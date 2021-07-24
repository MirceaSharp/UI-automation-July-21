Feature: Create Todo
  Scenario:Create a Todo
    Given I launch the chrome browser
    When I open todomvc homepage
    Then I click on the VanillaJS button
    Then I try to create a todo
    And I close google chrome

