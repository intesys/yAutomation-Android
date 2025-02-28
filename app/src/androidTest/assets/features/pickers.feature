Feature: Pickers Section
  Some tests for Pickers Section

  Scenario: Spinner select the color
    Given I am in demo
    When I tap on pickers
      And I am in pickers
      And I set spinner to blue
    Then number picker value is blue
      And you selected field is blue

  Scenario: NumberPicker select the color
    Given I am in demo
    When I tap on pickers
    And I am in pickers
    And I set number picker to blue
    Then spinner value is blue
    And you selected field is blue