package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.admin.AdminPage;
import com.auvenir.ui.pages.marketing.AuditorSignUpPage;
import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 5/25/2017.
 */
public class MarketingService extends AbstractService {
    MarketingPage marketingPage;
    AuditorSignUpPage auditorSignUpPage;
    AdminPage adminPage;

    public MarketingService(Logger logger, WebDriver driver) {
        super(logger, driver);
        marketingPage = new MarketingPage(getLogger(), getDriver());
        auditorSignUpPage = new AuditorSignUpPage(getLogger(), getDriver());
        adminPage = new AdminPage(getLogger(), getDriver());
    }

    public void verifyAboutContentPage() {
        marketingPage.verifyAboutContentPage();
    }

    public void goToCareersPage() {
        marketingPage.goToCareersPage();
    }

    public void verifyCareersContentPage() {
        marketingPage.verifyCareersContentPage();
    }

    public void verifyAboutContactPage() {
        marketingPage.verifyContactContentPage();
    }

    public void verifyCookiesNoticeContentPage() {
        marketingPage.verifyCookiesNoticeContentPage();
    }

    public void closeForgotPasswordDialog() {
        marketingPage.clickOnLoginBTN();
    }

    public void openLoginDialog() {
        marketingPage.clickOnLoginBTN();
    }

    public void loginWithUserNamePassword(String UserName, String Password) {
        getLogger().info("Input Username and Password.");
        marketingPage.inputUserNamePassword(UserName, Password);
        getLogger().info("Click on Login button.");
        marketingPage.clickOnSubmitBTN();
        marketingPage.waitForProgressOverlayIsClosed();
        adminPage.clickClosePopupWarningBrowser();
    }

    public void logout() {
        marketingPage.clickOnProfile();
        getLogger().info("Logout.");
        marketingPage.waitSomeSeconds(5);
        marketingPage.clickOnLogoutBTN();
    }

    public void deleteAllCookies() {
        marketingPage.deleteAllCookies();
    }

    public void deleteCookieName(String cookieName) {
        marketingPage.deleteCookieName(cookieName);
    }

    public void deleteAllCookieName(){
        marketingPage.deleteCookieName("_ga");
        marketingPage.deleteCookieName("_gat");
        marketingPage.deleteCookieName("_gid");
        marketingPage.deleteCookieName("_hjIncludedInSample");
        marketingPage.deleteCookieName("connect.sid");
        marketingPage.deleteCookieName("io");
    }

    public void refreshHomePage() {
        marketingPage.refreshPage();
    }

    public void verifyLoginBTN() {
        marketingPage.verifyLoginBTN();
    }

    public void verifySignUpBTN() {
        marketingPage.verifySignUpBTN();
    }

    public void verifyLogoutBTNIsNotPresented() {
        marketingPage.verifyLogoutBTNIsNotPresented();
    }

    public void verifyColorUserNameTxtBox() {
        marketingPage.verifyColorUserNameTxtBox();
    }

    public void verifyColorPasswordTxtBox() {
        marketingPage.verifyColorPasswordTxtBox();
    }

    public void verifyErrorLoginMessage(String messsage) {
        marketingPage.verifyErrorLoginMessage(messsage);
    }

    public void verifyColorErrorLoginMessage(String attributeName, String attributeValue) {
        marketingPage.verifyColorErrorLoginMessage(attributeName, attributeValue);
    }

    public void deleteGmail(String emailAddress, String password) {
        deleteAllExistedGMail(emailAddress, password);
    }

    public void goToForgotPassword() {
        marketingPage.clickOnForgotPasswordLink();
    }

    public void verifyForgotPasswordTitle() {
        marketingPage.verifyForgotPasswordTitle();
    }

    public void inputEmailForgotPassword(String text) {
        marketingPage.inputEmailForgotPassword(text);
    }

    public void clickOnRequestResetLinkBTN() throws InterruptedException {
        marketingPage.clickOnRequestResetLinkBTN();
        //marketingPage.waitPageLoad();
        //marketingPage.waitForResetLinkSent();
    }

    public void verifyColorEmailForgotPasswordTextBox(String attributeName, String attributeValue) {
        marketingPage.verifyColorEmailForgotPasswordTextBox(attributeName, attributeValue);
    }

    public void verifyColorEmailForgotPasswordMessage(String attributeName, String attributeValue) {
        marketingPage.verifyColorEmailForgotPasswordMessage(attributeName, attributeValue);
    }

    public void verifyGUIEmailForgotPasswordTextBox() {
        //marketingPage.verifyColorEmailForgotPasswordTextBox("border-color",sBorderColorValue);
        marketingPage.verifyColorEmailForgotPasswordTextBox("background-color","rgba(241, 103, 57, 0.2)");
    }

