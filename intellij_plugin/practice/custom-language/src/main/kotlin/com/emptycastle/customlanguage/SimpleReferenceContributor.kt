package com.emptycastle.customlanguage

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

import com.emptycastle.customlanguage.SimpleAnnotator.Companion.SIMPLE_PREFIX_STR
import com.emptycastle.customlanguage.SimpleAnnotator.Companion.SIMPLE_SEPARATOR_STR
import com.intellij.openapi.util.TextRange

class SimpleReferenceContributor: PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PsiLiteralExpression::class.java),
            object: PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    val literalExpression: PsiLiteralExpression = element as PsiLiteralExpression
                    val value: String? = if (literalExpression.value is String) literalExpression.value as String else null
                    if (value != null && value.startsWith(SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR)) {
                        val property: TextRange = TextRange(SIMPLE_PREFIX_STR.length + SIMPLE_SEPARATOR_STR.length + 1, value.length + 1)
                        return arrayOf<PsiReference>(SimpleReference(element, property))
                    }
                    return PsiReference.EMPTY_ARRAY
                }
            }
        )
    }
}