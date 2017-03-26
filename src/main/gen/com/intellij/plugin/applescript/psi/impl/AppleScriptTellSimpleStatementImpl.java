// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import com.intellij.plugin.applescript.psi.*;

public class AppleScriptTellSimpleStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptTellSimpleStatement {

  public AppleScriptTellSimpleStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitTellSimpleStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptConsideringStatement getConsideringStatement() {
    return findChildByClass(AppleScriptConsideringStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptContinueStatement getContinueStatement() {
    return findChildByClass(AppleScriptContinueStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptExitStatement getExitStatement() {
    return findChildByClass(AppleScriptExitStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerInterleavedParametersCall getHandlerInterleavedParametersCall() {
    return findChildByClass(AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptIfCompoundStatement getIfCompoundStatement() {
    return findChildByClass(AppleScriptIfCompoundStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptIfSimpleStatement getIfSimpleStatement() {
    return findChildByClass(AppleScriptIfSimpleStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptIgnoringStatement getIgnoringStatement() {
    return findChildByClass(AppleScriptIgnoringStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptReturnStatement getReturnStatement() {
    return findChildByClass(AppleScriptReturnStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptScriptPropertyDeclaration getScriptPropertyDeclaration() {
    return findChildByClass(AppleScriptScriptPropertyDeclaration.class);
  }

  @Override
  @Nullable
  public AppleScriptTryStatement getTryStatement() {
    return findChildByClass(AppleScriptTryStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptVarDeclarationList getVarDeclarationList() {
    return findChildByClass(AppleScriptVarDeclarationList.class);
  }

  @Override
  @Nullable
  public AppleScriptWithTimeoutStatement getWithTimeoutStatement() {
    return findChildByClass(AppleScriptWithTimeoutStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptWithTransactionStatement getWithTransactionStatement() {
    return findChildByClass(AppleScriptWithTransactionStatement.class);
  }

  @Nullable
  public String getApplicationName() {
    return AppleScriptPsiImplUtil.getApplicationName(this);
  }

}
