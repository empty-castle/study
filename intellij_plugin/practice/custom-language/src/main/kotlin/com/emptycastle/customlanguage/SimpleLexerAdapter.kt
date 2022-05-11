package com.emptycastle.customlanguage

import com.intellij.lexer.FlexAdapter
import org.intellij.sdk.language.SimpleLexer


class SimpleLexerAdapter: FlexAdapter(SimpleLexer(null))