package com.auvenir.ui.services;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.CareerPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by tan.pham on 5/29/2017.
 */
public class CareerService extends AbstractService {

    CareerPage careerPage;
    AuvenirPage auvenirPage;

    /*
     * contructor
     */
    public CareerService(Logger logger, WebDriver driver) {
        super(logger, driver);
        careerPage = new CareerPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void clickOnCareerLink(){
        auvenirPage.clickOnCareerLink();
    }

    public void verifyFooterCareerPathPage(){
        careerPage.verifyFooterCareerPathPage();
    }

    public void verifyContenCareerPathPage(){
        careerPage.verifyContenCareerPathPage();
    }
    public void verifyHeaderCareerPathPage(){
        careerPage.verifyHeaderCareerPathPage();
    }

}
