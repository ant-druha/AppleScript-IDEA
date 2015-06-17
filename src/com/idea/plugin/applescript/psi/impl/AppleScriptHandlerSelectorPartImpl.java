package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by andrey on 28/05/15.
 */
public class AppleScriptHandlerSelectorPartImpl extends BaseAppleScriptComponent implements
        AppleScriptHandlerSelectorPart {
  public AppleScriptHandlerSelectorPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public PsiReference getReference() {
    return null;
  }

  @Override
  public String getName() {
    return getParameterName();
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    ASTNode paramNode = findParameterNode();
    return paramNode != null ? paramNode.getPsi() : null;
  }

  @Nullable
  @Override
  public String getParameterName() {
    ASTNode node = findParameterNode();
    return node != null ? node.getText() : null;
  }

  @Nullable
  @Override
  public ASTNode findParameterNode() {
    PsiElement parameter = getParameter();
    return parameter != null ? parameter.getNode() : null;
  }

  @Nullable
  @Override
  public PsiElement getParameter() {
    final PsiElement first = getFirstChild();
    final PsiElement last = findLastChildByType(AppleScriptTypes.TARGET_VARIABLE);//todo could be list or record
    // literal..! and what todo with the parameterName in this case? return null?
    if (first != last && last != null) {
      return last;
    }
    return null;
  }

  @NotNull
  @Override
  public String getSelectorPart() {
    StringBuilder builder = new StringBuilder();
    ASTNode child = getNode().getFirstChildNode();
    if (child != null) {
      builder.append(child.getText());
      child = child.getTreeNext();
    }

    while (child != null && AppleScriptTokenTypesSets.COMMENT_OR_WHITE_SPACE.contains(child.getElementType()))
      child = child.getTreeNext();

    if (child != null && child.getElementType() == AppleScriptTypes.COLON) {
      builder.append(child.getText());
    }

    return builder.toString();
  }

  // !! IMPORTANT: defines handler's identifier !!
  @Nullable
  @Override
  public AppleScriptIdentifier getSelectorNameIdentifier() {
    AppleScriptSelectorIdentifier selectorId = findNotNullChildByClass(AppleScriptSelectorIdentifier.class);
    return selectorId.getAppleScriptIdentifier();
  }
}
