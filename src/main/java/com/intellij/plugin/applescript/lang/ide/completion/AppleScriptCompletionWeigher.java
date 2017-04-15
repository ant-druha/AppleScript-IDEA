package com.intellij.plugin.applescript.lang.ide.completion;

import com.intellij.codeInsight.completion.CompletionLocation;
import com.intellij.codeInsight.completion.CompletionWeigher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.plugin.applescript.lang.sdef.CommandParameter;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey 28/01/16.
 */
public class AppleScriptCompletionWeigher extends CompletionWeigher {
  @Override
  public Integer weigh(@NotNull final LookupElement element, @NotNull final CompletionLocation location) {
    final Object lookupObject = element.getObject();
    CommandParameter parameter = null;
    boolean opt = false;
    if (lookupObject instanceof CommandParameter) {
      parameter = (CommandParameter) lookupObject;
      opt = parameter.isOptional();
    }
    return parameter != null && opt ? -10 : 0;
  }
}