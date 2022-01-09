Feature: Hovers page practice
  Agile Story: As a user, when I am on the hovers page,
  I should be able to hover mouse on img 1, 2, and 3, and see user information

  Scenario: Page header verification
    Given User is on hovers page
    When User hovers mouse on img1
    Then User1 should displayed
    When User hovers mouse on img2
    Then User2 should displayed
    When User hovers mouse on img3
    Then User3 should displayed