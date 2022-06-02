package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class SimpleStructureViewModel(editor: Editor?, psiFile: PsiFile)
    : StructureViewModelBase(psiFile, editor, SimpleStructureViewElement(psiFile)), StructureViewModel, ElementInfoProvider {

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is SimpleProperty
    }

    override fun getSorters(): Array<Sorter> {
        return arrayOf<Sorter>(Sorter.ALPHA_SORTER)
    }

    override fun getSuitableClasses(): Array<Class<Any>> {
        return arrayOf<Class<Any>>(SimpleProperty::class.java.javaClass)
    }
}