package com.emptycastle.customlanguage

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.ide.impl.ProjectUtil
import com.intellij.ide.projectView.impl.ProjectRootsUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.impl.ProjectRootUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
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
        WriteCommandAction.writeCommandAction(project)
    }
}