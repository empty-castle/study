package com.emptycastle.customlanguage

import com.intellij.lang.Language

class SimpleLanguage private constructor(): Language("Simple") {

    companion object {
        val INSTANCE: SimpleLanguage = SimpleLanguage()
    }
}