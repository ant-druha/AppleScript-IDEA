package com.intellij.plugin.applescript.lang.resolve;

import com.intellij.openapi.util.Key;
import com.intellij.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.psi.ResolveState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Andrey 20.04.2015
 */
public class AppleScriptComponentScopeProcessor extends AppleScriptPsiScopeProcessor {

  private final @NotNull Set<AppleScriptComponent> myResult;
  private final Map<String, AppleScriptTargetVariable> myCollectedTargets =
          new HashMap<>();

  public AppleScriptComponentScopeProcessor(@NotNull Set<AppleScriptComponent> myResult) {
    this.myResult = myResult;
  }

  @Override
  protected boolean doExecute(@NotNull AppleScriptPsiElement element, final @NotNull ResolveState state) {
    if (element instanceof AppleScriptTargetVariable) {
      final AppleScriptTargetVariable targetVar = (AppleScriptTargetVariable) element;
      if (!myCollectedTargets.containsKey(targetVar.getName())) {
        myCollectedTargets.put(targetVar.getName(), targetVar);
        myResult.add(targetVar);
      } else if (targetVar.getContainingFile() != myCollectedTargets.get(targetVar.getName()).getContainingFile()) {
        myResult.add(targetVar);//should not happen if the file is the same
        AppleScriptTargetVariable addedVar = myCollectedTargets.get(targetVar.getName());
        // if there already variable with the same name defined it should be located in the same local context
        // (file, handler etc)
        throw new AssertionError("Elements are defined in different files:");
      }
    } else if (element instanceof AppleScriptComponent && !(element instanceof DictionaryComponent)) {
      myResult.add((AppleScriptComponent) element);
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
