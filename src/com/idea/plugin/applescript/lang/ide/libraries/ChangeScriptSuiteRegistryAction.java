package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilCore;

/**
 * Created by Andrey on 15.08.2015.
 */
public class ChangeScriptSuiteRegistryAction extends AnAction {
  @Override
  public void update(AnActionEvent e) {
    DataContext dataContext = e.getDataContext();
    final Project project = e.getProject();
    PsiFile psiFile = CommonDataKeys.PSI_FILE.getData(dataContext);
    if (psiFile == null || psiFile.getFileType() != AppleScriptFileType.INSTANCE || project == null) {
      e.getPresentation().setVisible(false);
    }
  }

  @Override
  public void actionPerformed(AnActionEvent e) {
    DataContext dataContext = e.getDataContext();
    final Project project = e.getProject();
    PsiFile psiFile = CommonDataKeys.PSI_FILE.getData(dataContext);
    final VirtualFile virtualFile = PsiUtilCore.getVirtualFile(psiFile);
    if (project == null || virtualFile == null) return;

    final AppleScriptSuiteRegistryConfigurable configurable = new AppleScriptSuiteRegistryConfigurable(project);
    ShowSettingsUtil.getInstance().editConfigurable(project, configurable, new Runnable() {
      @Override
      public void run() {
        configurable.selectFile(virtualFile);
      }
    });
  }
}
