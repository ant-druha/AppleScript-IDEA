package com.idea.plugin.applescript.lang.ide.completion;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 16/12/15.
 */
public class Keyw-ordCompletionContributor extends CompletionContributor{

public KeywordCompletionContributor(){

        extend(CompletionType.BASIC,psiElement().inFile(StandardPatterns.instanceOf(AppleScriptFile.class)),
        new CompletionProvider<CompletionParameters>(){
@Override
protected void addCompletions(@NotNull CompletionParameters completionParameters,
        ProcessingContext processingContext,
@NotNull CompletionResultSet completionResultSet){
        PsiFile file=completionParameters.getOriginalFile();
        if(!(file instanceof AppleScriptFile))return;
        PsiElement position=completionParameters.getPosition();
        if(position instanceof PsiComment)return;

        for(IElementType kwElem:AppleScriptTokenTypesSets.KEYWORDS.getTypes()){

        completionResultSet.addElement(LookupElementBuilder.create(kwElem.toString())
        .withTypeText("keyword",true));
        }

        }
        });
        }
        }
