package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.07.2015.
 */
public class CommandResult {
  @NotNull PsiType type;
  @Nullable String description;

  public CommandResult(@NotNull AppleScriptClassType type) {
    this.type = type;
  }

  public CommandResult(@NotNull PsiType type, @Nullable String description) {
    this.type = type;
    this.description = description;
  }
}
