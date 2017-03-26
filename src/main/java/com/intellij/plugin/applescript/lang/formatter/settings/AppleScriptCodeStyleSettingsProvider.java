package com.intellij.plugin.applescript.lang.formatter.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 11.04.2015
 */
public class AppleScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
  @Nullable
  @Override
  public String getConfigurableDisplayName() {
    return "AppleScript";
  }

  @NotNull
  @Override
  public Configurable createSettingsPage(CodeStyleSettings settings, CodeStyleSettings originalSettings) {
    return new AppleScriptCodeStyleConfigurable(settings, originalSettings);
  }
}
