package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.AuditorSignUpPage;
import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by tan.pham on 5/24/2017.
 */
public class AuditorSignUpService extends AbstractService {
    private AuditorSignUpPage auditorSignUpPage;
    private MarketingPage marketingPage;

    public AuditorSignUpService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorSignUpPage = new AuditorSignUpPage(getLogger(), getDriver());
        marketingPage = new MarketingPage(getLogger(), getDriver());
    }

    public void verifyFirmSignUpPage() {
        auditorSignUpPage.verifyFirmInfoPageContent();
    }

    public void registerFirmInfo(String strName, String strPreName, String strWebsite, String strStreetAddr, String strOffNum, String strZipCode, String strCity,String strCountry, String strState, String strMemberID, String strNumEmp, String strPhone, String strAffName, String strPathLogo) throws InterruptedException {
        auditorSignUpPage.registerFirmInfo(strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode, strCity,strCountry, strState, strMemberID, strNumEmp, strPhone, strAffName, strPathLogo);
    }

//    public void clickOnChangedNameCheckBox() {
//        auditorSignUpPage.clickOnChangedNameCheckBox();
//    }

    public void clickOnAllFirmCheckBox() {
        auditorSignUpPage.clickOnAllFirmCheckBox();
    }

    public void clickOnRuleLogoCheckBox() {
        auditorSignUpPage.clickOnRuleLogoCheckBox();
    }

    public void inputValueIntoFirmNameTextBox(String strName) {
        auditorSignUpPage.inputValueIntoFirmNameTextBox(strName);
    }

    public void inputValueIntoPreviousFirmNameTextBox(String strName) {
        auditorSignUpPage.inputValueIntoPreviousFirmNameTextBox(strName);
    }


    public void verifyInputValidValueOnFirmNameTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnFirmNameTextBox(invalidValue.get(i));
        }
    }

    public void verifyInputValidValueOnPreFirmNameTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnPreFirmNameTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoFirmWebsiteTextBox(String strName) {
        auditorSignUpPage.inputValueIntoWebsiteTextBox(strName);
    }

    public void verifyInputValidValueOnFirmWebsiteTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnFirmWebsiteTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoFullAddressTextBox(String strName) {
        auditorSignUpPage.inputValueIntoFullAddressTextBox(strName);
    }

    public void verifyInputValidValueOnFullAddressTextBox(String invalidValue) {
        auditorSignUpPage.verifyInputInValidValueOnFullAddressTextBox(invalidValue);
    }

    public void inputValueIntoZipCodeTextBox(String strName) {
        auditorSignUpPage.inputValueIntoZipCodeTextBox(strName);
    }

    public void verifyInputValidValueOnZipCodeTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnZipCodeTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoMemberIdTextBox(String strName) {
        auditorSignUpPage.inputValueIntoMemberIdTextBox(strName);
    }

    public void verifyInputValidValueOnMemberIdTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnMemberIdTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoPhoneNumberIdTextBox(String strName) {
        auditorSignUpPage.inputValueIntoPhoneNumberIdTextBox(strName);
    }

    public void verifyInputValidValueOnPhoneNumberIdTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnPhoneNumberIdTextBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoAffiliatedFirmNameTextBox(String strName) {
        auditorSignUpPage.inputValueIntoAffiliatedFirmNameTextBox(strName);
    }

    public void verifyInputValidValueOnAffFirmTextBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnAffFirmTextBox(invalidValue.get(i));
        }
    }

    public void navigateToSignUpPage() {
        marketingPage.clickOnSignupButton();
    }

    public void verifyPersonalSignUpPage() {
        auditorSignUpPage.verifyPersonalInfoPageContent();
    }

    public void registerAuditorPersonal(String strName, String strEmail, String strRoleFirm, String strPhone, String strReference) {
        auditorSignUpPage.registerAuditorPersonal(strName, strEmail, strRoleFirm, strPhone, strReference);
    }

    public void clickOnCheckBoxConfirm() {
        auditorSignUpPage.clickOnCheckBoxConfirm();
    }

    public void inputValueIntoFullNameTexBox(String strName) {
        auditorSignUpPage.inputValueIntoFullNameInput(strName);
    }

    public void verifyInputValidValueOnFullNameTxtBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnFullNameTxtBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoEmailTextBox(String strName) {
        auditorSignUpPage.inputValueIntoEmailTextBox(strName);
    }

    public void verifyInputValidValueOnEmailTxtBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnEmailTxtBox(invalidValue.get(i));
        }
    }

    public void inputValueIntoConfirmEmailTextBox(String strName) {
        auditorSignUpPage.inputValueIntoConfirmEmailTextBox(strName);
    }

    public void verifyInputValidValueOnConfirmEmailTxtBox(String invalidValue) {
        auditorSignUpPage.verifyInputInValidValueOnConfirmEmailTxtBox(invalidValue);
    }

    public void inputValueIntoPhoneNumberTextBox(String strName) {
        auditorSignUpPage.inputValueIntoPhoneNumberTextBox(strName);
    }

    public void verifyInputValidValueOnPhoneNumberTxtBox(List<String> invalidValue) {
        getLogger().info("Size Invalid Data: " + invalidValue.size());
        for (int i = 0; i < invalidValue.size(); i++) {
            auditorSignUpPage.verifyInputInValidValueOnPhoneNumberTxtBox(invalidValue.get(i));
        }
    }

    public void verifySecuritySignUpPage() {
        auditorSignUpPage.verifySecurityInfoPageContent();
    }

    public void createPassword(String strPass) {
        auditorSignUpPage.createPassword(strPass);
    }

    public void verifyCreateInvalidPassword(String password, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber) {
        auditorSignUpPage.verifyCreateInvalidPassword(password, isContainsCapialLetter, isContainsLetter, isContainsNumber);
    }

    public void verifyInputWrongConfirmPassword(String password) {
        auditorSignUpPage.verifyInputWrongConfirmPassword(password);
    }

    public void inputValueIntoPaswordInput(String strName) {
        auditorSignUpPage.inputValueIntoPaswordInput(strName);
    }

    public void inputValueIntoConfirmPaswordInput(String strName) {
        auditorSignUpPage.inputValueIntoConfirmPaswordInput(strName);
    }

    public void verifySuccessSignUpPage() {
        auditorSignUpPage.verifySuccessPageContent();
    }

    public void acceptCreateAccountAuditor() {
        auditorSignUpPage.acceptCreateAccountAuditor();
    }

    public void verifyRegisterNewAuditorUser(String fullName, String strEmail, String password) throws Exception {
        auditorSignUpPage.registerNewAuditorUser(fullName, strEmail, password);
    }

    public void confirmInfomationNewAuditorUser(String fullName, String strEmail, String password) {
        auditorSignUpPage.confirmInfomationNewAuditorUser(fullName, strEmail, password);
    }

    public void verifyCountryList() {
        auditorSignUpPage.verifyCountryList();
    }

    public void selectAnyCountry(String nameOfCountry) {
        auditorSignUpPage.selectAnyCountryInList(nameOfCountry);
    }

    public void verifyCountrySelectedCorrectly(String nameOfCountry) {
        auditorSignUpPage.verifyCountrySelectedCorrectly(nameOfCountry);
    }
    public void verifyStateSelectedCorrectly(String nameOfState){
        auditorSignUpPage.verifyStateSelectedCorrectly(nameOfState);
    }

    public void verifyStateListAfterSelectCountry(String nameOfCountry) {
        auditorSignUpPage.verifyStateListAfterSelectCountry(nameOfCountry);
    }

    public void selectAnyState(String nameOfState){
        auditorSignUpPage.selectAnyStateInList(nameOfState);

    }

    public void verifyMemberID_DefaultValue(){
        auditorSignUpPage.verifyMemberID_DefaultValueIsNull();
        auditorSignUpPage.selectMemberID();
        auditorSignUpPage.verifyMemberID_BorderColor();
    }

    public void inputMemberID(String value){
        auditorSignUpPage.inputMemberID(value);
    }
    public void verifyValidMemberID(String value){
        auditorSignUpPage.verifyValidMemberID(value);
    }
    public void verifyInvalidMemberID(String value){
        auditorSignUpPage.verifyInvalidMemberID(value);
    }
}
