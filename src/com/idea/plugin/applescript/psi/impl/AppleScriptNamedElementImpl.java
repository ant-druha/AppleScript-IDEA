package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.AppleScriptNamedElement;
import com.idea.plugin.applescript.psi.AppleScriptPsiElementFactory;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 08.04.2015.
 */
public abstract class AppleScriptNamedElementImpl extends AppleScriptPsiElementImpl implements AppleScriptNamedElement {
  public AppleScriptNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String newElementName) throws IncorrectOperationException {
    final AppleScriptIdentifier identifier = getAppleScriptIdentifier();
    final AppleScriptIdentifier identifierNew = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
            newElementName);
    if (identifierNew != null && identifier != null) {
      getNode().replaceChild(identifier.getNode(), identifierNew.getNode());
    }
    return this;
  }

  @Override
  public PsiReference getReference() {
    return super.getReference();//null
  }


  @Override
  public ItemPresentation getPresentation() {
    final PsiElement parent = getParent();
    if (parent instanceof NavigationItem) {
      return ((NavigationItem) parent).getPresentation();
    }
    return null;
  }

  @Override
  public String getName() {
    return getAppleScriptIdentifier().getText();
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return this;
//  return PsiTreeUtil.getChildOfType(this, AppleScriptIdentifier.class);
  }

  @NotNull
  @Override
  public AppleScriptIdentifier getAppleScriptIdentifier() {
    return PsiTreeUtil.getChildOfType(this, AppleScriptIdentifier.class);
  }
}
