package com.idea.plugin.applescript.psi.impl;

import com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets;
import com.intellij.lang.ASTNode;

/**
 * Created by Andrey on 09.04.2015.
 */
public class PsiImplUtil {
    public static boolean isWhiteSpaceOrNls(ASTNode node) {
        return node != null && AppleScriptTokenTypesSets.WHITE_SPACES_SET.contains(node.getElementType());
    }
}
