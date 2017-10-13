Feature: Smoke Test Feature
  This feature create six role on auvenir and test some basic feature.

  Scenario: Verify super admin login: AUV-2186
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auvenirad@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page

  @thuan
  Scenario: Verify admin login: AUV-2187
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
  @thuan
  Scenario: Auditor Admin click Sign up button and fill information: AUV-542
    Given I navigate to Marketing page
    And Delete all activity of user : "chr.auditor01.adm@gmail.com"
    And Delete all engagement of user : "chr.auditor01.adm@gmail.com"
    And Delete user role mapping by email: "chr.auditor01.adm@gmail.com"
    And Delete all firm which is create by : "chr.auditor01.adm@gmail.com"
    And Delete user by email: "chr.auditor01.adm@gmail.com"
    And I click sign up link
    Then I should see personal sign up page

    # Input personal information
    And I input full name: "Admin Auditor" text box
    And I input email address: "chr.auditor01.adm@gmail.com"
    And I input confirm email: "chr.auditor01.adm@gmail.com"
    And I select role in firm
    And I input phone number: "1234567890"
    And I select how to hear about Auvenir
    And I click agree with privacy and term service check box
    And I click confirm check box
    And I click continue button on sign up page
    Then I should see provide firm information page

    # Input Firm information
    And I input firm name: "Firm Auvenir"
    And I input firm web side: "titancorpvn.com"
    And I select country: "Canada"
    And I select provide state: "Quebec"
    And I input street address: "123 Hoang Van Thu"
    And I input zip code: "K3G4P8"
    And I input city: "Toronto"
    And I input office number: "12345"
    And I input memberId: "3215"
    And I select number employee
    And I input business phone number: "1234567890"
    And I check rule logo check box
    And I check on affiliate checkbox
    And I input affiliate name: "Titan corp"
    And I click continue button on sign up page
    Then I should see thank for create account page
    And I click continue button on sign up page
    Then I should see marketing portal page
  @thuan
  Scenario: Admin change status to Onboarding of a User: AUV-557
    Given I delete existed email
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
    Then I should see status of user: "chr.auditor01.adm@gmail.com" is "Wait Listed"
    And I change status of user: "chr.auditor01.adm@gmail.com" to "Onboarding"
    Then I should see confirm popup on admin page
    And I click confirm button on admin page
    Then I should see verified message successful on admin page
    Then I should see status of user: "chr.auditor01.adm@gmail.com" is "Onboarding"
  @thuan
  Scenario: Auditor user active email via email web app and login to Auvenir: AUV-572
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    And I sign In Email
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I open active email
    And I click on confirmation link
    And I create password: "Changeit@123"
    Then I should see engagement page
  @thuan
  Scenario: Admin auditor user create new Engagement: AUV-585
    Given I navigate to Marketing page
    And Delete engagement name by user  : "chr.auditor01.adm@gmail.com", "Engagement GP01"
    And Delete all business name by : "Titan"
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click create new engagement button
    Then I should see new engagement page
    And I input engagement name: "Engagement GP01"
    And I select engagement type: "Review"
    And I select company name: "Titan"
    And I set report deadline
    And I set start date
    And I set end date
    And I click on engagement continue button
    Then I should see team member wizard page
    And I click continue button without member
    And I should see create todo list page
    And I click create todo button on Create New Engagement Page
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
  @thuan
  Scenario: Admin Auditor Invite Lead Auditor: AUV-599
    Given I delete existed email
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And Delete all activity of user : "chr.auditor01.lead@gmail.com"
#    And Delete all activity of engagement by user  : "chr.auditor01.lead@gmail.com"
    And Delete all engagement of user : "chr.auditor01.lead@gmail.com"
    And Delete user role mapping by email: "chr.auditor01.lead@gmail.com"
    And Delete user by email: "chr.auditor01.lead@gmail.com"
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP01"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    And I click on Team tab of engagement detail page
    And I click in invite new member on team page
    Then I should see invite new member page
    And I input full name: "Lead Auditor" on invite new member page
    And I input email: "chr.auditor01.lead@gmail.com" on invite new member page
    And I input email confirm: "chr.auditor01.lead@gmail.com" on invite new member page
    And I select role of new member
    And I click on invite new member
    Then I should see invite successful message
  @thuan
  Scenario: Lead Auditor Active account: AUV-660
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    And I sign In Email
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I open active email
    And I click on confirmation link
    Then I should see personal sign up page
