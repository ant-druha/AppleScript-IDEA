// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import com.intellij.plugin.applescript.psi.sdef.impl.AbstractAppleScriptCommandHandlerCall;
import com.intellij.plugin.applescript.psi.*;

public class AppleScriptDictionaryCommandHandlerCallExpressionImpl extends AbstractAppleScriptCommandHandlerCall implements AppleScriptDictionaryCommandHandlerCallExpression {

  public AppleScriptDictionaryCommandHandlerCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitDictionaryCommandHandlerCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

}
