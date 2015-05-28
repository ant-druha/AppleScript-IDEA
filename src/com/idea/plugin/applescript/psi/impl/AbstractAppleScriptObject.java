package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.AppleScriptIcons;
import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Created by Andrey on 16.05.2015.
 */
public abstract class AbstractAppleScriptObject extends AbstractAppleScriptComponent implements AppleScriptObject {

  public AbstractAppleScriptObject(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public abstract AppleScriptComponentName getComponentName();

  @Override
  public boolean isGlobal() {
    return true;
  }

  @Override
  public boolean isObjectProperty() {
    return false;
  }

  @Override
  public boolean isHandler() {
    return false;
  }

  @Override
  public boolean isScriptProperty() {
    return false;
  }

  @Override
  public boolean isVariable() {
    return super.isVariable();
  }

  @Override
  public ItemPresentation getPresentation() {
    return new AppleScriptElementPresentation(this) {
      @Nullable
      @Override
      public String getPresentableText() {
        //AppleScriptComponent myScript = (AppleScriptObject) getElement();
        return getName();
      }
    };
  }

  @Nullable
  @Override
  public Icon getIcon(int flags) {
    return AppleScriptIcons.FILE;
  }

  @Nullable
  @Override
  public AppleScriptObject getParentScriptObject() {
    return null;
  }

  @Nullable
  @Override
  public List<AppleScriptComponent> getProperties() {
    return null;
  }

  @Nullable
  @Override
  public List<AppleScriptComponent> getHandlers() {
    return null;
  }
}
