package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.GmailPage;
import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cuong.nguyen on 4/25/2017.
 */
public class MailAuditorJoinPage extends CommonPage {

    // Element of title mail
    @FindBy(xpath = "//p[contains(text(),'Hello')]")
    private WebElement eleTitle;

    public WebElement getEleTitle() {
        return eleTitle;
    }

    //    @FindBy(xpath = "//h2[contains(text(),'Your Auvenir')]")
    @FindBy(xpath = "//h2[contains(text(),'Welcome to the Auvenir')]")
    private WebElement eleSubjectActiveEmail;

    @FindBy(xpath = "//h2[contains(text(),'Invitation from ')]")
    private WebElement eleSubjectInviteClientEmail;

    public WebElement getEleSubjectInviteClientEmail() {
        return eleSubjectInviteClientEmail;
    }

    @FindBy(xpath = "//p[contains(text(),'Hi')]")
    private WebElement eleContent0InviteClientEmailClient;

    public WebElement getEleContent0InviteClientEmailClient() {
        return eleContent0InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'has invited')]")
    private WebElement eleContent1InviteClientEmailClient;

    public WebElement getEleContent1InviteClientEmailClient() {
        return eleContent1InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Auvenir is')]")
    private WebElement eleContent2InviteClientEmailClient;

    public WebElement getEleContent2InviteClientEmailClient() {
        return eleContent2InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Here')]")
    private WebElement eleContent3InviteClientEmailClient;

    public WebElement getEleContent3InviteClientEmailClient() {
        return eleContent3InviteClientEmailClient;
    }


    @FindBy(xpath = "//p[contains(text(),'Secure')]")
    private WebElement eleContent4InviteClientEmailClient;

    public WebElement getEleContent4InviteClientEmailClient() {
        return eleContent4InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Customized')]")
    private WebElement eleContent5InviteClientEmailClient;

    public WebElement getEleContent5InviteClientEmailClient() {
        return eleContent5InviteClientEmailClient;
    }

    @FindBy(xpath = "//p[contains(text(),'Bank')]")
    private WebElement eleContent6InviteClientEmailClient;

    public WebElement getEleContent6InviteClientEmailClient() {
        return eleContent6InviteClientEmailClient;
    }


    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    private WebElement eleWelcomeActiveEmail;

    // Element of content mail
    @FindBy(xpath = "//p[contains(text(),'We ')]")
    private WebElement eleContent;

    public WebElement getEleContent() {
        return eleContent;
    }

    @FindBy(xpath = "//p[contains(text(),'Your account')]")
    private WebElement eleInformActive;

    @FindBy(xpath = "//p[contains(text(),'your feedback')]")
    private WebElement eleFeedbackInform;

    @FindBy(xpath = "//center/a")
    private WebElement eleGetStarted;

    @FindBy(xpath = "//a[contains(@href,'mailto:feedback@auvenir.com')]")
    private WebElement eleFeedbackLink;

    // Element of button Go to Auvenir website
    @FindBy(xpath = "//center/table[1]/tbody/tr/td/p/a[@href='http://auvenir.s3corp.com.vn:5000']")
    private WebElement btnGoToSiteAuvenir;

    public WebElement getBtnGoToSiteAuvenir() {
        return btnGoToSiteAuvenir;
    }

    // Element of Twitter link
    @FindBy(xpath = "//a[@href='https://twitter.com/auvenir']")
    private WebElement lnkTwitter;

    public WebElement getLnkTwitter() {
        return lnkTwitter;
    }

    // Element of LinkedIn link
    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/auvenir']")
    private WebElement lnkLinked;

    public WebElement getLnkLinked() {
        return lnkLinked;
    }

    // Element of Facebook link
    @FindBy(xpath = "//a[@href='https://www.facebook.com/auvenir/']")
    private WebElement lnkFacebook;

    public WebElement getLnkFacebook() {
        return lnkFacebook;
    }

    // Element of InfoAuvenir link
    @FindBy(xpath = "//a[@href='mailto:info@auvenir.com']")
    private WebElement lnkInfoAuvenir;

    public WebElement getLnkInfoAuvenir() {
        return lnkInfoAuvenir;
    }

    // Element of footer content mail
    @FindBy(xpath = "//p[contains(text(),'Best Regards,') and contains(.,'Auvenir Customer Success Team')]")
    private WebElement eleSignatureMail;


    // Element for content email in Gmail.

    @FindBy(xpath = "//h2[@class='hP']")
    private WebElement subjectEmail;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[1]")
    private WebElement titleGreeting;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[2]")
    private WebElement titleAnnouncement;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[3]")
    private WebElement titleAuvenirIntroducing;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[4]")
    private WebElement titleIntroducingBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[5]")
    private WebElement titleFirstBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[6]")
    private WebElement titleSecondBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[7]")
    private WebElement titleThirdBenefit;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[8]")
    private WebElement titleFeedback;

    @FindBy(xpath = "//table[contains(@class,'mainTable')]//p[9]")
    private WebElement titleGoodbye;

    @FindBy(xpath = "//*[@class='progress-overlay']")
    private WebElement progressingDiv;

    public WebElement getEleSignatureMail() {
        return eleSignatureMail;
    }

//    public MailAuditorJoinPage(Logger logger, WebDriver webDriver) {
//        super(logger, webDriver);
//        PageFactory.initElements(webDriver, this);
//    }

    public MailAuditorJoinPage(Logger logger, WebDriver webDriver) {
        super(logger, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    //@Override
    public void verifyPageContent() {
        // Checking Title Email element is displayed
        this.validateElememt(eleTitle, "Element of Title of Mail", Element_Type.DISPLAYED);

        // Checking content mail
        this.validateElememt(eleContent, "Element of content mail", Element_Type.DISPLAYED);
        this.validateElememt(eleContent, "We are excited about your interest in Auvenir, where we are on a mission to make the audit process better for auditors and their clients. We'll make sure to keep you up to date on our progress and will let you know when you can start using the platform.", Element_Type.TEXT_VALUE);

        // Checking link Twitter
        this.validateElememt(lnkTwitter, "Verify Element of Twitter link", Element_Type.DISPLAYED);

        // Checking link LinkedIn
        this.validateElememt(lnkLinked, "Verify Element of LinkedIn link", Element_Type.DISPLAYED);

        // Checking link Facebook
        this.validateElememt(lnkFacebook, "Verify Element of Facebook link", Element_Type.DISPLAYED);

        // Checking link InfoAuvenir
        this.validateElememt(lnkInfoAuvenir, "Verify Element of Info Auvenir link", Element_Type.DISPLAYED);

        // Checking Signature footer
        this.validateElememt(getEleSignatureMail(), "Verify Element of Signature footer", Element_Type.DISPLAYED);
    }

    /*

    Vien.Pham added new

        */
    public void verifyActiveEmailContent() {
        //Checking subject Active Email
        validateDisPlayedElement(eleSubjectActiveEmail, "Subject of Active Email");
        // Checking Content of subject Email is displayed
        validateElementText(eleSubjectActiveEmail, "Welcome to the Auvenir Audit Smarter Platform");
        validateElementText(eleWelcomeActiveEmail, "Welcome to Auvenir!");
        // Checking content mail
        validateElementText(eleInformActive, "Your account has been validated - when you are ready to audit smarter, click the button below to activate your account.");
        validateElementText(eleFeedbackInform, "We welcome your feedback, ideas and suggestions to make the audit experience better. Send us an email at feedback@auvenir.com.");
        //Checking Get Started button
        validateDisPlayedElement(eleGetStarted, "Get Started button");
        //Checking Feedback link
        validateDisPlayedElement(eleFeedbackLink, "feedback@auvenir.com link");
        // Checking Signature footer
        validateDisPlayedElement(eleSignatureMail, "Verify Element of Signature footer");
    }

    @FindBy(xpath = "//h2[contains(text(),'New user signed up to Auvenir system')]")
    WebElement subjectCustomerSuccessTeamEmail;

    @FindBy(xpath = "//p[contains(text(),'Hi Customer')]")
    WebElement bodyCustomerSuccessTeamEmail1;

    @FindBy(xpath = "//tbody/tr/td/p[2]")
    WebElement bodyEmailTable;

    public void verifyEmailToCustomerSuccessTeam(String auditorAccount, String fullName, String firmName) {
        this.validateElememt(subjectCustomerSuccessTeamEmail, "Verify subject of email to Customer success team", Element_Type.DISPLAYED);
        this.validateElememt(subjectCustomerSuccessTeamEmail, "New user signed up to Auvenir system", Element_Type.TEXT_VALUE);

        this.validateElememt(bodyCustomerSuccessTeamEmail1, "Verify body email to Customer success team", Element_Type.DISPLAYED);
        this.validateElememt(bodyCustomerSuccessTeamEmail1, "Hi Customer Success Team,", Element_Type.TEXT_VALUE);

        this.validateElememt(bodyEmailTable.findElement(By.xpath("./b[contains(text(),'"+fullName+"')]")),"",Element_Type.DISPLAYED);
        this.validateElememt(bodyEmailTable.findElement(By.xpath("./b[contains(text(),'"+fullName+"')]")),fullName,Element_Type.TEXT_VALUE);

        this.validateElememt(bodyEmailTable.findElement(By.xpath("./b[contains(text(),'"+firmName+"')]")),"",Element_Type.DISPLAYED);
        this.validateElememt(bodyEmailTable.findElement(By.xpath("./b[contains(text(),'"+firmName+"')]")),firmName,Element_Type.TEXT_VALUE);

        this.validateElememt(bodyEmailTable.findElement(By.xpath("./a[contains(text(),'"+auditorAccount+"')]")),"",Element_Type.DISPLAYED);
        this.validateElememt(bodyEmailTable.findElement(By.xpath("./a[contains(text(),'"+auditorAccount+"')]")),auditorAccount,Element_Type.TEXT_VALUE);

        this.validateElememt(eleSignatureMail, "Verify signature of email to Customer success team", Element_Type.DISPLAYED);


    }


    public void verifyAuditorInviteClientEmail() {

        //Checking subject Auditor invite Client
        this.validateElememt(getEleSubjectInviteClientEmail(), "Verify subject of Invite Email", Element_Type.DISPLAYED);
        //Checking content of Invite email
        this.validateElememt(getEleContent0InviteClientEmailClient(), "Verify content 0", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent1InviteClientEmailClient(), "Verify content 1", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent2InviteClientEmailClient(), "Verify content 2", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent3InviteClientEmailClient(), "Verify content 3", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent4InviteClientEmailClient(), "Verify content 4", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent5InviteClientEmailClient(), "Verify content 5", Element_Type.DISPLAYED);
        this.validateElememt(getEleContent6InviteClientEmailClient(), "Verify content 6", Element_Type.DISPLAYED);
        this.validateElememt(eleFeedbackInform, "Verify Feedback inform", Element_Type.DISPLAYED);
        //Checking footer of Invite Email
        this.validateElememt(getEleSignatureMail(), "Verify signature", Element_Type.DISPLAYED);
        //Checking getStarted
        this.validateElememt(eleGetStarted, "Verify Get started btn", Element_Type.DISPLAYED);
    }

    protected void isLoaded() throws Error {

        // checking header of Email is displayed
        this.validateElememt(this.getEleHeader(), "Elemnent of Header mail", Element_Type.DISPLAYED);

        // Checking footer of Email is displayed
        this.validateElememt(this.getEleFooter(), "Element of Footer mail", Element_Type.DISPLAYED);

        // Checking content of footer mail
        this.validateElememt(this.getEleContentLogoFooter(), "Audit, Smarter.", Element_Type.TEXT_VALUE);

        // Checking address Auvenir of footer mail
        this.validateElememt(this.getEleAddressMailFooter(), "225 Richmond Street West, Suite 402, Toronto, ON M5V1W2", Element_Type.TEXT_VALUE);

        // Checking "terms of service" link
        this.validateElememt(this.getEleLinkTermsFooter(), "Element terms of service", Element_Type.DISPLAYED);

        // Checking "privacy statament" link
        this.validateElememt(this.getEleLinkPrivacyFooter(), "Element of privacy", Element_Type.DISPLAYED);

        // Checking "un subscribe" link
        this.validateElememt(this.getEleLinkUnSubscribeFooter(), "Element of unsubscribe", Element_Type.DISPLAYED);

    }

    public void clickGetStartedButton() {
        getLogger().info("Click Get Started Button.");
        waitForVisibleElement(eleGetStarted, "Get Started.");
        clickElement(eleGetStarted, "Get Started.");
    }

    public void navigateToConfirmationLink() throws Exception {
        getLogger().info("Navigate to Confirmation Link");
        GmailPage gmailLoginPage = new GmailPage(getLogger(), getDriver());
        Thread.sleep(3000);
        String link = eleGetStarted.getAttribute("href");
        System.out.print("Link: " + link);

//        gmailLoginPage.gmailLogout();
        Thread.sleep(2000);
        clickGetStartedButton();
        switchToOtherTab(1);
//        if (GenericService.sBrowserData.equals("ff.")) {
//            getLogger().info("Accept alert.");
////            getDriver().switchTo().alert().accept();
//        }
//        getDriver().get(link);
//        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        getDriver().manage().window().maximize();
//        waitForProgressOverlayIsClosed();
    }

    // Element of header mail
    @FindBy(xpath = "//center/img[contains(@src,'png') and @alt='logo.png']")
    protected WebElement eleHeader;

    public WebElement getEleHeader() {
        return eleHeader;
    }

    // Element of logo footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']")
    protected WebElement eleLogoFooter;

    public WebElement getEleFooter() {
        return eleLogoFooter;
    }

    // Element of content Logo Footer mail
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[1]")
    protected WebElement eleContentLogoFooter;

    public WebElement getEleContentLogoFooter() {
        return eleContentLogoFooter;
    }

    // Element of Full Address Auvenir
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[2]")
    protected WebElement eleAddressMailFooter;

    public WebElement getEleAddressMailFooter() {
        return eleAddressMailFooter;
    }

    // Element of "terms of service" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/terms']")
    protected WebElement eleLinkTermsFooter;

    public WebElement getEleLinkTermsFooter() {
        return eleLinkTermsFooter;
    }

    // Element of "privacy statement" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[3]/a[@href='http://auvenir.s3corp.com.vn:5000/privacy']")
    protected WebElement eleLinkPrivacyFooter;

    public WebElement getEleLinkPrivacyFooter() {
        return eleLinkPrivacyFooter;
    }

    // Element of "unsubscribe" link
    @FindBy(xpath = "//span/img[contains(@src,'png') and @alt='icon.png']/parent::span/following-sibling::span[4]/a[@href='mailto:unsubscribe@auvenir.com?Subject=Unsubscribe']")
    protected WebElement eleLinkUnSubscribeFooter;

    public WebElement getEleLinkUnSubscribeFooter() {
        return eleLinkUnSubscribeFooter;
    }

    public void verifyGreetingTitle(String greetingTitleText) {
        validateElementText(titleGreeting, greetingTitleText);
    }

    public void verifySubjectEmail(String subjectContent) {
        validateElementText(subjectEmail, subjectContent);
    }

    public void verifyAnnouncementTitle(String text) {
        validateElementText(titleAnnouncement, text);
    }

    public void verifyAuvenirIntroducingContent(String text) {
        validateElementText(titleAuvenirIntroducing, text);
    }

    public void verifyIntroducingBenefitContent(String text) {
        validateElementText(titleIntroducingBenefit, text);
    }

    public void verifyFirstBenefitContent(String text) {
        validateElementText(titleFirstBenefit, text);
    }

    public void verifySecondBenefitContent(String text) {
        validateElementText(titleSecondBenefit, text);
    }

    public void verifyThirdBenefitContent(String text) {
        validateElementText(titleThirdBenefit, text);
    }

    public void verifyFeedbackContent(String text) {
        validateElementText(titleFeedback, text);
    }

    public void verifyGoodbyeContent(String text) {
        validateElementText(titleGoodbye, text);
    }

    public void verifySubjectEmailAuditorInviteClient(String auditorFullName, String subjectContent) {
        // Checking Content of subject Email is displayed
        String[] auditorName = auditorFullName.split(" ");
        String expectedSubjectContent = String.format(subjectContent, auditorName[0] + " " + auditorName[1].charAt(0));
        verifySubjectEmail(expectedSubjectContent);
    }

    public void verifyGreetingContentEmailAuditorInviteClient(String clientFullName, String greetingContent) {
        // Checking Greeting Content of Email is displayed
        String[] clientName = clientFullName.split(" ");
        verifyGreetingTitle(greetingContent + " " + clientName[0] +",");
    }

    public void verifyAnnouncementEmailAuditorInviteClient(String auditorFullName, String announcementContent) {
        String[] auditorName = auditorFullName.split(" ");
        String expectedAnnouncementTitle = String.format(announcementContent, auditorName[0]);
        verifyAnnouncementTitle(expectedAnnouncementTitle);
    }

    public void verifyBenefitContentEmailAuditorInviteClient(String introducingBenefit, String firstBenefitContent, String secondBenefitContent, String thirdBenefitContent) {
        verifyIntroducingBenefitContent(introducingBenefit);
        verifyFirstBenefitContent(firstBenefitContent);
        verifySecondBenefitContent(secondBenefitContent);
        verifyThirdBenefitContent(thirdBenefitContent);
    }

    /**
     * Waiting for The Progressing Overlay is closed.
     */
    public void waitForProgressOverlayIsClosed() {
        getLogger().info("Try to waiting the ProgressOverlayIsClosed.");
        waitForCssValueChanged(progressingDiv, "Progress Overlay", "display", "none");
    }

}