#    And I input confirm auditor personal information: "1234567890"
    And I input phone number: "12345678990" on personal information page
    And I select Auvenir referral on personal information page
    And I select check box agree on personal information page
    And I select confirm CPA check box on personal information page
    And I click on continue button on personal information page
    Then I should see provide firm information page
    And I click on continue button on firm information page
    And I create password: "Changeit@123"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"
  @thuan
  Scenario: Admin Auditor Invite Admin Client: AUV-633
    Given I delete existed email
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And Delete all client of user
      | Email                       |
      | chr.client01.adm@gmail.com  |
      | chr.client01.lead@gmail.com |
      | chr.client01@gmail.com      |
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP01"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    And I click on invite client button on engagement detail page
    Then I should see invite new client popup
    And I select add new client on new client popup
    And I input full name: "Admin Client" on invite client popup
    And I input email: "chr.client01.adm@gmail.com" on invite client popup
    And I input confirm email: "chr.client01.adm@gmail.com" on invite client popup
    And I input role: "IT" on invite client popup
    And I click on invite button on invite client popup
    Then I should see message invite successful: "Your engagement invitation has been sent."
    And I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
    Then I should see status of user: "chr.client01.adm@gmail.com" is "Onboarding"
  @thuan
  Scenario: Admin Client active account: AUV-645
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    And I sign In Email
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I input Client Mobile Phone Number: "1234567899"
    And I click on check box agreement
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I select Fiscal End Year on Business Information page
    And I select Business Industry on Business Information page
    And I select Accounting framework on Business Information page
    And I click on Continue Button on Business Information Page
#    Then I should see Bank Information Page ################ comment code
#    And I fill up all Bank Information ################ comment code
#    And I click on Skip Button on Bank Information Page ################ comment code
    Then I should see File Storage Information Page
    And I fill up all File Storage Information
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"
  @thuan
  Scenario: Lead Auditor Create new Engagement: AUV-684
    Given I navigate to Marketing page
    And Delete engagement name by user  : "chr.auditor01.lead@gmail.com", "Engagement GP02"
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click create new engagement button
    Then I should see new engagement page
    And I input engagement name: "Engagement GP02"
    And I select engagement type: "Review"
    And I select company name: "Titan"
    And I set report deadline
    And I set start date
    And I set end date
    And I click on engagement continue button
    Then I should see team member wizard page
    And I click continue button without member
    And I should see create todo list page
    And I click create todo button on Create New Engagement Page
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
  @thuan
  Scenario: Lead Auditor Invite Admin Client into Engagement 2: AUV-710
    Given I delete existed email
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Engagement GP02"
    Then I click on Invite Client button
    Then I should see Invite Your Client page
    Then I select option Admin Client fullname: "Admin Client"
    Then I click on Invite button
    Then I should see invite client success toast message
    And I relogin gmail: "Changeit@123"
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I input Client Mobile Phone Number: "1234567899"
    And I click on check box agreement
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I select Fiscal End Year on Business Information page
    And I select Business Industry on Business Information page
    And I select Accounting framework on Business Information page
    And I click on Continue Button on Business Information Page
