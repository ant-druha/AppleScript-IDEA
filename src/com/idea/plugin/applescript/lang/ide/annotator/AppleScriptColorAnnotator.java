package com.idea.plugin.applescript.lang.ide.annotator;

import com.idea.plugin.applescript.lang.ide.highlighting.AppleScriptSyntaxHighlighterColors;
import com.idea.plugin.applescript.lang.ide.intentions.AddApplicationDictionaryQuickFix;
import com.idea.plugin.applescript.lang.ide.intentions.RenameParameterLabelQuickFix;
import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptSystemDictionaryRegistry;
import com.idea.plugin.applescript.psi.*;
import com.idea.plugin.applescript.psi.impl.AppleScriptPsiImplUtil;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static com.idea.plugin.applescript.psi.AppleScriptTokenTypesSets.HANDLER_PARAMETER_LABELS;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;

/**
 * Created by Andrey on 12.04.2015.
 */
public class AppleScriptColorAnnotator implements Annotator {
  private static void createInfoAnnotation(final @NotNull AnnotationHolder holder,
                                           final @Nullable PsiElement element,
                                           final @Nullable TextAttributesKey attributeKey) {
    if (element != null && attributeKey != null) {
      holder.createInfoAnnotation(element, null).setTextAttributes(attributeKey);
    }
  }

  @Override
  public void annotate(final @NotNull PsiElement element, final @NotNull AnnotationHolder holder) {
    IElementType elementType = element.getNode().getElementType();
    if (element instanceof PsiReference
            || element instanceof AppleScriptHandlerCall) {
      PsiElement resolveResult = null;
      PsiReference ref = element.getReference();
      if (ref != null) {
        resolveResult = element.getReference().resolve();
      }
      if (resolveResult == null) {
        if (element instanceof AppleScriptHandlerCall) {
          AppleScriptHandlerCall handlerCall = (AppleScriptHandlerCall) element;
          for (AppleScriptHandlerArgument argument : handlerCall.getArguments()) {
            createInfoAnnotation(holder, argument.getArgumentSelector(),
                    AppleScriptSyntaxHighlighterColors.UNRESOLVED_REFERENCE);
          }
        } else createInfoAnnotation(holder, element, AppleScriptSyntaxHighlighterColors.UNRESOLVED_REFERENCE);
      }
    }
    if (element instanceof AppleScriptDictionaryCommandName) {
      createInfoAnnotation(holder, element, AppleScriptSyntaxHighlighterColors.DICTIONARY_COMMAND_ATTR);
    } else if (element instanceof AppleScriptTellSimpleStatement
            || element instanceof AppleScriptTellCompoundStatement) {
      String appName = AppleScriptPsiImplUtil.findApplicationNameFromTellStatement(element);
      AppleScriptSystemDictionaryRegistry systemDictionaryRegistry = ApplicationManager.getApplication()
              .getComponent(AppleScriptSystemDictionaryRegistry.class);
      if (systemDictionaryRegistry != null) {
        if (!StringUtil.isEmpty(appName) && !systemDictionaryRegistry.isApplicationKnown(appName)) {

          AppleScriptApplicationReference appRef = PsiTreeUtil
                  .findChildOfType(element, AppleScriptApplicationReference.class);
          holder.createWarningAnnotation(appRef != null ? appRef : element, "Application \"" + appName + "\" not found")
                  .registerFix(new AddApplicationDictionaryQuickFix(appName));
        }
      }
    }
    // duplicated labels
    if (elementType == HANDLER_LABELED_PARAMETERS_DEFINITION ||
            elementType == HANDLER_LABELED_PARAMETERS_CALL) {
      PsiElement[] childElements = element.getChildren();
      ArrayList<String> labelNames = new ArrayList<String>();
      for (PsiElement childElement : childElements) {
        if (childElement.getNode().getElementType() == HANDLER_PARAMETER_LABEL) {
          String labelName = childElement.getText();
          if (labelNames.contains(labelName)) {
            String newLabelName = null;
            for (IElementType type : HANDLER_PARAMETER_LABELS.getTypes()) {
              if (!labelNames.contains(type.toString().toLowerCase().substring(21))) {
                newLabelName = type.toString().toLowerCase().substring(21);
              }
            }
            holder.createErrorAnnotation(childElement, "Duplicated parameter label '" + labelName + "'")
                    .registerFix(new RenameParameterLabelQuickFix((AppleScriptHandlerParameterLabel) childElement,
                            newLabelName));
          }
          labelNames.add(labelName);
        }
      }
    }


  }
}
