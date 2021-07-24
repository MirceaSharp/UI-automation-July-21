Feature: Complete Todo
  Scenario:Complete a Todo
    Given I navigate to the todo page
    When I create 3 todos and mark the last one as completed
    Then I can see that the last todo is in fact completed
    And the number of completed todos is 1
