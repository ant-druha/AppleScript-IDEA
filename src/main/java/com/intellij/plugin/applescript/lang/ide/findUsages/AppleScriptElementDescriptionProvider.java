package com.intellij.plugin.applescript.lang.ide.findUsages;

import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.ElementDescriptionLocation;
import com.intellij.psi.ElementDescriptionProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.usageView.UsageViewLongNameLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 03.05.2015
 */
public class AppleScriptElementDescriptionProvider implements ElementDescriptionProvider {
  @Nullable
  @Override
  public String getElementDescription(@NotNull PsiElement element, @NotNull ElementDescriptionLocation location) {
    if (location instanceof UsageViewLongNameLocation) {
      if (element instanceof PsiNamedElement && element instanceof AppleScriptPsiElement) {
        return ((PsiNamedElement) element).getName();
      }
    }
    return null;
  }
}
