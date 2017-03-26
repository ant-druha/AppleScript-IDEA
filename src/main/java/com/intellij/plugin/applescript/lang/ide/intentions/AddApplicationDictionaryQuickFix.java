package com.intellij.plugin.applescript.lang.ide.intentions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugin.applescript.AppleScriptFileType;
import com.intellij.plugin.applescript.lang.ide.actions.LoadDictionaryAction;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;


public class AddApplicationDictionaryQuickFix implements IntentionAction {
  @NotNull String newApplicationName;

  public AddApplicationDictionaryQuickFix(@NotNull String appName) {
    newApplicationName = appName;
  }

  @Nls
  @NotNull
  @Override
  public String getText() {
    return "Add Dictionary for Application";
  }

  @Nls
  @NotNull
  @Override
  public String getFamilyName() {
    return "AppleScript";
  }

  @Override
  public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
    return file.getFileType() == AppleScriptFileType.INSTANCE;
  }

  @Override
  public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
    VirtualFile vFile = LocalFileSystem.getInstance().findFileByPath("/Applications/");
    LoadDictionaryAction.openLoadDirectoryDialog(project, vFile, newApplicationName);
  }

  @Override
  public boolean startInWriteAction() {
    return false;
  }
}