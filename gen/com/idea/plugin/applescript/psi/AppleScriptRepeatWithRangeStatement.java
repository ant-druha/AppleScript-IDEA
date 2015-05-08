// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptRepeatWithRangeStatement extends AppleScriptPsiElement {

  @Nullable
  AppleScriptBlockBody getBlockBody();

  @NotNull
  AppleScriptComponentName getComponentName();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
