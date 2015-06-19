package com.idea.plugin.applescript.lang.util;

import com.idea.plugin.applescript.AppleScriptLexerAdapter;
import com.idea.plugin.applescript.psi.*;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.tree.IElementType;
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
    //todo remove this dirty hack
    Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
    if (editor != null) {
      VirtualFile virtualFile = FileDocumentManager.getInstance().getFile(editor.getDocument());
      if (virtualFile != null) {
        PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
        if (psiFile != null) {
          int currOffset = editor.getCaretModel().getOffset();
          PsiElement element = psiFile.findElementAt(currOffset);
          PsiElement handler = getHandlerDefinitionOrCallContext(element);
          String oldName = null;
          if (handler instanceof AppleScriptHandler) {
            oldName = ((AppleScriptHandler) handler).getName();
          } else if (handler instanceof AppleScriptHandlerCall) {
            oldName = ((AppleScriptHandlerCall) handler).getHandlerSelector();
          }
          final String[] newParts = name.split(":");
          final String[] oldParts = oldName != null ? oldName.split(":") : null;
          if (oldParts == null || oldParts.length != newParts.length) {
            return isIdentifier(name);
          }
          for (String part : newParts) {
            if (!isIdentifier(part)) {
              return isIdentifier(name);
            }
          }
          return true;
        }
      }
      return isIdentifier(name);
    } else
      return isIdentifier(name);

  }

  private PsiElement getHandlerDefinitionOrCallContext(PsiElement element) {
    PsiElement selectorPart = null;
    if (isIdentifier(element.getText())) {
      PsiElement context = element.getContext();
      PsiElement selectorId = context != null ? context.getContext() : null;
      selectorPart = selectorId != null ? selectorId.getContext() : null;
    } else if (element.getNode().getElementType() == AppleScriptTypes.COLON) {
      selectorPart = element.getContext();
      if (selectorPart instanceof AppleScriptArgumentSelector) {
        selectorPart = selectorPart.getContext(); //for handler call..
      }
    }
    return selectorPart != null ? selectorPart.getContext() : null;
  }

  private boolean isIdentifier(String name) {
    return getTokenType(name) == AppleScriptTypes.VAR_IDENTIFIER; //todo check all variants
  }
}
