package com.auvenir.ui.bdd.stepDefinitions.marketing;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.AdminPage;
import com.auvenir.ui.bdd.pages.marketing.MarketingNewPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by doai.tran on 8/30/2017.
 */
public class MarketingStepDefinition extends BaseInit {
    private BaseInit base;
    private MarketingNewPage marketingNewPage;
    private AdminPage adminPage;
    public MarketingStepDefinition(BaseInit base) {
        this.base = base;
        adminPage = new AdminPage(logger, driver);
    }


    @And("^I click on login link$")
    public void iClickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.clickOnLoginBTN();
    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I enter the following for login =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The Username is: "+user.username);
            System.out.println("The Password is: "+user.password);
            marketingNewPage.inputUserNamePassword(user.username, user.password);
        }
    }

    @And("^I click sign up link$")
    public void iClickSignUpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.clickOnSignupButton();
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

    public class User{
        public String username;
        public String password;
        public User (String userName, String passWord){
            username = userName;
            password = passWord;
        }
    }
    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login button =====");
        /*MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.clickOnSubmitBTN();


    }
    @Then("^I should see the home page$")
    public void iShouldSeeTheHomePage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I should see the home page =====");
        /*AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        marketingNewPage.verifyHeaderAdminPage();
    }
}
