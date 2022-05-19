package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.impl.source.tree.java.PsiJavaTokenImpl

class SimpleLineMarkerProvider: RelatedItemLineMarkerProvider() {

    override fun collectNavigationMarkers(
        element: PsiElement,
        result: MutableCollection<in RelatedItemLineMarkerInfo<*>>
    ) {
        if (element !is PsiJavaTokenImpl || element.parent !is PsiLiteralExpression) {
            return
        }

        val literalExpression: PsiLiteralExpression = element.parent as PsiLiteralExpression
        val value: String? = if (literalExpression.value is String) literalExpression.value as String else null
        if (value == null || !value.startsWith(SimpleAnnotator.SIMPLE_PREFIX_STR + SimpleAnnotator.SIMPLE_SEPARATOR_STR)) {
            return
        }

        val project: Project = element.project
        val possibleProperties: String =
            value.substring(SimpleAnnotator.SIMPLE_PREFIX_STR.length + SimpleAnnotator.SIMPLE_SEPARATOR_STR.length)

        val properties: List<SimpleProperty> = SimpleUtil.findProperties(project, possibleProperties)
        if (properties.isNotEmpty()) {
            val builder: NavigationGutterIconBuilder<PsiElement> = NavigationGutterIconBuilder.create(SimpleIcons.FILE)
                .setTargets(properties)
                .setTooltipText("Navigate to Simple language property")
            result.add(builder.createLineMarkerInfo(element))
        }
    }
}