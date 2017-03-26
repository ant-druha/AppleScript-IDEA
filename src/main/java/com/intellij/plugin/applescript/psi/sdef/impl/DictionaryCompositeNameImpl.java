package com.intellij.plugin.applescript.psi.sdef.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey 22.08.2015
 */
public class DictionaryCompositeNameImpl extends AppleScriptPsiElementImpl implements DictionaryCompositeName {
  public DictionaryCompositeNameImpl(ASTNode node) {
    super(node);
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

  @Override
  public String getName() {
    return getCompositeName();
  }
}
