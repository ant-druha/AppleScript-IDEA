package com.intellij.plugin.applescript.lang.ide.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistryService;
import com.intellij.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.plugin.applescript.psi.AppleScriptApplicationReference;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 * Andrey 15.10.2015
 */
public class ApplicationNameCompletionContributor extends CompletionContributor {

  @Override
  public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
    super.fillCompletionVariants(parameters, result);
  }

  @Override
  public void beforeCompletion(@NotNull CompletionInitializationContext context) {
    super.beforeCompletion(context);
  }

  public ApplicationNameCompletionContributor() {
    final PsiElementPattern.Capture<PsiElement> inAppReferenceString = psiElement().withSuperParent(1, AppleScriptApplicationReference.class);

    extend(CompletionType.BASIC,
        inAppReferenceString,
        new CompletionProvider<CompletionParameters>() {
          @Override
          protected void addCompletions(@NotNull CompletionParameters parameters,
                                        ProcessingContext context,
                                        @NotNull CompletionResultSet result) {

            AppleScriptSystemDictionaryRegistryService systemDictionaryRegistry = ServiceManager.getService
                (AppleScriptSystemDictionaryRegistryService.class);
            if (systemDictionaryRegistry != null) {
              List<String> appNameList = new ArrayList<>();
              if (SystemInfo.isMac) {
                appNameList.addAll(systemDictionaryRegistry.getDiscoveredApplicationNames());
                appNameList.removeAll(systemDictionaryRegistry.getNotScriptableApplicationList());
                appNameList.removeAll(systemDictionaryRegistry.getScriptingAdditions());
                appNameList.remove(ApplicationDictionary.SCRIPTING_ADDITIONS_LIBRARY);
                appNameList.remove(ApplicationDictionary.COCOA_STANDARD_LIBRARY);
              } else {
                appNameList.addAll(systemDictionaryRegistry.getCachedApplicationNames());
              }
              for (String appName : appNameList) {
                result.addElement(LookupElementBuilder.create(appName));
              }
            }
          }
        });

  }
}
