// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerLabeledParametersDefinition extends AppleScriptComponent {

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  AppleScriptIdentifier getIdentifier();

  @NotNull
  AppleScriptLabeledParameterDeclarationList getLabeledParameterDeclarationList();

  @NotNull
  List<AppleScriptObjectTargetPropertyDeclaration> getObjectTargetPropertyDeclarationList();

  @Nullable
  AppleScriptReferenceExpression getReferenceExpression();

  @Nullable
  AppleScriptVarDeclarationList getVarDeclarationList();

  List<AppleScriptComponent> getParameterComponentList();

}
