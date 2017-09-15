package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorSignUpPage;
import com.auvenir.ui.bdd.pages.client.ClientSignUpPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class SignUpStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(SignUpStepDefinition.class.getSimpleName());
    BaseInit baseInit;
    ClientSignUpPage clientSignUpPage;
    AuditorSignUpPage auditorSignUpPage;

    public SignUpStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        auditorSignUpPage = new AuditorSignUpPage(logger, driver);
        clientSignUpPage = new ClientSignUpPage(logger, driver);
    }

    @And("^I should see personal sign up page$")
    public void iShouldSeePersonalSignUpPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I should see personal sign up page =====");
        auditorSignUpPage.verifyPersonalInfoPageContent();
    }

    @And("^I input phone number$")
    public void iInputPhoneNumber(List<String> phoneNumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I input: " + phoneNumber.get(0) + " to phone number text box =====");
        auditorSignUpPage.inputPhoneNumber(phoneNumber.get(0));
    }

    @And("^I select how to hear about Auvenir$")
    public void iSelectHowToHearAboutAuvenir() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select how to hear about auvenir");
        auditorSignUpPage.selectOptionHearAboutAuvenir();
    }

    @And("^I click agree with privacy and term service check box$")
    public void iClickAgreeWithPrivacyAndTermServiceCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click agree with privacy and term of service check box");
        auditorSignUpPage.clickAgreeCheckBox();
    }

    @And("^I click confirm check box$")
    public void iClickConfirmCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click confirm check box");
        auditorSignUpPage.clickConfirmCheckBox();
    }

    @And("^I click continue button on sign up page$")
    public void iClickContinueButtonOnSignUpPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click continue button");
        auditorSignUpPage.clickContinueButton();
    }

    @Then("^I should see provide firm information page$")
    public void iShouldSeeProvideFirmInfomationPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see provide firm infomation page");
        auditorSignUpPage.verifyFirmInfomationPage();
    }

    @And("^I select role in firm$")
    public void iSelectRoleInFirm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select role in firm");
        auditorSignUpPage.selectRoleInFirm();
    }

    @And("^I select number employee$")
    public void iSelectNumberEmployee() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select number employee");
        auditorSignUpPage.selectNumberEmployee();
    }

    @And("^I check rule logo check box$")
    public void iCheckRuleLogoCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I check rule logo check box");
        auditorSignUpPage.clickOnRuleLogoCheckBox();
    }

    @And("^I check on affiliate checkbox$")
    public void iCheckOnAffiliateCheckbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I check on affiliate checkbox");
        auditorSignUpPage.clickOnAllFirmCheckBox();
    }

    //    @And("^I click on continue button$")
    //    public void iClickOnCountinueButton() throws Throwable {
    //        // Write code here that turns the phrase above into concrete actions
    //        logger.info("I click on countinue button");
    //        auditorSignUpPage.clickContinueButton();
    //    }

    @Then("^I should see thank for create account page$")
    public void iShouldSeeThankForCreateAccountPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see thank for create account page");
        auditorSignUpPage.verifySuccessPageContent();
    }

    @And("^I input full name: \"([^\"]*)\" text box$")
    public void iInputFullNameTextBox(String fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        auditorSignUpPage.inputFullName(fullName);
    }

    @And("^I input email address: \"([^\"]*)\"$")
    public void iInputEmailAddress(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        auditorSignUpPage.inputEmail(email);
    }

    @And("^I input confirm email: \"([^\"]*)\"$")
    public void iInputConfirmEmail(String emailConfirm) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        auditorSignUpPage.inputEmailConfirm(emailConfirm);
    }

    @And("^I input phone number: \"([^\"]*)\"$")
    public void iInputPhoneNumber(String phoneNumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        auditorSignUpPage.inputPhoneNumber(phoneNumber);
    }

    @And("^I input firm name: \"([^\"]*)\"$")
    public void iInputFirmName(String firmName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input firm name");
        auditorSignUpPage.inputFirmName(firmName);
    }

    @And("^I input firm web side: \"([^\"]*)\"$")
    public void iInputFirmWebSide(String firmWebside) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input firm webside");
        auditorSignUpPage.inputFirmWebSide(firmWebside);
    }

    @And("^I select country: \"([^\"]*)\"$")
    public void iSelectCountry(String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select country");
        auditorSignUpPage.selectCountry(country);
    }

    @And("^I select provide state: \"([^\"]*)\"$")
    public void iSelectProvideState(String strState) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I select provide state");
        auditorSignUpPage.selectAnyStateInList(strState);
    }

    @And("^I input street address: \"([^\"]*)\"$")
    public void iInputStreetAddress(String strStreet) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input street address");
        auditorSignUpPage.inputStreet(strStreet);
    }

    @And("^I input zip code: \"([^\"]*)\"$")
    public void iInputZipCode(String StrZipCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input zip code");
        auditorSignUpPage.inputZipCode(StrZipCode);
    }

    @And("^I input city: \"([^\"]*)\"$")
    public void iInputCity(String strCity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input city");
        auditorSignUpPage.inputCity(strCity);
    }

    @And("^I input office number: \"([^\"]*)\"$")
    public void iInputOfficeNumber(String strOffiNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input office number");
        auditorSignUpPage.inputOfficeNumber(strOffiNum);
    }

    @And("^I input memberId: \"([^\"]*)\"$")
    public void iInputMemberId(String strMemberId) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input member Id");
        auditorSignUpPage.inputMemberID(strMemberId);
    }

    @And("^I input business phone number: \"([^\"]*)\"$")
    public void iInputBusinessPhoneNumber(String businessPhoneNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input business phone number");
        auditorSignUpPage.selectFirmPhoneNumber(businessPhoneNum);
    }

    @And("^I input affiliate name: \"([^\"]*)\"$")
    public void iInputAffiliateName(String affiliateName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input affiliate name");
        auditorSignUpPage.inputAffiliate(affiliateName);
    }

    @And("^I create password: \"([^\"]*)\"$")
    public void createPassword(String passWord) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I create password");
        auditorSignUpPage.createPassword(passWord);
    }

    @Then("^I should see Welcome to Auvenir Page$")
    public void verifyWelcomePageTitle() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see Welcome to Auvenir Page");
        clientSignUpPage.verifyWelcomePageTitle();
    }

    @And("^I click on Get Start button on Client Sign Up Page$")
    public void clickGetStartedButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see Welcome to Auvenir Page");
        clientSignUpPage.clickGetStartedButton();
    }

    @Then("^I should see Provide Information Page$")
    public void iVerifyProvideInfomationPageTitle() throws Throwable {
        logger.info("I should see Welcome to Auvenir Page");
        clientSignUpPage.verifyProvideInformationPageTitle();
    }

    @And("^I fill up all Client Personal Information with Phone Number: \"([^\"]*)\"$")
    public void fillUpClientPersonalInformationPage(String phoneNumber) throws Throwable {
        logger.info("I fill up all Information Page");
        clientSignUpPage.fillUpPersonalForm(phoneNumber);
    }

    @And("^I click on Continue Button on Personal Information Page$")
    public void clickPersonalContinueButton() throws Throwable {
        logger.info("I click on Continue Button on Personal Information Page");
        clientSignUpPage.clickPersonalContinueButton();
    }

    @And("^I input confirm auditor personal information: \"([^\"]*)\"$")
    public void iInputConfirmAuditorPersonalInformation(String phoneNumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I input confirm auditor personal information: " + phoneNumber);
        auditorSignUpPage.confirmAuditorPersonalInfo(phoneNumber);
    }

    @And("^I click on continue button on firm information page$")
    public void iClickOnContinueButtonOnFirmInformationPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click on continue button on firm information page");
        auditorSignUpPage.clickContinueFilmButton();
    }
    @Then("^I should see Business Information Page$")
    public void seeBusinessInformationPage() throws Throwable {
        logger.info("I should see Business Information Page");
        clientSignUpPage.verifyBusinessPageTitle();
    }

    @And("^I fill up all Client Business Information$")
    public void fillUpBusinessInformationPage() throws Throwable {
        logger.info("I fill up Client Business Information Page");
        clientSignUpPage.fillUpBusinessForm();
    }


    @And("^I click on Continue Button on Business Information Page$")
    public void clickBusinessContinueButton() throws Throwable {
        logger.info("I click on Continue Button on Business Information Page");
        clientSignUpPage.clickContinueButtonOnBusinessPage();
    }

    @Then("^I should see Bank Information Page$")
    public void seeBankInformationPage() throws Throwable {
        logger.info("I should see Bank Information Page");
        //        clientSignUpPage.verifyBankInformationTitle();
    }

    @And("^I fill up all Bank Information$")
    public void fillUpBankInformation() throws Throwable {
        logger.info("I fill up all Bank Information");
        //        clientSignUpPage.fillUpBankForm();
    }

    @And("^I click on Skip Button on Bank Information Page$")
    public void clickSkipButtonOnBankPage() throws Throwable {
        logger.info("I click on Skip Button on Bank Information Page");
        //        clientSignUpPage.clickSkipButtonOnBankPage();
    }

    @Then("^I should see File Storage Information Page$")
    public void seeFileStorageInformationPage() throws Throwable {
        logger.info("I should see File Storage Information Page");
        clientSignUpPage.verifyFileStoragePageTitle();
    }

    @And("^I fill up all File Storage Information$")
    public void fillUpFileStorageInformation() throws Throwable {
        logger.info("I fill up all File Storage Information");
        clientSignUpPage.fillUpFileForm();
    }

    @And("^I click on Skip Button on File Storage Information Page$")
    public void clickSkipButtonOnFilePage() throws Throwable {
        logger.info("I click on Skip Button on File Storage Information Page");
        clientSignUpPage.clickSkipButtonOnFilePage();
    }

    @Then("^I should see Security Information Page$")
    public void seeSecurityInformationPage() throws Throwable {
        logger.info("I should see Security Information Page");
        clientSignUpPage.verifySecurityPageTitle();
    }

    @And("^I fill up all Security Information with Password: \"([^\"]*)\"$")
    public void fillUpAllSecurityInformation(String password) throws Throwable {
        logger.info("I fill up all Security Information");
        clientSignUpPage.fillUpSecurityForm(password);
    }

    @And("^I click on Create Account Button on Security Information Page$")
    public void clickCreateAccountButtonOnSecurityPage() throws Throwable {
        logger.info("I click on Create Account Button on Security Information Page");
        clientSignUpPage.clickCreateAccountButtonOnSecurityPage();
    }
}
