package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.DataTable;
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
    private BaseInit baseInit;
    private MarketingPage marketingPage;

    public MarketingStepDefinition(BaseInit base) {
        this.baseInit = base;
        marketingPage = new MarketingPage(logger, driver);
    }

    public class User {
        public String email;
        public String password;

        public User(String eMail, String passWord) {
            email = eMail;
            password = passWord;
        }
    }

    @And("^I enter the following for Login$")
    public void enterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I enter the following for login =====");

        table.asMap(String.class, String.class);
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user : users) {
            System.out.println("The Email is: " + user.email);
            System.out.println("The Password is: " + user.password);
            marketingPage.inputUserNamePassword(user.email, user.password);
        }
    }

    @And("^I click on login link$")
    public void clickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login link =====");
        marketingPage.clickOnLoginButton();

    }

    @And("^I click sign up link$")
    public void clickSignUpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login link =====");
        marketingPage.clickOnSignUpButton();
    }

    @Then("^I should see marketing portal page$")
    public void shouldSeeMarketingPortalPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see marketing portal page");
        marketingPage.verifyMaketingHeaderPage();

    }

    @And("^I click on login button$")
    public void clickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login button =====");
        marketingPage.clickOnSubmitButton();
        marketingPage.waitForProgressOverlayIsClosed();
    }
}
