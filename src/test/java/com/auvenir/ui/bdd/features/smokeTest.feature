Feature: Smoke Test Feature
  This feature create six role on auvenir and test some basic feature.

  Scenario: Verify super admin login.
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | chr.auvenirad@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page

  Scenario: Verify admin login.
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page

  Scenario: Verify Sign Up Auditor User.
    Given I navigate to Marketing page
    And I click sign up link
    Then I should see personal sign up page

    # Input personal information
    And I input full name text box
      | Admin Auditor |
    And I input email address
      | auvenirinfo@gmail.com |
    And I input confirm email
      | auvenirinfo@gmail.com |
    And I select role in firm
    And I input phone number
      | 1234567890 |
    And I select how to hear about Auvenir
    And I click agree with privacy and term service check box
    And I click confirm check box
    And I click continue button on sign up page
    Then I should see provide firm information page

    # Input Firm information
    And I input firm name
      | Duong Firm |
    And I input firm webside
      | titancorpvn.com |
    And I select country
      | Canada |
    And I select provide state
      | Quebec |
    And I input street address
      | 123 Hoang Van Thu |
    And I input zip code
      | K3G4P8 |
    And I input city
      | Toronto |
    And I input office number
      | 12345 |
    And I input memberId
      | 3154 |
    And I select number employee
    And I input business phone number
      | 1234567890 |
    And I check rule logo check box
    And I check on affiliate checkbox
    And I input affiliate name
      | Titan corp |
    And I click continue button on sign up page
    Then I should see thank for create account page
    And I click continue button on sign up page

  Scenario: Verify Admin Change Status User To OnBoarding
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
    Then I should see status off user is wait listed
      | auvenirinfo@gmail.com | Wait Listed |
    And I change status of user to onboarding
      | auvenirinfo@gmail.com | Onboarding |
    Then I should see confirm popup on admin page
    And I click confirm button on admin page
    Then I should see verified message successful on admin page

  Scenario: Verify Auditor Login Gmail And Active User
    Given I navigate to gmail login page
    And I signIn gmail
      | auvenirinfo@gmail.com | 12345678@Ab |
    And I open Auditor active email
    And I click on confirmation link
    And I create password
    |Changeit@123|
    Then I should see engagement page

  Scenario: Verify Admin Auditor Create Simple Engagement
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | auvenirinfo@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click create new engagement button
    Then I should see new engagement page
    And I input enagagement name
    | Engagement Dr01 |
    And I select engagement type
    | Review |
    And I select company name
    | Titan |
    And I set report deadline
    And I set start date
    And I set end date
    And I click on engagement continue button
    Then I should see team member wizard page
    And I click continue button without member
    And I should see create todo list page
    And I click create todo button
    Then I should see engagement detail page
      | Engagement Dr01 |

  Scenario: Verify Admin Auditor Invite New Member Auditor
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | auvenirinfo@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement
      | Engagement Dr01 |
    Then I should see engagement detail page
      | Engagement Dr01 |
    And I click on team tab
    And I delete existed member




