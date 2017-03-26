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

public class AppleScriptObjectNamedPropertyDeclarationImpl extends AbstractAppleScriptComponent implements AppleScriptObjectNamedPropertyDeclaration {

  public AppleScriptObjectNamedPropertyDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitObjectNamedPropertyDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptExpression getExpression() {
    return findChildByClass(AppleScriptExpression.class);
  }

  @Override
  @Nullable
  public AppleScriptIdentifier getIdentifier() {
    return findChildByClass(AppleScriptIdentifier.class);
  }

  @Override
  @Nullable
  public AppleScriptListFormalParameter getListFormalParameter() {
    return findChildByClass(AppleScriptListFormalParameter.class);
  }

  @Override
  @Nullable
  public AppleScriptPropertyReference getPropertyReference() {
    return findChildByClass(AppleScriptPropertyReference.class);
  }

  @Override
  @Nullable
  public AppleScriptRecordFormalParameter getRecordFormalParameter() {
    return findChildByClass(AppleScriptRecordFormalParameter.class);
  }

  @Override
  @Nullable
  public AppleScriptSimpleFormalParameter getSimpleFormalParameter() {
    return findChildByClass(AppleScriptSimpleFormalParameter.class);
  }

}
