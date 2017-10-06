package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.common.Generic;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SquirrelMail extends AbstracEmail {
    private static Logger logger = Logger.getLogger(Gmail.class.getSimpleName());

    public SquirrelMail(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//input[@name='login_username']")
    private WebElement eleEmail;
    @FindBy(xpath = "//input[@name='secretkey']")
    private WebElement elePassword;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement eleLogin;
    @FindBy(xpath = "//a[text()='Compose']")
    private WebElement composeBtn;
//    @FindBy(xpath = "(//a[@onclick='CheckAllINBOX();'])[1]")
    @FindBy(xpath = "(//a[text()='Toggle All'])[1]")
    private WebElement allMailCheckBox;
    @FindBy(xpath = "//input[@name='delete']")
    private WebElement deleteBTN;
    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement eleSignOutBtn;
    @FindBy(xpath = "//a[text()='Click here to log back in.']")
    private WebElement eleReSignOutBtn;
    @FindBy(xpath = "//a[@class='loginButton']")
    private WebElement  eleGetStarted;
    @FindBy(xpath = "//a[@title='Invitation from Lead C to participate in an engagement on the Auvenir Platform']")
    private WebElement eleEmailAuvenir;
    @FindBy(xpath = "(//frame[@frameborder='1'])[2]")
    private WebElement frameRight;
    @FindBy(xpath = "//a[contains(text(), 'Start Your Engagement')]")
    private WebElement buttonStartEngagement;

    @FindBy(xpath = "//b[text()='THIS FOLDER IS EMPTY']")
    private WebElement checkNullEmail;



    public void clickOnboardingInvitationLink() {
        try {
            logger.info("Redirecting from SquirrelMail to Auvenir Welcome Page");
           // switchToFrame(frameRight);
            clickElement(buttonStartEngagement, "Button Start Engagement");
            waitSomeSeconds(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void navigateToConfirmationLink() throws Exception {
        logger.info("Navigate to Confirmation Link");
        //switchToFrame(frameRight);
       // waitSomeSeconds(2);
       // String link = eleGetStarted.getAttribute("href");
       // System.out.print("Link: " + link);

        waitSomeSeconds(2);
        clickGetStartedButton();
        switchToOtherTab(1);
    }
    public void selectActiveEmail() {
        logger.info("Select Active Email");
        //switchToFrame(frameRight);
        clickElement(eleEmailAuvenir, "Non-reply Active email");
    }
    public void clickGetStartedButton() {
        logger.info("Click Get Started Button.");
        //switchToFrame(frameRight);
        waitForVisibleElement(eleGetStarted, "Get Started.");
        clickElement(eleGetStarted, "Get Started.");
    }

    public void goEMail() {
        getDriver().get(Generic.getConfigValue(Generic.PROPERTIES_FILE, "MAIL_URL"));
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    public void signInEmail(String email, String password) {
        logger.info("Try to login Email");
        if (!getDriver().getCurrentUrl().contains("accounts.google.com")) {
          // clickElement(signButtonEle, "signButtonEle");
        }
        if (!email.isEmpty()) {
            sendKeyTextBox(eleEmail, email, "eleEmail");
            logger.info("Send email: " + email);
        }
        sendKeyTextBox(elePassword, password, "password");
        logger.info("Send password: " + password);

        clickElement(eleLogin, "click to Login");
        switchToFrame(frameRight);
        waitForVisibleElement(composeBtn,"compose button");

        logger.info("DONE => LOGIN");

    }
    public void deleteAllMail() throws Exception {
        //waitForVisibleElement(composeBtn, "composeBtn");

        logger.info("Try to delete all existed mail.");
        waitSomeSeconds(2);
        logger.info("Select all Delete mail: ");
        //switchToFrame(frameRight);
        if (!checkNullEmail.isDisplayed()){
            clickElement(allMailCheckBox,"all Mail CheckBox");
            Thread.sleep(200);
            logger.info("Click Delete All Email.");
            deleteBTN.click();
        }
        waitSomeSeconds(2);
        logger.info("Delete all mail successfully");
    }
    public void deleteAllExistedEmail(String Email, String ePassword) throws Exception {
        logger.info("Try to delete all existed eGMail");
        goEMail();
        signInEmail(Email, ePassword);
        deleteAllMail();
        emailLogout();
    }
    public void emailLogout() throws Exception {
        //switchToFrame(frameRight);
        waitForVisibleElement(eleSignOutBtn, "eleSignOutBtn");
        clickElement(eleSignOutBtn, "click to eleSignOutBtn");
       waitSomeSeconds(2);
    }
    public void reSignInEmail(String Email,String password) throws Exception{
        Thread.sleep(1000);
       // clickElement(eleReSignOutBtn,"Click re-sign out button");
        goEMail();
        signInEmail(Email,password);
        logger.info("DONE => LOGIN");
    }
}