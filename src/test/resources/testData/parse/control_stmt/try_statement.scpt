-- try full statement (err is a formal parameter)
-- === example 1
set fileName to "Generic Prefs" -- Use if no filename chosen.
try
  choose file -- Ask user to choose a file.
  -- If the user cancels, the next statement won't be executed.
  set fileName to result
on error errText number errNum
  if (errNum is equal to -128) then -- User cancelled.
    display dialog "No file chosen. Use the default file?"
    if button returned of result is equal to "OK" then
      display dialog "The script will continue " & ¬
                "using the default file \"" & fileName & "\"."
    end if
  else
  -- If any other error, do nothing.
  end if
end try
-- === example 2
try
  repeat with i from 1 to "Toronto"
  -- do something that depends on variable "i"
  end repeat
on error from obj to newClass
  log {obj, newClass} -- Display from and to info in log pane.
end try
-- === example 3
try
  open for access file "MyFolder:AddressData" with write permission
on error msg number n from f to t partial result p
  if n = -49 then -- File already open error
    display dialog "I'm sorry but the file is already open."
  else
    error msg number n from f to t partial result p
  end if
end try

--try simplified statement (only one errro nubmet is handled)
-- === example 1
try
  display alert "Hello" buttons {"Cancel", "Yes", "No"} cancel button 1
on error number -128
-- Either do something special to handle Cancel, or just ignore it.
end try
-- === example 2
try
  open for access file "MyFolder:AddressData" with write permission
on error number -49
display dialog "I'm sorry but the file is already open."
end try