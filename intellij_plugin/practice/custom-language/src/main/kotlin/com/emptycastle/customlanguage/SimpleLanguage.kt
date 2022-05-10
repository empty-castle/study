package com.emptycastle.customlanguage

import com.intellij.lang.Language

class SimpleLanguage: Language() {

    const val INSTANCE = SimpleLanguage()

    private fun SimpleLanguage() {
        super("Simple")
    }
}