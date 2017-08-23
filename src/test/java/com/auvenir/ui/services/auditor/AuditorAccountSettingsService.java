package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.settings.AuditorAcountSettingsPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */

public class AuditorAccountSettingsService extends AbstractService {

    AuditorAcountSettingsPage auditorAccountSettingsPage;

    /*
     * contructor
     */
    public AuditorAccountSettingsService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorAccountSettingsPage = new AuditorAcountSettingsPage(getLogger(), getDriver());

    }

    public void verifyFooter() {
        auditorAccountSettingsPage.scrollPageDown();
        getLogger().info("verify footer page.");
        auditorAccountSettingsPage.verifyFooterOfHomepage();
        getLogger().info("verfify term of service link.");
        auditorAccountSettingsPage.verifyTermsOfServiceLink();
        getLogger().info("verify privacy state link.");
        auditorAccountSettingsPage.verifyPrivacyStateLink();
        getLogger().info("verify cookies notice link.");
        auditorAccountSettingsPage.verifyCookieNotice();
        auditorAccountSettingsPage.scrollPageUp();
    }


    public void verifyAccountSettingsPage() {

        try {
            getLogger().info("verify Auditor Engagement page.");
            auditorAccountSettingsPage.verifyAccountSettingsPage();
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify Auditor Account Settings page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToNotificationsPage() {
        try {
            getLogger().info("navigate to Notifications tab.");
            auditorAccountSettingsPage.navigateToNotificationsPage();
            NXGReports.addStep("navigate to Notifications tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Notifications tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesPage() {
        try {
            getLogger().info("navigate to Devices tab.");
            auditorAccountSettingsPage.navigateToDevicesPage();
            NXGReports.addStep("navigate to Devices tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("navigate to Devices tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyBody() {
        getLogger().info("Start verify account tab of auditor settings page.");
        auditorAccountSettingsPage.verifyElementsOnAccountTab();
        getLogger().info("Go to Notification tab of auditor settings page.");
        auditorAccountSettingsPage.navigateToNotificationTab();
        getLogger().info("Start verify Notification Tab of auditor settings page.");
        auditorAccountSettingsPage.verifyElementsOnNotificationTab();
    }

    public void inputFullName(String TextValue) {
        try {
            getLogger().info("Try to input value: " + TextValue + " on FullName TextBox.");
            auditorAccountSettingsPage.inputFullName(TextValue);
            NXGReports.addStep("Inputed value: " + TextValue + " on FullName TextBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to input value: " + TextValue + " on FullName TextBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void sendTabkeyFullNametxt() {
        try {
            auditorAccountSettingsPage.sendTabkeyFullNameTxt();
            NXGReports.addStep("Tab successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to tab on Element FullNametxt.", LogAs.FAILED, null);
        }
    }

    public void sendTabkeyPhoneNumbertxt() {
        try {
            auditorAccountSettingsPage.sendTabkeyPhoneNumberTxt();
            NXGReports.addStep("Tab successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to tab on Element PhoneNumbertx.", LogAs.FAILED, null);
        }
    }
}

