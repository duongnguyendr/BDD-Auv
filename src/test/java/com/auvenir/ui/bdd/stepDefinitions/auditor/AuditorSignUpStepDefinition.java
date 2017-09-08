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

    @And("^I input full name text box$")
    public void iInputFullNameTextBox(List<String> fullName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I input: " + fullName.get(0) + " to full name text box =====");
        auditorSignUpPage.inputFullName(fullName.get(0));
    }

    @And("^I input email address$")
    public void iInputEmailAddress(List<String> strEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I input email: " + strEmail.get(0) + " to email text box =====");
        auditorSignUpPage.inputEmail(strEmail.get(0));
    }

    @And("^I input confirm email$")
    public void iInputConfirmEmail(List<String> strEmailConfirm) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I input email: " + strEmailConfirm.get(0) + " to confirm email text box =====");
        auditorSignUpPage.inputEmailConfirm(strEmailConfirm.get(0));
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

    @And("^I click continue button$")
    public void iClickContinueButton() throws Throwable {
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

    @And("^I input firm name$")
    public void iInputFirmName(List<String> firmName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input firm name");
        auditorSignUpPage.inputFirmName(firmName.get(0));
    }

    @And("^I input firm webside$")
    public void iInputFirmWebside(List<String> firmWebside) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input firm webside");
        auditorSignUpPage.inputFirmWebSide(firmWebside.get(0));
    }

    @And("^I select country$")
    public void iSelectCountry(List<String> country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select country");
        auditorSignUpPage.selectCountry(country.get(0));
    }

    @And("^I select provide state$")
    public void iSelectProvideState(List<String> strState) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select provide state");
        auditorSignUpPage.selectAnyStateInList(strState.get(0));
    }

    @And("^I input street address$")
    public void iInputStreetAddress(List<String> strStreet) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input street address");
        auditorSignUpPage.inputStreet(strStreet.get(0));
    }

    @And("^I input zip code$")
    public void iInputZipCode(List<String> StrZipCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input zip code");
        auditorSignUpPage.inputZipCode(StrZipCode.get(0));
    }

    @And("^I input city$")
    public void iInputCity(List<String> strCity) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input city");
        auditorSignUpPage.inputCity(strCity.get(0));
    }

    @And("^I input office number$")
    public void iInputOfficeNumber(List<String> strOffiNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input office number");
        auditorSignUpPage.inputOfficeNumber(strOffiNum.get(0));
    }

    @And("^I input memberId$")
    public void iInputMemberId(List<String> strMemberId) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input member Id");
        auditorSignUpPage.inputMemberID(strMemberId.get(0));
    }

    @And("^I select number employee$")
    public void iSelectNumberEmployee() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I select number employee");
        auditorSignUpPage.selectNumberEmployee();
    }

    @And("^I input business phone number$")
    public void iInputBusinessPhoneNumber(List<String> businessPhoneNum) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input business phone number");
        auditorSignUpPage.selectFirmPhoneNumber(businessPhoneNum.get(0));
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

    @And("^I input affiliate name$")
    public void iInputAffiliateName(List<String> affiliateName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I input affiliate name");
        auditorSignUpPage.inputAffiliate(affiliateName.get(0));
    }

    @And("^I click on continue button$")
    public void iClickOnCountinueButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I click on countinue button");
        auditorSignUpPage.clickContinueButton();
    }

    @Then("^I should see thank for create account page$")
    public void iShouldSeeThankForCreateAccountPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("I should see thank for create account page");
        auditorSignUpPage.verifySuccessPageContent();
    }

}
