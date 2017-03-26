// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.plugin.applescript.lang.parser.AppleScriptElementType;
import com.intellij.plugin.applescript.lang.lexer.AppleScriptTokenType;
import com.intellij.plugin.applescript.psi.impl.*;

public interface AppleScriptTypes {

  IElementType ACTIVATE_COMMAND_EXPRESSION = new AppleScriptElementType("ACTIVATE_COMMAND_EXPRESSION");
  IElementType ADDITIVE_EXPRESSION = new AppleScriptElementType("ADDITIVE_EXPRESSION");
  IElementType APPLE_SCRIPT_PROPERTY = new AppleScriptElementType("APPLE_SCRIPT_PROPERTY");
  IElementType APPLICATION_HANDLER_DEFINITION = new AppleScriptElementType("APPLICATION_HANDLER_DEFINITION");
  IElementType APPLICATION_REFERENCE = new AppleScriptElementType("APPLICATION_REFERENCE");
  IElementType ARBITRARY_REFERENCE = new AppleScriptElementType("ARBITRARY_REFERENCE");
  IElementType ARGUMENT_SELECTOR = new AppleScriptElementType("ARGUMENT_SELECTOR");
  IElementType ASSIGNMENT_STATEMENT = new AppleScriptElementType("ASSIGNMENT_STATEMENT");
  IElementType A_REFERENCE_TO_LITERAL_EXPRESSION = new AppleScriptElementType("A_REFERENCE_TO_LITERAL_EXPRESSION");
  IElementType BLOCK_BODY = new AppleScriptElementType("BLOCK_BODY");
  IElementType BUILT_IN_CLASS_IDENTIFIER = new AppleScriptElementType("BUILT_IN_CLASS_IDENTIFIER");
  IElementType BUILT_IN_CLASS_IDENTIFIER_PLURAL = new AppleScriptElementType("BUILT_IN_CLASS_IDENTIFIER_PLURAL");
  IElementType BUILT_IN_CONSTANT_LITERAL_EXPRESSION = new AppleScriptElementType("BUILT_IN_CONSTANT_LITERAL_EXPRESSION");
  IElementType COERCION_EXPRESSION = new AppleScriptElementType("COERCION_EXPRESSION");
  IElementType COMMAND_PARAMETER = new AppleScriptElementType("COMMAND_PARAMETER");
  IElementType COMMAND_PARAMETER_SELECTOR = new AppleScriptElementType("COMMAND_PARAMETER_SELECTOR");
  IElementType COMPARE_EXPRESSION = new AppleScriptElementType("COMPARE_EXPRESSION");
  IElementType CONCATENATION_EXPRESSION = new AppleScriptElementType("CONCATENATION_EXPRESSION");
  IElementType CONSIDERING_STATEMENT = new AppleScriptElementType("CONSIDERING_STATEMENT");
  IElementType CONTINUE_STATEMENT = new AppleScriptElementType("CONTINUE_STATEMENT");
  IElementType COUNT_COMMAND_EXPRESSION = new AppleScriptElementType("COUNT_COMMAND_EXPRESSION");
  IElementType DATE_LITERAL_EXPRESSION = new AppleScriptElementType("DATE_LITERAL_EXPRESSION");
  IElementType DICTIONARY_CLASS_IDENTIFIER_PLURAL = new AppleScriptElementType("DICTIONARY_CLASS_IDENTIFIER_PLURAL");
  IElementType DICTIONARY_CLASS_NAME = new AppleScriptElementType("DICTIONARY_CLASS_NAME");
  IElementType DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION = new AppleScriptElementType("DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION");
  IElementType DICTIONARY_COMMAND_NAME = new AppleScriptElementType("DICTIONARY_COMMAND_NAME");
  IElementType DICTIONARY_CONSTANT = new AppleScriptElementType("DICTIONARY_CONSTANT");
  IElementType DICTIONARY_PROPERTY_NAME = new AppleScriptElementType("DICTIONARY_PROPERTY_NAME");
  IElementType DIRECT_PARAMETER_DECLARATION = new AppleScriptElementType("DIRECT_PARAMETER_DECLARATION");
  IElementType DIRECT_PARAMETER_VAL = new AppleScriptElementType("DIRECT_PARAMETER_VAL");
  IElementType ERROR_COMMAND_EXPRESSION = new AppleScriptElementType("ERROR_COMMAND_EXPRESSION");
  IElementType EVERY_ELEM_REFERENCE = new AppleScriptElementType("EVERY_ELEM_REFERENCE");
  IElementType EVERY_RANGE_REFERENCE = new AppleScriptElementType("EVERY_RANGE_REFERENCE");
  IElementType EXIT_STATEMENT = new AppleScriptElementType("EXIT_STATEMENT");
  IElementType EXPRESSION = new AppleScriptElementType("EXPRESSION");
  IElementType FILTER_REFERENCE = new AppleScriptElementType("FILTER_REFERENCE");
  IElementType FORMAL_PARAMETER_LIST = new AppleScriptElementType("FORMAL_PARAMETER_LIST");
  IElementType GET_COMMAND_EXPRESSION = new AppleScriptElementType("GET_COMMAND_EXPRESSION");
  IElementType GIVEN_RAW_PARAMETER_EXPRESSION = new AppleScriptElementType("GIVEN_RAW_PARAMETER_EXPRESSION");
  IElementType HANDLER_ARGUMENT = new AppleScriptElementType("HANDLER_ARGUMENT");
  IElementType HANDLER_INTERLEAVED_PARAMETERS_CALL = new AppleScriptElementType("HANDLER_INTERLEAVED_PARAMETERS_CALL");
  IElementType HANDLER_INTERLEAVED_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_INTERLEAVED_PARAMETERS_DEFINITION");
  IElementType HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART = new AppleScriptElementType("HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART");
  IElementType HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION = new AppleScriptElementType("HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION");
  IElementType HANDLER_LABELED_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_LABELED_PARAMETERS_DEFINITION");
  IElementType HANDLER_PARAMETER_LABEL = new AppleScriptElementType("HANDLER_PARAMETER_LABEL");
  IElementType HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION = new AppleScriptElementType("HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION");
  IElementType HANDLER_POSITIONAL_PARAMETERS_DEFINITION = new AppleScriptElementType("HANDLER_POSITIONAL_PARAMETERS_DEFINITION");
  IElementType IDENTIFIER = new AppleScriptElementType("IDENTIFIER");
  IElementType ID_REFERENCE = new AppleScriptElementType("ID_REFERENCE");
  IElementType IF_COMPOUND_STATEMENT = new AppleScriptElementType("IF_COMPOUND_STATEMENT");
  IElementType IF_SIMPLE_STATEMENT = new AppleScriptElementType("IF_SIMPLE_STATEMENT");
  IElementType IGNORING_STATEMENT = new AppleScriptElementType("IGNORING_STATEMENT");
  IElementType INCOMPLETE_COMMAND_HANDLER_CALL = new AppleScriptElementType("INCOMPLETE_COMMAND_HANDLER_CALL");
  IElementType INCOMPLETE_EXPRESSION = new AppleScriptElementType("INCOMPLETE_EXPRESSION");
  IElementType INDEX_REFERENCE = new AppleScriptElementType("INDEX_REFERENCE");
  IElementType INDEX_REFERENCE_CLASS_FORM = new AppleScriptElementType("INDEX_REFERENCE_CLASS_FORM");
  IElementType INTEGER_LITERAL_EXPRESSION = new AppleScriptElementType("INTEGER_LITERAL_EXPRESSION");
  IElementType LABELED_PARAMETER_DECLARATION_LIST = new AppleScriptElementType("LABELED_PARAMETER_DECLARATION_LIST");
  IElementType LABELED_PARAMETER_DECLARATION_PART = new AppleScriptElementType("LABELED_PARAMETER_DECLARATION_PART");
  IElementType LAUNCH_COMMAND_EXPRESSION = new AppleScriptElementType("LAUNCH_COMMAND_EXPRESSION");
  IElementType LIST_FORMAL_PARAMETER = new AppleScriptElementType("LIST_FORMAL_PARAMETER");
  IElementType LIST_LITERAL_EXPRESSION = new AppleScriptElementType("LIST_LITERAL_EXPRESSION");
  IElementType LOGICAL_AND_EXPRESSION = new AppleScriptElementType("LOGICAL_AND_EXPRESSION");
  IElementType LOGICAL_OR_EXPRESSION = new AppleScriptElementType("LOGICAL_OR_EXPRESSION");
  IElementType LOG_COMMAND_EXPRESSION = new AppleScriptElementType("LOG_COMMAND_EXPRESSION");
  IElementType MIDDLE_ELEM_REFERENCE = new AppleScriptElementType("MIDDLE_ELEM_REFERENCE");
  IElementType MULTIPLICATIVE_EXPRESSION = new AppleScriptElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType NAME_REFERENCE = new AppleScriptElementType("NAME_REFERENCE");
  IElementType NEGATION_EXPRESSION = new AppleScriptElementType("NEGATION_EXPRESSION");
  IElementType NUMBER_LITERAL_EXPRESSION = new AppleScriptElementType("NUMBER_LITERAL_EXPRESSION");
  IElementType NUMERIC_CONSTANT = new AppleScriptElementType("NUMERIC_CONSTANT");
  IElementType OBJECT_NAMED_PROPERTY_DECLARATION = new AppleScriptElementType("OBJECT_NAMED_PROPERTY_DECLARATION");
  IElementType OBJECT_PROPERTY_DECLARATION = new AppleScriptElementType("OBJECT_PROPERTY_DECLARATION");
  IElementType OBJECT_REFERENCE_EXPRESSION = new AppleScriptElementType("OBJECT_REFERENCE_EXPRESSION");
  IElementType OBJECT_TARGET_PROPERTY_DECLARATION = new AppleScriptElementType("OBJECT_TARGET_PROPERTY_DECLARATION");
  IElementType PARAMETER_VAL = new AppleScriptElementType("PARAMETER_VAL");
  IElementType PARENTHESIZED_EXPRESSION = new AppleScriptElementType("PARENTHESIZED_EXPRESSION");
  IElementType POWER_EXPRESSION = new AppleScriptElementType("POWER_EXPRESSION");
  IElementType PROPERTY_REFERENCE = new AppleScriptElementType("PROPERTY_REFERENCE");
  IElementType RANGE_FROM_REFERENCE = new AppleScriptElementType("RANGE_FROM_REFERENCE");
  IElementType RANGE_INDEX_REFERENCE = new AppleScriptElementType("RANGE_INDEX_REFERENCE");
  IElementType RAW_CLASS_EXPRESSION = new AppleScriptElementType("RAW_CLASS_EXPRESSION");
  IElementType RAW_DATA_EXPRESSION = new AppleScriptElementType("RAW_DATA_EXPRESSION");
  IElementType RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION = new AppleScriptElementType("RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION");
  IElementType RAW_PARAMETER_EXPRESSION = new AppleScriptElementType("RAW_PARAMETER_EXPRESSION");
  IElementType RAW_PARAMETER_SELECTOR = new AppleScriptElementType("RAW_PARAMETER_SELECTOR");
  IElementType REAL_LITERAL_EXPRESSION = new AppleScriptElementType("REAL_LITERAL_EXPRESSION");
  IElementType RECORD_FORMAL_PARAMETER = new AppleScriptElementType("RECORD_FORMAL_PARAMETER");
  IElementType RECORD_LITERAL_EXPRESSION = new AppleScriptElementType("RECORD_LITERAL_EXPRESSION");
  IElementType REFERENCE_EXPRESSION = new AppleScriptElementType("REFERENCE_EXPRESSION");
  IElementType RELATIVE_REFERENCE = new AppleScriptElementType("RELATIVE_REFERENCE");
  IElementType REPEAT_FOREVER_STATEMENT = new AppleScriptElementType("REPEAT_FOREVER_STATEMENT");
  IElementType REPEAT_NUM_TIMES_STATEMENT = new AppleScriptElementType("REPEAT_NUM_TIMES_STATEMENT");
  IElementType REPEAT_UNTIL_STATEMENT = new AppleScriptElementType("REPEAT_UNTIL_STATEMENT");
  IElementType REPEAT_WHILE_STATEMENT = new AppleScriptElementType("REPEAT_WHILE_STATEMENT");
  IElementType REPEAT_WITH_LIST_STATEMENT = new AppleScriptElementType("REPEAT_WITH_LIST_STATEMENT");
  IElementType REPEAT_WITH_RANGE_STATEMENT = new AppleScriptElementType("REPEAT_WITH_RANGE_STATEMENT");
  IElementType RETURN_STATEMENT = new AppleScriptElementType("RETURN_STATEMENT");
  IElementType RUN_COMMAND_EXPRESSION = new AppleScriptElementType("RUN_COMMAND_EXPRESSION");
  IElementType SCRIPT_BODY = new AppleScriptElementType("SCRIPT_BODY");
  IElementType SCRIPT_OBJECT_DEFINITION = new AppleScriptElementType("SCRIPT_OBJECT_DEFINITION");
  IElementType SCRIPT_OBJECT_UNNAMED_DEFINITION = new AppleScriptElementType("SCRIPT_OBJECT_UNNAMED_DEFINITION");
  IElementType SCRIPT_PROPERTY_DECLARATION = new AppleScriptElementType("SCRIPT_PROPERTY_DECLARATION");
  IElementType SELECTOR_ID = new AppleScriptElementType("SELECTOR_ID");
  IElementType SIMPLE_FORMAL_PARAMETER = new AppleScriptElementType("SIMPLE_FORMAL_PARAMETER");
  IElementType STRING_LITERAL_EXPRESSION = new AppleScriptElementType("STRING_LITERAL_EXPRESSION");
  IElementType TARGET_LIST_LITERAL = new AppleScriptElementType("TARGET_LIST_LITERAL");
  IElementType TARGET_RECORD_LITERAL = new AppleScriptElementType("TARGET_RECORD_LITERAL");
  IElementType TARGET_VARIABLE = new AppleScriptElementType("TARGET_VARIABLE");
  IElementType TELL_COMPOUND_STATEMENT = new AppleScriptElementType("TELL_COMPOUND_STATEMENT");
  IElementType TELL_SIMPLE_STATEMENT = new AppleScriptElementType("TELL_SIMPLE_STATEMENT");
  IElementType TEXT_ITEM_DELIMITERS_PROPERTY = new AppleScriptElementType("TEXT_ITEM_DELIMITERS_PROPERTY");
  IElementType TOP_BLOCK_BODY = new AppleScriptElementType("TOP_BLOCK_BODY");
  IElementType TRY_STATEMENT = new AppleScriptElementType("TRY_STATEMENT");
  IElementType USER_CLASS_NAME = new AppleScriptElementType("USER_CLASS_NAME");
  IElementType USE_STATEMENT = new AppleScriptElementType("USE_STATEMENT");
  IElementType USING_TERMS_FROM_STATEMENT = new AppleScriptElementType("USING_TERMS_FROM_STATEMENT");
  IElementType VAR_ACCESS_DECLARATION = new AppleScriptElementType("VAR_ACCESS_DECLARATION");
  IElementType VAR_DECLARATION_LIST = new AppleScriptElementType("VAR_DECLARATION_LIST");
  IElementType VAR_DECLARATION_LIST_PART = new AppleScriptElementType("VAR_DECLARATION_LIST_PART");
  IElementType WITH_TIMEOUT_STATEMENT = new AppleScriptElementType("WITH_TIMEOUT_STATEMENT");
  IElementType WITH_TRANSACTION_STATEMENT = new AppleScriptElementType("WITH_TRANSACTION_STATEMENT");

