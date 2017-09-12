package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorEngagementPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class AuditorEngagementStepDefinition extends BaseInit{
    BaseInit baseInit;
    AuditorEngagementPage auditorEngagementPage;
    public AuditorEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorEngagementPage = new AuditorEngagementPage(logger, driver);
    }

    @Then("^I should see engagement page$")
    public void iShouldSeeEngagementPage() throws Throwable{
        getLogger().info("I should see engagement page");
        auditorEngagementPage.verifyEngagementPage();
    }

    @And("^I click create new engagement button$")
    public void iClickCreateNewEngagementButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click create new engagement button");
        auditorEngagementPage.clickNewEngagementButton();
    }

    @And("^I click on engagement: \"([^\"]*)\"$")
    public void iClickOnEngagement(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on engagement: " + engagementName);
        auditorEngagementPage.viewEngagementDetailsPage(engagementName);
    }

}
