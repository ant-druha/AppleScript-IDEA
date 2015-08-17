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
public class ParsableScriptSuiteRegistryHelper/* implements ScriptSuiteRegistryHelper */ {
  private Project myProject;
  private static ScriptSuiteRegistryHelper currentScriptSuiteRegistry;//how to be sure of not null ???

  private static ScriptSuiteRegistryHelper getCurrentScriptSuiteRegistry() {
    return currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry :
            ((ApplicationScriptSuiteRegistryComponent) ApplicationManager.getApplication().
                    getComponent("ApplicationScriptSuiteRegistryComponent")).getCurrentScriptSuiteRegistry();
  }


  public static CommandDirectParameter getDirectParameterForCommand(String commandName) {
    return getCurrentScriptSuiteRegistry().getDirectParameterForCommand(commandName);
  }

  @Nullable
  public static AppleScriptCommand getCommandWithName(String name) {
    return getCurrentScriptSuiteRegistry().getCommandWithName(name);
  }

  @NotNull
  public static List<AppleScriptCommand> getAllCommandsWithName(String name) {
    return getCurrentScriptSuiteRegistry().getAllCommandsWithName(name);
  }

  @NotNull
  public static List<AppleScriptCommand> findCommandsStartingWithName(String name) {
    return getCurrentScriptSuiteRegistry().findCommandsStartingWithName(name);
  }

  public static AppleScriptPropertyDefinition getPropertyWithName(String name) {
    return getCurrentScriptSuiteRegistry().getPropertyWithName(name);
  }

  public static AppleScriptClass getClassWithName(String name) {
    return getCurrentScriptSuiteRegistry().getClassWithName(name);
  }

  public static DictionaryEnumeration getEnumerationWithName(String name) {
    return getCurrentScriptSuiteRegistry().getEnumerationWithName(name);
  }

  public static void setCurrentScriptSuiteRegistry(@NotNull ScriptSuiteRegistry currentScriptSuiteRegistry) {
    ParsableScriptSuiteRegistryHelper.currentScriptSuiteRegistry = currentScriptSuiteRegistry;
  }

  public List<String> getParameterNamesForCommand(String name) {
    return getCurrentScriptSuiteRegistry().getParameterNamesForCommand(name);
  }

  public static DictionaryEnumerator getEnumerator(String name) {
    return getCurrentScriptSuiteRegistry().getEnumerator(name);
  }

  public static List<AppleScriptClass> findClassesStartingWithName(String name) {
    return getCurrentScriptSuiteRegistry().findClassesStartingWithName(name);
  }

  public static List<DictionaryEnumerator> findConstantsStartingWithWord(String name) {
    return getCurrentScriptSuiteRegistry().findConstantsStartingWithWord(name);
  }

}
