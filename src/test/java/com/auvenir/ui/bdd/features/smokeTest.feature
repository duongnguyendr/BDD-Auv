Feature: Smoke Test Feature
  This feature create six role on auvenir and test some basic feature.

  Scenario: Verify super admin login.
    Given I navigate to login page
    And I click on login link
    And I enter the following for Login
      | Username | Password |
      | chr.auvenirad@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the home page

  Scenario: Verify admin login.
    Given I navigate to login page
    And I click on login link
    And I enter the following for Login
      | Username | Password |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the home page

    Scenario: Verify Sign Up Auditor User.
      Given I navigate to login page
      And I click sign up link
      Then I should see personal sign up page

      # Input personal information
      And I input full name text box
      |Admin Auditor|
      And I input email address
      |chr.auditor0111.adm@gmail.com|
      And I input confirm email
      |chr.auditor0111.adm@gmail.com|
      And I select role in firm
      And I input phone number
      |1234567890|
      And I select how to hear about auvenir
      And I click agree with privacy and term service check box
      And I click confirm check box
      And I click continue button
      Then I should see provide firm infomation page

      # Input Firm information
      And I input firm name
      |Duong Firm|
      And I input firm webside
      |titancorpvn.com|
      And I select country
      |Canada|
      And I select provide state
      |Quebec|
      And I input street address
      |123 Hoang Van Thu|
      And I input zip code
      |K3G4P8|
      And I input city
      |Toronto|
      And I input office number
      |12345|
      And I input memberId
      |3154|
      And I select number employee
      And I input business phone number
      |1234567890|
      And I check rule logo check box
      And I check on affiliate checkbox
      And I input affiliate name
      |Titan corp|
      And I click on countinue button
      Then I should see thank for create account page
      And I click on countinue button

  Scenario: Verify Admin Change Status User To OnBoarding
    Given I navigate to login page
    And I click on login link
    And I enter the following for Login
      | Username | Password |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
#    Then I should see the home page
    Then I should see status off user is waitlisted
      |chr.auditor0111.adm@gmail.com|Wait Listed|
    And I change status of user to onboarding
      |chr.auditor0111.adm@gmail.com|Wait Listed|
    Then I should see confirm popup
    And I click confirm button
    Then I should see verified message succesfull
