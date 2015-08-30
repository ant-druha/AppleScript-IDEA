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
  CommandDirectParameter findDirectParameterForCommand(String commandName);

  @Nullable
  AppleScriptCommand findCommandWithName(String name);

  @Nullable
  AppleScriptPropertyDefinition findPropertyWithName(String name);

  @NotNull
  List<AppleScriptCommand> findAllCommandsWithName(String name);

  @NotNull
  List<AppleScriptCommand> findCommandsStartingWithName(String name);

  List<AppleScriptClass> findClassesStartingWithName(String name);

  List<AppleScriptClass> findClassesStartingWithPluralName(String name);

  List<DictionaryEnumerator> findConstantsStartingWithWord(String name);

  @Nullable
  DictionaryEnumerator findEnumerator(String name);

  @Nullable
  AppleScriptClass findClassWithName(String name);

  @Nullable
  AppleScriptClass findClassWithName(String dictionaryName, String name);

  @Nullable
  AppleScriptClass findClassByPluralName(String pluralForm);

  @Nullable
  DictionaryEnumeration findEnumerationWithName(String name);

  @Nullable
  List<AppleScriptCommand> getAllCommandsFromDictionary(String dictionaryName);

  List<AppleScriptCommand> geAllCommandsForSuiteRegistry();

  List<AppleScriptPropertyDefinition> findPropertiesStartingWithName(String name);
}
