package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult

class SimpleReference(element: PsiElement, textRange: TextRange): PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {

    private val key: String = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project: Project = myElement.project
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, key)
        val results: MutableList<ResolveResult> = mutableListOf()
        for (property: SimpleProperty in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray()
    }

    override fun resolve(): PsiElement? {
        val resolveResult: Array<ResolveResult> = multiResolve(false)
        return if (resolveResult.size == 1) resolveResult[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project: Project = myElement.project
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project)
        val variants: MutableList<LookupElement> = mutableListOf()
        for (property: SimpleProperty in properties) {
            val key = property.key
            if (key != null && key.isNotEmpty()) {
                variants.add(LookupElementBuilder
                    .create(property)
                    .withIcon(SimpleIcons.FILE)
                    .withTypeText(property.containingFile.name)
                )
            }
        }
        return variants.toTypedArray()
    }
}