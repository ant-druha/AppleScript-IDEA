package com.idea.plugin.applescript;

import com.idea.plugin.applescript.lang.lexer._AppleScriptLexer;
import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by Andrey on 22.02.2015.
 */
public class AppleScriptLexerAdapter extends FlexAdapter {
    public AppleScriptLexerAdapter() {
        super(new _AppleScriptLexer((Reader) null));
    }
}