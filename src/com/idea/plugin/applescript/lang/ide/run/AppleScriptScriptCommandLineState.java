package com.idea.plugin.applescript.lang.ide.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class AppleScriptScriptCommandLineState extends CommandLineState implements RunProfileState {

  AppleScriptRunConfiguration runConfiguration;

  public AppleScriptScriptCommandLineState(AppleScriptRunConfiguration runConfiguration,
                                           ExecutionEnvironment env) {
    super(env);
    this.runConfiguration = runConfiguration;
  }

  @NotNull
  @Override
  protected ProcessHandler startProcess() throws ExecutionException {
    String scriptPath = runConfiguration.getScriptPath();

//    GeneralCommandLine commandLine = new GeneralCommandLine("/usr/bin/osascript", "-e", "say \"Hi\"");
    scriptPath = scriptPath == null ? "" : scriptPath;//todo change this (and add validator to run config)
    GeneralCommandLine commandLine = new GeneralCommandLine("/usr/bin/osascript", scriptPath);
//    commandLine.withEnvironment(EnvironmentUtil.getEnvironmentMap());
//    commandLine.withPassParentEnvironment(true);
//    commandLine.pare
    AppleScriptProcessHandler processHandler = new AppleScriptProcessHandler(commandLine);
    return processHandler;
  }
}
