package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.sdef.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 09.08.2015.
 */
public interface ScriptSuiteRegistryHelper {

  @Nullable
  List<String> getParameterNamesForCommand(String name);

  CommandDirectParameter getDirectParameterForCommand(String commandName);

  @Nullable
  AppleScriptCommand getCommandWithName(String name);

  AppleScriptPropertyDefinition getPropertyWithName(String name);

  @NotNull
  List<AppleScriptCommand> getAllCommandsWithName(String name);

  @NotNull
  List<AppleScriptCommand> findCommandsStartingWithName(String name);

  List<AppleScriptClass> findClassesStartingWithName(String name);

  List<DictionaryEnumerator> findConstantsStartingWithWord(String name);

  DictionaryEnumerator getEnumerator(String name);

  AppleScriptClass getClassWithName(String name);

  DictionaryEnumeration getEnumerationWithName(String name);
}
