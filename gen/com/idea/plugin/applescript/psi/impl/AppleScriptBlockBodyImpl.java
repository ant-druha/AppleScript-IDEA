// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptBlockBodyImpl extends AppleScriptPsiElementImpl implements AppleScriptBlockBody {

  public AppleScriptBlockBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitBlockBody(this);
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
  public List<AppleScriptCreationStatement> getCreationStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptCreationStatement.class);
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
  public List<AppleScriptHandlerInterleavedParametersDefinition> getHandlerInterleavedParametersDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerInterleavedParametersDefinition.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerLabeledParametersDefinition> getHandlerLabeledParametersDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerLabeledParametersDefinition.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerPositionalParametersDefinition> getHandlerPositionalParametersDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerPositionalParametersDefinition.class);
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
  public List<AppleScriptPropertyDeclarationStatement> getPropertyDeclarationStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptPropertyDeclarationStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatForeverStatement> getRepeatForeverStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatForeverStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatNumTimesStatement> getRepeatNumTimesStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatNumTimesStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatUntilStatement> getRepeatUntilStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatUntilStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatWhileStatement> getRepeatWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatWhileStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatWithListStatement> getRepeatWithListStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatWithListStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptRepeatWithRangeStatement> getRepeatWithRangeStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptRepeatWithRangeStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptReturnStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptScriptObjectDefinitionStatement> getScriptObjectDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptScriptObjectDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTellCompoundStatement> getTellCompoundStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTellCompoundStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTellSimpleStatement> getTellSimpleStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTellSimpleStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTryStatement> getTryStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTryStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUseAppleScriptStatement> getUseAppleScriptStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUseAppleScriptStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUseApplicationOrScriptStatement> getUseApplicationOrScriptStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUseApplicationOrScriptStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUseFrameworkStatement> getUseFrameworkStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUseFrameworkStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUseScriptingAdditionsStatement> getUseScriptingAdditionsStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUseScriptingAdditionsStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptUsingTermsFromStatement> getUsingTermsFromStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptUsingTermsFromStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptVariableDeclarationStatement> getVariableDeclarationStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptVariableDeclarationStatement.class);
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