    public void verifyGUIEmailForgotPasswordMessage() {
        marketingPage.verifyColorEmailForgotPasswordMessage("background-color","rgba(255, 246, 246, 1)");
        marketingPage.verifyColorEmailForgotPasswordMessage("color","rgba(159, 58, 56, 1)");
    }

    public void verifyContentEmailForgotPasswordMessage(String text) {
        marketingPage.verifyContentEmailForgotPasswordMessage(text);
    }

    public void verifyHomeContentPage() {
        marketingPage.verifyHomeContentPage();
    }

    public void goToAboutPage() {
        marketingPage.goToAboutPage();
    }

    public void goToContactPage() {
        marketingPage.goToContactPage();
    }

    public void goToCookiesNoticePage() {
        marketingPage.goToCookiesNoticePage();
    }

    public void goToPrivacyPolicyPage() {
        marketingPage.goToPrivacyPolicyPage();
    }

    public void goToTermsOfService() {
        marketingPage.goToTermOfService();
    }

    public void verifyPrivacyPolicyContentPage() {
        marketingPage.verifyPrivacyPolicyContentPage();
    }

    public void verifyTermsContentPage() {
        marketingPage.verifyTermsContentPage();
    }

    /*
Vien.Pham added login With New User Role
*/
    public void loginWithNewUserRole(String userEmail, String usePwd) {
        loginWithUserNamePassword(userEmail, usePwd);
    }


    public void verifyResetPassword(String newPass, String retypeResetPass) {
        marketingPage.resetPassword(newPass, retypeResetPass);
    }

    public void verifyNewPassword(String newPassword) {
        marketingPage.setNewPassword(newPassword);
    }

    public void setConfirmPassword(String confirmPassword) {
        marketingPage.setConfirmPassword(confirmPassword);
    }

    public void verifyPopupWarning(String passwordString, boolean isContainsCapialLetter, boolean isContainsLetter, boolean isContainsNumber) {
        auditorSignUpPage.verifyCreateInvalidPassword(passwordString, isContainsCapialLetter, isContainsLetter, isContainsNumber);
    }

    public void verifyEnterRenewPassword(String passwordString) {
        auditorSignUpPage.verifyInputWrongConfirmPassword(passwordString);
    }

    public void exitClick() {
        marketingPage.exit();
    }

    /**
     * Added by huy.huynh on 19/06/2017.
     * Scenarios : SmokeTest R2
     * Vien.Pham seperated 3 funtions of Login as aTan suggestion.
     */

    public void goToAuvenirMarketingPageURL() {
        goToBaseURL();
    }

    public void selectLoginBtn() {
        openLoginDialog();
    }

    public void selectForgotPwd(){
        marketingPage.clickOnForgotPasswordLink();
    }

    public void verifyResetPasswordTitle(){
        marketingPage.verifyResetPasswordPageTitle();
    }

    public void loginWithUserPwd(String username, String pwd) {
        loginWithUserNamePassword(username, pwd);
    }

    public void loginUsingUsernamePassword(String username, String password) {
        goToBaseURL();
        openLoginDialog();
        loginWithUserNamePassword(username, password);
    }


    /**
     * -----end of huy.huynh 19/06/2017.-----
     */

    /**
     * Add new by huy.huynh on 29/06/2017.
     * R2.1 NewFeature
     */
    public void verifyResetPasswordPageTitle() {
        marketingPage.verifyResetPasswordPageTitle();
    }

    public void fillUpAndConfirmPassword(String password) {
        marketingPage.fillUpAndConfirmPassword(password);
    }
    /*-----------end of huy.huynh on 29/06/2017.*/

    /*
    *VienPham add new input reset pwd
    * R2.1
     */
    public void inputNewResetPassword(String newPwd, String position) throws InterruptedException {
        marketingPage.inputNewResetPassword(newPwd, position);
    }

    public void verifyInvalidPwdWarning(String position){
        marketingPage.verifyInvalidPasswordWarning(position);
    }

    public void verifyValidPwd(String position){
        marketingPage.verifyValidPassword(position);
    }
    public void selectSetPasswordBtn(){
        marketingPage.selectSetPasswordBtn();
    }

    public void verifyNewPasswordErrorMessage(){
        marketingPage.verifyNewPasswordErrorMessage();
    }

    public void verifyConfirmPasswordErrorMessage(){
        marketingPage.verifyConfirmPasswordErrorMessage();

    }

    public void verifyBambooContentPage(){
        marketingPage.verifyBambooContentPage();
    }

    public void loginWithUsernamePassword(String adminUser, String adminPassword) {
    }
}
