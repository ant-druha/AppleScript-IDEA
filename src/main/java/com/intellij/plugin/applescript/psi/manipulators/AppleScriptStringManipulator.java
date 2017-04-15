package com.intellij.plugin.applescript.psi.manipulators;

import com.intellij.openapi.util.TextRange;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElementFactory;
import com.intellij.plugin.applescript.psi.AppleScriptStringLiteralExpression;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 12/04/17.
 */
public class AppleScriptStringManipulator extends AbstractElementManipulator<AppleScriptStringLiteralExpression> {
  @NotNull
  @Override
  public TextRange getRangeInElement(@NotNull AppleScriptStringLiteralExpression element) {
    int length = element.getTextLength();
    return length > 1 ? TextRange.from(1, length - 2) : super.getRangeInElement(element);
  }

  @Override
  public AppleScriptStringLiteralExpression handleContentChange(@NotNull AppleScriptStringLiteralExpression element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
    String escaped = newContent.replaceAll("\"", "\\\\\"");
    AppleScriptStringLiteralExpression stringLiteral = AppleScriptPsiElementFactory.createStringLiteral(element.getProject(), escaped);
    return (AppleScriptStringLiteralExpression) element.replace(stringLiteral);
  }
}
