package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.settings.AuditorDevicesSettingsPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorDevicesSettingsService extends AbstractService {

    AuditorDevicesSettingsPage auditorDevicesSettingsPage;

    /*
     * contructor
     */
    public AuditorDevicesSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorDevicesSettingsPage = new AuditorDevicesSettingsPage(getLogger(), getDriver());

    }


    public void verifyFooter() {

        try {
            auditorDevicesSettingsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorDevicesSettingsPage.verifyFooterOfHomepage();
            getLogger().info("verfify term of service link.");
            auditorDevicesSettingsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorDevicesSettingsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorDevicesSettingsPage.verifyCookieNotice();
            auditorDevicesSettingsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAuditorDevicesSettingsPage() {

        try {
            getLogger().info("verify Auditor Devices Settings page.");
            auditorDevicesSettingsPage.verifyAuditorDevicesSettingsPage();
            NXGReports.addStep("verify Devices Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Auditor Devices Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


}

