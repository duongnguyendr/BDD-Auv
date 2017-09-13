package com.auvenir.ui.bdd.stepDefinitions.client;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.client.ClientDetailsEngagementPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by vien.pham on 9/12/2017.
 */
public class ClientDetailEngagementStepDefinition extends BaseInit {

    BaseInit baseInit;
    ClientDetailsEngagementPage clientDetailsEngagementPage;

    public ClientDetailEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        clientDetailsEngagementPage = new ClientDetailsEngagementPage(logger, driver);
    }

    @Then("^I should see the title of selected engagement: \"([^\"]*)\"$")
    public void iShouldSeeTheTitleOfSelectedEngagement(String engagementName) throws Throwable {
        clientDetailsEngagementPage.verifyDetailsEngagementPage(engagementName,false);
    }


    @And("^I click on Team tab on Client page$")
    public void iClickOnTeamTabOnClientPage() throws Throwable {
        logger.info("Client click on Team tab");
        clientDetailsEngagementPage.navigateToTeamTab();
    }

}
