package com.intellij.plugin.applescript.lang.util;

import com.intellij.plugin.applescript.lang.parser.AppleScriptParserDefinition;
import com.intellij.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

import static com.intellij.plugin.applescript.psi.AppleScriptTokenTypesSets.HANDLER_DEFINITIONS;

/**
 * Andrey 20.06.2015
 */
public class ScopeUtil {
  @Nullable
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
