package com.intellij.plugin.applescript.lang.ide.intentions;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.plugin.applescript.AppleScriptFileType;
import com.intellij.plugin.applescript.psi.AppleScriptHandlerParameterLabel;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElementFactory;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 12.04.2015
 */
public class RenameParameterLabelQuickFix extends BaseIntentionAction {
  private String myNewLabelName;
  private AppleScriptHandlerParameterLabel myHandlerParameterLabel;

  public RenameParameterLabelQuickFix(AppleScriptHandlerParameterLabel myHandlerParameterLabel, String myNewLabelName) {
    this.myHandlerParameterLabel = myHandlerParameterLabel;
    this.myNewLabelName = myNewLabelName;
  }

  @NotNull
  @Override
  public String getFamilyName() {
    return "AppleScript";
  }

  @Override
  public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
    return file.getFileType() instanceof AppleScriptFileType;
  }

  @Override
  public void invoke(@NotNull final Project project, Editor editor, PsiFile file) throws IncorrectOperationException {

    ApplicationManager.getApplication().invokeLater(() -> ApplicationManager.getApplication().runWriteAction(() -> CommandProcessor.getInstance()
            .executeCommand(project, () -> {
      AppleScriptHandlerParameterLabel newLabel = AppleScriptPsiElementFactory.createHandlerParameterLabel(project, myNewLabelName);
      if (newLabel != null) {
        myHandlerParameterLabel.replace(newLabel);
      }
    }, getText(), null)));
  }

  @NotNull
  @Override
  public String getText() {
    return "rename parameter label";
  }
}
