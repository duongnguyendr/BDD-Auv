package com.auvenir.ui.bdd.stepDefinitions.client;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorSignUpPage;
import com.auvenir.ui.bdd.pages.client.ClientSignUpPage;
import cucumber.api.java.en.And;

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

    @And("^I should see Welcome to Auvenir Page$")
    public void iVerifyWelcomePageTitle() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see Welcome to Auvenir Page");
        clientSignUpPage.verifyWelcomePageTitle();
    }
}
