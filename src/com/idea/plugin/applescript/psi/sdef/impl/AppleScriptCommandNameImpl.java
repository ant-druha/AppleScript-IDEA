package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandName;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

/**
 * Created by Andrey on 16.08.2015.
 */
public abstract class AppleScriptCommandNameImpl extends AppleScriptPsiElementImpl implements AppleScriptCommandName {
  public AppleScriptCommandNameImpl(ASTNode node) {
    super(node);
  }

//  @Override
//  public String getText() {
//    StringBuilder sb = new StringBuilder();
//    for (AppleScriptIdentifier id : getIdentifiers()) {
//      sb.append(id.getText()).append(" ");
//    }
//    return sb.toString().trim();
////    return super.getText().replaceAll("\\s{2,}", " ");
//  }

  @Override
  public List<AppleScriptIdentifier> getIdentifiers() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptIdentifier.class);
  }
}
