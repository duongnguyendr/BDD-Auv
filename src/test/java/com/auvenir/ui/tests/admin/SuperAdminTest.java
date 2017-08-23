package com.auvenir.ui.tests.admin;

import com.auvenir.ui.dataprovider.admin.AdminDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminAccountSettingsService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by thuan.duong on 7/5/2017.
 */
public class SuperAdminTest extends AbstractTest {
    AdminService adminService;
    AdminAccountSettingsService adminAccountSettingsService;
    MarketingService marketingService;

    @Test(priority = 1, enabled = true, description = "To Verify the GUI of Admin Home Page", dataProvider = "verifyGUISuperAdminHomePage", dataProviderClass = AdminDataProvider.class)
    public void verifyGUISuperAdminHomePage(String superAdminId, String superAdminPwd, String adminEmail,
                                            String clientEmail, String auditorEmail, String onboardingStatus, String waitListedStatus, String activeStatus, String inactiveStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        adminEmail = GenericService.addBrowserPrefix(adminEmail);
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyAdminSeeAllUser();
            adminService.verifyOnlyOneSuperAdmin();

            adminService.verifySuperAdminCanChangeSttAllUser();
            adminService.changeTheStatusUser(clientEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, onboardingStatus);
            adminService.changeTheStatusUser(clientEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, waitListedStatus);

            adminService.changeTheStatusUser(auditorEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, onboardingStatus);
            adminService.changeTheStatusUser(auditorEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, waitListedStatus);

            adminService.changeTheStatusUser(adminEmail, inactiveStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(adminEmail, inactiveStatus);
            adminService.changeTheStatusUser(adminEmail, activeStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(adminEmail, activeStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the GUI of Super Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Super Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "To Verify the GUI of Admin Home Page", dataProvider = "verifyGUIAdminHomePage", dataProviderClass = AdminDataProvider.class)
    public void verifyGUIAdminHomePage(String adminId, String adminPwd, String clientEmail, String auditorEmail, String onboardingStatus, String waitListedStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        adminId = GenericService.addBrowserPrefix(adminId);
        clientEmail = GenericService.addBrowserPrefix(clientEmail);
        auditorEmail = GenericService.addBrowserPrefix(auditorEmail);

        try {
            marketingService.loginUsingUsernamePassword(adminId, adminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyAdminSeeAllUser();
            adminService.verifyOnlyOneSuperAdmin();

            adminService.changeTheStatusUser(clientEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, onboardingStatus);
            adminService.changeTheStatusUser(clientEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(clientEmail, waitListedStatus);
            adminService.changeTheStatusUser(auditorEmail, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, onboardingStatus);
            adminService.changeTheStatusUser(auditorEmail, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.verifyUserIsChangeStatusOnTheList(auditorEmail, waitListedStatus);
            adminService.verifyAdminCannotChangeSttAdminUser();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the GUI of Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "To Verify Super Admin can change setting.", dataProvider = "verifySuperAdminChangeSetting", dataProviderClass = AdminDataProvider.class)
    public void verifySuperAdminChangeSetting(String superAdminId, String superAdminPwd, String superAdminFullName, String superAdminPhoneNum) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(superAdminFullName, superAdminId, superAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(superAdminFullName + "s");
            adminAccountSettingsService.clickUpdateBTN();
            marketingService.refreshHomePage();
            adminService.verifyHeaderAdminPage();

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(superAdminFullName + "s", superAdminId, superAdminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(superAdminFullName);
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the GUI of Super Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Super Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "To Verify the GUI of Admin Home Page", dataProvider = "verifyAdminChangeSetting", dataProviderClass = AdminDataProvider.class)
    public void verifyAdminChangeSetting(String adminId, String adminPwd, String adminFullName, String adminPhoneNum) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        adminId = GenericService.addBrowserPrefix(adminId);

        try {
            marketingService.loginUsingUsernamePassword(adminId, adminPwd);
            adminService.verifyHeaderAdminPage();

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(adminFullName, adminId, adminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(adminFullName + "s");
            adminAccountSettingsService.clickUpdateBTN();
            marketingService.refreshHomePage();
            adminService.verifyHeaderAdminPage();

            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyPersonalInfoRendered(adminFullName + "s", adminId, adminPhoneNum);
            adminAccountSettingsService.inputFullNameAdminSettingPage(adminFullName);
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify the GUI of Admin Home Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify the GUI of Admin Home Page: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "To Verify Assign Super Admin Role", dataProvider = "verifyAssignSuperAdminRole", dataProviderClass = AdminDataProvider.class)
    public void verifyAssignSuperAdminRole(String superAdminId, String superAdminPwd, String adminId, String adminPwd, String adminFullName, String superAdminFullName) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        adminId = GenericService.addBrowserPrefix(adminId);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.demoteSuperAdminRole(superAdminId, adminFullName, false);
            adminService.demoteSuperAdminRole(superAdminId, adminFullName, true);
            // Will update if the business change. Future plan: The Super admin will logout after demote user.
            adminService.verifyAdminCannotChangeSttAdminUser();
            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(superAdminId, superAdminPwd);
            adminService.verifyUserRoleOfEmail(superAdminId, "ADMIN");

            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(adminId, adminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyUserRoleOfEmail(adminId, "SUPER ADMIN");
            adminService.verifySuperAdminCanChangeSttAllUser();
            adminService.demoteSuperAdminRole(adminId, superAdminFullName, true);
            adminService.verifyAdminCannotChangeSttAdminUser();

            marketingService.logout();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(superAdminId, superAdminPwd);
            adminService.verifyHeaderAdminPage();
            adminService.verifyUserRoleOfEmail(superAdminId, "SUPER ADMIN");
            adminService.verifySuperAdminCanChangeSttAllUser();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Assign Super Admin Role.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Assign Super Admin Role: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify flow SuperAdmin change status of Admin.", dataProvider = "verifySuperAdminChangeStatusAdmin", dataProviderClass = AdminDataProvider.class, testName = "sa_25, 26, 27")
    public void verifySuperAdminChangeStatusAdmin(String superAdminId, String superAdminPassword, String adminId, String inactiveStatus, String lockedStatus, String onboardingStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        adminId = GenericService.addBrowserPrefix(adminId);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(adminId);

            adminService.changeTheStatusUser(adminId, inactiveStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(adminId);
            adminService.verifyUserIsChangeStatusOnTheList(adminId, inactiveStatus);

            adminService.changeTheStatusUser(adminId, lockedStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(adminId);
            adminService.verifyUserIsChangeStatusOnTheList(adminId, lockedStatus);

            adminService.changeTheStatusUser(adminId, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(adminId);
            adminService.verifyUserIsChangeStatusOnTheList(adminId, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Admin.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Admin.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 7, enabled = true, description = "Verify flow SuperAdmin change status of Auditor.", dataProvider = "verifySuperAdminChangeStatusAuditor", dataProviderClass = AdminDataProvider.class, testName = "sa_28, 29, 30, 31")
    public void verifySuperAdminChangeStatusAuditor(String superAdminId, String superAdminPassword, String auditorId, String inactiveStatus, String lockedStatus, String activeStatus, String waitListedStatus, String onboardingStatus) {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        auditorId = GenericService.addBrowserPrefix(auditorId);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(auditorId);

            adminService.changeTheStatusUser(auditorId, inactiveStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, inactiveStatus);

            adminService.changeTheStatusUser(auditorId, lockedStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, lockedStatus);

            adminService.changeTheStatusUser(auditorId, activeStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, activeStatus);

            adminService.changeTheStatusUser(auditorId, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, onboardingStatus);

            adminService.changeTheStatusUser(auditorId, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, waitListedStatus);

            adminService.changeTheStatusUser(auditorId, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(auditorId);
            adminService.verifyUserIsChangeStatusOnTheList(auditorId, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Auditor.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify flow SuperAdmin change status of Client.", dataProvider = "verifySuperAdminChangeStatusClient", dataProviderClass = AdminDataProvider.class, testName = "sa_32,33,34,35")
    public void verifySuperAdminChangeStatusClient(String superAdminId, String superAdminPassword, String clientId, String inactiveStatus, String lockedStatus, String activeStatus, String waitListedStatus, String onboardingStatus) throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        superAdminId = GenericService.addBrowserPrefix(superAdminId);
        clientId = GenericService.addBrowserPrefix(clientId);

        try {
            marketingService.loginUsingUsernamePassword(superAdminId, superAdminPassword);
            adminService.scrollToUser(clientId);

            adminService.changeTheStatusUser(clientId, inactiveStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, inactiveStatus);

            adminService.changeTheStatusUser(clientId, lockedStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, lockedStatus);

            MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", activeStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, activeStatus);

            adminService.changeTheStatusUser(clientId, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, onboardingStatus);

            adminService.changeTheStatusUser(clientId, waitListedStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, waitListedStatus);

            adminService.changeTheStatusUser(clientId, onboardingStatus);
            marketingService.refreshHomePage();
            adminService.scrollToUser(clientId);
            adminService.verifyUserIsChangeStatusOnTheList(clientId, onboardingStatus);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify flow SuperAdmin change status of Client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify flow SuperAdmin change status of Client.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


}