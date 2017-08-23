package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.auditor.todo.AuditorFileDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 7/20/2017.
 */
public class AuditorFilesTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService ;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private MarketingService marketingService;
    private AuditorCreateToDoService auditorCreateToDoService;
    /**
     * (case)verify Undo action Download Attachments disable
     */
    @Test(priority = 33, enabled = true, testName = "Undo failed", description = "verify Undo action Download Attachments disable", groups =
            "workflow", dataProvider = "verifyDownloadAttachmentsDisable", dataProviderClass = AuditorFileDataProvider.class)
    public void verifyDownloadAttachmentsDisable(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName, String toDoName01) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.verifyToDoDownloadAttachmentsDisable(toDoName01);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Download Attachments disable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


}
