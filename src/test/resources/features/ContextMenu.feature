Feature: Context Click - Homework
  Scenario: User should right click on an element to see context
  When user is on Context Menu Website
  Then user right clicks to the box.
  When alert will open.
  Then user confirm alert text is "You selected a context menu"
  Then user accepts alert
