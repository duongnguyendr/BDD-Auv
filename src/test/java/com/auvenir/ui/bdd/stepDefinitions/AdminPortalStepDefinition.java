package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.admin.AdminPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by doai.tran on 9/8/2017.
 */
public class AdminPortalStepDefinition extends BaseInit {
    BaseInit baseInit;
    private AdminPage adminPage;
    private static Logger logger = Logger.getLogger(AdminPortalStepDefinition.class.getSimpleName());
    public AdminPortalStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        adminPage = new AdminPage(logger, driver);
    }

    @Then("^I should see the AdminPortal page$")
    public void iShouldSeeTheAdminPortalPage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I should see the home page =====");
        /*AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();*/
        //MarketingPage MarketingPage = new MarketingPage(logger,driver);
        adminPage.verifyHeaderAdminPage();
    }

    @Then("^I should see confirm popup on admin page$")
    public void iShouldSeeConfirmPopupOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see confirm popup");
        adminPage.vefiryConfirmPopupDisplay();
    }

    @And("^I click confirm button on admin page$")
    public void iClickConfirmButtonOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click confirm button");
        adminPage.clickConfirmButton();
    }

    @Then("^I should see verified message successful on admin page$")
    public void iShouldSeeVerifiedMessageSuccessfulOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see verified message successful");
        adminPage.verifyMessageSuccessful();
    }

    @Then("^I should see status of user: \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iShouldSeeStatusOfUserIs(String user, String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see status off user: " + user + " is " + status);
        adminPage.verifyUserStatusAsExpected(user, status);
    }

    @And("^I change status of user: \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iChangeStatusOfUserTo(String user, String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I change status of user: " + user + " to " + status);
        adminPage.changeStatusUser(user, status);
    }
}
