package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.AdminPage;
import com.auvenir.ui.bdd.pages.MarketingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class GeneralStepDefinition extends BaseInit{
    private BaseInit base;
    public GeneralStepDefinition(BaseInit base) {
        this.base = base;
    }
    private MarketingPage marketingPage;

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws Throwable {
        System.out.println("I navigate to login page.");
        MarketingPage marketingPage = new MarketingPage(logger,driver);
    }

    @And("^I click on login link$")
    public void iClickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I click on login link.");
        MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnLoginBTN();
    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter the following for login.");
        //List<List<String>> data = table.raw();
        /*System.out.println(data.get(0).get(0).toString());
        System.out.println(data.get(0).get(1).toString());
        System.out.println(data.get(1).get(0).toString());
        System.out.println(data.get(1).get(1).toString());*/
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        MarketingPage marketingPage = new MarketingPage(logger,driver);
        for (User user: users){
            System.out.println("The Username is: "+user.username);
            System.out.println("The Password is: "+user.password);
            marketingPage.inputUserNamePassword(user.username, user.password);
        }
    }
    public class User{
        public String username;
        public String password;
        public User (String userName, String passWord){
            username = userName;
            password = passWord;
        }
    }
    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I click on login button.");
        MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();

    }
    @Then("^I should see the home page$")
    public void iShouldSeeTheHomePage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I should see the home page.");
        AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();
    }
}
