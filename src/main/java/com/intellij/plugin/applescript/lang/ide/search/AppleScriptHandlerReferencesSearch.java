package com.intellij.plugin.applescript.lang.ide.search;

import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.application.Result;
import com.intellij.plugin.applescript.psi.AppleScriptHandler;
import com.intellij.plugin.applescript.psi.AppleScriptHandlerCall;
import com.intellij.plugin.applescript.psi.AppleScriptHandlerSelectorPart;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.search.TextOccurenceProcessor;
import com.intellij.psi.search.UsageSearchContext;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import com.intellij.util.QueryExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Andrey 07.06.2015
 */
public class AppleScriptHandlerReferencesSearch implements QueryExecutor<PsiReference, ReferencesSearch.SearchParameters> {
  @Override
  public boolean execute(@NotNull final ReferencesSearch.SearchParameters queryParameters, @NotNull final
  Processor<PsiReference> consumer) {
    return new ReadAction<Boolean>() {
      protected void run(@NotNull final Result<Boolean> result) {
        result.setResult(doExecute(queryParameters, consumer));
      }
    }.execute().getResultObject();
  }

  private Boolean doExecute(ReferencesSearch.SearchParameters queryParameters, final Processor<PsiReference> consumer) {
    // the element which is gets returned is first immediate PsiNamedElement in the hierarchy of the element under the
    // caret (as with the find usages)
    // extension posts to redefine this (so that declarationPart resolved the whole method) are:
    // 1. com.intellij.codeInsight.TargetElementEvaluator#getElementByReference(ref, flags)/getNamedElement
    // (TargetElementEvaluatorEx2)
    // 2. com.intellij.pom.PomDeclarationSearcher#findDeclarationsAt
    // 3...
    final PsiElement element = queryParameters.getElementToSearch(); //was selector_identifier->redefined in
    // pomDeclarationSearcher to
    // the handler declaration
    AppleScriptHandler handler = null;
    if (element instanceof AppleScriptHandler) {
      handler = (AppleScriptHandler) element;
    }
//    else if (element instanceof AppleScriptSelectorId) {
//      //never here now (redefined in pomDeclarationSearcher)
//      contextElement = element.getContext() != null ? element.getContext().getContext() : null;
//      if (contextElement instanceof AppleScriptHandler) {
//        handler = (AppleScriptHandler) contextElement;
//      }
//    }

    if (handler == null) return true;

    final List<AppleScriptHandlerSelectorPart> parts = handler.getParameters();
    if (parts.isEmpty())
      return true;
    final String handlerSelector = handler.getSelector(); //or just getName()...
    final PsiSearchHelper helper = PsiSearchHelper.SERVICE.getInstance(element.getProject());


    String firstSelector = parts.get(0).getSelectorPart();

    String searchWord = firstSelector.endsWith(":") ? firstSelector.substring(0, firstSelector.length() - 1) :
            firstSelector;

    return searchWord.isEmpty() || helper.processElementsWithWord(new MyOccurrenceProcessor(handler, handlerSelector,
            consumer), queryParameters.getEffectiveSearchScope(), searchWord, UsageSearchContext.IN_CODE, true);

  }

  private static class MyOccurrenceProcessor implements TextOccurenceProcessor {
    private final Processor<PsiReference> myConsumer;
    private AppleScriptHandler myHandler;
    private String myHandlerSelector;

    MyOccurrenceProcessor(AppleScriptHandler handler, String handlerSelector,
                          Processor<PsiReference> consumer) {
      myHandler = handler;
      myHandlerSelector = handlerSelector;
      myConsumer = consumer;
    }

    @Override
    public boolean execute(@NotNull PsiElement element, int offsetInElement) {
      String selector;
      if (element instanceof AppleScriptHandlerCall) {
        AppleScriptHandlerCall handlerCall = (AppleScriptHandlerCall) element;
        selector = handlerCall.getHandlerSelector();
        if (myHandlerSelector.equals(selector)) {
          for (PsiReference ref : element.getReferences()) {
            if (ref.isReferenceTo(myHandler)) {
              return myConsumer.process(ref);
            }
          }
        }
      }
      return true;
    }
  }
}
