package com.auvenir.ui.tests.marketing;


import com.auvenir.ui.dataprovider.marketing.LoginMarketingDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by toan.nguyenp on 4/11/2017.
 * Update by minh.nguyen on June 30, 2017
 */
public class LoginMarketingTest extends AbstractTest {
    private MarketingService marketingService;
    private GmailLoginService gmailLoginService;
    private AdminService adminService;
    private ClientEngagementService clientEngagementService;

    private AuditorEngagementService auditorEngagementService;


    @Test(priority = 1, enabled= true, description = "Test positive behavior forgot password.", dataProvider = "forgotPasswordTest",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordTest(String emailId, String emailPassword, String ranPassword) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        getLogger().info(ranPassword);
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);

            /*String ranPassword = GenericService.genPassword(8, true, true, true);*/
            NXGReports.addStep("Enter new password: " + ranPassword, LogAs.PASSED, null);
            marketingService.verifyResetPassword(ranPassword,ranPassword);

            GenericService.updateExcelData(testData, "ForgotPassword", 1, 3, ranPassword);
            NXGReports.addStep("Login again after user resets password successfully.", LogAs.PASSED, null);

            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, ranPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive behavior forgot password: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Test positive behavior forgot password: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    @Test(priority = 2, enabled= true, description = "Forgot password with blank email address.", dataProvider = "forgotPasswordWithBlankEmail",
                                dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithBlankEmail(String errorMessage) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with blank email address: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e){
            NXGReports.addStep("Forgot password with blank email address: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    @Test(priority = 3, enabled= true, description = "Forgot password with email is invalid", dataProvider = "forgotPasswordWithInvalidEmail",
                                       dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithInvalidEmail(String invalidEmailAddress, String invalidEmailAddress1,
                                               String invalidEmailAddress2, String errorMessage) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        invalidEmailAddress = GenericService.sBrowserData + invalidEmailAddress;
        invalidEmailAddress1 = GenericService.sBrowserData + invalidEmailAddress1;
        invalidEmailAddress2 = GenericService.sBrowserData + invalidEmailAddress2;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);

            marketingService.closeForgotPasswordDialog();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress1);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);

            marketingService.closeForgotPasswordDialog();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress2);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyGUIEmailForgotPasswordTextBox();
            marketingService.verifyGUIEmailForgotPasswordMessage();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with email is invalid: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE),e.getMessage());
        }
    }

    @Test(priority = 4, enabled= true, description = "Forgot password with email is not exist.", dataProvider = "forgotPasswordWithEmailIsNotExist",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithEmailIsNotExist(String invalidEmailAddress, String errorMessage) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        invalidEmailAddress = GenericService.sBrowserData + invalidEmailAddress;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(invalidEmailAddress);
            marketingService.clickOnRequestResetLinkBTN();
            marketingService.verifyContentEmailForgotPasswordMessage(errorMessage);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with email is not exist: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (Exception e) {
            NXGReports.addStep("Forgot password with email is not exist: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE),e.getMessage());
        }
    }

    @Test(priority = 5,enabled = true, description = "Test positive tests case login and logout", dataProvider = "loginAndLogoutTest",
                                        dataProviderClass = LoginMarketingDataProvider.class)
    public void loginAndLogoutTest(String emailId, String emailPassword) throws Exception {
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, emailPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            marketingService.logout();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test positive tests case login and logout: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Test positive tests case login and logout: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), e.getMessage());
        }
    }

    @Test(priority = 6, enabled = true,description = "Clear all cookies after user login successfully.", dataProvider = "clearCookieAfterLoginSuccessTest"
                                                                                                ,dataProviderClass = LoginMarketingDataProvider.class )
    public void clearCookieAfterLoginSuccessTest(String emailId, String emailPassword){
        marketingService = new MarketingService(getLogger(),getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(emailId, emailPassword);
            marketingService.deleteAllCookieName();
            marketingService.refreshHomePage();
            marketingService.verifyLogoutBTNIsNotPresented();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Clear all cookies after user login successfully: PASSED", LogAs.PASSED, (CaptureScreen) null);
        }catch (AssertionError e){
            NXGReports.addStep("Clear all cookies after user login successfully: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE),e.getMessage());
        }
    }

    @Test(priority = 7, enabled = true, description = "Test login when user input invalid email and password.", dataProvider =
                                                "loginWithInvalidEmailAndPassword", dataProviderClass = LoginMarketingDataProvider.class)
    public void loginWithInvalidEmailAndPassword(String emailInvalid1, String emailInvalid2, String emailInvalid3, String emailNotExists,
            String password) {
        marketingService = new MarketingService(getLogger(),getDriver());
        try {
            marketingService.goToBaseURL();
            marketingService.loginToMarketingPageWithInvalidValue("","");
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyColorPasswordTxtBox();
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid1,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid2,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailInvalid3,password);
            marketingService.verifyColorUserNameTxtBox();
            marketingService.verifyErrorLoginMessage("The email is invalid!");
            marketingService.refreshHomePage();
            marketingService.loginToMarketingPageWithInvalidValue(emailNotExists, password);
            marketingService.verifyErrorLoginMessage("Wrong username or password!");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test login when user does not input email and password: PASSED", LogAs.PASSED, null);
        }catch (Exception e){
            NXGReports.addStep("Test login when user does not input email and password: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen
                    (CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "Forgot password with password is invalid.", dataProvider = "forgotPasswordWithInvalidValue",
                                                                                              dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithInvalidValue(String emailId, String emailPassword,
            String ranPasswordHas7Character, String ranPasswordNotContainsUpperCase,
            String ranPasswordNotContainsLowerCase, String ranPasswordNotContainsDigit, String ranPasswordNotContainsSpecial,
            String ranPasswordContainsUpperLowerCase, String ranPasswordContainsUpperCaseDigit, String ranPasswordContainsUpperCaseSpecial,
            String ranPasswordContainsLowerCaseDigit, String ranPasswordContainsLowerCaseSpecial, String ranPasswordContainDigitSpecial,
            String ranPasswordOnlyUpperCase, String ranPasswordOnlyLowerCase, String ranPasswordOnlyDigit, String ranPasswordOnlySpecial) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);


            marketingService.verifyNewPassword(ranPasswordHas7Character);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordHas7Character, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainDigitSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainDigitSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlySpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlySpecial, LogAs.PASSED, null);


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Forgot password with password is invalid: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Forgot password with password is invalid: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen(CaptureScreen
                    .ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }
    @Test(priority = 9, enabled = true , description = "Verify alert when user re-types new password not match.", dataProvider =
                            "forgotPasswordWithRetypePasswordNotMatchTest",dataProviderClass = LoginMarketingDataProvider.class)
    public void forgotPasswordWithRetypePasswordNotMatchTest(String emailId, String emailPassword,
                                                             String ranPassword, String ranReNewPassword) throws InterruptedException {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailId = GenericService.sBrowserData + emailId;
        try {
            marketingService.deleteGmail(emailId,emailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(emailId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(emailId, emailPassword);
            marketingService.verifyNewPassword(ranPassword);
            marketingService.setConfirmPassword(ranReNewPassword);
            marketingService.verifyConfirmPasswordErrorMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify alert when user re-types new password not match: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify alert when user re-types new password not match: FAILED", LogAs.FAILED, (CaptureScreen) new CaptureScreen
                    (CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }


    @Test(priority = 10, enabled = true, description = "Verify reset admin password flow.", dataProvider = "verifyAdminResetPassword",
                        dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAdminResetPassword(String adminId, String adminPassword, String adminEmailPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        adminId = GenericService.sBrowserData + adminId;

        try {
            marketingService.deleteGmail(adminId, adminEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(adminId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(adminId, adminEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(adminPassword);
            adminService.verifyPageLoad();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset admin password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset admin password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), e.getMessage());
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset admin password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), ex.getMessage());
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify reset admin password with invalid value.", dataProvider = "verifyAdminResetPasswordInvalidValue",
            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAdminResetPasswordInvalidValue(String adminId, String adminEmailPassword,
            String ranPasswordHas7Character, String ranPasswordNotContainsUpperCase,
            String ranPasswordNotContainsLowerCase, String ranPasswordNotContainsDigit, String ranPasswordNotContainsSpecial,
            String ranPasswordContainsUpperLowerCase, String ranPasswordContainsUpperCaseDigit, String ranPasswordContainsUpperCaseSpecial,
            String ranPasswordContainsLowerCaseDigit, String ranPasswordContainsLowerCaseSpecial, String ranPasswordContainDigitSpecial,
            String ranPasswordOnlyUpperCase, String ranPasswordOnlyLowerCase, String ranPasswordOnlyDigit, String ranPasswordOnlySpecial) {

        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        adminId = GenericService.sBrowserData + adminId;

        try {
            marketingService.deleteGmail(adminId, adminEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(adminId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(adminId, adminEmailPassword);
            marketingService.verifyResetPasswordPageTitle();

            marketingService.verifyNewPassword(ranPasswordHas7Character);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordHas7Character, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainDigitSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainDigitSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlySpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlySpecial, LogAs.PASSED, null);


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset admin password with invalid value.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset admin password with invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), e.getMessage());
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset admin password with invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), ex.getMessage());
        }
    }

    @Test(priority = 12, enabled = true, description = "Verify reset admin password not match.", dataProvider = "verifyAdminResetPasswordNotMatch",
                                                                            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAdminResetPasswordNotMatch(String adminId, String adminEmailPassword,
                                                 String ranPassword, String ranReNewPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        adminId = GenericService.sBrowserData + adminId;

        try {
            marketingService.deleteGmail(adminId, adminEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(adminId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(adminId, adminEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.verifyNewPassword(ranPassword);
            marketingService.setConfirmPassword(ranReNewPassword);
            marketingService.verifyConfirmPasswordErrorMessage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset admin password not match.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset admin password not match.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), e.getMessage());
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset admin password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE), ex.getMessage());
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify reset auditor password flow.", dataProvider = "verifyAuditorResetPassword",
                            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAuditorResetPassword(String auditorId, String auditorPassword, String auditorEmailPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            marketingService.deleteGmail(auditorId, auditorEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(auditorId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(auditorId, auditorEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset auditor password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset auditor password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset auditor password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify reset auditor password invalid value.", dataProvider = "verifyAuditorResetPasswordInValidValue",
            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAuditorResetPasswordInValidValue(String auditorId, String auditorEmailPassword,
            String ranPasswordHas7Character, String ranPasswordNotContainsUpperCase,
            String ranPasswordNotContainsLowerCase, String ranPasswordNotContainsDigit, String ranPasswordNotContainsSpecial,
            String ranPasswordContainsUpperLowerCase, String ranPasswordContainsUpperCaseDigit, String ranPasswordContainsUpperCaseSpecial,
            String ranPasswordContainsLowerCaseDigit, String ranPasswordContainsLowerCaseSpecial, String ranPasswordContainDigitSpecial,
            String ranPasswordOnlyUpperCase, String ranPasswordOnlyLowerCase, String ranPasswordOnlyDigit, String ranPasswordOnlySpecial) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            marketingService.deleteGmail(auditorId, auditorEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(auditorId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(auditorId, auditorEmailPassword);
            marketingService.verifyResetPasswordPageTitle();

            marketingService.verifyNewPassword(ranPasswordHas7Character);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordHas7Character, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainDigitSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainDigitSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlySpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlySpecial, LogAs.PASSED, null);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset auditor password invalid value.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset auditor password invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset auditor password invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 15, enabled = true, description = "Verify reset auditor password not match.", dataProvider = "verifyAuditorResetPasswordNotMatch",
            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyAuditorResetPasswordNotMatch(String auditorId, String auditorEmailPassword,
                                                   String ranPassword, String ranReNewPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            marketingService.deleteGmail(auditorId, auditorEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(auditorId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(auditorId, auditorEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.verifyNewPassword(ranPassword);
            marketingService.setConfirmPassword(ranReNewPassword);
            marketingService.verifyConfirmPasswordErrorMessage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset auditor password not match.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset auditor password not match.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset auditor password not match.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }


    @Test(priority = 16, enabled = true, description = "Verify reset client password flow.", dataProvider = "verifyClientResetPassword",
            dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyClientResetPassword(String clientId, String clientPassword, String clientEmailPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.deleteGmail(clientId, clientEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(clientId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(clientId, clientEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.fillUpAndConfirmPassword(clientPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset client password flow.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset client password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset client password flow.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify reset client password invalid value.", dataProvider =
            "verifyClientResetPasswordInValidValue", dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyClientResetPasswordInValidValue(String clientId, String clientEmailPassword,
            String ranPasswordHas7Character, String ranPasswordNotContainsUpperCase,
            String ranPasswordNotContainsLowerCase, String ranPasswordNotContainsDigit, String ranPasswordNotContainsSpecial,
            String ranPasswordContainsUpperLowerCase, String ranPasswordContainsUpperCaseDigit, String ranPasswordContainsUpperCaseSpecial,
            String ranPasswordContainsLowerCaseDigit, String ranPasswordContainsLowerCaseSpecial, String ranPasswordContainDigitSpecial,
            String ranPasswordOnlyUpperCase, String ranPasswordOnlyLowerCase, String ranPasswordOnlyDigit, String ranPasswordOnlySpecial) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.deleteGmail(clientId, clientEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(clientId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(clientId, clientEmailPassword);
            marketingService.verifyResetPasswordPageTitle();

            marketingService.verifyNewPassword(ranPasswordHas7Character);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordHas7Character, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsUpperCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsLowerCase, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsDigit, LogAs.PASSED, null);


            marketingService.verifyNewPassword(ranPasswordNotContainsSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordNotContainsSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsUpperCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsUpperCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainsLowerCaseSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainsLowerCaseSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordContainDigitSpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordContainDigitSpecial, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyUpperCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyUpperCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyLowerCase);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyLowerCase, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlyDigit);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlyDigit, LogAs.PASSED, null);

            marketingService.verifyNewPassword(ranPasswordOnlySpecial);
            marketingService.verifyNewPasswordErrorMessage();
            NXGReports.addStep("Enter new password: " + ranPasswordOnlySpecial, LogAs.PASSED, null);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset client password invalid value.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset client password invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset client password invalid value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify reset client password not match.", dataProvider = "verifyClientResetPasswordNotMatch",
                                                         dataProviderClass = LoginMarketingDataProvider.class)
    public void verifyClientResetPasswordNotMatch(String clientId, String clientEmailPassword,
                                                  String ranPassword, String ranReNewPassword) {
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientId = GenericService.sBrowserData + clientId;

        try {
            marketingService.deleteGmail(clientId, clientEmailPassword);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.goToForgotPassword();
            marketingService.verifyForgotPasswordTitle();
            marketingService.inputEmailForgotPassword(clientId);
            marketingService.clickOnRequestResetLinkBTN();
            gmailLoginService.openGmailIndexForgotPassword(clientId, clientEmailPassword);
            marketingService.verifyResetPasswordPageTitle();
            marketingService.verifyNewPassword(ranPassword);
            marketingService.setConfirmPassword(ranReNewPassword);
            marketingService.verifyConfirmPasswordErrorMessage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify reset client password not match.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify reset client password not match.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify reset client password not match.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            //throw ex;
        }
    }
}
