package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.CareerPage;
import com.auvenir.ui.pages.SupportPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/29/2017.
 */
public class SupportService extends AbstractService {
    SupportPage supportPage;
    AuvenirPage auvenirPage;
    /*
    * contructor
    */
    public SupportService(Logger logger, WebDriver driver) {
        super(logger, driver);
        supportPage = new SupportPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void clickOnSupportLink(){
        auvenirPage.clickOnSupportLink();
    }

    public void verifyContentSupportPage(){
        supportPage.verifyContentSupportPage();
    }

    public void verifyFooterSupportPage() {
        supportPage.verifyFooterSupportPage();
    }

}
