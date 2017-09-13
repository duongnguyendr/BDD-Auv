Feature: Smoke Test Feature
  This feature create six role on auvenir and test some basic feature.

  Scenario: Verify super admin login: AUV-2186
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | chr.auvenirad@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page

#  Scenario: Verify admin login: AUV-2187
#    Given I navigate to Marketing page
#    And I click on login link
#    And I enter the following for Login
#      | Email | Password |
#      | chr.adm.auvenir@gmail.com | Changeit@123 |
#    And I click on login button
#    Then I should see the AdminPortal page
#
#  Scenario: Auditor Admin click Sign up button and fill information: AUV-542
#    Given I navigate to Marketing page
#    And I click sign up link
#    Then I should see personal sign up page
#
#    # Input personal information
#    And I input full name: "Admin Auditor" text box
#    And I input email address: "auvenirinfo@gmail.com"
#    And I input confirm email: "auvenirinfo@gmail.com"
#    And I select role in firm
#    And I input phone number: "1234567890"
#    And I select how to hear about Auvenir
#    And I click agree with privacy and term service check box
#    And I click confirm check box
#    And I click continue button on sign up page
#    Then I should see provide firm information page
#
#    # Input Firm information
#    And I input firm name: "Duong Firm"
#    And I input firm web side: "titancorpvn.com"
#    And I select country: "Canada"
#    And I select provide state: "Quebec"
#    And I input street address: "123 Hoang Van Thu"
#    And I input zip code: "K3G4P8"
#    And I input city: "Toronto"
#    And I input office number: "12345"
#    And I input memberId: "3215"
#    And I select number employee
#    And I input business phone number: "1234567890"
#    And I check rule logo check box
#    And I check on affiliate checkbox
#    And I input affiliate name: "Titan corp"
#    And I click continue button on sign up page
#    Then I should see thank for create account page
#    And I click continue button on sign up page
#
#  Scenario: Admin change status to Onboarding of a User: AUV-557
#    Given I navigate to Marketing page
#    And I click on login link
#    And I enter the following for Login
#      | Email                     | Password     |
#      | chr.adm.auvenir@gmail.com | Changeit@123 |
#    And I click on login button
#    Then I should see the AdminPortal page
#    Then I should see status off user is wait listed
#      | auvenirinfo@gmail.com | Wait Listed |
#    And I change status of user to onboarding
#      | auvenirinfo@gmail.com | Onboarding |
#    Then I should see confirm popup on admin page
#    And I click confirm button on admin page
#    Then I should see verified message successful on admin page
#
#  Scenario: Auditor user active email via email web app and login to Auvenir: AUV-572
#    Given I navigate to gmail login page
#    And I signIn gmail
#      | auvenirinfo@gmail.com | 12345678@Ab |
#    And I open Auditor active email
#    And I click on confirmation link
#    And I create password: "Changeit@123"
#    Then I should see engagement page
#
#  Scenario: Auditor user create new Engegament: AUV-585
#    Given I navigate to Marketing page
#    And I click on login link
#    And I enter the following for Login
#      | Email                   | Password     |
#      | auvenirinfo@gmail.com   | Changeit@123 |
#    And I click on login button
#    Then I should see engagement page
#    And I click create new engagement button
#    Then I should see new engagement page
#    And I input engagement name: "Engagement Dr01"
#    And I select engagement type: "Review"
#    And I select company name: "Titan"
#    And I set report deadline
#    And I set start date
#    And I set end date
#    And I click on engagement continue button
#    Then I should see team member wizard page
#    And I click continue button without member
#    And I should see create todo list page
#    And I click create todo button
#    Then I should see engagement detail page: "Engagement Dr01"
#
#  Scenario: Admin Auditor Invite Lead Auditor: AUV-599
#    Given I delete existed email
#    Given I navigate to Marketing page
#    And I click on login link
#    And I enter the following for Login
#      | Email                   | Password     |
#      | auvenirinfo@gmail.com   | Changeit@123 |
#    And I click on login button
#    Then I should see engagement page
#    And I click on engagement: "Engagement Dr01"
#    Then I should see engagement detail page: "Engagement Dr01"
#    And I click on team tab
#    And I delete existed member on team page
#    And I click in invite new member on team page
#    Then I should see invite new member page
#    And I input full name on invite new member page: "Lead Auditor"
#    And I input email on invite new member page: "auditor01@gmail.com"
#    And I input email confirm on invite new member page: "auditor01@gmail.com"
#    And I select role of new member
#    And I click on invite new member
#    Then I should see invite successful message
#    And I relogin gmail: "auditor01@gmail.com"
#    And I open active email
#    And I click on confirmation link
#    Then I should see
#

#Thuan Duong create testcase:
  Scenario: Admin Client active account: AUV-645
    Given I navigate to gmail login page
    And I signIn gmail
      | chr.auvenirclient01@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I fill up all Information Page with Phone Number: "1234567899"
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page



#Vien Pham create testcase:
  Scenario: Admin Client invite Lead Client into Engagement: AUV-818
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | clvien.adm@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "En05"
    Then I should see the title of selected engagement: "En05"
    And I click on Team tab on Client page
    And I click on Invite New Member button on Client team page
    Then I should see Invite New Member popup
    And I input full name on invite new member popup: "Lead Client"
    And I input email on invite new member popup: "vien1234@gmail.com"
    And I input email confirm on invite new member popup: "vien1234@gmail.com"
    And I input Role of new client member on invite new member popup: "Client role"
    And I click on invite button
    Then I should see Invite Member successful message

  Scenario:Lead Auditor assign To Do task to Auditor Memeber: AUV-924
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | auvenirinfo@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement Dr01"
    Then I should see engagement detail page: "Engagement Dr01"
    Then I assignee list To-Do to General Auditor
      | Auditor Name  | Todo Name|
      |General Auditor| ToDo 01  |
      |General Auditor| ToDo 01  |
      |General Auditor| ToDo 01  |
      |General Auditor| ToDo 01  |



