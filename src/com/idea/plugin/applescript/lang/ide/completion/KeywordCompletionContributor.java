package com.idea.plugin.applescript.lang.ide.completion;

import com.idea.plugin.applescript.AppleScriptFile;
import com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.StandardPatterns;
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

                for (IElementType kwElem : AppleScriptTokenTypesSets.KEYWORDS.getTypes()) {
                  completionResultSet.addElement(LookupElementBuilder.create(kwElem.toString())
                          .withTypeText("keyword", true));
                }
              }
            });
  }
}
