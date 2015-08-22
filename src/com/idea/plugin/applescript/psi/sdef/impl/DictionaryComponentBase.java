package com.idea.plugin.applescript.psi.sdef.impl;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.idea.plugin.applescript.lang.sdef.DictionaryComponent;
import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.xml.XmlElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 19.08.2015.
 */
public abstract class DictionaryComponentBase<P extends DictionaryComponent, D extends XmlElement>
        extends FakePsiElement implements AppleScriptPsiElement {

  @NotNull protected final D myXmlElement;
  @NotNull protected final P myParent;

  protected DictionaryComponentBase(@NotNull D myXmlElement, @NotNull P myParent) {
    this.myXmlElement = myXmlElement;
    this.myParent = myParent;
  }

  @NotNull
  @Override
  public Language getLanguage() {
    return AppleScriptLanguage.INSTANCE;
  }

  @Nullable
  @Override
  public TextRange getTextRange() {
    return myXmlElement.getTextRange();
  }

  @Override
  public int getStartOffsetInParent() {
    return myXmlElement.getStartOffsetInParent();
  }

  @Override
  public int getTextLength() {
    return myXmlElement.getTextLength();
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    return myXmlElement.findElementAt(offset); //or we should not redefine this?we do not need Xml psi
  }

  @Override
  public int getTextOffset() {
    return myXmlElement.getTextOffset();
  }

  @Override
  public PsiElement getOriginalElement() {
    return myXmlElement.getOriginalElement();
  }

  @NotNull
  @Override
  public Project getProject() {
//    return getDictionaryParentComponent().getProject(); //should we use XMLTag then here??
    return myXmlElement.getProject(); //should we use XMLTag then here??
  }

  @Override
  public PsiFile getContainingFile() {
//    return super.getContainingFile();
    return myXmlElement.getContainingFile();
  }

  @Nullable
  @Override
  public String getText() {
    return myXmlElement.getText();
  }

  @Nullable
  @Override
  public ASTNode getNode() {
    return myXmlElement.getNode();
  }

  @Override
  public PsiElement getParent() {
    return getDictionaryParentComponent();
  }

  @NotNull
  public P getDictionaryParentComponent() {
    return myParent;
  }
}
