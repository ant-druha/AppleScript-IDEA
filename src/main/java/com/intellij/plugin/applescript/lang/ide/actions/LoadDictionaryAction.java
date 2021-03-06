package com.intellij.plugin.applescript.lang.ide.actions;

import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryService;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LoadDictionaryAction extends AnAction {
  public static void openLoadDirectoryDialog(@NotNull final Project project, @Nullable VirtualFile directoryFile, @Nullable final String appName) {
    final boolean chooseMultiple = StringUtil.isEmpty(appName);
    FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, false, false, false, chooseMultiple);
    FileChooser.chooseFiles(descriptor, project, directoryFile, files -> {
      AppleScriptProjectDictionaryService projectDictionaryRegistry = ServiceManager.getService(project, AppleScriptProjectDictionaryService
          .class);
      if (projectDictionaryRegistry == null) return;

      for (VirtualFile file : files) {
        if (!ApplicationDictionaryImpl.extensionSupported(file.getExtension())) continue;

        if (chooseMultiple) {
          String applicationName;
          if (ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS.contains(file.getExtension())) {
            applicationName = file.getNameWithoutExtension();
          } else {
            applicationName = Messages.showInputDialog(project, "Please specify application name for dictionary "
                + file.getName(), "Enter Application Name", null, file.getNameWithoutExtension(), null);
          }
          if (StringUtil.isEmpty(applicationName)) continue;
          projectDictionaryRegistry.createDictionaryFromFile(applicationName, file);
        } else {
          projectDictionaryRegistry.createDictionaryFromFile(appName, file);
          return;
        }
      }
    });
  }

  public void actionPerformed(final AnActionEvent e) {
    DataContext dataContext = e.getDataContext();
    final IdeView view = LangDataKeys.IDE_VIEW.getData(dataContext);
    if (view == null) return;
    final PsiDirectory[] directories = view.getDirectories();

    PsiDirectory currentDirectory = directories.length > 0 ? directories[0] : null;
    final Project project = e.getData(CommonDataKeys.PROJECT);
    if (project == null) return;

    VirtualFile directoryFile = currentDirectory != null ? currentDirectory.getVirtualFile() : project.getBaseDir();
    openLoadDirectoryDialog(project, directoryFile, null);
  }
}
