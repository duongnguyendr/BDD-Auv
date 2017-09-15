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

  Scenario: Verify admin login: AUV-2187
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email | Password |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page

  Scenario: Auditor Admin click Sign up button and fill information: AUV-542
    Given I navigate to Marketing page
    And Delete all activity of engagement by user  : "chr.auditor01.adm@gmail.com"
    And Delete all firm by name : "Firm Auvenir"
    And Delete all engagement of user : "chr.auditor01.adm@gmail.com"
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

  Scenario: Admin change status to Onboarding of a User: AUV-557
    Given I delete existed email
      |chr.auditor01.adm@gmail.com|Changeit@123|
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | chr.adm.auvenir@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
    Then I should see status of user is wait listed
      | chr.auditor01.adm@gmail.com | Wait Listed |
    And I change status of user to onboarding
      | chr.auditor01.adm@gmail.com | Onboarding |
    Then I should see confirm popup on admin page
    And I click confirm button on admin page
    Then I should see verified message successful on admin page

  Scenario: Auditor user active email via email web app and login to Auvenir: AUV-572
    Given I navigate to gmail login page
    And I signIn gmail
      | chr.auditor01.adm@gmail.com | Changeit@123 |
    And I open active email
    And I click on confirmation link
    And I create password: "Changeit@123"
    Then I should see engagement page

  Scenario: Admin auditor user create new Engagement: AUV-585
    Given I navigate to Marketing page
    And Delete engagement name by user  : "chr.auditor01.adm@gmail.com", "Engagement GP01"
    And Delete all business name by : "Titan"
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01.adm@gmail.com   | Changeit@123 |
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

  Scenario: Admin Auditor Invite Lead Auditor: AUV-599
    Given I delete existed email
      |chr.auditor01.lead@gmail.com|Changeit@123|
    And Delete all activity of engagement by user  : "chr.auditor01.lead@gmail.com"
    And Delete all engagement of user : "chr.auditor01.lead@gmail.com"
    And Delete user by email: "chr.auditor01.lead@gmail.com"
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auditor01.adm@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP01"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    And I click on team tab
    And I delete existed member on team page: "Lead Auditor"
    And I click in invite new member on team page
    Then I should see invite new member page
    And I input full name on invite new member page: "Lead Auditor"
    And I input email on invite new member page: "chr.auditor01.lead@gmail.com"
    And I input email confirm on invite new member page: "chr.auditor01.lead@gmail.com"
    And I select role of new member
    And I click on invite new member
    Then I should see invite successful message

    Scenario: Lead Auditor Active account: AUV-660
    Given I navigate to gmail login page
    And I signIn gmail
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I open active email
    And I click on confirmation link
    Then I should see personal sign up page
    And I input confirm auditor personal information: "1234567890"
    Then I should see provide firm information page
    And I click on continue button on firm information page
    And I create password: "Changeit@123"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"

  Scenario: Admin Auditor Invite Admin Client: AUV-633
    Given I delete existed email
      |chr.client01.adm@gmail.com | Changeit@123 |
    And Delete all client of user
      |chr.client01.adm@gmail.com|chr.client01.lead@gmail.com|chr.client01@gmail.com|
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                    | Password     |
      | chr.auditor01.adm@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP01"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP01"
    And I click on invite client button on engagement detail page
    Then I should see invite new client popup
    And I select add new client on new client popup
    And I input full name on invite client popup: "Admin Client"
    And I input email on invite client popup: "chr.client01.adm@gmail.com"
    And I input confirm email on invite client popup: "chr.client01.adm@gmail.com"
    And I input role on invite client popup: "IT"
    And I click on invite button on invite client popup
    Then I should see message invite successful: "Your engagement invitation has been sent."
    And I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                       | Password     |
      | chr.adm.auvenir@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see the AdminPortal page
    Then I should see status of user is onboarding
      | chr.client01.adm@gmail.com | Onboarding |

  Scenario: Admin Client active account: AUV-645
    Given I navigate to gmail login page
    And I signIn gmail
      | chr.client01.adm@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I fill up all Client Personal Information with Phone Number: "1234567899"
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I fill up all Client Business Information
    And I click on Continue Button on Business Information Page
    Then I should see Bank Information Page
    And I fill up all Bank Information
    And I click on Skip Button on Bank Information Page
    Then I should see File Storage Information Page
    And I fill up all File Storage Information
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement GP01"

  Scenario: Lead Auditor Create new Engagement: AUV-684
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | chr.auvenirauditor01@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click create new engagement button
    Then I should see new engagement page
    And I input engagement name: "Thuan Engagement GP03"
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
    Then I should see engagement detail page with Engagement Title Editable: "Thuan Engagement GP03"

  Scenario: Lead Auditor Invite Admin Client into Engagement 2: AUV-710
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                    | Password     |
      | auvenirauditor@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Huy Engagement 02"
    Then I click on Invite Client button
    Then I should see Invite Your Client page
    Then I select option Admin Client fullname: "Huy AC (Huy Company)"
    Then I click on Invite button
    Then I should see invite client success toast message
    Then I navigate to gmail login page
    And I signIn gmail
      | chr.auvenirclient@gmail.com | Changeit@123 |
    And I open active email
    And I click on onboarding invitation link
    Then I should see Welcome to Auvenir Page
    And I click on Get Start button on Client Sign Up Page
    Then I should see Provide Information Page
    And I fill up all Client Personal Information with Phone Number: "1234567899"
    And I click on Continue Button on Personal Information Page
    Then I should see Business Information Page
    And I fill up all Client Business Information
    And I click on Continue Button on Business Information Page
    Then I should see Bank Information Page
    And I fill up all Bank Information
    And I click on Skip Button on Bank Information Page
    Then I should see File Storage Information Page
    And I fill up all File Storage Information
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Huy Engagement 02"

  Scenario: Lead Auditor add New member auditor into Engagement 2: AUV-787
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                    | Password     |
      | auvenirauditor@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Huy Engagement 02"
    And I click on team tab
    And I click in invite new member on team page
    Then I should see invite new member page
    And I input full name on invite new member page: "Huy GA01"
    And I input email on invite new member page: "auvenirauditor01@gmail.com"
    And I input email confirm on invite new member page: "auvenirauditor01@gmail.com"
    And I select role of new member
    And I click on invite new member
    Then I should see invite successful message

  Scenario: Lead Auditor new Auditor member active account and login to Engagement 2: AUV-798
    Given I navigate to gmail login page
    Then I signIn gmail
      | auvenirauditor02@gmail.com | TESTPASSWORD |
    And I open active email
    And I click on confirmation link
    Then I should see personal sign up page
    And I input confirm auditor personal information: "1234567890"
    Then I should see provide firm information page
    And I click on continue button on firm information page
    And I create password: "Changeit@123"
    Then I should see engagement detail page with Engagement Title Uneditable: "Huy Engagement 02"

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
    Then I should see engagement detail page with Engagement Title Uneditable: "En05"
    And I click on Team tab on Client page
    And I click on Invite New Member button on Client team page
    Then I should see Invite New Member popup
    And I input full name on invite new member popup: "Lead Client"
    And I input email on invite new member popup: "vien1234@gmail.com"
    And I input email confirm on invite new member popup: "vien1234@gmail.com"
    And I input Role of new client member on invite new member popup: "Client role"
    And I click on invite button
    Then I should see Invite Member successful message

    #Vien Pham create testcase:
  Scenario:  Admin Client tranfer Lead permission to Lead Client in the Engagement2: AUV-847
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                     | Password     |
      | clvien.adm@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "En05"
    Then I should see engagement detail page with Engagement Title Uneditable: "En05"
    And I click on Team tab on Client page
    And I change the permission of member: "Lead Client" to be Lead

  #Viet Le create testcase:
  Scenario:Lead Auditor assign To Do task to Auditor Memeber: AUV-924
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                 | Password     |
      | auvenirinfo@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement abc"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement abc"
    Then I assignee list To-Do to Auditor
      | Auditor Name| Todo Name|
      |Admin Auditor| ToDo 01  |
      |Admin Auditor| ToDo 02  |
      |Admin Auditor| ToDo 03  |
    And I verify Auditor Assignee Selected
      | Auditor Name| Todo Name|
      |Admin Auditor| ToDo 01  |
      |Admin Auditor| ToDo 02  |
      |Admin Auditor| ToDo 03  |

