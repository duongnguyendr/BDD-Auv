package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.pages.client.engagement.ClientDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientTodoService;
import com.auvenir.ui.services.groupPermissions.LeadClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class LeadClientTest extends AbstractTest {
    private MarketingService marketingService;
    private ClientEngagementService clientEngagementService;
    private ClientDetailsEngagementPage clientDetailsEngagementService;
    private LeadClientService leadClientService;
    private AuditorToDoService auditorToDoService;
    private ClientTodoService clientTodoService;

    @Test(priority = 22, enabled = true, description = "To Verify Lead Client can not change request name .")
    public void verifyLeadClientCanNotChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(),getDriver());

        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requequestName = "request1";
        String newRequestName = "request1 modify";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientTodoService.openTodoDetailsByTodoNameUneditable(todoName);
            leadClientService.verifyLeadClientCanNotChangeRequestName(requequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can not change request Name : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client can not change request Name : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23, enabled = true, description = "To Verify Lead client can not delete request")
    public void verifyLeadClientCanNotDeleteRequest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(),getDriver());

        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "request2";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientTodoService.openTodoDetailsByTodoNameUneditable(todoName);
            leadClientService.verifyLeadClientCanNotDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can not delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can not delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 24, enabled = true, description = "To Verify lead client can not change Duedate.")
    public void verifyLeadClientCanNotChangeDuedate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String month = "8";
        String day = "15";
        String year = "2017";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            leadClientService.verifyLeadClientCanNotChangeDueDate(todoName, month, day, year);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify lead client can not change duedate : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify lead client can not change duedate : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25, enabled = true, description = "To Verify lead Client can not edit Category")
    public void verifyLeadClientCanNotEditCategory() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldCategoryName = "catego3";
        String newCategoryName = "catego4";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            leadClientService.verifyLeadClientCanNotEditCategory(todoName, oldCategoryName, newCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Client can not edit any Category: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Client can not edit any Category: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify Lead client cannot create todo.", testName = "LC-13")
    public void verifyLeadClientCanNotCreateTodo() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        String adminUser = "duong.client.lead@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr01";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadClientService.verifyLeadClientCannotCreateTodo();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Lead client cannot assign a todo to an auditor.", testName = "LC-18")
    public void verifyLeadClientCannotAssignTodoToAuditor() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName2 = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadClientService.verifyLeadClientCannotAssignToDoToAuditor(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client cannot assign a todo to an auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client cannot assign a todo to an auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "Verify Lead client can comment on todo they are not assign to.", testName = "LC-21")
    public void verifyLeadClientCanCommentOnTodoNotAssignTo() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        leadClientService = new LeadClientService(getLogger(), getDriver());
        String leadClientId = "chr.vienpham.lead.client@gmail.com";
        String leadClientPwd = "Changeit@123";
        String engagementName2 = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String comment = "Comment12345";
        try {
            marketingService.loginUsingUsernamePassword(leadClientId, leadClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName2);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadClientService.verifyLeadClientCanCommentOnTodoNotAssignTo(todoName, comment);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead client can comment on todo they are not assign to.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead client can comment on todo they are not assign to: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
