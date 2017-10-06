package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.mail.Gmail;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duong.nguyen on 9/7/2017.
 */
public class GmailStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(GmailStepDefinition.class.getSimpleName());
    private BaseInit base;
    Gmail mailPage;

    public GmailStepDefinition(BaseInit base) {
        this.base = base;
        mailPage = new Gmail(logger, driver);
    }

    @Given("^I navigate to GMail login page$")
    public void iNavigateToGMailLoginPage() throws Throwable {
        logger.info("===== I navigate to gmail login page =====");
       // mailPage.goGMail();
    }

    @And("^I sign In GMail$")
    public void iSignInGMail(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I signIn GMail =====");
        table.asMap(String.class, String.class);
        List<MarketingStepDefinition.User> users = new ArrayList<MarketingStepDefinition.User>();
        users = table.asList(MarketingStepDefinition.User.class);
        for (MarketingStepDefinition.User user : users) {
            System.out.println("The Email is: " + user.email);
            System.out.println("The Password is: " + user.password);
            mailPage.signInEmail(user.email, user.password);

        }
    }

    @And("^I open active email$")
    public void iOpenActiveEmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select Auditor active email");
        mailPage.selectActiveEmail();
    }

    @And("^I click on confirmation link$")
    public void iClickOnConfirmationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on confirmation link");
        mailPage.navigateToConfirmationLink();
    }

    @Given("^I delete existed email$")
    public void iDeleteExistedEmail(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I delete existed email =====");

        table.asMap(String.class, String.class);
        List<MarketingStepDefinition.User> users = new ArrayList<MarketingStepDefinition.User>();
        users = table.asList(MarketingStepDefinition.User.class);
        for (MarketingStepDefinition.User user : users) {
            System.out.println("The Email is: " + user.email);
            System.out.println("The Password is: " + user.password);
            mailPage.deleteAllExistedEmail(user.email, user.password);
        }
    }

    @And("^I relogin gmail: \"([^\"]*)\"$")
    public void iReloginGmail(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I relogin gmail");
       // mailPage.goGMail("Gmail");
     //   mailPage.reSignInGmail(password);
    }

    @And("^I click on onboarding invitation link$")
    public void iClickOnOnboardingInvitationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on onboarding invitation link");
        mailPage.clickOnboardingInvitationLink();
    }

}
