package com.intellij.plugin.applescript.psi;

import com.intellij.codeInsight.CodeInsightUtilCore;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugin.applescript.psi.impl.AppleScriptExpressionImpl;
import com.intellij.psi.ElementManipulators;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 11/04/17.
 */
public abstract class AppleScriptStringLiteralExpressionBase extends AppleScriptExpressionImpl implements PsiLanguageInjectionHost, AppleScriptStringLiteralExpression {
  public AppleScriptStringLiteralExpressionBase(ASTNode node) {
    super(node);
  }

  @Override
  public boolean isValidHost() {
    return true;
  }

  @Override
  public PsiLanguageInjectionHost updateText(@NotNull String text) {
    return ElementManipulators.handleContentChange(this, text);
  }

  @NotNull
  @Override
  public LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
    return new StringLiteralEscaper(this);
  }

  public static class StringLiteralEscaper extends LiteralTextEscaper<AppleScriptStringLiteralExpression> {
    private int[] sourceOffsets;

    StringLiteralEscaper(@NotNull AppleScriptStringLiteralExpression host) {
      super(host);
    }

    @NotNull
    @Override
    public TextRange getRelevantTextRange() {
      int length = myHost.getTextLength();
      return length > 1 ? TextRange.from(1, length - 2) : super.getRelevantTextRange();
    }

    @Override
    public boolean decode(@NotNull TextRange rangeInsideHost, @NotNull StringBuilder outChars) {
      String hostText = rangeInsideHost.substring(myHost.getText());
      sourceOffsets = new int[hostText.length() + 1];
      return CodeInsightUtilCore.parseStringCharacters(hostText, outChars, sourceOffsets);
    }

    @Override
    public int getOffsetInHost(int offsetInDecoded, @NotNull TextRange rangeInsideHost) {
      int result = offsetInDecoded < sourceOffsets.length ? sourceOffsets[offsetInDecoded] : -1;
      if (result == -1) return -1;
      return (result <= rangeInsideHost.getLength() ? result : rangeInsideHost.getLength()) + rangeInsideHost.getStartOffset();
    }

    @Override
    public boolean isOneLine() {
      return false;
    }
  }
}
