package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.settings.AuditorNotificationsSettingsPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorNotificationsSettingsService extends AbstractService {

    AuditorNotificationsSettingsPage auditorNotificationsSettingsPage;

    /*
     * contructor
     */
    public AuditorNotificationsSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorNotificationsSettingsPage = new AuditorNotificationsSettingsPage(getLogger(), getDriver());

    }


    public void verifyFooter() {

        try {
            auditorNotificationsSettingsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorNotificationsSettingsPage.verifyFooterOfHomepage();
            getLogger().info("verfify term of service link.");
            auditorNotificationsSettingsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorNotificationsSettingsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorNotificationsSettingsPage.verifyCookieNotice();
            //auditorNotificationsSettingsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyAuditorNotificationSettingsPage() {
        auditorNotificationsSettingsPage.verifyAuditorNotificationSettingsPage();
    }

    public void verifyNotificationItemListNotificationSettingsPage(){
        auditorNotificationsSettingsPage.verifyNotificationItemListNotificationSettingsPage();
    }

    public void verifyNotificationCheckBoxSliderRoundWorking(){
        auditorNotificationsSettingsPage.scrollPageDown();
        auditorNotificationsSettingsPage.verifyNotificationCheckBoxSliderRoundWorking();
    }

}

