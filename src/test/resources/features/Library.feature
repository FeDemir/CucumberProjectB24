@Library
Feature: Login
  As I user, I should be able to login

  Scenario Outline: Login as a librarian
    Given I am on the login page
    When I login as a librarian with "<username>" and "<password>"
    Then dashboard should be displayed
    Examples:
      |username             |password |
      |librarian14@library  |Sdet2022*|
      

  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then dashboard should be displayed