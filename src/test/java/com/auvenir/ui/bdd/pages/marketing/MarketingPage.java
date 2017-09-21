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

}
