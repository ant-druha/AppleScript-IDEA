package com.idea.plugin.applescript.psi.sdef;

import com.intellij.psi.MultiRangeReference;
import com.intellij.psi.PsiPolyVariantReference;

public interface DictionaryReference extends MultiRangeReference, PsiPolyVariantReference {
  @Override
  DictionaryCompositeElement getElement();
}
