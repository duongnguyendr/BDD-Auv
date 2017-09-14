package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.auditor.AuditorNewEngagementPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class NewEngagementStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorNewEngagementPage auditorNewEngagementPage;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    public NewEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorNewEngagementPage = new AuditorNewEngagementPage(logger, driver);
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
    }

    @Then("^I should see new engagement page$")
    public void iShouldSeeNewEngagementPage() throws Throwable{
        getLogger().info("I should see new engagement page");
        auditorNewEngagementPage.verifyNewEngagementPage();
    }

    @And("^I set report deadline$")
    public void iSetReportDeadline() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I set report deadline");
        auditorNewEngagementPage.enterDeadLineDate(auditorNewEngagementPage.getDate(10));
    }

    @And("^I set start date$")
    public void iSetStartDate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I set start date");
        auditorNewEngagementPage.enterStartDate(auditorNewEngagementPage.getDate(0));
    }

    @And("^I set end date$")
    public void iSetEndDate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I set end date");
        auditorNewEngagementPage.enterEndDate(auditorNewEngagementPage.getDate(10));
    }

    @And("^I click on engagement continue button$")
    public void iClickOnEngagementContinueButton() throws Throwable{
        getLogger().info("I click on continue button");
        auditorNewEngagementPage.clickContinueBtn();
    }

    @Then("^I should see team member wizard page$")
    public void iShouldSeeTeamMemberWizardPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see team member wizard page");
        auditorNewEngagementPage.verifyTeamMemberWizardPage();
    }

    @And("^I click continue button without member$")
    public void iClickContinueButtonWithoutMember() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click continue button without member");
        auditorNewEngagementPage.clickNoMemberBtn();
    }

    @And("^I should see create todo list page$")
    public void iShouldSeeCreateTodoListPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see create todo list page");
        auditorNewEngagementPage.verifyCreateTodoListPage();
    }

    @And("^I click create todo button on Create New Engagement Page$")
    public void clickCreateTodoButtonOnCreateNewEngagement() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click create todo button");
        auditorNewEngagementPage.clickCreateToDoBtn();
        auditorDetailsEngagementPage.verifyNewEngagementPopupClose();
    }

    @And("^I input engagement name: \"([^\"]*)\"$")
    public void iInputEngagementName(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input engagement name");
        auditorNewEngagementPage.enterEngagementName(engagementName);
    }

    @And("^I select engagement type: \"([^\"]*)\"$")
    public void iSelectEngagementType(String engagementType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select engagement type");
        auditorNewEngagementPage.selectEngagementType(engagementType);
    }

    @And("^I select company name: \"([^\"]*)\"$")
    public void iSelectCompanyName(String companyName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select company name");
        auditorNewEngagementPage.selectCompanyName(companyName);
    }
}
