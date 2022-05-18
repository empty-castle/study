package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.parser.SimpleParser
import com.emptycastle.customlanguage.psi.SimpleFile
import com.emptycastle.customlanguage.psi.SimpleTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class SimpleParserDefinition: ParserDefinition {

    companion object {
        val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS: TokenSet = TokenSet.create(SimpleTypes.COMMENT)
        val FILE: IFileElementType = IFileElementType(SimpleLanguage.INSTANCE)
    }

    override fun createLexer(project: Project?): Lexer {
        return SimpleLexerAdapter();
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES;
    }

    override fun createParser(project: Project?): PsiParser {
        return SimpleParser();
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE;
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS;
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY;
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return SimpleTypes.Factory.createElement(node);
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SimpleFile(viewProvider);
    }
}