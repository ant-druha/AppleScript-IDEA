// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerLabeledParametersCall extends AppleScriptPsiElement {

  @Nullable
  AppleScriptDirectParameterVal getDirectParameterVal();

  @NotNull
  List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList();

  @NotNull
  List<AppleScriptParameterVal> getParameterValList();

  @Nullable
  AppleScriptPropertyReference getPropertyReference();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

  @NotNull
  List<AppleScriptUserParameterVal> getUserParameterValList();

}
