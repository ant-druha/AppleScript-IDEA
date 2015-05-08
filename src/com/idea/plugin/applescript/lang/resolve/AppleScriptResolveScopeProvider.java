package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.OrderEntry;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.ResolveScopeProvider;
import com.intellij.psi.search.GlobalSearchScope;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Set;

/**
 * Created by Andrey on 15.04.2015.
 */
public class AppleScriptResolveScopeProvider extends ResolveScopeProvider {
    @Nullable
    @Override
    public GlobalSearchScope getResolveScope(@NotNull VirtualFile file, Project project) {
        final Set<VirtualFile> roots = new THashSet<VirtualFile>();
        final ProjectFileIndex fileIndex = ProjectRootManager.getInstance(project).getFileIndex();

        for (OrderEntry orderEntry : fileIndex.getOrderEntriesForFile(file)) {
            Collections.addAll(roots, orderEntry.getFiles(OrderRootType.SOURCES));
        }

        final GlobalSearchScope scope = GlobalSearchScope.projectScope(project);
        return GlobalSearchScope.getScopeRestrictedByFileTypes(scope, AppleScriptFileType.INSTANCE);
    }

}
