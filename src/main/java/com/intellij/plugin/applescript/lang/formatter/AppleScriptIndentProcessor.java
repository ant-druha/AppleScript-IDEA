package com.intellij.plugin.applescript.lang.formatter;

import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;

import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Andrey 08.04.2015
 */
class AppleScriptIndentProcessor {
  private final CommonCodeStyleSettings settings;

  AppleScriptIndentProcessor(CommonCodeStyleSettings settings) {
    this.settings = settings;
  }

  Indent getChildIndent(final ASTNode node) {
    final IElementType elementType = node.getElementType();

    if (elementType == BLOCK_BODY || elementType == TOP_BLOCK_BODY || elementType == SCRIPT_BODY) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }
}
