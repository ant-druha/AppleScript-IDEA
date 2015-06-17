package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.idea.plugin.applescript.psi.AppleScriptSelectorIdentifier;
import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Created by Andrey on 20.04.2015.
 */
public class AppleScriptComponentScopeProcessor extends AppleScriptPsiScopeProcessor {

  private final
  @NotNull
  Set<AppleScriptComponent> myResult;

  public AppleScriptComponentScopeProcessor(@NotNull Set<AppleScriptComponent> myResult) {
    this.myResult = myResult;
  }

  @Override
  protected boolean doExecute(@NotNull AppleScriptComponent element) {
    //todo need to think of better performance-wise solution
    if (element instanceof AppleScriptSelectorIdentifier) {
      PsiElement handler = element.getContext() != null ? element.getContext().getContext() : null;
      if (handler instanceof AppleScriptHandler) {
        myResult.add((AppleScriptHandler) handler);
      }
    } else {
      //todo to check if there will be doubled results for interleaved handler
      myResult.add(element);
    }
    return true;
  }

  @Nullable
  @Override
  public <T> T getHint(@NotNull Key<T> hintKey) {
    return null;
  }

  @Override
  public void handleEvent(@NotNull Event event, @Nullable Object associated) {

  }
}
