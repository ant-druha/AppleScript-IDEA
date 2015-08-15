package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.lang.LanguagePerFileMappings;
import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey.Dernov on 8/10/2015.
 */
@State(
        name = ScriptSuiteRegistryMappings.COMPONENT_NAME,
        storages = {
                @Storage(file = StoragePathMacros.PROJECT_FILE),
                @Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/appleScriptLibraryMappings.xml", scheme =
                        StorageScheme.DIRECTORY_BASED)
        }
)
public class ScriptSuiteRegistryMappings extends LanguagePerFileMappings<ScriptSuiteRegistry> {
  public static final String COMPONENT_NAME = "ScriptSuiteRegistryMappings";

//  private final Map<VirtualFile, ScriptSuiteRegistry> suiteRegistryPerScriptMap = ContainerUtil.newHashMap();

  public ScriptSuiteRegistryMappings(@NotNull Project project) {
    super(project);

  }

  public void associate(VirtualFile file, ScriptSuiteRegistry suiteRegistry) {
    if (file == null || suiteRegistry == null) return;

    setMapping(file, suiteRegistry);

  }

  public static ScriptSuiteRegistryMappings getInstance(@NotNull Project project) {
    return ServiceManager.getService(project, ScriptSuiteRegistryMappings.class);
  }

  @NotNull
  @Override
  protected String getValueAttribute() {
    return "suiteLibrary";
  }

  @Nullable
  @Override
  protected ScriptSuiteRegistry handleUnknownMapping(VirtualFile file, String value) {
    ScriptSuiteRegistry myLibrary = new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, getProject());
    VirtualFile applicationBundleFile = getVirtualFileFromPath(value);
    if (applicationBundleFile != null) {
      ApplicationDictionary dictionary = new ApplicationDictionary(getProject(), applicationBundleFile);
      myLibrary.addApplicationDictionary(dictionary);
    }
    return myLibrary;
  }

  @Contract("null -> null")
  @Nullable
  private static VirtualFile getVirtualFileFromPath(@Nullable String value) {
    if (value == null) return null;
    return LocalFileSystem.getInstance().findFileByPath(value);
  }

  @Override
  protected List<ScriptSuiteRegistry> getAvailableValues() {
    List<ScriptSuiteRegistry> result = new ArrayList<ScriptSuiteRegistry>();
    LibraryTable projectLibraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable(getProject());
    for (Library lib : projectLibraryTable.getLibraries()) {
      ArrayList<VirtualFile> collectedFiles = new ArrayList<VirtualFile>();
      if (lib instanceof LibraryEx) {
        LibraryEx libEx = (LibraryEx) lib;
        if (libEx.getKind() == AppleScriptLibraryKind.INSTANCE) {
          collectedFiles.addAll(Arrays.asList(libEx.getFiles(OrderRootType.CLASSES)));
          if (libEx.getName() != null) {
            ScriptSuiteRegistry registry = new ScriptSuiteRegistry(libEx.getName(), getProject(), collectedFiles);
            result.add(registry);
          }
        }
      }

    }

    result.add(new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, getProject()));
    return result;
  }

  @Nullable
  @Override
  protected String serialize(ScriptSuiteRegistry scriptSuiteRegistry) {
    //return comma separated list of library names
    //    for (ApplicationDictionary dic : scriptSuiteRegistry.getApplicationDictionaries()) {
//      sb.append(sep).append(dic.getApplicationFile().getPath());
//      sep = ",";
//    }
    return "{" + scriptSuiteRegistry.getName() + "}";
  }


}
