package com.auvenir.ui.services.admin;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.admin.AdminPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 4/28/2017.
 * Refactor code and implement for PLAT 2273
 */
public class AdminService extends AbstractService {
    AdminPage adminPage;
    AuvenirPage auvenirPage;

    public AdminService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminPage = new AdminPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
    }

    public void navigateToSettingPage() {
        adminPage.navigateToSettingsPage();
    }

    public void verifyHeaderAdminPage() {
        try {
            getLogger().info("verify Admin Login page.");
            adminPage.verifyHeaderAdminPage();
            NXGReports.addStep("verify Admin Login Page.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Login Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by huy.huynh on 24/05/2017.
     * Restructure only
     */
    public void verifyPageLoad() {
        adminPage.verifyHeaderAdminPage();
    }

    public void verifyHeader() {
        getLogger().info("Verify Admin logged in header.");
        auvenirPage.verifyHeader();
        adminPage.verifyAdminHeaderText();
    }

    public void verifyBody() {
        getLogger().info("Verify Admin logged in body.");
        adminPage.verifyAdminDashBoard();
        adminPage.verifyUserTable();
    }

    public void verifyFooter() {
        getLogger().info("Verify page footer.");
        auvenirPage.verifyFooterOfHomepage();
    }

    public void viewAndVerifyCredentials() {
        adminPage.viewAndVerifyCredentials();
    }

    public void verifyDropMenuMessage() {
        adminPage.verifyDropMenuMessage();
    }

    public void clickNewMessage() {
        adminPage.clickNewMessage();
    }

    public void verifyNewMessagePopup() {
        adminPage.verifyNewMessagePopup();
    }

    public void closeNewMessagePopup() {
        adminPage.closeNewMessagePopup();
    }

    public void verifyDropMenuNotification() {
        adminPage.verifyDropMenuNotification();
    }

    public void clickViewAllNotification() {
        adminPage.clickViewAllNotification();
    }

    public void verifyBodyNotificationPage() {
        adminPage.verifyBodyNotificationPage();
    }

    public void navigateToSettingAccountPage() {
        adminPage.navigateToSettingAccountPage();
    }

    public void verifySettingAccountPage() {
        adminPage.verifySettingAccountPage();
    }

    public void clickDeactiveLink() {
        adminPage.clickDeactiveLink();
    }

    public void verifyDeactivePopup() {
        adminPage.verifyDeactivePopup();
    }

    public void closeDeactivePopup() {
        adminPage.closeDeactivePopup();
    }

    public void navigateToSettingDevicesPage() {
        adminPage.navigateToSettingDevicesPage();
    }

    public void verifySettingDevicesPage() {
        adminPage.verifySettingDevicesPage();
    }

    public void addAnotherDeviceLink() {
        adminPage.addAnotherDeviceLink();
    }

    public void verifyAddAnotherPopup() {
        adminPage.verifyAddAnotherPopup();
    }

    public void navigateToSettingDevicesDisconnect() {
        adminPage.navigateToSettingDevicesDisconnect();
    }

    public void verifySettingDevicesDisconnectPopup() {
        adminPage.verifySettingDevicesDisconnectPopup();
    }
    /*-----------end of huy.huynh on 24/05/2017.*/

    /**
     * Refactored by huy.huynh on 30/05/2017.
     * New for smoke test
     */
    public void verifyAuditorRowOnAdminUserTable(String userType, String userEmail, String createdDate, String userStatus) {
        adminPage.verifyAuditorRowOnAdminUserTable(userType, userEmail, createdDate, userStatus);
    }

    public void verifyUserStatusOnAdminUserTable(String userEmail, String userStatus) {
        adminPage.verifyAuditorStatusOnAdminUserTable(userEmail, userStatus);
    }

    public void changeTheStatusUser(String userEmail, String chooseOption) {
        adminPage.changeTheStatusUser(userEmail, chooseOption);
    }
    /*-----------end of huy.huynh on 30/05/2017.*/

    public void clickClosePopupWarningBrowser() {
        adminPage.clickClosePopupWarningBrowser();
    }

    public void verifyAdminSeeAllUser() {
        adminPage.verifyAdminSeeAllUser();
    }

    public void verifyUserIsChangeStatusOnTheList(String email, String expectedStatus) {
        adminPage.verifyUserIsChangeStatusOnTheList(email, expectedStatus);
    }

    public void verifyAdminCannotChangeSttAdminUser() {
        adminPage.verifyAdminCannotChangeSttAdminUser();
    }

    public void demoteSuperAdminRole(String superAdminEmail, String adminName, boolean confirmation) {
        adminPage.demoteSuperAdminRole(superAdminEmail, adminName, confirmation);
    }

    public void verifySuperAdminCanChangeSttAllUser() {
        adminPage.verifySuperAdminCanChangeSttAllUser();
    }

    public void verifyUserRoleOfEmail(String email, String role) {
        adminPage.verifyUserRoleOfEmail(email, role);
    }

    public void verifyOnlyOneSuperAdmin() {
        adminPage.verifyOnlyOneSuperAdmin();
    }

    public void scrollToUser(String email) {
        adminPage.scrollToUser(email);
    }

    public void verifyUserTypeOnAdminUserTable(String email, String userType) {
        adminPage.verifyUserTypeOnAdminUserTable(email, userType, false);
    }
}

