package com.intellij.plugin.applescript.lang.ide.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.openapi.util.text.StringUtil;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppleScriptRunConfiguration extends LocatableConfigurationBase {

  private static final String SCRIPT_PATH_URL = "scriptUrl";

  private String scriptPath;

  public AppleScriptRunConfiguration(Project project, ConfigurationFactory configurationFactory, String name) {
    super(project, configurationFactory, name);
  }

  @NotNull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new AppleScriptRunSettingsEditor(getProject(), this);
  }

  @Nullable
  @Override
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws
          ExecutionException {
    return new AppleScriptScriptCommandLineState(this, environment);
  }

  @Nullable
  public String getScriptPath() {
    return scriptPath;
  }

  public void setScriptPath(String scriptPath) {
    this.scriptPath = scriptPath;
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    super.readExternal(element);
    String scriptUrl = element.getAttributeValue(SCRIPT_PATH_URL);
    if (!StringUtil.isEmpty(scriptUrl)) {
      scriptPath = scriptUrl;
    }
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    super.writeExternal(element);
    if (!StringUtil.isEmpty(scriptPath)) {
      element.setAttribute(SCRIPT_PATH_URL, scriptPath);
    }
  }

}
