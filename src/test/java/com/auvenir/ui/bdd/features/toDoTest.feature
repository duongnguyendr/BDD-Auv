Feature: ToDo Feature
  This feature to verify features on ToDo page..

  Scenario: Create To-Do Category: AUV-2352
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | lead.auditorthuan@vietnam-software.org | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagementmongo GP01"
    Then I should see engagement detail page with Engagement Title Editable: "Engagementmongo GP01"
