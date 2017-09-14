package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class InviteNewClientPage extends CommonPage {
    public InviteNewClientPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
    @FindBy(className = "m-ic-subTitle")
    private WebElement titleInviteClient;
    @FindBy(xpath = "//input[@id='m-ci-step-one-input']")
    private WebElement eleSelectYourClientDrpDwn;
    @FindBy(xpath = "//ul[@class='ddlLink inputDdl inputDdl-after']//a")
    private WebElement optionAddNewClient;
    @FindBy(id = "m-ac-name")
    private WebElement inputFullName;

    @FindBy(id = "m-inm-name")
    private WebElement inputFullNameMember;

    @FindBy(id = "m-ac-email")
    private WebElement inputEmail;

    @FindBy(id = "m-inm-email")
    private WebElement inputEmailMember;

    @FindBy(id = "m-ac-emailVerify")
    private WebElement inputVerifyEmail;
    @FindBy(id = "m-inm-reEmail")
    private WebElement inputVerifyEmailMember;
    @FindBy(id = "m-ac-role")
    private WebElement inputRoleEmail;
    @FindBy(id = "m-ac-addBtn")
    private WebElement buttonInviteNewClient;

    public void verifyInviteClientPopUpDisplay(){
        boolean result = validateElementText(titleInviteClient, "Invite Your Client");
        Assert.assertEquals(result, true);
    }

    public void selectAddNewClient() {
        clickElement(eleSelectYourClientDrpDwn, "Select dropdown");
        clickElement(optionAddNewClient, "Option Add New Client");
    }

    public void inputFullNameClient(String fullName){
        sendKeyTextBox(inputFullName, fullName, "Full Name Input");
    }

    public void inputEmailClient(String email){
        sendKeyTextBox(inputEmail, email,"Email");
    }
    public void inputConfirmEmail(String email){
        sendKeyTextBox(inputVerifyEmail, email, "Confirm email");
    }

    public void inputRoleClient(String clientRole){
        sendKeyTextBox(inputRoleEmail, clientRole, "Role in company");
    }

    public void clickInviteButton(){
        clickElement(buttonInviteNewClient, "Button Invite");
        waitForProgressOverlayIsClosed();
    }

    public void verifyInviteClientSuccess(String message) {
        waitSomeSeconds(2);
        verifyContentOfSuccessToastMessage(message);
    }


}
