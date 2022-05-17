package com.emptycastle.customlanguage.psi.impl

import com.intellij.lang.ASTNode
import org.intellij.sdk.language.psi.SimpleProperty
import org.intellij.sdk.language.psi.SimpleTypes

class SimplePsiImplUtil {

    companion object {
        fun getKey(element: SimpleProperty): String? {
            val keyNode: ASTNode? = element.node.findChildByType(SimpleTypes.KEY)
            return keyNode?.text?.replace("\\\\ ", " ")
        }
        
        fun getValue(element: SimpleProperty): String? {
            return element.node.findChildByType(SimpleTypes.VALUE)?.text
        }
    }
}