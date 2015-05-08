// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptRepeatWithListStatement extends AppleScriptPsiElement {

  @Nullable
  AppleScriptApplicationObjectReference getApplicationObjectReference();

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  AppleScriptComponentName getComponentName();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptFilterReference getFilterReference();

  @Nullable
  AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall();

  @NotNull
  List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList();

  @NotNull
  List<AppleScriptNumericConstant> getNumericConstantList();

  @Nullable
  AppleScriptObjectRef getObjectRef();

}
