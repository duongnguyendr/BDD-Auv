package com.auvenir.ui.bdd.common;

import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class GmailPage extends KeyWord {

    //static String gmailWindowHandles;
    public GmailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'gbii')]")
    private WebElement eleProfileIcn;

    public WebElement getEleProfileIcn() {
        return eleProfileIcn;
    }

    //  Old Xpath gmail:  @FindBy(xpath = "//a[@class='gb_Fa gb_rf gb_yf gb_xb']")
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/Logout')]")
    private WebElement eleSignOutBtn;

    public WebElement getEleSignOutBtn() {
        return eleSignOutBtn;
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement eleEmailIDTxtFld;

    public WebElement getEleEmailIDTxtFld() {
        return eleEmailIDTxtFld;
    }

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content/span")
    private WebElement eleNextBtn;

    public WebElement getEleNextBtn() {
        return eleNextBtn;
    }

    @FindBy(xpath = "//input[@type='password']")
    private WebElement elePasswordTxtFld;

    public WebElement getElePasswordTxtFld() {
        return elePasswordTxtFld;
    }


    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    private WebElement eleSignInBtn;

    public WebElement getEleSignInBtn() {
        return eleSignInBtn;
    }

    @FindBy(id = "gbqfq")
    private WebElement eleSearchTxtFld;

    public WebElement getEleSearchTxtFld() {
        return eleSearchTxtFld;
    }

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement composeTextFld;

    @FindBy(id = "gbqfb")
    private WebElement eleSearchBtn;

    public WebElement getEleSearchBtn() {
        return eleSearchBtn;
    }

    @FindBy(xpath = "(//span[contains(text(),'to complete your financial audit')])[last()]")
    private WebElement eleInviteMailLnk;

    public WebElement getEleInviteMailLnk() {
        return eleInviteMailLnk;
    }

    @FindBys({@FindBy(xpath = "//span[contains(text(),'to complete your financial audit')]")})
    private List<WebElement> lsEleInviteMailLnk;

    public List<WebElement> getLsEleInviteMailLnk() {
        return lsEleInviteMailLnk;
    }

    @FindBys({@FindBy(xpath = "//b[contains(text(),'Sign in to Auvenir')]")})
    private List<WebElement> lsEleSignInMailLnk;

    public List<WebElement> getLsEleSignInMailLnk() {
        return lsEleSignInMailLnk;
    }

    @FindBys({@FindBy(xpath = "//span[contains(text(),'Account is Active')]")})
    private List<WebElement> lsEleYourAccActiveLnk;

    public List<WebElement> getLsEleYourAccActiveLnk() {
        return lsEleYourAccActiveLnk;
    }

    @FindBy(xpath = "//b[contains(text(),'Account is Active')]")
    private WebElement eleYourAccActiveLnk;

    public WebElement getEleYourAccActiveLnk() {
        return eleYourAccActiveLnk;
    }

    @FindBy(xpath = "(//a[contains(text(),'Start')])[last()]")
    private WebElement eleStartBtn;

    public WebElement getEleStartBtn() {
        return eleStartBtn;
    }

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement eleSignInLnk;

    public WebElement getEleSignInLnk() {
        return eleSignInLnk;
    }

    @FindBy(xpath = "//a[@id='edit-account-list'][text()='Remove']")
    private WebElement eleRemoveLnk;

    public WebElement getEleRemoveLnk() {
        return eleRemoveLnk;
    }

    @FindBy(xpath = "//a[@id='edit-account-list'][text()='Done']")
    private WebElement eleDoneLnk;

    public WebElement getEleDoneLnk() {
        return eleDoneLnk;
    }

    @FindBy(xpath = "//span[contains(text(),'@gmail.com'])")
    private WebElement eleAccountCloseIcn;

    public WebElement getEleAccountCloseIcn() {
        return eleAccountCloseIcn;
    }

    @FindBy(xpath = "//div[@aria-label='Show trimmed content']/img")
    private WebElement eleShowTrimBtn;

    public WebElement getEleShowTrimBtn() {
        return eleShowTrimBtn;
    }

    public void gmailLogout() throws Exception {
        try {

            waitForVisibleElement(eleProfileIcn, "eleProfileIcn");
            clickElement(eleProfileIcn, "click to eleProfileIcn");
            Thread.sleep(2000);
            waitForVisibleElement(eleSignOutBtn, "eleSignOutBtn");
            clickElement(eleSignOutBtn, "click to eleSignOutBtn");
            Thread.sleep(3000);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }


    public void gmailLogin(String sUSN, String sPWD) throws InterruptedException {
        try {
            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
            try {
                if (getEleSignInLnk().isDisplayed()) {
                    getEleSignInLnk().click();
                }
            } catch (Exception e) {
            }
            try {
                if (getEleRemoveLnk().isDisplayed()) {
                    getEleRemoveLnk().click();
                    Thread.sleep(2000);
                    getDriver().findElement(By.xpath("//span[text()='" + sUSN + "']")).click();
                    try {
                        if (getEleRemoveLnk().isDisplayed()) {
                            getEleRemoveLnk().click();
                        }
                    } catch (Exception e) {
                    }

                    getEleDoneLnk().click();
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
            }

            try {
                if (getEleEmailIDTxtFld().isDisplayed()) {
                    getEleEmailIDTxtFld().sendKeys(sUSN);
                    getEleNextBtn().click();
                }
            } catch (Exception e) {
            }
            getElePasswordTxtFld().sendKeys(sPWD);
            getEleSignInBtn().click();
            Assert.assertTrue(getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
            getLogger().info("Login to Gmail is successful");

        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void inviteEmail() {
        try {

            for (int i = 0; i < lsEleInviteMailLnk.size(); i++) {
                System.out.println(lsEleInviteMailLnk.get(i).getText());
                if (lsEleInviteMailLnk.get(i).getText().contains("to complete your financial audit")) {
                    lsEleInviteMailLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);

                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public void signInEmail() {
        try {
            System.out.println(lsEleSignInMailLnk.size());
            for (int i = 0; i < lsEleSignInMailLnk.size(); i++) {
                System.out.println(lsEleSignInMailLnk.get(i).getText());
                if (lsEleSignInMailLnk.get(i).getText().contains("Sign in to Auvenir")) {
                    lsEleSignInMailLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);

                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public void accountActiveEmail() {
        try {
            System.out.println(lsEleYourAccActiveLnk.size());
            for (int i = 0; i < lsEleYourAccActiveLnk.size(); i++) {
                System.out.println(lsEleYourAccActiveLnk.get(i).getText());
                if (lsEleYourAccActiveLnk.get(i).getText().contains("Account is Active")) {
                    lsEleYourAccActiveLnk.get(i).click();
                    try {
                        if (getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']/img")).isDisplayed()) {
                            getDriver().findElement(By.xpath("(//div[@aria-label='Show trimmed content']/img)[last()]")).click();
                            Thread.sleep(2000);
                            Robot rb = new Robot();
                            rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                        }
                    } catch (Exception e) {
                    }
                    break;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public WebElement getComposeTextFld() {
        return composeTextFld;
    }

    //////////////////////////////////////////////////////////
    @FindBy(xpath = "//input[@type='email']")
    private WebElement eleEmail;

    public WebElement getEleEmail() {
        return eleEmail;
    }

    @FindBy(xpath = "//*//span[contains(text(),'Next')]")
    private WebElement eleNext;
    private String xpathResetPassword = "//a[contains(text(),'Reset Password')]";

    public WebElement getEleNext() {
        return eleNext;
    }

    @FindBy(xpath = "//div[@id='password']//input[@type='password']")
    private WebElement elePassword;

    public WebElement getElePassword() {
        return elePassword;
    }

    //    @FindBy(xpath = "//div[@class='yW']/span[@email='no-reply@auvenir.com']")
    @FindBy(xpath = "//div[@class='yW']/span[@email='andi@auvenir.com']")
    private WebElement eleEmailAuvenir;

    @FindBy(xpath = "//img[@src='//ssl.gstatic.com/ui/v1/icons/mail/profile_mask2.png']")
    private WebElement eleEmailAuvenir01;

    @FindBy(id = "signIn")
    private WebElement eleSignIn;

    public WebElement getEleSignIn() {
        return eleSignIn;
    }

//	@FindBy(xpath = "//div[contains(@class, 'y6')]/span[contains(text(), 'Auvenir')]")
//	private WebElement eleEmailAuvenir;

    public WebElement getEleEmailAuvenir() {
        return eleEmailAuvenir;
    }

    public void goGMail() {
        try {
//            getDriver().get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
            getDriver().get(GenericService.getConfigValue(Generic.PROPERTIES_FILE, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (Exception e) {
            getLogger().info("Unable to go to Gmail.");
        }
    }

    /**
     * Login gmail
     *
     * @param email
     * @param password
     */
    public void openGmailIndexForgotPassword(String email, String password) throws InterruptedException {
        try {
            getLogger().info("DONE => LOGIN");
        } catch (NoSuchElementException e) {
            getLogger().info("Errors ..... ");
            WebElement elementEmail = getDriver().findElement(By.id("identifierId"));
            elementEmail.sendKeys(email);
            getDriver().findElement(By.xpath("//div[@id='identifierNext']")).click();
            waitUtilElementClickable(getDriver().findElement(By.id("passwordNext")), waitTime);
            getDriver().findElement(By.cssSelector("#password input")).sendKeys(password);
            getDriver().findElement(By.id("passwordNext")).click();
        }
        reSignInGmail(password);
        //Waiting for email receiver form Auvenir in 30s
        waitUtilElementClickable(eleEmailAuvenir, waitTime);
        //Open email details
        Thread.sleep(smallTimeOut);
        clickElement(eleEmailAuvenir);
        Thread.sleep(smallTimeOut);
        clickElement(eleEmailAuvenir01);
        getLogger().info("Click on mail.");
        try {
            //Thread.sleep(smallerTimeOut);
            //WebElement showTrimmedContent = getDriver().findElement(By.xpath("//div[@aria-label='Show trimmed content']"));
            WebElement showTrimmedContent = getDriver().findElement(By.xpath(xpathResetPassword));
            getLogger().info("Find element reset password link.");
            if (showTrimmedContent.isDisplayed()) {
                showTrimmedContent.click();
                getLogger().info("Click on reset password link.");
            }
        } catch (NoSuchElementException e) {

        }
    }


    public void openGmailIndexRegisterAccount(String email, String password) {
        //Sending email address
        sendKeyTextBox(eleEmail, email, "Email text box");
        //Clicking on "Next" button
        clickElement(eleNext);
        //Sending password
        sendKeyTextBox(elePassword, password, "Password text box");
        //Clicking on "Next" button
        clickElement(eleNext);
        //Open email details
        eleEmailAuvenir.click();
    }

    public void searchGmail(String GMAIL_SEARCHMAIL) {
        clearTextBox(eleSearchTxtFld, "Search Field");
        sendKeyTextBox(eleSearchTxtFld, GMAIL_SEARCHMAIL, "Search Field");
        clickElement(eleSearchBtn, "Search button");
    }

    /**
     * Refactored by huy.huynh on 02/06/2017 - 05/06/2017.
     * New for smoke test
     */
    @FindBy(xpath = "//a[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//h1[text()='Sign in']")
    private WebElement titleSignIn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement buttonNextToPassword;

    @FindBy(xpath = "//div[@role='link']")
    private WebElement titleForgotPassword;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement buttonPasswordNext;

    @FindBy(xpath = "//div/span[text()='Gmail']")
    private WebElement titleGmail;

    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@id='gbqfb']")
    private WebElement buttonSearch;

    //@FindBy(xpath = "//div[@class='AO']//div[@class='nH']")
    @FindBy(xpath = "//div[@class='nH']/div[@role='main']//tbody")
    private WebElement rowSentEmail;

    @FindBy(xpath = "//h2[@class='hP']")
    private WebElement titleOfEmail;

    @FindBy(xpath = "//a[text()='Start Your Engagement']")
    private WebElement buttonStartEngagement;

    @FindBy(xpath = "//a[text()='Get Started']")
    private WebElement buttonGetStarted;

    @FindBy(id = "BltHke nH oy8Mbf aE3")
    private WebElement divSearchResultHidden;

    @FindBy(xpath = "//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signButtonEle;

    @FindBy(xpath = "(//content/span)[1]")
    private WebElement dropdownOption;

    @FindBy(xpath = "//p[contains(text(),'Use another account')]")
    private WebElement selectAnotherAccount;

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

    public void signInUseAnotherAccount(String email, String password) {
        try {
            getLogger().info("Try to login GMail");
            clickElement(dropdownOption);
            clickElement(selectAnotherAccount);
            sendKeyTextBox(eleEmail, email, "eleEmail");
            sendTabkey(eleEmail, "eleEmail");
            sendEnterkey(eleEmail, "eleEmail");
            getLogger().info("Send email: " + email);
            sendKeyTextBox(elePassword, password, "password");
            getLogger().info("Send password: " + password);
            clickElement(eleNext, "click to eleNext");
            getLogger().info("DONE => LOGIN");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void reSignInGmail(String password) {
        try {
            Thread.sleep(1000);
            elePassword.sendKeys(password);
            getLogger().info("Send password: " + password);
            Thread.sleep(1000);
            clickElement(eleNext, "click to eleNext");
            getLogger().info("DONE => LOGIN");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void reSignInUseAnotherAccount(String email, String password) {
        try {
            getLogger().info("Try to login GMail");
            clickElement(selectAnotherAccount);
            sendKeyTextBox(eleEmail, email, "eleEmail");
            sendTabkey(eleEmail, "eleEmail");
            sendEnterkey(eleEmail, "eleEmail");
            getLogger().info("Send email: " + email);
            sendKeyTextBox(elePassword, password, "password");
            getLogger().info("Send password: " + password);
            clickElement(eleNext, "click to eleNext");
            getLogger().info("DONE => LOGIN");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Sign in to gmail with given email and password
     */
    public void filterEmail() {
        try {
            sendKeyTextBox(inputSearch, GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"), "Search Email");
            clickElement(buttonSearch, "Button Search");
            //waitForCssValueChanged(divSearchResultHidden, "Hidden div", "display", "none");
            waitSomeSeconds(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Enter the email(after search) n click 'Start Engagement' button to go to Auvenir site
     */
    public void clickOnboardingInvitationLink() {
        try {
            clickElement(buttonStartEngagement, "Button Start Engagement");
            getLogger().info("Redirecting from Gmail to Auvenir Welcome Page");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectGetStartedButtonInActiveEmail(){
        try {
            clickElement(buttonGetStarted, "Button Start Engagement");
            getLogger().info("Redirecting from Gmail to Auvenir Welcome Page");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectStartYourEngagementButtonInActiveEmail(){
        try {
            clickElement(buttonStartEngagement, "Button Start Engagement");
            getLogger().info("Redirecting from Gmail to Auvenir Welcome Page");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Enter the email(after search) n click 'Start Engagement' button to go to Auvenir site
     */
    public void clickToEmailDetail() {
        try {
            clickElement(rowSentEmail, "Row Sent Email");
            getLogger().info("Redirecting for Email Detail");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /*-----------end of huy.huynh on 02/06/2017 - 05/06/2017.*/
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeBtn;
    @FindBy(xpath = "//div[@class='ae4 aDM']//div[@role=\"checkbox\"]/div")
    private List<WebElement> lastedMailCheckBox;
    @FindBy(xpath = "//div[@class='J-J5-Ji J-JN-M-I-Jm']//div[@role='presentation']/..")
    private WebElement allMailCheckBox;
    @FindBy(xpath = "//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private WebElement deleteBTN;

    @FindBy(xpath = "//*[@id=\":8q\"]/b")
    private WebElement nonReplyActiveEmail;

    public WebElement getNonReplyActiveEmail() {
        return nonReplyActiveEmail;
    }

    public void deleteAllMail() throws InterruptedException {
        waitForVisibleElement(composeBtn, "composeBtn");
        getLogger().info("Try to delete all existed mail.");
        try {
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
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            getLogger().info(e.getMessage());
        }

    }

    public void deleteLastedMail() throws InterruptedException {
        waitForVisibleElement(composeBtn, "composeBtn");
        getLogger().info("Try to delete the lasted mail.");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(ExpectedConditions.elementToBeClickable(lastedMailCheckBox.get(0)));
            lastedMailCheckBox.get(0).click();
            getLogger().info("Select Delete the lasted mail.");
            Thread.sleep(200);
            clickElement(deleteBTN, "deleteBTN");
            Thread.sleep(500);
            getLogger().info("Delete the lasted mail successfully");
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            getLogger().info(e.getMessage());
        }
    }


    /*
    Vien.pham edited method gmailNewLogin
     */
    public void gmailNewLogin(String userName, String pwd) {
        try {
            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            if (!validateNotExistedElement(getEleEmail(), "UserName textbox")) {
                //Wait for clickable of userName txtbox
                waitForClickableOfElement(getEleEmail(), "UserName textbox");
                sendKeyTextBox(getEleEmail(), userName, "UserName textbox");
                getEleNextBtn().click();
                //Wait for clickable of pwd txtbox
                waitForClickableOfElement(getElePasswordTxtFld(), "Passwd textbox");
                sendKeyTextBox(getElePasswordTxtFld(), pwd, "Passwd textbox");
                getEleSignInBtn().click();
                getEleInviteMailLnk().click();
            }
              /*
              Thread.sleep(2000);
              gmailLoginPo.getEleStartBtn().click();
              gmailWindow = getDriver().getWindowHandle();
              for (String winHandle : getDriver().getWindowHandles()) {
              getDriver().switchTo().window(winHandle);
              */
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectActiveEmaill() {
        Boolean isSelect = clickElement(eleEmailAuvenir, "Non-reply Active email");
        if (isSelect) {
            getLogger().info("Email is existed: Pass");
        } else {
            Assert.fail("Email is not existed: Fail");
        }
    }

    public void verifyNoEmailToCSTeam() throws InterruptedException {
        allMailCheckBox.click();
        Thread.sleep(200);
        if (!deleteBTN.isDisplayed()) {
            getLogger().info("There no email in Inbox");
        } else {
            getLogger().info("Verify no new Email to CS team: Fail");
        }
    }

    /**
     * Refactored by huy.huynh on 26/06/2017.
     * Refactor GeneralClientTest
     */
    @FindBy(className = "CToWUd")
    private WebElement imgAuvenirHeader;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[1]")
    private WebElement titleGreeting;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[2]")
    private WebElement titleAnnouncement;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[3]")
    private WebElement titleAuvenirIntroducing;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[4]")
    private WebElement titleIntroducingBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[5]")
    private WebElement titleFirstBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[6]")
    private WebElement titleSecondBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[7]")
    private WebElement titleThirdBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[8]")
    private WebElement titleFeedback;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[9]")
    private WebElement titleGoodbye;

    @FindBy(xpath = "//a[text()='Reset Password']")
    private WebElement buttonResetPassword;

    String cssGreeting = "font-family: Lato, \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 700; letter-spacing: 0.75px; line-height: 0; margin-top: 15px; color: #363a3c";
    String cssBody = "font-family: Lato, \"Helvetica Neue\", Helvetica, Arial, sans-serif; font-weight: normal; font-size: 14px; line-height: 1.6; color: #707070; padding: 0px; margin: 0px";

    public void verifyHeaderImage(String partialSrc) {
        validateAttributeContain(imgAuvenirHeader, "src", partialSrc, "Auvenir Image Header");
    }

    public void verifyGreetingTitle(String text) {
        validateElementTextContain(titleGreeting, text, "Title Greeting");
        //validateAttributeElement(titleGreeting, "style", cssGreeting);
    }

    public void verifyAnnouncementTitle(String text) {
        validateElementTextContain(titleAnnouncement, text, "Title Announcement");
        //validateAttributeElement(titleAnnouncement, "style", cssBody);
    }

    public void verifyAuvenirIntroducingTitle(String text) {
        validateElementTextContain(titleAuvenirIntroducing, text, "Title Auvenir Introducing");
        //validateAttributeElement(titleAuvenirIntroducing, "style", cssBody);
    }

    public void verifyIntroducingBenefitTitle(String text) {
        validateElementTextContain(titleIntroducingBenefit, text, "Title Introducing Benefit");
        //validateAttributeElement(titleIntroducingBenefit, "style", cssBody);
    }

    public void verifyFirstBenefitTitle(String text) {
        validateElementTextContain(titleFirstBenefit, text, "Title First Benefit");
        //validateAttributeElement(titleFirstBenefit, "style", cssBody);
    }

    public void verifySecondBenefitTitle(String text) {
        validateElementTextContain(titleSecondBenefit, text, "Title Second Benefit");
        //validateAttributeElement(titleSecondBenefit, "style", cssBody);
    }

    public void verifyThirdBenefitTitle(String text) {
        validateElementTextContain(titleThirdBenefit, text, "Title Third Benefit");
        //validateAttributeElement(titleThirdBenefit, "style", cssBody);
    }

    public void verifyFeedbackTitle(String text) {
        validateElementTextContain(titleFeedback, text, "Title Feedback");
        //validateAttributeElement(titleFeedback, "style", cssBody);
    }

    public void verifyGoodbyeTitle(String text) {
        validateElementTextContain(titleGoodbye, text, "Title Goodbye");
        //validateAttributeElement(titleGoodbye, "style", cssBody);
    }

    /**
     * Enter the email(after search) n click 'Reset Password' button to go to Auvenir site
     */
    public void clickResetPasswordLink() {
        try {
            clickElement(buttonResetPassword, "Button Reset Password");
            getLogger().info("Redirecting from Gmail to Auvenir Welcome Page");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 26/06/2017.*/
}