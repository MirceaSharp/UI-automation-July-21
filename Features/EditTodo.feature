Feature: Edit Todo
  Scenario:Edit a Todo
    Given I navigate to the todo list page
    When I create three todos and change the text of the second one
    Then I can see the new text in the second todo which is I used to be something else
