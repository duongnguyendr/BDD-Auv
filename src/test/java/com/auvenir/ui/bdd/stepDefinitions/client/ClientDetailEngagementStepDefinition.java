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
    @Then("^I should see client engagement detail page$")
    public void iShouldSeeClientEngagementDetailPage(List<String> engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see client engagement detail page");
        clientDetailsEngagementPage.verifyDetailsEngagementPage(engagementName.get(0),false);
    }

    @And("^I click on Client team tab$")
    public void iClickOnClientTeamTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
