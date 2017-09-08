package com.auvenir.ui.bdd.stepDefinitions.marketing;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.AdminPage;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by doai.tran on 8/30/2017.
 */
public class MarketingStepDefinition extends BaseInit {
    private BaseInit base;
    private MarketingPage marketingPage;
    private AdminPage adminPage;
    public MarketingStepDefinition(BaseInit base) {
        this.base = base;
        adminPage = new AdminPage(logger, driver);
        marketingPage = new MarketingPage(logger,driver);
    }

    @And("^I click on login link$")
    public void iClickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        marketingPage.clickOnLoginBTN();
    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I enter the following for login =====");

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The Username is: "+user.email);
            System.out.println("The Password is: "+user.password);
            marketingPage.inputUserNamePassword(user.email, user.password);
        }
    }

    @And("^I click sign up link$")
    public void iClickSignUpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        marketingPage.clickOnSignupButton();
    }

    public class User{
        public String email;
        public String password;
        public User (String eMail, String passWord){
            email = eMail;
            password = passWord;
        }
    }
    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login button =====");
        /*MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();*/
        //MarketingPage MarketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();
    }

}
