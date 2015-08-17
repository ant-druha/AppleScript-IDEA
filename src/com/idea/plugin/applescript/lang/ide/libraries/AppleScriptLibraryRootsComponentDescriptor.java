package com.idea.plugin.applescript.lang.ide.libraries;

import com.idea.plugin.applescript.lang.sdef.impl.ApplicationDictionaryImpl;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.ui.AttachRootButtonDescriptor;
import com.intellij.openapi.roots.libraries.ui.LibraryRootsComponentDescriptor;
import com.intellij.openapi.roots.libraries.ui.OrderRootTypePresentation;
import com.intellij.openapi.roots.libraries.ui.RootDetector;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.DefaultLibraryRootsComponentDescriptor;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 12.08.2015.
 */
public class AppleScriptLibraryRootsComponentDescriptor extends LibraryRootsComponentDescriptor {
  @Nullable
  @Override
  public OrderRootTypePresentation getRootTypePresentation(@NotNull OrderRootType type) {
    return DefaultLibraryRootsComponentDescriptor.getDefaultPresentation(type);
  }

  @NotNull
  @Override
  public List<? extends RootDetector> getRootDetectors() {
    return Arrays.asList(
            new AppleScriptLibRootDetector(OrderRootType.CLASSES, "choose classes"));
  }

  private class LibFileChooserDescriptor extends FileChooserDescriptor {
    public LibFileChooserDescriptor(final boolean chooseMultiple) {
      super(true, true, false, true, false, chooseMultiple);
    }

    @Override
    public boolean isFileSelectable(VirtualFile file) {
      return (file.isDirectory() || ApplicationDictionaryImpl.extensionSupported(file.getExtension())) && super
              .isFileSelectable(file);
    }

    @Override
    public boolean isFileVisible(VirtualFile file, boolean showHiddenFiles) {
      return super.isFileVisible(file, showHiddenFiles);
//      if (!(file.isDirectory() || myProvider.acceptsExtension(file.getExtension()))) return false;
//      return super.isFileVisible(file, showHiddenFiles);
    }
  }

  @NotNull
  @Override
  public List<? extends AttachRootButtonDescriptor> createAttachButtons() {
    List<AttachRootButtonDescriptor> myButtonDescriptors = new ArrayList<AttachRootButtonDescriptor>();
    myButtonDescriptors.add(new AttachFromButtonDescriptor(OrderRootType.CLASSES, "Attach dictionary file cls"));
    return myButtonDescriptors;
//    return Arrays.asList(new AttachUrlJavadocDescriptor());
  }


  private class AttachFromButtonDescriptor extends AttachRootButtonDescriptor {
    protected AttachFromButtonDescriptor(@NotNull OrderRootType orderRootType, @NotNull String buttonText) {
      super(orderRootType, buttonText);
    }

    @Override
    public VirtualFile[] selectFiles(@NotNull JComponent parent,
                                     @Nullable VirtualFile initialSelection,
                                     @Nullable Module contextModule,
                                     @NotNull LibraryEditor libraryEditor) {

      List<VirtualFile> collectedFiles = new ArrayList<VirtualFile>();
      FileChooserDescriptor chooserDescriptor = new LibFileChooserDescriptor(true);
      chooserDescriptor.setTitle("Select Application Dictionary Classes File");
      Project project = contextModule != null ? contextModule.getProject() : null;
      VirtualFile[] chosenFiles = FileChooser.chooseFiles(chooserDescriptor, parent, project, null);
      for (VirtualFile chosenFile : chosenFiles) {
        if (!chosenFile.isValid()) continue;

        if (chosenFile.isDirectory()) {
          collectFilesRecursively(collectedFiles, chosenFile, getRootType());
        } else if (ApplicationDictionaryImpl.extensionSupported(chosenFile.getExtension())) {
          collectedFiles.add(chosenFile);
        }
      }
      return VfsUtilCore.toVirtualFileArray(collectedFiles);
    }
  }

  private void collectFilesRecursively(final List<VirtualFile> collectedFiles, VirtualFile dir, final OrderRootType
          rootType) {
    VfsUtilCore.visitChildrenRecursively(dir, new VirtualFileVisitor() {
      @Override
      public boolean visitFile(@NotNull VirtualFile file) {
        if (!file.isDirectory() && (ApplicationDictionaryImpl.extensionSupported(file.getExtension()))) {
          collectedFiles.add(file);
        }
        return true;
      }
    });
  }

  private class AppleScriptLibRootDetector extends RootDetector {

    protected AppleScriptLibRootDetector(OrderRootType rootType, String presentableRootTypeName) {
      super(rootType, false, presentableRootTypeName);
    }

    @NotNull
    @Override
    public Collection<VirtualFile> detectRoots(@NotNull VirtualFile rootCandidate, @NotNull ProgressIndicator
            progressIndicator) {
      List<VirtualFile> result = new ArrayList<VirtualFile>();
      collectRoots(rootCandidate, result, progressIndicator);
      return result;
    }

    private void collectRoots(VirtualFile file, final List<VirtualFile> result, @NotNull final ProgressIndicator
            progressIndicator) {
      if (file.getFileSystem() instanceof JarFileSystem) {
        return;
      }
      VfsUtilCore.visitChildrenRecursively(file, new VirtualFileVisitor() {
        @Override
        public boolean visitFile(@NotNull VirtualFile file) {
          if (ApplicationDictionaryImpl.extensionSupported(file.getExtension())) {
            result.add(file);
          } else if (file.isDirectory()) {
            progressIndicator.setText2(file.getPath());
            progressIndicator.checkCanceled();
          }
          return true;
        }
      });
    }
  }
}
