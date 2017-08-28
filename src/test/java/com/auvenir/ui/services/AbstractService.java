package com.auvenir.ui.services;

//import com.auvenir.ui.pages.common.GmailPage;
//import com.auvenir.ui.pages.marketing.MarketingPage;
//import com.auvenir.ui.services.admin.AdminService;
//import com.auvenir.ui.services.auditor.AuditorEngagementService;
//import com.auvenir.ui.services.marketing.AuditorSignUpService;
//import com.auvenir.ui.services.marketing.EmailTemplateService;
//import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.bdd.pages.MarketingPage;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.WebService;
//import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
//import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
//import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import static com.auvenir.ui.tests.AbstractTest.httpProtocol;

/**
 * Created by cuong.nguyen on 4/25/2017.
 * Updated by Doai.Tran
 * Udpated by Minh.Nguyen on June 19, 2017
 */
public class AbstractService {
    private WebDriver driver;
    private Logger logger;
    private static final int waitTime = 20;
    public static WebDriverWait sWebDriverWait = null;
    public static String gmailWindow;

    /*
    Variable to validate Passed - Failed of a TestCases
     */
    public static int sStatusCnt = 0;

    /**
     * Base url this value is set at runtime.
     */
    public static String baseUrl = "https://ariel.auvenir.com";
    MarketingPage marketingPage;
    private final String keywordApiDelete = "/delete";
    private final String keywordApiUpdateActive = "/update?status=ACTIVE";
    private final String keywordApiUpdateOnboading = "/update?status=ONBOARDING";

    private String apiUrl = "";
//    private AuditorSignUpService auditorSignUpService;
//    private MarketingService marketingService;
//    private AdminService adminService;
//    private GmailLoginService gmailLoginService;
//    private EmailTemplateService emailTemplateService;
//    private AuditorEngagementService auditorEngagementService;

