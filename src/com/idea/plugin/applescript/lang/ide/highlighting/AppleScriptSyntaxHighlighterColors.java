/*
 * Copyright (C) 2014, Cast & Crew (R) Software, LLC
 * All rights reserved.  Unauthorized disclosure or distribution is prohibited.
 */
package com.idea.plugin.applescript.lang.ide.highlighting;


import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.ui.JBColor;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AppleScriptSyntaxHighlighterColors {
  public static final String APPLE_SCRIPT_KEYWORD = "APPLE_SCRIPT_KEYWORD";
  private static final String APPLE_SCRIPT_NUMBER = "APPLE_SCRIPT_NUMBER";
  private static final String APPLE_SCRIPT_STRING = "APPLE_SCRIPT_STRING";
  private static final String APPLE_SCRIPT_OPERATION_SIGN = "APPLE_SCRIPT_OPERATION_SIGN";
  private static final String APPLE_SCRIPT_COMMENT = "APPLE_SCRIPT_COMMENT";
  private static final String DICTIONARY_COMMAND = "DICTIONARY_COMMAND";
  private static final String DICTIONARY_CLASS = "DICTIONARY_CLASS";
  private static final String DICTIONARY_PROPERTY = "DICTIONARY_PROPERTY";
  private static final String UNRESOLVED_ACCESS_ID = "UNRESOLVED_REFERENCE";

  public static final TextAttributes UNRESOLVED_REFERENCE_ATTRIBUTES = HighlighterColors.TEXT.getDefaultAttributes()
          .clone();

  static {
    UNRESOLVED_REFERENCE_ATTRIBUTES.setForegroundColor(JBColor.BLACK);
    UNRESOLVED_REFERENCE_ATTRIBUTES.setEffectColor(JBColor.GRAY);
    UNRESOLVED_REFERENCE_ATTRIBUTES.setEffectType(EffectType.LINE_UNDERSCORE);
  }


  public static final TextAttributesKey KEYWORD =
          createTextAttributesKey(APPLE_SCRIPT_KEYWORD, DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey STRING =
          createTextAttributesKey(APPLE_SCRIPT_STRING, DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey NUMBER =
          createTextAttributesKey(APPLE_SCRIPT_NUMBER, DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey OPERATION_SIGN =
          createTextAttributesKey(APPLE_SCRIPT_OPERATION_SIGN, DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey COMMENT =
          createTextAttributesKey(APPLE_SCRIPT_COMMENT, DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey UNRESOLVED_REFERENCE =
          createTextAttributesKey(UNRESOLVED_ACCESS_ID, UNRESOLVED_REFERENCE_ATTRIBUTES);
  public static final TextAttributesKey DICTIONARY_COMMAND_ATTR =
          createTextAttributesKey(DICTIONARY_COMMAND, DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);
  public static final TextAttributesKey DICTIONARY_CLASS_ATTR =
          createTextAttributesKey(DICTIONARY_CLASS, DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey DICTIONARY_PROPERTY_ATTR =
          createTextAttributesKey(DICTIONARY_PROPERTY, DefaultLanguageHighlighterColors.INSTANCE_FIELD);


}
