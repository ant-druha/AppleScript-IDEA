package com.intellij.plugin.applescript.psi.impl;

import com.intellij.navigation.ColoredItemPresentation;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.plugin.applescript.AppleScriptNames;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Andrey 04.05.2015
 */
public class AppleScriptElementPresentation implements ColoredItemPresentation {

  @NotNull private final AppleScriptPsiElement myElement;
  @Nullable private TextAttributesKey myTextAttributes;

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
    return myTextAttributes;
  }

  public void setTextAttributesKey(@NotNull TextAttributesKey textAttributes) {
    myTextAttributes = textAttributes;
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
