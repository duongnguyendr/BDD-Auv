package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class CreateNewAuditPage extends AbstractPage {

    public CreateNewAuditPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//button[text()='Create New']")
    private WebElement eleNewAuditBtn;

    public WebElement getEleNewAuditBtn() {
        return eleNewAuditBtn;
    }

    @FindBy(xpath = "//input[@placeholder='Enter your audit name']")
    private WebElement eleEnterYourAuditNameTxtBox;

    public WebElement getEleEnterYourAuditNameTxtBox() {
        return eleEnterYourAuditNameTxtBox;
    }

    //@FindBy(xpath = "//h4[contains(text(),'My Client')]/../div//button[text()='Select Client']")
    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectClientBtn;

    public WebElement getEleSelectClientBtn() {
        return eleSelectClientBtn;
    }

    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectBtn;

    public WebElement getEleSelectBtn() {
        return eleSelectBtn;
    }

    @FindBy(xpath = "//input[@id='m-ci-step-one-input']")
    private WebElement eleSelectYourClientDrpDwn;

    public WebElement getEleSelectYourClientDrpDwn() {
        return eleSelectYourClientDrpDwn;
    }

    @FindBy(xpath = "//p[text()='Please select your client']")
    private WebElement elePleaseSelectYourTxt;

    public WebElement getElePleaseSelectYourTxt() {
        return elePleaseSelectYourTxt;
    }

    @FindBy(xpath = "//h1[@class='addClient-header']")
    private WebElement eleAddNewClientTxt;

    public WebElement getEleAddNewClientTxt() {
        return eleAddNewClientTxt;
    }

    @FindBy(xpath = "//a[text()='Create New']")
    private WebElement eleCreateNewClientDrpDwn;

    public WebElement getEleCreateNewClientDrpDwn() {
        return eleCreateNewClientDrpDwn;
    }

    @FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
    private WebElement eleEnterDueDateTxtBox;

    public WebElement getEleEnterDueDateTxtBox() {
        return eleEnterDueDateTxtBox;
    }

    @FindBy(xpath = "//input[@placeholder='Enter email address']")
    private WebElement eleEnterEmailAddTxtBox;

    public WebElement getEleEnterEmailAddTxtBox() {
        return eleEnterEmailAddTxtBox;
    }

    @FindBy(xpath = "//button[@id='m-ic-continueBtn']")
    private WebElement eleContinueBtn;

    public WebElement getEleContinueBtn() {
        return eleContinueBtn;
    }

    @FindBy(xpath = "//button[@class='w-mc-name']")
    private WebElement eleFirstNameTxt;

    public WebElement getEleFirstNameTxt() {
        return eleFirstNameTxt;
    }

    public WebElement getEleSelectCreatedClientDrpDwn(String newClientName) {
        return getDriver().findElement(By.xpath("//a[text()='" + newClientName + "']"));
    }

    @FindBy(xpath = "//div[contains(text(),'Your enagagement invitation has been sent.')]")
    private WebElement eleEnagagementInivitationTxt;

    public WebElement getEleEnagagementInivitationTxt() {
        return eleEnagagementInivitationTxt;
    }

    @FindBy(xpath = "//button[text()='Invite']")
    private WebElement eleInviteBtn;

    public WebElement getEleInviteBtn() {
        return eleInviteBtn;
    }

    @FindBy(xpath = "//button[text()='Resend']")
    private WebElement eleResendBtn;

    public WebElement getEleResendBtn() {
        return eleResendBtn;
    }

    @FindBy(xpath = "//*[@id='engagement-my-client-widget']/h4")
    private WebElement myClientTitleEle;

    @FindBy(xpath = "//p[@class = 'w-mc-name']")
    private WebElement clientNameTextEle;

    public void clickSelectClientButton() {
        waitForVisibleElement(myClientTitleEle, "My Client Title");
        validateElementText(myClientTitleEle, "My Client");
        clickElement(eleSelectClientBtn, "Select Client Button");
    }

    public void verifyPleaseSelectClientText() {
        waitForVisibleElement(elePleaseSelectYourTxt, "Please select your client");
        validateDisPlayedElement(elePleaseSelectYourTxt, "Please select your client");
        validateElementText(elePleaseSelectYourTxt, "Please select your client");
    }

    public void clickCreateNewClient() {
        waitForVisibleElement(eleSelectYourClientDrpDwn, "Select Your Client Dropdown");
        clickElement(eleSelectYourClientDrpDwn, "Select Your Client Dropdown");
        waitForVisibleElement(eleCreateNewClientDrpDwn, "Create New Client Item");
        clickElement(eleCreateNewClientDrpDwn, "Create New Client Item");
    }

    public void verifyAddNewClientPopUpDisplayed() {
        waitForVisibleElement(eleAddNewClientTxt, "Add New Client Title");
        validateDisPlayedElement(eleAddNewClientTxt, "Add New Client Title");
        validateElementText(eleAddNewClientTxt, "Add New Client");
    }

    public void clickSelectClient(String clientName) {
        getLogger().info("Select client.");
        waitForVisibleElement(eleSelectYourClientDrpDwn, "Select Your Client Dropdown");
        clickElement(eleSelectYourClientDrpDwn, "Select Your Client Dropdown");
        waitForVisibleElement(getEleSelectCreatedClientDrpDwn(clientName), String.format("client name '%s' option", clientName));
        clickElement(getEleSelectCreatedClientDrpDwn(clientName), String.format("client name '%s' option", clientName));
        waitForVisibleElement(eleContinueBtn, "Continue Button");
        clickElement(eleContinueBtn, "Continue Button");
        waitForProgressOverlayIsClosed();
    }

    public void verifyClientIsSelected(String clientFirstName) {
        getLogger().info("Verify Client is selected.");
        waitForVisibleElement(clientNameTextEle, "Client Name Text");
        validateDisPlayedElement(clientNameTextEle, "Client Name Text");
        validateElementText(clientNameTextEle, clientFirstName);
        validateDisPlayedElement(eleInviteBtn, "Invite Button");
    }

    public void sendInvitationName() {
        getLogger().info("Send Invitation to Client.");
        //        closeSuccessToastMes();
        waitForProgressOverlayIsClosed();
        final String expectedContent = "Your engagement invitation has been sent.";
        clickElement(eleInviteBtn, "Invite Button");
        verifyContentOfSuccessToastMessage(expectedContent);
        clickElement(eleResendBtn, "Resend Button");
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */

    @FindBy(className = "m-ic-subTitle")
    private WebElement titleInviteClient;

    @FindBy(xpath = "//ul[@class='ddlLink inputDdl inputDdl-after']//a")
    private WebElement optionAddNewClient;

    @FindBy(xpath = "//p[@class='addClient-header']")
    private WebElement titleInviteNewClient;

    @FindBy(xpath = "//h3[@class='inm-subTitle']")
    private WebElement titleInviteNewMember;

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

    @FindBy(id = "m-inm-jobTitle")
    private WebElement inputRoleMember;

    @FindBy(id = "m-ac-addBtn")
    private WebElement buttonInviteNewClient;

    @FindBy(id = "m-inm-addBtn")
    private WebElement buttonInviteNewMember;

    @FindBy(xpath = "//input[@id='m-ac-role']/following-sibling::ul//a[1]")
    private WebElement optionFirstOnClientRoleList;

    @FindBy(xpath = "(//input[@id='m-inm-jobTitle']/following-sibling::ul//a)[1]")
    private WebElement optionFirstOnMemberRoleList;

    /**
     * Choose 'Add New Client' option
     */
    public void selectAddNewClient() {
        prepareSelectClientToInvite();
        clickElement(optionAddNewClient, "Option Add New Client");
    }

    public void prepareSelectClientToInvite() {
        waitSomeSeconds(1);
        validateElementText(titleInviteClient, "Invite Your Client");
        clickElement(eleSelectYourClientDrpDwn, "Select Client");
    }

    public void selectClientWithFullName(String fullName) {
        prepareSelectClientToInvite();
        String xpathOptionAdminClientName = "//ul[@class='ddlLink inputDdl inputDdl-after']//a[text()='%s']";
        clickElement(getElementByXpath(xpathOptionAdminClientName, fullName), "Option Admin Client Name");
    }

    /**
     * Input info to invite a client
     *
     * @param fullName name of client
     * @param email    email
     * @param role     role on company
     */
    public void fillInfoToInviteNewMember(String fullName, String email, String role) {
        waitForTextValueChanged(titleInviteNewMember, "Invite New Member", "Invite New Member");
        sendKeyTextBox(inputFullNameMember, fullName, "Full Name Input");
        sendKeyTextBox(inputEmailMember, email, "Email Input");
        sendKeyTextBox(inputVerifyEmailMember, email, "Verify Email Input");
        sendKeyTextBox(inputRoleMember, role, "Input Role Member");
        //        clickElement(inputRoleEmailMember, "Input Member Role In Their Company");
        //        clickElement(optionFirstOnMemberRoleList, "First Option member Role");
        //        waitSomeSeconds(3);
        clickElement(buttonInviteNewMember, "Button Invite");
    }

    public void fillInfoToInviteNewClient(String fullName, String email, String role) {
        waitForTextValueChanged(titleInviteNewClient, "Invite New Client", "Invite New Client");
        sendKeyTextBox(inputFullName, fullName, "Full Name Input");
        sendKeyTextBox(inputEmail, email, "Email Input");
        sendKeyTextBox(inputVerifyEmail, email, "Verify Email Input");
        //sendKeyTextBox(inputRoleEmail, role, "Role Input");
        //selectOptionByText(selectRoleEmail, role, "Client Role In Their Company");
        clickElement(inputRoleEmail, "Input Client Role In Their Company");
        clickElement(optionFirstOnClientRoleList, "First Option Client Role");

        clickElement(buttonInviteNewClient, "Button Invite");
    }

    @FindBy(xpath = "//button[@id='team-inviteMember-btn']")
    WebElement inviteMemberBtn;
    @FindBy(xpath = "//div[@id='engagement-team']")
    WebElement engagementTeam;

    public void selectInviteNewMemberButton() {
        waitForCssValueChanged(engagementTeam, "engagementTeam", "display", "block");
        clickElement(inviteMemberBtn);
    }

    /**
     * Verify if show success Toast message
     *
     * @param message toast message
     */

    WebElement inviteClientPage;

    public void verifyInviteClientSuccess(String message) {
        waitForProgressOverlayIsClosed();
        verifyContentOfSuccessToastMessage(message);
    }

    public void verifyInviteClientFailure(String message) {
        waitForProgressOverlayIsClosed();
        verifyContentOfWarningToastMessage(message);
        closeWarningToastMessage();
    }
     /*-----------end of huy.huynh on 02/06/2017.*/

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */

     @FindBy(id = "m-ic-continueBtn")
     WebElement buttonInviteClient;

    public void clickButtonInvite(){
        clickElement(buttonInviteClient, "Button Invite Client");
    }
    /*-----------end of huy.huynh on 03/08/2017.*/
}
