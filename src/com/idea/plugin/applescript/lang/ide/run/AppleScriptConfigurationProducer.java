package com.idea.plugin.applescript.lang.ide.run;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;

public class AppleScriptConfigurationProducer extends RunConfigurationProducer<AppleScriptRunConfiguration> {

  public AppleScriptConfigurationProducer() {
    super(new AppleScriptConfigurationType());
  }

  @Override
  protected boolean setupConfigurationFromContext(AppleScriptRunConfiguration configuration, ConfigurationContext
          context, Ref<PsiElement> sourceElement) {
    PsiElement elem = context.getPsiLocation();
    boolean shouldSetUp = elem != null && elem.getContainingFile().getFileType() == AppleScriptFileType.INSTANCE;
    String scriptPath = elem != null ? elem.getContainingFile().getVirtualFile().getPath() : null;
    configuration.setScriptPath(scriptPath);
    String[] parts = scriptPath != null ? scriptPath.split("/") : null;
    if (parts != null && parts.length > 0) {
      configuration.setName(parts[parts.length - 1]);
    }
    return shouldSetUp;
  }

  @Override
  public boolean isConfigurationFromContext(AppleScriptRunConfiguration configuration, ConfigurationContext context) {
    PsiElement elem = context.getPsiLocation();
    VirtualFile currentFile = elem != null ? elem.getContainingFile().getVirtualFile() : null;

    boolean isSameFile = false;
    if (currentFile != null) {
      isSameFile = currentFile.getPath().equals(configuration.getScriptPath());
    }
    return isSameFile;
  }
}
