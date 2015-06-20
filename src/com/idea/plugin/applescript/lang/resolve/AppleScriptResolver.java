package com.idea.plugin.applescript.lang.resolve;

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
    final List<PsiElement> result = new ArrayList<PsiElement>();

    final AppleScriptResolveProcessor resolveProcessor = new AppleScriptResolveProcessor(name);
    PsiTreeUtil.treeWalkUp(resolveProcessor, scopeElement, null, ResolveState.initial());
    result.add(resolveProcessor.getResult());
    return result;
  }

  @Override
  public List<? extends PsiElement> resolve(@NotNull AppleScriptReferenceElement reference, boolean incompleteCode) {

    return resolveSimpleReference(reference, reference.getCanonicalText());
  }
}
