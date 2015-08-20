package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.idea.plugin.applescript.psi.sdef.DictionaryIdentifier;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 19.08.2015.
 */
public class DictionaryIdentifierImpl extends DictionaryPsiElementBase<DictionaryComponent, XmlToken>
        implements DictionaryIdentifier {

  @NotNull protected final String varIdentifierText;

  public DictionaryIdentifierImpl(@NotNull DictionaryComponent myParent, @NotNull String varIdentifierText,
                                  @NotNull XmlToken myXmlToken) {
    super(myXmlToken, myParent);
    this.varIdentifierText = varIdentifierText;
  }

  @NotNull
  @Override
  public PsiElement getVarIdentifier() {
    return this;
  }

  @Override
  public int getTextLength() {
    return varIdentifierText.length();
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    return this;
  }

  @Nullable
  @Override
  public String getText() {
    return varIdentifierText;
  }

  @NotNull
  @Override
  public DictionaryComponent getParent() {
    return myParent;
  }

}
