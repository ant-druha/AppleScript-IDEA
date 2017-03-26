package com.intellij.plugin.applescript.psi.sdef.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.plugin.applescript.psi.sdef.DictionaryReference;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 22.08.2015
 */
public class AbstractDictionaryPropertySpecifier extends DictionaryCompositeNameImpl
        implements DictionaryCompositeElement, DictionaryCompositeName {

  public AbstractDictionaryPropertySpecifier(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return this;
  }

  @NotNull
  @Override
  public DictionaryReference getReference() {
    return new DictionaryPropertySpecifierReference();
  }

  private class DictionaryPropertySpecifierReference extends AbstractDictionaryReferenceElement
          implements DictionaryReference {

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryPropertySpecifier.this;
    }
  }
}
