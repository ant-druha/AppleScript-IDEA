package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptHandler;
import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 10.06.2015.
 */
public class AppleScriptHandlerScopeProcessor implements PsiScopeProcessor {

  private final
  @NotNull String myName;
  private AppleScriptHandler myResult;

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    return !(element instanceof AppleScriptHandler) || doExecute((AppleScriptHandler) element);
  }

  public AppleScriptHandlerScopeProcessor(@NotNull String name) {
    myName = name;
  }

  public AppleScriptHandler getMyResult() {
    return myResult;
  }

  protected boolean doExecute(@NotNull AppleScriptHandler handler) {
    if (myName.equals(handler.getName())) {
      myResult = handler;
      return false;
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
