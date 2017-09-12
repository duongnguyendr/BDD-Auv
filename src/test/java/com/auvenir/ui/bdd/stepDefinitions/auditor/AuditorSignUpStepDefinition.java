package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorSignUpPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by duong.nguyen on 9/7/2017.
 */
public class AuditorSignUpStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorSignUpPage auditorSignUpPage;
    public AuditorSignUpStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorSignUpPage = new AuditorSignUpPage(logger, driver);
    }

    @And("^I should see personal sign up page$")
    public void iShouldSeePersonalSignUpPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I should see personal sign up page =====");
        auditorSignUpPage.verifyPersonalInfoPageContent();
    }

    @And("^I input phone number$")
    public void iInputPhoneNumber(List<String> phoneNumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I input: " + phoneNumber.get(0) + " to phone number text box =====");
        auditorSignUpPage.inputPhoneNumber(phoneNumber.get(0));
    }

    @And("^I select how to hear about Auvenir$")
    public void iSelectHowToHearAboutAuvenir() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select how to hear about auvenir");
        auditorSignUpPage.selectOptionHearAboutAuvenir();
    }

    @And("^I click agree with privacy and term service check box$")
    public void iClickAgreeWithPrivacyAndTermServiceCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click agree with privacy and term of service check box");
        auditorSignUpPage.clickAgreeCheckBox();
    }

    @And("^I click confirm check box$")
    public void iClickConfirmCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click confirm check box");
        auditorSignUpPage.clickConfirmCheckBox();
    }

    @And("^I click continue button on sign up page$")
    public void iClickContinueButtonOnSignUpPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click continue button");
        auditorSignUpPage.clickContinueButton();
    }

    @Then("^I should see provide firm information page$")
    public void iShouldSeeProvideFirmInfomationPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see provide firm infomation page");
        auditorSignUpPage.verifyFirmInfomationPage();
    }

    @And("^I select role in firm$")
    public void iSelectRoleInFirm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select role in firm");
        auditorSignUpPage.selectRoleInFirm();
    }

    @And("^I select number employee$")
    public void iSelectNumberEmployee() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select number employee");
        auditorSignUpPage.selectNumberEmployee();
    }

    @And("^I check rule logo check box$")
    public void iCheckRuleLogoCheckBox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I check rule logo check box");
        auditorSignUpPage.clickOnRuleLogoCheckBox();
    }

    @And("^I check on affiliate checkbox$")
    public void iCheckOnAffiliateCheckbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I check on affiliate checkbox");
        auditorSignUpPage.clickOnAllFirmCheckBox();
    }

//    @And("^I click on continue button$")
//    public void iClickOnCountinueButton() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        getLogger().info("I click on countinue button");
//        auditorSignUpPage.clickContinueButton();
//    }

    @Then("^I should see thank for create account page$")
    public void iShouldSeeThankForCreateAccountPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see thank for create account page");
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
        getLogger().info("I input firm name");
        auditorSignUpPage.inputFirmName(firmName);
    }

    @And("^I input firm web side: \"([^\"]*)\"$")
    public void iInputFirmWebSide(String firmWebside) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input firm webside");
        auditorSignUpPage.inputFirmWebSide(firmWebside);
    }

    @And("^I select country: \"([^\"]*)\"$")
    public void iSelectCountry(String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select country");
        auditorSignUpPage.selectCountry(country);
    }

    @And("^I select provide state: \"([^\"]*)\"$")
    public void iSelectProvideState(String strState) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select provide state");
        auditorSignUpPage.selectAnyStateInList(strState);
    }

    @And("^I input street address: \"([^\"]*)\"$")
    public void iInputStreetAddress(String strStreet) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input street address");
        auditorSignUpPage.inputStreet(strStreet);
    }

    @And("^I input zip code: \"([^\"]*)\"$")
    public void iInputZipCode(String StrZipCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input zip code");
        auditorSignUpPage.inputZipCode(StrZipCode);
    }

    @And("^I input city: \"([^\"]*)\"$")
    public void iInputCity(String strCity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input city");
        auditorSignUpPage.inputCity(strCity);
    }

    @And("^I input office number: \"([^\"]*)\"$")
    public void iInputOfficeNumber(String strOffiNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input office number");
        auditorSignUpPage.inputOfficeNumber(strOffiNum);
    }

    @And("^I input memberId: \"([^\"]*)\"$")
    public void iInputMemberId(String strMemberId) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input member Id");
        auditorSignUpPage.inputMemberID(strMemberId);
    }

    @And("^I input business phone number: \"([^\"]*)\"$")
    public void iInputBusinessPhoneNumber(String businessPhoneNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input business phone number");
        auditorSignUpPage.selectFirmPhoneNumber(businessPhoneNum);
    }

    @And("^I input affiliate name: \"([^\"]*)\"$")
    public void iInputAffiliateName(String affiliateName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input affiliate name");
        auditorSignUpPage.inputAffiliate(affiliateName);
    }

    @And("^I create password: \"([^\"]*)\"$")
    public void iCreatePassword(String passWord) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I create password");
        auditorSignUpPage.createPassword(passWord);
    }
}
