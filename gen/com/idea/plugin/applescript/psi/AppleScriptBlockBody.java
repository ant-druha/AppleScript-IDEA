// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptBlockBody extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptConsideringStatement> getConsideringStatementList();

  @NotNull
  List<AppleScriptContinueStatement> getContinueStatementList();

  @NotNull
  List<AppleScriptCreationStatement> getCreationStatementList();

  @NotNull
  List<AppleScriptExitStatement> getExitStatementList();

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @NotNull
  List<AppleScriptHandlerInterleavedParametersDefinition> getHandlerInterleavedParametersDefinitionList();

  @NotNull
  List<AppleScriptHandlerLabeledParametersDefinition> getHandlerLabeledParametersDefinitionList();

  @NotNull
  List<AppleScriptHandlerPositionalParametersDefinition> getHandlerPositionalParametersDefinitionList();

  @NotNull
  List<AppleScriptIfCompoundStatement> getIfCompoundStatementList();

  @NotNull
  List<AppleScriptIfSimpleStatement> getIfSimpleStatementList();

  @NotNull
  List<AppleScriptIgnoringStatement> getIgnoringStatementList();

  @NotNull
  List<AppleScriptPropertyDeclarationStatement> getPropertyDeclarationStatementList();

  @NotNull
  List<AppleScriptRepeatForeverStatement> getRepeatForeverStatementList();

  @NotNull
  List<AppleScriptRepeatNumTimesStatement> getRepeatNumTimesStatementList();

  @NotNull
  List<AppleScriptRepeatUntilStatement> getRepeatUntilStatementList();

  @NotNull
  List<AppleScriptRepeatWhileStatement> getRepeatWhileStatementList();

  @NotNull
  List<AppleScriptRepeatWithListStatement> getRepeatWithListStatementList();

  @NotNull
  List<AppleScriptRepeatWithRangeStatement> getRepeatWithRangeStatementList();

  @NotNull
  List<AppleScriptReturnStatement> getReturnStatementList();

  @NotNull
  List<AppleScriptScriptObjectDefinitionStatement> getScriptObjectDefinitionStatementList();

  @NotNull
  List<AppleScriptTellCompoundStatement> getTellCompoundStatementList();

  @NotNull
  List<AppleScriptTellSimpleStatement> getTellSimpleStatementList();

  @NotNull
  List<AppleScriptTryStatement> getTryStatementList();

  @NotNull
  List<AppleScriptUseAppleScriptStatement> getUseAppleScriptStatementList();

  @NotNull
  List<AppleScriptUseApplicationOrScriptStatement> getUseApplicationOrScriptStatementList();

  @NotNull
  List<AppleScriptUseFrameworkStatement> getUseFrameworkStatementList();

  @NotNull
  List<AppleScriptUseScriptingAdditionsStatement> getUseScriptingAdditionsStatementList();

  @NotNull
  List<AppleScriptUsingTermsFromStatement> getUsingTermsFromStatementList();

  @NotNull
  List<AppleScriptVariableDeclarationStatement> getVariableDeclarationStatementList();

  @NotNull
  List<AppleScriptWithTimeoutStatement> getWithTimeoutStatementList();

  @NotNull
  List<AppleScriptWithTransactionStatement> getWithTransactionStatementList();

}
