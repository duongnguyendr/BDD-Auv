package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingNewPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

    @Given("^I navigate to Marketing page$")
    public void iNavigateToMarketingPage() throws Throwable {
        base.getLogger().info("===== I navigate to login page =====");
        MarketingNewPage marketingNewPage = new MarketingNewPage(logger,driver);
        getLogger().info("=========="+baseUrl);
        marketingNewPage.getUrl("https://"+baseUrl);
    }

}