  IElementType ABOUT = new AppleScriptTokenType("about");
  IElementType ABOVE = new AppleScriptTokenType("above");
  IElementType ACTIVATE = new AppleScriptTokenType("activate");
  IElementType AFTER = new AppleScriptTokenType("after");
  IElementType AGAINST = new AppleScriptTokenType("against");
  IElementType ALIAS = new AppleScriptTokenType("alias");
  IElementType ANY = new AppleScriptTokenType("any");
  IElementType ANYTHING = new AppleScriptTokenType("anything");
  IElementType APART_FROM = new AppleScriptTokenType("APART_FROM");
  IElementType APP = new AppleScriptTokenType("app");
  IElementType APPLICATION = new AppleScriptTokenType("application");
  IElementType APP_RESPONSES = new AppleScriptTokenType("APP_RESPONSES");
  IElementType APS = new AppleScriptTokenType("'s");
  IElementType AROUND = new AppleScriptTokenType("around");
  IElementType AS = new AppleScriptTokenType("as");
  IElementType ASIDE_FROM = new AppleScriptTokenType("ASIDE_FROM");
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
  IElementType BOOLEAN = new AppleScriptTokenType("boolean");
  IElementType BUILT_IN_PROPERTY = new AppleScriptTokenType("BUILT_IN_PROPERTY");
  IElementType BUILT_IN_TYPE_S = new AppleScriptTokenType("BUILT_IN_TYPE_S");
  IElementType BUNDLE = new AppleScriptTokenType("bundle");
  IElementType BUT = new AppleScriptTokenType("but");
  IElementType BY = new AppleScriptTokenType("by");
  IElementType CC = new AppleScriptTokenType("¬");
  IElementType CENTIMETERS = new AppleScriptTokenType("centimeters");
  IElementType CENTIMETRES = new AppleScriptTokenType("centimetres");
  IElementType CHARACTER = new AppleScriptTokenType("character");
  IElementType CLASS = new AppleScriptTokenType("class");
  IElementType COLON = new AppleScriptTokenType(":");
  IElementType COMMA = new AppleScriptTokenType(",");
  IElementType COMMENT = new AppleScriptTokenType("COMMENT");
  IElementType CONSIDERING = new AppleScriptTokenType("considering");
  IElementType CONSIDER_IGNORE_ATTRIBUTE = new AppleScriptTokenType("CONSIDER_IGNORE_ATTRIBUTE");
  IElementType CONSTANT = new AppleScriptTokenType("constant");
  IElementType CONTINUE = new AppleScriptTokenType("continue");
  IElementType COPY = new AppleScriptTokenType("copy");
  IElementType COUNT = new AppleScriptTokenType("count");
  IElementType CUBIC_VOL = new AppleScriptTokenType("CUBIC_VOL");
  IElementType CURRENT = new AppleScriptTokenType("current");
  IElementType CURRENT_APP = new AppleScriptTokenType("CURRENT_APP");
  IElementType CURRENT_APPLICATION = new AppleScriptTokenType("CURRENT_APPLICATION");
  IElementType C_WHITE_SPACE = new AppleScriptTokenType("C_WHITE_SPACE");
  IElementType DATA = new AppleScriptTokenType("data");
  IElementType DATE = new AppleScriptTokenType("date");
  IElementType DAYS_CONSTANT = new AppleScriptTokenType("days");
  IElementType DEC_EXPONENT = new AppleScriptTokenType("DEC_EXPONENT");
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
  IElementType EVENT = new AppleScriptTokenType("event");
  IElementType EVERY = new AppleScriptTokenType("every");
  IElementType EXIT = new AppleScriptTokenType("exit");
  IElementType FALSE = new AppleScriptTokenType("false");
  IElementType FEET = new AppleScriptTokenType("feet");
  IElementType FIFTH = new AppleScriptTokenType("fifth");
  IElementType FILE = new AppleScriptTokenType("file");
  IElementType FILE_SPECIFICATION = new AppleScriptTokenType("FILE_SPECIFICATION");
  IElementType FIRST = new AppleScriptTokenType("first");
  IElementType FOR = new AppleScriptTokenType("for");
  IElementType FOURTH = new AppleScriptTokenType("fourth");
  IElementType FRAMEWORK = new AppleScriptTokenType("framework");
  IElementType FROM = new AppleScriptTokenType("from");
  IElementType FRONT = new AppleScriptTokenType("front");
  IElementType GALLONS = new AppleScriptTokenType("gallons");
  IElementType GE = new AppleScriptTokenType("GE");
  IElementType GET = new AppleScriptTokenType("get");
  IElementType GIVEN = new AppleScriptTokenType("given");
  IElementType GLOBAL = new AppleScriptTokenType("global");
  IElementType GRAMS = new AppleScriptTokenType("grams");
  IElementType GT = new AppleScriptTokenType("GT");
  IElementType HOURS_CONSTANT = new AppleScriptTokenType("hours");
  IElementType ID = new AppleScriptTokenType("id");
  IElementType IF = new AppleScriptTokenType("if");
  IElementType IGNORING = new AppleScriptTokenType("ignoring");
  IElementType IMPORTING = new AppleScriptTokenType("importing");
  IElementType IN = new AppleScriptTokenType("in");
  IElementType INCHES = new AppleScriptTokenType("inches");
  IElementType INDEX = new AppleScriptTokenType("index");
  IElementType INSTEAD_OF = new AppleScriptTokenType("INSTEAD_OF");
  IElementType INTEGER = new AppleScriptTokenType("integer");
  IElementType INTERNATIONAL_TEXT = new AppleScriptTokenType("INTERNATIONAL_TEXT");
  IElementType INTO = new AppleScriptTokenType("into");
  IElementType INT_DIV = new AppleScriptTokenType("div");
  IElementType IS_CONTAIN = new AppleScriptTokenType("IS_CONTAIN");
  IElementType IS_IN = new AppleScriptTokenType("IS_IN");
  IElementType IS_NOT_IN = new AppleScriptTokenType("IS_NOT_IN");
  IElementType IT = new AppleScriptTokenType("it");
  IElementType ITEM = new AppleScriptTokenType("item");
  IElementType ITS = new AppleScriptTokenType("its");
  IElementType KILOGRAMS = new AppleScriptTokenType("kilograms");
  IElementType KILOMETERS = new AppleScriptTokenType("kilometers");
  IElementType KILOMETRES = new AppleScriptTokenType("kilometres");
  IElementType LAND = new AppleScriptTokenType("and");
  IElementType LAST = new AppleScriptTokenType("last");
  IElementType LAUNCH = new AppleScriptTokenType("launch");
  IElementType LCURLY = new AppleScriptTokenType("{");
  IElementType LE = new AppleScriptTokenType("LE");
  IElementType LINEFEED = new AppleScriptTokenType("linefeed");
  IElementType LIST = new AppleScriptTokenType("list");
  IElementType LITERS = new AppleScriptTokenType("liters");
  IElementType LITRES = new AppleScriptTokenType("litres");
  IElementType LNOT = new AppleScriptTokenType("not");
  IElementType LOCAL = new AppleScriptTokenType("local");
  IElementType LOCATION_SPECIFIER = new AppleScriptTokenType("LOCATION_SPECIFIER");
  IElementType LOG = new AppleScriptTokenType("log");
  IElementType LOR = new AppleScriptTokenType("or");
  IElementType LPAREN = new AppleScriptTokenType("(");
  IElementType LT = new AppleScriptTokenType("LT");
  IElementType MACHINE = new AppleScriptTokenType("machine");
  IElementType ME = new AppleScriptTokenType("me");
  IElementType METERS = new AppleScriptTokenType("meters");
  IElementType METRES = new AppleScriptTokenType("metres");
  IElementType MIDDLE = new AppleScriptTokenType("middle");
  IElementType MILES = new AppleScriptTokenType("miles");
  IElementType MINUS = new AppleScriptTokenType("-");
  IElementType MINUTES_CONSTANT = new AppleScriptTokenType("minutes");
  IElementType MISSING_VALUE = new AppleScriptTokenType("MISSING_VALUE");
  IElementType MOD = new AppleScriptTokenType("mod");
  IElementType MULTI_LINE_COMMENT_END = new AppleScriptTokenType("*)");
  IElementType MULTI_LINE_COMMENT_START = new AppleScriptTokenType("(*");
  IElementType MY = new AppleScriptTokenType("my");
  IElementType NAMED = new AppleScriptTokenType("named");
  IElementType NE = new AppleScriptTokenType("NE");
  IElementType NINTH = new AppleScriptTokenType("ninth");
  IElementType NLS = new AppleScriptTokenType("NLS");
  IElementType NUMBER = new AppleScriptTokenType("number");
  IElementType OF = new AppleScriptTokenType("of");
  IElementType ON = new AppleScriptTokenType("on");
  IElementType ONTO = new AppleScriptTokenType("onto");
  IElementType OUNCES = new AppleScriptTokenType("ounces");
  IElementType OUT_OF = new AppleScriptTokenType("OUT_OF");
  IElementType OVER = new AppleScriptTokenType("over");
  IElementType PARAGRAPH = new AppleScriptTokenType("paragraph");
  IElementType PARENT = new AppleScriptTokenType("parent");
  IElementType PARTIAL = new AppleScriptTokenType("partial");
  IElementType PI_CONSTANT = new AppleScriptTokenType("pi");
  IElementType PLUS = new AppleScriptTokenType("+");
  IElementType POINT = new AppleScriptTokenType("point");
  IElementType POUNDS = new AppleScriptTokenType("pounds");
  IElementType POW = new AppleScriptTokenType("^");
  IElementType PREPOSITION = new AppleScriptTokenType("preposition");
  IElementType PROP = new AppleScriptTokenType("prop");
  IElementType PROPERTY = new AppleScriptTokenType("property");
  IElementType PUT = new AppleScriptTokenType("put");
  IElementType QUARTS = new AppleScriptTokenType("quarts");
  IElementType QUOTE = new AppleScriptTokenType("quote");
  IElementType QUOTED_FORM = new AppleScriptTokenType("QUOTED_FORM");
  IElementType RAW_LBR = new AppleScriptTokenType("«");
  IElementType RAW_RBR = new AppleScriptTokenType("»");
  IElementType RCURLY = new AppleScriptTokenType("}");
  IElementType REAL = new AppleScriptTokenType("real");
  IElementType RECORD = new AppleScriptTokenType("record");
  IElementType RECTANGLE = new AppleScriptTokenType("rectangle");
  IElementType REFERENCE = new AppleScriptTokenType("reference");
  IElementType REF_OP = new AppleScriptTokenType("REF_OP");
  IElementType REPEAT = new AppleScriptTokenType("repeat");
  IElementType RESULT = new AppleScriptTokenType("result");
  IElementType RETURN = new AppleScriptTokenType("return");
  IElementType RETURNING = new AppleScriptTokenType("returning");
  IElementType RGB_COLOR = new AppleScriptTokenType("RGB_COLOR");
  IElementType RPAREN = new AppleScriptTokenType(")");
  IElementType SCRIPT = new AppleScriptTokenType("script");
  IElementType SCRIPTING_ADDITIONS = new AppleScriptTokenType("SCRIPTING_ADDITIONS");
  IElementType SCRIPTS = new AppleScriptTokenType("scripts");
  IElementType SECOND = new AppleScriptTokenType("second");
  IElementType SECONDS = new AppleScriptTokenType("seconds");
  IElementType SET = new AppleScriptTokenType("set");
  IElementType SEVENTH = new AppleScriptTokenType("seventh");
  IElementType SINCE = new AppleScriptTokenType("since");
  IElementType SIXTH = new AppleScriptTokenType("sixth");
  IElementType SOME = new AppleScriptTokenType("some");
  IElementType SPACE = new AppleScriptTokenType("space");
  IElementType SPECIFIER = new AppleScriptTokenType("specifier");
  IElementType SQUARE_AREA = new AppleScriptTokenType("SQUARE_AREA");
  IElementType STAR = new AppleScriptTokenType("*");
  IElementType STARTS_BEGINS_WITH = new AppleScriptTokenType("STARTS_BEGINS_WITH");
  IElementType STRING = new AppleScriptTokenType("string");
  IElementType STRING_LITERAL = new AppleScriptTokenType("STRING_LITERAL");
  IElementType STYLED_CLIPBOARD_TEXT = new AppleScriptTokenType("STYLED_CLIPBOARD_TEXT");
  IElementType STYLED_TEXT = new AppleScriptTokenType("STYLED_TEXT");
  IElementType TAB = new AppleScriptTokenType("tab");
  IElementType TELL = new AppleScriptTokenType("tell");
  IElementType TEMPERATURE = new AppleScriptTokenType("TEMPERATURE");
  IElementType TENTH = new AppleScriptTokenType("tenth");
  IElementType TERMS = new AppleScriptTokenType("terms");
  IElementType TEXT = new AppleScriptTokenType("text");
  IElementType TEXT_ITEM = new AppleScriptTokenType("TEXT_ITEM");
  IElementType TEXT_ITEM_DELIMETERS = new AppleScriptTokenType("TEXT_ITEM_DELIMETERS");
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
  IElementType TYPE = new AppleScriptTokenType("type");
  IElementType UNDER = new AppleScriptTokenType("under");
  IElementType UNICODE_TEXT = new AppleScriptTokenType("UNICODE_TEXT");
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
  IElementType WORD = new AppleScriptTokenType("word");
  IElementType YARDS = new AppleScriptTokenType("yards");
  IElementType ZONE = new AppleScriptTokenType("zone");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ACTIVATE_COMMAND_EXPRESSION) {
        return new AppleScriptActivateCommandExpressionImpl(node);
      }
      else if (type == ADDITIVE_EXPRESSION) {
        return new AppleScriptAdditiveExpressionImpl(node);
      }
      else if (type == APPLE_SCRIPT_PROPERTY) {
        return new AppleScriptAppleScriptPropertyImpl(node);
      }
      else if (type == APPLICATION_HANDLER_DEFINITION) {
        return new AppleScriptApplicationHandlerDefinitionImpl(node);
      }
      else if (type == APPLICATION_REFERENCE) {
        return new AppleScriptApplicationReferenceImpl(node);
      }
      else if (type == ARBITRARY_REFERENCE) {
        return new AppleScriptArbitraryReferenceImpl(node);
      }
      else if (type == ARGUMENT_SELECTOR) {
        return new AppleScriptArgumentSelectorImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new AppleScriptAssignmentStatementImpl(node);
      }
      else if (type == A_REFERENCE_TO_LITERAL_EXPRESSION) {
        return new AppleScriptAReferenceToLiteralExpressionImpl(node);
      }
      else if (type == BLOCK_BODY) {
        return new AppleScriptBlockBodyImpl(node);
      }
      else if (type == BUILT_IN_CLASS_IDENTIFIER) {
        return new AppleScriptBuiltInClassIdentifierImpl(node);
      }
      else if (type == BUILT_IN_CLASS_IDENTIFIER_PLURAL) {
        return new AppleScriptBuiltInClassIdentifierPluralImpl(node);
      }
      else if (type == BUILT_IN_CONSTANT_LITERAL_EXPRESSION) {
        return new AppleScriptBuiltInConstantLiteralExpressionImpl(node);
      }
      else if (type == COERCION_EXPRESSION) {
        return new AppleScriptCoercionExpressionImpl(node);
      }
      else if (type == COMMAND_PARAMETER) {
        return new AppleScriptCommandParameterImpl(node);
      }
      else if (type == COMMAND_PARAMETER_SELECTOR) {
        return new AppleScriptCommandParameterSelectorImpl(node);
      }
      else if (type == COMPARE_EXPRESSION) {
        return new AppleScriptCompareExpressionImpl(node);
      }
      else if (type == CONCATENATION_EXPRESSION) {
        return new AppleScriptConcatenationExpressionImpl(node);
      }
      else if (type == CONSIDERING_STATEMENT) {
        return new AppleScriptConsideringStatementImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new AppleScriptContinueStatementImpl(node);
      }
      else if (type == COUNT_COMMAND_EXPRESSION) {
        return new AppleScriptCountCommandExpressionImpl(node);
      }
      else if (type == DATE_LITERAL_EXPRESSION) {
        return new AppleScriptDateLiteralExpressionImpl(node);
      }
      else if (type == DICTIONARY_CLASS_IDENTIFIER_PLURAL) {
        return new AppleScriptDictionaryClassIdentifierPluralImpl(node);
      }
      else if (type == DICTIONARY_CLASS_NAME) {
        return new AppleScriptDictionaryClassNameImpl(node);
      }
      else if (type == DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION) {
        return new AppleScriptDictionaryCommandHandlerCallExpressionImpl(node);
      }
      else if (type == DICTIONARY_COMMAND_NAME) {
        return new AppleScriptDictionaryCommandNameImpl(node);
      }
      else if (type == DICTIONARY_CONSTANT) {
        return new AppleScriptDictionaryConstantImpl(node);
      }
      else if (type == DICTIONARY_PROPERTY_NAME) {
        return new AppleScriptDictionaryPropertyNameImpl(node);
      }
      else if (type == DIRECT_PARAMETER_DECLARATION) {
        return new AppleScriptDirectParameterDeclarationImpl(node);
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
      else if (type == EVERY_RANGE_REFERENCE) {
        return new AppleScriptEveryRangeReferenceImpl(node);
      }
      else if (type == EXIT_STATEMENT) {
        return new AppleScriptExitStatementImpl(node);
      }
      else if (type == EXPRESSION) {
        return new AppleScriptExpressionImpl(node);
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
      else if (type == GIVEN_RAW_PARAMETER_EXPRESSION) {
        return new AppleScriptGivenRawParameterExpressionImpl(node);
      }
      else if (type == HANDLER_ARGUMENT) {
        return new AppleScriptHandlerArgumentImpl(node);
      }
      else if (type == HANDLER_INTERLEAVED_PARAMETERS_CALL) {
        return new AppleScriptHandlerInterleavedParametersCallImpl(node);
      }
      else if (type == HANDLER_INTERLEAVED_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerInterleavedParametersDefinitionImpl(node);
      }
      else if (type == HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART) {
        return new AppleScriptHandlerInterleavedParametersSelectorPartImpl(node);
      }
      else if (type == HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION) {
        return new AppleScriptHandlerLabeledParametersCallExpressionImpl(node);
      }
      else if (type == HANDLER_LABELED_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerLabeledParametersDefinitionImpl(node);
      }
      else if (type == HANDLER_PARAMETER_LABEL) {
        return new AppleScriptHandlerParameterLabelImpl(node);
      }
      else if (type == HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION) {
        return new AppleScriptHandlerPositionalParametersCallExpressionImpl(node);
      }
      else if (type == HANDLER_POSITIONAL_PARAMETERS_DEFINITION) {
        return new AppleScriptHandlerPositionalParametersDefinitionImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new AppleScriptIdentifierImpl(node);
      }
      else if (type == ID_REFERENCE) {
        return new AppleScriptIdReferenceImpl(node);
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
      else if (type == INCOMPLETE_COMMAND_HANDLER_CALL) {
        return new AppleScriptIncompleteCommandHandlerCallImpl(node);
      }
      else if (type == INCOMPLETE_EXPRESSION) {
        return new AppleScriptIncompleteExpressionImpl(node);
      }
      else if (type == INDEX_REFERENCE) {
        return new AppleScriptIndexReferenceImpl(node);
      }
      else if (type == INDEX_REFERENCE_CLASS_FORM) {
        return new AppleScriptIndexReferenceClassFormImpl(node);
      }
      else if (type == INTEGER_LITERAL_EXPRESSION) {
        return new AppleScriptIntegerLiteralExpressionImpl(node);
      }
      else if (type == LABELED_PARAMETER_DECLARATION_LIST) {
        return new AppleScriptLabeledParameterDeclarationListImpl(node);
      }
      else if (type == LABELED_PARAMETER_DECLARATION_PART) {
        return new AppleScriptLabeledParameterDeclarationPartImpl(node);
      }
      else if (type == LAUNCH_COMMAND_EXPRESSION) {
        return new AppleScriptLaunchCommandExpressionImpl(node);
      }
      else if (type == LIST_FORMAL_PARAMETER) {
        return new AppleScriptListFormalParameterImpl(node);
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
      else if (type == LOG_COMMAND_EXPRESSION) {
        return new AppleScriptLogCommandExpressionImpl(node);
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
      else if (type == NEGATION_EXPRESSION) {
        return new AppleScriptNegationExpressionImpl(node);
      }
      else if (type == NUMBER_LITERAL_EXPRESSION) {
        return new AppleScriptNumberLiteralExpressionImpl(node);
      }
      else if (type == NUMERIC_CONSTANT) {
        return new AppleScriptNumericConstantImpl(node);
      }
      else if (type == OBJECT_NAMED_PROPERTY_DECLARATION) {
        return new AppleScriptObjectNamedPropertyDeclarationImpl(node);
      }
      else if (type == OBJECT_PROPERTY_DECLARATION) {
        return new AppleScriptObjectPropertyDeclarationImpl(node);
      }
      else if (type == OBJECT_REFERENCE_EXPRESSION) {
        return new AppleScriptObjectReferenceExpressionImpl(node);
      }
      else if (type == OBJECT_TARGET_PROPERTY_DECLARATION) {
        return new AppleScriptObjectTargetPropertyDeclarationImpl(node);
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
      else if (type == PROPERTY_REFERENCE) {
        return new AppleScriptPropertyReferenceImpl(node);
      }
      else if (type == RANGE_FROM_REFERENCE) {
        return new AppleScriptRangeFromReferenceImpl(node);
      }
      else if (type == RANGE_INDEX_REFERENCE) {
        return new AppleScriptRangeIndexReferenceImpl(node);
      }
      else if (type == RAW_CLASS_EXPRESSION) {
        return new AppleScriptRawClassExpressionImpl(node);
      }
      else if (type == RAW_DATA_EXPRESSION) {
        return new AppleScriptRawDataExpressionImpl(node);
      }
      else if (type == RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION) {
        return new AppleScriptRawDictionaryCommandHandlerCallExpressionImpl(node);
      }
      else if (type == RAW_PARAMETER_EXPRESSION) {
        return new AppleScriptRawParameterExpressionImpl(node);
      }
      else if (type == RAW_PARAMETER_SELECTOR) {
        return new AppleScriptRawParameterSelectorImpl(node);
      }
      else if (type == REAL_LITERAL_EXPRESSION) {
        return new AppleScriptRealLiteralExpressionImpl(node);
      }
      else if (type == RECORD_FORMAL_PARAMETER) {
        return new AppleScriptRecordFormalParameterImpl(node);
      }
      else if (type == RECORD_LITERAL_EXPRESSION) {
        return new AppleScriptRecordLiteralExpressionImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new AppleScriptReferenceExpressionImpl(node);
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
      else if (type == SCRIPT_BODY) {
        return new AppleScriptScriptBodyImpl(node);
      }
      else if (type == SCRIPT_OBJECT_DEFINITION) {
        return new AppleScriptScriptObjectDefinitionImpl(node);
      }
      else if (type == SCRIPT_OBJECT_UNNAMED_DEFINITION) {
        return new AppleScriptScriptObjectUnnamedDefinitionImpl(node);
      }
      else if (type == SCRIPT_PROPERTY_DECLARATION) {
        return new AppleScriptScriptPropertyDeclarationImpl(node);
      }
      else if (type == SELECTOR_ID) {
        return new AppleScriptSelectorIdImpl(node);
      }
      else if (type == SIMPLE_FORMAL_PARAMETER) {
        return new AppleScriptSimpleFormalParameterImpl(node);
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
      else if (type == TOP_BLOCK_BODY) {
        return new AppleScriptTopBlockBodyImpl(node);
      }
      else if (type == TRY_STATEMENT) {
        return new AppleScriptTryStatementImpl(node);
      }
      else if (type == USER_CLASS_NAME) {
        return new AppleScriptUserClassNameImpl(node);
      }
      else if (type == USE_STATEMENT) {
        return new AppleScriptUseStatementImpl(node);
      }
      else if (type == USING_TERMS_FROM_STATEMENT) {
        return new AppleScriptUsingTermsFromStatementImpl(node);
      }
      else if (type == VAR_ACCESS_DECLARATION) {
        return new AppleScriptVarAccessDeclarationImpl(node);
      }
      else if (type == VAR_DECLARATION_LIST) {
        return new AppleScriptVarDeclarationListImpl(node);
      }
      else if (type == VAR_DECLARATION_LIST_PART) {
        return new AppleScriptVarDeclarationListPartImpl(node);
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
