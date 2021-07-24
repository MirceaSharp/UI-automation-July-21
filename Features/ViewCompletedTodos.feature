Feature: View Completed Todos
  Scenario:View the completed todos
    Given I navigate to the todo page in all 3 implementations
    When I create 3 todos and change the view to completed
    Then I can see that there are no todos shown
    And I can see that the site shows 3 items left
    When I change the view back to All then complete 2 todos and change the view back to completed todos
    Then I can see that only the completed todos are shown
    And I can see that the site shows 1 item left
