package com.auvenir.ui.bdd.stepDefinitions.admin;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.AdminPage;
import com.auvenir.ui.bdd.pages.auditor.AuditorSignUpPage;
import cucumber.api.DataTable;
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
    @Then("^I should see status off user is waitlisted$")
    public void iShouldSeeStatusOffUserIsWaitlisted(DataTable datas) throws Throwable {
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

    @Then("^I should see confirm popup$")
    public void iShouldSeeConfirmPopup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see confirm popup");
        adminPage.vefiryConfirmPopupDisplay();
    }

    @And("^I click confirm button$")
    public void iClickConfirmButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click confirm button");
        adminPage.clickConfirmButton();
    }

    @Then("^I should see verified message succesfull$")
    public void iShouldSeeVerifiedMessageSuccesfull() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see verified message succesfull");
        adminPage.verifyMessageSuccessful();
    }
}
