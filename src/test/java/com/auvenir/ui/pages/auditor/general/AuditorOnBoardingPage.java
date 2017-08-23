package com.auvenir.ui.pages.auditor.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.log4testng.Logger;

public class AuditorOnBoardingPage extends AbstractPage {


    public AuditorOnBoardingPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(css = "img[class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(id = "link-onboarding-personaltitle")
    private WebElement elePersonalTxt;

    public WebElement getElePersonalTxt() {
        return elePersonalTxt;
    }

    @FindBy(id = "link-onboarding-firmtitle")
    private WebElement eleFirmTxt;

    public WebElement getEleFirmTxt() {
        return eleFirmTxt;
    }

    @FindBy(id = "link-onboarding-securitytitle")
    private WebElement eleSecurityTxt;

    public WebElement getEleSecurityTxt() {
        return eleSecurityTxt;
    }

    @FindBy(id = "link-onboarding-personalcircle")
    private WebElement elePersonalNumberCircleImg;

    public WebElement getElePersonalNumberCircleImg() {
        return elePersonalNumberCircleImg;
    }

    @FindBy(id = "link-onboarding-firmcircle")
    private WebElement eleFirmNumberCircleImg;

    public WebElement getEleFirmNumberCircleImg() {
        return eleFirmNumberCircleImg;
    }

    @FindBy(id = "link-onboarding-securitycircle")
    private WebElement eleSecurityNumberCircleImg;

    public WebElement getEleSecurityNumberCircleImg() {
        return eleSecurityNumberCircleImg;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Confirm your Information')]")
    private WebElement elePleaseConfirmTxt;

    public WebElement getElePleaseConfirmTxt() {
        return elePleaseConfirmTxt;
    }

    @FindBy(xpath = "//p[@id='component-body']//p[contains(text(),'First and Last Name')]")
    private WebElement eleFirstAndLastNameTxt;

    public WebElement getEleFirstAndLastNameTxt() {
        return eleFirstAndLastNameTxt;
    }

    @FindBy(id = "personal-name")
    private WebElement eleFirstAndLastNameTxtFld;

    public WebElement getEleFirstAndLastNameTxtFld() {
        return eleFirstAndLastNameTxtFld;
    }

    @FindBy(xpath = "//p[text()='Street Address']")
    private WebElement eleAddressTxt;

    public WebElement getEleAddressTxt() {
        return eleAddressTxt;
    }

    @FindBy(id = "firm-streetAddress")
    private WebElement eleAddressTxtFld;

    public WebElement getEleAddressTxtFld() {
        return eleAddressTxtFld;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][@for='personal-email']")
    private WebElement eleEmailAddressTxt;

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    @FindBy(id = "personal-email")
    private WebElement eleEmailAddressTxtFld;

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    @FindBy(xpath = "//p[text()='Phone Number']")
    private WebElement elePersonalPhoneNumberTxt;

    public WebElement getElePersonalPhoneNumberTxt() {
        return elePersonalPhoneNumberTxt;
    }

    @FindBy(id = "personal-phoneNumber")
    private WebElement elePersonalPhoneNumberTxtFld;

    public WebElement getElePersonalPhoneNumberTxtFld() {
        return elePersonalPhoneNumberTxtFld;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to')]//..//img")
    private WebElement eleIAgreeToChkBox;

    public WebElement getEleIAgreeToChkBox() {
        return eleIAgreeToChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to')]")
    private WebElement eleIAgreeToTxt;

    public WebElement getEleIAgreeToTxt() {
        return eleIAgreeToTxt;
    }

    @FindBy(xpath = "//a[@class='personal-terms'][contains(text(),'privacy')]")
    private WebElement elePrivacyLnk;

    public WebElement getElePrivacyLnk() {
        return elePrivacyLnk;
    }

    @FindBy(xpath = "//a[@class='personal-terms'][contains(text(),'terms')]")
    private WebElement eleTermsAndConditionsLnk;

    public WebElement getEleTermsAndConditionsLnk() {
        return eleTermsAndConditionsLnk;
    }

    @FindBy(xpath = "//label[contains(text(),'I hereby confirm')]//..//img")
    private WebElement eleIHerebyConfirmChkBox;

    public WebElement getEleIHerebyConfirmChkBox() {
        return eleIHerebyConfirmChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I hereby confirm')]")
    private WebElement eleIHerebyConfirmTxt;

    public WebElement getEleIHerebyConfirmTxt() {
        return eleIHerebyConfirmTxt;
    }

    @FindBy(xpath = "//span[@id='personal-emptyCamera']")
    private WebElement eleCameraImg;

    public WebElement getEleCameraImg() {
        return eleCameraImg;
    }

    @FindBy(xpath = "//button[text()='Update Photo']")
    private WebElement eleUpdatePhotoBtn;

    public WebElement getEleUpdatePhotoBtn() {
        return eleUpdatePhotoBtn;
    }

    @FindBy(xpath = "//button[@id='personal-coninueBtn']")
    private WebElement eleContinueBtn;

    public WebElement getEleContinueBtn() {
        return eleContinueBtn;
    }

    @FindBy(xpath = "//div[@class='onboarding-badgesContainer']//img")
    private WebElement eleNortonBadgesImg;

    public WebElement getEleNortonBadgesImg() {
        return eleNortonBadgesImg;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Provide Your Firm Information')]")
    private WebElement elePleaseProvideTxt;

    public WebElement getElePleaseProvideTxt() {
        return elePleaseProvideTxt;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][@for='firm-name']")
    private WebElement eleNameTxt;

    public WebElement getEleNameTxt() {
        return eleNameTxt;
    }

    @FindBy(id = "firm-name")
    private WebElement eleNameTxtFld;

    public WebElement getEleNameTxtFld() {
        return eleNameTxtFld;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][@for='firm-size']")
    private WebElement eleNumberOfEmployeesTxt;

    public WebElement getEleNumberOfEmployeesTxt() {
        return eleNumberOfEmployeesTxt;
    }

    @FindBy(id = "firm-size")
    private WebElement eleNumberOfEmployeesTxtFld;

    public WebElement getEleNumberOfEmployeesTxtFld() {
        return eleNumberOfEmployeesTxtFld;
    }

    @FindBy(xpath = "//p[@class='auv-inputTitle'][@for='firm-phone']")
    private WebElement eleFirmPhoneNumberTxt;

    public WebElement getEleFirmPhoneNumberTxt() {
        return eleFirmPhoneNumberTxt;
    }

    @FindBy(id = "firm-phone")
    private WebElement eleFirmPhoneNumberTxtFld;

    public WebElement getEleFirmPhoneNumberTxtFld() {
        return eleFirmPhoneNumberTxtFld;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Provide')]//..//p[@class='auv-inputTitle'][text()='Street Number']")
    private WebElement eleStreetNumberTxt;

    public WebElement getEleStreetNumberTxt() {
        return eleStreetNumberTxt;
    }

    @FindBy(id = "firmAddress-streetNumber")
    private WebElement eleStreetNumberTxtFld;

    public WebElement getEleStreetNumberTxtFld() {
        return eleStreetNumberTxtFld;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Provide')]//..//p[text()='Street']")
    private WebElement eleStreetTxt;

    public WebElement getEleStreetTxt() {
        return eleStreetTxt;
    }

    @FindBy(id = "firmAddress-streetName")
    private WebElement eleStreetTxtFld;

    public WebElement getEleStreetTxtFld() {
        return eleStreetTxtFld;
    }

    @FindBy(xpath = "//p[text()='Unit / Suite Number']")
    private WebElement eleUnitNumberTxt;

    public WebElement getEleUnitNumberTxt() {
        return eleUnitNumberTxt;
    }

    @FindBy(id = "firm-unit")
    private WebElement eleUnitNumberTxtFld;

    public WebElement getEleUnitNumberTxtFld() {
        return eleUnitNumberTxtFld;
    }

    @FindBy(xpath = "//p[text()='City']")
    private WebElement eleCityTxt;

    public WebElement getEleCityTxt() {
        return eleCityTxt;
    }

    @FindBy(id = "firm-city")
    private WebElement eleCityTxtFld;

    public WebElement getEleCityTxtFld() {
        return eleCityTxtFld;
    }

    @FindBy(xpath = "//p[text()='Province/ State']")
    private WebElement eleProvinceStateTxt;

    public WebElement getEleProvinceStateTxt() {
        return eleProvinceStateTxt;
    }

    @FindBy(id = "firm-stateProvince")
    private WebElement eleProvinceStateTxtFld;

    public WebElement getEleProvinceStateTxtFld() {
        return eleProvinceStateTxtFld;
    }

    @FindBy(xpath = "//p[text()='Postal Code/ Zip Code']")
    private WebElement elePostalCodeZipCodeTxt;

    public WebElement getElePostalCodeZipCodeTxt() {
        return elePostalCodeZipCodeTxt;
    }

    @FindBy(id = "firm-country")
    private WebElement eleCountryTxtFld;

    public WebElement getEleCountryTxtFld() {
        return eleCountryTxtFld;
    }

    @FindBy(xpath = "//p[text()='Country']")
    private WebElement eleCountryTxt;

    public WebElement getEleCountryTxt() {
        return eleCountryTxt;
    }

    @FindBy(id = "firm-postalCode")
    private WebElement elePostalCodeZipCodeTxtFld;

    public WebElement getElePostalCodeZipCodeTxtFld() {
        return elePostalCodeZipCodeTxtFld;
    }

    @FindBy(id = "firm-affiliated")
    private WebElement eleIAmAffiliatedChkBox;

    public WebElement getEleIAmAffiliatedChkBox() {
        return eleIAmAffiliatedChkBox;
    }

    @FindBy(xpath = "//p[@for='firm-affiliated-name']")
    private WebElement eleAffliatedNameTxt;

    public WebElement getEleAffliatedNameTxt() {
        return eleAffliatedNameTxt;
    }

    @FindBy(id = "firm-affiliated-name")
    private WebElement eleAffliatedNameTxtFld;

    public WebElement getEleAffliatedNameTxtFld() {
        return eleAffliatedNameTxtFld;
    }

    @FindBy(xpath = "//label[contains(text(),'I am affiliated')]")
    private WebElement eleIAmAffiliatedTxt;

    public WebElement getEleIAmAffiliatedTxt() {
        return eleIAmAffiliatedTxt;
    }

    @FindBy(xpath = "//button[@id='onboard-firm-continue'][text()='Continue']")
    private WebElement eleContinueFirmBtn;

    public WebElement getEleContinueFirmBtn() {
        return eleContinueFirmBtn;
    }

    @FindBy(xpath = "//span[@id='firm-emptyCamera']//..")
    private WebElement eleCameraFirmImg;

    public WebElement getEleCameraFirmImg() {
        return eleCameraFirmImg;
    }

    @FindBy(xpath = "//h3[contains(text(),'Please Provide')]//..//button[text()='Update Logo']")
    private WebElement eleUpdatePhotoFirmBtn;

    public WebElement getEleUpdatePhotoFirmBtn() {
        return eleUpdatePhotoFirmBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Set Up')]")
    private WebElement eleSetUpTxt;

    public WebElement getEleSetUpTxt() {
        return eleSetUpTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Download the Auvenir')]")
    private WebElement eleDownloadtheAuvenirTxt;

    public WebElement getEleDownloadtheAuvenirTxt() {
        return eleDownloadtheAuvenirTxt;
    }

    @FindBy(xpath = "//button[contains(text(),'Text me a Link')]")
    private WebElement eleTextMeALinkBtn;

    public WebElement getEleTextMeALinkBtn() {
        return eleTextMeALinkBtn;
    }

    @FindBy(id = "smsInputBox")
    private WebElement elePhoneNumberSmsInputTxtFld;

    public WebElement getElePhoneNumberSmsInputTxtFld() {
        return elePhoneNumberSmsInputTxtFld;
    }

    @FindBy(css = "img[class='register-mb-img']")
    private WebElement elePhoneImg;

    public WebElement getElePhoneImg() {
        return elePhoneImg;
    }

    @FindBy(css = "img[src='images/components/applestore.png']")
    private WebElement eleAppStoreImg;

    public WebElement getEleAppStoreImg() {
        return eleAppStoreImg;
    }

    @FindBy(css = "img[src='images/components/googlestore.png']")
    private WebElement eleGooglePlayImg;

    public WebElement getEleGooglePlayImg() {
        return eleGooglePlayImg;
    }

    @FindBy(xpath = "//button[text()='Skip']")
    private WebElement eleSkipBtn;

    public WebElement getEleSkipBtn() {
        return eleSkipBtn;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//img[@src='images/icons/warning.svg']")
    private WebElement eleWarningImg;

    public WebElement getEleWarningImg() {
        return eleWarningImg;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//img[@src='images/icons/x-small.svg']")
    private WebElement eleCloseImg;

    public WebElement getEleCloseImg() {
        return eleCloseImg;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]")
    private WebElement eleSkipSecurityTxt;

    public WebElement getEleSkipSecurityTxt() {
        return eleSkipSecurityTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'By choosing')]")
    private WebElement eleByChoosingTxt;

    public WebElement getEleByChoosingTxt() {
        return eleByChoosingTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'defaulting to email')]//..//img")
    private WebElement eleIAmDefaultingChkBox;

    public WebElement getEleIAmDefaultingChkBox() {
        return eleIAmDefaultingChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'defaulting to email')]")
    private WebElement eleIAmDefaultingTxt;

    public WebElement getEleIAmDefaultingTxt() {
        return eleIAmDefaultingTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'I take responsibility')]//..//img")
    private WebElement eleITakeResponsibilityChkBox;

    public WebElement getEleITakeResponsibilityChkBox() {
        return eleITakeResponsibilityChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I take responsibility')]")
    private WebElement eleITakeResponsibilityTxt;

    public WebElement getEleITakeResponsibilityTxt() {
        return eleITakeResponsibilityTxt;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to Auvenir')]//..//img")
    private WebElement eleIAgreeToAuvenirChkBox;

    public WebElement getEleIAgreeToAuvenirChkBox() {
        return eleIAgreeToAuvenirChkBox;
    }

    @FindBy(xpath = "//label[contains(text(),'I agree to Auvenir')]")
    private WebElement eleIAgreeToAuvenirTxt;

    public WebElement getEleIAgreeToAuvenirTxt() {
        return eleIAgreeToAuvenirTxt;
    }

    @FindBy(className = "skip-security-link")
    private WebElement eleTermsAndConditionsSkipSecurityLnk;

    public WebElement getEleTermsAndConditionsSkipSecurityLnk() {
        return eleTermsAndConditionsSkipSecurityLnk;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//input[@value='Cancel']")
    private WebElement eleCancelSkipSecurityBtn;

    public WebElement getEleCancelSkipSecurityBtn() {
        return eleCancelSkipSecurityBtn;
    }

    @FindBy(xpath = "//label[contains(text(),'Skip Security')]//..//..//input[@value='Agree']")
    private WebElement eleAgreeSkipSecurityBtn;

    public WebElement getEleAgreeSkipSecurityBtn() {
        return eleAgreeSkipSecurityBtn;
    }

    public void verifyOnBoardingPersonalInformationPage() {
        validateDisPlayedElement(eleAuvenirLogoImg, "Auvenir Logo");
        validateDisPlayedElement(elePersonalTxt, "Personal Text");
        validateDisPlayedElement(eleFirmTxt, "Firm Text");
        validateDisPlayedElement(eleSecurityTxt, "Security Text");
        validateDisPlayedElement(elePersonalNumberCircleImg, "Personal Number Circle Image");
        validateDisPlayedElement(eleFirmNumberCircleImg, "Firm Number Circle Image");
        validateDisPlayedElement(eleSecurityNumberCircleImg, "Security Number Circle Image");
        validateDisPlayedElement(elePleaseConfirmTxt, "Please Confirm Text ");
        validateDisPlayedElement(eleFirstAndLastNameTxt, "First and Last name Text");
        validateDisPlayedElement(eleFirstAndLastNameTxtFld, "First and Last name Text Field");
        validateDisPlayedElement(eleEmailAddressTxt, "Email Address Text");
        validateDisPlayedElement(eleEmailAddressTxtFld, "Email Address Text Field");
        validateDisPlayedElement(elePersonalPhoneNumberTxt, "Personal Phone Number Text");
        validateDisPlayedElement(elePersonalPhoneNumberTxtFld, "Personal Phone Number Text Field");
        validateDisPlayedElement(eleIAgreeToChkBox, "I Agree to Check Box");
        validateDisPlayedElement(eleIAgreeToTxt, "I Agree to Text");
        validateDisPlayedElement(elePrivacyLnk, "Privacy link");
        validateDisPlayedElement(eleTermsAndConditionsLnk, "Terms and Conditions link");
        validateDisPlayedElement(eleIHerebyConfirmChkBox, "I hereby confirm Check Box");
        validateDisPlayedElement(eleIHerebyConfirmTxt, "I hereby confirm Text");
//        toValidate(getEleCameraImg(), "Camera Image", "Displayed");       //Removed
//        toValidate(getEleUpdatePhotoBtn(), "Update Photo Button", "Enabled");     //Removed
        validateEnabledElement(eleContinueBtn, "Continue button");
        validateDisPlayedElement(eleNortonBadgesImg, "Norton and Truste Image");
    }

    public void verifyInputPersonalInfomation(String auditorName, String phoneNumber) {
        sendKeyTextBox(eleFirstAndLastNameTxtFld, auditorName, "First and Last name Text Field");
        sendKeyTextBox(elePersonalPhoneNumberTxtFld, phoneNumber, "Personal Phone Number Text Field");
        clickOnCheckBox(eleIAgreeToChkBox, "I Agree to Check Box");
        clickOnCheckBox(eleIHerebyConfirmChkBox, "I hereby confirm Check Box");
        clickElement(eleContinueBtn, "Continue button");
    }

    public void verifyOnBoardingFirmInfomationPage() {
        validateDisPlayedElement(elePleaseProvideTxt, "Please Provide Your Text");
        validateDisPlayedElement(eleNameTxt, "Name Text");
        validateDisPlayedElement(eleNameTxtFld, "Name Text Field");
        validateDisPlayedElement(eleNumberOfEmployeesTxt, "Number of Employees Text");
        validateDisPlayedElement(eleNumberOfEmployeesTxtFld, "Number of Employees Text Field");
        validateDisPlayedElement(eleFirmPhoneNumberTxt, "Phone Number Text");
        validateDisPlayedElement(eleFirmPhoneNumberTxtFld, "Phone Number Text Field");
        validateDisPlayedElement(eleAddressTxt, "Address Text");
        validateDisPlayedElement(eleAddressTxtFld, "Address Text Field");
        validateDisPlayedElement(eleUnitNumberTxtFld, "Unit Number Text Field");
        validateDisPlayedElement(eleCityTxt, "City Text");
        validateDisPlayedElement(eleCityTxtFld, "City Text Field");
        validateDisPlayedElement(eleCountryTxt, "Country Text");
        validateDisPlayedElement(eleCountryTxtFld, "Country Text Field");
        validateDisPlayedElement(eleProvinceStateTxt, "Province / State Text");
        validateDisPlayedElement(eleProvinceStateTxtFld, "Province / State Text Field");
        validateDisPlayedElement(elePostalCodeZipCodeTxt, "Postal Code / Zip Code Text");
        validateDisPlayedElement(elePostalCodeZipCodeTxtFld, "Postal Code / Zip Code Text Field");
        validateDisPlayedElement(eleIAmAffiliatedChkBox, "I am affiliated Check Box");
        validateDisPlayedElement(eleIAmAffiliatedTxt, "I am affiliated Text");
        validateEnabledElement(eleContinueFirmBtn, "Continue button");
        validateDisPlayedElement(eleCameraFirmImg, "Camera Firm Image");
        validateEnabledElement(eleUpdatePhotoFirmBtn, "Update Photo Firm Button");
    }

    public void verifyInputFirmInformationOnboardingPage(String firmName, String numberEmployee, String phoneNumber,
                                                         String address, String unitNumber, String cityName, String provinceState,
                                                         String countryName, String zipCode) {
        sendKeyTextBox(eleNameTxtFld, firmName, "Name Text Field");
        sendKeyTextBox(eleNumberOfEmployeesTxtFld, numberEmployee, "Number of Employees Text Field");
        sendKeyTextBox(eleFirmPhoneNumberTxtFld, phoneNumber, "Phone Number Text Field");
        sendKeyTextBox(eleAddressTxtFld, address, "Address Text Field");
        sendKeyTextBox(eleUnitNumberTxtFld, unitNumber, "Unit Number Text Field");
        sendKeyTextBox(eleCityTxtFld, cityName, "City Text Field");
        sendKeyTextBox(eleProvinceStateTxtFld, provinceState, "Province / State Text Field");
        sendKeyTextBox(eleCountryTxtFld, countryName, "Country Text Field");
        sendKeyTextBox(elePostalCodeZipCodeTxtFld, zipCode, "Postal Code / Zip Code Text Field");
//        clickOnCheckBox(getEleIAmAffiliatedChkBox(), "I am affiliated Check Box");
    }

    public void verifyInputAffliateField(String affliateName) {
        validateDisPlayedElement(eleAffliatedNameTxt, "Affliated Name - Text");
        validateDisPlayedElement(eleAffliatedNameTxtFld, "Affliated Name - Text Field");
        sendKeyTextBox(eleAffliatedNameTxtFld, affliateName, "Affliated Name - Text Field");
    }

    public void verifySecurityOnBoardingPage() {
        clickElement(eleContinueFirmBtn, "Continue button");
        validateDisPlayedElement(eleSetUpTxt, "Set Up Security Text");
        validateDisPlayedElement(eleDownloadtheAuvenirTxt, "Download the Auvenir Text");
        validateEnabledElement(eleTextMeALinkBtn, "Text me a link Button");
        validateDisPlayedElement(elePhoneNumberSmsInputTxtFld, "Phone number Text Field");
        validateDisPlayedElement(elePhoneImg, "Phone Image");
        validateDisPlayedElement(eleAppStoreImg, "App Store Image");
        validateDisPlayedElement(eleGooglePlayImg, "Google Play Image");
        validateEnabledElement(eleSkipBtn, "Skip Button");
        clickElement(eleSkipBtn, "Skip button");
        validateDisPlayedElement(eleWarningImg, "Warning Image");
        validateDisPlayedElement(eleCloseImg, "Close Image");
        validateDisPlayedElement(eleSkipSecurityTxt, "Skip Security Text");
        validateDisPlayedElement(eleByChoosingTxt, "By Choosing Text");
        validateDisPlayedElement(eleIAmDefaultingChkBox, "I am Defaulting Check Box");
        validateDisPlayedElement(eleIAmDefaultingTxt, "I am Defaulting Text");
        validateDisPlayedElement(eleITakeResponsibilityChkBox, "I Take Responsibility Check Box");
        validateDisPlayedElement(eleITakeResponsibilityTxt, "I Take Responsibility Text");
        validateDisPlayedElement(eleIAgreeToAuvenirChkBox, "I Agree to Auvenir Check Box");
        validateDisPlayedElement(eleIAgreeToAuvenirTxt, "I Agree to Auvenir Text");
        validateDisPlayedElement(eleTermsAndConditionsSkipSecurityLnk, "Terms and Conditions Link");
        validateEnabledElement(eleCancelSkipSecurityBtn, "Cancel Button");
        validateEnabledElement(eleAgreeSkipSecurityBtn, "Agree Button");
    }

    /**
     * Refactored by huy.huynh on 01/06/2017.
     * New for smoke test
     */

    @FindBy(id = "onboard-firm-continue")
    private WebElement buttonFirmContinue;

    @FindBy(id = "security-title")
    private WebElement titleSecurity;

    @FindBy(xpath = "//input[@id='first-password']")
    private WebElement inputFirstPassword;

    @FindBy(xpath = "//input[@id='second-password']")
    private WebElement inputSecondPassword;

    @FindBy(id = "security-continueBtn")
    private WebElement buttonSecurityContinue;

    @FindBy(id = "epilogue-title")
    private WebElement titleEpilogue;

    @FindBy(id = "epilogue-description")
    private WebElement textViewEpilogueDescription;

    @FindBy(id = "epilogue-closeBtn")
    private WebElement buttonElilogueClose;

    /**
     * input password and confirm for Security Onboarding page
     * Simplelize: other version seem have more element- this version only have 2 password inputs
     *
     * @param password password to set
     */
    public void verifySecurityOnBoardingPageSimplelize(String password) {
        clickElement(buttonFirmContinue);

        validateElementText(titleSecurity, "Create Your Password");

        sendKeyTextBox(inputFirstPassword, password, "First password");
        sendKeyTextBox(inputSecondPassword, password, "Second password");

        clickElement(buttonSecurityContinue);
    }

    /**
     * Announcement that account created n thanks
     *
     * @param email email on thanks message
     */
    public void verifyEpilogueOnBoardingPage(String email) {
        validateElementText(titleEpilogue, "Your Account Has Been Created!");
        validateElementText(textViewEpilogueDescription, "Thank you for creating an account. We will be sending a verification email to " + email + " within 24 hours. Please click the link in the email to get started on your engagements.");

        clickElement(buttonElilogueClose);
    }
    /*-----------end of huy.huynh on 01/06/2017.*/
}