package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class EngagementDetailStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    public EngagementDetailStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
    }

    @And("^I click on team tab$")
    public void iClickOnTeamTab() throws Throwable{
        getLogger().info("I click on team tab");
        auditorDetailsEngagementPage.navigateToTeamTab();
    }

    @Then("^I should see engagement detail page: \"([^\"]*)\"$")
    public void iShouldSeeEngagementDetailPage(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see engagement detail page");
        auditorDetailsEngagementPage.verifyDetailsEngagementPage(engagementName);
    }
}
