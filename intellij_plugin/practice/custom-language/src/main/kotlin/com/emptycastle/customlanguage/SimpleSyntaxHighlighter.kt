package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class SimpleSyntaxHighlighter: SyntaxHighlighterBase() {

    companion object {
        val SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val KEY = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val VALUE = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = createTextAttributesKey("SIMPLE_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer(): Lexer {
        return SimpleLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (tokenType?.equals(SimpleTypes.SEPARATOR) == true) {
            return SEPARATOR_KEYS
        }
        if (tokenType?.equals(SimpleTypes.KEY) == true) {
            return KEY_KEYS
        }
        if (tokenType?.equals(SimpleTypes.VALUE) == true) {
            return VALUE_KEYS
        }
        if (tokenType?.equals(SimpleTypes.COMMENT) == true) {
            return COMMENT_KEYS
        }
        if (tokenType?.equals(TokenType.BAD_CHARACTER) == true) {
            return BAD_CHAR_KEYS
        }
        return EMPTY_KEYS;
    }
}