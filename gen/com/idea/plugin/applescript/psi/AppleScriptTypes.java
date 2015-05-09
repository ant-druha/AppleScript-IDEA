// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.idea.plugin.applescript.lang.parser.AppleScriptElementType;
import com.idea.plugin.applescript.lang.lexer.AppleScriptTokenType;
import com.idea.plugin.applescript.psi.impl.*;

public interface AppleScriptTypes {

  IElementType ADDITIVE_EXPRESSION = new AppleScriptElementType("ADDITIVE_EXPRESSION");
  IElementType APPLE_SCRIPT_PROPERTY = new AppleScriptElementType("APPLE_SCRIPT_PROPERTY");
  IElementType APPLICATION_OBJECT_REFERENCE = new AppleScriptElementType("APPLICATION_OBJECT_REFERENCE");
  IElementType APPLICATION_REFERENCE = new AppleScriptElementType("APPLICATION_REFERENCE");
  IElementType ARBITRARY_REFERENCE = new AppleScriptElementType("ARBITRARY_REFERENCE");
  IElementType A_REFERENCE_TO_LITERAL_EXPRESSION = new AppleScriptElementType("A_REFERENCE_TO_LITERAL_EXPRESSION");
  IElementType BLOCK_BODY = new AppleScriptElementType("BLOCK_BODY");
  IElementType BUILT_IN_CLASS_NAME = new AppleScriptElementType("BUILT_IN_CLASS_NAME");
  IElementType COERCION_BUILT_IN_EXPRESSION = new AppleScriptElementType("COERCION_BUILT_IN_EXPRESSION");
  IElementType COERCION_EXPRESSION = new AppleScriptElementType("COERCION_EXPRESSION");
  IElementType COERCION_EXTERNAL_EXPRESSION = new AppleScriptElementType("COERCION_EXTERNAL_EXPRESSION");
  IElementType COMPARE_EXPRESSION = new AppleScriptElementType("COMPARE_EXPRESSION");
  IElementType COMPONENT_NAME = new AppleScriptElementType("COMPONENT_NAME");
  IElementType CONCATENATION_EXPRESSION = new AppleScriptElementType("CONCATENATION_EXPRESSION");
  IElementType CONSIDERING_STATEMENT = new AppleScriptElementType("CONSIDERING_STATEMENT");
  IElementType CONSIDER_OR_IGNORE_ATTRIBUTE = new AppleScriptElementType("CONSIDER_OR_IGNORE_ATTRIBUTE");
  IElementType CONSTANT_LITERAL_EXPRESSION = new AppleScriptElementType("CONSTANT_LITERAL_EXPRESSION");
  IElementType CONTINUE_STATEMENT = new AppleScriptElementType("CONTINUE_STATEMENT");
  IElementType COUNT_COMMAND_EXPRESSION = new AppleScriptElementType("COUNT_COMMAND_EXPRESSION");
  IElementType CREATION_STATEMENT = new AppleScriptElementType("CREATION_STATEMENT");
  IElementType DATE_LITERAL_EXPRESSION = new AppleScriptElementType("DATE_LITERAL_EXPRESSION");
  IElementType DIRECT_PARAMETER_VAL = new AppleScriptElementType("DIRECT_PARAMETER_VAL");
  IElementType ERROR_COMMAND_EXPRESSION = new AppleScriptElementType("ERROR_COMMAND_EXPRESSION");
  IElementType EVERY_ELEM_REFERENCE = new AppleScriptElementType("EVERY_ELEM_REFERENCE");
  IElementType EXIT_STATEMENT = new AppleScriptElementType("EXIT_STATEMENT");
  IElementType EXPRESSION = new AppleScriptElementType("EXPRESSION");
  IElementType FILE_REFERENCE = new AppleScriptElementType("FILE_REFERENCE");
  IElementType FILTER_REFERENCE = new AppleScriptElementType("FILTER_REFERENCE");
  IElementType FORMAL_PARAMETER_LIST = new AppleScriptElementType("FORMAL_PARAMETER_LIST");
  IElementType GET_COMMAND_EXPRESSION = new AppleScriptElementType("GET_COMMAND_EXPRESSION");
  IElementType HANDLER_INTERLEAVED_PARAMETERS_CALL = new AppleScriptElementType("HANDLER_INTERLEAVED_PARAMETERS_CALL");
  IElementType HANDLER_INTERLEAVED_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_INTERLEAVED_PARAMETERS_DEFINITION");
  IElementType HANDLER_LABELED_PARAMETERS_CALL = new AppleScriptElementType("HANDLER_LABELED_PARAMETERS_CALL");
  IElementType HANDLER_LABELED_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_LABELED_PARAMETERS_DEFINITION");
  IElementType HANDLER_NAME_PART_DEFINITION = new AppleScriptElementType("HANDLER_NAME_PART_DEFINITION");
  IElementType HANDLER_NAME_PART_REFERENCE = new AppleScriptElementType("HANDLER_NAME_PART_REFERENCE");
  IElementType HANDLER_PARAMETER_LABEL = new AppleScriptElementType("HANDLER_PARAMETER_LABEL");
  IElementType HANDLER_POSITIONAL_PARAMETERS_CALL = new AppleScriptElementType("HANDLER_POSITIONAL_PARAMETERS_CALL");
  IElementType HANDLER_POSITIONAL_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_POSITIONAL_PARAMETERS_DEFINITION");
  IElementType IDENTIFIER = new AppleScriptElementType("IDENTIFIER");
  IElementType IF_COMPOUND_STATEMENT = new AppleScriptElementType("IF_COMPOUND_STATEMENT");
  IElementType IF_SIMPLE_STATEMENT = new AppleScriptElementType("IF_SIMPLE_STATEMENT");
  IElementType IGNORING_STATEMENT = new AppleScriptElementType("IGNORING_STATEMENT");
  IElementType INDEX_REFERENCE = new AppleScriptElementType("INDEX_REFERENCE");
  IElementType INTEGER_LITERAL_EXPRESSION = new AppleScriptElementType("INTEGER_LITERAL_EXPRESSION");
  IElementType LIST_LITERAL_EXPRESSION = new AppleScriptElementType("LIST_LITERAL_EXPRESSION");
  IElementType LOGICAL_AND_EXPRESSION = new AppleScriptElementType("LOGICAL_AND_EXPRESSION");
  IElementType LOGICAL_OR_EXPRESSION = new AppleScriptElementType("LOGICAL_OR_EXPRESSION");
  IElementType MIDDLE_ELEM_REFERENCE = new AppleScriptElementType("MIDDLE_ELEM_REFERENCE");
  IElementType MULTIPLICATIVE_EXPRESSION = new AppleScriptElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType NAME_REFERENCE = new AppleScriptElementType("NAME_REFERENCE");
  IElementType NUMERIC_CONSTANT = new AppleScriptElementType("NUMERIC_CONSTANT");
  IElementType OBJECT_REF = new AppleScriptElementType("OBJECT_REF");
  IElementType PARAMETER_VAL = new AppleScriptElementType("PARAMETER_VAL");
  IElementType PARENTHESIZED_EXPRESSION = new AppleScriptElementType("PARENTHESIZED_EXPRESSION");
  IElementType POWER_EXPRESSION = new AppleScriptElementType("POWER_EXPRESSION");
  IElementType PROPERTY_DECLARATION_STATEMENT = new AppleScriptElementType("PROPERTY_DECLARATION_STATEMENT");
  IElementType PROPERTY_REFERENCE = new AppleScriptElementType("PROPERTY_REFERENCE");
  IElementType RANGE_REFERENCE = new AppleScriptElementType("RANGE_REFERENCE");
  IElementType REAL_LITERAL_EXPRESSION = new AppleScriptElementType("REAL_LITERAL_EXPRESSION");
  IElementType RECORD_LITERAL_EXPRESSION = new AppleScriptElementType("RECORD_LITERAL_EXPRESSION");
  IElementType REFERENCE_EXPRESSION = new AppleScriptElementType("REFERENCE_EXPRESSION");
  IElementType REFERENCE_IDENTIFIER = new AppleScriptElementType("REFERENCE_IDENTIFIER");
  IElementType RELATIVE_REFERENCE = new AppleScriptElementType("RELATIVE_REFERENCE");
  IElementType REPEAT_FOREVER_STATEMENT = new AppleScriptElementType("REPEAT_FOREVER_STATEMENT");
  IElementType REPEAT_NUM_TIMES_STATEMENT = new AppleScriptElementType("REPEAT_NUM_TIMES_STATEMENT");
  IElementType REPEAT_UNTIL_STATEMENT = new AppleScriptElementType("REPEAT_UNTIL_STATEMENT");
  IElementType REPEAT_WHILE_STATEMENT = new AppleScriptElementType("REPEAT_WHILE_STATEMENT");
  IElementType REPEAT_WITH_LIST_STATEMENT = new AppleScriptElementType("REPEAT_WITH_LIST_STATEMENT");
  IElementType REPEAT_WITH_RANGE_STATEMENT = new AppleScriptElementType("REPEAT_WITH_RANGE_STATEMENT");
  IElementType RETURN_STATEMENT = new AppleScriptElementType("RETURN_STATEMENT");
  IElementType RUN_COMMAND_EXPRESSION = new AppleScriptElementType("RUN_COMMAND_EXPRESSION");
  IElementType SCRIPT_OBJECT_DEFINITION_STATEMENT = new AppleScriptElementType("SCRIPT_OBJECT_DEFINITION_STATEMENT");
  IElementType STRING_LITERAL_EXPRESSION = new AppleScriptElementType("STRING_LITERAL_EXPRESSION");
  IElementType TARGET_LIST_LITERAL = new AppleScriptElementType("TARGET_LIST_LITERAL");
  IElementType TARGET_RECORD_LITERAL = new AppleScriptElementType("TARGET_RECORD_LITERAL");
  IElementType TARGET_VARIABLE = new AppleScriptElementType("TARGET_VARIABLE");
  IElementType TELL_COMPOUND_STATEMENT = new AppleScriptElementType("TELL_COMPOUND_STATEMENT");
  IElementType TELL_SIMPLE_STATEMENT = new AppleScriptElementType("TELL_SIMPLE_STATEMENT");
  IElementType TEXT_ITEM_DELIMITERS_PROPERTY = new AppleScriptElementType("TEXT_ITEM_DELIMITERS_PROPERTY");
  IElementType TRY_STATEMENT = new AppleScriptElementType("TRY_STATEMENT");
  IElementType USER_PARAMETER_VAL = new AppleScriptElementType("USER_PARAMETER_VAL");
  IElementType USE_APPLE_SCRIPT_STATEMENT = new AppleScriptElementType("USE_APPLE_SCRIPT_STATEMENT");
  IElementType USE_APPLICATION_OR_SCRIPT_STATEMENT = new AppleScriptElementType("USE_APPLICATION_OR_SCRIPT_STATEMENT");
  IElementType USE_FRAMEWORK_STATEMENT = new AppleScriptElementType("USE_FRAMEWORK_STATEMENT");
  IElementType USE_SCRIPTING_ADDITIONS_STATEMENT = new AppleScriptElementType("USE_SCRIPTING_ADDITIONS_STATEMENT");
  IElementType USING_TERMS_FROM_STATEMENT = new AppleScriptElementType("USING_TERMS_FROM_STATEMENT");
  IElementType VARIABLE_DECLARATION_STATEMENT = new AppleScriptElementType("VARIABLE_DECLARATION_STATEMENT");
  IElementType WITH_TIMEOUT_STATEMENT = new AppleScriptElementType("WITH_TIMEOUT_STATEMENT");
  IElementType WITH_TRANSACTION_STATEMENT = new AppleScriptElementType("WITH_TRANSACTION_STATEMENT");

