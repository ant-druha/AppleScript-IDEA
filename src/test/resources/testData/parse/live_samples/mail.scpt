property theBusinessName:"This is just for me."


set the_subject to "Hourly report"
set the_content to return & return & "Email to : This is just for me." & return & return & "1 am : 6 ●●●●●●◆◆◆" & return & "2 am : 4 ●●●●◆◆" & return & "3 am : 5 ●●●●●◆" & return
set textcolor to {7 * 256, 93 * 256, 5 * 256}

try
  set pathToMe to (path to applications folder) & "Mail Manager:Mail Manager.app:" as text
  set logoPath to pathToMe & "Contents:Resources:Report Logo.png" as text
  set PosixLogoPath to POSIX path of logoPath
end try
tell application "Mail"
  activate
  make
  delete
  set p to 4
  set newMessage to make new outgoing message with properties {visible:true, subject:the_subject, content:the_content}
  set p to 5
  tell content of newMessage
    try
      set y to count of the_content
      set color of characters 1 thru y to textcolor
    end try
    try
      set x to offset of my theBusinessName in the_content
      set font of characters x thru (x + (count of my theBusinessName) - 1) to "Helvetica Bold"
      set color of characters x thru (x + (count of my theBusinessName) - 1) to {56342, 2442, 607}
    end try
    try
      set x to offset of ("Hourly " & my hourCutOff & " Report" as rich text) in the_content
      if x ≠ 0 then
        set xx to count of ("Hourly " & (my hourCutOff) & " Report" as rich text)
        try
          set font of characters x thru (x + xx - 1) to "Cochin"
        end try
        set size of characters x thru (x + xx - 1) to 20
        set color of characters x thru (x + xx - 1) to {43 * 256, 0, 256 * 256 - 1}
      end if
    end try
    try
      set x to 0
      set xxx to (count of the_content)
      repeat
        set x to x + 1
        if character x of the_content = "●" then
          set xx to 0
          repeat
            set xx to xx + 1
            if character (x + xx) of the_content ≠ "●" then
              set color of characters x through (x + (xx - 1)) to {56342, 2442, 607}
              set x to x + xx
              exit repeat
            end if
          end repeat
        end if
        if character x of the_content = "◆" then
          set xx to 0
          repeat
            set xx to xx + 1
            if character (x + xx) of the_content ≠ "◆" then
              set size of characters x through (x + (xx - 1)) to 10
              set x to x + xx
              exit repeat
            end if
          end repeat
        end if
        if x ≥ xxx then exit repeat
      end repeat
    end try
  end tell
  activate
  tell newMessage
    set p to 20.1
    try
      repeat with themailitem in theCCRecipients
        set p to 20.5
        make new to recipient at end of to recipients with properties {address:themailitem}
      end repeat
    end try
    try
      set p to 20.6
      make new attachment with properties {file name:PosixLogoPath as POSIX file} at before first paragraph
    on error errmsg number errnum
      tell application "System Events" to display dialog "eMailIt setting Logo error " & errmsg & " number " & errnum
    end try
  end tell
end tell
