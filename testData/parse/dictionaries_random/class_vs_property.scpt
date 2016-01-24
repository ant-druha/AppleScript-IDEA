tell application "Mail"
  set theTempID to 123
  get message id
  message id
  message id of dldl --'message id' is a property: correct
  message whose message id is theTempID
  should copy message
end tell

do shell script