  IElementType ABOUT = new AppleScriptTokenType("about");
  IElementType ABOVE = new AppleScriptTokenType("above");
  IElementType ADDITIONS = new AppleScriptTokenType("additions");
  IElementType AFTER = new AppleScriptTokenType("after");
  IElementType AGAINST = new AppleScriptTokenType("against");
  IElementType ALIAS = new AppleScriptTokenType("alias");
  IElementType ANYTHING = new AppleScriptTokenType("anything");
  IElementType APART_FROM = new AppleScriptTokenType("apart from");
  IElementType APP = new AppleScriptTokenType("app");
  IElementType APPLICATION = new AppleScriptTokenType("application");
  IElementType APS = new AppleScriptTokenType("'s");
  IElementType AROUND = new AppleScriptTokenType("around");
  IElementType AS = new AppleScriptTokenType("as");
  IElementType ASIDE_FROM = new AppleScriptTokenType("aside from");
  IElementType ASK = new AppleScriptTokenType("ask");
  IElementType AT = new AppleScriptTokenType("at");
  IElementType BACK = new AppleScriptTokenType("back");
  IElementType BAND = new AppleScriptTokenType("&");
  IElementType BEFORE = new AppleScriptTokenType("before");
  IElementType BEGINNING = new AppleScriptTokenType("beginning");
  IElementType BEHIND = new AppleScriptTokenType("behind");
  IElementType BELOW = new AppleScriptTokenType("below");
  IElementType BENEATH = new AppleScriptTokenType("beneath");
  IElementType BESIDE = new AppleScriptTokenType("beside");
  IElementType BETWEEN = new AppleScriptTokenType("between");
  IElementType BUILT_IN_TYPE = new AppleScriptTokenType("BUILT_IN_TYPE");
  IElementType BUT = new AppleScriptTokenType("but");
  IElementType BY = new AppleScriptTokenType("by");
  IElementType CASE = new AppleScriptTokenType("case");
  IElementType CC = new AppleScriptTokenType("¬");
  IElementType CLOSE = new AppleScriptTokenType("close");
  IElementType COLON = new AppleScriptTokenType(":");
  IElementType COMMA = new AppleScriptTokenType(",");
  IElementType COMMENT = new AppleScriptTokenType("COMMENT");
  IElementType CONSIDERING = new AppleScriptTokenType("considering");
  IElementType CONTAIN = new AppleScriptTokenType("contain");
  IElementType CONTAINS = new AppleScriptTokenType("contains");
  IElementType CONTINUE = new AppleScriptTokenType("continue");
  IElementType COPY = new AppleScriptTokenType("copy");
  IElementType COUNT = new AppleScriptTokenType("count");
  IElementType CURRENT = new AppleScriptTokenType("current");
  IElementType DATE = new AppleScriptTokenType("date");
  IElementType DAYS_CONSTANT = new AppleScriptTokenType("days");
  IElementType DEC_EXPONENT = new AppleScriptTokenType("DEC_EXPONENT");
  IElementType DIACRITICALS = new AppleScriptTokenType("diacriticals");
  IElementType DIGITS = new AppleScriptTokenType("DIGITS");
  IElementType DIV = new AppleScriptTokenType("DIV");
  IElementType DOES = new AppleScriptTokenType("does");
  IElementType DOES_NOT_CONTAIN = new AppleScriptTokenType("DOES_NOT_CONTAIN");
  IElementType EACH = new AppleScriptTokenType("each");
  IElementType EIGHTH = new AppleScriptTokenType("eighth");
  IElementType ELSE = new AppleScriptTokenType("else");
  IElementType END = new AppleScriptTokenType("end");
  IElementType ENDS_WITH = new AppleScriptTokenType("ENDS_WITH");
  IElementType EQ = new AppleScriptTokenType("EQ");
  IElementType ERROR = new AppleScriptTokenType("error");
  IElementType EVERY = new AppleScriptTokenType("every");
  IElementType EXIT = new AppleScriptTokenType("exit");
  IElementType EXPANSION = new AppleScriptTokenType("expansion");
  IElementType FALSE = new AppleScriptTokenType("false");
  IElementType FIFTH = new AppleScriptTokenType("fifth");
  IElementType FILE = new AppleScriptTokenType("file");
  IElementType FIRST = new AppleScriptTokenType("first");
  IElementType FOR = new AppleScriptTokenType("for");
  IElementType FOURTH = new AppleScriptTokenType("fourth");
  IElementType FRAMEWORK = new AppleScriptTokenType("framework");
  IElementType FROM = new AppleScriptTokenType("from");
  IElementType FRONT = new AppleScriptTokenType("front");
  IElementType GE = new AppleScriptTokenType("GE");
  IElementType GET = new AppleScriptTokenType("get");
  IElementType GIVEN = new AppleScriptTokenType("given");
  IElementType GLOBAL = new AppleScriptTokenType("global");
  IElementType GT = new AppleScriptTokenType("GT");
  IElementType HOURS_CONSTANT = new AppleScriptTokenType("hours");
  IElementType HYPHENS = new AppleScriptTokenType("hyphens");
  IElementType IF = new AppleScriptTokenType("if");
  IElementType IGNORING = new AppleScriptTokenType("ignoring");
  IElementType IMPORTING = new AppleScriptTokenType("importing");
  IElementType IN = new AppleScriptTokenType("in");
  IElementType INDEX = new AppleScriptTokenType("index");
  IElementType INSTEAD_OF = new AppleScriptTokenType("instead of");
  IElementType INTO = new AppleScriptTokenType("into");
  IElementType INT_DIV = new AppleScriptTokenType("div");
  IElementType IS = new AppleScriptTokenType("is");
  IElementType IS_IN = new AppleScriptTokenType("IS_IN");
  IElementType IS_NOT_IN = new AppleScriptTokenType("IS_NOT_IN");
  IElementType IT = new AppleScriptTokenType("it");
  IElementType ITS = new AppleScriptTokenType("its");
  IElementType LAND = new AppleScriptTokenType("and");
  IElementType LAST = new AppleScriptTokenType("last");
  IElementType LAUNCH = new AppleScriptTokenType("launch");
  IElementType LCURLY = new AppleScriptTokenType("{");
  IElementType LE = new AppleScriptTokenType("LE");
  IElementType LINEFEED = new AppleScriptTokenType("linefeed");
  IElementType LNOT = new AppleScriptTokenType("not");
  IElementType LOCAL = new AppleScriptTokenType("local");
  IElementType LOR = new AppleScriptTokenType("or");
  IElementType LPAREN = new AppleScriptTokenType("(");
  IElementType LT = new AppleScriptTokenType("LT");
  IElementType MACHINE = new AppleScriptTokenType("machine");
  IElementType ME = new AppleScriptTokenType("me");
  IElementType MIDDLE = new AppleScriptTokenType("middle");
  IElementType MINUS = new AppleScriptTokenType("-");
  IElementType MINUTES_CONSTANT = new AppleScriptTokenType("minutes");
  IElementType MOD = new AppleScriptTokenType("mod");
  IElementType MULTI_LINE_COMMENT_END = new AppleScriptTokenType("*)");
  IElementType MULTI_LINE_COMMENT_START = new AppleScriptTokenType("(*");
  IElementType MY = new AppleScriptTokenType("my");
  IElementType NAMED = new AppleScriptTokenType("named");
  IElementType NE = new AppleScriptTokenType("NE");
  IElementType NINTH = new AppleScriptTokenType("ninth");
  IElementType NLS = new AppleScriptTokenType("NLS");
  IElementType NO = new AppleScriptTokenType("no");
  IElementType NUMBER = new AppleScriptTokenType("number");
  IElementType OF = new AppleScriptTokenType("of");
  IElementType ON = new AppleScriptTokenType("on");
  IElementType ONTO = new AppleScriptTokenType("onto");
  IElementType OUT_OF = new AppleScriptTokenType("out of");
  IElementType OVER = new AppleScriptTokenType("over");
  IElementType PARENT = new AppleScriptTokenType("parent");
  IElementType PARTIAL = new AppleScriptTokenType("partial");
  IElementType PI_CONSTANT = new AppleScriptTokenType("pi");
  IElementType PLUS = new AppleScriptTokenType("+");
  IElementType POW = new AppleScriptTokenType("^");
  IElementType PROP = new AppleScriptTokenType("prop");
  IElementType PROPERTY = new AppleScriptTokenType("property");
  IElementType PUNCTUATION = new AppleScriptTokenType("punctuation");
  IElementType PUT = new AppleScriptTokenType("put");
  IElementType QUOTE = new AppleScriptTokenType("quote");
  IElementType RAW_CODE = new AppleScriptTokenType("RAW_CODE");
  IElementType RCURLY = new AppleScriptTokenType("}");
  IElementType REF = new AppleScriptTokenType("ref");
  IElementType REFERENCE = new AppleScriptTokenType("reference");
  IElementType REF_OP = new AppleScriptTokenType("REF_OP");
  IElementType REPEAT = new AppleScriptTokenType("repeat");
  IElementType RESPONSES = new AppleScriptTokenType("responses");
  IElementType RESULT = new AppleScriptTokenType("result");
  IElementType RETURN = new AppleScriptTokenType("return");
  IElementType RETURNING = new AppleScriptTokenType("returning");
  IElementType RPAREN = new AppleScriptTokenType(")");
  IElementType RUN = new AppleScriptTokenType("run");
  IElementType SCRIPT = new AppleScriptTokenType("script");
  IElementType SCRIPTING = new AppleScriptTokenType("scripting");
  IElementType SECOND = new AppleScriptTokenType("second");
  IElementType SECONDS = new AppleScriptTokenType("seconds");
  IElementType SET = new AppleScriptTokenType("set");
  IElementType SEVENTH = new AppleScriptTokenType("seventh");
  IElementType SINCE = new AppleScriptTokenType("since");
  IElementType SIXTH = new AppleScriptTokenType("sixth");
  IElementType SOME = new AppleScriptTokenType("some");
  IElementType SPACE = new AppleScriptTokenType("space");
  IElementType STAR = new AppleScriptTokenType("*");
  IElementType STARTS_BEGINS_WITH = new AppleScriptTokenType("STARTS_BEGINS_WITH");
  IElementType STRING_LITERAL = new AppleScriptTokenType("STRING_LITERAL");
  IElementType TAB = new AppleScriptTokenType("tab");
  IElementType TELL = new AppleScriptTokenType("tell");
  IElementType TENTH = new AppleScriptTokenType("tenth");
  IElementType TERMS = new AppleScriptTokenType("terms");
  IElementType THAT = new AppleScriptTokenType("that");
  IElementType THEN = new AppleScriptTokenType("then");
  IElementType THE_KW = new AppleScriptTokenType("the");
  IElementType THIRD = new AppleScriptTokenType("third");
  IElementType THROUGH = new AppleScriptTokenType("through");
  IElementType THRU = new AppleScriptTokenType("thru");
  IElementType TIMEOUT = new AppleScriptTokenType("timeout");
  IElementType TIMES = new AppleScriptTokenType("times");
  IElementType TO = new AppleScriptTokenType("to");
  IElementType TRANSACTION = new AppleScriptTokenType("transaction");
  IElementType TRUE = new AppleScriptTokenType("true");
  IElementType TRY = new AppleScriptTokenType("try");
  IElementType UNDER = new AppleScriptTokenType("under");
  IElementType UNTIL = new AppleScriptTokenType("until");
  IElementType USE = new AppleScriptTokenType("use");
  IElementType USING = new AppleScriptTokenType("using");
  IElementType VAR_IDENTIFIER = new AppleScriptTokenType("var_identifier");
  IElementType VERSION = new AppleScriptTokenType("version");
  IElementType WEEKS_CONSTANT = new AppleScriptTokenType("weeks");
  IElementType WHERE = new AppleScriptTokenType("where");
  IElementType WHILE = new AppleScriptTokenType("while");
  IElementType WHOSE = new AppleScriptTokenType("whose");
  IElementType WITH = new AppleScriptTokenType("with");
  IElementType WITHOUT = new AppleScriptTokenType("without");
  IElementType YES = new AppleScriptTokenType("yes");
  IElementType ZONE = new AppleScriptTokenType("zone");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADDITIVE_EXPRESSION) {
        return new AppleScriptAdditiveExpressionImpl(node);
      }
      else if (type == APPLE_SCRIPT_PROPERTY) {
        return new AppleScriptAppleScriptPropertyImpl(node);
      }
      else if (type == APPLICATION_OBJECT_REFERENCE) {
        return new AppleScriptApplicationObjectReferenceImpl(node);
      }
      else if (type == APPLICATION_REFERENCE) {
        return new AppleScriptApplicationReferenceImpl(node);
      }
      else if (type == ARBITRARY_REFERENCE) {
        return new AppleScriptArbitraryReferenceImpl(node);
      }
      else if (type == A_REFERENCE_TO_LITERAL_EXPRESSION) {
        return new AppleScriptAReferenceToLiteralExpressionImpl(node);
      }
      else if (type == BLOCK_BODY) {
        return new AppleScriptBlockBodyImpl(node);
      }
      else if (type == BUILT_IN_CLASS_NAME) {
        return new AppleScriptBuiltInClassNameImpl(node);
      }
      else if (type == COERCION_BUILT_IN_EXPRESSION) {
        return new AppleScriptCoercionBuiltInExpressionImpl(node);
      }
      else if (type == COERCION_EXPRESSION) {
        return new AppleScriptCoercionExpressionImpl(node);
      }
      else if (type == COERCION_EXTERNAL_EXPRESSION) {
        return new AppleScriptCoercionExternalExpressionImpl(node);
      }
      else if (type == COMPARE_EXPRESSION) {
        return new AppleScriptCompareExpressionImpl(node);
      }
      else if (type == COMPONENT_NAME) {
        return new AppleScriptComponentNameImpl(node);
      }
      else if (type == CONCATENATION_EXPRESSION) {
        return new AppleScriptConcatenationExpressionImpl(node);
      }
      else if (type == CONSIDERING_STATEMENT) {
        return new AppleScriptConsideringStatementImpl(node);
      }
      else if (type == CONSIDER_OR_IGNORE_ATTRIBUTE) {
        return new AppleScriptConsiderOrIgnoreAttributeImpl(node);
      }
      else if (type == CONSTANT_LITERAL_EXPRESSION) {
        return new AppleScriptConstantLiteralExpressionImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new AppleScriptContinueStatementImpl(node);
      }
      else if (type == COUNT_COMMAND_EXPRESSION) {
        return new AppleScriptCountCommandExpressionImpl(node);
      }
      else if (type == CREATION_STATEMENT) {
        return new AppleScriptCreationStatementImpl(node);
      }
      else if (type == DATE_LITERAL_EXPRESSION) {
        return new AppleScriptDateLiteralExpressionImpl(node);
      }
      else if (type == DIRECT_PARAMETER_VAL) {
        return new AppleScriptDirectParameterValImpl(node);
      }
      else if (type == ERROR_COMMAND_EXPRESSION) {
        return new AppleScriptErrorCommandExpressionImpl(node);
      }
      else if (type == EVERY_ELEM_REFERENCE) {
        return new AppleScriptEveryElemReferenceImpl(node);
      }
      else if (type == EXIT_STATEMENT) {
        return new AppleScriptExitStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new AppleScriptExpressionImpl(node);
      }
      else if (type == FILE_REFERENCE) {
        return new AppleScriptFileReferenceImpl(node);
      }
      else if (type == FILTER_REFERENCE) {
        return new AppleScriptFilterReferenceImpl(node);
      }
      else if (type == FORMAL_PARAMETER_LIST) {
        return new AppleScriptFormalParameterListImpl(node);
      }
      else if (type == GET_COMMAND_EXPRESSION) {
        return new AppleScriptGetCommandExpressionImpl(node);
      }
      else if (type == HANDLER_INTERLEAVED_PARAMETERS_CALL) {
        return new AppleScriptHandlerInterleavedParametersCallImpl(node);
      }
      else if (type == HANDLER_INTERLEAVED_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerInterleavedParametersDefinitionImpl(node);
      }
      else if (type == HANDLER_LABELED_PARAMETERS_CALL) {
        return new AppleScriptHandlerLabeledParametersCallImpl(node);
      }
      else if (type == HANDLER_LABELED_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerLabeledParametersDefinitionImpl(node);
      }
      else if (type == HANDLER_NAME_PART_DEFINITION) {
        return new AppleScriptHandlerNamePartDefinitionImpl(node);
      }
      else if (type == HANDLER_NAME_PART_REFERENCE) {
        return new AppleScriptHandlerNamePartReferenceImpl(node);
      }
      else if (type == HANDLER_PARAMETER_LABEL) {
        return new AppleScriptHandlerParameterLabelImpl(node);
      }
      else if (type == HANDLER_POSITIONAL_PARAMETERS_CALL) {
        return new AppleScriptHandlerPositionalParametersCallImpl(node);
      }
      else if (type == HANDLER_POSITIONAL_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerPositionalParametersDefinitionImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new AppleScriptIdentifierImpl(node);
      }
      else if (type == IF_COMPOUND_STATEMENT) {
        return new AppleScriptIfCompoundStatementImpl(node);
      }
      else if (type == IF_SIMPLE_STATEMENT) {
        return new AppleScriptIfSimpleStatementImpl(node);
      }
      else if (type == IGNORING_STATEMENT) {
        return new AppleScriptIgnoringStatementImpl(node);
      }
      else if (type == INDEX_REFERENCE) {
        return new AppleScriptIndexReferenceImpl(node);
      }
      else if (type == INTEGER_LITERAL_EXPRESSION) {
        return new AppleScriptIntegerLiteralExpressionImpl(node);
      }
      else if (type == LIST_LITERAL_EXPRESSION) {
        return new AppleScriptListLiteralExpressionImpl(node);
      }
      else if (type == LOGICAL_AND_EXPRESSION) {
        return new AppleScriptLogicalAndExpressionImpl(node);
      }
      else if (type == LOGICAL_OR_EXPRESSION) {
        return new AppleScriptLogicalOrExpressionImpl(node);
      }
      else if (type == MIDDLE_ELEM_REFERENCE) {
        return new AppleScriptMiddleElemReferenceImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new AppleScriptMultiplicativeExpressionImpl(node);
      }
      else if (type == NAME_REFERENCE) {
        return new AppleScriptNameReferenceImpl(node);
      }
      else if (type == NUMERIC_CONSTANT) {
        return new AppleScriptNumericConstantImpl(node);
      }
      else if (type == OBJECT_REF) {
        return new AppleScriptObjectRefImpl(node);
      }
      else if (type == PARAMETER_VAL) {
        return new AppleScriptParameterValImpl(node);
      }
      else if (type == PARENTHESIZED_EXPRESSION) {
        return new AppleScriptParenthesizedExpressionImpl(node);
      }
      else if (type == POWER_EXPRESSION) {
        return new AppleScriptPowerExpressionImpl(node);
      }
      else if (type == PROPERTY_DECLARATION_STATEMENT) {
        return new AppleScriptPropertyDeclarationStatementImpl(node);
      }
      else if (type == PROPERTY_REFERENCE) {
        return new AppleScriptPropertyReferenceImpl(node);
      }
      else if (type == RANGE_REFERENCE) {
        return new AppleScriptRangeReferenceImpl(node);
      }
      else if (type == REAL_LITERAL_EXPRESSION) {
        return new AppleScriptRealLiteralExpressionImpl(node);
      }
      else if (type == RECORD_LITERAL_EXPRESSION) {
        return new AppleScriptRecordLiteralExpressionImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new AppleScriptReferenceExpressionImpl(node);
      }
      else if (type == REFERENCE_IDENTIFIER) {
        return new AppleScriptReferenceIdentifierImpl(node);
      }
      else if (type == RELATIVE_REFERENCE) {
        return new AppleScriptRelativeReferenceImpl(node);
      }
      else if (type == REPEAT_FOREVER_STATEMENT) {
        return new AppleScriptRepeatForeverStatementImpl(node);
      }
      else if (type == REPEAT_NUM_TIMES_STATEMENT) {
        return new AppleScriptRepeatNumTimesStatementImpl(node);
      }
      else if (type == REPEAT_UNTIL_STATEMENT) {
        return new AppleScriptRepeatUntilStatementImpl(node);
      }
      else if (type == REPEAT_WHILE_STATEMENT) {
        return new AppleScriptRepeatWhileStatementImpl(node);
      }
      else if (type == REPEAT_WITH_LIST_STATEMENT) {
        return new AppleScriptRepeatWithListStatementImpl(node);
      }
      else if (type == REPEAT_WITH_RANGE_STATEMENT) {
        return new AppleScriptRepeatWithRangeStatementImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new AppleScriptReturnStatementImpl(node);
      }
      else if (type == RUN_COMMAND_EXPRESSION) {
        return new AppleScriptRunCommandExpressionImpl(node);
      }
      else if (type == SCRIPT_OBJECT_DEFINITION_STATEMENT) {
        return new AppleScriptScriptObjectDefinitionStatementImpl(node);
      }
      else if (type == STRING_LITERAL_EXPRESSION) {
        return new AppleScriptStringLiteralExpressionImpl(node);
      }
      else if (type == TARGET_LIST_LITERAL) {
        return new AppleScriptTargetListLiteralImpl(node);
      }
      else if (type == TARGET_RECORD_LITERAL) {
        return new AppleScriptTargetRecordLiteralImpl(node);
      }
      else if (type == TARGET_VARIABLE) {
        return new AppleScriptTargetVariableImpl(node);
      }
      else if (type == TELL_COMPOUND_STATEMENT) {
        return new AppleScriptTellCompoundStatementImpl(node);
      }
      else if (type == TELL_SIMPLE_STATEMENT) {
        return new AppleScriptTellSimpleStatementImpl(node);
      }
      else if (type == TEXT_ITEM_DELIMITERS_PROPERTY) {
        return new AppleScriptTextItemDelimitersPropertyImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new AppleScriptTryStatementImpl(node);
      }
      else if (type == USER_PARAMETER_VAL) {
        return new AppleScriptUserParameterValImpl(node);
      }
      else if (type == USE_APPLE_SCRIPT_STATEMENT) {
        return new AppleScriptUseAppleScriptStatementImpl(node);
      }
      else if (type == USE_APPLICATION_OR_SCRIPT_STATEMENT) {
        return new AppleScriptUseApplicationOrScriptStatementImpl(node);
      }
      else if (type == USE_FRAMEWORK_STATEMENT) {
        return new AppleScriptUseFrameworkStatementImpl(node);
      }
      else if (type == USE_SCRIPTING_ADDITIONS_STATEMENT) {
        return new AppleScriptUseScriptingAdditionsStatementImpl(node);
      }
      else if (type == USING_TERMS_FROM_STATEMENT) {
        return new AppleScriptUsingTermsFromStatementImpl(node);
      }
      else if (type == VARIABLE_DECLARATION_STATEMENT) {
        return new AppleScriptVariableDeclarationStatementImpl(node);
      }
      else if (type == WITH_TIMEOUT_STATEMENT) {
        return new AppleScriptWithTimeoutStatementImpl(node);
      }
      else if (type == WITH_TRANSACTION_STATEMENT) {
        return new AppleScriptWithTransactionStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
