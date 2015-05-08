package com.idea.plugin.applescript;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 15.02.2015.
 */
public class AppleScriptLanguage extends Language {
    public static final AppleScriptLanguage INSTANCE = new AppleScriptLanguage();

    private AppleScriptLanguage() {
        super("AppleScript");

    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType() {
        return AppleScriptFileType.INSTANCE;
    }

    @Override
    public boolean isCaseSensitive() {
        return false;
    }
}