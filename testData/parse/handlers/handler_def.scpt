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
  get calendar
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

end createEventStartingAt:endingAt:allDay:theSummary:calendarID:inLocation:withDescription: