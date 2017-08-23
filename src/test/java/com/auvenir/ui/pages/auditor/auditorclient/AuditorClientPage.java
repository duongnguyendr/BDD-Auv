package com.auvenir.ui.pages.auditor.auditorclient;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuditorClientPage extends AbstractPage {


    public AuditorClientPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//span[contains(text(),'My Clients')]")
    private WebElement eleMyClientTxt;

    public WebElement getEleMyClientTxt() {
        return eleMyClientTxt;
    }

    @FindBy(xpath = "//div[@id='clientList-noClients']/img")
    private WebElement eleNoClientsImg;

    public WebElement getEleNoClientsImg() {
        return eleNoClientsImg;
    }

    @FindBy(xpath = "//h2[@class='noEngagement-txt']")
    private WebElement eleYouDontHaveTxt;

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElement eleAddNewBtn;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    public void verifyDisplayElementInClientPage(){
        validateDisPlayedElement(eleMyClientTxt, "My Client Text");
        validateDisPlayedElement(eleNoClientsImg, "No Client - Image");
        validateEnabledElement(eleAddNewBtn, "Add New Button");
        validateEnabledElement(eleYouDontHaveTxt, "Add New Button");
    }

}
