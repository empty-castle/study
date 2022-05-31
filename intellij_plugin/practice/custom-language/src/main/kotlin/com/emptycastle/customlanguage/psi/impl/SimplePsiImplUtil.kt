package com.emptycastle.customlanguage.psi.impl

import com.emptycastle.customlanguage.SimpleIcons
import com.emptycastle.customlanguage.psi.SimpleElementFactory
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.emptycastle.customlanguage.psi.SimpleTypes
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import javax.swing.Icon

class SimplePsiImplUtil {

    companion object {
        @JvmStatic
        fun getKey(element: SimpleProperty): String? {
            val keyNode: ASTNode? = element.node.findChildByType(SimpleTypes.KEY)
            return keyNode?.text?.replace("\\\\ ", " ")
        }

        @JvmStatic
        fun getValue(element: SimpleProperty): String? {
            return element.node.findChildByType(SimpleTypes.VALUE)?.text
        }

        @JvmStatic
        fun getName(element: SimpleProperty): String? {
            return getKey(element)
        }

        @JvmStatic
        fun setName(element: SimpleProperty, newName: String): PsiElement {
            val keyNode: ASTNode? = element.node.findChildByType(SimpleTypes.KEY)
            if (keyNode != null) {
                val property: SimpleProperty = SimpleElementFactory.createProperty(element.project, newName)
                val newKeyNode: ASTNode = property.firstChild.node
                element.node.replaceChild(keyNode, newKeyNode)
            }
            return element
        }

        @JvmStatic
        fun getNameIdentifier(element: SimpleProperty): PsiElement? {
            return element.node.findChildByType(SimpleTypes.KEY)?.psi
        }

        @JvmStatic
        fun getPresentation(element: SimpleProperty): ItemPresentation {
            return object : ItemPresentation {
                override fun getPresentableText(): String? {
                    return element.key
                }

                override fun getLocationString(): String? {
                    val containingFile: PsiFile? = element.containingFile
                    return containingFile?.containingFile?.name
                }

                override fun getIcon(unused: Boolean): Icon? {
                    return SimpleIcons.FILE
                }
            }
        }
    }
}