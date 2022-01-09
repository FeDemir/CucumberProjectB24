@test
@regression
  @Dice
Feature: Dice job search
  As a user, I should be able to search for jobs using a keyboard and zipcode, then see results.

Scenario: User searches for a job
  Given User is on dice homepage
  When User enters keyboard and zipcode
  Then User should see search results
