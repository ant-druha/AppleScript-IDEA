package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.impl.BaseAppleScriptComponent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 04.07.2015.
 */
public abstract class DictionaryAbstractItem extends BaseAppleScriptComponent {

//  @NotNull
//  private final String code;

  public DictionaryAbstractItem(@NotNull ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public AppleScriptIdentifier getIdentifier() {
    //todo should return code in dictionary
    return null;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    //todo should return getCode method
    return super.getNameIdentifier();
  }

  @Override
  public String getName() {
    //todo should return definition's name
    return super.getName();
  }
}
