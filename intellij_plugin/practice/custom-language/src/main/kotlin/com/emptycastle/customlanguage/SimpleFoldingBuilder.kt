package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.toArray

class SimpleFoldingBuilder: FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val group: FoldingGroup = FoldingGroup.newGroup(SimpleAnnotator.SIMPLE_PREFIX_STR)
        val descriptor: MutableList<FoldingDescriptor> = mutableListOf()
        val literalExpressions: Collection<PsiLiteralExpression>  = PsiTreeUtil.findChildrenOfType(root, PsiLiteralExpression::class.java)
        for (literalExpression: PsiLiteralExpression in literalExpressions) {
            val value: String? = if (literalExpression.value is String) literalExpression.value as String else null
            if (value != null && value.startsWith(SimpleAnnotator.SIMPLE_PREFIX_STR + SimpleAnnotator.SIMPLE_SEPARATOR_STR)) {
                val project: Project = literalExpression.project
                val key: String = value.substring(
                    SimpleAnnotator.SIMPLE_PREFIX_STR.length + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length
                )
                val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, key)
                if (properties.size == 1) {
                    descriptor.add(
                        FoldingDescriptor(
                            literalExpression.node,
                            TextRange(
                                literalExpression.textRange.startOffset + 1,
                                literalExpression.textRange.endOffset - 1
                            ),
                            group
                        )
                    )
                }
            }
        }
        return descriptor.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        val retTxt: String = "..."
        if (node.psi is PsiLiteralExpression) {
            val nodeElement: PsiLiteralExpression = node.psi as PsiLiteralExpression
            val key: String = (nodeElement.value as String).substring(
                SimpleAnnotator.SIMPLE_PREFIX_STR.length + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length
            )
            val properties: List<SimpleProperty> = SimpleUtil.findProperties(nodeElement.project, key)
            val place: String? = properties[0].value
            return place?.replace("\n", "\\n")?.replace("\"", "\\\\\"") ?: retTxt
        }
        return retTxt
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return true
    }
}