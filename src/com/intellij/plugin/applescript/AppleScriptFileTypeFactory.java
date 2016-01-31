package com.intellij.plugin.applescript;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;

/**
 * Andrey.Dernov 2/5/2015
 */
public class AppleScriptFileTypeFactory extends FileTypeFactory {
  @Override
  public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(AppleScriptFileType.INSTANCE,
            StringUtil.join(AppleScriptFileType.INSTANCE.getExtensions(), FileTypeConsumer.EXTENSION_DELIMITER));
  }
}