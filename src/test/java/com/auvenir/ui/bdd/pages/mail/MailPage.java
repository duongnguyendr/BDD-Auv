package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.common.KeyWord;
//import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by thuan.duong on 9/11/2017.
 */
public class MailPage extends KeyWord{
    WebDriver driver;
    Logger logger;
    MailPage mailPage;
    public MailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
        mailPage = new MailPage(logger, driver);
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
    @FindBy(xpath = "//a[text()='Start Your Engagement']")
    private WebElement buttonStartEngagement;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeBtn;
    @FindBy(xpath = "//div[@class='J-J5-Ji J-JN-M-I-Jm']//div[@role='presentation']/..")
    private WebElement allMailCheckBox;
    @FindBy(xpath = "//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement deleteBTN;
    @FindBy(xpath = "//span[contains(@class,'gbii')]")
    private WebElement eleProfileIcn;
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/Logout')]")
    private WebElement eleSignOutBtn;

    public void selectActiveEmail() {
        getLogger().info("Select Active Email");
        clickElement(eleEmailAuvenir, "Non-reply Active email");
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
//            getDriver().get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
        getDriver().get(Generic.getConfigValue(Generic.PROPERTIES_FILE, "GMAIL_URL"));
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    /**
     * Sign in to gmail with given email and password
     *
     * @param email    email to login
     * @param password password of email
     */
    public void signInGmail(String email, String password) {
        getLogger().info("Try to login GMail");
        if (!getDriver().getCurrentUrl().contains("accounts.google.com")) {
            clickElement(signButtonEle, "signButtonEle");
        }
        if (!email.isEmpty()) {
            sendKeyTextBox(eleEmail, email, "eleEmail");
            sendTabKey(eleEmail, "eleEmail");
            sendEnterKey(eleEmail, "eleEmail");
            getLogger().info("Send email: " + email);
        }
        sendKeyTextBox(elePassword, password, "password");
        getLogger().info("Send password: " + password);
        clickElement(eleNext, "click to eleNext");
        getLogger().info("DONE => LOGIN");
    }

    public void deleteAllExistedGMail(String eGMail, String ePassword) throws Exception {
        getLogger().info("Try to delete all existed eGMail");
        driver.get( Generic.getConfigValue(Generic.sConfigFile, "GMAIL_URL"));
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        signInGmail(eGMail, ePassword);
        deleteAllMail();
        gmailLogout();
    }

    /**
     * Enter the email(after search) n click 'Start Engagement' button to go to Auvenir site
     */
    public void clickOnboardingInvitationLink() {
        try {
            getLogger().info("Redirecting from Gmail to Auvenir Welcome Page");
            clickElement(buttonStartEngagement, "Button Start Engagement");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAllMail() throws InterruptedException {
        waitForVisibleElement(composeBtn, "composeBtn");
        getLogger().info("Try to delete all existed mail.");
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(allMailCheckBox));
        Thread.sleep(2000);
        getLogger().info("Select all Delete mail: ");
        allMailCheckBox.click();
        Thread.sleep(200);
        if (deleteBTN.isDisplayed()) {
            getLogger().info("Click Delete All Email.");
            deleteBTN.click();
        }
        Thread.sleep(2000);
        getLogger().info("Delete all mail successfully");
    }

    public void gmailLogout() throws Exception {
        waitForVisibleElement(eleProfileIcn, "eleProfileIcn");
        clickElement(eleProfileIcn, "click to eleProfileIcn");
        Thread.sleep(2000);
        waitForVisibleElement(eleSignOutBtn, "eleSignOutBtn");
        clickElement(eleSignOutBtn, "click to eleSignOutBtn");
        Thread.sleep(3000);
    }

    public void reSignInGmail(String password) throws Exception{
            Thread.sleep(1000);
            elePassword.sendKeys(password);
            getLogger().info("Send password: " + password);
            Thread.sleep(1000);
            clickElement(eleNext, "click to eleNext");
            getLogger().info("DONE => LOGIN");
    }
}
