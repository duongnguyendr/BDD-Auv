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
      | Email                     | Password     |
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
    Then I should see marketing portal page

  Scenario: Admin change status to Onboarding of a User: AUV-557
    Given I delete existed email
      | chr.auditor01.adm@gmail.com | Changeit@123 |
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
    Then I should see status of user is onboarding
      | chr.auditor01.adm@gmail.com | Onboarding |

  Scenario: Auditor user active email via email web app and login to Auvenir: AUV-572
    Given I navigate to GMail login page
    And I sign In GMail
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

  Scenario: Admin Auditor Invite Lead Auditor: AUV-599
    Given I delete existed email
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And Delete all activity of engagement by user  : "chr.auditor01.lead@gmail.com"
    And Delete all engagement of user : "chr.auditor01.lead@gmail.com"
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

  Scenario: Lead Auditor Active account: AUV-660
    Given I navigate to GMail login page
    And I sign In GMail
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
      | chr.client01.adm@gmail.com | Changeit@123 |
    And Delete all client of user
      | chr.client01.adm@gmail.com | chr.client01.lead@gmail.com | chr.client01@gmail.com |
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
    Then I should see status of user is onboarding
      | chr.client01.adm@gmail.com | Onboarding |

  Scenario: Admin Client active account: AUV-645
    Given I navigate to GMail login page
    And I sign In GMail
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
      | Email                          | Password     |
      | chr.auvenirauditor01@gmail.com | Changeit@123 |
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
    Then I navigate to GMail login page
    And I sign In GMail
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
    And I click on Team tab of engagement detail page
    And I click in invite new member on team page
    Then I should see invite new member page
    And I input full name: "Huy GA01" on invite new member page
    And I input email: "auvenirauditor01@gmail.com" on invite new member page
    And I input email confirm: "auvenirauditor01@gmail.com" on invite new member page
    And I select role of new member
    And I click on invite new member
    Then I should see invite successful message

  Scenario: New Auditor member active account and login to Engagement 2: AUV-798
    Given I navigate to GMail login page
    Then I sign In GMail
      | auvenirauditor02@gmail.com | TESTPASSWORD |
    And I open active email
    And I click on confirmation link
    Then I should see personal sign up page
    And I input confirm auditor personal information: "1234567890"
    Then I should see provide firm information page
    And I click on continue button on firm information page
    And I create password: "Changeit@123"
    Then I should see engagement detail page with Engagement Title Uneditable: "Huy Engagement 02"

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
    And I input full name: "Lead Client" on invite new member popup
    And I input email: "vien1234@gmail.com" on invite new member popup
    And I input email confirm: "vien1234@gmail.com" on invite new member popup
    And I input Role: "Client role" of new client member on invite new member popup
    And I click on invite button
    Then I should see Invite Member successful message

  Scenario: Lead Client Active Account and Login to Engagement2: AUV-840
    Given I navigate to GMail login page
    And I sign In GMail
      | phamhoangtan13052007@gmail.com | myphuong |
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
    Then I should see Bank Information Page
    And I click on Skip Button on Bank Information Page
    Then I should see File Storage Information Page
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "0"


  Scenario:  Admin Client transfer Lead permission to Lead Client in the Engagement2: AUV-847
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

  Scenario:Lead Auditor Create To Do task: AUV-878
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement abc"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement abc"
    Then I create To-Do with name and category
      | ToDo name | Category |
      | ToDo 01   | Music    |
      | ToDo 02   | Sport    |

  Scenario:Lead Auditor assign To Do task to Lead Client: AUV-896
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                 | Password     |
      | auvenirinfo@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement abc"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement abc"
    Then I assignee list To-Do to Client
      | userName   | Todo Name |
      | Unassigned | ToDo 01   |
      | Unassigned | ToDo 02   |

  Scenario:Lead Auditor assign To Do task to Auditor member AUV-924
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
      | Auditor Name  | Todo Name |
      | Admin Auditor | ToDo 01   |
      | Admin Auditor | ToDo 02   |
      | Admin Auditor | ToDo 03   |
    And I verify Auditor Assignee Selected
      | Auditor Name  | Todo Name |
      | Admin Auditor | ToDo 01   |
      | Admin Auditor | ToDo 02   |
      | Admin Auditor | ToDo 03   |

    #Thuan Duong create
  Scenario: Lead Auditor add file to request on To Do task AUV-954
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                          | Password     |
      | chr.auvenirauditor01@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement"
    And I click slide out menu on selected To-do: "Todo4"
    Then I should see the Todo detail opened
    And I uploads list files on list requests
      | File Name             | Request Name |
      | TXT_Auvenir.jpg       | Request 1    |
      | TXT_Auvenir.pdf       | Request 2    |
      | TXT_Auvenir.xlsx      | Request 3    |
      | TXT_helloAuvenir.docx | Request 4    |
      | TXT_helloAuvenir.png  | Request 5    |
      | TXT_helloAuvenir.txt  | Request 6    |

  Scenario:  Lead Auditor add new request on To Do task: AUV-947
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | auvien.lead@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on assigned engagement: "En02"
    Then I should see engagement detail page with Engagement Title Editable: "En02"
    And  I click slide out menu on selected To-do: "Todo 01"
    Then I should see the Todo detail opened
    And  I creates some new requests
      | Request Name |
      | Request 01   |
      | Request 02   |
      | Request 03   |
      | Request 04   |
      | Request 05   |
      | Request 06   |


  #Duong
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
    And I select todo: "ToDo 04" check box on todo page
    And I click bulk action drop down on todo page
    And I click assignee to :"unassigned" on bulk action drop down
    And I verify Client Assignee Selected
      | userName   | Todo Name |
      | Unassigned | ToDo 04   |
    And I click bulk action drop down on todo page
    And I click assignee to :"Lead Auditor" on bulk action drop down
    And I verify Auditor Assignee Selected
      | User Name    | Todo Name |
      | Lead Auditor | ToDo 04   |

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

  Scenario:Auditor Member assign To Do to Lead Client : AUV-1069
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                        | Password     |
      | chr.auditor01.lead@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement abc"
    Then I should see engagement detail page with Engagement Title Editable: "Engagement abc"
    Then I assignee list To-Do to Client
      | Lead client | Todo Name |
      | Unassigned  | ToDo 01   |
      | Unassigned  | ToDo 02   |
    Then I verify Client Assignee Selected
      | Lead client | Todo Name |
      | Unassigned  | ToDo 01   |
      | Unassigned  | ToDo 02   |

  @Run
  Scenario: Lead Auditor post new comment: AUV-968
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                    | Password     |
      | auvenirauditor@gmail.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    Then I click on engagement: "Huy Engagement 02"
    Then I should see engagement detail page with Engagement Title Editable: "Huy Engagement 02"
    And  I click slide out menu on selected To-do: "Todo 01"
    Then I should see the Todo detail opened
    Then I input comment content: "Lead Auditor Comment"
    Then I click on post comment button
    Then I should see this comment display on list: "Lead Auditor Comment"
