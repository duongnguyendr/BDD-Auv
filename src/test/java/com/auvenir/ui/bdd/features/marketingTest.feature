Feature: Marketing Feature
  This feature to verify features on Marketing page

  Scenario: Verify 'Forgot Password' flow for waitlisted user (Auditor Sign-Up): AUV-482
    Given I navigate to Marketing page
    And I click on login link
    Then I click on forgot password link
    Then I should see Forgot Password popup
    Then I input email forgotten password : "auveniradm01@gmail.com"
    Then I click on Request Reset Link button
    Then I should see Account still processing message

  Scenario: Home page- Login popup title: AUV-532
    Given I navigate to Marketing page
    And I click on login link
    Then I should see Login popup title

#  @Run
  Scenario: Home page- Verify Top Banner: AUV-548
    Given I navigate to Marketing page
    Then I should see Header Logo
    Then I should see Login link
    Then I should see Sign Up Link
    Then I should see Language Link
    Then I should see Join As Auditor Link

  @Run
  Scenario: About Page- Verify Top Banner: AUV-550
    Given I navigate to Marketing page
    Then I redirect to About Page
    Then I should see Header Logo
    Then I should see Login link
    Then I should see Sign Up Link
    Then I should see Language Link
    Then I should see Banner Information


  Scenario: Marketing Page - About Page - Verify Title :"Wanna Join US?" :AUV-578 (Pendding)
    Given I navigate to Marketing page
    Then I redirect to About Page
    Then I should see text Wanna join Us


  @Vietlq
  Scenario: Marketing Pages- Home page- Password textbox : AUV-579
    Given I navigate to Marketing page
