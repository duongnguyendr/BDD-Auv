package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTeamPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by duong.nguyen on 9/11/2017.
 */
public class AuditorTeamStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorTeamPage auditorTeamPage;
    public AuditorTeamStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorTeamPage = new AuditorTeamPage(logger, driver);
    }

    @And("^I delete existed member on team page$")
    public void iDeleteExistedMemberOnTeamPage(List<String> fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I delete existed member on team page");
        auditorTeamPage.deleteMemberInEngagementByName(fullName.get(0));
    }

    @And("^I click in invite new member on team page$")
    public void iClickInInviteNewMemberOnTeamPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click in invite new member on team page");
        auditorTeamPage.clickInviteMember();
    }

    @Then("^I should see invite new member page$")
    public void iShouldSeeInviteNewMemberPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see invite new member page");
        auditorTeamPage.verifyInviteNewMemberPageDisplayed();
    }

    @And("^I input full name on invite new member page$")
    public void iInputFullNameOnInviteNewMemberPage(List<String> fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input full name on invite new member page");
        auditorTeamPage.inputFullName(fullName.get(0));
    }

    @And("^I input email on invite new member page$")
    public void iInputEmailOnInviteNewMemberPage(List<String> strEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input email on invite new member page");
        auditorTeamPage.inputEmail(strEmail.get(0));
    }

    @And("^I input email confirm on invite new member page$")
    public void iInputEmailConfirmOnInviteNewMemberPage(List<String> strEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input email confirm on invite new member page");
        auditorTeamPage.inputEmailConfirm(strEmail.get(0));
    }

    @And("^I select role of new member$")
    public void iSelectRoleOfNewMember() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select role of new member");
        auditorTeamPage.selectRoleMember();
    }

    @And("^I click on invite new member$")
    public void iClickOnInviteNewMember() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on invite new member");
        auditorTeamPage.clickButtonInviteNewMember();
    }

    @Then("^I should see invite successful message$")
    public void iShouldSeeInviteSuccessfulMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see invite successful message");
        auditorTeamPage.verifyAddNewMemberSuccessful();
    }

}
