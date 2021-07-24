Feature: Remove Todo
  Scenario:Remove a Todo
    Given I navigate to the todo page in 3 implementations
    When I create 3 todos and delete one of them
    Then I can see that there are only 2 todos left and that my todo is not present anymore
