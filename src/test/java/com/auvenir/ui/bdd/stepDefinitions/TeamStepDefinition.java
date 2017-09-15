package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTeamPage;
import com.auvenir.ui.bdd.pages.client.ClientTeamPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class TeamStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TeamStepDefinition.class.getSimpleName());
    BaseInit baseInit;
    AuditorTeamPage auditorTeamPage;
    ClientTeamPage clientTeamPage;

    public TeamStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        auditorTeamPage = new AuditorTeamPage(logger, driver);
        clientTeamPage = new ClientTeamPage(logger, driver);
    }

    @And("^I click in invite new member on team page$")
    public void iClickInInviteNewMemberOnTeamPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click in invite new member on team page");
        auditorTeamPage.clickInviteMember();
    }

    @Then("^I should see invite new member page$")
    public void iShouldSeeInviteNewMemberPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see invite new member page");
        auditorTeamPage.verifyInviteNewMemberPageDisplayed();
    }

    @And("^I select role of new member$")
    public void iSelectRoleOfNewMember() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select role of new member");
        auditorTeamPage.selectRoleMember();
    }

    @And("^I input role of new member$")
    public void inputRoleOfNewMember() throws Throwable {
        // Hard code role of Client
        logger.info("I select role of new member");
        clientTeamPage.inputMemberRole("Manager");
    }

    @And("^I click on invite new member$")
    public void iClickOnInviteNewMember() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on invite new member");
        auditorTeamPage.clickButtonInviteNewMember();
    }

    @Then("^I should see invite successful message$")
    public void iShouldSeeInviteSuccessfulMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see invite successful message");
        auditorTeamPage.verifyAddNewMemberSuccessful();
    }

    @And("^I input full name on invite new member page: \"([^\"]*)\"$")
    public void iInputFullNameOnInviteNewMemberPage(String fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input full name on invite new member page");
        auditorTeamPage.inputFullName(fullName);
    }

    @And("^I input email on invite new member page: \"([^\"]*)\"$")
    public void iInputEmailOnInviteNewMemberPage(String strEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input email on invite new member page");
        auditorTeamPage.inputEmail(strEmail);
    }

    @And("^I input email confirm on invite new member page: \"([^\"]*)\"$")
    public void iInputEmailConfirmOnInviteNewMemberPage(String strEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input email confirm on invite new member page");
        auditorTeamPage.inputEmailConfirm(strEmail);
    }

    @And("^I click on Invite New Member button on Client team page$")
    public void iClickOnInviteNewMemberButtonOnClientTeamPage() throws Throwable {
        logger.info("I click in invite new member on client team page");
        clientTeamPage.clickInviteMember();
    }

    @Then("^I should see Invite New Member popup$")
    public void iShouldSeeInviteNewMemberPopup() throws Throwable {
        logger.info("I should see invite new member popup");
        clientTeamPage.verifyInviteNewMemberPageDisplayed();
    }

    @And("^I input full name on invite new member popup: \"([^\"]*)\"$")
    public void iInputFullNameOnInviteNewMemberPopup(String clientFullName) throws Throwable {
        logger.info("I input full name on invite new member popup");
        clientTeamPage.inputFullName(clientFullName);
    }

    @And("^I input email on invite new member popup: \"([^\"]*)\"$")
    public void iInputEmailOnInviteNewMemberPopup(String email) throws Throwable {
        logger.info("I input client email on invite new member popup");
        clientTeamPage.inputEmail(email);
    }

    @And("^I input email confirm on invite new member popup: \"([^\"]*)\"$")
    public void iInputEmailConfirmOnInviteNewMemberPopup(String email) throws Throwable {
        logger.info("I confirm client email on invite new member popup");
        clientTeamPage.inputEmailConfirm(email);
    }

    @And("^I input Role of new client member on invite new member popup: \"([^\"]*)\"$")
    public void iInputRoleOfNewClientMemberOnInviteNewMemberPopup(String roleName) throws Throwable {
        logger.info("I confirm client email on invite new member popup");
        clientTeamPage.inputMemberRole(roleName);
    }

    @And("^I click on invite button$")
    public void iClickOnInviteButton() throws Throwable {
        logger.info("I click Invite button");
        clientTeamPage.clickButtonInviteNewMember();
    }

    @Then("^I should see Invite Member successful message$")
    public void iShouldSeeInviteMemberSuccessfulMessage() throws Throwable {
        logger.info("Verify message of completed invitation");
        clientTeamPage.verifyAddNewMemberSuccessful();
    }

    @And("^I delete existed member on team page: \"([^\"]*)\"$")
    public void iDeleteExistedMemberOnTeamPage(String fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I delete existed member on team page");
        auditorTeamPage.deleteMemberInEngagementByName(fullName);
    }

    @And("^I change the permission of member: \"([^\"]*)\" to be Lead$")
    public void changeThePermissionOfMember(String memberName) throws Throwable {
        logger.info("I am going change the permission of Member: " + memberName);
        clientTeamPage.changePermissionOfMember(memberName);
    }
}
