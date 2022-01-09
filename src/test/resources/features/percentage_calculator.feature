@Percent
Feature: User calculating 5% values
  Scenario:User calculating 5% values
  Given User is on percentage calculator page
  Then User should see the following calculations
    |100|5|
    |500|25|
    |1300|65|
    |2100|105|
  Then user closed driver.