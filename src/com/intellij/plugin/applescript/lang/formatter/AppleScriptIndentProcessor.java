package com.intellij.plugin.applescript.lang.formatter;

import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;

import static com.intellij.plugin.applescript.psi.AppleScriptTypes.BLOCK_BODY;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.TOP_BLOCK_BODY;

/**
 * Andrey 08.04.2015
 */
public class AppleScriptIndentProcessor {
  private final CommonCodeStyleSettings settings;

  public AppleScriptIndentProcessor(CommonCodeStyleSettings settings) {
    this.settings = settings;
  }

  public Indent getChildIndent(final ASTNode node) {
    final IElementType elementType = node.getElementType();
//        final ASTNode prevSibling = UsefulPsiTreeUtil.getPrevSiblingSkipWhiteSpacesAndComments(node);
//        final IElementType prevSiblingType = prevSibling == null ? null : prevSibling.getElementType();
    final ASTNode parent = node.getTreeParent();
    final IElementType parentType = parent != null ? parent.getElementType() : null;
    final ASTNode superParent = parent == null ? null : parent.getTreeParent();
    final IElementType superParentType = superParent == null ? null : superParent.getElementType();

    final PsiElement psi = node.getPsi();

    if (elementType == BLOCK_BODY || elementType == TOP_BLOCK_BODY) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }
}
