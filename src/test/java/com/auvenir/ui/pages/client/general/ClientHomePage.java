package com.auvenir.ui.pages.client.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class ClientHomePage extends AbstractPage {
    public ClientHomePage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//span[contains(text(),'My Audits')]")
    private WebElement eleMyAuditsTxt;

    public WebElement getEleMyAuditsTxt() {
        return eleMyAuditsTxt;
    }

    @FindBy(xpath = "//div[@id='clientDashboardLink']")
    private WebElement eleInProgressTxt;

    public WebElement getEleInProgressTxt() {
        return eleInProgressTxt;
    }

    @FindBy(xpath = "//div[@id='clientCompletedLink']")
    private WebElement eleCompletedTxt;

    public WebElement getEleCompletedTxt() {
        return eleCompletedTxt;
    }

    @FindBy(xpath = "//div[@class='e-widget-options']")
    private WebElement eleDataGatheringIcn;

    public WebElement getEleDataGatheringIcn() {
        return eleDataGatheringIcn;
    }


    @FindBy(xpath = "//input[@value='View']")
    private WebElement eleViewBtn;

    public WebElement getEleViewBtn() {
        return eleViewBtn;
    }

    @FindBy(xpath = "//label[contains(text(),'Data gathering')]")
    private WebElement eleDataGatheringTxt;

    public WebElement getEleDataGatheringTxt() {
        return eleDataGatheringTxt;
    }

    @FindBy(xpath = "//img[@src='/images/logos/business/BusinessLogo6.svg']")
    private WebElement eleBusinessLogoImg;

    public WebElement getEleBusinessLogoImg() {
        return eleBusinessLogoImg;
    }

    @FindBy(xpath = "//p[contains(text(),'Untitled')]")
    private WebElement eleUntitledTxt;

    public WebElement getEleUntitledTxt() {
        return eleUntitledTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Updated')]")
    private WebElement eleUpdatedTxt;

    public WebElement getEleUpdatedTxt() {
        return eleUpdatedTxt;
    }

    public void verifyMyAuditsPage() {
        getLogger().info("Verify My Audits Page.");
        clickAndHold(getEleAuvenirHeaderImg(), "Auvenir Header Image.");
        waitForVisibleElement(eleMyAuditsTxt, "myAuditTextEle");
        validateDisPlayedElement(eleMyAuditsTxt, "My Audits Text");
        validateElementText(eleMyAuditsTxt, "My Audits");
        validateDisPlayedElement(eleInProgressTxt, "In Progress Link");
        validateDisPlayedElement(eleCompletedTxt, "Completed link");
        //auvenirPage.toValidate(clientHomePage.getEleBusinessLogoImg(),"Business Logo Image", "Displayed");
        validateDisPlayedElement(eleDataGatheringTxt, "Data Gathering Text");
        hoverElement(eleDataGatheringIcn, "Data Gathering");
        validateDisPlayedElement(eleViewBtn, "View Button");
        //will updated later after finding how to visible this element.
//        auvenirPage.toValidate(clientHomePage.getEleUntitledTxt(), "Untitled Text", "Displayed");
        validateDisPlayedElement(eleUpdatedTxt, "Updated Text");
    }
}
