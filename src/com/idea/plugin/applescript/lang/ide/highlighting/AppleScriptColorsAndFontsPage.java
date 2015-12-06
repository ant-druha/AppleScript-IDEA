package com.idea.plugin.applescript.lang.ide.highlighting;

import com.idea.plugin.applescript.AppleScriptFileType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Andrey 04.04.2015
 */
public class AppleScriptColorsAndFontsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] ATTRS;

  @NonNls
  private static final Map<String, TextAttributesKey> ourTags = new HashMap<String, TextAttributesKey>();

  static {
    ATTRS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", AppleScriptSyntaxHighlighterColors.KEYWORD),
            new AttributesDescriptor("String", AppleScriptSyntaxHighlighterColors.STRING),
            new AttributesDescriptor("Operator", AppleScriptSyntaxHighlighterColors.OPERATION_SIGN),
            new AttributesDescriptor("Comment", AppleScriptSyntaxHighlighterColors.COMMENT),
            new AttributesDescriptor("Dictionary command", AppleScriptSyntaxHighlighterColors
                    .DICTIONARY_COMMAND_ATTR),
            new AttributesDescriptor("Command parameter name", AppleScriptSyntaxHighlighterColors
                    .DICTIONARY_COMMAND_SELECTOR_ATTR),
            new AttributesDescriptor("Dictionary class", AppleScriptSyntaxHighlighterColors
                    .DICTIONARY_CLASS_ATTR),
            new AttributesDescriptor("Dictionary property", AppleScriptSyntaxHighlighterColors
                    .DICTIONARY_PROPERTY_ATTR),
            new AttributesDescriptor("Dictionary constant", AppleScriptSyntaxHighlighterColors
                    .DICTIONARY_CONSTANT_ATTR),
    };

    ourTags.put("keyword", AppleScriptSyntaxHighlighterColors.KEYWORD);
    ourTags.put("string", AppleScriptSyntaxHighlighterColors.STRING);
    ourTags.put("operator", AppleScriptSyntaxHighlighterColors.OPERATION_SIGN);
    ourTags.put("comment", AppleScriptSyntaxHighlighterColors.COMMENT);
    ourTags.put("command", AppleScriptSyntaxHighlighterColors.DICTIONARY_COMMAND_ATTR);
    ourTags.put("command parameter", AppleScriptSyntaxHighlighterColors.DICTIONARY_COMMAND_SELECTOR_ATTR);
    ourTags.put("dictionary class", AppleScriptSyntaxHighlighterColors.DICTIONARY_CLASS_ATTR);
    ourTags.put("dictionary property", AppleScriptSyntaxHighlighterColors.DICTIONARY_PROPERTY_ATTR);
    ourTags.put("dictionary constant", AppleScriptSyntaxHighlighterColors.DICTIONARY_CONSTANT_ATTR);
  }


  @Nullable
  @Override
  public Icon getIcon() {
    return AppleScriptFileType.INSTANCE.getIcon();
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new AppleScriptSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "searchFiles for ff of minimumValue(2, 3) for \"LeChateau\"\n" +
            "text from word (copy 5 to c) to word 4 of \"We're all in this together\"\n" +
            "minimumValue(2, maximumValue(x, y))\n" +
            "if file_type comes before \"APPL\" then copy 5 to c\n" +
            "if reportsToPrint > 0 then\n" +
            "    tell application \"ReportWizard\"\n" +
            "    -- Statements to print the reports.\n" +
            "    end tell\n" +
            "end if ## had some reports to print\n" +
            "tell application \"TextEdit\"\n" +
            "  <command>make</command> <command parameter>new</command parameter> " +
            "<dictionary class>document</dictionary class> <command parameter>with properties</command parameter> " +
            "{name:\"Doc Name\", text:\"Now I can create new documents ¬ \nusing " +
            "AppleScript.\"}\n" +
            "  get <dictionary property>message id</dictionary property> of it's " +
            "<dictionary class>mailbox</dictionary class>\n" +
            "  <command>close</command>\n" +
            "  get <dictionary class>character</dictionary class>\n" +
            "  set pathToSpec to <dictionary constant>application support</dictionary constant>\n" +
            "  set character to 1234\n" +
            "end tell";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return ourTags;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return ATTRS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "Apple Script";
  }
}
