package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.lang.sdef.ApplicationDictionary;
import com.intellij.lang.LanguagePerFileMappings;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
  public static final String CACHED_DICTIONARIES_SYSTEM_FOLDER = PathManager.getSystemPath() + "/sdef";

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
    LibraryTable globalLibraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable();
    addSuitesFromLibraryTable(result, projectLibraryTable);
    addSuitesFromLibraryTable(result, globalLibraryTable);
    result.add(new ScriptSuiteRegistry(ScriptSuiteRegistry.STD_LIBRARY_NAME, getProject()));
    return result;
  }

  private void addSuitesFromLibraryTable(List<ScriptSuiteRegistry> result, LibraryTable projectLibraryTable) {
    for (Library lib : projectLibraryTable.getLibraries()) {
      ArrayList<VirtualFile> collectedFiles = new ArrayList<VirtualFile>();
      if (lib instanceof LibraryEx) {
        LibraryEx libEx = (LibraryEx) lib;
        if (libEx.getKind() == AppleScriptLibraryKind.INSTANCE) {
          collectedFiles.addAll(Arrays.asList(libEx.getFiles(OrderRootType.CLASSES)));
          if (libEx.getName() != null) {
            LibraryProperties properties = libEx.getProperties();
            ScriptSuiteRegistry registry;
            List<VirtualFile> cachedDictionaries = new ArrayList<VirtualFile>();
            if (properties instanceof AppleScriptLibraryProperties) {
              AppleScriptLibraryProperties scriptProperties = (AppleScriptLibraryProperties) properties;
              Collection<String> cachedDictionaryUrls = scriptProperties.getCachedDictionaryUrls();
              if (cachedDictionaryUrls.isEmpty()) {
                Map<VirtualFile, String> cachedDictionaryFileUrlMap;
                LibraryEx.ModifiableModelEx modifiableModel = libEx.getModifiableModel();
                cachedDictionaryFileUrlMap = serializeDictionaryFilesForLibrary(libEx, OrderRootType.CLASSES,
                        getProject());

                cacheDictionaries(cachedDictionaryFileUrlMap);

                if (!cachedDictionaryFileUrlMap.values().isEmpty()) {
                  modifiableModel.setProperties(new AppleScriptLibraryProperties(cachedDictionaryFileUrlMap.values()));
                }
                cachedDictionaryUrls.addAll(cachedDictionaryFileUrlMap.values());
              }
              for (String fileUrl : cachedDictionaryUrls) {
                File finalXmlFile = new File(fileUrl);
                VirtualFile virtualXmlFile = LocalFileSystem.getInstance().findFileByIoFile(finalXmlFile);
                if (virtualXmlFile != null)
                  cachedDictionaries.add(virtualXmlFile);

              }
            }

            if (cachedDictionaries.isEmpty()) {
              registry = new ScriptSuiteRegistry(libEx.getName(), getProject(), collectedFiles);
            } else {
              System.out.println("! Using cached dictionaries for suite initialization !");
              registry = new ScriptSuiteRegistry(libEx.getName(), getProject(), cachedDictionaries);
            }
            result.add(registry);
          }
        }
      }

    }
  }

  private void cacheDictionaries(Map<VirtualFile, String> cachedDictionaryFileUrlMap) {

    try {
      System.out.println("=== Caching Dictionaries Started ===");
      char sep = File.separatorChar;
      for (Map.Entry<VirtualFile, String> pair : cachedDictionaryFileUrlMap.entrySet()) {
        String cmdName;
        if ("xml".equals(pair.getKey().getExtension())) {
          cmdName = "cat";
        } else {
          cmdName = "sdef";
        }

        final String appFileFinalPath = "\"" + pair.getKey().getPath() + "\"";
        final String finalFilePath = pair.getValue();
        File targetFile = new File(finalFilePath);
        if (!targetFile.getParentFile().exists()) {// if directory does not exist, create one
          targetFile.getParentFile().mkdirs();
        }
        if (targetFile.getParentFile().exists()) {
          String[] shellCommand = new String[]{"/bin/bash", "-c", " " + cmdName + " " + appFileFinalPath + " > " +
                  finalFilePath};
          System.out.println("executing command: " + Arrays.toString(shellCommand));
          long execStart = System.currentTimeMillis();
          int exitCode = Runtime.getRuntime().exec(shellCommand).waitFor();
          long execEnd = System.currentTimeMillis();
          System.out.println("Exit code = " + exitCode + " Execution time: " + (execEnd - execStart) + " ms.");
        }
//        File finalXmlFile = new File(finalFilePath);
//        VirtualFile virtualXmlFile = LocalFileSystem.getInstance().findFileByIoFile(finalXmlFile);
//        readDictionaryFromXmlFile(virtualXmlFile, project);
//        finalXmlFile.delete();
//      finalXmlFile.deleteOnExit();

      }
      System.out.println("=== Caching Dictionaries Completed ===");
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private Map<VirtualFile, String> serializeDictionaryFilesForLibrary(LibraryEx libEx, OrderRootType classes, Project
          project) {
    Map<VirtualFile, String> result = new HashMap<VirtualFile, String>();
    char sep = File.separatorChar;
    final String myCacheDir = CACHED_DICTIONARIES_SYSTEM_FOLDER + sep + project.getName() + sep + libEx.getName();

    for (VirtualFile vFile : Arrays.asList(libEx.getFiles(OrderRootType.CLASSES))) {
      final String cachedFileName = myCacheDir + sep + vFile.getNameWithoutExtension().replace(" ", "_") +
              "_generated.xml";
      result.put(vFile, cachedFileName);
    }
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
