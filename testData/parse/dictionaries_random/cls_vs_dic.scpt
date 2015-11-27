run script diskLocalRef

repeat with i from len to 1 by -1
  set path to ((text items 1 thru i of item_) as text) & ":"
  if path is in expandedPathTo then
    repeat with idx from 1 to (length of expandedPathTo)
      if (item idx of expandedPathTo) = path then
        set refFldr to "path to " & (item_idx of pathToSpec) as text
        set diskLocalRef to ("alias " & ("(" & "(" & refFldr & " as text) & ") & "\"" & ass (*(text items (i + 1) thru -1 of item_)*) as text) & "\")"
        try
          run script diskLocalRef
        on error
          set refFldr to refFldr & " from user domain"
          set diskLocalRef to ("alias " & ("(" & "(" & refFldr & " as text) & ") & "\"" & ass (*(text items (i + 1) thru -1 of item_)*) as text) & "\")"
          try
            run script diskLocalRef
          on error er
            error er
          end try
        end try
        return diskLocalRef

      end if
    end repeat
  end if
end repeat

make new mailbox with properties {name:"* items to store"}

exists mailbox "* items to store"
exists mailbox
tell application "Mail"
  exists mailbox "sdsd"
  get outgoing message
  get mailbox "sdsd"
  get mailbox of outgoing message
  get mailbox named "sdsd"
  get (hghg) of mailbox ""
  (hghg of mailbox "")
  message id
  message id of dldl
  delete ((some message whose message id is theTempID) of mailbox "* items to shift")

  exists --process "Mail"
  --if not (exists process "Mail") then ddd

end tell

--((some message whose message id is theTempID) of mailbox "* items to shift")--mailbox is parsed as a property (not a class)

--delete ((some message whose message id is theTempID) of mailbox "* items to shift")
exists process "Mail"
process
--if not (exists process "Mail") then exit repeat --process class is lot loaded

tell application "Mail"
--  if not (exists process "Mail") then exit repeat
end tell

try
  tell application "System Events" to set pid to the unix id of process The_app as Unicode_text
  do shell script "kill " & pid
on error
end try

