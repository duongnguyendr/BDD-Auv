package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.DatePicker;
import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by thuan.duong on 9/12/2017.
 */
public class ClientSignUpPage extends CommonPage {

    @FindBy(xpath = "//h3[@id='welcome-body']")
    private WebElement titleWelcome;

    @FindBy(id = "welcome-continueBtn")
    private WebElement buttonWelcomeContinue;

    @FindBy(xpath = "//div[@id='onboarding-personal-container']//h2")
    private WebElement titleComponentPersonal;

    @FindBy(id = "personal-phoneNumber")
    private WebElement inputPersonalPhoneNumber;

    //@FindBy(id = "agreement-personal")
    @FindBy(xpath = "//div[@id='icheckbox']")
    private WebElement checkboxAgreementPersonal;

    @FindBy(id = "personal-continueBtn")
    private WebElement buttonPersonalContinue;

    @FindBy(xpath = "//div[@id='onboarding-business-container']//h2")
    private WebElement titleComponentBusiness;

    @FindBy(xpath = ".//div[@class='field']//label[@class='auv-label' and not(@id)]")
    private WebElement labelBusinessIndustry;

    @FindBy(xpath = ".//form[@id='onboarding-business-info']//div[@class='field']/div[@role='listbox']")
    private WebElement inputBusinessIndustry;

    @FindBy(name = "business_fiscal_year")
    private WebElement inputFiscalEndYear;

    @FindBy(xpath = "//div[@class='field']//div[contains(@class,'menu transition')]/div[@role='option']")
    private List<WebElement> listOptionIndustryEle;

    @FindBy(name = "business_name")
    private WebElement businessNameEle;

    //@FindBy(id = "accounting-framework")
    @FindBy(xpath = "//div[@class='field business-smallerInput']/div[@role='listbox']")
    private WebElement inputAccountingFramework;

    //@FindBy(xpath = "//div[@id='accounting-framework-container']//a")
    @FindBy(xpath = "//div[@class='field business-smallerInput']//div[@role='option']")
    private List<WebElement> listOptionAccountingFramework;

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
        PageFactory.initElements(driver, this);
    }

    public void verifyWelcomePageTitle() {
        getLogger().info("Welcome Page loaded.(Status change: Onboarding->Active)");
        switchToOtherTab(1);
        boolean result = validateElementText(titleWelcome, "Welcome to Auvenir!");
        Assert.assertTrue(result, "Should see the Welcome to Auvenir! title.");
    }

    public void clickGetStartedButton() {
        getLogger().info("Start activating client");
        clickElement(buttonWelcomeContinue, "Button Get Started");
    }

    public void fillUpPersonalForm(String phoneNumber) {
        getLogger().info("Fill Up Personal Form");
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
    }

    public void verifyProvideInformationPageTitle() {
        getLogger().info("Verify Provide Information Page Title");
        boolean result = validateElementText(titleComponentPersonal, "Please Provide your Information");
        Assert.assertTrue(result, "Should see the Please Provide your Information title.");
    }

    public void clickPersonalContinueButton() {
        getLogger().info("Click Personal Continue Button.");
        clickElement(buttonPersonalContinue, "Button Personal Continue");
    }

    public void verifyBusinessPageTitle() {
        getLogger().info("Verify Business Page Title");
        boolean result = validateElementText(titleComponentBusiness, "Please Confirm your Business Information");
        Assert.assertTrue(result, "Should see the Business Page Title.");
    }

    public void fillUpBusinessForm() {
        getLogger().info("Fill Up Business Form");
        if (validateNotExistedElement(labelBusinessIndustry, "Input Business Industry")) {
            String industryData = getText(inputBusinessIndustry);
            System.out.println("industryData = " + industryData);
            if (industryData.equalsIgnoreCase("Please select")) {
                clickElement(inputFiscalEndYear, "Input Fiscal End Year");
                DatePicker datePicker = new DatePicker(getDriver());
                datePicker.pickADate("28");
                //Old business
                //                    sendKeyTextBox(inputBusinessIndustry, "Financial", "Input Business Industry");
                clickElement(inputBusinessIndustry, "Input Business Industry");
                // Change the first Item to Third Item
                //                chooseFirstOptionOfInputSelect(listOptionIndustryEle,
                // "chooseFirstOptionOfInputSelect");
                clickElement(listOptionIndustryEle.get(0), "First Option Industry");
                clickElement(businessNameEle, "Business Name Textbox");

                clickElement(inputAccountingFramework, "Input Accounting Framework");
                chooseFirstOptionOfInputSelect(listOptionAccountingFramework, "List Option Accounting Framework");
            }
        }
    }

    public void clickContinueButtonOnBusinessPage() {
        getLogger().info("Click Continue Button on Business");
        clickElement(buttonBusinessContinue, "Button Business Continue");
    }

    public void fillUpBankForm() {
        getLogger().info("Fill Up Bank Form");
        //        validateElementText(titleComponentBank, "Integrate with your Bank");
        //            waitSomeSeconds(10);
        waitForJSandJQueryToLoad();
        scrollToFooter();
    }

    public void verifyBankInformationTitle() {
        getLogger().info("Verify Bank Information Title.");
        validateElementText(titleComponentBank, "Integrate with your Bank");
    }

    public void clickSkipButtonOnBankPage() {
        getLogger().info("Click Skip Button On Bank Page.");
        clickElement(buttonBankSkip, "Button Bank Skip");
    }

    public void fillUpFileForm() {
        getLogger().info("Fill Up File Storage Information Form");
        scrollToFooter();
    }

    public void verifyFileStoragePageTitle() {
        getLogger().info("Verify File Storage Page Title.");
        validateElementText(titleComponentFiles, "Integrate With Your File Storage");
    }

    public void clickSkipButtonOnFilePage() {
        getLogger().info("Click Skip Button On File Page.");
        clickElement(buttonFilesSkip, "Button File Skip");
    }

    public void fillUpSecurityForm(String password) {
        getLogger().info("Fill Up Personal Form");
        sendKeyTextBox(inputCreatePassword, password, "Input Create Password");
        sendKeyTextBox(inputConfirmPassword, password, "Input Confirm Password");
        sendTabKey(inputConfirmPassword, "Input Confirm Password");
        waitSomeSeconds(1);
    }

    public void verifySecurityPageTitle() {
        getLogger().info("Verify File Storage Page Title.");
        validateElementText(titleComponentSecurity, "Create Your Password");
    }

    public void clickCreateAccountButtonOnSecurityPage() {
        getLogger().info("Click Continue Button on Security Page.");
        clickElement(buttonSecurityContinue, "Button Security Continue");
        waitSomeSeconds(3);
        waitForProgressOverlayIsClosed();
    }

}
