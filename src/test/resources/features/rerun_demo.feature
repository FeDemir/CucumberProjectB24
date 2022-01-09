@rerun
Feature: Rerunning failed scenarios
  Scenario: one
    Given User adds two numbers
    Then result should be as expected

  Scenario: two
    Given User adds three numbers
    Then result should be sum of the three numbers

  Scenario: three
    Given User divides two numbers
    Then result should be division result

  Scenario: four
    Given User multiplies two numbers
    Then result should be multiplication result