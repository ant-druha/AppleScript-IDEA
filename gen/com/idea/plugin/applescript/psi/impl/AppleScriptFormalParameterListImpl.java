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

public class AppleScriptFormalParameterListImpl extends AppleScriptPsiElementImpl implements AppleScriptFormalParameterList {

  public AppleScriptFormalParameterListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitFormalParameterList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetComponentName> getTargetComponentNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetComponentName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetListLiteral> getTargetListLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetListLiteral.class);
  }

  @Override
  @NotNull
  public List<AppleScriptTargetRecordLiteral> getTargetRecordLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptTargetRecordLiteral.class);
  }

  @NotNull
  public List<AppleScriptComponentName> getComponentNameList() {
    return AppleScriptPsiImplUtil.getComponentNameList(this);
  }

}
