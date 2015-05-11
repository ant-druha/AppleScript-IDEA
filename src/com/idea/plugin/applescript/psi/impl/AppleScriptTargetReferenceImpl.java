package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.psi.AppleScriptComponentName;
import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptTargetReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 22.04.2015.
 */
public class AppleScriptTargetReferenceImpl extends AppleScriptReferenceElementImpl implements AppleScriptTargetReference {

    AppleScriptComponent myElement;

    public AppleScriptTargetReferenceImpl(AppleScriptComponent targetComponent) {
        super(targetComponent.getNode());
        myElement = targetComponent;

    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        AppleScriptFile psiFile = (AppleScriptFile) getContainingFile();//todo need a check, ugly
        Set<AppleScriptComponentName> allComponents = new HashSet<AppleScriptComponentName>();
        psiFile.processTopDeclarationsImpl(allComponents);
        final ResolveResult[] results = super.multiResolve(incompleteCode);

        if (!allComponents.isEmpty()) {
            int offset = Integer.MAX_VALUE;
            PsiElement firstDeclaration = null;
            for (AppleScriptComponentName component : allComponents) {
                if (component.getName() != null && component.getName().equals(getCanonicalText())
                        && component.getTextOffset() < offset) {
                    firstDeclaration = component;
                    offset = component.getTextOffset();
                }
            }
            return firstDeclaration != null ? new ResolveResult[]{new PsiElementResolveResult(firstDeclaration)} : results;
        }
        return new ResolveResult[]{new PsiElementResolveResult(myElement)};
    }


}
