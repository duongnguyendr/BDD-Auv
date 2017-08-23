package com.auvenir.ui.pages.marketing;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by toan.nguyenp on 4/11/2017.
 */
public class MarketingPage extends AbstractPage {

    public MarketingPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }


    /**
     * About page
     */
    //@FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    //private WebElement avenirLogo;
    //@FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui center aligned header header-main-text']")
    //private WebElement headerText;
    @FindBy(xpath = ".//*/div[@class='ui center aligned header header-main-text about-header']")
    private WebElement headerTextAbout;
    @FindBy(xpath = ".//*[@id='about-league']/h2")
    private WebElement meetTheAuvyLeagueText;
    @FindBy(xpath = ".//img[@src='/static/images/about/img_teammember_alex.png']")
    private WebElement alexImage;
    @FindBy(xpath = ".//*[@id='about-league']//h4[contains(text(),'Alex McCooey')]")
    private WebElement alextNameText;
    @FindBy(xpath = ".//*[@id='about-league']/div/div[1]/p")
    private WebElement alextTitleText;
    @FindBy(xpath = ".//*[@id='about-joinUs']/div/h2")
    private WebElement wannaJoinUsText;
    @FindBy(xpath = ".//*[@id='about-joinUs']/div/a")
    private WebElement viewCareerBTN;
    @FindBy(xpath = ".//*[@id='about-highlightPhotos']/h2")
    private WebElement highlightSoFourWeekendText;
    @FindBy(xpath = ".//img[@src='/static/images/about/img-wkphoto_01.png']")
    private WebElement firstImage;

    /**
     * Careers page
     */
    private String marketingHeaderTextCst = "We are growing. Come join our team.";
    private String careersAtAuvenirTextCst = "Careers at Auvenir";
    private String errorPwdMesg1 = "Please enter a password and least 8 characters, have a capital letter, lower case letter, a number and a special character (!@#$%^&*)";
    private String errorPwdMesg2 = "Your passwords don't match.";
    //@FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    //private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='row']/div")
    private WebElement marketingHeaderText;
    @FindBy(xpath = ".//*[@id='career']//h1[@class='page-title']")
    private WebElement careersAtAuvenirText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Engineering')]")
    private WebElement EngineeringText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Product')]")
    private WebElement ProductText;
    @FindBy(xpath = ".//*[@id='career']//div[contains(text(),'Sales')]")
    private WebElement SalesText;

    /**
     * Contact page
     */
    private String headerTextCst = "Get In Touch! We are here to support you and would love to hear your feedback.";
    private String getInTouchTextCst = "Get in Touch with Auvenir\n" + "We will respond within 24 hours.";
    //@FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    //private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*/div[@class='ui center aligned header header-main-text']")
    private WebElement headerText;
    @FindBy(xpath = ".//*[@id='contact-form']/div[1]/div/h2")
    private WebElement getInTouchText;
    @FindBy(xpath = ".//input[@name='name']")
    private WebElement nameTextBox;
    @FindBy(xpath = ".//input[@name='email']")
    private WebElement contactEmailTextBox;
    @FindBy(xpath = "//div[@class='ui selection dropdown']")
    private WebElement directMessageDropdown;
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageTextBox;
    @FindBy(xpath = ".//*[@id='contact-form']/form/button")
    private WebElement sendMessageBTN;
    @FindBy(xpath = ".//*[@id='contact_map']")
    private WebElement contactMapImage;

    /**
     * Cookie Notice Page
     */
    //@FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    //private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui text container cookie-banner']")
    private WebElement cookiesNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//h1/div")
    private WebElement auvenirCookieNoticeText;
    @FindBy(xpath = ".//*[@id='cookie-page']//div[@class='ui text container cookie-content']")
    private WebElement ookiesNoticecontentText;
    private String cookiesNoticeTextCst = "Cookie Notice";
    private String auvenirCookieText = "Auvenir Cookie Notice";
    private String auvenirCookiesNoticeTextCst = "Auvenir uses cookies to improve the user experience and ensure that it is functioning effectively.\n" +
            "This Cookie Notice is part of our Privacy Statement. For more information about us, and how we protect visitor information, please see our Privacy Statement.\n" +
            "In order to provide you with a more personalized and responsive service we need to remember and store information about how you use Auvenir. This is done using small text files called cookies. Cookies contain small amounts of information and are downloaded to your computer or other device by a server for Auvenir. Your web browser then sends these cookies back to Auvenir on each subsequent visit so that it can recognize you and remember things like your user preferences. You can find more detailed information about cookies and how they work at http://www.aboutcookies.org/.\n" +
            "Whenever you use Auvenir, information may be collected through the use of cookies and other technologies. By using Auvenir you agree to our use of cookies as described in this Cookie Notice and also to the use of cookies on the other country, regional or practice specific websites contained in deloitte.com that you may visit, as described in their accompanying cookie notices.\n" +
            "What Cookies Do We Use and Why?\n" +
            "Some of the cookies we use are necessary to enable you to move around Auvenir and use its features such as accessing secure areas that may contain content for registered users.\n" +
            "We also use functional cookies to record information about the choices you have made and to allow us to tailor the site to our users; for example, to remember your language or region or that you have already completed a survey. This information is usually anonymized and is not used for any other purpose.\n" +
            "We or our service providers also use analytic services to help us understand how effective our content is, what interests our users have, and to improve how Auvenir works. In addition, we use web beacons or tracking pixels to count visitor numbers and performance cookies to track how many individual users access Auvenir and how often. This information is used for statistical purposes only and it is not our intention to use such information to personally identify any user. However, if you have registered and signed into Auvenir we may combine this information with information from our web analytic services and cookies to analyze how you use Auvenir in more detail.\n" +
            "Auvenir does not use Targeting Cookies to deliver targeted advertising to visitors.\n" +
            "Please contact us at info@auvenir.com if you would like more detailed information on the cookies we use.\n" +
            "How To Control Cookies\n" +
            "By using Auvenir you agree that we can place cookies on your computer or device as explained above. However, you can control and manage cookies in various ways. Please bear in mind that removing or blocking cookies can impact on your user experience and parts of Auvenir may no longer be fully accessible.\n" +
            "Browser Controls\n" +
            "Most browsers will allow you to see what cookies you have and delete them on an individual basis or block cookies from particular or all websites. Be aware that any preference you have set will be lost if you delete all cookies, including your preference to opt-out from cookies as this itself requires an opt-out cookie to have been set. For more information on how to modify your browser settings to block or filter cookies, see http://www.aboutcookies.org/ or http://www.cookiecentral.com/faq/.\n" +
            "Managing Analytics cookies\n" +
            "You can opt-out of having your anonymized browsing activity within websites recorded by analytics cookies. We use the following service providers and you can learn more about their privacy policies and how to opt-out of their cookies by clicking on following links:\n" +
            "Adobe: http://www.adobe.com/privacy/opt-out.html\n" +
            "Google Analytics: http://www.google.com/analytics/learn/privacy.html\n" +
            "Managing Local Shared Objects or Flash Cookies\n" +
            "A local shared object or flash cookie is like most other browser cookies except that it can store additional types of information. These cookies cannot be controlled using the mechanisms listed above. Some parts of Auvenir use these types of cookies to store user preferences for media player functionality and without them some video content may not play properly. These cookies can be controlled manually by visiting the Adobe website.\n" +
            "http://www.macromedia.com/support/documentation/en/flashplayer/help/settings_manager07.html\n" +
            "Social Buttons\n" +
            "We use ‘social buttons’ to enable our users to share or bookmark web pages. These are buttons for third party social media sites and these sites may log information about your activities on the Internet including on Auvenir. Please review the respective terms of service and privacy statement of these sites to understand exactly how they use your information and to find out how to opt-out, or delete, such information.\n" +
            "External Web Services\n" +
            "We sometimes use external web services on Auvenir to display content within the web pages of Auvenir, for example to display images, show videos or run polls. As with the social buttons, we cannot prevent these sites, or external domains, from collecting information on your use of this embedded content.\n" +
            "Email Communications\n" +
            "We may also use tracking technologies to determine whether you have read, clicked on, or forwarded certain email communications we send to you so that we can make our communications more helpful and interesting. If you do not wish us to confirm whether you have opened, clicked on or forwarded our communications, you will need to unsubscribe, as it is not possible for us to send these emails without tracking enabled. Registered subscribers can update their communication preferences at any time by contacting us at info@auvenir.com, or you can unsubscribe following the instructions in the individual email communications you receive from us.\n" +
            "Changes To This Cookie Notice\n" +
            "We may modify or amend this Cookie Notice from time to time at our discretion. When we make changes to this notice, we will amend the revision date at the top of this page, and such modified or amended Cookie Notice shall be effective as to you and your information as of that revision date. We encourage you to periodically review this Cookie Notice to be informed about how we are using cookies.";

    /**
     * Home page
     */
    private static final String WHY_AUVENIR_CONTENT_TEXT ="Your time and your business.";
    private static final String WHY_AUVENIR_END_TEXT ="A smarter audit means a straightforward, faster process that gives you back time to focus on" +
            " higher value services and activities in your practice. It means improved client collaboration and interaction, giving you stronger client relationships and more referrals. A smarter audit experience means a better way of doing business.";
    private String whyAuvenirText2Cct = "We have developed a robust collaboration tool for auditors and their clients as well as patent pending machine learning software that automates a great deal of the audit process.";
    private String belowProductFeaturesTextCst = "Our platform re-imagines the audit, making it smarter for all parties.";
    private String spendLessTimeDescriptionTextCst = "Automate mundane tasks, freeing up time for higher value services and a better ROI";
    @FindBy(xpath = "//*[@id='language-flag']/button")
    private WebElement changeLanguageBTN;
    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement loginBTN;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = ".//*[@id='login-popup']//button")
    private WebElement submitBTN;
    //    @FindBy(xpath = "//*[@class='ui label userAligment']")
    @FindBy(xpath = "//*[@class='au-dropdown-trigger']")
    private WebElement profileLink;
    //    @FindBy(xpath = "//div[@class='menu transition visible']//div[2]/span")
    @FindBy(xpath = "//*[@id='h-ddl-signOut']")
    private WebElement logoutBTN;
    @FindBy(xpath = "//*/a[@class='ui large basic inverted button']")
    private WebElement signUpBTN;
    @FindBy(xpath = "//div[@class='ui center aligned container']//div[@class='ui error message']//div/p")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@class='ui center aligned container']//div[@class='ui error message']")
    private WebElement errorMessageBorder;
    @FindBy(xpath = "//*/form[@class='ui error form login-form']//input[@name='email']")
    private WebElement userError;
    @FindBy(xpath = "//*/form[@class='ui error form login-form']//input[@name='password']")
    private WebElement passwordError;
    @FindBy(xpath = "//form[@class='ui form login-form']//a[@class='ui label forgot-password']")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//span[@class='forgot-title']")
    private WebElement forgotPasswordTitle;
    @FindBy(xpath = "//form[@class='ui form forgot-form']//input")
    private WebElement emailForgotPasswordTextBox;
    @FindBy(xpath = "//button[contains(text(),'Request Reset Link')]")
    private WebElement requestResetLinkBTN;
    @FindBy(xpath = "//div[@class='error field']//input")
    private WebElement EmailForgotPasswordTextBox;
    @FindBy(xpath = "//div[@id='forgot-popup']//div[@class='ui error message']")
    private WebElement EmailForgotPasswordMessage;
    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.svg']")
    private WebElement avenirLogo;
    @FindBy(xpath = ".//*[@id='marketing-header']//h1")
    private WebElement weHelpYouAuditSmarterText;
    @FindBy(xpath = ".//*[@id='marketing-header']//a[contains(text(),'Join as an Auditor Today')]")
    private WebElement joinAsAnAuditorTodayText;
    @FindBy(xpath = ".//*[@id='home_mission']/h2[contains(text(),'Our Mission')]")
    private WebElement ourMissionText;
    @FindBy(xpath = ".//*[@id='home_mission']/p[1]")
    private WebElement ourMissionText1;
    @FindBy(xpath = ".//*[@id='home_mission']/p[2]")
    private WebElement ourMissionText2;
    @FindBy(xpath = ".//*[@id='home_mission']/p[3]")
    private WebElement ourMissionText3;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//h2[contains(text(),'Why Auvenir?')]")
    private WebElement whyAuvenirText;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//div[@class='middle aligned column why-auvenir-content']/p[1]")
    private WebElement whyAuvenirText1;
    @FindBy(xpath = ".//*[@id='home_whyAuvenir']//div[@class='middle aligned column why-auvenir-content']/p[2]")
    private WebElement whyAuvenirText2;
    @FindBy(xpath = ".//*[@id='home_productFeatures']/header/h2")
    private WebElement productFeaturesText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']/header/p")
    private WebElement belowProductFeaturesText;
    @FindBy(xpath = "//img[@src='/static/images/home/time-money.svg']")
    private WebElement spendLessTimeImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Spend Less Time, Earn More')]")
    private WebElement spendLessTimeText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[1]/p")
    private WebElement spendLessTimeDescriptionText;

    @FindBy(xpath = "//img[@src='/static/images/home/locked-cloud.svg']")
    private  WebElement eleSecurelyStoreYourDocumentsImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Securely Store Your Documents')]")
    private WebElement eleSecurelyStoreYourDocumentsText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[2]/p")
    private WebElement eleSecurelyStoreYourDocumentsDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/clipboard.svg']")
    private  WebElement eleSimplifyYourWorkFlowImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Simplify Your Workﬂow')]")
    private WebElement eleSimplifyYourWorkFlowText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[3]/p")
    private WebElement eleSimplifyYourWorkFlowDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/files-in-folder.svg']")
    private  WebElement eleCollaborateBetterWithYourClientsImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Collaborate Better With Your Clients')]")
    private WebElement eleCollaborateBetterWithYourClientsText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[4]/p")
    private WebElement eleCollaborateBetterWithYourClientsDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/handshake.svg']")
    private  WebElement eleIntelligentlyAllocateResourcesImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Intelligently Allocate Resources')]")
    private WebElement eleCIntelligentlyAllocateResourcesText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[5]/p")
    private WebElement eleIntelligentlyAllocateResourcesDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/download-cloud.svg']")
    private  WebElement eleSeamlesslyImportDataImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Seamlessly Import Data')]")
    private WebElement eleCSeamlesslyImportDataText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[6]/p")
    private WebElement eleSeamlesslyImportDataDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/laptop.svg']")
    private  WebElement eleCustomizeBrandingImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Customize Branding')]")
    private WebElement eleCustomizeBrandingText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[7]/p")
    private WebElement eleCustomizeBrandingDescription;

    @FindBy(xpath = "//img[@src='/static/images/home/gears.svg']")
    private  WebElement eleAutomatedToolsImage;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//h4[contains(text(),'Automated Tools (Coming Soon)')]")
    private WebElement eleAutomatedToolsText;
    @FindBy(xpath = ".//*[@id='home_productFeatures']//div[8]/p")
    private WebElement eleAutomatedToolsDescription;




    @FindBy(xpath = "//a[@href='/about']")
    private WebElement aBoutLink;
    @FindBy(xpath = "//a[@href='/contact']")
    private WebElement contactLink;
    @FindBy(xpath = "//a[@href='/cookies']")
    private WebElement cookiesNoticeLink;
    @FindBy(xpath = "//a[@href='/privacy']")
    private WebElement privacyPolicyLink;
    @FindBy(xpath = "//a[@href='/terms']")
    private WebElement termsOfService;


    private static final String SECURELY_STORE_YOUR_DOCUMENT_DESCRIPTION = "Cloud-based file storage, encrypted and stored on SOC compliant servers";
    private static final String SIMPLIFY_YOUR_WORK_FLOW_DESCRIPTION = "Customize the client request list & rollover previous engagements";
    private static final String COLLABORATE_BETTER_WITH_YOUR_CLIENTS_DESCRIPTION = "Efﬁciently manage your engagements";
    private static final String INTELLIGENTLY_ALLOCATE_RESOURCES_DESCRIPTION = "Manage team stafﬁng, access and permissions";
    private static final String SEAMLESSLY_IMPORT_DATA_DESCRIPTION ="Integrate with bank and accounting software";
    private static final String CUSTOMIZE_BRANDING_DESCRIPTION = "Display your brand prominently on your client's portal";
    private static final String AUTOMATION_TOOL_DESCRIPTION ="Generate working papers, contract analysis and extracting information from documents";

    /**
     * Privacy Policy page
     */
    private String privacyPolicyTextContentCst = "Introduction\n" +
            "This Privacy Statement applies to the Auvenir.com website (the “Auvenir Site”) and all related software, mobile applications, documentation, services, products, and content (collectively, and together with the Auvenir Site, “Auvenir”)\n" +
            "When used in this Privacy Statement, “we,” “us,” and “our” refers to Auvenir, a general partnership formed under the laws of Canada. This Privacy Statement explains how we protect visitors’ information gathered via Auvenir. By using Auvenir you are agreeing to the use of your information as described in this Privacy Statement.\n" +
            "Auvenir may contain links to other sites which may not be governed by this privacy statement. We encourage users to review each website’s privacy statement before disclosing any personal information. If you have any questions regarding this Privacy Statement, please contact info@auvenir.com.\n" +
            "Information Collection\n" +
            "To use Auvenir, you must first complete a registration form and provide certain personal information to sign up for an Auvenir account. We only collect personal information that is specifically and voluntarily provided by you. Such information may consist of, but is not limited to, your name, email, phone number, position, organization, and profile photo.\n" +
            "We do not usually seek information relating to your race or ethnic origin, religious beliefs, criminal record, physical or mental health, or sexual orientation. We will, if applicable, obtain your explicit consent to collect and use such information in accordance with applicable laws.\n" +
            "Log Information, Cookies, and Web Beacons\n" +
            "Auvenir may collect standard internet log information including your IP address, browser type and language, access times, and referring website addresses. We may also automatically collect information about you such as your device type, mobile network, and version of the app being used.\n" +
            "Auvenir may use cookies (small text files stored in a user’s browser) to identify users when they connect to Auvenir. If Auvenir uses cookies, a user’s browser must be enabled to allow cookies in order to access Auvenir. Upon successful login, cookies are created and placed on the user’s computer or device. In addition to information related to authentication, information may be stored in the cookies in order to direct a user to the correct site location. To ensure that Auvenir is well managed and to facilitate improved navigation, we or our service providers may also use cookies or Web beacons (electronic images that allow the Website to count visitors who have accessed a particular page and to access certain cookies) to collect aggregate data. Additional information on how we use cookies and other tracking technologies and how you can control these can be found in our cookie notice. By using this Website, you agree that we can place cookies on your computer or device.\n" +
            "Most browsers can be set to inform you when a cookie has been sent to you and provide you with the opportunity to reject that cookie. However, refusing a cookie may, in some cases, preclude you from using, or negatively impact the display or function of, Auvenir or some of its areas or features.\n" +
            "Information Use\n" +
            "This Privacy Statement applies to the Auvenir.com website (the “Auvenir Site”) and all related software, mobile applications, documentation, services, products, and content (collectively, and together with the Auvenir Site, “Auvenir”)\n" +
            "When used in this Privacy Statement, “we,” “us,” and “our” refers to Auvenir, a general partnership formed under the laws of Canada. This Privacy Statement explains how we protect visitors’ information gathered via Auvenir. By using Auvenir you are agreeing to the use of your information as described in this Privacy Statement.\n" +
            "Auvenir may contain links to other sites which may not be governed by this privacy statement. We encourage users to review each website’s privacy statement before disclosing any personal information. If you have any questions regarding this Privacy Statement, please contact info@auvenir.com.\n" +
            "Disclosure of Information to Third Parties\n" +
            "Personal information may be disclosed to other Deloitte Network entities and other third parties in order to respond to your requests or inquiries, as part of a corporate transaction (such as a sale, divestiture, reorganization, merger or acquisition), or where those parties handle information on our behalf. All of these disclosures may involve the transfer of personal information to countries, regions, or areas where other Deloitte Network entities, our service providers, and other third parties are located, and these may not have data protection rules similar to those in effect in your area of residence. As used in this Privacy Statement, the “Deloitte Network” refers to Deloitte Touche Tohmatsu Limited, a UK private company limited by guarantee (“DTTL”), its network of member firms, and their related entities.\n" +
            "Personal information may also be disclosed to law enforcement, regulatory, or other government agencies, or to other third parties, in each case to comply with legal or regulatory obligations or requests.\n" +
            "By using or providing information through Auvenir, you are consenting to the disclosures described above.\n" +
            "Blogs, Forums, Wikis and Other Social Media\n" +
            "Auvenir may host or provide access to various blogs, forums, wikis, and other social media applications or services that allow you to share content with other users (collectively, “Social Media Applications”). Any personal information or other information that you contribute to any Social Media Application can be read, collected, and used by other users of that Social Media Application over whom we have little or no control. Therefore, we are not responsible for any other user’s use, misuse, or misappropriation of any personal information or other information that you contribute to any Social Media Application.\n" +
            "Access to Information\n" +
            "Visitors who choose to register on or with Auvenir may access their user profile, correct, and update their details, or unsubscribe from communications at any time. Visitors who have any problem accessing their profiles, or would like to request a copy of their personal information should contact webmaster services using the contact us link in Auvenir. In all cases we will treat requests to access information or change information in accordance with applicable legal requirements.\n" +
            "Information Security\n" +
            "We have in place reasonable commercial standards of technology and operational security to protect all information provided by visitors via Auvenir from unauthorized access, disclosure, alteration, or destruction.\n" +
            "Changes to Our Privacy Statement\n" +
            "We may modify or amend this Privacy Statement from time to time at our discretion. When we make changes to this Privacy Statement, we will amend the revision date at the top of this page, and such modified or amended Privacy Statement shall be effective as to you and your information as of that revision date. We encourage you to periodically review this Privacy Statement to be informed about how we are protecting your information.\n" +
            "Questions\n" +
            "If you have any questions or concerns regarding your privacy while using Auvenir, please send an email to info@auvenir.com.";
    //@FindBy(xpath = "//img[@src='static/images/logo-auvenir.png']")
    //private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[contains(text(),'Privacy Policy')]")
    private WebElement privacyHeaderText;
    @FindBy(xpath = ".//*[@id='privacy-page']//h1/div")
    private WebElement auvenirPrivacyPolicyText;
    @FindBy(xpath = ".//*[@id='privacy-page']//div[@class='ui text container privacy-content']")
    private WebElement privacyPolicyTextContent;

    /**
     * Terms page
     */
    private String termsContentTextCst = "These Terms of Service (these “Terms”) govern your access to and use of the Auvenir.com website (the \" " +
            "+\n" + "            \"“Auvenir Site”) and all related software, mobile applications, documentation, services, products, and content (collectively, and together with the Auvenir Site, “Auvenir”).\\n\" + \"\\n\" + \"You agree to these Terms either by using Auvenir or by clicking the “I AGREE” (or similar) box when creating your Auvenir user account. If you do not agree with these Terms, then you are not allowed to use Auvenir, and you should stop using it immediately.\\n\" + \"If you have questions about these Terms or Auvenir, you should contact info@auvenir.com.\\n\" + \"1. Who These Terms Apply to and What They Govern\\n\" + \"\\n\" + \"1.1. To use Auvenir, you must agree to these Terms on behalf of yourself and the company, organization, or other legal entity that you work for as a partner, principal, director, employee, or contractor (“Your Company”). Thereafter, these Terms will be a legally binding contract between us, on the one hand, and you and Your Company, on the other.\\n\" + \"\\n\" + \"1.2. Your Company’s Affiliates. Subject to the terms of service of these Terms, Your Company’s Affiliates may also use Auvenir to the same extent Your Company is permitted under these Terms. If Your Company’s Affiliates use Auvenir, then either (a) you have the power and authority to bind each Affiliate these Terms or (b) if you do not have the power and authority to do so, then Your Company will be liable for any action or inaction of its Affiliates that violates these Terms. If you have the power and authority to bind Your Company’s Affiliates, then (i) each Affiliate will be a party to these Terms, (ii) these Terms will be a legally binding contract between us, on the one hand, and you, Your Company, and each those Affiliates, on the other, and (iii) for purposes of these Terms, “Your Company” will mean, collectively, Your Company and its Affiliates. As used in these Terms, “Affiliate” means an entity that controls, is controlled by, or under common control with, Your Company.\\n\" + \"\\n\" + \"1.3. Deloitte Network Affiliation. Although we are affiliated with the Deloitte Network and parts of these Terms may refer to other Deloitte Network entities, these Terms are only with us and not with any of those other entities. As used in these Terms, the “Deloitte Network” refers to Deloitte Touche Tohmatsu Limited, a UK private company limited by guarantee (“DTTL”), its network of member firms, and their related entities. Please visit deloitte.com/about to learn more about the Deloitte Network.\\n\" + \"\\n\" + \"1.4. Third Party Services. Auvenir may contain features designed to operate with third-party applications, websites, tools, and resources (“Third Party Services”), such as Quickbooks, Xero, and online banking services. In addition to Third Party Services, some of Auvenir’s links and contact information may lead to third party resources, websites, or tools (“Third Party Resources”). If you use any Third Party Service or Third Party Resource, you or Your Company may need to create an account with the applicable provider and agree to and comply with terms of use, terms of service, privacy policy, or other related agreement for that Third Party Service or Third Party Resource, as applicable (“Third Party Terms”).\\n\" + \"\\n\" + \"1.5. Supplemental Terms. Auvenir consists of various services, applications, tools, and websites, and in addition to these Terms and any applicable Third Party Terms, you and Your Company may need to agree to supplemental terms that will apply to your access and use of a specific service, application, tool, or website (“Supplemental Terms”). We will either display those Supplemental Terms in the applicable service, application, tool, or website, or we will include them in, or link to them from, these Terms.\\n\" + \"2. Registering To Use Auvenir; User Accounts\\n\" + \"\\n\" + \"2.1. General Eligibility Requirements. To be eligible to use Auvenir: (a) you must be at least 18 years old; (b) you must have full power and authority to enter into these Terms on behalf of yourself and Your Company; and (c) you cannot be prohibited from entering into these Terms or using any portion of Auvenir by us, Your Company, or any other party, or by any contract, law, regulation, rule, or professional standard. You hereby represent and warrant to us that you meet these eligibility requirements, and you shall promptly notify us if you no longer comply with them due to a change in circumstances.\\n\" + \"\\n\" + \"2.2. Additional Eligibility Requirements for Auditors. If you are an auditor, then, in addition to the eligibility requirements listed above: (a) you and Your Company must have in good standing all licenses, certifications or other authorizations required to perform audit or attest services in each jurisdiction where they are required; (b) you and Your Company have received all necessary approvals, consents and other authorizations to use Auvenir that are required from regulators, other governmental authorities, and your clients; and (c) your and Your Company’s audit or attest services must be performed in accordance with, and any resulting audit opinion must be issued under, Canadian Auditing Standards. You and Your Company hereby represent and warrant to us that you and Your Company meet these eligibility requirements, and you shall promptly notify us if you or Your Company no longer comply with them due to a change in circumstances.\\n\" + \"\\n\" + \"2.3. Creating and Using Your User Account. You will need a username and password to access and use Auvenir (a “User Account”). You can create your User Account by signing up on the Auvenir Site. When signing up for a User Account, you shall not submit any false, inaccurate, or misleading information. You may create and maintain only one User Account for yourself, and you cannot have multiple User Accounts, unless you have a business reason to do so (e.g., you work for multiple companies). Your User Account is for you alone, and you cannot share or transfer it to anyone else. You and Your Company are responsible for anything that happens through your User Account, unless and until you or Your Company request deactivation in accordance with these Terms. You and Your Company shall keep your User Account details and password secure and confidential. If your employment or other work relationship with Your Company is terminated for any reason, then you must immediately stop using your User Account, and Your Company shall promptly notify us in writing of that termination and request deactivation of your User Account in accordance with the next section.\\n\" + \"\\n\" + \"2.4. Deactivating Your User Account. At any time, you or Your Company may deactivate your User Account. To deactivate it, you or Your Company must send us a written notice in accordance with Section 15, which will be effective when we process it. We may deactivate your User Account at any time for any reason or no reason, with or without notice to you, including if your User Account is inactive for an extended time period. Our deactivation will be effective immediately, unless we specify otherwise in a notice that we send to you or Your Company. Deactivating your User Account will result in the immediate termination of your ability to access Auvenir. We may also bar you from using Auvenir and block access from any IP address or range of IP addresses associated with you. These Terms will survive deactivation of your User Account, except for Section 3.1 which will terminate when your User Account is deactivated.\\n\" + \"3. USING AUVENIR.\\n\" + \"\\n\" + \"3.1. Right to Access and Use. On the condition that you comply with these Terms (including any Supplemental Terms) and any separately documented payment obligation to us, we grant you a limited, revocable, nonexclusive, non-assignable, non-sublicensable right to access and use Auvenir.\\n\" + \"\\n\" + \"3.2. Acceptable Use. You may use Auvenir only in accordance with these Terms (including any applicable Supplemental Terms), and when using Auvenir, the following terms apply:\\n\" + \"\\n\" + \"You and Your Company shall not:\\n\" + \"Rent, resell, lease, lend, sublicense, or otherwise attempt to transfer any of your or Your Company’s rights to access and use Auvenir;\\n\" + \"Reverse engineer, decompile or otherwise attempt to derive the source code for any software related to Auvenir, or adapt, modify, or create derivative works based on Auvenir or any software code (including any Mobile App (as defined below)), program, methodology, process, tool, or device contained in or underlying Auvenir (collectively, the “Auvenir Technology”);\\n\" + \"Except as expressly permitted in these Terms, copy, download, reproduce, modify, or distribute any Auvenir Technology, except as expressly permitted elsewhere in writing outside of these Terms; or\\n\" + \"Bypass any measures we may use to prevent or restrict access to Auvenir (or other accounts, computer systems or networks connected to Auvenir).\\n\" + \"You and Your Company shall comply with all laws and regulations applicable to accessing and using Auvenir, including all data privacy, export control, copyright, and securities laws and regulations. You and Your Company also represent and warrant that neither you nor Your Company are (i) located in a country that is subject to a U.S. or other government embargo, or that has been designated by the U.S. or another government as a “terrorist supporting” country or (ii) listed on any U.S. or another government’s list of prohibited or restricted parties.\\n\" + \"In addition, if you are an auditor, then you and Your Company shall comply with all applicable rules of professional conduct relating to the provision of audit or attest services.\\n\" + \"You shall not remove any copyright, trademark, or other proprietary rights notices found in Auvenir or any Auvenir Content. As used in these Terms, “Auvenir Content” means, other than any of your Uploaded Data (as defined below), any data, text, audio, video, image or other content that is made available on the Auvenir Site or otherwise in connection with Auvenir, including any data, text, audio, video, image or other content made available by third parties.\\n\" + \"You and Your Company shall not:\\n\" + \"Employ manual or automated software, devices, or other processes to “crawl,” “web-scrape” or “spider” any page of Auvenir; or\\n\" + \"Otherwise engage in any action that directly or indirectly interferes with the proper working of, or places an unreasonable load on, our or our Supplier’s infrastructure, including spamming or the distribution of computer viruses or other malicious code.\\n\" + \"You and Your Company shall maintain the confidentiality of the Auvenir Content and Auvenir Technology using at least the same degree of care as you and Your Company use in maintaining your own proprietary and/or confidential information, but in no event using less than a reasonable degree of care.\\n\" + \"You and Your Company shall not use Auvenir to (i) distribute any unauthorized or unsolicited advertising or junk or bulk email (“spamming”) or (ii) advertise any contests or sweepstakes.\\n\" + \"You and Your Company shall promptly notify us upon becoming aware of any unauthorized use of your User Account or any other breach of this Section 3.2.\\n\" + \"4. Uploaded Data\\n\" + \"\\n\" + \"4.1. Ownership of Uploaded Data. As used in these Terms, “Uploaded Data” means the data, documents, files, comments and other information or materials that you upload or otherwise transfer to us for processing, storage or hosting in connection with your use of Auvenir. You or Your Company, as applicable, owns the Uploaded Data, and we do not claim ownership to it.\\n\" + \"\\n\" + \"4.2. Obligations Related to Uploaded Data. You and Your Company are solely responsible for your Uploaded Data, and without limiting the foregoing, you and Your Company shall ensure the following:\\n\" + \"\\n\" + \"Your Company has appropriately authorized you to provide the Uploaded Data.\\n\" + \"The Uploaded Data does not contain any content that could be reasonably viewed as false, offensive, indecent, defamatory, libelous, harassing, threatening, or otherwise harmful.\\n\" + \"The Uploaded Data, and your providing of it, does not violate any applicable law, regulation, rule, or professional standard, including any third party privacy right, or third party copyright, trademark, or other intellectual property right.\\n\" + \"4.3. Access to and Use of Uploaded Data. You and Your Company agree to the following with respect to access and use of Uploaded Data:\\n\" + \"\\n\" + \"Uploaded Data will be available to us and may be available to our Suppliers (defined below), and we and our Suppliers may access Uploaded Data for limited periods of time in some limited circumstances, such as site administration, troubleshooting, system maintenance, emergencies, or other technical support, or if required by law or other valid legal process. If we are obligated to respond to a third party subpoena or other compulsory legal order or process, Your Company shall reimburse us for reasonable attorneys’ fees, as well as our employees’ and Suppliers’ time and materials spent responding to the third party subpoena or other compulsory legal order or process at our then-current hourly rates.\\n\" + \"To improve Auvenir and its services, Auvenir may analyze Uploaded Data using machine learning and other automated techniques. This analysis may happen when the Uploaded Data is sent or received or while it is being stored. We may also extract anonymized data from Uploaded Data for aggregation with similar data from other Auvenir users and third parties and such aggregated and anonymized data may be made available to you, other Auvenir users, and other third parties (including other entities in the Deloitte Network) for benchmarking purposes, data analysis, publications, and other activities. We will maintain the confidentiality of your and Your Company’s identity when performing such tasks. We are not obligated, however, to provide you or Your Company with any such aggregated and anonymized data.\\n\" + \"If you authorize other third parties to access your Uploaded Data, we may provide the Uploaded Data to them, and we have no responsibility or liability for their use of the Uploaded Data.\\n\" + \"Although we are not required to do so, we may review and remove some or all of the Uploaded Data if we believe it violates these Terms or if it is outdated or no longer relevant to your use of Auvenir.\\n\" + \"Auvenir may be hosted, supported, or maintained in countries outside of your home jurisdiction, and Uploaded Data may be stored in those countries. As such, this may involve the transfer of Uploaded Data (including personal information) to countries or regions without data protection rules similar to those in effect in your home jurisdiction. By registering for or using Auvenir, you and Your Company consent to, and confirm that all legally required authorizations have been obtained for, those transfers and the storage of Uploaded Data (including personal information) in those countries. For more information, please see our Privacy Statement Privacy Statement.\\n\" + \"4.4. No Guarantee of Storage.\\n\" + \"\\n\" + \"Auvenir is not a long-term document archive or storage service. We are not required to store, maintain, or provide you or Your Company with any Uploaded Data. If your access to Auvenir is terminated for any reason, you will no longer be able to access your Uploaded Data and we may delete it. Therefore, you and Your Company will need to backup all of your Uploaded Data and keep separate copies of it.\\n\" + \"If you are an auditor, you should not use Auvenir for long-term storage of your work papers, and you and Your Company will be responsible for using other methods to comply with professional standards relating to the storage of work papers and audit engagement data.\\n\" + \"5. User Community\\n\" + \"\\n\" + \"5.1. User Community Applications and Content. Auvenir may host or provide access to various blogs, forums, wikis, and other social media applications or services that allow you to share content with other Auvenir users (collectively, “ User Community Applications”). These User Community Applications will allow Auvenir users to submit, post, email, display, transmit or otherwise make available comments, reviews, links, materials, ideas, opinions, messages and other content and information (“User Community Content”).\\n\" + \"\\n\" + \"5.2. Posting User Community Content. If you submit, post, email, display, transmit or otherwise make available any User Community Content, you represent to us that you have all the necessary legal rights to do so and that User Community Content will not violate any law or the rights of any person. When you submit, post, email, display, transmit or otherwise make available User Community Content in a User Community Application, you grant us a non-exclusive, transferable, worldwide, fully paid-up, royalty-free, perpetual, irrevocable, sub-licensable right and license to use, distribute, publicly perform, display, translate, adapt, reproduce, and create derivative works from your User Community Content in any and all media or technology, now known or later developed, in any manner, in whole or part, with or without attribution, without any duty to compensate you. You also waive all moral rights you may have in any of your User Community Content. We may modify or alter your User Community Content without seeking your permission, and we may also remove any User Community Content for any reason and without notice to you.\\n\" + \"\\n\" + \"5.3. Other Users’ Content. You understand and agree that User Community Content includes information, views, opinions, and recommendations of many different Auvenir users, and you are responsible for properly analyzing and verifying any information you intend to rely upon. We do not endorse any User Community Content, including any recommendation or opinion made by any user. We do not routinely screen, edit, or review User Community Content. You should also be aware that other users may use Auvenir for personal gain, and therefore, please approach messages with appropriate skepticism. User Content may be misleading, deceptive, or in error. We will not be liable under any circumstance for any User Community Content, including errors or omissions in any User Community Content, or any loss or damage of any kind incurred as a result of any User Community Content.\\n\" + \"6. Privacy and Other Disclosures\\n\" + \"\\n\" + \"These Terms incorporate our Privacy Statement, and you hereby agree to its terms. In addition to the disclosures described elsewhere in these Terms and our Privacy Statement, we may disclose your User Account information and Uploaded Data to others if we have a good faith belief that such action is reasonably necessary to comply with law, regulatory requirements, professional standards, or to prevent harm.\\n\" + \"7. Disclaimer of Professional Relationship and Services\\n\" + \"\\n\" + \"7.1. No Professional Relationship or Services. We are a technology provider. We are not an auditor and do not provide auditing or other accounting services or advice or any other professional service. No professional relationship of any nature is created by your or Your Company’s use of Auvenir or by any correspondence or communication with us or any other person or entity (including any Deloitte Network entity) relating to Auvenir. Your use of Auvenir will not constitute an engagement of us or any other Deloitte Network entity to provide audit, compilation, review, attestation services or any other professional services, and therefore, neither we nor any other Deloitte Network entity will express an opinion or any other form of assurance as a result of you and Your Company having access to, or otherwise using, Auvenir.\\n\" + \"\\n\" + \"7.2. No Endorsement of Auditors and Other Service Providers. Auditors and other service providers may offer and provide their services through Auvenir. We do not endorse any of these auditors or service providers, nor do we evaluate their services, education, training, experience, licensing, or credentials. We also are not responsible for any services provided (or not provided) by these auditors or other service providers. You should conduct appropriate checks of any auditor or service provider before you hire them. Reliance on any information provided through Auvenir, whether you receive or provide audit or other services, is solely at your own risk. We simply offer a marketplace platform that allows auditors and other service providers to advertise and provide their services.\\n\" + \"8. Conflicts\\n\" + \"\\n\" + \"Your and Your Company’s use of Auvenir will not prevent or restrict us or any other Deloitte Network entity from (i) using or sharing for any purpose any knowledge, experience or skills used in, gained from, or otherwise related to, us making Auvenir available to you and Your Company, even if the interests of such person or entity are in competition with you or Your Company or (ii) providing services to any person or entity (including if you are an auditor, your and Your Company’s clients).\\n\" + \"9. Our Third Party Suppliers\\n\" + \"\\n\" + \"Portions of Auvenir may be licensed to us from Suppliers. We may also use Suppliers to host, support, or maintain Auvenir. Except for Third Party Terms or as specifically stated otherwise in a separate written agreement, (i) none of our Suppliers is providing a service to, or has any relationship with, you or Your Company, and (ii) these Terms will govern your and Your Company’s use of Auvenir. As used in these Terms, “Supplier” refers to any of the following: (a) any of our third party suppliers or service providers (including, if applicable, other Deloitte Network entities), (b) with respect to a Mobile App, Apple, Inc., BlackBerry Limited, or Google Inc., (c) any other software or device supplier or manufacturer, (d) any mobile access provider (including any airtime service providers and telecommunications carriers), (e) any distributor, merchant of record, or seller of record of a Mobile App, or (f) any affiliate of any of the foregoing.\\n\" + \"10. Availability; Suspension\\n\" + \"\\n\" + \"We strive to keep Auvenir up-and-running. However, it may be unavailable, and we do not guarantee that it will be available for your or Your Company’s use when needed. We may also change or discontinue Auvenir or change or remove some of its functionality at any time. We are not liable for any disruption or loss that you or Your Company may suffer as a result of Auvenir not being available or changes to its functionality. We may also suspend your right to access or use some or all Auvenir at any time in our sole discretion.\\n\" + \"11. Internet Access and Mobile Applications\\n\" + \"\\n\" + \"11.1. Accessing Auvenir. You and Your Company are responsible for ensuring that you have software and hardware capable of effectively accessing Auvenir over the internet. You and Your Company are also responsible for all charges and necessary permissions related to accessing Auvenir through your internet provider and must otherwise comply with your agreement with them when using Auvenir.\\n\" + \"\\n\" + \"11.2. Mobile Apps. Auvenir may include mobile apppcations created by us or third party developers (each, a “Mobile App”). If you access and use Auvenir through a Mobile App, you may be required to agree to additional terms, such as an end-user license agreement, associated with that Mobile App (“Mobile App Terms”). If the Mobile App does not contain or reference Mobile App Terms, then these Terms, including the following, will apply:\\n\" + \"\\n\" + \"On the condition that you and Your Company comply with all of your obligations and Your Company’s obligations under these Terms and subject to the other limitations contained in these Terms, you and Your Company may download and use a Mobile App on authorized mobile devices that you or Your Company own or control. Your download and use of a Mobile App must be solely for the purposes set forth in these Terms. This license to use a Mobile App is personal, limited, revocable, non-exclusive, non-assignable, non-transferable, and non-sublicenseable.\\n\" + \"This license does not allow you or Your Company to use the Mobile App on any device that you or Your Company do not own or control, and you and Your Company may not distribute or make a Mobile App available over a network where it could be used by multiple devices at the same time. You and Your Company may not rent, lease, lend, sell, transfer, redistribute, or sublicense a Mobile App. If you or Your Company sell or give your device to a third party, you or Your Company must remove all Mobile Apps from that device before doing so.\\n\" + \"You and Your Company acknowledge that these Terms are between us and you and Your Company, and they are not with any our Suppliers. None of our Suppliers has any responsibility, obligation, or liability (negligence or otherwise) to you or Your Company with respect to any Mobile App.\\n\" + \"None of our Suppliers will be responsible for any claims by you, Your Company, or any third party relating to your or Your Company’s possession or use of a Mobile App, including (a) any product liability claims, (b) any claim that a Mobile App fails to conform to any applicable legal or regulatory requirement, (c) any claims arising under consumer protection laws or similar legislation, or (d) any claims by any third party that a Mobile App or your or Your Company’s possession or use of it infringes a third party’s intellectual property rights.\\n\" + \"You and Your Company acknowledge and agree that: (i) each applicable Supplier with respect to a Mobile App is a third party beneficiary of these Terms, and (ii) upon your and Your Company’s agreement to these Terms, each such Supplier will have the right (and will be deemed to have accepted the right) to enforce the relevant portions of these Terms against you and Your Company as a third-party beneficiary of them.\\n\" + \"For any Mobile App created for Apple devices (e.g., containing iOS or Mac OS), in addition to the other terms contained in these Terms, the license granted to you and Your Company for that Mobile App is limited to a non-transferable license (except that such Mobile App created for Apple devices may be accessed, acquired, and used by other accounts associated with Apple’s Purchaser via Family Sharing) to use the Mobile App on any Apple devices that you or Your Company own or control as permitted by the usage rules set forth in the iTunes Store, Mac App Store, App Store, and iBookstore Terms and Conditions.\\n\" + \"12. Intellectual Property Rights\\n\" + \"\\n\" + \"12.1. Intellectual Property Rights in Auvenir. Auvenir (including the Auvenir Content and Auvenir Technology) are protected by copyright, trademark, and other laws of various countries around the world. We and our Suppliers reserve all rights not expressly granted in these Terms.\\n\" + \"\\n\" + \"12.2. Names and Logos. “Auvenir” and the Auvenir logo, and local language variants of the foregoing trademarks, and certain product names and logos that appear in Auvenir (collectively, the “Auvenir Marks”) are trademarks or registered trademarks of entities within the Deloitte Network. Except as expressly provided in these Terms or as expressly authorized in writing by the relevant trademark owner, neither you nor Your Company shall use any Auvenir Marks either alone or in combination with other words or design elements, including in any press release, advertisement, or other promotional or marketing material or media, whether in written, oral, electronic, visual or any other form. References to other parties’ trademarks in Auvenir are for identification purposes only and do not indicate that such parties have approved Auvenir. These Terms do not grant you any right to use the trademarks of other parties.\\n\" + \"\\n\" + \"12.3. Feedback. You or Your Company may provide us with feedback, ideas or other suggestions related to Auvenir (“Feedback”). If you or Your Company provides Feedback, then you or Your Company (as applicable) hereby assign and convey to us, without additional compensation, all right, title, and interest worldwide in and to that Feedback, including all patent, copyright, trademark, trade secret, and other intellectual property rights in it, together with all goodwill and claims appurtenant thereto. This includes a right to modify and create derivative works of the Feedback as we may determine in our sole discretion. You or Your Company (as applicable) also hereby irrevocably waive all rights with respect to the Feedback, including all rights of attribution, rights of integrity, rights of publicity or privacy, moral rights, and rights to inspect or approve anything that uses or incorporates the Feedback. You and Your Company acknowledge that we are not required to use or incorporate Feedback.\\n\" + \"13. Indemnification\\n\" + \"\\n\" + \"You and Your Company shall defend, indemnify and hold harmless us, each of the other entities within the Deloitte Network, and each of the foregoing’s personnel and Suppliers against any claims, losses, damages, liabilities, costs and expenses (including reasonable attorneys’ fees) arising out of or relating to any third party claim concerning: (a) your or Your Company’s use of Auvenir; (b) your or your Company’s breach of these Terms or violation of any applicable law, regulation, rule or professional standard; (c) your Uploaded Data, including any claim involving alleged infringement, violation or misappropriation of third-party rights by your Uploaded Data, or any claim concerning any data or other security breach caused by you; or (d) a dispute between the third party and you or Your Company.\\n\" + \"14. Disclaimer of Warranties; Limitations of Liability\\n\" + \"\\n\" + \"14.1. No Professional Services. As stated in Section 7, neither we nor any other entity within the Deloitte Network is, by means of permitting you access to Auvenir, rendering professional advice or services.\\n\" + \"\\n\" + \"14.2. No Warranties. Although we take commercially reasonable steps to make Auvenir useful and secure, Auvenir (including all Auvenir Technology, Auvenir Content and Mobile Apps) is provided “as is” and “as available” and without warranty of any kind. Neither we nor any Supplier has any obligation to provide maintenance and support services or any update, upgrade, enhancement, new functionality, modification, patch, bug fixes, or similar deliverable with respect to Auvenir (including any Auvenir Technology, Auvneir Content, or Mobile App). Without limiting the foregoing, we do not warrant that Auvenir (including any Auvenir Technology, Auvneir Content, or Mobile App) will be available, secure, error-free, free from viruses or malicious code, or will meet any particular criteria of performance or quality, and we expressly disclaim all implied warranties, including any warranties of merchantability, title, fitness for a particular purpose, non-infringement, compatibility, security, and accuracy.\\n\" + \"\\n\" + \"14.3. No Promises on Accuracy of Results. Some of Auvenir’s features may process Uploaded Data and provide you with analytical or computational results. Without limiting the other terms of this Section 14, (a) we are not responsible for the accuracy, integrity, quality, legality, or usefulness of those results, (b) you and Your Company waive any claims related to those results, and (c) we will not be liable for any damages or inconveniences you or Your Company may suffer as a result of inaccurate or incomplete results.\\n\" + \"\\n\" + \"14.4. No Responsibility or Endorsement of Third Party Services or Resources. We are not responsible for the availability, services, or content provided by Third Party Services or Third Party Resources. We also do not endorse any Third Party Service or Third Party Resources, and we make no representations or warranties as to the accuracy of, or any other aspect relating to, them. Third Party Services and Third Party Resources will be provided under terms determined solely between the third party and you or Your Company.\\n\" + \"\\n\" + \"14.5. No Liability. Your and Your Company’s use of Auvenir is at your own risk and you and Your Company assume full responsibility and risk of loss resulting from its use, including with respect to any loss of service or data. We will not be liable for any damages whatsoever relating to use of Auvenir, regardless of whether the damage is direct, indirect, special, incidental, consequential, punitive or otherwise.\\n\" + \"\\n\" + \"14.6. Related Entities and Suppliers. The disclaimer of warranties, limitations of liability and other terms of this Section 14 apply not only to us, but also to all of the other entities within the Deloitte Network and to our and their respective personnel and Suppliers.\\n\" + \"\\n\" + \"14.7. Applicability of Limitations. These Terms (including this Section 14) will apply to the fullest extent of the law and regardless of whether the damage, cost, expense, or loss is based in contract, statute, tort (including negligence) or otherwise. The provisions of this Section 14 will not apply to any disclaimer of warrant or limitation of liability which by the governing law of these Terms is unlawful to limit or exclude.\\n\" + \"15. Disclaimer of Warranties; Limitations of Liability.\\n\" + \"\\n\" + \"15.1. Notices from us to you. Any notice from us to you regarding these Terms or Auvenir may be made by any of the following methods: (1) a general posting to Auvenir users; (2) any communication function available through your User Account; or (3) the email address or physical address contact information associated with your User Account (which you are responsible for keeping current and accurate).\\n\" + \"\\n\" + \"15.2. Notices from you to us. Any notice from you or Your Company under these Terms must be delivered by one of the following methods: (1) email; (2) personal delivery; or (3) a globally or nationally (as applicable) recognized express mail, courier, or delivery service (“Express Courier”). A notice sent by electronic mail will be deemed given on the date of electronic confirmation of receipt. A notice sent by personal delivery or Express Courier will be deemed given on the date of receipt or refusal of receipt. The notice from you or Your Company must be addressed as follows:\\n\" + \"\\n\" + \"Auvenir\\n\" + \"Suite 402, 225 Richmond St. W.,\\n\" + \"Toronto, ON M5V 2W1\\n\" + \"Canada\\n\" + \"Email: info@auvenir.com\\n\" + \"16. General Terms\\n\" + \"\\n\" + \"16.1. Entire Agreement; Order of Precedence for Conflicts. These Terms (including, if applicable, any Supplemental Terms and Mobile App Terms) constitute the full and complete agreement between you and Your Company, on the one hand, and us, on the other, with respect to their subject matter, and supersede all other agreements, whether written or oral, between the parties. If there is an inconsistency or conflict among these Terms and any of the following documents, it will be resolved using the following order of precedence: (i) the Supplemental Terms (but only with respect to the part of Auvenir to which those Supplemental Terms apply), (ii) the Mobile App Terms (but only with respect to the Mobile App to which those Mobile App Terms apply), and (iii) these Terms.\\n\" + \"\\n\" + \"16.2. Amendments to these Terms. We may change these Terms at any time in our sole discretion. If we make a change, we will either (1) display the revised Terms on this website or elsewhere in Auvenir or (2) send you a notice of the revised Terms in accordance with Section 15. The revised Terms will be effective upon posting or other notice, unless we explicitly state otherwise. You and Your Company are responsible to be aware of any such revised Terms by checking this website and reading your notices. If you or Your Company do not agree with the revised Terms, then you are not allowed to use Auvenir and should stop using them immediately and deactivate your User Account under Section 2.4.\\n\" + \"\\n\" + \"16.3. No Informal Waivers, Agreements or Representations. No waiver of any breach by you or Your Company, or of any objection to any act or omission connected therewith, will be implied or claimed by you or Your Company or be deemed to constitute a consent to any continuation of such breach, act or omission, unless contained in a writing signed by us.\\n\" + \"\\n\" + \"16.4. Governing Law; Venue; Jury Trial Waiver. The laws of Ontario, Canada, without giving effect to its principles of conflicts of law, govern all proceedings arising out of these Terms or arising out of your or your Company’s use of Auvenir. The United Nations Convention on Contracts for the International Sale of Goods do not apply to these Terms. If any party brings any claim or proceeding arising out of these Terms, that party may bring that claim or proceeding only in Toronto, Ontario, and each party hereby submits to the exclusive jurisdiction of those courts for purposes of any such claim or proceeding. However, despite the other terms in this section, we may apply in any jurisdiction for injunctive remedies or other equivalent type of urgent legal relief.\\n\" + \"\\n\" + \"16.5. Equitable Relief. You and Your Company shall not seek or be entitled to rescission, injunctive, or other equitable relief, or to enjoin or restrain the operation, use, or exploitation of Auvenir or any part of it, including any Auvenir Technology or Auvenir Content. We shall be entitled to injunctive or other equitable relief in order to prevent, mitigate, or remedy the breach or continuing breach of these Terms.\\n\" + \"\\n\" + \"16.6. Remedies Not Exclusive. Exercise or enforcement of a right or remedy given in these Terms shall not be considered to be in lieu of enforcement of other rights or remedies otherwise existing at law or equity, unless specifically waived in writing.\\n\" + \"\\n\" + \"16.7. Severability. If any term in these Terms is invalid or unenforceable in any jurisdiction, then (1) in that jurisdiction it shall be re-construed to the maximum extent permitted by law to effect its intent as nearly as possible and the remaining terms shall remain in full force and effect, and (2) in every other jurisdiction all of these Terms shall remain in full force and effect.\\n\" + \"\\n\" + \"16.8. No Construction Against the Drafter. If an ambiguity or question of intent or interpretation arises with respect to these Terms, these Terms will be construed as if drafted jointly by you, Your Company and us, and no presumption or burden of proof will arise favoring or disfavoring any of those parties by virtue of authorship of these Terms.\\n\" + \"\\n\" + \"16.9. Assignment and Delegation. You and Your Company may not assign or delegate any rights or obligations under these Terms, and any such purported assignment or delegation will be void. If Your Company undergoes a change of control, whether through merger, sale or otherwise, you must create a new User Account for the new entity. We may freely assign or delegate all rights and obligations under these Terms, fully or partially, without notice to you or Your Company. These Terms will be binding on your, Your Company’s and our successors and permitted assigns.\\n\" + \"\\n\" + \"16.10. Relationship of the Parties; Third Party Beneficiaries. No agency, partnership, franchise, or joint venture is created by these Terms between you and Your Company, on the one hand, and us, on the other. Nothing in this Agreement (express or implied) confers, or is intended to confer, on any person or entity other than the parties any right, benefit or remedy, except that the Deloitte Network entities and our Suppliers are third party beneficiaries to certain sections of these Terms and may enforce specific rights under them.\\n\" + \"\\n\" + \"16.11. Construction. Paragraph or section numbers and headings that are used in these Terms are included for convenience only, and if there is any conflict between any such numbers and headings and the text of these Terms, the text shall control. As used in these Terms, the word “including” means “including, without limitation,” and the word “include” means “include, without limitation,”.";

    @FindBy(xpath = "//img[@src='static/images/logo-auvenir.svg']")
    private WebElement auvenirLogoImage;
    @FindBy(xpath = ".//*[@id='marketing-header']//div[@class='ui center aligned header header-main-text']")
    private WebElement termsHeaderText;
    @FindBy(xpath = "//p[@class='ui aligned center header sub-title']")
    private WebElement auvenirTermsOfServiceText;
    @FindBy(xpath = "//div[@id='term']//div[@class='ui container term-container']//div[@class='ui basic segment']//div[@class='terms-detail']")
    private WebElement termsContentText;

    @FindBy(xpath = "//*[@id=\"preview-header-left\"]/span")
    private WebElement allEngagementsEle;

    //@FindBy(xpath = "//*[@id='reset-password']//input[@name='password']")
    @FindBy(xpath = "//*[@id='create-password-form']//input[@name='password']")
    private WebElement eleNewPasword;

    public WebElement getEleNewPasword() {
        return eleNewPasword;
    }


    //@FindBy(xpath = "//*[@id='reset-password']//input[@name='retype_password']")
    @FindBy(xpath = "//*[@id='create-password-form']//input[@name='retype_password']")
    private WebElement eleRetypeNewPassword;

    public WebElement getEleRetypeNewPassword() {
        return eleRetypeNewPassword;
    }

    @FindBy(xpath = "//div/button[contains(@class, 'button') and (text()='Cancel' or text()='Annuler')]")
    private WebElement btnCancel;

    public WebElement getBtnCancel() {
        return btnCancel;
    }

    @FindBy(xpath = "//div/button[contains(@class, 'button') and (text()='Reset' or text()='Réinitialiser')]")
    private WebElement btnReset;

    public WebElement getBtnReset() {
        return btnReset;
    }

    @FindBy(id = "reset-password-warning-popup")
    private WebElement resetPasswordWarningPopup;

    public WebElement getResetPasswordWarningPopup() {
        return resetPasswordWarningPopup;
    }

    @FindBy(id = "confirm-password-message")
    private WebElement confirmPasswordMessage;

    public WebElement getConfirmPasswordMessage() {
        return confirmPasswordMessage;
    }

    @FindBy(css = "#reset-password .exit")
    private WebElement btnExit;

    public WebElement getBtnExit() {
        return btnExit;
    }

    @FindBy(css = "#reset-password .login")
    private WebElement btnLogin;

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    @FindBy(xpath = "//div[@class='au-modal-container modalTransition-popUp-container']/img[@class='au-modal-closeBtn']")
    private WebElement eleCredentialsCloseIcn;

    public WebElement getEleCredentialsCloseIcn() {
        return eleCredentialsCloseIcn;
    }

    @FindBy(xpath = "//p[@id='security-body']/div/div[1]/p[@class ='auv-inputError']")
    private WebElement eleNewPasswordErrorMessage;

    @FindBy(xpath = "//p[@id='security-body']/div/div[2]/p[@class ='auv-inputError']")
    private WebElement eleConfirmPasswordErrorMessage;


    @FindBy(xpath = "//img[contains(@src,'logos/cropped.jpg?v=27')]")
    private WebElement eleBambooImage;

    @FindBy(xpath = "//div[@class='ResAts__card-content']/h2")
    private WebElement eleBambooHeader;

    @FindBy(xpath = "//div[@class='ResAts__card-content']/span[@class='ResAts__card-subtitle']")
    private WebElement eleBambooSubtitle;

    private static final String BAMBOO_HEADER_TITLE = "Current Openings";
    private static final String BAMBOO_SUB_TITLE = "Thanks for checking out our job openings. See something that interests you? Apply here.";

    private static final String NEW_PASSWORD_ERROR_MESSAGE = "Please enter a password and least 8 characters, have a capital letter, lower case letter, a number and a special character (!@#$%^&*)";
    private static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "Your passwords don't match.";


    public void verifyNewPasswordErrorMessage(){
        waitForVisibleElement(eleNewPasswordErrorMessage, "new password error message");
        validateElementText(eleNewPasswordErrorMessage,NEW_PASSWORD_ERROR_MESSAGE);
    }

    public void verifyConfirmPasswordErrorMessage(){
        waitForVisibleElement(eleConfirmPasswordErrorMessage, "confirm password error message");
        validateElementText(eleConfirmPasswordErrorMessage,CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void verifyBambooContentPage(){
        try {
            switchToOtherTab(1);
            waitForVisibleElement(eleBambooImage, "bamboo image");
            waitForVisibleElement(eleBambooHeader, "bamboo header title");
            waitForVisibleElement(eleBambooSubtitle, "bamboo sub title");
            validateElementText(eleBambooHeader, BAMBOO_HEADER_TITLE);
            validateElementText(eleBambooSubtitle, BAMBOO_SUB_TITLE);
            Assert.assertTrue(AbstractService.sStatusCnt == 0);
            NXGReports.addStep("Verify about bamboo page.", LogAs.PASSED, (CaptureScreen) null);
        }catch (AssertionError assertionError){
            NXGReports.addStep("Verify about bamboo page.", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void verifyAboutContentPage() {
        getLogger().info("Verify about content page");
        boolean isCheckAboutContentPage, isCheckAboutContentPage1, isCheckAboutContentPage2, isCheckAboutContentPage3, isCheckAboutContentPage4, isCheckAboutContentPage5, isCheckAboutContentPage6, isCheckAboutContentPage7, isCheckAboutContentPage8, isCheckAboutContentPage9 = false;

        isCheckAboutContentPage = waitForVisibleElement(avenirLogo, "avenirLogo");
        isCheckAboutContentPage1 = validateElementText(headerTextAbout, "Auvenir is a Deloitte Venture created to help small and medium sized " +
                "practitioners provide a better financial audit experience for their clients. We are a technology-forward company with deep experience in the accounting and audit world.");
        isCheckAboutContentPage2 = waitForVisibleElement(meetTheAuvyLeagueText, "meetTheAuvyLeagueText");
        isCheckAboutContentPage3 = waitForVisibleElement(alexImage, "alexImage");
        isCheckAboutContentPage4 = waitForVisibleElement(alextNameText, "alextNameText");
        isCheckAboutContentPage5 = waitForVisibleElement(alextTitleText, "alextTitleText");
        isCheckAboutContentPage6 = waitForVisibleElement(wannaJoinUsText, "wannaJoinUsText");
        isCheckAboutContentPage7 = waitForVisibleElement(viewCareerBTN, "viewCareerBTN");
        isCheckAboutContentPage8 = waitForVisibleElement(highlightSoFourWeekendText, "highlightSoFourWeekendText");
        isCheckAboutContentPage9 = waitForVisibleElement(firstImage, "firstImage");

        if (isCheckAboutContentPage & isCheckAboutContentPage1 & isCheckAboutContentPage2 & isCheckAboutContentPage3 & isCheckAboutContentPage4 & isCheckAboutContentPage5
                & isCheckAboutContentPage6 & isCheckAboutContentPage7 & isCheckAboutContentPage8 & isCheckAboutContentPage9) {
            NXGReports.addStep("Verify about content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify about content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void goToCareersPage() {
        clickElement(viewCareerBTN, "viewCareerBTN");
    }

    public void verifyCareersContentPage() {
        getLogger().info("Verify careers content page");
        boolean checkMarketingHeaderText = false;
        boolean checkCareersAuvenirText = false;
        boolean isCheckCareersContentPage, isCheckCareersContentPage1, isCheckCareersContentPage2, isCheckCareersContentPage3, isCheckCareersContentPage4, isCheckCareersContentPage5 = false;
        isCheckCareersContentPage = waitForVisibleElement(auvenirLogoImage, "auvenirLogoImage");
        isCheckCareersContentPage1 = waitForVisibleElement(marketingHeaderText, "auvenmarketingHeaderTextirLogoImage");
        if (marketingHeaderText.getText().equals(marketingHeaderTextCst)) {
            checkMarketingHeaderText = true;
        }
        getLogger().info("marketingHeaderText = " + marketingHeaderText.getText());
        isCheckCareersContentPage2 = waitForVisibleElement(careersAtAuvenirText, "careersAtAuvenirText");
        if (careersAtAuvenirText.getText().equals(careersAtAuvenirTextCst)) {
            checkCareersAuvenirText = true;
        }
        isCheckCareersContentPage3 = waitForVisibleElement(EngineeringText, "EngineeringText");
        isCheckCareersContentPage4 = waitForVisibleElement(ProductText, "ProductText");
        isCheckCareersContentPage5 = waitForVisibleElement(SalesText, "SalesText");
        if (isCheckCareersContentPage & isCheckCareersContentPage1 & isCheckCareersContentPage2 & isCheckCareersContentPage3 & isCheckCareersContentPage4
                & isCheckCareersContentPage5 & checkMarketingHeaderText & checkCareersAuvenirText) {
            NXGReports.addStep("Verify careers content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify careers content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void verifyContactContentPage() {
        getLogger().info("Verify contact content page");
        boolean checkHeaderText = false;
        String strGetTouchText = "";
        boolean isCheckContactContentPage, isCheckContactContentPage1, isCheckContactContentPage2, isCheckContactContentPage3, isCheckContactContentPage4,
                isCheckContactContentPage5, isCheckContactContentPage6, isCheckContactContentPage7, isCheckContactContentPage8 = false;
        isCheckContactContentPage = waitForVisibleElement(auvenirLogoImage, "auvenirLogoImage");
        isCheckContactContentPage1 = waitForVisibleElement(headerText, "headerText");
        if (headerText.getText().equals(headerTextCst)) {
            checkHeaderText = true;
        }
        isCheckContactContentPage2 = waitForVisibleElement(getInTouchText, "getInTouchText");
        strGetTouchText = getInTouchText.getText();
        boolean isCheckTouchText = false;
        if (strGetTouchText.equals(getInTouchTextCst)) {
            isCheckTouchText = true;
        }
        getLogger().info("strGetTouchText = " + strGetTouchText);
        isCheckContactContentPage3 = waitForVisibleElement(nameTextBox, "nameTextBox");
        isCheckContactContentPage4 = waitForVisibleElement(contactEmailTextBox, "contactEmailTextBox");
        isCheckContactContentPage5 = waitForVisibleElement(directMessageDropdown, "directMessageDropdown");
        isCheckContactContentPage6 = waitForVisibleElement(messageTextBox, "messageTextBox");
        isCheckContactContentPage7 = waitForVisibleElement(sendMessageBTN, "sendMessageBTN");
        isCheckContactContentPage8 = waitForVisibleElement(contactMapImage, "contactMapImage");
        if (isCheckTouchText & isCheckContactContentPage & isCheckContactContentPage1 & isCheckContactContentPage2 & isCheckContactContentPage3
                & isCheckContactContentPage4 & isCheckContactContentPage5 & isCheckContactContentPage6 & isCheckContactContentPage7 & isCheckContactContentPage8
                & checkHeaderText) {
            NXGReports.addStep("Verify contact content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify contact content page: PASSED", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void verifyCookiesNoticeContentPage() {
        getLogger().info("Verify cookies notice content page");
        String strCookiesNotice = "";
        String strAuvenirCookieNotice = "";
        String strCookieNoticeContent = "";
        boolean checkCookiesNotie = false;
        boolean checkAuvenirCookiesNotice = false;
        boolean checkCookiesNoticecontent = false;
        boolean checkCookiesNoticeContentPage, checkCookiesNoticeContentPage1 = false;
        checkCookiesNoticeContentPage = waitForVisibleElement(auvenirLogoImage, "auvenirLogoImage");
        checkCookiesNoticeContentPage1 = waitForVisibleElement(cookiesNoticeText, "cookiesNoticeText");
        strCookiesNotice = cookiesNoticeText.getText();
        getLogger().info("strCookiesNotice = " + strCookiesNotice);
        if (strCookiesNotice.equals(cookiesNoticeTextCst)) {
            checkCookiesNotie = true;
        }
        waitForVisibleElement(auvenirCookieNoticeText, "auvenirCookieNoticeText");
        strAuvenirCookieNotice = auvenirCookieNoticeText.getText();
        if (strAuvenirCookieNotice.equals(auvenirCookieText)) {
            checkAuvenirCookiesNotice = true;
        }
        waitForVisibleElement(ookiesNoticecontentText, "ookiesNoticecontentText");
        strCookieNoticeContent = ookiesNoticecontentText.getText();
        getLogger().info("strCookieNoticeContent = " + strCookieNoticeContent);
        if (strCookieNoticeContent.equals(auvenirCookiesNoticeTextCst)) {
            checkCookiesNoticecontent = true;
        }
        if (checkCookiesNoticeContentPage & checkCookiesNoticeContentPage1 & checkCookiesNotie & checkAuvenirCookiesNotice & checkCookiesNoticecontent) {
            NXGReports.addStep("Verify cookies notice content page: PASSED", LogAs.PASSED, (CaptureScreen) null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify cookies notice content page", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void clickOnChangeLanguageBTN() {
        clickElement(changeLanguageBTN, "changeLanguageBTN");
    }

    public void clickOnLoginBTN() {
        getLogger().info("Click on login button.");
        clickElement(loginBTN, "loginBTN");
    }

    public void inputUserNamePassword(String username, String password) {
        sendKeyTextBox(emailTextBox, username, "emailTextBox");
        sendKeyTextBox(passwordTextBox, password, "passwordTextBox");
    }

    public void clickOnSubmitBTN() {
        clickElement(submitBTN, "loginBTN");
    }

    public void clickOnProfile() {
        clickAndHold(profileLink, "profileLink");
    }

    public void clickOnLogoutBTN() {
        clickElement(logoutBTN, "logoutBTN");
    }

    public void verifyLoginBTN() {
        waitForClickableOfElement(loginBTN, "loginBTN");
    }

    public void verifySignUpBTN() {
        waitForClickableOfElement(signUpBTN, "signUpBTN");
    }

    public void verifyLogoutBTNIsNotPresented() {
        validateNotExistedElement(logoutBTN, "logoutBTN");
    }

    public void verifyColorUserNameTxtBox() {
        waitForVisibleElement(userError, "User Name Text Box");
        waitForCssValueChanged(userError, "User Name Text Box", borderColor, warningBorderCSSColor);
        validateCssValueElement(userError, borderColor, warningBorderCSSColor);
        waitForCssValueChanged(userError, "User Name Text Box", backgroundColor, warningBackgroundCSSColor);
        validateCssValueElement(userError, backgroundColor, warningBackgroundCSSColor);
    }

    public void verifyColorPasswordTxtBox() {
        waitForVisibleElement(passwordError, "Password Text Box");
        waitForCssValueChanged(passwordError, "Password Text Box", borderColor, warningBorderCSSColor);
        validateCssValueElement(passwordError, borderColor, warningBorderCSSColor);
        waitForCssValueChanged(passwordError, "Password Text Box", backgroundColor, warningBackgroundCSSColor);
        validateCssValueElement(passwordError, backgroundColor, warningBackgroundCSSColor);
//        validateCssValueElement(passwordError,attributeName,attributeValue);
    }

    public void verifyErrorLoginMessage(String messsage) {
        getLogger().info("Verify Error Login Message.");
        final String errorColorOfLoginMeesage = "rgba(159, 58, 56, 1)";
        final String errorBackgroundColorOfLoginMeesage = "rgba(255, 246, 246, 1)";
        waitForVisibleElement(errorMessageBorder, "errorMessageBorder");
        validateElementText(errorMessage, messsage);
        verifyColorErrorLoginMessage(color, errorColorOfLoginMeesage);
        verifyColorErrorLoginMessage(backgroundColor, errorBackgroundColorOfLoginMeesage);
////        validateCssValueElement(errorMessageBorder,color, errorColorOfLoginMeesage);
//        validateCssValueElement(errorMessageBorder,color, errorColorOfLoginMeesage);
    }

    public void verifyColorErrorLoginMessage(String attributeName, String attributeValue) {
        getLogger().info("Verify Error Color of Login Message.");
        waitForVisibleElement(errorMessageBorder, "errorMessageBorder");
        validateCssValueElement(errorMessageBorder, attributeName, attributeValue);
    }

    public void clickOnForgotPasswordLink() {
//            waitForClickableOfElement(forgotPasswordLink, "forgotPasswordLink");
        clickElement(forgotPasswordLink, "forgotPasswordLink");

    }

    public void verifyForgotPasswordTitle() {
        try {
            Boolean isVisible = waitForVisibleElement(forgotPasswordTitle, "forgotPasswordTitle");
            Boolean isText = validateElementText(forgotPasswordTitle, "Forgot Your Password?");
            if (isText && isVisible) {
                NXGReports.addStep("Verify Forgot Password Title: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify Forgot Password Title: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Forgot Password Title: Fail_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void inputEmailForgotPassword(String text) {
        clearTextBox(emailForgotPasswordTextBox, "emailForgotPasswordTextBox");
        sendKeyTextBox(emailForgotPasswordTextBox, text, "emailForgotPasswordTextBox");
    }

    @FindBy(xpath = "//div[@id='forgot-popup']")
    WebElement resetPwdPopUp;

    /*
    Vien.Pham edited clickOnRequestResetLinkBTN()
     */
    private WebElement eleForgetPasswordErrorMessage;
    public void clickOnRequestResetLinkBTN() {
        clickElement(requestResetLinkBTN, "requestResetLinkBTN");
        //waitForCssValueChanged(resetPwdPopUp, "ResetPwd PopUp", "display", "none");
    }

    public void verifyColorEmailForgotPasswordTextBox(String attributeName, String attributeValue) {
        waitForVisibleElement(EmailForgotPasswordTextBox, "EmailForgotPasswordTextBox");
        validateCssValueElement(EmailForgotPasswordTextBox, attributeName, attributeValue);
    }

    public void verifyColorEmailForgotPasswordMessage(String attributeName, String attributeValue) {
        waitForVisibleElement(EmailForgotPasswordMessage, "EmailForgotPasswordMessage");
        validateCssValueElement(EmailForgotPasswordMessage, attributeName, attributeValue);
    }

    public void verifyContentEmailForgotPasswordMessage(String text) {
        validateElementText(EmailForgotPasswordMessage, text);
    }

    public void clickOnSignupButton() {
        waitForClickableOfElement(signUpBTN, "signup button");
        clickElement(signUpBTN, "signup button");
    }

    public void verifyHomeContentPage() {
        getLogger().info("Verify home content page");
        try{
        waitForVisibleElement(avenirLogo, "avenirLogo");
        waitForVisibleElement(weHelpYouAuditSmarterText, "weHelpYouAuditSmarterText");
        waitForVisibleElement(joinAsAnAuditorTodayText, "joinAsAnAuditorTodayText");
        waitForVisibleElement(whyAuvenirText, "whyAuvenirText");
        waitForVisibleElement(whyAuvenirText1, "whyAuvenirText1");
        waitForVisibleElement(whyAuvenirText2, "whyAuvenirText2");
        waitForVisibleElement(productFeaturesText, "productFeaturesText");
        waitForVisibleElement(belowProductFeaturesText, "belowProductFeaturesText");
        waitForVisibleElement(spendLessTimeImage, "spendLessTimeImage");
        waitForVisibleElement(spendLessTimeText, "spendLessTimeText");
        waitForVisibleElement(spendLessTimeDescriptionText, "spendLessTimeDescriptionText");

        waitForVisibleElement(eleSecurelyStoreYourDocumentsImage, "securely store your documents image");
        waitForVisibleElement(eleSecurelyStoreYourDocumentsText, "securely store your documents text");
        waitForVisibleElement(eleSecurelyStoreYourDocumentsDescription, "securely store your documents description");

        waitForVisibleElement(eleSimplifyYourWorkFlowImage,"simplify your work flow image");
        waitForVisibleElement(eleSimplifyYourWorkFlowText,"simplify your work flow text");
        waitForVisibleElement(eleSimplifyYourWorkFlowDescription,"simplify your work flow description");

        waitForVisibleElement(eleCollaborateBetterWithYourClientsImage,"collaborate better with your clients image");
        waitForVisibleElement(eleCollaborateBetterWithYourClientsText,"collaborate better with your clients text");
        waitForVisibleElement(eleCollaborateBetterWithYourClientsDescription,"collaborate better with your clients description");

        waitForVisibleElement(eleIntelligentlyAllocateResourcesImage,"intelligently allocate resources image");
        waitForVisibleElement(eleCIntelligentlyAllocateResourcesText,"intelligently allocate resources text");
        waitForVisibleElement(eleIntelligentlyAllocateResourcesDescription,"intelligently allocate resources description");

        waitForVisibleElement(eleSeamlesslyImportDataImage,"seamlessly import data image");
        waitForVisibleElement(eleCSeamlesslyImportDataText,"seamlessly import data text");
        waitForVisibleElement(eleSeamlesslyImportDataDescription,"seamlessly import data description");

        waitForVisibleElement(eleCustomizeBrandingImage,"customize branding image");
        waitForVisibleElement(eleCustomizeBrandingText,"customize branding text");
        waitForVisibleElement(eleCustomizeBrandingDescription,"customize branding description");

        waitForVisibleElement(eleAutomatedToolsImage,"automation tool image");
        waitForVisibleElement(eleAutomatedToolsText,"automation tool text");
        waitForVisibleElement(eleAutomatedToolsDescription,"automation tool description");

        validateElementText(whyAuvenirText1, WHY_AUVENIR_CONTENT_TEXT);
        validateElementText(whyAuvenirText2,WHY_AUVENIR_END_TEXT);
        validateElementText(productFeaturesText,"Product Features");

        validateElementText(belowProductFeaturesText,belowProductFeaturesTextCst);
        validateElementText(spendLessTimeDescriptionText,spendLessTimeDescriptionTextCst);
        validateElementText(eleSecurelyStoreYourDocumentsDescription, SECURELY_STORE_YOUR_DOCUMENT_DESCRIPTION);
        validateElementText(eleSimplifyYourWorkFlowDescription, SIMPLIFY_YOUR_WORK_FLOW_DESCRIPTION);
        validateElementText(eleCollaborateBetterWithYourClientsDescription, COLLABORATE_BETTER_WITH_YOUR_CLIENTS_DESCRIPTION);
        validateElementText(eleIntelligentlyAllocateResourcesDescription, INTELLIGENTLY_ALLOCATE_RESOURCES_DESCRIPTION);
        validateElementText(eleSeamlesslyImportDataDescription, SEAMLESSLY_IMPORT_DATA_DESCRIPTION);
        validateElementText(eleCustomizeBrandingDescription, CUSTOMIZE_BRANDING_DESCRIPTION);
        validateElementText(eleAutomatedToolsDescription, AUTOMATION_TOOL_DESCRIPTION);

        Assert.assertTrue(AbstractService.sStatusCnt == 0);
        NXGReports.addStep("Verify home content page", LogAs.PASSED, null);
        }catch (AssertionError assertionError){
            NXGReports.addStep("Verify home content page", LogAs.FAILED, null,assertionError.getMessage());
        }
    }

    public void goToAboutPage() {
        clickElement(aBoutLink, "aBoutLink");
    }

    public void goToContactPage() {
        clickElement(contactLink, "contactLink");
    }

    public void goToCookiesNoticePage() {
        clickElement(cookiesNoticeLink, "cookiesNoticeLink");
    }

    public void goToPrivacyPolicyPage() {
        clickElement(privacyPolicyLink, "privacyPolicyLink");
    }

    public void goToTermOfService() {
        clickElement(termsOfService, "termsOfService");
    }

    public void verifyPrivacyPolicyContentPage() {
        getLogger().info("Verify privacy policy content page");
        boolean checkPrivacyPolicyTextContent = false;
        boolean checkAuvenirPrivacyText = false;
        boolean checkPrivacyHeaderText = false;
        boolean checkAuvenirLogoImage = false;
        checkAuvenirLogoImage = waitForVisibleElement(auvenirLogoImage, "auvenirImageLogo");
        waitForVisibleElement(privacyHeaderText, "privacyHeaderText");
        if (privacyHeaderText.getText().equals("Privacy Policy")) {
            checkPrivacyHeaderText = true;
        }
        waitForVisibleElement(auvenirPrivacyPolicyText, "auvenirPrivacyPolicyText");
        if (auvenirPrivacyPolicyText.getText().equals("Auvenir Privacy Policy")) {
            checkAuvenirPrivacyText = true;
        }
        waitForVisibleElement(privacyPolicyTextContent, "privacyPolicyTextContent");
        if (privacyPolicyTextContent.getText().equals(privacyPolicyTextContentCst)) {
            checkPrivacyPolicyTextContent = true;
        }
        getLogger().info("privacyPolicyTextContent = " + privacyPolicyTextContent.getText());
        if (checkPrivacyPolicyTextContent & checkAuvenirPrivacyText & checkPrivacyHeaderText & checkAuvenirLogoImage) {
            NXGReports.addStep("Verify privacy policy content page", LogAs.PASSED, (CaptureScreen) null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify privacy policy content page", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void verifyTermsContentPage() {

        getLogger().info("Verify terms content page");
        try {
            waitForVisibleElement(auvenirLogoImage, "auvenirLogoImage");
            waitForVisibleElement(termsHeaderText, "termsHeaderText");
            waitForVisibleElement(auvenirTermsOfServiceText, "auvenirTermsOfServiceText");
            waitForVisibleElement(termsContentText, "termsContentText");
            validateElementText(termsHeaderText, "Terms of Service");
            validateElementText(auvenirTermsOfServiceText, "Effective: January 16, 2017");
            //validateElementText(termsContentText, termsContentTextCst);
            Assert.assertTrue(AbstractService.sStatusCnt ==0);
            NXGReports.addStep("Verify terms content page", LogAs.PASSED, (CaptureScreen) null);
        }catch (AssertionError assertionError){
            NXGReports.addStep("Verify terms content page", LogAs.FAILED, (CaptureScreen) null,assertionError.getMessage());
        }
    }


    protected void isLoadedExitLogin() throws Error {
        validateElememt(btnExit, "Exit button", Element_Type.DISPLAYED);
        validateElememt(btnLogin, "Login button", Element_Type.DISPLAYED);
    }

    public void exit() {
        clickElement(btnExit, "click to btnExit");
    }

    public void login() {
        clickElement(btnLogin, "click to btnLogin");
    }

    protected void isLoaded() throws Error {
        validateElememt(eleNewPasword, "New password input", Element_Type.DISPLAYED);
        validateElememt(eleRetypeNewPassword, "New retype password input", Element_Type.DISPLAYED);
    }

    public void resetPassword(String newPass, String retypeResetPass) {
        try {
            getLogger().info("Verify to reset password");
            Thread.sleep(smallTimeOut);
            switchToOtherTab(1);
            sendKeyTextBox(inputFirstPassword, newPass, "send key to eleNewPasword");
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(inputSecondPassword, retypeResetPass, "send key to eleRetypeNewPassword");
            clickElement(buttonSetPassword, "click to btnReset");
            NXGReports.addStep("Verify to reset password", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to reset password", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void setNewPassword(String newPassword) {
        try {

            Thread.sleep(smallTimeOut);
            switchToOtherTab(1);
            sendKeyTextBox(inputFirstPassword, newPassword, "send key to new password");
            NXGReports.addStep("Verify to set new password", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to set new password", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    public void setConfirmPassword(String confirmPassword) {
        try {

            Thread.sleep(smallTimeOut);
            switchToOtherTab(1);
            sendKeyTextBox(inputSecondPassword, confirmPassword, "send key to confirm password");
            NXGReports.addStep("Verify to set confirm password", LogAs.PASSED, (CaptureScreen) null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to set confirm password", LogAs.FAILED, (CaptureScreen) null);
        }
    }

    /**
     * Click Close on Popup which warning about supporting only Chrome Browser.
     */
    public void clickClosePopupWarningBrowser() {
        try {
            if (GenericService.sBrowserData.equals("ff.")) {
                getLogger().info("Close Popup Warning Browser");
                Thread.sleep(3000);
                waitForVisibleElement(getEleCredentialsCloseIcn(), "Close Icon");
                waitForClickableOfElement(getEleCredentialsCloseIcn(), "Close Icon");
                clickElement(getEleCredentialsCloseIcn(), "Close Icon");
                waitForProgressOverlayIsClosed();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            getLogger().info(e);
        }
    }

    /**
     * Add new by huy.huynh on 29/06/2017.
     * R2.1 NewFeature
     */
    @FindBy(xpath = "//div[@class='email-sending-title']/span")
    private WebElement titleResetLinkSent;

    @FindBy(id = "security-title")
    private WebElement titleResetPassword;

    @FindBy(id = "first-password")
    private WebElement inputFirstPassword;

    @FindBy(id = "second-password")
    private WebElement inputSecondPassword;

    @FindBy(id = "security-continueBtn")
    private WebElement buttonSetPassword;

    @FindBy(xpath = "//div[@id='email-sending-popup']")
    private WebElement resetLinkSentPopup;

    public void waitForResetLinkSent() {
//        waitForVisibleElement(titleResetLinkSent,"Title Reset Link Sent");
        waitForTextValueChanged(titleResetLinkSent, "Title Reset Link Sent", "Reset Link Sent");
    }

    public void verifyResetPasswordPageTitle() {
        try {
            switchToOtherTab(1);
            validateElementText(titleResetPassword, "Reset Password");
            getLogger().info("Reset Password Page loaded.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpAndConfirmPassword(String password) {
        sendKeyTextBox(inputFirstPassword, password, "Input First Password");
        sendKeyTextBox(inputSecondPassword, password, "Input Second Password");
        clickElement(buttonSetPassword, "Button Set Password");
    }
    /*-----------end of huy.huynh on 29/06/2017.*/

    /*
    Vien.Pham added new method
     */

    public void inputNewResetPassword(String newPwd, String position) throws InterruptedException {
        if (position.equals("1")) {
            clickElement(inputFirstPassword, "First pwd box");
            sendKeyTextBox(inputFirstPassword, newPwd, "Input First Password");
        } else {
            clickElement(inputSecondPassword, "Second pwd box");
            sendKeyTextBox(inputSecondPassword, newPwd, "Input Second Password");
        }
        Thread.sleep(smallerTimeOut);
    }


    @FindBy(xpath = "//input[contains(@class,'auv-error')]")
    WebElement errorPwdVerify;
    @FindBy(xpath = "//div[@id='reset-password-component-container']//p[@class='auv-inputError']")
    List<WebElement> errorPwdMessage;
//    @FindBy(xpath = "//button[@id='security-continueBtn']")
//    WebElement disableSetPasswordBtn;

    public void verifyInvalidPasswordWarning(String position) {
        try {
            Boolean isVisible = waitForVisibleElement(errorPwdVerify, "");
            if (isVisible && position.equals("1")) {
                Boolean isCheck = validateElementText(errorPwdMessage.get(0), errorPwdMesg1);
                if (isCheck) {
                    NXGReports.addStep("Verify error password message: Pass", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify error password message: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
            if (isVisible && position.equals("2")) {
                Boolean isCheck = validateElementText(errorPwdMessage.get(1), errorPwdMesg2);
                if (isCheck) {
                    NXGReports.addStep("Verify error password message: Pass", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify error password message: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify all cases of password input: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyValidPassword(String position) {
        try {
            if (position.equals("1")) {
                Boolean isWait = waitForCssValueChanged(inputFirstPassword, "border first pwd", "border", "1px solid rgb(89, 155, 161)");
                if (isWait) {
                    NXGReports.addStep("Verify border Green while input valid pass: Pass", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify border Green while input valid pass: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                Boolean isWait = waitForCssValueChanged(inputSecondPassword, "border first pwd", "border", "1px solid rgb(89, 155, 161)");
                if (isWait) {
                    NXGReports.addStep("Verify border Green while input valid pass: Pass", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify border Green while input valid pass: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify border Green while input valid pass: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void selectSetPasswordBtn() {
        clickElement(buttonSetPassword, "Set password Btn");
    }

    /*
    End of Vien.Pham
     */
}