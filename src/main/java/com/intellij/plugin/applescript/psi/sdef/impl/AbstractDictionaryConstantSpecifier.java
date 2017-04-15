package com.intellij.plugin.applescript.psi.sdef.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.plugin.applescript.psi.sdef.DictionaryReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey 22.08.2015
 */
public class AbstractDictionaryConstantSpecifier extends AppleScriptPsiElementImpl implements DictionaryCompositeElement, DictionaryCompositeName {


  public AbstractDictionaryConstantSpecifier(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public DictionaryReference getReference() {
    return new DictionaryConstantSpecifierReference();
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return this;
  }

  @Override
  public List<PsiElement> getIdentifiers() {
    final List<PsiElement> result = new ArrayList<>();
    PsiElement psiChild = getFirstChild();
    if (psiChild == null) {
      result.add(this);
      return result;
    }
    while (psiChild != null) {
      if (psiChild.getNode().getElementType() != TokenType.WHITE_SPACE) {
        result.add(psiChild);
      }
      psiChild = psiChild.getNextSibling();
    }
    return result;
  }

  @Override
  public String getCompositeName() {
    StringBuilder sb = new StringBuilder();
    for (PsiElement id : getIdentifiers()) {
      sb.append(id.getText()).append(" ");
    }
    return sb.toString().trim();
  }


  private class DictionaryConstantSpecifierReference extends AbstractDictionaryReferenceElement
          implements DictionaryReference {

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryConstantSpecifier.this;
    }
  }
}