
Feature: Church database scraoing
  
  Scenario Outline: Search for sports details and record it
    Given User opens website
    When User verifies title
    And User clicks Find a place to play
    And User waits for some time
    And User enters "<zip>"
    And User waits for some time
    And User selects first sport
    And User selects 50 Miles in the Radius Dropdown Box
    And User clicks Go button
    And User waits for some time
    Then User verifies result
    And User waits for some time
    And User collects data and records it
    Then User closes browser
    

    Examples: 
      | zip  | 
      | 20109 |
