package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class AuditorDetailEngagementStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;

    public AuditorDetailEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
    }

    @And("^I click on team tab$")
    public void iClickOnTeamTab() throws Throwable{
        getLogger().info("I click on team tab");
        auditorDetailsEngagementPage.navigateToTeamTab();
    }

    @Then("^I should see engagement detail page$")
    public void iShouldSeeEngagementDetailPage(List<String> engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see engagement detail page");
        auditorDetailsEngagementPage.verifyNewEngagementPopupClose();
        auditorDetailsEngagementPage.verifyDetailsEngagementPage(engagementName.get(0));
    }

}
