package com.auvenir.ui.tests.client.general;

import com.auvenir.ui.dataprovider.client.ClientDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.client.ClientDetailsEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNewEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by huy.huynh on 11/07/2017.
 */
public class ClientTest extends AbstractTest {
    private ClientService clientService;
    private AuditorEngagementService auditorEngagementService;
    private MarketingService marketingService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    private ClientSignUpService clientSignUpService;
    private ClientEngagementService clientEngagementService;

    @Test(priority = 1, enabled = true, description = "Inviting a client from Auditor", dataProvider = "verifyInvitingNewClient",
            dataProviderClass = ClientDataProvider.class)
    public void verifyInvitingNewClient(String adminId, String adminPassword, String auditorId, String auditorPassword, String clientId,
            String clientEmailPassword, String clientFullName, String invalidClientId, String engagementName) throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        adminId = GenericService.addBrowserPrefix(adminId);
        auditorId = GenericService.addBrowserPrefix(auditorId);
        clientId = GenericService.addBrowserPrefix(clientId);

        MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
        MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //MongoDBService.removeBusinessByInvitedClientEmail(MongoDBService.getCollection("businesses"), clientId);
        //need precondition for save engagement name, and delete this engagement or client on acl

        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);

            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(clientFullName, invalidClientId, "");
            clientService.verifyInviteClientFailure("Error on finding existing user");

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            marketingService.loginUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, "Onboarding");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = true, description = "To Verify the display of Elements in Email: Invitation from to complete your financial audit",
            dataProvider = "verifyInvitationEmail", dataProviderClass = ClientDataProvider.class)
    public void verifyInvitationEmail(String clientId, String clientEmailPassword, String imageLogo, String greetingTitle, String announcementTitle,
            String auvenirIntroducingTitle, String introducingBenefitTitle, String firstBenefitTitle, String secondBenefitTitle,
            String thirdBenefitTitle, String feedbackTitle, String goodbyeTitle) throws Exception {
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());

        clientId = GenericService.addBrowserPrefix(clientId);
        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateToEmailDetail();

            gmailLoginService.verifyHeaderImage(imageLogo);
            gmailLoginService.verifyGreetingTitle(greetingTitle);
            gmailLoginService.verifyAnnouncementTitle(announcementTitle);
            gmailLoginService.verifyAuvenirIntroducingTitle(auvenirIntroducingTitle);
            gmailLoginService.verifyIntroducingBenefitTitle(introducingBenefitTitle);
            gmailLoginService.verifyFirstBenefitTitle(firstBenefitTitle);
            gmailLoginService.verifySecondBenefitTitle(secondBenefitTitle);
            gmailLoginService.verifyThirdBenefitTitle(thirdBenefitTitle);
            gmailLoginService.verifyFeedbackTitle(feedbackTitle);
            gmailLoginService.verifyGoodbyeTitle(goodbyeTitle);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed",
            dataProvider = "verifyClientLogsInAndActive", dataProviderClass = ClientDataProvider.class)
    public void verifyClientLogsInAndActive(String clientId, String clientEmailPassword, String personalPhoneNumber, String parentStakeholders,
            String clientPassword, String engagementName) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        //MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");
        clientId = GenericService.addBrowserPrefix(clientId);
        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();

            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(personalPhoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStakeholders);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientPassword);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Client Home Page", dataProvider = "verifyClientHomePage",
            dataProviderClass = ClientDataProvider.class)
    public void verifyClientHomePage(String logoHeaderBluePartialLink, String headerEngagementsText, String headerContactsText,
            String dashboardUsernameText, String dashboardSettingsText, String dashboardSignOutText, String previewHeaderText,
            String engagementFiltersText, String filterAllText, String filterTypeOfEngagementText, String typeOfEngagementFinancialAuditText,
            String typeOfEngagementReviewText, String typeOfEngagementNoticeToReaderCompilationText, String typeOfEngagementOtherText,
            String engagementSearchText, String engagementColumnText, String auditFirmColumnText, String statusColumnText,
            String auditAssigneeColumnText, String completedDocsColumnText, String clientColumnText, String activityColumnText,
            String dueDateColumnText, String companyInfoText, String termsOfServiceText, String termsOfServicePartialLink,
            String privacyStatementText, String privacyStatementPartialLink, String cookieNoticeText,
            String cookieNoticePartialLink) throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());

        String clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Auvenir Password");
        try {
            marketingService.loginUsingUsernamePassword(clientId, clientPassword);

            clientEngagementService
                    .verifyUIListEngagementHeader(logoHeaderBluePartialLink, headerEngagementsText, headerContactsText, dashboardUsernameText,
                            dashboardSettingsText, dashboardSignOutText);
            clientEngagementService.verifyUIListEngagementBody(previewHeaderText, engagementFiltersText, filterAllText, filterTypeOfEngagementText,
                    typeOfEngagementFinancialAuditText, typeOfEngagementReviewText, typeOfEngagementNoticeToReaderCompilationText,
                    typeOfEngagementOtherText, engagementSearchText, engagementColumnText, auditFirmColumnText, statusColumnText,
                    auditAssigneeColumnText, completedDocsColumnText, clientColumnText, activityColumnText, dueDateColumnText);
            clientEngagementService.verifyUIListEngagementFooter(companyInfoText, termsOfServiceText, termsOfServicePartialLink, privacyStatementText,
                    privacyStatementPartialLink, cookieNoticeText, cookieNoticePartialLink);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }
}