    public void setApiUrl(String apiURL) {
        this.apiUrl = "https://" + apiURL;
        getLogger().info("API Url: " + this.apiUrl);
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public static String prefixProtocol = "";

    public String getPrefixProtocol() {
        return prefixProtocol;
    }

    public void setPrefixProtocol(String prefixProtocol) {
        this.prefixProtocol = prefixProtocol;
    }

    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */
    public AbstractService(Logger logger, WebDriver driver) {
        this.logger = logger;
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        marketingPage = new MarketingPage(getLogger(), getDriver());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String serverDomainName) {
        // S3 do not use HTTPS
        baseUrl = serverDomainName;
        getLogger().info("Url of testing server is: " + baseUrl);
    }

    /*
    Closed by Doai Tran
    Refactor => Currently, we do not use this method to login. we will use only userid to login.

    public void loginWithUserRole(String userId, String getTokenUrl, String checkTokenUrl) {
        try {
            getLogger().info("Login with user role: " + userId);
            driver.get(getTokenUrl + userId);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
            String[] parts = s1.split("(\")");
            String token = parts[3];
            //GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", checkTokenUrl + userId + "&token=" + token);
            driver.get(checkTokenUrl + userId + "&token=" + token);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            NXGReports.addStep("Login with userid: " + userId, LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Login with userid: " + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
    */

    public void loginWithUserRole(String userId) {
        try {
            getLogger().info("Login with user role: " + userId);
            if (prefixProtocol == "") {
                prefixProtocol = "https://";
            }
            setBaseUrl(prefixProtocol + System.getProperty("serverDomainName"));
//            setBaseUrl(prefixProtocol + "auvenir-qa-automation.com");
            String getTokenUrl = getBaseUrl() + "/getToken?email=";
            getLogger().info("gettoken link: " + getTokenUrl);
            driver.get(getTokenUrl + userId);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
            String[] parts = s1.split("(\")");
            String token = parts[3];
            String checkTokenUrl = getBaseUrl() + "/checkToken?email=";
            getLogger().info("checktokenurl: " + checkTokenUrl);
            //GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", checkTokenUrl + userId + "&token=" + token);
            driver.get(checkTokenUrl + userId + "&token=" + token);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
            driver.manage().window().maximize();
//            NXGReports.addStep("Login with userid: " + userId, LogAs.PASSED, null);
        } catch (Exception e) {
//            NXGReports.addStep("Login with userid: " + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }

    }

    public void executeAutoITScriptUploadImage(String AutoITScripDirectory, String fileDirectory) throws IOException {
        try {
            String[] cmdRun = new String[]{AutoITScripDirectory, fileDirectory};
            Runtime.getRuntime().exec(cmdRun);
//            NXGReports.addStep("Execute AutoITScriptUploadImage successfully", LogAs.PASSED, null);
        } catch (Exception e) {
//            NXGReports.addStep("Execute AutoITScriptUploadImage successfully", LogAs.FAILED, null);
            throw e;
        }
    }

    private String baseLanguage = "English";

    public String getLanguage() {
        return baseLanguage;
    }

    public void setLanguage(String language) {
        baseLanguage = language;
        getLogger().info("Language of page is: " + baseLanguage);
    }

    /*
    This method will be used on Advertisement and Marketing page.
     */
    public void goToBaseURL() {
        try {
            if ("".equals(prefixProtocol)) {
                prefixProtocol = "https://";
            }
            //TODO: temproryly for stable environment
            setBaseUrl(prefixProtocol + System.getProperty("serverDomainName"));
            String baseUrl = getBaseUrl();
            getLogger().info("Go to baseURL: " + baseUrl);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);
            setLanguage(System.getProperty("language"));
            String sLanguage = getLanguage();
            if (sLanguage == null) {
                sLanguage = "English";
            }
            getLogger().info(sLanguage);
            if (sLanguage.equals("French")) {
                getLogger().info("Language is : " + baseLanguage);
//                marketingPage.clickOnChangeLanguageBTN();
            }
            GenericService.sLanguage = sLanguage;
//            NXGReports.addStep("Go to home page successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            //NXGReports.addStep("unable to go to home page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            /*NXGReports.addStep("unable to go to home page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());*/
        }
    }

    public void loginToMarketingPageWithInvalidValue(String UserName, String Password) {
        try {
//            goToBaseURL();
//            marketingPage.clickOnLoginBTN();
            getLogger().info("Input Username and Password.");
//            marketingPage.inputUserNamePassword(UserName, Password);
            getLogger().info("Click on Login button.");
//            marketingPage.clickOnSubmitBTN();
            //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//            marketingPage.waitPageLoad();
//            marketingPage.waitForJSandJQueryToLoad();
        } catch (Exception e) {
//            NXGReports.addStep("unable to login to Marketing page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    //Loading the URL by keeping in config properties
    private String homeAuvenirUrl = "https://ariel.auvenir.com";

    public String getHomeAuvenirUrl() {
        return homeAuvenirUrl;
    }

    public void setHomeAuvenirUrl(String serverDomainName) {
        if (prefixProtocol == "") {
            prefixProtocol = "https://";
        }
        // S3 do not use HTTPS
        homeAuvenirUrl = prefixProtocol + serverDomainName;
        getLogger().info("Url of testing server is: " + homeAuvenirUrl);
    }

    public void goToAuvenirHomePage() {
        try {
            setHomeAuvenirUrl(System.getProperty("serverDomainName"));
            String homeAuvenir = getHomeAuvenirUrl();
            getLogger().info("Go to home auvenri url : " + homeAuvenir);
            System.out.println(homeAuvenir);
            driver.get(homeAuvenir);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (AssertionError e) {
//            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public static String parentWin = null;
    public static String newWin = null;

    public void switchToWindow() {
        logger.info("Detect new windows.");
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            parentWin = it.next();
            newWin = it.next();

        }
        logger.info("Switch to new windwos.");
        driver.switchTo().window(newWin);

    }

    public void navigateToURL(String sUrl) {
        try {
            System.out.println(sUrl);
            driver.get(sUrl);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (AssertionError e) {
//            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void callRestApiUpdateUser(String userId, String keywordUpdate) {
        try {
            getLogger().info("Update user role: " + userId);
            setApiUrl(System.getProperty("apiURL") + "/api/user/");
            String apiUpdateUserUrl = getApiUrl() + userId + keywordUpdate;
            driver.get(apiUpdateUserUrl);
            String s1 = driver.findElement(By.xpath("//pre")).getText();
//            String[] parts = s1.split("(\")");
//            String statusCode = parts[6];
//            statusCode = StringUtils.replaceChars(statusCode, ":", "");
//            statusCode = StringUtils.replaceChars(statusCode, "}", "");
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            System.out.println("Status Code: " + s1);
            if (s1.contains("\"code\":200")) {
                getLogger().info("Existed user is deleted successful.");
            } else if (s1.contains("\"code\":400")) {
                getLogger().info("The client is not existed in database.");
            } else {
                getLogger().info(s1);
            }
//            NXGReports.addStep("Call API service successfully" + userId, LogAs.PASSED, null);
        } catch (Exception e) {
//            NXGReports.addStep("Call API service unsuccessfully" + userId, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * Delete User using API Url
     *
     * @param userEmail The email which is deleted.
     */
    public void deleteUserUsingApi(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiDelete);
    }

    /**
     * Update status of user to Onboarding using API Url
     *
     * @param userEmail The email which is updated.
     */
    public void updateUserOnboardingUsingAPI(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiUpdateOnboading);
    }

    /**
     * Update status of user to Active using API Url
     *
     * @param userEmail The email which is updated.
     */
    public void updateUserActiveUsingAPI(String userEmail) {
        callRestApiUpdateUser(userEmail, keywordApiUpdateActive);
    }

    /*
    Refactoring to join AbstractRefactorService
     */
    public void navigateToURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        driver.get(sGetTokenURL + sEmailID);
        String s1 = driver.findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        //GenericService.setConfigValue(GenericService.sConfigFile, "LOGIN_URL", sCheckTokenURL + sEmailID + "&token=" + token);
        driver.get(sCheckTokenURL + sEmailID + "&token=" + token);
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Getting the URl by passing Dev Auth ID and Authentication key

    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(logger);
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            //System.out.println(GenericService.getConfigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
//            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            sWebDriverWait = new WebDriverWait(driver, waitTime);
            V until = sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            sStatusCnt++;
//            NXGReports.addStep(elementName + " is not Visible", LogAs.FAILED, null);
        }
    }

    public void gmaillLogin() throws Exception {
        try {
//            GmailPage gmailLoginPage = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //gmailLoginPage.getEleSignInLink().click();
//            if (gmailLoginPage.getEleEmailIDTxtFld().isDisplayed()) {
//                gmailLoginPage.getEleEmailIDTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
//                gmailLoginPage.getEleNextBtn().click();
//            }
//            Thread.sleep(5000);
//            gmailLoginPage.getElePasswordTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_PWD"));
//            gmailLoginPage.getEleSignInBtn().click();
//            Assert.assertTrue(gmailLoginPage.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
//            Thread.sleep(5000);
//            gmailLoginPage.getEleSearchTxtFld().sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
//            gmailLoginPage.getEleSearchBtn().click();
//            gmailLoginPage.getEleInviteMailLnk().click();
//            gmailWindow = driver.getWindowHandle();
//
//            gmailLoginPage.getEleStartBtn().click();
//            switchToWindow();
//
//            driver.close();
//            driver.switchTo().window(parentWin);
        } catch (AssertionError e) {
//            NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*public void auditorLogout() throws Exception {
        Thread.sleep(10000);
        GmailPage gmailLoginPage = new GmailPage(logger, driver);
        driver.close();

        driver.switchTo().window(gmailWindow);
        gmailLoginPage.getEleProfileIcn().click();
        gmailLoginPage.getEleSignOutBtn().click();
    }*/

    /**
     * Refactored by huy.huynh on 06/06/2017.
     * New for smoke test
     */

    /**
     * Scroll to footer of current page
     *
     * @param webDriver current webDriver
     */
    public void scrollToFooter(WebDriver webDriver) {
        //marketingPage.scrollToFooter(webDriver);
        getLogger().info("Scroll down to see page footer.");
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /*
        Deleted by Doai.Tran
        Review and refactor duplicate methods.
     *
     * Delete given email user
     *
     * @param email current webDriver
     *//*
    public String deleteUserViaAPI(String email) {
        String deleteURL = GenericService.getConfigValue(GenericService.sConfigFile, "DELETE_URL")
                + email + "/delete";
        navigateToURL(deleteURL);
        return GeneralUtilities.getElementByXpath(getDriver(), "//pre").getText();
    }


    public void verifyAPIResponseSuccessCode(String message, String role) {
        getLogger().info(message);
        if (!message.contains("\"code\":200")) {
            NXGReports.addStep(role + " is delete fail. Message: " + message, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(role + " is delete fail");
            sStatusCnt++;
        } else {
            NXGReports.addStep(role + " is delete success. " + message, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(role + " is delete success.");
        }
    }
    */

    /*-----------end of huy.huynh on 06/06/2017.*/
    /*
    Method to delete all existed mail in GMail.
     */

     /*public void deleteAllExistedGMail(String eGMail, String ePassword) {
        getLogger().info("Try to delete all existed eGMail");
        try {
            GmailPage gmailLoginPage = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            gmailLoginPage.signInGmail(eGMail, ePassword);
            gmailLoginPage.deleteAllMail();
            gmailLoginPage.gmailLogout();
        } catch (Exception e) {
            getLogger().info("Unable to delete all existed mail.");
        }
    }

    public void deleteAllExistedGmailUseAnotherAccount(String eGmail, String ePassword){
        getLogger().info("Try to delete all existed eGMail");
        try {
            GmailPage gmailLoginPage = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            gmailLoginPage.signInUseAnotherAccount(eGmail, ePassword);
            gmailLoginPage.deleteAllMail();
            gmailLoginPage.gmailLogout();
        } catch (Exception e) {
            getLogger().info("Unable to delete all existed mail.");
        }
    }

    public void reLoginUseAnotherAccount(String user, String pwd){
        GmailPage gmailLoginPage = new GmailPage(logger, driver);
        try {
            gmailLoginPage.reSignInUseAnotherAccount(user, pwd);
        }catch (Exception e){
            getLogger().info("Unable to relogin use another account.");
        }

    }*/

    /*
    Method to the lasted mail in GMail.
     */
    /*public void deleteTheLastedGMail(String eGMail, String ePassword) {
        getLogger().info("Try to delete all existed eGMail");
        try {
            GmailPage gmailLoginPage = new GmailPage(logger, driver);
            driver.get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginPage.signInGmail(eGMail, ePassword);
            gmailLoginPage.deleteLastedMail();
            gmailLoginPage.gmailLogout();
        } catch (Exception e) {
            getLogger().info("Unable to delete all existed mail.");
        }
    }*/

    /**
     * Delete user using MongoDB service.
     *
     * @param email The email which is deleted.
     */
    /*public void deleteUserUsingMongoDB(String email) {
        try {
            MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), email);
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }*/

    /**
     * Update status of user to ONBOARDING using MongoDB service.
     *
     * @param email The email which is deleted.
     */
    /*public void updateUserOnboardingUsingMongoDB(String email) {
        try {
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), email, "status", "ONBOARDING");
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }*/

    /**
     * Update status of user to ACTIVE using MongoDB service.
     *
     * @param email The email which is updated.
     */
    /*public void updateUserActiveUsingMongoDB(String email) {
        try {
            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), email, "status", "ACTIVE");
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("User cannot be deleted.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }*/

    /**
     * Logout of Gmail.
     */
    /*public void logoutGmail() {
        getLogger().info("Try to logout gmail.");
        try {
            GmailPage gmailLoginPage = new GmailPage(logger, driver);
            gmailLoginPage.gmailLogout();
        } catch (Exception e) {
            sStatusCnt++;
            NXGReports.addStep("Cannot logout of gmail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info("Unable to logout of gmail.");
        }
    }

    public void createAndActiveNewUserByEmail(String fullNameCreate, String strEmailCreate, String passwordCreate, String strAdminEmail, String strAdminPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        // This test cases is verified creating new user.
        // It must be deleted old user in database before create new one.
        setPrefixProtocol(httpProtocol);
        deleteUserUsingApi(strEmailCreate);
        deleteUserUsingMongoDB(strEmailCreate);
        goToBaseURL();
        auditorSignUpService.verifyRegisterNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreate);
        gmailLoginService.deleteAllExistedEmail(strEmailCreate, passwordCreate);
        marketingService.setPrefixProtocol(httpProtocol);
        goToBaseURL();
        marketingService.openLoginDialog();
        marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
        adminService.changeTheStatusUser(strEmailCreate, "Onboarding");
        getLogger().info("Auditor open Email and verify it.. ");
        getLogger().info("Auditor login his email to verify Welcome email template");
        gmailLoginService.gmailReLogin(passwordCreate);
        gmailLoginService.selectActiveEmaill();
        emailTemplateService.verifyActiveEmailTemplateContent();
//        logoutGmail();
//        emailTemplateService.clickGetStartedButton();
//        switchToWindow();
        emailTemplateService.navigateToConfirmationLink();
        auditorSignUpService.confirmInfomationNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreate);
        auditorEngagementService.verifyAuditorEngagementPage();
        marketingService.logout();
    }

    public void createAndActiveNewUserByEmail(String fullNameCreate, String strEmailCreate, String passwordCreatedGmail, String passwordCreatedAuvenir, String strAdminEmail, String strAdminPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        // This test cases is verified creating new user.
        // It must be deleted old user in database before create new one.
        setPrefixProtocol(httpProtocol);
        deleteUserUsingApi(strEmailCreate);
        deleteUserUsingMongoDB(strEmailCreate);
        goToBaseURL();
        auditorSignUpService.verifyRegisterNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreatedAuvenir);
        gmailLoginService.deleteAllExistedEmail(strEmailCreate, passwordCreatedGmail);
        marketingService.setPrefixProtocol(httpProtocol);
        goToBaseURL();
        marketingService.openLoginDialog();
        marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
        ;
        adminService.changeTheStatusUser(strEmailCreate, "Onboarding");
        getLogger().info("Auditor open Email and verify it.. ");
        getLogger().info("Auditor login his email to verify Welcome email template");
        gmailLoginService.gmailReLogin(passwordCreatedGmail);
        gmailLoginService.selectActiveEmaill();
        emailTemplateService.verifyActiveEmailTemplateContent();
//        logoutGmail();
//        emailTemplateService.clickGetStartedButton();
//        switchToWindow();
        emailTemplateService.navigateToConfirmationLink();
        auditorSignUpService.confirmInfomationNewAuditorUser(fullNameCreate, strEmailCreate, passwordCreatedAuvenir);
        auditorEngagementService.verifyAuditorEngagementPage();
        marketingService.logout();
    }

    public void openLoginDialog() {
        getLogger().info("Click on login button.");
        marketingPage.clickOnLoginBTN();
    }

    public void loginWithUserNamePassword(String UserName, String Password) {
        getLogger().info("Input Username and Password.");
        marketingPage.inputUserNamePassword(UserName, Password);
        getLogger().info("Click on Login button.");
        marketingPage.clickOnSubmitBTN();
        marketingPage.waitForProgressOverlayIsClosed();
        marketingPage.clickClosePopupWarningBrowser();
    }

    public void logout() {
        marketingPage.clickOnProfile();
        getLogger().info("Logout.");
        marketingPage.clickOnLogoutBTN();
    }
    public void scrollDown(WebDriver webDriver) {
        //marketingPage.scrollToFooter(webDriver);
        getLogger().info("Scroll down.");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }
    public void scrollUp(WebDriver webDriver) {
        //marketingPage.scrollToFooter(webDriver);
        getLogger().info("Scroll up.");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
    }*/
}
