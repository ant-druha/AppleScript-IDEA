package com.intellij.plugin.applescript;

/**
 * Andrey 04.05.2015
 */
public class AppleScriptNames {

  public static final String UNNAMED_ELEMENT = "<unnamed>";

  public static boolean isIdentifierStart(char c) {
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '|';
  }
}
