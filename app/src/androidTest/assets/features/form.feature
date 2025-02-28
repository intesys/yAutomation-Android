Feature: Form Section
  Some tests for Form section

  Scenario: Insert and save data
    Given I am in demo
    When I tap on form
      And I input firstname
      And I input lastname
      And I input phone number
      And I tap on save button
    Then A loading appear
      And A dialog with title Alert Title appear