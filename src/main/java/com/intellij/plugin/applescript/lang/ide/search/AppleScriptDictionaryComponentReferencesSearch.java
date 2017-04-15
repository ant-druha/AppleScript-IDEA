package com.intellij.plugin.applescript.lang.ide.search;

import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.application.Result;
import com.intellij.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.intellij.plugin.applescript.psi.sdef.DictionaryCompositeElement;
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
public class AppleScriptDictionaryComponentReferencesSearch implements QueryExecutor<PsiReference, ReferencesSearch
        .SearchParameters> {
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
    final PsiElement element = queryParameters.getElementToSearch(); //was selector_identifier->redefined in
    DictionaryComponent dictionaryComponent = null;
    if (element instanceof DictionaryComponent) {
      dictionaryComponent = (DictionaryComponent) element;
    }

    if (dictionaryComponent == null) return true;

    final List<String> parts = dictionaryComponent.getNameIdentifiers();
    if (parts.isEmpty())
      return true;
    final String componentName = dictionaryComponent.getName(); //or just getName()...
    final PsiSearchHelper helper = PsiSearchHelper.SERVICE.getInstance(element.getProject());

    String searchWord = parts.get(0);
    return searchWord.isEmpty() || helper.processElementsWithWord(new MyOccurrenceProcessor(dictionaryComponent, componentName, consumer), 
        queryParameters.getScopeDeterminedByUser(), searchWord, UsageSearchContext.IN_CODE, true);

  }

  private static class MyOccurrenceProcessor implements TextOccurenceProcessor {
    private final Processor<PsiReference> myConsumer;
    private final DictionaryComponent myDictionaryComponent;
    private final String myComponentName;

    public MyOccurrenceProcessor(DictionaryComponent dictionaryComponent, String componentName,
                                 Processor<PsiReference> consumer) {
      myDictionaryComponent = dictionaryComponent;
      myComponentName = componentName;
      myConsumer = consumer;
    }

    @Override
    public boolean execute(@NotNull PsiElement element, int offsetInElement) {
      String selector = null;
      if (element instanceof AppleScriptCommandHandlerCall) {
        AppleScriptCommandHandlerCall handlerCall = (AppleScriptCommandHandlerCall) element;
        selector = handlerCall.getCommandName();
      }//todo: handle other component types
      else if (element instanceof DictionaryCompositeElement) {
        DictionaryCompositeElement dictionaryCompositeElement = (DictionaryCompositeElement) element;
        selector = dictionaryCompositeElement.getCompositeNameElement().getCompositeName();
      }
      if (selector != null) {
        boolean selectorMatches;
        selectorMatches = myComponentName.equals(selector);
        if (selectorMatches) {
          for (PsiReference ref : element.getReferences()) {
            if (ref.isReferenceTo(myDictionaryComponent)) {
              return myConsumer.process(ref);
            }
          }
        }
      }
      return true;
    }
  }
}
