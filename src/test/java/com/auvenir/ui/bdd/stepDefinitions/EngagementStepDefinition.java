package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorEngagementPage;
import com.auvenir.ui.bdd.pages.client.ClientEngagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class EngagementStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(EngagementStepDefinition.class.getSimpleName());
    BaseInit baseInit;
    AuditorEngagementPage auditorEngagementPage;
    ClientEngagementPage clientEngagementPage;
    public EngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorEngagementPage = new AuditorEngagementPage(logger, driver);
        clientEngagementPage = new ClientEngagementPage(logger, driver);
    }

    @Then("^I should see engagement page$")
    public void iShouldSeeEngagementPage() throws Throwable{
        logger.info("I should see engagement page");
        auditorEngagementPage.verifyEngagementPage();
    }

    @And("^I click create new engagement button$")
    public void iClickCreateNewEngagementButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click create new engagement button");
        auditorEngagementPage.clickNewEngagementButton();
    }

    @And("^I click on engagement: \"([^\"]*)\"$")
    public void iClickOnEngagement(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on engagement: " + engagementName);
        auditorEngagementPage.viewEngagementDetailsPage(engagementName);
    }

    @Then("^I should see client engagement page$")
    public void iShouldSeeClientEngagementPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see client engagement page");
        clientEngagementPage.verifyEngagementPage();
    }

    @And("^I click on assigned engagement: \"([^\"]*)\"$")
    public void iClickOnAssignedEngagement(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        clientEngagementPage.viewEngagementDetailsPage(engagementName);
    }
}
