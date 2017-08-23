package com.auvenir.ui.tests.auditor.general;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorAccountSettingsService;
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
 * Edited by Doai.Tran - PLAT 2273
 * Refactored by Minh Nguyen on June 26, 2017
 */

public class AuditorSettingsTest extends AbstractTest {
    private AuditorAccountSettingsService auditorAccountSettingsService;
    private AuditorEngagementService auditorEngagementService;
    private MarketingService marketingService;
    String auditorId, auditorPwd;


    @Test(priority = 1, enabled = true, description = "Verify Footer in Auditor Account Settings page.")
    public void verifyFooterAuditorAccountSettingsPage() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyAccountSettingsPage();
            auditorAccountSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Footer in Auditor Account Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Footer in Auditor Account Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify GUI auditor setting page.")
    public void verifyUIAuditorSetting() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            auditorAccountSettingsService.verifyBody();
            auditorAccountSettingsService.verifyFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI auditor setting page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Verify All UI Audit Settings page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Test First and Last name on Auditor Setting Page.")
    public void InputValueFullName() throws Exception {
        auditorAccountSettingsService = new AuditorAccountSettingsService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToSettingsPage();
            getLogger().info("Input any value on FullName TextBox.");
            auditorAccountSettingsService.inputFullName("Doai Test");
            auditorAccountSettingsService.sendTabkeyFullNametxt();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: Passed", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Test First and Last name on Auditor Setting Page: PASSED", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}


