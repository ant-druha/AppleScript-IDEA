package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptDictionarySystemRegistryService;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Andrey on 01.07.2015.
 */
public class ParsableScriptSuiteRegistryHelper {

  private static ParsableScriptHelper scriptHelper;

  private static ParsableScriptHelper getParsableScriptHelper() {
    scriptHelper = scriptHelper != null ? scriptHelper :
            ServiceManager.getService(AppleScriptDictionarySystemRegistryService.class);
    return scriptHelper;
  }

  public static boolean ensureDictionaryInitialized(@NotNull String applicationName) {
    return getParsableScriptHelper().ensureDictionaryInitialized(applicationName);
  }

  public static boolean isStdLibClass(@NotNull String name) {
    return getParsableScriptHelper().isStdLibClass(name);
  }

  public static boolean isApplicationClass(@NotNull String applicationName, @NotNull String className) {
    return getParsableScriptHelper().isApplicationClass(applicationName, className);
  }

  public static boolean isStdLibClassPluralName(@NotNull String pluralName) {
    return getParsableScriptHelper().isStdLibClassPluralName(pluralName);
  }

  public static boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName) {
    return getParsableScriptHelper().isApplicationClassPluralName(applicationName, pluralClassName);
  }

  public static int countStdClassesStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countStdClassesStartingWithName(namePrefix);
  }

  public static int countApplicationClassesStartingWithName(@NotNull String applicationName,
                                                            @NotNull String classNamePrefix) {
    return getParsableScriptHelper().countApplicationClassesStartingWithName(applicationName, classNamePrefix);
  }

  public static int countStdClassesStartingWithPluralName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countStdClassesStartingWithPluralName(namePrefix);
  }

  public static int countApplicationClassesStartingWithPluralName(@NotNull String applicationName,
                                                                  @NotNull String pluralClassNamePrefix) {
    return getParsableScriptHelper().countApplicationClassesStartingWithPluralName(applicationName,
            pluralClassNamePrefix);
  }

  public static boolean isStdCommand(@NotNull String name) {
    return getParsableScriptHelper().isStdCommand(name);
  }

  public static boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName) {
    return getParsableScriptHelper().isApplicationCommand(applicationName, commandName);
  }

  public static int countStdCommandsStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countStdCommandsStartingWithName(namePrefix);
  }

  public static int countApplicationCommandsStartingWithName(@NotNull String applicationName,
                                                             @NotNull String commandNamePrefix) {
    return getParsableScriptHelper().countApplicationCommandsStartingWithName(applicationName, commandNamePrefix);
  }

  @NotNull
  public static List<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName) {
    return getParsableScriptHelper().findStdCommands(project, commandName);
  }

  @NotNull
  public static List<AppleScriptCommand> findApplicationCommands(@NotNull Project project,
                                                                 @NotNull String applicationName,
                                                                 @NotNull String commandName) {
    return getParsableScriptHelper().findApplicationCommands(project, applicationName, commandName);
  }

  public static boolean isStdProperty(@NotNull String name) {
    return getParsableScriptHelper().isStdProperty(name);
  }

  public static boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName) {
    return getParsableScriptHelper().isApplicationProperty(applicationName, propertyName);
  }

  public static int countStdPropertiesStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countStdPropertiesStartingWithName(namePrefix);
  }

  public static int countApplicationPropertiesStartingWithName(@NotNull String applicationName,
                                                               @NotNull String propertyNamePrefix) {
    return getParsableScriptHelper().countApplicationPropertiesStartingWithName(applicationName, propertyNamePrefix);
  }

  public static boolean isStdConstant(@NotNull String name) {
    return getParsableScriptHelper().isStdConstant(name);
  }

  public static boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName) {
    return getParsableScriptHelper().isApplicationConstant(applicationName, constantName);
  }

  public static int countStdConstantStartingWithName(@NotNull String namePrefix) {
    return getParsableScriptHelper().countStdConstantStartingWithName(namePrefix);
  }

  public static int countApplicationConstantStartingWithName(@NotNull String applicationName,
                                                             @NotNull String constantNamePrefix) {
    return getParsableScriptHelper().countApplicationConstantStartingWithName(applicationName, constantNamePrefix);
  }
}
