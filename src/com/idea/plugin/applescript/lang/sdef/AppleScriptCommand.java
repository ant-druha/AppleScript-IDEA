package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Andrey 09.07.2015
 */
public interface AppleScriptCommand extends DictionaryComponent {

  @Nullable
  CommandParameter getParameterByName(String name);

  @NotNull
  List<String> getParameterNames();

  @NotNull
  List<CommandParameter> getParameters();

  @Nullable
  CommandDirectParameter getDirectParameter();

  @Nullable
  CommandResult getResult();

  @Nullable
  CommandResult setResult(CommandResult result);

  @NotNull
  List<CommandParameter> getMandatoryParameters();

  void setParameters(List<CommandParameter> parameters);

  void setDirectParameter(CommandDirectParameter directParameter);
}
