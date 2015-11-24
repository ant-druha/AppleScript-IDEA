package com.idea.plugin.applescript.lang.ide.actions;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryService;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.util.Consumer;

import java.util.List;

public class LoadDictionaryAction extends AnAction {
  public void actionPerformed(final AnActionEvent e) {

    DataContext dataContext = e.getDataContext();
    final IdeView view = LangDataKeys.IDE_VIEW.getData(dataContext);
    if (view == null) return;
    final PsiDirectory[] directories = view.getDirectories();

    PsiDirectory currentDirectory = directories.length > 0 ? directories[0] : null;
    final Project project = e.getData(DataKeys.PROJECT);
    if (project == null) return;

    VirtualFile directoryFile = currentDirectory != null ? currentDirectory.getVirtualFile() : project.getBaseDir();
    openLoadDirectoryDialog(project, directoryFile, null);


  }

  public static void openLoadDirectoryDialog(final Project project, VirtualFile directoryFile, final String appName) {
    FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, false, false, false, true);
    FileChooser.chooseFiles(descriptor, project, directoryFile, new Consumer<List<VirtualFile>>() {
      @Override
      public void consume(final List<VirtualFile> files) {
        for (VirtualFile file : files) {
          if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {
            String applicationName;
            if (StringUtil.isEmpty(appName)) {
              if (!ApplicationDictionary.SUPPORTED_APPLICATION_EXTENSIONS.contains(file.getExtension())) {
                applicationName = Messages.showInputDialog(project, "Please specify application name for dictionary "
                        + file.getName(), "Enter application name", null, file.getNameWithoutExtension(), null);
              } else {
                applicationName = file.getNameWithoutExtension();
              }
            } else {
              applicationName = appName;
            }
            if (StringUtil.isEmpty(applicationName)) {
              return;
            } else {
              AppleScriptProjectDictionaryService projectDictionaryRegistry = ServiceManager
                      .getService(project, AppleScriptProjectDictionaryService.class);
              if (projectDictionaryRegistry != null) {
                projectDictionaryRegistry.createDictionary(applicationName, file);
              }
            }
          }
        }
      }
    });
  }
}
