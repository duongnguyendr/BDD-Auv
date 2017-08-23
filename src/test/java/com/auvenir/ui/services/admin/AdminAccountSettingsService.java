package com.auvenir.ui.services.admin;

import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.auvenir.ui.pages.admin.AdminAccountSettingsPage;

/**
 * Created by doai.tran on 4/27/2017.
 * Updated by doai.tran on 5/201/2017
 */
public class AdminAccountSettingsService extends AbstractService {
    AdminAccountSettingsPage adminAccountSettingsPage;

    public AdminAccountSettingsService(Logger logger, WebDriver driver) {
        super(logger, driver);
        adminAccountSettingsPage = new AdminAccountSettingsPage(getLogger(), getDriver());
    }

    public void verifyHeaderAdminSettingPage() {
        getLogger().info("Start verify Elements on Admin Setting page.");
        adminAccountSettingsPage.verifyElementsHeader();
    }

    public void verifyBodyAdminSettingPage() {
        getLogger().info("Start verify Element on Account Tab on Admin Setting page.");
        adminAccountSettingsPage.verifyElementsOnAccountTab();
        adminAccountSettingsPage.navigateToDevicesTab();
        adminAccountSettingsPage.verifyElementsOnDevicesTab();
    }

    public void verifyFooterAdminSettingPage() {
        getLogger().info("Start verify Elements on Admin Setting page.");
        adminAccountSettingsPage.verifyElementsFooter();
    }

    public void inputFullNameAdminSettingPage(String Value) {
        getLogger().info("Input data for FullName Textbox.");
        adminAccountSettingsPage.inputValueFullName(Value);
    }

    public void inputPhoneNumberAdminSettingPage(String Value) {
        getLogger().info("Input data for Phone Number Textbox.");
        adminAccountSettingsPage.inputValuePhoneNumber(Value);
    }

    public void verifyEmailTextBoxVisible() {
        getLogger().info("Verify that Email TextBox is disable.");
        adminAccountSettingsPage.verifyEmailTextBoxIsDisable();
    }

    public void verifyTextFullNameLable() {
        getLogger().info("Verify text of Element: FullName lable ");
        adminAccountSettingsPage.validateTextMessageFullNametxtbox();
    }

    public void verifyTextphoneLabel() {
        getLogger().info("Verify text of Element: phoneLabel");
        adminAccountSettingsPage.validateTextMessagePhoneTxtbox();
    }

    public void clickUpdateBTN() {
        adminAccountSettingsPage.clickUpdateBTN();
    }

    public void waitAndVerifyUpdatedTextMessage() {
        getLogger().info("Try to waitAndVerifyUpdatedTextMessage.");
        adminAccountSettingsPage.waitAndVerifyUpdatedTextMessage();
    }

    public void waitAndVerifyErrorMessageUploadImage() {
        getLogger().info("Try to waitAndVerifyUpdatedTextMessage.");
        adminAccountSettingsPage.waitAndVerifyErrorMessageUploadImage();
    }

    public void waitAndVerifyErrorMessageBigFile() {
        getLogger().info("Try to waitAndVerifyErrorMessageBigFile.");
        adminAccountSettingsPage.waitAndVerifyErrorMessageBigFile();
    }

    public void verifyUpdateButtonDisableDefault() {
        getLogger().info("Try to verifyUpdateButtonDisableDefault.");
        adminAccountSettingsPage.verifyUpdateButtonDisableDefault();
    }

    public void verifyUpdateButtonEnable() {
        getLogger().info("Try to verifyUpdateButtonEnable.");
        adminAccountSettingsPage.verifyUpdateButtonEnable();
    }

    public void sendTabkeyFullNametxt() {
        getLogger().info("Try to sendTabkeyFullNametxt");
        adminAccountSettingsPage.sendTabkeyFullNameTxt();
    }

    public void sendTabkeyPhoneNumbertxt() {
        getLogger().info("Try to sendTabkeyPhoneNumbertxt");
        adminAccountSettingsPage.sendTabkeyPhoneNumberTxt();
    }

    public void verifyPersonalInfoRendered(String fullName, String email, String phone) {
        adminAccountSettingsPage.verifyPersonalInfoRendered(fullName, email, phone);
    }
}
