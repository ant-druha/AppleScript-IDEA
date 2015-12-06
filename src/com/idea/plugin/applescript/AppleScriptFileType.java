package com.idea.plugin.applescript;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Andrey 15.02.2015
 */
public class AppleScriptFileType extends LanguageFileType {
    public static final AppleScriptFileType INSTANCE = new AppleScriptFileType();

    private AppleScriptFileType() {
        super(AppleScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "AppleScript file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "AppleScript language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "scpt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AppleScriptIcons.FILE;
    }
}