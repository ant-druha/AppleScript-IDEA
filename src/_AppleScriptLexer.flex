package com.intellij.plugin.applescript.lang.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.intellij.plugin.applescript.psi.AppleScriptTypes.*;

%%

%{
  public _AppleScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _AppleScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

ONE_NL=(\r|\n|\r\n)
CC="¬"
WHITE_SPACE_CHAR=[\ \t\f]
WHITE_SPACE={WHITE_SPACE_CHAR}|{CC}({WHITE_SPACE_CHAR})*({ONE_NL})?//|{CC}
NLS={ONE_NL}({ONE_NL}|{WHITE_SPACE})*

STARTS_BEGINS_WITH=("start""s with"|"start with"|"begin""s with"|"begin with")
ENDS_WITH=("end""s with"|"end with")
DOES_NOT_CONTAIN=("does not contain"|"doesn't contain")
IS_IN=("is in"|"is contained by")
IS_NOT_IN=("is not in"|"is not contained by"|"isn't contained by")
IS_CONTAIN=("contain"|"contains")

//todo duplicate variants with and without to/is parts otherwise it is not parsed correctly
GT=(">"|"is greater than"|"greater than"|"comes after"|"is not less than or equal to"|"is not less than or equal"|"isn't less than or equal to"|"isn't less than or equal")
LE=("≤"|"<="|"is less than or equal to"|"less than or equal to"|"is less than or equal"|"less than or equal"|"is not greater than"|"isn't greater than"|"does not come after"|"doesn't come after")
GE=("≥"|">="|"is greater than or equal to"|"greater than or equal to"|"is greater than or equal"|"greater than or equal"|"is not less than"|"isn't less than"|"does not come before"|"doesn't come before")
LT=("<"|"is less than"|"less than"|"comes before"|"is not greater than or equal to"|"is not greater than or equal"|"isn't greater than or equal to"|"isn't greater than or equal")
NE=("≠"|"isn't equal to"|"isn't equal"|"is not equal to"|"is not equal"|"doesn't equal"|"does not equal"|"is not"|"isn't")
EQ=("="|"is equal to"|"equal to"|"is"|"equal"|"equals")
REF_OP=("a reference to"|"a ref to"|"a ref"|"reference to"|"ref")
DIV=("/"|"÷")
STYLED_TEXT="styled"{WHITE_SPACE}+"text"
TEXT_ITEM="text"{WHITE_SPACE}+"item"
FILE_SPECIFICATION="file"{WHITE_SPACE}+"specification"
INTERNATIONAL_TEXT=["I""i"]"nternational"{WHITE_SPACE}+["T""t"]"ext"
UNICODE_TEXT=(["U""u"]"nicode"{WHITE_SPACE}+["T""t"]"ext")
RGB_COLOR="rgb"{WHITE_SPACE}+"color"
STYLED_CLIPBOARD_TEXT="styled"{WHITE_SPACE}+"clipboard"{WHITE_SPACE}+"text"
LOCATION_SPECIFIER="location"{WHITE_SPACE}+"specifier"
TEMPERATURE="degrees"{WHITE_SPACE}+("Celsius"|"Fahrenheit"|"Kelvin")
CUBIC_VOL="cubic"{WHITE_SPACE}+("centimetres"|"centimeters"|"feet"|"inches"|"metres"|"meters"|"yards")
SQUARE_AREA="square"{WHITE_SPACE}+("feet"|"kilometres"|"kilometers"|"metres"|"meters"|"miles"|"yards")
//class name plural form
BUILT_IN_TYPE={STYLED_TEXT}|{TEXT_ITEM}|{FILE_SPECIFICATION}|{INTERNATIONAL_TEXT}|{UNICODE_TEXT}|{RGB_COLOR}|{STYLED_CLIPBOARD_TEXT}|{LOCATION_SPECIFIER}|{TEMPERATURE}|{CUBIC_VOL}|{SQUARE_AREA}|"string"|"integer"|"real"|"boolean"|"class"|"constant"|"list"|"record"|"data"|"date"|"number"|"reference"|"text"|"item"|"any"|"file"|"alias"|"point"|"rectangle"|"specifier"|"type"|"gallons"|"litres"|"liters"|"quarts"|"grams"|"kilograms"|"ounces"|"pounds"|"centimetres"|"centimeters"|"feet"|"inches"|"kilometres"|"kilometers"|"metres"|"meters"|"miles"|"yards"|"character"|"paragraph"|"word"//|"script"
BUILT_IN_TYPE_S={BUILT_IN_TYPE}"s"

//built in classes properties
QUOTED_FORM="quoted"{WHITE_SPACE}+"form"
BUILT_IN_PROPERTY=("class"|"day"|"weekday"|"month"|"year"|"time"|"date"{WHITE_SPACE}+"string"|"short"{WHITE_SPACE}+"date"{WHITE_SPACE}+"string"|"time"{WHITE_SPACE}+"string"|"length"|"rest"|"reverse"|"contents"|{QUOTED_FORM})

APART_FROM="apart"{WHITE_SPACE}+"from"
ASIDE_FROM="aside"{WHITE_SPACE}+"from"
OUT_OF="out"{WHITE_SPACE}+"of"
INSTEAD_OF="instead"{WHITE_SPACE}+"of"
C_WHITE_SPACE="white"{WHITE_SPACE}+"space"
APP_RESPONSES=("application"{WHITE_SPACE}+"responses"|"app"{WHITE_SPACE}+"responses")
SCRIPTING_ADDITIONS="scripting"{WHITE_SPACE}+"additions"
//CURRENT_DATE="current"{WHITE_SPACE}+"date"
CURRENT_APPLICATION="current"{WHITE_SPACE}+"application"
CURRENT_APP="current"{WHITE_SPACE}+"app"
TEXT_ITEM_DELIMETERS="text"{WHITE_SPACE}+"item"{WHITE_SPACE}+"delimiters"
MISSING_VALUE="missing"{WHITE_SPACE}+"value"
CONSIDER_IGNORE_ATTRIBUTE=("case"|"diacriticals"|"hyphens"|"numeric"{WHITE_SPACE}+"strings"|"punctuation")

STRING_LITERAL=\"([^\"\\]|\\.)*\"
DIGITS=[0-9]+
DEC_EXPONENT=[Ee][+-]?[0-9]+
VAR_IDENTIFIER=([_a-zA-Z][a-zA-Z0-9_]*)|(\|(([^\|])|(\\\|))*[^\\]\|)
COMMENT=(("#".*)|("--".*)|(("(*"[^"*"](([^"*"]*("*"+[^"*"")"])?)*("*"+")")?))|"(*"))
//RAW_CODE=("«"[^"»"]*"»")

%%
<YYINITIAL> {
  {WHITE_SPACE}                    { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "("                              { return LPAREN; }
  ")"                              { return RPAREN; }
  "+"                              { return PLUS; }
  "-"                              { return MINUS; }
  "*"                              { return STAR; }
  "div"                            { return INT_DIV; }
  "mod"                            { return MOD; }
  "^"                              { return POW; }
  "or"                             { return LOR; }
  "and"                            { return LAND; }
  "&"                              { return BAND; }
  "not"                            { return LNOT; }
  "as"                             { return AS; }
  "'s"                             { return APS; }
  "string"                         { return STRING; }
  "class"                          { return CLASS; }
  "event"                          { return EVENT; }
  "preposition"                    { return PREPOSITION; }
  "constant"                       { return CONSTANT; }
  "list"                           { return LIST; }
  "data"                           { return DATA; }
  "reference"                      { return REFERENCE; }
  "item"                           { return ITEM; }
  "character"                      { return CHARACTER; }
  "paragraph"                      { return PARAGRAPH; }
  "word"                           { return WORD; }
  "repeat"                         { return REPEAT; }
  "any"                            { return ANY; }
  "boolean"                        { return BOOLEAN; }
  "date"                           { return DATE; }
  "file"                           { return FILE; }
  "alias"                          { return ALIAS; }
  "integer"                        { return INTEGER; }
  "number"                         { return NUMBER; }
  "point"                          { return POINT; }
  "real"                           { return REAL; }
  "record"                         { return RECORD; }
  "rectangle"                      { return RECTANGLE; }
  "specifier"                      { return SPECIFIER; }
  "text"                           { return TEXT; }
  "type"                           { return TYPE; }
  "gallons"                        { return GALLONS; }
  "litres"                         { return LITRES; }
  "liters"                         { return LITERS; }
  "quarts"                         { return QUARTS; }
  "grams"                          { return GRAMS; }
  "kilograms"                      { return KILOGRAMS; }
  "ounces"                         { return OUNCES; }
  "pounds"                         { return POUNDS; }
  "centimetres"                    { return CENTIMETRES; }
  "centimeters"                    { return CENTIMETERS; }
  "feet"                           { return FEET; }
  "inches"                         { return INCHES; }
  "kilometres"                     { return KILOMETRES; }
  "kilometers"                     { return KILOMETERS; }
  "metres"                         { return METRES; }
  "meters"                         { return METERS; }
  "miles"                          { return MILES; }
  "yards"                          { return YARDS; }
  "the"                            { return THE_KW; }
  "does"                           { return DOES; }
  "that"                           { return THAT; }
  "its"                            { return ITS; }
  "current"                        { return CURRENT; }
  "application"                    { return APPLICATION; }
  "app"                            { return APP; }
  "pi"                             { return PI_CONSTANT; }
  "minutes"                        { return MINUTES_CONSTANT; }
  "hours"                          { return HOURS_CONSTANT; }
  "days"                           { return DAYS_CONSTANT; }
  "weeks"                          { return WEEKS_CONSTANT; }
  "«"                              { return RAW_LBR; }
  "»"                              { return RAW_RBR; }
  "(*"                             { return MULTI_LINE_COMMENT_START; }
  "*)"                             { return MULTI_LINE_COMMENT_END; }
  ","                              { return COMMA; }
  "{"                              { return LCURLY; }
  "}"                              { return RCURLY; }
  ":"                              { return COLON; }
  "tell"                           { return TELL; }
  "set"                            { return SET; }
  "copy"                           { return COPY; }
  "if"                             { return IF; }
  "return"                         { return RETURN; }
  "exit"                           { return EXIT; }
  "end"                            { return END; }
  "times"                          { return TIMES; }
  "while"                          { return WHILE; }
  "until"                          { return UNTIL; }
  "with"                           { return WITH; }
  "from"                           { return FROM; }
  "to"                             { return TO; }
  "by"                             { return BY; }
  "in"                             { return IN; }
  "error"                          { return ERROR; }
  "partial"                        { return PARTIAL; }
  "result"                         { return RESULT; }
  "try"                            { return TRY; }
  "on"                             { return ON; }
  "considering"                    { return CONSIDERING; }
  "but"                            { return BUT; }
  "ignoring"                       { return IGNORING; }
  "timeout"                        { return TIMEOUT; }
  "of"                             { return OF; }
  "seconds"                        { return SECONDS; }
  "second"                         { return SECOND; }
  "transaction"                    { return TRANSACTION; }
  "use"                            { return USE; }
  "version"                        { return VERSION; }
  "importing"                      { return IMPORTING; }
  "without"                        { return WITHOUT; }
  "script"                         { return SCRIPT; }
  "false"                          { return FALSE; }
  "framework"                      { return FRAMEWORK; }
  "using"                          { return USING; }
  "terms"                          { return TERMS; }
  "then"                           { return THEN; }
  "else"                           { return ELSE; }
  "scripts"                        { return SCRIPTS; }
  "true"                           { return TRUE; }
  "machine"                        { return MACHINE; }
  "zone"                           { return ZONE; }
  "some"                           { return SOME; }
  "every"                          { return EVERY; }
  "whose"                          { return WHOSE; }
  "where"                          { return WHERE; }
  "id"                             { return ID; }
  "first"                          { return FIRST; }
  "third"                          { return THIRD; }
  "fourth"                         { return FOURTH; }
  "fifth"                          { return FIFTH; }
  "sixth"                          { return SIXTH; }
  "seventh"                        { return SEVENTH; }
  "eighth"                         { return EIGHTH; }
  "ninth"                          { return NINTH; }
  "tenth"                          { return TENTH; }
  "last"                           { return LAST; }
  "front"                          { return FRONT; }
  "back"                           { return BACK; }
  "index"                          { return INDEX; }
  "middle"                         { return MIDDLE; }
  "named"                          { return NAMED; }
  "beginning"                      { return BEGINNING; }
  "thru"                           { return THRU; }
  "through"                        { return THROUGH; }
  "before"                         { return BEFORE; }
  "after"                          { return AFTER; }
  "behind"                         { return BEHIND; }
  "property"                       { return PROPERTY; }
  "prop"                           { return PROP; }
  "global"                         { return GLOBAL; }
  "local"                          { return LOCAL; }
  "space"                          { return SPACE; }
  "tab"                            { return TAB; }
  "linefeed"                       { return LINEFEED; }
  "quote"                          { return QUOTE; }
  "anything"                       { return ANYTHING; }
  "parent"                         { return PARENT; }
  "it"                             { return IT; }
  "me"                             { return ME; }
  "about"                          { return ABOUT; }
  "above"                          { return ABOVE; }
  "against"                        { return AGAINST; }
  "around"                         { return AROUND; }
  "at"                             { return AT; }
  "below"                          { return BELOW; }
  "beneath"                        { return BENEATH; }
  "beside"                         { return BESIDE; }
  "between"                        { return BETWEEN; }
  "for"                            { return FOR; }
  "into"                           { return INTO; }
  "onto"                           { return ONTO; }
  "over"                           { return OVER; }
  "since"                          { return SINCE; }
  "under"                          { return UNDER; }
  "run"                            { return RUN; }
  "open"                           { return OPEN; }
  "given"                          { return GIVEN; }
  "continue"                       { return CONTINUE; }
  "activate"                       { return ACTIVATE; }
  "launch"                         { return LAUNCH; }
  "put"                            { return PUT; }
  "count"                          { return COUNT; }
  "each"                           { return EACH; }
  "get"                            { return GET; }
  "log"                            { return LOG; }
  "returning"                      { return RETURNING; }
  "my"                             { return MY; }

  {NLS}                            { return NLS; }
  {STARTS_BEGINS_WITH}             { return STARTS_BEGINS_WITH; }
  {ENDS_WITH}                      { return ENDS_WITH; }
  {DOES_NOT_CONTAIN}               { return DOES_NOT_CONTAIN; }
  {IS_IN}                          { return IS_IN; }
  {IS_NOT_IN}                      { return IS_NOT_IN; }
  {IS_CONTAIN}                     { return IS_CONTAIN; }
  {GT}                             { return GT; }
  {LE}                             { return LE; }
  {GE}                             { return GE; }
  {LT}                             { return LT; }
  {NE}                             { return NE; }
  {EQ}                             { return EQ; }
  {REF_OP}                         { return REF_OP; }
  {DIV}                            { return DIV; }
  {STYLED_TEXT}                    { return STYLED_TEXT; }
  {TEXT_ITEM}                      { return TEXT_ITEM; }
  {FILE_SPECIFICATION}             { return FILE_SPECIFICATION; }
  {INTERNATIONAL_TEXT}             { return INTERNATIONAL_TEXT; }
  {UNICODE_TEXT}                   { return UNICODE_TEXT; }
  {RGB_COLOR}                      { return RGB_COLOR; }
  {STYLED_CLIPBOARD_TEXT}          { return STYLED_CLIPBOARD_TEXT; }
  {LOCATION_SPECIFIER}             { return LOCATION_SPECIFIER; }
  {TEMPERATURE}                    { return TEMPERATURE; }
  {CUBIC_VOL}                      { return CUBIC_VOL; }
  {SQUARE_AREA}                    { return SQUARE_AREA; }
  {BUILT_IN_TYPE_S}                { return BUILT_IN_TYPE_S; }
  {QUOTED_FORM}                    { return QUOTED_FORM; }
  {BUILT_IN_PROPERTY}              { return BUILT_IN_PROPERTY; }
  {APART_FROM}                     { return APART_FROM; }
  {ASIDE_FROM}                     { return ASIDE_FROM; }
  {OUT_OF}                         { return OUT_OF; }
  {INSTEAD_OF}                     { return INSTEAD_OF; }
  {C_WHITE_SPACE}                  { return C_WHITE_SPACE; }
  {APP_RESPONSES}                  { return APP_RESPONSES; }
  {SCRIPTING_ADDITIONS}            { return SCRIPTING_ADDITIONS; }
  {CURRENT_APPLICATION}            { return CURRENT_APPLICATION; }
  {CURRENT_APP}                    { return CURRENT_APP; }
  {TEXT_ITEM_DELIMETERS}           { return TEXT_ITEM_DELIMETERS; }
  {MISSING_VALUE}                  { return MISSING_VALUE; }
  {CONSIDER_IGNORE_ATTRIBUTE}      { return CONSIDER_IGNORE_ATTRIBUTE; }
  {STRING_LITERAL}                 { return STRING_LITERAL; }
  {DIGITS}                         { return DIGITS; }
  {DEC_EXPONENT}                   { return DEC_EXPONENT; }
  {VAR_IDENTIFIER}                 { return VAR_IDENTIFIER; }
  {COMMENT}                        { return COMMENT; }
//  {RAW_CODE}                       { return RAW_CODE; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
