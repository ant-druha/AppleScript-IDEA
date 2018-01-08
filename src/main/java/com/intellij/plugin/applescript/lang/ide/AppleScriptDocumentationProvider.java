package com.intellij.plugin.applescript.lang.ide;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.plugin.applescript.lang.sdef.DictionaryComponent;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 22.08.2015
 */
public class AppleScriptDocumentationProvider extends AbstractDocumentationProvider {
  @Nullable
  @Override
  public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
    if (element instanceof DictionaryComponent) {
      DictionaryComponent appElement = (DictionaryComponent) element;
      return appElement.getType() + " \"" + appElement.getName() + "\" [ " + appElement.getDictionary().getName() + " ]";
    }
    return null;
  }

  @Override
  public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
    PsiElement targetElement = element instanceof DictionaryComponent ? 
        element :  
        element.getReference() != null ? element.getReference().resolve() : null;
    if (targetElement instanceof DictionaryComponent) {
      DictionaryComponent applicationElement = (DictionaryComponent) targetElement;
      return applicationElement.getDocumentation();
    }
    return null;
  }

  @Override
  public PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
    if (!(context instanceof AppleScriptPsiElement)) return null;
    return AppleScriptDocHelper.getDocumentationElementForLink(psiManager, link, context);
  }
}
