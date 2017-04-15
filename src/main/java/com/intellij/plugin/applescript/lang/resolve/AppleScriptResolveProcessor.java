package com.intellij.plugin.applescript.lang.resolve;

import com.intellij.openapi.util.Key;
import com.intellij.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.util.containers.SortedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 15.04.2015
 */
public class AppleScriptResolveProcessor extends AppleScriptPsiScopeProcessor {

  private AppleScriptComponent myResult;
  @NotNull
  private final String myName;
  @NotNull
  private final SortedList<AppleScriptTargetVariable> myTargets = new SortedList<>((o1, o2) -> -(o1.getTextOffset() - o2.getTextOffset()));


  public PsiElement getResult() {
    return myResult;
  }

  public AppleScriptResolveProcessor(@NotNull String myName) {
    this.myName = myName;
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
  protected boolean doExecute(@NotNull AppleScriptPsiElement element, @NotNull ResolveState state) {
    if (element instanceof AppleScriptComponent) {
      if (this.myName.equals(element.getName())) {
        if (element instanceof AppleScriptTargetVariable) {
          myTargets.add((AppleScriptTargetVariable) element);
          //set the closest from added before definition and continue the search
          myResult = myTargets.get(0);
          return true;
        }
        myResult = (AppleScriptComponent) element;
        return false;
      }
    }
    return true;
  }
}
