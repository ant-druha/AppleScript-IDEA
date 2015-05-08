/*
 * Copyright (C) 2014, Cast & Crew (R) Software, LLC
 * All rights reserved.  Unauthorized disclosure or distribution is prohibited.
 */
package com.idea.plugin.applescript.highlighter;

import com.idea.plugin.applescript.lang.lexer._AppleScriptLexer;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets.*;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

public class AppleScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static {
        fillMap(ATTRIBUTES, OPERATORS, AppleScriptSyntaxHighlighterColors.OPERATION_SIGN);
        fillMap(ATTRIBUTES, KEYWORDS, AppleScriptSyntaxHighlighterColors.KEYWORD);
        fillMap(ATTRIBUTES, STRINGS, AppleScriptSyntaxHighlighterColors.STRING);
        fillMap(ATTRIBUTES, NUMBERS, AppleScriptSyntaxHighlighterColors.NUMBER);
        ATTRIBUTES.put(COMMENT, AppleScriptSyntaxHighlighterColors.COMMENT);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new _AppleScriptLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
