package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.client.InviteNewClientPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class InviteNewClientStepDefinition extends BaseInit {
    BaseInit baseInit;
    InviteNewClientPage inviteNewClientPage;
    public InviteNewClientStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        inviteNewClientPage = new InviteNewClientPage(logger, driver);
    }

    @Then("^I should see invite new client popup$")
    public void iSeeInviteNewClientPopUp(){
        getLogger().info("I should see invite new client popup");
        inviteNewClientPage.verifyInviteClientPopUpDisplay();
    }


    @And("^I select add new client on new client popup$")
    public void iSelectAddNewClientOnNewClientPopup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select add new client on new client popup");
        inviteNewClientPage.selectAddNewClient();
    }

    @And("^I input email on invite client popup: \"([^\"]*)\"$")
    public void iInputEmailOnInviteClientPopup(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input email on invite client popup: " + email);
        inviteNewClientPage.inputEmailClient(email);
    }

    @And("^I input full name: \"([^\"]*)\" on invite client popup$")
    public void iInputFullNameOnInviteClientPopup(String fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input full name on invite client popup: " + fullName);
        inviteNewClientPage.inputFullNameClient(fullName);
    }

    @And("^I input confirm email on invite client popup: \"([^\"]*)\"$")
    public void iInputConfirmEmailOnInviteClientPopup(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input confirm email on invite client popup: " + email);
        inviteNewClientPage.inputConfirmEmail(email);
    }

    @And("^I input role on invite client popup: \"([^\"]*)\"$")
    public void iInputRoleOnInviteClientPopup(String clientRole) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input role on invite client popup: " + clientRole);
        inviteNewClientPage.inputRoleClient(clientRole);
    }

    @And("^I click on invite button on invite client popup$")
    public void iClickOnInviteButtonOnInviteClientPopup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on invite button on invite client popup");
        inviteNewClientPage.clickInviteButton();
    }

    @Then("^I should see message invite successful: \"([^\"]*)\"$")
    public void iShouldSeeMessageInviteSuccessful(String msg) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see message invite successful");
        inviteNewClientPage.verifyInviteClientSuccess(msg);
    }
}
