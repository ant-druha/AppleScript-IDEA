package com.intellij.plugin.applescript.lang.ide;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class AppleScriptLiveTemplatesProvider implements DefaultLiveTemplatesProvider {
  public static final String[] TEMPLATE_FILES = {"liveTemplates/AppleScriptLiveTemplates"};

  @Override
  public String[] getDefaultLiveTemplateFiles() {
    return TEMPLATE_FILES;
  }

  @Nullable
  @Override
  public String[] getHiddenLiveTemplateFiles() {
    return new String[0];
  }
}
