package com.auvenir.ui.bdd.stepDefinitions.client;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.client.ClientEngagementPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;


/**
 * Created by vien.pham on 9/12/2017.
 */
public class ClientEngagementStepDefinition extends BaseInit {
    BaseInit baseInit;
    ClientEngagementPage clientEngagementPage;
    public ClientEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        clientEngagementPage = new ClientEngagementPage(logger,driver);
    }


    @Then("^I should see client engagement page$")
    public void iShouldSeeClientEngagementPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see client engagement page");
        clientEngagementPage.verifyEngagementPage();
    }

    @And("^I click on client engagement$")
    public void iClickOnClientEngagement(List<String> EngagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on client engagement: "+EngagementName.get(0));
        clientEngagementPage.viewEngagementDetailsPage(EngagementName.get(0));
    }


}
