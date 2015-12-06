package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;

/**
 * Andrey 09.07.2015
 */
public abstract class PsiType {
  /**
   * Value class definitions contain information about values that belong to a particular class. All value classes
   * fall into one of two categories: simple values, such as integers and real numbers, which do not contain other
   * values, or composite values, such as lists and records, which do
   */
  public static final AppleScriptBuiltInType BOOLEAN = new AppleScriptBuiltInType("boolean");
  public static final AppleScriptBuiltInType CLASS = new AppleScriptBuiltInType("class");

  @NotNull String typeName;

  public PsiType(@NotNull String typeName) {
    this.typeName = typeName;
  }

  @NotNull
  public String getTypeName() {
    return typeName;
  }


  private static class AppleScriptBuiltInType extends PsiType {
    public AppleScriptBuiltInType(String className) {
      super(className);
    }
  }
}
