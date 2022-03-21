package com.intellij.sql.formatter.settings;

import com.intellij.lang.Language;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 * @author Rustam Vishnyakov, Leonid Bushuev, ignatov
 */
public abstract class SqlLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider implements SqlLanguageCodeStyleProvider {

  @NotNull
  protected final Language myDialect;
  
  @NotNull
  protected final Class<? extends SqlCodeStyleSettings> mySettingsClass;


  protected SqlLanguageCodeStyleSettingsProvider(@NotNull Language dialect,
                                                 @NotNull Class<? extends SqlCodeStyleSettings> settingsClass) {
    myDialect = dialect;
    mySettingsClass = settingsClass;
  }

  @NotNull
  @Override
  public Language getLanguage() {
    return myDialect;
  }

  @NlsSafe
  @Nullable
  @Override
  public String getLanguageName() {
    return getLanguage().getDisplayName();
  }

  @Nullable
  @Override
  public final String getConfigurableDisplayName() {
    return getLanguageName();
  }

  @Override
  @NotNull
  public Class<? extends SqlCodeStyleSettings> getSettingsClass() {
    return mySettingsClass;
  }

  @Override
  public List<Language> getApplicableLanguages() {
    return SqlCodeStyles.getSettingsDialects().filter(d -> d != myDialect).filter(Language.class).toList();
  }

  @Override
  public boolean supportsExternalFormats() {
    return false;
  }
}
