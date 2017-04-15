package com.intellij.plugin.applescript.psi;

import com.intellij.openapi.project.Project;
import com.intellij.plugin.applescript.AppleScriptFile;
import com.intellij.plugin.applescript.AppleScriptFileType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.plugin.applescript.psi.AppleScriptTypes.HANDLER_PARAMETER_LABEL;

/**
 * Andrey 12.04.2015
 */
public class AppleScriptPsiElementFactory {


  public static AppleScriptHandlerParameterLabel createHandlerParameterLabel(Project project, String labelName) {
    StringBuilder builder = new StringBuilder();
    String newLabelName = labelName != null && !labelName.isEmpty() ? labelName : "to";
    builder.append("dummyHandlerName ").append(newLabelName).append(" \"some sting val\"");
    AppleScriptFile file = createFile(project, builder.toString());
    file.findChildByClass(AppleScriptHandlerLabeledParametersCallExpression.class);
//    file.getFirstChild().findChildByClass(AppleScriptHandlerLabeledParametersCallExpression.class);
    AppleScriptHandlerLabeledParametersCallExpression handlerCall =
            (AppleScriptHandlerLabeledParametersCallExpression) file
                    .getFirstChild();

    AppleScriptHandlerParameterLabel psiLabelNode = PsiTreeUtil.getChildOfType(file, AppleScriptHandlerParameterLabel
            .class);

    PsiElement[] childElements = handlerCall.getChildren();
    for (PsiElement childElement : childElements) {
      if (childElement.getNode().getElementType() == HANDLER_PARAMETER_LABEL) {
        return (AppleScriptHandlerParameterLabel) childElement;
      }
    }
    return null;
  }

  public static AppleScriptFile createFile(Project project, String text) {
    final String name = "dummy_file" + AppleScriptFileType.INSTANCE.getDefaultExtension();
    final long stamp = System.currentTimeMillis();
    final PsiFileFactory factory = PsiFileFactory.getInstance(project);
    return (AppleScriptFile) factory.createFileFromText(name, AppleScriptFileType.INSTANCE, text, stamp, false);
  }
  
  @NotNull
  public static AppleScriptStringLiteralExpression createStringLiteral(Project project, String text) {
    PsiFile file = createFile(project, "\"" + text + "\"");
    AppleScriptStringLiteralExpression string = PsiTreeUtil.findChildOfType(file, AppleScriptStringLiteralExpression.class);
    assert string != null : "text=" + text;
    return string;
  }

  @Nullable
  public static AppleScriptIdentifier createIdentifierFromText(Project project, String name) {
    AppleScriptFile file = createFile(project, name);
    return PsiTreeUtil.findChildOfAnyType(file, AppleScriptIdentifier.class);
  }
}
