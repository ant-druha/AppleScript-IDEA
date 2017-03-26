package com.intellij.plugin.applescript;

import com.intellij.lexer.FlexAdapter;
import com.intellij.plugin.applescript.lang.lexer._AppleScriptLexer;

/**
 * Andrey 22.02.2015
 */
public class AppleScriptLexerAdapter extends FlexAdapter {
  public AppleScriptLexerAdapter() {
    super(new _AppleScriptLexer(null));
  }
}