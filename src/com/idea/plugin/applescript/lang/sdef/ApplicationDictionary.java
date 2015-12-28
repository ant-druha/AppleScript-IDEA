package com.idea.plugin.applescript.lang.sdef;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
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
  String COCOA_STANDARD_LIBRARY = "Standard Terminology";
  // name for imitated dictionary which includes all installed in Osx ScriptingAdditions suites
  String SCRIPTING_ADDITIONS_LIBRARY = "Scripting Additions";
  String COCOA_STANDARD_LIBRARY_PATH = "/System/Library/ScriptingDefinitions/CocoaStandard.sdef";
  String[] SCRIPTING_ADDITIONS_FOLDERS = {"/System/Library/ScriptingAdditions/", "/Library/ScriptingAdditions/"};
  String SDEF_FOLDER = "/sdef";
  String COCOA_STANDARD_FILE = SDEF_FOLDER + "/CocoaStandard.sdef";
  String STANDARD_ADDITIONS_FILE = SDEF_FOLDER + "/StandardAdditions.sdef";
  String[] STANDARD_DEFINITION_FILES = {COCOA_STANDARD_FILE, STANDARD_ADDITIONS_FILE};
  String[] APP_BUNDLE_DIRECTORIES = new String[]{"/Applications", "/System/Library/CoreServices",
          "/Library/ScriptingAdditions"};

  @Nullable
  PsiFile processInclude(@NotNull XmlFile includedFile);

  boolean addSuite(Suite suite);

  @NotNull
  VirtualFile getDictionaryFile();

  @Nullable
  File getApplicationBundle();

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
