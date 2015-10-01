package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.libraries.ScriptSuiteRegistry;
import com.idea.plugin.applescript.lang.sdef.*;
import com.intellij.lang.PsiBuilder;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Stack;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ParsableScriptSuiteRegistryHelper /*implements ScriptSuiteRegistryHelper*/ {
  private Project myProject;
  private static ScriptSuiteRegistryHelperEx currentScriptSuiteRegistry;//how to be sure of not null ???

  private static ScriptSuiteRegistryHelperEx getCurrentScriptSuiteRegistry() {
    return currentScriptSuiteRegistry != null ? currentScriptSuiteRegistry :
            ((ApplicationScriptSuiteRegistryComponent) ApplicationManager.getApplication().
                    getComponent("ApplicationScriptSuiteRegistryComponent")).getCurrentScriptSuiteRegistry();
  }

  private static ScriptSuiteRegistryHelper getCurrentDictionaryFromScriptSuiteRegistry(PsiBuilder b) {
    Stack<ApplicationDictionary> scriptDictionaryStack = b.getUserData(AppleScriptGeneratedParserUtil
            .SCRIPT_DICTIONARY_STACK);
    Stack<String> scriptDictionaryNameStack = b.getUserData(AppleScriptGeneratedParserUtil
            .SCRIPT_DICTIONARY_NAME_STACK);
    ApplicationDictionary currDictionary;
    String currDictionaryName;
    if (scriptDictionaryStack != null) {
      currDictionary = scriptDictionaryStack.peek();
      //1. if dictionary not null use registry helper with this dictionary name
      //but then behavior will not be consistent (need to load this dictionary to make it consistent)
      // we can do it inside ScriptSuiteRegistry


    }
    currDictionaryName = scriptDictionaryNameStack != null ? scriptDictionaryNameStack.peek() : null;
    if (!StringUtil.isEmpty(currDictionaryName)) {
      //use this name for searching classes via currentScriptSuiteRegistry
      //for this:
      //1. initialize ScriptSuiteRegistry with full name of the script and standard libraries
      //2. later (lazy) add dictionaries (look them up by name and load from xml file) to this registry as parsing in
      // progress
      //3. use dictionary name, taken from the script for looking up needed term (class, command, property, etc)

    }
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

  @Nullable
  public static AppleScriptClass findClassByPluralName(String dictionaryName, String pluralForm) {
    return getCurrentScriptSuiteRegistry().findClassByPluralName(dictionaryName, pluralForm);
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

  public static List<AppleScriptClass> findClassesStartingWithName(String dictionaryName, String name) {
    return getCurrentScriptSuiteRegistry().findClassesStartingWithName(dictionaryName, name);
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
