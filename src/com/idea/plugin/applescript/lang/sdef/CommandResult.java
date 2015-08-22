package com.idea.plugin.applescript.lang.sdef;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Andrey on 03.07.2015.
 */
public class CommandResult {
  @NotNull private String type;
  @Nullable private String description;

  public CommandResult(@NotNull String type) {
    this.type = type;
  }

  public CommandResult(@NotNull String type, @Nullable String description) {
    this.type = type;
    this.description = description;
  }

  @NotNull
  public String getType() {
    return type;
  }

  @Nullable
  public String getDescription() {
    return description;
  }
}
