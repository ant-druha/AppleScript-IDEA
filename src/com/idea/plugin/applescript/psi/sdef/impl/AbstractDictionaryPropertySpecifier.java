package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.AppleScriptPropertyDefinition;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiImplUtil;
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
  public PsiReference getReference() {
    return new DictionaryPropertySpecifierReference();
  }

  private class DictionaryPropertySpecifierReference extends AbstractDictionaryReferenceElement implements
          MultiRangeReference, PsiPolyVariantReference {

    @NotNull
    @Override
    protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
      AppleScriptProjectDictionaryRegistry dictionaryRegistry = getProject()
              .getComponent(AppleScriptProjectDictionaryRegistry.class);

      String propName = getCompositeName();
      List<String> appNames = AppleScriptPsiImplUtil.getApplicationNameForElementInsideTellStatement(getMyElement());
      AppleScriptPropertyDefinition allPropsWithName = null;
      if (dictionaryRegistry != null) {
        for (String appName : appNames) {
          if (appName != null) {
            ApplicationDictionary dictionary = dictionaryRegistry.getDictionary(appName);
            if (dictionary == null) {
              dictionary = dictionaryRegistry.createDictionary(appName);
            }
            if (dictionary != null) {
              allPropsWithName = dictionary.findProperty(propName);
            }
          }
          if (allPropsWithName != null) break;
        }
        if (allPropsWithName == null) {
          for (ApplicationDictionary stdDict : dictionaryRegistry.getStandardDictionaries()) {
            allPropsWithName = stdDict.findProperty(propName);
            if (allPropsWithName != null) break;
          }
        }
      }
      final List<PsiElement> results = new ArrayList<PsiElement>();
      results.add(allPropsWithName);
      return AppleScriptResolveUtil.toCandidateInfoArray(results);
    }

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryPropertySpecifier.this;
    }
  }
}
