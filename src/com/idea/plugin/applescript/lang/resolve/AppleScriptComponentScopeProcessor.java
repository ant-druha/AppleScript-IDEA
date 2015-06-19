package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.openapi.util.Key;
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
    myResult.add(element);
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
