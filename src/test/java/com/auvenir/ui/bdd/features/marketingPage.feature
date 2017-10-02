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

#  @Run
  Scenario: About Page- Verify Top Banner: AUV-550
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I redirect to About Page
    Then I should see Header Logo
    Then I should see Login link
    Then I should see Sign Up Link
    Then I should see Language Link
    Then I should see Banner Information

#  @Run
  Scenario: Home page- Verify Our Mission text(English): AUV-558
    Given I navigate to Marketing page
#    Then I scroll to Auvenir Mission part
    Then I should see Auvenir Mission header
    Then I should see Auvenir Mission content

#  @Run
  Scenario: Home page- Verify Why Auvenir text(English): AUV-559
    Given I navigate to Marketing page
    Then I scroll to Why Auvenir part
    Then I should see Why Auvenir header
    Then I should see Why Auvenir content

  @Run
  Scenario: Home page- Verify Footer: AUV-560
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I should see Home link
    Then I should see About link
    Then I should see Contact link
    Then I should see Terms of Service link
    Then I should see Privacy Policy link
    Then I should see Cookie Notice link