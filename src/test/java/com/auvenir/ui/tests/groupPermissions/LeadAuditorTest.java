package com.auvenir.ui.tests.groupPermissions;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.groupPermissions.LeadAuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by duong.nguyen on 7/17/2017.
 */
public class LeadAuditorTest extends AbstractTest {
    private LeadAuditorService leadAuditorService;
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorToDoService auditorToDoService;

    @Test(priority = 22, enabled = true, description = "To Verify lead auditor can change request name.",
            dataProvider = "verifyLeadAuditorCanChangeRequestName", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanChangeRequestName(String leadAuditorId, String leadAuditorPwd, String engagementName, String todoName,
            String requequestName, String newRequestName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        leadAuditorId = GenericService.addBrowserPrefix(leadAuditorPwd);
       /* String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement Duong";
        String todoName = "lead vien1";
        String oldRequestName = "request1";
        String newRequestName = "request1 modify";*/
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(todoName);
            leadAuditorService.verifyLeadAuditorCanChangeRequestName(requequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead auditor change request name: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead auditor change request name: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23, enabled = true, description = "To Verify lead Auditor can delete request",
            dataProvider = "verifyLeadAuditorCanDeleteRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanDeleteRequest(String leadAuditorId, String leadAuditorPwd, String engagementName, String todoName,
            String requestName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        leadAuditorId = GenericService.addBrowserPrefix(leadAuditorPwd);
        /*String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "request2";*/
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(todoName);
            leadAuditorService.verifyLeadAuditorCanDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 24, enabled = true, description = "To Verify lead Auditor can change Duedate",
            dataProvider = "verifyLeadAuditorCanChangeDueDate", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanChangeDueDate(String leadAuditorId, String leadAuditorPwd, String engagementName, String todoName,
            String month, String day, String year) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        leadAuditorId = GenericService.addBrowserPrefix(leadAuditorPwd);
        /*String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String month = "8";
        String day = "24";
        String year = "2017";*/
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            leadAuditorService.verifyLeadAuditorCanChangeDueDate(todoName, month, day, year);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 25, enabled = true, description = "To Verify lead Auditor can edit Category",
            dataProvider = "verifyLeadAuditorCanEditCategory", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyLeadAuditorCanEditCategory(String leadAuditorId, String leadAuditorPwd, String engagementName, String todoName,
            String oldCategoryName, String newCategoryName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        leadAuditorId = GenericService.addBrowserPrefix(leadAuditorPwd);
        /*String leadAuditorId = "chr.vienpham.lead.auditor@gmail.com";
        String leadAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldCategoryName = "catego4";
        String newCategoryName = "catego1";*/
        try {
            marketingService.loginUsingUsernamePassword(leadAuditorId, leadAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            leadAuditorService.verifyLeadAuditorCanEditCategory(todoName, oldCategoryName, newCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Lead Auditor can edit Category: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Lead Auditor can edit Category: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Admin Auditor cannot assign todo to general client.", testName = "LA-19")
    public void verifyLeadAuditorCannotAssignToGeneralClient() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String[] todoName = {"Todo 1"};
        String generalClient = "General Client";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCannotAssignToGeneralClient(Arrays.asList(todoName), generalClient);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can mark todo completed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify Admin Auditor can comment on todo they are no assign to.", testName = "LA-19")
    public void verifyLeadAuditorCanCommentingWithOutAssign() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        leadAuditorService = new LeadAuditorService(getLogger(), getDriver());
        String adminUser = "duong.lead.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String todoName = "Todo 1";
        String comment = "Comment 12345";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

            leadAuditorService.verifyLeadAuditorCanCommentOnTodoWithOutAssign(todoName, comment);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can comment on todo they are no assign to.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can comment on todo they are no assign to: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
