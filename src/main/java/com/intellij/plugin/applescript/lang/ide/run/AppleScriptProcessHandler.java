package com.intellij.plugin.applescript.lang.ide.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;

public class AppleScriptProcessHandler extends KillableColoredProcessHandler {
  AppleScriptProcessHandler(@NotNull GeneralCommandLine commandLine) throws ExecutionException {
    super(commandLine);
  }

  public AppleScriptProcessHandler(Process process, String commandLine, @NotNull Charset charset) {
    super(process, commandLine, charset);
  }

  public AppleScriptProcessHandler(Process process, String commandLine) {
    super(process, commandLine);
  }
}
