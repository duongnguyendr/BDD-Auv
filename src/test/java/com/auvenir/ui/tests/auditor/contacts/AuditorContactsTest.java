package com.auvenir.ui.tests.auditor.contacts;

import com.auvenir.ui.dataprovider.auditor.AuditorContactDataProvider;
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
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorContactsTest extends AbstractTest {
    private AuditorContactService auditorContactService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "Verify GUI auditor contacts page.", dataProvider = "verifyGUIAuditorContactsPage", dataProviderClass = AuditorContactDataProvider.class)
    public void verifyGUIAuditorContactsPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorContactService = new AuditorContactService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorContactService = new AuditorContactService(getLogger(),getDriver());

        auditorId = GenericService.sBrowserData + auditorId;
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        /*String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Test Engagement Contacts 99999";*/
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on contact link
            auditorDetailsEngagementService.clickOnContactLink();
            // Verify contact page
            auditorContactService.verifyAuditorContactPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify GUI auditor contact page");
            NXGReports.addStep("Verify GUI auditor contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI auditor contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify engagement link in auditor contacts page.", dataProvider = "verifyEngagementLinkInAuditorContactsPage", dataProviderClass = AuditorContactDataProvider.class)
    public void verifyEngagementLinkInAuditorContactsPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorContactService = new AuditorContactService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorContactService = new AuditorContactService(getLogger(),getDriver());

        auditorId = GenericService.sBrowserData + auditorId;
        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        /*String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Test Engagement Contacts 99999";*/

        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on contact link
            auditorDetailsEngagementService.clickOnContactLink();
            // Verify contact page
            auditorContactService.verifyAuditorContactPage();
            // Click on engagement link
            auditorContactService.clickOnEngagementLink();
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify engagement work in auditor contacts page");
            NXGReports.addStep("Verify engagement link in auditor contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify engagement link in auditor contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }


    @Test(priority = 3, enabled = true, description = "Verify GUI data table auditor contacts page.", dataProvider = "verifyGUIDataTableAuditorContactsPage", dataProviderClass = AuditorContactDataProvider.class)
    public void verifyGUIDataTableAuditorContactsPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorContactService = new AuditorContactService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorContactService = new AuditorContactService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        /*String auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");*/

        /*String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Test Engagement Contacts 99999";*/
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Click on contact link
            auditorDetailsEngagementService.clickOnContactLink();
            // Verify contact page
            auditorContactService.verifyGUIDataTableContactPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify GUI data table auditor contacts pagee");
            NXGReports.addStep("Verify GUI data table auditor contacts page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI data table auditor contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "Verify Footer in Auditor Contacts page.", dataProvider = "verifyFooterAuditorContactsPage", dataProviderClass = AuditorContactDataProvider.class)
    public void verifyFooterAuditorContactsPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorContactService = new AuditorContactService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorContactService = new AuditorContactService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        /*String auditorId = "chr.auvenirauditor@gmail.com";
        String auditorPwd = "Changeit@123";
        String engagementName = "Test Engagement Contacts 99999";
*/
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify GUI engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Verify GUI engagement detail page
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            // Move to contact page
            auditorDetailsEngagementService.clickOnContactLink();
            // Verify footer auditor contact page
            auditorContactService.verifyAuditorFooter();
            NXGReports.addStep("Verify Footer in Auditor Contacts page: PASSED", LogAs.PASSED, null);
            // logCurrentStepEnd();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify footer in Auditor Contacts page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}



