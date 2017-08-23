package com.auvenir.ui.pages.client.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class ClientLoginPage extends AbstractPage {

    public static int iFailCount = 0;


    public ClientLoginPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//h3[text()='Are you a financial auditor?']")
    private WebElement eleAreUFinancialAuditorTxt;

    public WebElement getEleAreUFinancialAuditorTxt() {
        return eleAreUFinancialAuditorTxt;
    }

    @FindBy(xpath = "//a[text()='Join as an Auditor']")
    private WebElement eleJoinAsAuditorHdrLnk;

    public WebElement getEleJoinAsAuditorHdrLnk() {
        return eleJoinAsAuditorHdrLnk;
    }

    @FindBy(xpath = "//img[@class='CToWUd']")
    private WebElement eleAuvenirImg;

    public WebElement getEleAuvenirImg() {
        return eleAuvenirImg;
    }

    @FindBy(xpath = "//p[text()='Hi Jack,']")
    private WebElement eleHiJackTxt;

    public WebElement getEleHiJackTxt() {
        return eleHiJackTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'has invited you to join')]")
    private WebElement eleHasInvitedTxt;

    public WebElement getEleHasInvitedTxt() {
        return eleHasInvitedTxt;
    }

    @FindBy(xpath = "(//a[contains(text(),'Start Your Audit')])[last()]")
    private WebElement eleStartAuditBtn;

    public WebElement getEleStartAuditBtn() {
        return eleStartAuditBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir is on a mission')]")
    private WebElement eleAuvenirisTxt;

    public WebElement getEleAuvenirisTxt() {
        return eleAuvenirisTxt;
    }

    @FindBy(xpath = "//a[contains(text(),'feedback@auvenir.com')]")
    private WebElement eleFeedbackAuvTxt;

    public WebElement getEleFeedbackAuvTxt() {
        return eleFeedbackAuvTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'Audit, Smarter.')]")
    private WebElement eleAuditSmarterTxt;

    public WebElement getEleAuditSmarterTxt() {
        return eleAuditSmarterTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'Audit, Smarter.')]/../span/img")
    private WebElement eleAuditSmarterImg;

    public WebElement getEleAuditSmarterImg() {
        return eleAuditSmarterImg;
    }

    @FindBy(xpath = "//span[contains(text(),'225 Richmond Street West')]")
    private WebElement eleRichmondStreetTxt;

    public WebElement getEleRichmondStreetTxt() {
        return eleRichmondStreetTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'This email is subject')]")
    private WebElement eleThisEmailTxt;

    public WebElement getEleThisEmailTxt() {
        return eleThisEmailTxt;
    }

    @FindBy(xpath = "//a[@href='https://ariel.auvenir.com/terms']")
    private WebElement eleTermsOfServiceLnk;

    public WebElement getEleTermsOfServiceLnk() {
        return eleTermsOfServiceLnk;
    }

    @FindBy(xpath = "//a[@href='https://ariel.auvenir.com/privacy']")
    private WebElement elePrivacyStatementLnk;

    public WebElement getElePrivacyStatementLnk() {
        return elePrivacyStatementLnk;
    }

    @FindBy(xpath = "//span[contains(text(),'To unsubscribe, please')]")
    private WebElement eleToUnsubscribeTxt;

    public WebElement getEleToUnsubscribeTxt() {
        return eleToUnsubscribeTxt;
    }

    @FindBy(xpath = "//a[@href='mailto:unsubscribe@auvenir.com?Subject=Unsubscribe']")
    private WebElement eleClickHereLnk;

    public WebElement getEleClickHereLnk() {
        return eleClickHereLnk;
    }

    @FindBy(xpath = "//nav[@id='landingAuditPopUp']//button[@type='button']")
    private WebElement eleCloseXBtn;

    public WebElement getEleCloseXBtn() {
        return eleCloseXBtn;
    }

    @FindBy(id = "headerLogo")
    private WebElement eleAuvenirHdrImg;

    public WebElement getEleAuvenirHdrImg() {
        return eleAuvenirHdrImg;
    }

    @FindBy(xpath = "//a[text()='Log in']")
    private WebElement eleLoginLnk;

    public WebElement getEleLoginLnk() {
        return eleLoginLnk;
    }

    @FindBy(xpath = "//i[@class='fa fa-chevron-down land-loginChevron landing-login-btn-after']")
    private WebElement eleLoginLnkArrow;

    public WebElement getEleLoginLnkArrow() {
        return eleLoginLnkArrow;
    }


    public String getLoginDropdown() {

        String loginXP = getDriver().findElement(By.xpath("//div[@id='land-login-dropdown']")).getAttribute("class");
        return loginXP;
    }

    @FindBy(xpath = "//div[@id='land-login-dropdown']//span[contains(text(),'Email Address')]")
    private WebElement eleEmailAdrTxt;

    public WebElement getEleEmailAdrTxt() {
        return eleEmailAdrTxt;
    }

    @FindBy(xpath = "//input[@id='audLand-emailField-top']")
    private WebElement eleTypeYourEmailTxtFld;

    public WebElement getEleTypeYourEmailTxtFld() {
        return eleTypeYourEmailTxtFld;
    }

    @FindBy(xpath = "//input[@id='emailField-top'][@placeholder='Type your email']")
    private WebElement eleTypeYourEmailTxt;

    public WebElement getEleTypeYourEmailTxt() {
        return eleTypeYourEmailTxt;
    }

    @FindBy(xpath = "//button[@id='audLand-dd-loginBtn']")
    private WebElement eleGoBtn;

    public WebElement getEleGoBtn() {
        return eleGoBtn;
    }

    @FindBy(xpath = "//a[@id='landing-signUpBtn']")
    private WebElement eleSignUpBtn;

    public WebElement getEleSignUpBtn() {
        return eleSignUpBtn;
    }


    @FindBy(xpath = "//a[contains(text(),'Get an Invite')]")
    private WebElement eleGetInviteBtn;

    public WebElement getEleGetInviteBtn() {
        return eleGetInviteBtn;
    }

    @FindBy(xpath = "//header[@id='header']//img")
    private WebElement eleDashboardImg;

    public WebElement getEleDashboardImg() {
        return eleDashboardImg;
    }

    @FindBy(xpath = "//i[@class='fa fa-chevron-down landing-learnMoreChevron']")
    private WebElement eleDownArrow;

    public WebElement getEleDownArrow() {
        return eleDownArrow;
    }

    @FindBy(xpath = "//a[contains(text(),'Learn More')]")
    private WebElement eleLearnMoreTxt;

    public WebElement getEleLearnMoreTxt() {
        return eleLearnMoreTxt;
    }

    public String getAboutAuvenir() {

        String AboutAuvenirXP = getDriver().findElement(By.xpath("//div[@id='landing-fixedLearnMore']")).getAttribute("style");
        return AboutAuvenirXP;
    }

    @FindBy(xpath = "//h2[contains(text(),'What is Auvenir?')]")
    private WebElement eleWhatIsAuvenirTxt;

    public WebElement getEleWhatIsAuvenirTxt() {
        return eleWhatIsAuvenirTxt;
    }

    @FindBy(xpath = "//span[@class='separator']")
    private WebElement eleSeparatorImg;

    public WebElement getEleSeparatorImg() {
        return eleSeparatorImg;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir is the future of financial audit.')]")
    private WebElement eleAuvFutureTxt;

    public WebElement getEleAuvFutureTxt() {
        return eleAuvFutureTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Adaptable and Customizable')]/preceding-sibling::img")
    private WebElement eleAdaptableImg;

    public WebElement getEleAdaptableImg() {
        return eleAdaptableImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Adaptable and Customizable')]")
    private WebElement eleAdaptAndCustomTxt;

    public WebElement getEleAdaptAndCustomTxt() {
        return eleAdaptAndCustomTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Adaptable and Customizable')]/following-sibling::p")
    private WebElement eleFeaturesAndIntegrTxt;

    public WebElement getEleFeaturesAndIntegrTxt() {
        return eleFeaturesAndIntegrTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Simplified Workflow')]/preceding-sibling::img")
    private WebElement eleSimplifiedImg;

    public WebElement getEleSimplifiedImg() {
        return eleSimplifiedImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Simplified Workflow')]")
    private WebElement eleSimplifiedTxt;

    public WebElement getEleSimplifiedTxt() {
        return eleSimplifiedTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Simplified Workflow')]/following-sibling::p")
    private WebElement eleWeAreAutomatingTxt;

    public WebElement getEleWeAreAutomatingTxt() {
        return eleWeAreAutomatingTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Highly Secure')]/preceding-sibling::img")
    private WebElement eleHighlySecureImg;

    public WebElement getEleHighlySecureImg() {
        return eleHighlySecureImg;
    }

    @FindBy(xpath = "//h4[contains(text(),'Highly Secure')]")
    private WebElement eleHighlySecureTxt;

    public WebElement getEleHighlySecureTxt() {
        return eleHighlySecureTxt;
    }

    @FindBy(xpath = "//h4[contains(text(),'Highly Secure')]/following-sibling::p")
    private WebElement eleWeUseTwoFactorTxt;

    public WebElement getEleWeUseTwoFactorTxt() {
        return eleWeUseTwoFactorTxt;
    }

    @FindBy(xpath = "//h2[contains(text(),'Key Features')]")
    private WebElement eleKeyFeaturesTxt;

    public WebElement getEleKeyFeaturesTxt() {
        return eleKeyFeaturesTxt;
    }

    @FindBy(xpath = "//h2[contains(text(),'Key Features')]/following-sibling::p")
    private WebElement eleBringYourAuditTxt;

    public WebElement getEleBringYourAuditTxt() {
        return eleBringYourAuditTxt;
    }

    @FindBy(xpath = "//ul/li[contains(text(),'Sync with your bank')]")
    private WebElement eleSyncWithYourBankTxt;

    public WebElement getEleSyncWithYourBankTxt() {
        return eleSyncWithYourBankTxt;
    }

    @FindBy(xpath = "//ul/li[contains(text(),'Automatic bank')]")
    private WebElement eleAutomaticBankTxt;

    public WebElement getEleAutomaticBankTxt() {
        return eleAutomaticBankTxt;
    }

    @FindBy(xpath = "//ul/li[contains(text(),'E-signature')]")
    private WebElement eleESignatureTxt;

    public WebElement getEleESignatureTxt() {
        return eleESignatureTxt;
    }

    @FindBy(xpath = "//ul/li[contains(text(),'Machine Learning')]")
    private WebElement eleEleMachineLearningTxt;

    public WebElement getEleMachineLearningTxt() {
        return eleEleMachineLearningTxt;
    }

    @FindBy(xpath = "//img[@class='fadeRight animated']")
    private WebElement eleFeaturesDashboardImg;

    public WebElement getEleFeaturesDashboardImg() {
        return eleFeaturesDashboardImg;
    }


    @FindBy(xpath = "//h3[@id='landingSubscribeHeader']")
    private WebElement eleLoginToAuvenirTxt;

    public WebElement getEleJoinTheWaitlistForAuvenirTxt() {
        return eleLoginToAuvenirTxt;
    }

    @FindBy(id = "emailField")
    private WebElement eleYourEmailAddressTxtFld;

    public WebElement getEleYourEmailAddressTxtFld() {
        return eleYourEmailAddressTxtFld;
    }

    @FindBy(id = "landing-modal-LoginBtn")
    private WebElement eleJoinBtn;

    public WebElement getEleJoinBtn() {
        return eleJoinBtn;
    }

    @FindBy(xpath = "//section[@id='subscribe']//a[contains(text(),'Join as an auditor')]")
    private WebElement eleJoinAsAuditorLnk;

    public WebElement getEleJoinAsAuditorLnk() {
        return eleJoinAsAuditorLnk;
    }

    @FindBy(xpath = "//h2[contains(text(),'Get in Touch')]")
    private WebElement eleGetInTouchtxt;

    public WebElement getEleGetInTouchtxt() {
        return eleGetInTouchtxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Use the form below')]")
    private WebElement eleUseTheFormBelowTxt;

    public WebElement getEleUseTheFormBelowTxt() {
        return eleUseTheFormBelowTxt;
    }

    @FindBy(id = "landing-userName")
    private WebElement eleNameTxtFld;

    public WebElement getEleNameTxtFld() {
        return eleNameTxtFld;
    }

    @FindBy(id = "landing-userEmail")
    private WebElement eleEmailTxtFld;

    public WebElement getEleEmailTxtFld() {
        return eleEmailTxtFld;
    }

    @FindBy(id = "landing-userMessage")
    private WebElement eleMessageTxtFld;

    public WebElement getEleMessageTxtFld() {
        return eleMessageTxtFld;
    }

    @FindBy(id = "landing-modal-msgBtn")
    private WebElement eleSendMessageBtn;

    public WebElement getEleSendMessageBtn() {
        return eleSendMessageBtn;
    }

    @FindBy(id = "map")
    private WebElement eleMapImg;

    public WebElement getEleMapImg() {
        return eleMapImg;
    }

    @FindBy(id = "footerLogo")
    private WebElement eleAuvenirFtrImg;

    public WebElement getEleAuvenirFtrImg() {
        return eleAuvenirFtrImg;
    }

    @FindBy(xpath = "//a[contains(text(),'Join as a business')]")
    private WebElement eleJoinAsBusiLnk;

    public WebElement getEleJoinAsBusiLnk() {
        return eleJoinAsBusiLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement eleCareersLnk;

    public WebElement getEleCareersLnk() {
        return eleCareersLnk;
    }

    @FindBy(xpath = "//span[@class='fa fa-briefcase']")
    private WebElement eleCareersIcn;

    public WebElement getEleCareersIcn() {
        return eleCareersIcn;
    }

    @FindBy(xpath = "//a[contains(@href,'https://www.google.ca/maps/place/225+Richmond+St+W,+Toronto,+ON+M5V+1W2/@43.6492418,-79.3916968,17z/data=!3m1!4b1!4m5!3m4!1s0x882b34d02ffa2c39:0xccd12349e2ef3f18!8m2!3d43.6492418!4d-79.3895081')]")
    private WebElement eleLocationLnk;

    public WebElement getEleLocationLnk() {
        return eleLocationLnk;
    }

    @FindBy(xpath = "//span[@class='fa fa-map-marker']")
    private WebElement eleLocationIcn;

    public WebElement getEleLocationIcn() {
        return eleLocationIcn;
    }

    @FindBy(xpath = "//div[@class='upper-footer']//a[contains(text(),'Join as an auditor')]")
    private WebElement eleJoinAsAuditorFtrLnk;

    public WebElement getEleJoinAsAuditorFtrLnk() {
        return eleJoinAsAuditorFtrLnk;
    }

    @FindBy(xpath = "//a[contains(text(),'Support')]")
    private WebElement eleEmailLnk;

    public WebElement getEleSupportLnk() {
        return eleEmailLnk;
    }

    @FindBy(xpath = "//span[@class='fa fa-envelope']")
    private WebElement eleEmailIcn;

    public WebElement getEleEmailIcn() {
        return eleEmailIcn;
    }

    @FindBy(xpath = "//a[contains(@href,'tel:')]")
    private WebElement eleContactNmbrLnk;

    public WebElement getElerContactNmbrLnk() {
        return eleContactNmbrLnk;
    }

    @FindBy(xpath = "//span[@class='fa fa-phone']")
    private WebElement eleContactNmbrIcn;

    public WebElement getElerContactNmbrIcn() {
        return eleContactNmbrIcn;
    }

    @FindBy(xpath = "//a[contains(@href,'https://www.facebook.com/')]")
    private WebElement eleFacebookLnk;

    public WebElement getEleFacebookLnk() {
        return eleFacebookLnk;
    }

    @FindBy(xpath = "//a[contains(@href,'https://twitter.com/')]")
    private WebElement eleTwitterLnk;

    public WebElement getEleTwitterLnk() {
        return eleTwitterLnk;
    }

    @FindBy(xpath = "//a[contains(@href,'https://www.linkedin.com/')]")
    private WebElement eleLinkedinLnk;

    public WebElement getEleLinkedinLnk() {
        return eleLinkedinLnk;
    }

    @FindBy(xpath = "//p[text()='Welcome to Auvenir!']")
    private WebElement eleWelcomeAuvenirTxt;

    public WebElement getEleWelcomeAuvenirTxt() {
        return eleWelcomeAuvenirTxt;
    }

    @FindBy(xpath = "//p[text()='Thank you for using our secure login system.']")
    private WebElement eleThankYouTxt;

    public WebElement getEleThankYouTxt() {
        return eleThankYouTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Congratulations')]")
    private WebElement eleCongratzTxt;

    public WebElement getEleCongratzTxt() {
        return eleCongratzTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'ready to audit smarter,')]")
    private WebElement eleWhenReadyTxt;

    public WebElement getEleWhenReadyTxt() {
        return eleWhenReadyTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'We welcome your feedback,')]")
    private WebElement eleWeWelcomeTxt;

    public WebElement getEleWeWelcomeTxt() {
        return eleWeWelcomeTxt;
    }

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement eleLoginBtn;

    public WebElement getEleLoginBtn() {
        return eleLoginBtn;
    }

    @FindBy(xpath = "//p[contains(text(),'Best Regards')]")
    private WebElement eleBestRegardsTxt;

    public WebElement getEleBestRegardsTxt() {
        return eleBestRegardsTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Your account has been authenticated and is now active.')]")
    private WebElement eleYourAccountTxt;

    public WebElement getEleYourAccountTxt() {
        return eleYourAccountTxt;
    }

    @FindBy(xpath = "//a[text()='Get Started']")
    private WebElement eleGetStartedBtn;

    public WebElement getEleGetStartedBtn() {
        return eleGetStartedBtn;
    }

    public void signInEmailOnClientLoginPage(String clientID) {
        getLogger().info("Sign In Email On Client Login Page");
        clickElement(eleLoginLnk, "Login link");
        sendKeyTextBox(eleTypeYourEmailTxtFld, clientID, "Login link");
        clickElement(eleGoBtn, "Go Button");
    }

    public void verifyClientLoginPageAfterSignIn() {
        getLogger().info("Verify Client Login Page After Sign In.");
        waitForVisibleElement(eleWelcomeAuvenirTxt, "Welcome to Auvenir");
        validateDisPlayedElement(eleWelcomeAuvenirTxt, "Welcome to Auvenir");
        validateElementText(eleWelcomeAuvenirTxt, "Welcome to Auvenir!");
        validateDisPlayedElement(eleAuvenirImg, "Auvenir - Image");
        validateDisPlayedElement(eleCongratzTxt, "Congratulations - Text");
        validateDisPlayedElement(eleWhenReadyTxt, "When we are ready - Text");
        validateDisPlayedElement(eleLoginBtn, "Login - Button");
        validateDisPlayedElement(eleWeWelcomeTxt, "We Welcome - Text");
        validateDisPlayedElement(eleFeedbackAuvTxt, "feedback@auvenir.com - Link");
        validateDisPlayedElement(eleBestRegardsTxt, "Best Regards - Text");
        validateDisPlayedElement(eleAuditSmarterImg, "Audit Smarter - Image");
        validateDisPlayedElement(eleAuditSmarterTxt, "Audit Smarter - Text");
        validateDisPlayedElement(eleRichmondStreetTxt, "Richmond Street Address - Text");
        validateDisPlayedElement(eleThisEmailTxt, "This email is subject to - Text");
        validateDisPlayedElement(eleToUnsubscribeTxt, "To Unsubribe - Text");
        validateDisPlayedElement(eleTermsOfServiceLnk, "Terms of Service - Link");
        validateDisPlayedElement(elePrivacyStatementLnk, "Privacy statement - Link");
        validateDisPlayedElement(eleClickHereLnk, "Click Here - Link");
    }

    public void verifyClientLoginPageAfterActiveAccount() {
        getLogger().info("Verify Client Login Page After Active Account.");
        waitForVisibleElement(eleWelcomeAuvenirTxt, "Welcome to Auvenir");
        validateDisPlayedElement(eleWelcomeAuvenirTxt, "Welcome to Auvenir");
        validateElementText(eleWelcomeAuvenirTxt, "Welcome to Auvenir!");
        validateDisPlayedElement(eleAuvenirImg, "Auvenir - Image");
        validateDisPlayedElement(eleYourAccountTxt, "Your account has been activated - Text");
        validateDisPlayedElement(eleGetStartedBtn, "Get Started - Button");
        validateDisPlayedElement(eleWeWelcomeTxt, "We Welcome - Text");
        validateDisPlayedElement(eleFeedbackAuvTxt, "feedback@auvenir.com - Link");
        validateDisPlayedElement(eleBestRegardsTxt, "Best Regards - Text");
        validateDisPlayedElement(eleAuditSmarterImg, "Audit Smarter - Image");
        validateDisPlayedElement(eleAuditSmarterTxt, "Audit Smarter - Text");
        validateDisPlayedElement(eleRichmondStreetTxt, "Richmond Street Address - Text");
        validateDisPlayedElement(eleThisEmailTxt, "This email is subject to - Text");
        validateDisPlayedElement(eleToUnsubscribeTxt, "To Unsubribe - Text");
        validateDisPlayedElement(eleTermsOfServiceLnk, "Terms of Service - Link");
        validateDisPlayedElement(elePrivacyStatementLnk, "Privacy statement - Link");
        validateDisPlayedElement(eleClickHereLnk, "Click Here - Link");
    }

    public void verifyClientLoginPageInvitationEmail() {
        getLogger().info("Verify Client Login Page Invitation Email.");
        validateDisPlayedElement(eleAuvenirImg, "Auvenir - Image");
        validateDisPlayedElement(eleHiJackTxt, "Hi Jack, -Text ");
        validateDisPlayedElement(eleHasInvitedTxt, "has invited you to join Auvenir - Text");
        validateDisPlayedElement(eleStartAuditBtn, "Start Your Audit - Button");
        validateDisPlayedElement(eleAuvenirisTxt, "Auvenir is on mission- Text");
        validateDisPlayedElement(eleFeedbackAuvTxt, "feedback@auvenir.com - Link");
        validateDisPlayedElement(eleAuditSmarterImg, "Audit Smarter - Image");
        validateDisPlayedElement(eleAuditSmarterTxt, "Audit Smarter - Text");
        validateDisPlayedElement(eleRichmondStreetTxt, "Richmond Street Address - Text");
        validateDisPlayedElement(eleThisEmailTxt, "This email is subject to - Text");
        validateDisPlayedElement(eleToUnsubscribeTxt, "To Unsubribe - Text");
        validateDisPlayedElement(eleTermsOfServiceLnk, "Terms of Service - Link");
        validateDisPlayedElement(elePrivacyStatementLnk, "Privacy statement - Link");
        validateDisPlayedElement(eleClickHereLnk, "Click Here - Link");
    }

    public void clickStartAuditButton() {
        getLogger().info("Click Start Audit Button.");
        clickElement(eleStartAuditBtn, "Start Audit Button");
    }
}
