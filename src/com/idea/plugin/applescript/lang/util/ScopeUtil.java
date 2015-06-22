package com.idea.plugin.applescript.lang.util;

import com.idea.plugin.applescript.lang.parser.AppleScriptParserDefinition;
import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.idea.plugin.applescript.psi.AppleScriptTargetVariable;
import com.idea.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

import static com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets.HANDLER_DEFINITIONS;

/**
 * Created by Andrey on 20.06.2015.
 */
public class ScopeUtil {
  public static PsiElement getMaxLocalScopeForTargetOrReference(PsiElement element) {
    if (element == null) {
      return null;
    }
    PsiElement currentScope;
    if (element instanceof AppleScriptTargetVariable
            || element instanceof AppleScriptReferenceElement) {
      //local scope: handler definition, current file, object declaration
      currentScope = element.getContext();
      boolean roofReached = false;
      while (!roofReached && currentScope != null) {
        IElementType elementType = currentScope.getNode().getElementType();
        roofReached = HANDLER_DEFINITIONS.contains(elementType)
                || elementType == AppleScriptParserDefinition.FILE
                || element == AppleScriptTypes.OBJECT_TARGET_PROPERTY_DECLARATION;//todo to check this
        currentScope = roofReached ? currentScope : currentScope.getContext();
      }
      return currentScope;
    }
    return null;
  }
}
