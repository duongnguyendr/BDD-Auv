package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.GeneralUtilities;
import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class GeneralStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(GeneralStepDefinition.class.getSimpleName());
    private BaseInit base;

    private MarketingPage marketingPage;

    public GeneralStepDefinition(BaseInit base) {
        this.base = base;
        marketingPage = new MarketingPage(logger, driver);
    }

    @Given("^I navigate to Marketing page$")
    public void navigateToMarketingPage() throws Throwable {
        base.logger.info("===== I navigate to login page =====");
        logger.info("==========" + baseUrl);
        marketingPage.getUrl("https://" + baseUrl);
    }

    @And("^I delete existed file: \"([^\"]*)\" in download folder$")
    public void iDeleteExistedFileInDownloadFolder(String fileName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Check file: " + fileName + " exist in download folder and delete if any.");
        GeneralUtilities.checkFileExists(Generic.FOLDER_DOWNLOAD + fileName, true);
    }
}
