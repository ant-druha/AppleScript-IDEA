package com.intellij.plugin.applescript.lang.ide.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppleScriptScriptCommandLineState extends CommandLineState implements RunProfileState {

  AppleScriptRunConfiguration runConfiguration;
  private final Logger LOG = Logger.getInstance("#" + getClass().getName());

  public AppleScriptScriptCommandLineState(AppleScriptRunConfiguration runConfiguration,
                                           ExecutionEnvironment env) {
    super(env);
    this.runConfiguration = runConfiguration;
  }

  @NotNull
  @Override
  protected ProcessHandler startProcess() throws ExecutionException {
    String scriptPath = runConfiguration.getScriptPath();
    String scriptParameters = runConfiguration.getScriptParameters();
    String scriptOptions = runConfiguration.getScriptOptions();

    scriptPath = scriptPath == null ? "" : scriptPath;//todo change this (and add validator to run config)
    final List<String> commandString = new ArrayList<>();
    commandString.add("/usr/bin/osascript");
    if (!StringUtil.isEmpty(scriptOptions)) {
      String[] options = scriptOptions.split(" ");
      commandString.addAll(Arrays.asList(options));
    }
    commandString.add(scriptPath);
    if (!StringUtil.isEmpty(scriptParameters)) {
      Pattern regex = Pattern.compile("\"([^\"]*)\"|(\\w+)");
      final ArrayList<String> matchedParams = new ArrayList<>();
      Matcher matcher = regex.matcher(scriptParameters);
      while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
          try {
            String p = matcher.group(i);
            if (!StringUtil.isEmpty(p)) matchedParams.add(p);
          } catch (IllegalStateException | IndexOutOfBoundsException e) {
            LOG.warn("Error parsing script parameters: " + e.getMessage());
          }
        }
      }
      commandString.addAll(matchedParams);
    }

    final GeneralCommandLine commandLine = new GeneralCommandLine(commandString);
    if (runConfiguration.isShowAppleEvents()) {
      commandLine.withEnvironment("AEDebugSends", "1");
      commandLine.withEnvironment("AEDebugReceives", "1");
    }
    return new AppleScriptProcessHandler(commandLine);
  }
}
