package com.idea.plugin.applescript.lang.ide;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class AppleScriptTemplateContextType extends TemplateContextType {

  protected AppleScriptTemplateContextType() {
    super("AppleScript", "AppleScript");
  }

  @Override
  public boolean isInContext(@NotNull PsiFile file, int offset) {
    return file.getFileType() == AppleScriptFileType.INSTANCE;
  }

  @Override
  public SyntaxHighlighter createHighlighter() {
    return SyntaxHighlighterFactory.getSyntaxHighlighter(AppleScriptFileType.INSTANCE, null, null);
  }
}