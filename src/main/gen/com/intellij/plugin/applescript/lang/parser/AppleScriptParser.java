// This is a generated file. Not intended for manual editing.
package com.intellij.plugin.applescript.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;
import static com.intellij.plugin.applescript.lang.parser.AppleScriptGeneratedParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AppleScriptParser implements PsiParser, LightPsiParser {

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
    else if (t == ACTIVATE_COMMAND_EXPRESSION) {
      r = activateCommandExpression(b, 0);
    }
    else if (t == ADDITIVE_EXPRESSION) {
      r = additiveExpression(b, 0);
    }
    else if (t == APPLE_SCRIPT_PROPERTY) {
      r = appleScriptProperty(b, 0);
    }
    else if (t == APPLICATION_HANDLER_DEFINITION) {
      r = applicationHandlerDefinition(b, 0);
    }
    else if (t == APPLICATION_REFERENCE) {
      r = applicationReference(b, 0);
    }
    else if (t == ARBITRARY_REFERENCE) {
      r = arbitraryReference(b, 0);
    }
    else if (t == ARGUMENT_SELECTOR) {
      r = argumentSelector(b, 0);
    }
    else if (t == ASSIGNMENT_STATEMENT) {
      r = assignmentStatement(b, 0);
    }
    else if (t == BLOCK_BODY) {
      r = blockBody(b, 0);
    }
    else if (t == BUILT_IN_CLASS_IDENTIFIER) {
      r = builtInClassIdentifier(b, 0);
    }
    else if (t == BUILT_IN_CLASS_IDENTIFIER_PLURAL) {
      r = builtInClassIdentifierPlural(b, 0);
    }
    else if (t == BUILT_IN_CONSTANT_LITERAL_EXPRESSION) {
      r = builtInConstantLiteralExpression(b, 0);
    }
    else if (t == COERCION_EXPRESSION) {
      r = coercionExpression(b, 0);
    }
    else if (t == COMMAND_PARAMETER) {
      r = commandParameter(b, 0);
    }
    else if (t == COMMAND_PARAMETER_SELECTOR) {
      r = commandParameterSelector(b, 0);
    }
    else if (t == COMPARE_EXPRESSION) {
      r = compareExpression(b, 0);
    }
    else if (t == CONCATENATION_EXPRESSION) {
      r = concatenationExpression(b, 0);
    }
    else if (t == CONSIDERING_STATEMENT) {
      r = consideringStatement(b, 0);
    }
    else if (t == CONTINUE_STATEMENT) {
      r = continue_statement(b, 0);
    }
    else if (t == COUNT_COMMAND_EXPRESSION) {
      r = countCommandExpression(b, 0);
    }
    else if (t == DATE_LITERAL_EXPRESSION) {
      r = dateLiteralExpression(b, 0);
    }
    else if (t == DICTIONARY_CLASS_IDENTIFIER_PLURAL) {
      r = dictionaryClassIdentifierPlural(b, 0);
    }
    else if (t == DICTIONARY_CLASS_NAME) {
      r = dictionaryClassName(b, 0);
    }
    else if (t == DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION) {
      r = dictionaryCommandHandlerCallExpression(b, 0);
    }
    else if (t == DICTIONARY_COMMAND_NAME) {
      r = dictionaryCommandName(b, 0);
    }
    else if (t == DICTIONARY_CONSTANT) {
      r = dictionaryConstant(b, 0);
    }
    else if (t == DICTIONARY_PROPERTY_NAME) {
      r = dictionaryPropertyName(b, 0);
    }
    else if (t == DIRECT_PARAMETER_DECLARATION) {
      r = directParameterDeclaration(b, 0);
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
    else if (t == EVERY_RANGE_REFERENCE) {
      r = everyRangeReference(b, 0);
    }
    else if (t == EXIT_STATEMENT) {
      r = exitStatement(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
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
    else if (t == GIVEN_RAW_PARAMETER_EXPRESSION) {
      r = givenRawParameterExpression(b, 0);
    }
    else if (t == HANDLER_ARGUMENT) {
      r = handlerArgument(b, 0);
    }
    else if (t == HANDLER_INTERLEAVED_PARAMETERS_CALL) {
      r = handlerInterleavedParametersCall(b, 0);
    }
    else if (t == HANDLER_INTERLEAVED_PARAMETERS_DEFINITION) {
      r = handlerInterleavedParametersDefinition(b, 0);
    }
    else if (t == HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART) {
      r = handlerInterleavedParametersSelectorPart(b, 0);
    }
    else if (t == HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION) {
      r = handlerLabeledParametersCallExpression(b, 0);
    }
    else if (t == HANDLER_LABELED_PARAMETERS_DEFINITION) {
      r = handlerLabeledParametersDefinition(b, 0);
    }
    else if (t == HANDLER_PARAMETER_LABEL) {
      r = handlerParameterLabel(b, 0);
    }
    else if (t == HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION) {
      r = handlerPositionalParametersCallExpression(b, 0);
    }
    else if (t == HANDLER_POSITIONAL_PARAMETERS_DEFINITION) {
      r = handlerPositionalParametersDefinition(b, 0);
    }
    else if (t == ID_REFERENCE) {
      r = idReference(b, 0);
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
    else if (t == INCOMPLETE_COMMAND_HANDLER_CALL) {
      r = incompleteCommandHandlerCall(b, 0);
    }
    else if (t == INCOMPLETE_EXPRESSION) {
      r = incompleteExpression(b, 0);
    }
    else if (t == INDEX_REFERENCE) {
      r = indexReference(b, 0);
    }
    else if (t == INDEX_REFERENCE_CLASS_FORM) {
      r = indexReferenceClassForm(b, 0);
    }
    else if (t == INTEGER_LITERAL_EXPRESSION) {
      r = integerLiteralExpression(b, 0);
    }
    else if (t == LABELED_PARAMETER_DECLARATION_LIST) {
      r = labeledParameterDeclarationList(b, 0);
    }
    else if (t == LABELED_PARAMETER_DECLARATION_PART) {
      r = labeledParameterDeclarationPart(b, 0);
    }
    else if (t == LAUNCH_COMMAND_EXPRESSION) {
      r = launchCommandExpression(b, 0);
    }
    else if (t == LIST_FORMAL_PARAMETER) {
      r = listFormalParameter(b, 0);
    }
    else if (t == LIST_LITERAL_EXPRESSION) {
      r = listLiteralExpression(b, 0);
    }
    else if (t == LOG_COMMAND_EXPRESSION) {
      r = logCommandExpression(b, 0);
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
    else if (t == NEGATION_EXPRESSION) {
      r = negationExpression(b, 0);
    }
    else if (t == NUMBER_LITERAL_EXPRESSION) {
      r = numberLiteralExpression(b, 0);
    }
    else if (t == NUMERIC_CONSTANT) {
      r = numericConstant(b, 0);
    }
    else if (t == OBJECT_NAMED_PROPERTY_DECLARATION) {
      r = objectNamedPropertyDeclaration(b, 0);
    }
    else if (t == OBJECT_PROPERTY_DECLARATION) {
      r = objectPropertyDeclaration(b, 0);
    }
    else if (t == OBJECT_REFERENCE_EXPRESSION) {
      r = objectReferenceExpression(b, 0);
    }
    else if (t == OBJECT_TARGET_PROPERTY_DECLARATION) {
      r = objectTargetPropertyDeclaration(b, 0);
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
    else if (t == PROPERTY_REFERENCE) {
      r = propertyReference(b, 0);
    }
    else if (t == RANGE_FROM_REFERENCE) {
      r = rangeFromReference(b, 0);
    }
    else if (t == RANGE_INDEX_REFERENCE) {
      r = rangeIndexReference(b, 0);
    }
    else if (t == RAW_CLASS_EXPRESSION) {
      r = rawClassExpression(b, 0);
    }
    else if (t == RAW_DATA_EXPRESSION) {
      r = rawDataExpression(b, 0);
    }
    else if (t == RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION) {
      r = rawDictionaryCommandHandlerCallExpression(b, 0);
    }
    else if (t == RAW_PARAMETER_EXPRESSION) {
      r = rawParameterExpression(b, 0);
    }
    else if (t == RAW_PARAMETER_SELECTOR) {
      r = rawParameterSelector(b, 0);
    }
    else if (t == REAL_LITERAL_EXPRESSION) {
      r = realLiteralExpression(b, 0);
    }
    else if (t == RECORD_FORMAL_PARAMETER) {
      r = recordFormalParameter(b, 0);
    }
    else if (t == RECORD_LITERAL_EXPRESSION) {
      r = recordLiteralExpression(b, 0);
    }
    else if (t == REFERENCE_EXPRESSION) {
      r = referenceExpression(b, 0);
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
    else if (t == SCRIPT_BODY) {
      r = scriptBody(b, 0);
    }
    else if (t == SCRIPT_OBJECT_DEFINITION) {
      r = scriptObjectDefinition(b, 0);
    }
    else if (t == SCRIPT_OBJECT_UNNAMED_DEFINITION) {
      r = scriptObjectUnnamedDefinition(b, 0);
    }
    else if (t == SCRIPT_PROPERTY_DECLARATION) {
      r = scriptPropertyDeclaration(b, 0);
    }
    else if (t == SELECTOR_ID) {
      r = selectorId(b, 0);
    }
    else if (t == SIMPLE_FORMAL_PARAMETER) {
      r = simpleFormalParameter(b, 0);
    }
    else if (t == STRING_LITERAL_EXPRESSION) {
      r = stringLiteralExpression(b, 0);
    }
    else if (t == TARGET_LIST_LITERAL) {
      r = targetListLiteral(b, 0);
    }
    else if (t == TARGET_RECORD_LITERAL) {
      r = targetRecordLiteral(b, 0);
    }
    else if (t == TARGET_VARIABLE) {
      r = targetVariable(b, 0);
    }
    else if (t == TELL_COMPOUND_STATEMENT) {
      r = tellCompoundStatement(b, 0);
    }
    else if (t == TELL_SIMPLE_STATEMENT) {
      r = tellSimpleStatement(b, 0);
    }
    else if (t == TEXT_ITEM_DELIMITERS_PROPERTY) {
      r = textItemDelimitersProperty(b, 0);
    }
    else if (t == TOP_BLOCK_BODY) {
      r = topBlockBody(b, 0);
    }
    else if (t == TRY_STATEMENT) {
      r = tryStatement(b, 0);
    }
    else if (t == USE_STATEMENT) {
      r = useStatement(b, 0);
    }
    else if (t == USER_CLASS_NAME) {
      r = userClassName(b, 0);
    }
    else if (t == USING_TERMS_FROM_STATEMENT) {
      r = usingTermsFromStatement(b, 0);
    }
    else if (t == VAR_ACCESS_DECLARATION) {
      r = varAccessDeclaration(b, 0);
    }
    else if (t == VAR_DECLARATION_LIST) {
      r = varDeclarationList(b, 0);
    }
    else if (t == VAR_DECLARATION_LIST_PART) {
      r = varDeclarationListPart(b, 0);
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
    create_token_set_(ACTIVATE_COMMAND_EXPRESSION, ADDITIVE_EXPRESSION, A_REFERENCE_TO_LITERAL_EXPRESSION, BUILT_IN_CONSTANT_LITERAL_EXPRESSION,
      COERCION_EXPRESSION, COMPARE_EXPRESSION, CONCATENATION_EXPRESSION, COUNT_COMMAND_EXPRESSION,
      DATE_LITERAL_EXPRESSION, DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION, ERROR_COMMAND_EXPRESSION, EXPRESSION,
      GET_COMMAND_EXPRESSION, GIVEN_RAW_PARAMETER_EXPRESSION, HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION, HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION,
      INCOMPLETE_EXPRESSION, INTEGER_LITERAL_EXPRESSION, LAUNCH_COMMAND_EXPRESSION, LIST_LITERAL_EXPRESSION,
      LOGICAL_AND_EXPRESSION, LOGICAL_OR_EXPRESSION, LOG_COMMAND_EXPRESSION, MULTIPLICATIVE_EXPRESSION,
      NEGATION_EXPRESSION, NUMBER_LITERAL_EXPRESSION, OBJECT_REFERENCE_EXPRESSION, PARENTHESIZED_EXPRESSION,
      POWER_EXPRESSION, RAW_CLASS_EXPRESSION, RAW_DATA_EXPRESSION, RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION,
      RAW_PARAMETER_EXPRESSION, REAL_LITERAL_EXPRESSION, RECORD_LITERAL_EXPRESSION, REFERENCE_EXPRESSION,
      RUN_COMMAND_EXPRESSION, STRING_LITERAL_EXPRESSION),
  };

  /* ********************************************************** */
  // CENTIMETRES|CENTIMETERS|FEET|INCHES|KILOMETRES|KILOMETERS|METRES|METERS|MILES|YARDS
  static boolean Length(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Length")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CENTIMETRES);
    if (!r) r = consumeToken(b, CENTIMETERS);
    if (!r) r = consumeToken(b, FEET);
    if (!r) r = consumeToken(b, INCHES);
    if (!r) r = consumeToken(b, KILOMETRES);
    if (!r) r = consumeToken(b, KILOMETERS);
    if (!r) r = consumeToken(b, METRES);
    if (!r) r = consumeToken(b, METERS);
    if (!r) r = consumeToken(b, MILES);
    if (!r) r = consumeToken(b, YARDS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GALLONS|LITRES|LITERS|QUARTS
  static boolean LiquidVolume(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiquidVolume")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GALLONS);
    if (!r) r = consumeToken(b, LITRES);
    if (!r) r = consumeToken(b, LITERS);
    if (!r) r = consumeToken(b, QUARTS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GRAMS|KILOGRAMS|OUNCES|POUNDS
  static boolean Weight(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Weight")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GRAMS);
    if (!r) r = consumeToken(b, KILOGRAMS);
    if (!r) r = consumeToken(b, OUNCES);
    if (!r) r = consumeToken(b, POUNDS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // REF_OP objectReferenceWrapper
  public static boolean aReferenceToLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aReferenceToLiteralExpression")) return false;
    if (!nextTokenIsFast(b, REF_OP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, REF_OP);
    r = r && objectReferenceWrapper(b, l + 1);
    exit_section_(b, m, A_REFERENCE_TO_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // activate expression?
  public static boolean activateCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "activateCommandExpression")) return false;
    if (!nextTokenIsFast(b, ACTIVATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, ACTIVATE);
    r = r && activateCommandExpression_1(b, l + 1);
    exit_section_(b, m, ACTIVATE_COMMAND_EXPRESSION, r);
    return r;
  }

  // expression?
  private static boolean activateCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "activateCommandExpression_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (PLUS|MINUS) multiplicativeExpressionWrapper
  public static boolean additiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression")) return false;
    if (!nextTokenIsFast(b, MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = additiveExpression_0(b, l + 1);
    r = r && multiplicativeExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PLUS|MINUS
  private static boolean additiveExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, PLUS);
    if (!r) r = consumeTokenFast(b, MINUS);
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
  // getCommandExpression|runCommandExpression|countCommandExpression|
  // errorCommandExpression|logCommandExpression|activateCommandExpression|launchCommandExpression
  static boolean appleScriptCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "appleScriptCommandExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = getCommandExpression(b, l + 1);
    if (!r) r = runCommandExpression(b, l + 1);
    if (!r) r = countCommandExpression(b, l + 1);
    if (!r) r = errorCommandExpression(b, l + 1);
    if (!r) r = logCommandExpression(b, l + 1);
    if (!r) r = activateCommandExpression(b, l + 1);
    if (!r) r = launchCommandExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // compilation_unit_*
  static boolean appleScriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "appleScriptFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!compilation_unit_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "appleScriptFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // BUILT_IN_PROPERTY|resultProperty|versionProperty|anythingProperty
  // |textItemDelimitersProperty|parentProperty
  public static boolean appleScriptProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "appleScriptProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLE_SCRIPT_PROPERTY, "<apple script property>");
    r = consumeToken(b, BUILT_IN_PROPERTY);
    if (!r) r = resultProperty(b, l + 1);
    if (!r) r = versionProperty(b, l + 1);
    if (!r) r = anythingProperty(b, l + 1);
    if (!r) r = textItemDelimitersProperty(b, l + 1);
    if (!r) r = parentProperty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean appleTalkZoneName(PsiBuilder b, int l) {
    return consumeToken(b, STRING_LITERAL);
  }

  /* ********************************************************** */
  // (on|to) applicationHandlerDefinitionSignature
  //                                          [given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*] //nls //should be sep here
  //                                          [varDeclarationList] sep
  //                                            blockBody?
  //                                   end [applicationHandlerDefinitionSignature]
  public static boolean applicationHandlerDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition")) return false;
    if (!nextTokenIs(b, "<application handler definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_HANDLER_DEFINITION, "<application handler definition>");
    r = applicationHandlerDefinition_0(b, l + 1);
    r = r && applicationHandlerDefinitionSignature(b, l + 1);
    r = r && applicationHandlerDefinition_2(b, l + 1);
    r = r && applicationHandlerDefinition_3(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && applicationHandlerDefinition_5(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && applicationHandlerDefinition_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // on|to
  private static boolean applicationHandlerDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // [given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*]
  private static boolean applicationHandlerDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2")) return false;
    applicationHandlerDefinition_2_0(b, l + 1);
    return true;
  }

  // given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*
  private static boolean applicationHandlerDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && applicationHandlerDefinition_2_0_1(b, l + 1);
    r = r && objectTargetPropertyDeclaration(b, l + 1);
    r = r && applicationHandlerDefinition_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationHandlerDefinition_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (COMMA THE_KW? objectTargetPropertyDeclaration)*
  private static boolean applicationHandlerDefinition_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2_0_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!applicationHandlerDefinition_2_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "applicationHandlerDefinition_2_0_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA THE_KW? objectTargetPropertyDeclaration
  private static boolean applicationHandlerDefinition_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && applicationHandlerDefinition_2_0_3_0_1(b, l + 1);
    r = r && objectTargetPropertyDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationHandlerDefinition_2_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_2_0_3_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // [varDeclarationList]
  private static boolean applicationHandlerDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_3")) return false;
    varDeclarationList(b, l + 1);
    return true;
  }

  // blockBody?
  private static boolean applicationHandlerDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [applicationHandlerDefinitionSignature]
  private static boolean applicationHandlerDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationHandlerDefinition_7")) return false;
    applicationHandlerDefinitionSignature(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parseApplicationHandlerDefinitionSignature>>
  static boolean applicationHandlerDefinitionSignature(PsiBuilder b, int l) {
    return parseApplicationHandlerDefinitionSignature(b, l + 1);
  }

  /* ********************************************************** */
  // <<parseApplicationName tellStatementStartCondition>>
  static boolean applicationName(PsiBuilder b, int l) {
    return parseApplicationName(b, l + 1, tellStatementStartCondition_parser_);
  }

  /* ********************************************************** */
  // applicationName [of THE_KW? machine machineName (of THE_KW? zone appleTalkZoneName)?] | THE_KW? currentApplicationConstant
  public static boolean applicationReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, APPLICATION_REFERENCE, "<application reference>");
    r = applicationReference_0(b, l + 1);
    if (!r) r = applicationReference_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // applicationName [of THE_KW? machine machineName (of THE_KW? zone appleTalkZoneName)?]
  private static boolean applicationReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationName(b, l + 1);
    r = r && applicationReference_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [of THE_KW? machine machineName (of THE_KW? zone appleTalkZoneName)?]
  private static boolean applicationReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1")) return false;
    applicationReference_0_1_0(b, l + 1);
    return true;
  }

  // of THE_KW? machine machineName (of THE_KW? zone appleTalkZoneName)?
  private static boolean applicationReference_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    r = r && applicationReference_0_1_0_1(b, l + 1);
    r = r && consumeToken(b, MACHINE);
    r = r && machineName(b, l + 1);
    r = r && applicationReference_0_1_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationReference_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (of THE_KW? zone appleTalkZoneName)?
  private static boolean applicationReference_0_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1_0_4")) return false;
    applicationReference_0_1_0_4_0(b, l + 1);
    return true;
  }

  // of THE_KW? zone appleTalkZoneName
  private static boolean applicationReference_0_1_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    r = r && applicationReference_0_1_0_4_0_1(b, l + 1);
    r = r && consumeToken(b, ZONE);
    r = r && appleTalkZoneName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationReference_0_1_0_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_0_1_0_4_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // THE_KW? currentApplicationConstant
  private static boolean applicationReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationReference_1_0(b, l + 1);
    r = r && currentApplicationConstant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean applicationReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "applicationReference_1_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // some typeSpecifier
  public static boolean arbitraryReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arbitraryReference")) return false;
    if (!nextTokenIs(b, SOME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARBITRARY_REFERENCE, null);
    r = consumeToken(b, SOME);
    p = r; // pin = 1
    r = r && typeSpecifier(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !(RPAREN|COMMA)
  static boolean argListPartRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argListPartRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !argListPartRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RPAREN|COMMA
  private static boolean argListPartRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argListPartRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, RPAREN);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(RPAREN)
  static boolean argListRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argListRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !argListRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (RPAREN)
  private static boolean argListRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argListRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // argumentListPart (COMMA argumentListPart)*
  static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = argumentListPart(b, l + 1);
    r = r && argumentList_1(b, l + 1);
    exit_section_(b, l, m, r, false, argListRecover_parser_);
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
  // statement | expression
  static boolean argumentListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentListPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, argListPartRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON
  public static boolean argumentSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentSelector")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, ARGUMENT_SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // setCommandAppleScript|copyCommandStatement
  public static boolean assignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_STATEMENT, "<assignment statement>");
    r = setCommandAppleScript(b, l + 1);
    if (!r) r = copyCommandStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // blockBodyPart sep ( blockBodyPart sep)*
  public static boolean blockBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_BODY, "<block body>");
    r = blockBodyPart(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && blockBody_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( blockBodyPart sep)*
  private static boolean blockBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!blockBody_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "blockBody_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // blockBodyPart sep
  private static boolean blockBody_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBody_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = blockBodyPart(b, l + 1);
    r = r && sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement|expression
  static boolean blockBodyPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBodyPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, bodyPartRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !(sep)
  static boolean bodyPartRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyPartRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !bodyPartRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (sep)
  private static boolean bodyPartRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bodyPartRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
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
  // STRING|CLASS|CONSTANT|LIST|DATA|REFERENCE|STYLED_TEXT|TEXT_ITEM|ITEM|FILE_SPECIFICATION|
  // INTERNATIONAL_TEXT|RGB_COLOR|STYLED_CLIPBOARD_TEXT|UNICODE_TEXT|unitTypeValueClasses|CHARACTER|PARAGRAPH|WORD
  static boolean builtInClassIdCommon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdCommon")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CLASS);
    if (!r) r = consumeToken(b, CONSTANT);
    if (!r) r = consumeToken(b, LIST);
    if (!r) r = consumeToken(b, DATA);
    if (!r) r = consumeToken(b, REFERENCE);
    if (!r) r = consumeToken(b, STYLED_TEXT);
    if (!r) r = consumeToken(b, TEXT_ITEM);
    if (!r) r = consumeToken(b, ITEM);
    if (!r) r = consumeToken(b, FILE_SPECIFICATION);
    if (!r) r = consumeToken(b, INTERNATIONAL_TEXT);
    if (!r) r = consumeToken(b, RGB_COLOR);
    if (!r) r = consumeToken(b, STYLED_CLIPBOARD_TEXT);
    if (!r) r = consumeToken(b, UNICODE_TEXT);
    if (!r) r = unitTypeValueClasses(b, l + 1);
    if (!r) r = consumeToken(b, CHARACTER);
    if (!r) r = consumeToken(b, PARAGRAPH);
    if (!r) r = consumeToken(b, WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANY|BOOLEAN|DATE|FILE|INTEGER|LOCATION_SPECIFIER|NUMBER|POINT|REAL|RECORD|RECTANGLE|SPECIFIER|TEXT|TYPE|ALIAS
  static boolean builtInClassIdNative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdNative")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = consumeToken(b, FILE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, LOCATION_SPECIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, POINT);
    if (!r) r = consumeToken(b, REAL);
    if (!r) r = consumeToken(b, RECORD);
    if (!r) r = consumeToken(b, RECTANGLE);
    if (!r) r = consumeToken(b, SPECIFIER);
    if (!r) r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, ALIAS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtInClassIdCommon|builtInClassIdNative|<<parseExpression '"script"' script>>
  // |<<parseExpression '"bundle"' bundle>>
  public static boolean builtInClassIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILT_IN_CLASS_IDENTIFIER, "<built in class identifier>");
    r = builtInClassIdCommon(b, l + 1);
    if (!r) r = builtInClassIdNative(b, l + 1);
    if (!r) r = parseExpression(b, l + 1, "script", SCRIPT_parser_);
    if (!r) r = parseExpression(b, l + 1, "bundle", BUNDLE_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BUILT_IN_TYPE_S|scripts
  public static boolean builtInClassIdentifierPlural(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassIdentifierPlural")) return false;
    if (!nextTokenIs(b, "<built in class identifier plural>", BUILT_IN_TYPE_S, SCRIPTS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILT_IN_CLASS_IDENTIFIER_PLURAL, "<built in class identifier plural>");
    r = consumeToken(b, BUILT_IN_TYPE_S);
    if (!r) r = consumeToken(b, SCRIPTS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // stringProperty | BUILT_IN_PROPERTY |
  // (&(builtInClassIdentifier of) builtInClassIdentifier)
  static boolean builtInClassProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassProperty")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringProperty(b, l + 1);
    if (!r) r = consumeToken(b, BUILT_IN_PROPERTY);
    if (!r) r = builtInClassProperty_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(builtInClassIdentifier of) builtInClassIdentifier
  private static boolean builtInClassProperty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassProperty_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassProperty_2_0(b, l + 1);
    r = r && builtInClassIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(builtInClassIdentifier of)
  private static boolean builtInClassProperty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassProperty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = builtInClassProperty_2_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // builtInClassIdentifier of
  private static boolean builtInClassProperty_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInClassProperty_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassIdentifier(b, l + 1);
    r = r && consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // boolean_constant|date_time_constants|text_constant|itMeProperty
  // |currentApplicationConstant| missing_value_constant | scriptingAdditionsFolderConstant
  public static boolean builtInConstantLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInConstantLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILT_IN_CONSTANT_LITERAL_EXPRESSION, "<built in constant literal expression>");
    r = boolean_constant(b, l + 1);
    if (!r) r = date_time_constants(b, l + 1);
    if (!r) r = text_constant(b, l + 1);
    if (!r) r = itMeProperty(b, l + 1);
    if (!r) r = currentApplicationConstant(b, l + 1);
    if (!r) r = missing_value_constant(b, l + 1);
    if (!r) r = scriptingAdditionsFolderConstant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // typeSpecifier
  static boolean classNamePrimaryExpression(PsiBuilder b, int l) {
    return typeSpecifier(b, l + 1);
  }

  /* ********************************************************** */
  // AS NLS* ( typeSpecifier | concatenationExpressionWrapper  )
  public static boolean coercionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpression")) return false;
    if (!nextTokenIsFast(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, COERCION_EXPRESSION, null);
    r = consumeTokenFast(b, AS);
    r = r && coercionExpression_1(b, l + 1);
    r = r && coercionExpression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NLS*
  private static boolean coercionExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "coercionExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // typeSpecifier | concatenationExpressionWrapper
  private static boolean coercionExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "coercionExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeSpecifier(b, l + 1);
    if (!r) r = concatenationExpressionWrapper(b, l + 1);
    exit_section_(b, m, null, r);
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
  // given? commandParameterSelector parameterValue
  public static boolean commandParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandParameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_PARAMETER, "<command parameter>");
    r = commandParameter_0(b, l + 1);
    r = r && commandParameterSelector(b, l + 1);
    r = r && parameterValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // given?
  private static boolean commandParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandParameter_0")) return false;
    consumeToken(b, GIVEN);
    return true;
  }

  /* ********************************************************** */
  // <<parseCommandParameterSelector>>
  public static boolean commandParameterSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandParameterSelector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND_PARAMETER_SELECTOR, "<command parameter selector>");
    r = parseCommandParameterSelector(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression? (rawParameterExpression | givenRawParameterExpression)*
  static boolean commandRawParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandRawParameters")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = commandRawParameters_0(b, l + 1);
    r = r && commandRawParameters_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean commandRawParameters_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandRawParameters_0")) return false;
    expression(b, l + 1);
    return true;
  }

  // (rawParameterExpression | givenRawParameterExpression)*
  private static boolean commandRawParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandRawParameters_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!commandRawParameters_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commandRawParameters_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // rawParameterExpression | givenRawParameterExpression
  private static boolean commandRawParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commandRawParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rawParameterExpression(b, l + 1);
    if (!r) r = givenRawParameterExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (equalityOperator|relational_operator) NLS* coercionExpressionWrapper
  public static boolean compareExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, COMPARE_EXPRESSION, "<compare expression>");
    r = compareExpression_0(b, l + 1);
    r = r && compareExpression_1(b, l + 1);
    r = r && coercionExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  // NLS*
  private static boolean compareExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "compareExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
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
  // topBlockBodyPart|sep
  static boolean compilation_unit_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilation_unit_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = topBlockBodyPart(b, l + 1);
    if (!r) r = sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean composite_value(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // BAND additiveExpressionWrapper
  public static boolean concatenationExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenationExpression")) return false;
    if (!nextTokenIsFast(b, BAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, CONCATENATION_EXPRESSION, null);
    r = consumeTokenFast(b, BAND);
    r = r && additiveExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // CONSIDER_IGNORE_ATTRIBUTE|C_WHITE_SPACE|expression
  static boolean considerOrIgnoreAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "considerOrIgnoreAttr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONSIDER_IGNORE_ATTRIBUTE);
    if (!r) r = consumeToken(b, C_WHITE_SPACE);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // considering considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  //                            [but ignoring considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)? ] sep
  //                            blockBody?
  //                          end considering
  public static boolean consideringStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement")) return false;
    if (!nextTokenIs(b, CONSIDERING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSIDERING_STATEMENT, null);
    r = consumeToken(b, CONSIDERING);
    r = r && considerOrIgnoreAttr(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consideringStatement_2(b, l + 1));
    r = p && report_error_(b, consideringStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, consideringStatement_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, CONSIDERING)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean consideringStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2")) return false;
    consideringStatement_2_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?
  private static boolean consideringStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consideringStatement_2_0_0(b, l + 1);
    r = r && consideringStatement_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttr)*
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

  // COMMA considerOrIgnoreAttr
  private static boolean consideringStatement_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttr)?
  private static boolean consideringStatement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_1")) return false;
    consideringStatement_2_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttr
  private static boolean consideringStatement_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [but ignoring considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)? ]
  private static boolean consideringStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3")) return false;
    consideringStatement_3_0(b, l + 1);
    return true;
  }

  // but ignoring considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean consideringStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUT, IGNORING);
    r = r && considerOrIgnoreAttr(b, l + 1);
    r = r && consideringStatement_3_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean consideringStatement_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3")) return false;
    consideringStatement_3_0_3_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?
  private static boolean consideringStatement_3_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consideringStatement_3_0_3_0_0(b, l + 1);
    r = r && consideringStatement_3_0_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttr)*
  private static boolean consideringStatement_3_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consideringStatement_3_0_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "consideringStatement_3_0_3_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttr
  private static boolean consideringStatement_3_0_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttr)?
  private static boolean consideringStatement_3_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3_0_1")) return false;
    consideringStatement_3_0_3_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttr
  private static boolean consideringStatement_3_0_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "consideringStatement_3_0_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttr(b, l + 1);
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
  // IS_CONTAIN|DOES_NOT_CONTAIN|IS_IN|IS_NOT_IN
  static boolean containment_any_part_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containment_any_part_operator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IS_CONTAIN);
    if (!r) r = consumeToken(b, DOES_NOT_CONTAIN);
    if (!r) r = consumeToken(b, IS_IN);
    if (!r) r = consumeToken(b, IS_NOT_IN);
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
  // ifStatement | tryStatement | tellStatement | <<parseExpression '"repeat"' repeatStatement>>
  // | exitStatement | consideringStatement | ignoringStatement | withTimeoutStatement | withTransactionStatement | <<parseUsingTermsFromStatement>>
  static boolean controlStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "controlStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifStatement(b, l + 1);
    if (!r) r = tryStatement(b, l + 1);
    if (!r) r = tellStatement(b, l + 1);
    if (!r) r = parseExpression(b, l + 1, "repeat", repeatStatement_parser_);
    if (!r) r = exitStatement(b, l + 1);
    if (!r) r = consideringStatement(b, l + 1);
    if (!r) r = ignoringStatement(b, l + 1);
    if (!r) r = withTimeoutStatement(b, l + 1);
    if (!r) r = withTransactionStatement(b, l + 1);
    if (!r) r = parseUsingTermsFromStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (copy|put) expression (to|into) (targetVariablePattern|objectReferenceWrapper)
  static boolean copyCommandStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement")) return false;
    if (!nextTokenIs(b, "", COPY, PUT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = copyCommandStatement_0(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && copyCommandStatement_2(b, l + 1);
    r = r && copyCommandStatement_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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

  // to|into
  private static boolean copyCommandStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    if (!r) r = consumeToken(b, INTO);
    exit_section_(b, m, null, r);
    return r;
  }

  // targetVariablePattern|objectReferenceWrapper
  private static boolean copyCommandStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "copyCommandStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetVariablePattern(b, l + 1);
    if (!r) r = objectReferenceWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (count [[each|every] typeSpecifier (in|of)] composite_value) | (number of [typeSpecifier (in|of)] composite_value)
  public static boolean countCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression")) return false;
    if (!nextTokenIsFast(b, COUNT, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COUNT_COMMAND_EXPRESSION, "<count command expression>");
    r = countCommandExpression_0(b, l + 1);
    if (!r) r = countCommandExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // count [[each|every] typeSpecifier (in|of)] composite_value
  private static boolean countCommandExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COUNT);
    r = r && countCommandExpression_0_1(b, l + 1);
    r = r && composite_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [[each|every] typeSpecifier (in|of)]
  private static boolean countCommandExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1")) return false;
    countCommandExpression_0_1_0(b, l + 1);
    return true;
  }

  // [each|every] typeSpecifier (in|of)
  private static boolean countCommandExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = countCommandExpression_0_1_0_0(b, l + 1);
    r = r && typeSpecifier(b, l + 1);
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
    r = consumeTokenFast(b, EACH);
    if (!r) r = consumeTokenFast(b, EVERY);
    exit_section_(b, m, null, r);
    return r;
  }

  // in|of
  private static boolean countCommandExpression_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_0_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, IN);
    if (!r) r = consumeTokenFast(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // number of [typeSpecifier (in|of)] composite_value
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

  // [typeSpecifier (in|of)]
  private static boolean countCommandExpression_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2")) return false;
    countCommandExpression_1_2_0(b, l + 1);
    return true;
  }

  // typeSpecifier (in|of)
  private static boolean countCommandExpression_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeSpecifier(b, l + 1);
    r = r && countCommandExpression_1_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // in|of
  private static boolean countCommandExpression_1_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "countCommandExpression_1_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, IN);
    if (!r) r = consumeTokenFast(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CURRENT_APPLICATION|CURRENT_APP|(CURRENT APPLICATION)
  static boolean currentApplicationConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "currentApplicationConstant")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURRENT_APPLICATION);
    if (!r) r = consumeToken(b, CURRENT_APP);
    if (!r) r = currentApplicationConstant_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CURRENT APPLICATION
  private static boolean currentApplicationConstant_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "currentApplicationConstant_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CURRENT, APPLICATION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean dataSpecifier(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // date (stringLiteralExpression|expression)
  public static boolean dateLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateLiteralExpression")) return false;
    if (!nextTokenIsFast(b, DATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, DATE);
    r = r && dateLiteralExpression_1(b, l + 1);
    exit_section_(b, m, DATE_LITERAL_EXPRESSION, r);
    return r;
  }

  // stringLiteralExpression|expression
  private static boolean dateLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dateLiteralExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringLiteralExpression(b, l + 1);
    if (!r) r = expression(b, l + 1);
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
  // <<parseDictionaryClassName 'true' useStatementsCondition>>
  public static boolean dictionaryClassIdentifierPlural(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryClassIdentifierPlural")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_CLASS_IDENTIFIER_PLURAL, "<dictionary class identifier plural>");
    r = parseDictionaryClassName(b, l + 1, true, useStatementsCondition_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<parseDictionaryClassName 'false' useStatementsCondition>>
  public static boolean dictionaryClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryClassName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_CLASS_NAME, "<dictionary class name>");
    r = parseDictionaryClassName(b, l + 1, false, useStatementsCondition_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<parseCommandHandlerCallExpression>>
  public static boolean dictionaryCommandHandlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCommandHandlerCallExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION, "<dictionary command handler call expression>");
    r = parseCommandHandlerCallExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<parseDictionaryCommandName>>
  public static boolean dictionaryCommandName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCommandName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_COMMAND_NAME, "<dictionary command name>");
    r = parseDictionaryCommandName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<parseDictionaryConstant>>
  public static boolean dictionaryConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_CONSTANT, "<dictionary constant>");
    r = parseDictionaryConstant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (<<parseDictionaryPropertyName>> &(of|in|COLON)) | (!dictionaryClassName <<parseDictionaryPropertyName>>)
  public static boolean dictionaryPropertyName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICTIONARY_PROPERTY_NAME, "<dictionary property name>");
    r = dictionaryPropertyName_0(b, l + 1);
    if (!r) r = dictionaryPropertyName_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // <<parseDictionaryPropertyName>> &(of|in|COLON)
  private static boolean dictionaryPropertyName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseDictionaryPropertyName(b, l + 1);
    r = r && dictionaryPropertyName_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(of|in|COLON)
  private static boolean dictionaryPropertyName_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = dictionaryPropertyName_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // of|in|COLON
  private static boolean dictionaryPropertyName_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // !dictionaryClassName <<parseDictionaryPropertyName>>
  private static boolean dictionaryPropertyName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dictionaryPropertyName_1_0(b, l + 1);
    r = r && parseDictionaryPropertyName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !dictionaryClassName
  private static boolean dictionaryPropertyName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryPropertyName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !dictionaryClassName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // THE_KW? identifier
  public static boolean directParameterDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterDeclaration")) return false;
    if (!nextTokenIs(b, "<direct parameter declaration>", THE_KW, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECT_PARAMETER_DECLARATION, "<direct parameter declaration>");
    r = directParameterDeclaration_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // THE_KW?
  private static boolean directParameterDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterDeclaration_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // referenceIdBeforeParamLabel | expression
  public static boolean directParameterVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directParameterVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECT_PARAMETER_VAL, "<direct parameter val>");
    r = referenceIdBeforeParamLabel(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  //                                  [from offendingObject]
  //                                  [to expectedType]
  //                                  [partial result resultList]
  public static boolean errorCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorCommandExpression")) return false;
    if (!nextTokenIsFast(b, ERROR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, ERROR);
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
    r = consumeTokenFast(b, NUMBER);
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
    r = consumeTokenFast(b, FROM);
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
    r = consumeTokenFast(b, TO);
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
  // expression
  static boolean errorMessage(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // directParameterDeclaration|expression
  static boolean errorMessageVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorMessageVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean errorNumber(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // directParameterDeclaration|expression
  static boolean errorNumberVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorNumberVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // every typeSpecifier | pluralClassName
  public static boolean everyElemReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyElemReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EVERY_ELEM_REFERENCE, "<every elem reference>");
    r = everyElemReference_0(b, l + 1);
    if (!r) r = pluralClassName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // every typeSpecifier
  private static boolean everyElemReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyElemReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVERY);
    r = r && typeSpecifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // every (singularClassName|userClassName) from (beginning|expression) to (end|expression)
  public static boolean everyRangeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyRangeReference")) return false;
    if (!nextTokenIs(b, EVERY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EVERY);
    r = r && everyRangeReference_1(b, l + 1);
    r = r && consumeToken(b, FROM);
    r = r && everyRangeReference_3(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && everyRangeReference_5(b, l + 1);
    exit_section_(b, m, EVERY_RANGE_REFERENCE, r);
    return r;
  }

  // singularClassName|userClassName
  private static boolean everyRangeReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyRangeReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singularClassName(b, l + 1);
    if (!r) r = userClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // beginning|expression
  private static boolean everyRangeReference_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyRangeReference_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGINNING);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // end|expression
  private static boolean everyRangeReference_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "everyRangeReference_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, END);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // exit [REPEAT]
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

  // [REPEAT]
  private static boolean exitStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exitStatement_1")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // expression
  static boolean expectedType(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // directParameterDeclaration|expression
  static boolean expectedTypeVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expectedTypeVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logicalOrExpressionWrapper
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = logicalOrExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement | expression
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
  // (whose|where) expression
  public static boolean filterReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filterReference")) return false;
    if (!nextTokenIs(b, "<filter reference>", WHERE, WHOSE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, FILTER_REFERENCE, "<filter reference>");
    r = filterReference_0(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
    Marker m = enter_section_(b, l, _NONE_, FORMAL_PARAMETER_LIST, "<formal parameter list>");
    r = formalParameterListPart(b, l + 1);
    r = r && formalParameterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // formalParameterListPartPattern
  static boolean formalParameterListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterListPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = formalParameterListPartPattern(b, l + 1);
    exit_section_(b, l, m, r, false, argListPartRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // simpleFormalParameter|listFormalParameter|recordFormalParameter|expression
  static boolean formalParameterListPartPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterListPartPattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleFormalParameter(b, l + 1);
    if (!r) r = listFormalParameter(b, l + 1);
    if (!r) r = recordFormalParameter(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // get <<parseCommandParametersExpression>>
  public static boolean getCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getCommandExpression")) return false;
    if (!nextTokenIsFast(b, GET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, GET);
    r = r && parseCommandParametersExpression(b, l + 1);
    exit_section_(b, m, GET_COMMAND_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // given rawClassExpression COLON expression (COMMA rawClassExpression COLON expression)*
  public static boolean givenRawParameterExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "givenRawParameterExpression")) return false;
    if (!nextTokenIsFast(b, GIVEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, GIVEN);
    r = r && rawClassExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    r = r && givenRawParameterExpression_4(b, l + 1);
    exit_section_(b, m, GIVEN_RAW_PARAMETER_EXPRESSION, r);
    return r;
  }

  // (COMMA rawClassExpression COLON expression)*
  private static boolean givenRawParameterExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "givenRawParameterExpression_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!givenRawParameterExpression_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "givenRawParameterExpression_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA rawClassExpression COLON expression
  private static boolean givenRawParameterExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "givenRawParameterExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && rawClassExpression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // argumentSelector userParameterVal
  public static boolean handlerArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerArgument")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argumentSelector(b, l + 1);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, HANDLER_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // handlerInterleavedParametersCall |
  // propertyReference | (referenceExpression handlerPositionalParametersCallExpression?)
  static boolean handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerInterleavedParametersCall(b, l + 1);
    if (!r) r = propertyReference(b, l + 1);
    if (!r) r = handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression handlerPositionalParametersCallExpression?
  private static boolean handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerPositionalParametersCallExpression?
  private static boolean handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier_2_1")) return false;
    handlerPositionalParametersCallExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // handlerArgument+
  public static boolean handlerInterleavedParametersCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersCall")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerArgument(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerArgument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersCall", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, HANDLER_INTERLEAVED_PARAMETERS_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // (on|to) handlerInterleavedParametersSelectorPart+ sep
  //                                                blockBody?
  //                                              end [handlerNamePartRef COLON (handlerNamePartRef COLON)*]
  public static boolean handlerInterleavedParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler interleaved parameters definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HANDLER_INTERLEAVED_PARAMETERS_DEFINITION, "<handler interleaved parameters definition>");
    r = handlerInterleavedParametersDefinition_0(b, l + 1);
    r = r && handlerInterleavedParametersDefinition_1(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && handlerInterleavedParametersDefinition_3(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && handlerInterleavedParametersDefinition_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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

  // handlerInterleavedParametersSelectorPart+
  private static boolean handlerInterleavedParametersDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerInterleavedParametersSelectorPart(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerInterleavedParametersSelectorPart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersDefinition_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean handlerInterleavedParametersDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_3")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [handlerNamePartRef COLON (handlerNamePartRef COLON)*]
  private static boolean handlerInterleavedParametersDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_5")) return false;
    handlerInterleavedParametersDefinition_5_0(b, l + 1);
    return true;
  }

  // handlerNamePartRef COLON (handlerNamePartRef COLON)*
  private static boolean handlerInterleavedParametersDefinition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartRef(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && handlerInterleavedParametersDefinition_5_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerNamePartRef COLON)*
  private static boolean handlerInterleavedParametersDefinition_5_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_5_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerInterleavedParametersDefinition_5_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerInterleavedParametersDefinition_5_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // handlerNamePartRef COLON
  private static boolean handlerInterleavedParametersDefinition_5_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersDefinition_5_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerNamePartRef(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // selectorId COLON userParameterVar
  public static boolean handlerInterleavedParametersSelectorPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerInterleavedParametersSelectorPart")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selectorId(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVar(b, l + 1);
    exit_section_(b, m, HANDLER_INTERLEAVED_PARAMETERS_SELECTOR_PART, r);
    return r;
  }

  /* ********************************************************** */
  // (
  //    (of|in) directParameterVal// on|of is mandatory if parsing user handler call
  //    (
  //      (    (handlerParameterLabel parameterVal)+
  //            ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //            )*
  //      )
  //      |
  //        ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )+
  //    )
  //    )|
  //    (
  //    (handlerParameterLabel parameterVal)+ //&(with|without|given)
  //        ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )*
  //    )
  public static boolean handlerLabeledParametersCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, HANDLER_LABELED_PARAMETERS_CALL_EXPRESSION, "<handler labeled parameters call expression>");
    r = handlerLabeledParametersCallExpression_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (of|in) directParameterVal// on|of is mandatory if parsing user handler call
  //    (
  //      (    (handlerParameterLabel parameterVal)+
  //            ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //            )*
  //      )
  //      |
  //        ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )+
  //    )
  private static boolean handlerLabeledParametersCallExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_0(b, l + 1);
    r = r && directParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // of|in
  private static boolean handlerLabeledParametersCallExpression_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, OF);
    if (!r) r = consumeTokenFast(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (    (handlerParameterLabel parameterVal)+
  //            ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //            )*
  //      )
  //      |
  //        ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )+
  private static boolean handlerLabeledParametersCallExpression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  //            ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //            )*
  private static boolean handlerLabeledParametersCallExpression_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0_0(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  private static boolean handlerLabeledParametersCallExpression_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCallExpression_0_2_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_0_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerParameterLabel parameterVal
  private static boolean handlerLabeledParametersCallExpression_0_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && parameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //            )*
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //            | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //            | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0_1_0_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_0_2_0_1_0_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_0_2_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1_0_0_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_0_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_3")) return false;
    handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1_0_1_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1_0_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_0_1_0_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_3")) return false;
    handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_0_1_0_2_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_2_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_0_1_0_2_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_0_1_0_2_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCallExpression_0_2_0_1_0_2_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_0_1_0_2_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )+
  private static boolean handlerLabeledParametersCallExpression_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCallExpression_0_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_1_0_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_0_2_1_0_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_0_2_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_1_0_0_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_1_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_1_0_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0_3")) return false;
    handlerLabeledParametersCallExpression_0_2_1_0_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_1_0_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_1_0_1_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_1_0_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_1_0_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_1_0_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1_3")) return false;
    handlerLabeledParametersCallExpression_0_2_1_0_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_0_2_1_0_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_0_2_1_0_2_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_2_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_0_2_1_0_2_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_0_2_1_0_2_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCallExpression_0_2_1_0_2_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_0_2_1_0_2_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+ //&(with|without|given)
  //        ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )*
  private static boolean handlerLabeledParametersCallExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_1_0(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (handlerParameterLabel parameterVal)+
  private static boolean handlerLabeledParametersCallExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_1_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!handlerLabeledParametersCallExpression_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_1_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerParameterLabel parameterVal
  private static boolean handlerLabeledParametersCallExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerParameterLabel(b, l + 1);
    r = r && parameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  //        )*
  private static boolean handlerLabeledParametersCallExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam])
  //        | (without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam])
  //        | (given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*)
  private static boolean handlerLabeledParametersCallExpression_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_1_1_0_0(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_1_1_0_1(b, l + 1);
    if (!r) r = handlerLabeledParametersCallExpression_1_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with labelForTrueParam (COMMA labelForTrueParam)* [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITH);
    r = r && labelForTrueParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1_0_0_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForTrueParam)*
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_1_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_1_1_0_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForTrueParam]
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0_3")) return false;
    handlerLabeledParametersCallExpression_1_1_0_0_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForTrueParam
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_1_1_0_0_3_0_0(b, l + 1);
    r = r && labelForTrueParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_1_1_0_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // without labelForFalseParam (COMMA labelForFalseParam)* [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WITHOUT);
    r = r && labelForFalseParam(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1_0_1_2(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1_0_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA labelForFalseParam)*
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_1_1_0_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_1_1_0_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(LAND|LOR|COMMA) labelForFalseParam]
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1_3")) return false;
    handlerLabeledParametersCallExpression_1_1_0_1_3_0(b, l + 1);
    return true;
  }

  // (LAND|LOR|COMMA) labelForFalseParam
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersCallExpression_1_1_0_1_3_0_0(b, l + 1);
    r = r && labelForFalseParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LAND|LOR|COMMA
  private static boolean handlerLabeledParametersCallExpression_1_1_0_1_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_1_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAND);
    if (!r) r = consumeTokenFast(b, LOR);
    if (!r) r = consumeTokenFast(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // given userLabelReference COLON userParameterVal (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_1_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, GIVEN);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    r = r && handlerLabeledParametersCallExpression_1_1_0_2_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA userLabelReference COLON userParameterVal)*
  private static boolean handlerLabeledParametersCallExpression_1_1_0_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_2_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersCallExpression_1_1_0_2_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersCallExpression_1_1_0_2_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA userLabelReference COLON userParameterVal
  private static boolean handlerLabeledParametersCallExpression_1_1_0_2_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersCallExpression_1_1_0_2_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && userLabelReference(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && userParameterVal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (on|to) identifier !LPAREN labeledParameterDeclarationList
  //                                          [given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*]
  //                                          [varDeclarationList] sep
  //                                            blockBody?
  //                                         end [referenceExpression]
  public static boolean handlerLabeledParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler labeled parameters definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HANDLER_LABELED_PARAMETERS_DEFINITION, "<handler labeled parameters definition>");
    r = handlerLabeledParametersDefinition_0(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && handlerLabeledParametersDefinition_2(b, l + 1);
    r = r && labeledParameterDeclarationList(b, l + 1);
    r = r && handlerLabeledParametersDefinition_4(b, l + 1);
    r = r && handlerLabeledParametersDefinition_5(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && handlerLabeledParametersDefinition_7(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && handlerLabeledParametersDefinition_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, LPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*]
  private static boolean handlerLabeledParametersDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4")) return false;
    handlerLabeledParametersDefinition_4_0(b, l + 1);
    return true;
  }

  // given THE_KW? objectTargetPropertyDeclaration (COMMA THE_KW? objectTargetPropertyDeclaration)*
  private static boolean handlerLabeledParametersDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GIVEN);
    r = r && handlerLabeledParametersDefinition_4_0_1(b, l + 1);
    r = r && objectTargetPropertyDeclaration(b, l + 1);
    r = r && handlerLabeledParametersDefinition_4_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean handlerLabeledParametersDefinition_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // (COMMA THE_KW? objectTargetPropertyDeclaration)*
  private static boolean handlerLabeledParametersDefinition_4_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!handlerLabeledParametersDefinition_4_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "handlerLabeledParametersDefinition_4_0_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA THE_KW? objectTargetPropertyDeclaration
  private static boolean handlerLabeledParametersDefinition_4_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && handlerLabeledParametersDefinition_4_0_3_0_1(b, l + 1);
    r = r && objectTargetPropertyDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean handlerLabeledParametersDefinition_4_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_4_0_3_0_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // [varDeclarationList]
  private static boolean handlerLabeledParametersDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_5")) return false;
    varDeclarationList(b, l + 1);
    return true;
  }

  // blockBody?
  private static boolean handlerLabeledParametersDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_7")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [referenceExpression]
  private static boolean handlerLabeledParametersDefinition_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerLabeledParametersDefinition_9")) return false;
    referenceExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // referenceExpression
  static boolean handlerNamePartRef(PsiBuilder b, int l) {
    return referenceExpression(b, l + 1);
  }

  /* ********************************************************** */
  // about|above|against|'apart from'|around|'aside from'|at|below|beneath|beside|between|by|for
  // |from|'instead of'|into|on|onto|'out of'|over|since|thru|through|under|to
  public static boolean handlerParameterLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerParameterLabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HANDLER_PARAMETER_LABEL, "<handler parameter label>");
    r = consumeToken(b, ABOUT);
    if (!r) r = consumeToken(b, ABOVE);
    if (!r) r = consumeToken(b, AGAINST);
    if (!r) r = consumeToken(b, "apart from");
    if (!r) r = consumeToken(b, AROUND);
    if (!r) r = consumeToken(b, "aside from");
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BELOW);
    if (!r) r = consumeToken(b, BENEATH);
    if (!r) r = consumeToken(b, BESIDE);
    if (!r) r = consumeToken(b, BETWEEN);
    if (!r) r = consumeToken(b, BY);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FROM);
    if (!r) r = consumeToken(b, "instead of");
    if (!r) r = consumeToken(b, INTO);
    if (!r) r = consumeToken(b, ON);
    if (!r) r = consumeToken(b, ONTO);
    if (!r) r = consumeToken(b, "out of");
    if (!r) r = consumeToken(b, OVER);
    if (!r) r = consumeToken(b, SINCE);
    if (!r) r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    if (!r) r = consumeToken(b, UNDER);
    if (!r) r = consumeToken(b, TO);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN argumentList? RPAREN
  public static boolean handlerPositionalParametersCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersCallExpression")) return false;
    if (!nextTokenIsFast(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, HANDLER_POSITIONAL_PARAMETERS_CALL_EXPRESSION, null);
    r = consumeTokenFast(b, LPAREN);
    r = r && handlerPositionalParametersCallExpression_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argumentList?
  private static boolean handlerPositionalParametersCallExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersCallExpression_1")) return false;
    argumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (on|to) identifier LPAREN [formalParameterList] RPAREN
  //                                             [varDeclarationList] sep
  //                                                blockBody?
  //                                             end [referenceExpression]
  public static boolean handlerPositionalParametersDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition")) return false;
    if (!nextTokenIs(b, "<handler positional parameters definition>", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HANDLER_POSITIONAL_PARAMETERS_DEFINITION, "<handler positional parameters definition>");
    r = handlerPositionalParametersDefinition_0(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && handlerPositionalParametersDefinition_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && handlerPositionalParametersDefinition_5(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && handlerPositionalParametersDefinition_7(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && handlerPositionalParametersDefinition_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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

  // [formalParameterList]
  private static boolean handlerPositionalParametersDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_3")) return false;
    formalParameterList(b, l + 1);
    return true;
  }

  // [varDeclarationList]
  private static boolean handlerPositionalParametersDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_5")) return false;
    varDeclarationList(b, l + 1);
    return true;
  }

  // blockBody?
  private static boolean handlerPositionalParametersDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_7")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [referenceExpression]
  private static boolean handlerPositionalParametersDefinition_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handlerPositionalParametersDefinition_9")) return false;
    referenceExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id expression
  public static boolean idReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "idReference")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, ID_REFERENCE, null);
    r = consumeToken(b, ID);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // var_identifier
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR_IDENTIFIER);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // if expression [then] sep
  //                                        blockBody?
  //                                    (else if expression [then] sep
  //                                        blockBody?  )*
  //                                    (else sep
  //                                         blockBody? )?
  //                         end [if]
  public static boolean ifCompoundStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_COMPOUND_STATEMENT, null);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && ifCompoundStatement_2(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && ifCompoundStatement_4(b, l + 1);
    r = r && ifCompoundStatement_5(b, l + 1);
    r = r && ifCompoundStatement_6(b, l + 1);
    r = r && consumeToken(b, END);
    p = r; // pin = 8
    r = r && ifCompoundStatement_8(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [then]
  private static boolean ifCompoundStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_2")) return false;
    consumeToken(b, THEN);
    return true;
  }

  // blockBody?
  private static boolean ifCompoundStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // (else if expression [then] sep
  //                                        blockBody?  )*
  private static boolean ifCompoundStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ifCompoundStatement_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ifCompoundStatement_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // else if expression [then] sep
  //                                        blockBody?
  private static boolean ifCompoundStatement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && expression(b, l + 1);
    r = r && ifCompoundStatement_5_0_3(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && ifCompoundStatement_5_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [then]
  private static boolean ifCompoundStatement_5_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_5_0_3")) return false;
    consumeToken(b, THEN);
    return true;
  }

  // blockBody?
  private static boolean ifCompoundStatement_5_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_5_0_5")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // (else sep
  //                                         blockBody? )?
  private static boolean ifCompoundStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_6")) return false;
    ifCompoundStatement_6_0(b, l + 1);
    return true;
  }

  // else sep
  //                                         blockBody?
  private static boolean ifCompoundStatement_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && sep(b, l + 1);
    r = r && ifCompoundStatement_6_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean ifCompoundStatement_6_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_6_0_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [if]
  private static boolean ifCompoundStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifCompoundStatement_8")) return false;
    consumeToken(b, IF);
    return true;
  }

  /* ********************************************************** */
  // if expression then (statement|expression)
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

  // statement|expression
  private static boolean ifSimpleStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifSimpleStatement_3")) return false;
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
  // ignoring considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  //                         [but considering considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)? ] sep
  //                            blockBody?
  //                       end ignoring
  public static boolean ignoringStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement")) return false;
    if (!nextTokenIs(b, IGNORING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IGNORING_STATEMENT, null);
    r = consumeToken(b, IGNORING);
    r = r && considerOrIgnoreAttr(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, ignoringStatement_2(b, l + 1));
    r = p && report_error_(b, ignoringStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, ignoringStatement_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, END, IGNORING)) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean ignoringStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2")) return false;
    ignoringStatement_2_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?
  private static boolean ignoringStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ignoringStatement_2_0_0(b, l + 1);
    r = r && ignoringStatement_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttr)*
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

  // COMMA considerOrIgnoreAttr
  private static boolean ignoringStatement_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttr)?
  private static boolean ignoringStatement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_1")) return false;
    ignoringStatement_2_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttr
  private static boolean ignoringStatement_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [but considering considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)? ]
  private static boolean ignoringStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3")) return false;
    ignoringStatement_3_0(b, l + 1);
    return true;
  }

  // but considering considerOrIgnoreAttr ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean ignoringStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUT, CONSIDERING);
    r = r && considerOrIgnoreAttr(b, l + 1);
    r = r && ignoringStatement_3_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?)?
  private static boolean ignoringStatement_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3")) return false;
    ignoringStatement_3_0_3_0(b, l + 1);
    return true;
  }

  // (COMMA considerOrIgnoreAttr)* (LAND considerOrIgnoreAttr)?
  private static boolean ignoringStatement_3_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ignoringStatement_3_0_3_0_0(b, l + 1);
    r = r && ignoringStatement_3_0_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA considerOrIgnoreAttr)*
  private static boolean ignoringStatement_3_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ignoringStatement_3_0_3_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ignoringStatement_3_0_3_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA considerOrIgnoreAttr
  private static boolean ignoringStatement_3_0_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && considerOrIgnoreAttr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LAND considerOrIgnoreAttr)?
  private static boolean ignoringStatement_3_0_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3_0_1")) return false;
    ignoringStatement_3_0_3_0_1_0(b, l + 1);
    return true;
  }

  // LAND considerOrIgnoreAttr
  private static boolean ignoringStatement_3_0_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignoringStatement_3_0_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAND);
    r = r && considerOrIgnoreAttr(b, l + 1);
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
  // <<parseIncompleteCommandCall>>
  public static boolean incompleteCommandHandlerCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteCommandHandlerCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCOMPLETE_COMMAND_HANDLER_CALL, "<incomplete command handler call>");
    r = parseIncompleteCommandCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // tell expression | set objectReferenceWrapper | copy expression | if expression
  public static boolean incompleteExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCOMPLETE_EXPRESSION, "<incomplete expression>");
    r = incompleteExpression_0(b, l + 1);
    if (!r) r = incompleteExpression_1(b, l + 1);
    if (!r) r = incompleteExpression_2(b, l + 1);
    if (!r) r = incompleteExpression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // tell expression
  private static boolean incompleteExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, TELL);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // set objectReferenceWrapper
  private static boolean incompleteExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, SET);
    r = r && objectReferenceWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // copy expression
  private static boolean incompleteExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COPY);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if expression
  private static boolean incompleteExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incompleteExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, IF);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (integerLiteralExpression('st'|'rd'|'th') (typeSpecifier|userClassName))
  //                    |((first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth) (typeSpecifier|userClassName) )
  //                    |((last|front|back) (typeSpecifier|userClassName))
  public static boolean indexReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDEX_REFERENCE, "<index reference>");
    r = indexReference_0(b, l + 1);
    if (!r) r = indexReference_1(b, l + 1);
    if (!r) r = indexReference_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // integerLiteralExpression('st'|'rd'|'th') (typeSpecifier|userClassName)
  private static boolean indexReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    r = r && indexReference_0_1(b, l + 1);
    r = r && indexReference_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'st'|'rd'|'th'
  private static boolean indexReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "st");
    if (!r) r = consumeToken(b, "rd");
    if (!r) r = consumeToken(b, "th");
    exit_section_(b, m, null, r);
    return r;
  }

  // typeSpecifier|userClassName
  private static boolean indexReference_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeSpecifier(b, l + 1);
    if (!r) r = userClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth) (typeSpecifier|userClassName)
  private static boolean indexReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexReference_1_0(b, l + 1);
    r = r && indexReference_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // first|second|third|fourth|fifth|sixth|seventh|eighth|ninth|tenth
  private static boolean indexReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_1_0")) return false;
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

  // typeSpecifier|userClassName
  private static boolean indexReference_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeSpecifier(b, l + 1);
    if (!r) r = userClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (last|front|back) (typeSpecifier|userClassName)
  private static boolean indexReference_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexReference_2_0(b, l + 1);
    r = r && indexReference_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // last|front|back
  private static boolean indexReference_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAST);
    if (!r) r = consumeToken(b, FRONT);
    if (!r) r = consumeToken(b, BACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeSpecifier|userClassName
  private static boolean indexReference_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReference_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeSpecifier(b, l + 1);
    if (!r) r = userClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [index] indexValueExpression
  public static boolean indexReferenceClassForm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReferenceClassForm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, INDEX_REFERENCE_CLASS_FORM, "<index reference class form>");
    r = indexReferenceClassForm_0(b, l + 1);
    r = r && indexValueExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [index]
  private static boolean indexReferenceClassForm_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexReferenceClassForm_0")) return false;
    consumeToken(b, INDEX);
    return true;
  }

  /* ********************************************************** */
  // referenceExpression|integerLiteralExpression|parenthesizedExpression
  static boolean indexValueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexValueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    if (!r) r = integerLiteralExpression(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DIGITS
  public static boolean integerLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerLiteralExpression")) return false;
    if (!nextTokenIsFast(b, DIGITS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, DIGITS);
    exit_section_(b, m, INTEGER_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // it|me|ITS
  static boolean itMeProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "itMeProperty")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IT);
    if (!r) r = consumeToken(b, ME);
    if (!r) r = consumeToken(b, ITS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean labelForFalseParam(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // expression
  static boolean labelForTrueParam(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // ((of|in)? directParameterDeclaration | targetVariablePattern )? labeledParameterDeclarationPart*
  public static boolean labeledParameterDeclarationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABELED_PARAMETER_DECLARATION_LIST, "<labeled parameter declaration list>");
    r = labeledParameterDeclarationList_0(b, l + 1);
    r = r && labeledParameterDeclarationList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((of|in)? directParameterDeclaration | targetVariablePattern )?
  private static boolean labeledParameterDeclarationList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_0")) return false;
    labeledParameterDeclarationList_0_0(b, l + 1);
    return true;
  }

  // (of|in)? directParameterDeclaration | targetVariablePattern
  private static boolean labeledParameterDeclarationList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labeledParameterDeclarationList_0_0_0(b, l + 1);
    if (!r) r = targetVariablePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (of|in)? directParameterDeclaration
  private static boolean labeledParameterDeclarationList_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = labeledParameterDeclarationList_0_0_0_0(b, l + 1);
    r = r && directParameterDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (of|in)?
  private static boolean labeledParameterDeclarationList_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_0_0_0_0")) return false;
    labeledParameterDeclarationList_0_0_0_0_0(b, l + 1);
    return true;
  }

  // of|in
  private static boolean labeledParameterDeclarationList_0_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_0_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    exit_section_(b, m, null, r);
    return r;
  }

  // labeledParameterDeclarationPart*
  private static boolean labeledParameterDeclarationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!labeledParameterDeclarationPart(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "labeledParameterDeclarationList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // handlerParameterLabel THE_KW? identifier
  public static boolean labeledParameterDeclarationPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABELED_PARAMETER_DECLARATION_PART, "<labeled parameter declaration part>");
    r = handlerParameterLabel(b, l + 1);
    r = r && labeledParameterDeclarationPart_1(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // THE_KW?
  private static boolean labeledParameterDeclarationPart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "labeledParameterDeclarationPart_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // launch expression?
  public static boolean launchCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "launchCommandExpression")) return false;
    if (!nextTokenIsFast(b, LAUNCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LAUNCH);
    r = r && launchCommandExpression_1(b, l + 1);
    exit_section_(b, m, LAUNCH_COMMAND_EXPRESSION, r);
    return r;
  }

  // expression?
  private static boolean launchCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "launchCommandExpression_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LCURLY [formalParameterListPartPattern|expression] (COMMA formalParameterListPartPattern|expression)* RCURLY
  public static boolean listFormalParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && listFormalParameter_1(b, l + 1);
    r = r && listFormalParameter_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, LIST_FORMAL_PARAMETER, r);
    return r;
  }

  // [formalParameterListPartPattern|expression]
  private static boolean listFormalParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter_1")) return false;
    listFormalParameter_1_0(b, l + 1);
    return true;
  }

  // formalParameterListPartPattern|expression
  private static boolean listFormalParameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = formalParameterListPartPattern(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA formalParameterListPartPattern|expression)*
  private static boolean listFormalParameter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!listFormalParameter_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listFormalParameter_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA formalParameterListPartPattern|expression
  private static boolean listFormalParameter_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listFormalParameter_2_0_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA formalParameterListPartPattern
  private static boolean listFormalParameter_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listFormalParameter_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && formalParameterListPartPattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY [expression] (COMMA expression)* RCURLY
  public static boolean listLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression")) return false;
    if (!nextTokenIsFast(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LCURLY);
    r = r && listLiteralExpression_1(b, l + 1);
    r = r && listLiteralExpression_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, LIST_LITERAL_EXPRESSION, r);
    return r;
  }

  // [expression]
  private static boolean listLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // (COMMA expression)*
  private static boolean listLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!listLiteralExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listLiteralExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA expression
  private static boolean listLiteralExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteralExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean listOrReferenceExpression(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // stringLiteralExpression
  //               |styledTextLiteralExpression
  //               |numberLiteralExpression
  //               |dictionaryConstant
  //               |builtInConstantLiteralExpression
  //               |<<parseLiteralExpression listLiteralExpression>>
  //               |<<parseLiteralExpression recordLiteralExpression>>
  //               |<<parseExpression '"date"' dateLiteralExpression>>
  //               |aReferenceToLiteralExpression
  static boolean literalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringLiteralExpression(b, l + 1);
    if (!r) r = styledTextLiteralExpression(b, l + 1);
    if (!r) r = numberLiteralExpression(b, l + 1);
    if (!r) r = dictionaryConstant(b, l + 1);
    if (!r) r = builtInConstantLiteralExpression(b, l + 1);
    if (!r) r = parseLiteralExpression(b, l + 1, listLiteralExpression_parser_);
    if (!r) r = parseLiteralExpression(b, l + 1, recordLiteralExpression_parser_);
    if (!r) r = parseExpression(b, l + 1, "date", dateLiteralExpression_parser_);
    if (!r) r = aReferenceToLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // log expression
  public static boolean logCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logCommandExpression")) return false;
    if (!nextTokenIsFast(b, LOG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LOG);
    r = r && expression(b, l + 1);
    exit_section_(b, m, LOG_COMMAND_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // LAND NLS* negationExpressionWrapper
  public static boolean logicalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression")) return false;
    if (!nextTokenIsFast(b, LAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, LOGICAL_AND_EXPRESSION, null);
    r = consumeTokenFast(b, LAND);
    r = r && logicalAndExpression_1(b, l + 1);
    r = r && negationExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NLS*
  private static boolean logicalAndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "logicalAndExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // negationExpressionWrapper logicalAndExpression*
  static boolean logicalAndExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = negationExpressionWrapper(b, l + 1);
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
  // LOR NLS* logicalAndExpressionWrapper
  public static boolean logicalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression")) return false;
    if (!nextTokenIsFast(b, LOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, LOGICAL_OR_EXPRESSION, null);
    r = consumeTokenFast(b, LOR);
    r = r && logicalOrExpression_1(b, l + 1);
    r = r && logicalAndExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NLS*
  private static boolean logicalOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "logicalOrExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
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
  // directParameterDeclaration
  static boolean loopVariable(PsiBuilder b, int l) {
    return directParameterDeclaration(b, l + 1);
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean machineName(PsiBuilder b, int l) {
    return consumeToken(b, STRING_LITERAL);
  }

  /* ********************************************************** */
  // middle typeSpecifier
  public static boolean middleElemReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "middleElemReference")) return false;
    if (!nextTokenIs(b, MIDDLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MIDDLE_ELEM_REFERENCE, null);
    r = consumeToken(b, MIDDLE);
    p = r; // pin = 1
    r = r && typeSpecifier(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MISSING_VALUE
  static boolean missing_value_constant(PsiBuilder b, int l) {
    return consumeToken(b, MISSING_VALUE);
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
  // multiplicativeOperator NLS* powerExpressionWrapper
  public static boolean multiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = multiplicativeOperator(b, l + 1);
    r = r && multiplicativeExpression_1(b, l + 1);
    r = r && powerExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NLS*
  private static boolean multiplicativeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
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
  // nameReferenceString
  public static boolean nameReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameReference")) return false;
    if (!nextTokenIs(b, "<name reference>", STRING_LITERAL, NAMED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, NAME_REFERENCE, "<name reference>");
    r = nameReferenceString(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [named] nameStringExpression
  static boolean nameReferenceString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameReferenceString")) return false;
    if (!nextTokenIs(b, "", STRING_LITERAL, NAMED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameReferenceString_0(b, l + 1);
    r = r && nameStringExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [named]
  private static boolean nameReferenceString_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameReferenceString_0")) return false;
    consumeToken(b, NAMED);
    return true;
  }

  /* ********************************************************** */
  // stringLiteralExpression
  static boolean nameStringExpression(PsiBuilder b, int l) {
    return stringLiteralExpression(b, l + 1);
  }

  /* ********************************************************** */
  // LNOT NLS* negationExpressionWrapper
  public static boolean negationExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negationExpression")) return false;
    if (!nextTokenIsFast(b, LNOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LNOT);
    r = r && negationExpression_1(b, l + 1);
    r = r && negationExpressionWrapper(b, l + 1);
    exit_section_(b, m, NEGATION_EXPRESSION, r);
    return r;
  }

  // NLS*
  private static boolean negationExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negationExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeTokenFast(b, NLS)) break;
      if (!empty_element_parsed_guard_(b, "negationExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // negationExpression | compareExpressionWrapper
  static boolean negationExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negationExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = negationExpression(b, l + 1);
    if (!r) r = compareExpressionWrapper(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean numTimes(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // realLiteralExpression|integerLiteralExpression|numericConstant
  public static boolean numberLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, NUMBER_LITERAL_EXPRESSION, "<number literal expression>");
    r = realLiteralExpression(b, l + 1);
    if (!r) r = integerLiteralExpression(b, l + 1);
    if (!r) r = numericConstant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PI_CONSTANT|seconds_constants
  public static boolean numericConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numericConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_CONSTANT, "<numeric constant>");
    r = consumeToken(b, PI_CONSTANT);
    if (!r) r = seconds_constants(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // propertyLabelIdentifier COLON (formalParameterListPartPattern|propertyInitializerExpression)
  public static boolean objectNamedPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectNamedPropertyDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_NAMED_PROPERTY_DECLARATION, "<object named property declaration>");
    r = propertyLabelIdentifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && objectNamedPropertyDeclaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // formalParameterListPartPattern|propertyInitializerExpression
  private static boolean objectNamedPropertyDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectNamedPropertyDeclaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = formalParameterListPartPattern(b, l + 1);
    if (!r) r = propertyInitializerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // of|in|APS|<<isPossessivePpronoun>>
  static boolean objectPointer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPointer")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OF);
    if (!r) r = consumeToken(b, IN);
    if (!r) r = consumeToken(b, APS);
    if (!r) r = isPossessivePpronoun(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // propertyLabelIdentifier COLON propertyInitializerExpression
  public static boolean objectPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPropertyDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_PROPERTY_DECLARATION, "<object property declaration>");
    r = propertyLabelIdentifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && propertyInitializerExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // possessiveFormAndInterleavedCall | objectPointer THE_KW? prefixExpression
  public static boolean objectReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, OBJECT_REFERENCE_EXPRESSION, "<object reference expression>");
    r = possessiveFormAndInterleavedCall(b, l + 1);
    if (!r) r = objectReferenceExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // objectPointer THE_KW? prefixExpression
  private static boolean objectReferenceExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectPointer(b, l + 1);
    r = r && objectReferenceExpression_1_1(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectReferenceExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceExpression_1_1")) return false;
    consumeTokenFast(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // THE_KW? prefixExpression objectReferenceExpression*
  static boolean objectReferenceWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectReferenceWrapper_0(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    r = r && objectReferenceWrapper_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean objectReferenceWrapper_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceWrapper_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // objectReferenceExpression*
  private static boolean objectReferenceWrapper_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectReferenceWrapper_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!objectReferenceExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "objectReferenceWrapper_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // propertyLabelIdentifier COLON (targetVariablePattern|propertyInitializerExpression)
  public static boolean objectTargetPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectTargetPropertyDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_TARGET_PROPERTY_DECLARATION, "<object target property declaration>");
    r = propertyLabelIdentifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && objectTargetPropertyDeclaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // targetVariablePattern|propertyInitializerExpression
  private static boolean objectTargetPropertyDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectTargetPropertyDeclaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetVariablePattern(b, l + 1);
    if (!r) r = propertyInitializerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (referenceExpression &to) | expression
  static boolean offendingObject(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offendingObject")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = offendingObject_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression &to
  private static boolean offendingObject_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offendingObject_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && offendingObject_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &to
  private static boolean offendingObject_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offendingObject_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, TO);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // directParameterDeclaration|expression
  static boolean offendingObjectVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offendingObjectVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceIdBeforeParamLabel | expression
  public static boolean parameterVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_VAL, "<parameter val>");
    r = referenceIdBeforeParamLabel(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean parameterValue(PsiBuilder b, int l) {
    return expression(b, l + 1);
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
    if (!nextTokenIsFast(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LPAREN);
    r = r && expressionInParentheses(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARENTHESIZED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // <<parseAssignmentStatementInner>>
  static boolean parseAssignmentStatement(PsiBuilder b, int l) {
    return parseAssignmentStatementInner(b, l + 1);
  }

  /* ********************************************************** */
  // <<parseTellSimpleStatementInner>>
  static boolean parseTellSimpleStatement(PsiBuilder b, int l) {
    return parseTellSimpleStatementInner(b, l + 1);
  }

  /* ********************************************************** */
  // builtInClassIdentifierPlural | dictionaryClassIdentifierPlural | rawClassExpression
  static boolean pluralClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluralClassName")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtInClassIdentifierPlural(b, l + 1);
    if (!r) r = dictionaryClassIdentifierPlural(b, l + 1);
    if (!r) r = rawClassExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (APS|<<isPossessivePpronoun>>) handlerInterleavedParametersCall
  static boolean possessiveFormAndInterleavedCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "possessiveFormAndInterleavedCall")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = possessiveFormAndInterleavedCall_0(b, l + 1);
    r = r && handlerInterleavedParametersCall(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // APS|<<isPossessivePpronoun>>
  private static boolean possessiveFormAndInterleavedCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "possessiveFormAndInterleavedCall_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, APS);
    if (!r) r = isPossessivePpronoun(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // POW objectReferenceWrapper
  public static boolean powerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "powerExpression")) return false;
    if (!nextTokenIsFast(b, POW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, POWER_EXPRESSION, null);
    r = consumeTokenFast(b, POW);
    r = r && objectReferenceWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // objectReferenceWrapper powerExpression*
  static boolean powerExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "powerExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectReferenceWrapper(b, l + 1);
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
  // (prefixOperator prefixExpression) | valueExpression
  static boolean prefixExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression_0(b, l + 1);
    if (!r) r = valueExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefixOperator prefixExpression
  private static boolean prefixExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixOperator(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS|MINUS
  static boolean prefixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOperator")) return false;
    if (!nextTokenIs(b, "", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literalExpression
  //  |   dictionaryCommandHandlerCallExpression
  //  |   rawDictionaryCommandHandlerCallExpression
  //  |   rawDataExpression
  //  | ( primaryReferenceExpression
  //      (
  //      <<isTreePrevSimpleReference>>
  //        (  handlerPositionalParametersCallExpression | <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression )
  //      )?
  //    )
  //  |   parenthesizedExpression
  //  |   appleScriptCommandExpression
  static boolean primaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = literalExpression(b, l + 1);
    if (!r) r = dictionaryCommandHandlerCallExpression(b, l + 1);
    if (!r) r = rawDictionaryCommandHandlerCallExpression(b, l + 1);
    if (!r) r = rawDataExpression(b, l + 1);
    if (!r) r = primaryExpression_4(b, l + 1);
    if (!r) r = parenthesizedExpression(b, l + 1);
    if (!r) r = appleScriptCommandExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // primaryReferenceExpression
  //      (
  //      <<isTreePrevSimpleReference>>
  //        (  handlerPositionalParametersCallExpression | <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression )
  //      )?
  private static boolean primaryExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primaryReferenceExpression(b, l + 1);
    r = r && primaryExpression_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (
  //      <<isTreePrevSimpleReference>>
  //        (  handlerPositionalParametersCallExpression | <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression )
  //      )?
  private static boolean primaryExpression_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_4_1")) return false;
    primaryExpression_4_1_0(b, l + 1);
    return true;
  }

  // <<isTreePrevSimpleReference>>
  //        (  handlerPositionalParametersCallExpression | <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression )
  private static boolean primaryExpression_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = isTreePrevSimpleReference(b, l + 1);
    r = r && primaryExpression_4_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // handlerPositionalParametersCallExpression | <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression
  private static boolean primaryExpression_4_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_4_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerPositionalParametersCallExpression(b, l + 1);
    if (!r) r = primaryExpression_4_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<isHandlerLabeledParametersCallAllowed>>  handlerLabeledParametersCallExpression
  private static boolean primaryExpression_4_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_4_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = isHandlerLabeledParametersCallAllowed(b, l + 1);
    r = r && handlerLabeledParametersCallExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // applicationReference | referenceForm | referenceExpression
  static boolean primaryReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationReference(b, l + 1);
    if (!r) r = referenceForm(b, l + 1);
    if (!r) r = referenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean propertyInitializerExpression(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // propertyReference|identifier
  static boolean propertyLabelIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyLabelIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = propertyReference(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dictionaryPropertyName|literalExpression|appleScriptProperty|builtInClassProperty
  public static boolean propertyReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_REFERENCE, "<property reference>");
    r = dictionaryPropertyName(b, l + 1);
    if (!r) r = literalExpression(b, l + 1);
    if (!r) r = appleScriptProperty(b, l + 1);
    if (!r) r = builtInClassProperty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // from [THE_KW] (beginning|expression) to [THE_KW](end|expression)
  public static boolean rangeFromReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeFromReference")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && rangeFromReference_1(b, l + 1);
    r = r && rangeFromReference_2(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && rangeFromReference_4(b, l + 1);
    r = r && rangeFromReference_5(b, l + 1);
    exit_section_(b, m, RANGE_FROM_REFERENCE, r);
    return r;
  }

  // [THE_KW]
  private static boolean rangeFromReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeFromReference_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // beginning|expression
  private static boolean rangeFromReference_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeFromReference_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEGINNING);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [THE_KW]
  private static boolean rangeFromReference_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeFromReference_4")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // end|expression
  private static boolean rangeFromReference_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeFromReference_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, END);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // startIndex (thru|through) stopIndex
  public static boolean rangeIndexReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeIndexReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RANGE_INDEX_REFERENCE, "<range index reference>");
    r = startIndex(b, l + 1);
    r = r && rangeIndexReference_1(b, l + 1);
    r = r && stopIndex(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // thru|through
  private static boolean rangeIndexReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeIndexReference_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THRU);
    if (!r) r = consumeToken(b, THROUGH);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rangeFromReference | rangeIndexReference
  static boolean rangeReferenceFormWithClassPrefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rangeReferenceFormWithClassPrefix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rangeFromReference(b, l + 1);
    if (!r) r = rangeIndexReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RAW_LBR CLASS identifier RAW_RBR
  public static boolean rawClassExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawClassExpression")) return false;
    if (!nextTokenIsFast(b, RAW_LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RAW_LBR, CLASS);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, RAW_RBR);
    exit_section_(b, m, RAW_CLASS_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // RAW_LBR DATA DIGITS RAW_RBR
  public static boolean rawDataExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawDataExpression")) return false;
    if (!nextTokenIsFast(b, RAW_LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RAW_LBR, DATA, DIGITS, RAW_RBR);
    exit_section_(b, m, RAW_DATA_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // RAW_LBR EVENT identifier RAW_RBR commandRawParameters?
  public static boolean rawDictionaryCommandHandlerCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawDictionaryCommandHandlerCallExpression")) return false;
    if (!nextTokenIsFast(b, RAW_LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RAW_LBR, EVENT);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, RAW_RBR);
    r = r && rawDictionaryCommandHandlerCallExpression_4(b, l + 1);
    exit_section_(b, m, RAW_DICTIONARY_COMMAND_HANDLER_CALL_EXPRESSION, r);
    return r;
  }

  // commandRawParameters?
  private static boolean rawDictionaryCommandHandlerCallExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawDictionaryCommandHandlerCallExpression_4")) return false;
    commandRawParameters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // rawParameterSelector expression
  public static boolean rawParameterExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawParameterExpression")) return false;
    if (!nextTokenIsFast(b, RAW_LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rawParameterSelector(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, RAW_PARAMETER_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // RAW_LBR PREPOSITION identifier RAW_RBR
  public static boolean rawParameterSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rawParameterSelector")) return false;
    if (!nextTokenIs(b, RAW_LBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RAW_LBR, PREPOSITION);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, RAW_RBR);
    exit_section_(b, m, RAW_PARAMETER_SELECTOR, r);
    return r;
  }

  /* ********************************************************** */
  // ('.'(DIGITS)(DEC_EXPONENT))|(dec_significand DEC_EXPONENT?)
  public static boolean realLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REAL_LITERAL_EXPRESSION, "<real literal expression>");
    r = realLiteralExpression_0(b, l + 1);
    if (!r) r = realLiteralExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '.'(DIGITS)(DEC_EXPONENT)
  private static boolean realLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, ".");
    r = r && realLiteralExpression_0_1(b, l + 1);
    r = r && realLiteralExpression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DIGITS)
  private static boolean realLiteralExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, DIGITS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DEC_EXPONENT)
  private static boolean realLiteralExpression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, DEC_EXPONENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // dec_significand DEC_EXPONENT?
  private static boolean realLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dec_significand(b, l + 1);
    r = r && realLiteralExpression_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DEC_EXPONENT?
  private static boolean realLiteralExpression_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "realLiteralExpression_1_1")) return false;
    consumeTokenFast(b, DEC_EXPONENT);
    return true;
  }

  /* ********************************************************** */
  // LCURLY[objectNamedPropertyDeclaration] (COMMA objectNamedPropertyDeclaration)* RCURLY
  public static boolean recordFormalParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordFormalParameter")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && recordFormalParameter_1(b, l + 1);
    r = r && recordFormalParameter_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, RECORD_FORMAL_PARAMETER, r);
    return r;
  }

  // [objectNamedPropertyDeclaration]
  private static boolean recordFormalParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordFormalParameter_1")) return false;
    objectNamedPropertyDeclaration(b, l + 1);
    return true;
  }

  // (COMMA objectNamedPropertyDeclaration)*
  private static boolean recordFormalParameter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordFormalParameter_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!recordFormalParameter_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordFormalParameter_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA objectNamedPropertyDeclaration
  private static boolean recordFormalParameter_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordFormalParameter_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && objectNamedPropertyDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY[objectPropertyDeclaration] (COMMA objectPropertyDeclaration)* RCURLY
  public static boolean recordLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression")) return false;
    if (!nextTokenIsFast(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LCURLY);
    r = r && recordLiteralExpression_1(b, l + 1);
    r = r && recordLiteralExpression_2(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, RECORD_LITERAL_EXPRESSION, r);
    return r;
  }

  // [objectPropertyDeclaration]
  private static boolean recordLiteralExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression_1")) return false;
    objectPropertyDeclaration(b, l + 1);
    return true;
  }

  // (COMMA objectPropertyDeclaration)*
  private static boolean recordLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!recordLiteralExpression_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recordLiteralExpression_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA objectPropertyDeclaration
  private static boolean recordLiteralExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recordLiteralExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, COMMA);
    r = r && objectPropertyDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean referenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression")) return false;
    if (!nextTokenIsFast(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, REFERENCE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // (my handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier )
  //     | (my?
  //     // it looks like only range reference can be compiled using referenceIdentifier. For other forms valid
  //     // class name is a must
  //        (classNamePrimaryExpression
  //         (  rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  //         )? //can not remove '?' from here.. as script compiles with just className as a primary expression...
  //        )
  //        |
  //        (  arbitraryReference
  //         | everyElemReference
  //         | everyRangeReference
  //         | middleElemReference
  //         | relativeReference
  //         | indexReference
  //         | propertyReference
  //        )
  //       )
  static boolean referenceForm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceForm_0(b, l + 1);
    if (!r) r = referenceForm_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier
  private static boolean referenceForm_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MY);
    r = r && handlerInterleavedCallOrPropertyReferenceOrReferenceIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my?
  //     // it looks like only range reference can be compiled using referenceIdentifier. For other forms valid
  //     // class name is a must
  //        (classNamePrimaryExpression
  //         (  rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  //         )? //can not remove '?' from here.. as script compiles with just className as a primary expression...
  //        )
  //        |
  //        (  arbitraryReference
  //         | everyElemReference
  //         | everyRangeReference
  //         | middleElemReference
  //         | relativeReference
  //         | indexReference
  //         | propertyReference
  //        )
  private static boolean referenceForm_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceForm_1_0(b, l + 1);
    if (!r) r = referenceForm_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my?
  //     // it looks like only range reference can be compiled using referenceIdentifier. For other forms valid
  //     // class name is a must
  //        (classNamePrimaryExpression
  //         (  rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  //         )? //can not remove '?' from here.. as script compiles with just className as a primary expression...
  //        )
  private static boolean referenceForm_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceForm_1_0_0(b, l + 1);
    r = r && referenceForm_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // my?
  private static boolean referenceForm_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_0_0")) return false;
    consumeToken(b, MY);
    return true;
  }

  // classNamePrimaryExpression
  //         (  rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  //         )?
  private static boolean referenceForm_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classNamePrimaryExpression(b, l + 1);
    r = r && referenceForm_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (  rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  //         )?
  private static boolean referenceForm_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_0_1_1")) return false;
    referenceForm_1_0_1_1_0(b, l + 1);
    return true;
  }

  // rangeReferenceFormWithClassPrefix
  //          | nameReference
  //          | relativeReference
  //          | indexReferenceClassForm
  //          | idReference
  private static boolean referenceForm_1_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rangeReferenceFormWithClassPrefix(b, l + 1);
    if (!r) r = nameReference(b, l + 1);
    if (!r) r = relativeReference(b, l + 1);
    if (!r) r = indexReferenceClassForm(b, l + 1);
    if (!r) r = idReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // arbitraryReference
  //         | everyElemReference
  //         | everyRangeReference
  //         | middleElemReference
  //         | relativeReference
  //         | indexReference
  //         | propertyReference
  private static boolean referenceForm_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceForm_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arbitraryReference(b, l + 1);
    if (!r) r = everyElemReference(b, l + 1);
    if (!r) r = everyRangeReference(b, l + 1);
    if (!r) r = middleElemReference(b, l + 1);
    if (!r) r = relativeReference(b, l + 1);
    if (!r) r = indexReference(b, l + 1);
    if (!r) r = propertyReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression &handlerParameterLabel
  static boolean referenceIdBeforeParamLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceIdBeforeParamLabel")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && referenceIdBeforeParamLabel_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &handlerParameterLabel
  private static boolean referenceIdBeforeParamLabel_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceIdBeforeParamLabel_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = handlerParameterLabel(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // applicationReference
  static boolean referenceToApplicationVar(PsiBuilder b, int l) {
    return applicationReference(b, l + 1);
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
  // (after|([in]( back | end ) of)|behind )primaryReferenceExpression
  static boolean relativeAfterReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeAfterReference")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeAfterReference_0(b, l + 1);
    r = r && primaryReferenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // after|([in]( back | end ) of)|behind
  private static boolean relativeAfterReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeAfterReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AFTER);
    if (!r) r = relativeAfterReference_0_1(b, l + 1);
    if (!r) r = consumeToken(b, BEHIND);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]( back | end ) of
  private static boolean relativeAfterReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeAfterReference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeAfterReference_0_1_0(b, l + 1);
    r = r && relativeAfterReference_0_1_1(b, l + 1);
    r = r && consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]
  private static boolean relativeAfterReference_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeAfterReference_0_1_0")) return false;
    consumeToken(b, IN);
    return true;
  }

  // back | end
  private static boolean relativeAfterReference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeAfterReference_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACK);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (before|([in] ( front | beginning ) of) )primaryReferenceExpression
  static boolean relativeBeforeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeBeforeReference")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeBeforeReference_0(b, l + 1);
    r = r && primaryReferenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // before|([in] ( front | beginning ) of)
  private static boolean relativeBeforeReference_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeBeforeReference_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BEFORE);
    if (!r) r = relativeBeforeReference_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in] ( front | beginning ) of
  private static boolean relativeBeforeReference_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeBeforeReference_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relativeBeforeReference_0_1_0(b, l + 1);
    r = r && relativeBeforeReference_0_1_1(b, l + 1);
    r = r && consumeToken(b, OF);
    exit_section_(b, m, null, r);
    return r;
  }

  // [in]
  private static boolean relativeBeforeReference_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeBeforeReference_0_1_0")) return false;
    consumeToken(b, IN);
    return true;
  }

  // front | beginning
  private static boolean relativeBeforeReference_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeBeforeReference_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FRONT);
    if (!r) r = consumeToken(b, BEGINNING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // relativeBeforeReference | relativeAfterReference
  public static boolean relativeReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relativeReference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, RELATIVE_REFERENCE, "<relative reference>");
    r = relativeBeforeReference(b, l + 1);
    if (!r) r = relativeAfterReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // REPEAT sep
  //                             blockBody?
  //                            end [REPEAT]
  public static boolean repeatForeverStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && sep(b, l + 1);
    r = r && repeatForeverStatement_2(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && repeatForeverStatement_4(b, l + 1);
    exit_section_(b, m, REPEAT_FOREVER_STATEMENT, r);
    return r;
  }

  // blockBody?
  private static boolean repeatForeverStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [REPEAT]
  private static boolean repeatForeverStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatForeverStatement_4")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // REPEAT numTimes [times] sep
  //                             blockBody?
  //                             end [REPEAT]
  public static boolean repeatNumTimesStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && numTimes(b, l + 1);
    r = r && repeatNumTimesStatement_2(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && repeatNumTimesStatement_4(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && repeatNumTimesStatement_6(b, l + 1);
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

  // [REPEAT]
  private static boolean repeatNumTimesStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatNumTimesStatement_6")) return false;
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
  // REPEAT until expression sep
  //                          blockBody?
  //                          end [REPEAT]
  public static boolean repeatUntilStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPEAT_UNTIL_STATEMENT, null);
    r = consumeTokens(b, 2, REPEAT, UNTIL);
    p = r; // pin = 2
    r = r && report_error_(b, expression(b, l + 1));
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, repeatUntilStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatUntilStatement_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatUntilStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [REPEAT]
  private static boolean repeatUntilStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatUntilStatement_6")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // REPEAT while expression sep
  //                             blockBody?
  //                          end [REPEAT]
  public static boolean repeatWhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPEAT_WHILE_STATEMENT, null);
    r = consumeTokens(b, 2, REPEAT, WHILE);
    p = r; // pin = 2
    r = r && report_error_(b, expression(b, l + 1));
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, repeatWhileStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatWhileStatement_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatWhileStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement_4")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [REPEAT]
  private static boolean repeatWhileStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWhileStatement_6")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // REPEAT with loopVariable in listOrReferenceExpression sep
  //                          blockBody?
  //                          end [REPEAT]
  public static boolean repeatWithListStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPEAT_WITH_LIST_STATEMENT, null);
    r = consumeTokens(b, 0, REPEAT, WITH);
    r = r && loopVariable(b, l + 1);
    r = r && consumeToken(b, IN);
    p = r; // pin = 4
    r = r && report_error_(b, listOrReferenceExpression(b, l + 1));
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithListStatement_6(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatWithListStatement_8(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean repeatWithListStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [REPEAT]
  private static boolean repeatWithListStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithListStatement_8")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // REPEAT with loopVariable from startValue to stopValue [by stepValue] sep
  //                              blockBody?
  //                              end [REPEAT]
  public static boolean repeatWithRangeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPEAT_WITH_RANGE_STATEMENT, null);
    r = consumeTokens(b, 0, REPEAT, WITH);
    r = r && loopVariable(b, l + 1);
    r = r && consumeToken(b, FROM);
    p = r; // pin = 4
    r = r && report_error_(b, startValue(b, l + 1));
    r = p && report_error_(b, consumeToken(b, TO)) && r;
    r = p && report_error_(b, stopValue(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithRangeStatement_7(b, l + 1)) && r;
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, repeatWithRangeStatement_9(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && repeatWithRangeStatement_11(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
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

  // [REPEAT]
  private static boolean repeatWithRangeStatement_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repeatWithRangeStatement_11")) return false;
    consumeToken(b, REPEAT);
    return true;
  }

  /* ********************************************************** */
  // expression
  static boolean resultList(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // directParameterDeclaration|expression
  static boolean resultListVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resultListVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // ("run" [script] [script_object_variable])|("run" [referenceToApplicationVar])
  public static boolean runCommandExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RUN_COMMAND_EXPRESSION, "<run command expression>");
    r = runCommandExpression_0(b, l + 1);
    if (!r) r = runCommandExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "run" [script] [script_object_variable]
  private static boolean runCommandExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, "run");
    r = r && runCommandExpression_0_1(b, l + 1);
    r = r && runCommandExpression_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [script]
  private static boolean runCommandExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_0_1")) return false;
    consumeTokenFast(b, SCRIPT);
    return true;
  }

  // [script_object_variable]
  private static boolean runCommandExpression_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_0_2")) return false;
    script_object_variable(b, l + 1);
    return true;
  }

  // "run" [referenceToApplicationVar]
  private static boolean runCommandExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "runCommandExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, "run");
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
  // topBlockBodyPart (sep topBlockBodyPart)* sep?
  public static boolean scriptBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBody")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_BODY, "<script body>");
    r = topBlockBodyPart(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, scriptBody_1(b, l + 1));
    r = p && scriptBody_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (sep topBlockBodyPart)*
  private static boolean scriptBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBody_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!scriptBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scriptBody_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // sep topBlockBodyPart
  private static boolean scriptBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && topBlockBodyPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sep?
  private static boolean scriptBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptBody_2")) return false;
    sep(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // script scriptObjectName sep
  //                                   scriptBody?
  //                            end [script]
  public static boolean scriptObjectDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinition")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    r = r && scriptObjectName(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && scriptObjectDefinition_3(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && scriptObjectDefinition_5(b, l + 1);
    exit_section_(b, m, SCRIPT_OBJECT_DEFINITION, r);
    return r;
  }

  // scriptBody?
  private static boolean scriptObjectDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinition_3")) return false;
    scriptBody(b, l + 1);
    return true;
  }

  // [script]
  private static boolean scriptObjectDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectDefinition_5")) return false;
    consumeToken(b, SCRIPT);
    return true;
  }

  /* ********************************************************** */
  // identifier
  static boolean scriptObjectName(PsiBuilder b, int l) {
    return identifier(b, l + 1);
  }

  /* ********************************************************** */
  // script sep
  //                                   scriptBody?
  //                                  end [script]
  public static boolean scriptObjectUnnamedDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectUnnamedDefinition")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_OBJECT_UNNAMED_DEFINITION, null);
    r = consumeToken(b, SCRIPT);
    r = r && sep(b, l + 1);
    r = r && scriptObjectUnnamedDefinition_2(b, l + 1);
    r = r && consumeToken(b, END);
    p = r; // pin = 4
    r = r && scriptObjectUnnamedDefinition_4(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // scriptBody?
  private static boolean scriptObjectUnnamedDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectUnnamedDefinition_2")) return false;
    scriptBody(b, l + 1);
    return true;
  }

  // [script]
  private static boolean scriptObjectUnnamedDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptObjectUnnamedDefinition_4")) return false;
    consumeToken(b, SCRIPT);
    return true;
  }

  /* ********************************************************** */
  // (property|prop) propertyLabelIdentifier COLON propertyInitializerExpression
  public static boolean scriptPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptPropertyDeclaration")) return false;
    if (!nextTokenIs(b, "<script property declaration>", PROP, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_PROPERTY_DECLARATION, "<script property declaration>");
    r = scriptPropertyDeclaration_0(b, l + 1);
    r = r && propertyLabelIdentifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && propertyInitializerExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // property|prop
  private static boolean scriptPropertyDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scriptPropertyDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROPERTY);
    if (!r) r = consumeToken(b, PROP);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression
  static boolean script_object_variable(PsiBuilder b, int l) {
    return referenceExpression(b, l + 1);
  }

  /* ********************************************************** */
  // <<parseExpression '"scripting additions"' SCRIPTING_ADDITIONS>>
  static boolean scriptingAdditionsFolderConstant(PsiBuilder b, int l) {
    return parseExpression(b, l + 1, "scripting additions", SCRIPTING_ADDITIONS_parser_);
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
  // identifier
  public static boolean selectorId(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectorId")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, SELECTOR_ID, r);
    return r;
  }

  /* ********************************************************** */
  // (COMMENT? NLS COMMENT?)+
  static boolean sep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep")) return false;
    if (!nextTokenIs(b, "", COMMENT, NLS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!sep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sep", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT? NLS COMMENT?
  private static boolean sep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep_0_0(b, l + 1);
    r = r && consumeToken(b, NLS);
    r = r && sep_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean sep_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep_0_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // COMMENT?
  private static boolean sep_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep_0_2")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // expression
  static boolean sessionSpecificator(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // setCommandAppleScriptSetSyntax|setCommandAppleScriptReturningSyntax
  static boolean setCommandAppleScript(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScript")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setCommandAppleScriptSetSyntax(b, l + 1);
    if (!r) r = setCommandAppleScriptReturningSyntax(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression returning targetVariablePattern
  static boolean setCommandAppleScriptReturningSyntax(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptReturningSyntax")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, RETURNING);
    r = r && targetVariablePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // set THE_KW? (targetVariablePattern to|objectReferenceWrapper to) THE_KW? expression
  static boolean setCommandAppleScriptSetSyntax(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && setCommandAppleScriptSetSyntax_1(b, l + 1);
    r = r && setCommandAppleScriptSetSyntax_2(b, l + 1);
    r = r && setCommandAppleScriptSetSyntax_3(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean setCommandAppleScriptSetSyntax_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax_1")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  // targetVariablePattern to|objectReferenceWrapper to
  private static boolean setCommandAppleScriptSetSyntax_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setCommandAppleScriptSetSyntax_2_0(b, l + 1);
    if (!r) r = setCommandAppleScriptSetSyntax_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // targetVariablePattern to
  private static boolean setCommandAppleScriptSetSyntax_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetVariablePattern(b, l + 1);
    r = r && consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // objectReferenceWrapper to
  private static boolean setCommandAppleScriptSetSyntax_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = objectReferenceWrapper(b, l + 1);
    r = r && consumeToken(b, TO);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean setCommandAppleScriptSetSyntax_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setCommandAppleScriptSetSyntax_3")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // THE_KW? identifier
  public static boolean simpleFormalParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFormalParameter")) return false;
    if (!nextTokenIs(b, "<simple formal parameter>", THE_KW, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_FORMAL_PARAMETER, "<simple formal parameter>");
    r = simpleFormalParameter_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // THE_KW?
  private static boolean simpleFormalParameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFormalParameter_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // (dictionaryClassName | builtInClassIdentifier | rawClassExpression) ITEM?
  static boolean singularClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singularClassName_0(b, l + 1);
    r = r && singularClassName_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // dictionaryClassName | builtInClassIdentifier | rawClassExpression
  private static boolean singularClassName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dictionaryClassName(b, l + 1);
    if (!r) r = builtInClassIdentifier(b, l + 1);
    if (!r) r = rawClassExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM?
  private static boolean singularClassName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singularClassName_1")) return false;
    consumeToken(b, ITEM);
    return true;
  }

  /* ********************************************************** */
  // integerLiteralExpression | expression
  static boolean startIndex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "startIndex")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (referenceExpression &to) | expression
  static boolean startValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "startValue")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = startValue_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression &to
  private static boolean startValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "startValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && startValue_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &to
  private static boolean startValue_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "startValue_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, TO);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // controlStatement|scriptPropertyDeclaration|varDeclarationList
  //                       |<<parseExpression '"script"' (scriptObjectDefinition | scriptObjectUnnamedDefinition)>>
  //                       |returnStatement|continue_statement
  //                       |parseAssignmentStatement
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = controlStatement(b, l + 1);
    if (!r) r = scriptPropertyDeclaration(b, l + 1);
    if (!r) r = varDeclarationList(b, l + 1);
    if (!r) r = parseExpression(b, l + 1, "script", statement_3_1_parser_);
    if (!r) r = returnStatement(b, l + 1);
    if (!r) r = continue_statement(b, l + 1);
    if (!r) r = parseAssignmentStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // scriptObjectDefinition | scriptObjectUnnamedDefinition
  private static boolean statement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = scriptObjectDefinition(b, l + 1);
    if (!r) r = scriptObjectUnnamedDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean stepValue(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // integerLiteralExpression | expression
  static boolean stopIndex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopIndex")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integerLiteralExpression(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (referenceExpression &by) | expression
  static boolean stopValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopValue")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stopValue_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression &by
  private static boolean stopValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && stopValue_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &by
  private static boolean stopValue_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stopValue_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, BY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean stringLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteralExpression")) return false;
    if (!nextTokenIsFast(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, STRING_LITERAL);
    exit_section_(b, m, STRING_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTED_FORM
  static boolean stringProperty(PsiBuilder b, int l) {
    return consumeToken(b, QUOTED_FORM);
  }

  /* ********************************************************** */
  // STRING_LITERAL
  static boolean styledTextLiteralExpression(PsiBuilder b, int l) {
    return consumeTokenFast(b, STRING_LITERAL);
  }

  /* ********************************************************** */
  // LCURLY [targetVariablePattern|expression] (COMMA targetVariablePattern|expression)* RCURLY
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

  // [targetVariablePattern|expression]
  private static boolean targetListLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_1")) return false;
    targetListLiteral_1_0(b, l + 1);
    return true;
  }

  // targetVariablePattern|expression
  private static boolean targetListLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetVariablePattern(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA targetVariablePattern|expression)*
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

  // COMMA targetVariablePattern|expression
  private static boolean targetListLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetListLiteral_2_0_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA targetVariablePattern
  private static boolean targetListLiteral_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetListLiteral_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && targetVariablePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY[objectTargetPropertyDeclaration] (COMMA objectTargetPropertyDeclaration)* RCURLY
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

  // [objectTargetPropertyDeclaration]
  private static boolean targetRecordLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_1")) return false;
    objectTargetPropertyDeclaration(b, l + 1);
    return true;
  }

  // (COMMA objectTargetPropertyDeclaration)*
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

  // COMMA objectTargetPropertyDeclaration
  private static boolean targetRecordLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetRecordLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && objectTargetPropertyDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean targetVariable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetVariable")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, TARGET_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // targetVariable|targetListLiteral|targetRecordLiteral
  static boolean targetVariablePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targetVariablePattern")) return false;
    if (!nextTokenIs(b, "", LCURLY, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = targetVariable(b, l + 1);
    if (!r) r = targetListLiteral(b, l + 1);
    if (!r) r = targetRecordLiteral(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tell objectReferenceWrapper sep
  //                                         blockBody?
  //                           end [tell]
  public static boolean tellCompoundStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellCompoundStatement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TELL);
    r = r && objectReferenceWrapper(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && tellCompoundStatement_3(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && tellCompoundStatement_5(b, l + 1);
    exit_section_(b, m, TELL_COMPOUND_STATEMENT, r);
    return r;
  }

  // blockBody?
  private static boolean tellCompoundStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellCompoundStatement_3")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [tell]
  private static boolean tellCompoundStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellCompoundStatement_5")) return false;
    consumeToken(b, TELL);
    return true;
  }

  /* ********************************************************** */
  // tell <<parseTellSimpleObjectReference>> to (statement | handlerInterleavedParametersCall | expression )
  public static boolean tellSimpleStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellSimpleStatement")) return false;
    if (!nextTokenIs(b, TELL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TELL);
    r = r && parseTellSimpleObjectReference(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && tellSimpleStatement_3(b, l + 1);
    exit_section_(b, m, TELL_SIMPLE_STATEMENT, r);
    return r;
  }

  // statement | handlerInterleavedParametersCall | expression
  private static boolean tellSimpleStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellSimpleStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = handlerInterleavedParametersCall(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parseTellSimpleStatement|<<parseTellCompoundStatement>>
  static boolean tellStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tellStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTellSimpleStatement(b, l + 1);
    if (!r) r = parseTellCompoundStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<isTellStatementStart>>
  static boolean tellStatementStartCondition(PsiBuilder b, int l) {
    return isTellStatementStart(b, l + 1);
  }

  /* ********************************************************** */
  // TEXT_ITEM_DELIMETERS
  public static boolean textItemDelimitersProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "textItemDelimitersProperty")) return false;
    if (!nextTokenIs(b, TEXT_ITEM_DELIMETERS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXT_ITEM_DELIMETERS);
    exit_section_(b, m, TEXT_ITEM_DELIMITERS_PROPERTY, r);
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
  // expression
  static boolean timeoutIntegerExpression(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // topBlockBodyPart sep (topBlockBodyPart sep)*
  public static boolean topBlockBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topBlockBody")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TOP_BLOCK_BODY, "<top block body>");
    r = topBlockBodyPart(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && topBlockBody_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (topBlockBodyPart sep)*
  private static boolean topBlockBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topBlockBody_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!topBlockBody_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "topBlockBody_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // topBlockBodyPart sep
  private static boolean topBlockBody_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topBlockBody_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = topBlockBodyPart(b, l + 1);
    r = r && sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // topLevelStatement | statement | expression | incompleteExpression
  static boolean topBlockBodyPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topBlockBodyPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = topLevelStatement(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = incompleteExpression(b, l + 1);
    exit_section_(b, l, m, r, false, topBodyPartRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !sep
  static boolean topBodyPartRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topBodyPartRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !sep(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // applicationHandlerDefinition | userHandlerDefinition | <<parseUseStatement useStatement>>
  static boolean topLevelStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelStatement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationHandlerDefinition(b, l + 1);
    if (!r) r = userHandlerDefinition(b, l + 1);
    if (!r) r = parseUseStatement(b, l + 1, useStatement_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // try sep
  //                      blockBody?
  //                      (on error [errorMessageVar] [number errorNumberVar] [from offendingObjectVar]
  //                      [to expectedTypeVar] [partial result resultListVar] sep
  //                      [varDeclarationList sep]
  //                      blockBody?)?
  //                  end [error|try]
  public static boolean tryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TRY_STATEMENT, null);
    r = consumeToken(b, TRY);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, tryStatement_2(b, l + 1)) && r;
    r = p && report_error_(b, tryStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && tryStatement_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // blockBody?
  private static boolean tryStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_2")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // (on error [errorMessageVar] [number errorNumberVar] [from offendingObjectVar]
  //                      [to expectedTypeVar] [partial result resultListVar] sep
  //                      [varDeclarationList sep]
  //                      blockBody?)?
  private static boolean tryStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3")) return false;
    tryStatement_3_0(b, l + 1);
    return true;
  }

  // on error [errorMessageVar] [number errorNumberVar] [from offendingObjectVar]
  //                      [to expectedTypeVar] [partial result resultListVar] sep
  //                      [varDeclarationList sep]
  //                      blockBody?
  private static boolean tryStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ON, ERROR);
    r = r && tryStatement_3_0_2(b, l + 1);
    r = r && tryStatement_3_0_3(b, l + 1);
    r = r && tryStatement_3_0_4(b, l + 1);
    r = r && tryStatement_3_0_5(b, l + 1);
    r = r && tryStatement_3_0_6(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && tryStatement_3_0_8(b, l + 1);
    r = r && tryStatement_3_0_9(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [errorMessageVar]
  private static boolean tryStatement_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_2")) return false;
    errorMessageVar(b, l + 1);
    return true;
  }

  // [number errorNumberVar]
  private static boolean tryStatement_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_3")) return false;
    tryStatement_3_0_3_0(b, l + 1);
    return true;
  }

  // number errorNumberVar
  private static boolean tryStatement_3_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && errorNumberVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [from offendingObjectVar]
  private static boolean tryStatement_3_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_4")) return false;
    tryStatement_3_0_4_0(b, l + 1);
    return true;
  }

  // from offendingObjectVar
  private static boolean tryStatement_3_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && offendingObjectVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [to expectedTypeVar]
  private static boolean tryStatement_3_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_5")) return false;
    tryStatement_3_0_5_0(b, l + 1);
    return true;
  }

  // to expectedTypeVar
  private static boolean tryStatement_3_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    r = r && expectedTypeVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [partial result resultListVar]
  private static boolean tryStatement_3_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_6")) return false;
    tryStatement_3_0_6_0(b, l + 1);
    return true;
  }

  // partial result resultListVar
  private static boolean tryStatement_3_0_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARTIAL, RESULT);
    r = r && resultListVar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [varDeclarationList sep]
  private static boolean tryStatement_3_0_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_8")) return false;
    tryStatement_3_0_8_0(b, l + 1);
    return true;
  }

  // varDeclarationList sep
  private static boolean tryStatement_3_0_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varDeclarationList(b, l + 1);
    r = r && sep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean tryStatement_3_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_3_0_9")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [error|try]
  private static boolean tryStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_5")) return false;
    tryStatement_5_0(b, l + 1);
    return true;
  }

  // error|try
  private static boolean tryStatement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ERROR);
    if (!r) r = consumeToken(b, TRY);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pluralClassName | singularClassName
  static boolean typeSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeSpecifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pluralClassName(b, l + 1);
    if (!r) r = singularClassName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Length|SQUARE_AREA|CUBIC_VOL|LiquidVolume|Weight|TEMPERATURE
  static boolean unitTypeValueClasses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unitTypeValueClasses")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Length(b, l + 1);
    if (!r) r = consumeToken(b, SQUARE_AREA);
    if (!r) r = consumeToken(b, CUBIC_VOL);
    if (!r) r = LiquidVolume(b, l + 1);
    if (!r) r = Weight(b, l + 1);
    if (!r) r = consumeToken(b, TEMPERATURE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use 'AppleScript' [version expression]
  static boolean useAppleScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, USE);
    r = r && consumeToken(b, "AppleScript");
    p = r; // pin = 2
    r = r && useAppleScriptStatement_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [version expression]
  private static boolean useAppleScriptStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement_2")) return false;
    useAppleScriptStatement_2_0(b, l + 1);
    return true;
  }

  // version expression
  private static boolean useAppleScriptStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useAppleScriptStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use [directParameterDeclaration COLON]
  //                     (
  //                      (  <<parseUsedApplicationNameExternal withImportCondition>>//application "string" &(importing)
  //                       | dataSpecifier
  //                       | (script dataSpecifier)
  //                      )
  //                         [versionSpecifier] [(with importing)|(without importing)|(importing expression)]
  //                     )
  static boolean useApplicationOrScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    r = r && useApplicationOrScriptStatement_1(b, l + 1);
    r = r && useApplicationOrScriptStatement_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [directParameterDeclaration COLON]
  private static boolean useApplicationOrScriptStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_1")) return false;
    useApplicationOrScriptStatement_1_0(b, l + 1);
    return true;
  }

  // directParameterDeclaration COLON
  private static boolean useApplicationOrScriptStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directParameterDeclaration(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (  <<parseUsedApplicationNameExternal withImportCondition>>//application "string" &(importing)
  //                       | dataSpecifier
  //                       | (script dataSpecifier)
  //                      )
  //                         [versionSpecifier] [(with importing)|(without importing)|(importing expression)]
  private static boolean useApplicationOrScriptStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useApplicationOrScriptStatement_2_0(b, l + 1);
    r = r && useApplicationOrScriptStatement_2_1(b, l + 1);
    r = r && useApplicationOrScriptStatement_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<parseUsedApplicationNameExternal withImportCondition>>//application "string" &(importing)
  //                       | dataSpecifier
  //                       | (script dataSpecifier)
  private static boolean useApplicationOrScriptStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseUsedApplicationNameExternal(b, l + 1, withImportCondition_parser_);
    if (!r) r = dataSpecifier(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // script dataSpecifier
  private static boolean useApplicationOrScriptStatement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    r = r && dataSpecifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [versionSpecifier]
  private static boolean useApplicationOrScriptStatement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_1")) return false;
    versionSpecifier(b, l + 1);
    return true;
  }

  // [(with importing)|(without importing)|(importing expression)]
  private static boolean useApplicationOrScriptStatement_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_2")) return false;
    useApplicationOrScriptStatement_2_2_0(b, l + 1);
    return true;
  }

  // (with importing)|(without importing)|(importing expression)
  private static boolean useApplicationOrScriptStatement_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useApplicationOrScriptStatement_2_2_0_0(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement_2_2_0_1(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement_2_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // with importing
  private static boolean useApplicationOrScriptStatement_2_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITH, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // without importing
  private static boolean useApplicationOrScriptStatement_2_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITHOUT, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // importing expression
  private static boolean useApplicationOrScriptStatement_2_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useApplicationOrScriptStatement_2_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORTING);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // use framework dataSpecifier
  static boolean useFrameworkStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useFrameworkStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 2, USE, FRAMEWORK);
    p = r; // pin = 2
    r = r && dataSpecifier(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // use SCRIPTING_ADDITIONS
  //                                    [((with importing)|(without importing)|importing) expression ]
  static boolean useScriptingAdditionsStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useScriptingAdditionsStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 2, USE, SCRIPTING_ADDITIONS);
    p = r; // pin = 2
    r = r && useScriptingAdditionsStatement_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
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
  // useAppleScriptStatement|useApplicationOrScriptStatement|useFrameworkStatement
  public static boolean useStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useStatement")) return false;
    if (!nextTokenIs(b, USE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = useAppleScriptStatement(b, l + 1);
    if (!r) r = useApplicationOrScriptStatement(b, l + 1);
    if (!r) r = useFrameworkStatement(b, l + 1);
    exit_section_(b, m, USE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // <<parseCheckForUseStatements>>
  static boolean useStatementsCondition(PsiBuilder b, int l) {
    return parseCheckForUseStatements(b, l + 1);
  }

  /* ********************************************************** */
  // identifier
  public static boolean userClassName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userClassName")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, USER_CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // handlerLabeledParametersDefinition | handlerPositionalParametersDefinition | handlerInterleavedParametersDefinition
  static boolean userHandlerDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userHandlerDefinition")) return false;
    if (!nextTokenIs(b, "", ON, TO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = handlerLabeledParametersDefinition(b, l + 1);
    if (!r) r = handlerPositionalParametersDefinition(b, l + 1);
    if (!r) r = handlerInterleavedParametersDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THE_KW? referenceExpression
  static boolean userLabelReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userLabelReference")) return false;
    if (!nextTokenIs(b, "", THE_KW, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userLabelReference_0(b, l + 1);
    r = r && referenceExpression(b, l + 1);
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
  static boolean userParameterVal(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  /* ********************************************************** */
  // THE_KW? targetVariablePattern | expression
  static boolean userParameterVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVar")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userParameterVar_0(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW? targetVariablePattern
  private static boolean userParameterVar_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVar_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userParameterVar_0_0(b, l + 1);
    r = r && targetVariablePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // THE_KW?
  private static boolean userParameterVar_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userParameterVar_0_0")) return false;
    consumeToken(b, THE_KW);
    return true;
  }

  /* ********************************************************** */
  // using terms from (applicationReference|(script dataSpecifier)|<<pushStdLibrary>>) sep
  //                              topBlockBody?
  //                             end [using terms from]
  public static boolean usingTermsFromStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement")) return false;
    if (!nextTokenIs(b, USING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USING, TERMS, FROM);
    r = r && usingTermsFromStatement_3(b, l + 1);
    r = r && sep(b, l + 1);
    r = r && usingTermsFromStatement_5(b, l + 1);
    r = r && consumeToken(b, END);
    r = r && usingTermsFromStatement_7(b, l + 1);
    exit_section_(b, m, USING_TERMS_FROM_STATEMENT, r);
    return r;
  }

  // applicationReference|(script dataSpecifier)|<<pushStdLibrary>>
  private static boolean usingTermsFromStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = applicationReference(b, l + 1);
    if (!r) r = usingTermsFromStatement_3_1(b, l + 1);
    if (!r) r = pushStdLibrary(b, l + 1);
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

  // topBlockBody?
  private static boolean usingTermsFromStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_5")) return false;
    topBlockBody(b, l + 1);
    return true;
  }

  // [using terms from]
  private static boolean usingTermsFromStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingTermsFromStatement_7")) return false;
    parseTokens(b, 0, USING, TERMS, FROM);
    return true;
  }

  /* ********************************************************** */
  // primaryExpression filterReference? dictionaryCommandHandlerCallExpression?
  static boolean valueExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primaryExpression(b, l + 1);
    r = r && valueExpression_1(b, l + 1);
    r = r && valueExpression_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // filterReference?
  private static boolean valueExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueExpression_1")) return false;
    filterReference(b, l + 1);
    return true;
  }

  // dictionaryCommandHandlerCallExpression?
  private static boolean valueExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valueExpression_2")) return false;
    dictionaryCommandHandlerCallExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // variableGlobalDeclaration|variableLocalDeclaration
  public static boolean varAccessDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varAccessDeclaration")) return false;
    if (!nextTokenIs(b, "<var access declaration>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_ACCESS_DECLARATION, "<var access declaration>");
    r = variableGlobalDeclaration(b, l + 1);
    if (!r) r = variableLocalDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // varAccessDeclaration (COMMA varDeclarationListPart)*
  public static boolean varDeclarationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclarationList")) return false;
    if (!nextTokenIs(b, "<var declaration list>", GLOBAL, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECLARATION_LIST, "<var declaration list>");
    r = varAccessDeclaration(b, l + 1);
    r = r && varDeclarationList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA varDeclarationListPart)*
  private static boolean varDeclarationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclarationList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!varDeclarationList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varDeclarationList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA varDeclarationListPart
  private static boolean varDeclarationList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclarationList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && varDeclarationListPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean varDeclarationListPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclarationListPart")) return false;
    if (!nextTokenIs(b, VAR_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, VAR_DECLARATION_LIST_PART, r);
    return r;
  }

  /* ********************************************************** */
  // global identifier
  static boolean variableGlobalDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableGlobalDeclaration")) return false;
    if (!nextTokenIs(b, GLOBAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GLOBAL);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // local identifier
  static boolean variableLocalDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableLocalDeclaration")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // version
  static boolean versionProperty(PsiBuilder b, int l) {
    return consumeToken(b, VERSION);
  }

  /* ********************************************************** */
  // version stringLiteralExpression
  static boolean versionSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "versionSpecifier")) return false;
    if (!nextTokenIs(b, VERSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION);
    r = r && stringLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // &([versionSpecifier] !((without importing)|(importing false)))
  static boolean withImportCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = withImportCondition_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [versionSpecifier] !((without importing)|(importing false))
  private static boolean withImportCondition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withImportCondition_0_0(b, l + 1);
    r = r && withImportCondition_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [versionSpecifier]
  private static boolean withImportCondition_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0_0")) return false;
    versionSpecifier(b, l + 1);
    return true;
  }

  // !((without importing)|(importing false))
  private static boolean withImportCondition_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !withImportCondition_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (without importing)|(importing false)
  private static boolean withImportCondition_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = withImportCondition_0_1_0_0(b, l + 1);
    if (!r) r = withImportCondition_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // without importing
  private static boolean withImportCondition_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WITHOUT, IMPORTING);
    exit_section_(b, m, null, r);
    return r;
  }

  // importing false
  private static boolean withImportCondition_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withImportCondition_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORTING, FALSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // with timeout [of] timeoutIntegerExpression (seconds|second) sep
  //                            blockBody?
  //                          end [timeout]
  public static boolean withTimeoutStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WITH_TIMEOUT_STATEMENT, null);
    r = consumeTokens(b, 2, WITH, TIMEOUT);
    p = r; // pin = 2
    r = r && report_error_(b, withTimeoutStatement_2(b, l + 1));
    r = p && report_error_(b, timeoutIntegerExpression(b, l + 1)) && r;
    r = p && report_error_(b, withTimeoutStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, withTimeoutStatement_6(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && withTimeoutStatement_8(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [of]
  private static boolean withTimeoutStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_2")) return false;
    consumeToken(b, OF);
    return true;
  }

  // seconds|second
  private static boolean withTimeoutStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SECONDS);
    if (!r) r = consumeToken(b, SECOND);
    exit_section_(b, m, null, r);
    return r;
  }

  // blockBody?
  private static boolean withTimeoutStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_6")) return false;
    blockBody(b, l + 1);
    return true;
  }

  // [timeout]
  private static boolean withTimeoutStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTimeoutStatement_8")) return false;
    consumeToken(b, TIMEOUT);
    return true;
  }

  /* ********************************************************** */
  // with transaction [sessionSpecificator] sep
  //                                blockBody?
  //                              end [transaction]
  public static boolean withTransactionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement")) return false;
    if (!nextTokenIs(b, WITH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WITH_TRANSACTION_STATEMENT, null);
    r = consumeTokens(b, 2, WITH, TRANSACTION);
    p = r; // pin = 2
    r = r && report_error_(b, withTransactionStatement_2(b, l + 1));
    r = p && report_error_(b, sep(b, l + 1)) && r;
    r = p && report_error_(b, withTransactionStatement_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, END)) && r;
    r = p && withTransactionStatement_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
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

  // [transaction]
  private static boolean withTransactionStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "withTransactionStatement_6")) return false;
    consumeToken(b, TRANSACTION);
    return true;
  }

  final static Parser BUNDLE_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, BUNDLE);
    }
  };
  final static Parser SCRIPTING_ADDITIONS_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, SCRIPTING_ADDITIONS);
    }
  };
  final static Parser SCRIPT_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, SCRIPT);
    }
  };
  final static Parser argListPartRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return argListPartRecover(b, l + 1);
    }
  };
  final static Parser argListRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return argListRecover(b, l + 1);
    }
  };
  final static Parser bodyPartRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return bodyPartRecover(b, l + 1);
    }
  };
  final static Parser dateLiteralExpression_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return dateLiteralExpression(b, l + 1);
    }
  };
  final static Parser listLiteralExpression_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return listLiteralExpression(b, l + 1);
    }
  };
  final static Parser recordLiteralExpression_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recordLiteralExpression(b, l + 1);
    }
  };
  final static Parser repeatStatement_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return repeatStatement(b, l + 1);
    }
  };
  final static Parser statement_3_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return statement_3_1(b, l + 1);
    }
  };
  final static Parser tellStatementStartCondition_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return tellStatementStartCondition(b, l + 1);
    }
  };
  final static Parser topBodyPartRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return topBodyPartRecover(b, l + 1);
    }
  };
  final static Parser useStatement_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return useStatement(b, l + 1);
    }
  };
  final static Parser useStatementsCondition_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return useStatementsCondition(b, l + 1);
    }
  };
  final static Parser withImportCondition_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return withImportCondition(b, l + 1);
    }
  };
}
