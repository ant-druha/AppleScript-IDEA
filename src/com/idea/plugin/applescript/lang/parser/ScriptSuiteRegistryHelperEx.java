package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.sdef.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 09.08.2015.
 */
public interface ScriptSuiteRegistryHelperEx extends ScriptSuiteRegistryHelper {

  @Nullable
  ApplicationDictionary findDictionaryByName(String name);

  @Nullable
  List<String> getParameterNamesForCommand(@Nullable String dictionaryName, String name);

  @Nullable
  CommandDirectParameter findDirectParameterForCommand(@Nullable String dictionaryName, String commandName);

  @Nullable
  AppleScriptCommand findCommandWithName(@Nullable String dictionaryName, String name);

  @Nullable
  AppleScriptPropertyDefinition findPropertyWithName(@Nullable String dictionaryName, String name);

  @NotNull
  List<AppleScriptCommand> findAllCommandsWithName(@Nullable String dictionaryName, String name);

  @NotNull
  List<AppleScriptCommand> findCommandsStartingWithName(@Nullable String dictionaryName, String name);

  List<AppleScriptClass> findClassesStartingWithName(@Nullable String dictionaryName, String name);

  List<AppleScriptClass> findClassesStartingWithPluralName(@Nullable String dictionaryName, String name);

  List<DictionaryEnumerator> findConstantsStartingWithWord(@Nullable String dictionaryName, String name);

  @Nullable
  DictionaryEnumerator findEnumerator(@Nullable String dictionaryName, String name);

  @Nullable
  AppleScriptClass findClassWithName(@Nullable String dictionaryName, String name);

  @Nullable
  AppleScriptClass findClassByPluralName(@Nullable String dictionaryName, String pluralForm);

  @Nullable
  DictionaryEnumeration findEnumerationWithName(@Nullable String dictionaryName, String name);

  @Nullable
  Collection<AppleScriptCommand> getAllCommandsFromDictionary(String dictionaryName);

  List<AppleScriptCommand> geAllCommandsForSuiteRegistry();

  List<AppleScriptPropertyDefinition> findPropertiesStartingWithName(@Nullable String dictionaryName, String name);
}
