package com.auvenir.ui.pages.client.general;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.utilities.DatePicker;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by huy.huynh on 14/06/2017.
 */
public class ClientSignUpPage extends AbstractPage {

    @FindBy(xpath = "//h3[@id='welcome-body']")
    private WebElement titleWelcome;

    @FindBy(id = "welcome-continueBtn")
    private WebElement buttonWelcomeContinue;

    @FindBy(xpath = "//div[@id='onboarding-personal-container']//h2")
    private WebElement titleComponentPersonal;


    @FindBy(xpath = "//div[@id='personal-role-container']//input")
    private WebElement inputPersonalRole;

    @FindBy(xpath = "//div[@id='personal-role-container']//a[1]")
    private WebElement optionFirstOnPersonalRoleList;

    @FindBy(id = "personal-phoneNumber")
    private WebElement inputPersonalPhoneNumber;

    //@FindBy(id = "agreement-personal")
    @FindBy(xpath = "//div[@id='icheckbox']")
    private WebElement checkboxAgreementPersonal;

    @FindBy(xpath = "//div[@id='icheckbox']/following-sibling::div//label")
    private WebElement checkboxConfirm;

    @FindBy(id = "personal-continueBtn")
    private WebElement buttonPersonalContinue;

    @FindBy(xpath = "//div[@id='onboarding-business-container']//h2")
    private WebElement titleComponentBusiness;

    @FindBy(xpath = "//p[@for='business-parentStakeholders']")
    private WebElement titleParentStakeholders;

    //@FindBy(id = "business-parentStakeholders")
    @FindBy(name = "business_parent_stake_holders")
    private WebElement textAreaParentStakeholders;

    @FindBy(id = "business-industry")
    private WebElement inputIndustry;

    @FindBy(xpath = "//div[@id='business-industry-container']//a")
    private List<WebElement> listOptionIndustry;

    //@FindBy(id = "accounting-framework")
    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement inputAccountingFramework;

    //@FindBy(xpath = "//div[@id='accounting-framework-container']//a")
    @FindBy(xpath = "//div[@role='option']")
    private List<WebElement> listOptionAccountingFramework;

    @FindBy(name = "business_industry")
    private WebElement inputBusinessIndustry;

    @FindBy(name = "business_fiscal_year")
    private WebElement inputFiscalEndYear;

    @FindBy(id = "onboard-business-continue")
    private WebElement buttonBusinessContinue;

    @FindBy(xpath = "//div[@id='onboarding-bank-container']//h3")
    private WebElement titleComponentBank;

    @FindBy(xpath = "//div[@id='onboarding-bank-container']//button[@class='auvbtn light']")
    private WebElement buttonBankSkip;

    @FindBy(xpath = "//div[@id='onboarding-files-container']//p[@class='component-title']")
    private WebElement titleComponentFiles;

    @FindBy(xpath = "//div[@id='onboarding-files-container']//button[contains(@id,'files-skipBtn')]")
    private WebElement buttonFilesSkip;

    @FindBy(xpath = "//div[@id='onboarding-security-container']//h2")
    private WebElement titleComponentSecurity;

    @FindBy(name = "password")
    private WebElement inputCreatePassword;

    @FindBy(name = "retype_password")
    private WebElement inputConfirmPassword;

    @FindBy(id = "security-continueBtn")
    private WebElement buttonSecurityContinue;

