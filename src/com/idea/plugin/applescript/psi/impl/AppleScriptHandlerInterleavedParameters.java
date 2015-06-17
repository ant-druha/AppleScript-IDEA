package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.idea.plugin.applescript.psi.AppleScriptHandlerSelectorPart;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.pom.PomNamedTarget;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 16.05.2015.
 */
public class AppleScriptHandlerInterleavedParameters extends BaseAppleScriptComponent implements
        AppleScriptHandler, NavigatablePsiElement, PsiNameIdentifierOwner, PomNamedTarget {
  public AppleScriptHandlerInterleavedParameters(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String newElementName) throws IncorrectOperationException {
    //todo implement this
    return super.setName(newElementName);
  }

  @Override
  public boolean isHandler() {
    return true;
  }

  @Override
  public PsiReference getReference() {
    return null;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    findChildByClass(AppleScriptIdentifier.class); //use this instead?
    final AppleScriptHandlerSelectorPart selector = findChildByType(AppleScriptTypes
            .HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART);
    return selector != null ? selector.getSelectorNameIdentifier() : null;
  }

  @Nullable
  @Override
  public Icon getIcon(int flags) {
    return PlatformIcons.FUNCTION_ICON;
  }

  @Override
  public ItemPresentation getPresentation() {
    return new AppleScriptElementPresentation(this);
  }

  @Override
  public String getName() {
    return getSelector();
  }

  @Override
  public int getTextOffset() {
    final List<AppleScriptHandlerSelectorPart> selectors = findChildrenByType(AppleScriptTypes
            .HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART);
    if (selectors.isEmpty()) {
      return super.getTextOffset();
    }
    return selectors.get(0).getTextRange().getStartOffset();
  }

  @NotNull
  @Override
  public String getSelector() {
    StringBuilder buf = new StringBuilder();
    final List<AppleScriptHandlerSelectorPart> selectors = findChildrenByType(AppleScriptTypes
            .HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART);
    for (AppleScriptHandlerSelectorPart selector : selectors) {
      buf.append(selector.getSelectorPart());
    }
    return buf.toString();
  }

  @NotNull
  @Override
  public List<PsiElement> getSelectors() {
    List<PsiElement> selectors = new ArrayList<PsiElement>();
    for (AppleScriptHandlerSelectorPart part : getParameters()) {
      if (part.getSelectorNameIdentifier() != null)
        selectors.add(part.getSelectorNameIdentifier());
    }
    return selectors;
  }

  @NotNull
  public List<AppleScriptHandlerSelectorPart> getParameters() {
    return findChildrenByType(AppleScriptTypes
            .HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART);
  }
}
