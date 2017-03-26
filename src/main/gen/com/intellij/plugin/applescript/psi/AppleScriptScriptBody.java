// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptScriptBody extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptApplicationHandlerDefinition> getApplicationHandlerDefinitionList();

  @NotNull
  List<AppleScriptConsideringStatement> getConsideringStatementList();

  @NotNull
  List<AppleScriptContinueStatement> getContinueStatementList();

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
  List<AppleScriptReturnStatement> getReturnStatementList();

  @NotNull
  List<AppleScriptScriptPropertyDeclaration> getScriptPropertyDeclarationList();

  @NotNull
  List<AppleScriptTryStatement> getTryStatementList();

  @NotNull
  List<AppleScriptVarDeclarationList> getVarDeclarationListList();

  @NotNull
  List<AppleScriptWithTimeoutStatement> getWithTimeoutStatementList();

  @NotNull
  List<AppleScriptWithTransactionStatement> getWithTransactionStatementList();

}
