package com.emptycastle.customlanguage

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class SimpleCodeStyleSettingsProvider() : CodeStyleSettingsProvider() {

    override fun createCustomSettings(settings: CodeStyleSettings?): CustomCodeStyleSettings? {
        return if (settings != null) SimpleCodeStyleSettings(settings) else null
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object: CodeStyleAbstractConfigurable(
            settings,
            modelSettings,
            this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings?): CodeStyleAbstractPanel {
                return SimpleCodeStyleMainPanel(currentSettings, settings)
            }
        }
    }

    override fun getConfigurableDisplayName(): String {
        return "Simple"
    }

    private class SimpleCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings?):
        TabbedLanguageCodeStylePanel(SimpleLanguage.INSTANCE, currentSettings, settings)
}
