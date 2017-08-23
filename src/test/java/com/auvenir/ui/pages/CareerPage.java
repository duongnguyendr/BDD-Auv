package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class CareerPage extends AbstractPage {

    public CareerPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//img[@id='headerLogo']")
    private WebElement eleAuvenirImg;

    @FindBy(xpath = "//h1[contains(text(),'We are Growing. Come Join our Team.')]")
    private WebElement eleWeAreGrowingTxt;

    public WebElement getEleWeAreGrowingTxt() {
        return eleWeAreGrowingTxt;
    }

    @FindBy(xpath = "//h3[contains(text(),'Careers at Auvenir')]")
    private WebElement eleCareersAtAuvenirTxt;

    public WebElement getEleCareersAtAuvenirTxt() {
        return eleCareersAtAuvenirTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Business')]")
    private WebElement eleBusinessTxt;

    public WebElement getEleBusinessTxt() {
        return eleBusinessTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Product')]")
    private WebElement eleProductLeadLnk;

    public WebElement getEleProductLeadLnk() {
        return eleProductLeadLnk;
    }

    @FindBy(xpath = "//div[contains(text(),'Marketing')]")
    private WebElement eleMarketingTxt;

    public WebElement getEleMarketingTxt() {
        return eleMarketingTxt;
    }

    @FindBy(xpath = "//a[contains(text(),'Sales/Biz Development')]")
    private WebElement eleSalesBizDevelopmentLnk;

    public WebElement getEleSalesBizDevelopmentLnk() {
        return eleSalesBizDevelopmentLnk;
    }

    @FindBy(xpath = "//div[contains(text(),'Technology')]")
    private WebElement eleTechnologyTxt;

    public WebElement getEleTechnologyTxt() {
        return eleTechnologyTxt;
    }

    @FindBy(xpath = "//a[contains(text(),'Developer (Front End and/or Back End)')]")
    private WebElement eleDeveloperLnk;

    public WebElement getEleDeveloperLnk() {
        return eleDeveloperLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Senior Dev Ops')]")
    private WebElement eleSeniorDevOpsLnk;

    public WebElement getEleSeniorDevOpsLnk() {
        return eleSeniorDevOpsLnk;
    }

    @FindBy(xpath = "//img[@id='footerLogo'][@src='images/logo.svg']")
    private WebElement eleAuvenirFooterImg;

    public WebElement getEleAuvenirFooterImg() {
        return eleAuvenirFooterImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]//span")
    private WebElement eleCareersImg;

    public WebElement getEleCareersImg() {
        return eleCareersImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement eleCareersLnk;

    public WebElement getEleCareersLnk() {
        return eleCareersLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]//span")
    private WebElement eleSupportImg;

    public WebElement getEleSupportImg() {
        return eleSupportImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    private WebElement eleSupportLnk;

    public WebElement getEleSupportLnk() {
        return eleSupportLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]//span")
    private WebElement eleLocatorImg;

    public WebElement getEleLocatorImg() {
        return eleLocatorImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]")
    private WebElement eleTorontoCanadaLnk;

    public WebElement getEleTorontoCanadaLnk() {
        return eleTorontoCanadaLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]//span")
    private WebElement elePhoneImg;

    public WebElement getElePhoneImg() {
        return elePhoneImg;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]")
    private WebElement elePhoneNumberLnk;

    public WebElement getElePhoneNumberLnk() {
        return elePhoneNumberLnk;
    }

    @FindBy(xpath = "//a[@href='https://www.facebook.com/auvenir']")
    private WebElement eleFacebookImg;

    public WebElement getEleFacebookImg() {
        return eleFacebookImg;
    }

    @FindBy(xpath = "//a[@href='https://twitter.com/auvenir']")
    private WebElement eleTwitterImg;

    public WebElement getEleTwitterImg() {
        return eleTwitterImg;
    }

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/10419712']")
    private WebElement eleLinkedinImg;

    public WebElement getEleLinkedinImg() {
        return eleLinkedinImg;
    }

    @FindBy(xpath = "//span[contains(text(),'All rights reserved.')]")
    private WebElement eleAllRightsReservedTxt;

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/terms']")
    private WebElement eleTermsOfServiceFtrLnk;

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/privacy']")
    private WebElement elePrivacyStatementFtrLnk;

    @FindBy(xpath = "//div[@class='pull-left']//a[@href='/cookies']")
    private WebElement eleCookieFtrLnk;


    public WebElement getElePrivacyStatementFtrLnk() {
        return elePrivacyStatementFtrLnk;
    }


    public WebElement getEleAllRightsReservedTxt() {
        return eleAllRightsReservedTxt;
    }

    public void verifyHeaderCareerPathPage(){
        waitForVisibleElement(eleAuvenirImg, "auvenir image header");
        NXGReports.addStep("Auvenir image is displayed", LogAs.PASSED, null);
    }

    public void verifyContenCareerPathPage(){
        waitForVisibleElement(eleWeAreGrowingTxt, "we are growing text");
        NXGReports.addStep("We are Growing Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleCareersAtAuvenirTxt, "careers at Auvenir Text");
        NXGReports.addStep("Careers at Auvenir Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleProductLeadLnk, "product text");
        NXGReports.addStep("Product text is displayed", LogAs.PASSED, null);

        /*waitForVisibleElement(eleTechnologyTxt, "technology text");
        NXGReports.addStep("Technology text is displayed", LogAs.PASSED, null);*/

        //waitForVisibleElement(eleDeveloperLnk, "developer link");
        //NXGReports.addStep("Developer link is displayed", LogAs.PASSED, null);
    }

    public void verifyFooterCareerPathPage() {
        waitForVisibleElement(eleCareersImg, "careers image");
        NXGReports.addStep("Careers image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleCareersLnk, "careers link");
        NXGReports.addStep("Careers link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleSupportImg, "support image");
        NXGReports.addStep("Support image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleSupportLnk, "support link");
        NXGReports.addStep("Support link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleLocatorImg, "locator image");
        NXGReports.addStep("Locator image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleTorontoCanadaLnk, "toronto canada location link");
        NXGReports.addStep("Toronto canada location link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(elePhoneImg, "phone image");
        NXGReports.addStep("Phone image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(elePhoneNumberLnk, "phone number link");
        NXGReports.addStep("Phone number link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleTermsOfServiceFtrLnk, "terms of service link");
        NXGReports.addStep("Terms of service link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(elePrivacyStatementFtrLnk, "privacy statement link");
        NXGReports.addStep("Privacy statement link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleCookieFtrLnk, "cookie notice footer link");
        NXGReports.addStep("Cookie notice footer link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleFacebookImg, "Facebook image");
        NXGReports.addStep("Facebook image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleTwitterImg, "Twitter image");
        NXGReports.addStep("Twitter image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleLinkedinImg, "Linkedin image");
        NXGReports.addStep("Linkedin image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleAllRightsReservedTxt, "All rights reserversd test");
        NXGReports.addStep("All rights reserversd is displayed", LogAs.PASSED, null);
    }
}