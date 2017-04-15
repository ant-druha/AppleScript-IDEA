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
  private static final String SCRIPT_PARAMETERS = "scriptParameters";
  private static final String SCRIPT_OPTIONS = "scriptOptions";
  private static final String SCRIPT_SHOW_EVENTS = "logEvents";

  private String scriptPath;
  private String scriptParameters;
  private String scriptOptions;
  private boolean myShowAppleEvents;

  AppleScriptRunConfiguration(Project project, ConfigurationFactory configurationFactory, String name) {
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
  String getScriptPath() {
    return scriptPath;
  }

  @Nullable
  String getScriptParameters() {
    return scriptParameters;
  }

  void setScriptPath(String scriptPath) {
    this.scriptPath = scriptPath;
  }

  void setScriptParameters(String scriptParameters) {
    this.scriptParameters = scriptParameters;
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    super.readExternal(element);
    String scriptUrl = element.getAttributeValue(SCRIPT_PATH_URL);
    String scriptParams = element.getAttributeValue(SCRIPT_PARAMETERS);
    String scriptOptions = element.getAttributeValue(SCRIPT_OPTIONS);
    String logEvents = element.getAttributeValue(SCRIPT_SHOW_EVENTS);
    if (!StringUtil.isEmpty(scriptUrl)) {
      scriptPath = scriptUrl;
    }
    if (!StringUtil.isEmpty(scriptParams)) {
      scriptParameters = scriptParams;
    }
    if (!StringUtil.isEmpty(scriptOptions)) {
      this.scriptOptions = scriptOptions;
    }
    if (!StringUtil.isEmpty(logEvents)) myShowAppleEvents = "true".equals(logEvents);
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    super.writeExternal(element);
    if (!StringUtil.isEmpty(scriptPath)) {
      element.setAttribute(SCRIPT_PATH_URL, scriptPath);
    }
    if (!StringUtil.isEmpty(scriptParameters)) {
      element.setAttribute(SCRIPT_PARAMETERS, scriptParameters);
    }
    if (!StringUtil.isEmpty(scriptOptions)) {
      element.setAttribute(SCRIPT_OPTIONS, scriptOptions);
    }
    element.setAttribute(SCRIPT_SHOW_EVENTS, myShowAppleEvents ? "true" : "false");
  }

  String getScriptOptions() {
    return scriptOptions;
  }

  void setScriptOptions(String scriptOptions) {
    this.scriptOptions = scriptOptions;
  }

  boolean isShowAppleEvents() {
    return myShowAppleEvents;
  }

  void setShowAppleEvents(boolean showAppleEvents) {
    myShowAppleEvents = showAppleEvents;
  }
}
