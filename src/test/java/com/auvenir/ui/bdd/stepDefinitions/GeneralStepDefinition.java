package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class GeneralStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(GeneralStepDefinition.class.getSimpleName());
    private BaseInit base;

    public GeneralStepDefinition(BaseInit base) {
        this.base = base;
    }

    private MarketingPage marketingPage;

    @Given("^I navigate to Marketing page$")
    public void iNavigateToMarketingPage() throws Throwable {
        base.logger.info("===== I navigate to login page =====");
        MarketingPage marketingPage = new MarketingPage(logger, driver);
        logger.info("==========" + baseUrl);
        marketingPage.getUrl("https://" + baseUrl);
    }
}
