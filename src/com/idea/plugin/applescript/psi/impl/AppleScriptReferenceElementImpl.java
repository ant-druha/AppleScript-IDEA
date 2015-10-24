package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.lang.AppleScriptComponentType;
import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.lang.resolve.AppleScriptComponentScopeResolver;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolveUtil;
import com.idea.plugin.applescript.lang.resolve.AppleScriptResolver;
import com.idea.plugin.applescript.lang.sdef.AppleScriptClass;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.idea.plugin.applescript.lang.util.ScopeUtil;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.AppleScriptPsiElementFactory;
import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.idea.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.UnfairTextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 13.04.2015.
 */
public class AppleScriptReferenceElementImpl extends AppleScriptExpressionImpl implements
        AppleScriptReferenceElement, PsiPolyVariantReference {


  public AppleScriptReferenceElementImpl(ASTNode node) {
    super(node);
    //todo create private field - myElement and do not extent wrapper??
  }

  @NotNull
  @Override
  public ResolveResult[] multiResolve(boolean incompleteCode) {
    ResolveResult[] results = multiResolveInner(incompleteCode);
    return results;//.length > 1 ? new ResolveResult[]{results[0]} : results;
  }

  protected ResolveResult[] multiResolveInner(boolean incompleteCode) {
    final List<? extends PsiElement> elements =
            ResolveCache.getInstance(getProject()).resolveWithCaching(this, AppleScriptResolver.INSTANCE,
                    true, incompleteCode);
    return AppleScriptResolveUtil.toCandidateInfoArray(elements);
  }

  @Override
  public PsiReference getReference() {
    return this;
  }

  @Override
  public PsiElement getElement() {
    return this;
  }

  @Override
  public TextRange getRangeInElement() {
    final TextRange textRange = getTextRange();

    AppleScriptReferenceElement[] appleScriptReferences = PsiTreeUtil.getChildrenOfType(this,
            AppleScriptReferenceElement.class);
    if (appleScriptReferences != null && appleScriptReferences.length > 0) {
      TextRange lastReferenceRange = appleScriptReferences[appleScriptReferences.length - 1].getTextRange();
      return new UnfairTextRange(
              lastReferenceRange.getStartOffset() - textRange.getStartOffset(),
              lastReferenceRange.getEndOffset() - textRange.getEndOffset()
      );
    }
    return new UnfairTextRange(0, textRange.getEndOffset() - textRange.getStartOffset());
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    final ResolveResult[] resolveResults = multiResolve(true);

    return resolveResults.length == 0 || resolveResults.length > 0 &&
            !resolveResults[0].isValidResult() ? null : resolveResults[0].getElement();
  }

  @NotNull
  @Override
  public String getCanonicalText() {
    return getText();
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    PsiElement element = this;
    final AppleScriptIdentifier identifier = PsiTreeUtil.getChildOfType(element, AppleScriptIdentifier.class);
    final AppleScriptIdentifier identifierNew = AppleScriptPsiElementFactory.createIdentifierFromText(getProject(),
            newElementName);
    if (identifierNew != null && identifier != null) {
      element.getNode().replaceChild(identifier.getNode(), identifierNew.getNode());
    }
    return this;
  }

  @Override
  public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
    return this;
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    PsiElement target = resolve();
    if (target instanceof AppleScriptTargetVariable) {//could be defined more than once
      final String theirName = ((AppleScriptTargetVariable) target).getName();
      String ourName = getCanonicalText();
      if (ourName.equals(theirName)) {
        final PsiElement ourScopeOwner = ScopeUtil.getMaxLocalScopeForTargetOrReference(getElement());
        final PsiElement theirScopeOwner = ScopeUtil.getMaxLocalScopeForTargetOrReference(element);
        if (resolvesToSameLocal(element, theirName, ourScopeOwner, theirScopeOwner)) {
          return true;
        }
      }
    }
    return target == element;
  }

  private boolean resolvesToSameLocal(PsiElement element, String name, PsiElement ourScopeOwner, PsiElement
          theirScopeOwner) {
    return ourScopeOwner == theirScopeOwner;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    List<? extends PsiElement> elements =
            ResolveCache.getInstance(getProject()).resolveWithCaching(this, AppleScriptComponentScopeResolver
                    .INSTANCE, true, true);
    //here we should add elements from parsed dictionaries (commands, classes etc.. which are the most relevant)

    List<String> applicationNames = AppleScriptPsiImplUtil
            .getApplicationNameForElementInsideTellStatement(this);
    AppleScriptProjectDictionaryRegistry projectDictionaryRegistry = getProject()
            .getComponent(AppleScriptProjectDictionaryRegistry.class);
    List<AppleScriptCommand> stdCommandsWithName = new ArrayList<AppleScriptCommand>();
    List<AppleScriptClass> stdClassesWithName = new ArrayList<AppleScriptClass>();
    List<DictionaryComponent> dictionaryComponents = new ArrayList<DictionaryComponent>();
    if (projectDictionaryRegistry != null) {
      for (ApplicationDictionary stdDictionary : projectDictionaryRegistry.getStandardDictionaries()) {
        Map<String, AppleScriptCommand> stdCommandsMap = stdDictionary.getDictionaryCommandMap();
        Map<String, AppleScriptClass> stdClassMap = stdDictionary.getDictionaryClassMap();
        stdCommandsWithName.addAll(stdCommandsMap.values());
        stdClassesWithName.addAll(stdClassMap.values());
      }
      if (!applicationNames.isEmpty()) {
        for (String appName : applicationNames) {
          ApplicationDictionary dictionary = projectDictionaryRegistry.getDictionary(appName);
          if (dictionary == null) {
            dictionary = projectDictionaryRegistry.createDictionary(appName);
          }
          if (dictionary != null) {
            Map<String, AppleScriptCommand> dictionaryCommandsMap = dictionary.getDictionaryCommandMap();
            stdCommandsWithName.addAll(dictionaryCommandsMap.values());
            for (AppleScriptCommand stdCmd : stdCommandsWithName) {//filtering the same std commands
              if (!dictionaryCommandsMap.containsKey(stdCmd.getName())) {
                dictionaryComponents.add(stdCmd);
              }
            }
            dictionaryComponents.addAll(dictionaryCommandsMap.values());
            dictionaryComponents.addAll(dictionary.getDictionaryClassMap().values());
            dictionaryComponents.addAll(dictionary.getDictionaryPropertyMap().values());
          }
        }
      } else {
        dictionaryComponents.addAll(stdCommandsWithName);
        dictionaryComponents.addAll(stdClassesWithName);
      }
    }
    List<LookupElement> lookupElements = new ArrayList<LookupElement>();
    for (DictionaryComponent dictionaryTerm : dictionaryComponents) {
      LookupElementBuilder builder = LookupElementBuilder.create(dictionaryTerm)
              .withTypeText(dictionaryTerm.getType(), dictionaryTerm.getIcon(0), true);
      lookupElements.add(builder);
    }
    if (elements != null) {
      for (PsiElement el : elements) {
        LookupElementBuilder builder;
        if (el instanceof PsiNamedElement) {
          builder = LookupElementBuilder.create((PsiNamedElement) el);
        } else {
          builder = LookupElementBuilder.create(el);
        }
        AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(this);
        String typeText = componentType != null ? componentType.toString() : null;
        builder = builder.withTypeText(typeText, el.getIcon(0), true);
        lookupElements.add(builder);
      }
    }

    return !lookupElements.isEmpty() ? lookupElements.toArray() : LookupElement.EMPTY_ARRAY;
  }

  @Override
  public boolean isSoft() {
    return false;
  }
}
