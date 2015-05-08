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

public class AppleScriptTellSimpleStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptTellSimpleStatement {

  public AppleScriptTellSimpleStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitTellSimpleStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationObjectReference getApplicationObjectReference() {
    return findChildByClass(AppleScriptApplicationObjectReference.class);
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
  public AppleScriptCreationStatement getCreationStatement() {
    return findChildByClass(AppleScriptCreationStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptExitStatement getExitStatement() {
    return findChildByClass(AppleScriptExitStatement.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptFilterReference getFilterReference() {
    return findChildByClass(AppleScriptFilterReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerInterleavedParametersCall> getHandlerInterleavedParametersCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerInterleavedParametersDefinition getHandlerInterleavedParametersDefinition() {
    return findChildByClass(AppleScriptHandlerInterleavedParametersDefinition.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerLabeledParametersDefinition getHandlerLabeledParametersDefinition() {
    return findChildByClass(AppleScriptHandlerLabeledParametersDefinition.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @Nullable
  public AppleScriptHandlerPositionalParametersDefinition getHandlerPositionalParametersDefinition() {
    return findChildByClass(AppleScriptHandlerPositionalParametersDefinition.class);
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
  @NotNull
  public List<AppleScriptNumericConstant> getNumericConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptNumericConstant.class);
  }

  @Override
  @Nullable
  public AppleScriptObjectRef getObjectRef() {
    return findChildByClass(AppleScriptObjectRef.class);
  }

  @Override
  @Nullable
  public AppleScriptPropertyDeclarationStatement getPropertyDeclarationStatement() {
    return findChildByClass(AppleScriptPropertyDeclarationStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatForeverStatement getRepeatForeverStatement() {
    return findChildByClass(AppleScriptRepeatForeverStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatNumTimesStatement getRepeatNumTimesStatement() {
    return findChildByClass(AppleScriptRepeatNumTimesStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatUntilStatement getRepeatUntilStatement() {
    return findChildByClass(AppleScriptRepeatUntilStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatWhileStatement getRepeatWhileStatement() {
    return findChildByClass(AppleScriptRepeatWhileStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatWithListStatement getRepeatWithListStatement() {
    return findChildByClass(AppleScriptRepeatWithListStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptRepeatWithRangeStatement getRepeatWithRangeStatement() {
    return findChildByClass(AppleScriptRepeatWithRangeStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptReturnStatement getReturnStatement() {
    return findChildByClass(AppleScriptReturnStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptScriptObjectDefinitionStatement getScriptObjectDefinitionStatement() {
    return findChildByClass(AppleScriptScriptObjectDefinitionStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptTellCompoundStatement getTellCompoundStatement() {
    return findChildByClass(AppleScriptTellCompoundStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptTellSimpleStatement getTellSimpleStatement() {
    return findChildByClass(AppleScriptTellSimpleStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptTryStatement getTryStatement() {
    return findChildByClass(AppleScriptTryStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptUseAppleScriptStatement getUseAppleScriptStatement() {
    return findChildByClass(AppleScriptUseAppleScriptStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptUseApplicationOrScriptStatement getUseApplicationOrScriptStatement() {
    return findChildByClass(AppleScriptUseApplicationOrScriptStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptUseFrameworkStatement getUseFrameworkStatement() {
    return findChildByClass(AppleScriptUseFrameworkStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptUseScriptingAdditionsStatement getUseScriptingAdditionsStatement() {
    return findChildByClass(AppleScriptUseScriptingAdditionsStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptUsingTermsFromStatement getUsingTermsFromStatement() {
    return findChildByClass(AppleScriptUsingTermsFromStatement.class);
  }

  @Override
  @Nullable
  public AppleScriptVariableDeclarationStatement getVariableDeclarationStatement() {
    return findChildByClass(AppleScriptVariableDeclarationStatement.class);
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

}
