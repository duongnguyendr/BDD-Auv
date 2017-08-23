package com.auvenir.ui.tests.marketing;

import com.auvenir.ui.dataprovider.marketing.AuditorSignUpDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorTeamService;
import com.auvenir.ui.services.client.ClientDetailsEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNewEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by thuan.duong on 6/2/2017.
 */
public class AuditorSignUpTest extends AbstractTest {
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;
    private EmailTemplateService emailTemplateService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private AuditorTeamService auditorTeamService;


    @Test(priority = 1, enabled = true, description = "Verify Register and Active Auditor User", dataProvider = "verifyRegisterAndActiveAuditorUser",
            dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyRegisterAndActiveAuditorUser(String strFullName, String emailCreate, String strRoleFirm, String strPhone, String strReference,
            String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity,
            String strCountry, String strState, String strMemberID, String strNumEmp, String strPhoneFirm, String strAffName, String strPathLogo,
            String passwordCreate, String strAdminEmail, String strAdminPwd, String sStatusUser) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        emailCreate = GenericService.sBrowserData + emailCreate;
        strAdminEmail = GenericService.sBrowserData + strAdminEmail;

        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            // Below comment code need to be verify with new environment due to the business rule is changed.
            auditorSignUpService.deleteUserUsingApi(emailCreate);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService
                    .registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strCountry, strState,
                            strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();
            gmailLoginService.deleteAllExistedEmail(emailCreate, passwordCreate);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            adminService.changeTheStatusUser(emailCreate, sStatusUser);
            gmailLoginService.gmailReLogin(passwordCreate);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyActiveEmailTemplateContent();

            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.createPassword(passwordCreate);
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Input information firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Input information sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify Firm sign up page and Input Invalid Test.",
            dataProvider = "verifyAuditorFirmInputInvalidValue", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyAuditorFirmInputInvalidValue(String strFullName, String strEmail, String strRoleFirm, String strPhone, String strReference,
            List<String> firmNameInvalidDataList, List<String> preFirmNameInvalidDataList, List<String> firmWebsiteInvalidDataList,
            List<String> zipCodeInvalidDataList, List<String> memberIdInvalidDataList, List<String> phoneNumberIdInvalidDataList,
            List<String> affFirmInvalidDataList) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        try {
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, strEmail, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            //            Verify input valid Value on Firm name: with one Blank, two spaces in character, with one blank and character"
            auditorSignUpService.verifyInputValidValueOnFirmNameTextBox(firmNameInvalidDataList);
            //            Verify input valid Value on Previous name: with one Blank, two spaces in character and special character"
            // Business rule changed. The previous name is removed.
            //            auditorSignUpService.clickOnChangedNameCheckBox();
            //            auditorSignUpService.verifyInputValidValueOnPreFirmNameTextBox(preFirmNameInvalidDataList);
            //            Verify input valid Value on Website Textbox: with one Blank, space before character, invalid format, special character"
            auditorSignUpService.verifyInputValidValueOnFirmWebsiteTextBox(firmWebsiteInvalidDataList);
            //            Verify input valid Value on Zip Code: with one Blank, five character, seventh character, with Number and Special Character, Special Character
            auditorSignUpService.verifyInputValidValueOnZipCodeTextBox(zipCodeInvalidDataList);
            //            Verify input valid Value on Member Id: with one Blank, with Special Character, with Space between Number
            auditorSignUpService.verifyInputValidValueOnMemberIdTextBox(memberIdInvalidDataList);
            //            Verify input valid Value on Phone Number Id: with one Blank, with nine number, with Character, with special character
            auditorSignUpService.verifyInputValidValueOnPhoneNumberIdTextBox(phoneNumberIdInvalidDataList);
            //            Verify input valid Value Affiliated Firm's Name: with one Blank, with 2 Space in character, with Special Character
            auditorSignUpService.clickOnAllFirmCheckBox();
            auditorSignUpService.verifyInputValidValueOnAffFirmTextBox(affFirmInvalidDataList);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify firm sign up page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify firm sign up page: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify Personal sign up page and Input Invalid Test.",
            dataProvider = "verifyAuditorPersonalInputInvalidValue", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyAuditorPersonalInputInvalidValue(List<String> firstLastNameInvalidDataList, List<String> emailInvalidDataList, String strEmail,
            String confirmEmailInvalidData, List<String> phoneInvalidDataList) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());

        try {
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            //            Verify input valid Value on Full Name Text box: with one character, only two blank, with one character and one blank, two spaces in character, one special Characters, with number"
            auditorSignUpService.verifyInputValidValueOnFullNameTxtBox(firstLastNameInvalidDataList);
            //            Verify input valid Value on Email Text box: with one character, input blank, input invalid format Name, input invalid format Style
            auditorSignUpService.verifyInputValidValueOnEmailTxtBox(emailInvalidDataList);
            //            Verify input valid Value on Confirm Email Text box: with invalid value"
            auditorSignUpService.inputValueIntoEmailTextBox(strEmail);
            auditorSignUpService.verifyInputValidValueOnConfirmEmailTxtBox(confirmEmailInvalidData);
            //            Verify input valid Value on Phone Number Text box: with blank, with 9 number, with character, with Special Character
            auditorSignUpService.verifyInputValidValueOnPhoneNumberTxtBox(phoneInvalidDataList);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Full Name are highlight when input only with 1 character: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Full Name are highlight when input only with 1 character: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify GUI when input password random blank",
            dataProvider = "verifyAuditorSecurityInputInvalidPassword", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyAuditorSecurityInputInvalidPassword(String strFullName, String emailCreate, String strRoleFirm, String strPhone,
            String strReference, String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode,
            String strCity, String strCountry, String strState, String strMemberID, String strNumEmp, String strPhoneFirm, String strAffName,
            String strPathLogo, String passwordCreate, String strAdminEmail, String strAdminPwd, String sStatusUser, String blankPassword,
            String invalidLengthPassword, String noUpperCasePassword, String noLowerCasePassword, String noDigitsPassword, String noCharPassword,
            String successPassword, String confirmPassword) throws Exception {

        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());

        emailCreate = GenericService.sBrowserData + emailCreate;
        strAdminEmail = GenericService.sBrowserData + strAdminEmail;
        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            // Below comment code need to be verify with new environment due to the business rule is changed.
            auditorSignUpService.deleteUserUsingApi(emailCreate);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService
                    .registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strCountry, strState,
                            strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();

            gmailLoginService.deleteAllExistedEmail(emailCreate, passwordCreate);

            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithNewUserRole(strAdminEmail, strAdminPwd);
            adminService.changeTheStatusUser(emailCreate, sStatusUser);

            gmailLoginService.gmailReLogin(passwordCreate);
            gmailLoginService.selectActiveEmaill();

            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.verifyCreateInvalidPassword(blankPassword, false, false, false);
            auditorSignUpService.verifyCreateInvalidPassword(invalidLengthPassword, true, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noUpperCasePassword, false, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noLowerCasePassword, true, true, true);
            auditorSignUpService.verifyCreateInvalidPassword(noDigitsPassword, true, true, false);
            auditorSignUpService.verifyCreateInvalidPassword(noCharPassword, false, false, true);
            auditorSignUpService.inputValueIntoPaswordInput(successPassword);
            auditorSignUpService.verifyInputWrongConfirmPassword(confirmPassword);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI when input password random have invalid length: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify GUI when input password random have invalid length: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    @Test(priority = 5, enabled = true, description = "Verify Provice and State displayed correctly when Auditor Signed up",
            dataProvider = "verifyProvinceAndStateWhenSignUp", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyProvinceAndStateWhenSignUp(String strFullName, String emailCreate, String strRoleFirm, String strPhone, String strReference,
            String strCountry, String strState, String selectAnyCountry, String selectAnyState) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        emailCreate = GenericService.sBrowserData + emailCreate;
        try {
            auditorSignUpService.deleteUserUsingApi(emailCreate);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService.verifyCountryList();
            auditorSignUpService.selectAnyCountry(strCountry);
            auditorSignUpService.verifyCountrySelectedCorrectly(strCountry);
            auditorSignUpService.verifyStateListAfterSelectCountry(strCountry);
            auditorSignUpService.selectAnyState(strState);
            auditorSignUpService.verifyStateSelectedCorrectly(strState);
            auditorSignUpService.verifyCountryList();
            auditorSignUpService.selectAnyCountry(selectAnyCountry);
            auditorSignUpService.verifyCountrySelectedCorrectly(selectAnyCountry);
            auditorSignUpService.verifyStateListAfterSelectCountry(selectAnyCountry);
            auditorSignUpService.selectAnyState(selectAnyState);
            auditorSignUpService.verifyStateSelectedCorrectly(selectAnyState);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Provice and State displayed correctly when Signed up: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Provice and State displayed correctly when Signed up: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify Member ID", dataProvider = "verifyMemberIDWhenSignUp",
            dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyMemberIDWhenSignUp(String strFullName, String emailCreate, String strRoleFirm, String strPhone, String strReference,
            String memberIDAlphabet, String memberIDNumeric, String memberIDSpecialChar, String memberIDMoreWords,
            String memberIDAlphaNumeric) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        emailCreate = GenericService.sBrowserData + emailCreate;

        try {
            auditorSignUpService.deleteUserUsingApi(emailCreate);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, emailCreate, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService.verifyMemberID_DefaultValue();
            auditorSignUpService.inputMemberID(memberIDAlphabet);
            auditorSignUpService.verifyValidMemberID(memberIDAlphabet);
            auditorSignUpService.inputMemberID(memberIDNumeric);
            auditorSignUpService.verifyValidMemberID(memberIDNumeric);
            auditorSignUpService.inputMemberID(memberIDAlphaNumeric);
            auditorSignUpService.verifyValidMemberID(memberIDAlphaNumeric);
            auditorSignUpService.inputMemberID(memberIDSpecialChar);
            auditorSignUpService.verifyInvalidMemberID(memberIDSpecialChar);
            auditorSignUpService.inputMemberID(memberIDMoreWords);
            auditorSignUpService.verifyInvalidMemberID(memberIDMoreWords);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member ID: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Member ID: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    @Test(priority = 7, enabled = true, description = "Email to Customer Success Team (internal) after Lead Auditor sign up",
            dataProvider = "verifyEmailToCustomerSuccessTeamAfterLeadAuditorSignedUp", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyEmailToCustomerSuccessTeamAfterLeadAuditorSignedUp(String strFullName, String auditorAccount, String strRoleFirm,
            String strPhone, String strReference, String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum,
            String strZipCode, String strCity, String strCountry, String strState, String strMemberID, String strNumEmp, String strPhoneFirm,
            String strAffName, String strPathLogo, String successTeamEmail, String successTeamEmailPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorAccount = GenericService.sBrowserData + auditorAccount;
        successTeamEmail = GenericService.sBrowserData + successTeamEmail;
        try {
            auditorSignUpService.deleteUserUsingApi(auditorAccount);
            auditorSignUpService.deleteAllExistedGMail(successTeamEmail, successTeamEmailPwd);
            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(strFullName, auditorAccount, strRoleFirm, strPhone, strReference);
            auditorSignUpService.verifyFirmSignUpPage();
            auditorSignUpService
                    .registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity, strCountry, strState,
                            strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();
            //Verify email to success Team
            gmailLoginService.gmailReLogin(successTeamEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.verifyEmailToCustomerSuccessTeam(auditorAccount, strFullName, strName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Member ID: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Member ID: FAILED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    @Test(priority = 8, enabled = true, description = "Verify Auditor invite client", dataProvider = "verifyAuditorInviteClient",
            dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyAuditorInviteClient(String leadClient, String leadAuditor, String leadAuditorPwd, String engagementName,
            String leadClientEmailPwd, String leadClientFullName, String leadClientAuvenirPwd, String successTeamEmail, String successTeamEmailPwd,
            String inviteClientSuccessfulMessage, String updatePhoneNumber, String updateStackerHolder, String roleClient) throws Exception {
        getLogger().info("Verify Auditor invite a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadClient = GenericService.sBrowserData + leadClient;
        leadAuditor = GenericService.sBrowserData + leadAuditor;
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClient);
        try {
            gmailLoginService.deleteAllExistedEmail(leadClient, leadClientEmailPwd);
            gmailLoginService.deleteAllExistedEmailUseAnotherAccount(successTeamEmail, successTeamEmailPwd);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(leadAuditor, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            //auditor invite client
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(leadClientFullName, leadClient, "");
            clientService.verifyInviteClientSuccess(inviteClientSuccessfulMessage);
            gmailLoginService.gmailReLoginUseAnotherAccount(leadClient, leadClientEmailPwd);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(updatePhoneNumber);
            clientSignUpService.fillUpBusinessForm(updateStackerHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(leadClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor invite a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor invite a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }


    @Test(priority = 9, enabled = true, description = "Customer Success Team  has not received any Email(internal) after Lead Client sign up",
            dataProvider = "verifyNoEmailToCustomerSuccessTeam", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyNoEmailToCustomerSuccessTeamAfterLeadClientSignUp(String successTeamEmail, String successTeamEmailPwd) throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        try {
            gmailLoginService.gmailLogin(successTeamEmail, successTeamEmailPwd);
            //Verify no email to Customer successteam
            gmailLoginService.verifyNoEmailToCSTeamInbox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Customer inbox after Lead Client sign up", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Customer inbox after Lead Client sign up", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }


    @Test(priority = 10, enabled = true, description = "Verify Auditor invite general Auditor", dataProvider = "verifyAuditorInviteGeneralAuditor",
            dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyAuditorInviteGeneralAuditor(String generalAuditor, String leadAuditor, String leadAuditorPwd, String engagementName,
            String generalAuditorEmailPwd, String generalAuditorFullName, String generalAuditorAuvenirPwd, String successTeamEmail,
            String successTeamEmailPwd) throws Exception {
        getLogger().info("Verify Auditor invite a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTeamService = new AuditorTeamService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        //        clientId = GenericService.sBrowserData + clientId;
        //        auditorId = GenericService.sBrowserData + auditorId;
        generalAuditor = GenericService.sBrowserData + generalAuditor;
        leadAuditor = GenericService.sBrowserData + leadAuditor;
        try {
            auditorSignUpService.deleteUserUsingApi(generalAuditor);
            gmailLoginService.deleteAllExistedEmail(generalAuditor, generalAuditorEmailPwd);
            gmailLoginService.deleteAllExistedEmailUseAnotherAccount(successTeamEmail, successTeamEmailPwd);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(leadAuditor, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.navigateToInviteGeneralMember();
            auditorTeamService.inputInviteNewMemberInfo(generalAuditorFullName, generalAuditor, "");
            gmailLoginService.gmailReLoginUseAnotherAccount(generalAuditor, generalAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.confirmInfomationNewAuditorUser(generalAuditorFullName, generalAuditor, generalAuditorAuvenirPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor invite general Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor invite general Auditor", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 11, enabled = true, description = "Customer Success Team  has not received any Email(internal) after general Auditor sign up",
            dataProvider = "verifyNoEmailToCustomerSuccessTeam", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyNoEmailToCustomerSuccessTeamAfterGeneralAuditorSignUp(String successTeamEmail, String successTeamEmailPwd) throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

      /*  String successTeamEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
        String successTeamEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid
        Value");*/

        try {
            gmailLoginService.gmailLogin(successTeamEmail, successTeamEmailPwd);
            gmailLoginService.verifyNoEmailToCSTeamInbox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Customer inbox after general Auditor sign up", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Customer inbox after general Auditor sign up", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }


    @Test(priority = 12, enabled = true, description = "Verify Lead Client invite general client",
            dataProvider = "verifyLeadClientInviteGeneralClient", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyLeadClientInviteGeneralClient(String generalClient, String leadClient, String leadClientPwd, String engagementName,
            String generalClientEmailPwd, String generalClientFullName, String generalClientAuvenirPwd, String successTeamEmail,
            String successTeamEmailPwd, String inviteClientSuccessfulMessage, String updatePhoneNumber, String updateStackerHolder) throws Exception {
        getLogger().info("Verify Auditor invite a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        generalClient = GenericService.sBrowserData + generalClient;
        leadClient = GenericService.sBrowserData + leadClient;
           /*
            String generalClient = GenericService.getTestDataFromExcel("AuditorSignUpTest", "GENERAL_CLIENT_USER_ID", "Valid Value");
            String generalClientAuvenirPwd = GenericService
                    .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_USER_PASSWORD", "Valid Value");
            String generalClientEmailPwd = GenericService
                    .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_EMAIL_PASSWORD", "Valid Value");
            String generalClientFullName = GenericService
                    .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_USER_FULLNAME", "Valid Value");
            String leadClient = GenericService.getTestDataFromExcel("AuditorSignUpTest", "CLIENT_USER_ID", "Valid Value");
            String leadClientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "CLIENT_USER_PASSWORD", "Valid Value");
            String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Engagement Name", "Valid Value");
            String successTeamEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
            String successTeamEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid Value");
*/
        MongoDBService.removeClientAndIndicatedValueByEmail(generalClient);
        try {
            gmailLoginService.deleteAllExistedEmail(generalClient, generalClientEmailPwd);
            gmailLoginService.deleteAllExistedEmailUseAnotherAccount(successTeamEmail, successTeamEmailPwd);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(leadClient, leadClientPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.navigateToInviteGeneralMember();

            clientService.fillInfoToInviteNewMember(generalClientFullName, generalClient, "");
            clientService.verifyInviteClientSuccess(inviteClientSuccessfulMessage);
            // client login Gmail to Signup
            gmailLoginService.gmailReLoginUseAnotherAccount(generalClient, generalClientEmailPwd);
            //            gmailLoginService.filterEmail();
            //            gmailLoginService.navigateAuvenirFromInvitationLink();
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(updatePhoneNumber);
            clientSignUpService.fillUpBusinessForm(updateStackerHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(generalClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client invite general client", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client invite general client", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 13, enabled = true, description = "Customer Success Team  has not received any Email(internal) after general Auditor sign up",
            dataProvider = "verifyNoEmailToCustomerSuccessTeam", dataProviderClass = AuditorSignUpDataProvider.class)
    public void verifyNoEmailToCustomerSuccessTeamAfterGeneralClientSignUp(String successTeamEmail, String successTeamEmailPwd) throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

      /*  String successTeamEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
        String successTeamEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid
        Value");*/
        try {
            gmailLoginService.gmailLogin(successTeamEmail, successTeamEmailPwd);
            gmailLoginService.verifyNoEmailToCSTeamInbox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Customer inbox after general Auditor sign up", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Customer inbox after general Auditor sign up", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

}
