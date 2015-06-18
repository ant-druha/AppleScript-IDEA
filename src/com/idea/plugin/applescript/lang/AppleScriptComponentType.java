package com.idea.plugin.applescript.lang;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.intellij.psi.PsiElement;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Andrey on 17.06.2015.
 */
public enum AppleScriptComponentType {
  PROPERTY(PlatformIcons.PROPERTY_ICON) {
    @Override
    public Icon getIcon(@NotNull AppleScriptComponent component) {
      return super.getIcon(component);
    }
  },
  HANDLER(PlatformIcons.FUNCTION_ICON),
  //for other variable types
  VARIABLE(PlatformIcons.VARIABLE_ICON);

  private Icon myIcon;

  AppleScriptComponentType(Icon icon) {
    myIcon = icon;
  }

  public Icon getIcon() {
    return myIcon;
  }

  public Icon getIcon(@NotNull AppleScriptComponent component) {
    // should be overridden in appropriate subclasses if needed
    return getIcon();
  }

  @Nullable
  public static AppleScriptComponentType typeOf(@Nullable PsiElement element) {
    if (!(element instanceof AppleScriptComponent)) {
      return null;
    }
    final AppleScriptComponent component = (AppleScriptComponent) element;
    if (component.isHandler()) {
      return HANDLER;
    } else if (component.isVariable()) {
      return VARIABLE;
    } else if (component.isScriptProperty() || component.isObjectProperty()) {
      return PROPERTY;
    }
    return null;
  }
}
