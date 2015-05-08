package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.AppleScriptNames;
import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.navigation.ColoredItemPresentation;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Andrey on 04.05.2015.
 */
public class AppleScriptElementPresentation implements ColoredItemPresentation {

    @NotNull private final AppleScriptPsiElement myElement;

    public AppleScriptElementPresentation(@NotNull AppleScriptPsiElement element) {
        myElement = element;
    }

    @NotNull
    public AppleScriptPsiElement getElement() {
        return myElement;
    }

    @Nullable

    @Override
    public TextAttributesKey getTextAttributesKey() {
        return null;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        String name = myElement.getName();
        return name != null ? name : AppleScriptNames.UNNAMED_ELEMENT;
    }

    @Nullable
    @Override
    public String getLocationString() {
        return "(" + myElement.getContainingFile() + ")";
    }

    @Nullable
    @Override
    public Icon getIcon(boolean unused) {
        return myElement.getIcon(0);
    }
}
