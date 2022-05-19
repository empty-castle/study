package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiLiteralValue

class SimpleAnnotator: Annotator {

    companion object {
        const val SIMPLE_PREFIX_STR: String = "simple"
        const val SIMPLE_SEPARATOR_STR: String = ":"
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PsiLiteralExpression) {
            return
        }

        val psiLiteralValue = element as PsiLiteralValue
        val value: String? =
            if (psiLiteralValue.value is String) psiLiteralValue.value as String
            else null
        if (value == null || !value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
            return
        }

        val prefixRange: TextRange = TextRange.from(element.textRange.startOffset, SIMPLE_PREFIX_STR.length + 1)
        val separatorRange: TextRange = TextRange.from(prefixRange.startOffset, SIMPLE_PREFIX_STR.length + 1)
        val keyRange: TextRange = TextRange(separatorRange.endOffset, element.textRange.endOffset - 1)

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(prefixRange).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create()
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(separatorRange).textAttributes(SimpleSyntaxHighlighter.SEPARATOR).create()

        val key: String = value.substring(SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length)
        val properties: List<SimpleProperty> = SimpleUtil.findProperties(element.project, key)
        if (properties.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved property")
                .range(keyRange)
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
//                .withFix(new SimpleCreatePropertyQuickFix (key))
                .create()
        } else {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(keyRange).textAttributes(SimpleSyntaxHighlighter.VALUE).create()
        }
    }
}