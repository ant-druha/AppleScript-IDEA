package com.intellij.plugin.applescript.psi.sdef.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.plugin.applescript.psi.sdef.DictionaryReference;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 20.08.2015
 */
public class AbstractDictionaryClassSpecifier extends DictionaryCompositeNameImpl implements DictionaryCompositeElement, DictionaryCompositeName {


  public AbstractDictionaryClassSpecifier(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public DictionaryReference getReference() {
    return new DictionaryClassSpecifierReference();
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return this;
  }

  private class DictionaryClassSpecifierReference extends AbstractDictionaryReferenceElement
          implements DictionaryReference {

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryClassSpecifier.this;
    }
  }
}
