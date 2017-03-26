tell application "Microsoft PowerPoint"
--document property
  property effect
  property effect
  properties

  get animate level second level
  get animate level third level
  get autoshape flowchart summing junction
  set color for
  get slide range -- todo class is not detected
  property set effect
  --  document property
  --  custom character wrap
  get action setting for
  display dialog
end tell

close
on run
--        tell application id "com.microsoft.PowerPoint" --wrong fictionary added (for Ms Word ;( )
--end tell
  tell application "Microsoft PowerPoint"
    activate

    tell active window
      tell it's presentation
        document window
        document property --illegal statement, acually
        document
        --document property not detected as class, but detected as document only
        get link source as text
        if value of document property "keywords" = "Fish" then
          set value of document property "keywords" to "Chips"
        else
          set value of document property "keywords" to "Fish"
        end if
        if value of custom document property "LTWProp" = "NO" then
          set value of custom document property "LTWProp" to "YES"
        else
          set value of custom document property "LTWProp" to "NO"
        end if

      end tell
    end tell
  end tell
end run

