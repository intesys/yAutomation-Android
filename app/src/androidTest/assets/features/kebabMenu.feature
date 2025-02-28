Feature: Kebab Menu
  Some tests for Kebab Menu in Navigation Bar

  Scenario: Kebab menu item 1 action
    Given I am in demo
    When I tap on kebab menu
      And I tap on item 1
    Then Snackbar with item 1 appear

  Scenario: Kebab menu item 2 action
    Given I am in demo
    When I tap on kebab menu
      And I tap on item 2
    Then Snackbar with item 2 appear

  Scenario: Kebab menu item 3 action
    Given I am in demo
    When I tap on kebab menu
      And I tap on item 3
    Then Snackbar with item 3 appear
