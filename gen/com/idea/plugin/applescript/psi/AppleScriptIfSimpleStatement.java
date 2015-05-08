// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptIfSimpleStatement extends AppleScriptPsiElement {

  @Nullable
  AppleScriptConsideringStatement getConsideringStatement();

  @Nullable
  AppleScriptContinueStatement getContinueStatement();

  @Nullable
  AppleScriptCreationStatement getCreationStatement();

  @Nullable
  AppleScriptExitStatement getExitStatement();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptHandlerInterleavedParametersDefinition getHandlerInterleavedParametersDefinition();

  @Nullable
  AppleScriptHandlerLabeledParametersDefinition getHandlerLabeledParametersDefinition();

  @Nullable
  AppleScriptHandlerPositionalParametersDefinition getHandlerPositionalParametersDefinition();

  @Nullable
  AppleScriptIfCompoundStatement getIfCompoundStatement();

  @Nullable
  AppleScriptIfSimpleStatement getIfSimpleStatement();

  @Nullable
  AppleScriptIgnoringStatement getIgnoringStatement();

  @Nullable
  AppleScriptPropertyDeclarationStatement getPropertyDeclarationStatement();

  @Nullable
  AppleScriptRepeatForeverStatement getRepeatForeverStatement();

  @Nullable
  AppleScriptRepeatNumTimesStatement getRepeatNumTimesStatement();

  @Nullable
  AppleScriptRepeatUntilStatement getRepeatUntilStatement();

  @Nullable
  AppleScriptRepeatWhileStatement getRepeatWhileStatement();

  @Nullable
  AppleScriptRepeatWithListStatement getRepeatWithListStatement();

  @Nullable
  AppleScriptRepeatWithRangeStatement getRepeatWithRangeStatement();

  @Nullable
  AppleScriptReturnStatement getReturnStatement();

  @Nullable
  AppleScriptScriptObjectDefinitionStatement getScriptObjectDefinitionStatement();

  @Nullable
  AppleScriptTellCompoundStatement getTellCompoundStatement();

  @Nullable
  AppleScriptTellSimpleStatement getTellSimpleStatement();

  @Nullable
  AppleScriptTryStatement getTryStatement();

  @Nullable
  AppleScriptUseAppleScriptStatement getUseAppleScriptStatement();

  @Nullable
  AppleScriptUseApplicationOrScriptStatement getUseApplicationOrScriptStatement();

  @Nullable
  AppleScriptUseFrameworkStatement getUseFrameworkStatement();

  @Nullable
  AppleScriptUseScriptingAdditionsStatement getUseScriptingAdditionsStatement();

  @Nullable
  AppleScriptUsingTermsFromStatement getUsingTermsFromStatement();

  @Nullable
  AppleScriptVariableDeclarationStatement getVariableDeclarationStatement();

  @Nullable
  AppleScriptWithTimeoutStatement getWithTimeoutStatement();

  @Nullable
  AppleScriptWithTransactionStatement getWithTransactionStatement();

}
