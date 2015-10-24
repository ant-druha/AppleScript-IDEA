package com.idea.plugin.applescript.highlighter;

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

import static com.idea.plugin.applescript.highlighter.AppleScriptSyntaxHighlighterColors.*;

/**
 * Created by Andrey on 04.04.2015.
 */
public class AppleScriptColorsAndFontsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] ATTRS;

    @NonNls
    private static final Map<String, TextAttributesKey> ourTags = new HashMap<String, TextAttributesKey>();

    static {
        ATTRS = new AttributesDescriptor[]{
                new AttributesDescriptor("Keyword", KEYWORD),
                new AttributesDescriptor("String", STRING),
                new AttributesDescriptor("Operator", OPERATION_SIGN),
                new AttributesDescriptor("Comment", COMMENT),
                new AttributesDescriptor("Dictionary command", DICTIONARY_COMMAND_ATTR),
        };

        ourTags.put("keyword", KEYWORD);
        ourTags.put("string", STRING);
        ourTags.put("operator", OPERATION_SIGN);
        ourTags.put("comment", COMMENT);
      ourTags.put("command", DICTIONARY_COMMAND_ATTR);
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
                "end if ## had some reports to print";
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