##Viet Le create testcase:
  Scenario:Lead Auditor assign To Do task to Lead Client: AUV-896
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                   | Password     |
      | auvenirinfo@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement abc"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement abc"
    Then I assignee list To-Do to Client
      |userName | Todo Name|
      |Unassigned| ToDo 01|
      |Unassigned| ToDo 02|

  #Duong
  Scenario: Lead Auditor Mark Complete a To Do task: AUV-981
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                          | Password     |
      | chr.auditor01.lead@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I select todo check box on todo page: "ToDo 02"
    And I click bulk action drop down on todo page
    And I click mark complete button on bulk action
    Then I should see mark completed todo popup
    And I click on archive button on complete todo popup
    Then I should see todo mark completed on todo page: "ToDo 02"

  Scenario: Lead Auditor Bulk Actions Assign To Do: AUV-1016
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                          | Password     |
      | chr.auditor01.lead@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I select todo check box on todo page: "ToDo 03"
    And I click bulk action drop down on todo page
#    And I click assignee on bulk action drop down

  Scenario: Lead Auditor delete To Do Task: AUV-1026
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                          | Password     |
      | chr.auditor01.lead@gmail.com   | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement GP02"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement GP02"
    And I select todo check box on todo page: "ToDo 03"
    And I click bulk action drop down on todo page
    And I click delete button on bulk action
    Then I should see delete todo popup
    And I click on confirm delete button on delete todo popup
    Then I should see todo not existed in todo list: "ToDo 03"
   #/Duong