package com.idea.plugin.applescript.lang.ide;

import com.idea.plugin.applescript.lang.ide.sdef.AppleScriptProjectDictionaryRegistry;
import com.idea.plugin.applescript.lang.sdef.*;
import com.idea.plugin.applescript.psi.AppleScriptPsiElement;
import com.intellij.codeInsight.documentation.DocumentationManagerProtocol;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 24.08.2015.
 */
public class AppleScriptDocHelper {
  public static final String URL_PREFIX_DICTIONARY = "dictionary#";
  public static final String URL_PREFIX_SUITE = "suite#";
  public static final String URL_PREFIX_CLASS = "class#";
  public static final String TYPE_SEPARATOR = "/";
  public static final String ELEMENT_NAME_SEPARATOR = ":";


  public static String appendElementLink(StringBuilder sb, AppleScriptPsiElement psiElement, String label) {
    String elementRef = "";
//    label = label.replace(".",".");
//    String sampleLink = "psi_element://#dictionary:Mail.xml#class:item";
    String sampleClassLink = "psi_element://class#Mail.xml:item";
    String sample2ClassLink = "psi_element://dictionary:Finder.xml/suite:fndr/class#ctnr"; //this one does not work
    // (dup. codes)
    String sample3ClassLink = "psi_element://dictionary:Finder.xml/suite:Finder Basics/class#icon family"; //this one
    String sampleDictionaryLink = "psi_element://dictionary#Finder.xml";
    String sampleSuiteLink = "psi_element://dictionary:Finder.xml/suite#Finder Basics";
    if (psiElement instanceof AppleScriptClass) {
      AppleScriptClass dClass = (AppleScriptClass) psiElement;
      elementRef = "dictionary:" + dClass.getDictionary().getName() + TYPE_SEPARATOR + "suite" +
              ELEMENT_NAME_SEPARATOR + dClass.getSuite().getName() + TYPE_SEPARATOR +
              URL_PREFIX_CLASS + dClass.getName();
    } else if (psiElement instanceof ApplicationDictionary) {
      ApplicationDictionary dictionary = (ApplicationDictionary) psiElement;
      elementRef = URL_PREFIX_DICTIONARY + dictionary.getName();
    } else if (psiElement instanceof Suite) {
      Suite suite = (Suite) psiElement;
      elementRef = "dictionary:" + suite.getDictionary().getName() + TYPE_SEPARATOR + URL_PREFIX_SUITE +
              suite.getName();
    }
    if (StringUtil.isEmpty(elementRef)) return null;

    final String result = "<a href=\"" + DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + elementRef +
            "\">" + label + "</a>";
    sb.append(result);
    return result;
  }

  public static PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
    PsiElement result = null;

    int dicNameIdxEnt = link.indexOf(TYPE_SEPARATOR) > 0 ? link.indexOf(TYPE_SEPARATOR) : link.length();
    final String dictionaryName = link.substring("dictionary".length() + 1, dicNameIdxEnt);
    AppleScriptProjectDictionaryRegistry dictionaryRegistry = context.getProject()
            .getComponent(AppleScriptProjectDictionaryRegistry.class);
    ApplicationDictionary dictionary = null;
    if (dictionaryRegistry != null) {
      dictionary = dictionaryRegistry.getDictionary(dictionaryName);
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
      if (result == null)
        result = dictionary != null ? dictionary.findClassByName(targetName) : null;
    } else if ("dictionary".equals(typeName)) {
      result = dictionary;
    } else if ("suite".equals(typeName)) {
      result = dictionary != null ? dictionary.findSuiteByName(targetName) : null;
    }
//    result = ParsableScriptSuiteRegistryHelper.findClassWithName(className);
    return result;
  }

  public static void appendClassAttributes(@NotNull StringBuilder sb, @NotNull AppleScriptClass dictionaryClass) {
    List<String> classElements = dictionaryClass.getElementNames();
    List<AppleScriptPropertyDefinition> classProperties = dictionaryClass.getProperties();
    final String indent = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    if (!classElements.isEmpty()) {
      sb.append("<p>").append(indent).append("ELEMENTS <br>").append(indent).append("contains ");
      Iterator<String> it = classElements.iterator();
      String className = it.next();
      AppleScriptClass aClass = dictionaryClass.getDictionary().findClassByName(className);
      if (aClass != null) {
        appendElementLink(sb, aClass, aClass.getName());
      } else {
        sb.append(className);
      }
      while (it.hasNext()) {
        className = it.next();
        aClass = dictionaryClass.getDictionary().findClassByName(className);
        sb.append(", ");
        if (aClass != null) {
          appendElementLink(sb, aClass, aClass.getName());
        } else {
          sb.append(className);
        }
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
  }

  public static void appendClassProperty(@NotNull StringBuilder sb, @NotNull AppleScriptPropertyDefinition prop) {
    String accessType = prop.getAccessType() == AccessType.R ? ", r/o" : "";
    sb.append("<b>").append(prop.getName()).append("</b> ").append("(").append(prop.getTypeSpecifier()).
            append(accessType).append(") : ").append(StringUtil.notNullize(prop.getDescription())).append("<br>");
  }
}