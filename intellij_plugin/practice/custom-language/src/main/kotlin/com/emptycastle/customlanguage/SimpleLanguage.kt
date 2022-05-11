package com.emptycastle.customlanguage

import com.intellij.lang.Language

class SimpleLanguage private constructor(): Language("Simple") {

    companion object {
        @JvmField
        val INSTANCE: SimpleLanguage = SimpleLanguage()
    }
}