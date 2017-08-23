package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class SupportPage extends AbstractPage {

    public SupportPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//img[@src='images/full-dark-logo.svg']")
    private WebElement eleAuvenirHeaderLogoImg;

    public WebElement getEleAuvenirHeaderLogoImg() {
        return eleAuvenirHeaderLogoImg;
    }

    @FindBy(xpath = "//h1[contains(text(),'Here To Help')]")
    private WebElement eleHereToHelpTxt;

    public WebElement getEleHereToHelpTxt() {
        return eleHereToHelpTxt;
    }

    @FindBy(xpath = "//img[@src='images/support-team.png']")
    private WebElement eleSupportTeamImg;

    public WebElement getEleSupportTeamImg() {
        return eleSupportTeamImg;
    }

    @FindBy(xpath = "//h3[contains(text(),'Experiencing Problems')]")
    private WebElement eleExperiencingProblemsTxt;

    public WebElement getEleExperiencingProblemsTxt() {
        return eleExperiencingProblemsTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'Give us a call')]")
    private WebElement eleGiveUsACallTxt;

    public WebElement getEleGiveUsACallTxt() {
        return eleGiveUsACallTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'1-855-528-8364')]")
    private WebElement elePhoneNumberTxt;

    public WebElement getElePhoneNumberTxt() {
        return elePhoneNumberTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'or email us at info@auvenir.com')]")
    private WebElement eleEmailTxt;

    public WebElement getEleEmailTxt() {
        return eleEmailTxt;
    }

    @FindBy(xpath = "//a[contains(text(),'Send Message')]")
    private WebElement eleSendMessageBtn;

    public WebElement getEleSendMessageBtn() {
        return eleSendMessageBtn;
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

    public WebElement getEleAllRightsReservedTxt() {
        return eleAllRightsReservedTxt;
    }

    public void verifyContentSupportPage(){

        waitForVisibleElement(eleAuvenirHeaderLogoImg, "Auvenir Header Logo Image");
        NXGReports.addStep("Auvenir Header Logo Image is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleHereToHelpTxt, "Here to help Text");
        NXGReports.addStep("Here to help Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleSupportImg, "Support Team Imag");
        NXGReports.addStep("Support Team Imag is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleExperiencingProblemsTxt, "Experiencing Problem Textt");
        NXGReports.addStep("Experiencing Problem Text", LogAs.PASSED, null);

        waitForVisibleElement(eleGiveUsACallTxt, "Give us a call Text");
        NXGReports.addStep("Give us a call Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(elePhoneNumberTxt, "Phone Number Text");
        NXGReports.addStep("Phone Number Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleEmailTxt, "Email Text");
        NXGReports.addStep("Email Text is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleSendMessageBtn, "Send Message Button");
        NXGReports.addStep("Send Message Button", LogAs.PASSED, null);
    }

    public void verifyFooterSupportPage() {
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

        /*waitForVisibleElement(eleTermsOfServiceFtrLnk, "terms of service link");
        NXGReports.addStep("Terms of service link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(elePrivacyStatementFtrLnk, "privacy statement link");
        NXGReports.addStep("Privacy statement link is displayed", LogAs.PASSED, null);

        waitForVisibleElement(eleCookieFtrLnk, "cookie notice footer link");
        NXGReports.addStep("Cookie notice footer link is displayed", LogAs.PASSED, null);*/

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
