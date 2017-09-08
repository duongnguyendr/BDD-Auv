Feature: Login Feature - super admin
  This feature deals with the login functionalities of the applications.

  Scenario: Login with correct username and password in Pass.
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | qatest01@auvenir.com  | P@ssword123 |
    And I click on login button
    Then I should see the AdminPortal page