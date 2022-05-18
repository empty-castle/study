package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.google.common.collect.Lists
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

class SimpleUtil {

    companion object {

        fun findProperties(project: Project, key: String): List<SimpleProperty> {
            val result: MutableList<SimpleProperty> = mutableListOf()
            val virtualFiles: Collection<VirtualFile> =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val simpleFile: SimpleFile = PsiManager.getInstance(project).findFile(virtualFile) as SimpleFile
                PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                    ?.forEach { property: SimpleProperty ->
                        if (key == property.key) {
                            result.add(property)
                        }
                    }
            }

            return result
        }

        fun findProperties(project: Project): List<SimpleProperty> {
            val result: MutableList<SimpleProperty> = mutableListOf()
            val virtualFiles: Collection<VirtualFile> =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project))
            for (virtualFile in virtualFiles) {
                val simpleFile: SimpleFile = PsiManager.getInstance(project).findFile(virtualFile) as SimpleFile
                val properties: Array<out SimpleProperty>? = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleProperty::class.java)
                if (properties != null) {
                    Collections.addAll(result, *properties)
                }
            }
            return result
        }

        fun findDocumentationComment(property: SimpleProperty): String {
            val result: LinkedList<String> = LinkedList<String>()
            var element: PsiElement = property.prevSibling
            while (element is PsiComment || element is PsiWhiteSpace) {
                if (element is PsiComment) {
                    result.add(element.text.replaceFirst("[!# ]+", ""))
                }
                element = element.prevSibling
            }
            return StringUtil.join(Lists.reverse(result), "\n ")
        }
    }
}