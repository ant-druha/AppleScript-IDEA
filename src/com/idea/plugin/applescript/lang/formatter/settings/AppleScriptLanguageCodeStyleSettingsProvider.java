package com.idea.plugin.applescript.lang.formatter.settings;

import com.idea.plugin.applescript.AppleScriptLanguage;
import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrey on 11.04.2015.
 */
public class AppleScriptLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    @NotNull
    @Override
    public Language getLanguage() {
        return AppleScriptLanguage.INSTANCE;
    }

    @Override
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    public CommonCodeStyleSettings getDefaultCommonSettings() {
        CommonCodeStyleSettings defaultSettings = new CommonCodeStyleSettings(getLanguage());
        CommonCodeStyleSettings.IndentOptions indentOptions = defaultSettings.initIndentOptions();
        indentOptions.INDENT_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE = 4;
        indentOptions.TAB_SIZE = 2;
        return defaultSettings;
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
        return "searchFiles for ff of minimumValue(2, 3) for \"LeChateau\"\n" +
                "text from word (copy 5 to c) to word 4 of \"We're all in this together\"\n" +
                "minimumValue(2, maximumValue(x, y))\n" +
                "if file_type comes before \"APPL\" then copy 5 to c\n" +
                "on point({x, y})\n" +
                "  display dialog(\"x = \" & x & \", y = \" & y)\n" +
                "end point\n\n" +
                "if reportsToPrint > 0 then\n" +
                "    tell application \"ReportWizard\"\n" +
                "    -- Statements to print the reports.\n" +
                "    end tell\n" +
                "end if ## had some reports to print\n" +
                "{\"this\", \"is\", 1 + 1, \"cool\"} + 8\n" +
                "point({x, y})\n\n" +
                "if (x > y) then\n" +
                "  set myMessage to \" is greater than \"\n" +
                "else if (x < y) then\n" +
                "  set myMessage to \" is less than \"\n" +
                "else\n" +
                "  set myMessage to \" is equal to \"\n" +
                "end if";
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_BEFORE_METHOD_CALL_PARENTHESES",
                    "SPACE_BEFORE_METHOD_PARENTHESES",
                    "SPACE_BEFORE_IF_PARENTHESES",
                    "SPACE_AROUND_ASSIGNMENT_OPERATORS",
                    "SPACE_AROUND_LOGICAL_OPERATORS",
                    "SPACE_AROUND_EQUALITY_OPERATORS",
                    "SPACE_AROUND_RELATIONAL_OPERATORS",
                    "SPACE_AROUND_ADDITIVE_OPERATORS",
                    "SPACE_AROUND_MULTIPLICATIVE_OPERATORS",
                    "SPACE_AROUND_SHIFT_OPERATORS",
                    "SPACE_BEFORE_METHOD_LBRACE",
                    "SPACE_BEFORE_ELSE_LBRACE",
                    "SPACE_BEFORE_WHILE_KEYWORD",
                    "SPACE_BEFORE_ELSE_KEYWORD",
                    "SPACE_WITHIN_METHOD_CALL_PARENTHESES",
                    "SPACE_WITHIN_METHOD_PARENTHESES",
                    "SPACE_WITHIN_IF_PARENTHESES",
                    "SPACE_BEFORE_COLON",
                    "SPACE_AFTER_COLON",
                    "SPACE_AFTER_COMMA",
                    "SPACE_AFTER_COMMA_IN_TYPE_ARGUMENTS",
                    "SPACE_BEFORE_COMMA",
                    "SPACE_AROUND_UNARY_OPERATOR"
            );
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
        }
        else if (settingsType == SettingsType.WRAPPING_AND_BRACES_SETTINGS) {
            consumer.showStandardOptions("RIGHT_MARGIN",
                    "KEEP_LINE_BREAKS",
                    "KEEP_FIRST_COLUMN_COMMENT",
                    "BRACE_STYLE",
                    "METHOD_BRACE_STYLE",
                    "CALL_PARAMETERS_WRAP",
                    "CALL_PARAMETERS_LPAREN_ON_NEXT_LINE",
                    "CALL_PARAMETERS_RPAREN_ON_NEXT_LINE",
                    "METHOD_PARAMETERS_WRAP",
                    "METHOD_PARAMETERS_LPAREN_ON_NEXT_LINE",
                    "METHOD_PARAMETERS_RPAREN_ON_NEXT_LINE",
                    "ELSE_ON_NEW_LINE",
                    "ALIGN_MULTILINE_PARAMETERS",
                    "ALIGN_MULTILINE_PARAMETERS_IN_CALLS",
                    "ALIGN_MULTILINE_BINARY_OPERATION",
                    "BINARY_OPERATION_WRAP",
                    "BINARY_OPERATION_SIGN_ON_NEXT_LINE",
                    "PARENTHESES_EXPRESSION_LPAREN_WRAP",
                    "PARENTHESES_EXPRESSION_RPAREN_WRAP",
                    "SPECIAL_ELSE_IF_TREATMENT");
        }
    }
}
