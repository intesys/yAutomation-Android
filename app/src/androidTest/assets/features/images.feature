Feature: Images Section
  Some tests for Images Section

  Scenario: Image section has 2 images
    Given I am in demo
    When I tap on images
      And I am in images
    Then There is at least 1 image
      And There are 2 images