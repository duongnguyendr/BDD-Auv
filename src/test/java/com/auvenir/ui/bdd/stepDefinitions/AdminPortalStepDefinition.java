package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.admin.AdminPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by doai.tran on 9/8/2017.
 */
public class AdminPortalStepDefinition extends BaseInit {
    BaseInit baseInit;
    private AdminPage adminPage;
    public AdminPortalStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        adminPage = new AdminPage(logger, driver);
    }

    @Then("^I should see the AdminPortal page$")
    public void iShouldSeeTheAdminPortalPage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I should see the home page =====");
        /*AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();*/
        //MarketingPage MarketingPage = new MarketingPage(logger,driver);
        adminPage.verifyHeaderAdminPage();
    }
    @Then("^I should see status of user is wait listed$")
    public void iShouldSeeStatusOfUserIsWaitListed(DataTable datas) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see status off user is waitlisted");
        List<String> listData = datas.asList(String.class);
        adminPage.verifyUserStatusAsExpected(listData.get(0), listData.get(1));
    }

    @And("^I change status of user to onboarding$")
    public void iChangeStatusOfUserToOnboarding(DataTable datas) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I change status of user to onboarding");
        List<String> listData = datas.asList(String.class);
        adminPage.changeStatusUser(listData.get(0), listData.get(1));
    }

    @Then("^I should see confirm popup on admin page$")
    public void iShouldSeeConfirmPopupOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see confirm popup");
        adminPage.vefiryConfirmPopupDisplay();
    }

    @And("^I click confirm button on admin page$")
    public void iClickConfirmButtonOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click confirm button");
        adminPage.clickConfirmButton();
    }

    @Then("^I should see verified message successful on admin page$")
    public void iShouldSeeVerifiedMessageSuccessfulOnAdminPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see verified message successful");
        adminPage.verifyMessageSuccessful();
    }

    @Then("^I should see status of user is onboarding$")
    public void iShouldSeeStatusOffUserIsOnboarding(DataTable datas) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see status of user is Onboarding");
        List<String> listData = datas.asList(String.class);
        adminPage.verifyUserStatusAsExpected(listData.get(0), listData.get(1));
    }

}