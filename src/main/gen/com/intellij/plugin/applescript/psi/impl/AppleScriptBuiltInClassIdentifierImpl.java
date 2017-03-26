// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import com.intellij.plugin.applescript.psi.*;

public class AppleScriptBuiltInClassIdentifierImpl extends AppleScriptPsiElementImpl implements AppleScriptBuiltInClassIdentifier {

  public AppleScriptBuiltInClassIdentifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AppleScriptVisitor visitor) {
    visitor.visitBuiltInClassIdentifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) accept((AppleScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCubicVol() {
    return findChildByType(CUBIC_VOL);
  }

  @Override
  @Nullable
  public PsiElement getFileSpecification() {
    return findChildByType(FILE_SPECIFICATION);
  }

  @Override
  @Nullable
  public PsiElement getInternationalText() {
    return findChildByType(INTERNATIONAL_TEXT);
  }

  @Override
  @Nullable
  public PsiElement getLocationSpecifier() {
    return findChildByType(LOCATION_SPECIFIER);
  }

  @Override
  @Nullable
  public PsiElement getRgbColor() {
    return findChildByType(RGB_COLOR);
  }

  @Override
  @Nullable
  public PsiElement getSquareArea() {
    return findChildByType(SQUARE_AREA);
  }

  @Override
  @Nullable
  public PsiElement getStyledClipboardText() {
    return findChildByType(STYLED_CLIPBOARD_TEXT);
  }

  @Override
  @Nullable
  public PsiElement getStyledText() {
    return findChildByType(STYLED_TEXT);
  }

  @Override
  @Nullable
  public PsiElement getTemperature() {
    return findChildByType(TEMPERATURE);
  }

  @Override
  @Nullable
  public PsiElement getTextItem() {
    return findChildByType(TEXT_ITEM);
  }

  @Override
  @Nullable
  public PsiElement getUnicodeText() {
    return findChildByType(UNICODE_TEXT);
  }

}
