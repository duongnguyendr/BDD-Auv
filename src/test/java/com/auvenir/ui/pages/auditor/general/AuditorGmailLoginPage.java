package com.auvenir.ui.pages.auditor.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuditorGmailLoginPage extends AbstractPage {

    public AuditorGmailLoginPage(Logger logger, WebDriver driver) {
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

    @FindBy(xpath = "(//div[@class='ae4 UI UJ']//tr)[1]")
    private WebElement eleFirstMailLnk;

    public WebElement getEleFirstMailLnk() {
        return eleFirstMailLnk;
    }

    @FindBy(xpath = "(//span[text()='no-reply@auvenir.com'])[last()]")
    private WebElement eleNoReplyTxt;

    public WebElement getEleNoReplyTxt() {
        return eleNoReplyTxt;
    }

    /*@FindBy(xpath = "(//td[contains(text(),'Welcome to Auvenir!')])[last()]//..//..//..//..//..//center//img")
    private WebElement eleAuvenirImg;
    public WebElement getEleAuvenirImg() {
        return eleAuvenirImg;
    }*/
    @FindBy(xpath = "(//img[@class='CToWUd')])[last()]")
    private WebElement eleAuvenirImg;

    public WebElement getEleAuvenirImg() {
        return eleAuvenirImg;
    }

    @FindBy(xpath = "(//td[text()='Welcome to Auvenir!'])[last()]")
    private WebElement eleAuvenirTxt;

    public WebElement getEleAuvenirTxt() {
        return eleAuvenirTxt;
    }

    @FindBy(xpath = "(//td[text()='Audit, smarter.'])[last()]")
    private WebElement eleAuditSmarterTxt;

    public WebElement getEleAuditSmarterTxt() {
        return eleAuditSmarterTxt;
    }

    @FindBy(xpath = "(//td[contains(text(),'You have been')])[last()]")
    private WebElement eleYouHaveBeenTxt;

    public WebElement getEleYouHaveBeenTxt() {
        return eleYouHaveBeenTxt;
    }

    @FindBy(xpath = "(//td[contains(text(),'You have been')]//..)[last()]")
    private WebElement eleClickToLoginLnk;

    public WebElement getEleClickToLoginLnk() {
        return eleClickToLoginLnk;
    }

    @FindBy(xpath = "(//td[contains(text(),'We welcome your')])[last()]")
    private WebElement eleWeWelcomeYourTxt;

    public WebElement getEleWeWelcomeYourTxt() {
        return eleWeWelcomeYourTxt;
    }

    @FindBy(xpath = "(//td[contains(text(),'We welcome your')]//..)[last()]")
    private WebElement eleFeedbackLnk;

    public WebElement getEleFeedbackLnk() {
        return eleFeedbackLnk;
    }
}
