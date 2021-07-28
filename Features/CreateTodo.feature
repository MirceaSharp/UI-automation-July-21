Feature: Create Todo
  Scenario:Create a Todo
    Given I navigate to the todo page in 3 versions
    When I create one todo in each page
    Then I verify that there is only one todo and that the text on the page is Automation is fun
