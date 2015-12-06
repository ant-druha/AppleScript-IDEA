package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandHandlerParameter;
import com.intellij.lang.ASTNode;

/**
 * Andrey 16.08.2015
 */
public class AbstractAppleScriptCommandParameter extends AppleScriptPsiElementImpl
        implements AppleScriptCommandHandlerParameter {
  public AbstractAppleScriptCommandParameter(ASTNode node) {
    super(node);
  }
}
