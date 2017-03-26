package com.intellij.plugin.applescript.test.lexer;

import com.intellij.plugin.applescript.AppleScriptLexerAdapter;
import com.intellij.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import junit.framework.TestCase;

/**
 * Created by Andrey on 02/01/16.
 */
public class AppleScriptLexerTest extends TestCase {
  public void testLexerTest() {
    AppleScriptLexerAdapter lexer = new AppleScriptLexerAdapter();
    CharSequence ch = "the \"My string\"";
    lexer.start(ch);
    IElementType tt = lexer.getTokenType();
    assertTrue(tt == AppleScriptTypes.THE_KW);
    lexer.advance();
    tt = lexer.getTokenType();
    assertTrue(tt == TokenType.WHITE_SPACE);
    lexer.advance();
    tt = lexer.getTokenType();
    assertTrue(tt == AppleScriptTypes.STRING_LITERAL);
  }
}