package com.idea.plugin.applescript.lang.sdef;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 17.08.2015.
 */
public interface ApplicationDictionary extends DictionarySuite {
  //todo add sdef file types as xml
  List<String> SUPPORTED_EXTENSIONS = Arrays.asList("xml", "app", "osax");

  boolean addSuite(Suite suite);

  @NotNull
  VirtualFile getApplicationFile();

  List<DictionaryEnumeration> getDictionaryEnumerationList();

  List<DictionaryRecord> getDictionaryRecordList();

  Map<String, AppleScriptCommand> getDictionaryCommandMap();

  List<AppleScriptCommand> getDictionaryCommandList();

  List<AppleScriptClass> getDictionaryClassList();

  List<String> getParameterNamesForCommand(String name);

  List<AppleScriptPropertyDefinition> getDictionaryPropertyList();

  void setDictionaryPropertyList(List<AppleScriptPropertyDefinition> dictionaryPropertyList);

  ApplicationDictionary setRootTag(XmlTag myRootTag);

  XmlTag getRootTag();

  @NotNull
  List<AppleScriptCommand> getAllCommands();

  @Nullable
  Suite findSuiteByCode(String suiteCode);

  @Nullable
  Suite findSuiteByName(String suiteCode);
}
