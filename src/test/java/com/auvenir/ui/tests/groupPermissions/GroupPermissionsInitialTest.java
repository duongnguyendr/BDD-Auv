package com.auvenir.ui.tests.groupPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.auvenir.ui.services.auditor.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.client.ClientDetailsEngagementService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientEngagementTeamService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.client.ClientTeamService;
import com.auvenir.ui.services.client.ClientTodoService;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.groupPermissions.AdminClientService;
import com.auvenir.ui.services.groupPermissions.GeneralAuditorService;
import com.auvenir.ui.services.groupPermissions.GeneralClientService;
import com.auvenir.ui.services.groupPermissions.LeadAuditorService;
import com.auvenir.ui.services.groupPermissions.LeadClientService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by huy.huynh on 19/07/2017.
 */
public class GroupPermissionsInitialTest extends AbstractTest {
    private AdminService adminService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTeamService auditorTeamService;
    private GmailLoginService gmailLoginService;
    private AuditorSignUpService auditorSignUpService;
    private MarketingService marketingService;
    private EmailTemplateService emailTemplateService;
    private AuditorTodoListService auditorTodoListService;
    private ClientService clientService;
    private ClientEngagementTeamService clientEngagementTeamService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private ClientEngagementService clientEngagementService;
    private ClientTodoService clientTodoService;
    private ClientTeamService clientTeamService;
    private AdminAuditorService adminAuditorService;
    private LeadAuditorService leadAuditorService;
    private GeneralAuditorService generalAuditorService;
    private AdminClientService adminClientService;
    private LeadClientService leadClientService;
    private GeneralClientService generalClientService;
    private AuditorToDoService auditorTodoService;
    private AuditorFileService auditorFileService;

