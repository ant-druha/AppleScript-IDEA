package com.intellij.plugin.applescript.lang.formatter;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.BlockWithParent;
import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.AppleScriptLanguage;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Andrey 08.04.2015
 */
public class AppleScriptBlock extends AbstractBlock implements BlockWithParent {
  private final Indent myIndent;
  private final AppleScriptIndentProcessor myIndentProcessor;
  private final AppleScriptSpacingProcessor mySpacingProcessor;
  private final AppleScriptWrappingProcessor myWrappingProcessor;
  private final CodeStyleSettings mySettings;
  private BlockWithParent myParent;
  private Wrap myChildWrap = null;


  protected AppleScriptBlock(ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, CodeStyleSettings
          settings) {
    super(node, wrap, alignment);
    mySettings = settings;
    myIndentProcessor = new AppleScriptIndentProcessor(settings.getCommonSettings(AppleScriptLanguage.INSTANCE));
    myIndent = myIndentProcessor.getChildIndent(myNode);
    mySpacingProcessor = new AppleScriptSpacingProcessor(node, settings.getCommonSettings(AppleScriptLanguage
            .INSTANCE));
    myWrappingProcessor = new AppleScriptWrappingProcessor(node, settings.getCommonSettings(AppleScriptLanguage
            .INSTANCE));
  }

  @Override
  protected List<Block> buildChildren() {
    if (isLeaf()) {
      return EMPTY;
    }
    final ArrayList<Block> tlChildren = new ArrayList<Block>();
    for (ASTNode childNode = getNode().getFirstChildNode(); childNode != null; childNode = childNode.getTreeNext()) {
//          if (FormatterUtil.containsWhiteSpacesOnly(childNode)) continue; //check for whitespaces only is not enought
      if (childNode.getText().trim().isEmpty()) continue;
      final AppleScriptBlock childBlock = new AppleScriptBlock(childNode, createChildWrap(childNode),
              Alignment.createAlignment(), mySettings);
      childBlock.setParent(this);
      tlChildren.add(childBlock);
    }
    return tlChildren;
  }

  private Wrap createChildWrap(ASTNode childNode) {
    final IElementType childType = childNode.getElementType();
    Wrap wrap = myWrappingProcessor.createChildWrap(childNode, Wrap.createWrap(WrapType.NONE, false), myChildWrap);

    return wrap;
  }


  @Nullable
  @Override
  public Spacing getSpacing(Block child1, Block child2) {
    return mySpacingProcessor.getSpacing((AppleScriptBlock) child1, (AppleScriptBlock) child2);
  }

  @Override
  public boolean isLeaf() {
    return false;
  }

  @Override
  public Indent getIndent() {
    return myIndent;
  }

  @Override
  public BlockWithParent getParent() {
    return myParent;
  }

  public void setParent(BlockWithParent parent) {
    this.myParent = parent;
  }
}
