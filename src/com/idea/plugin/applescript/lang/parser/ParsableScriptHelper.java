package com.idea.plugin.applescript.lang.parser;

import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ParsableScriptHelper {

  boolean ensureDictionaryInitialized(@NotNull String applicationName);

  // Application classes
  boolean isStdLibClass(@NotNull String name);

  boolean isApplicationClass(@NotNull String applicationName, @NotNull String className);

  boolean isStdLibClassPluralName(@NotNull String pluralName);

  boolean isApplicationClassPluralName(@NotNull String applicationName, @NotNull String pluralClassName);

  int countStdClassesStartingWithName(@NotNull String namePrefix);

  int countApplicationClassesStartingWithName(@NotNull String applicationName, @NotNull String classNamePrefix);

  int countStdClassesStartingWithPluralName(@NotNull String namePrefix);

  int countApplicationClassesStartingWithPluralName(@NotNull String applicationName,
                                                    @NotNull String pluralClassNamePrefix);

  // Application commands
  boolean isStdCommand(@NotNull String name);

  boolean isApplicationCommand(@NotNull String applicationName, @NotNull String commandName);

  int countStdCommandsStartingWithName(@NotNull String namePrefix);

  int countApplicationCommandsStartingWithName(@NotNull String applicationName, @NotNull String commandNamePrefix);

  @NotNull
  List<AppleScriptCommand> findStdCommands(@NotNull Project project, @NotNull String commandName);

  @NotNull
  List<AppleScriptCommand> findApplicationCommands(@NotNull Project project, @NotNull String applicationName,
                                                   @NotNull String commandName);

  // Application properties
  boolean isStdProperty(@NotNull String name);

  boolean isApplicationProperty(@NotNull String applicationName, @NotNull String propertyName);

  int countStdPropertiesStartingWithName(@NotNull String namePrefix);

  int countApplicationPropertiesStartingWithName(@NotNull String applicationName, @NotNull String propertyNamePrefix);


  // Application constants (enumerators)
  boolean isStdConstant(@NotNull String name);

  boolean isApplicationConstant(@NotNull String applicationName, @NotNull String constantName);

  int countStdConstantStartingWithName(@NotNull String namePrefix);

  int countApplicationConstantStartingWithName(@NotNull String applicationName, @NotNull String constantNamePrefix);

}
