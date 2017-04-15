package com.intellij.plugin.applescript.lang.parser;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistryService;
import com.intellij.plugin.applescript.lang.sdef.AppleScriptCommand;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Andrey 01.07.2015
 */
public class ParsableScriptSuiteRegistryHelper {

  private static ParsableScriptHelper scriptHelper;

  private static ParsableScriptHelper getParsableScriptHelper() {
    scriptHelper = scriptHelper != null ? scriptHelper : ServiceManager.getService(AppleScriptSystemDictionaryRegistryService.class);
    return scriptHelper;
  }

  static boolean ensureKnownApplicationInitialized(@NotNull String applicationName) {
    return getParsableScriptHelper().ensureKnownApplicationDictionaryInitialized(applicationName);
  }

  static boolean isStdLibClass(@NotNull String name) {
    return getParsableScriptHelper().isStdLibClass(name);
  }

  static boolean isApplicationClass(@NotNull String applicationName, @NotNull String className) {
    return getParsableScriptHelper().isApplicationClass(applicationName, className);
  }

  static boolean isStdLibClassPluralName(@NotNull String pluralName) {
    return getParsableScriptHelper().isStdLibClassPluralName(pluralName);
  }

  static boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName) {
    return getParsableScriptHelper().isApplicationClassPluralName(applicationName, pluralClassName);
  }

  static boolean isStdClassWithPrefixExist(@NotNull String classNamePrefix) {
    return getParsableScriptHelper().isStdClassWithPrefixExist(classNamePrefix);
  }

  static boolean isClassWithPrefixExist(@NotNull String applicationName, @NotNull String classNamePrefix) {
    return getParsableScriptHelper().isClassWithPrefixExist(applicationName, classNamePrefix);
  }

  static boolean isStdClassPluralWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdClassPluralWithPrefixExist(namePrefix);
  }

  static boolean isClassPluralWithPrefixExist(@NotNull String applicationName, @NotNull String
      pluralClassNamePrefix) {
    return getParsableScriptHelper().isClassPluralWithPrefixExist(applicationName, pluralClassNamePrefix);
  }

  static boolean isStdCommand(@NotNull String name) {
    return getParsableScriptHelper().isStdCommand(name);
  }

  static boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName) {
    return getParsableScriptHelper().isApplicationCommand(applicationName, commandName);
  }

  static boolean isCommandWithPrefixExist(@NotNull String applicationName, @NotNull String commandNamePrefix) {
    return getParsableScriptHelper().isCommandWithPrefixExist(applicationName, commandNamePrefix);
  }

  static boolean isStdCommandWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdCommandWithPrefixExist(namePrefix);
  }

  @NotNull
  static Collection<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName) {
    return getParsableScriptHelper().findStdCommands(project, commandName);
  }

  @NotNull
  static List<AppleScriptCommand> findApplicationCommands(@NotNull Project project,
                                                          @NotNull String applicationName,
                                                          @NotNull String commandName) {
    return getParsableScriptHelper().findApplicationCommands(project, applicationName, commandName);
  }

  static boolean isStdProperty(@NotNull String name) {
    return getParsableScriptHelper().isStdProperty(name);
  }

  static boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName) {
    return getParsableScriptHelper().isApplicationProperty(applicationName, propertyName);
  }

  static boolean isStdPropertyWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdPropertyWithPrefixExist(namePrefix);
  }

  static boolean isPropertyWithPrefixExist(@NotNull String applicationName,
                                           @NotNull String propertyNamePrefix) {
    return getParsableScriptHelper().isPropertyWithPrefixExist(applicationName, propertyNamePrefix);
  }

  static boolean isStdConstant(@NotNull String name) {
    return getParsableScriptHelper().isStdConstant(name);
  }

  static boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName) {
    return getParsableScriptHelper().isApplicationConstant(applicationName, constantName);
  }

  static boolean isStdConstantWithPrefixExist(@NotNull String namePrefix) {
    return getParsableScriptHelper().isStdConstantWithPrefixExist(namePrefix);
  }

  static boolean isConstantWithPrefixExist(@NotNull String applicationName,
                                           @NotNull String constantNamePrefix) {
    return getParsableScriptHelper().isConstantWithPrefixExist(applicationName, constantNamePrefix);
  }

  public static HashSet<String> getScriptingAdditions() {
    return getParsableScriptHelper().getScriptingAdditions();
  }
}
