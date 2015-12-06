package com.idea.plugin.applescript.lang.sdef;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Andrey 17.08.2015
 */
public interface ApplicationDictionary extends DictionarySuite {

  List<String> SUPPORTED_DICTIONARY_EXTENSIONS = Arrays.asList("xml", "app", "osax", "sdef");
  List<String> SUPPORTED_APPLICATION_EXTENSIONS = Arrays.asList("app", "osax");
  // supported by default in a scriptable application
  String STANDARD_COCOA_LIBRARY = "CocoaStandard";
  // standard suite, provided by Mac OS X
  String STANDARD_ADDITIONS_LIBRARY = "StandardAdditions";
  List<String> STD_LIBRARY_NAMES = Arrays.asList(STANDARD_ADDITIONS_LIBRARY);
  String[] STANDARD_DEFINITION_FILES = {"sdef/CocoaStandard.xml", "sdef/StandardAdditions.xml"};
  String[] APP_BUNDLE_DIRECTORIES = new String[]{"/Applications", "/System/Library/CoreServices",
          "/Library/ScriptingAdditions"};

  @Nullable
  PsiFile processInclude(@NotNull VirtualFile includedFile);

  boolean addSuite(Suite suite);

  @NotNull
  VirtualFile getDictionaryFile();

  @Nullable
  VirtualFile getApplicationBundle();

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
  AppleScriptClass findClass(String name);

  @Nullable
  List<String> getParameterNamesForCommand(String name);

  @NotNull
  String getApplicationName();

  @Nullable
  DictionaryEnumerator findEnumerator(String name);

  @Nullable
  DictionaryEnumeration findEnumeration(String name);

  @Nullable
  AppleScriptPropertyDefinition findProperty(String name);

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
