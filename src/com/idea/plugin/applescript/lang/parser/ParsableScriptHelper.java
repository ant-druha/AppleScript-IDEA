package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ParsableScriptHelper {

  // Application classes
  boolean isClassExist(@NotNull String name);

  boolean isClassExist(@NotNull String applicationName, @NotNull String className);

  boolean isClassWithPluralNameExist(@NotNull String pluralName);

  boolean isClassWithPluralNameExist(@NotNull String applicationName, @NotNull String pluralClassName);

  int countClassesStartingWithName(@NotNull String namePrefix);

  int countClassesStartingWithName(@NotNull String applicationName, @NotNull String classNamePrefix);

  int countClassesStartingWithPluralName(@NotNull String namePrefix);

  int countClassesStartingWithPluralName(@NotNull String applicationName, @NotNull String pluralClassNamePrefix);

  // Application commands
  boolean isCommandExist(@NotNull String name);

  boolean isCommandExist(@NotNull String applicationName, @NotNull String commandName);

  int countCommandsStartingWithName(@NotNull String namePrefix);

  int countCommandsStartingWithName(@NotNull String applicationName, @NotNull String commandNamePrefix);

  @NotNull
  List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String commandName);

  @NotNull
  List<AppleScriptCommand> findCommands(@NotNull Project project, @NotNull String applicationName,
                                        @NotNull String commandName);

  // Application properties
  boolean isPropertyExist(@NotNull String name);

  boolean isPropertyExist(@NotNull String applicationName, @NotNull String propertyName);

  int countPropertiesStartingWithName(@NotNull String namePrefix);

  int countPropertiesStartingWithName(@NotNull String applicationName, @NotNull String propertyNamePrefix);


  // Application constants (enumerators)
  boolean isConstantExist(@NotNull String name);

  boolean isConstantExist(@NotNull String applicationName, @NotNull String constantName);

  int countConstantStartingWithName(@NotNull String namePrefix);

  int countConstantStartingWithName(@NotNull String applicationName, @NotNull String constantNamePrefix);

}
