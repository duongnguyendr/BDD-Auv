package com.auvenir.ui.bdd.pages.marketing;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by doai.tran on 8/29/2017.
 */
public class MarketingPage extends CommonPage {

    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement buttonLogin;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@id='login-popup']//button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*/a[@class='ui large basic inverted button']")
    private WebElement buttonSignUp;

    @FindBy(id = "marketing-header")
    private WebElement marketingHeader;

    @FindBy(xpath = "//a[@class='ui label forgot-password']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//div[@id='forgot-popup']//input[@name='email']")
    private WebElement inputForgottenEmail;

    @FindBy(xpath = "//div[@id='forgot-popup']//button[@type='submit']")
    private WebElement buttonRequestResetLink;

    @FindBy(xpath = "//div[@id='waitlist-popup']//span")
    private WebElement spanAccountStillProcessingMessage;

    @FindBy(className = "login-title")
    private WebElement titleLogin;

    @FindBy(id = "forgot-popup")
    private WebElement popupForgotPassword;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/about']")
    private WebElement itemFooterAbout;

    @FindBy(xpath = "//div[contains(@class,'about-header')]")
    private WebElement textBannerInformation;

    //private String xpathStatusCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[5]/select";

    public MarketingPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton() {
        clickElement(buttonLogin, "Login Button");
    }

    public void clickOnSignUpButton() {
        clickElement(buttonSignUp, "Button Sign Up");
    }

    public void inputUserNamePassword(String username, String password) {
        sendKeyTextBox(inputEmail, username, "emailTextBox");
        sendKeyTextBox(inputPassword, password, "passwordTextBox");
    }

    public void clickOnSubmitButton() {
        clickElement(buttonSubmit, "Button Submit");
    }

    public void verifyMaketingHeaderPage() {
        boolean result = validateExistedElement(marketingHeader, "Marketing header");
        Assert.assertTrue(result, "Verify marketing header page.");
    }

    public void clickOnForgotPasswordLink() {
        //            waitForClickableOfElement(forgotPasswordLink, "forgotPasswordLink");
        clickElement(linkForgotPassword, "Link Forgot Pasword");
    }

    public void verifyForgotPasswordPopup() {
        validateExistedElement(popupForgotPassword, "Popup Forgot Password");
    }

    public void inputEmailForgottenPassword(String email) {
        sendKeyTextBox(inputForgottenEmail, email, "Input Forgotten Email");
    }

    public void clickOnRequestResetLinkButton() {
        clickElement(buttonRequestResetLink, "Button Request Reset Link");
    }

    public void verifyStillProcessingMessage() {
        validateElementText(spanAccountStillProcessingMessage,
                "Thanks for registering for the Auvenir platform! Your account information is being reviewed and you"
                        + " will receive an email from our customer service team shortly. If you have any questions "
                        + "in the meantime, please send us a note at info@auvenir.com.");
    }

    public void verifyLoginPopupTitle() {
        validateElementText(titleLogin, "Login to Auvenir");
    }

    @FindBy(xpath = "//img[contains(@class,'ui-logo')]")
    private WebElement imageLogo;

    @FindBy(xpath = "//button[contains(@class,'btn-login')]")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@class='row header-logo']//a[contains(@class,'inverted button')]")
    private WebElement linkAuditorSignUp;

    @FindBy(xpath = "//div[contains(@class,'button inverted')]")
    private WebElement linkLanguage;

    @FindBy(xpath = "//div[@class='row']//a[contains(@class,'inverted button')]")
    private WebElement linkJoinAsAuditor;

    public void verifyHeaderLogo() {
        boolean result = validateAttributeContain(imageLogo, "src", "static/images/logo-auvenir.svg", "Image Logo");
        Assert.assertTrue(result, "Link Header Logo should be: " + "static/images/logo-auvenir.svg");
    }

    public void verifyLoginLink() {
        boolean result = validateExistedElement(linkLogin, "Link Login");
        Assert.assertTrue(result, "Login Link should be exist");
    }

    public void seeSignUpLink() {
        boolean result = validateExistedElement(linkAuditorSignUp, "Link Auditor Sign Up");
        Assert.assertTrue(result, "Link Auditor Sign Up should be exist");
    }

    public void seeLanguageLink() {
        boolean result = validateExistedElement(linkLanguage, "Link Language");
        Assert.assertTrue(result, "Link Language should be exist");
    }

    public void seeJoinAsAuditorLink() {
        boolean result = validateExistedElement(linkJoinAsAuditor, "Link Join As Auditor");
        Assert.assertTrue(result, "Link Join As Auditor should be exist");
    }

    public void redirectToAboutPage() {
        scrollToFooter();
        clickElement(itemFooterAbout, "Item Footer About");
    }

    public void seeBannerInformation() {
        boolean result = validateExistedElement(textBannerInformation, "Banner Information");
        Assert.assertTrue(result, "Banner Information should be exist");
    }
}
