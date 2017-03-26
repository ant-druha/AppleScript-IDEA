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

public class AppleScriptHandlerPositionalParametersCallExpressionImpl extends AppleScriptExpressionImpl implements AppleScriptHandlerPositionalParametersCallExpression {

  public AppleScriptHandlerPositionalParametersCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitHandlerPositionalParametersCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptConsideringStatement> getConsideringStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptConsideringStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptContinueStatement> getContinueStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptContinueStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExitStatement> getExitStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExitStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIfCompoundStatement> getIfCompoundStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIfCompoundStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIfSimpleStatement> getIfSimpleStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIfSimpleStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptIgnoringStatement> getIgnoringStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIgnoringStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptReturnStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptScriptPropertyDeclaration> getScriptPropertyDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptScriptPropertyDeclaration.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTryStatement> getTryStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTryStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptVarDeclarationList> getVarDeclarationListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptVarDeclarationList.class);
  }

  @Override
  @NotNull
  public List<AppleScriptWithTimeoutStatement> getWithTimeoutStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptWithTimeoutStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptWithTransactionStatement> getWithTransactionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptWithTransactionStatement.class);
  }

}
