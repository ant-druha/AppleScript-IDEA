package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.sdef.AppleScriptClass;
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
 * Created by Andrey on 20.08.2015.
 */
public class AbstractDictionaryClassSpecifier extends DictionaryCompositeNameImpl
        implements DictionaryCompositeElement, DictionaryCompositeName {


  public AbstractDictionaryClassSpecifier(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public PsiReference getReference() {
    return new DictionaryClassSpecifierReference();
  }

  @NotNull
  @Override
  public DictionaryCompositeName getCompositeNameElement() {
    return this;
  }

  private class DictionaryClassSpecifierReference extends AbstractDictionaryReferenceElement implements
          MultiRangeReference,
          PsiPolyVariantReference {

    @NotNull
    @Override
    protected ResolveResult[] resolveInner(boolean incompleteCode, @NotNull PsiFile containingFile) {
      String classNameNormalized = getCompositeName();
      AppleScriptProjectDictionaryRegistry dictionaryRegistry = getProject()
              .getComponent(AppleScriptProjectDictionaryRegistry.class);
      AppleScriptClass allClassesWithName = null;
      List<String> toldAppNames = AppleScriptPsiImplUtil
              .getApplicationNameForElementInsideTellStatement(getMyElement());
      if (dictionaryRegistry != null) {
        for (String appName : toldAppNames) {
          if (appName != null) {
            ApplicationDictionary dictionary = dictionaryRegistry.getDictionary(appName);
            if (dictionary == null) {
              dictionary = dictionaryRegistry.createDictionary(appName);
            }
            if (dictionary != null) {
              allClassesWithName = dictionary.findClassByName(classNameNormalized);
              if (allClassesWithName == null)
                allClassesWithName = dictionary.findClassByPluralName(classNameNormalized);
              if (allClassesWithName != null) break;
            }
          }
        }
        //if not found in dictionary checking in standard additions
        if (allClassesWithName == null) {
          List<ApplicationDictionary> stdDictionaries = dictionaryRegistry.getStandardDictionaries();
          for (ApplicationDictionary stdDict : stdDictionaries) {
            allClassesWithName = stdDict.findClassByName(classNameNormalized);
            if (allClassesWithName == null)
              allClassesWithName = stdDict.findClassByPluralName(classNameNormalized);
            if (allClassesWithName != null) break;
          }
        }
      }
      final List<PsiElement> results = new ArrayList<PsiElement>();
      results.add(allClassesWithName);
      return AppleScriptResolveUtil.toCandidateInfoArray(results);
    }

    @NotNull
    @Override
    protected DictionaryCompositeElement getMyElement() {
      return AbstractDictionaryClassSpecifier.this;
    }
  }
}