#    Then I should see Bank Information Page ################ comment code
#    And I fill up all Bank Information ################ comment code
#    And I click on Skip Button on Bank Information Page ################ comment code
    Then I should see File Storage Information Page
    And I fill up all File Storage Information
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
  @thuan
  Scenario: Lead Auditor add New member auditor into Engagement 2: AUV-787
    Given I delete existed email
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    Given I navigate to Marketing page
    And Delete all activity of engagement by user  : "chr.auditor01@gmail.com"
    And Delete user by email: "chr.auditor01@gmail.com"
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Engagement GP02"
    And I click on Team tab of engagement detail page
    And I click in invite new member on team page
    Then I should see invite new member page
    And I input full name: "Auvenir Auditor" on invite new member page
    And I input email: "chr.auditor01@gmail.com" on invite new member page
    And I input email confirm: "chr.auditor01@gmail.com" on invite new member page
    And I select role of new member
    And I click on invite new member
    Then I should see invite successful message
  @thuan
  Scenario: New Auditor member active account and login to Engagement 2: AUV-798
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    Then I sign In Email
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I open active email
    And I click on confirmation link
    Then I should see personal sign up page
    And I input phone number: "12345678990" on personal information page
    And I select Auvenir referral on personal information page
    And I select check box agree on personal information page
    And I select confirm CPA check box on personal information page
    And I click on continue button on personal information page
    Then I should see provide firm information page
    And I click on continue button on firm information page
    And I create password: "Changeit@123"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
  @thuan
  Scenario: Admin Client invite Lead Client into Engagement: AUV-818
    Given I delete existed email
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    Given I navigate to Marketing page
    And Delete all client of user
      | Email                       |
      | chr.client01.lead@gmail.com |
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click on Team tab on Client page
    And I click on Invite New Member button on Client team page
    Then I should see Invite New Member popup
    And I input full name: "Lead Client" on invite new member popup
    And I input email: "chr.client01.lead@gmail.com" on invite new member popup
    And I input email confirm: "chr.client01.lead@gmail.com" on invite new member popup
    And I input Role: "IT" of new client member on invite new member popup
    And I click on invite button
    Then I should see Invite Member successful message
  @thuan
  Scenario: Lead Client Active Account and Login to Engagement2: AUV-840
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    And I sign In Email
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I input Client Mobile Phone Number: "1234567899"
    And I click on check box agreement
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I click on Continue Button on Business Information Page
#    Then I should see Bank Information Page  ################ comment code
#    And I click on Skip Button on Bank Information Page  ################ comment code
    Then I should see File Storage Information Page
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
  @thuan
  Scenario:  Admin Client transfer Lead permission to Lead Client in the Engagement2: AUV-847
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click on Team tab on Client page
    And I change the permission of member: "Lead Client" to be Lead

  @thuan
  Scenario: Lead client remove admin client out Engagement: AUV-1210
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click on Team tab of engagement detail page
    Then I should see Admin Client name : "Admin Client" in team member list
    Then I click on check box beside Admin Client name : "Admin Client" in team member list
    And I remove Admin Client name : "Admin Client" out of team member list
    Then I should not see Admin Client name : "Admin Client" in team member list

  @thuan
  Scenario: Leader Client invite client into Engagement: AUV-1214
    Given I delete existed email
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    Given I navigate to Marketing page
    And Delete all client of user
      | Email                  |
      | chr.client01@gmail.com |
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click on Team tab of engagement detail page
    And I click on Invite New Member button on team page
    Then I should see Invite New Member popup
    And I input full name: "General Client" on invite new member popup
    And I input email: "chr.client01@gmail.com" on invite new member popup
    And I input email confirm: "chr.client01@gmail.com" on invite new member popup
    And I input Role: "IT" of new client member on invite new member popup
    And I click on invite button
    Then I should see Invite Member successful message

  @thuan
  Scenario: New client log in their email and active user: AUV-1217
    Given I navigate to GMail login page
