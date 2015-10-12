package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistry;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ParsableScriptSuiteRegistryHelper {

  private static ParsableScriptHelper scriptHelper;

  private static ParsableScriptHelper getParsableScriptHelper() {
    scriptHelper = scriptHelper != null ? scriptHelper :
            (AppleScriptSystemDictionaryRegistry) ApplicationManager.getApplication()
                    .getComponent(AppleScriptSystemDictionaryRegistry.COMPONENT_NAME);
    return scriptHelper;
  }

  public static boolean isClassExist(@NotNull String name) {
    return getParsableScriptHelper().isClassExist(name);
  }

  public static boolean isClassExist(@NotNull String applicationName, @NotNull String className) {
    return getParsableScriptHelper().isClassExist(applicationName, className);
  }

  public static boolean isClassWithPluralNameExist(@NotNull String pluralName) {
    return getParsableScriptHelper().isClassWithPluralNameExist(pluralName);
  }

  public static boolean isClassWithPluralNameExist(@NotNull String applicationName, @NotNull String pluralClassName) {
    return getParsableScriptHelper().isClassWithPluralNameExist(applicationName, pluralClassName);
  }

  public static int countClassesStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countClassesStartingWithName(namePrefix);
  }

  public static int countClassesStartingWithName(@NotNull String applicationName, @NotNull String classNamePrefix) {
    return getParsableScriptHelper().countClassesStartingWithName(applicationName, classNamePrefix);
  }

  public static int countClassesStartingWithPluralName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countClassesStartingWithPluralName(namePrefix);
  }

  public static int countClassesStartingWithPluralName(@NotNull String applicationName, @NotNull String
          pluralClassNamePrefix) {
    return getParsableScriptHelper().countClassesStartingWithPluralName(applicationName, pluralClassNamePrefix);
  }

  public static boolean isCommandExist(@NotNull String name) {
    return getParsableScriptHelper().isCommandExist(name);
  }

  public static boolean isCommandExist(@NotNull String applicationName, @NotNull String commandName) {
    return getParsableScriptHelper().isCommandExist(applicationName, commandName);
  }

  public static int countCommandsStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countCommandsStartingWithName(namePrefix);
  }

  public static int countCommandsStartingWithName(@NotNull String applicationName, @NotNull String commandNamePrefix) {
    return getParsableScriptHelper().countCommandsStartingWithName(applicationName, commandNamePrefix);
  }

  @Nullable
  public static List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String commandName) {
    return getParsableScriptHelper().findCommands(project, commandName);
  }

  @Nullable
  public static List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String applicationName,
                                                      @NotNull String commandName) {
    return getParsableScriptHelper().findCommands(project, applicationName, commandName);
  }

  public static boolean isPropertyExist(@NotNull String name) {
    return getParsableScriptHelper().isPropertyExist(name);
  }

  public static boolean isPropertyExist(@NotNull String applicationName, @NotNull String propertyName) {
    return getParsableScriptHelper().isPropertyExist(applicationName, propertyName);
  }

  public static int countPropertiesStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countPropertiesStartingWithName(namePrefix);
  }

  public static int countPropertiesStartingWithName(@NotNull String applicationName, @NotNull String
          propertyNamePrefix) {
    return getParsableScriptHelper().countPropertiesStartingWithName(applicationName, propertyNamePrefix);
  }

  public static boolean isConstantExist(@NotNull String name) {
    return getParsableScriptHelper().isConstantExist(name);
  }

  public static boolean isConstantExist(@NotNull String applicationName, @NotNull String constantName) {
    return getParsableScriptHelper().isConstantExist(applicationName, constantName);
  }

  public static int countConstantStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countConstantStartingWithName(namePrefix);
  }

  public static int countConstantStartingWithName(@NotNull String applicationName, @NotNull String constantNamePrefix) {
    return getParsableScriptHelper().countConstantStartingWithName(applicationName, constantNamePrefix);
  }
}
