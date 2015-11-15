use AppleScript version "2.5"
use scripting additions
use framework "Foundation"
use framework "EventKit"

-- lazy way to specify calender
tell application "Calendar"
  set calId to uid of calendar 1 whose name is "Work"
end tell
set timeNow to current date
set timeInAnHour to timeNow + 3600
set eventId to my createEventStartingAt:timeNow endingAt:timeInAnHour allDay:false theSummary:"Test event" calendarID:calId inLocation:"Backyard" withDescription:"Some notes here"

on createEventStartingAt:startDate endingAt:endDate allDay:allDayFlag theSummary:theTitle calendarID:calId inLocation:theLocation withDescription:theNotes
-- create event store and get the OK to access Calendars
  set theEKEventStore to current application's EKEventStore's alloc()'s init()
  theEKEventStore's requestAccessToEntityType:0 completion:(missing value)

  -- check if app has access; this will still occur the first time you OK authorization
  set authorizationStatus to current application's EKEventStore's authorizationStatusForEntityType:0
  if authorizationStatus is not 3 then
    display dialog "Access must be given in System Preferences" & linefeed & "-> Security & Privacy first." buttons {"OK"} default button 1
    tell application "System Preferences"
      activate
      tell pane id "com.apple.preference.security" to reveal anchor "Privacy"
    end tell
    error number -128
  end if
  -- get calendar
  set theCal to theEKEventStore's calendarWithIdentifier:calId
  -- make new event
  set newEvent to current application's EKEvent's eventWithEventStore:theEKEventStore
  newEvent's setTitle:theTitle
  newEvent's setAllDay:allDayFlag
  newEvent's setLocation:theLocation
  newEvent's setNotes:theNotes
  newEvent's setStartDate:startDate
  newEvent's setEndDate:endDate
  newEvent's setCalendar:theCal
  -- save event
  set {theResult, theError} to theEKEventStore's saveEvent:newEvent span:0 commit:true |error|:(reference)
  if not theResult as boolean then error (theError's localizedDescription() as text)
  -- return the Calendar.app AS id
  return newEvent's calendarItemExternalIdentifier() as string
end createEventStartingAt:endingAt:allDay:theSummary:calendarID:inLocation:withDescription:

use scripting additions
use framework "Foundation"
use framework "EventKit"

set theID to "374F621E-8B76-4082-8ED8-C8CECD5C6E5B"
set calTitle to "Home"
--its deletEventWithID:theID inCalName:calTitle --todo its -> it's
it's deletEventWithID:theID inCalName:calTitle

on deletEventWithID:theID inCalName:calTitle
-- create event store and get the OK to access Calendars
  set theEKEventStore to current application's EKEventStore's alloc()'s init()
  theEKEventStore's requestAccessToEntityType:0 completion:(missing value)

  -- check if app has access; this will still occur the first time you OK authorization
  set authorizationStatus to current application's EKEventStore's authorizationStatusForEntityType:0 -- work around enum bug
  if authorizationStatus is not 3 then
    display dialog "Access must be given in System Preferences" & linefeed & "-> Security & Privacy first." buttons {"OK"} default button 1
    tell application "System Preferences"
      activate
      tell pane id "com.apple.preference.security" to reveal anchor "Privacy"
    end tell
    error number -128
  end if

  -- get events matching ID
  set theEvents to (theEKEventStore's calendarItemsWithExternalIdentifier:theID)
  -- Calendars.app uses non-uique IDs, so there may be more than one; in this case filter by calendar
  if (count of theEvents) > 1 then
    set theNSPredicate to current application's NSPredicate's predicateWithFormat_("calendar.title == %@", calTitle)
    set theEvents to theEvents's filteredArrayUsingPredicate:theNSPredicate
  end if
  -- do the deletion(s)
  repeat with anEvent in theEvents
    (theEKEventStore's removeEvent:anEvent span:1 commit:true |error|:(missing value))
  end repeat
end deletEventWithID:inCalName: