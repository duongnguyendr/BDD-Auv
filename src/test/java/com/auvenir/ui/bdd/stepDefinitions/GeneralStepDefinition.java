package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class GeneralStepDefinition extends BaseInit {
    private Logger logger = Logger.getLogger(GeneralStepDefinition.class.getSimpleName());
    private BaseInit base;
    private MarketingPage marketingPage;
    public GeneralStepDefinition(BaseInit base) {
        this.base = base;
        marketingPage = new MarketingPage(logger, driver);
    }



    @Given("^I navigate to Marketing page$")
    public void iNavigateToMarketingPage() throws Throwable {
        logger.info("===== I navigate to login page =====");
        logger.info("==========" + baseUrl);
        marketingPage.getUrl("https://" + baseUrl);
    }




}
