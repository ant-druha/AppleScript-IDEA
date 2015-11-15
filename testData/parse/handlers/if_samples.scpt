if authorizationStatus is not 3 then
  --display dialog "Access must be given in System Preferences" & linefeed & "-> Security & Privacy first." buttons {"OK"} default button 1
  tell application "System Preferences"
    activate
    --tell pane id "com.apple.preference.security" to reveal anchor "Privacy"
  end tell
  error number -128
end if