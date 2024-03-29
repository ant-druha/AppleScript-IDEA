package com.intellij.plugin.applescript.lang.ide.findUsages;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.AppleScriptLexerAdapter;
import com.intellij.plugin.applescript.lang.AppleScriptComponentType;
import com.intellij.plugin.applescript.psi.AppleScriptReferenceElement;
import com.intellij.plugin.applescript.psi.AppleScriptTypes;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Andrey 18.04.2015
 */
public class AppleScriptFindUsagesProvider implements FindUsagesProvider {

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new AppleScriptLexerAdapter(),
            TokenSet.create(AppleScriptTypes.IDENTIFIER),
            TokenSet.create(AppleScriptTypes.COMMENT),
            TokenSet.create(AppleScriptTypes.STRING_LITERAL));
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiNamedElement || psiElement instanceof AppleScriptReferenceElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    AppleScriptComponentType componentType = AppleScriptComponentType.typeOf(element);
    return componentType != null ? componentType.toString().toLowerCase() : "reference";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof PsiNamedElement) {
      return StringUtil.notNullize(((PsiNamedElement) element).getName());
    }
    return "";
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    final String name = element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
    return name != null ? name : element.getText();
  }
}
