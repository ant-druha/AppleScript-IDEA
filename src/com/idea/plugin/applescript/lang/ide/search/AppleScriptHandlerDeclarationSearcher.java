package com.idea.plugin.applescript.lang.ide.search;

import com.idea.plugin.applescript.psi.AppleScriptSelectorId;
import com.idea.plugin.applescript.psi.impl.AppleScriptHandlerInterleavedParameters;
import com.intellij.pom.PomDeclarationSearcher;
import com.intellij.pom.PomTarget;
import com.intellij.psi.PsiElement;
import com.intellij.util.Consumer;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 17.06.2015.
 */
public class AppleScriptHandlerDeclarationSearcher extends PomDeclarationSearcher {
  @Override
  public void findDeclarationsAt(@NotNull PsiElement element, int offsetInElement, Consumer<PomTarget> consumer) {
    if (element instanceof AppleScriptSelectorId) {
      AppleScriptHandlerInterleavedParameters handler;
      final PsiElement contextElement = element.getContext() != null ? element.getContext().getContext() : null;
      if (contextElement instanceof AppleScriptHandlerInterleavedParameters) {
        handler = (AppleScriptHandlerInterleavedParameters) contextElement;
        consumer.consume(handler);
      }
    }
  }
}
