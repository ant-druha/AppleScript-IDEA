--Here's a script I use to wake me up in the morning:
property Reveillie: alias "MacBook Pro:Users:sjc:Documents:Development:cron:Reveille.mp3"
property sysVolMax: 100
property qtVolMax: 256
property reveilleVol: 30 -- reduce to 10 for external speakers
property logfile: "MacBook Pro:Users:sjc:Documents:Development:cron:Debug Log.txt"


get logfile

make
--use application "Finder"
use scripting additions
use application "QuickTime Player"
tell application "QuickTime Player"
  try
    set logFileID to open for access file logfile with write permission
  on error
    close access file logfile
    return
  end try

  --todo: starting at is not detected as command parameter label
  write return & "Start at: " & (current date) & return & return to logFileID starting at get eof of logFileID
  make
  -- Set System Volume
  set pctVol to reveilleVol / sysVolMax
  set saveSysVol to output volume of (get volume settings)
  display dialog "Current System Volume is " & saveSysVol
  write  "System Volume = : " & saveSysVol & return to logFileID starting at get eof of logFileID
  set volume output volume pctVol * sysVolMax
  set newSysVol to output volume of (get volume settings)
  display dialog "New System Volume is " & newSysVol
end tell
tell application "QuickTime Player"
  activate
  set theFile to open Reveillie
  set audio volume of document 1 to pctVol * qtVolMax
  play document 1
  repeat while playing of document 1
    delay 1
  end repeat
  -- display dialog "quitting"
  quit
end tell



set volume 111 output volume 123
-- Restore System Volume Settings
set volume output volume saveSysVol
write  "Stop at: " & (current date) & return & return to logFileID


--todo close access 'close access' command of std additions VS 'close' command of CocoaStandard
closing folder window for
-- close access

write ¬
"System Volume = : " & saveSysVol & return to logFileID ¬
starting at get eof of logFileID

