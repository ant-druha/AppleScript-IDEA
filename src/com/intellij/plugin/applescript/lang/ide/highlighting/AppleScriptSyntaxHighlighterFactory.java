/*
 * Copyright (C) 2014, Cast & Crew (R) Software, LLC
 * All rights reserved.  Unauthorized disclosure or distribution is prohibited.
 */
package com.intellij.plugin.applescript.lang.ide.highlighting;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class AppleScriptSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  @NotNull
  @Override
  public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
    return new AppleScriptSyntaxHighlighter();
  }
}
