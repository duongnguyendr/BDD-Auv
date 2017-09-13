package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    public ClientSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyWelcomePageTitle() {
        getLogger().info("Welcome Page loaded.(Status change: Onboarding->Active)");
        switchToOtherTab(1);
        boolean result = validateElementText(titleWelcome, "Welcome to Auvenir!");
        Assert.assertTrue(result,"Should see the Welcome to Auvenir! title.");
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
        getLogger().info("Fill Up Personal Form");
        boolean result = validateElementText(titleComponentPersonal, "Please Provide your Information");
        Assert.assertTrue(result,"Should see the Please Provide your Information title.");
    }

    public void clickPersonalContinueButton() {
        getLogger().info("Click Personal Continue Button.");
        clickElement(buttonPersonalContinue, "Button Personal Continue");
    }


}
