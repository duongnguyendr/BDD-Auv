package com.auvenir.ui.bdd.stepDefinitions.gmail;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.GmailPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.List;

/**
 * Created by duong.nguyen on 9/7/2017.
 */
public class GmailStepDefinition extends BaseInit {
    private BaseInit base;
    GmailPage gmailPage;

    public GmailStepDefinition(BaseInit base) {
        this.base = base;
        gmailPage = new GmailPage(logger, driver);
    }

    @Given("^I navigate to gmail login page$")
    public void iNavigateToGmailLoginPage() throws Throwable {
        getLogger().info("===== I navigate to gmail login page =====");
        gmailPage.goGMail();
    }

    @And("^I signIn gmail$")
    public void iSignInGmail(DataTable users) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I signIn gmail =====");
        List<String> lstData = users.asList(String.class);
        gmailPage.signInGmail(lstData.get(0), lstData.get(1));
    }
}
