package com.emptycastle.customlanguage

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SimpleFileType private constructor(): LanguageFileType(SimpleLanguage.INSTANCE) {

    companion object {
        val INSTANCE: SimpleFileType = SimpleFileType()
    }

    override fun getName(): String {
        return "Simple File"
    }

    override fun getDescription(): String {
        return "Simple language file"
    }

    override fun getDefaultExtension(): String {
        return "simple"
    }

    override fun getIcon(): Icon {
        return SimpleIcons.FILE;
    }
}