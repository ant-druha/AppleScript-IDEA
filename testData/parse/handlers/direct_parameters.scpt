on run argv
return "hello, " & item 1 of argv & "."
end run

on run {input, parameters}
set upperCaseString to ""
repeat with i in input
  if (ASCII number i) > 96 and (ASCII number i) < 123 then
    set upperCaseString to upperCaseString & (ASCII character ((ASCII number i) - 32))
  else
    set upperCaseString to upperCaseString & (ASCII character (ASCII number i))
  end if
end repeat

return upperCaseString
end run