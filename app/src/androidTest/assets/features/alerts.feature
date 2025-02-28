Feature: Alerts Screen
  Some tests for Alerts Screen

 Scenario: Open yes/no alert
    Given I am in demo
    When I tap on alerts
      And I am in alerts
      And I tap on Show Yes/No alert
    Then button yes and no appear

 Scenario: Open yes/no alert and tap yes
   Given I am in demo
   When I tap on alerts
      And I am in alerts
      And I tap on Show Yes/No alert
      And button yes and no appear
      And I tap on yes
   Then yes tapped text appears

  Scenario: Open yes/no alert and tap no
    Given I am in demo
    When I tap on alerts
      And I am in alerts
      And I tap on Show Yes/No alert
      And button yes and no appear
      And I tap on no
    Then no tapped text appears

 Scenario: Show color options
   Given I am in demo
   When I tap on alerts
      And I am in alerts
      And I tap on Show color options
      And options green, red and yellow  appear
      And I tap on green
   Then green tapped text appears
