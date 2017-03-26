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

public class AppleScriptUsingTermsFromStatementImpl extends AppleScriptPsiElementImpl implements AppleScriptUsingTermsFromStatement {

  public AppleScriptUsingTermsFromStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitUsingTermsFromStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationReference getApplicationReference() {
    return findChildByClass(AppleScriptApplicationReference.class);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptTopBlockBody getTopBlockBody() {
    return findChildByClass(AppleScriptTopBlockBody.class);
  }

  @Nullable
  public String getApplicationName() {
    return AppleScriptPsiImplUtil.getApplicationName(this);
  }

  public boolean withImportingStdLibrary() {
    return AppleScriptPsiImplUtil.withImportingStdLibrary(this);
  }

}
