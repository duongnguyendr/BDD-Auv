package com.auvenir.ui.bdd.stepDefinitions.gmail;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.mail.MailPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.List;

/**
 * Created by duong.nguyen on 9/7/2017.
 */
public class GmailStepDefinition extends BaseInit {
    private BaseInit base;
    MailPage mailPage;

    public GmailStepDefinition(BaseInit base) {
        this.base = base;
        mailPage = new MailPage(logger, driver);
    }

    @Given("^I navigate to gmail login page$")
    public void iNavigateToGmailLoginPage() throws Throwable {
        getLogger().info("===== I navigate to gmail login page =====");
        mailPage.goGMail();
    }

    @And("^I signIn gmail$")
    public void iSignInGmail(DataTable users) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I signIn gmail =====");
        List<String> lstData = users.asList(String.class);
        mailPage.signInGmail(lstData.get(0), lstData.get(1));
    }

    @And("^I open Auditor active email$")
    public void iOpenAuditorActiveEmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select Auditor active email");
        mailPage.selectActiveEmail();
    }

    @And("^I click on confirmation link$")
    public void iClickOnConfirmationLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on confirmation link");
        mailPage.navigateToConfirmationLink();
    }
}
