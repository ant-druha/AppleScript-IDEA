package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * andrey 28/05/15
 */
public class AppleScriptHandlerSelectorPartImpl extends AppleScriptNamedElementImpl implements
        AppleScriptHandlerSelectorPart {
  public AppleScriptHandlerSelectorPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public List<AppleScriptComponent> findParameters() {
    final List<AppleScriptComponent> components = new ArrayList<AppleScriptComponent>();
    PsiElement parameter = getParameter();
    if (parameter instanceof AppleScriptTargetVariable) {
      components.add((AppleScriptTargetVariable) parameter);
    } else if (parameter instanceof AppleScriptTargetListLiteral) {
      AppleScriptTargetListLiteral list = (AppleScriptTargetListLiteral) parameter;
      components.addAll(list.getTargets());
    } else if (parameter instanceof AppleScriptTargetRecordLiteral) {
      AppleScriptTargetRecordLiteral record = (AppleScriptTargetRecordLiteral) parameter;
      components.addAll(record.getTargets());
    }
    return components;
  }

  @Nullable
  @Override
  public PsiReference getReference() {
    return null;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String newElementName) throws IncorrectOperationException {
    //should work ok
    return super.setName(newElementName);
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

  //todo might be null ... this is not used currently
  @NotNull
  @Override
  public AppleScriptIdentifier getIdentifier() {
    PsiElement parameter = getParameter();
//    AppleScriptSelectorId selectorIdentifier = findNotNullChildByClass(AppleScriptSelectorId.class);
//    return selectorIdentifier.getIdentifier();
    AppleScriptIdentifier parameterId = PsiTreeUtil.findChildOfAnyType(parameter, AppleScriptIdentifier.class);
    return parameterId != null ? parameterId : PsiTreeUtil.getRequiredChildOfType(parameter != null ? parameter :
            getLastChild(), AppleScriptIdentifier.class);
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
    // todo literal..! and what to do with the parameterName in this case? return null?
    final PsiElement lastAny = getLastChild();
    if (first != lastAny && lastAny != null) {
      return lastAny;
    }
    return first != last && last != null ? last : null;
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
  @NotNull
  @Override
  public AppleScriptIdentifier getSelectorNameIdentifier() {
    AppleScriptSelectorId selectorId = findNotNullChildByClass(AppleScriptSelectorId.class);
    return selectorId.getIdentifier();
  }
}
