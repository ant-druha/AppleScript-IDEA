// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.lang.parcer;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AppleScriptParser implements PsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == A_REFERENCE_TO_LITERAL_EXPRESSION) {
      r = aReferenceToLiteralExpression(b, 0);
    }
    else if (t == ADDITIVE_EXPRESSION) {
      r = additiveExpression(b, 0);
    }
    else if (t == APPLE_SCRIPT_PROPERTY) {
      r = appleScriptProperty(b, 0);
    }
    else if (t == APPLICATION_OBJECT_REFERENCE) {
      r = applicationObjectReference(b, 0);
    }
    else if (t == APPLICATION_REFERENCE) {
      r = application_reference(b, 0);
    }
    else if (t == ARBITRARY_REFERENCE) {
      r = arbitraryReference(b, 0);
    }
    else if (t == BLOCK_BODY) {
      r = blockBody(b, 0);
    }
    else if (t == BUILT_IN_CLASS_NAME) {
      r = builtInClassName(b, 0);
    }
    else if (t == COERCION_BUILT_IN_EXPRESSION) {
      r = coercionBuiltInExpression(b, 0);
    }
    else if (t == COERCION_EXPRESSION) {
      r = coercionExpression(b, 0);
    }
    else if (t == COERCION_EXTERNAL_EXPRESSION) {
      r = coercionExternalExpression(b, 0);
    }
    else if (t == COMPARE_EXPRESSION) {
      r = compareExpression(b, 0);
    }
    else if (t == COMPONENT_NAME) {
      r = componentName(b, 0);
    }
    else if (t == CONCATENATION_EXPRESSION) {
      r = concatenationExpression(b, 0);
    }
    else if (t == CONSIDER_OR_IGNORE_ATTRIBUTE) {
      r = considerOrIgnoreAttribute(b, 0);
    }
    else if (t == CONSIDERING_STATEMENT) {
      r = consideringStatement(b, 0);
    }
    else if (t == CONSTANT_LITERAL_EXPRESSION) {
      r = constantLiteralExpression(b, 0);
    }
    else if (t == CONTINUE_STATEMENT) {
      r = continue_statement(b, 0);
    }
    else if (t == COUNT_COMMAND_EXPRESSION) {
      r = countCommandExpression(b, 0);
    }
    else if (t == CREATION_STATEMENT) {
      r = creationStatement(b, 0);
    }
    else if (t == DATE_LITERAL_EXPRESSION) {
      r = dateLiteralExpression(b, 0);
    }
    else if (t == DIRECT_PARAMETER_VAL) {
      r = directParameterVal(b, 0);
    }
    else if (t == ERROR_COMMAND_EXPRESSION) {
      r = errorCommandExpression(b, 0);
    }
    else if (t == EVERY_ELEM_REFERENCE) {
      r = everyElemReference(b, 0);
    }
    else if (t == EXIT_STATEMENT) {
      r = exitStatement(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == FILE_REFERENCE) {
      r = file_reference(b, 0);
    }
    else if (t == FILTER_REFERENCE) {
      r = filterReference(b, 0);
    }
    else if (t == FORMAL_PARAMETER_LIST) {
      r = formalParameterList(b, 0);
    }
    else if (t == GET_COMMAND_EXPRESSION) {
      r = getCommandExpression(b, 0);
    }
    else if (t == HANDLER_INTERLEAVED_PARAMETERS_CALL) {
      r = handlerInterleavedParametersCall(b, 0);
    }
    else if (t == HANDLER_INTERLEAVED_PARAMETERS_DEFINITION) {
      r = handlerInterleavedParametersDefinition(b, 0);
    }
    else if (t == HANDLER_LABELED_PARAMETERS_CALL) {
      r = handlerLabeledParametersCall(b, 0);
    }
    else if (t == HANDLER_LABELED_PARAMETERS_DEFINITION) {
      r = handlerLabeledParametersDefinition(b, 0);
    }
    else if (t == HANDLER_NAME_PART_DEFINITION) {
      r = handlerNamePartDefinition(b, 0);
    }
    else if (t == HANDLER_NAME_PART_REFERENCE) {
      r = handlerNamePartReference(b, 0);
    }
    else if (t == HANDLER_PARAMETER_LABEL) {
      r = handlerParameterLabel(b, 0);
    }
    else if (t == HANDLER_POSITIONAL_PARAMETERS_CALL) {
      r = handlerPositionalParametersCall(b, 0);
    }
    else if (t == HANDLER_POSITIONAL_PARAMETERS_DEFINITION) {
      r = handlerPositionalParametersDefinition(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = identifier(b, 0);
    }
    else if (t == IF_COMPOUND_STATEMENT) {
      r = ifCompoundStatement(b, 0);
    }
    else if (t == IF_SIMPLE_STATEMENT) {
      r = ifSimpleStatement(b, 0);
    }
    else if (t == IGNORING_STATEMENT) {
      r = ignoringStatement(b, 0);
    }
    else if (t == INDEX_REFERENCE) {
      r = indexReference(b, 0);
    }
    else if (t == INTEGER_LITERAL_EXPRESSION) {
      r = integerLiteralExpression(b, 0);
    }
    else if (t == LIST_LITERAL_EXPRESSION) {
      r = listLiteralExpression(b, 0);
    }
    else if (t == LOGICAL_AND_EXPRESSION) {
      r = logicalAndExpression(b, 0);
    }
    else if (t == LOGICAL_OR_EXPRESSION) {
      r = logicalOrExpression(b, 0);
    }
    else if (t == MIDDLE_ELEM_REFERENCE) {
      r = middleElemReference(b, 0);
    }
    else if (t == MULTIPLICATIVE_EXPRESSION) {
      r = multiplicativeExpression(b, 0);
    }
    else if (t == NAME_REFERENCE) {
      r = nameReference(b, 0);
    }
    else if (t == NUMERIC_CONSTANT) {
      r = numericConstant(b, 0);
    }
    else if (t == OBJECT_REF) {
      r = objectRef(b, 0);
    }
    else if (t == PARAMETER_VAL) {
      r = parameterVal(b, 0);
    }
    else if (t == PARENTHESIZED_EXPRESSION) {
      r = parenthesizedExpression(b, 0);
    }
    else if (t == POWER_EXPRESSION) {
      r = powerExpression(b, 0);
    }
    else if (t == PROPERTY_DECLARATION_STATEMENT) {
      r = propertyDeclarationStatement(b, 0);
    }
    else if (t == PROPERTY_REFERENCE) {
      r = propertyReference(b, 0);
    }
    else if (t == RANGE_REFERENCE) {
      r = rangeReference(b, 0);
    }
    else if (t == REAL_LITERAL_EXPRESSION) {
      r = realLiteralExpression(b, 0);
    }
    else if (t == RECORD_LITERAL_EXPRESSION) {
      r = recordLiteralExpression(b, 0);
    }
    else if (t == REFERENCE_EXPRESSION) {
      r = referenceExpression(b, 0);
    }
    else if (t == REFERENCE_IDENTIFIER) {
      r = referenceIdentifier(b, 0);
    }
    else if (t == RELATIVE_REFERENCE) {
      r = relativeReference(b, 0);
    }
    else if (t == REPEAT_FOREVER_STATEMENT) {
      r = repeatForeverStatement(b, 0);
    }
    else if (t == REPEAT_NUM_TIMES_STATEMENT) {
      r = repeatNumTimesStatement(b, 0);
    }
    else if (t == REPEAT_UNTIL_STATEMENT) {
      r = repeatUntilStatement(b, 0);
    }
    else if (t == REPEAT_WHILE_STATEMENT) {
      r = repeatWhileStatement(b, 0);
    }
    else if (t == REPEAT_WITH_LIST_STATEMENT) {
      r = repeatWithListStatement(b, 0);
    }
    else if (t == REPEAT_WITH_RANGE_STATEMENT) {
      r = repeatWithRangeStatement(b, 0);
    }
    else if (t == RETURN_STATEMENT) {
      r = returnStatement(b, 0);
    }
    else if (t == RUN_COMMAND_EXPRESSION) {
      r = runCommandExpression(b, 0);
    }
    else if (t == SCRIPT_OBJECT_DEFINITION_STATEMENT) {
      r = scriptObjectDefinitionStatement(b, 0);
    }
    else if (t == STRING_LITERAL_EXPRESSION) {
      r = stringLiteralExpression(b, 0);
    }
    else if (t == TARGET_COMPONENT_NAME) {
      r = targetComponentName(b, 0);
    }
    else if (t == TARGET_LIST_LITERAL) {
      r = targetListLiteral(b, 0);
    }
    else if (t == TARGET_RECORD_LITERAL) {
      r = targetRecordLiteral(b, 0);
    }
    else if (t == TELL_COMPOUND_STATEMENT) {
      r = tell_compound_statement(b, 0);
    }
    else if (t == TELL_SIMPLE_STATEMENT) {
      r = tell_simple_statement(b, 0);
    }
    else if (t == TEXT_ITEM_DELIMITERS_PROPERTY) {
      r = textItemDelimitersProperty(b, 0);
    }
    else if (t == TRY_STATEMENT) {
      r = tryStatement(b, 0);
    }
    else if (t == USE_APPLE_SCRIPT_STATEMENT) {
      r = useAppleScriptStatement(b, 0);
    }
    else if (t == USE_APPLICATION_OR_SCRIPT_STATEMENT) {
      r = useApplicationOrScriptStatement(b, 0);
    }
    else if (t == USE_FRAMEWORK_STATEMENT) {
      r = useFrameworkStatement(b, 0);
    }
    else if (t == USE_SCRIPTING_ADDITIONS_STATEMENT) {
      r = useScriptingAdditionsStatement(b, 0);
    }
    else if (t == USER_PARAMETER_VAL) {
      r = userParameterVal(b, 0);
    }
    else if (t == USING_TERMS_FROM_STATEMENT) {
      r = usingTermsFromStatement(b, 0);
    }
    else if (t == VARIABLE_DECLARATION_STATEMENT) {
      r = variableDeclarationStatement(b, 0);
    }
    else if (t == WITH_TIMEOUT_STATEMENT) {
      r = withTimeoutStatement(b, 0);
    }
    else if (t == WITH_TRANSACTION_STATEMENT) {
      r = withTransactionStatement(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return appleScriptFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ADDITIVE_EXPRESSION, A_REFERENCE_TO_LITERAL_EXPRESSION, COERCION_BUILT_IN_EXPRESSION, COERCION_EXPRESSION,
      COERCION_EXTERNAL_EXPRESSION, COMPARE_EXPRESSION, CONCATENATION_EXPRESSION, CONSTANT_LITERAL_EXPRESSION,
      COUNT_COMMAND_EXPRESSION, DATE_LITERAL_EXPRESSION, ERROR_COMMAND_EXPRESSION, EXPRESSION,
      GET_COMMAND_EXPRESSION, INTEGER_LITERAL_EXPRESSION, LIST_LITERAL_EXPRESSION, LOGICAL_AND_EXPRESSION,
      LOGICAL_OR_EXPRESSION, MULTIPLICATIVE_EXPRESSION, PARENTHESIZED_EXPRESSION, POWER_EXPRESSION,
      REAL_LITERAL_EXPRESSION, RECORD_LITERAL_EXPRESSION, REFERENCE_EXPRESSION, RUN_COMMAND_EXPRESSION,
      STRING_LITERAL_EXPRESSION),
  };

  /* ********************************************************** */
  // REF_OP referenceExpression
  public static boolean aReferenceToLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aReferenceToLiteralExpression")) return false;
    if (!nextTokenIs(b, REF_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REF_OP);
    r = r && referenceExpression(b, l + 1);
    exit_section_(b, m, A_REFERENCE_TO_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // (PLUS|MINUS) nls multiplicativeExpressionWrapper
  public static boolean additiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression")) return false;
    if (!nextTokenIs(b, "<additive expression>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<additive expression>");
    r = additiveExpression_0(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && multiplicativeExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, ADDITIVE_EXPRESSION, r, false, null);
    return r;
  }

  // PLUS|MINUS
  private static boolean additiveExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeExpressionWrapper additiveExpression*
  static boolean additiveExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeExpressionWrapper(b, l + 1);
    r = r && additiveExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // additiveExpression*
  private static boolean additiveExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!additiveExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // anything
  static boolean anythingProperty(PsiBuilder b, int l) {
    return consumeToken(b, ANYTHING);
  }

  /* ********************************************************** */
  // compilation_unit_
  static boolean appleScriptFile(PsiBuilder b, int l) {
    return compilation_unit_(b, l + 1);
  }

  /* ********************************************************** */
  // resultProperty|versionProperty|missing_value_constant/*??*/|anythingProperty
  // |textItemDelimitersProperty|parentProperty
  public static boolean appleScriptProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "appleScriptProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<apple script property>");
    r = resultProperty(b, l + 1);
    if (!r) r = versionProperty(b, l + 1);
    if (!r) r = missing_value_constant(b, l + 1);
    if (!r) r = anythingProperty(b, l + 1);
    if (!r) r = textItemDelimitersProperty(b, l + 1);
    if (!r) r = parentProperty(b, l + 1);
    exit_section_(b, l, m, APPLE_SCRIPT_PROPERTY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // countCommandExpression|getCommandExpression
  //                         |runCommandExpression|errorCommandExpression
  static boolean apple_script_command_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "apple_script_command_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = countCommandExpression(b, l + 1);
    if (!r) r = getCommandExpression(b, l + 1);
    if (!r) r = runCommandExpression(b, l + 1);
    if (!r) r = errorCommandExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // application|app
  static boolean applicationClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationClass")) return false;
    if (!nextTokenIs(b, "", APP, APPLICATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, APPLICATION);
    if (!r) r = consumeToken(b, APP);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // file
  static boolean applicationClassName(PsiBuilder b, int l) {
    return consumeToken(b, FILE);
  }

  /* ********************************************************** */
  // (of|in) THE_KW? application_reference
  public static boolean applicationObjectReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationObjectReference")) return false;
    if (!nextTokenIs(b, "<application object reference>", IN, OF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<application object reference>");
    r = applicationObjectReference_0(b, l + 1);
    r = r && applicationObjectReference_1(b, l + 1);
    r = r && application_reference(b, l + 1);
    exit_section_(b, l, m, APPLICATION_OBJECT_REFERENCE, r, false, null);
    return r;
  }

  // of|in
  private static boolean applicationObjectReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationObjectReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationObjectReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationObjectReference_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // close|launch
  static boolean applicationStandardCommandNames(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationStandardCommandNames")) return false;
    if (!nextTokenIs(b, "", CLOSE, LAUNCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLOSE);
    if (!r) r = consumeToken(b, LAUNCH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THE_KW? applicationClass STRING_LITERAL [of THE_KW?machine STRING_LITERAL (of THE_KW? zone STRING_LITERAL)?]
  //                                 |THE_KW?current_application_constant
  public static boolean application_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<application reference>");
    r = application_reference_0(b, l + 1);
    if (!r) r = application_reference_1(b, l + 1);
    exit_section_(b, l, m, APPLICATION_REFERENCE, r, false, null);
    return r;
  }

  // THE_KW? applicationClass STRING_LITERAL [of THE_KW?machine STRING_LITERAL (of THE_KW? zone STRING_LITERAL)?]
  private static boolean application_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = application_reference_0_0(b, l + 1);
    r = r && applicationClass(b, l + 1);
    r = r && consumeToken(b, STRING_LITERAL);
    r = r && application_reference_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean application_reference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // [of THE_KW?machine STRING_LITERAL (of THE_KW? zone STRING_LITERAL)?]
  private static boolean application_reference_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3")) return false;
    application_reference_0_3_0(b, l + 1);
    return true;
  }

  // of THE_KW?machine STRING_LITERAL (of THE_KW? zone STRING_LITERAL)?
  private static boolean application_reference_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    r = r && application_reference_0_3_0_1(b, l + 1);
    r = r && consumeTokens(b, 0, MACHINE, STRING_LITERAL);
    r = r && application_reference_0_3_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean application_reference_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (of THE_KW? zone STRING_LITERAL)?
  private static boolean application_reference_0_3_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3_0_4")) return false;
    application_reference_0_3_0_4_0(b, l + 1);
    return true;
  }

  // of THE_KW? zone STRING_LITERAL
  private static boolean application_reference_0_3_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    r = r && application_reference_0_3_0_4_0_1(b, l + 1);
    r = r && consumeTokens(b, 0, ZONE, STRING_LITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean application_reference_0_3_0_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_0_3_0_4_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // THE_KW?current_application_constant
  private static boolean application_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = application_reference_1_0(b, l + 1);
    r = r && current_application_constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean application_reference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_reference_1_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // some classTypeName
  public static boolean arbitraryReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arbitraryReference")) return false;
    if (!nextTokenIs(b, SOME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, SOME);
    p = r; // pin = 1
    r = r && classTypeName(b, l + 1);
    exit_section_(b, l, m, ARBITRARY_REFERENCE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // argumentListPart (COMMA argumentListPart)*
  static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = argumentListPart(b, l + 1);
    r = r && argumentList_1(b, l + 1);
    exit_section_(b, l, m, null, r, false, argument_list_recover_parser_);
    return r;
  }

  // (COMMA argumentListPart)*
  private static boolean argumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!argumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argumentList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA argumentListPart
  private static boolean argumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && argumentListPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean argumentListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentListPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = expression(b, l + 1);
    exit_section_(b, l, m, null, r, false, argument_list_part_recover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !(RPAREN|COMMA)
  static boolean argument_list_part_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_part_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !argument_list_part_recover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // RPAREN|COMMA
  private static boolean argument_list_part_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_part_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(RPAREN)
  static boolean argument_list_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_list_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !consumeToken(b, RPAREN);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (statement|COMMENT|expression|RAW_CODE)? (nls (statement|COMMENT|expression|RAW_CODE))*
  public static boolean blockBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<block body>");
    r = blockBody_0(b, l + 1);
    r = r && blockBody_1(b, l + 1);
    exit_section_(b, l, m, BLOCK_BODY, r, false, null);
    return r;
  }

  // (statement|COMMENT|expression|RAW_CODE)?
  private static boolean blockBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_0")) return false;
    blockBody_0_0(b, l + 1);
    return true;
  }

  // statement|COMMENT|expression|RAW_CODE
  private static boolean blockBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = expression(b, l + 1);
    if (!r) r = consumeToken(b, RAW_CODE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (nls (statement|COMMENT|expression|RAW_CODE))*
  private static boolean blockBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!blockBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockBody_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // nls (statement|COMMENT|expression|RAW_CODE)
  private static boolean blockBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nls(b, l + 1);
    r = r && blockBody_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement|COMMENT|expression|RAW_CODE
  private static boolean blockBody_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = expression(b, l + 1);
    if (!r) r = consumeToken(b, RAW_CODE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // true|false
  static boolean boolean_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_constant")) return false;
    if (!nextTokenIs(b, "", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // beginning|expression
  static boolean boundaryReference1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boundaryReference1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGINNING);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // end|expression
  static boolean boundaryReference2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boundaryReference2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, END);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BUILT_IN_TYPE
  public static boolean builtInClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassName")) return false;
    if (!nextTokenIs(b, BUILT_IN_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BUILT_IN_TYPE);
    exit_section_(b, m, BUILT_IN_CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // classTypeNameStrict|referenceIdentifier
  static boolean classTypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classTypeName")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeNameStrict(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtInClassName|applicationClassName
  static boolean classTypeNameStrict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classTypeNameStrict")) return false;
    if (!nextTokenIs(b, "", BUILT_IN_TYPE, FILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassName(b, l + 1);
    if (!r) r = applicationClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AS nls builtInClassName
  public static boolean coercionBuiltInExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionBuiltInExpression")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, AS);
    r = r && nls(b, l + 1);
    r = r && builtInClassName(b, l + 1);
    exit_section_(b, l, m, COERCION_BUILT_IN_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AS nls concatenationExpressionWrapper
  public static boolean coercionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpression")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, AS);
    r = r && nls(b, l + 1);
    r = r && concatenationExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, COERCION_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // concatenationExpressionWrapper coercionExpression*
  static boolean coercionExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = concatenationExpressionWrapper(b, l + 1);
    r = r && coercionExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // coercionExpression*
  private static boolean coercionExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!coercionExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "coercionExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // coercionBuiltInExpression|coercionExternalExpression
  static boolean coercionExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpression_2")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = coercionBuiltInExpression(b, l + 1);
    if (!r) r = coercionExternalExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AS nls referenceIdentifier
  public static boolean coercionExternalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExternalExpression")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, AS);
    r = r && nls(b, l + 1);
    r = r && referenceIdentifier(b, l + 1);
    exit_section_(b, l, m, COERCION_EXTERNAL_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (equalityOperator|relational_operator) nls coercionExpressionWrapper
  public static boolean compareExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<compare expression>");
    r = compareExpression_0(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && coercionExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, COMPARE_EXPRESSION, r, false, null);
    return r;
  }

  // equalityOperator|relational_operator
  private static boolean compareExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equalityOperator(b, l + 1);
    if (!r) r = relational_operator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // coercionExpressionWrapper compareExpression*
  static boolean compareExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = coercionExpressionWrapper(b, l + 1);
    r = r && compareExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // compareExpression*
  private static boolean compareExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!compareExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compareExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (
  //                         (statement sep*)
  //                       | (expression sep*)//of startup disk -> expects new line after startup without *
  //                       | (COMMENT sep*) //how to include space as a separator?
  //                       | (RAW_CODE sep*)
  // //                      | (reservedWords sep*) //to workaround problem with using reserved words inside custom commands
  //                       | sep//|spaceSep
  //                       )*
  static boolean compilation_unit_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit_")) return false;
    int c = current_position_(b);
    while (true) {
      if (!compilation_unit__0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compilation_unit_", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (statement sep*)
  //                       | (expression sep*)//of startup disk -> expects new line after startup without *
  //                       | (COMMENT sep*) //how to include space as a separator?
  //                       | (RAW_CODE sep*)
  // //                      | (reservedWords sep*) //to workaround problem with using reserved words inside custom commands
  //                       | sep
  private static boolean compilation_unit__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = compilation_unit__0_0(b, l + 1);
    if (!r) r = compilation_unit__0_1(b, l + 1);
    if (!r) r = compilation_unit__0_2(b, l + 1);
    if (!r) r = compilation_unit__0_3(b, l + 1);
    if (!r) r = sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement sep*
  private static boolean compilation_unit__0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && compilation_unit__0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sep*
  private static boolean compilation_unit__0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sep(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compilation_unit__0_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // expression sep*
  private static boolean compilation_unit__0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && compilation_unit__0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sep*
  private static boolean compilation_unit__0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sep(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compilation_unit__0_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMENT sep*
  private static boolean compilation_unit__0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    r = r && compilation_unit__0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sep*
  private static boolean compilation_unit__0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sep(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compilation_unit__0_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // RAW_CODE sep*
  private static boolean compilation_unit__0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RAW_CODE);
    r = r && compilation_unit__0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sep*
  private static boolean compilation_unit__0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit__0_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sep(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compilation_unit__0_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean componentName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<component name>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, COMPONENT_NAME, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // listLiteralExpression|recordLiteralExpression
  //                            |referenceExpression|stringLiteralExpression|referenceIdentifier
  static boolean composite_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "composite_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteralExpression(b, l + 1);
    if (!r) r = recordLiteralExpression(b, l + 1);
    if (!r) r = referenceExpression(b, l + 1);
    if (!r) r = stringLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BAND additiveExpressionWrapper
  public static boolean concatenationExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenationExpression")) return false;
    if (!nextTokenIs(b, BAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, BAND);
    r = r && additiveExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, CONCATENATION_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // additiveExpressionWrapper concatenationExpression*
  static boolean concatenationExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenationExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveExpressionWrapper(b, l + 1);
    r = r && concatenationExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // concatenationExpression*
  private static boolean concatenationExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenationExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!concatenationExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concatenationExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (applicationClass responses)|case|diacriticals|expansion|hyphens|punctuation|'white space'
  public static boolean considerOrIgnoreAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "considerOrIgnoreAttribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<consider or ignore attribute>");
    r = considerOrIgnoreAttribute_0(b, l + 1);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, DIACRITICALS);
    if (!r) r = consumeToken(b, EXPANSION);
    if (!r) r = consumeToken(b, HYPHENS);
    if (!r) r = consumeToken(b, PUNCTUATION);
    if (!r) r = consumeToken(b, "white space");
    exit_section_(b, l, m, CONSIDER_OR_IGNORE_ATTRIBUTE, r, false, null);
    return r;
  }

  // applicationClass responses
  private static boolean considerOrIgnoreAttribute_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "considerOrIgnoreAttribute_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationClass(b, l + 1);
    r = r && consumeToken(b, RESPONSES);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // considering considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls
  //                            [but ignoring considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls]
  //                            blockBody? nls
  //                          end considering
  public static boolean consideringStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement")) return false;
    if (!nextTokenIs(b, CONSIDERING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, CONSIDERING);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consideringStatement_2(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consideringStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consideringStatement_5(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, CONSIDERING)) && r;
    exit_section_(b, l, m, CONSIDERING_STATEMENT, r, p, null);
    return r || p;
  }

  // ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)?
  private static boolean consideringStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2")) return false;
    consideringStatement_2_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?
  private static boolean consideringStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consideringStatement_2_0_0(b, l + 1);
    r = r && consideringStatement_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttribute)*
  private static boolean consideringStatement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consideringStatement_2_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "consideringStatement_2_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttribute
  private static boolean consideringStatement_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttribute)?
  private static boolean consideringStatement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_1")) return false;
    consideringStatement_2_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttribute
  private static boolean consideringStatement_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [but ignoring considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls]
  private static boolean consideringStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4")) return false;
    consideringStatement_4_0(b, l + 1);
    return true;
  }

  // but ignoring considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls
  private static boolean consideringStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUT, IGNORING);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    r = r && consideringStatement_4_0_3(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)?
  private static boolean consideringStatement_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3")) return false;
    consideringStatement_4_0_3_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?
  private static boolean consideringStatement_4_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consideringStatement_4_0_3_0_0(b, l + 1);
    r = r && consideringStatement_4_0_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttribute)*
  private static boolean consideringStatement_4_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consideringStatement_4_0_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "consideringStatement_4_0_3_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttribute
  private static boolean consideringStatement_4_0_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttribute)?
  private static boolean consideringStatement_4_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3_0_1")) return false;
    consideringStatement_4_0_3_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttribute
  private static boolean consideringStatement_4_0_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_4_0_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean consideringStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // boolean_constant|date_time_constants|save_opt_constant|text_constant|itMeProperty
  public static boolean constantLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<constant literal expression>");
    r = boolean_constant(b, l + 1);
    if (!r) r = date_time_constants(b, l + 1);
    if (!r) r = save_opt_constant(b, l + 1);
    if (!r) r = text_constant(b, l + 1);
    if (!r) r = itMeProperty(b, l + 1);
    exit_section_(b, l, m, CONSTANT_LITERAL_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // isContain|doesNotContain|isIn|isNotIn
  static boolean containment_any_part_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containment_any_part_operator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = isContain(b, l + 1);
    if (!r) r = doesNotContain(b, l + 1);
    if (!r) r = isIn(b, l + 1);
    if (!r) r = isNotIn(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STARTS_BEGINS_WITH|ENDS_WITH
  static boolean containment_start_end_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containment_start_end_operator")) return false;
    if (!nextTokenIs(b, "", ENDS_WITH, STARTS_BEGINS_WITH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STARTS_BEGINS_WITH);
    if (!r) r = consumeToken(b, ENDS_WITH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // continue expression
  public static boolean continue_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continue_statement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    r = r && expression(b, l + 1);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ifStatement | tryStatement | tell_statement | repeatStatement | exitStatement
  // |consideringStatement|ignoringStatement|withTimeoutStatement|withTransactionStatement|useStatement
  static boolean control_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifStatement(b, l + 1);
    if (!r) r = tryStatement(b, l + 1);
    if (!r) r = tell_statement(b, l + 1);
    if (!r) r = repeatStatement(b, l + 1);
    if (!r) r = exitStatement(b, l + 1);
    if (!r) r = consideringStatement(b, l + 1);
    if (!r) r = ignoringStatement(b, l + 1);
    if (!r) r = withTimeoutStatement(b, l + 1);
    if (!r) r = withTransactionStatement(b, l + 1);
    if (!r) r = useStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (copy|put) 
  // (((&(referenceIdentifier to)referenceIdentifier )|expression) (to|into) targetCompositeComponent|expression)
  static boolean copyCommandStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement")) return false;
    if (!nextTokenIs(b, "", COPY, PUT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = copyCommandStatement_0(b, l + 1);
    p = r; // pin = 1
    r = r && copyCommandStatement_1(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // copy|put
  private static boolean copyCommandStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COPY);
    if (!r) r = consumeToken(b, PUT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((&(referenceIdentifier to)referenceIdentifier )|expression) (to|into) targetCompositeComponent|expression
  private static boolean copyCommandStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = copyCommandStatement_1_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((&(referenceIdentifier to)referenceIdentifier )|expression) (to|into) targetCompositeComponent
  private static boolean copyCommandStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = copyCommandStatement_1_0_0(b, l + 1);
    r = r && copyCommandStatement_1_0_1(b, l + 1);
    r = r && targetCompositeComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&(referenceIdentifier to)referenceIdentifier )|expression
  private static boolean copyCommandStatement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = copyCommandStatement_1_0_0_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(referenceIdentifier to)referenceIdentifier
  private static boolean copyCommandStatement_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = copyCommandStatement_1_0_0_0_0(b, l + 1);
    r = r && referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(referenceIdentifier to)
  private static boolean copyCommandStatement_1_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = copyCommandStatement_1_0_0_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // referenceIdentifier to
  private static boolean copyCommandStatement_1_0_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    r = r && consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // to|into
  private static boolean copyCommandStatement_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    if (!r) r = consumeToken(b, INTO);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (count [[each|every] (classTypeName|pluralClassName) (in|of)] composite_value)
  //                         |(number of [(classTypeName|pluralClassName) (in|of)] composite_value)
  public static boolean countCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression")) return false;
    if (!nextTokenIs(b, "<count command expression>", COUNT, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<count command expression>");
    r = countCommandExpression_0(b, l + 1);
    if (!r) r = countCommandExpression_1(b, l + 1);
    exit_section_(b, l, m, COUNT_COMMAND_EXPRESSION, r, false, null);
    return r;
  }

  // count [[each|every] (classTypeName|pluralClassName) (in|of)] composite_value
  private static boolean countCommandExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT);
    r = r && countCommandExpression_0_1(b, l + 1);
    r = r && composite_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [[each|every] (classTypeName|pluralClassName) (in|of)]
  private static boolean countCommandExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1")) return false;
    countCommandExpression_0_1_0(b, l + 1);
    return true;
  }

  // [each|every] (classTypeName|pluralClassName) (in|of)
  private static boolean countCommandExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = countCommandExpression_0_1_0_0(b, l + 1);
    r = r && countCommandExpression_0_1_0_1(b, l + 1);
    r = r && countCommandExpression_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [each|every]
  private static boolean countCommandExpression_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0_0")) return false;
    countCommandExpression_0_1_0_0_0(b, l + 1);
    return true;
  }

  // each|every
  private static boolean countCommandExpression_0_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EACH);
    if (!r) r = consumeToken(b, EVERY);
    exit_section_(b, m, null, r);
    return r;
  }

  // classTypeName|pluralClassName
  private static boolean countCommandExpression_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // in|of
  private static boolean countCommandExpression_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // number of [(classTypeName|pluralClassName) (in|of)] composite_value
  private static boolean countCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NUMBER, OF);
    r = r && countCommandExpression_1_2(b, l + 1);
    r = r && composite_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(classTypeName|pluralClassName) (in|of)]
  private static boolean countCommandExpression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2")) return false;
    countCommandExpression_1_2_0(b, l + 1);
    return true;
  }

  // (classTypeName|pluralClassName) (in|of)
  private static boolean countCommandExpression_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = countCommandExpression_1_2_0_0(b, l + 1);
    r = r && countCommandExpression_1_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // classTypeName|pluralClassName
  private static boolean countCommandExpression_1_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // in|of
  private static boolean countCommandExpression_1_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // setCommandSyntaxSet|setCommandSyntaxReturning
  // |copyCommandStatement
  public static boolean creationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "creationStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<creation statement>");
    r = setCommandSyntaxSet(b, l + 1);
    if (!r) r = setCommandSyntaxReturning(b, l + 1);
    if (!r) r = copyCommandStatement(b, l + 1);
    exit_section_(b, l, m, CREATION_STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'current date'
  static boolean currentDateCommand(PsiBuilder b, int l) {
    return consumeToken(b, "current date");
  }

  /* ********************************************************** */
  // current applicationClass
  static boolean current_application_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_application_constant")) return false;
    if (!nextTokenIs(b, CURRENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURRENT);
    r = r && applicationClass(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression|stringLiteralExpression
  static boolean dataSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataSpecifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    if (!r) r = stringLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (date stringLiteralExpression)|currentDateCommand
  public static boolean dateLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<date literal expression>");
    r = dateLiteralExpression_0(b, l + 1);
    if (!r) r = currentDateCommand(b, l + 1);
    exit_section_(b, l, m, DATE_LITERAL_EXPRESSION, r, false, null);
    return r;
  }

  // date stringLiteralExpression
  private static boolean dateLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateLiteralExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATE);
    r = r && stringLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // weekday_constant|month_constant
  static boolean date_time_constants(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_time_constants")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = weekday_constant(b, l + 1);
    if (!r) r = month_constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('.'DIGITS)|(DIGITS'.'DIGITS*)
  static boolean dec_significand(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_significand")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dec_significand_0(b, l + 1);
    if (!r) r = dec_significand_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '.'DIGITS
  private static boolean dec_significand_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_significand_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, DIGITS);
    exit_section_(b, m, null, r);
    return r;
  }

  // DIGITS'.'DIGITS*
  private static boolean dec_significand_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_significand_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIGITS);
    r = r && consumeToken(b, ".");
    r = r && dec_significand_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DIGITS*
  private static boolean dec_significand_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_significand_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, DIGITS)) break;
      if (!empty_element_parsed_guard_(b, "dec_significand_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // handlerCallGuardPredicate|
  //   expression
  public static boolean directParameterVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<direct parameter val>");
    r = handlerCallGuardPredicate(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, DIRECT_PARAMETER_VAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // THE_KW?componentName
  static boolean directParameterVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterVar_0(b, l + 1);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean directParameterVar_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterVar_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // "does not contain"|"doesn't contain"
  static boolean doesNotContain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doesNotContain")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "does not contain");
    if (!r) r = consumeToken(b, "doesn't contain");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NE|EQ
  static boolean equalityOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityOperator")) return false;
    if (!nextTokenIs(b, "", EQ, NE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // error [errorMessage] [number errorNumber]
  //                                 [from offendingObject]
  //                                 [to expectedType]
  //                                 [partial result resultList]
  public static boolean errorCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression")) return false;
    if (!nextTokenIs(b, ERROR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ERROR);
    r = r && errorCommandExpression_1(b, l + 1);
    r = r && errorCommandExpression_2(b, l + 1);
    r = r && errorCommandExpression_3(b, l + 1);
    r = r && errorCommandExpression_4(b, l + 1);
    r = r && errorCommandExpression_5(b, l + 1);
    exit_section_(b, m, ERROR_COMMAND_EXPRESSION, r);
    return r;
  }

  // [errorMessage]
  private static boolean errorCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_1")) return false;
    errorMessage(b, l + 1);
    return true;
  }

  // [number errorNumber]
  private static boolean errorCommandExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_2")) return false;
    errorCommandExpression_2_0(b, l + 1);
    return true;
  }

  // number errorNumber
  private static boolean errorCommandExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && errorNumber(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [from offendingObject]
  private static boolean errorCommandExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_3")) return false;
    errorCommandExpression_3_0(b, l + 1);
    return true;
  }

  // from offendingObject
  private static boolean errorCommandExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && offendingObject(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [to expectedType]
  private static boolean errorCommandExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_4")) return false;
    errorCommandExpression_4_0(b, l + 1);
    return true;
  }

  // to expectedType
  private static boolean errorCommandExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    r = r && expectedType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [partial result resultList]
  private static boolean errorCommandExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_5")) return false;
    errorCommandExpression_5_0(b, l + 1);
    return true;
  }

  // partial result resultList
  private static boolean errorCommandExpression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARTIAL, RESULT);
    r = r && resultList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // stringLiteralExpression|referenceIdentifier
  static boolean errorMessage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorMessage")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName
  static boolean errorMessageVar(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // integerLiteralExpression|referenceIdentifier
  static boolean errorNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorNumber")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName
  static boolean errorNumberVar(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // every (classTypeName|pluralClassName)
  public static boolean everyElemReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyElemReference")) return false;
    if (!nextTokenIs(b, EVERY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, EVERY);
    p = r; // pin = 1
    r = r && everyElemReference_1(b, l + 1);
    exit_section_(b, l, m, EVERY_ELEM_REFERENCE, r, p, null);
    return r || p;
  }

  // classTypeName|pluralClassName
  private static boolean everyElemReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyElemReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // exit [repeat]
  public static boolean exitStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitStatement")) return false;
    if (!nextTokenIs(b, EXIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXIT);
    r = r && exitStatement_1(b, l + 1);
    exit_section_(b, m, EXIT_STATEMENT, r);
    return r;
  }

  // [repeat]
  private static boolean exitStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitStatement_1")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // classTypeName|referenceIdentifier
  static boolean expectedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expectedType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean expectedTypeVar(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // logicalOrExpressionWrapper
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<expression>");
    r = logicalOrExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement|expression
  static boolean expressionInParentheses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionInParentheses")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THE_KW?(file|alias) expression
  public static boolean file_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<file reference>");
    r = file_reference_0(b, l + 1);
    r = r && file_reference_1(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, FILE_REFERENCE, r, false, null);
    return r;
  }

  // THE_KW?
  private static boolean file_reference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_reference_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // file|alias
  private static boolean file_reference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_reference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FILE);
    if (!r) r = consumeToken(b, ALIAS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (whose|where) expression
  public static boolean filterReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filterReference")) return false;
    if (!nextTokenIs(b, "<filter reference>", WHERE, WHOSE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<filter reference>");
    r = filterReference_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, FILTER_REFERENCE, r, false, null);
    return r;
  }

  // whose|where
  private static boolean filterReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filterReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHOSE);
    if (!r) r = consumeToken(b, WHERE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // formalParameterListPart (COMMA formalParameterListPart)*
  public static boolean formalParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<formal parameter list>");
    r = formalParameterListPart(b, l + 1);
    r = r && formalParameterList_1(b, l + 1);
    exit_section_(b, l, m, FORMAL_PARAMETER_LIST, r, false, null);
    return r;
  }

  // (COMMA formalParameterListPart)*
  private static boolean formalParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!formalParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "formalParameterList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA formalParameterListPart
  private static boolean formalParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && formalParameterListPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // targetCompositeComponent
  static boolean formalParameterListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterListPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = targetCompositeComponent(b, l + 1);
    exit_section_(b, l, m, null, r, false, argument_list_part_recover_parser_);
    return r;
  }

  /* ********************************************************** */
  // get expression
  public static boolean getCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getCommandExpression")) return false;
    if (!nextTokenIs(b, GET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GET);
    r = r && expression(b, l + 1);
    exit_section_(b, m, GET_COMMAND_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // handlerLabeledParametersCall|handlerPositionalParametersCall
  static boolean handlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall(b, l + 1);
    if (!r) r = handlerPositionalParametersCall(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &((referenceIdentifier/*|applicationStandardCommandNames*/) handlerParameterLabel)(referenceIdentifier/*|applicationStandardCommandNames*/)
  static boolean handlerCallGuardPredicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallGuardPredicate")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerCallGuardPredicate_0(b, l + 1);
    r = r && handlerCallGuardPredicate_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &((referenceIdentifier/*|applicationStandardCommandNames*/) handlerParameterLabel)
  private static boolean handlerCallGuardPredicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallGuardPredicate_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = handlerCallGuardPredicate_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (referenceIdentifier/*|applicationStandardCommandNames*/) handlerParameterLabel
  private static boolean handlerCallGuardPredicate_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallGuardPredicate_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerCallGuardPredicate_0_0_0(b, l + 1);
    r = r && handlerParameterLabel(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (referenceIdentifier/*|applicationStandardCommandNames*/)
  private static boolean handlerCallGuardPredicate_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallGuardPredicate_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (referenceIdentifier/*|applicationStandardCommandNames*/)
  private static boolean handlerCallGuardPredicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerCallGuardPredicate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON userParameterVal (handlerNamePartReference COLON userParameterVal)*
  public static boolean handlerInterleavedParametersCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersCall")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerInterleavedParametersCall_2(b, l + 1);
    exit_section_(b, l, m, HANDLER_INTERLEAVED_PARAMETERS_CALL, r, false, null);
    return r;
  }

  // (handlerNamePartReference COLON userParameterVal)*
  private static boolean handlerInterleavedParametersCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersCall_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerInterleavedParametersCall_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersCall_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // handlerNamePartReference COLON userParameterVal
  private static boolean handlerInterleavedParametersCall_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersCall_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (on|to) handlerNamePartDefinition COLON userParameterVar (handlerNamePartDefinition COLON userParameterVar)* nls
  //                                                blockBody? nls
  //                                              end [handlerNamePartDefinition COLON (handlerNamePartDefinition COLON)*]
  public static boolean handlerInterleavedParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler interleaved parameters definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<handler interleaved parameters definition>");
    r = handlerInterleavedParametersDefinition_0(b, l + 1);
    r = r && handlerNamePartDefinition(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVar(b, l + 1);
    r = r && handlerInterleavedParametersDefinition_4(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && handlerInterleavedParametersDefinition_6(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && handlerInterleavedParametersDefinition_9(b, l + 1);
    exit_section_(b, l, m, HANDLER_INTERLEAVED_PARAMETERS_DEFINITION, r, false, null);
    return r;
  }

  // on|to
  private static boolean handlerInterleavedParametersDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerNamePartDefinition COLON userParameterVar)*
  private static boolean handlerInterleavedParametersDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerInterleavedParametersDefinition_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersDefinition_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // handlerNamePartDefinition COLON userParameterVar
  private static boolean handlerInterleavedParametersDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartDefinition(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean handlerInterleavedParametersDefinition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [handlerNamePartDefinition COLON (handlerNamePartDefinition COLON)*]
  private static boolean handlerInterleavedParametersDefinition_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_9")) return false;
    handlerInterleavedParametersDefinition_9_0(b, l + 1);
    return true;
  }

  // handlerNamePartDefinition COLON (handlerNamePartDefinition COLON)*
  private static boolean handlerInterleavedParametersDefinition_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartDefinition(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && handlerInterleavedParametersDefinition_9_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerNamePartDefinition COLON)*
  private static boolean handlerInterleavedParametersDefinition_9_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_9_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerInterleavedParametersDefinition_9_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersDefinition_9_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // handlerNamePartDefinition COLON
  private static boolean handlerInterleavedParametersDefinition_9_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_9_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartDefinition(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (
  //    (of|in)? directParameterVal
  //    (
  //      (    (handlerParameterLabel parameterVal)+
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //         )?
  //      )
  //      |
  //      (    (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //      )
  //    )
  //    )|
  //    (
  //    (handlerParameterLabel parameterVal)+ //&(with|without|given)
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //        )?
  //    )
  public static boolean handlerLabeledParametersCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<handler labeled parameters call>");
    r = handlerLabeledParametersCall_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_1(b, l + 1);
    exit_section_(b, l, m, HANDLER_LABELED_PARAMETERS_CALL, r, false, null);
    return r;
  }

  // (of|in)? directParameterVal
  //    (
  //      (    (handlerParameterLabel parameterVal)+
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //         )?
  //      )
  //      |
  //      (    (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //      )
  //    )
  private static boolean handlerLabeledParametersCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_0(b, l + 1);
    r = r && directParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (of|in)?
  private static boolean handlerLabeledParametersCall_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_0")) return false;
    handlerLabeledParametersCall_0_0_0(b, l + 1);
    return true;
  }

  // of|in
  private static boolean handlerLabeledParametersCall_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (    (handlerParameterLabel parameterVal)+
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //         )?
  //      )
  //      |
  //      (    (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //      )
  private static boolean handlerLabeledParametersCall_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //         )?
  private static boolean handlerLabeledParametersCall_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_0(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  private static boolean handlerLabeledParametersCall_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCall_0_2_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_0_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerParameterLabel parameterVal
  private static boolean handlerLabeledParametersCall_0_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && parameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //         )?
  private static boolean handlerLabeledParametersCall_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1")) return false;
    handlerLabeledParametersCall_0_2_0_1_0(b, l + 1);
    return true;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_1_0_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_0_2_0_1_0_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_0_2_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1_0_0_2(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_0_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_0_1_0_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0_3")) return false;
    handlerLabeledParametersCall_0_2_0_1_0_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_1_0_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1_0_1_2(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1_0_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_0_1_0_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_0_1_0_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1_3")) return false;
    handlerLabeledParametersCall_0_2_0_1_0_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_1_0_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_0_1_0_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCall_0_2_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_0_1_0_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_0_1_0_2_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_2_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_2_0_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_0_1_0_2_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_0_1_0_2_0_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCall_0_2_0_1_0_2_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_0_1_0_2_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_1_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_0_2_1_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_0_2_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_0_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_1_0_2(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCall_0_2_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_1_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCall_0_2_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_0_2_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0_3")) return false;
    handlerLabeledParametersCall_0_2_1_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCall_0_2_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_1_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_0_2_1_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_0_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_1_1_2(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_1_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCall_0_2_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_1_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_1_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCall_0_2_1_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_0_2_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1_3")) return false;
    handlerLabeledParametersCall_0_2_1_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCall_0_2_1_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_1_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_0_2_1_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_0_2_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_0_2_1_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCall_0_2_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_1_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_0_2_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCall_0_2_1_2_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_0_2_1_2_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_2_0_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_0_2_1_2_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_0_2_1_2_0_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCall_0_2_1_2_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_0_2_1_2_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+ //&(with|without|given)
  //        (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //        )?
  private static boolean handlerLabeledParametersCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_0(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  private static boolean handlerLabeledParametersCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCall_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_1_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerParameterLabel parameterVal
  private static boolean handlerLabeledParametersCall_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && parameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (  (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  //        )?
  private static boolean handlerLabeledParametersCall_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1")) return false;
    handlerLabeledParametersCall_1_1_0(b, l + 1);
    return true;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //         | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //         | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_1_0_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_1_1_0_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCall_1_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1_0_0_2(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCall_1_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_1_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_1_1_0_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCall_1_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCall_1_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0_3")) return false;
    handlerLabeledParametersCall_1_1_0_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCall_1_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_1_0_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_1_1_0_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1_0_1_2(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1_0_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCall_1_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_1_1_0_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_1_1_0_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCall_1_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCall_1_1_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1_3")) return false;
    handlerLabeledParametersCall_1_1_0_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCall_1_1_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_1_0_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCall_1_1_0_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    if (!r) r = consumeToken(b, LOR);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)+
  private static boolean handlerLabeledParametersCall_1_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCall_1_1_0_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCall_1_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_1_1_0_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_1_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCall_1_1_0_2_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCall_1_1_0_2_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_2_0_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCall_1_1_0_2_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCall_1_1_0_2_0_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCall_1_1_0_2_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCall_1_1_0_2_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (on|to) handlerNameNonStrictDeclaration !LPAREN [(of|in)? directParameterVar]
  //                                          (handlerParameterLabel userParameterVar)*
  //                                          [given userLabelComponent COLON userParameterVar (COMMA userLabelComponent COLON userParameterVar)*] //nls //should be sep here
  //                                          [global componentName (COMMA componentName)*] //nls
  //                                          [local componentName (COMMA componentName)*] nls
  //                                            blockBody? nls
  //                                         end [handlerNameStrict]
  public static boolean handlerLabeledParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler labeled parameters definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<handler labeled parameters definition>");
    r = handlerLabeledParametersDefinition_0(b, l + 1);
    r = r && handlerNameNonStrictDeclaration(b, l + 1);
    r = r && handlerLabeledParametersDefinition_2(b, l + 1);
    r = r && handlerLabeledParametersDefinition_3(b, l + 1);
    r = r && handlerLabeledParametersDefinition_4(b, l + 1);
    r = r && handlerLabeledParametersDefinition_5(b, l + 1);
    r = r && handlerLabeledParametersDefinition_6(b, l + 1);
    r = r && handlerLabeledParametersDefinition_7(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && handlerLabeledParametersDefinition_9(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && handlerLabeledParametersDefinition_12(b, l + 1);
    exit_section_(b, l, m, HANDLER_LABELED_PARAMETERS_DEFINITION, r, false, null);
    return r;
  }

  // on|to
  private static boolean handlerLabeledParametersDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // !LPAREN
  private static boolean handlerLabeledParametersDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !consumeToken(b, LPAREN);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // [(of|in)? directParameterVar]
  private static boolean handlerLabeledParametersDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_3")) return false;
    handlerLabeledParametersDefinition_3_0(b, l + 1);
    return true;
  }

  // (of|in)? directParameterVar
  private static boolean handlerLabeledParametersDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersDefinition_3_0_0(b, l + 1);
    r = r && directParameterVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (of|in)?
  private static boolean handlerLabeledParametersDefinition_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_3_0_0")) return false;
    handlerLabeledParametersDefinition_3_0_0_0(b, l + 1);
    return true;
  }

  // of|in
  private static boolean handlerLabeledParametersDefinition_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel userParameterVar)*
  private static boolean handlerLabeledParametersDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersDefinition_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersDefinition_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // handlerParameterLabel userParameterVar
  private static boolean handlerLabeledParametersDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && userParameterVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [given userLabelComponent COLON userParameterVar (COMMA userLabelComponent COLON userParameterVar)*]
  private static boolean handlerLabeledParametersDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_5")) return false;
    handlerLabeledParametersDefinition_5_0(b, l + 1);
    return true;
  }

  // given userLabelComponent COLON userParameterVar (COMMA userLabelComponent COLON userParameterVar)*
  private static boolean handlerLabeledParametersDefinition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && userLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVar(b, l + 1);
    r = r && handlerLabeledParametersDefinition_5_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelComponent COLON userParameterVar)*
  private static boolean handlerLabeledParametersDefinition_5_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_5_0_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersDefinition_5_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersDefinition_5_0_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelComponent COLON userParameterVar
  private static boolean handlerLabeledParametersDefinition_5_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_5_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && userLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [global componentName (COMMA componentName)*]
  private static boolean handlerLabeledParametersDefinition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_6")) return false;
    handlerLabeledParametersDefinition_6_0(b, l + 1);
    return true;
  }

  // global componentName (COMMA componentName)*
  private static boolean handlerLabeledParametersDefinition_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    r = r && componentName(b, l + 1);
    r = r && handlerLabeledParametersDefinition_6_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean handlerLabeledParametersDefinition_6_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_6_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersDefinition_6_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersDefinition_6_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean handlerLabeledParametersDefinition_6_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_6_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [local componentName (COMMA componentName)*]
  private static boolean handlerLabeledParametersDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_7")) return false;
    handlerLabeledParametersDefinition_7_0(b, l + 1);
    return true;
  }

  // local componentName (COMMA componentName)*
  private static boolean handlerLabeledParametersDefinition_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && componentName(b, l + 1);
    r = r && handlerLabeledParametersDefinition_7_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean handlerLabeledParametersDefinition_7_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_7_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersDefinition_7_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersDefinition_7_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean handlerLabeledParametersDefinition_7_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_7_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean handlerLabeledParametersDefinition_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_9")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [handlerNameStrict]
  private static boolean handlerLabeledParametersDefinition_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_12")) return false;
    handlerNameStrict(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // componentName|reservedWordsNotParameterLabel
  static boolean handlerNameNonStrictDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNameNonStrictDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    if (!r) r = reservedWordsNotParameterLabel(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName
  public static boolean handlerNamePartDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNamePartDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<handler name part definition>");
    r = componentName(b, l + 1);
    exit_section_(b, l, m, HANDLER_NAME_PART_DEFINITION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  public static boolean handlerNamePartReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNamePartReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<handler name part reference>");
    r = referenceIdentifier(b, l + 1);
    exit_section_(b, l, m, HANDLER_NAME_PART_REFERENCE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ((referenceIdentifier|reservedWordsNotParameterLabel) !handlerParameterLabel)*
  static boolean handlerNameStrict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNameStrict")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerNameStrict_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerNameStrict", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (referenceIdentifier|reservedWordsNotParameterLabel) !handlerParameterLabel
  private static boolean handlerNameStrict_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNameStrict_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNameStrict_0_0(b, l + 1);
    r = r && handlerNameStrict_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceIdentifier|reservedWordsNotParameterLabel
  private static boolean handlerNameStrict_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNameStrict_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    if (!r) r = reservedWordsNotParameterLabel(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !handlerParameterLabel
  private static boolean handlerNameStrict_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerNameStrict_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !handlerParameterLabel(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // about|above|against|'apart from'|around|'aside from'|at|below|beneath|beside|between   // spaces ??
  //                      |by|for|from|'instead of'|into|on|onto|'out of'|over|since|thru|through|under
  // |to
  public static boolean handlerParameterLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerParameterLabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<handler parameter label>");
    r = consumeToken(b, ABOUT);
    if (!r) r = consumeToken(b, ABOVE);
    if (!r) r = consumeToken(b, AGAINST);
    if (!r) r = consumeToken(b, APART_FROM);
    if (!r) r = consumeToken(b, AROUND);
    if (!r) r = consumeToken(b, ASIDE_FROM);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BELOW);
    if (!r) r = consumeToken(b, BENEATH);
    if (!r) r = consumeToken(b, BESIDE);
    if (!r) r = consumeToken(b, BETWEEN);
    if (!r) r = consumeToken(b, BY);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FROM);
    if (!r) r = consumeToken(b, INSTEAD_OF);
    if (!r) r = consumeToken(b, INTO);
    if (!r) r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, ONTO);
    if (!r) r = consumeToken(b, OUT_OF);
    if (!r) r = consumeToken(b, OVER);
    if (!r) r = consumeToken(b, SINCE);
    if (!r) r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    if (!r) r = consumeToken(b, UNDER);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, l, m, HANDLER_PARAMETER_LABEL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN argumentList? RPAREN
  public static boolean handlerPositionalParametersCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersCall")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, LPAREN);
    r = r && handlerPositionalParametersCall_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, HANDLER_POSITIONAL_PARAMETERS_CALL, r, false, null);
    return r;
  }

  // argumentList?
  private static boolean handlerPositionalParametersCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersCall_1")) return false;
    argumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (on|to) handlerNameNonStrictDeclaration LPAREN formalParameterList? RPAREN
  //                                                 [global componentName (COMMA componentName)*]
  //                                                 [local componentName (COMMA componentName)*] nls
  //                                                blockBody? nls
  //                                             end !(considering|ignoring|error|try|repeat|tell|timeout|(using terms from))[handlerNameStrict]
  public static boolean handlerPositionalParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler positional parameters definition>", ON, TO)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<handler positional parameters definition>");
    r = handlerPositionalParametersDefinition_0(b, l + 1);
    r = r && handlerNameNonStrictDeclaration(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 3
    r = r && report_error_(b, handlerPositionalParametersDefinition_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    r = p && report_error_(b, handlerPositionalParametersDefinition_5(b, l + 1)) && r;
    r = p && report_error_(b, handlerPositionalParametersDefinition_6(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, handlerPositionalParametersDefinition_8(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && handlerPositionalParametersDefinition_11(b, l + 1);
    r = r && handlerPositionalParametersDefinition_12(b, l + 1);
    exit_section_(b, l, m, HANDLER_POSITIONAL_PARAMETERS_DEFINITION, r, p, null);
    return r || p;
  }

  // on|to
  private static boolean handlerPositionalParametersDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // formalParameterList?
  private static boolean handlerPositionalParametersDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_3")) return false;
    formalParameterList(b, l + 1);
    return true;
  }

  // [global componentName (COMMA componentName)*]
  private static boolean handlerPositionalParametersDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_5")) return false;
    handlerPositionalParametersDefinition_5_0(b, l + 1);
    return true;
  }

  // global componentName (COMMA componentName)*
  private static boolean handlerPositionalParametersDefinition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    r = r && componentName(b, l + 1);
    r = r && handlerPositionalParametersDefinition_5_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean handlerPositionalParametersDefinition_5_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_5_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerPositionalParametersDefinition_5_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerPositionalParametersDefinition_5_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean handlerPositionalParametersDefinition_5_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_5_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [local componentName (COMMA componentName)*]
  private static boolean handlerPositionalParametersDefinition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_6")) return false;
    handlerPositionalParametersDefinition_6_0(b, l + 1);
    return true;
  }

  // local componentName (COMMA componentName)*
  private static boolean handlerPositionalParametersDefinition_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && componentName(b, l + 1);
    r = r && handlerPositionalParametersDefinition_6_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean handlerPositionalParametersDefinition_6_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_6_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerPositionalParametersDefinition_6_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerPositionalParametersDefinition_6_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean handlerPositionalParametersDefinition_6_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_6_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean handlerPositionalParametersDefinition_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_8")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|error|try|repeat|tell|timeout|(using terms from))
  private static boolean handlerPositionalParametersDefinition_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_11")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !handlerPositionalParametersDefinition_11_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|error|try|repeat|tell|timeout|(using terms from)
  private static boolean handlerPositionalParametersDefinition_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, TIMEOUT);
    if (!r) r = handlerPositionalParametersDefinition_11_0_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean handlerPositionalParametersDefinition_11_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_11_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [handlerNameStrict]
  private static boolean handlerPositionalParametersDefinition_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_12")) return false;
    handlerNameStrict(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // var_identifier|appleScriptProperty
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<identifier>");
    r = consumeToken(b, VAR_IDENTIFIER);
    if (!r) r = appleScriptProperty(b, l + 1);
    exit_section_(b, l, m, IDENTIFIER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // if expression nls [then] nls
  //                                        blockBody? nls
  //                                    (else if expression nls [then] nls
  //                                        blockBody? nls )*
  //                                    (else nls
  //                                         blockBody? nls)?
  //                                    end /*!(considering|ignoring|tell|error|try|repeat)*/ [if]
  public static boolean ifCompoundStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_3(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_5(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_7(b, l + 1);
    r = r && ifCompoundStatement_8(b, l + 1);
    r = r && consumeToken(b, END);
    p = r; // pin = 10
    r = r && ifCompoundStatement_10(b, l + 1);
    exit_section_(b, l, m, IF_COMPOUND_STATEMENT, r, p, null);
    return r || p;
  }

  // [then]
  private static boolean ifCompoundStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_3")) return false;
    consumeToken(b, THEN);
    return true;
  }

  // blockBody?
  private static boolean ifCompoundStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // (else if expression nls [then] nls
  //                                        blockBody? nls )*
  private static boolean ifCompoundStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_7")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ifCompoundStatement_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifCompoundStatement_7", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // else if expression nls [then] nls
  //                                        blockBody? nls
  private static boolean ifCompoundStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && expression(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_7_0_4(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_7_0_6(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [then]
  private static boolean ifCompoundStatement_7_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_7_0_4")) return false;
    consumeToken(b, THEN);
    return true;
  }

  // blockBody?
  private static boolean ifCompoundStatement_7_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_7_0_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // (else nls
  //                                         blockBody? nls)?
  private static boolean ifCompoundStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_8")) return false;
    ifCompoundStatement_8_0(b, l + 1);
    return true;
  }

  // else nls
  //                                         blockBody? nls
  private static boolean ifCompoundStatement_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && nls(b, l + 1);
    r = r && ifCompoundStatement_8_0_2(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean ifCompoundStatement_8_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_8_0_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [if]
  private static boolean ifCompoundStatement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_10")) return false;
    consumeToken(b, IF);
    return true;
  }

  /* ********************************************************** */
  // if expression //what todo with recursion here?
  //                                     then (!(ifCompoundStatement) (statement|expression) /*sep**/)
  public static boolean ifSimpleStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && ifSimpleStatement_3(b, l + 1);
    exit_section_(b, m, IF_SIMPLE_STATEMENT, r);
    return r;
  }

  // !(ifCompoundStatement) (statement|expression)
  private static boolean ifSimpleStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifSimpleStatement_3_0(b, l + 1);
    r = r && ifSimpleStatement_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(ifCompoundStatement)
  private static boolean ifSimpleStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !ifSimpleStatement_3_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (ifCompoundStatement)
  private static boolean ifSimpleStatement_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifCompoundStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement|expression
  private static boolean ifSimpleStatement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ifCompoundStatement|ifSimpleStatement
  static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifCompoundStatement(b, l + 1);
    if (!r) r = ifSimpleStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ignoring considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls
  //                         [but considering considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls]
  //                            blockBody? nls
  //                       end ignoring
  public static boolean ignoringStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement")) return false;
    if (!nextTokenIs(b, IGNORING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, IGNORING);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, ignoringStatement_2(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, ignoringStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, ignoringStatement_5(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IGNORING)) && r;
    exit_section_(b, l, m, IGNORING_STATEMENT, r, p, null);
    return r || p;
  }

  // ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)?
  private static boolean ignoringStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2")) return false;
    ignoringStatement_2_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?
  private static boolean ignoringStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ignoringStatement_2_0_0(b, l + 1);
    r = r && ignoringStatement_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttribute)*
  private static boolean ignoringStatement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ignoringStatement_2_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ignoringStatement_2_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttribute
  private static boolean ignoringStatement_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttribute)?
  private static boolean ignoringStatement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_1")) return false;
    ignoringStatement_2_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttribute
  private static boolean ignoringStatement_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [but considering considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls]
  private static boolean ignoringStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4")) return false;
    ignoringStatement_4_0(b, l + 1);
    return true;
  }

  // but considering considerOrIgnoreAttribute ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)? nls
  private static boolean ignoringStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUT, CONSIDERING);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    r = r && ignoringStatement_4_0_3(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?)?
  private static boolean ignoringStatement_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3")) return false;
    ignoringStatement_4_0_3_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttribute)* (LAND considerOrIgnoreAttribute)?
  private static boolean ignoringStatement_4_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ignoringStatement_4_0_3_0_0(b, l + 1);
    r = r && ignoringStatement_4_0_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttribute)*
  private static boolean ignoringStatement_4_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ignoringStatement_4_0_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ignoringStatement_4_0_3_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttribute
  private static boolean ignoringStatement_4_0_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttribute)?
  private static boolean ignoringStatement_4_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3_0_1")) return false;
    ignoringStatement_4_0_3_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttribute
  private static boolean ignoringStatement_4_0_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_4_0_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean ignoringStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (classTypeNameStrict [index] (indexValueExpression|parenthesizedExpression))
  //                    |(classTypeName [index] indexValueExpression)
  //                    |(integerLiteralExpression('st'|'rd'|'th') classTypeName) //how to concatenate?
  //                    |((first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth) classTypeName)
  //                    |((last|front|back) classTypeName)
  public static boolean indexReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<index reference>");
    r = indexReference_0(b, l + 1);
    if (!r) r = indexReference_1(b, l + 1);
    if (!r) r = indexReference_2(b, l + 1);
    if (!r) r = indexReference_3(b, l + 1);
    if (!r) r = indexReference_4(b, l + 1);
    exit_section_(b, l, m, INDEX_REFERENCE, r, false, null);
    return r;
  }

  // classTypeNameStrict [index] (indexValueExpression|parenthesizedExpression)
  private static boolean indexReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeNameStrict(b, l + 1);
    r = r && indexReference_0_1(b, l + 1);
    r = r && indexReference_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [index]
  private static boolean indexReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0_1")) return false;
    consumeToken(b, INDEX);
    return true;
  }

  // indexValueExpression|parenthesizedExpression
  private static boolean indexReference_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexValueExpression(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // classTypeName [index] indexValueExpression
  private static boolean indexReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    r = r && indexReference_1_1(b, l + 1);
    r = r && indexValueExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [index]
  private static boolean indexReference_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_1_1")) return false;
    consumeToken(b, INDEX);
    return true;
  }

  // integerLiteralExpression('st'|'rd'|'th') classTypeName
  private static boolean indexReference_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    r = r && indexReference_2_1(b, l + 1);
    r = r && classTypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'st'|'rd'|'th'
  private static boolean indexReference_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "st");
    if (!r) r = consumeToken(b, "rd");
    if (!r) r = consumeToken(b, "th");
    exit_section_(b, m, null, r);
    return r;
  }

  // (first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth) classTypeName
  private static boolean indexReference_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexReference_3_0(b, l + 1);
    r = r && classTypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth
  private static boolean indexReference_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIRST);
    if (!r) r = consumeToken(b, SECOND);
    if (!r) r = consumeToken(b, THIRD);
    if (!r) r = consumeToken(b, FOURTH);
    if (!r) r = consumeToken(b, FIFTH);
    if (!r) r = consumeToken(b, SIXTH);
    if (!r) r = consumeToken(b, SEVENTH);
    if (!r) r = consumeToken(b, EIGHTH);
    if (!r) r = consumeToken(b, NINTH);
    if (!r) r = consumeToken(b, TENTH);
    exit_section_(b, m, null, r);
    return r;
  }

  // (last|front|back) classTypeName
  private static boolean indexReference_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexReference_4_0(b, l + 1);
    r = r && classTypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // last|front|back
  private static boolean indexReference_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAST);
    if (!r) r = consumeToken(b, FRONT);
    if (!r) r = consumeToken(b, BACK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (referenceIdentifier|reservedWordsNotParameterLabel|integerLiteralExpression)
  // //to exclude detecting as index handlerWithDirectLabeledParametersCall and other handler calls
  //  !(handlerParameterLabel|with|without|given|LPAREN|COLON)
  static boolean indexValueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexValueExpression_0(b, l + 1);
    r = r && indexValueExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceIdentifier|reservedWordsNotParameterLabel|integerLiteralExpression
  private static boolean indexValueExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValueExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    if (!r) r = reservedWordsNotParameterLabel(b, l + 1);
    if (!r) r = integerLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(handlerParameterLabel|with|without|given|LPAREN|COLON)
  private static boolean indexValueExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValueExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !indexValueExpression_1_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // handlerParameterLabel|with|without|given|LPAREN|COLON
  private static boolean indexValueExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValueExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    if (!r) r = consumeToken(b, WITH);
    if (!r) r = consumeToken(b, WITHOUT);
    if (!r) r = consumeToken(b, GIVEN);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DIGITS
  public static boolean integerLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerLiteralExpression")) return false;
    if (!nextTokenIs(b, DIGITS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIGITS);
    exit_section_(b, m, INTEGER_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // contain|contains
  static boolean isContain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isContain")) return false;
    if (!nextTokenIs(b, "", CONTAIN, CONTAINS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTAIN);
    if (!r) r = consumeToken(b, CONTAINS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "is in"|"is contained by"
  static boolean isIn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isIn")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is in");
    if (!r) r = consumeToken(b, "is contained by");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "is not in"|"is not contained by"|"isn't contained by"
  static boolean isNotIn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isNotIn")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "is not in");
    if (!r) r = consumeToken(b, "is not contained by");
    if (!r) r = consumeToken(b, "isn't contained by");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // it|me
  static boolean itMeProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itMeProperty")) return false;
    if (!nextTokenIs(b, "", IT, ME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IT);
    if (!r) r = consumeToken(b, ME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean labelForFalseParam(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean labelForTrueParam(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // LCURLY [expression|referenceIdentifier] (COMMA(expression|referenceIdentifier))* RCURLY
  static boolean listLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && listLiteral_1(b, l + 1);
    r = r && listLiteral_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // [expression|referenceIdentifier]
  private static boolean listLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_1")) return false;
    listLiteral_1_0(b, l + 1);
    return true;
  }

  // expression|referenceIdentifier
  private static boolean listLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA(expression|referenceIdentifier))*
  private static boolean listLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!listLiteral_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listLiteral_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA(expression|referenceIdentifier)
  private static boolean listLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && listLiteral_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression|referenceIdentifier
  private static boolean listLiteral_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((listLiteral|numberLiteralExpression|boolean_constant|dateLiteralExpression|parenthesizedExpression|referenceIdentifier)
  // (BAND nls primaryExpression)+)//any other(than string or record) class converted to a list
  // |listLiteral
  public static boolean listLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<list literal expression>");
    r = listLiteralExpression_0(b, l + 1);
    if (!r) r = listLiteral(b, l + 1);
    exit_section_(b, l, m, LIST_LITERAL_EXPRESSION, r, false, null);
    return r;
  }

  // (listLiteral|numberLiteralExpression|boolean_constant|dateLiteralExpression|parenthesizedExpression|referenceIdentifier)
  // (BAND nls primaryExpression)+
  private static boolean listLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteralExpression_0_0(b, l + 1);
    r = r && listLiteralExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // listLiteral|numberLiteralExpression|boolean_constant|dateLiteralExpression|parenthesizedExpression|referenceIdentifier
  private static boolean listLiteralExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteral(b, l + 1);
    if (!r) r = numberLiteralExpression(b, l + 1);
    if (!r) r = boolean_constant(b, l + 1);
    if (!r) r = dateLiteralExpression(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BAND nls primaryExpression)+
  private static boolean listLiteralExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteralExpression_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!listLiteralExpression_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listLiteralExpression_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // BAND nls primaryExpression
  private static boolean listLiteralExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAND);
    r = r && nls(b, l + 1);
    r = r && primaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // listLiteralExpression|objectRefWrapper
  static boolean listOrReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listOrReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteralExpression(b, l + 1);
    if (!r) r = objectRefWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // stringLiteralExpression
  //               |styledTextLiteralExpression
  //               //|built_in_type
  //               |numberLiteralExpression
  //               |constantLiteralExpression
  //               |listLiteralExpression
  //               |recordLiteralExpression
  //               |dateLiteralExpression
  //               |aReferenceToLiteralExpression
  static boolean literalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringLiteralExpression(b, l + 1);
    if (!r) r = styledTextLiteralExpression(b, l + 1);
    if (!r) r = numberLiteralExpression(b, l + 1);
    if (!r) r = constantLiteralExpression(b, l + 1);
    if (!r) r = listLiteralExpression(b, l + 1);
    if (!r) r = recordLiteralExpression(b, l + 1);
    if (!r) r = dateLiteralExpression(b, l + 1);
    if (!r) r = aReferenceToLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LAND nls compareExpressionWrapper
  public static boolean logicalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression")) return false;
    if (!nextTokenIs(b, LAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, LAND);
    r = r && nls(b, l + 1);
    r = r && compareExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, LOGICAL_AND_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // compareExpressionWrapper logicalAndExpression*
  static boolean logicalAndExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = compareExpressionWrapper(b, l + 1);
    r = r && logicalAndExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logicalAndExpression*
  private static boolean logicalAndExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!logicalAndExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalAndExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // LOR nls logicalAndExpressionWrapper
  public static boolean logicalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression")) return false;
    if (!nextTokenIs(b, LOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, LOR);
    r = r && nls(b, l + 1);
    r = r && logicalAndExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, LOGICAL_OR_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // logicalAndExpressionWrapper logicalOrExpression*
  static boolean logicalOrExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logicalAndExpressionWrapper(b, l + 1);
    r = r && logicalOrExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logicalOrExpression*
  private static boolean logicalOrExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!logicalOrExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalOrExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // componentName
  static boolean loopVariable(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // middle classTypeName
  public static boolean middleElemReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "middleElemReference")) return false;
    if (!nextTokenIs(b, MIDDLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, MIDDLE);
    p = r; // pin = 1
    r = r && classTypeName(b, l + 1);
    exit_section_(b, l, m, MIDDLE_ELEM_REFERENCE, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'missing value'
  static boolean missing_value_constant(PsiBuilder b, int l) {
    return consumeToken(b, "missing value");
  }

  /* ********************************************************** */
  // 'January'|'February'|'March'|'April'|'May'|'June'|'July'|'August'|'September'|'October'
  //                     |'November'|'December' |'Jan'|'Feb'|'Mar'|'Apr'|'Jun'|'Jul'|'Aug'|'Sep'|'Oct'|'Nov'|'Dec'
  static boolean month_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "month_constant")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "January");
    if (!r) r = consumeToken(b, "February");
    if (!r) r = consumeToken(b, "March");
    if (!r) r = consumeToken(b, "April");
    if (!r) r = consumeToken(b, "May");
    if (!r) r = consumeToken(b, "June");
    if (!r) r = consumeToken(b, "July");
    if (!r) r = consumeToken(b, "August");
    if (!r) r = consumeToken(b, "September");
    if (!r) r = consumeToken(b, "October");
    if (!r) r = consumeToken(b, "November");
    if (!r) r = consumeToken(b, "December");
    if (!r) r = consumeToken(b, "Jan");
    if (!r) r = consumeToken(b, "Feb");
    if (!r) r = consumeToken(b, "Mar");
    if (!r) r = consumeToken(b, "Apr");
    if (!r) r = consumeToken(b, "Jun");
    if (!r) r = consumeToken(b, "Jul");
    if (!r) r = consumeToken(b, "Aug");
    if (!r) r = consumeToken(b, "Sep");
    if (!r) r = consumeToken(b, "Oct");
    if (!r) r = consumeToken(b, "Nov");
    if (!r) r = consumeToken(b, "Dec");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeOperator nls powerExpressionWrapper
  public static boolean multiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<multiplicative expression>");
    r = multiplicativeOperator(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && powerExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, MULTIPLICATIVE_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // powerExpressionWrapper multiplicativeExpression*
  static boolean multiplicativeExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = powerExpressionWrapper(b, l + 1);
    r = r && multiplicativeExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // multiplicativeExpression*
  private static boolean multiplicativeExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!multiplicativeExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // STAR|DIV|INT_DIV|MOD
  static boolean multiplicativeOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, INT_DIV);
    if (!r) r = consumeToken(b, MOD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // classTypeName [named] nameString
  public static boolean nameReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<name reference>");
    r = classTypeName(b, l + 1);
    r = r && nameReference_1(b, l + 1);
    r = r && nameString(b, l + 1);
    exit_section_(b, l, m, NAME_REFERENCE, r, false, null);
    return r;
  }

  // [named]
  private static boolean nameReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameReference_1")) return false;
    consumeToken(b, NAMED);
    return true;
  }

  /* ********************************************************** */
  // stringLiteralExpression
  static boolean nameString(PsiBuilder b, int l) {
    return stringLiteralExpression(b, l + 1);
  }

  /* ********************************************************** */
  // NLS*
  static boolean nls(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nls")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "nls", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // integerLiteralExpression|referenceIdentifier|parenthesizedExpression
  static boolean numTimes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numTimes")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // realLiteralExpression|integerLiteralExpression|numericConstant
  static boolean numberLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = realLiteralExpression(b, l + 1);
    if (!r) r = integerLiteralExpression(b, l + 1);
    if (!r) r = numericConstant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PI_CONSTANT|seconds_constants
  public static boolean numericConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numericConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<numeric constant>");
    r = consumeToken(b, PI_CONSTANT);
    if (!r) r = seconds_constants(b, l + 1);
    exit_section_(b, l, m, NUMERIC_CONSTANT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (of|in) THE_KW? ((prefixExpression APS THE_KW? prefixExpression handlerInterleavedParametersCall?)|prefixExpression handlerInterleavedParametersCall?)
  // [filterReference] THE_KW? applicationObjectReference?
  public static boolean objectRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef")) return false;
    if (!nextTokenIs(b, "<object ref>", IN, OF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<object ref>");
    r = objectRef_0(b, l + 1);
    r = r && objectRef_1(b, l + 1);
    r = r && objectRef_2(b, l + 1);
    r = r && objectRef_3(b, l + 1);
    r = r && objectRef_4(b, l + 1);
    r = r && objectRef_5(b, l + 1);
    exit_section_(b, l, m, OBJECT_REF, r, false, null);
    return r;
  }

  // of|in
  private static boolean objectRef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectRef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (prefixExpression APS THE_KW? prefixExpression handlerInterleavedParametersCall?)|prefixExpression handlerInterleavedParametersCall?
  private static boolean objectRef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRef_2_0(b, l + 1);
    if (!r) r = objectRef_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefixExpression APS THE_KW? prefixExpression handlerInterleavedParametersCall?
  private static boolean objectRef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression(b, l + 1);
    r = r && consumeToken(b, APS);
    r = r && objectRef_2_0_2(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    r = r && objectRef_2_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectRef_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2_0_2")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // handlerInterleavedParametersCall?
  private static boolean objectRef_2_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2_0_4")) return false;
    handlerInterleavedParametersCall(b, l + 1);
    return true;
  }

  // prefixExpression handlerInterleavedParametersCall?
  private static boolean objectRef_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression(b, l + 1);
    r = r && objectRef_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerInterleavedParametersCall?
  private static boolean objectRef_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_2_1_1")) return false;
    handlerInterleavedParametersCall(b, l + 1);
    return true;
  }

  // [filterReference]
  private static boolean objectRef_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_3")) return false;
    filterReference(b, l + 1);
    return true;
  }

  // THE_KW?
  private static boolean objectRef_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_4")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // applicationObjectReference?
  private static boolean objectRef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef_5")) return false;
    applicationObjectReference(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // THE_KW? ((prefixExpression APS THE_KW?prefixExpression handlerInterleavedParametersCall?)|prefixExpression) [filterReference]
  // ((THE_KW? applicationObjectReference)|objectRef*)
  static boolean objectRefWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper_0(b, l + 1);
    r = r && objectRefWrapper_1(b, l + 1);
    r = r && objectRefWrapper_2(b, l + 1);
    r = r && objectRefWrapper_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectRefWrapper_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (prefixExpression APS THE_KW?prefixExpression handlerInterleavedParametersCall?)|prefixExpression
  private static boolean objectRefWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper_1_0(b, l + 1);
    if (!r) r = prefixExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefixExpression APS THE_KW?prefixExpression handlerInterleavedParametersCall?
  private static boolean objectRefWrapper_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression(b, l + 1);
    r = r && consumeToken(b, APS);
    r = r && objectRefWrapper_1_0_2(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    r = r && objectRefWrapper_1_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectRefWrapper_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_1_0_2")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // handlerInterleavedParametersCall?
  private static boolean objectRefWrapper_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_1_0_4")) return false;
    handlerInterleavedParametersCall(b, l + 1);
    return true;
  }

  // [filterReference]
  private static boolean objectRefWrapper_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_2")) return false;
    filterReference(b, l + 1);
    return true;
  }

  // (THE_KW? applicationObjectReference)|objectRef*
  private static boolean objectRefWrapper_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper_3_0(b, l + 1);
    if (!r) r = objectRefWrapper_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW? applicationObjectReference
  private static boolean objectRefWrapper_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper_3_0_0(b, l + 1);
    r = r && applicationObjectReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectRefWrapper_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_3_0_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // objectRef*
  private static boolean objectRefWrapper_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRefWrapper_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!objectRef(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "objectRefWrapper_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // classTypeName|objectRefWrapper
  static boolean offendingObject(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offendingObject")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    if (!r) r = objectRefWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean offendingObjectVar(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // !(handlerParameterLabel (error|literalExpression|refForm))handlerParameterLabel
  static boolean parameterLabelSafeInclude(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterLabelSafeInclude")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterLabelSafeInclude_0(b, l + 1);
    r = r && handlerParameterLabel(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(handlerParameterLabel (error|literalExpression|refForm))
  private static boolean parameterLabelSafeInclude_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterLabelSafeInclude_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !parameterLabelSafeInclude_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // handlerParameterLabel (error|literalExpression|refForm)
  private static boolean parameterLabelSafeInclude_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterLabelSafeInclude_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && parameterLabelSafeInclude_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // error|literalExpression|refForm
  private static boolean parameterLabelSafeInclude_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterLabelSafeInclude_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ERROR);
    if (!r) r = literalExpression(b, l + 1);
    if (!r) r = refForm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // handlerCallGuardPredicate|
  //  expression
  public static boolean parameterVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter val>");
    r = handlerCallGuardPredicate(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, PARAMETER_VAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // parent
  static boolean parentProperty(PsiBuilder b, int l) {
    return consumeToken(b, PARENT);
  }

  /* ********************************************************** */
  // LPAREN expressionInParentheses RPAREN
  public static boolean parenthesizedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesizedExpression")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expressionInParentheses(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARENTHESIZED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // classTypeName"s"|classTypeName
  static boolean pluralClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pluralClassName_0(b, l + 1);
    if (!r) r = classTypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // classTypeName"s"
  private static boolean pluralClassName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    r = r && consumeToken(b, "s");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // POW objectRefWrapper
  public static boolean powerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "powerExpression")) return false;
    if (!nextTokenIs(b, POW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, POW);
    r = r && objectRefWrapper(b, l + 1);
    exit_section_(b, l, m, POWER_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // objectRefWrapper powerExpression*
  static boolean powerExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "powerExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper(b, l + 1);
    r = r && powerExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // powerExpression*
  private static boolean powerExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "powerExpressionWrapper_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!powerExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "powerExpressionWrapper_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (prefixOperator nls prefixExpression) | valueExpression
  static boolean prefixExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression_0(b, l + 1);
    if (!r) r = valueExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefixOperator nls prefixExpression
  private static boolean prefixExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixOperator(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS|MINUS|LNOT
  static boolean prefixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, LNOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literalExpression//literals and paren expressions are included into ref.expr...
  //                              |referenceExpression //handlerCallExpression?//handler call here??
  //                              |parenthesizedExpression
  //                              |apple_script_command_expression
  // //                             |appleScriptPropertiesConstant
  //                              //|builtInTypeName //todo to think where to include this in the end
  //                              |reservedWords
  static boolean primaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literalExpression(b, l + 1);
    if (!r) r = referenceExpression(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    if (!r) r = apple_script_command_expression(b, l + 1);
    if (!r) r = reservedWords(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (property|prop) propertyLabelComponent COLON propertyInitializer
  static boolean propertyCommonDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyCommonDeclarationStatement")) return false;
    if (!nextTokenIs(b, "", PROP, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = propertyCommonDeclarationStatement_0(b, l + 1);
    r = r && propertyLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && propertyInitializer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // property|prop
  private static boolean propertyCommonDeclarationStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyCommonDeclarationStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY);
    if (!r) r = consumeToken(b, PROP);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // propertyCommonDeclarationStatement
  public static boolean propertyDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyDeclarationStatement")) return false;
    if (!nextTokenIs(b, "<property declaration statement>", PROP, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<property declaration statement>");
    r = propertyCommonDeclarationStatement(b, l + 1);
    exit_section_(b, l, m, PROPERTY_DECLARATION_STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean propertyInitializer(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // builtInClassName|componentName
  static boolean propertyLabelComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyLabelComponent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassName(b, l + 1);
    if (!r) r = componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtInClassName|referenceIdentifier|literalExpression
  static boolean propertyLabelReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyLabelReference")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassName(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    if (!r) r = literalExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // propertyLabelReference
  public static boolean propertyReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<property reference>");
    r = propertyLabelReference(b, l + 1);
    exit_section_(b, l, m, PROPERTY_REFERENCE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (every classTypeName from boundaryReference1 to boundaryReference2)
  //                    |(pluralClassName from boundaryReference1 to boundaryReference2)
  //                    |(classTypeName startIndex (thru|through) stopIndex)
  //                    |(pluralClassName startIndex (thru|through) stopIndex)
  public static boolean rangeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<range reference>");
    r = rangeReference_0(b, l + 1);
    if (!r) r = rangeReference_1(b, l + 1);
    if (!r) r = rangeReference_2(b, l + 1);
    if (!r) r = rangeReference_3(b, l + 1);
    exit_section_(b, l, m, RANGE_REFERENCE, r, false, null);
    return r;
  }

  // every classTypeName from boundaryReference1 to boundaryReference2
  private static boolean rangeReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVERY);
    r = r && classTypeName(b, l + 1);
    r = r && consumeToken(b, FROM);
    r = r && boundaryReference1(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && boundaryReference2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // pluralClassName from boundaryReference1 to boundaryReference2
  private static boolean rangeReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pluralClassName(b, l + 1);
    r = r && consumeToken(b, FROM);
    r = r && boundaryReference1(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && boundaryReference2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // classTypeName startIndex (thru|through) stopIndex
  private static boolean rangeReference_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    r = r && startIndex(b, l + 1);
    r = r && rangeReference_2_2(b, l + 1);
    r = r && stopIndex(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // thru|through
  private static boolean rangeReference_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    exit_section_(b, m, null, r);
    return r;
  }

  // pluralClassName startIndex (thru|through) stopIndex
  private static boolean rangeReference_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pluralClassName(b, l + 1);
    r = r && startIndex(b, l + 1);
    r = r && rangeReference_3_2(b, l + 1);
    r = r && stopIndex(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // thru|through
  private static boolean rangeReference_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReference_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('.'(DIGITS)(DEC_EXPONENT))|(dec_significand nls DEC_EXPONENT?)
  public static boolean realLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<real literal expression>");
    r = realLiteralExpression_0(b, l + 1);
    if (!r) r = realLiteralExpression_1(b, l + 1);
    exit_section_(b, l, m, REAL_LITERAL_EXPRESSION, r, false, null);
    return r;
  }

  // '.'(DIGITS)(DEC_EXPONENT)
  private static boolean realLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && consumeToken(b, DIGITS);
    r = r && consumeToken(b, DEC_EXPONENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // dec_significand nls DEC_EXPONENT?
  private static boolean realLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dec_significand(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && realLiteralExpression_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DEC_EXPONENT?
  private static boolean realLiteralExpression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_1_2")) return false;
    consumeToken(b, DEC_EXPONENT);
    return true;
  }

  /* ********************************************************** */
  // LCURLY[propertyLabelComponent COLON expression] (COMMA propertyLabelComponent COLON expression)* RCURLY
  static boolean recordLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteral")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && recordLiteral_1(b, l + 1);
    r = r && recordLiteral_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // [propertyLabelComponent COLON expression]
  private static boolean recordLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteral_1")) return false;
    recordLiteral_1_0(b, l + 1);
    return true;
  }

  // propertyLabelComponent COLON expression
  private static boolean recordLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = propertyLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA propertyLabelComponent COLON expression)*
  private static boolean recordLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteral_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!recordLiteral_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordLiteral_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA propertyLabelComponent COLON expression
  private static boolean recordLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && propertyLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // recordLiteral (BAND nls primaryExpression)*
  public static boolean recordLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = recordLiteral(b, l + 1);
    r = r && recordLiteralExpression_1(b, l + 1);
    exit_section_(b, m, RECORD_LITERAL_EXPRESSION, r);
    return r;
  }

  // (BAND nls primaryExpression)*
  private static boolean recordLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!recordLiteralExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordLiteralExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // BAND nls primaryExpression
  private static boolean recordLiteralExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAND);
    r = r && nls(b, l + 1);
    r = r && primaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (my referenceIdentifier handlerInterleavedParametersCall)
  //                     |(my?
  //                     (arbitraryReference
  //                     |everyElemReference
  //                     |rangeReference
  //                     |nameReference
  //                     |middleElemReference
  //                     |relativeReference
  //                     |indexReference
  //                     |propertyReference handlerCallExpression?
  //                      ))
  static boolean refForm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = refForm_0(b, l + 1);
    if (!r) r = refForm_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my referenceIdentifier handlerInterleavedParametersCall
  private static boolean refForm_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MY);
    r = r && referenceIdentifier(b, l + 1);
    r = r && handlerInterleavedParametersCall(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my?
  //                     (arbitraryReference
  //                     |everyElemReference
  //                     |rangeReference
  //                     |nameReference
  //                     |middleElemReference
  //                     |relativeReference
  //                     |indexReference
  //                     |propertyReference handlerCallExpression?
  //                      )
  private static boolean refForm_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = refForm_1_0(b, l + 1);
    r = r && refForm_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my?
  private static boolean refForm_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_1_0")) return false;
    consumeToken(b, MY);
    return true;
  }

  // arbitraryReference
  //                     |everyElemReference
  //                     |rangeReference
  //                     |nameReference
  //                     |middleElemReference
  //                     |relativeReference
  //                     |indexReference
  //                     |propertyReference handlerCallExpression?
  private static boolean refForm_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arbitraryReference(b, l + 1);
    if (!r) r = everyElemReference(b, l + 1);
    if (!r) r = rangeReference(b, l + 1);
    if (!r) r = nameReference(b, l + 1);
    if (!r) r = middleElemReference(b, l + 1);
    if (!r) r = relativeReference(b, l + 1);
    if (!r) r = indexReference(b, l + 1);
    if (!r) r = refForm_1_1_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // propertyReference handlerCallExpression?
  private static boolean refForm_1_1_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_1_1_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = propertyReference(b, l + 1);
    r = r && refForm_1_1_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerCallExpression?
  private static boolean refForm_1_1_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refForm_1_1_7_1")) return false;
    handlerCallExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // refForm
  //                                 |application_reference
  //                                 |file_reference
  //                                 |referenceIdentifier handlerCallExpression?
  public static boolean referenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<reference expression>");
    r = refForm(b, l + 1);
    if (!r) r = application_reference(b, l + 1);
    if (!r) r = file_reference(b, l + 1);
    if (!r) r = referenceExpression_3(b, l + 1);
    exit_section_(b, l, m, REFERENCE_EXPRESSION, r, false, null);
    return r;
  }

  // referenceIdentifier handlerCallExpression?
  private static boolean referenceExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    r = r && referenceExpression_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerCallExpression?
  private static boolean referenceExpression_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression_3_1")) return false;
    handlerCallExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier|applicationStandardCommandNames
  public static boolean referenceIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<reference identifier>");
    r = identifier(b, l + 1);
    if (!r) r = applicationStandardCommandNames(b, l + 1);
    exit_section_(b, l, m, REFERENCE_IDENTIFIER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // application_reference
  static boolean referenceToApplicationVar(PsiBuilder b, int l) {
    return application_reference(b, l + 1);
  }

  /* ********************************************************** */
  // LT|GT|LE|GE|containment_start_end_operator|containment_any_part_operator
  static boolean relational_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_operator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = containment_start_end_operator(b, l + 1);
    if (!r) r = containment_any_part_operator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ([classTypeName](before|([in]front of) )referenceExpression)
  //                        |([classTypeName](after|([in]back of)|behind)referenceExpression)
  public static boolean relativeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<relative reference>");
    r = relativeReference_0(b, l + 1);
    if (!r) r = relativeReference_1(b, l + 1);
    exit_section_(b, l, m, RELATIVE_REFERENCE, r, false, null);
    return r;
  }

  // [classTypeName](before|([in]front of) )referenceExpression
  private static boolean relativeReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeReference_0_0(b, l + 1);
    r = r && relativeReference_0_1(b, l + 1);
    r = r && referenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [classTypeName]
  private static boolean relativeReference_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_0_0")) return false;
    classTypeName(b, l + 1);
    return true;
  }

  // before|([in]front of)
  private static boolean relativeReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEFORE);
    if (!r) r = relativeReference_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]front of
  private static boolean relativeReference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeReference_0_1_1_0(b, l + 1);
    r = r && consumeTokens(b, 0, FRONT, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]
  private static boolean relativeReference_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_0_1_1_0")) return false;
    consumeToken(b, IN);
    return true;
  }

  // [classTypeName](after|([in]back of)|behind)referenceExpression
  private static boolean relativeReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeReference_1_0(b, l + 1);
    r = r && relativeReference_1_1(b, l + 1);
    r = r && referenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [classTypeName]
  private static boolean relativeReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_1_0")) return false;
    classTypeName(b, l + 1);
    return true;
  }

  // after|([in]back of)|behind
  private static boolean relativeReference_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AFTER);
    if (!r) r = relativeReference_1_1_1(b, l + 1);
    if (!r) r = consumeToken(b, BEHIND);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]back of
  private static boolean relativeReference_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_1_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeReference_1_1_1_0(b, l + 1);
    r = r && consumeTokens(b, 0, BACK, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]
  private static boolean relativeReference_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference_1_1_1_0")) return false;
    consumeToken(b, IN);
    return true;
  }

  /* ********************************************************** */
  // repeat nls
  //                             blockBody? nls
  //                            end /*!(considering|ignoring|tell|error|try|(using terms from))*/[repeat]
  public static boolean repeatForeverStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && nls(b, l + 1);
    r = r && repeatForeverStatement_2(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && repeatForeverStatement_5(b, l + 1);
    exit_section_(b, m, REPEAT_FOREVER_STATEMENT, r);
    return r;
  }

  // blockBody?
  private static boolean repeatForeverStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [repeat]
  private static boolean repeatForeverStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement_5")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // repeat numTimes [times] nls
  //                             blockBody? nls
  //                             end [repeat]
  public static boolean repeatNumTimesStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && numTimes(b, l + 1);
    r = r && repeatNumTimesStatement_2(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && repeatNumTimesStatement_4(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && repeatNumTimesStatement_7(b, l + 1);
    exit_section_(b, m, REPEAT_NUM_TIMES_STATEMENT, r);
    return r;
  }

  // [times]
  private static boolean repeatNumTimesStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement_2")) return false;
    consumeToken(b, TIMES);
    return true;
  }

  // blockBody?
  private static boolean repeatNumTimesStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [repeat]
  private static boolean repeatNumTimesStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement_7")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // repeatNumTimesStatement | repeatWhileStatement | repeatUntilStatement
  // | repeatWithRangeStatement | repeatWithListStatement | repeatForeverStatement
  static boolean repeatStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = repeatNumTimesStatement(b, l + 1);
    if (!r) r = repeatWhileStatement(b, l + 1);
    if (!r) r = repeatUntilStatement(b, l + 1);
    if (!r) r = repeatWithRangeStatement(b, l + 1);
    if (!r) r = repeatWithListStatement(b, l + 1);
    if (!r) r = repeatForeverStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // repeat until expression nls
  //                          blockBody? nls
  //                          end [repeat]
  public static boolean repeatUntilStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, REPEAT, UNTIL);
    p = r; // pin = 2
    r = r && report_error_(b, expression(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, repeatUntilStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatUntilStatement_7(b, l + 1) && r;
    exit_section_(b, l, m, REPEAT_UNTIL_STATEMENT, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatUntilStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [repeat]
  private static boolean repeatUntilStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement_7")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // repeat while expression nls
  //                             blockBody? nls
  //                          end [repeat]
  public static boolean repeatWhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, REPEAT, WHILE);
    p = r; // pin = 2
    r = r && report_error_(b, expression(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, repeatWhileStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatWhileStatement_7(b, l + 1) && r;
    exit_section_(b, l, m, REPEAT_WHILE_STATEMENT, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatWhileStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [repeat]
  private static boolean repeatWhileStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement_7")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // repeat with loopVariable in listOrReferenceExpression nls
  //                          blockBody? nls
  //                          end !(considering|ignoring|tell|error|try|(using terms from))[repeat]
  public static boolean repeatWithListStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 0, REPEAT, WITH);
    r = r && loopVariable(b, l + 1);
    r = r && consumeToken(b, IN);
    p = r; // pin = 4
    r = r && report_error_(b, listOrReferenceExpression(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithListStatement_6(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && repeatWithListStatement_9(b, l + 1);
    r = r && repeatWithListStatement_10(b, l + 1);
    exit_section_(b, l, m, REPEAT_WITH_LIST_STATEMENT, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatWithListStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|tell|error|try|(using terms from))
  private static boolean repeatWithListStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_9")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !repeatWithListStatement_9_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|tell|error|try|(using terms from)
  private static boolean repeatWithListStatement_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = repeatWithListStatement_9_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean repeatWithListStatement_9_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_9_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [repeat]
  private static boolean repeatWithListStatement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_10")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // repeat with loopVariable from startValue to stopValue [by stepValue] nls
  //                              blockBody? nls
  //                              end [repeat]
  public static boolean repeatWithRangeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 0, REPEAT, WITH);
    r = r && loopVariable(b, l + 1);
    r = r && consumeToken(b, FROM);
    p = r; // pin = 4
    r = r && report_error_(b, startValue(b, l + 1));
    r = p && report_error_(b, consumeToken(b, TO)) && r;
    r = p && report_error_(b, stopValue(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithRangeStatement_7(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithRangeStatement_9(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatWithRangeStatement_12(b, l + 1) && r;
    exit_section_(b, l, m, REPEAT_WITH_RANGE_STATEMENT, r, p, null);
    return r || p;
  }

  // [by stepValue]
  private static boolean repeatWithRangeStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement_7")) return false;
    repeatWithRangeStatement_7_0(b, l + 1);
    return true;
  }

  // by stepValue
  private static boolean repeatWithRangeStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BY);
    r = r && stepValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean repeatWithRangeStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement_9")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [repeat]
  private static boolean repeatWithRangeStatement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement_12")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // reservedWordsNotParameterLabel|parameterLabelSafeInclude
  static boolean reservedWords(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reservedWords")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reservedWordsNotParameterLabel(b, l + 1);
    if (!r) r = parameterLabelSafeInclude(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ref|THE_KW|with
  static boolean reservedWordsNotParameterLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reservedWordsNotParameterLabel")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REF);
    if (!r) r = consumeToken(b, THE_KW);
    if (!r) r = consumeToken(b, WITH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // listLiteralExpression|referenceIdentifier
  static boolean resultList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultList")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean resultListVar(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // result
  static boolean resultProperty(PsiBuilder b, int l) {
    return consumeToken(b, RESULT);
  }

  /* ********************************************************** */
  // return [expression]
  public static boolean returnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && returnStatement_1(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // [expression]
  private static boolean returnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStatement_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (run [script_object_variable])
  // |(run [referenceToApplicationVar])
  public static boolean runCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression")) return false;
    if (!nextTokenIs(b, RUN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = runCommandExpression_0(b, l + 1);
    if (!r) r = runCommandExpression_1(b, l + 1);
    exit_section_(b, m, RUN_COMMAND_EXPRESSION, r);
    return r;
  }

  // run [script_object_variable]
  private static boolean runCommandExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RUN);
    r = r && runCommandExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [script_object_variable]
  private static boolean runCommandExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_0_1")) return false;
    script_object_variable(b, l + 1);
    return true;
  }

  // run [referenceToApplicationVar]
  private static boolean runCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RUN);
    r = r && runCommandExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [referenceToApplicationVar]
  private static boolean runCommandExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_1_1")) return false;
    referenceToApplicationVar(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // yes|no|ask
  static boolean save_opt_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "save_opt_constant")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YES);
    if (!r) r = consumeToken(b, NO);
    if (!r) r = consumeToken(b, ASK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // script [scriptObjectName] nls
  //                                        blockBody? nls
  //                                     end [script]
  public static boolean scriptObjectDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinitionStatement")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, SCRIPT);
    p = r; // pin = 1
    r = r && report_error_(b, scriptObjectDefinitionStatement_1(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, scriptObjectDefinitionStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && scriptObjectDefinitionStatement_6(b, l + 1) && r;
    exit_section_(b, l, m, SCRIPT_OBJECT_DEFINITION_STATEMENT, r, p, null);
    return r || p;
  }

  // [scriptObjectName]
  private static boolean scriptObjectDefinitionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinitionStatement_1")) return false;
    scriptObjectName(b, l + 1);
    return true;
  }

  // blockBody?
  private static boolean scriptObjectDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinitionStatement_3")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [script]
  private static boolean scriptObjectDefinitionStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinitionStatement_6")) return false;
    consumeToken(b, SCRIPT);
    return true;
  }

  /* ********************************************************** */
  // componentName
  static boolean scriptObjectName(PsiBuilder b, int l) {
    return componentName(b, l + 1);
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean script_object_variable(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // MINUTES_CONSTANT|HOURS_CONSTANT|DAYS_CONSTANT|WEEKS_CONSTANT
  static boolean seconds_constants(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "seconds_constants")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUTES_CONSTANT);
    if (!r) r = consumeToken(b, HOURS_CONSTANT);
    if (!r) r = consumeToken(b, DAYS_CONSTANT);
    if (!r) r = consumeToken(b, WEEKS_CONSTANT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NLS|COMMENT
  static boolean sep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep")) return false;
    if (!nextTokenIs(b, "", COMMENT, NLS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NLS);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdentifier
  static boolean sessionSpecificator(PsiBuilder b, int l) {
    return referenceIdentifier(b, l + 1);
  }

  /* ********************************************************** */
  // expression returning (targetCompositeComponent|referenceExpression)
  static boolean setCommandSyntaxReturning(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxReturning")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = expression(b, l + 1);
    r = r && consumeToken(b, RETURNING);
    p = r; // pin = 2
    r = r && setCommandSyntaxReturning_2(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // targetCompositeComponent|referenceExpression
  private static boolean setCommandSyntaxReturning_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxReturning_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetCompositeComponent(b, l + 1);
    if (!r) r = referenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // set (((targetCompositeComponent|expression) to expression)|expression)
  static boolean setCommandSyntaxSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxSet")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, SET);
    p = r; // pin = 1
    r = r && setCommandSyntaxSet_1(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // ((targetCompositeComponent|expression) to expression)|expression
  private static boolean setCommandSyntaxSet_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxSet_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setCommandSyntaxSet_1_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (targetCompositeComponent|expression) to expression
  private static boolean setCommandSyntaxSet_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxSet_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setCommandSyntaxSet_1_0_0(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // targetCompositeComponent|expression
  private static boolean setCommandSyntaxSet_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandSyntaxSet_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetCompositeComponent(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integerLiteralExpression
  static boolean startIndex(PsiBuilder b, int l) {
    return integerLiteralExpression(b, l + 1);
  }

  /* ********************************************************** */
  // integerLiteralExpression|referenceIdentifier|parenthesizedExpression
  static boolean startValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "startValue")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // control_statement|propertyDeclarationStatement|variableDeclarationStatement
  //                       |handlerLabeledParametersDefinition|handlerPositionalParametersDefinition
  // //                      |handlerRunDefinition|handlerOpenDefinition|handlerIdleDefinition|handlerQuitDefinition
  //                       |handlerInterleavedParametersDefinition
  //                       |scriptObjectDefinitionStatement
  //                       |returnStatement|continue_statement
  //                       |creationStatement
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = control_statement(b, l + 1);
    if (!r) r = propertyDeclarationStatement(b, l + 1);
    if (!r) r = variableDeclarationStatement(b, l + 1);
    if (!r) r = handlerLabeledParametersDefinition(b, l + 1);
    if (!r) r = handlerPositionalParametersDefinition(b, l + 1);
    if (!r) r = handlerInterleavedParametersDefinition(b, l + 1);
    if (!r) r = scriptObjectDefinitionStatement(b, l + 1);
    if (!r) r = returnStatement(b, l + 1);
    if (!r) r = continue_statement(b, l + 1);
    if (!r) r = creationStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integerLiteralExpression|referenceIdentifier|parenthesizedExpression
  static boolean stepValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stepValue")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // integerLiteralExpression
  static boolean stopIndex(PsiBuilder b, int l) {
    return integerLiteralExpression(b, l + 1);
  }

  /* ********************************************************** */
  // integerLiteralExpression|referenceIdentifier|parenthesizedExpression
  static boolean stopValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopValue")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = referenceIdentifier(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL (BAND ((CC sep)|CC)? primaryExpression)*
  public static boolean stringLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    r = r && stringLiteralExpression_1(b, l + 1);
    exit_section_(b, m, STRING_LITERAL_EXPRESSION, r);
    return r;
  }

  // (BAND ((CC sep)|CC)? primaryExpression)*
  private static boolean stringLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!stringLiteralExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stringLiteralExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // BAND ((CC sep)|CC)? primaryExpression
  private static boolean stringLiteralExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAND);
    r = r && stringLiteralExpression_1_0_1(b, l + 1);
    r = r && primaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((CC sep)|CC)?
  private static boolean stringLiteralExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression_1_0_1")) return false;
    stringLiteralExpression_1_0_1_0(b, l + 1);
    return true;
  }

  // (CC sep)|CC
  private static boolean stringLiteralExpression_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringLiteralExpression_1_0_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, CC);
    exit_section_(b, m, null, r);
    return r;
  }

  // CC sep
  private static boolean stringLiteralExpression_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CC);
    r = r && sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean styledTextLiteralExpression(PsiBuilder b, int l) {
    return consumeToken(b, STRING_LITERAL);
  }

  /* ********************************************************** */
  // componentName
  public static boolean targetComponentName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetComponentName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<target component name>");
    r = componentName(b, l + 1);
    exit_section_(b, l, m, TARGET_COMPONENT_NAME, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // targetComponentName|targetListLiteral|targetRecordLiteral
  static boolean targetCompositeComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetCompositeComponent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetComponentName(b, l + 1);
    if (!r) r = targetListLiteral(b, l + 1);
    if (!r) r = targetRecordLiteral(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY [targetCompositeComponent] (COMMA targetCompositeComponent)* RCURLY
  public static boolean targetListLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && targetListLiteral_1(b, l + 1);
    r = r && targetListLiteral_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, TARGET_LIST_LITERAL, r);
    return r;
  }

  // [targetCompositeComponent]
  private static boolean targetListLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_1")) return false;
    targetCompositeComponent(b, l + 1);
    return true;
  }

  // (COMMA targetCompositeComponent)*
  private static boolean targetListLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!targetListLiteral_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "targetListLiteral_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA targetCompositeComponent
  private static boolean targetListLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && targetCompositeComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY[propertyLabelComponent COLON targetCompositeComponent] (COMMA propertyLabelComponent COLON targetCompositeComponent)* RCURLY
  public static boolean targetRecordLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && targetRecordLiteral_1(b, l + 1);
    r = r && targetRecordLiteral_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, TARGET_RECORD_LITERAL, r);
    return r;
  }

  // [propertyLabelComponent COLON targetCompositeComponent]
  private static boolean targetRecordLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_1")) return false;
    targetRecordLiteral_1_0(b, l + 1);
    return true;
  }

  // propertyLabelComponent COLON targetCompositeComponent
  private static boolean targetRecordLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = propertyLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && targetCompositeComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA propertyLabelComponent COLON targetCompositeComponent)*
  private static boolean targetRecordLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!targetRecordLiteral_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "targetRecordLiteral_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA propertyLabelComponent COLON targetCompositeComponent
  private static boolean targetRecordLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && propertyLabelComponent(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && targetCompositeComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tell objectRefWrapper nls //todo not to count Ø -| and CRLF char as a sep
  //                                         blockBody? nls
  //                             end !(considering|ignoring|error|try|repeat|(using terms from))[tell]
  public static boolean tell_compound_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, TELL);
    r = r && objectRefWrapper(b, l + 1);
    r = r && nls(b, l + 1);
    r = r && tell_compound_statement_3(b, l + 1);
    p = r; // pin = 4
    r = r && report_error_(b, nls(b, l + 1));
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && tell_compound_statement_6(b, l + 1);
    r = r && tell_compound_statement_7(b, l + 1);
    exit_section_(b, l, m, TELL_COMPOUND_STATEMENT, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean tell_compound_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement_3")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|error|try|repeat|(using terms from))
  private static boolean tell_compound_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !tell_compound_statement_6_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|error|try|repeat|(using terms from)
  private static boolean tell_compound_statement_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = tell_compound_statement_6_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean tell_compound_statement_6_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement_6_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tell]
  private static boolean tell_compound_statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_compound_statement_7")) return false;
    consumeToken(b, TELL);
    return true;
  }

  /* ********************************************************** */
  // tell (/*handlerCallGuardPredicate|*/objectRefWrapper)
  // to (statement|(expression handlerInterleavedParametersCall))
  public static boolean tell_simple_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_simple_statement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, TELL);
    r = r && tell_simple_statement_1(b, l + 1);
    r = r && consumeToken(b, TO);
    p = r; // pin = 3
    r = r && tell_simple_statement_3(b, l + 1);
    exit_section_(b, l, m, TELL_SIMPLE_STATEMENT, r, p, null);
    return r || p;
  }

  // (/*handlerCallGuardPredicate|*/objectRefWrapper)
  private static boolean tell_simple_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_simple_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectRefWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement|(expression handlerInterleavedParametersCall)
  private static boolean tell_simple_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_simple_statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = tell_simple_statement_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression handlerInterleavedParametersCall
  private static boolean tell_simple_statement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_simple_statement_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && handlerInterleavedParametersCall(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tell_simple_statement|tell_compound_statement
  static boolean tell_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tell_statement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tell_simple_statement(b, l + 1);
    if (!r) r = tell_compound_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'text item delimiters'
  public static boolean textItemDelimitersProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "textItemDelimitersProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<text item delimiters property>");
    r = consumeToken(b, "text item delimiters");
    exit_section_(b, l, m, TEXT_ITEM_DELIMITERS_PROPERTY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // return|space|tab|linefeed|quote
  static boolean text_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_constant")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, SPACE);
    if (!r) r = consumeToken(b, TAB);
    if (!r) r = consumeToken(b, LINEFEED);
    if (!r) r = consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // try nls
  //                      blockBody? nls
  //                      on error [errorMessageVar] [number errorNumberVar] [from offendingObjectVar]
  //                      [to expectedTypeVar] [partial result resultListVar]
  //                      [global componentName (COMMA componentName)* nls]
  //                      [local componentName (COMMA componentName)* nls] nls
  //                      blockBody? nls
  //                   end !(considering|ignoring|tell|repeat|(using terms from))[error|try]
  public static boolean tryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, TRY);
    p = r; // pin = 1
    r = r && report_error_(b, nls(b, l + 1));
    r = p && report_error_(b, tryStatement_2(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, ON, ERROR)) && r;
    r = p && report_error_(b, tryStatement_6(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_7(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_8(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_9(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_10(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_11(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_12(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_14(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && tryStatement_17(b, l + 1);
    r = r && tryStatement_18(b, l + 1);
    exit_section_(b, l, m, TRY_STATEMENT, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean tryStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [errorMessageVar]
  private static boolean tryStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_6")) return false;
    errorMessageVar(b, l + 1);
    return true;
  }

  // [number errorNumberVar]
  private static boolean tryStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_7")) return false;
    tryStatement_7_0(b, l + 1);
    return true;
  }

  // number errorNumberVar
  private static boolean tryStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && errorNumberVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [from offendingObjectVar]
  private static boolean tryStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_8")) return false;
    tryStatement_8_0(b, l + 1);
    return true;
  }

  // from offendingObjectVar
  private static boolean tryStatement_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && offendingObjectVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [to expectedTypeVar]
  private static boolean tryStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_9")) return false;
    tryStatement_9_0(b, l + 1);
    return true;
  }

  // to expectedTypeVar
  private static boolean tryStatement_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    r = r && expectedTypeVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [partial result resultListVar]
  private static boolean tryStatement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_10")) return false;
    tryStatement_10_0(b, l + 1);
    return true;
  }

  // partial result resultListVar
  private static boolean tryStatement_10_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_10_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARTIAL, RESULT);
    r = r && resultListVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [global componentName (COMMA componentName)* nls]
  private static boolean tryStatement_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_11")) return false;
    tryStatement_11_0(b, l + 1);
    return true;
  }

  // global componentName (COMMA componentName)* nls
  private static boolean tryStatement_11_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_11_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    r = r && componentName(b, l + 1);
    r = r && tryStatement_11_0_2(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean tryStatement_11_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_11_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tryStatement_11_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tryStatement_11_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean tryStatement_11_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_11_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [local componentName (COMMA componentName)* nls]
  private static boolean tryStatement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_12")) return false;
    tryStatement_12_0(b, l + 1);
    return true;
  }

  // local componentName (COMMA componentName)* nls
  private static boolean tryStatement_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_12_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && componentName(b, l + 1);
    r = r && tryStatement_12_0_2(b, l + 1);
    r = r && nls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA componentName)*
  private static boolean tryStatement_12_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_12_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tryStatement_12_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tryStatement_12_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA componentName
  private static boolean tryStatement_12_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_12_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean tryStatement_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_14")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|tell|repeat|(using terms from))
  private static boolean tryStatement_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_17")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !tryStatement_17_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|tell|repeat|(using terms from)
  private static boolean tryStatement_17_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_17_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = tryStatement_17_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean tryStatement_17_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_17_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [error|try]
  private static boolean tryStatement_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_18")) return false;
    tryStatement_18_0(b, l + 1);
    return true;
  }

  // error|try
  private static boolean tryStatement_18_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_18_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use 'AppleScript' [version stringLiteralExpression]
  public static boolean useAppleScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, USE);
    r = r && consumeToken(b, "AppleScript");
    p = r; // pin = 2
    r = r && useAppleScriptStatement_2(b, l + 1);
    exit_section_(b, l, m, USE_APPLE_SCRIPT_STATEMENT, r, p, null);
    return r || p;
  }

  // [version stringLiteralExpression]
  private static boolean useAppleScriptStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement_2")) return false;
    useAppleScriptStatement_2_0(b, l + 1);
    return true;
  }

  // version stringLiteralExpression
  private static boolean useAppleScriptStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION);
    r = r && stringLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use [referenceIdentifier COLON] (script|applicationClass) dataSpecifier
  //                                        [version stringLiteralExpression ]
  //                                        [((with importing)|(without importing)|importing) expression ]
  public static boolean useApplicationOrScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, USE);
    r = r && useApplicationOrScriptStatement_1(b, l + 1);
    r = r && useApplicationOrScriptStatement_2(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, dataSpecifier(b, l + 1));
    r = p && report_error_(b, useApplicationOrScriptStatement_4(b, l + 1)) && r;
    r = p && useApplicationOrScriptStatement_5(b, l + 1) && r;
    exit_section_(b, l, m, USE_APPLICATION_OR_SCRIPT_STATEMENT, r, p, null);
    return r || p;
  }

  // [referenceIdentifier COLON]
  private static boolean useApplicationOrScriptStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_1")) return false;
    useApplicationOrScriptStatement_1_0(b, l + 1);
    return true;
  }

  // referenceIdentifier COLON
  private static boolean useApplicationOrScriptStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceIdentifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // script|applicationClass
  private static boolean useApplicationOrScriptStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    if (!r) r = applicationClass(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [version stringLiteralExpression ]
  private static boolean useApplicationOrScriptStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_4")) return false;
    useApplicationOrScriptStatement_4_0(b, l + 1);
    return true;
  }

  // version stringLiteralExpression
  private static boolean useApplicationOrScriptStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION);
    r = r && stringLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [((with importing)|(without importing)|importing) expression ]
  private static boolean useApplicationOrScriptStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_5")) return false;
    useApplicationOrScriptStatement_5_0(b, l + 1);
    return true;
  }

  // ((with importing)|(without importing)|importing) expression
  private static boolean useApplicationOrScriptStatement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useApplicationOrScriptStatement_5_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (with importing)|(without importing)|importing
  private static boolean useApplicationOrScriptStatement_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useApplicationOrScriptStatement_5_0_0_0(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement_5_0_0_1(b, l + 1);
    if (!r) r = consumeToken(b, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // with importing
  private static boolean useApplicationOrScriptStatement_5_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_5_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITH, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // without importing
  private static boolean useApplicationOrScriptStatement_5_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_5_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITHOUT, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use  framework  dataSpecifier
  public static boolean useFrameworkStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useFrameworkStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, USE, FRAMEWORK);
    p = r; // pin = 2
    r = r && dataSpecifier(b, l + 1);
    exit_section_(b, l, m, USE_FRAMEWORK_STATEMENT, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // use 'scripting additions'
  //                                    [((with importing)|(without importing)|importing) expression ]
  public static boolean useScriptingAdditionsStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, USE);
    r = r && consumeToken(b, "scripting additions");
    p = r; // pin = 2
    r = r && useScriptingAdditionsStatement_2(b, l + 1);
    exit_section_(b, l, m, USE_SCRIPTING_ADDITIONS_STATEMENT, r, p, null);
    return r || p;
  }

  // [((with importing)|(without importing)|importing) expression ]
  private static boolean useScriptingAdditionsStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement_2")) return false;
    useScriptingAdditionsStatement_2_0(b, l + 1);
    return true;
  }

  // ((with importing)|(without importing)|importing) expression
  private static boolean useScriptingAdditionsStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useScriptingAdditionsStatement_2_0_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (with importing)|(without importing)|importing
  private static boolean useScriptingAdditionsStatement_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useScriptingAdditionsStatement_2_0_0_0(b, l + 1);
    if (!r) r = useScriptingAdditionsStatement_2_0_0_1(b, l + 1);
    if (!r) r = consumeToken(b, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // with importing
  private static boolean useScriptingAdditionsStatement_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITH, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // without importing
  private static boolean useScriptingAdditionsStatement_2_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement_2_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITHOUT, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // useAppleScriptStatement|useScriptingAdditionsStatement|useApplicationOrScriptStatement
  // |useFrameworkStatement|usingTermsFromStatement
  static boolean useStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useStatement")) return false;
    if (!nextTokenIs(b, "", USE, USING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useAppleScriptStatement(b, l + 1);
    if (!r) r = useScriptingAdditionsStatement(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement(b, l + 1);
    if (!r) r = useFrameworkStatement(b, l + 1);
    if (!r) r = usingTermsFromStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THE_KW?componentName
  static boolean userLabelComponent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userLabelComponent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userLabelComponent_0(b, l + 1);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean userLabelComponent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userLabelComponent_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // THE_KW?referenceIdentifier
  static boolean userLabelReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userLabelReference")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userLabelReference_0(b, l + 1);
    r = r && referenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean userLabelReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userLabelReference_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // expression
  public static boolean userParameterVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<user parameter val>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, USER_PARAMETER_VAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // THE_KW?componentName
  static boolean userParameterVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userParameterVar_0(b, l + 1);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean userParameterVar_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVar_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // using terms from (application_reference|(script dataSpecifier)|(scripting additions)) nls
  //                                blockBody? nls
  //                             end !(considering|ignoring|error|try|repeat|tell|timeout)[using terms from]
  public static boolean usingTermsFromStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement")) return false;
    if (!nextTokenIs(b, USING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 3, USING, TERMS, FROM);
    p = r; // pin = 3
    r = r && report_error_(b, usingTermsFromStatement_3(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, usingTermsFromStatement_5(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && usingTermsFromStatement_8(b, l + 1);
    r = r && usingTermsFromStatement_9(b, l + 1);
    exit_section_(b, l, m, USING_TERMS_FROM_STATEMENT, r, p, null);
    return r || p;
  }

  // application_reference|(script dataSpecifier)|(scripting additions)
  private static boolean usingTermsFromStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = application_reference(b, l + 1);
    if (!r) r = usingTermsFromStatement_3_1(b, l + 1);
    if (!r) r = usingTermsFromStatement_3_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // script dataSpecifier
  private static boolean usingTermsFromStatement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    r = r && dataSpecifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // scripting additions
  private static boolean usingTermsFromStatement_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCRIPTING, ADDITIONS);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean usingTermsFromStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|error|try|repeat|tell|timeout)
  private static boolean usingTermsFromStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_8")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !usingTermsFromStatement_8_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|error|try|repeat|tell|timeout
  private static boolean usingTermsFromStatement_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, TIMEOUT);
    exit_section_(b, m, null, r);
    return r;
  }

  // [using terms from]
  private static boolean usingTermsFromStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_9")) return false;
    parseTokens(b, 0, USING, TERMS, FROM);
    return true;
  }

  /* ********************************************************** */
  // primaryExpression coercionExpression_2?
  static boolean valueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primaryExpression(b, l + 1);
    r = r && valueExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // coercionExpression_2?
  private static boolean valueExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueExpression_1")) return false;
    coercionExpression_2(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // variableGlobalDeclarationStatement|variableLocalDeclarationStatement
  public static boolean variableDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarationStatement")) return false;
    if (!nextTokenIs(b, "<variable declaration statement>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable declaration statement>");
    r = variableGlobalDeclarationStatement(b, l + 1);
    if (!r) r = variableLocalDeclarationStatement(b, l + 1);
    exit_section_(b, l, m, VARIABLE_DECLARATION_STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // global propertyLabelComponent
  static boolean variableGlobalDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableGlobalDeclarationStatement")) return false;
    if (!nextTokenIs(b, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    r = r && propertyLabelComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // local propertyLabelComponent
  static boolean variableLocalDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableLocalDeclarationStatement")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && propertyLabelComponent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // version
  static boolean versionProperty(PsiBuilder b, int l) {
    return consumeToken(b, VERSION);
  }

  /* ********************************************************** */
  // 'Monday'|'Tuesday'|'Wednesday'|'Thursday'|'Friday'|'Saturday'
  //                             |'Sunday'|'Mon'|'Tue'|'Wed'|'Thu'|'Fri'|'Sat'|'Sun'
  static boolean weekday_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "weekday_constant")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "Monday");
    if (!r) r = consumeToken(b, "Tuesday");
    if (!r) r = consumeToken(b, "Wednesday");
    if (!r) r = consumeToken(b, "Thursday");
    if (!r) r = consumeToken(b, "Friday");
    if (!r) r = consumeToken(b, "Saturday");
    if (!r) r = consumeToken(b, "Sunday");
    if (!r) r = consumeToken(b, "Mon");
    if (!r) r = consumeToken(b, "Tue");
    if (!r) r = consumeToken(b, "Wed");
    if (!r) r = consumeToken(b, "Thu");
    if (!r) r = consumeToken(b, "Fri");
    if (!r) r = consumeToken(b, "Sat");
    if (!r) r = consumeToken(b, "Sun");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // with timeout [of] integerLiteralExpression (seconds|second !(classTypeName)) nls //index ref
  //                            blockBody? nls
  //                          end !(considering|ignoring|error|try|repeat|tell|transaction|(using terms from))[timeout]
  public static boolean withTimeoutStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, WITH, TIMEOUT);
    p = r; // pin = 2
    r = r && report_error_(b, withTimeoutStatement_2(b, l + 1));
    r = p && report_error_(b, integerLiteralExpression(b, l + 1)) && r;
    r = p && report_error_(b, withTimeoutStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, withTimeoutStatement_6(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && withTimeoutStatement_9(b, l + 1);
    r = r && withTimeoutStatement_10(b, l + 1);
    exit_section_(b, l, m, WITH_TIMEOUT_STATEMENT, r, p, null);
    return r || p;
  }

  // [of]
  private static boolean withTimeoutStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_2")) return false;
    consumeToken(b, OF);
    return true;
  }

  // seconds|second !(classTypeName)
  private static boolean withTimeoutStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECONDS);
    if (!r) r = withTimeoutStatement_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // second !(classTypeName)
  private static boolean withTimeoutStatement_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECOND);
    r = r && withTimeoutStatement_4_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(classTypeName)
  private static boolean withTimeoutStatement_4_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_4_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !withTimeoutStatement_4_1_1_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (classTypeName)
  private static boolean withTimeoutStatement_4_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_4_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classTypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean withTimeoutStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|error|try|repeat|tell|transaction|(using terms from))
  private static boolean withTimeoutStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_9")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !withTimeoutStatement_9_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|error|try|repeat|tell|transaction|(using terms from)
  private static boolean withTimeoutStatement_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, TRANSACTION);
    if (!r) r = withTimeoutStatement_9_0_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean withTimeoutStatement_9_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_9_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [timeout]
  private static boolean withTimeoutStatement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_10")) return false;
    consumeToken(b, TIMEOUT);
    return true;
  }

  /* ********************************************************** */
  // with transaction [sessionSpecificator] nls
  //                                blockBody? nls
  //                              end !(considering|ignoring|error|try|repeat|tell|timeout|(using terms from)) [transaction]
  public static boolean withTransactionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 2, WITH, TRANSACTION);
    p = r; // pin = 2
    r = r && report_error_(b, withTransactionStatement_2(b, l + 1));
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, withTransactionStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, nls(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = r && withTransactionStatement_7(b, l + 1);
    r = r && withTransactionStatement_8(b, l + 1);
    exit_section_(b, l, m, WITH_TRANSACTION_STATEMENT, r, p, null);
    return r || p;
  }

  // [sessionSpecificator]
  private static boolean withTransactionStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_2")) return false;
    sessionSpecificator(b, l + 1);
    return true;
  }

  // blockBody?
  private static boolean withTransactionStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // !(considering|ignoring|error|try|repeat|tell|timeout|(using terms from))
  private static boolean withTransactionStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_7")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !withTransactionStatement_7_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // considering|ignoring|error|try|repeat|tell|timeout|(using terms from)
  private static boolean withTransactionStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDERING);
    if (!r) r = consumeToken(b, IGNORING);
    if (!r) r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, REPEAT);
    if (!r) r = consumeToken(b, TELL);
    if (!r) r = consumeToken(b, TIMEOUT);
    if (!r) r = withTransactionStatement_7_0_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // using terms from
  private static boolean withTransactionStatement_7_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_7_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    exit_section_(b, m, null, r);
    return r;
  }

  // [transaction]
  private static boolean withTransactionStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_8")) return false;
    consumeToken(b, TRANSACTION);
    return true;
  }

  final static Parser argument_list_part_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return argument_list_part_recover(b, l + 1);
    }
  };
  final static Parser argument_list_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return argument_list_recover(b, l + 1);
    }
  };
}
