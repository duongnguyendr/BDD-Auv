package com.auvenir.ui.pages.client.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class ClientGmailLoginPage extends AbstractPage {


    public ClientGmailLoginPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//a[text()='Sign In']")
    private WebElement eleSignInLink;

    public WebElement getEleSignInLink() {
        return eleSignInLink;
    }

    @FindBy(xpath = "//span[contains(@class,'gbii')]")
    private WebElement eleProfileIcn;

    public WebElement getEleProfileIcn() {
        return eleProfileIcn;
    }

    @FindBy(id = "gb_71")
    private WebElement eleSignOutBtn;

    public WebElement getEleSignOutBtn() {
        return eleSignOutBtn;
    }

    @FindBy(id = "Email")
    private WebElement eleEmailIDTxtFld;

    public WebElement getEleEmailIDTxtFld() {
        return eleEmailIDTxtFld;
    }

    @FindBy(id = "next")
    private WebElement eleNextBtn;

    public WebElement getEleNextBtn() {
        return eleNextBtn;
    }

    @FindBy(id = "Passwd")
    private WebElement elePasswordTxtFld;

    public WebElement getElePasswordTxtFld() {
        return elePasswordTxtFld;
    }

    @FindBy(id = "signIn")
    private WebElement eleSignInBtn;

    public WebElement getEleSignInBtn() {
        return eleSignInBtn;
    }

    @FindBy(id = "gbqfq")
    private WebElement eleSearchTxtFld;

    public WebElement getEleSearchTxtFld() {
        return eleSearchTxtFld;
    }

    @FindBy(id = "gbqfb")
    private WebElement eleSearchBtn;

    public WebElement getEleSearchBtn() {
        return eleSearchBtn;
    }

    @FindBy(xpath = "(//span[contains(text(),'Invitation from to complete your financial audit')])[1]")
    private WebElement eleFirstMailLnk;

    public WebElement getEleFirstMailLnk() {
        return eleFirstMailLnk;
    }

    @FindBy(xpath = "//a[text()='Start Your Audit']")
    private WebElement eleStartBtn;

    public WebElement getEleStartBtn() {
        return eleStartBtn;
    }

    @FindBy(xpath = "//div[@aria-label='Show trimmed content']/img")
    private WebElement eleShowTrimBtn;

    public WebElement getEleShowTrimBtn() {
        return eleShowTrimBtn;
    }

}
