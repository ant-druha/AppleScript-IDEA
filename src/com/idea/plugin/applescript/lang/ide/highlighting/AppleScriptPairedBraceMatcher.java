package com.idea.plugin.applescript.lang.ide.highlighting;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.idea.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppleScriptPairedBraceMatcher extends PairedBraceMatcherAdapter {
  private static final BracePair[] PAIRS = new BracePair[]{
          new BracePair(AppleScriptTypes.ON, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.TELL, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.USING, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.TRY, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.IF, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.REPEAT, AppleScriptTypes.END, true),
          new BracePair(AppleScriptTypes.LCURLY, AppleScriptTypes.RCURLY, true),
          new BracePair(AppleScriptTypes.LPAREN, AppleScriptTypes.RPAREN, true),
  };

  TokenSet startOfBlockTokens = TokenSet.create(AppleScriptTypes.TELL, AppleScriptTypes.USE, AppleScriptTypes.TRY,
          AppleScriptTypes.IF, AppleScriptTypes.REPEAT);

  @Override
  public boolean isRBraceToken(HighlighterIterator iterator, CharSequence fileText, FileType fileType) {
    BracePair pair = findPair(false, iterator, fileText, fileType);
    if (pair == null) return false;
    if (pair.getRightBraceType() != AppleScriptTypes.END)
      return super.isRBraceToken(iterator, fileText, fileType);//true;

    boolean result = false;
    int count = 0;
    while (true) {
      iterator.retreat();
      count++;
      if (iterator.atEnd()) break;
      IElementType eType = iterator.getTokenType();
      if (eType == AppleScriptTypes.NLS || eType == AppleScriptTypes.BLOCK_BODY)
        result = true;
      else break;
    }
    while (count-- > 0) iterator.advance();
    return result;
//    return super.isRBraceToken(iterator, fileText, fileType);
  }

  @Override
  public boolean isLBraceToken(HighlighterIterator iterator, CharSequence fileText, FileType fileType) {
    BracePair pair = findPair(true, iterator, fileText, fileType);
    if (pair == null) return false;
    if (pair.getRightBraceType() != AppleScriptTypes.END) return true;

    boolean result = true;
    int count = 0;
    while (true) {
      iterator.retreat();
      count++;
      if (iterator.atEnd()) break;
      IElementType eType = iterator.getTokenType();

      if (eType == com.intellij.psi.TokenType.WHITE_SPACE) continue;

      if (eType == AppleScriptTypes.END) result = false;
      else break;
    }
    while (count-- > 0) iterator.advance();
    if (!result) return false;

    //check other cases: if/tell simple statement (have no end block). Will try first:
    // 1. <tell> if there is 'to' on the same line -> false
    if (pair.getLeftBraceType() == AppleScriptTypes.TELL) {
      count = 0;
      result = true;
      while (true) {
        iterator.advance();
        count++;
        if (iterator.atEnd()) break;
        IElementType eType = iterator.getTokenType();
        if (eType == AppleScriptTypes.TO)
          result = false;
        else if (eType == AppleScriptTypes.NLS) break;
      }
      while (count-- > 0) iterator.retreat();
      if (!result) return false;
    }

    // 2. <if> if there is 'then' on the same line -> false
    if (pair.getLeftBraceType() == AppleScriptTypes.IF) {
      count = 0;
      result = true;
      boolean thenKw = false;

      while (true) {
        iterator.advance();
        count++;
        if (iterator.atEnd()) break;
        IElementType eType = iterator.getTokenType();

        if (thenKw) {
          if (eType == AppleScriptTypes.COMMENT
                  || eType == com.intellij.psi.TokenType.WHITE_SPACE) continue;
          else if (eType == AppleScriptTypes.NLS) {
            break;
          } else {
            result = false;
            break;
          }
        }

        if (eType == AppleScriptTypes.THEN) {
          thenKw = true;
        }
      }
      while (count-- > 0) iterator.retreat();
      if (!result) return false;

      // else if -> if not counted
      count = 0;
      result = true;
      while (true) {
        iterator.retreat();
        count++;
        if (iterator.atEnd()) break;
        if (iterator.atEnd()) break;
        IElementType eType = iterator.getTokenType();

        if (eType == com.intellij.psi.TokenType.WHITE_SPACE) continue;

        if (eType == AppleScriptTypes.ELSE) result = false;
        else break;
      }
      while (count-- > 0) iterator.advance();
    }
    if (!result) return false;

    // on error -> not count
    if (pair.getLeftBraceType() == AppleScriptTypes.ON) {
      count = 0;
      result = true;

      while (true) {
        iterator.advance();
        count++;
        if (iterator.atEnd()) break;
        IElementType eType = iterator.getTokenType();

        if (eType == com.intellij.psi.TokenType.WHITE_SPACE) continue;
        if (eType == AppleScriptTypes.ERROR) result = false;
        else break;
      }
      while (count-- > 0) iterator.retreat();
    }
    return result;
//    return super.isLBraceToken(iterator, fileText, fileType);
  }

  public AppleScriptPairedBraceMatcher() {
    super(new MyPairedBraceMatcher(), AppleScriptLanguage.INSTANCE);
  }

  private static class MyPairedBraceMatcher implements PairedBraceMatcher {
    @Override
    public BracePair[] getPairs() {
      return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType
            contextType) {
      return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
      return openingBraceOffset;
    }
  }
}