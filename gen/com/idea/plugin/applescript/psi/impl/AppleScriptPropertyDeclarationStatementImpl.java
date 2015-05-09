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

public class AppleScriptPropertyDeclarationStatementImpl extends AbstractAppleScriptTargetComponent implements AppleScriptPropertyDeclarationStatement {

  public AppleScriptPropertyDeclarationStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitPropertyDeclarationStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptBuiltInClassName getBuiltInClassName() {
    return findChildByClass(AppleScriptBuiltInClassName.class);
  }

  @Override
  @Nullable
  public AppleScriptComponentName getComponentName() {
    return findChildByClass(AppleScriptComponentName.class);
  }

  @Override
  @NotNull
  public AppleScriptExpression getExpression() {
    return findNotNullChildByClass(AppleScriptExpression.class);
  }

}
