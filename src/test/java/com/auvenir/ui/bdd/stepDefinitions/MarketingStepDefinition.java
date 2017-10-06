package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.marketing.MarketingPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 8/30/2017.
 */
public class MarketingStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(MarketingStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    private MarketingPage marketingPage;

    public MarketingStepDefinition(BaseInit base) {
        this.baseInit = base;
        marketingPage = new MarketingPage(logger, driver);
    }

    @Then("^I should see Forgot Password popup$")
    public void seeForgotPasswordPopup() throws Throwable {
        marketingPage.verifyForgotPasswordPopup();
    }

    @Then("^I input email forgotten password : \"([^\"]*)\"$")
    public void inputEmailForgottenPassword(String email) throws Throwable {
        marketingPage.inputEmailForgottenPassword(email);
    }

    @Then("^I click on Request Reset Link button$")
    public void clickOnRequestResetLinkButton() throws Throwable {
        marketingPage.clickOnRequestResetLinkButton();
    }

    @Then("^I should see Account still processing message")
    public void seeAccountStillProcessingMessage() throws Throwable {
        marketingPage.verifyStillProcessingMessage();
    }

    @Then("^I should see Login popup title$")
    public void seeLoginPopupTitle() throws Throwable {
        marketingPage.verifyLoginPopupTitle();
    }

    @Then("^I should see Header Logo$")
    public void seeHeaderLogo() throws Throwable {
        marketingPage.verifyHeaderLogo();
    }

    @Then("^I should see Login link$")
    public void seeLoginLink() throws Throwable {
        marketingPage.verifyLoginLink();
    }

    @Then("^I should see Sign Up Link$")
    public void seeSignUpLink() throws Throwable {
        marketingPage.seeSignUpLink();
    }

    @Then("^I should see Language Link$")
    public void seeLanguageLink() throws Throwable {
        marketingPage.seeLanguageLink();
    }

    @Then("^I should see Join As Auditor Link$")
    public void seeJoinAsAuditorLink() throws Throwable {
        marketingPage.seeJoinAsAuditorLink();
    }

    @Then("^I scroll to footer$")
    public void scrollToFooter() throws Throwable {
        marketingPage.scrollToFooter();
    }

    @Then("^I redirect to About Page$")
    public void redirectToAboutPage() throws Throwable {
        marketingPage.redirectToAboutPage();
    }

    @Then("^I should see Banner Information$")
    public void seeBannerInformation() throws Throwable {
        marketingPage.seeBannerInformation();
    }

    @Then("^I scroll to Auvenir Mission part$")
    public void scrollToAuvenirMissionPart() throws Throwable {
        marketingPage.scrollToAuvenirMissionPart();
    }

    @Then("^I should see Auvenir Mission header$")
    public void seeAuvenirMissionHeader() throws Throwable {
        marketingPage.seeAuvenirMissionHeader();
    }

    @Then("^I should see Auvenir Mission content$")
    public void seeAuvenirMissionContent() throws Throwable {
        marketingPage.seeAuvenirMissionContent();
    }

    @Then("^I scroll to Why Auvenir part$")
    public void scrollToWhyAuvenirPart() throws Throwable {
        marketingPage.scrollToWhyAuvenirPart();
    }

    @Then("^I should see Why Auvenir header$")
    public void seeWhyAuvenirHeader() throws Throwable {
        marketingPage.seeWhyAuvenirHeader();
    }

    @Then("^I should see Why Auvenir content$")
    public void seeWhyAuvenirContent() throws Throwable {
        marketingPage.seeWhyAuvenirContent();
    }

    @Then("^I should see Home link$")
    public void seeHomeLink() throws Throwable {
        marketingPage.seeHomeLink();
    }

    @Then("^I should see About link$")
    public void seeAboutLink() throws Throwable {
        marketingPage.seeAboutLink();
    }

    @Then("^I should see Contact link$")
    public void seeContactLink() throws Throwable {
        marketingPage.seeContactLink();
    }

    @Then("^I should see Terms of Service link$")
    public void seeTermsOfServiceLink() throws Throwable {
        marketingPage.seeTermsOfServiceLink();
    }

    @Then("^I should see Privacy Policy link$")
    public void seePrivacyPolicyLink() throws Throwable {
        marketingPage.seePrivacyPolicyLink();
    }

    @Then("^I should see Cookie Notice link$")
    public void seeCookieNoticeLink() throws Throwable {
        marketingPage.seeCookieNoticeLink();
    }

    @Then("^I should see Facebook icon$")
    public void seeFacebookIcon() throws Throwable {
        marketingPage.seeFacebookIcon();
    }

    @Then("^I should see Twitter icon$")
    public void seeTwitterIcon() throws Throwable {
        marketingPage.seeTwitterIcon();
    }

    @Then("^I should see Linkedin icon$")
    public void seeLinkedinIcon() throws Throwable {
        marketingPage.seeLinkedinIcon();
    }

    @Then("^I should see Copyright title$")
    public void seeCopyrightTitle() throws Throwable {
        marketingPage.seeCopyrightTitle();
    }

    @Then("^I should see Meet The Auvy League header$")
    public void seeMeetTheAuvyLeagueHeader() throws Throwable {
        marketingPage.seeMeetTheAuvyLeagueHeader();
    }

    @Then("^I should see Meet The Auvy League content: \"([^\"]*)\" members$")
    public void seeMeetTheAuvyLeagueContent(String members) throws Throwable {
        marketingPage.seeMeetTheAuvyLeagueContent(members);
    }

    @Then("^I verify Email label$")
    public void verifyEmailLabel() throws Throwable {
        marketingPage.verifyEmailLabel();
    }

    @Then("^I verify Email textbox$")
    public void verifyEmailTextbox() throws Throwable {
        marketingPage.verifyEmailTextbox();
    }

    @Then("^I verify Password label$")
    public void verifyPasswordLabel() throws Throwable {
        marketingPage.verifyPasswordLabel();
    }

    @Then("^I verify Password textbox$")
    public void verifyPasswordTextbox() throws Throwable {
        marketingPage.verifyPasswordTextbox();
    }

    @Then("^I verify Forgot password link$")
    public void verifyForgotPasswordLink() throws Throwable {
        marketingPage.verifyForgotPasswordLink();
    }

    @Then("^I verify Login button$")
    public void verifyLoginButton() throws Throwable {
        marketingPage.verifyLoginButton();
    }

    @Then("^I redirect to Terms of Service Page$")
    public void redirectToTermsOfServicePage() throws Throwable {
        marketingPage.redirectToTermsOfServicePage();
    }

    @Then("^I should see Terms of Service Header Banner$")
    public void seeTermsOfServiceHeaderBanner() throws Throwable {
        marketingPage.seeTermsOfServiceHeaderBanner();
    }

    @Then("^I should see color of forgot password link is green$")
    public void seeColorOfForgotPasswordLinkIsGreen() throws Throwable {
        marketingPage.seeColorOfForgotPasswordLinkIsGreen();
    }

    @And("^I should see Forgot Password popup title$")
    public void seeForgotPasswordPopupTitle() throws Throwable {
        marketingPage.seeForgotPasswordPopupTitle();
    }

    @And("^I should see Forgot Password popup guide$")
    public void seeForgotPasswordPopupGuide() throws Throwable {
        marketingPage.seeForgotPasswordPopupGuide();
    }

    @And("^I should see Forgot Password popup border$")
    public void seeForgotPasswordPopupBorder() throws Throwable {
        marketingPage.seeForgotPasswordPopupBorder();
    }

    @And("^I should see Forgot Password popup Email label$")
    public void seeForgotPasswordPopupEmailLabel() throws Throwable {
        marketingPage.seeForgotPasswordPopupEmailLabel();
    }

    @And("^I verify input Forgot Email with text: \"([^\"]*)\"$")
    public void verifyInputForgotEmailWithText(String textString) throws Throwable {
        marketingPage.verifyInputForgotEmailWithText(textString);
    }

    @And("^I verify input Forgot Email with number: \"([^\"]*)\"$")
    public void verifyInputForgotEmailWithNumber(String numberString) throws Throwable {
        marketingPage.verifyInputForgotEmailWithNumber(numberString);
    }

    @And("^I verify input Forgot Email with special character: \"([^\"]*)\"$")
    public void verifyInputForgotEmailWithSpecialCharacter(String specialCharacterString) throws Throwable {
        marketingPage.verifyInputForgotEmailWithSpecialCharacter(specialCharacterString);
    }

    @Then("^I click confirm with Account still processing message$")
    public void clickConfirmWithAccountStillProcessingMessage() throws Throwable {
        marketingPage.clickConfirmWithAccountStillProcessingMessage();
    }

    @Then("^I should see Account not exist error message$")
    public void seeAccountNotExistErrorMessage() throws Throwable {
        marketingPage.seeAccountNotExistErrorMessage();
    }

    @Then("^I should see Reset Link Sent message$")
    public void seeResetLinkSentMessage() throws Throwable {
        marketingPage.seeResetLinkSentMessage();
    }

    @Then("^I scroll to Product Feartures part$")
    public void scrollToProductFearturesPart() throws Throwable {
        marketingPage.scrollToProductFearturesPart();
    }

    @Then("^I should see Spend Less Time, Earn More$")
    public void seeSpendLessTimeEarnMore() throws Throwable {
        marketingPage.seeSpendLessTimeEarnMore();
    }

    @Then("^I should see Securely Store Your Documents$")
    public void seeSecurelyStoreYourDocuments() throws Throwable {
        marketingPage.seeSecurelyStoreYourDocuments();
    }

    @Then("^I should see Simplify Your Workﬂow$")
    public void seeSimplifyYourWorkﬂow() throws Throwable {
        marketingPage.seeSimplifyYourWorkﬂow();
    }

    @Then("^I should see Collaborate Better With Your Clients$")
    public void seeCollaborateBetterWithYourClients() throws Throwable {
        marketingPage.seeCollaborateBetterWithYourClients();
    }

    @Then("^I should see Intelligently Allocate Resources$")
    public void seeIntelligentlyAllocateResources() throws Throwable {
        marketingPage.seeIntelligentlyAllocateResources();
    }

    @Then("^I should see Seamlessly Import Data$")
    public void seeSeamlesslyImportData() throws Throwable {
        marketingPage.seeSeamlesslyImportData();
    }

    @Then("^I should see Customize Branding$")
    public void seeCustomizeBranding() throws Throwable {
        marketingPage.seeCustomizeBranding();
    }

    @Then("^I should see Automated Tools$")
    public void seeAutomatedTools() throws Throwable {
        marketingPage.seeAutomatedTools();
    }

    @Then("^I input Login Email Address: \"([^\"]*)\"$")
    public void inputLoginEmailAddress(String email) throws Throwable {
        marketingPage.inputLoginEmailAddress(email);
    }

    @Then("^I should see \"([^\"]*)\" on Email textbox$")
    public void seeOnEmailTextbox(String email) throws Throwable {
        marketingPage.seeOnEmailTextbox(email);
    }

    @Then("^I input Login Password: \"([^\"]*)\"$")
    public void inputLoginPassword(String password) throws Throwable {
        marketingPage.inputLoginPassword(password);
    }

    @Then("^I should see \"([^\"]*)\" characters on Password textbox$")
    public void seeCharactersOnPasswordTextbox(String password) throws Throwable {
        marketingPage.seeCharactersOnPasswordTextbox(password);
    }

    public class User {
        public String email;
        public String password;

        public User(String eMail, String passWord) {
            email = eMail;
            password = passWord;
        }
    }

    @And("^I enter the following for Login$")
    public void enterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I enter the following for login =====");

        table.asMap(String.class, String.class);
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        for (User user : users) {
            System.out.println("The Email is: " + user.email);
            System.out.println("The Password is: " + user.password);
            marketingPage.inputUserNamePassword(user.email, user.password);
        }
    }

    @And("^I click on login link$")
    public void clickOnLoginLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login link =====");
        marketingPage.clickOnLoginButton();

    }

    @And("^I click sign up link$")
    public void clickSignUpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login link =====");
        marketingPage.clickOnSignUpButton();
    }

    @Then("^I should see marketing portal page$")
    public void shouldSeeMarketingPortalPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see marketing portal page");
        marketingPage.verifyMaketingHeaderPage();

    }

    @And("^I click on login button$")
    public void clickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I click on login button =====");
        marketingPage.clickOnSubmitButton();
        marketingPage.waitForProgressOverlayIsClosed();
    }

    @And("^I click on forgot password link$")
    public void clickOnForgotPasswordLink() throws Throwable {
        marketingPage.clickOnForgotPasswordLink();
    }

    @Then("^I should see text :\"([^\"]*)\"$")
    public void seeTextWannaJoinUs(String arg1) throws Throwable {
        marketingPage.seeAboutJoinUs();

    }

    @Then("^I click on password field$")
    public void clickOnPasswordField() throws Throwable {
        marketingPage.clickOnTextBoxPassword();

    }

    @Then("^I verify change color boundary of field$")
    public void verifyChangeColorBoundary() throws Throwable {
        marketingPage.verifyBoundaryPasswordChange();


    }

    @Then("^I verify input with text :\"([^\"]*)\"$")
    public void verifyInputWithText(String arg1) throws Throwable {
        marketingPage.verifyInputPassword(arg1);

    }

    @Then("^I verify input with number :\"([^\"]*)\"$")
    public void verifyInputWithNumber(String arg1) throws Throwable {
        marketingPage.verifyInputPassword(arg1);
    }

    @Then("^I verify input special character : \"([^\"]*)\"$")
    public void verifyInputSpecialCharacter(String arg1) throws Throwable {
        marketingPage.verifyInputPassword(arg1);
    }

    @Then("^I verify input text have space :\"([^\"]*)\"$")
    public void verifyInputTextHaveSpace(String arg1) throws Throwable {
        marketingPage.verifyInputPassword(arg1);
    }

}
