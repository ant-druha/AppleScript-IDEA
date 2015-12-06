package com.idea.plugin.applescript.lang;

import com.idea.plugin.applescript.AppleScriptIcons;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptScriptObject;
import com.idea.plugin.applescript.psi.AppleScriptSimpleFormalParameter;
import com.intellij.psi.PsiElement;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Andrey 17.06.2015
 */
public enum AppleScriptComponentType {
  PROPERTY(PlatformIcons.PROPERTY_ICON) {
    @Override
    public Icon getIcon(@NotNull AppleScriptComponent component) {
      return super.getIcon(component);
    }
  },
  HANDLER(PlatformIcons.FUNCTION_ICON),
  SCRIPT(AppleScriptIcons.FILE),
  PARAMETER(PlatformIcons.PARAMETER_ICON),
  //for other variable types
  VARIABLE(PlatformIcons.VARIABLE_ICON),
  //sdef dictionary
  APPLICATION_DICTIONARY(AppleScriptIcons.OPEN_DICTIONARY),
  DICTIONARY_SUITE(PlatformIcons.PACKAGE_ICON),
  DICTIONARY_CLASS(PlatformIcons.CLASS_ICON),
  DICTIONARY_ENUMERATOR(PlatformIcons.VARIABLE_ICON),
  DICTIONARY_COMMAND(PlatformIcons.FUNCTION_ICON);

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
    if (element instanceof AppleScriptComponent) {

      final AppleScriptComponent component = (AppleScriptComponent) element;
      if (component.isHandler()) {
        return HANDLER;
      } else if (element instanceof AppleScriptSimpleFormalParameter) {//todo handle detection for all handlers
        return PARAMETER;
      } else if (component.isVariable()) {
        return VARIABLE;
      } else if (component.isScriptProperty() || component.isObjectProperty()) {
        return PROPERTY;
      } else if (component instanceof AppleScriptScriptObject) {
        //todo how better to define this?
        return SCRIPT;
      } else if (element instanceof AppleScriptClass) {
        return DICTIONARY_CLASS;
      } else if (element instanceof AppleScriptCommand) {
        return DICTIONARY_COMMAND;
      } else if (element instanceof DictionaryEnumeratorImpl) {
        return DICTIONARY_ENUMERATOR;
      } else if (element instanceof SuiteImpl) {
        return DICTIONARY_SUITE;
      } else if (element instanceof ApplicationDictionary)
        return APPLICATION_DICTIONARY;
    }
    return null;
  }

  @Override
  public String toString() {
    return super.toString().replace("_", " ");
  }
}
