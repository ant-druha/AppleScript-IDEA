// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptParenthesizedExpression extends AppleScriptExpression {

  @Nullable
  AppleScriptConsideringStatement getConsideringStatement();

  @Nullable
  AppleScriptContinueStatement getContinueStatement();

  @Nullable
  AppleScriptExitStatement getExitStatement();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptIfCompoundStatement getIfCompoundStatement();

  @Nullable
  AppleScriptIfSimpleStatement getIfSimpleStatement();

  @Nullable
  AppleScriptIgnoringStatement getIgnoringStatement();

  @Nullable
  AppleScriptReturnStatement getReturnStatement();

  @Nullable
  AppleScriptScriptPropertyDeclaration getScriptPropertyDeclaration();

  @Nullable
  AppleScriptTryStatement getTryStatement();

  @Nullable
  AppleScriptVarDeclarationList getVarDeclarationList();

  @Nullable
  AppleScriptWithTimeoutStatement getWithTimeoutStatement();

  @Nullable
  AppleScriptWithTransactionStatement getWithTransactionStatement();

}
