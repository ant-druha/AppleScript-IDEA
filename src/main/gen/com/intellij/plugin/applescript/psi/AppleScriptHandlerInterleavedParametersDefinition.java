// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptHandlerInterleavedParametersDefinition extends AppleScriptHandler {

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  List<AppleScriptHandlerInterleavedParametersSelectorPart> getHandlerInterleavedParametersSelectorPartList();

  @NotNull
  List<AppleScriptReferenceExpression> getReferenceExpressionList();

}
