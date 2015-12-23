package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.AppleScriptIcons;
import com.idea.plugin.applescript.psi.AppleScriptBlockBody;
import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptScriptObject;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Andrey 16.05.2015
 */
public abstract class AbstractAppleScriptScriptObject extends AbstractAppleScriptComponent implements
        AppleScriptScriptObject {

  public AbstractAppleScriptScriptObject(@NotNull ASTNode node) {
    super(node);
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
  public AppleScriptScriptObject getParentScriptObject() {
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

  @NotNull
  @Override
  public AppleScriptBlockBody getScriptBody() {
    return findNotNullChildByClass(AppleScriptBlockBody.class);
  }
}
