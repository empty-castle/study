package com.emptycastle.customlanguage

import com.intellij.lexer.FlexAdapter


class SimpleLexerAdapter: FlexAdapter(SimpleLexer(null))