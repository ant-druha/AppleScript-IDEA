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

public class AppleScriptHandlerInterleavedParametersDefinitionImpl extends AppleScriptPsiElementImpl implements AppleScriptHandlerInterleavedParametersDefinition {

  public AppleScriptHandlerInterleavedParametersDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitHandlerInterleavedParametersDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptBlockBody getBlockBody() {
    return findChildByClass(AppleScriptBlockBody.class);
  }

  @Override
  @NotNull
  public List<AppleScriptComponentName> getComponentNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptComponentName.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerNamePartDefinition> getHandlerNamePartDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerNamePartDefinition.class);
  }

}
