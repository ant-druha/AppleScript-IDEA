package com.idea.plugin.applescript.lang.sdef;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey on 17.08.2015.
 */
public interface ApplicationDictionary extends DictionarySuite {

  List<String> STD_LIBRARY_NAMES = Arrays.asList("CocoaStandard", "StandardAdditions");
  List<String> SUPPORTED_EXTENSIONS = Arrays.asList("xml", "app", "osax");
  String[] STANDARD_DEFINITION_FILES = {"sdef/CocoaStandard.xml", "sdef/StandardAdditions.xml"};
  String[] APP_BUNDLE_DIRECTORIES = new String[]{"/Applications",
          "/System/Library/CoreServices", "/System/Library/CoreServices/Applications",
          "/Library/ScriptingAdditions"};

  @NotNull
  VirtualFile getCachedLibraryXmlFile();

  boolean addSuite(Suite suite);

  @NotNull
  VirtualFile getApplicationFile();

  @NotNull
  Map<String, DictionaryEnumeration> getDictionaryEnumerationMap();

  @NotNull
  Map<String, DictionaryEnumerator> getDictionaryEnumeratorMap();

  @NotNull
  Map<String, DictionaryRecord> getDictionaryRecordMap();

  @NotNull
  Map<String, AppleScriptCommand> getDictionaryCommandMap();

  @NotNull
  Map<String, AppleScriptClass> getDictionaryClassMap();

  @Nullable
  List<String> getParameterNamesForCommand(String name);

  @NotNull
  String getApplicationName();

  void setDisplayName(@NotNull String displayName);

  @Nullable
  DictionaryEnumerator findEnumerator(String name);

  @Nullable
  DictionaryEnumeration findEnumeration(String name);

  @Nullable
  AppleScriptPropertyDefinition findProperty(String name);

  @NotNull
  String getDisplayName();

  @NotNull
  Map<String, AppleScriptPropertyDefinition> getDictionaryPropertyMap();

  ApplicationDictionary setRootTag(XmlTag myRootTag);

  XmlTag getRootTag();

  @NotNull
  Collection<AppleScriptCommand> getAllCommands();

  @Nullable
  AppleScriptCommand findCommand(String name);

  @Nullable
  Suite findSuiteByCode(String suiteCode);

  @Nullable
  Suite findSuiteByName(String suiteCode);

  @Nullable
  CommandDirectParameter findDirectParameterForCommand(String commandName);

  @NotNull
  List<AppleScriptCommand> findAllCommandsWithName(String name);
}
