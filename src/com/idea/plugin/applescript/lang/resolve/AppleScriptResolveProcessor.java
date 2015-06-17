package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Andrey on 15.04.2015.
 */
public class AppleScriptResolveProcessor extends AppleScriptPsiScopeProcessor {
  private final List<AppleScriptComponent> myResult;
  private final String myName;

  public AppleScriptResolveProcessor(List<AppleScriptComponent> result, String name) {
    myResult = result;
    myName = name;
  }

  @Nullable
  @Override
  public <T> T getHint(@NotNull Key<T> hintKey) {
    return null;
  }

  @Override
  public void handleEvent(@NotNull Event event, @Nullable Object associated) {

  }


  @Override
  protected boolean doExecute(@NotNull AppleScriptComponent element) {
    if (this.myName.equals(element.getName())) {
      myResult.add(element);
      return false;
    }
    return true;
  }
}
