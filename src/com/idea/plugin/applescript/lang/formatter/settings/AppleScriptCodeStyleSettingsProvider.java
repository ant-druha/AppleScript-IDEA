package com.idea.plugin.applescript.lang.formatter.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 11.04.2015.
 */
public class AppleScriptCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "Apple Script";
    }

    @NotNull
    @Override
    public Configurable createSettingsPage(CodeStyleSettings settings, CodeStyleSettings originalSettings) {
        return new AppleScriptCodeStyleConfigurable(settings,originalSettings);
    }
}
