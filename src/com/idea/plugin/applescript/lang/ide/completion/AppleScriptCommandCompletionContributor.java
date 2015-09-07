package com.idea.plugin.applescript.lang.ide.completion;

import com.idea.plugin.applescript.lang.sdef.AppleScriptCommand;
import com.idea.plugin.applescript.lang.sdef.CommandParameter;
import com.idea.plugin.applescript.psi.AppleScriptIdentifier;
import com.idea.plugin.applescript.psi.sdef.AppleScriptCommandHandlerCall;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.ElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

/**
 * Created by Andrey on 31.08.2015.
 */
public class AppleScriptCommandCompletionContributor extends CompletionContributor {

  @Override
  public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
    super.fillCompletionVariants(parameters, result);
  }

  public AppleScriptCommandCompletionContributor() {
    final PsiElementPattern.Capture<PsiElement> idInExpression =
            psiElement().withSuperParent(1, AppleScriptIdentifier.class).
                    withSuperParent(2, AppleScriptCommandHandlerCall.class);

    final PsiElementPattern.Capture<PsiElement> id =
            psiElement().withSuperParent(1, AppleScriptIdentifier.class);

    final PsiElementPattern.Capture<PsiElement> any =
            psiElement();

//    psiElement().

    extend(CompletionType.BASIC,
            idInExpression,
            new CompletionProvider<CompletionParameters>() {
              @Override
              protected void addCompletions(@NotNull CompletionParameters parameters,
                                            ProcessingContext context,
                                            @NotNull CompletionResultSet result) {
                AppleScriptCommandHandlerCall handlerCallExpression =
                        PsiTreeUtil.getParentOfType(parameters.getPosition(), AppleScriptCommandHandlerCall.class);
//                if (handlerCallExpression != null) {
//                  PsiReference ref = handlerCallExpression.getReference();
//                  PsiElement target = ref.resolve();
//                  if (target instanceof AppleScriptCommand) {
//                    AppleScriptCommand command = (AppleScriptCommand) target;
//                    for (CommandParameter par : command.getParameters()) {
//                      result.addElement(LookupElementBuilder.create(par.getName()));
//                    }
//                  }
//                }

              }
            });
    extend(CompletionType.BASIC,
            id,
            new CompletionProvider<CompletionParameters>() {
              @Override
              protected void addCompletions(@NotNull CompletionParameters parameters,
                                            ProcessingContext context,
                                            @NotNull CompletionResultSet result) {
                AppleScriptCommandHandlerCall handlerCallExpression =
                        PsiTreeUtil.getParentOfType(parameters.getPosition(), AppleScriptCommandHandlerCall.class);
                if (handlerCallExpression == null) {

                  PsiElement appId = PsiTreeUtil.getParentOfType(parameters.getPosition(), AppleScriptIdentifier.class);
                  PsiElement refId = appId != null ? appId.getParent() : null;
                  PsiElement expression = refId != null ? refId.getParent() : null;
                  PsiElement directParam = expression != null ? expression.getParent() : null;
                  PsiElement handlerCall = directParam != null ? directParam.getParent() : null;
                  if (handlerCall instanceof AppleScriptCommandHandlerCall) {
                    handlerCallExpression = (AppleScriptCommandHandlerCall) handlerCall;
                  }
                  if (expression instanceof AppleScriptCommandHandlerCall) {
                    handlerCallExpression = (AppleScriptCommandHandlerCall) expression;
                  }
                }
//parameters.getPosition().getParent().getParent().getParent() (handler call if invoked after parameters
//parameters.getPosition().getParent().getParent().getParent().getParent().getParent() if after handler call
                if (handlerCallExpression != null) {
                  PsiReference ref = handlerCallExpression.getReference();
                  PsiElement target = ref.resolve();
                  if (target instanceof AppleScriptCommand) {
                    AppleScriptCommand command = (AppleScriptCommand) target;
                    for (CommandParameter par : command.getParameters()) {
                      result.addElement(LookupElementBuilder.create(par.getName()));
                    }
                  }
                }
              }
            });
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
                PsiElement elemAtCaret = parameters.getOriginalFile().findElementAt(parameters.getOffset());
                PsiElement prevSibling = elemAtCaret != null ? elemAtCaret.getPrevSibling() : null;
                while (prevSibling != null && prevSibling.getNode().getElementType() == ElementType.WHITE_SPACE) {
                  prevSibling = prevSibling.getPrevSibling();
                }
//                PsiElement mayBeHandler = prevSibling;
                if (handlerCallExpression == null) {
                  handlerCallExpression = prevSibling instanceof AppleScriptCommandHandlerCall ?
                          (AppleScriptCommandHandlerCall) prevSibling : null;
                }

                if (handlerCallExpression != null) {
                  PsiReference ref = handlerCallExpression.getReference();
                  PsiElement target = ref.resolve();
                  if (target instanceof AppleScriptCommand) {
                    AppleScriptCommand command = (AppleScriptCommand) target;
//                    CommandDirectParameter dirPar = command.getDirectParameter();
//                    if (dirPar != null) {
//                      String lb = "", rb = "";
//                      if (dirPar.isOptional()) {
//                        lb = "[";
//                        rb = "]";
//                      }
//                      String text = lb + dirPar.getTypeSpecifier() + rb;
//                      result.addElement(LookupElementBuilder.create(text));
//                    }
                    for (CommandParameter par : command.getParameters()) {
//                      String lb = "", rb = "";
//                      if (par.isOptional()) {
//                        lb = "[";
//                        rb = "]";
//                      }
//                      String text = lb + par.getName() + rb;
                      LookupElement le = LookupElementBuilder.create(par.getName());

                      result.addElement(le);
                    }
                    result.stopHere();
                  }
                }

              }
            });

    extend(CompletionType.BASIC,
            psiElement(AppleScriptCommandHandlerCall.class),
            new CompletionProvider<CompletionParameters>() {
              @Override
              protected void addCompletions(@NotNull CompletionParameters parameters,
                                            ProcessingContext context,
                                            @NotNull CompletionResultSet result) {
                AppleScriptCommandHandlerCall handlerCallExpression =
                        PsiTreeUtil.getParentOfType(parameters.getPosition(), AppleScriptCommandHandlerCall.class);
                if (handlerCallExpression != null) {
                  PsiReference ref = handlerCallExpression.getReference();
                  PsiElement target = ref.resolve();
                  if (target instanceof AppleScriptCommand) {
                    AppleScriptCommand command = (AppleScriptCommand) target;
                    for (CommandParameter par : command.getParameters()) {
                      LookupElement le = LookupElementBuilder.create(par.getName());

                      result.addElement(le);
                    }
                    result.stopHere();
                  }
                }

              }
            });
  }
}
