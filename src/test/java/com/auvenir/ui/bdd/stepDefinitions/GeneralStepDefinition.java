package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.AdminPage;
import com.auvenir.ui.bdd.pages.MarketingNewPage;
import com.auvenir.ui.bdd.pages.MarketingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.jfree.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class GeneralStepDefinition extends BaseInit{
    private BaseInit base;
    public GeneralStepDefinition(BaseInit base) {
        this.base = base;
    }
    private MarketingNewPage marketingNewPage;

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws Throwable {
        base.getLogger().info("I navigate to login page.");
        MarketingNewPage marketingNewPage = new MarketingNewPage(driver);
    }

    @And("^I click on login link$")
    public void iClickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I click on login link =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(driver);
        marketingNewPage.clickOnLoginBTN();
    }
    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I enter the following for login.");
        //List<List<String>> data = table.raw();
        /*System.out.println(data.get(0).get(0).toString());
        System.out.println(data.get(0).get(1).toString());
        System.out.println(data.get(1).get(0).toString());
        System.out.println(data.get(1).get(1).toString());*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(driver);

        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user: users){
            System.out.println("The Username is: "+user.username);
            System.out.println("The Password is: "+user.password);
            marketingNewPage.inputUserNamePassword(user.username, user.password);
        }
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
        getLogger().info("<3<3<3 I click on login button. <3<3<3");
        /*MarketingPage marketingPage = new MarketingPage(logger,driver);
        marketingPage.clickOnSubmitBTN();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(driver);
        marketingNewPage.clickOnSubmitBTN();


    }
    @Then("^I should see the home page$")
    public void iShouldSeeTheHomePage()throws Throwable{
        //System.out.println("The driver is: "+base.StepInfo);
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see the home page.");
        /*AdminPage adminPage = new AdminPage(logger,driver);
        adminPage.verifyHeaderAdminPage();*/
        MarketingNewPage marketingNewPage = new MarketingNewPage(driver);
        marketingNewPage.verifyHeaderAdminPage();
    }
}
