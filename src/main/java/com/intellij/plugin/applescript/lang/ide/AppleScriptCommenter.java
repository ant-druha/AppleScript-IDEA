package com.intellij.plugin.applescript.lang.ide;

import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 12.04.2015
 */
public class AppleScriptCommenter implements CodeDocumentationAwareCommenter {
  @Nullable
  @Override
  public IElementType getLineCommentTokenType() {
    return null;
  }

  @Nullable
  @Override
  public IElementType getBlockCommentTokenType() {
    return null;
  }

  @Nullable
  @Override
  public IElementType getDocumentationCommentTokenType() {
    return null;
  }

  @Nullable
  @Override
  public String getDocumentationCommentPrefix() {
    return null;
  }

  @Nullable
  @Override
  public String getDocumentationCommentLinePrefix() {
    return null;
  }

  @Nullable
  @Override
  public String getDocumentationCommentSuffix() {
    return null;
  }

  @Override
  public boolean isDocumentationComment(PsiComment element) {
    return false;
  }

  @Nullable
  @Override
  public String getLineCommentPrefix() {
    return "--";
  }

  @Nullable
  @Override
  public String getBlockCommentPrefix() {
    return "(*";
  }

  @Nullable
  @Override
  public String getBlockCommentSuffix() {
    return "*)";
  }

  @Nullable
  @Override
  public String getCommentedBlockCommentPrefix() {
    return null;
  }

  @Nullable
  @Override
  public String getCommentedBlockCommentSuffix() {
    return null;
  }
}
