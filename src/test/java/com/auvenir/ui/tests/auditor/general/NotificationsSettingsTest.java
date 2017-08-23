package com.auvenir.ui.tests.auditor.general;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorAccountSettingsService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNotificationsSettingsService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class NotificationsSettingsTest extends AbstractTest {
    private AuditorNotificationsSettingsService auditorNotificationsSettingsService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorAccountSettingsService auditorAccountSettingsService;
    private MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "Verify GUI in auditor notifications settings page.")
    public void verifyGUIAuditorNotificationsSettingsPage() throws Exception {
        auditorNotificationsSettingsService = new AuditorNotificationsSettingsService(getLogger(), getDriver());
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
         /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify engagement list page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Go to setting page
            auditorEngagementService.navigateToSettingsPage();
            // Verify account setting page
            auditorAccountSettingsService.verifyAccountSettingsPage();
            // Go to notification setting page
            auditorAccountSettingsService.navigateToNotificationsPage();
            // Verify notification setting page
            auditorNotificationsSettingsService.verifyAuditorNotificationSettingsPage();
            //auditorNotificationsSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify GUI in auditor notifications settings page");
            NXGReports.addStep("Verify GUI in auditor notifications settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI in auditor notifications settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify notification item list in auditor notifications settings page.")
    public void verifyNotificationItemList() throws Exception {
        auditorNotificationsSettingsService = new AuditorNotificationsSettingsService(getLogger(), getDriver());
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
         /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify engagement list page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Go to setting page
            auditorEngagementService.navigateToSettingsPage();
            // Verify account setting page
            auditorAccountSettingsService.verifyAccountSettingsPage();
            // Go to notification setting page
            auditorAccountSettingsService.navigateToNotificationsPage();
            // Verify notification item list
            auditorNotificationsSettingsService.verifyNotificationItemListNotificationSettingsPage();
            //auditorNotificationsSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify notification item list in auditor notifications settings page");
            NXGReports.addStep("Verify notification item list in auditor notifications settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify notification item list in auditor notifications settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify notification check box slider round list in auditor notifications settings page.")
    public void verifyNotificationCheckBoxSliderRoundList() throws Exception {
        auditorNotificationsSettingsService = new AuditorNotificationsSettingsService(getLogger(), getDriver());
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
         /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify engagement list page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Go to setting page
            auditorEngagementService.navigateToSettingsPage();
            // Verify account setting page
            auditorAccountSettingsService.verifyAccountSettingsPage();
            // Go to notification setting page
            auditorAccountSettingsService.navigateToNotificationsPage();
            // Verify notification item list
            auditorNotificationsSettingsService.verifyNotificationCheckBoxSliderRoundWorking();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify notification check box slider round list in auditor notifications settings page");
            NXGReports.addStep("Verify notification check box slider round list in auditor notifications settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify notification check box slider round list in auditor notifications settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}


