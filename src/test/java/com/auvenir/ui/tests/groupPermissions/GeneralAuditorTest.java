package com.auvenir.ui.tests.groupPermissions;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.groupPermissions.GeneralAuditorService;
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
public class GeneralAuditorTest extends AbstractTest {
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private GeneralAuditorService generalAuditorService;
    private AuditorToDoService auditorToDoService;

    @Test(priority = 22, enabled = true, description = "To Verify auditor can change request name assigned to it.")
    public void verifyGeneralAuditorCanChangeRequestNameBeAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());

        String generalAuditor = "chr.vienpham.auditor@gmail.com";
        String generalAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldRequestName = "request2";
        String newRequestName = "request2 modify";
        try {
            marketingService.loginUsingUsernamePassword(generalAuditor, generalAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(todoName);
            generalAuditorService.verifyGeneralAuditorCanChangeRequestNameBeAssigned(oldRequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general auditor can change request name assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general auditor can change request name assigned: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23, enabled = true, description = "To Verify general Auditor can delete request be assigned")
    public void verifyLeadAuditorCanDeleteRequestBeAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());

        String generalAuditorId = "chr.vienpham.auditor@gmail.com";
        String generalAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "request1";
        try {
            marketingService.loginUsingUsernamePassword(generalAuditorId, generalAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(todoName);
            generalAuditorService.verifyGeneralAuditorCanDeleteRequestBeAssigned(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Auditor can delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Auditor can delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 24, enabled = true, description = "To Verify general Auditor can change Duedate")
    public void verifyGeneralAuditorCanChangeDueDate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        String generalAuditorId = "chr.vienpham.auditor@gmail.com";
        String generalAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String month = "8";
        String day = "30";
        String year = "2017";
        try {
            marketingService.loginUsingUsernamePassword(generalAuditorId, generalAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            generalAuditorService.verifyGeneralAuditorCanChangeDueDateBeAssigned(todoName, month, day, year);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Auditor can delete request be assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Auditor can delete request be assigned: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25, enabled = true, description = "To Verify general Auditor can edit Category be assigned")
    public void verifyGeneralAuditorCanEditCategoryBeAssigned() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());

        String generalAuditorId = "chr.vienpham.auditor@gmail.com";
        String generalAuditorPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldCategoryName = "catego4";
        String newCategoryName = "catego7";
        try {
            marketingService.loginUsingUsernamePassword(generalAuditorId, generalAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            generalAuditorService.verifyGeneralAuditorCanEditCategoryBeAssigned(todoName, oldCategoryName, newCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Auditor can edit Category be assigned: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Auditor can edit Category be assigned: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 18, enabled = true, description = "To Verify auditor can change request name assigned to it.", testName = "au_18")
    public void verifyGeneralAuditorCanAssignToAuditor() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        String todoName = "todo1";
        String adminUser = "duong.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement AUV353";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            generalAuditorService.verifyGeneralAuditorCanNotAssignTodoToAuditor(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "To Verify general auditor cannot assigned todo to general client.", testName = "au_20")
    public void verifyGeneralAuditorCannotAssignToGeneralClient() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        String adminUser = "chr.vienpham.auditor@gmail.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String generalClient = "General Client";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            generalAuditorService.verifyGeneralAuditorCannotAssignToDoToGeneralClient(Arrays.asList(todoName), generalClient);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can mark todo completed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 21, enabled = true, description = "To Verify general auditor cannot comment on todo they are not assign to.", testName = "au_21")
    public void verifyGeneralAuditorCannotCommentOnTodoNotAssignTo() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        generalAuditorService = new GeneralAuditorService(getLogger(), getDriver());
        String adminUser = "duong.auditor@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement AUV353";
        String todoName = "lead vien1";
        String comment = "Commenting";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            generalAuditorService.verifyGeneralAuditorCannotCommentOnTodoNotAssignedTo(todoName, comment);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify General Auditor cannot comment on todo they are no assign to.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify General Auditor cannot comment on todo they are no assign to: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
