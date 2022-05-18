package com.emptycastle.customlanguage.psi.impl

import com.emptycastle.customlanguage.psi.SimpleProperty
import com.emptycastle.customlanguage.psi.SimpleTypes
import com.intellij.lang.ASTNode

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
    }
}