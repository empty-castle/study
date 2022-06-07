package com.emptycastle.customlanguage

import com.emptycastle.customlanguage.psi.SimpleTypes
import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings

class SimpleFormattingModelBuilder: FormattingModelBuilder {

    companion object {
        fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, SimpleLanguage.INSTANCE)
                .around(SimpleTypes.SEPARATOR)
                .spaceIf(settings.getCommonSettings(SimpleLanguage.INSTANCE.id).SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(SimpleTypes.PROPERTY)
                .none()
        }
    }

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val codeStyleSettings: CodeStyleSettings = formattingContext.codeStyleSettings
        return FormattingModelProvider
            .createFormattingModelForPsiFile(
                formattingContext.containingFile,
                SimpleBlock(
                    formattingContext.node,
                    Wrap.createWrap(WrapType.NONE, false),
                    Alignment.createAlignment(),
                    createSpaceBuilder(codeStyleSettings)
                ),
                codeStyleSettings
            )
    }
}