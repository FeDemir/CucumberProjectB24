@cloudtables

  Feature: DDT example with Cloudtables

    Scenario Outline: Adding multiple users to the tables

      Given  User is on cloudtables homepage
      When User enters "<firstname>" to firstname field
      And User enters "<lastname>" to lastname field
      And User enters "<position>" to position field
      And User enters "<salary>" to salary field
      And User clicks on create button

      Examples:

      |firstname|lastname|position|salary|
      |Janina |Romanenko  |SDET               |105000|
      |Nisso  |Umarbaeva  |Automation Engineer|115000|
      |Kamila |Salehova   |Developer          |130000|
      |Fahima |Eldarrat   |UI Developer       |125000|
      |Ferhat |Demir      |Devops Architect   |160000|

