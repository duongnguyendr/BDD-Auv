package com.auvenir.ui.bdd.pages.marketing;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by doai.tran on 8/29/2017.
 */
public class MarketingPage extends CommonPage {

    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[@id='login-popup']//input[@name='email']/ancestor::div[@class='field']/label")
    private WebElement labelEmail;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@id='login-popup']//input[@name='password']/ancestor::div[@class='field']/label")
    private WebElement labelPassword;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//*[@id='login-popup']//button")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*/a[@class='ui large basic inverted button']")
    private WebElement buttonSignUp;

    @FindBy(id = "marketing-header")
    private WebElement marketingHeader;

    @FindBy(xpath = "//a[@class='ui label forgot-password']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//div[@id='forgot-popup']//input[@name='email']")
    private WebElement inputForgottenEmail;

    @FindBy(xpath = "//button[contains(@class,'submit-forgot')]")
    private WebElement buttonRequestResetLink;

    @FindBy(xpath = "//div[@id='waitlist-popup']//span")
    private WebElement spanAccountStillProcessingMessage;

    @FindBy(className = "login-title")
    private WebElement titleLogin;

    @FindBy(id = "forgot-popup")
    private WebElement popupForgotPassword;

    @FindBy(xpath = "//div[contains(@class,'about-header')]")
    private WebElement textBannerInformation;

    @FindBy(id = "about-joinUs")
    private WebElement aboutJoinUs;

    @FindBy(xpath = "//div[@id='home_mission']/h2")
    private WebElement titleMissionHeader;

    @FindBy(xpath = "//div[@id='home_mission']/p[1]")
    private WebElement titleMissionContentPartOne;

    @FindBy(xpath = "//div[@id='home_mission']/p[2]")
    private WebElement titleMissionContentPartTwo;

    @FindBy(xpath = "//div[@id='home_whyAuvenir']//h2")
    private WebElement titleWhyAuvenirHeader;

    @FindBy(xpath = "//div[@id='home_whyAuvenir']//p[1]")
    private WebElement titleWhyAuvenirContentPartOne;

    @FindBy(xpath = "//div[@id='home_whyAuvenir']//p[2]")
    private WebElement titleWhyAuvenirContentPartTwo;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/']")
    private WebElement itemFooterHome;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/about']")
    private WebElement itemFooterAbout;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/contact']")
    private WebElement itemFooterContact;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/terms']")
    private WebElement itemFooterTermsOfSevice;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/privacy']")
    private WebElement itemFooterPrivacyPolicy;

    @FindBy(xpath = "//div[@id='footer']//a[@href='/cookies']")
    private WebElement itemFooterCookieNotice;

    @FindBy(xpath = "//i[contains(@class,'facebook')]")
    private WebElement iconFooterFacebook;

    @FindBy(xpath = "//i[contains(@class,'twitter')]")
    private WebElement iconFooterTwitter;

    @FindBy(xpath = "//i[contains(@class,'linkedin')]")
    private WebElement iconFooterLinkedin;

    @FindBy(xpath = "//div[contains(@class,'copyright-footer')]")
    private WebElement titleFooterCopyright;

    @FindBy(xpath = "//div[@id='about-league']//h2[@class='ui header']")
    private WebElement titleMeetTheAuvyLeagueHeader;

    @FindBy(xpath = "//div[@id='about-league']//img[@class='ui image']")
    private List<WebElement> imageMeetTheAuvyLeagueContentAvatar;

    @FindBy(xpath = "//div[@id='about-league']//h4[@class='name']")
    private List<WebElement> textMeetTheAuvyLeagueContentName;

    @FindBy(xpath = "//div[@id='about-league']//p[@class='title']")
    private List<WebElement> textMeetTheAuvyLeagueContentTitle;

    @FindBy(xpath = "//div[@class='term-service']//div[contains(@class,'header-main-text')]")
    private WebElement textTermsOfServiceHeaderBanner;

    @FindBy(className = "forgot-title")
    private WebElement titleForgotPassword;

    @FindBy(xpath = "//div[@id='forgot-popup']//span")
    private WebElement textForgotPasswordGuide;

    @FindBy(xpath = "//div[@id='forgot-popup']//label")
    private WebElement labelForgotPasswordEmail;

    @FindBy(xpath = "//button[contains(@class,'waitlist-done')]")
    private WebElement buttonConfirmProcessing;

    @FindBy(xpath = "//div[@id='forgot-popup']//div[contains(@class,'error message')]//p")
    private WebElement textNotExistEmailErrorMessage;

    @FindBy(className = "email-sending-title")
    private WebElement titleResetLinkSent;

    public static final String borderColorCSSName = "border-color";
    public final String colorCSSName = "color";

    public final String selectedBorderCSSColor = "rgb(133, 183, 217)";
    public final String greenLinkColorCode = "rgba(89, 155, 161, 1)";

    //private String xpathStatusCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[5]/select";

    public MarketingPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnLoginButton() {
        clickElement(buttonLogin, "Login Button");
    }

    public void clickOnSignUpButton() {
        clickElement(buttonSignUp, "Button Sign Up");
    }

    public void inputUserNamePassword(String username, String password) {
        sendKeyTextBox(inputEmail, username, "emailTextBox");
        sendKeyTextBox(inputPassword, password, "passwordTextBox");
    }

    public void clickOnSubmitButton() {
        clickElement(buttonSubmit, "Button Submit");
    }

    public void verifyMaketingHeaderPage() {
        boolean result = validateExistedElement(marketingHeader, "Marketing header");
        Assert.assertTrue(result, "Verify marketing header page.");
    }

    public void clickOnForgotPasswordLink() {
        //            waitForClickableOfElement(forgotPasswordLink, "forgotPasswordLink");
        clickElement(linkForgotPassword, "Link Forgot Pasword");
    }

    public void verifyForgotPasswordPopup() {
        validateExistedElement(popupForgotPassword, "Popup Forgot Password");
    }

    public void inputEmailForgottenPassword(String email) {
        sendKeyTextBox(inputForgottenEmail, email, "Input Forgotten Email");
    }

    public void clickOnRequestResetLinkButton() {
        clickElement(buttonRequestResetLink, "Button Request Reset Link");
    }

    public void verifyStillProcessingMessage() {
        validateElementText(spanAccountStillProcessingMessage,
                "Thanks for registering for the Auvenir platform! Your account information is being reviewed and you"
                        + " will receive an email from our customer service team shortly. If you have any questions "
                        + "in the meantime, please send us a note at info@auvenir.com.");
    }

    public void verifyLoginPopupTitle() {
        validateElementText(titleLogin, "Login to Auvenir");
    }

    @FindBy(xpath = "//img[contains(@class,'ui-logo')]")
    private WebElement imageLogo;

    @FindBy(xpath = "//button[contains(@class,'btn-login')]")
    private WebElement linkLogin;

    @FindBy(xpath = "//div[@class='row header-logo']//a[contains(@class,'inverted button')]")
    private WebElement linkAuditorSignUp;

    @FindBy(xpath = "//div[contains(@class,'button inverted')]")
    private WebElement linkLanguage;

    @FindBy(xpath = "//div[@class='row']//a[contains(@class,'inverted button')]")
    private WebElement linkJoinAsAuditor;

    public void verifyHeaderLogo() {
        String partialLogoURL = "static/images/logo-auvenir.svg";
        boolean result = validateAttributeContain(imageLogo, "src", partialLogoURL, "Image Logo");
        Assert.assertTrue(result, "Link Header Logo should be: " + partialLogoURL);
    }

    public void verifyLoginLink() {
        boolean result = validateExistedElement(linkLogin, "Link Login");
        Assert.assertTrue(result, "Login Link should be exist");
    }

    public void seeSignUpLink() {
        boolean result = validateExistedElement(linkAuditorSignUp, "Link Auditor Sign Up");
        Assert.assertTrue(result, "Link Auditor Sign Up should be exist");
    }

    public void seeLanguageLink() {
        boolean result = validateExistedElement(linkLanguage, "Link Language");
        Assert.assertTrue(result, "Link Language should be exist");
    }

    public void seeJoinAsAuditorLink() {
        boolean result = validateExistedElement(linkJoinAsAuditor, "Link Join As Auditor");
        Assert.assertTrue(result, "Link Join As Auditor should be exist");
    }

    public void redirectToAboutPage() {
        clickElement(itemFooterAbout, "Item Footer About");
    }

    public void seeBannerInformation() {
        boolean result = validateExistedElement(textBannerInformation, "Banner Information");
        Assert.assertTrue(result, "Banner Information should be exist");
    }

    public void seeAboutJoinUs() {
        scrollToElement(aboutJoinUs, -200);
        waitSomeSeconds(2);
        boolean result = validateExistedElement(textBannerInformation, "Banner Information");
        Assert.assertTrue(result, "");
    }

    public void scrollToAuvenirMissionPart() {
        scrollPageDown();
    }

    public void seeAuvenirMissionHeader() {
        validateElementText(titleMissionHeader, "Auvenir is on a mission to enable a Smarter Audit.");
    }

    public void seeAuvenirMissionContent() {
        validateElementText(titleMissionContentPartOne,
                "As a Deloitte venture, Auvenir benefits from the agility of a start-up culture while leveraging " +
                        "deep world-class audit and technology expertise. Our long term goal is to facilitate " +
                        "higher trust and confidence in financial reporting and assurance.");
        validateElementText(titleMissionContentPartTwo,
                "The Auvenir platform seamlessly integrates advanced technology to enhance the financial audit " +
                        "workflow, improving efficiencies and communications for auditors and their clients. This " +
                        "includes a robust collaboration tool, as well as patent pending machine learning software "
                        + "that automates routine tasks of the audit process.");
    }

    public void scrollToWhyAuvenirPart() {
        scrollPageDown();
    }

    public void seeWhyAuvenirHeader() {
        validateElementText(titleWhyAuvenirHeader, "Why Auvenir?");
    }

    public void seeWhyAuvenirContent() {
        validateElementText(titleWhyAuvenirContentPartOne, "Your time and your business.");
        validateElementText(titleWhyAuvenirContentPartTwo,
                "A smarter audit means a straightforward, faster process that gives you back time to focus on " +
                        "higher value services and activities in your practice.  It means improved client " +
                        "collaboration and interaction, giving you stronger client relationships and more " +
                        "referrals.  A smarter audit experience means a better way of doing business.");
    }


    public void seeHomeLink() {
        boolean result = validateExistedElement(itemFooterHome, "Item Footer Home");
        Assert.assertTrue(result, "Item Footer Home should be exist");
    }

    public void seeAboutLink() {
        boolean result = validateExistedElement(itemFooterAbout, "Item Footer About");
        Assert.assertTrue(result, "Item Footer About should be exist");
    }

    public void seeContactLink() {
        boolean result = validateExistedElement(itemFooterContact, "Item Footer Contact");
        Assert.assertTrue(result, "Item Footer Contact should be exist");
    }

    public void seeTermsOfServiceLink() {
        boolean result = validateExistedElement(itemFooterTermsOfSevice, "Item Footer Terms Of Sevice");
        Assert.assertTrue(result, "Item Footer Terms Of Sevice should be exist");
    }

    public void seePrivacyPolicyLink() {
        boolean result = validateExistedElement(itemFooterPrivacyPolicy, "Item Footer Privacy Policy");
        Assert.assertTrue(result, "Item Footer PrivacyP olicy should be exist");
    }

    public void seeCookieNoticeLink() {
        boolean result = validateExistedElement(itemFooterCookieNotice, "Item Footer Cookie Notice");
        Assert.assertTrue(result, "Item Footer Cookie Notice should be exist");
    }

    public void clickOnTextBoxPassword() {
        clickElement(inputPassword, "inputpassword");
    }

    public void verifyBoundaryPasswordChange() {
        boolean result = waitForCssValueChanged(inputPassword, " Password Text Box", borderColorCSSName,
                selectedBorderCSSColor);
        Assert.assertTrue(result, "verify password change border color when focus ");

    }

    public void verifyInputPassword(String password) {
        sendKeyTextBox(inputPassword, password, "passwordTextBox");
        Assert.assertEquals(getText(inputPassword), password);
    }


    public void seeFacebookIcon() {
        boolean result = validateExistedElement(iconFooterFacebook, "Icon Footer Facebook");
        Assert.assertTrue(result, "Icon Facebook should be exist");
    }

    public void seeTwitterIcon() {
        boolean result = validateExistedElement(iconFooterTwitter, "Icon Footer Twitter");
        Assert.assertTrue(result, "Icon Twitter should be exist");
    }

    public void seeLinkedinIcon() {
        boolean result = validateExistedElement(iconFooterLinkedin, "Icon Footer Linkedin");
        Assert.assertTrue(result, "Icon Linkedin should be exist");
    }

    public void seeCopyrightTitle() {
        boolean result = validateExistedElement(titleFooterCopyright, "Title Footer Copyright");
        Assert.assertTrue(result, "Title Footer Copyright should be exist");
    }

    public void seeMeetTheAuvyLeagueHeader() {
        scrollToElement(titleMeetTheAuvyLeagueHeader);
        waitSomeSeconds(2);
        boolean result = validateExistedElement(titleMeetTheAuvyLeagueHeader, "Title Meet The Auvy League Header");
        Assert.assertTrue(result, "Title Meet The Auvy League Header should be exist");
    }

    public void seeMeetTheAuvyLeagueContent(String members) {
        int memberQuantity = Integer.parseInt(members);
        Assert.assertEquals(imageMeetTheAuvyLeagueContentAvatar.size(), memberQuantity,
                "Quantity of avatar member should be equals: " + memberQuantity);
        Assert.assertEquals(textMeetTheAuvyLeagueContentName.size(), memberQuantity,
                "Quantity of name member should be equals: " + memberQuantity);
        Assert.assertEquals(textMeetTheAuvyLeagueContentTitle.size(), memberQuantity,
                "Quantity of title member should be equals: " + memberQuantity);
    }


    public void verifyEmailLabel() {
        boolean result = validateExistedElement(labelEmail, "Label Email");
        Assert.assertTrue(result, "Label Email should be exist");
    }

    public void verifyEmailTextbox() {
        boolean result = validateExistedElement(inputEmail, "Input Email");
        Assert.assertTrue(result, "Input Email should be exist");
    }

    public void verifyPasswordLabel() {
        boolean result = validateExistedElement(labelPassword, "Label Password");
        Assert.assertTrue(result, "Label Password should be exist");
    }

    public void verifyPasswordTextbox() {
        boolean result = validateExistedElement(inputPassword, "Input Password");
        Assert.assertTrue(result, "Input Password should be exist");
    }

    public void verifyForgotPasswordLink() {
        boolean result = validateExistedElement(linkForgotPassword, "Link Forgot Password");
        Assert.assertTrue(result, "Link Forgot Password should be exist");
    }

    public void verifyLoginButton() {
        boolean result = validateExistedElement(buttonLogin, "Button Login");
        Assert.assertTrue(result, "Button Login should be exist");
    }

    public void redirectToTermsOfServicePage() {
        clickElement(itemFooterTermsOfSevice, "Item Footer Terms Of Sevice");
    }

    public void seeTermsOfServiceHeaderBanner() {
        boolean result = validateExistedElement(textTermsOfServiceHeaderBanner, "Terms Of Service Header Banner");
        Assert.assertTrue(result, "Terms Of Service Header Banner should be exist");
    }

    public void seeColorOfForgotPasswordLinkIsGreen() {
        boolean result = validateCssValueElement(linkForgotPassword, colorCSSName, greenLinkColorCode);
        Assert.assertTrue(result, "Link Forgot Password color should be: " + greenLinkColorCode);
    }

    public void seeForgotPasswordPopupTitle() {
        boolean result = validateExistedElement(titleForgotPassword, "Title Forgot Password");
        Assert.assertTrue(result, "Title Forgot Password should be exist");
    }

    public void seeForgotPasswordPopupGuide() {
        boolean result = validateExistedElement(textForgotPasswordGuide, "Forgot Password Guide");
        Assert.assertTrue(result, "Forgot Password Guide should be exist");
    }

    public void seeForgotPasswordPopupBorder() {
        clickElement(inputForgottenEmail, "Input Forgotten Email");
        boolean result = waitForCssValueChanged(inputForgottenEmail, "Input Forgotten Email", borderColorCSSName,
                selectedBorderCSSColor);
        Assert.assertTrue(result,
                "Input Forgotten Email border color when selected should be: " + selectedBorderCSSColor);
    }

    public void seeForgotPasswordPopupEmailLabel() {
        boolean result = validateExistedElement(labelForgotPasswordEmail, "Label Forgot Password Email");
        Assert.assertTrue(result, "Label Forgot Password Email should be exist");
    }

    public void verifyInputForgotEmailWithText(String textString) {
        sendKeyTextBox(inputForgottenEmail, textString, "passwordTextBox");
        Assert.assertEquals(getText(inputForgottenEmail), textString);
    }

    public void verifyInputForgotEmailWithNumber(String numberString) {
        sendKeyTextBox(inputForgottenEmail, numberString, "passwordTextBox");
        Assert.assertEquals(getText(inputForgottenEmail), numberString);
    }

    public void verifyInputForgotEmailWithSpecialCharacter(String specialCharacterString) {
        sendKeyTextBox(inputForgottenEmail, specialCharacterString, "passwordTextBox");
        Assert.assertEquals(getText(inputForgottenEmail), specialCharacterString);
    }


    public void clickConfirmWithAccountStillProcessingMessage() {
        clickElement(buttonConfirmProcessing, "Button Confirm Processing");
    }

    public void seeAccountNotExistErrorMessage() {
        boolean result = validateExistedElement(textNotExistEmailErrorMessage, "Not Exist Email Error Message");
        Assert.assertTrue(result, "Not Exist Email Error Message should be exist");
    }

    public void seeResetLinkSentMessage() {
        boolean result = validateExistedElement(titleResetLinkSent, "Title Reset Link Sent");
        Assert.assertTrue(result, "Title Reset Link Sent should be exist");
    }
}
