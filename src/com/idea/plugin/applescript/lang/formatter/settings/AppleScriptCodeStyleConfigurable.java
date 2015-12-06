package com.idea.plugin.applescript.lang.formatter.settings;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 11.04.2015
 */
public class AppleScriptCodeStyleConfigurable extends CodeStyleAbstractConfigurable {
    public AppleScriptCodeStyleConfigurable(@NotNull CodeStyleSettings settings, CodeStyleSettings cloneSettings) {
        super(settings, cloneSettings, "Apple Script");
    }

    @Override
    protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
        return new AppleScriptCodeStyleMainPanel(getCurrentSettings(), settings);
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }
}
