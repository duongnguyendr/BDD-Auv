package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorNewEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by hai.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementService extends AbstractService {

    AuditorNewEngagementPage auditorNewEngagementPage;

    /*
     * contructor 
     */
    public AuditorNewEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorNewEngagementPage = new AuditorNewEngagementPage(getLogger(), getDriver());

    }


    public void verifyNewEngagementPage() {
        try {
            getLogger().info("verify create new Engagement form page.(Implemented later)");
            auditorNewEngagementPage.verifyNewEngagementPage();
            NXGReports.addStep("verify create new Engagement form page.(Implemented later)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify create new Engagement form page.(Implemented later)", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void enterDataForNewEngagementPage(String name, String engagementType, String company) {
        auditorNewEngagementPage.enterDataForNewEngagementPage(name, engagementType, company);
    }

    public void verifyUINewEngagementSetUp(String name) {
        auditorNewEngagementPage.verifyUINewEngagementHeaderSetUp();
        //auditorNewEngagementPage.verifyUINewEngagementBodySetUp(name);
        auditorNewEngagementPage.insertDataForNewEngagementPage(name,"","Company Auvenir");
        auditorNewEngagementPage.verifyUINewEngagementFooterSetup();
    }

    public void verifyUINewEngagementTeam(String name) {
        auditorNewEngagementPage.verifyUINewEngagementHeaderTeam(name);
        auditorNewEngagementPage.verifyUINewEngagementBodyTeam();
    }

    public void verifyUINewEngagementCustomize(String name) {
        auditorNewEngagementPage.verifyUINewEngagementHeaderCustomize(name);
        auditorNewEngagementPage.verifyUINewEngagementBodyCustomize();
    }
}

