package com.auvenir.ui.tests.admin;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminAccountSettingsService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Doai.tran on 4/27/2017.
 * Implement for PLAT - 2273
 */
public class AdminSettingsTest extends AbstractTest {
    AdminAccountSettingsService adminAccountSettingsService;
    AdminService adminService;

    @Test(priority = 1, enabled = true, description = "Verify GUI admin setting page.")
    public void verifyUIAdminSetting() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        this.adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        /*String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");*/
        try {
            //adminService.loginWithUserRole(userId, getTokenUrl, checkTokenUrl);
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyHeaderAdminSettingPage();
            adminAccountSettingsService.verifyBodyAdminSettingPage();
            adminAccountSettingsService.verifyFooterAdminSettingPage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Some Elements on Admin Setting page not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 2, enabled = true, description = "Test First and Last name on Admin Setting Page.")
    public void InputValueFullName() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        /*String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");*/

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input any value on FullName TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("Doai Test");
            getLogger().info("Do not input any value on FullName TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextFullNameLable();
            getLogger().info("Input any value on FullName TextBox with max lenght.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Input NUMBER on FullName TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("123456");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextFullNameLable();
            getLogger().info("Input SPECIAL KEY on FullName TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("!@#$%^");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextFullNameLable();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Test First and Last name on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 3, enabled = true, description = "Email element View only on Admin Setting Page.")
    public void VerifyEmailTextBox() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.verifyEmailTextBoxVisible();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Email element View only on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Some Elements on Admin Setting page not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 4, enabled = true, description = "PhoneNumber textbox on Admin Setting Page.")
    public void InputValuePhoneNumber() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input any value on PhoneNumber TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("0934567890");

            getLogger().info("Do not input any value on PhoneNumber TextBox.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            getLogger().info("Input value on PhoneNumber TextBox with max length: 10.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("0934");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            getLogger().info("Input CHARACTER on PhoneNumber TextBox.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("abcdcdsfafs");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            getLogger().info("Input SPECIAL KEY on FullName TextBox.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("!@#$%^");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("PhoneNumber textbox on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 5, enabled = true, description = "Update new image on Admin Setting Page.")
    public void updateNewImage() throws IOException {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT");
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile1.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            adminAccountSettingsService.clickUpdateBTN();
            adminAccountSettingsService.waitAndVerifyUpdatedTextMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update new image on Admin Setting Page:PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 6, enabled = true, description = "Update new information on Admin Setting Page.")
    public void updateNewInfo() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.inputFullNameAdminSettingPage("ADMIN TEST");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("0906973152");
            adminAccountSettingsService.verifyEmailTextBoxVisible();
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile4.txt\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Get the message: *Please select a valid image file.");
            adminAccountSettingsService.waitAndVerifyErrorMessageUploadImage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update a wrong type on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Some Elements on Admin Setting page not displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 7, enabled = true, description = "Update a overload image file on Admin Setting Page.")
    public void updateOverLoadImage() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(this.getLogger(), this.getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile2.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Get the message: *Please select a valid image file.");
            adminAccountSettingsService.waitAndVerifyErrorMessageBigFile();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update a overload image file on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify disable default Update button on Admin Setting Page.")
    public void verifyDisableUpdateBtn() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(this.getLogger(), this.getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Verify disable default Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            getLogger().info("Input some new value.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("TEST TEST");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Verify Update Button to enable after changes value.");
            adminAccountSettingsService.verifyUpdateButtonEnable();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify disable default Update button on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 9, enabled = true, description = "Verify message when Update button with invalid value on Admin Setting Page.")
    public void verifyMessageUpdateBtnErrorValue() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input an invalid value on phone number");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("abcdcdsfafs");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            getLogger().info("Verify disable default Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            getLogger().info("Input an invalid value on FullName TextBox.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("!@#$%^");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextFullNameLable();
            getLogger().info("Verify disable default Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            getLogger().info("Upload an invalid image file.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile2.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Get the message: *Please select a valid image file.");
            adminAccountSettingsService.waitAndVerifyErrorMessageBigFile();
            getLogger().info("Verify disable default Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify message when Update button with invalid value on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 10, enabled = true, description = "Update failed because of wrong name")
    public void updateFailedWithWrongName() {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input an invalid data on FullName");
            adminAccountSettingsService.inputFullNameAdminSettingPage("123456");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextFullNameLable();
            getLogger().info("Verify disable Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update failed because of wrong name: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 11, enabled = true, description = "Update failed because of wrong phone number")
    public void updateFailedWithWrongPhoneNumber() {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input CHARACTER on PhoneNumber TextBox.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("abcdcdsfafs");
            adminAccountSettingsService.inputFullNameAdminSettingPage("");
            getLogger().info("Get the error message.");
            adminAccountSettingsService.verifyTextphoneLabel();
            getLogger().info("Verify disable Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update failed because of wrong name: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 12, enabled = true, description = "Update failed because of wrong image")
    public void updateFailedWithInvalidImage() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Upload an invalid image file.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile2.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Get the message: *Please select a valid image file.");
            adminAccountSettingsService.waitAndVerifyErrorMessageBigFile();
            getLogger().info("Verify disable default Update Button.");
            adminAccountSettingsService.verifyUpdateButtonDisableDefault();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update failed because of wrong image: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 13, enabled = true, description = "Update with valid Name on Admin Setting Page.")
    public void updateWithValidName() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");

        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input valid Full Name.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("Admin test");
            adminAccountSettingsService.sendTabkeyFullNametxt();
            adminAccountSettingsService.verifyUpdateButtonEnable();
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update with valid Name on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 14, enabled = true, description = "Update with valid PhoneNumber on Admin Setting Page.")
    public void updateWithValidPhoneNumber() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input valid phone number.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("0906973162");
            adminAccountSettingsService.sendTabkeyPhoneNumbertxt();
            adminAccountSettingsService.verifyUpdateButtonEnable();
            adminAccountSettingsService.clickUpdateBTN();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update with valid PhoneNumber on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 15, enabled = true, description = "change avatar successful")
    public void updateAvatarSuccessful() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Upload an valid image file.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile3.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Click on Update button.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Selected image successfully.");
            adminAccountSettingsService.waitAndVerifyUpdatedTextMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update new image on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Update all new information successfully.")
    public void updateAllInfoSuccessful() throws Exception {
        adminService = new AdminService(getLogger(), getDriver());
        adminAccountSettingsService = new AdminAccountSettingsService(getLogger(), getDriver());
        String userId = GenericService.getConfigValue(GenericService.sConfigFile, "ADMIN_ID");
        String getTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "GETTOKENURL");
        String checkTokenUrl = GenericService.getConfigValue(GenericService.sConfigFile, "CHECKTOKENURL");
        try {
            adminService.loginWithUserRole(userId);
            adminService.verifyHeaderAdminPage();
            adminService.navigateToSettingPage();
            getLogger().info("Input valid Full Name.");
            adminAccountSettingsService.inputFullNameAdminSettingPage("Admin test");
            getLogger().info("Input valid phone number.");
            adminAccountSettingsService.inputPhoneNumberAdminSettingPage("0906973162");
            getLogger().info("Upload an valid image file.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Run autoIT to select an image file");
            String autoITExecutable = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\UploadImageProfile_64bit.exe\"";
            String fileName = "\"" + GenericService.sDirPath + "\\src\\test\\resources\\TestData\\TestProfile3.jpg\"";
            adminAccountSettingsService.executeAutoITScriptUploadImage(autoITExecutable, fileName);
            getLogger().info("Click on Update button.");
            adminAccountSettingsService.clickUpdateBTN();
            getLogger().info("Selected image successfully.");
            adminAccountSettingsService.waitAndVerifyUpdatedTextMessage();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Update all new info on Admin Setting Page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}
