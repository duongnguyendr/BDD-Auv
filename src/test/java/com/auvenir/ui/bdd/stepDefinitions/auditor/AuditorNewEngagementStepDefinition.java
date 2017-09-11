package com.auvenir.ui.bdd.stepDefinitions.auditor;

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
public class AuditorNewEngagementStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorNewEngagementPage auditorNewEngagementPage;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    public AuditorNewEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorNewEngagementPage = new AuditorNewEngagementPage(logger, driver);
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
    }

    @Then("^I should see new engagement page$")
    public void iShouldSeeNewEngagementPage() throws Throwable{
        getLogger().info("I should see new engagement page");
        auditorNewEngagementPage.verifyNewEngagementPage();
    }

    @And("^I input enagagement name$")
    public void iInputEnagagementName(List<String> engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input enagagement name");
        auditorNewEngagementPage.enterEngagementName(engagementName.get(0));
    }

    @And("^I select engagement type$")
    public void iSelectEngagementType(List<String> engagementType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select engagement type");
        auditorNewEngagementPage.selectEngagementType(engagementType.get(0));
    }

    @And("^I select company name$")
    public void iSelectCompanyName(List<String> companyName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select company name");
        auditorNewEngagementPage.selectCompanyName(companyName.get(0));
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

    @And("^I click create todo button$")
    public void iClickCreateTodoButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click create todo button");
        auditorNewEngagementPage.clickCreateToDoBtn();
    }

    @Then("^I should see engagement detail page$")
    public void iShouldSeeEngagementDetailPage(List<String> engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see engagement detail page");
        auditorNewEngagementPage.verifyNewEngagementPopupClose();
        auditorDetailsEngagementPage.verifyDetailsEngagementPage(engagementName.get(0));
    }
}
