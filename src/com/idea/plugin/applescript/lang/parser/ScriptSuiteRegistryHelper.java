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
  ApplicationDictionary findDictionaryByName(String name);

  @Nullable
  List<String> getParameterNamesForCommand(String name);

  @Nullable
  CommandDirectParameter getDirectParameterForCommand(String commandName);

  @Nullable
  AppleScriptCommand getCommandWithName(String name);

  @Nullable
  AppleScriptPropertyDefinition getPropertyWithName(String name);

  @NotNull
  List<AppleScriptCommand> getAllCommandsWithName(String name);

  @NotNull
  List<AppleScriptCommand> findCommandsStartingWithName(String name);

  List<AppleScriptClass> findClassesStartingWithName(String name);

  List<DictionaryEnumerator> findConstantsStartingWithWord(String name);

  @Nullable
  DictionaryEnumerator getEnumerator(String name);

  @Nullable
  AppleScriptClass getClassWithName(String name);

  @Nullable
  DictionaryEnumeration getEnumerationWithName(String name);

  @Nullable
  List<AppleScriptCommand> getAllCommandsFromDictionary(String dictionaryName);

  List<AppleScriptCommand> geAllCommandsForSuiteRegistry();
}
