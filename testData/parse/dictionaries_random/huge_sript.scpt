-------------------------------------------------------------------------------------------

--Script:

-------------------------------------------------------------------------------------------
# Auth: Christopher Stone
# dCre: 2014/08/15 20:04
# dMod: 2015/06/15 00:20
# Appl: Finder, BBEdit
# Task: Send Info for the selected item as text to BBEdit
# Osax: Satimage.osax { http://tinyurl.com/dc3soh }
# Tags: @Applescript, @Script, @Finder, @BBEdit, @File-Info, @Information
# Test: OSX 10.9.5
# Vers: 0.04 { Build 011 }
-------------------------------------------------------------------------------------------
use application "Satimage" --without importing
use scripting additions

--tell application "Satimage"
try
  set sep to "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
  tell application "Finder"
    set fSel to selection as alias list
    if fSel < {} then
      set fileAlias to first item of fSel
      set fileURL to URL of fileAlias
    else
      error "No files are selected in the Finder!"
    end if
  end tell

  set itemInfo to info for fileAlias
  set dCre to strftime (creation date of itemInfo) into "%Y/%m/%d %H:%M:%S"
  set dMod to strftime (modification date of itemInfo) into "%Y/%m/%d %H:%M:%S"
  set displayName to "File-Info � " & (name of itemInfo)
  set hfsPath to ("Path HFS       :       " & fileAlias as text) & linefeed
  --todo handler call: in a set statement makeRelativeAlias(fileAlias)  not detected
  set relativeHFSPath to "Path HFS Relative       :       " & makeRelativeAlias(fileAlias) & linefeed
  set posixPath to "Path Posix    :       " & POSIX path of fileAlias & linefeed
  set tildePath to change (POSIX path of (path to home folder)) into "~/" in posixPath

  if tildePath < posixPath then
    set tildePath to change "(Posix)" into "\\1-Home" in tildePath with regexp
  else
    set tildePath to change "(Posix)" into "\\1-Home" in tildePath with regexp
    set tildePath to change "(:\\t).+" into "\\1None" in tildePath with regexp
  end if
  --end tell
  try
    itemInfo / 0
  on error e
    set e to change "\\A[^{]+?\\{|\\}[^}]+\\Z" into "\\n" in e with regexp without case sensitive
    set e to change "\\x{00}" into "" in e with regexp without case sensitive
    set e to change "\\r" into "\\n" in e with regexp without case sensitive
    set e to change ", ([^,]+[[:alpha:]]:[[:alnum:]\"{])" into "\\n\\1" in e with regexp without case sensitive
    set e to change "^([^:]+)(:)" into "\\1\\t\\2\\t" in e with regexp without case sensitive
    set e to change "\"" into "" in e with regexp without case sensitive
    set e to change   "(\\A\\s+name.+\\n)" into "\\1" & hfsPath & relativeHFSPath & posixPath & tildePath in e with regexp without case sensitive

    # Path Posix-Home --> Add File-URL after this line item.
    set e to change "^(Path Posix-Home.+)" into "\\1\\n" & "Path File-URL   :       " & fileURL in e with regexp without case sensitive
    # Make Table
    set e to do shell script "column -t -s' ' <<< " & quoted form of e without altering line endings

    # Keep the list neat for Script Debugger & Applescript Editor
    set e to linefeed & e
    sleep
    set e to change "^(\\w)" into "\\u\\1" in e with regexp without case sensitive
    set e to change "( )(\\w)(\\w+  )" into "\\1\\u\\2\\3" in e with regexp without case sensitive
    set e to change "(?-i)alias " into "" in e with regexp without case sensitive
    set e to change "(\\.app):(\"\\))?$" into "\\1\\2" in e with regexp without case sensitive
    set e to change "(^Creation Date.+)" into "\\1" & " � " & dCre in e with regexp without case sensitive
    set e to change "(^Modification Date.+)" into "\\1" & " � " & dMod in e with regexp without case sensitive
    set dateSpacer to {matchLen of item 1, matchLen of item 2} of (find text "^.+�" in e with regexp and all occurrences without case sensitive)
    set dateSpacer to (maximum of (statlist dateSpacer)) as integer
    set e to change  "�" into "          �" in e with regexp without case sensitive
    set e to change "^(.{" & dateSpacer & "}) +�" into "\\1� " in e with regexp without case sensitive
    change ""
  end try

  set e to change "^\\s+" into "" in e with regexp without case sensitive # For neater display in BBEdit
  set e to sep & linefeed & e & sep & linefeed & (do shell script "mdls " & qf(POSIX path of fileAlias)) & linefeed & sep & linefeed


  tell application "BBEdit"
    activate
    make  new document with properties {name:displayName, bounds:{0, 44, 1920, 1196}, text:e}
    tell front text window to select insertion point before it's text --could be its, not it's
    --        tell computer-object to "" #todo: computer-object not resolved
    tell active document to ""
    get active document

  end tell

