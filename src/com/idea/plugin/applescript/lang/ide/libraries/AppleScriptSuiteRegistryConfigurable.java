package com.idea.plugin.applescript.lang.ide.libraries;

import com.intellij.lang.PerFileMappings;
import com.intellij.openapi.project.Project;
import com.intellij.util.ui.tree.LanguagePerFileConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 14.08.2015.
 */
public class AppleScriptSuiteRegistryConfigurable extends LanguagePerFileConfigurable<ScriptSuiteRegistry> {
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
}