    @Test(/*priority = 1,*/ enabled = true, description = "Verify Normal Admin is able to login", alwaysRun = true,
            dataProvider = "verifySuperAdminLogin", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifySuperAdminLogin(String superAdminUser, String superAdminPwd) {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminUser = GenericService.sBrowserData + superAdminUser;
        try {
            marketingService.loginUsingUsernamePassword(superAdminUser, superAdminPwd);
            adminService.verifyPageLoad();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Super Admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Super Admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 1, */enabled = true, description = "Verify Normal Admin is able to login", dependsOnMethods = {"verifySuperAdminLogin"},
            alwaysRun = true, dataProvider = "verifyAdminLogin", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminLogin(String adminId, String adminPwd) {
        getLogger().info("Verify admin is able to login.");
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminId = GenericService.sBrowserData + adminId;
        try {
            marketingService.loginUsingUsernamePassword(adminId, adminPwd);
            adminService.verifyPageLoad();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Normal Admin is able to login.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Normal Admin is able to login.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 1, */enabled = true, description = "Verify Register and sign up successfully an Auditor User",
            dependsOnMethods = {"verifyAdminLogin"}, alwaysRun = true, dataProvider = "verifySignUpAuditorUser",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifySignUpAuditorUser(String adminAuditorEmail, String adminAuditorFullName, String firmName, String roleFirm, String phoneNumber,
            String referenceToAuvenir, String firmPreName, String firmWebsite, String streetAddress, String officeNumber, String zipCode, String city,
            String country, String stateNumber, String memberEmail, String numberEmployee, String phoneFirm, String affiliateFirmName,
            String pathLogo) throws Exception {
        getLogger().info("Verify Register and sign up successfully an Auditor User.");
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        try {
            // This test cases is verified creating new user.
            // It must be deleted old user in database before create new one.
            MongoDBService.removeAllActivitiesCollectionOfAUser(adminAuditorEmail);
            MongoDBService.removeAllFirmByName(firmName);
            MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorEmail);

            auditorSignUpService.deleteUserUsingApi(adminAuditorEmail);

            auditorSignUpService.goToBaseURL();
            auditorSignUpService.navigateToSignUpPage();
            auditorSignUpService.verifyPersonalSignUpPage();
            auditorSignUpService.registerAuditorPersonal(adminAuditorFullName, adminAuditorEmail, roleFirm, phoneNumber, referenceToAuvenir);
            auditorSignUpService
                    .registerFirmInfo(firmName, firmPreName, firmWebsite, streetAddress, officeNumber, zipCode, city, country, stateNumber,
                            memberEmail, numberEmployee, phoneFirm, affiliateFirmName, pathLogo);
            auditorSignUpService.verifySuccessSignUpPage();
            auditorSignUpService.acceptCreateAccountAuditor();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Admin auditor sign up from marketing page: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Admin auditor sign up from marketing page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 2, */enabled = true, description = "Verify Admin user can change status of Auditor User from Wait-List to On Boarding.",
            testName = "if_2", dependsOnMethods = {"verifySignUpAuditorUser"}, alwaysRun = true,
            dataProvider = "verifyAdminChangeStatusUserToOnBoarding", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminChangeStatusUserToOnBoarding(String adminAuditorEmail, String adminEmail, String adminAuditorEmailPwd,
            String adminAuvenirPwd, String onboardingStatus) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(adminAuditorEmail, adminAuditorEmailPwd);

            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.changeTheStatusUser(adminAuditorEmail, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Admin change status of admin Auditor to On-Boarding: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Admin change status of admin Auditor to On-Boarding: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 3, */enabled = true, description = "Verify Auditor user status: Active Auditor User and create a password.", testName = "if_3",
            dependsOnMethods = {"verifyAdminChangeStatusUserToOnBoarding"}, alwaysRun = true, dataProvider = "verifyAuditorLoginGmailAndActiveUser",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorLoginGmailAndActiveUser(String adminAuditorEmail, String adminAuditorEmailPwd,
            String adminAuditorAuvenirPwd) throws Exception {
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        try {
            gmailLoginService.gmailLogin(adminAuditorEmail, adminAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();

            //TODO: from not support ff version, recheck for new code run in ff
            adminService.clickClosePopupWarningBrowser();
            auditorSignUpService.createPassword(adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Admin Auditor be active via Mail link: PASSED", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("Admin Auditor be active via Mail link: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 4, */enabled = true, description = "Admin Auditor create new Engagement1", testName = "if_4",
            dependsOnMethods = {"verifyAuditorLoginGmailAndActiveUser"}, alwaysRun = true, dataProvider = "verifyAdminAuditorCreateSimpleEngagement",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCreateSimpleEngagement(String adminAuditorEmail, String engagementName1, String companyName,
            String adminAuditorAuvenirPwd) {
        getLogger().info("Admin Auditor create new Engagement1 (simple engagement).");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);

        MongoDBService.removeEngagementCreatedByLeadAuditor(adminAuditorEmail, engagementName1);
        MongoDBService.removeAllBusinessByName(companyName);

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName1, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagement: Passed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagement: Failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 6,*/ enabled = true, description = "Verify that Admin Auditor can invite new member.", testName = "if_6, if_9",
            dependsOnMethods = {"verifyAdminAuditorCreateSimpleEngagement"}, alwaysRun = true,
            dataProvider = "verifyAdminAuditorInviteNewMemberAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInviteNewMemberAuditor(String leadAuditorEmail, String leadAuditorAuvenirPwd, String adminAuditorEmail,
            String adminAuditorAuvenirPwd, String engagementName1, String leadAuditorFullName, String partnerRole,
            String leadAuditorEmailPwd) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTeamService = new AuditorTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        MongoDBService.removeAllActivitiesCollectionOfAUser(leadAuditorEmail);
        MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorEmail);
        auditorSignUpService.deleteUserUsingApi(leadAuditorEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(leadAuditorEmail, leadAuditorAuvenirPwd);

            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);
            auditorDetailsEngagementService.navigateToTeamTab();
            auditorTeamService.deleteMemberInEngagementByName(leadAuditorFullName);

            auditorTeamService.clickInviteMember();
            auditorTeamService.inputInviteNewMemberInfo(leadAuditorFullName, leadAuditorEmail, partnerRole);
            auditorTeamService.verifyAddNewInvitedMember(leadAuditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(leadAuditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(leadAuditorFullName, leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /////// Test case verifyAdminAuditorInvitingNewClient, verifyClientLogsInAndActive, verifyClientActiveAfterSignUpSuccess will be uncomment to
    // run after the issue ( the System cannot add client member ) is fixed.

    @Test(/*priority = 8,*/ enabled = true, description = "Verify that Auditor can invite a client", testName = "if_8",
            dependsOnMethods = {"verifyAdminAuditorInviteNewMemberAuditor"}, alwaysRun = true, dataProvider = "verifyAdminAuditorInvitingNewClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInvitingNewClient(String adminEmail, String adminAuvenirPwd, String adminClientEmail, String adminClientEmailPwd,
            String adminAuditorEmail, String adminAuditorAuvenirPwd, String engagementName1, String adminClientFullName, String roleClient,
            String onboardingStatus, String leadClientEmail, String clientEmail) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        adminAuditorEmail = GenericService.addBrowserPrefix(adminAuditorEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);
        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientEmail, adminClientEmailPwd);

            marketingService.loginUsingUsernamePassword(adminAuditorEmail, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(adminClientFullName, adminClientEmail, roleClient);
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(adminClientEmail, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 9,*/ enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed", testName = "if_8",
            dependsOnMethods = {"verifyAdminAuditorInvitingNewClient"}, alwaysRun = true, dataProvider = "verifyClientLogsInAndActive",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientLogsInAndActive(String adminClientEmail, String adminClientEmailPwd, String clientPhoneNumber, String parentStackHolder,
            String adminClientAuvenirPwd, String engagementName1) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(adminClientEmail, adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName1);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 10,*/ enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_10",
            dependsOnMethods = {"verifyClientLogsInAndActive"}, alwaysRun = true, dataProvider = "verifyLeadAuditorCreateNewEngagement",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCreateNewEngagement(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String companyName) {
        getLogger().info("Lead Auditor create new Engagement2.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        try {
            MongoDBService.removeEngagementCreatedByLeadAuditor(leadAuditorEmail, engagementName2);
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName2, "", companyName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Auditor create new Engagament (simple engagement).", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 11,*/ enabled = true, description = "Verify that Lead Auditor can invite a admin client", testName = "if_11",
            dependsOnMethods = {"verifyLeadAuditorCreateNewEngagement"}, alwaysRun = true, dataProvider = "verifyLeadAuditorInvitingAdminClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInvitingAdminClient(String leadAuditorUser, String leadAuditorAuvenirPwd, String adminClientUser,
            String adminClientEmailPwd, String adminClientAuvenirPwd, String engagementName2, String adminClientFullNameAndCompany,
            String clientPhoneNumber, String parentStackHolder) throws Exception {
        getLogger().info("Verify Lead Auditor inviting a admin client.");
        // This test case should invite a admin client by add member client (a client is existed in the system)
        // But due to the issue that system cannot add a client member, this test case will invite new Admin client.\
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        leadAuditorUser = GenericService.addBrowserPrefix(leadAuditorUser);
        adminClientUser = GenericService.addBrowserPrefix(adminClientUser);

        //need precondition for save engagement name, and delete this engagement or client on acl
        //to init: delete client on acl and keycontact on business

        //        MongoDBService.removeClientAndIndicatedValueByEmail(adminClientEmail);
        //        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        //        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);

        try {
            gmailLoginService.deleteAllExistedEmail(adminClientUser, adminClientEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorUser, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectClientWithFullName(adminClientFullNameAndCompany);
            clientService.inviteExistedClient();
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            gmailLoginService.gmailReLogin(adminClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(adminClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
            throw e;
        }
    }

    @Test(/*priority = 12,*/ enabled = true, description = "Verify that lead auditor user create a engagement 2", testName = "if_12, if_13",
            dependsOnMethods = {"verifyLeadAuditorInvitingAdminClient"}, alwaysRun = true, dataProvider = "verifyLeadAuditorInviteNewAuditorMember",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorInviteNewAuditorMember(String leadAuditorEmail, String leadAuditorAuvenirPwd, String auditorEmail,
            String auditorEmailPwd, String auditorAuvenirPwd, String engagementName2, String auditorFullName, String partnerRole) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTeamService = new AuditorTeamService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());

        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            MongoDBService.removeAllActivitiesCollectionOfAUser(auditorEmail);
            auditorSignUpService.deleteUserUsingApi(auditorEmail);

            gmailLoginService.deleteAllExistedEmail(auditorEmail, auditorEmailPwd);

            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            auditorDetailsEngagementService.navigateToTeamTab();
            auditorTeamService.deleteMemberInEngagementByName(auditorFullName);

            auditorTeamService.clickInviteMember();
            auditorTeamService.inputInviteNewMemberInfo(auditorFullName, auditorEmail, partnerRole);
            auditorTeamService.verifyAddNewInvitedMember(auditorFullName, partnerRole);

            // Invited Auditor User Login gmail and active user.
            gmailLoginService.gmailReLogin(auditorEmailPwd);
            gmailLoginService.selectActiveEmaill();
            emailTemplateService.navigateToConfirmationLink();
            adminService.clickClosePopupWarningBrowser();

            auditorSignUpService.confirmInfomationNewAuditorUser(auditorFullName, auditorEmail, auditorAuvenirPwd);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Add New Member Auditor", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Test script Failed: Verify Add New Member Auditor", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(/*priority = 15,*/ enabled = true, description = "Verify Admin Client have permission to invite client via email.", testName = "if_15",
            dependsOnMethods = {"verifyLeadAuditorInviteNewAuditorMember"}, alwaysRun = true, dataProvider = "verifyAdminClientCanInviteClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminClientCanInviteClient(String adminClientEmail, String adminClientAuvenirPwd, String leadClientEmail,
            String leadClientEmailPwd, String adminEmail, String adminAuvenirPwd, String engagementName2, String leadClientFullName,
            String successMessageInvitation, String onboardingStatus, String roleClient) throws Exception {

        getLogger().info("Verify Admin Client have permission to invite client via email.");
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        clientTeamService = new ClientTeamService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);

        MongoDBService.removeClientAndIndicatedValueByEmail(leadClientEmail);
        try {
            gmailLoginService.deleteAllExistedEmail(leadClientEmail, leadClientEmailPwd);

            marketingService.loginUsingUsernamePassword(adminClientEmail, adminClientAuvenirPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientTeamService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember(leadClientFullName, leadClientEmail, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);

            marketingService.loginUsingUsernamePassword(adminEmail, adminAuvenirPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(leadClientEmail, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 16,*/ enabled = true, description = "Verify Invited Client have permission to seft-active via email.", testName = "if_16",
            dependsOnMethods = {"verifyAdminClientCanInviteClient"}, alwaysRun = true, dataProvider = "verifyClientCanActiveViaEmail",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientCanActiveViaEmail(String leadClientEmail, String leadClientEmailPwd, String clientPhoneNumber, String parentStackHolder,
            String leadClientAuvenirPwd, String engagementName2) throws Exception {
        getLogger().info("Verify Invited Client have permission to seft-active via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(leadClientEmail, leadClientEmailPwd);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(clientPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(leadClientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Invited Client have permission to seft-active via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 17,*/ enabled = true,
            description = "Verify Lead Client have permission to tranfer their Lead Permission to other Client on team", testName = "if_17",
            dependsOnMethods = {"verifyClientCanActiveViaEmail"}, alwaysRun = true, dataProvider = "verifyLeadPermissionCanBeTranfered",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadPermissionCanBeTranfered(String adminClientEmail, String adminClientAuvenirPwd, String engagementName2,
            String leadClientFullName, String leadText) throws Exception {
        getLogger().info("Verify Admin Client have permission to invite client via email.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTeamService = new ClientTeamService(getLogger(), getDriver());

        adminClientEmail = GenericService.addBrowserPrefix(adminClientEmail);

        try {
            marketingService.loginUsingUsernamePassword(adminClientEmail, adminClientAuvenirPwd);

            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientTeamService.chooseLeadClientWithTeamMemberName(leadClientFullName);
            clientTeamService.verifyLeadSetByName(leadClientFullName, leadText);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Client have permission to invite client via email.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 18,*/ enabled = true, description = "Verify group permission Lead auditor create todo.", testName = "if_18, if_19, if_20",
            dependsOnMethods = {"verifyLeadPermissionCanBeTranfered"}, alwaysRun = true, dataProvider = "verifyLeadAuditorCreateTodoAndAssignClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCreateTodoAndAssignClient(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo2, String todo3, String todo4, String todo5, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        //        leadAuditorEmail = "duongauvenir01@gmail.com";
        //        engagementName2 = "Engagement HD";
        //        leadClientFullName = "Client ABC";
//        List<String> listTodo = new ArrayList<>();
//        listTodo.add(todo1);
//        listTodo.add(todo2);
//        listTodo.add(todo3);
        String [] listTodo = {todo1, todo2, todo3, todo4, todo5};
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(Arrays.asList(listTodo), categoryName);
            auditorCreateToDoService.verifyLeadAuditorSeeListToDoTask(true, Arrays.asList(listTodo));
            auditorCreateToDoService.verifyAssignTodotoClient(Arrays.asList(listTodo), leadClientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 21,*/ enabled = true, description = "Verify group permission Lead auditor assign todo to general auditor.", testName = "if_21",
            dependsOnMethods = {"verifyLeadAuditorCreateTodoAndAssignClient"}, alwaysRun = true,
            dataProvider = "verifyLeadAuditorAssignToGeneralAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAssignToGeneralAuditor(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String auditorFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        String [] listTodo = {todo1, todo4};
        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String auditorAssign = "Auditor 007";
        //        String toDoName = "To-do 1";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectAuditorAssigneeByName(Arrays.asList(listTodo), auditorFullName);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(Arrays.asList(listTodo), auditorFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor assign todo to general auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(description = "Verify group permission Lead auditor add new request.", dependsOnMethods = {"verifyLeadAuditorAssignToGeneralAuditor"},
            alwaysRun = true, dataProvider = "verifyLeadAuditorAddNewRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAddNewRequest(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo2, String todo3, String todo4, String todo5, String requestName1, String requestName2, String requestName3,
            String requestName4, String requestName5, String requestName6) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        //        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        //        String leadAuditorEmail = "duong.lead.auditor@mailinator.com";
        //        String leadAuditorAuvenirPwd = "Changeit@123";
        //        String engagementName2 = "Engagement Dr02";
        //        String todo1 = "To-do 1";
        String [] listTodo = {todo1, todo2, todo3, todo4, todo5};
        String[] listRequest = {requestName1, requestName2, requestName3, requestName4, requestName5, requestName6};
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            auditorCreateToDoService.verifyCreateNewRequest(Arrays.asList(listTodo), Arrays.asList(listRequest));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor add new request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor add new request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(description = "Verify group permission Lead auditor add file to new request.", dependsOnMethods = {"verifyLeadAuditorAddNewRequest"},
            alwaysRun = true, dataProvider = "verifyLeadAuditorAddFileToNewRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAddFileToNewRequest(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo4,
            String requestName1, String requestName2, String requestName3, String requestName4, String requestName5, String requestName6,
            String fileRequestName1, String fileRequestName2, String fileRequestName3, String fileRequestName4, String fileRequestName5,
            String fileRequestName6, String pathOfUploadLocation) throws Exception {

        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        String[] listRequest = {requestName1, requestName2, requestName3, requestName4, requestName5, requestName6};
        String[] listFile = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};

        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.uploadFileByRequestName(pathOfUploadLocation, Arrays.asList(listFile), Arrays.asList(listRequest));
            auditorTodoService.closePopupTodoDetail();
            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.verifyUploadFileSuccessfully(Arrays.asList(listFile), Arrays.asList(listRequest));
            //            auditorCreateToDoService.verifyAddFileToNewRequest(todo1, pathOfUploadLocation, Arrays.asList(listRequest), Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor add file to new request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor add file to new request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(enabled = true, description = "Verify group permission Lead auditor download file from request.",
            dependsOnMethods = {"verifyLeadAuditorAddFileToNewRequest"}, alwaysRun = true, dataProvider = "verifyLeadAuditorDownloadRequestFile",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorDownloadRequestFile(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo4,
            String pathOfUploadLocation, String pathOfDownloadLocation, String fileName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.downloadFileFromRequest(pathOfDownloadLocation, fileName);
            auditorCreateToDoService.verifyDownloadFileSuccessful(pathOfUploadLocation, pathOfDownloadLocation, fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download file from request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor download file from request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(enabled = true, description = "Verify group permission Lead auditor commenting.", testName = "if_25",
            dependsOnMethods = {"verifyLeadAuditorDownloadRequestFile"}, alwaysRun = true, dataProvider = "verifyLeadAuditorCommenting",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCommenting(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo4,
            String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo4);
            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.verifyInputAComment(leadClientFullName);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 26,*/ enabled = true, description = "Verify group permission Lead auditor mark completed todo.", testName = "if_26",
            /*dependsOnMethods = {"verifyLeadAuditorCommenting"},*/ alwaysRun = true, dataProvider = "verifyLeadAuditorMarkCompleted",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorMarkCompleted(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo2) {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        leadAuditorEmail = "duong.lead.auditor@mailinator.com";
        //        leadAuditorAuvenirPwd = "Changeit@123";
        //        engagementName2 = "Engagement AUV353";
        //        todo2 = "todo3";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo2);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(todo2);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 27,*/ enabled = true, description = "Verify Lead auditor Assign ToDo Bulk Action.", testName = "if_27",
            dependsOnMethods = {"verifyLeadAuditorMarkCompleted"}, alwaysRun = true, dataProvider = "verifyLeadAuditorAssignToDoBulkAction",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorAssignToDoBulkAction(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2, String todo3,
            String auditorFullName, String leadClientFullName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String auditorAuvenirPwd = "Changeit@123";
        //        String engagementName = "Firm Auvenir Duong";
        //        String toDoName = "To-do 3";
        //        String fullNameInvitedMember = "Auditor 007";
        //        String fullNameInvitedClient = "Duong Client";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(auditorFullName);
            auditorCreateToDoService.verifyAuditorAssigneeSelected(Arrays.asList(todo3), auditorFullName);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectAssigneeToDoUsingBulkAction(leadClientFullName);
            auditorCreateToDoService.verifyClientAssigneeSelected(todo3, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor Assign ToDo Bulk Action.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 28,*/ enabled = true, description = "Verify group permission Lead auditor delete todo.", testName = "if_28",
            dependsOnMethods = {"verifyLeadAuditorAssignToDoBulkAction"}, alwaysRun = true, dataProvider = "verifyLeadAuditorDeleteTodo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorDeleteTodo(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String todo3) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);

        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String toDoName = "To-do 3";
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo3);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(todo3);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 29,*/ enabled = true, description = "Verify group permission Lead auditor download from all todo.", testName = "if_29",
            dependsOnMethods = {"verifyLeadAuditorDeleteTodo"}, alwaysRun = true, dataProvider = "verifyLeadAuditorDownloadFromAllTodo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorDownloadFromAllTodo(String leadAuditorEmail, String leadAuditorAuvenirPwd, String engagementName2,
            String pathDownload) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        leadAuditorEmail = GenericService.addBrowserPrefix(leadAuditorEmail);
        String fileName = pathDownload + engagementName2 + ".zip";
        //        String auditorId = "duongauvenir01@gmail.com";
        //        String password = "Changeit@123";
        //        String engagement = "Firm Auvenir Duong";
        //        String fileDownload = GenericService.sDirPath + "\\src\\test\\resources\\download\\" + engagement + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(leadAuditorEmail, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission Lead auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 30,*/ enabled = true, description = "Verify group permission General auditor create todo.", testName = "if_30, if_31, if_33",
            dependsOnMethods = {"verifyLeadAuditorDownloadFromAllTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorCreateTodo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorCreateTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo6, String todo7,
            String todo8, String todo9, String todo10, String leadClientFullName, String categoryName) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

//        List<String> listTodo = new ArrayList<>();
//        listTodo.add(todo4);
//        listTodo.add(todo5);
//        listTodo.add(todo6);
//        listTodo.add(todo7);
//        listTodo.add(todo8);
        String [] listTodo = {todo6, todo7, todo8, todo9, todo10};
        String[] listTodoAssigneToClient = {todo6, todo7, todo9};
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorCreateToDoService.createListTodoTaskWithCategoryName(Arrays.asList(listTodo), categoryName);
            auditorCreateToDoService.checkToDoListIsExists(true, Arrays.asList(listTodo));
            auditorCreateToDoService.verifyAssignTodotoClient(Arrays.asList(listTodoAssigneToClient), leadClientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(enabled = true, description = "Verify group permission general auditor add new request.",
            dependsOnMethods = {"verifyGeneralAuditorCreateTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorAddNewRequest",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorAddNewRequest(String auditorUser, String auditorPwd, String engagementName2, String todo6, String todo7,
            String todo8, String todo9, String todo10, String requestName1, String requestName2, String requestName3, String requestName4, String
            requestName5, String requestName6) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorUser = GenericService.addBrowserPrefix(auditorUser);

        String[] listRequest = {requestName1, requestName2, requestName3, requestName4, requestName5, requestName6};
        String[] listTodo = {todo6, todo7, todo8, todo9, todo10};

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.verifyCreateNewRequest(Arrays.asList(listTodo), Arrays.asList(listRequest));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission general auditor add new request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission general auditor add new request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(description = "Verify group permission General auditor add file to new request.", dependsOnMethods = {"verifyGeneralAuditorAddNewRequest"},
            alwaysRun = true, dataProvider = "verifyGeneralAuditorAddFileToNewRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorAddFileToNewRequest(String auditorUser, String auditorPwd, String engagementName2, String todo9,
            String requestName1, String requestName2, String requestName3, String requestName4, String requestName5, String requestName6,
            String fileRequestName1, String fileRequestName2, String fileRequestName3, String fileRequestName4, String fileRequestName5,
            String fileRequestName6, String pathOfUploadLocation) throws Exception {

        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        auditorUser = GenericService.addBrowserPrefix(auditorUser);

        String[] listRequest = {requestName1, requestName2, requestName3, requestName4, requestName5, requestName6};
        String[] listFile = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
            auditorCreateToDoService.clickCommentIconPerTaskName(todo9);
            auditorCreateToDoService.uploadFileByRequestName(pathOfUploadLocation, Arrays.asList(listFile), Arrays.asList(listRequest));
            auditorTodoService.closePopupTodoDetail();
            auditorCreateToDoService.clickCommentIconPerTaskName(todo9);
            auditorCreateToDoService.verifyUploadFileSuccessfully(Arrays.asList(listFile), Arrays.asList(listRequest));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor add file to new request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor add file to new request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(enabled = true, description = "Verify group permission General auditor download file from request.",
            dependsOnMethods = {"verifyGeneralAuditorAddFileToNewRequest"}, alwaysRun = true,
            dataProvider = "verifyGeneralAuditorDownloadRequestFile", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorDownloadRequestFile(String auditorUser, String auditorPwd, String engagementName2, String todo4,
            String pathOfUploadLocation, String pathOfDownloadLocation, String fileName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorUser = GenericService.addBrowserPrefix(auditorUser);

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.clickCommentIconPerTaskName(todo4);
            auditorCreateToDoService.downloadFileFromRequest(pathOfDownloadLocation, fileName);
            auditorCreateToDoService.verifyDownloadFileSuccessful(pathOfUploadLocation, pathOfDownloadLocation, fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead auditor download file from request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead auditor download file from request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 36,*/ enabled = true, description = "Verify group permission General auditor commenting.", testName = "if_36",
            dependsOnMethods = {"verifyGeneralAuditorDownloadRequestFile"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorCommenting",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorCommenting(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo9,
            String generalAuditorCmt) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo9);
            auditorCreateToDoService.clickCommentIconPerTaskName(todo9);
            auditorCreateToDoService.verifyInputAComment(generalAuditorCmt);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, generalAuditorCmt);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor commenting.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 37,*/ enabled = true, description = "Verify group permission General auditor mark completed todo.", testName = "if_37",
            dependsOnMethods = {"verifyGeneralAuditorCommenting"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorMarkCompleted",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorMarkCompleted(String auditorEmail, String auditorAuvenirPwd, String engagementName2,
            String todo7) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo7);
            // Click on Bulk Action drop down
            auditorCreateToDoService.clickBulkActionsDropdown();
            // Verify GUI Mark As Complete popup
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickOnArchiveButtonInMarkAsCompletePopup();
            // Verify mark as complete popup
            auditorCreateToDoService.verifyMarksAsCompletePopupIsClose();

            auditorCreateToDoService.verifyTodoMarkCompleted(todo7);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission General auditor mark completed todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 38,*/ enabled = true, description = "Verify group permission General auditor delete todo.", testName = "if_38",
            dependsOnMethods = {"verifyGeneralAuditorMarkCompleted"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorDeleteTodo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorDeleteTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2, String todo8) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        try {
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.selectToDoTaskName(todo8);
            auditorCreateToDoService.scrollUp(getDriver());
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.selectDeleteToDoUsingBulkAction();
            auditorCreateToDoService.confirmDeleteButton();
            auditorCreateToDoService.verifyToDoNotExist(todo8);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor delete todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor delete todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 39,*/ enabled = true, description = "Verify group permission General auditor download from all todo.", testName = "if_39",
            dependsOnMethods = {"verifyGeneralAuditorDeleteTodo"}, alwaysRun = true, dataProvider = "verifyGeneralAuditorDownloadFromAllTodo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralAuditorDownloadFromAllTodo(String auditorEmail, String auditorAuvenirPwd, String engagementName2,
            String pathDownload) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);
        String fileName = pathDownload + engagementName2 + ".zip";
        try {
            auditorCreateToDoService.checkFileDownloadExisted(fileName);
            marketingService.loginUsingUsernamePassword(auditorEmail, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorCreateToDoService.checkAllCheckBox();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.clickToBulkDownloadAttachmentButton();
            auditorCreateToDoService.clickDownloadAllTodo();
            auditorCreateToDoService.verifyDownloadFileAllTodoSuccess(fileName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission General auditor download from all todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify group permission General auditor download from all todo.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * Vien.Pham added to verify Lead Client and General Client on To-do page.
     */

    @Test(/*priority = 40,*/ enabled = true, description = "Verify Lead Client can see all to-dos", testName = "if_40",
            dependsOnMethods = {"verifyGeneralAuditorDownloadFromAllTodo"}, alwaysRun = true, dataProvider = "verifyLeadClientSeeToDo",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientSeeToDo(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2, String todo1, String todo2,
            String todo4, String todo5, String todo6, String todo7, String todo9) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        String toDoListNames[] = {todo1, todo2, todo4, todo5, todo6, todo7, todo9};
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.verifyClientSeeListTodos(Arrays.asList(toDoListNames));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(/*priority = 41,*/ enabled = true, description = "To verify Lead Client can remove Admin client", testName = "if_41",
            dependsOnMethods = {"verifyLeadClientSeeToDo"}, alwaysRun = true, dataProvider = "verifyLeadClientRemoveAdminClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientRemoveAdminClient(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2,
            String adminClientFullName, String successMessageRemoveTeamMember) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        //        String leadClientPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String adminClientFullName = "Admin Client";
        //        String successMessageRemoveTeamMember = "Your team member has been removed.";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientEngagementTeamService.removeAdminClient(adminClientFullName);
            clientEngagementTeamService.verifyMessageFromRemovingAdminClient(successMessageRemoveTeamMember);
            clientEngagementTeamService.verifyRemoveAdminClient(adminClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can remove Admin client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can remove Admin client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 42,*/ enabled = true, description = "To verify Lead Client can invite a general client", testName = "if_42",
            dependsOnMethods = {"verifyLeadClientRemoveAdminClient"}, alwaysRun = true, dataProvider = "verifyLeadClientInviteClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientInviteClient(String leadClientEmail, String leadClientAuvenirPwd, String clientEmail, String clientEmailPwd,
            String engagementName2, String clientFullName, String successMessageInvitation, String roleClient) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementTeamService = new ClientEngagementTeamService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        //        String leadClientPassword = "Changeit@123";
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String engagementName = "Engagement GP02";
        //        String generalClientFullName = "General Client";
        //        String successMessage = "Your engagement invitation has been sent.";

        MongoDBService.removeClientAndIndicatedValueByEmail(clientEmail);
        try {
            gmailLoginService.deleteAllExistedEmail(clientEmail, clientEmailPwd);
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientDetailsEngagementService.navigateToTeamTab();
            clientService.selectInviteNewMemberButton();
            clientService.fillInfoToInviteNewMember(clientFullName, clientEmail, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 43,*/ enabled = true, description = "Verify general Client can active from invited", testName = "if_43",
            dependsOnMethods = {"verifyLeadClientInviteClient"}, alwaysRun = true, dataProvider = "verifyGeneralClientActive",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientActive(String clientEmail, String clientEmailPwd, String clientAuvenirPwd, String engagementName2,
            String phoneNumber, String parentStackHolder) {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        //        String generalClientEmailPassword = "Changeit@123";
        //        String generalClientAuvenirPassword = "Changeit@123";
        //        String engagementName = "Vien_Engagement";
        //        String phoneNumber = "1234567890";
        //        String stackerHolder = "Titancorpvn";
        try {
            gmailLoginService.gmailLogin(clientEmail, clientEmailPwd);
            gmailLoginService.selectActiveEmaill();
            gmailLoginService.selectStartEngagementBtnToNavigateToAuvenirPage();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPwd);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can invite a new general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can invite a new general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 44,*/ enabled = true, description = "To verify Lead Client can assign todo task to general client", testName = "if_44, if_48",
            dependsOnMethods = {"verifyGeneralClientActive"}, alwaysRun = true, dataProvider = "verifyLeadClientAssignTodoTaskToClient",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientAssignTodoTaskToClient(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2, String todo1,
            String todo6, String todo9, String clientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        String[] listTodo = {todo1, todo6, todo9};
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            for (int i = 0; i < listTodo.length; i++) {
                clientService.selectClientAssigneeByName(listTodo[i], clientFullName);
                clientService.verifyClientAssigneeSelected(listTodo[i], clientFullName);
            }
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can assign task to general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can assign task to general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 45,*/ enabled = true, description = "To verify Lead Client use Bulk Action to assign todo task to general client",
            dependsOnMethods = {"verifyLeadClientAssignTodoTaskToClient"}, alwaysRun = true,
            dataProvider = "verifyLeadClientUseBulkActionToAssignTodoTask", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientUseBulkActionToAssignTodoTask(String leadClientEmail, String leadClientAuvenirPwd, String engagementName2,
            String todo4, String clientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        //        String leadClientEmail = "chr.vienpham.lead.client@gmail.com";
        //        String leadClientAuvenirPwd = "Changeit@123";
        //        String engagementName2 = "Engagement_LeadAuditor";
        //        String todo4 = "lead vien4";
        //        String clientFullName = "General Client";
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.selectCheckboxByTodoName(todo4);
            clientTodoService.clickBulkActionsDropdown();
            clientTodoService.selectAssigneeToDoUsingBulkAction(clientFullName);
            clientTodoService.verifyClientAssigneeSelected(todo4, clientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can assign task to general client through Bulk Action: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can assign task to general client through Bulk Action: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 50,*/ enabled = true, description = "To verify general Client can view All Todos task assigned ", testName = "if_50",
            dependsOnMethods = {"verifyLeadClientUseBulkActionToAssignTodoTask"}, alwaysRun = true,
            dataProvider = "verifyGeneralClientCanViewTodoTaskAssigned", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientCanViewTodoTaskAssigned(String clientEmail, String clientAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9) {
        marketingService = new MarketingService(getLogger(), getDriver());
        //        clientService = new ClientService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        String toDoListNames[] = {todo1, todo4, todo6, todo9};
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(clientEmail, clientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.verifyClientSeeListTodos(Arrays.asList(toDoListNames));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view Todo task assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view Todo task assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 46,*/ description = "Verify Lead client add file to new request.",
            dependsOnMethods = {"verifyGeneralClientCanViewTodoTaskAssigned"}, alwaysRun = true, dataProvider = "verifyLeadClientAddFileToNewRequest",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientAddFileToNewRequest(String leadClientID, String leadClientAuvenirPwd, String engagementName2, String todo6,
            String request1, String request2, String request3, String request4, String request5, String request6, String file1, String file2,
            String file3, String file4, String file5, String file6, String PathUpLoad) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        leadClientID = GenericService.addBrowserPrefix(leadClientID);
        String[] listFile = {file1, file2, file3, file4, file5, file6};
        String[] listRequest = {request1, request2, request3, request4, request5, request6};
        /*String leadClientID = "chr.vienpham.lead.client@gmail.com";
        String leadClientAuvenirPwd = "Changeit@123";
        String engagementName2 = "EngagementLeadAuditor";
        String todo7 = "vien lead7";
        String[] listRequest = {"request1", "request2", "request3", "request4", "request5", "request6"};
        String[] listFile =
                {"TXT_helloAuvenir.txt", "TXT_helloAuvenir.png", "TXT_helloAuvenir.docx", "TXT_Auvenir.jpg", "TXT_Auvenir.pdf", "TXT_Auvenir.xlsx"};

        String pathOfUploadLocation = GenericService.sDirPath + "\\src\\test\\resources\\upload\\";*/
        try {
            marketingService.loginUsingUsernamePassword(leadClientID, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.selectCheckboxByTodoName(todo6);
            clientTodoService.clickCommentIconPerTaskName(todo6, false);
            clientTodoService.uploadFileByRequestName(PathUpLoad, Arrays.asList(listFile), Arrays.asList(listRequest));
            clientTodoService.closePopupTodoDetail();
            clientTodoService.clickCommentIconPerTaskName(todo6, false);
            clientTodoService.verifyUploadFileSuccessfully(Arrays.asList(listFile), Arrays.asList(listRequest));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client add file to new request: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client add file to new request: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(/*priority = 24,*/ enabled = true, description = "Verify group permission Lead client download file from request.",
            dependsOnMethods = {"verifyLeadClientAddFileToNewRequest"}, alwaysRun = true, dataProvider = "verifyLeadClientDownloadFileToNewRequest",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientDownloadRequestFile(String leadClientID, String leadClientAuvenirPwd, String engagementName2, String todo6,
            String fileName, String pathUploadLocation, String pathDownloadLocation) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        leadClientID = GenericService.addBrowserPrefix(leadClientID);
      /*  String leadClientID = "chr.vienpham.lead.client@gmail.com";
        String leadClientAuvenirPwd = "Changeit@123";
        String engagementName2 = "EngagementLeadAuditor";
        String todo7 = "vien lead7";
        String fileName = "TXT_Auvenir.xlsx";
        String pathOfUploadLocation = GenericService.sDirPath + "\\src\\test\\resources\\upload\\";
        String pathOfDownloadLocation = GenericService.sDirPath + "\\src\\test\\resources\\download\\";*/
        try {
            marketingService.loginUsingUsernamePassword(leadClientID, leadClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.selectCheckboxByTodoName(todo6);
            clientTodoService.clickCommentIconPerTaskName(todo6, false);
            clientTodoService.downloadFileFromRequestFile(pathDownloadLocation, fileName);
            clientTodoService.verifyDownloadFileFromRequestSuccessfully(pathUploadLocation, pathDownloadLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission Lead client download file from request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission Lead client download file from request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(/*priority = 47,*/ enabled = true, description = "Verify Lead Client can make a comment on todo assigned", testName = "if_47",
            dependsOnMethods = {"verifyLeadClientDownloadRequestFile"}, alwaysRun = true, dataProvider = "verifyLeadClientMakeComment",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientMakeComment(String leadClientEmail, String leadClientPassword, String engagementName2, String todo6,
            String commentContent) throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
       /* String leadClientEmail = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";*/
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.clickCommentIconPerTaskName(todo6, false);
            clientTodoService.verifyInputAComment(commentContent);
            int numberOfListCommentList = clientTodoService.getNumberOfListComment();
            clientTodoService.clickOnPostCommentButton();
            clientTodoService.verifyNewCommentIsDisplayed(numberOfListCommentList, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can make a comment on todo assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client can make a comment on todo assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 48,*/ enabled = true, description = "Verify general Client can view a comment made by lead client ", testName = "if_47",
            dependsOnMethods = {"verifyLeadClientMakeComment"}, alwaysRun = true, dataProvider = "verifyGeneralClientViewComment",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientCanViewComment(String generalClient, String generalClientAuvenirPassword, String engagementName2, String todo6,
            String commentContent, String leadClientFullName) throws Exception{
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
       /* String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 01";
        String engagementName = "Vien_Engagement";
        String leadClientFullName = "Lead Client";*/
        generalClient = GenericService.addBrowserPrefix(generalClient);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.clickCommentIconPerTaskName(todo6, false);
            clientTodoService.verifyLastCommentOfUserDisplayed(commentContent, leadClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can view a comment made by lead client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can view a comment made by lead client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }


    @Test(/*priority = 53,*/ enabled = true, description = "Verify general Client can make a comment on todo assigned", testName = "if_53",
            dependsOnMethods = {"verifyGeneralClientCanViewComment"}, alwaysRun = true, dataProvider = "verifyGeneralClientPostComment",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientMakeComment(String generalClient, String generalClientAuvenirPassword, String engagementName2, String todo1,
            String commentContent) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        /*String generalClient = GenericService.addBrowserPrefix("auvenirclient2@gmail.com");
        String generalClientAuvenirPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";*/
        generalClient = GenericService.addBrowserPrefix(generalClient);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(generalClient, generalClientAuvenirPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.clickCommentIconPerTaskName(todo1, false);
            clientTodoService.verifyInputAComment(commentContent);
            int numberOfListCommentList = clientTodoService.getNumberOfListComment();
            clientTodoService.clickOnPostCommentButton();
            clientTodoService.verifyNewCommentIsDisplayed(numberOfListCommentList, commentContent);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can make a comment on todo assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can make a comment on todo assigned: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 54,*/ enabled = true, description = "Verify Lead Client can view a comment made by general client ", testName = "if_53",
            dependsOnMethods = {"verifyGeneralClientMakeComment"}, alwaysRun = true, dataProvider = "verifyLeadClientViewComment",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientCanViewComment(String leadClientEmail, String leadClientPassword, String engagementName2, String todo1,
            String commentContent, String generalClientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
       /* String leadClientEmail = GenericService.addBrowserPrefix("vienpham.client.lead@gmail.com");
        String leadClientPassword = "Changeit@123";
        String todoName = "vientodo4";
        String commentContent = "Comment 02";
        String engagementName = "Vien_Engagement";
        String generalClientFullName = "General Client";*/
        leadClientEmail = GenericService.addBrowserPrefix(leadClientEmail);
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserPwd(leadClientEmail, leadClientPassword);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.clickCommentIconPerTaskName(todo1, false);
            clientTodoService.verifyLastCommentOfUserDisplayed(commentContent, generalClientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can view a comment made by general client: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify lead Client can view a comment made by general client: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(/*priority = 51, */description = "Verify general client adds file to new request.", dependsOnMethods = {"verifyLeadClientCanViewComment"},
            alwaysRun = true, dataProvider = "verifyGeneralClientAddFileToNewRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientAddFileToNewRequest(String generalClientID, String generalClientAuvenirPwd, String engagementName2, String todo1,
            String request1, String request2, String request3, String request4, String request5, String request6, String file1, String file2,
            String file3, String file4, String file5, String file6, String PathUpLoad) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        generalClientID = GenericService.addBrowserPrefix(generalClientID);
        String[] listFile = {file1, file2, file3, file4, file5, file6};
        String[] listRequest = {request1, request2, request3, request4, request5, request6};
        /*String generalClientID = "chr.vienpham.client@gmail.com";
        String generalClientAuvenirPwd = "Changeit@123";
        String engagementName2 = "EngagementLeadAuditor";
        String todo8 = "vien lead8";
        String[] listRequest = {"request1", "request2", "request3", "request4", "request5", "request6"};
        String[] listFile =
                {"TXT_helloAuvenir.txt", "TXT_helloAuvenir.png", "TXT_helloAuvenir.docx", "TXT_Auvenir.jpg", "TXT_Auvenir.pdf", "TXT_Auvenir.xlsx"};

        String pathOfUploadLocation = GenericService.sDirPath + "\\src\\test\\resources\\upload\\";*/
        try {
            marketingService.loginUsingUsernamePassword(generalClientID, generalClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.selectCheckboxByTodoName(todo1);
            clientTodoService.clickCommentIconPerTaskName(todo1, false);
            clientTodoService.uploadFileByRequestName(PathUpLoad, Arrays.asList(listFile), Arrays.asList(listRequest));
            clientTodoService.closePopupTodoDetail();
            clientTodoService.clickCommentIconPerTaskName(todo1, false);
            clientTodoService.verifyUploadFileSuccessfully(Arrays.asList(listFile), Arrays.asList(listRequest));
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify genral client adds file to new request: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general client adds file to new request: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    @Test(/*priority = 24,*/ enabled = true, description = "Verify group permission general client download file from request.",
            dependsOnMethods = {"verifyGeneralClientAddFileToNewRequest"}, alwaysRun = true,
            dataProvider = "verifyGeneralClientDownloadFileToNewRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyGeneralClientDownloadRequestFile(String generalClientID, String generalClientAuvenirPwd, String engagementName2, String todo1,
            String fileName, String pathUploadLocation, String pathDownloadLocation) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());
        generalClientID = GenericService.addBrowserPrefix(generalClientID);
      /*  String leadClientID = "chr.vienpham.lead.client@gmail.com";
        String leadClientAuvenirPwd = "Changeit@123";
        String engagementName2 = "EngagementLeadAuditor";
        String todo7 = "vien lead7";
        String fileName = "TXT_Auvenir.xlsx";
        String pathOfUploadLocation = GenericService.sDirPath + "\\src\\test\\resources\\upload\\";
        String pathOfDownloadLocation = GenericService.sDirPath + "\\src\\test\\resources\\download\\";*/
        try {
            marketingService.loginUsingUsernamePassword(generalClientID, generalClientAuvenirPwd);
            clientEngagementService.verifyEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);
            clientTodoService.selectCheckboxByTodoName(todo1);
            clientTodoService.clickCommentIconPerTaskName(todo1, false);
            clientTodoService.downloadFileFromRequestFile(pathDownloadLocation, fileName);
            clientTodoService.verifyDownloadFileFromRequestSuccessfully(pathUploadLocation, pathDownloadLocation, fileName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify group permission general client download file from request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify group permission general client download file from request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * End of Vien Pham
     */

    @Test(priority = 59, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyAdminAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanSeeAllFiles(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);
        //        adminAuditorUser = "thuan.auditor.adm@mailinator.com";
        //        adminAuditorAuvenirPwd = "Changeit@123";
        //        engagementName2 = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo1);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo4);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo6);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo9);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 60, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyLeadAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanSeeAllFiles(String leadAuditorUser, String leadAuditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        leadAuditorUser = GenericService.addBrowserPrefix(leadAuditorUser);
        //        leadAuditorUser = "thuan.lead.auditor@mailinator.com";
        //        leadAuditorAuvenirPwd = "Changeit@123";
        //        String engagementName = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(leadAuditorUser, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            leadAuditorService.verifyLeadAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            leadAuditorService.verifyLeadAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            leadAuditorService.verifyLeadAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            leadAuditorService.verifyLeadAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Lead Auditor Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Lead Auditor Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 61, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorCanSeeAllFiles(String auditorUser, String auditorAuvenirPwd, String engagementName2, String todo1, String todo4,
            String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        auditorUser = GenericService.addBrowserPrefix(auditorUser);
        //        auditorUser = "thuan.auditor@mailinator.com";
        //        auditorAuvenirPwd = "Changeit@123";
        //        String engagementName = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            generalAuditorService.verifyGeneralAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            generalAuditorService.verifyGeneralAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            generalAuditorService.verifyGeneralAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            generalAuditorService.verifyGeneralAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Auditor Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 62, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyAdminClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminClientCanSeeAllFiles(String adminClientUser, String adminClientAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminClientService = new AdminClientService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        adminClientUser = GenericService.addBrowserPrefix(adminClientUser);
        //        adminClientUser = "thuan.client.adm@mailinator.com";
        //        adminClientAuvenirPwd = "Changeit@123";
        //        String engagementName = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(adminClientUser, adminClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo1);
            adminClientService.verifyAdminClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo4);
            adminClientService.verifyAdminClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo6);
            adminClientService.verifyAdminClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo9);
            adminClientService.verifyAdminClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Admin Client Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Client Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 63, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyLeadClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientCanSeeAllFiles(String leadClientUser, String leadClientAuvenirPwd, String engagementName2, String todo1, String todo4,
            String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        leadClientUser = GenericService.addBrowserPrefix(leadClientUser);
        //        leadClientUser = "thuan.client.adm@mailinator.com";
        //        leadClientAuvenirPwd = "Changeit@123";
        //        String engagementName = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(leadClientUser, leadClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo1);
            leadClientService.verifyLeadClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo4);
            leadClientService.verifyLeadClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo6);
            leadClientService.verifyLeadClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo9);
            leadClientService.verifyLeadClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 64, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientCanSeeAllFiles(String clientUser, String clientAuvenirPwd, String engagementName2, String todo1, String todo4,
            String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());
        generalClientService = new GeneralClientService(getLogger(), getDriver());

        clientUser = GenericService.addBrowserPrefix(clientUser);
        //        clientUser = "thuan.client.adm@mailinator.com";
        //        clientAuvenirPwd = "Changeit@123";
        //        String engagementName = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(clientUser, clientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo1);
            generalClientService.verifyGeneralClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo4);
            generalClientService.verifyGeneralClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo6);
            generalClientService.verifyGeneralClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();
            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo9);
            generalClientService.verifyGeneralClientCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Client Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Client Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 65, enabled = true, description = "Verify admin auditor can download file from their assigned To-Do request.",
            testName = "AA_65", dataProvider = "verifyAdminAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanDownloadFileFromTodoRequest(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify admin auditor can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 66, enabled = true, description = "Verify lead auditor can download file from their assigned To-Do request.", testName = "AA_66",
            dataProvider = "verifyLeadAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanDownloadFileFromTodoRequest(String leadAuditorUser, String leadAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify lead auditor can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        leadAuditorUser = GenericService.addBrowserPrefix(leadAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(leadAuditorUser, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify lead auditor can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify lead auditor can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 67, enabled = true, description = "Verify auditor can download file from their assigned To-Do request.", testName = "AA_67",
            dataProvider = "verifyAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorCanDownloadFileFromTodoRequest(String auditorUser, String auditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify auditor can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        auditorUser = GenericService.addBrowserPrefix(auditorUser);

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify auditor can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify auditor can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 68, enabled = true, description = "Verify admin client can download file from their assigned To-Do request.", testName = "AA_68",
            dataProvider = "verifyAdminClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminClientCanDownloadFileFromTodoRequest(String adminClientUser, String adminClientAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify admin client can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        adminClientUser = GenericService.addBrowserPrefix(adminClientUser);

        try {
            marketingService.loginUsingUsernamePassword(adminClientUser, adminClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin client can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin client can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 69, enabled = true, description = "Verify lead client can download file from their assigned To-Do request.", testName = "AA_69",
            dataProvider = "verifyLeadClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientCanDownloadFileFromTodoRequest(String leadClientUser, String leadClientAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify lead client can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        leadClientUser = GenericService.addBrowserPrefix(leadClientUser);

        try {
            marketingService.loginUsingUsernamePassword(leadClientUser, leadClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify lead client can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify lead client can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 70, enabled = true, description = "Verify client can download file from their assigned To-Do request.", testName = "AA_70",
            dataProvider = "verifyClientCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyClientCanDownloadFileFromTodoRequest(String clientUser, String clientAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify client can download file from their assigned To-Do request.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        clientUser = GenericService.addBrowserPrefix(clientUser);

        try {
            marketingService.loginUsingUsernamePassword(clientUser, clientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromRequest(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify client can download file from their assigned To-Do request.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify client can download file from their assigned To-Do request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 71, enabled = true, description = "Verify admin auditor can download file from their assigned To-Do comment.",
            testName = "AA_71", dataProvider = "verifyAdminAuditorCanDownloadFileFromTodoComment",
            dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanDownloadFileFromTodoComment(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify admin auditor can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 72, enabled = true, description = "Verify lead auditor can download file from their assigned To-Do comment.", testName = "AA_72",
            dataProvider = "verifyLeadAuditorCanDownloadFileFromTodoComment", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanDownloadFileFromTodoComment(String leadAuditorUser, String leadAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify lead auditor can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        leadAuditorUser = GenericService.addBrowserPrefix(leadAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(leadAuditorUser, leadAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify lead auditor can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify lead auditor can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 73, enabled = true, description = "Verify auditor can download file from their assigned To-Do comment.", testName = "AA_73",
            dataProvider = "verifyAuditorCanDownloadFileFromTodoComment", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAuditorCanDownloadFileFromTodoComment(String auditorUser, String auditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify auditor can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        auditorUser = GenericService.addBrowserPrefix(auditorUser);

        try {
            marketingService.loginUsingUsernamePassword(auditorUser, auditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify auditor can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify auditor can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 74, enabled = true, description = "Verify admin client can download file from their assigned To-Do comment.", testName = "AA_74",
            dataProvider = "verifyAdminClientCanDownloadFileFromTodoComment", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminClientCanDownloadFileFromTodoComment(String adminClientUser, String adminClientAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify admin client can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        adminClientUser = GenericService.addBrowserPrefix(adminClientUser);

        try {
            marketingService.loginUsingUsernamePassword(adminClientUser, adminClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin client can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin client can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 75, enabled = true, description = "Verify lead client can download file from their assigned To-Do comment.", testName = "AA_75",
            dataProvider = "verifyLeadClientCanDownloadFileFromTodoComment", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadClientCanDownloadFileFromTodoComment(String leadClientUser, String leadClientAuvenirPwd, String engagementName2,
            String todo1, String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify lead client can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        leadClientUser = GenericService.addBrowserPrefix(leadClientUser);

        try {
            marketingService.loginUsingUsernamePassword(leadClientUser, leadClientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify lead client can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify lead client can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 76, enabled = true, description = "Verify client can download file from their assigned To-Do comment.", testName = "AA_76",
            dataProvider = "getVerifyClientCanDownloadFileFromTodoComment", dataProviderClass = GroupPermissionsDataProvider.class)
    public void getVerifyClientCanDownloadFileFromTodoComment(String clientUser, String clientAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String[] listFile) {
        getLogger().info("Verify client can download file from their assigned To-Do comment.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());

        String pathOfDownloadLocation = GenericService.sDirPath + GenericService.downloadRelativePath;
        String pathOfUploadLocation = GenericService.sDirPath + GenericService.uploadRelativePath;

        clientUser = GenericService.addBrowserPrefix(clientUser);

        try {
            marketingService.loginUsingUsernamePassword(clientUser, clientAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo1);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo4);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo6);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            auditorTodoService.openTodoDetailsByTodoNameEditable(todo9);
            auditorCreateToDoService.downloadFilesFromComment(pathOfDownloadLocation, Arrays.asList(listFile));
            auditorCreateToDoService.verifyDownloadFilesSuccessful(pathOfUploadLocation, pathOfDownloadLocation, Arrays.asList(listFile));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify client can download file from their assigned To-Do comment.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify client can download file from their assigned To-Do comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 77, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement", alwaysRun = true,
            dataProvider = "verifyAdminAuditorCanSeeAllFiles", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorDownloadOnFileTab(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2, String todo1,
            String todo4, String todo6, String todo9, String listFile[]) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorTodoService = new AuditorToDoService(getLogger(), getDriver());
        auditorFileService = new AuditorFileService(getLogger(), getDriver());

        //        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);
        adminAuditorUser = "thuan.lead.auditor@mailinator.com";
        adminAuditorAuvenirPwd = "Changeit@123";
                engagementName2 = "Engagement02";
        //        String toDo2 = "todo2";
        //        String toDo4 = "todo4";
        //        String toDo5 = "todo6";
        //        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            auditorFileService.navigateToFilesTab();
            auditorFileService.verifyUserDownloadFileInFileTab(listFile[1], "Lead Auditor", todo1);

            //            auditorTodoService.openTodoDetailsByTodoNameUneditable(todo1);
            //            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            //            auditorTodoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.toString());
            throw e;
        }
    }
}
