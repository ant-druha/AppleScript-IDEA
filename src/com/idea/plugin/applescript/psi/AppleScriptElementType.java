package com.idea.plugin.applescript.psi;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey.Dernov on 2/5/2015.
 */
public class AppleScriptElementType extends IElementType {
    public AppleScriptElementType(@NotNull @NonNls String debugName) {
        super(debugName, AppleScriptLanguage.INSTANCE);
    }
}