    public ClientSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyWelcomePageTitle() {
        try {
            switchToOtherTab(1);
            validateElementText(titleWelcome, "Welcome to Auvenir!");
            getLogger().info("Welcome Page loaded.(Status change: Onboarding->Active)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickGetStartedButton() {
        try {
            getLogger().info("Start activating client");
            clickElement(buttonWelcomeContinue, "Button Get Started");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpPersonalForm(String phoneNumber) {
        try {
            getLogger().info("Fill Up Personal Form");
            validateElementText(titleComponentPersonal, "Please Provide your Information");
            //clickElement(inputPersonalRole, "Input Personal Role");
            //waitSomeSeconds(5);
            //scrollToFooter();
            //clickElement(optionFirstOnPersonalRoleList, "First Option Personal Role");
            sendKeyTextBox(inputPersonalPhoneNumber, phoneNumber, "Input Personal Phone Number");
            //            clickElement(checkboxConfirm, "Checkbox Confirm Chartered Professional Accountant");
            clickElement(titleComponentPersonal, "Title Personal Information Page");
            clickElement(checkboxAgreementPersonal, "Checkbox Agreement Personal");
            switchToOtherTab(1);
            scrollToFooter();
            clickElement(buttonPersonalContinue, "Button Personal Continue");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @FindBy(id = "personal-referral")
    WebElement hearAboutAuvenir;
    @FindBy(xpath = "//div[@id='personal-referral']//div[@role='option']")
    WebElement selectFirstOptionOfHearAuvenir;
    @FindBy(id = "agreement-personal-cpa")
    WebElement herebyCheckbox;
    @FindBy(id = "firm-affiliated")
    WebElement affiliatedCheckbox;
    @FindBy(id = "firm-affiliated-name")
    WebElement affiliatedName;
    @FindBy(id = "onboard-firm-continue")
    WebElement onboardFirmContinueBtn;
    @FindBy(xpath = "//div[@id='onboarding-personal-container']//h2[@class='ui center aligned header']")
    WebElement titlePersonalGeneralAuditor;
    @FindBy(xpath = "(//div[contains(@id,'module-')])[3]")
    WebElement generalAuditorSignupPage;

    public void fillUpPersonalFormOfAuditorPage(String phoneNumber) {
        try {
            waitSomeSeconds(5);
            //            waitForCssValueChanged(generalAuditorSignupPage,"General Auditor Sign Up page","display","inherit");
            //            waitForTextValueChanged(titlePersonalGeneralAuditor, "", "Please Provide your Information");
            scrollToFooter();
            sendKeyTextBox(inputPersonalPhoneNumber, phoneNumber, "Input Personal Phone Number");
            clickElement(hearAboutAuvenir);
            clickElement(selectFirstOptionOfHearAuvenir, "first Option of hear Auvenir");
            clickElement(checkboxAgreementPersonal, "Checkbox Agreement Personal");
            clickElement(herebyCheckbox, "Hereby checkbox");
            clickElement(buttonPersonalContinue, "Button Personal Continue");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillUpFirmPage(String affiliatedTxt) {
        try {
            clickElement(affiliatedCheckbox, "affiliated checkbox");
            clickElement(affiliatedName);
            sendKeyTextBox(affiliatedName, affiliatedTxt, "");
            clickElement(onboardFirmContinueBtn, "Continue Btn");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillUpBusinessForm(String parentStakeholders) {
        try {
            getLogger().info("Fill Up Business Form");
            validateElementText(titleComponentBusiness, "Please Confirm your Business Information");
            //            if (textAreaParentStakeholders.getTagName().equals("textarea")) {
            //                clickElement(inputFiscalEndYear, "Input Fiscal End Year");
            //                DatePicker datePicker = new DatePicker(getDriver());
            //                datePicker.pickADate("28");
            //                sendKeyTextBox(textAreaParentStakeholders, parentStakeholders, "Text Area Parent Stakeholders");
            //            }
            scrollToFooter();
            if (!validateNotExistedElement(inputBusinessIndustry, "Input Business Industry")) {
                if (getText(inputBusinessIndustry).isEmpty()) {
                    clickElement(inputFiscalEndYear, "Input Fiscal End Year");
                    DatePicker datePicker = new DatePicker(getDriver());
                    datePicker.pickADate("28");
                    sendKeyTextBox(inputBusinessIndustry, "Financial", "Input Business Industry");
                    clickElement(inputAccountingFramework, "Input Accounting Framework");
                    chooseFirstOptionOfInputSelect(listOptionAccountingFramework, "List Option Accounting Framework");
                }
            }
            //clickElement(titleParentStakeholders);
            //clickElement(inputIndustry, "Input Industry");
            //chooseFirstOptionOfInputSelect(listOptionIndustry, "List Option Industry");
            //sometime listoption not close after choose an option, so need to click somewhere to close, avoid it cover others element
            //clickElement(titleParentStakeholders);
            //clickElement(inputAccountingFramework, "Input Accounting Framework");
            //chooseFirstOptionOfInputSelect(listOptionAccountingFramework, "List Option Accounting Framework");
            //clickElement(titleParentStakeholders);
            //scrollToFooter();
            clickElement(buttonBusinessContinue, "Button Business Continue");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpBankForm() {
        try {
            getLogger().info("Fill Up Bank Form");
            validateElementText(titleComponentBank, "Integrate with your Bank");
            //            waitSomeSeconds(10);
            waitForJSandJQueryToLoad();
            scrollToFooter();
            clickElement(buttonBankSkip, "Button Bank Skip");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpFileForm() {
        try {
            getLogger().info("Fill Up Bank Form");
            validateElementText(titleComponentFiles, "Integrate With Your File Storage");
            scrollToFooter();
            clickElement(buttonFilesSkip, "Button File Skip");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillUpSecurityForm(String password) {
        try {
            getLogger().info("Fill Up Personal Form");
            validateElementText(titleComponentSecurity, "Create Your Password");
            sendKeyTextBox(inputCreatePassword, password, "Input Create Password");
            sendKeyTextBox(inputConfirmPassword, password, "Input Confirm Password");
            sendTabkey(inputConfirmPassword, "Input Confirm Password");
            Thread.sleep(1000);
            //            scrollToFooter();
            clickElement(buttonSecurityContinue, "Button Security Continue");
            waitSomeSeconds(10);
            waitForProgressOverlayIsClosed();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
