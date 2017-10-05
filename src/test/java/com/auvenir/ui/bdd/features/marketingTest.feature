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

 #    vietlq
  Scenario: Marketing Page - About Page - Verify Title :"Wanna Join US?" :AUV-578 (Pendding)
    Given I navigate to Marketing page
    Then I redirect to About Page
    Then I should see text :"Wanna join us ?"

#    vietlq
  Scenario: Marketing Pages- Home page- Password textbox : AUV-579
    Given I navigate to Marketing page
    And I click on login link
    Then I click on password field
    Then I verify change color boundary of field
    Then I verify input with text :"MarketingPage"
    Then I verify input with number :"123456789"
    Then I verify input special character : "<><><>!@"
    Then I verify input text have space :"ABC ABC"

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

#  @vietlq
  Scenario: Marketing Page - About Page - Verify "Highlights of our Weekend Photo Competition" board: AUV-590
    Given I navigate to Marketing page
    Then I redirect to About Page
    Then I verify Highlights of our Weekend Photo Competition title
    Then I verify display 12 picture on board

#  @vietlq
  Scenario:Marketing Page - About Page - Verify "View Careers" button: AUV-582
    Given I navigate to Marketing page
    Then I redirect to About Page
    Then I verify text "View careers" and color of text
    And I click on view careers button

  @vietlq
  Scenario:Contact page > Verify that Contact page displays after user click on Contact
    link in footer at the end of the page: AUV-592
    Given I navigate to Marketing page
    Then I redirect to Contact Page
