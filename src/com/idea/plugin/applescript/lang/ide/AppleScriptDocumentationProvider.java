package com.idea.plugin.applescript.lang.ide;

import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 22.08.2015.
 */
public class AppleScriptDocumentationProvider extends AbstractDocumentationProvider {
  @Nullable
  @Override
  public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
    PsiElement target = element.getReference() != null ? element.getReference().resolve() : null;
//    if (element instanceof DictionaryComponent) {
//      DictionaryComponent appElement = (DictionaryComponent)element;
//      return appElement.getType() + " " + appElement.getQualifiedName();
//    }
    return null;
  }

  @Override
  public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
    PsiElement targetElement = element.getReference() != null ? element.getReference().resolve() : null;
    if (targetElement instanceof DictionaryComponent) {
      DictionaryComponent applicationElement = (DictionaryComponent) targetElement;
      return applicationElement.getDocumentation();
    }
    return null;
  }
}
