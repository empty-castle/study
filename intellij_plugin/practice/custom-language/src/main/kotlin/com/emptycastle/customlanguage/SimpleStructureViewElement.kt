package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.emptycastle.customlanguage.psi.impl.SimplePropertyImpl
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.uast.EMPTY_ARRAY

class SimpleStructureViewElement(val element: NavigatablePsiElement): StructureViewTreeElement, SortableTreeElement {
    override fun getPresentation(): ItemPresentation {
        val presentation: ItemPresentation? = element.presentation
        return presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        if (element is SimpleFile) {
            val properties: List<SimpleProperty> = PsiTreeUtil.getChildrenOfTypeAsList(element, SimpleProperty::class.java)
            val treeElements: MutableList<TreeElement> = mutableListOf()
            for (property: SimpleProperty in properties) {
                treeElements.add(SimpleStructureViewElement(property as SimplePropertyImpl))
            }
            return treeElements.map { it as TreeElement }.toTypedArray()
        }
        return emptyArray<TreeElement>()
    }

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return element.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return element.canNavigateToSource()
    }

    override fun getValue(): Any {
        return element
    }

    override fun getAlphaSortKey(): String {
        val name: String? = element.name
        return name ?: ""
    }
}