package com.auvenir.ui.pages.admin;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*
Created by: Doai. Tran
Date: 27-Apr-2017
 */
public class AdminAccountSettingsPage extends AbstractPage {
    AuvenirPage auvenirPage = null;
    WebElement SelectStatus = null;
    private int waitTime = 30;

    public AdminAccountSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//img[@src='images/logos/auvenir/auvenir.svg']")
    private WebElement eleAuvenirLogoImg;

    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUserNameEle;

    @FindBy(id = "navTitle")
    private WebElement settingTitle;

    @FindBy(id = "link-setting-account")
    private WebElement accountTab;

    @FindBy(id = "link-setting-device")
    private WebElement devicesTab;

    @FindBy(id = "titleContainer")
    private WebElement accountSettingTitle;

    @FindBy(id = "acc-ay-fullName")
    private WebElement fullNameTextBox;

    @FindBy(id = "acc-ay-email")
    private WebElement emailTextBox;

    @FindBy(id = "acc-ay-phone")
    private WebElement phoneNoTextBox;

    @FindBy(id = "acc-ay-photo")
    private WebElement userPhoto;

    public WebElement getUserPhoto() {
        return userPhoto;
    }

    @FindBy(id = "uploadButton")
    private WebElement uploadButton;

    @FindBy(xpath = "//*[@class='auvbtn secondary']")
    private WebElement deactivateButton;

    @FindBy(id = "ac-updatebtn")
    private WebElement updateButton;

    @FindBy(xpath = "//*[@id='card-Mydevices']/div[1]/div")
    private WebElement myDeviceTitle;

    @FindBy(id = "pNumDevices")
    private WebElement numberDevicesText;

    @FindBy(xpath = "//img[@src='images/illustrations/devices/Desktop.svg']")
    private WebElement computerImage;

    @FindBy(xpath = "//*[@class='c-devices-deviceCustomName']")
    private WebElement deviceCustomName;

    @FindBy(xpath = "//*[@class='c-devices-deviceName']")
    private WebElement deviceName;

    @FindBy(xpath = "//*[@class='btn-lg ghost c-devices-viewDeviceBtn']")
    private WebElement viewButton;

    @FindBy(xpath = "//*[@id='card-Mydevices']/button")
    private WebElement addAnotherButton;

    @FindBy(xpath = "/html/body/footer/div/div/div[1]/span")
    private WebElement allRightReservedLink;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[1]")
    private WebElement termOfServiceLink;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[3]")
    private WebElement privacyStatementLink;

    @FindBy(xpath = "/html/body/footer/div/div/div[2]/a[5]")
    private WebElement cookiesNoticeLink;

    @FindBy(id = "h-ddl-item-settings")
    private WebElement settingsTabEle;

    public WebElement getSettingTabEle() {
        return settingsTabEle;
    }

    @FindBy(id = "fullNameLabel")
    private WebElement fullnameLable;

    public WebElement getFullNameTextBox() {
        return fullNameTextBox;
    }

    @FindBy(id = "phoneLabel")
    private WebElement phoneLable;

    public WebElement getphoneTextBox() {
        return phoneLable;
    }

    @FindBy(xpath = "//*[contains(text(),'Your account has been updated.')]")
    private WebElement updatedTextMessage;

    @FindBy(xpath = "//*[contains(text(),'*Please select a valid image file.')]")
    private WebElement errorMessageWrongTypeImage;

    public WebElement getErrorMessageWrongTypeImage() {
        return this.errorMessageWrongTypeImage;
    }

    @FindBy(xpath = "//*[contains(text(),'*Your image is too big. Please upload an image less than 2MB.')]")
    private WebElement errorMessageBigFile;

    @FindBy(xpath = "//*[@id='loaderContainer']")
    private WebElement loaderUpdateButton;

