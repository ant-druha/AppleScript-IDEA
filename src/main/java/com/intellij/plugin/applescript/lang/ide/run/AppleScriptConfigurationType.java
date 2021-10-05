package com.intellij.plugin.applescript.lang.ide.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.intellij.plugin.applescript.AppleScriptIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AppleScriptConfigurationType extends ConfigurationTypeBase {
  public AppleScriptConfigurationType() {
    super("AppleScriptRunType", "Run AppleScript", "Run Configuration for AppleScript", AppleScriptIcons.FILE);

    addFactory(new ConfigurationFactory(this) {
        @Override
        public @NotNull @NonNls String getId() {
            return "AppleScript";
        }

        @Override
      public boolean isConfigurationSingletonByDefault() {
        return true;
      }

      @Override
      public boolean canConfigurationBeSingleton() {
        return false;
      }

      @NotNull
      @Override
      public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new AppleScriptRunConfiguration(project, this, " Template config");
      }
    });

  }
}
