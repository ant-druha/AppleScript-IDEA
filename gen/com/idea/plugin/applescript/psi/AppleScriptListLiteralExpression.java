// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptListLiteralExpression extends AppleScriptExpression {

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @NotNull
  List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList();

  @NotNull
  List<AppleScriptNumericConstant> getNumericConstantList();

  @NotNull
  List<AppleScriptReferenceIdentifier> getReferenceIdentifierList();

}
