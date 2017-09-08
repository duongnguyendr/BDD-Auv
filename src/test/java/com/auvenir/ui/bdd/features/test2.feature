Feature: Login Feature - admin
  This feature deals with the login functionalities of the applications.

  Scenario: Login with correct username and password in Pass.
    Given I navigate to login page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | qatest02@auvenir.com  | P@ssword123 |
    And I click on login button
    Then I should see the home page