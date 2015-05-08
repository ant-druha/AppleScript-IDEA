package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponentName;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Created by Andrey on 20.04.2015.
 */
public class AppleScriptComponentNameScopeProcessor extends AppleScriptPsiScopeProcessor {

    private final @NotNull Set<AppleScriptComponentName> myResult;

    public AppleScriptComponentNameScopeProcessor(@NotNull Set<AppleScriptComponentName> myResult) {
        this.myResult = myResult;
    }

    @Override
    protected boolean doExecute(AppleScriptComponentName element) {
        myResult.add(element);
        return true;
    }

    @Nullable
    @Override
    public <T> T getHint(Key<T> hintKey) {
        return null;
    }

    @Override
    public void handleEvent(Event event, @Nullable Object associated) {

    }
}
