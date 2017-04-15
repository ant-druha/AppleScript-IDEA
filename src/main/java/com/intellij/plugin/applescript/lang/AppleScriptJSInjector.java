package com.intellij.plugin.applescript.lang;

import com.intellij.lang.Language;
import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugin.applescript.psi.AppleScriptStringLiteralExpression;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Andrey 11/04/17.
 */
public class AppleScriptJSInjector implements MultiHostInjector {
  @Override
  public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement context) {
    if (context instanceof AppleScriptStringLiteralExpression) {
      AppleScriptCommandHandlerCall asCommand = PsiTreeUtil.getContextOfType(context, AppleScriptCommandHandlerCall.class);
      if (asCommand != null && asCommand.getCommandName().equalsIgnoreCase("do javascript")) {
        Collection<Language> javascript = Language.findInstancesByMimeType("javascript");
        if (javascript.isEmpty()) return;

        registrar.startInjecting(javascript.iterator().next()).addPlace(null, null, (PsiLanguageInjectionHost) context, new TextRange(1, context.getTextLength() - 1)).doneInjecting();
      }
    }
  }

  @NotNull
  @Override
  public List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
    return Collections.singletonList(AppleScriptStringLiteralExpression.class);

  }
}
