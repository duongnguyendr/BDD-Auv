package com.auvenir.ui.services;

import com.auvenir.ui.pages.common.GmailPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

//import org.testng.log4testng.Logger;

public class GmailLoginService extends AbstractService {
    Logger logger = Logger.getLogger(GmailLoginService.class);
    GmailPage gmailLoginPo = null;

    public GmailLoginService(Logger logger, WebDriver driver) {
        super(logger, driver);
        gmailLoginPo = new GmailPage(getLogger(), getDriver());
    }

//    public void gmailLogin() {
//        try {
//            gmailLoginPo = new GmailPage(getLogger(), getDriver());
//            getDriver().get(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
//            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//            if (gmailLoginPo.getEleEmailIDTxtFld().isDisplayed()) {
//                gmailLoginPo.getEleEmailIDTxtFld()
//                        .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_EMAIL_ID"));
//                gmailLoginPo.getEleNextBtn().click();
//            }
//            Thread.sleep(5000);
//            gmailLoginPo.getElePasswordTxtFld()
//                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "CLIENT_PWD"));
//            gmailLoginPo.getEleSignInBtn().click();
//            Assert.assertTrue(gmailLoginPo.getEleSearchTxtFld().isDisplayed(), "User is not logged into gmail");
//            Thread.sleep(5000);
//            gmailLoginPo.getEleSearchTxtFld()
//                    .sendKeys(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_SEARCHMAIL"));
//            gmailLoginPo.getEleSearchBtn().click();
//            Thread.sleep(5000);
//            gmailLoginPo.getEleInviteMailLnk().click();
//        /*	try{
//                gmailLoginPo.getEleShowTrimBtn().click();
//			}catch(Exception e)
//			{
//
//			}*/
//            gmailLoginPo.getEleStartBtn().click();
//            gmailWindow = getDriver().getWindowHandle();
//            for (String winHandle : getDriver().getWindowHandles()) {
//                getDriver().switchTo().window(winHandle);
//            }
//        } catch (AssertionError e) {
//            NXGReports.addStep("Page not Loaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public void gmailLogin(String gmailAccount, String gmailPwd) throws InterruptedException {
        gmailLoginPo.goGMail();
        gmailLoginPo.signInGmail(gmailAccount, gmailPwd);
    }

    public void selectActiveEmaill() {
        gmailLoginPo.selectActiveEmaill();
    }
    public void selectGetStartBtnToNavigateToAuvenirPage(){
        gmailLoginPo.selectGetStartedButtonInActiveEmail();
    }

    public void selectStartEngagementBtnToNavigateToAuvenirPage(){
        gmailLoginPo.selectStartYourEngagementButtonInActiveEmail();
    }


    public void navigateToResetPwdPage() {
        gmailLoginPo.clickResetPasswordLink();
    }

    public void gmailLogout() throws Exception {
        Thread.sleep(10000);

        getDriver().close();
        getDriver().switchTo().window(gmailWindow);
        gmailLoginPo.getEleProfileIcn().click();
        gmailLoginPo.getEleSignOutBtn().click();
    }

    //////////////////
    public void openGmailIndexForgotPassword(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        gmailLoginPo.goGMail();
        gmailLoginPo.openGmailIndexForgotPassword(email, password);
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */
    public void signInGmail(String email, String password) {
        gmailLoginPo.signInGmail(email, password);
    }

    public void filterEmail() {
        gmailLoginPo.filterEmail();
    }

    public void navigateAuvenirFromInvitationLink() {
        gmailLoginPo.clickToEmailDetail();
        gmailLoginPo.clickOnboardingInvitationLink();
    }



    public void navigateAuvenirFromResetLink() {
        gmailLoginPo.clickToEmailDetail();
        gmailLoginPo.clickResetPasswordLink();
    }

    public void navigateToEmailDetail() {
        gmailLoginPo.clickToEmailDetail();
    }
    /*-----------end of huy.huynh on 02/06/2017.*/

    public void verifyOpenGmailIndexRegisterAccount(String strEmail, String strPassword) {
        gmailLoginPo.goGMail();
        gmailLoginPo.openGmailIndexRegisterAccount(strEmail, strPassword);
    }

    public void deleteAllExistedEmail(String userName, String pwd) {
        deleteAllExistedGMail(userName, pwd);
    }

    public void deleteAllExistedEmailUseAnotherAccount(String userName, String pwd){
        deleteAllExistedGmailUseAnotherAccount(userName,pwd);
    }

    public void gmailReLogin(String gmailPwd) throws InterruptedException {
        gmailLoginPo.goGMail();
        gmailLoginPo.reSignInGmail(gmailPwd);
    }

    public void gmailReLoginUseAnotherAccount(String user, String pwd){
        gmailLoginPo.goGMail();
        reLoginUseAnotherAccount(user,pwd);
    }


    public void verifyNoEmailToCSTeamInbox() throws InterruptedException {
        gmailLoginPo.verifyNoEmailToCSTeam();
    }
    /**
     * Refactored by huy.huynh on 26/06/2017.
     * Refactor GeneralClientTest
     */
    public void verifyHeaderImage(String partialSrc) {
        gmailLoginPo.verifyHeaderImage(partialSrc);
    }

    public void verifyGreetingTitle(String text) {
        gmailLoginPo.verifyGreetingTitle(text);
    }

    public void verifyAnnouncementTitle(String text) {
        gmailLoginPo.verifyAnnouncementTitle(text);
    }

    public void verifyAuvenirIntroducingTitle(String text) {
        gmailLoginPo.verifyAuvenirIntroducingTitle(text);
    }

    public void verifyIntroducingBenefitTitle(String text) {
        gmailLoginPo.verifyIntroducingBenefitTitle(text);
    }

    public void verifyFirstBenefitTitle(String text) {
        gmailLoginPo.verifyFirstBenefitTitle(text);
    }

    public void verifySecondBenefitTitle(String text) {
        gmailLoginPo.verifySecondBenefitTitle(text);
    }

    public void verifyThirdBenefitTitle(String text) {
        gmailLoginPo.verifyThirdBenefitTitle(text);
    }

    public void verifyFeedbackTitle(String text) {
        gmailLoginPo.verifyFeedbackTitle(text);
    }

    public void verifyGoodbyeTitle(String text) {
        gmailLoginPo.verifyGoodbyeTitle(text);
    }

    public void clickOnboardingInvitationLink() {
        gmailLoginPo.clickOnboardingInvitationLink();
    }

    /*-----------end of huy.huynh on 26/06/2017.*/
}
