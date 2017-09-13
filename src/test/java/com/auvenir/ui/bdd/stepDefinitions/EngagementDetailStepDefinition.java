package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.client.ClientDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.common.DetailsEngagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class EngagementDetailStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    ClientDetailsEngagementPage clientDetailsEngagementPage;
    DetailsEngagementPage detailsEngagementPage;
    public EngagementDetailStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
        clientDetailsEngagementPage = new ClientDetailsEngagementPage(logger, driver);
        detailsEngagementPage = new DetailsEngagementPage(logger, driver);
    }

    @And("^I click on team tab$")
    public void iClickOnTeamTab() throws Throwable{
        getLogger().info("I click on team tab");
        detailsEngagementPage.navigateToTeamTab();
    }

    @Then("^I should see engagement detail page with Engagement Title Editable: \"([^\"]*)\"$")
    public void iShouldSeeEngagementDetailPage(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see engagement detail page");
        detailsEngagementPage.verifyDetailsEngagementPageEditable(engagementName);
    }

    @Then("^I should see engagement detail page with Engagement Title Uneditable: \"([^\"]*)\"$")
    public void iShouldSeeTheTitleOfSelectedEngagement(String engagementName) throws Throwable {
        detailsEngagementPage.verifyDetailsEngagementPageUnEditable(engagementName);
    }


    @And("^I click on Team tab on Client page$")
    public void iClickOnTeamTabOnClientPage() throws Throwable {
        getLogger().info("Client click on Team tab");
        detailsEngagementPage.navigateToTeamTab();
    }
}
