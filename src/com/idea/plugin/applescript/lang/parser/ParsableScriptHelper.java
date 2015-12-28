package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public interface ParsableScriptHelper {

  /**
   * Does not perform initialization for application which name was not discovered in standard paths at start
   * Condition is needed for the calls from the parser so not to try to initialize not yet completed by the user
   * application names
   *
   * @param knownApplicationName Name of the application
   * @return true if dictionary for the application was initialized
   */
  boolean ensureKnownApplicationDictionaryInitialized(@NotNull String knownApplicationName);

  // Application classes
  boolean isStdLibClass(@NotNull String name);

  boolean isApplicationClass(@NotNull String applicationName, @NotNull String className);

  boolean isStdLibClassPluralName(@NotNull String pluralName);

  boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName);

  boolean isStdClassWithPrefixExist(@NotNull String classNamePrefix);

  boolean isClassWithPrefixExist(@NotNull String applicationName, @NotNull String classNamePrefix);

  boolean isStdClassPluralWithPrefixExist(@NotNull String namePrefix);

  boolean isClassPluralWithPrefixExist(@NotNull String applicationName, @NotNull String pluralClassNamePrefix);


  // Application commands
  boolean isStdCommand(@NotNull String name);

  boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName);

  boolean isCommandWithPrefixExist(@NotNull String applicationName, @NotNull String commandNamePrefix);

  boolean isStdCommandWithPrefixExist(@NotNull String namePrefix);

  @NotNull
  Collection<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName);

  @NotNull
  List<AppleScriptCommand> findApplicationCommands(@NotNull Project project, @NotNull String applicationName,
                                                   @NotNull String commandName);

  // Application properties
  boolean isStdProperty(@NotNull String name);

  boolean isStdPropertyWithPrefixExist(@NotNull String namePrefix);

  boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName);

  boolean isPropertyWithPrefixExist(@NotNull String applicationName, @NotNull String propertyNamePrefix);


  // Application constants (enumerators)
  boolean isStdConstant(@NotNull String name);

  boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName);

  boolean isStdConstantWithPrefixExist(@NotNull String namePrefix);

  boolean isConstantWithPrefixExist(@NotNull String applicationName, @NotNull String namePrefix);

  @NotNull
  HashSet<String> getScriptingAdditions();
}
