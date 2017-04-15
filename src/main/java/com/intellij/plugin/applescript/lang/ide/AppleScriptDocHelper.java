package com.intellij.plugin.applescript.lang.ide;

import com.intellij.codeInsight.documentation.DocumentationManagerProtocol;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryService;
import com.intellij.plugin.applescript.lang.sdef.*;
import com.intellij.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

/**
 * Andrey 24.08.2015
 */
public class AppleScriptDocHelper {
  private static final String URL_PREFIX_DICTIONARY = "dictionary#";
  private static final String URL_PREFIX_SUITE = "suite#";
  private static final String URL_PREFIX_CLASS = "class#";
  private static final String URL_PREFIX_COMMAND = "command#";
  private static final String TYPE_SEPARATOR = "/";
  private static final String ELEMENT_NAME_SEPARATOR = ":";


  @Nullable
  public static String appendElementLink(StringBuilder sb, AppleScriptPsiElement psiElement, String label) {
    String elementRef = "";
//    sample Class Link:      "psi_element://dictionary:Finder.xml/suite:Finder Basics/class#icon family";
//    sample Dictionary Link: "psi_element://dictionary#Finder.xml";
//    sample Suite Link:      "psi_element://dictionary:Finder.xml/suite#Finder Basics";
    if (psiElement instanceof AppleScriptClass) {
      AppleScriptClass dClass = (AppleScriptClass) psiElement;
      elementRef = "dictionary:" + dClass.getDictionary().getName() + TYPE_SEPARATOR + "suite" + ELEMENT_NAME_SEPARATOR +
          dClass.getSuite().getName() + TYPE_SEPARATOR + URL_PREFIX_CLASS + dClass.getName();
    } else if (psiElement instanceof ApplicationDictionary) {
      ApplicationDictionary dictionary = (ApplicationDictionary) psiElement;
      elementRef = URL_PREFIX_DICTIONARY + dictionary.getName();
    } else if (psiElement instanceof Suite) {
      Suite suite = (Suite) psiElement;
      elementRef = "dictionary:" + suite.getDictionary().getName() + TYPE_SEPARATOR + URL_PREFIX_SUITE + suite.getName();
    } else if (psiElement instanceof AppleScriptCommand) {
      AppleScriptCommand cmd = (AppleScriptCommand) psiElement;
      elementRef = "dictionary:" + cmd.getDictionary().getName() + TYPE_SEPARATOR + "suite" + ELEMENT_NAME_SEPARATOR + cmd.getSuite().getName
          () + TYPE_SEPARATOR + URL_PREFIX_COMMAND + cmd.getName();
    }
    if (StringUtil.isEmpty(elementRef)) return null;

    final String result = "<a href=\"" + DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + elementRef + "\">" + label + "</a>";
    sb.append(result);
    return result;
  }

  static PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
    PsiElement result = null;

    int dicNameIdxEnt = link.indexOf(TYPE_SEPARATOR) > 0 ? link.indexOf(TYPE_SEPARATOR) : link.length();
    final String dictionaryName = link.substring("dictionary".length() + 1, dicNameIdxEnt);
    AppleScriptProjectDictionaryService dictionaryRegistry =  
        ServiceManager.getService(context.getProject(), AppleScriptProjectDictionaryService.class);
    ApplicationDictionary dictionary = null;
    if (dictionaryRegistry != null) {
      dictionary = dictionaryRegistry.getDictionary(dictionaryName);//todo: dictionaryName != applicationName !NB!
      if (dictionary == null) {
        for (ApplicationDictionary dict : dictionaryRegistry.getDictionaries()) {
          if (dict.getName().equals(dictionaryName)) {
            dictionary = dict;
            break;
          }
        }
      }
    }
    int typeIndexStart = link.lastIndexOf(TYPE_SEPARATOR);
    int hashIndex = link.indexOf("#");
    String typeName = link.substring(typeIndexStart + TYPE_SEPARATOR.length(), hashIndex);
    String targetName = link.substring(hashIndex + 1);

    int SuiteIdxStart = link.lastIndexOf(ELEMENT_NAME_SEPARATOR);
    if ("class".equals(typeName)) {
      final String suiteName = link.substring(SuiteIdxStart + ELEMENT_NAME_SEPARATOR.length(), typeIndexStart);

      Suite suite = dictionary != null ? dictionary.findSuiteByName(suiteName) : null;
      result = suite != null ? suite.findClassByCode(targetName) : null;//search in suite first
      if (result == null) result = dictionary != null ? dictionary.findClass(targetName) : null;
    } else if ("command".equals(typeName)) {
      final String suiteName = link.substring(SuiteIdxStart + ELEMENT_NAME_SEPARATOR.length(), typeIndexStart);

      Suite suite = dictionary != null ? dictionary.findSuiteByName(suiteName) : null;
      result = suite != null ? suite.findCommandByCode(targetName) : null;//search in suite first§
      if (result == null) result = dictionary != null ? dictionary.findCommand(targetName) : null;
    } else if ("dictionary".equals(typeName)) {
      result = dictionary;
    } else if ("suite".equals(typeName)) {
      result = dictionary != null ? dictionary.findSuiteByName(targetName) : null;
    }
    return result;
  }

  public static void appendClassAttributes(@NotNull StringBuilder sb, @NotNull AppleScriptClass dictionaryClass) {
    List<AppleScriptClass> classElements = dictionaryClass.getElements();
    List<AppleScriptPropertyDefinition> classProperties = dictionaryClass.getProperties();
    final String indent = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    if (!classElements.isEmpty()) {
      sb.append("<p>").append(indent).append("ELEMENTS <br>").append(indent).append("contains ");
      Iterator<AppleScriptClass> it = classElements.iterator();
      AppleScriptClass aClass = it.next();
      appendElementLink(sb, aClass, aClass.getName());
      while (it.hasNext()) {
        aClass = it.next();
        sb.append(", ");
        appendElementLink(sb, aClass, aClass.getName());
      }
      sb.append(".</p>");
    }
    if (!classProperties.isEmpty()) {
      sb.append("<p>").append(indent).append("PROPERTIES <br>");
      for (AppleScriptPropertyDefinition prop : classProperties) {
        sb.append(indent);
        appendClassProperty(sb, prop);
      }
      sb.append("</p>");
    }
    List<AppleScriptCommand> commandsToRespond = dictionaryClass.getRespondingCommands();
    if (!commandsToRespond.isEmpty()) {
      sb.append("<p>").append(indent).append("RESPONDS TO: <br>").append(indent);
      Iterator<AppleScriptCommand> it = commandsToRespond.iterator();
      AppleScriptCommand cmd = it.next();
      appendElementLink(sb, cmd, cmd.getName());
      while (it.hasNext()) {
        cmd = it.next();
        sb.append(", ");
        appendElementLink(sb, cmd, cmd.getName());
      }
    }
  }

  private static void appendClassProperty(@NotNull StringBuilder sb, @NotNull AppleScriptPropertyDefinition prop) {
    String accessType = prop.getAccessType() == AccessType.R ? ", r/o" : "";
    sb.append("<b>").append(prop.getName()).append("</b> ").append("(").append(prop.getTypeSpecifier()).
        append(accessType).append(") : ").append(StringUtil.notNullize(prop.getDescription())).append("<br>");
  }
}