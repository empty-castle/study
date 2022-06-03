package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleProperty
import com.intellij.icons.AllIcons
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import javax.swing.Icon

// 동작 안 한다. step 15
class SimpleStructureAwareNavbar: StructureAwareNavBarModelExtension() {

    override val language: Language
        get() = SimpleLanguage.INSTANCE

    override fun getPresentableText(`object`: Any?): String? {
        if (`object` is SimpleFile) {
            return (`object` as SimpleFile).name
        }
        if (`object` is SimpleProperty) {
            return (`object` as SimpleProperty).name
        }
        return null
    }

    override fun getIcon(`object`: Any?): Icon? {
        return if (`object` is SimpleProperty) AllIcons.Nodes.Property else null
    }
}