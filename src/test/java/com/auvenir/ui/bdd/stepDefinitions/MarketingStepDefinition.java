package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.admin.AdminPage;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 8/30/2017.
 */
public class MarketingStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(MarketingStepDefinition.class.getSimpleName());
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
        logger.info("===== I click on login link =====");
        marketingPage.clickOnLoginBTN();

    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I enter the following for login =====");

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The Email is: "+user.email);
            System.out.println("The Password is: "+user.password);
            marketingPage.inputUserNamePassword(user.email, user.password);
        }
    }

    @And("^I click sign up link$")
    public void iClickSignUpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login link =====");
        marketingPage.clickOnSignupButton();
    }

    @Then("^I should see marketing portal page$")
    public void iShouldSeeMarketingPortalPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see marketing portal page");
        marketingPage.verifyMaketingHeaderPage();

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
        logger.info("===== I click on login button =====");
        /*MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();*/
        //MarketingPage MarketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();
        marketingPage.waitForProgressOverlayIsClosed();
    }

}
