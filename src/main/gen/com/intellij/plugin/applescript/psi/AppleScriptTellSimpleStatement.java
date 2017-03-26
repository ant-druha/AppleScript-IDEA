// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.plugin.applescript.psi.sdef.ApplicationDictionaryDeclarator;

public interface AppleScriptTellSimpleStatement extends ApplicationDictionaryDeclarator {

  @Nullable
  AppleScriptConsideringStatement getConsideringStatement();

  @Nullable
  AppleScriptContinueStatement getContinueStatement();

  @Nullable
  AppleScriptExitStatement getExitStatement();

  @Nullable
  AppleScriptExpression getExpression();

  @Nullable
  AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall();

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

  @Nullable
  String getApplicationName();

}
