package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistryMappings;
import com.idea.plugin.applescript.lang.parser.ParsableScriptSuiteRegistryHelper;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.DictionaryEnumerator;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeElement;
import com.idea.plugin.applescript.psi.sdef.DictionaryCompositeName;
import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 22.08.2015.
 */
public class AbstractDictionaryConstantSpecifier extends AppleScriptPsiElementImpl
        implements DictionaryCompositeElement, DictionaryCompositeName {


  public AbstractDictionaryConstantSpecifier(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public PsiReference getReference() {
    return new DictionaryConstantSpecifierReference();
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return this;
  }

  @Override
  public List<PsiElement> getIdentifiers() {
    final List<PsiElement> result = new ArrayList<PsiElement>();
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
          implements MultiRangeReference, PsiPolyVariantReference {

    @NotNull
    @Override
    protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
      ScriptSuiteRegistryMappings registryMappings = ScriptSuiteRegistryMappings.getInstance(containingFile
              .getProject());
      ScriptSuiteRegistry suiteRegistry = registryMappings.getMapping(containingFile.getVirtualFile());
      String enumeratorName = getCompositeName();
      final DictionaryEnumerator allEnumeratorsWithName = suiteRegistry != null ? suiteRegistry.
              findEnumerator(enumeratorName) :
              ParsableScriptSuiteRegistryHelper.getEnumerator(enumeratorName);
      final List<PsiElement> results = new ArrayList<PsiElement>();
      results.add(allEnumeratorsWithName);
      return AppleScriptResolveUtil.toCandidateInfoArray(results);
    }

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryConstantSpecifier.this;
    }
  }
}