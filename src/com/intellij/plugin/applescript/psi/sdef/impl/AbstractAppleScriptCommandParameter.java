package com.intellij.plugin.applescript.psi.sdef.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.psi.impl.AppleScriptPsiElementImpl;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerParameter;

/**
 * Andrey 16.08.2015
 */
public class AbstractAppleScriptCommandParameter extends AppleScriptPsiElementImpl
        implements AppleScriptCommandHandlerParameter {
  public AbstractAppleScriptCommandParameter(ASTNode node) {
    super(node);
  }
}
