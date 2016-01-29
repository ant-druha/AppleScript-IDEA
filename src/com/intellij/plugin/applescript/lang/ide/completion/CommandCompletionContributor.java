package com.intellij.plugin.applescript.lang.ide.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.intellij.plugin.applescript.lang.sdef.CommandParameter;
import com.intellij.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 * Andrey 31.08.2015
 */
public class CommandCompletionContributor extends CompletionContributor {

  @Override
  public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
    super.fillCompletionVariants(parameters, result);
  }

  @Override
  public void beforeCompletion(@NotNull CompletionInitializationContext context) {
    super.beforeCompletion(context);
  }

  public CommandCompletionContributor() {

    final PsiElementPattern.Capture<PsiElement> any = psiElement();

    extend(CompletionType.BASIC,
            any,
            new CompletionProvider<CompletionParameters>() {
              @Override
              protected void addCompletions(@NotNull CompletionParameters parameters,
                                            ProcessingContext context,
                                            @NotNull CompletionResultSet result) {
                AppleScriptCommandHandlerCall handlerCallExpression;
                handlerCallExpression = PsiTreeUtil.getParentOfType(parameters.getPosition(),
                        AppleScriptCommandHandlerCall.class);
                final PsiElement elemAtCaret = parameters.getOriginalFile().findElementAt(parameters.getOffset());
                final int currLine = parameters.getEditor().getDocument().getLineNumber(parameters.getOffset());
                PsiElement prevSibling = elemAtCaret != null ? elemAtCaret.getPrevSibling() : null;
                while (prevSibling != null
                        && prevSibling.getNode().getElementType() == com.intellij.psi.TokenType.WHITE_SPACE) {
                  prevSibling = prevSibling.getPrevSibling();
                }
                if (handlerCallExpression == null) {
                  handlerCallExpression = prevSibling instanceof AppleScriptCommandHandlerCall ?
                          (AppleScriptCommandHandlerCall) prevSibling : null;
                }

                if (handlerCallExpression != null) {
                  final int handlerLine = parameters.getEditor().getDocument()
                          .getLineNumber(handlerCallExpression.getTextOffset());
                  if (handlerLine != currLine) return;

                  PsiReference ref = handlerCallExpression.getReference();
                  PsiElement target = ref.resolve();
                  if (target instanceof AppleScriptCommand) {
                    AppleScriptCommand command = (AppleScriptCommand) target;
                    List<CommandParameter> sortedParams = command.getParameters();
                    Collections.sort(sortedParams, new Comparator<CommandParameter>() {
                      @Override
                      public int compare(CommandParameter par1, CommandParameter par2) {
                        int res = 0;
                        boolean o1 = par1.isOptional();
                        boolean o2 = par2.isOptional();
                        if (o1 && o2 || !o1 && !o2) res = 0;
                        if (!o1 && o2) res = -1;
                        if (o1 && !o2) res = 1;
                        return res;
                      }
                    });
                    for (CommandParameter par : sortedParams) {
                      result.addElement(LookupElementBuilder.create(par).withBoldness(!par.isOptional())
                              .withIcon(par.getIcon(0)));
                    }
                    result.stopHere();
                  }
                }
              }
            });
  }
}
