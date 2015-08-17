package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.lang.parser.ApplicationScriptSuiteRegistryComponent;
import com.intellij.lang.PerFileMappings;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.util.ui.tree.LanguagePerFileConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 14.08.2015.
 */
public class AppleScriptSuiteRegistryConfigurable extends LanguagePerFileConfigurable<ScriptSuiteRegistry>
        implements LibraryTable.Listener, Disposable {
  protected AppleScriptSuiteRegistryConfigurable(@NotNull Project project,
                                                 Class<ScriptSuiteRegistry> valueClass,
                                                 PerFileMappings<ScriptSuiteRegistry> mappings,
                                                 String caption,
                                                 String treeTableTitle,
                                                 String overrideQuestion,
                                                 String overrideTitle) {
    super(project, valueClass, mappings, caption, treeTableTitle, overrideQuestion, overrideTitle);
  }

  public AppleScriptSuiteRegistryConfigurable(@NotNull Project project) {
    super(project, ScriptSuiteRegistry.class, ScriptSuiteRegistryMappings.getInstance(project),
            "Select mappings between script and SuiteRegistry",
            "Script Suite Library",
            "Override?", "Override Subdirectory Script Suite Registry");
  }

  @Override
  protected String visualize(@NotNull ScriptSuiteRegistry scriptSuiteRegistry) {
    return scriptSuiteRegistry.getName();
  }

  @Nls
  @Override
  public String getDisplayName() {
    return "AppleScript Suite Libraries";
  }

  @Nullable
  @Override
  public String getHelpTopic() {
    return null;
  }

  @Override
  public void dispose() {

  }

  @Override
  public void afterLibraryAdded(Library newLibrary) {
    ApplicationScriptSuiteRegistryComponent suiteRegCmp = ((ApplicationScriptSuiteRegistryComponent)
            ApplicationManager.getApplication().getComponent("ApplicationScriptSuiteRegistryComponent"));
    ScriptSuiteRegistryMappings registryMappings = ScriptSuiteRegistryMappings.getInstance(myProject);
    ScriptSuiteRegistry newSuiteLibrary = registryMappings.getSuiteRegistryByName(newLibrary.getName());
    ScriptSuiteRegistry currentSuite = suiteRegCmp.getCurrentScriptSuiteRegistry();

  }

  @Override
  public void afterLibraryRenamed(Library library) {

  }

  @Override
  public void beforeLibraryRemoved(Library library) {

  }

  @Override
  public void afterLibraryRemoved(Library library) {

  }
}
