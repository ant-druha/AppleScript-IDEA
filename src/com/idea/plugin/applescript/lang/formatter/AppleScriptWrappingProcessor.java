package com.idea.plugin.applescript.lang.formatter;

import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;

import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Created by Andrey on 12.04.2015.
 */
public class AppleScriptWrappingProcessor {
    private final ASTNode myNode;
    private final CommonCodeStyleSettings mySettings;

    public AppleScriptWrappingProcessor(ASTNode node, CommonCodeStyleSettings commonSettings) {
        myNode = node;
        mySettings = commonSettings;
    }

    Wrap createChildWrap(ASTNode child, Wrap defaultWrap, Wrap childWrap){
        final IElementType childType = child.getElementType();
        final IElementType elementType = myNode.getElementType();

        if (childType == COMMA) return defaultWrap;

        return defaultWrap;
    }
}
