package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 15.04.2015.
 */
public class AppleScriptResolver implements ResolveCache.AbstractResolver<AppleScriptReferenceElement, List<? extends
        PsiElement>> {
  public static final AppleScriptResolver INSTANCE = new AppleScriptResolver();

  protected List<? extends PsiElement> resolveSimpleReference(@NotNull final PsiElement scopeElement, @NotNull final
  String name) {
    final List<AppleScriptComponent> result = new ArrayList<AppleScriptComponent>();

    // local
    final AppleScriptResolveProcessor resolveProcessor = new AppleScriptResolveProcessor(result, name);
    PsiTreeUtil.treeWalkUp(resolveProcessor, scopeElement, null, ResolveState.initial());
    return result;
  }

  @Override
  public List<? extends PsiElement> resolve(@NotNull AppleScriptReferenceElement reference, boolean incompleteCode) {

    return resolveSimpleReference(reference, reference.getCanonicalText());
  }
}
