Feature: To-Do Page
  This feature to verify features on To-Do

  Scenario:Verify Overdue To-Dos: AUV-761
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | lead.auditorthuan@vietnam-software.org | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement2 GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement2 GP02"
    And I click on expand arrow icon
    Then I see 0 in Overdue To-Dos field

  Scenario:Verify Outstanding To-Dos: AUV-763
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | lead.auditorthuan@vietnam-software.org | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement2 GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement2 GP02"
    And I click on expand arrow icon
    Then I see 0 in OutStanding To-Dos field

  Scenario:Verify Overdue Documents: AUV-766
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | lead.auditorthuan@vietnam-software.org | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement2 GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement2 GP02"
    And I click on expand arrow icon
    Then I see 0 in Overdue Documents field

  Scenario:Verify Outstanding Documents: AUV-768
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | lead.auditorthuan@vietnam-software.org | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement2 GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement2 GP02"
    And I click on expand arrow icon
    Then I see 0 in OutStanding Documents field