package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
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
    private BaseInit baseInit;
    private MarketingPage marketingPage;

    public MarketingStepDefinition(BaseInit base) {
        this.baseInit = base;
        marketingPage = new MarketingPage(logger, driver);
    }

    @Then("^I should see Forgot Password popup$")
    public void seeForgotPasswordPopup() throws Throwable {
        marketingPage.verifyForgotPasswordPopup();
    }

    @Then("^I input email forgotten password : \"([^\"]*)\"$")
    public void inputEmailForgottenPassword(String email) throws Throwable {
        marketingPage.inputEmailForgottenPassword(email);
    }

    @Then("^I click on Request Reset Link button$")
    public void clickOnRequestResetLinkButton() throws Throwable {
        marketingPage.clickOnRequestResetLinkButton();
    }

    @Then("^I should see Account still processing message")
    public void seeAccountStillProcessingMessage() throws Throwable {
        marketingPage.verifyStillProcessingMessage();
    }

    @Then("^I should see Login popup title$")
    public void seeLoginPopupTitle() throws Throwable {
        marketingPage.verifyLoginPopupTitle();
    }

    @Then("^I should see Header Logo$")
    public void seeHeaderLogo() throws Throwable {
        marketingPage.verifyHeaderLogo();
    }

    @Then("^I should see Login link$")
    public void seeLoginLink() throws Throwable {
        marketingPage.verifyLoginLink();
    }

    @Then("^I should see Sign Up Link$")
    public void seeSignUpLink() throws Throwable {
        marketingPage.seeSignUpLink();
    }

    @Then("^I should see Language Link$")
    public void seeLanguageLink() throws Throwable {
        marketingPage.seeLanguageLink();
    }

    @Then("^I should see Join As Auditor Link$")
    public void seeJoinAsAuditorLink() throws Throwable {
        marketingPage.seeJoinAsAuditorLink();
    }

    @Then("^I redirect to About Page$")
    public void redirectToAboutPage() throws Throwable {
        marketingPage.redirectToAboutPage();
    }

    @Then("^I should see Banner Information$")
    public void seeBannerInfomation() throws Throwable {
        marketingPage.seeBannerInformation();
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

    @And("^I click on forgot password link$")
    public void clickOnForgotPasswordLink() throws Throwable {
        marketingPage.clickOnForgotPasswordLink();
    }

}
