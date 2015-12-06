package com.idea.plugin.applescript;

/**
 * Andrey 04.05.2015
 */
public class AppleScriptNames {

  public static final String UNNAMED_ELEMENT = "<unnamed>";

  //For just for debugging purposes for now will declare names here
  //todo parsing dictionary for names
  public static final String[] SCRIPTING_ADDITION_COMMAND_NAMES = {"moving folder window for", "round"
//          ,"get", "error", "run",
//          "count", "round", "mount " +
//          "volume", "do shell script"/*!"script"!*/, "display dialog", "make new", "exists", "system attribute",
//          "system info",
//          "localized string", "open location", "ein zwei polizei", "path to"
  };

  //taken from scripting additions
  public static final String[] SCRIPTING_ADDITION_CLASSES_PROPERTY_NAMES = {};

  public static final String[] PARSED_SCRIPT_OBJECTS_PROPERTIES = {"creation datte", "startup disk",
          "message id", "creation date", "home folder", "case sensitive", "command down", "shift down", "POSIX path",
          "applications folder", "modification date", "text body", "altering line endings", "quoted form"};

  public static final String[] PARSED_COMMAND_PARAMETER_NAMES = {"opening window", "with properties", "to",
          "altering line endings", "buttons", "from", "with title"};

  public static final String[] PARSED_CLASS_NAMES = {"word", "file", "application"};

  public static boolean isIdentifierStart(char c){
    //    r = Character.isLetter(c) || c == '|';
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '|';
  }
}
