package com.intellij.plugin.applescript.lang.ide.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.plugin.applescript.AppleScriptIcons;
import com.intellij.psi.PsiDirectory;

public class CreateAppleScriptFileAction extends CreateFileFromTemplateAction implements DumbAware {
  public CreateAppleScriptFileAction() {
    super("AppleScript File", "Creates a AppleScript file from the specified template", AppleScriptIcons.FILE);
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder.setTitle("New AppleScript file").addKind("AppleScript file", AppleScriptIcons.FILE, "AppleScript File.scpt");
  }

  @Override
  protected String getActionName(PsiDirectory directory, String newName, String templateName) {
    return "Create AppleScript file " + newName;
  }
}
