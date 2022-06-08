package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

class SimpleElementFactory {

    companion object {
        fun createProperty(project: Project, name: String): SimpleProperty {
            val file: SimpleFile = createFile(project, name)
            return file.firstChild as SimpleProperty
        }

        fun createFile(project: Project, text: String): SimpleFile {
            val name: String = "dummy.simple"
            return PsiFileFactory
                .getInstance(project)
                .createFileFromText(
                    name,
                    SimpleFileType.INSTANCE,
                    text
                ) as SimpleFile
        }

        fun createProperty(project: Project, name: String, value: String): SimpleProperty {
            val file: SimpleFile = createFile(project, "$name = $value")
            return file.firstChild as SimpleProperty
        }

        fun createCRLF(project: Project): PsiElement {
            val file: SimpleFile = createFile(project, "\n")
            return file.firstChild
        }
    }
}