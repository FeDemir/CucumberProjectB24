Feature: Searching Lyft fare details

  As a rider , I should be able to enter pickup and drop off locations so that I can see the estimated fare

  @Regression @Lyft
  Scenario: Fare estimate using City
    Given User is on lyft fare estimate page
    When User enters "Odessa, TX, USA" to pickup address
    And User enters "Midland, TX, USA" to drop address
    And User clicks on get estimate button
    Then User should see estimated prices

  @Regression @Lyft
  Scenario: Fare estimate using fullAddress
    Given User is on lyft fare estimate page
    When User enters "4008 New Orleans Drive, Odessa, TX, USA" to pickup address
    And User enters "2755 North Grandview Avenue, Odessa, TX, USA" to drop address
    And User clicks on get estimate button
    Then User should see estimated prices

  @Regression @Lyft
  Scenario: Fare estimate using empty should show error
    Given User is on lyft fare estimate page
    When User enters "" to pickup address
    And User enters "" to drop address
    And User clicks on get estimate button
    Then User should see error message