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

#  @Run
  Scenario: Home page- Verify Footer: AUV-560
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I should see Home link
    Then I should see About link
    Then I should see Contact link
    Then I should see Terms of Service link
    Then I should see Privacy Policy link
    Then I should see Cookie Notice link
    Then I should see Facebook icon
    Then I should see Twitter icon
    Then I should see Linkedin icon
    Then I should see Copyright title

#  @Run
  Scenario: About Page - Verify Meet The Auvy League board: AUV-562
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I redirect to About Page
    Then I should see Meet The Auvy League header
    Then I should see Meet The Auvy League content: "12" members

#  @Run
  Scenario: Home page- Verify popup UI: AUV-563
    Given I navigate to Marketing page
    And I click on login link
    Then I verify Email label
    Then I verify Email textbox
    Then I verify Password label
    Then I verify Password textbox
    Then I verify Forgot password link
    Then I verify Login button

#  @Run
  Scenario: Terms of Service page- Verify Top Banner: AUV-575
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I redirect to Terms of Service Page
    Then I should see Header Logo
    Then I should see Login link
    Then I should see Sign Up Link
    Then I should see Language Link
    Then I should see Terms of Service Header Banner

#  @Run
  Scenario: Home page- Forgot password link: AUV-583
    Given I navigate to Marketing page
    And I click on login link
    Then I should see color of forgot password link is green
    Then I click on forgot password link
    Then I should see Forgot Password popup

#  @Run
  Scenario: Home page- Verify Forgot your password popup: AUV-588
    Given I navigate to Marketing page
    And I click on login link
    Then I click on forgot password link
    Then I should see Forgot Password popup
    And I should see Forgot Password popup title
    And I should see Forgot Password popup guide
    And I should see Forgot Password popup border
    And I should see Forgot Password popup Email label
    And I verify input Forgot Email with text: "abc"
    And I verify input Forgot Email with number: "132156"
    And I verify input Forgot Email with special character: "!@#$%^&*("
    Then I input email forgotten password : "auveniradm02@gmail.com"
    Then I click on Request Reset Link button
    Then I should see Account still processing message
    Then I click confirm with Account still processing message
    And I click on login link
    Then I click on forgot password link
    Then I should see Forgot Password popup
    Then I input email forgotten password : "auveniradm012345@gmail.com"
    Then I click on Request Reset Link button
    Then I should see Account not exist error message
    Then I input email forgotten password : "auveniradm01@gmail.com"
    Then I click on Request Reset Link button
    Then I should see Reset Link Sent message

#  @Run
  Scenario: Home page- Verify Product Features: AUV-589
    Given I navigate to Marketing page
    Then I scroll to Product Feartures part
    Then I should see Spend Less Time, Earn More
    Then I should see Securely Store Your Documents
    Then I should see Simplify Your Workﬂow
    Then I should see Collaborate Better With Your Clients
    Then I should see Intelligently Allocate Resources
    Then I should see Seamlessly Import Data
    Then I should see Customize Branding
    Then I should see Automated Tools

#  @Run
  Scenario: Home page- Verify popup UI: AUV-594
    Given I navigate to Marketing page
    And I click on login link
    Then I input Login Email Address: "auveniradm01@gmail.com"
    Then I should see "auveniradm01@gmail.com" on Email textbox
    Then I input Login Password: "Changeit@123"
    Then I should see "12" characters on Password textbox
    Then I click on login button
    Then I should see engagement page

  @Run
  Scenario: About Page- Verify Footer: AUV-598
    Given I navigate to Marketing page
    Then I scroll to footer
    Then I redirect to About Page
    Then I scroll to footer
    Then I scroll down
    Then I should see Home link
    Then I should see About link
    Then I should see Contact link
    Then I should see Terms of Service link
    Then I should see Privacy Policy link
    Then I should see Cookie Notice link
    Then I should see Facebook icon
    Then I should see Twitter icon
    Then I should see Linkedin icon
    Then I should see Copyright title