package com.auvenir.ui.bdd.stepDefinitions.client;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorSignUpPage;
import com.auvenir.ui.bdd.pages.client.ClientSignUpPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by thuan.duong on 9/12/2017.
 */
public class ClientSignUpStepDefinition extends BaseInit{
    BaseInit baseInit;
    ClientSignUpPage clientSignUpPage;
    public ClientSignUpStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        clientSignUpPage = new ClientSignUpPage(logger, driver);
    }

    @Then("^I should see Welcome to Auvenir Page$")
    public void iVerifyWelcomePageTitle() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see Welcome to Auvenir Page");
        clientSignUpPage.verifyWelcomePageTitle();
    }

    @And("^I click on Get Start button on Client Sign Up Page$")
    public void iClickGetStartedButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see Welcome to Auvenir Page");
        clientSignUpPage.clickGetStartedButton();
    }

    @Then("^I should see Provide Information Page$")
    public void iVerifyProvideInfomationPageTitle() throws Throwable {
        getLogger().info("I should see Welcome to Auvenir Page");
        clientSignUpPage.verifyProvideInformationPageTitle();
    }

    @And("^I fill up all Information Page with Phone Number: \"([^\"]*)\"$")
    public void iFillUpAllInformationPage(String phoneNumber) throws Throwable {
        getLogger().info("I fill up all Information Page");
        clientSignUpPage.fillUpPersonalForm(phoneNumber);
    }

    @And("^I click on Continue Button on Personal Information Page")
    public void iClickPersonalContinueButton() throws Throwable {
        getLogger().info("I click on Continue Button on Personal Information Page");
        clientSignUpPage.clickPersonalContinueButton();
    }

    @Then("^I should see Business Information Page")
    public void seeBusinessInformationPage() throws Throwable {
        getLogger().info("I should see Business Information Page");
        clientSignUpPage.verifyBusinessPageTitle();
    }



}
