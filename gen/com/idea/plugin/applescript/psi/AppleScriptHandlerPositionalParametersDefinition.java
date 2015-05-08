// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerPositionalParametersDefinition extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  List<AppleScriptComponentName> getComponentNameList();

  @Nullable
  AppleScriptFormalParameterList getFormalParameterList();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
