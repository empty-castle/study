package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.ide.impl.ProjectUtil
import com.intellij.lang.ASTNode
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.IncorrectOperationException

class SimpleCreatePropertyQuickFix(val key: String): BaseIntentionAction() {

    override fun getText(): String {
        return "Create property '$key'"
    }

    override fun getFamilyName(): String {
        return "Create property"
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    @kotlin.jvm.Throws(IncorrectOperationException::class)
    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        ApplicationManager.getApplication().invokeLater {
            val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(
                SimpleFileType.INSTANCE,
                GlobalSearchScope.allScope(project)
            )
            if (virtualFiles.size == 1) {
                createProperty(project, virtualFiles.iterator().next())
            } else {
                val descriptor: FileChooserDescriptor =
                    FileChooserDescriptorFactory.createSingleFileDescriptor(SimpleFileType.INSTANCE)
                descriptor.setRoots(LocalFileSystem.getInstance().findFileByPath(ProjectUtil.getBaseDir()))
                val file1: VirtualFile? = FileChooser.chooseFile(descriptor, project, null)
                if (file1 != null) {
                    createProperty(project, file1)
                }
            }
        }
    }

    private fun createProperty(project: Project, file: VirtualFile) {
        WriteCommandAction.writeCommandAction(project).run<Exception> {
            val simpleFile: SimpleFile = PsiManager.getInstance(project).findFile(file) as SimpleFile
            val lastChildNode: ASTNode? = simpleFile.node.lastChildNode
            if (lastChildNode != null) {
                simpleFile.node.addChild(SimpleElementFactory.createCRLF(project).node)
            }
            val property: SimpleProperty = SimpleElementFactory.createProperty(project, key.replace(" ", "\\\\ "), "")
            simpleFile.node.addChild(property.node)
            (property.lastChild.navigationElement as Navigatable).navigate(true)
            FileEditorManager.getInstance(project).selectedTextEditor?.caretModel?.moveCaretRelatively(2, 0, false, false, false)
        }
    }
}