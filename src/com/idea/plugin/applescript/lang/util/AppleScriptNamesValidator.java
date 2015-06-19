package com.idea.plugin.applescript.lang.util;

import com.idea.plugin.applescript.AppleScriptLexerAdapter;
import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets;
import com.idea.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.ide.DataManager;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.refactoring.rename.PsiElementRenameHandler;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 18.06.2015.
 */
public class AppleScriptNamesValidator implements NamesValidator {
  @Override
  public boolean isKeyword(@NotNull String name, Project project) {
    return isKeyword(name);
  }

  private boolean isKeyword(String name) {
    IElementType tokenType = getTokenType(name);
    return AppleScriptTokenTypesSets.KEYWORDS.contains(tokenType);
  }

  private IElementType getTokenType(String name) {
    AppleScriptLexerAdapter lexer = new AppleScriptLexerAdapter();
    lexer.start(name);
    IElementType tt = lexer.getTokenType();
    lexer.advance();
    return lexer.getTokenType() == null ? tt : null;
  }

  @Override
  public boolean isIdentifier(@NotNull String name, Project project) {
    //todo remove this hack (via rename handler and change signature refactoring...)
    return isRenamingHandlerWithValidName(name, project) || isIdentifier(name);
  }

  private boolean isRenamingHandlerWithValidName(@NotNull String name, Project project) {
    PsiElement elementToRename;
    String oldName;
    Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
    if (editor != null) {
      DataContext dataContext = DataManager.getInstance().getDataContext(editor.getComponent());
      elementToRename = PsiElementRenameHandler.getElement(dataContext);
      if (elementToRename instanceof AppleScriptHandler) {
        oldName = ((AppleScriptHandler) elementToRename).getName();
        final String[] newParts = name.split(":");
        final String[] oldParts = oldName != null ? oldName.split(":") : null;
        if (oldParts == null || oldParts.length != newParts.length) {
          return false;
        }
        for (String part : newParts) {
          if (!isIdentifier(part)) {
            return false;
          }
        }
        return true;
      } else
        return false;
    } else
      return false;
  }

//  private PsiElement getHandlerDefinitionOrCallContext(PsiElement element) {
//    PsiElement selectorPart = null;
//    if (isIdentifier(element.getText())) {
//      PsiElement context = element.getContext();
//      PsiElement selectorId = context != null ? context.getContext() : null;
//      selectorPart = selectorId != null ? selectorId.getContext() : null;
//    } else if (element.getNode().getElementType() == AppleScriptTypes.COLON) {
//      selectorPart = element.getContext();
//      if (selectorPart instanceof AppleScriptArgumentSelector) {
//        selectorPart = selectorPart.getContext(); //for handler call..
//      }
//    }
//    return selectorPart != null ? selectorPart.getContext() : null;
//  }

  private boolean isIdentifier(String name) {
    return getTokenType(name) == AppleScriptTypes.VAR_IDENTIFIER; //todo check all variants
  }
}
