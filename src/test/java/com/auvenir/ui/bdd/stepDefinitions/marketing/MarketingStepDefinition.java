package com.auvenir.ui.bdd.stepDefinitions.marketing;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingNewPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 8/30/2017.
 */
public class MarketingStepDefinition extends BaseInit {
    private BaseInit base;
    public MarketingStepDefinition(BaseInit base) {
        this.base = base;
    }
    private MarketingNewPage marketingNewPage;

    @And("^I click on login link$")
    public void iClickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.clickOnLoginBTN();
    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I enter the following for login =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The Username is: "+user.username);
            System.out.println("The Password is: "+user.password);
            marketingNewPage.inputUserNamePassword(user.username, user.password);
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
        getLogger().info("===== I click on login button =====");
        /*MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.clickOnSubmitBTN();


    }
    @Then("^I should see the home page$")
    public void iShouldSeeTheHomePage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I should see the home page =====");
        /*AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.verifyHeaderAdminPage();
    }
}
