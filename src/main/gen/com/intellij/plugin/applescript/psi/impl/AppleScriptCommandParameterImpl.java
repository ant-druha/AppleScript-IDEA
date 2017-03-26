// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import com.intellij.plugin.applescript.psi.sdef.impl.AbstractAppleScriptCommandParameter;
import com.intellij.plugin.applescript.psi.*;

public class AppleScriptCommandParameterImpl extends AbstractAppleScriptCommandParameter implements AppleScriptCommandParameter {

  public AppleScriptCommandParameterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitCommandParameter(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AppleScriptCommandParameterSelector getCommandParameterSelector() {
    return findNotNullChildByClass(AppleScriptCommandParameterSelector.class);
  }

  @Override
  @NotNull
  public AppleScriptExpression getExpression() {
    return findNotNullChildByClass(AppleScriptExpression.class);
  }

}
