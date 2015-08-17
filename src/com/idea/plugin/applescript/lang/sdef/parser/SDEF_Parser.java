package com.idea.plugin.applescript.lang.sdef.parser;

import com.idea.plugin.applescript.lang.sdef.*;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class SDEF_Parser {

  public static void parse(@NotNull XmlFile file, ApplicationDictionary parsedDictionary) {
    System.out.println("Start parsing xml file --- " + file.toString() + " ---");
    final XmlDocument document = file.getDocument();
    if (document != null) {
      final XmlTag rootTag = document.getRootTag();
      if (rootTag != null) {
        XmlAttribute attr = rootTag.getAttribute("title");
        if ("dictionary".equals(rootTag.getName()) && attr != null) {
          String dicTitle = attr.getValue();
          if (!StringUtil.isEmpty(dicTitle)) {
            parsedDictionary.setName(dicTitle);
          }
        }
        XmlTag[] suiteTags = rootTag.getSubTags();
        for (XmlTag suiteTag : suiteTags) {
          Suite suite = parseSuiteTag(suiteTag, parsedDictionary);

          XmlTag[] suiteCommands = suiteTag.findSubTags("command");
          for (XmlTag commandTag : suiteCommands) {
            AppleScriptCommand command = parseCommandTag(commandTag, suite);
            parsedDictionary.addCommand(command);
            suite.addCommand(command);
          }

          XmlTag[] suiteClasses = suiteTag.findSubTags("class");
          for (XmlTag classTag : suiteClasses) {
            AppleScriptClass appleScriptClass = parseClassTag(classTag, suite);
            parsedDictionary.addClass(appleScriptClass);
          }

          XmlTag[] suiteClassExtensions = suiteTag.findSubTags("class-extension");
          for (XmlTag classExtensionTag : suiteClassExtensions) {
            AppleScriptClass appleScriptClass = parseClassExtensionTag(classExtensionTag, parsedDictionary, suite);
            if (appleScriptClass != null) {
              parsedDictionary.addClass(appleScriptClass);
            }
          }

          XmlTag[] recordTypeTags = suiteTag.findSubTags("record-type");
          for (XmlTag recordTag : recordTypeTags) {
            DictionaryRecord record = parseRecordTag(recordTag, suite);
            parsedDictionary.addRecord(record);
          }

          XmlTag[] enumerationTags = suiteTag.findSubTags("enumeration");
          for (XmlTag enumerationTag : enumerationTags) {
            DictionaryEnumeration enumeration = parseEnumerationTag(enumerationTag, suite);
            parsedDictionary.addEnumeration(enumeration);
          }
          parsedDictionary.addSuite(suite);
        }

      }
    }
    System.out.println("parsing completed for file.");
  }

  private static Suite parseSuiteTag(XmlTag suiteTag, ApplicationDictionary dictionary) {
    //todo add all subtags to the suite here
    Suite result = null;
    String name = suiteTag.getAttributeValue("name");
    String code = suiteTag.getAttributeValue("code");
    String description = suiteTag.getAttributeValue("description");
    String hiddenVal = suiteTag.getAttributeValue("hidden");
    if (name != null && code != null) {
      result = new SuiteImpl(code, name, "yes".equals(hiddenVal), description, dictionary);
    }
    return result;
  }

  private static AppleScriptClass parseClassExtensionTag(XmlTag classExtensionTag, ApplicationDictionary dictionary,
                                                         Suite suite) {
    AppleScriptClass result = null;

    String parentClassName = classExtensionTag.getAttributeValue("extends");
    AppleScriptClass parentClass = dictionary.getClassByName(parentClassName);
    String parentClassCode = parentClass != null ? parentClass.getCode() : null;
    String description = classExtensionTag.getAttributeValue("description");

    List<AppleScriptPropertyDefinition> properties = new ArrayList<AppleScriptPropertyDefinition>();
    XmlTag[] propertyTags = classExtensionTag.findSubTags("property");

    if (parentClassName != null && parentClassCode != null) {
      for (XmlTag propTag : propertyTags) {
        AppleScriptPropertyDefinition property = null;
        String pName = propTag.getAttributeValue("name");
        String pCode = propTag.getAttributeValue("code");
        String pDescription = propTag.getAttributeValue("description");
        String pType = propTag.getAttributeValue("type");
        if (pName != null && pCode != null && pType != null) {
          property = new DictionaryPropertyImpl(pCode, pName, pType, suite, pDescription);
          properties.add(property);
        }

      }
      result = new DictionaryClass(parentClassCode, parentClassName, description, suite, properties);
    }
    return result;
  }

  private static DictionaryEnumeration parseEnumerationTag(XmlTag enumerationTag, Suite suite) {
    DictionaryEnumeration result = null;
    String name = enumerationTag.getAttributeValue("name");
    String code = enumerationTag.getAttributeValue("code");
    String description = enumerationTag.getAttributeValue("description");

    List<DictionaryEnumeratorImpl> enumConstants = new ArrayList<DictionaryEnumeratorImpl>();

    XmlTag[] enumTags = enumerationTag.findSubTags("enumerator");

    if (name != null && code != null) {
      for (XmlTag enumTag : enumTags) {
        DictionaryEnumeratorImpl enumConst = null;
        String eName = enumTag.getAttributeValue("name");
        String eCode = enumTag.getAttributeValue("code");
        String eDescription = enumTag.getAttributeValue("description");
        if (eName != null && eCode != null) {
          enumConst = new DictionaryEnumeratorImpl(eCode, eName, suite, eDescription);
          enumConstants.add(enumConst);
        }
      }
      result = new DictionaryEnumerationImpl(code, name, suite, description, enumConstants);
    }
    return result;
  }

  private static DictionaryRecord parseRecordTag(XmlTag recordTag, Suite suite) {
    DictionaryRecord result = null;
    String name = recordTag.getAttributeValue("name");
    String code = recordTag.getAttributeValue("code");
    String description = recordTag.getAttributeValue("description");

    List<AppleScriptPropertyDefinition> properties = new ArrayList<AppleScriptPropertyDefinition>();

    XmlTag[] propertyTags = recordTag.findSubTags("property");

    if (name != null && code != null) {
      for (XmlTag propTag : propertyTags) {
        AppleScriptPropertyDefinition property = null;
        String pName = propTag.getAttributeValue("name");
        String pCode = propTag.getAttributeValue("code");
        String pDescription = propTag.getAttributeValue("description");
        String pType = propTag.getAttributeValue("type");
        if (pName != null && pCode != null && pType != null) {
          property = new DictionaryPropertyImpl(pCode, pName, pType, suite, pDescription);
          properties.add(property);
        }

      }
      result = new DictionaryRecordDefinition(code, name, description, suite, properties);
    }
    return result;
  }

  private static AppleScriptClass parseClassTag(XmlTag classTag, Suite suite) {
    AppleScriptClass result = null;
    String name = classTag.getAttributeValue("name");
    String code = classTag.getAttributeValue("code");
    String description = classTag.getAttributeValue("description");

    List<AppleScriptPropertyDefinition> properties = new ArrayList<AppleScriptPropertyDefinition>();

    XmlTag[] propertyTags = classTag.findSubTags("property");

    if (name != null && code != null) {
      for (XmlTag propTag : propertyTags) {
        AppleScriptPropertyDefinition property = null;
        String pName = propTag.getAttributeValue("name");
        String pCode = propTag.getAttributeValue("code");
        String pDescription = propTag.getAttributeValue("description");
        String pType = propTag.getAttributeValue("type");
        if (pName != null && pCode != null && pType != null) {
          property = new DictionaryPropertyImpl(pCode, pName, pType, suite, pDescription);
          properties.add(property);
        }

      }
      result = new DictionaryClass(code, name, description, suite, properties);
    }


    return result;
  }

  private static AppleScriptCommand parseCommandTag(XmlTag commandTag, Suite suite) {
    AppleScriptCommand result = null;
    String name = commandTag.getAttributeValue("name");
    String code = commandTag.getAttributeValue("code");
    String description = commandTag.getAttributeValue("description");

    if (name == null || code == null) return null;

//    result = new AppleScriptCommandImpl(code, name, suite);
//    result.setDescription(description);

    XmlTag directParam = commandTag.findFirstSubTag("direct-parameter");
    CommandDirectParameter directParameter = null;
    if (directParam != null) {
      XmlAttribute type = directParam.getAttribute("type");
      XmlAttribute requiresAccess = directParam.getAttribute("requires-access");
      XmlAttribute paramDescription = directParam.getAttribute("description");
      XmlAttribute isOptionalAttr = directParam.getAttribute("optional");
      String typeVal = null;
      if (type != null) {
        typeVal = type.getValue();

      } else {//could be sub-tag
        XmlTag typeTag = directParam.findFirstSubTag("type");
        if (typeTag != null && typeTag.getAttribute("type") != null) {
          XmlAttribute typeAttr = typeTag.getAttribute("type");
          typeVal = typeAttr != null ? typeAttr.getValue() : null;
        }
      }
      boolean isOptional = isOptionalAttr != null && "yes".equals(isOptionalAttr.getValue());
      if (typeVal != null) {
        if (paramDescription != null) {
          directParameter = new CommandDirectParameter(typeVal, paramDescription.getValue(), isOptional);
        } else {
          directParameter = new CommandDirectParameter(typeVal, null, isOptional);
        }
      }
    }
    XmlTag[] parameters = commandTag.findSubTags("parameter");
    List<CommandParameter> commandParameters = new ArrayList<CommandParameter>();
    CommandParameter commandParameter = null;
    for (XmlTag paramTag : parameters) {
      String pName = paramTag.getAttributeValue("name");
      String pCode = paramTag.getAttributeValue("code");
      String pDescription = paramTag.getAttributeValue("description");
      String pType = paramTag.getAttributeValue("type");
      if (pType == null) {
        XmlTag typeSubTag = paramTag.findFirstSubTag("type");
        if (typeSubTag != null) {
          pType = typeSubTag.getAttributeValue("type");
        }
      }
      String pOptional = paramTag.getAttributeValue("optional");
      if (pName != null && pCode != null && pType != null) {
        boolean bOptional = false;
        if ("yes".equals(pOptional)) {
          bOptional = true;
        }
        commandParameter = new CommandParameterImpl(pName, pType, pCode, suite, pDescription, bOptional);
      }
      if (commandParameter != null) {
        commandParameters.add(commandParameter);
      }
    }
    result = new AppleScriptCommandImpl(name, code, suite, commandParameters, directParameter, null, description);
    return result;
  }
}
