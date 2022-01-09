@Etsy #This is a comment tag

Feature: User Etsy Search
  As a user, when I search for item, I should see teh results.
  @smoke @regression
  Scenario: User search for wooden spoon
    Given user is on etsy homepage
    Then Page title should be as expected
    When User searches for wooden spoon
    Then Page title should start with wooden spoon
  @regression
  Scenario: User empty search
    Given user is on etsy homepage
    Then Page title should be as expected
    When User searches for empty value
    Then All categories should displayed

  Scenario Outline: Data driven test
    Given user is on etsy homepage
    Then Page title should be as expected
    And User searches for "<itemName>"
    Then User should find at least "<expectedResult>" items
    Examples:
      | itemName     | expectedResult |
      | Wooden spoon | 100            |
      | Apple        | 1000           |