package com.intellij.plugin.applescript.lang.ide.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.patterns.StandardPatterns;
import com.intellij.plugin.applescript.AppleScriptFile;
import com.intellij.plugin.applescript.psi.AppleScriptTokenTypesSets;
import com.intellij.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 * Created by Andrey on 16/12/15.
 */
public class KeywordCompletionContributor extends CompletionContributor {

  public KeywordCompletionContributor() {

    extend(CompletionType.BASIC, psiElement().inFile(StandardPatterns.instanceOf(AppleScriptFile.class)),
            new CompletionProvider<CompletionParameters>() {
              @Override
              protected void addCompletions(@NotNull CompletionParameters completionParameters,
                                            ProcessingContext processingContext,
                                            @NotNull CompletionResultSet completionResultSet) {
                PsiFile file = completionParameters.getOriginalFile();
                if (!(file instanceof AppleScriptFile)) return;
                PsiElement position = completionParameters.getPosition();
                if (position instanceof PsiComment) return;

                ASTNode node = position.getNode();
                if (node.getElementType() == AppleScriptTypes.STRING_LITERAL) return;

                for (IElementType kwElem : AppleScriptTokenTypesSets.KEYWORDS.getTypes()) {
                  completionResultSet.addElement(LookupElementBuilder
                          .create(kwElem.toString().toLowerCase().replaceAll("_", " ")).bold()
                          .withTypeText("keyword", true));
                }
              }
            });
  }
}
