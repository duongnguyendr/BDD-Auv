package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.common.KeyWord;
//import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan.duong on 9/11/2017.
 */
public class MailPage extends KeyWord{

    public MailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='yW']/span[@email='andi@auvenir.com']")
    private WebElement eleEmailAuvenir;
    @FindBy(xpath = "//center/a")
    private WebElement eleGetStarted;
    @FindBy(xpath = "//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signButtonEle;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement eleEmail;
    @FindBy(xpath = "//div[@id='password']//input[@type='password']")
    private WebElement elePassword;
    @FindBy(xpath = "//*//span[contains(text(),'Next')]")
    private WebElement eleNext;

    public void selectActiveEmaill() {
        Boolean isSelect = clickElement(eleEmailAuvenir, "Non-reply Active email");
        if (isSelect) {
            getLogger().info("Email is existed: Pass");
        } else {
            Assert.fail("Email is not existed: Fail");
        }
    }

    public void navigateToConfirmationLink() throws Exception {
        getLogger().info("Navigate to Confirmation Link");
        Thread.sleep(3000);
        String link = eleGetStarted.getAttribute("href");
        System.out.print("Link: " + link);

        Thread.sleep(2000);
        clickGetStartedButton();
        switchToOtherTab(1);
    }

    public void clickGetStartedButton() {
        getLogger().info("Click Get Started Button.");
        waitForVisibleElement(eleGetStarted, "Get Started.");
        clickElement(eleGetStarted, "Get Started.");
    }

    public void goGMail() {
        try {
//            getDriver().get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
            getDriver().get(Generic.getConfigValue(Generic.PROPERTIES_FILE, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (Exception e) {
            getLogger().info("Unable to go to Gmail.");
        }
    }

    /**
     * Sign in to gmail with given email and password
     *
     * @param email    email to login
     * @param password password of email
     */
    public void signInGmail(String email, String password) {
        try {
            getLogger().info("Try to login GMail");
            if (!getDriver().getCurrentUrl().contains("accounts.google.com")) {
                clickElement(signButtonEle, "signButtonEle");
            }
            if (!email.isEmpty()) {
                sendKeyTextBox(eleEmail, email, "eleEmail");
                sendTabkey(eleEmail, "eleEmail");
                sendEnterkey(eleEmail, "eleEmail");
                getLogger().info("Send email: " + email);
            }
            sendKeyTextBox(elePassword, password, "password");
            getLogger().info("Send password: " + password);
            clickElement(eleNext, "click to eleNext");
            getLogger().info("DONE => LOGIN");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
