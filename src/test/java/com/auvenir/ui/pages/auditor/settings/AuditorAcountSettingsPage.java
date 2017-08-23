package com.auvenir.ui.pages.auditor.settings;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import sun.awt.windows.WEmbeddedFrame;

/**
 * Created by cuong.nguyen on 4/27/2017.
 * Updated by: Doai.Tran on 5/5/2017 For ticket: 2273
 */
public class AuditorAcountSettingsPage extends AbstractPage {
    private final static int waitTime = 60;

    public AuditorAcountSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,waitTime),this);

    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]")
    private WebElement auditorAccountSettingsHeaderTextEle;

    @FindBy(id = "link-setting-notifications-auditor")
    private WebElement notificationLinkEle;
    @FindBy(id = "link-setting-device-auditor")
    private WebElement devicesLinkEle;
    /*
    Element for ticket: PLAT-2273
     */
    @FindBy(id = "header-blue-logo")
    private WebElement auvenirLogo;
    @FindBy(id = "h-engagementsLink")
    private WebElement engagementlink;
    @FindBy(id = "h-clientListLink")
    private WebElement contactLink;
    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUserNameEle;
    @FindBy(id = "m-s-navSystemAuditorHead-id")
    private WebElement settingTitle;
    @FindBy(id = "link-setting-account-auditor")
    private WebElement accountTab;
    @FindBy(id = "link-setting-notifications-auditor")
    private WebElement notificationTab;
    @FindBy(id = "link-setting-device-auditor")
    private WebElement devicesTab;
    @FindBy(className = "card-account-title")
    private WebElement accountSettingTitle;
    @FindBy(id = "acc-ay-fullName")
    private WebElement fullNameTextBox;
    @FindBy(id = "acc-ay-email")
    private WebElement emailTextBox;
    @FindBy(id = "acc-ay-phoneNumber")
    private WebElement phoneNoTextBox;
    @FindBy(id = "acc-ay-photo")
    private WebElement userPhoto;
    @FindBy(id = "photoUploadBtn")
    private WebElement uploadButton;
    @FindBy(id = "acc-ay-firmName")
    private WebElement firNameTextBox;
    @FindBy(id = "acc-ay-role")
    private WebElement roleTextBox;
    @FindBy(id = "acc-ay-firmSize")
    private WebElement firmSizeDropBox;
    @FindBy(id = "acc-ay-firmLogo")
    private WebElement firmLogo;
    @FindBy(id = "logoUploadBtn")
    private WebElement logoUploadButton;
    @FindBy(xpath = "//div[@id='settings-auditorAccount-container']//button[@class='auvbtn secondary']")
    private WebElement deactivateButton;
    @FindBy(xpath = "//*[@class='auvbtn primary']")
    private WebElement updateButton;
    /*
    Element on Notification tab
     */
    @FindBy(xpath = "//*[contains(text(),'Notifications Settings')]")
    private WebElement notificationSettingTitle;
    @FindBy(id = "pNotificationNote")
    private WebElement notificationNote;
    @FindBy(className = "c-notifications-subHeader")
    private WebElement byEmailTitle;
    @FindBy(className = "c-notifications-cardSubNote")
    private WebElement SubNotification;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[3]/label/div")
    private WebElement isInventedToYourEngagementSlider;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[4]/label/div")
    private WebElement hasJoinedYourEngagementSlider;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[5]/label/div")
    private WebElement sendYouAMessageSlider;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[6]/label/div")
    private WebElement uploadsADocumentSlider;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[7]/label/div")
    private WebElement commentsOnEngagementSlider;
    @FindBy(xpath = "//*[@id='card-Notifications']/div[8]/label/div")
    private WebElement createANewRequestSlider;
    /*
    Element on Devices tab
     */
    @FindBy(xpath = "//*[contains(text(),'My Devices')]")
    private WebElement myDeviceTitle;
    @FindBy(id = "pNumDevices")
    private WebElement numberDevicesText;
    @FindBy(xpath = "//div[1]/img[@src='images/illustrations/devices/Desktop.svg']")
    private WebElement computerImage;
    @FindBy(xpath = "//div[1]/*[@class='c-devices-deviceCustomName']")
    private WebElement deviceCustomName;
    @FindBy(xpath = "//div[1]/*[@class='c-devices-deviceName']")
    private WebElement deviceName;
    @FindBy(xpath = "//div[1]/*[@class='btn-lg ghost c-devices-viewDeviceBtn']")
    private WebElement viewButton;
    @FindBy(xpath = "//*[@id='card-Mydevices']/button")
    private WebElement addAnotherButton;
    /*
    Element on footer
     */
    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement eleAuvenirIncTxt;
    @FindBy(xpath = "//*/div[@class='pull-right']/a[@href='/terms']")
    private WebElement eleTermsOfService;
    @FindBy(xpath = "//*/div[@class='pull-right']/a[@href='/privacy']")
    private WebElement elePrivacyStatement;
    @FindBy(xpath = "//*/div[@class='pull-right']/a[@href='/cookies']")
    private WebElement eleCookiesNotice;

    /*
    Some Methods to action on elements
     */
    public void verifyAccountSettingsPage() {
        waitForVisibleElement(auditorAccountSettingsHeaderTextEle, "auditorAccountSettingsHeaderTextEle");
    }

    public void navigateToNotificationsPage() {
        notificationLinkEle.click();
    }

    public void navigateToDevicesPage() {
        waitForClickableOfElement(devicesLinkEle, "devicesLinkEle");
        devicesLinkEle.click();
    }

    /*
    Verify all elements on Header of Auditor Settings Page
    Created by DoaiTran on 5/5/2017
     */
    public void verifyHeader() {
        waitForVisibleElement(auvenirLogo, "auvenirLogo");
        NXGReports.addStep("verified Element: auvenirLogo displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(engagementlink, "engagementlink");
        NXGReports.addStep("verified Element: engagementlink displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(contactLink, "contactLink");
        NXGReports.addStep("verified Element: contactLink displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(dashboardUserNameEle, "dashboardUserNameEle");
        NXGReports.addStep("verified Element: dashboardUserNameEle displayed.", LogAs.PASSED, (CaptureScreen) null);
    }

    /*

     */
    public void verifyFooterAcountSetting() {
        waitForVisibleElement(eleAuvenirIncTxt, "eleAuvenirIncTxt");
        NXGReports.addStep("verified Element: eleAuvenirIncTxt displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(eleTermsOfService, "eleTermsOfService");
        NXGReports.addStep("verified Element: eleAuvenirIncTxt displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(elePrivacyStatement, "elePrivacyStatement");
        NXGReports.addStep("verified Element: elePrivacyStatement displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(eleCookiesNotice, "eleCookiesNotice");
        NXGReports.addStep("verified Element: eleCookiesNotice displayed.", LogAs.PASSED, (CaptureScreen) null);
    }

    /*
    Verify all elements on body of Auditor Settings Page
    Created by DoaiTran on 5/5/2017
    Refactored by Minh Nguyen on June 26, 2017
     */
    public void verifyElementsOnAccountTab() {
        boolean isSettingTitle, isAccountTab, isNotificationTab, isAccountSettingTitle, isFullNameTextBox, isEmailTextBox, isPhoneNoTextBox,
        isFirNameTextBox, isRoleTextBox, isFirmSizeDropBox, isFirmLogo, isLogoUploadButton, isDeactivateButton, isUpdateButton, isUpdateButtonDis  = false;
        isSettingTitle = waitForVisibleElement(settingTitle, "settingTitle");
        if(!isSettingTitle)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: settingTitle visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isAccountTab = waitForVisibleElement(accountTab, "accountTab");
        if(!isAccountTab)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: accountTab visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isNotificationTab = waitForVisibleElement(notificationTab, "notificationTab");
        if(!isNotificationTab)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: notificationTab visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isAccountSettingTitle = waitForVisibleElement(accountSettingTitle, "accountSettingTitle");
        if(!isAccountSettingTitle)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: accountSettingTitle visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isFullNameTextBox = waitForVisibleElement(fullNameTextBox, "fullNameTextBox");
        if(!isFullNameTextBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: fullNameTextBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isEmailTextBox = waitForVisibleElement(emailTextBox, "emailTextBox");
        if(!isEmailTextBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: emailTextBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isPhoneNoTextBox = waitForVisibleElement(phoneNoTextBox, "phoneNoTextBox");
        if(!isPhoneNoTextBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: phoneNoTextBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isFirNameTextBox = waitForVisibleElement(firNameTextBox, "firNameTextBox");
        if(!isFirNameTextBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: firNameTextBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isRoleTextBox = waitForVisibleElement(roleTextBox, "roleTextBox");
        if(!isRoleTextBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: roleTextBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isFirmSizeDropBox = waitForVisibleElement(firmSizeDropBox, "firmSizeDropBox");
        if(!isFirmSizeDropBox)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: firmSizeDropBox visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isFirmLogo = waitForVisibleElement(firmLogo, "firmLogo");
        if(!isFirmLogo)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: firmLogo visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isLogoUploadButton = waitForVisibleElement(logoUploadButton, "logoUploadButton");
        if(!isLogoUploadButton)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: logoUploadButton visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isDeactivateButton = validateElementText(deactivateButton, "Deactivate My Account");
        if(!isDeactivateButton)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: deactivateButton visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isUpdateButton = validateElementText(updateButton, "Update");
        if(!isUpdateButton)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: updateButton text visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isUpdateButtonDis = validateDisabledElement(updateButton, "updateButton");
        if(!isUpdateButtonDis)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verified Element: updateButton disable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        if(isSettingTitle && isAccountTab && isNotificationTab && isAccountSettingTitle && isFullNameTextBox && isEmailTextBox && isPhoneNoTextBox &&
                isFirNameTextBox && isRoleTextBox && isFirmSizeDropBox && isFirmLogo && isLogoUploadButton && isDeactivateButton && isUpdateButton && isUpdateButtonDis )
        {
            NXGReports.addStep("verified Elements On Account Tab", LogAs.PASSED, null);
        }
    }

    public void navigateToNotificationTab() {
        waitForVisibleElement(notificationTab, "notificationTab");
        getLogger().info("verify Element: notificationTab displayed.");
        clickElement(notificationTab, "click to notificationTab");
        NXGReports.addStep("Go to Notification Tab successfully.", LogAs.PASSED, (CaptureScreen) null);
    }

    public void navigateToDevicesTab() {
        //waitForVisibleElement(devicesTab, "devicesTab");
        //getLogger().info("verify Element: devicesTab displayed.");
        //devicesTab.click();
        //NXGReports.addStep("Go to Device Tab successfully.", LogAs.PASSED, (CaptureScreen) null);
    }

    public void verifyElementsOnNotificationTab() {
        waitForVisibleElement(notificationSettingTitle, "notificationNote");
        NXGReports.addStep("verified Element: notificationSettingTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(notificationNote, "notificationNote");
        NXGReports.addStep("verified Element: notificationNote displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(byEmailTitle, "byEmailTitle");
        NXGReports.addStep("verified Element: byEmailTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(SubNotification, "SubNotification");
        NXGReports.addStep("verified Element: SubNotification displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(isInventedToYourEngagementSlider, "isInventedToYourEngagementSlider");
        NXGReports.addStep("verified Element: isInventedToYourEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(hasJoinedYourEngagementSlider, "hasJoinedYourEngagementSlider");
        NXGReports.addStep("verified Element: hasJoinedYourEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(sendYouAMessageSlider, "sendYouAMessageSlider");
        NXGReports.addStep("verified Element: sendYouAMessageSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(uploadsADocumentSlider, "verified");
        NXGReports.addStep("verified Element: uploadsADocumentSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(commentsOnEngagementSlider, "commentsOnEngagementSlider");
        NXGReports.addStep("verified Element: commentsOnEngagementSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(createANewRequestSlider, "createANewRequestSlider");
        NXGReports.addStep("verified Element: createANewRequestSlider displayed.", LogAs.PASSED, (CaptureScreen) null);
    }

    public void verifyElementsOnDevicesTab() {
        waitForVisibleElement(myDeviceTitle, "myDeviceTitle");
        NXGReports.addStep("verified Element: myDeviceTitle displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(numberDevicesText, "numberDevicesText");
        NXGReports.addStep("verified Element: numberDevicesText displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(computerImage, "computerImage");
        NXGReports.addStep("verified Element: computerImage displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(deviceCustomName, "deviceCustomName");
        NXGReports.addStep("verified Element: deviceCustomName displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(deviceName, "deviceName");
        NXGReports.addStep("verified Element: deviceName displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(viewButton, "viewButton");
        NXGReports.addStep("verified Element: viewButton displayed.", LogAs.PASSED, (CaptureScreen) null);
        waitForVisibleElement(addAnotherButton, "addAnotherButton");
        NXGReports.addStep("verified Element: addAnotherButton displayed.", LogAs.PASSED, (CaptureScreen) null);
    }

    public void inputFullName(String TextVlaue) {
        waitForVisibleElement(fullNameTextBox, "fullNameTextBox");
        fullNameTextBox.sendKeys(TextVlaue);
    }

    public void sendTabkeyFullNameTxt() {
        sendTabkey(fullNameTextBox, "fullNameTextBox");
    }

    public void sendTabkeyPhoneNumberTxt() {
        sendTabkey(phoneNoTextBox, "phoneNoTextBox");
    }
}
