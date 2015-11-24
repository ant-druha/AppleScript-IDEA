tell application "Mail"
  get message id -- todo not correct, should be 'message id' property
  message id -- todo: not correct: 'message' is a class, should be 'message id' property
  message id of dldl --'message id' is a property: correct
  message whose message id is theTempID --todo 'message id' is not detected as a property
  should copy message
end tell
