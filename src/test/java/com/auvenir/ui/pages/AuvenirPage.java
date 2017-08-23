package com.auvenir.ui.pages;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class AuvenirPage extends AbstractPage {
    Actions actions = null;

    public AuvenirPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//img[@class='header-auvenirLogo']")
    private WebElement auvenirLogoImgEle;

    public WebElement getAuvenirLogoImgEle() {
        return auvenirLogoImgEle;
    }

    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.svg']")
    private WebElement auvenirImgEle;

    public WebElement getAuvenirImgEle() {
        return auvenirImgEle;
    }

    @FindBy(xpath = "//span[@id='dashboardUsername']")
    private WebElement userNameTextEle;

    public WebElement getUserNameTextEle() {
        return userNameTextEle;
    }

    @FindBy(xpath = "//span[@id='dashboardUsername']//..//i")
    private WebElement eleUserNameDropDownImg;

    public WebElement getEleUserNameDropDownImg() {
        return eleUserNameDropDownImg;
    }

    @FindBy(xpath = "//div[@id='h-f-inbox-dropdown']")
    private WebElement eleInboxImg;

    public WebElement getEleInboxImg() {
        return eleInboxImg;
    }

    @FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
    private WebElement eleNotificationImg;

    public WebElement getEleNotificationImg() {
        return eleNotificationImg;
    }


    @FindBy(xpath = "//span[@id='dropdownPicInitials']")
    private WebElement eleInitialsTxt;

    public WebElement getEleInitialsTxt() {
        return eleInitialsTxt;
    }

    @FindBy(xpath = "//span[@id='dropdownUsername'][@class='au-dropdown-username']")
    private WebElement eleUsernameDropDownTxt;

    public WebElement getEleUsernameDropDownTxt() {
        return eleUsernameDropDownTxt;
    }

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement eleSettingsLnk;

    public WebElement getEleSettingsLnk() {
        return eleSettingsLnk;
    }

    @FindBy(xpath = "//a[text()='Sign Out']")
    private WebElement eleSignOutLnk;

    public WebElement getEleSignOutLnk() {
        return eleSignOutLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]//span")
    private WebElement eleCareersImg;

    public WebElement getEleCareersImg() {
        return eleCareersImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement eleCareersLnk;

    public WebElement getEleCareersLnk() {
        return eleCareersLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]//span")
    private WebElement eleSupportImg;

    public WebElement getEleSupportImg() {
        return eleSupportImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    private WebElement eleSupportLnk;

    public WebElement getEleSupportLnk() {
        return eleSupportLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]//span")
    private WebElement eleLocatorImg;

    public WebElement getEleLocatorImg() {
        return eleLocatorImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Toronto, ON, Canada')]")
    private WebElement eleTorontoCanadaLnk;

    public WebElement getEleTorontoCanadaLnk() {
        return eleTorontoCanadaLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]//span")
    private WebElement elePhoneImg;

    public WebElement getElePhoneImg() {
        return elePhoneImg;
    }

    @FindBy(xpath = "//a[contains(text(),'+1-855-528-8364')]")
    private WebElement elePhoneNumberLnk;

    public WebElement getElePhoneNumberLnk() {
        return elePhoneNumberLnk;
    }

    @FindBy(xpath = "//a[@href='https://www.facebook.com/auvenir']")
    private WebElement facebookImgEle;

    public WebElement getFacebookImgEle() {
        return facebookImgEle;
    }

    @FindBy(xpath = "//a[@href='https://twitter.com/auvenir']")
    private WebElement twitterImgEle;

    public WebElement getTwitterImgEle() {
        return twitterImgEle;
    }

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/10419712']")
    private WebElement linkedinImgEle;

    public WebElement getLinkedinImgEle() {
        return linkedinImgEle;
    }

    @FindBy(xpath = "//div[@class='ui header copyright-footer']")
    private WebElement allRightsReservedTxtEle;

    public WebElement getAllRightsReservedTxtEle() {
        return allRightsReservedTxtEle;
    }

    @FindBy(xpath = "//a[@href='/terms']")
    private WebElement termsOfServiceLnkEle;

    public WebElement getTermsOfServiceLnkEle() {
        return termsOfServiceLnkEle;
    }

    @FindBy(xpath = "//a[@href='/privacy']")
    private WebElement privacyStatementLnkEle;

    public WebElement getPrivacyStatementLnkEle() {
        return privacyStatementLnkEle;
    }

    @FindBy(xpath = "//a[@href='/cookies']")
    private WebElement cookieLnkEle;

    public WebElement getCookieLnkEle() {
        return cookieLnkEle;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/terms']")
    private WebElement eleTermsOfUserFtrLnk;

    public WebElement getEleTermsOfUserFtrLnk() {
        return eleTermsOfUserFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/privacy']")
    private WebElement elePrivacyPolicyFtrLnk;

    public WebElement getElePrivacyPolicyFtrLnk() {
        return elePrivacyPolicyFtrLnk;
    }

    @FindBy(xpath = "//div[@class='pull-right']//a[@href='/cookies']")
    private WebElement eleCookieNoticeFtrLnk;

    public WebElement getEleCookieNoticeFtrLnk() {
        return eleCookieNoticeFtrLnk;
    }

    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Terms of Service ']")
    private WebElement eleTOSTitleTxt;

    public WebElement getEleTOSTitleTxt() {
        return eleTOSTitleTxt;
    }

    @FindBy(xpath = "//div[@id='agreement']/h3[text()='Effective: 16th January, 2017']")
    private WebElement eleEffectiveTxt;

    public WebElement getEleEffectiveTxt() {
        return eleEffectiveTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'These Terms of Service')]")
    private WebElement eleTheseTermsTxt;

    public WebElement getEleTheseTermsTxt() {
        return eleTheseTermsTxt;
    }

    @FindBy(xpath = "//a[@href='mailto:info@auvenir.com']")
    private WebElement eleContactInfoLnk;

    public WebElement getEleContactInfoLnk() {
        return eleContactInfoLnk;
    }

    @FindBy(xpath = "//a[text()='deloitte.com/about']")
    private WebElement eleVisitDeloitteLnk;

    public WebElement getEleVisitDeloitteLnk() {
        return eleVisitDeloitteLnk;
    }

    @FindBy(xpath = "//a[@href='/privacy']")
    private WebElement elePrivacyStatementLnk;

    public WebElement getElePrivacyStatementLnk() {
        return elePrivacyStatementLnk;
    }

    @FindBy(xpath = "//a[@href='http://www.aboutcookies.org/']")
    private WebElement eleAboutCookiesLnk;

    public WebElement getEleAboutCookiesLnk() {
        return eleAboutCookiesLnk;
    }

    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Privacy Statement ']")
    private WebElement elePrivacyTitleTxt;

    public WebElement getElePrivacyTitleTxt() {
        return elePrivacyTitleTxt;
    }

    @FindBy(xpath = "//a[@id='english']")
    private WebElement eleEnglishFrenchTxt;

    public WebElement getEleEnglishFrenchTxt() {
        return eleEnglishFrenchTxt;
    }

    @FindBy(xpath = "//div[@id='agreement']/h3[text()='Last revised: January 16th, 2017']")
    private WebElement eleLastRevisedTxt;

    public WebElement getEleLastRevisedTxt() {
        return eleLastRevisedTxt;
    }

    @FindBy(xpath = "//h3[text()='INTRODUCTION']")
    private WebElement eleIntroductionTxt;

    public WebElement getEleIntroductionTxt() {
        return eleIntroductionTxt;
    }

    @FindBy(xpath = "//a[@href='/cookies']")
    private WebElement elePrivacyCookiesLnk;

    public WebElement getElePrivacyCookiesLnk() {
        return elePrivacyCookiesLnk;
    }

    @FindBy(xpath = "//a[@href='/terms']")
    private WebElement elePrivacyTOSLnk;

    public WebElement getElePrivacyTOSLnk() {
        return elePrivacyTOSLnk;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir uses cookies to improve')]")
    private WebElement eleAuvenirUsesTxt;

    public WebElement getEleAuvenirUsesTxt() {
        return eleAuvenirUsesTxt;
    }

    @FindBy(xpath = "//h2[@class='terms-title'][text()=' Cookie Notice ']")
    private WebElement eleCookieNoticeTitleTxt;

    public WebElement getEleCookieNoticeTitleTxt() {
        return eleCookieNoticeTitleTxt;
    }

    @FindBy(xpath = "//button[@class='ui large basic inverted button btn-login']")
    private WebElement auditorLoginLnkEle;

    public WebElement getAuditorLoginLnkEle() {
        return auditorLoginLnkEle;
    }

    @FindBy(id = "aud-loginChevron")
    private WebElement eleAuditorLoginImg;

    public WebElement getEleAuditorLoginImg() {
        return eleAuditorLoginImg;
    }

    @FindBy(xpath = "//h1[contains(text(),'We help you Audit Smarter.')]")
    private WebElement weHelpYouAuditTxtEle;

    public WebElement getWeHelpYouAuditTxtEle() {
        return weHelpYouAuditTxtEle;
    }

    @FindBy(xpath = "//a[contains(text(),'Join as an Auditor Today')]")
    private WebElement joinAsAuditorTodayTxt;

    public WebElement getJoinAsAuditorTodayTxt() {
        return joinAsAuditorTodayTxt;
    }

    @FindBy(xpath = "//input[@placeholder='Type work email address']")
    private WebElement eleWorkEmailTxt;

    public WebElement getEleWorkEmailTxt() {
        return eleWorkEmailTxt;
    }

    @FindBy(id = "emailField")
    private WebElement eleAuditorEmailAddressTxtFld;

    public WebElement getEleAuditorEmailAddressTxtFld() {
        return eleAuditorEmailAddressTxtFld;
    }

    @FindBy(xpath = "//li[text()='Not a valid email address']")
    private WebElement eleNotValidEmailTxt;

    public WebElement getEleNotValidEmailTxt() {
        return eleNotValidEmailTxt;
    }

    //@FindBy(id="audLandMainBtn")
    @FindBy(xpath = "//button[contains(text(),'Join')]")
    private WebElement eleJoinBtn;

    public WebElement getEleJoinBtn() {
        return eleJoinBtn;
    }
    @FindBy(xpath = "//p[@class='audLand-jb-footTxt']")
    private WebElement eleBySigningUpTxt;

    public WebElement getEleBySigningUpTxt() {
        return eleBySigningUpTxt;
    }

    @FindBy(xpath = "//img[@src='images/timeClock.svg']")
    private WebElement eleSpendLessTimeClockImg;

    public WebElement getEleSpendLessTimeClockImg() {
        return eleSpendLessTimeClockImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Spend Less Time')]")
    private WebElement eleSpendLessTimeTxt;

    public WebElement getEleSpendLessTimeTxt() {
        return eleSpendLessTimeTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Use sophisticated')]")
    private WebElement eleUseSophisticatedTxt;

    public WebElement getEleUseSophisticatedTxt() {
        return eleUseSophisticatedTxt;
    }

    @FindBy(xpath = "//img[@src='images/graphCut.svg']")
    private WebElement eleDevelopDeeperImg;

    public WebElement getEleDevelopDeeperImg() {
        return eleDevelopDeeperImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Develop Deeper')]")
    private WebElement eleDevelopDeeperTxt;

    public WebElement getEleDevelopDeeperTxt() {
        return eleDevelopDeeperTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Leverage machine')]")
    private WebElement eleLeverageMachineTxt;

    public WebElement getEleLeverageMachineTxt() {
        return eleLeverageMachineTxt;
    }

    @FindBy(xpath = "//img[@src='images/blackLock.svg']")
    private WebElement eleSecurelyManageImg;

    public WebElement getEleSecurelyManageImg() {
        return eleSecurelyManageImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Securely Manage')]")
    private WebElement eleSecurelyManageTxt;

    public WebElement getEleSecurelyManageTxt() {
        return eleSecurelyManageTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Access a cloud')]")
    private WebElement eleAccessACloudTxt;

    public WebElement getEleAccessACloudTxt() {
        return eleAccessACloudTxt;
    }

    @FindBy(xpath = "//img[@src='images/featuresTech.svg']")
    private WebElement elePersonalizedForYouImg;

    public WebElement getElePersonalizedForYouImg() {
        return elePersonalizedForYouImg;
    }

    @FindBy(xpath = "//h2[contains(text(),'Personalized for you')]")
    private WebElement elePersonalizedForYouTxt;

    public WebElement getElePersonalizedForYouTxt() {
        return elePersonalizedForYouTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Customize Schedules')]")
    private WebElement eleCustomizeSchedulesTxt;

    public WebElement getEleCustomizeSchedulesTxt() {
        return eleCustomizeSchedulesTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Access and Manage')]")
    private WebElement eleAccessAndManageTxt;

    public WebElement getEleAccessAndManageTxt() {
        return eleAccessAndManageTxt;
    }

    @FindBy(xpath = "//li[contains(text(),'Store All ')]")
    private WebElement eleStoreAllTxt;

    public WebElement getEleStoreAllTxt() {
        return eleStoreAllTxt;
    }

    @FindBy(xpath = "//img[@id='footerLogo'][@src='images/logo.svg']")
    private WebElement eleAuvenirFooterImg;

    public WebElement getEleAuvenirFooterImg() {
        return eleAuvenirFooterImg;
    }

    @FindBy(id = "intercom-container-body")
    private WebElement eleIntercomLauncherIcn;

    public WebElement getEleIntercomLauncherIcn() {
        return eleIntercomLauncherIcn;
    }

    @FindBy(xpath = "//img[@src='images/illustrations/login.svg']")
    private WebElement eleMailImg;

    public WebElement getEleMailImg() {
        return eleMailImg;
    }

    @FindBy(xpath = "//h2[contains(text(),'Check your')]")
    private WebElement eleCheckYourEmailTxt;

    public WebElement getEleCheckYourEmailTxt() {
        return eleCheckYourEmailTxt;
    }

    @FindBy(xpath = "//h2[contains(text(),'Awaiting approval!')]")
    private WebElement eleAwaitingApprovalTxt;

    public WebElement getEleAwaitingApprovalTxt() {
        return eleAwaitingApprovalTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'We sent')]")
    private WebElement eleWeSentTxt;

    public WebElement getEleWeSentTxt() {
        return eleWeSentTxt;
    }

    @FindBy(id = "audLandModalDoneBtn")
    private WebElement eleDoneBtn;

    public WebElement getEleDoneBtn() {
        return eleDoneBtn;
    }

    @FindBy(xpath = "//h3[contains(text(),'Welcome! Please check')]")
    private WebElement eleWelcomePleaseCheckTxt;

    public WebElement getEleWelcomePleaseCheckTxt() {
        return eleWelcomePleaseCheckTxt;
    }

    @FindBy(xpath = "//div[@id='login-popup']//div[@class='ui error message']/div/p")
    private WebElement waitVerificationTxtEle;

    public WebElement getWaitVerificationTxtEle() {
        return waitVerificationTxtEle;
    }

    @FindBy(xpath = "//h3[contains(text(),'Welcome! Please check')]//..//..//button[contains(text(),'×')]")
    private WebElement eleCloseBtn;

    public WebElement getEleCloseBtn() {
        return eleCloseBtn;
    }

    @FindBy(xpath = "//div[@id='login-popup']//label[contains(text(),'Email Address')]")
    private WebElement emailAddressTxtEle;

    public WebElement getEmailAddressTxtEle() {
        return emailAddressTxtEle;
    }

    @FindBy(xpath = "//div[@id='login-popup']//input[@name='email']")
    private WebElement emailAddressFieldEle;

    public WebElement getEmailAddressFieldEle() {
        return emailAddressFieldEle;
    }

    @FindBy(id = "audLand-dd-loginBtn")
    private WebElement eleGoBtn;

    public WebElement getEleGoBtn() {
        return eleGoBtn;
    }

    @FindBy(xpath="//img[@src='static/images/home/macbook-pro.png']")
    private WebElement imgMacbookHomePage;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeLinkEle;

    @FindBy(xpath="//a[@href='/about']")
    private WebElement aboutLinkEle;

    @FindBy(xpath="//a[@href='/contact']")
    private WebElement contactLinkEle;

    @FindBy(xpath = "//div[@id='login-popup']//label[contains(text(),'Password')]")
    private WebElement passwordTxtEle;

    @FindBy(xpath = "//div[@id='login-popup']//input[@name = 'password']")
    private WebElement passwordFieldEle;

    @FindBy(xpath = "//div[@id='login-popup']//a[contains(text(),'Forgot Password?')]")
    private WebElement forgotPasswordLinkEle;

    @FindBy(xpath = "//div[@id='login-popup']//button[contains(text(),'Login')]")
    private WebElement loginButtonEle;

    @FindBy(xpath="//span[@id='h-engagementsLink']")
    private WebElement engagementLink;

    @FindBy(xpath="//span[@id='h-clientListLink']")
    private WebElement contactLink;

    @FindBy(xpath = "//div[@id='h-ddl-item-settings']/a")
    private WebElement settingLink;

    @FindBy(xpath = "//a[@id='h-ddl-signOut']")
    private WebElement signOutLink;

    @FindBy(xpath="//div[@id='preview-footer']//div[@class='pull-left']/span")
    private WebElement engagementAuvenirAllRights;

    /**
     * Refactored by huy.huynh on 24/05/2017.
     * Restructure only
     * Updated by Minh Nguyen on June 27, 2017
     */
    public void verifyHeader() {
        boolean isAuvenirLogoImgEle, isEngagementLink, isContactLink, isUserNameTextEle, isSettingLink, isSignOutLink = false;
        isAuvenirLogoImgEle = validateDisPlayedElement(auvenirLogoImgEle, "Auvenir Logo Image");
        isEngagementLink = validateDisPlayedElement(engagementLink, "Engagement link");
        isContactLink = validateDisPlayedElement(contactLink, "Contact link");
        isUserNameTextEle = clickElement(userNameTextEle, "click to userNameTextEle");
        isSettingLink = validateDisPlayedElement(settingLink, "Setting link");
        isSignOutLink = validateDisPlayedElement(signOutLink, "Sign Out link");
        if(isAuvenirLogoImgEle && isEngagementLink && isContactLink && isUserNameTextEle && isSettingLink && isSignOutLink)
        {
            NXGReports.addStep("Verify the header of list engagement page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the header of list engagement page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by Minh Nguyen on June 26, 2017
     */
    public void verifyFooterOfHomepage() {
        try {
            boolean isHomeLinkEle,isAboutLinkEle, isContactLinkEle,isTermsOfServiceLnk, isPrivacyStatementLnk, isCookieLnk, isFacebookImg, isTwitterImg, isLinkedinImg, isAllRightsReserved = false;
            isHomeLinkEle = validateDisPlayedElement(homeLinkEle, "Home link");
            if(!isHomeLinkEle)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Home link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isAboutLinkEle = validateDisPlayedElement(aboutLinkEle, "About link");
            if(!isAboutLinkEle)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the About link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isContactLinkEle = validateDisPlayedElement(contactLinkEle, "Contact link");
            if(!isContactLinkEle)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Contact link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isTermsOfServiceLnk = validateDisPlayedElement(termsOfServiceLnkEle, "Terms of Service - Link");
            if(!isTermsOfServiceLnk)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Term Of Service link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isPrivacyStatementLnk = validateDisPlayedElement(privacyStatementLnkEle, "Privacy Statement - Link");
            if(!isPrivacyStatementLnk)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Privacy Statement link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isCookieLnk = validateDisPlayedElement(cookieLnkEle, "Cookie Notice footer - Link");
            if(!isCookieLnk)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Cookie link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isFacebookImg = validateDisPlayedElement(facebookImgEle, "Facebook Image");
            if(!isFacebookImg)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Facebook image displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isTwitterImg = validateDisPlayedElement(twitterImgEle, "Twitter Image");
            if(!isTwitterImg)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Twitter image displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            isLinkedinImg = validateDisPlayedElement(linkedinImgEle, "Linkedin Image");
            if(!isLinkedinImg)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the Linkedin image displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            validateDisPlayedElement(allRightsReservedTxtEle, "All Rights Reserversd - Text");
            String allRightsReservedText = allRightsReservedTxtEle.getText();
            if(allRightsReservedText.equals("© 2017 Auvenir, All Rights reserved."))
            {
                isAllRightsReserved = true;
            }
            if(!isAllRightsReserved)
            {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the All Right Reserved text displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            if(isHomeLinkEle && isAboutLinkEle && isContactLinkEle && isTermsOfServiceLnk && isPrivacyStatementLnk && isCookieLnk && isFacebookImg && isTwitterImg && isLinkedinImg && isAllRightsReserved)
            {
                NXGReports.addStep("Verify the Footer of Home page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the Footer of Home page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by Minh Nguyen on June 26, 2017
     */
    public void verifyBodyHomePage() {
        boolean isAuvenirImg, isAuditorLoginLnk, isWeHelpYouAuditTxt, isJoinAsAuditorTodayTxt, isImgMacbookHomePage = false;
        isAuvenirImg = validateDisPlayedElement(auvenirImgEle, "Auvenir Header Logo Image");
        if(!isAuvenirImg)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auvenir Imge displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isAuditorLoginLnk = validateDisPlayedElement(auditorLoginLnkEle, "Auditor Login Link");
        if(!isAuditorLoginLnk)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Login Link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isWeHelpYouAuditTxt = validateDisPlayedElement(weHelpYouAuditTxtEle, "We help you Audit Smarter.");
        if(!isWeHelpYouAuditTxt)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify We Help You Audit text displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

        isJoinAsAuditorTodayTxt = validateDisPlayedElement(joinAsAuditorTodayTxt, "Join the Waitlist Text");
        if(!isJoinAsAuditorTodayTxt)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Join As Auditor Today text displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isImgMacbookHomePage = validateDisPlayedElement(imgMacbookHomePage, "Macbook home page image");
        if(!isImgMacbookHomePage)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Macbook Home Page image displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        if(isAuvenirImg && isAuditorLoginLnk && isWeHelpYouAuditTxt && isJoinAsAuditorTodayTxt && isImgMacbookHomePage)
        {
            NXGReports.addStep("Verify the body of Home Page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by Minh Nguyen on June 27, 2017
     */
    public void verifyFormLogin() {
        boolean isAuditorLoginLnk, isEmailAddressTxt, isEmailAddressField, isPasswordTxt, isPasswordField, isForgotPasswordLink, isLoginButton = false;
        isAuditorLoginLnk = clickElement(auditorLoginLnkEle, "Auditor Login Link");
        if(!isAuditorLoginLnk)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Login Link click able", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isEmailAddressTxt = validateDisPlayedElement(emailAddressTxtEle, "Email Address Text");
        if(!isEmailAddressTxt)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Email Address Text displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isEmailAddressField = validateDisPlayedElement(emailAddressFieldEle, "Email Address PopUp Text Field");
        if(!isEmailAddressField)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Email Address Field displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isPasswordTxt = validateDisPlayedElement(passwordTxtEle, "Password text");
        if(!isPasswordTxt)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Password text displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isPasswordField = validateDisPlayedElement(passwordFieldEle, "Password field");
        if(!isPasswordField)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Password field displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isForgotPasswordLink = validateDisPlayedElement(forgotPasswordLinkEle, "Forgot password link");
        if(!isForgotPasswordLink)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Forgot Password link displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isLoginButton = validateEnabledElement(loginButtonEle, "Login button");
        if(!isLoginButton)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Login Button enabled", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        if(isAuditorLoginLnk && isEmailAddressTxt && isEmailAddressField && isPasswordTxt && isPasswordField && isForgotPasswordLink && isLoginButton)
        {
            NXGReports.addStep("Verify Login Form", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Refactored by Minh Nguyen on June 27, 2017
     */
    public void verifyLoginWithEmail(String email) {
        boolean isEmailAddressField, isLoginButton, isWaitVerificationTxt = false;
        isEmailAddressField = sendKeyTextBox(emailAddressFieldEle, email, "Email Address PopUp Text Field");
        if(!isEmailAddressField)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify send key to Email Address Field", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isLoginButton = clickElement(loginButtonEle, "click to Login button");
        if(!isLoginButton)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click able to Login Button", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isWaitVerificationTxt = validateElementText(waitVerificationTxtEle, "Email or password can't be empty!");
        if(!isWaitVerificationTxt)
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Verification text visible", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        if(isEmailAddressField && isLoginButton && isWaitVerificationTxt)
        {
            NXGReports.addStep("Verify login with email", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyApprovePopupDisplayed() {
        boolean isPopupDisplayed = false;
        isPopupDisplayed = validateDisPlayedElement(getEleAwaitingApprovalTxt(), "Approve popup");
        if (isPopupDisplayed) {
            NXGReports.addStep("Awaiting approval popup is successfully displayed.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Awaiting approval popup is successfully displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        clickElement(getEleDoneBtn(), "Awaiting Approval popup");
    }

    public void verifyFooterPage() {
        boolean istermsOfServiceLnkEle, isprivacyStatementLnkEle, iscookieLnkEle, isAllRightsReserved = false;
        istermsOfServiceLnkEle = validateDisPlayedElement(termsOfServiceLnkEle, "Terms of Service - Link");
        isprivacyStatementLnkEle = validateDisPlayedElement(privacyStatementLnkEle, "Privacy Statement - Link");
        iscookieLnkEle = validateDisPlayedElement(cookieLnkEle, "Cookie Notice footer - Link");
        validateDisPlayedElement(engagementAuvenirAllRights, "All Rights Reserversd - Text");
        String allRightsReservedText = engagementAuvenirAllRights.getText();
        if (allRightsReservedText.trim().equals("© 2017 Auvenir Inc. All rights reserved.")) {
            isAllRightsReserved = true;
        }
        if (istermsOfServiceLnkEle && isprivacyStatementLnkEle && iscookieLnkEle && isAllRightsReserved)
        {
            NXGReports.addStep("Verify footer of engagement page.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify footer of engagement page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickMessageBoxIcon() {
        visibilityOfElementWait(getEleInboxImg(), "Inbox Icon", 20);
        getEleInboxImg().click();
    }

    public void clickNotiticationIcon() {
        visibilityOfElementWait(getEleNotificationImg(), "Inbox Icon", 20);
        getEleNotificationImg().click();
    }

    public void clickTermsOfServiceLink() {
        getEleTermsOfUserFtrLnk().click();
    }

    public void verifyTermsOfServicePage() {
        validateDisPlayedElement(getEleTOSTitleTxt(), "Terms of Service - Text");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleEffectiveTxt(), "Effective: 16th Jan  - Text");
        validateDisPlayedElement(getEleTheseTermsTxt(), "These terms of service  - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getEleVisitDeloitteLnk(), "Visit DEloitte - Link");
        validateDisPlayedElement(getElePrivacyStatementLnk(), "Privacy Statement - Link");
    }

    public void clickPrivacyStatementLink() {
        getElePrivacyPolicyFtrLnk().click();
    }

    public void verifyPrivacyStatementPage() {
        validateDisPlayedElement(getElePrivacyTitleTxt(), "Privacy Statement - Title");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleLastRevisedTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getElePrivacyTOSLnk(), "Privacy - TOS - Link");
        validateDisPlayedElement(getElePrivacyCookiesLnk(), "Privacy Cookies - Link");
    }

    public void clickCookieNoticeLink() {
        getEleCookieNoticeFtrLnk().click();
    }

    public void verifyCookieNoticePage() {
        validateDisPlayedElement(getEleCookieNoticeTitleTxt(), "Cookie Notice - Title");
        validateDisPlayedElement(getEleEnglishFrenchTxt(), "English French - Text");
        validateDisPlayedElement(getEleLastRevisedTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleAuvenirUsesTxt(), "Last Revised - Text");
        validateDisPlayedElement(getEleContactInfoLnk(), "Contact info@auvenir.com - Link");
        validateDisPlayedElement(getElePrivacyStatementLnk(), "Privacy Statement - Link");
        validateDisPlayedElement(getEleAboutCookiesLnk(), "About Cookies - Link");
    }
    /*-----------end of huy.huynh on 24/05/2017.*/

    /**
     * TanPham 29/05/2017 - Start
     */

    public void clickOnCareerLink() {
        waitForVisibleElement(eleCareersLnk, "career link");
        hoverElement(eleCareersLnk, "career link");
        clickElement(eleCareersLnk, "carrer link");
    }

    public void verifyAuvenirImage() {
        waitForVisibleElement(auvenirImgEle, "career link");
    }

    public void clickOnSupportLink() {
        waitForVisibleElement(eleSupportLnk, "support link");
        hoverElement(eleSupportLnk, "support link");
        clickElement(eleSupportLnk, "support link");
    }

    /**
     * TanPham 29/05/2017 - End
     */

    public void verifyWelcomePleaseCheckTxtIsDisplayed() {
        getLogger().info("Verify Welcome Please Check Text is displayed.");
        waitForVisibleElement(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login popup is not displayed");
        validateDisPlayedElement(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login popup is not displayed");
        validateElementText(eleWelcomePleaseCheckTxt, "Welcome! Please check your email for a login link.");
    }

    /**
     * Refactored by huy.huynh on 30/05/2017.
     * Restructure only
     */

    @FindBy(id = "audLand-modal-loginHeader")
    private WebElement titleApproval;

    /**
     * verify page loaded
     */
    public void verifyPageLoad() {
        validateDisPlayedElement(getEleAuditorEmailAddressTxtFld(), "Join email");
    }

    /**
     * join action
     */
    public void inputEmailAndJoin(String email) {
        getEleAuditorEmailAddressTxtFld()
                .sendKeys(email);
        getLogger().info("click to regedit auditor user.");
        getEleJoinBtn().click();
    }

    /**
     * Check dialog and click done
     */
    public void actionWithApprovalDialog() {
        /*visibilityOfElementWait(getEleAwaitingApprovalTxt(), "Awaiting Approval", 20);
        visibilityOfElementWait(getEleDoneBtn(), "Approval Done Button", 20);*/
        try {
            /*TODO temproryly
            Thread.sleep(2000);
            System.out.println("Value Awaiting: " + getDriver().findElement(By.id("audLand-modal-loginHeader")).getAttribute("value"));
            validateElementText(getDriver().findElement(By.id("audLand-modal-loginHeader")), "Awaiting approval!");*/
            waitForTextValueChanged(titleApproval, "Awaiting approval", "Awaiting approval!");
            getEleDoneBtn().click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*-----------end of huy.huynh on 30/05/2017.*/
}
