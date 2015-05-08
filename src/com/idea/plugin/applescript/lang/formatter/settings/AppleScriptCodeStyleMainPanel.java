package com.idea.plugin.applescript.lang.formatter.settings;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;

/**
 * Created by Andrey on 11.04.2015.
 */
public class AppleScriptCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
    protected AppleScriptCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
        super(AppleScriptLanguage.INSTANCE, currentSettings, settings);
    }
}
