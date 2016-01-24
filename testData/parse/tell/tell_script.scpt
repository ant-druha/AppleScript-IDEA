use AppleScript version "2.3.1"
use scripting additions
use framework "Foundation"
use framework "AppKit"


property textFieldOutlet: missing value
property labelOutlet: missing value
property boundProperty: "Initial state"

tell script "Dialog Toolkit"
  check for main -- make sure we are in foreground when testing
  set theLabelStrings to {"Random Text", "Random Text", "Even more randome text"}
  set maxLabelWidth to max width for labels theLabelStrings
  set controlLeft to maxLabelWidth + 6
  set {labelOutlet, theTop, newWidth} to create label " total per queue." left inset 0 bottom (0 + 8) max width 250 aligns "left" without multiline
end tell
set theOptions to current application's NSDictionary's dictionaryWithObjects:{true, "No entry"} forKeys:{current application's NSContinuouslyUpdatesValueBindingOption, current application's NSNullPlaceholderBindingOption}
labelOutlet's bind:(current application's NSValueBinding) toObject:me withKeyPath:"boundProperty" options:theOptions

tell script "Dialog Toolkit"
  set {textFieldOutlet, textFieldLabel, theTop, fieldLeft} to create side labeled field "the field" placeholder text "Stop ID" left inset 0 bottom (theTop + 8) total width 250 label text "textFieldOutlet" field left controlLeft
end tell

textFieldOutlet's bind:(current application's NSValueBinding) toObject:me withKeyPath:"boundProperty" options:theOptions

tell script "Dialog Toolkit"
  set allControls to {labelOutlet, textFieldLabel, textFieldOutlet}
  -- controlResults will in the same order as allControls
  set {buttonName, suppressedState, controlResults} to display enhanced alert "The main title." message "some other stuff" as informational buttons {"Cancel", "OK"} giving up after 120 acc view width 250 acc view height theTop acc view controls allControls without suppression
  log controlResults
  set {statusMessage, textFieldLabel, textFieldOutlet} to controlResults

end tell