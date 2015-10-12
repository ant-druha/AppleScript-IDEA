package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.psi.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.*;
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
    FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, false, false, false, true);
    FileChooser.chooseFiles(descriptor, project, directoryFile, new Consumer<List<VirtualFile>>() {
      @Override
      public void consume(final List<VirtualFile> files) {
        for (VirtualFile file : files) {
          if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {

            String applicationName = null;
            if (!"app".equals(file.getExtension())) {
              applicationName = Messages.showInputDialog(project, "Please specify application name for dictionary "
                      + file.getName(), "Enter application name", null);
            }
            if (StringUtil.isEmpty(applicationName)) {
              return;
            }
            AppleScriptProjectDictionaryRegistry projectDictionaryRegistry = project
                    .getComponent(AppleScriptProjectDictionaryRegistry.class);
            if (projectDictionaryRegistry != null) {
              projectDictionaryRegistry.createDictionary(applicationName);
            }
          }
        }
      }
    });


  }
}
