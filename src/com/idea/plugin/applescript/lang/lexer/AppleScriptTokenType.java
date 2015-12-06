package com.idea.plugin.applescript.lang.lexer;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey.Dernov 2/5/2015
 */
public class AppleScriptTokenType extends IElementType {
    public AppleScriptTokenType(@NotNull @NonNls String debugName) {
        super(debugName, AppleScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "AppleScriptTokenType." + super.toString();
    }

    public String getMyDebugName(){
        return toString().substring(22);
    }
}