#/Huy

    #Tan
  Scenario: Lead Client can see to-dos: AUV-1171
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                         | Password     |
      | clienttan.lead@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement 02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement 02"
    Then I should see all to do assigned : ToDo1,ToDo2,ToDo3,ToDo4,ToDo5

  Scenario: Lead client remove admin client out Engagement: AUV-1210
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                         | Password     |
      | clienttan.lead@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "Engagement 02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement 02"
    And I click on Team tab of engagement detail page
    Then I should see Admin Client name : "Admin Client" in team member list
    Then I click on check box beside Admin Client name : "Admin Client" in team member list
    And I remove Admin Client name : "Admin Client" out of team member list
    Then I should not see Admin Client name : "Admin Client" in team member list

  Scenario: Leader Client invite client into Engagement: AUV-1214
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                         | Password     |
      | clienttan.lead@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see client engagement page
    And I click on engagement: "Engagement 02"
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement 02"
    And I click on Team tab of engagement detail page
    And I click on Invite New Member button on team page
    Then I should see Invite New Member popup
    And I input full name: "General Client" on invite new member popup
    And I input email: "phamhoangtan12071986@gmail.com" on invite new member popup
    And I input email confirm: "phamhoangtan12071986@gmail.com" on invite new member popup
    And I input Role: "General Client" of new client member on invite new member popup
    And I click on invite button
    Then I should see Invite Member successful message

  Scenario: New client log in their email and active user: AUV-1217
    Given I navigate to GMail login page
    And I sign In GMail
      | phamhoangtan12071986@gmail.com | myphuong |
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
    Then I should see Bank Information Page
    And I click on Skip Button on Bank Information Page
    Then I should see File Storage Information Page
    And I click on Skip Button on File Storage Information Page
    Then I should see Security Information Page
    And I fill up all Security Information with Password: "Changeit@123"
    And I click on Create Account Button on Security Information Page
    Then I should see engagement detail page with Engagement Title Uneditable: "Engagement 02"
#Tan
  #Duong

  Scenario: Auditor mark as complete one To-Do: AUV-1217
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
    And I select todo: "ToDo 08" check box on todo page
    And I click bulk action drop down on todo page
    And I click delete button on bulk action
    Then I should see delete todo popup
    And I click on confirm delete button on delete todo popup
    Then I should see todo: "ToDo 08" not existed in todo list

  @duong123
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
  #/Duong

#    Then i should see Admin Client name : "Admin Client" in team member list

  # VienPham create
  Scenario: Lead client - Bulk acction - assign To-Do to General Client: AUV-1294
    # Bulk action assign to-do4 to General client
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                      | Password     |
      | clvien.lead@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "En02"
    Then I should see engagement detail page with Engagement Title Uneditable: "En02"
    And I select todo: "ToDo 04" check box on Uneditable To-do page
    And I click bulk action drop down on todo page
    And I click assignee to :"General Client" on bulk action drop down
    Then I verify Client Assignee Selected on Uneditabe Page
      | User Name      | Todo Name |
      | General Client | ToDo 04   |

    # VienPham create

  Scenario: General Client can see to-dos: AUV-1299
    Given I navigate to Marketing page
    And I click on login link
    And I enter the following for Login
      | Email                         | Password     |
      | clvien.general@mailinator.com | Changeit@123 |
    And I click on login button
    Then I should see engagement page
    And I click on engagement: "En02"
    Then I should see engagement detail page with Engagement Title Uneditable: "En02"
    Then I should see all to do assigned : ToDo 01,ToDo 04,Todo 06,Todo 09
