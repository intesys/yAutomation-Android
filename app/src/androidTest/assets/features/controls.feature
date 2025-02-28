Feature: Controls Section
  Some tests for Controls Section

  Scenario: Switch is working
    Given I am in demo
    When I tap on controls
      And I am in controls
      And switch is off
    Then I tap on the switch
      And switch is on

  Scenario: Slider change value
    Given I am in demo
    When I tap on controls
      And I am in controls
      And I move slider to 50
    Then The shown value is 50