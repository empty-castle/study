package com.emptycastle.customlanguage.psi

import com.emptycastle.customlanguage.SimpleLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class SimpleElementType(debugName: @NonNls String) : IElementType(debugName, SimpleLanguage.INSTANCE) {
}