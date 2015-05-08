package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponentName;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 15.04.2015.
 */
public abstract class AppleScriptPsiScopeProcessor implements PsiScopeProcessor {
    @Override
    public boolean execute(final @NotNull PsiElement element, final @NotNull ResolveState state) {
        if (!(element instanceof AppleScriptComponentName)) return true;

        final String name = ((AppleScriptComponentName)element).getName();

        return doExecute((AppleScriptComponentName)element);
    }

    protected abstract boolean doExecute(AppleScriptComponentName element);
}
