Feature: Date Pickers Section
  Some tests for Date Pickers Section

  Scenario: Date Picker set to a specific date update the dates of button and "date is" field
    Given I am in demo
    When I tap on date pickers
      And I am in date pickers
      And I set datePicker to 18 January 2024
    Then button date picker value is 18 January 2024
      And date is field date is 18 January 2024

  Scenario: Date Picker dialog set to a specific date update the dates of datePicker and "date is" field
    Given I am in demo
    When I tap on date pickers
      And I am in date pickers
      And I set date picker dialog to 18 January 2024
    Then button date picker value is 18 January 2024
      And date picker value is 18 January 2024
      And date is field date is 18 January 2024

