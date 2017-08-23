package com.auvenir.ui.tests.auditor.general;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.util.Date;


/**
 * Created by duong.nguyen on 5/24/2017.
 * Refactored by Minh Nguyen on June 26, 2017
 */
public class AuditorTest extends AbstractTest{
    AuditorService auditorService;
    AuditorEngagementService auditorEngagementService;
    AbstractService abstractService;

    String testCaseId = null;
    String sData[] = null;
    DateFormat dateFormat = null;
    Date date = null;
    static String CurrentDate = null;
    private MarketingService marketingService;
    String auditorId,auditorIdLogin , auditorPwd;

    @Test(priority = 1, enabled = true, description = "To Verify the display of Elements in Auditor Login Page")
    public void verifyAuditorLoginPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            auditorService.goToBaseURL();
            auditorService.verifyBodyHomePage();
            auditorService.verifyFooterHomePage();
            auditorService.verifyEmailLoginForm();
            auditorService.verifyLoginWithEmail(auditorId);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify Auditor Login page");
            NXGReports.addStep("Verify Auditor Login page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify Auditor Login page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor Login page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To verify the header of Auditor Engagement Page")
    public void verifyHeaderAuditorEngagementPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorService.verifyheaderPage();
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorService.verifyFooterPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "To verify the header of Auditor Engagement Page");
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("To verify the header of Auditor Engagement Page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "To Verify the display of Elements in Auditor Engagement Dashboard Page")
    public void verifyAuditorEngagementDashboardPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.createOrViewDetailsEngagement("engagement 01");
            auditorService.verifyDisplayElementInAuditorDashBoardPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify Auditor Engagement Dashboard page");
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor Engagement Dashboard page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the display of Elements in Engagement File, Activity, Team Page")
    public void verifyEngagementFilesActivityTeamPage() throws Exception {
        auditorService = new AuditorService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        abstractService = new AbstractService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.createOrViewDetailsEngagement("engagement 01");
            auditorService.clickFilesLink();
            auditorService.verifyDisplayElementInEngagementFilesPage();
            auditorService.clickActivityLink();
            auditorService.verifyDisplayElementInEngagementActivityPage();
            auditorService.clickTeamLink();
            auditorService.verifyDisplayElementInEngagementTeamPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify Engagement Files, Activity, Team page");
            NXGReports.addStep("Verify Engagement Files, Activity, Team page", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Verify Engagement Files, Activity, Team page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception e) {
            NXGReports.addStep("Verify Engagement Files, Activity, Team page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }
}
