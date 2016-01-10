package com.intellij.plugin.applescript.lang.formatter.settings;

import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;

/**
 * Andrey 11.04.2015
 */
public class AppleScriptCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
  protected AppleScriptCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
    super(AppleScriptLanguage.INSTANCE, currentSettings, settings);
  }
}
