// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerInterleavedParametersCall extends AppleScriptPsiElement {

  @Nullable
  AppleScriptExpression getExpression();

  @NotNull
  List<AppleScriptHandlerNamePartReference> getHandlerNamePartReferenceList();

  @Nullable
  AppleScriptHandlerParameterLabel getHandlerParameterLabel();

  @Nullable
  AppleScriptNumericConstant getNumericConstant();

  @Nullable
  AppleScriptReferenceIdentifier getReferenceIdentifier();

  @NotNull
  List<AppleScriptUserParameterVal> getUserParameterValList();

}
