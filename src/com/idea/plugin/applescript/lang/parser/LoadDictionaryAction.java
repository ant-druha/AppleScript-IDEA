package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistryMappings;
import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
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
        ScriptSuiteRegistry currentSuiteRegistry = getCurrentSuiteRegistry();
        for (VirtualFile file : files) {
          if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {
            ApplicationDictionary dictionary = new ApplicationDictionaryImpl(project, file);
            currentSuiteRegistry.addApplicationDictionary(dictionary);
          }
        }
        ScriptSuiteRegistryMappings mappings = ScriptSuiteRegistryMappings.getInstance(project);
        if (!mappings.getMappings().containsValue(currentSuiteRegistry)) {
          VirtualFile scriptFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
          mappings.associate(scriptFile, currentSuiteRegistry);

//          ApplicationScriptSuiteRegistryComponent suiteRegCmp = ((ApplicationScriptSuiteRegistryComponent)
//                  ApplicationManager.getApplication().getComponent("ApplicationScriptSuiteRegistryComponent"));
//          suiteRegCmp.update(project, scriptFile);
        }
      }
    });


  }

  private static ScriptSuiteRegistry getCurrentSuiteRegistry() {
    return ((ApplicationScriptSuiteRegistryComponent) ApplicationManager.getApplication().
            getComponent("ApplicationScriptSuiteRegistryComponent")).getCurrentScriptSuiteRegistry();
  }
}
