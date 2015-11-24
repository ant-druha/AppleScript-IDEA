use application "Satimage"
use scripting additions
try

  set _sep to "-------------------------------------------------------------------------------------------"

  tell application "Mail"
    set selMsgList to selection
    if selMsgList ≠ {} then
      set selMsg to item 1 of selMsgList
      tell selMsg
        set headers_ to all headers
        set content_ to content
        set listID to headers whose name is "List-Id"
        if length of listID = 1 then
          set listID to content of item 1 of listID
        end if
      end tell
    end if
  end tell

  set from_ to fnd("^From:.*", headers_, 0, 1) of me
  set subject_ to fnd("^Subject:.*", headers_, 0, 1) of me
  set date_ to fnd("^Date:.*", headers_, 0, 1) of me
  set to_ to fnd("^To:.*", headers_, 0, 1) of me

  if fndBool("^Reply-To:.*", headers_, 0, 1) of me ≠ false then
    set replyTo to result
  else
    set replyTo to ""
  end if

  if fndBool("^X-Sender:.*", headers_, 0, 1) of me ≠ false then
    set xSender to result
  else
    set xSender to ""
  end if

  set smallHeaders to join {subject_, from_, date_, replyTo, to_, xSender} using linefeed
  set smallHeaders to cng("^[[:blank:]]*$[\\n\\r]?", "", smallHeaders) of me
  set smallHeaders to cng("^([^:]+:) ", "\\1\\t", smallHeaders) of me
  set smallHeaders to do shell script "column -t -s'" & tab & "' <<< " & quoted form of smallHeaders without altering line endings
  set smallHeaders to cng("^([^:]+)(:)([[:blank:]]+)", "\\1\\3\\2  ", smallHeaders) of me
  set smallHeaders to stripWhiteSpaceTopBottom(smallHeaders)
  set smallHeaders to cng("^", "# ", smallHeaders) of me

  # NBS (non-breaking space) to space:
  set content_ to cng("[\\x{FFFC}\\x{A0}]", " ", content_) of me
  set content_ to cng("\\n{3,}", "\\n", content_) of me
  set content_ to cng("\\r]{3,}", "\\r", content_) of me

  if listID contains "applescript-users.lists.apple.com" then
    set content_ to rmvAsulJunk(content_)
  else if listID contains "bbedit.googlegroups.com" then
    set content_ to rmvBBeditTalkJunk(content_)
  end if

  set content_ to _sep & linefeed & smallHeaders & linefeed & _sep & linefeed & linefeed & stripWhiteSpaceTopBottom(content_)

  tell application "Script Debugger"
    activate
    set newDoc to make new document with properties {source text:content_}
    set bounds of newDoc's window to {606, 23, 1920, 1196}
  end tell

on error e number n
  stdErr(e, n, true, true) of me
end try


-------------------------------------------------------------------------------------------

--» HANDLERS

-------------------------------------------------------------------------------------------
--» FILTER HANDLERS
-------------------------------------------------------------------------------------------
on rmvAsulJunk(textData)
  set textData to cng("(?m)_______________________________________________\\n+Do not post admin.+?\\nApplescript-Users mailing list.+This email sent to listmeister@thestoneforge.com", "", textData) of me
end rmvAsulJunk
-------------------------------------------------------------------------------------------
on rmvBBeditTalkJunk(textData)
  set textData to cng("(?m)--\\s*This is the BBEdit Talk public discussion group. If you have a.+To post to this group, send email to bbedit@googlegroups.com.", "", textData) of me
end rmvBBeditTalkJunk
-------------------------------------------------------------------------------------------
on stripWhiteSpaceTopBottom(textData)
  set textData to cng("\\A\\s+|\\s+\\Z", "", textData) of me
end stripWhiteSpaceTopBottom

-------------------------------------------------------------------------------------------
--» SATIMAGE.OSAX HANDLERS
-------------------------------------------------------------------------------------------
on cng(_find, _replace, _data)
  change _find into _replace in _data with regexp without case sensitive
end cng
-------------------------------------------------------------------------------------------
on fnd(_find, _data, _all, strRslt)
  try
    find text _find in _data all occurrences _all string result strRslt with regexp without case sensitive
  on error
    return false
  end try
end fnd
-------------------------------------------------------------------------------------------
on fndBool(_find, _data, _all, strRslt)
  try
    find text _find in _data all occurrences _all string result strRslt with regexp without case sensitive
    return true
  on error
    return false
  end try
end fndBool

-------------------------------------------------------------------------------------------
--» ERROR HANDLER
-------------------------------------------------------------------------------------------
on stdErr(e, n, beepFlag, ddFlag)
  set e to e & return & return & "Num: " & n
  if beepFlag = true then
    beep
  end if
  if ddFlag = true then
    tell me
      set dDlg to display dialog e with title "ERROR!" buttons {"Cancel", "Copy", "OK"} default button "OK"
    end tell
    if button returned of dDlg = "Copy" then set the clipboard to e
  else
    return e
  end if
end stdErr
-------------------------------------------------------------------------------------------