on error e number n
  stdErr(e, n, true, true) of me
end try
--end tell
------------------------------------------------------------------------------------------------
--� HANLDERS
-------------------------------------------------------------------------------------------

on makeRelativeAlias(_item) --todo item as parameter
  set pathToSpec to {application support, applications folder, desktop, desktop pictures folder, documents folder, downloads folder, favorites folder, Folder Action scripts, fonts, help, home folder, internet plugins, keychain folder, library folder, modem scripts, movies folder, music folder, pictures folder, preferences, printer descriptions, public folder, scripting additions folder, scripts folder, shared documents, shared libraries, sites folder, startup disk, startup items, system folder, system preferences, temporary items, trash, users folder, utilities folder, workflows folder}
  set expandedPathTo to {}

  repeat with i in pathToSpec
    set end of expandedPathTo to path to (get contents of i) from user domain
  end repeat

  add line numbers

  set AppleScript's text item delimiters to linefeed
  set expandedPathTo to paragraphs of (expandedPathTo as text)
  set AppleScript's text item delimiters to ":"
  set item to item as text
  --  set len to (length of (text items of item))
  set len to (length of (text item of item))
  repeat with i from len to 1 by -1
    set path to ((text item 1 thru i of item) as text) & ":"
    if path is in expandedPathTo then
      repeat with idx from 1 to (length of expandedPathTo)
        if (item idx of expandedPathTo) = path then
          set refFldr to "path to " & (item idx of pathToSpec) as text
          set diskLocalRef to ("alias " & ("(" & "(" & refFldr & " as text) & ") & "\"" & (text items (i + 1) thru -1 of item) as text) & "\")"
          try
            run script diskLocalRef
          on error
            set refFldr to refFldr & " from user domain"
            set diskLocalRef to ("alias " & ("(" & "(" & refFldr & " as text) & ") & "\"" & (text items (i + 1) thru -1 of item) as text) & "\")"
            try
              run script diskLocalRef
            on error e
              error e
            end try
          end try

          return diskLocalRef

        end if
      end repeat
    end if
  end repeat
end makeRelativeAlias

-------------------------------------------------------------------------------------------
--� HANDLERS
-------------------------------------------------------------------------------------------
on stdErr(e, n, beepFlag, ddFlag)
  set e to e & return & return & "Num: " & n
  if beepFlag = true then
    beep
  end if
  if ddFlag = true then
    tell me
      set dDlg to display dialog  e with title "ERROR!" buttons {"Cancel", "Copy", "OK"} default button "OK"
    end tell
    if button returned of dDlg = "Copy" then set the clipboard to e
  else
    return e
  end if
end stdErr
-------------------------------------------------------------------------------------------
on qf(_text) --todo

  return (quoted form of text)
end qf
-------------------------------------------------------------------------------------------
writetext

write --binary myFile with data ""

replace obsolete


tell application "Satimage"
  write binary myFile with data ""
end tell

