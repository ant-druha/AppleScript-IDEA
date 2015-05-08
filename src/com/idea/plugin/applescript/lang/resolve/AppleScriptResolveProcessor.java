package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponentName;
import com.idea.plugin.applescript.psi.AppleScriptNamedElement;
import com.intellij.openapi.util.Key;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 15.04.2015.
 */
public class AppleScriptResolveProcessor extends AppleScriptPsiScopeProcessor {
    private final List<AppleScriptComponentName> myResult;
    private final String myName;

    public AppleScriptResolveProcessor(List<AppleScriptComponentName> result, String name) {
        myResult = result;
        myName = name;
    }

    @Nullable
    @Override
    public <T> T getHint(Key<T> hintKey) {
        return null;
    }

    @Override
    public void handleEvent(Event event, @Nullable Object associated) {

    }


    @Override
    protected boolean doExecute(AppleScriptComponentName element) {

        if (this.myName.equals(element.getName())) {
            myResult.add(element);
            return false;
        }
        return true;

    }

}
