package com.auvenir.ui.pages.auditor.settings;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class AuditorSettingsPage extends AbstractPage {

    public AuditorSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//div[@id='m-s-navSystemAuditorHead-id']")
    private WebElement eleSettingsTxt;

    public WebElement getEleSettingsTxt() {
        return eleSettingsTxt;
    }

    @FindBy(id = "link-setting-account-auditor")
    private WebElement eleAccountLnk;

    public WebElement getEleAccountLnk() {
        return eleAccountLnk;
    }

    @FindBy(xpath = "//div[@id='link-setting-notifications-auditor']")
    private WebElement eleNotificationsLnk;

    public WebElement getEleNotificationsLnk() {
        return eleNotificationsLnk;
    }

    @FindBy(xpath = "//div[@id='link-setting-device-auditor']")
    private WebElement eleDevicesLnk;

    public WebElement getEleDevicesLnk() {
        return eleDevicesLnk;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]")
    private WebElement eleAccountSettingsTxt;

    public WebElement getEleAccountSettingsTxt() {
        return eleAccountSettingsTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'First and Last Name')]")
    private WebElement eleFirstLastNameTxt;

    public WebElement getEleFirstLastNameTxt() {
        return eleFirstLastNameTxt;
    }

    @FindBy(id = "acc-ay-fullName")
    private WebElement eleFirstAndLastNameTxtFld;

    public WebElement getEleFirstAndLastNameTxtFld() {
        return eleFirstAndLastNameTxtFld;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Email Address')]")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(id = "acc-ay-email")
    private WebElement eleEmailAddressTxtFld;

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Phone Number')]")
    private WebElement elePhoneNumberTxt;

    public WebElement getElePhoneNumberTxt() {
        return elePhoneNumberTxt;
    }

    @FindBy(id = "acc-ay-phoneNumber")
    private WebElement elePhoneNumberTxtFld;

    public WebElement getElePhoneNumberTxtFld() {
        return elePhoneNumberTxtFld;
    }

    @FindBy(id = "acc-ay-photo")
    private WebElement eleProfilePictureImg;

    public WebElement getEleProfilePictureImg() {
        return eleProfilePictureImg;
    }

    @FindBy(xpath = "//h5[contains(text(),'Your Photo')]")
    private WebElement eleYourPhotoTxt;

    public WebElement getEleYourPhotoTxt() {
        return eleYourPhotoTxt;
    }

    @FindBy(xpath = "//div[@id='photoDiv2']//button[@id='photoUploadBtn']")
    private WebElement eleUpdatePhotoBtn;

    public WebElement getEleUpdatePhotoBtn() {
        return eleUpdatePhotoBtn;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Firm Name')]")
    private WebElement eleFirmNameTxt;

    public WebElement getEleFirmNameTxt() {
        return elePhoneNumberTxt;
    }

    @FindBy(id = "acc-ay-firmName")
    private WebElement eleFirmNameTxtFld;

    public WebElement getEleFirmNameTxtFld() {
        return eleFirmNameTxtFld;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Role')]")
    private WebElement eleRoleTxt;

    public WebElement getEleRoleTxt() {
        return eleRoleTxt;
    }

    @FindBy(id = "acc-ay-role")
    private WebElement eleRoleTxtFld;

    public WebElement getEleRoleTxtFld() {
        return eleRoleTxtFld;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Firm Size')]")
    private WebElement eleFirmSizeTxt;

    public WebElement getEleFirmSizeTxt() {
        return eleFirmSizeTxt;
    }

    @FindBy(id = "acc-ay-firmSize")
    private WebElement eleFirmSizeTxtFld;

    public WebElement getEleFirmSizeTxtFld() {
        return eleFirmSizeTxtFld;
    }

    @FindBy(id = "acc-ay-firmLogo")
    private WebElement eleFirmLogoImg;

    public WebElement getEleFirmLogoImg() {
        return eleFirmLogoImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//h5[contains(text(),'Firm Logo')]")
    private WebElement eleFirmLogoTxt;

    public WebElement getEleFirmLogoTxt() {
        return eleFirmLogoTxt;
    }

    @FindBy(id = "firmLogoDiv2")
    private WebElement eleUpdateBtn;

    public WebElement getEleUpdateBtn() {
        return eleUpdateBtn;
    }

    @FindBy(xpath = "//h4[contains(text(),'Account Settings')]//..//..//p[contains(text(),'Deactivate My Account')]")
    private WebElement eleDeactivateTxt;

    public WebElement getEleDeactivateTxt() {
        return eleDeactivateTxt;
    }

    @FindBy(xpath = "//div[text()='Notifications Settings']")
    private WebElement eleNotificationsSettingsTxt;

    public WebElement getEleNotificationsSettingsTxt() {
        return eleNotificationsSettingsTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'We will alert you')]")
    private WebElement eleWeWillAlertTxt;

    public WebElement getEleWeWillAlertTxt() {
        return eleWeWillAlertTxt;
    }

    @FindBy(xpath = "//h3[contains(text(),'By Email')]")
    private WebElement eleByEmailTxt;

    public WebElement getEleByEmailTxt() {
        return eleByEmailTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Get notified')]")
    private WebElement eleGetNotifiedTxt;

    public WebElement getEleGetNotifiedTxt() {
        return eleGetNotifiedTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Is invented')]")
    private WebElement eleIsInventedTxt;

    public WebElement getEleIsInventedTxt() {
        return eleIsInventedTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Is invented')]//..//div[@class='checkboxSlider round']")
    private WebElement eleIsInventedSliderBtn;

    public WebElement getEleIsInventedSliderBtn() {
        return eleIsInventedSliderBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Has joined')]")
    private WebElement eleHasJoinedTxt;

    public WebElement getEleHasJoinedTxt() {
        return eleHasJoinedTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Has joined')]//..//div[@class='checkboxSlider round']")
    private WebElement eleHasJoinedSliderBtn;

    public WebElement getEleHasJoinedSliderBtn() {
        return eleHasJoinedSliderBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Send you')]")
    private WebElement eleSendYouTxt;

    public WebElement getEleSendYouTxt() {
        return eleSendYouTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Send you')]//..//div[@class='checkboxSlider round']")
    private WebElement eleSendYouSliderBtn;

    public WebElement getEleSendYouSliderBtn() {
        return eleSendYouSliderBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'uploads a')]")
    private WebElement eleUploadATxt;

    public WebElement getEleUploadATxt() {
        return eleUploadATxt;
    }

    @FindBy(xpath = "//p[contains(text(),'uploads a')]//..//div[@class='checkboxSlider round']")
    private WebElement eleUploadASliderBtn;

    public WebElement getEleUploadASliderBtn() {
        return eleUploadASliderBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'comments')]")
    private WebElement eleCommentsTxt;

    public WebElement getEleCommentsTxt() {
        return eleCommentsTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'comments')]//..//div[@class='checkboxSlider round']")
    private WebElement eleCommentsSliderBtn;

    public WebElement getEleCommentsSliderBtn() {
        return eleCommentsSliderBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'create a')]")
    private WebElement eleCreateATxt;

    public WebElement getEleCreateATxt() {
        return eleCreateATxt;
    }

    @FindBy(xpath = "//p[contains(text(),'create a')]//..//div[@class='checkboxSlider round']")
    private WebElement eleCreateASliderBtn;

    public WebElement getEleCreateASliderBtn() {
        return eleCreateASliderBtn;
    }

    @FindBy(xpath = "//div[contains(text(),'My Devices')]")
    private WebElement eleMyDevicesTxt;

    public WebElement getEleMyDevicesTxt() {
        return eleMyDevicesTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'You have registered')]")
    private WebElement eleYouHaveRegisteredTxt;

    public WebElement getEleYouHaveRegisteredTxt() {
        return eleYouHaveRegisteredTxt;
    }

    @FindBy(xpath = "//button[contains(text(),'+ Add Another')]")
    private WebElement eleAddAnotherBtn;

    public WebElement getEleAddAnotherBtn() {
        return eleAddAnotherBtn;
    }

    public void clickNotificationLink(){
        waitForClickableOfElement(eleNotificationsLnk, "Notification link");
        clickElement(eleNotificationsLnk, "Notification link");
    }
    public void verifyDisplayElementInAuditorAccountSettingPage(){
        validateDisPlayedElement(eleSettingsTxt, "Settings  - Title");
        validateDisPlayedElement(eleAccountLnk, "Account  - Link");
        validateDisPlayedElement(eleNotificationsLnk, "Notification  - Link");
        validateDisPlayedElement(eleDevicesLnk, "Devices  - Link");
        validateDisPlayedElement(eleAccountSettingsTxt, "Account Settings  - Text");
        validateDisPlayedElement(eleFirstLastNameTxt, "First and Last Name  - Text");
        validateDisPlayedElement(eleFirstAndLastNameTxtFld, "First and Last Name  - Text Field");
        validateDisPlayedElement(eleEmailAddressTxt, "Email Address  - Text");
        validateDisPlayedElement(eleEmailAddressTxtFld, "Email Address  - Text Field");
        validateDisPlayedElement(elePhoneNumberTxt, "Phone Number  - Text");
        validateDisPlayedElement(elePhoneNumberTxtFld, "Phone Number  - Text Field");
        validateDisPlayedElement(eleProfilePictureImg, "Photo  - Image");
        validateDisPlayedElement(eleYourPhotoTxt, "your Photo  - Text");
        validateDisPlayedElement(eleUpdateBtn, "Update   - Button");
    }
    public void verifyDisplayElementInAuditorNotificationSettingPage(){
        clickNotificationLink();
        validateDisPlayedElement(eleNotificationsSettingsTxt, "Notification Settings Text");
        validateDisPlayedElement(eleWeWillAlertTxt, "We Will Alert Text");
        validateDisPlayedElement(eleByEmailTxt, "By Email Text");
        validateDisPlayedElement(eleGetNotifiedTxt, "Get Notified Text");
        validateDisPlayedElement(eleIsInventedTxt, "Is Invented Text");
        validateDisPlayedElement(eleIsInventedSliderBtn, "Is Invented Slider Button");
        validateDisPlayedElement(eleHasJoinedTxt, "Has Joined Text");
        validateDisPlayedElement(eleHasJoinedSliderBtn, "Has Joined Slider Button");
        validateDisPlayedElement(eleSendYouTxt, "Send You Text");
        validateDisPlayedElement(eleSendYouSliderBtn, "Send You Slider Button");
        validateDisPlayedElement(eleUploadATxt, "Upload A Text");
        validateDisPlayedElement(eleUploadASliderBtn, "Upload A Slider Button");
        validateDisPlayedElement(eleCommentsTxt, "Comment Text");
        validateDisPlayedElement(eleCommentsSliderBtn, "Comment Slider Button");
        validateDisPlayedElement(eleCreateATxt, "Create A Text");
        validateDisPlayedElement(eleCreateASliderBtn, "Create A Slider Button");
        clickElement(eleDevicesLnk, "Device link");
        validateDisPlayedElement(eleMyDevicesTxt, "My Devices Text");
        validateDisPlayedElement(eleYouHaveRegisteredTxt, "You Have Registered Text");
        validateEnabledElement(eleAddAnotherBtn, "Add Another Button");
    }
}
