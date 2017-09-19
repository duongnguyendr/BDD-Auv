package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.client.ClientDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.common.DetailsEngagementPage;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class EngagementDetailStepDefinition extends BaseInit {
    BaseInit baseInit;
    private static Logger logger = Logger.getLogger(EngagementDetailStepDefinition.class.getSimpleName());
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    ClientDetailsEngagementPage clientDetailsEngagementPage;
    DetailsEngagementPage detailsEngagementPage;

    public EngagementDetailStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
        clientDetailsEngagementPage = new ClientDetailsEngagementPage(logger, driver);
        detailsEngagementPage = new DetailsEngagementPage(logger, driver);
    }

    @And("^I click on Team tab of engagment detail page $")
    public void iClickOnTeamTab() throws Throwable {
        logger.info("I click on team tab");
        detailsEngagementPage.navigateToTeamTab();
    }

    @Then("^I should see engagement detail page with Engagement Title Editable: \"([^\"]*)\"$")
    public void iShouldSeeEngagementDetailPage(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see engagement detail page");
        detailsEngagementPage.verifyDetailsEngagementPageEditable(engagementName);
    }

    @Then("^I should see engagement detail page with Engagement Title Uneditable: \"([^\"]*)\"$")
    public void iShouldSeeTheTitleOfSelectedEngagement(String engagementName) throws Throwable {
        detailsEngagementPage.verifyDetailsEngagementPageUnEditable(engagementName);
    }


    @And("^I click on Team tab on Client page$")
    public void iClickOnTeamTabOnClientPage() throws Throwable {
        logger.info("Client click on Team tab");
        detailsEngagementPage.navigateToTeamTab();
    }

    @Then("^I click on Invite Client button$")
    public void clickOnInviteClientButton() throws Throwable {
        auditorDetailsEngagementPage.clickInviteClientButton();
    }

    @Then("^I should see Invite Your Client page$")
    public void seeInviteYourClientPage() throws Throwable {
        auditorDetailsEngagementPage.verifyInviteYourClientPage();
    }

    @Then("^I select option Admin Client fullname: \"([^\"]*)\"$")
    public void selectOptionAdminClientFullname(String fullName) throws Throwable {
        auditorDetailsEngagementPage.selectClientWithFullName(fullName);
    }

    @Then("^I click on Invite button$")
    public void clickOnInviteButton() throws Throwable {
        auditorDetailsEngagementPage.clickInviteButton();
    }

    @Then("^I should see invite client success toast message$")
    public void seeInviteClientSuccessToastMessage() throws Throwable {
        auditorDetailsEngagementPage.verifyInviteClientSuccess();
    }

    @And("^I click on invite client button on engagement detail page$")
    public void iClickOnInviteButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on invite client button on engagement detail page");
        auditorDetailsEngagementPage.clickOnInviteClientBtn();
    }

    @And("^I click on Team tab of engagement detail page$")
    public void iClickOnTeamTabOfEngagementDetailPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("=====I click on Team tab of engagement detail page=====");
        detailsEngagementPage.navigateToTeamTab();
    }


    @Then("^I click on engagement tab return engagement page$")
    public void iClickOnEngagementTabReturnEngagementPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("=====I click on engagement tab return engagement page=====");
        detailsEngagementPage.navigateToEngagementTab();
    }
}