    public void goToSettingPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60L);
        wait.until(ExpectedConditions.visibilityOf(dashboardUserNameEle));
        clickElement(dashboardUserNameEle,"Dashboard User Name");
        wait.until(ExpectedConditions.visibilityOf(settingsTabEle));
        getSettingTabEle().click();
    }

    public void verifyElementsHeader() {
        try {
            getLogger().info("verify Element: eleAuvenirLogoImg displayed.");
            waitForVisibleElement(eleAuvenirLogoImg, "eleAuvenirLogoImg");
            NXGReports.addStep("verified Element: eleAuvenirLogoImg displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: dashboardUserNameEle displayed.");
            waitForVisibleElement(dashboardUserNameEle, "dashboardUserNameEle");
            NXGReports.addStep("verified Element: dashboardUserNameEle displayed.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Some Elements on header are not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyElementsOnAccountTab() {
        try {
            getLogger().info("verify Element: settingTitle displayed.");
            waitForVisibleElement(settingTitle, "settingTitle");
            NXGReports.addStep("verified Element: settingTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: accountTab displayed.");
            waitForVisibleElement(accountTab, "accountTab");
            NXGReports.addStep("verified Element: accountTab displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: devicesTab displayed.");
            waitForVisibleElement(devicesTab, "devicesTab");
            NXGReports.addStep("verified Element: devicesTab displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: accountSettingTitle displayed.");
            waitForVisibleElement(accountSettingTitle, "accountSettingTitle");
            NXGReports.addStep("verify Element: accountSettingTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: fullNameTextBox displayed.");
            waitForVisibleElement(fullNameTextBox, "fullNameTextBox");
            NXGReports.addStep("verified Element: fullNameTextBox displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: emailTextBox displayed.");
            waitForVisibleElement(emailTextBox, "emailTextBox");
            NXGReports.addStep("verified Element: emailTextBox displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: phoneNoTextBox displayed.");
            waitForVisibleElement(phoneNoTextBox, "phoneNoTextBox");
            NXGReports.addStep("verified Element: phoneNoTextBox displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: userPhoto displayed.");
            waitForVisibleElement(userPhoto, "userPhoto");
            NXGReports.addStep("verified Element: userPhoto displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: uploadButton displayed.");
            waitForVisibleElement(uploadButton, "uploadButton");
            NXGReports.addStep("verified Element: uploadButton displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: deactivateButton displayed.");
            validateElementText(deactivateButton, "Deactivate My Account");
            NXGReports.addStep("verified Element: deactivateButton displayed and disable", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: updateButton displayed.");
            validateElementText(updateButton, "Update");
            NXGReports.addStep("verified Element: updateButton displayed and disable", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Some Elements on AccountTab are not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesTab() {
        waitForVisibleElement(devicesTab, "devicesTab");
        getLogger().info("verify Element: devicesTab displayed.");
        devicesTab.click();
        NXGReports.addStep("Go to Device Tab successfully.", LogAs.PASSED, (CaptureScreen) null);
    }

    public void verifyElementsOnDevicesTab() {
        try {
            getLogger().info("verify Element: settingTitle displayed.");
            waitForVisibleElement(settingTitle, "settingTitle");
            NXGReports.addStep("verified Element: settingTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: accountTab displayed.");
            waitForVisibleElement(accountTab, "accountTab");
            NXGReports.addStep("verified Element: accountTab displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: devicesTab displayed.");
            waitForVisibleElement(devicesTab, "devicesTab");
            NXGReports.addStep("verified Element: devicesTab displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: myDeviceTitle displayed.");
            waitForVisibleElement(myDeviceTitle, "myDeviceTitle");
            NXGReports.addStep("verified Element: myDeviceTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: numberDevicesText displayed.");
            waitForVisibleElement(numberDevicesText, "numberDevicesText");
            NXGReports.addStep("verified Element: numberDevicesText displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: computerImage displayed.");
            waitForVisibleElement(computerImage, "computerImage");
            NXGReports.addStep("verified Element: computerImage displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: deviceCustomName displayed.");
            waitForVisibleElement(deviceCustomName, "deviceCustomName");
            NXGReports.addStep("verified Element: deviceCustomName displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: deviceName displayed.");
            waitForVisibleElement(deviceName, "deviceName");
            NXGReports.addStep("verified Element: deviceName displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: viewButton displayed.");
            waitForVisibleElement(viewButton, "viewButton");
            NXGReports.addStep("verify Element: viewButton displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: addAnotherButton displayed.");
            waitForVisibleElement(addAnotherButton, "addAnotherButton");
            NXGReports.addStep("verified Element: addAnotherButton displayed.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Some Elements on DevicesTab are not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyElementsFooter() {
        try {
            getLogger().info("verify Element: allRightReservedLink displayed.");
            waitForVisibleElement(allRightReservedLink, "allRightReservedLink");
            NXGReports.addStep("verified Element: allRightReservedLink displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: termOfServiceLink displayed.");
            waitForVisibleElement(termOfServiceLink, "termOfServiceLink");
            NXGReports.addStep("verified Element: termOfServiceLink displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: privacyStatementLink displayed.");
            waitForVisibleElement(privacyStatementLink, "privacyStatementLink");
            NXGReports.addStep("verified Element: privacyStatementLink displayed.", LogAs.PASSED, (CaptureScreen) null);
            getLogger().info("verify Element: cookiesNoticeLink displayed.");
            waitForVisibleElement(cookiesNoticeLink, "cookiesNoticeLink");
            NXGReports.addStep("verified Element: cookiesNoticeLink displayed.", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception e) {
            NXGReports.addStep("Some Elements on footer are not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void inputValueFullName(String Value) {
        waitForVisibleElement(fullNameTextBox, "fullNameTextBox");
        sendKeyTextBox(fullNameTextBox, Value, "fullNameTextBox");
        sendTabkey(fullNameTextBox, "fullNameTextBox");
    }

    public void inputValuePhoneNumber(String Value) {
        waitForVisibleElement(phoneNoTextBox, "phoneNoTextBox");
        sendKeyTextBox(phoneNoTextBox, Value, "phoneNoTextBox");
        sendTabkey(phoneNoTextBox, "phoneNoTextBox");
    }

    public void verifyEmailTextBoxIsDisable() {
        validateDisabledElement(emailTextBox, "emailTextBox");
    }

    public void validateTextMessageFullNametxtbox() {
        validateElementText(fullnameLable, "First and Last Name");
    }

    public void validateTextMessagePhoneTxtbox() {
        validateElementText(phoneLable, "Phone Number");
    }

    public void clickUpdateBTN() {
        getLogger().info("Try to click on Update Image button.");
        clickElement(updateButton, "updateButton");
        waitForCssValueChanged(loaderUpdateButton, "Loader Update Button", "display", "none");
    }

    public void waitAndVerifyUpdatedTextMessage() {
        waitForVisibleElement(updatedTextMessage, "updatedTextMessage");
        validateElementText(updatedTextMessage, "Your account has been updated.");
    }

    public void waitAndVerifyErrorMessageUploadImage() {
        waitForVisibleElement(errorMessageWrongTypeImage, "errorMessageWrongTypeImage");
        validateElementText(errorMessageWrongTypeImage, "*Please select a valid image file.");
    }

    public void waitAndVerifyErrorMessageBigFile() {
        waitForVisibleElement(errorMessageBigFile, "errorMessageBigFile");
        validateElementText(errorMessageBigFile, "*Your image is too big. Please upload an image less than 2MB.");
    }

    public void verifyUpdateButtonDisableDefault() {
        validateDisabledElement(updateButton, "updateButton");
    }

    public void verifyUpdateButtonEnable() {
        validateEnabledElement(updateButton, "updateButton");
        waitForClickableOfElement(updateButton, "updateButton");
    }

    public void sendTabkeyFullNameTxt() {
        sendTabkey(fullNameTextBox, "fullNameTextBox");
    }

    public void sendTabkeyPhoneNumberTxt() {
        sendTabkey(phoneNoTextBox, "phoneNoTextBox");
    }

    public void verifyPersonalInfoRendered(String fullName, String email, String phone) {
        getLogger().info("Verify Personal Information is rendered.");
        try {
            int count = 0;
            if (!validateAttributeElement(fullNameTextBox, "value", fullName))
                count++;
            if (!validateAttributeElement(emailTextBox, "value", email))
                count++;
            if (!validateAttributeElement(phoneNoTextBox, "value", phone))
                count++;
            Assert.assertTrue(count == 0, "Personal Information should be rendered correctly.");
            NXGReports.addStep("Personal Information is rendered correctly.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt ++;
            NXGReports.addStep("Personal Information is not rendered correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),e.getMessage());
        }

    }
}
