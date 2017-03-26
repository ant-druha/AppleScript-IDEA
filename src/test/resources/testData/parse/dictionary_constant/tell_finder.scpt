tell application "Finder"
  close every window
  open home
  tell the front Finder window
    set toolbar visible to true
    set the sidebar width to 135
    set the current view to column view --column view

    set the bounds to {36, 116, 511, 674}
  end tell
  open folder "Documents" of home
  tell the front Finder window
    set toolbar visible to false
    set the current view to flow view
    set the bounds to {528, 116, 1016, 674}
  end tell
  select the last Finder window
end tell