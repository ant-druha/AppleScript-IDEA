package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.sdef.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ParsableScriptSuiteRegistryHelper /*implements ScriptSuiteRegistryHelper*/ {
  private Project myProject;
  private static ScriptSuiteRegistryHelper currentScriptSuiteRegistry;//how to be sure of not null ???

  private static ScriptSuiteRegistryHelper getCurrentScriptSuiteRegistry() {
    return currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry :
            ((ApplicationScriptSuiteRegistryComponent) ApplicationManager.getApplication().
                    getComponent("ApplicationScriptSuiteRegistryComponent")).getCurrentScriptSuiteRegistry();
  }


  public static CommandDirectParameter getDirectParameterForCommand(String commandName) {
    return getCurrentScriptSuiteRegistry().findDirectParameterForCommand(commandName);
  }

  @Nullable
  public static AppleScriptCommand findCommandWithName(String name) {
    return getCurrentScriptSuiteRegistry().findCommandWithName(name);
  }

  @Nullable
  public static AppleScriptClass findClassByPluralName(String pluralForm) {
    return getCurrentScriptSuiteRegistry().findClassByPluralName(pluralForm);
  }

  @NotNull
  public static List<AppleScriptCommand> getAllCommandsWithName(String name) {
    return getCurrentScriptSuiteRegistry().findAllCommandsWithName(name);
  }

  @NotNull
  public static List<AppleScriptCommand> findCommandsStartingWithName(String name) {
    return getCurrentScriptSuiteRegistry().findCommandsStartingWithName(name);
  }

  public static AppleScriptPropertyDefinition getPropertyWithName(String name) {
    return getCurrentScriptSuiteRegistry().findPropertyWithName(name);
  }

  public static AppleScriptClass findClassWithName(String name) {
    return getCurrentScriptSuiteRegistry().findClassWithName(name);
  }

  public static AppleScriptClass findClassWithName(String dictionaryName, String name) {
    return getCurrentScriptSuiteRegistry().findClassWithName(name);
  }

  public static DictionaryEnumeration getEnumerationWithName(String name) {
    return getCurrentScriptSuiteRegistry().findEnumerationWithName(name);
  }

  public static void setCurrentScriptSuiteRegistry(@NotNull ScriptSuiteRegistry currentScriptSuiteRegistry) {
    ParsableScriptSuiteRegistryHelper.currentScriptSuiteRegistry = currentScriptSuiteRegistry;
  }

  public List<String> getParameterNamesForCommand(String name) {
    return getCurrentScriptSuiteRegistry().getParameterNamesForCommand(name);
  }

  public static DictionaryEnumerator getEnumerator(String name) {
    return getCurrentScriptSuiteRegistry().findEnumerator(name);
  }

  public static List<AppleScriptClass> findClassesStartingWithName(String name) {
    return getCurrentScriptSuiteRegistry().findClassesStartingWithName(name);
  }

  public static List<AppleScriptClass> findClassesStartingWithPluralName(String pluralForm) {
    return getCurrentScriptSuiteRegistry().findClassesStartingWithPluralName(pluralForm);
  }

  public static List<AppleScriptPropertyDefinition> findPropertiesStartingWithName(String name) {
    return getCurrentScriptSuiteRegistry().findPropertiesStartingWithName(name);
  }

  public static List<DictionaryEnumerator> findConstantsStartingWithWord(String name) {
    return getCurrentScriptSuiteRegistry().findConstantsStartingWithWord(name);
  }

  public static List<AppleScriptCommand> geAllCommandsForSuiteRegistry() {
    return getCurrentScriptSuiteRegistry().geAllCommandsForSuiteRegistry();
  }

  @Nullable
  public static ApplicationDictionary findDictionaryByName(String name) {
    return getCurrentScriptSuiteRegistry().findDictionaryByName(name);
  }

}
