// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptErrorCommandExpression extends AppleScriptExpression {

  @Nullable
  AppleScriptApplicationObjectReference getApplicationObjectReference();

  @NotNull
  List<AppleScriptBuiltInClassName> getBuiltInClassNameList();

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

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