#    Given I navigate to SquirrelMail login page
    And I sign In Email
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I input Client Mobile Phone Number: "1234567899"
    And I click on check box agreement
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I click on Continue Button on Business Information Page
#    Then I should see Bank Information Page ################ comment code
#    And I click on Skip Button on Bank Information Page ################ comment code
    Then I should see File Storage Information Page
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"

  Scenario:Lead Auditor Create To Do task: AUV-878
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I create To-Do with name and category
      | ToDo name | Category |
      | ToDo 01   | Cat1     |
      | ToDo 02   | Cat1     |
      | ToDo 03   | Cat1     |
      | ToDo 04   | Cat1     |
      | ToDo 05   | Cat1     |
    Then I verify To-Do has been created and category
      | ToDo name | Category |
      | ToDo 01   | Cat1     |
      | ToDo 02   | Cat1     |
      | ToDo 03   | Cat1     |
      | ToDo 04   | Cat1     |
      | ToDo 05   | Cat1     |

  Scenario:Lead Auditor assign To Do task to Lead Client: AUV-896
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I assignee list To-Do to Client
      | Client Full Name | Todo Name |
      | Lead Client      | ToDo 01   |
      | Lead Client      | ToDo 02   |
      | Lead Client      | ToDo 04   |
      | Lead Client      | ToDo 05   |
    Then I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | Lead Client      | ToDo 01   |
      | Lead Client      | ToDo 02   |
      | Lead Client      | ToDo 04   |
      | Lead Client      | ToDo 05   |

  Scenario:Lead Auditor assign To Do task to Auditor member AUV-924
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    Then I assignee list To-Do to Auditor
      | Auditor Name    | Todo Name |
      | Auvenir Auditor | ToDo 01   |
      | Auvenir Auditor | ToDo 04   |
    And I verify Auditor Assignee Selected
      | Auditor Name    | Todo Name |
      | Auvenir Auditor | ToDo 01   |
      | Auvenir Auditor | ToDo 04   |

  Scenario:  Lead Auditor add new request on To Do task: AUV-947
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    Then I create requests from To-Do
      | ToDo 01 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 02 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 03 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 04 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 05 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |

    Then I verify Auditor Create requests from To-Do: ToDo 01, ToDo 02, ToDo 03, ToDo 04, ToDo 05
      | Request Name |
      | Request 01   |
      | Request 02   |
      | Request 03   |
      | Request 04   |
      | Request 05   |
      | Request 06   |

  Scenario: Lead Auditor add file to request on To Do task AUV-954
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 04"
    Then I should see the Todo detail opened
    And I uploads list files on list requests
      | File Name             | Request Name |
      | TXT_Auvenir.jpg       | Request 01   |
      | TXT_Auvenir.pdf       | Request 02   |
      | TXT_Auvenir.xlsx      | Request 03   |
      | TXT_helloAuvenir.docx | Request 04   |
      | TXT_helloAuvenir.png  | Request 05   |
      | TXT_helloAuvenir.txt  | Request 06   |
    And I closes the To Do detail popup
    And I click slide out menu on selected To-do: "ToDo 04"
    Then I should see the Todo detail opened
    Then I should see list files: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Lead Auditor download files of request on To Do task: AUV-961
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 04"
    Then I should see the Todo detail opened
    And I click download list files on Todo detail popup: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt
    Then I should see list files which are downloaded successfully: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Lead Auditor post new comment: AUV-968
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And  I click slide out menu on selected To-do: "ToDo 04"
    Then I should see the Todo detail opened
    Then I input comment content: "Lead Auditor Comment"
    Then I click on post comment button
    Then I should see this comment display on list: "Lead Auditor Comment"
    Then I attach to comment a file: "TXT_ATTACHMENT.png"
    Then I should see this comment display on list: "TXT_ATTACHMENT.png"

  Scenario: Lead Auditor Mark Complete a To Do task: AUV-981
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I select todo: "ToDo 02" check box on todo page
    And I click bulk action drop down on todo page
    And I click mark complete button on bulk action
    Then I should see mark completed todo popup
    And I click on archive button on complete todo popup
    Then I should see todo: "ToDo 02" mark completed on todo page

  Scenario: Lead Auditor Bulk Actions Assign To Do: AUV-1016
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I select todo: "ToDo 03" check box on todo page
    And I click bulk action drop down on todo page
    And I click assignee to :"Lead Client" on bulk action drop down
    And I verify Client Assignee Selected
      | User Name   | Todo Name |
      | Lead Client | ToDo 03   |
    And I select todo: "ToDo 03" check box on todo page
    And I click bulk action drop down on todo page
    And I click assignee to :"Auvenir Auditor" on bulk action drop down
    And I verify Auditor Assignee Selected
      | User Name       | Todo Name |
      | Auvenir Auditor | ToDo 03   |

  Scenario: Lead Auditor delete To Do Task: AUV-1026
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I assignee list To-Do to Client
      | Client Full Name | Todo Name |
      | Unassigned       | ToDo 03   |
    Then I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | Unassigned       | ToDo 03   |
    And I select todo: "ToDo 03" check box on todo page
    And I click bulk action drop down on todo page
    And I click delete button on bulk action
    Then I should see delete todo popup
    And I click on confirm delete button on delete todo popup
    Then I should see todo: "ToDo 03" not existed in todo list

  Scenario: Lead Auditor download all To Do: AUV-1052
    Given I navigate to Marketing page
    And I delete existed file: "Engagement GP02.zip" in download folder
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I click check box all todo on todo page
    And I click bulk action drop down on todo page
    And I click download attachments on bulk action
    Then I should see popup download attachments on todo page
    And I click download button on attachment download popup
    Then I verify file "Engagement GP02.zip" existed in computer

  Scenario:Auditor Member creates to do task: AUV-1060
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I create To-Do with name and category
      | ToDo name | Category |
      | ToDo 06   | Cat1     |
      | ToDo 07   | Cat1     |
      | ToDo 08   | Cat1     |
      | ToDo 09   | Cat1     |
      | ToDo 10   | Cat1     |
    Then I verify To-Do has been created and category
      | ToDo name | Category |
      | ToDo 06   | Cat1     |
      | ToDo 07   | Cat1     |
      | ToDo 08   | Cat1     |
      | ToDo 09   | Cat1     |
      | ToDo 10   | Cat1     |

  Scenario:Auditor Member assign To Do to Lead Client : AUV-1069
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I assignee list To-Do to Client
      | Client Full Name | Todo Name |
      | Lead Client      | ToDo 06   |
      | Lead Client      | ToDo 07   |
      | Lead Client      | ToDo 09   |
    Then I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | Lead Client      | ToDo 06   |
      | Lead Client      | ToDo 07   |
      | Lead Client      | ToDo 09   |

  Scenario: Auditor Member add new request on To Do task: AUV-1083
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I create requests from To-Do
      | ToDo 06 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 07 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 08 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 09 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 10 | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |

    Then I verify Auditor Create requests from To-Do: ToDo 06, ToDo 07, ToDo 08, ToDo 09, ToDo 10
      | Request Name |
      | Request 01   |
      | Request 02   |
      | Request 03   |
      | Request 04   |
      | Request 05   |
      | Request 06   |

  Scenario: Auditor add file to request on To-Do: AUV-1107
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 09"
    Then I should see the Todo detail opened
    And I uploads list files on list requests
      | File Name             | Request Name |
      | TXT_Auvenir.jpg       | Request 01   |
      | TXT_Auvenir.pdf       | Request 02   |
      | TXT_Auvenir.xlsx      | Request 03   |
      | TXT_helloAuvenir.docx | Request 04   |
      | TXT_helloAuvenir.png  | Request 05   |
      | TXT_helloAuvenir.txt  | Request 06   |
    And I closes the To Do detail popup
    And I click slide out menu on selected To-do: "ToDo 09"
    Then I should see the Todo detail opened
    Then I should see list files: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Auditor download file from request: AUV-1113
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 09"
    Then I should see the Todo detail opened
    And I click download list files on Todo detail popup: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt
    Then I should see list files which are downloaded successfully: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: General Auditor post new comment: AUV-1123
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And  I click slide out menu on selected To-do: "ToDo 09"
    Then I should see the Todo detail opened
    Then I input comment content: "General Auditor Comment"
    Then I click on post comment button
    Then I should see this comment display on list: "General Auditor Comment"
    Then I attach to comment a file: "TXT_ATTACHMENT.docx"
    Then I should see this comment display on list: "TXT_ATTACHMENT.docx"

  Scenario: Auditor mark as complete one To-Do: AUV-1127
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I select todo: "ToDo 07" check box on todo page
    And I click bulk action drop down on todo page
    And I click mark complete button on bulk action
    Then I should see mark completed todo popup
    And I click on archive button on complete todo popup
    Then I should see todo: "ToDo 07" mark completed on todo page

  Scenario: Auditor delete 1 To-Do: AUV-1130
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I assignee list To-Do to Client
      | Client Full Name | Todo Name |
      | Unassigned       | ToDo 08   |
    Then I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | Unassigned       | ToDo 08   |
    And I select todo: "ToDo 08" check box on todo page
    And I click bulk action drop down on todo page
    And I click delete button on bulk action
    Then I should see delete todo popup
    And I click on confirm delete button on delete todo popup
    Then I should see todo: "ToDo 08" not existed in todo list

  Scenario: Auditor download from all To-do: AUV-1141
    Given I navigate to Marketing page
    And I delete existed file: "Engagement GP02.zip" in download folder
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click check box all todo on todo page
    And I click bulk action drop down on todo page
    And I click download attachments on bulk action
    Then I should see popup download attachments on todo page
    And I click download button on attachment download popup
    Then I verify file "Engagement GP02.zip" existed in computer

  Scenario: Lead Client can see to-dos: AUV-1171
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I should see all to do assigned : ToDo 01, ToDo 02, ToDo 04, ToDo 05, ToDo 06, ToDo 07, ToDo 09

  Scenario: Lead Client assign To Do to client: AUV-2248
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I assignee list To-Do to Client
      | Client Full Name | Todo Name |
      | General Client   | ToDo 01   |
      | General Client   | ToDo 06   |
      | General Client   | ToDo 09   |
    Then I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | General Client   | ToDo 01   |
      | General Client   | ToDo 06   |
      | General Client   | ToDo 09   |

  Scenario: Lead client login and add file to request: AUV-1250
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 06"
    Then I should see the Todo detail opened
    And I uploads list files on list requests
      | File Name             | Request Name |
      | TXT_Auvenir.jpg       | Request 01   |
      | TXT_Auvenir.pdf       | Request 02   |
      | TXT_Auvenir.xlsx      | Request 03   |
      | TXT_helloAuvenir.docx | Request 04   |
      | TXT_helloAuvenir.png  | Request 05   |
      | TXT_helloAuvenir.txt  | Request 06   |
    And I closes the To Do detail popup
    And I click slide out menu on selected To-do: "ToDo 06"
    Then I should see the Todo detail opened
    Then I should see list files: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Lead Client download file from request: AUV-1259
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 06"
    Then I should see the Todo detail opened
    And I click download list files on Todo detail popup: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt
    Then I should see list files which are downloaded successfully: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Lead Client post new comment: AUV-1267
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And  I click slide out menu on selected To-do: "ToDo 06"
    Then I should see the Todo detail opened
    Then I input comment content: "Lead Client Comment"
    Then I click on post comment button
    Then I should see this comment display on list: "Lead Client Comment"
    Then I attach to comment a file: "TXT_ATTACHMENT.txt"
    Then I should see this comment display on list: "TXT_ATTACHMENT.txt"

  Scenario: Lead client - Bulk acction - assign To-Do to General Client: AUV-1294
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.client01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I select todo: "ToDo 04" check box on Uneditable To-do page
    And I click bulk action drop down on todo page
    And I click assignee to :"General Client" on bulk action drop down
    And I verify Client Assignee Selected
      | Client Full Name | Todo Name |
      | General Client   | ToDo 04   |

  Scenario: General Client can see to-dos: AUV-1299
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I should see all to do assigned : ToDo 01, ToDo 04, ToDo 06, ToDo 09

  Scenario: Client add file to request on To-Do: AUV-1316
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 01"
    Then I should see the Todo detail opened
    And I uploads list files on list requests
      | File Name             | Request Name |
      | TXT_Auvenir.jpg       | Request 01   |
      | TXT_Auvenir.pdf       | Request 02   |
      | TXT_Auvenir.xlsx      | Request 03   |
      | TXT_helloAuvenir.docx | Request 04   |
      | TXT_helloAuvenir.png  | Request 05   |
      | TXT_helloAuvenir.txt  | Request 06   |
    And I closes the To Do detail popup
    And I click slide out menu on selected To-do: "ToDo 01"
    Then I should see the Todo detail opened
    Then I should see list files: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Client download file from request: AUV-1319
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I click slide out menu on selected To-do: "ToDo 01"
    Then I should see the Todo detail opened
    And I click download list files on Todo detail popup: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt
    Then I should see list files which are downloaded successfully: TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt

  Scenario: Client post new comment: AUV-1326
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                  | Password     |
      | chr.client01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And  I click slide out menu on selected To-do: "ToDo 01"
    Then I should see the Todo detail opened
    Then I input comment content: "General Client Comment"
    Then I click on post comment button
    Then I should see this comment display on list: "General Client Comment"
    Then I attach to comment a file: "TXT_ATTACHMENT.docx"
    Then I should see this comment display on list: "TXT_ATTACHMENT.docx"

  Scenario: Admin auditor can see engagement in firm: AUV-1336
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I should see engagement list : Engagement GP01, Engagement GP02
    Then I click on engagement: "Engagement GP01"
    And I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    Then I click on engagement tab return engagement page
    And I should see engagement page
    Then I click on engagement: "Engagement GP02"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"

  Scenario: Admin client can see all engagement(s) in business: AUV-1376
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I should see engagement list : Engagement GP01, Engagement GP02
    Then I click on assigned engagement: "Engagement GP01"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"
    Then I click on engagement tab return engagement page
    And I should see engagement page
    Then I click on assigned engagement: "Engagement GP02"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"

  Scenario: Admin auditor can see all to-dos in firm: AUV-2253
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I should see engagement list : Engagement GP01, Engagement GP02
    Then I click on engagement: "Engagement GP01"
    And I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    Then I should see empty ToDo list
    Then I click on engagement tab return engagement page
    And I should see engagement page
    Then I click on engagement: "Engagement GP02"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I should see all to do : ToDo 01, ToDo 02, ToDo 04, ToDo 05, ToDo 06, ToDo 07, ToDo 09, ToDo 10


  Scenario: Admin auditor can see all request(s) in Firm: AUV-2254
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I verify Existed request name from Todo
      | Todo Name | Request Name                                                           |
      | ToDo 02   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 05   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 07   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 10   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
    And I verify Existed request files from Todo
      | Todo Name | File Request                                                                                                          |
      | ToDo 01   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 04   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 06   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 09   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |

  Scenario: Admin auditor can see all comments in firm : AUV-2255
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I verify comment at list To-Do
      | To-Do Name | User Comment    | Content Comment         |
      | ToDo 01    | General Client  | General Client Comment  |
      | ToDo 01    | General Client  | TXT_ATTACHMENT.docx     |
      | ToDo 04    | Lead Auditor    | Lead Auditor Comment    |
      | ToDo 04    | Lead Auditor    | TXT_ATTACHMENT.png      |
      | ToDo 06    | Lead Client     | Lead Client Comment     |
      | ToDo 06    | Lead Client     | TXT_ATTACHMENT.txt      |
      | ToDo 09    | Auvenir Auditor | General Auditor Comment |
      | ToDo 09    | Auvenir Auditor | TXT_ATTACHMENT.docx     |

  Scenario:  Admin client can see all To-do(s) in business: AUV-2256
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I should see engagement list : Engagement GP01, Engagement GP02
    Then I click on assigned engagement: "Engagement GP01"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"
    Then I should see empty ToDo list
    Then I click on engagement tab return engagement page
    And I should see engagement page
    Then I click on assigned engagement: "Engagement GP02"
    And I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    Then I should see all to do : ToDo 01, ToDo 02, ToDo 04, ToDo 05, ToDo 06, ToDo 07, ToDo 09

  Scenario: Admin client can see all request(s) in Business: AUV-2257
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I verify Existed request name from Todo
      | Todo Name | Request Name                                                           |
      | ToDo 02   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 05   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
      | ToDo 07   | Request 01, Request 02, Request 03, Request 04, Request 05, Request 06 |
    And I verify Existed request files from Todo
      | Todo name | Request name                                                                                                          |
      | ToDo 01   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 04   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 06   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |
      | ToDo 09   | TXT_Auvenir.jpg, TXT_Auvenir.pdf, TXT_Auvenir.xlsx, TXT_helloAuvenir.docx, TXT_helloAuvenir.png, TXT_helloAuvenir.txt |

  Scenario: Admin client can see all comment(s) in business: AUV-2258
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on assigned engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP02"
    And I verify comment at list To-Do
      | To-Do Name | User Comment    | Content Comment         |
      | ToDo 01    | General Client  | General Client Comment  |
      | ToDo 01    | General Client  | TXT_ATTACHMENT.docx     |
      | ToDo 04    | Lead Auditor    | Lead Auditor Comment    |
      | ToDo 04    | Lead Auditor    | TXT_ATTACHMENT.png      |
      | ToDo 06    | Lead Client     | Lead Client Comment     |
      | ToDo 06    | Lead Client     | TXT_ATTACHMENT.txt      |
      | ToDo 09    | Auvenir Auditor | General Auditor Comment |
      | ToDo 09    | Auvenir Auditor | TXT_ATTACHMENT.docx     |


    @VietDT
  Scenario: Admin client can see all comment(s) in business: AUV-2258
    Given I Check email function work