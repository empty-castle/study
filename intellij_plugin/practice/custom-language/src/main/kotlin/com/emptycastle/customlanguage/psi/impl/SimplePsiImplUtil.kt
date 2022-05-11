package com.emptycastle.customlanguage.psi.impl

import com.intellij.lang.ASTNode
import org.intellij.sdk.language.psi.SimpleProperty
import org.intellij.sdk.language.psi.SimpleTypes

class SimplePsiImplUtil {

    companion object {
        fun getKey(element: SimpleProperty) {
            val keyNode: ASTNode? = element.node.findChildByType(SimpleTypes.KEY)
            if (keyNode != null) {
                return keyNode.text.replace("\\\\ ", " ")
            }
        }
    }
}