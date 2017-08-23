package com.auvenir.ui.tests.auditor.engagement;

import com.auvenir.ui.dataprovider.auditor.AuditorEngagementDataProvider;
import com.auvenir.ui.services.*;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorNewEngagementService;
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

public class EngagementTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "Verify footer in auditor engagements page.", dataProvider = "verifyFooterAuditorEngagementPage", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifyFooterAuditorEngagementPage(String auditorId,String auditorPwd) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify footer auditor engagement
            auditorEngagementService.verifyAuditorFooter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify footer in auditor engagements page");
            NXGReports.addStep("Verify footer in auditor engagements page.", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Verify footer in auditor engagements page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * verify UI of New Engagement flow
     */
    @Test(priority = 2, enabled = true, description = "Verify GUI of new engagement page.", dataProvider = "verifyUINewEngagement", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifyUINewEngagement(String auditorId,String auditorPwd, String engagementName) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Click on new engagement button
            auditorEngagementService.navigateToNewEngagementPage();
            // Verify new engagement setup page
            auditorNewEngagementService.verifyUINewEngagementSetUp(engagementName);
            // Verify new engagement team page
            auditorNewEngagementService.verifyUINewEngagementTeam(engagementName);
            // Verify new engagement customize page
            auditorNewEngagementService.verifyUINewEngagementCustomize(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify GUI of new engagement page");
            NXGReports.addStep("Verify GUI of new engagement page.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify GUI of new engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page
     */
    @Test(priority = 3, enabled = true, description = "Verify GUI of list engagement page.", dataProvider = "verifyGUIListEngagement", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifyGUIListEngagement(String auditorId, String auditorPwd) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Verify GUI list auditor engagement page
            auditorEngagementService.verifyUIListEngagement();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify GUI of list engagement page");
            NXGReports.addStep("Verify GUI of list engagement page.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify GUI of list engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }


    @Test(priority = 4, enabled = true, description = "Verify search data list by name.",dataProvider = "verifySearchDataListByName", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifySearchDataListByName(String auditorId, String auditorPwd, String engagementName) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Input name search value
            auditorEngagementService.searchEngagementListByName(engagementName);
            // Verify search data list
            auditorEngagementService.verifyDataSearchByEngagementName(engagementName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify data list search by name");
            NXGReports.addStep("Verify search data list by name.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify search data list by name.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify search data list by company.",dataProvider = "verifySearchDataListByCompany", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifySearchDataListByCompany(String auditorId, String auditorPwd, String companyName) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Input name search value
            auditorEngagementService.searchEngagementListByCompany(companyName);
            // Verify search data list
            auditorEngagementService.verifyDataSearchByEngagementCompany(companyName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify data list search by company");
            NXGReports.addStep("Verify search data list by company.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify search data list by company.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify search data list by filter select.",dataProvider = "verifySearchDataListByFilterSelectBox", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifySearchDataListByFilterSelectBox(String auditorId, String auditorPwd) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(),getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Click on filter select box
            auditorEngagementService.clickOnEngagementFilter();
            // Click on filter all check box
            auditorEngagementService.clickOnEngagementFilterAll();
            // Verify data

            // Click on filter select box
            auditorEngagementService.clickOnEngagementFilter();
            // Click on type of engagement
            auditorEngagementService.clickOnTypeOfEngagement();
            // Click on engagement audit finical
            auditorEngagementService.clickOnEngagementFinancialAudit();
            // Verify data

            // Click on filter select box
            auditorEngagementService.clickOnEngagementFilter();
            // Click on type of engagement
            auditorEngagementService.clickOnTypeOfEngagement();
            // Click on engagement audit finical
            auditorEngagementService.clickOnEngagementReview();
            // Verify data

            // Click on filter select box
            auditorEngagementService.clickOnEngagementFilter();
            // Click on type of engagement
            auditorEngagementService.clickOnTypeOfEngagement();
            // Click on engagement audit finical
            auditorEngagementService.clickOnEngagementNotice();
            // Verify data

            // Click on filter select box
            auditorEngagementService.clickOnEngagementFilter();
            // Click on type of engagement
            auditorEngagementService.clickOnTypeOfEngagement();
            // Click on engagement audit finical
            auditorEngagementService.clickOnEngagementOther();
            // Verify data


            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify search data list by filter select");
            NXGReports.addStep("Verify search data list by filter select.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify search data list by filter select.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify data sort by click on column name.",dataProvider = "verifyDataSortByClickOnColumnName", dataProviderClass = AuditorEngagementDataProvider.class)
    public void verifyDataSortByClickOnColumnName(String auditorId, String auditorPwd) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            //Go to marketing page
            marketingService.goToBaseURL();
            // Click on button login
            marketingService.openLoginDialog();
            // Login with user name and password
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            // Verify auditor engagement page
            auditorEngagementService.verifyAuditorEngagementPage();

            // Click on company icon sort down
            auditorEngagementService.clickOnCompanyIconSortDown();
            // Verify ascending company data list
            auditorEngagementService.verifyCompanyDataListSortAscending();
            // Click on company icon sort up
            auditorEngagementService.clickOnCompanyIconSortUp();
            // Verify ascending company data list
            auditorEngagementService.verifyCompanyDataListSortDescending();

            // Click on name icon sort down
            auditorEngagementService.clickOnEngagementNameIconSortDown();
            // Verify ascending name data list
            auditorEngagementService.verifyEngagementNameDataListSortAscending();
            // Click on name icon sort up
            auditorEngagementService.clickOnEngagementNameIconSortUp();
            // Verify ascending name data list
            auditorEngagementService.verifyEngagementNameDataListSortDescending();


            // Click on status icon sort down
            auditorEngagementService.clickOnEngagementStatusIconSortDown();
            // Verify ascending status data list
            auditorEngagementService.verifyEngagementStatusDataListSortAscending();
            // Click on status icon sort down
            auditorEngagementService.clickOnEngagementStatusIconSortUp();
            // Verify ascending status data list
            auditorEngagementService.verifyEngagementStatusDataListSortDescending();

            // Click on audit icon sort down
            auditorEngagementService.clickOnEngagementAuditIconSortDown();
            // Verify ascending audit data list
            auditorEngagementService.verifyEngagementAuditDataListSortAscending();
            // Click on audit icon sort down
            auditorEngagementService.clickOnEngagementAuditIconSortUp();
            // Verify ascending audit data list
            auditorEngagementService.verifyEngagementAuditDataListSortDescending();

            // Click on todo icon sort down
            auditorEngagementService.clickOnEngagementToDoIconSortDown();
            // Verify ascending todo data list
            auditorEngagementService.verifyEngagementToDoDataListSortAscending();
            // Click on todo icon sort down
            auditorEngagementService.clickOnEngagementToDoIconSortUp();
            // Verify ascending todo data list
            auditorEngagementService.verifyEngagementToDoDataListSortDescending();

            // Click on client icon sort down
            auditorEngagementService.clickOnEngagementClientIconSortDown();
            // Verify ascending client data list
            auditorEngagementService.verifyEngagementClientDataListSortAscending();
            // Click on client icon sort down
            auditorEngagementService.clickOnEngagementClientIconSortUp();
            // Verify ascending client data list
            auditorEngagementService.verifyEngagementClientDataListSortDescending();


            // Click on doc icon sort down
            auditorEngagementService.clickOnEngagementDocIconSortDown();
            // Verify ascending doc data list
            auditorEngagementService.verifyEngagementDocDataListSortAscending();
            // Click on doc icon sort down
            auditorEngagementService.clickOnEngagementDocIconSortUp();
            // Verify ascending doc data list
            auditorEngagementService.verifyEngagementDocDataListSortDescending();


            // Click on activity icon sort down
            auditorEngagementService.clickOnEngagementActivityIconSortDown();
            // Verify ascending activity data list
            auditorEngagementService.verifyEngagementActivityDataListSortAscending();
            // Click on activity icon sort down
            auditorEngagementService.clickOnEngagementActivityIconSortUp();
            // Verify ascending activity data list
            auditorEngagementService.verifyEngagementActivityDataListSortDescending();

            // Click on activity icon sort down
            auditorEngagementService.clickOnEngagementDueDateIconSortDown();
            // Verify ascending activity data list
            auditorEngagementService.verifyEngagementDueDateDataListSortAscending();
            // Click on activity icon sort down
            auditorEngagementService.clickOnEngagementDueDateIconSortUp();
            // Verify ascending activity data list
            auditorEngagementService.verifyEngagementDueDateDataListSortDescending();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify data sort by click on column name");
            NXGReports.addStep("Verify data sort by click on column name.", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify data sort by click on column name.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
}



