package com.intellij.plugin.applescript.lang.ide.findUsages;

import com.intellij.plugin.applescript.psi.AppleScriptFormalParameterList;
import com.intellij.plugin.applescript.psi.AppleScriptHandlerInterleavedParametersSelectorPart;
import com.intellij.plugin.applescript.psi.AppleScriptLabeledParameterDeclarationPart;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.usages.impl.rules.UsageType;
import com.intellij.usages.impl.rules.UsageTypeProvider;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 22.06.2015
 */
public class AppleScriptUsageTypeProvider implements UsageTypeProvider {

  @Nullable
  @Override
  public UsageType getUsageType(PsiElement element) {
    if (!(element instanceof AppleScriptPsiElement)) return null;

    //todo make better psi
    if (element instanceof AppleScriptLabeledParameterDeclarationPart
            || element.getContext() instanceof AppleScriptFormalParameterList
            || element.getContext() instanceof AppleScriptHandlerInterleavedParametersSelectorPart) {
      return UsageType.CLASS_METHOD_PARAMETER_DECLARATION;
    }

    return null;
  }

}
