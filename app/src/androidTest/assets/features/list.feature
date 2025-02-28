Feature: List Section
  Some tests for List Section

  Scenario: Item can be selected from list
    Given I am in demo
    When I tap on list
      And I am in list
      And I tap on an item in the list
    Then The item tapped is selected

  Scenario: Testing scroll
    Given I am in demo
    When I tap on list
      And I am in list
      And I tap on an item in the bottom
      And I scroll to top
    Then The first item is displayed

  Scenario: Search filters the list
    Given I am in demo
    When I tap on list
      And I am in list
      And I write a text in the searchbar
    Then All items contain the text