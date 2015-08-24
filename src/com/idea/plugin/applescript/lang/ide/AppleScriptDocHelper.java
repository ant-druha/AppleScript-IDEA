package com.idea.plugin.applescript.lang.ide;

import com.idea.plugin.applescript.lang.parser.ParsableScriptSuiteRegistryHelper;
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
//    String sampleLink = "psi_element://#dictionary:Mail.xml#class:item";
    String sampleClassLink = "psi_element://class#Mail.xml:item";
    String sample2ClassLink = "psi_element://dictionary:Finder.xml/suite:fndr/class#ctnr"; //this one
    String sampleDictionaryLink = "psi_element://dictionary#Finder.xml";
    String sampleSuiteLink = "psi_element://dictionary:Finder.xml/suite#fndr";
    if (psiElement instanceof AppleScriptClass) {
      AppleScriptClass dClass = (AppleScriptClass) psiElement;
      elementRef = "dictionary:" + dClass.getDictionary().getName() + TYPE_SEPARATOR + "suite" +
              ELEMENT_NAME_SEPARATOR + dClass.getSuite().getCode() + TYPE_SEPARATOR +
              URL_PREFIX_CLASS + dClass.getCode();
    } else if (psiElement instanceof ApplicationDictionary) {
      ApplicationDictionary dictionary = (ApplicationDictionary) psiElement;
      elementRef = URL_PREFIX_DICTIONARY + dictionary.getName();
    }
    if (StringUtil.isEmpty(elementRef)) return null;

    final String result = "<a href=\"" + DocumentationManagerProtocol.PSI_ELEMENT_PROTOCOL + elementRef +
            "\">" + label + "</a>";
    sb.append(result);
    return result;
  }

  public static PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
    String classCode = null;
    PsiElement result = null;

    int dicNameIdxEnt = link.indexOf(TYPE_SEPARATOR) > 0 ? link.indexOf(TYPE_SEPARATOR) : link.length();
    final String dictionaryName = link.substring("dictionary".length() + 1, dicNameIdxEnt);

    int typeIndexStart = link.lastIndexOf(TYPE_SEPARATOR);
    int hashIndex = link.indexOf("#");
    String typeName = link.substring(typeIndexStart + TYPE_SEPARATOR.length(), hashIndex);

    if ("class".equals(typeName)) {
      int SuiteIdxStart = link.lastIndexOf(ELEMENT_NAME_SEPARATOR);
      final String suiteCode = link.substring(SuiteIdxStart + ELEMENT_NAME_SEPARATOR.length(), typeIndexStart);

      ApplicationDictionary dictionary = ParsableScriptSuiteRegistryHelper.findDictionaryByName(dictionaryName);
      Suite suite = dictionary != null ? dictionary.findSuiteByCode(suiteCode) : null;
      classCode = link.substring(hashIndex + 1);
      result = suite != null ? suite.findClassByCode(classCode) : null;//search in suite first
      if (result == null)
        result = dictionary != null ? dictionary.findClassByCode(classCode) : null;
    } else if ("dictionary".equals(typeName)) {
      result = ParsableScriptSuiteRegistryHelper.findDictionaryByName(dictionaryName);
    }
//    result = ParsableScriptSuiteRegistryHelper.getClassWithName(className);
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
      AppleScriptClass aClass = dictionaryClass.getDictionary().getClassByName(className);
      if (aClass != null) {
        appendElementLink(sb, aClass, aClass.getName());
      } else {
        sb.append(className);
      }
      while (it.hasNext()) {
        className = it.next();
        aClass = dictionaryClass.getDictionary().getClassByName(className);
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