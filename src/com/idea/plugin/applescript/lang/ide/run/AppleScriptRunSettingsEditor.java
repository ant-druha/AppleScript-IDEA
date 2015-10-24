package com.idea.plugin.applescript.lang.ide.run;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AppleScriptRunSettingsEditor extends SettingsEditor<AppleScriptRunConfiguration> {

  private Project project;
  AppleScriptRunConfiguration runConfiguration;
  private JPanel mainPanel;
  private TextFieldWithBrowseButton scriptTextField;

  public AppleScriptRunSettingsEditor(Project project, AppleScriptRunConfiguration runConfiguration) {
    this.project = project;
    this.runConfiguration = runConfiguration;

    FileChooserDescriptor descriptor = new FileChooserDescriptor(true, false, false, false, false, false);
    scriptTextField.addBrowseFolderListener("Chose script", "Please choose script to run", project, descriptor);
//    mainPanel.setEnabled(false);
  }

  @Override
  protected void resetEditorFrom(AppleScriptRunConfiguration configuration) {
    String scriptPath = configuration.getScriptPath();
    if (!StringUtil.isEmpty(scriptPath)) {
      scriptTextField.setText(scriptPath);
      String[] parts = scriptPath.split("/");
      if (parts.length > 0) {
        runConfiguration.setName(parts[parts.length - 1]);
      }
    }
  }

  @Override
  protected void applyEditorTo(AppleScriptRunConfiguration configuration) throws ConfigurationException {
    configuration.setScriptPath(scriptTextField.getText().trim());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return mainPanel;
  }

  @Nullable
  public String getScriptName() {
    return runConfiguration.getScriptPath();
  }
}
