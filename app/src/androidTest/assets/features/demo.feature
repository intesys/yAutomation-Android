Feature: Demo Screen
  Some tests for Demo Screen

  Scenario: Navigation to Form
    Given I am in demo
    When I tap on form
    Then I am in form

  Scenario: Navigation to List
    Given I am in demo
    When I tap on list
    Then I am in list

  Scenario: Navigation to Images
    Given I am in demo
    When I tap on images
    Then I am in images

  Scenario: Navigation to Controls
    Given I am in demo
    When I tap on controls
    Then I am in controls

  Scenario: Navigation to Pickers
    Given I am in demo
    When I tap on pickers
    Then I am in pickers

  Scenario: Navigation to Date Pickers
    Given I am in demo
    When I tap on date pickers
    Then I am in date pickers

  Scenario: Navigation to Alerts
    Given I am in demo
    When I tap on alerts
    Then I am in alerts

#  Scenario Outline: All navigations from demo
#    Given I am in demo
#    When I tap on "<section>"
#    Then I am in "<section>"
#    Examples:
#    | section        |
#    | form           |
#    | list           |
#    | images         |
#    | controls       |
#    | pickers        |
#    | date pickers   |
#    | alerts         |

  Scenario: Title is visible
    Given I am in demo
    Then Title Demo BDD is visible
      And Text containg Demo is visible