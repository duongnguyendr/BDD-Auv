**Auvenir Automation Framework**



===================================

**1.Project Description:**

It is a automation testing framework to support automation web testing for Auvenir.
**BDD - Behavior Driven Development framework**. It is built to help a non-technical user understand and execute test script more easily.
Framework is built on Integration from _**Maven project, Selenium and Cucumber**_

**2. Feature file**

We will input and create test script for each test suite to run automation with _.feature_ file.
 The content of feature file will be followed Cucumber scenarios consist of steps, also known as Givens, Whens and Thens.

Cucumber doesn’t technically distinguish between these three kind of steps. However, we strongly recommend that you do! These words have been carefully selected for their purpose, and you should know what the purpose is to get into the BDD mindset.

_Example_:
    
    Scenario: Verify super admin login.
        Given I navigate to Marketing page
        And I click on login link
        And I enter the following for Login
          | Email | Password |
          | chr.auvenirad@gmail.com | Changeit@123 |
        And I click on login button
        Then I should see the AdminPortal page
        
**3. Run Test:**
we can run test framework on Local (Selenium WebDriver) and Selenium Grid
We can run test script with Maven command line: `_mvn clean verify_` 

Automation framework will execute test scenario, test steps with default configuration:
Browser: _`Chrome`_; toMail and ccMail: _`Null`_; RunMode: _`Local`_
Besides, we can run test script on Selenium Grid with Jenkins Integration

**4. Report in Framework**

Framework is supporting reports with: `HTML report, PDF report, Mail report`.

![alt text](http://i65.tinypic.com/jzh7oo.png)

_References:_

1. Gherkin Language: https://github.com/cucumber/cucumber/wiki/Gherkin

2. Cucumber:
https://github.com/cucumber

3. Maven: https://github.com/cucumber

4. TestNG: 
http://testng.org
