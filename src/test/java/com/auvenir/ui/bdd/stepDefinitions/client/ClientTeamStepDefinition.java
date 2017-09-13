package com.auvenir.ui.bdd.stepDefinitions.client;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTeamPage;
import com.auvenir.ui.bdd.pages.client.ClientTeamPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import sun.management.BaseOperatingSystemImpl;

/**
 * Created by vien.pham on 9/12/2017.
 */
public class ClientTeamStepDefinition extends BaseInit {

    BaseInit baseInit;
    ClientTeamPage clientTeamPage;

    public ClientTeamStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        clientTeamPage = new ClientTeamPage(logger, driver);
    }


    @And("^I click on Invite New Member button on Client team page$")
    public void iClickOnInviteNewMemberButtonOnClientTeamPage() throws Throwable {
        getLogger().info("I click in invite new member on client team page");
        clientTeamPage.clickInviteMember();
    }

    @Then("^I should see Invite New Member popup$")
    public void iShouldSeeInviteNewMemberPopup() throws Throwable {
        getLogger().info("I should see invite new member popup");
        clientTeamPage.verifyInviteNewMemberPageDisplayed();
    }

    @And("^I input full name on invite new member popup: \"([^\"]*)\"$")
    public void iInputFullNameOnInviteNewMemberPopup(String clientFullName) throws Throwable {
        getLogger().info("I input full name on invite new member popup");
        clientTeamPage.inputFullName(clientFullName);
    }

    @And("^I input email on invite new member popup: \"([^\"]*)\"$")
    public void iInputEmailOnInviteNewMemberPopup(String email) throws Throwable {
        getLogger().info("I input client email on invite new member popup");
        clientTeamPage.inputEmail(email);
    }

    @And("^I input email confirm on invite new member popup: \"([^\"]*)\"$")
    public void iInputEmailConfirmOnInviteNewMemberPopup(String email) throws Throwable {
        getLogger().info("I confirm client email on invite new member popup");
        clientTeamPage.inputEmailConfirm(email);
    }

    @And("^I input Role of new client member on invite new member popup: \"([^\"]*)\"$")
    public void iInputRoleOfNewClientMemberOnInviteNewMemberPopup(String roleName) throws Throwable {
        getLogger().info("I confirm client email on invite new member popup");
        clientTeamPage.inputMemberRole(roleName);
    }

    @And("^I click on invite button$")
    public void iClickOnInviteButton() throws Throwable {
        getLogger().info("I click Invite button");
        clientTeamPage.clickButtonInviteNewMember();
    }

    @Then("^I should see Invite Member successful message$")
    public void iShouldSeeInviteMemberSuccessfulMessage() throws Throwable {
        getLogger().info("Verify message of completed invitation");
        clientTeamPage.verifyAddNewMemberSuccessful();
    }
}
