package com.idea.plugin.applescript.lang.ide.completion;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistryService;
import com.idea.plugin.applescript.psi.AppleScriptApplicationReference;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

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
    final PsiElementPattern.Capture<PsiElement> inAppReferenceString =
            psiElement().withSuperParent(1, AppleScriptApplicationReference.class);

    final PsiElementPattern.Capture<PsiElement> any =
            psiElement();

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
                  Collection<String> appNameList;
                  if (SystemInfo.isMac) {
                    appNameList = systemDictionaryRegistry.getDiscoveredApplicationNames();
                  } else {
                    appNameList = systemDictionaryRegistry.getCachedApplicationNames();
                  }
                  for (String appName : appNameList) {
                    result.addElement(LookupElementBuilder.create(appName));
                  }
                }
              }
            });

  }
}
