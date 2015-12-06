package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistryService;
import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Andrey 01.07.2015
 */
public class ParsableScriptSuiteRegistryHelper {

  private static ParsableScriptHelper scriptHelper;

  private static ParsableScriptHelper getParsableScriptHelper() {
    scriptHelper = scriptHelper != null ? scriptHelper :
            ServiceManager.getService(AppleScriptSystemDictionaryRegistryService.class);
    return scriptHelper;
  }

  public static boolean ensureKnownApplicationInitialized(@NotNull String applicationName) {
    return getParsableScriptHelper().ensureKnownApplicationDictionaryInitialized(applicationName);
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

  public static boolean isStdClassWithPrefixExist(@NotNull String classNamePrefix) {
    return getParsableScriptHelper().isStdClassWithPrefixExist(classNamePrefix);
  }

  public static boolean isClassWithPrefixExist(@NotNull String applicationName, @NotNull String classNamePrefix) {
    return getParsableScriptHelper().isClassWithPrefixExist(applicationName, classNamePrefix);
  }

  public static boolean isStdClassPluralWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdClassPluralWithPrefixExist(namePrefix);
  }

  public static boolean isClassPluralWithPrefixExist(@NotNull String applicationName, @NotNull String
          pluralClassNamePrefix) {
    return getParsableScriptHelper().isClassPluralWithPrefixExist(applicationName, pluralClassNamePrefix);
  }

  public static boolean isStdCommand(@NotNull String name) {
    return getParsableScriptHelper().isStdCommand(name);
  }

  public static boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName) {
    return getParsableScriptHelper().isApplicationCommand(applicationName, commandName);
  }

  public static boolean isCommandWithPrefixExist(@NotNull String applicationName, @NotNull String commandNamePrefix) {
    return getParsableScriptHelper().isCommandWithPrefixExist(applicationName, commandNamePrefix);
  }

  public static boolean isStdCommandWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdCommandWithPrefixExist(namePrefix);
  }

  @NotNull
  public static Collection<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName) {
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

  public static boolean isStdPropertyWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdPropertyWithPrefixExist(namePrefix);
  }

  public static boolean isPropertyWithPrefixExist(@NotNull String applicationName,
                                                  @NotNull String propertyNamePrefix) {
    return getParsableScriptHelper().isPropertyWithPrefixExist(applicationName, propertyNamePrefix);
  }

  public static boolean isStdConstant(@NotNull String name) {
    return getParsableScriptHelper().isStdConstant(name);
  }

  public static boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName) {
    return getParsableScriptHelper().isApplicationConstant(applicationName, constantName);
  }

  public static boolean isStdConstantWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdConstantWithPrefixExist(namePrefix);
  }

  public static boolean isConstantWithPrefixExist(@NotNull String applicationName,
                                                  @NotNull String constantNamePrefix) {
    return getParsableScriptHelper().isConstantWithPrefixExist(applicationName, constantNamePrefix);
  }
}
