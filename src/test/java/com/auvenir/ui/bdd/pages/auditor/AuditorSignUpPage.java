package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by duong.nguyen on 9/7/2017.
 */
public class AuditorSignUpPage extends KeyWord {
    public AuditorSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    // ================================= Element of First and Last Name =======================================
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_fullname']")
    private WebElement eleName;

    // Element of EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email']")
    private WebElement eleEmail;

    // Element with locator of confirm EmailAddress
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_email_confirm']")
    private WebElement eleConfirmEmail;

    // Element of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]")
    private WebElement eleRoleFirm;

    // Element of Phone Number
    @FindBy(xpath = "//form[@id='onboarding-personal-info']//div[@class='ui input']//input[@name='member_phone_number']")
    private WebElement elePhoneNumber;

    // Element of Hear about Auvenir
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]")
    private WebElement eleReference;

    // Element of checkbox I agree
    @FindBy(xpath = "//div[@class='ui checkbox']/label/span")
    private WebElement chkAgree;

    // List Item of ListBox Role in Firm
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[1]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemRoleFirmEle;

    // List Item of Option 'Hear about Auvenir'
    @FindBy(xpath = "(//form[@id='onboarding-personal-info']//div[@role='listbox'])[2]//div[@class='menu transition visible']/div")
    private List<WebElement> listItemReferenceEle;

    // Element of checkbox I confirm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[contains(text(),'confirm')]/..")
    private WebElement chkConfirm;

    // Page Provide Firm Information Div Element
    @FindBy(xpath = "//div[@class='step-content' and @id='step2']")
    private WebElement pageProvideFirmInfoEle;

    // Element of button Continue
    @FindBy(id = "btn-continue")
    private WebElement btnContinue;

    // ================================================ Element of Firm Name  =============================================
    @FindBy(xpath = "//input[@name='firm_name']")
    private WebElement eleFirmName;

    public WebElement getEleFirmName() {
        return eleFirmName;
    }

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_name']")
    private WebElement eleFirmNameError;

    // Element of checkbox rule changed Name
    //    @FindBy(xpath = "//*[@id='img-upload-label']/ancestor::form//div[contains(@class,'ui checked')]/label")
    //    private WebElement chkChangedName;

    // Element of Firm previous Name
    @FindBy(xpath = "//input[@name='firm_previous_name']")
    private WebElement elePreFirmName;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_previous_name']")
    private WebElement elePreFirmNameError;

    // Element of Firm website
    @FindBy(xpath = "//input[@name='firm_website']")
    private WebElement eleFirmWebsite;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_website']")
    private WebElement elePreFirmWebsiteError;

    // Element of Full Address
    @FindBy(xpath = "//input[@name='firm_full_address']")
    private WebElement eleFullAddress;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_full_address']")
    private WebElement eleFullAddressError;

    // Element of Street Address
    @FindBy(xpath = "//input[@name='firm_street_address']")
    private WebElement eleStreetAddress;


    // Element of Office number
    @FindBy(xpath = "//input[@name='firm_suit_number']")
    private WebElement eleOfficeNumber;

    // Element of Zip Code
    @FindBy(xpath = "//input[@name='firm_postal_code']")
    private WebElement eleZipCode;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_postal_code']")
    private WebElement eleZipCodeError;

    // Element of City
    @FindBy(xpath = "//input[@name='firm_city']")
    private WebElement eleCity;

    //Element of Country dropdown
    @FindBy(xpath = "(//div[@role='listbox'])[1]")
    private WebElement countryDropdownEle;

    //Element of State dropdown
    @FindBy(xpath = "(//div[@role='listbox'])[2]")
    private WebElement stateDropdownEle;

    //Element of Country_State
    @FindBy(xpath = "(//div[@role='listbox'])[3]")
    private WebElement numberOfEmployeeDropdownEle;

    //Element of listOfCountry_State
    @FindBy(xpath = "//div[@role='listbox']//div[@class='menu transition visible']/div")
    private List<WebElement> country_State_NumberOfEmployee_ListEle;

    @FindBy(xpath = "//div[@role='listbox']/div[@class='text']")
    private WebElement countrySelectedEle;
    // Element of State Dropdown list
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[1]")
    private WebElement provinceDropdownEle;

    // Element with locator of Menu listbox
    @FindBy(xpath = "//div[@class='menu transition visible']")
    private WebElement eleMenu;

    // Element of Member I.D
    @FindBy(xpath = "//input[@name='firm_member_id']")
    private WebElement eleMemberID;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_member_id']")
    private WebElement eleMemberIdError;

    // Element of Number of Employees Dropdown
    @FindBy(xpath = "(//form[@id='onboarding-firm-info']//div[@role='listbox'])[3]")
    private WebElement numberEmployeeDropdown;

    // Element of Phone Number
    @FindBy(xpath = "//input[@name='firm_phone_number']")
    private WebElement phoneNumberFirmInfoEle;

    @FindBy(xpath = "//form[@id='onboarding-firm-info']//div[@class='ui input']//input[@name='firm_phone_number']")
    private WebElement elePhoneNumberIdError;

    // Element of checkbox affiliated Firm
    @FindBy(xpath = "//div[@class='ui checkbox']/label[starts-with(text(),'I am affiliated') or starts-with(text(),'Je')]")
    private WebElement chkAffFirm;

    // Element of Affiliated Firm Name
    @FindBy(xpath = "//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirm;

    @FindBy(xpath = "//div[@class='error field']//label[text()='Affiliated Firm’s Name' or contains(text(),'Nom de')]/following-sibling::div[1]/input")
    private WebElement eleAffFirmError;

    // Element of checkbox Rule Logo
    @FindBy(xpath = "//label[starts-with(text(),'Once') or starts-with(text(),'Un')]")
    private WebElement chkRuleLogo;

    @FindBy(xpath = "//*[@id='account-created-confirmation']//h1[@class='ui header']")
    private WebElement successPageHeaderEle;
    // Element image letter
    @FindBy(css = ".ui.image")
    private WebElement eleImageLetter;

    /**
     * Verify Content of Register Personal Information Page
     */
    public void verifyPersonalInfoPageContent() {
        getLogger().info("Verify Content of Register Personal Information Page");
        // Checking First and Last Name element is displayed
        validateElememt(eleName, "Element First and Last Name", Element_Type.DISPLAYED);
        // Checking Email Address element is displayed
        validateElememt(eleEmail, "Element of Email Address", Element_Type.DISPLAYED);
        // Checking ReEnter Email Address element is displayed
        validateElememt(eleConfirmEmail, "Element of ReEnter Email Address", Element_Type.DISPLAYED);
        //  Checking Role in Firm element is displayed
        validateElememt(eleRoleFirm, "Element of Role in Firm", Element_Type.DISPLAYED);
        // Checking Phone Number element is displayed
        validateElememt(elePhoneNumber, "Element of Phone Number", Element_Type.DISPLAYED);
        // Checking Reference Auvenir element is displayed
        validateElememt(eleReference, "Element of Reference Auvenir", Element_Type.DISPLAYED);
    }

    public void inputFullName(String fullName){
        waitForVisibleElement(eleName, "Full name");
        sendKeyTextBox(eleName, fullName, "Full Name TextBox");
    }

    public void inputEmail(String strEmail){
        waitForVisibleElement(eleEmail, "Email");
        sendKeyTextBox(eleEmail, strEmail, "Email Name TextBox");
    }

    public void inputEmailConfirm(String strEmailConfirm){
        waitForVisibleElement(eleConfirmEmail, "Email");
        sendKeyTextBox(eleConfirmEmail, strEmailConfirm, "Confirm Email TextBox");
    }

    public void selectRoleInFirm(){
        waitForClickableOfElement(eleRoleFirm, "Role in Firm Dropdown");
        clickElement(eleRoleFirm, "Role");
        waitForAtrributeValueChanged(eleRoleFirm, "Role in Firm Dropdown", "aria-expanded", "true");
        clickElement(listItemRoleFirmEle.get(0), "First Item on Role Dropdown");
        waitForAtrributeValueChanged(eleRoleFirm, "Role in Firm Dropdown", "aria-expanded", "false");
    }

    public void inputPhoneNumber(String strPhone){
        waitForVisibleElement(elePhoneNumber, "Phone number");
        sendKeyTextBox(elePhoneNumber, strPhone, "Phone number TextBox");
    }

    public void selectOptionHearAboutAuvenir(){
        waitForVisibleElement(eleReference, "Reference check box");
        clickElement(eleReference, "Reference check box");
        waitForAtrributeValueChanged(eleReference, "Reference 'Hear' Dropdown", "aria-expanded", "true");
        clickElement(listItemReferenceEle.get(0), "First Item on Reference 'Hear' Dropdown");
        waitForAtrributeValueChanged(eleReference, "Reference 'Hear' Dropdown", "aria-expanded", "false");
    }

    public void clickAgreeCheckBox(){
        waitForVisibleElement(chkAgree, "Check box agree");
        clickElement(chkAgree, " check box agree");
    }

    public void clickConfirmCheckBox(){
        waitForVisibleElement(chkConfirm, "Check box confirm");
        clickElement(chkConfirm, "check box confirm");
    }

    public void clickContinueButton(){
        waitForVisibleElement(btnContinue, "Continue button");
        clickElement(btnContinue, "continue button");
    }

    public void verifyFirmInfomationPage(){
        boolean result = validateDisPlayedElement(pageProvideFirmInfoEle, "Page Provide Firm Infomation");
        Assert.assertTrue(result, "Page Provide Your Firm Infomation should be loaded.");
    }

    public void inputFirmName(String firmName){
        waitForVisibleElement(eleFirmName, "Firm Name Input");
        sendKeyTextBox(eleFirmName, firmName, "Firm Name Input");
    }

    public void inputFirmWebSide(String firmWebsite){
        waitForVisibleElement(eleFirmWebsite, "Firm Website Input");
        sendKeyTextBox(eleFirmWebsite, firmWebsite, "Firm Website Input");
    }

    public void inputStreet(String strStreetAddr){
        waitForVisibleElement(eleStreetAddress, "Street Address Input");
        sendKeyTextBox(eleStreetAddress, strStreetAddr, "Street Address Input");
    }

    public void inputOfficeNumber(String strOffNum){
        waitForVisibleElement(eleOfficeNumber, "Office Number Input");
        sendKeyTextBox(eleOfficeNumber, strOffNum, "Office Number Input");
    }

    public void selectCountry(String strCountry){
        verifyCountryList();
        selectAnyCountryInList(strCountry);
        verifyStateListAfterSelectCountry(strCountry);
    }

    public void selectAnyStateInList(String nameOfState) {
        try {
            int index = findCountry_StateInList(nameOfState);
            if (index == -1) {
                System.out.println("Can not find the state has name is: " + nameOfState);
            }
            clickElement(country_State_NumberOfEmployee_ListEle.get(index));
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void inputZipCode(String strZipCode){
        waitForVisibleElement(eleZipCode, "Zip Code Input");
        sendKeyTextBox(eleZipCode, strZipCode, "Zip Code Input");
    }

    public void inputCity(String strCity){
        waitForVisibleElement(eleCity, "City Input");
        sendKeyTextBox(eleCity, strCity, "City Input");
    }

    public void inputMemberID(String value) {
        try {
            clickElement(eleMemberID, "click to memberID");
            sendKeyTextBox(eleMemberID, value, "sendkey to member ID");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void selectNumberEmployee(){
        waitForVisibleElement(numberOfEmployeeDropdownEle, "Number Of Employee Dropdown");
        clickElement(numberOfEmployeeDropdownEle, "Number Of Employee Dropdown");
        waitForAtrributeValueChanged(numberOfEmployeeDropdownEle, "Number Of Employee Dropdown", "aria-expanded", "true");
        clickElement(country_State_NumberOfEmployee_ListEle.get(0), "First Item on Number of Employee Dropdown");
        waitForAtrributeValueChanged(numberOfEmployeeDropdownEle, "Number Of Employee Dropdown", "aria-expanded", "false");
    }

    public void selectFirmPhoneNumber(String strPhone){
        waitForVisibleElement(phoneNumberFirmInfoEle, "Phone Number Input");
        sendKeyTextBox(phoneNumberFirmInfoEle, strPhone, "Phone Number Input");
    }

    public void clickOnRuleLogoCheckBox() {
        hoverElement(chkRuleLogo, " rule logo check box");
        clickElement(chkRuleLogo, " rule logo check box");
    }

    public void clickOnAllFirmCheckBox() {
        hoverElement(this.chkAffFirm, " all firm check box");
        clickElement(this.chkAffFirm, " all firm check box");
    }

    public void inputAffiliate(String strAffName){
        waitForVisibleElement(eleAffFirm, "Affiliated Firm's Name Input");
        sendKeyTextBox(eleAffFirm, strAffName, "Affiliated Firm's Name Input");
    }

    public void verifyCountryList() {
        try {
            getLogger().info("Verifying list of Country displayed correctly..");
            waitForVisibleElement(countryDropdownEle, "wait for Country menu visible");
            clickElement(countryDropdownEle, "country dropdown menu");
            int isCount = country_State_NumberOfEmployee_ListEle.size();
            System.out.println("Number of countries in country list is: " + isCount);
            String firstCountry = country_State_NumberOfEmployee_ListEle.get(0).getText();
            System.out.println("First Country in list is: " + firstCountry);
            String secoundCountry = country_State_NumberOfEmployee_ListEle.get(1).getText();
            System.out.println("Second Country in list is: " + secoundCountry);
            if (isCount == 231 && firstCountry.equals("Canada") && secoundCountry.equals("United States")) {
            } else {
                Assert.fail("Verify list of Country: failed.");
            }
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void selectAnyCountryInList(String nameOfCountry) {
        try {
            int index = findCountry_StateInList(nameOfCountry);
            if (index == -1) {
                System.out.println("Can not find the country has name is: " + nameOfCountry);
            }
            clickElement(country_State_NumberOfEmployee_ListEle.get(index));
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public int findCountry_StateInList(String value) {
        int index;
        for (index = 0; index < country_State_NumberOfEmployee_ListEle.size(); index++) {
            if (country_State_NumberOfEmployee_ListEle.get(index).getText().equals(value)) {
                break;
            }
        }
        if (index == country_State_NumberOfEmployee_ListEle.size()) {
            return index = -1;
        }
        return index;
    }

    public void verifyStateListAfterSelectCountry(String nameOfCountry) {
        try {
            getLogger().info("Verifying list of State of: " + nameOfCountry + " displayed correctly..");
            waitForVisibleElement(stateDropdownEle, "wait for Country menu visible");
            clickElement(stateDropdownEle, "country dropdown menu");
            int isCount = country_State_NumberOfEmployee_ListEle.size();
            System.out.println("Number of states in country list is: " + isCount);
            String firstState = country_State_NumberOfEmployee_ListEle.get(0).getText();
            System.out.println("First State in list is: " + firstState);
            String secoundState = country_State_NumberOfEmployee_ListEle.get(1).getText();
            System.out.println("Second State in list is: " + secoundState);
            if (nameOfCountry.equals("Canada")) {
                if (isCount == 13 && firstState.equals("Alberta") && secoundState.equals("British Columbia")) {
                    getLogger().info("Verify list of State :" + nameOfCountry + " passed");
                } else {
                    Assert.fail("Verify list of State :" + nameOfCountry + " failed");
                }
            }
            if (nameOfCountry.equals("United States")) {
                if (isCount == 51 && firstState.equals("Alabama") && secoundState.equals("Alaska")) {
                    getLogger().info("Verify list of State :" + nameOfCountry + " passed");
                } else {
                    Assert.fail("Verify list of State :" + nameOfCountry + " failed");
                }
            }
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void verifySuccessPageContent() {
        getLogger().info("Verify Content of Register Success Page");
        waitForVisibleElement(successPageHeaderEle, "Success Page Header");
        validateDisPlayedElement(successPageHeaderEle, "Success Page Header");
        // validateElementText(successPageHeaderEle, "Your Account is on the Waitlist!");
        validateElementText(successPageHeaderEle, "Thank you for your interest in Auvenir!");
        // Checking Image Letter element is displayed
        waitForVisibleElement(eleImageLetter, "Image Letter");
        validateDisPlayedElement(eleImageLetter, "Element of Image Letter");
        // Checking button Close element is displayed
        validateDisPlayedElement(btnContinue, "Element of button Continue");
    }
}

