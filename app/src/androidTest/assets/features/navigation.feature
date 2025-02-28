Feature: App navigation
  Some tests for navigation in app

  Scenario: Bottom bar is visible
    Given I am in demo
    Then Bottom bar home is visible
      And Bottom bar info is visible
      And Bottom bar credits is visible

  Scenario: Bottom bar info
    Given I am in demo
    When I tap on info
    Then I am in info

  Scenario: Bottom bar credits
    Given I am in demo
    When I tap on credits
    Then I am in credits

  Scenario: Bottom bar home (from credits)
    Given I am in demo
    When I tap on credits
      And I tap on home
    Then I am in demo

  Scenario: Bottom bar home (from info)
    Given I am in demo
    When I tap on info
      And I tap on home
    Then I am in demo