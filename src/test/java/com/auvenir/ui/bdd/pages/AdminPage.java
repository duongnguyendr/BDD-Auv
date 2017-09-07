package com.auvenir.ui.bdd.pages;

//import com.auvenir.ui.pages.AuvenirPage;
//import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
//import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AdminPage extends KeyWord {
    public AdminPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }
//    AuvenirPage auvenirPage = null;
    WebElement SelectStatus = null;
    String xpathUserTypeCellOnAdminPage = "//*[@id='w-mu-table']//tr/td[2][text()='%s']";
    private int waitTime = 60;
    //@FindBy(xpath = "//span[@id='pageHeadBackText']")
    @FindBy(id = "pageHeadBackText")
    private WebElement eleAdminHdrTxt;
    @FindBy(xpath = "//button[text()='View Credentials']")
    private WebElement eleViewCredentialsBtn;
    @FindBy(xpath = "//p[text()='Auvenir Users']//..//h3")
    private WebElement eleAuvenirUserCountTxt;
    @FindBy(xpath = "//p[text()='Auvenir Users']")
    private WebElement eleAuvenirUserTxt;
    @FindBy(xpath = "//p[text()='Auvenir Users']//..//i")
    private WebElement eleAuvenirUserImg;
    @FindBy(xpath = "//p[text()='Auditors']//..//h3")
    private WebElement eleAuditorsCountTxt;
    @FindBy(xpath = "//p[text()='Auditors']")
    private WebElement eleAuditorsTxt;
    @FindBy(xpath = "//p[text()='Auditors']//..//i")
    private WebElement eleAuditorsImg;
    @FindBy(xpath = "//p[text()='Businesses']//..//h3")
    private WebElement eleBusinessesCountTxt;
    @FindBy(xpath = "//p[text()='Businesses']")
    private WebElement eleBusinessesTxt;
    @FindBy(xpath = "//p[text()='Businesses']//..//i")
    private WebElement eleBusinessesImg;
    @FindBy(xpath = "//p[text()='Engagements']//..//h3")
    private WebElement eleEngagementsCountTxt;
    @FindBy(xpath = "//p[text()='Engagements']")
    private WebElement eleEngagementsTxt;
    @FindBy(xpath = "//p[text()='Engagements']//..//i")
    private WebElement eleEngagementsImg;
    @FindBy(xpath = "//td[text()='Name']")
    private WebElement eleNameTxt;
    @FindBy(xpath = "//td[text()='User Type']")
    private WebElement eleUserTypeTxt;
    @FindBy(xpath = "//td[text()='Email']")
    private WebElement eleEmailTxt;
    @FindBy(xpath = "//td[text()='Date Created']")
    private WebElement eleDateCreatedTxt;
    @FindBy(xpath = "//td[text()='Auvenir Rep']")
    private WebElement eleAuvenirRepTxt;
    @FindBy(xpath = "//td[text()='Current CPA']")
    private WebElement eleCurrentCPATxt;
    @FindBy(xpath = "//td[text()='Status']")
    private WebElement eleStatusTxt;
    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement eleStatusConfirmBtn;
    @FindBy(xpath = "//img[@src='images/icons/x-small.svg']")
    private WebElement eleVerifyAuditorSuccessFullyBtn;
    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement eleConfirmBtn;
    @FindBy(xpath = "//p[text()='PENDING to ONBOARDING']")
    private WebElement elePENDINGtoONBOARDINGTxt;
    @FindBy(xpath = "//p[text()='WAIT-LIST to ONBOARDING']")
    private WebElement eleWAITLISTtoONBOARDINGTxt;
    @FindBy(xpath = "//p[text()='ONBOARDING to ACTIVE']")
    private WebElement eleONBOARDINGtoACTIVETxt;
    @FindBy(xpath = "//div[@id='msgContainer']/p/div[contains(text(),'Updated')]")
    private WebElement eleUpdatedtoACTIVETxt;
    @FindBy(id = "msgText-vyeaMOlY")
    private WebElement elePENDINGcanINVITEDTxt;
    @FindBy(id = "msgText-iP3tMBkM")
    private WebElement eleUsercannotACTIVETxt;
    @FindBy(xpath = "//div[@class='au-modal-container modalTransition-popUp-container']/img[@class='au-modal-closeBtn']")
    private WebElement eleCredentialsCloseIcn;
    @FindBy(xpath = "//div[@class='au-modal-container modalTransition-popUp-container']/img")
    private WebElement eleCloseIcn;
    @FindBy(xpath = "//div[@class='au-modal-container au-modal-fullScreen modalTransition-fp-container']/img")
    private WebElement elePopupCloseIcn;
    @FindBy(xpath = "//img[@src='images/icons/close-x.svg']")
    private WebElement eleMailCloseIcn;
    @FindBy(xpath = "//xhtml:pre")
    private WebElement eleDeletedTxt;
    @FindBy(xpath = "//b[text()='Auth ID:']")
    private WebElement eleAuthIDTxt;
    @FindBy(xpath = "//b[text()='API Key:']")
    private WebElement eleAPIKeyTxt;
    @FindBy(className = "inbox-view-messages")
    private WebElement eleViewMessagesBtn;
    @FindBy(xpath = "//div[contains(text(),'There are no emails')]")
    private WebElement eleThereNoEmailsTxt;
    @FindBy(className = "inbox-header-default-title")
    private WebElement eleMyMessagesTxt;
    @FindBy(xpath = "//button[text()='New Message']")
    private WebElement eleNewMessageBtn;
    @FindBy(className = "m-email-header")
    private WebElement eleNewMessageTxt;
    @FindBy(xpath = "//div[@class='m-email-header']//img")
    private WebElement eleNewMsgCloseIcn;
    @FindBy(xpath = "//label[text()='To:']")
    private WebElement eleEmailToTxt;
    @FindBy(xpath = "//li[@class='search-field']/input[@type='text']")
    private WebElement eleEmailToTxtFld;
    @FindBy(xpath = "//label[text()='Subject:']")
    private WebElement eleSubjectTxt;
    @FindBy(id = "m-email-subjectInput")
    private WebElement eleSubjectTxtFld;
    @FindBy(id = "m-email-bodyText")
    private WebElement eleEmailBodyTxtFld;
    @FindBy(xpath = "//button[text()='Send']")
    private WebElement eleSendBtn;
    @FindBy(id = "m-email-fileUpload")
    private WebElement eleAttachmentIcn;
    @FindBy(xpath = "//div[@id='inbox-empty']//img")
    private WebElement eleInboxMsgImg;
    @FindBy(className = "inbox-empty-text")
    private WebElement eleYouDontHaveTxt;
    @FindBy(xpath = "//div[@class='notification-content notification-noContent']")
    private WebElement eleYouHaveNoNotificationTxt;
    @FindBy(xpath = "//div[text()='View All']")
    private WebElement eleViewAllLnk;
    @FindBy(xpath = "//h4[text()='My Notifications']")
    private WebElement eleMyNotificationsTxt;
    @FindBy(xpath = "//i[@class='icon auvicon-notifications']")
    private WebElement eleNotificationsIcn;
    @FindBy(className = "notification-noNoti-text")
    private WebElement eleYouDontHaveNotificationTxt;
    @FindBy(className = "notification-noNoti-link")
    private WebElement eleClickHereLnk;
    @FindBy(id = "navTitle")
    private WebElement eleSettingsTxt;
    @FindBy(id = "titleContent")
    private WebElement eleAccountSettingsTxt;
    @FindBy(id = "link-setting-account")
    private WebElement eleAccountLnk;
    @FindBy(id = "fullNameLabel")
    private WebElement eleFirstLastNameTxt;
    @FindBy(id = "acc-ay-fullName")
    private WebElement eleFirstLastNameTxtFld;
    @FindBy(id = "emailLabel")
    private WebElement eleEmailAddressTxt;
    @FindBy(id = "acc-ay-email")
    private WebElement eleEmailAddressTxtFld;
    @FindBy(id = "phoneLabel")
    private WebElement elePhomeNumberTxt;
    @FindBy(id = "acc-ay-phone")
    private WebElement elePhoneNumberTxtFld;
    @FindBy(id = "acc-ay-photo")
    private WebElement elePhotoImg;
    @FindBy(id = "uploadButtonLabel")
    private WebElement eleYourPhotoTxt;
    @FindBy(id = "uploadButton")
    private WebElement eleUpdateBtn;
    @FindBy(xpath = "//button[text()='Deactivate My Account']")
    private WebElement eleDeactivateLnk;
    @FindBy(xpath = "//label[text()='Deactivate Account']")
    private WebElement eleDeactivatAccTxt;
    @FindBy(className = "au-modal-title-icon")
    private WebElement eleAlertIcn;
    @FindBy(id = "deactivateAccountText")
    private WebElement eleYouareAboutTxt;
    @FindBy(xpath = "//*[text()='Cancel']")
    private WebElement eleCancelBtn;
    @FindBy(xpath = "//input[@value='Deactivate']")
    private WebElement eleDeactivateBtn;
    @FindBy(id = "link-setting-device")
    private WebElement eleDevicesLnk;
    @FindBy(className = "card-account-title")
    private WebElement eleMyDevicesTxt;
    @FindBy(id = "pNumDevices")
    private WebElement eleYouRegisteredTxt;
    @FindBy(className = "c-devices-deviceImg")
    private WebElement eleDeviceImg;
    @FindBy(className = "c-devices-deviceCustomName")
    private WebElement eleDeviceCustomerNmTxt;
    @FindBy(className = "c-devices-deviceName")
    private WebElement eleDeviceNameTxt;
    @FindBy(xpath = "//button[text()='View']")
    private WebElement eleViewBtn;
    @FindBy(xpath = "//div[@class='au-modal-title']/label")
    private WebElement eleCustomerNameTxt;
    @FindBy(className = "c-devices-deviceViewImg")
    private WebElement eleDeviceViewImg;
    @FindBy(xpath = "//button[text()='Disconnect Device']")
    private WebElement eleDisconnectDeviceBtn;
    @FindBy(xpath = "//div[text()='Disconnect this device?']")
    private WebElement eleDisconnectthisDeviceTxt;
    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement eleCancelDisconnectBtn;
    @FindBy(xpath = "//button[text()='Disconnect']")
    private WebElement eleDisconnectBtn;
    @FindBy(xpath = "//td[text()='Device:']")
    private WebElement eleDeviceTxt;
    @FindBy(xpath = "//td[text()='OS: ']")
    private WebElement eleOSTxt;
    @FindBy(xpath = "//td[text()='Browser: ']")
    private WebElement eleBrowserTxt;
    @FindBy(xpath = "//td[text()='Last Used: ']")
    private WebElement eleLastUsedTxt;
    @FindBy(xpath = "//button[text()='+ Add Another']")
    private WebElement eleAddAnotherLnk;
    @FindBy(id = "component-title")
    private WebElement eleRegisterDeviceTxt;
    @FindBy(id = "component-description")
    private WebElement eleDownloadAuvenirTxt;
    @FindBy(id = "smsInputBox")
    private WebElement eleTextMeTxtFld;
    @FindBy(id = "smsSendBtn")
    private WebElement eleTextMeBtn;
    @FindBy(className = "register-mb-img")
    private WebElement eleRegisterMobileImg;
    @FindBy(xpath = "//img[@src='images/components/applestore.png']")
    private WebElement eleDownloadAppStoreImg;
    @FindBy(xpath = "//img[@src='images/components/googlestore.png']")
    private WebElement eleGetItGooglePlayImg;
    @FindBy(xpath = "//*[@id='w-mu-table']//tr/td[2]")
    private List<WebElement> listUserTypeEle;
    @FindBy(xpath = "//*[contains(@id,'m-demoteUser') and (@class ='au-modal-title-text')]")
    private WebElement demoteSuperAdminTitleTextPopup;
    @FindBy(xpath = "//*[@id='w-mu-demoteUserModal']/div[@style='display: inherit;']//span")
    private WebElement demoteSuperAdminContentPopup;
    @FindBy(xpath = "//*[@id='w-mu-demoteUser-removeBtn']")
    private WebElement continueBtnOnDemotePopup;
    @FindBy(xpath = "//*[@id='w-mu-selectUser-ddl']")
    private WebElement grantedUserDropdownList;
    @FindBy(xpath = "//*[@id='w-mu-selectUser-cancelBtn']")
    private WebElement cancelBtnOnDemotePopup;
    @FindBy(xpath = "//*[@id='w-mu-selectUser-removeBtn']")
    private WebElement selectBtnOnDemotePopup;
    @FindBy(xpath = "//*[contains(@id,'m-demoteUser') and (@class ='au-modal-title')]")
    private WebElement demoteSuperAdminTitlePopup;
    @FindBy(xpath = "//*[@class='progress-overlay']")
    private WebElement progressingDiv;
    /**
     * Refactored by huy.huynh on 30/05/2017.
     * New for smoke test
     */
    @FindBy(xpath = "//table[@id='w-mu-table']")
    private WebElement tableUser;
    @FindBy(xpath = "//p[contains(@id,'msgText')]/div/p[1]")
    private WebElement textViewOnPopupConfirm;
    private String xpathUserTypeCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[2]";
    private String xpathEmailCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[3]";
    private String xpathDateCreatedCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[4]";
    private String xpathStatusCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[5]/select";
    /**
     * Add new by huy.huynh on 06/07/2017.
     * R2.1 NewFeature
     */
    private String xpathDueDateByName = "//table[@id='w-mu-table']//td[3][text()='%s']";


    public WebElement getEleAdminHdrTxt() {
        return eleAdminHdrTxt;
    }

    public WebElement getEleViewCredentialsBtn() {
        return eleViewCredentialsBtn;
    }

    public WebElement getEleAuvenirUserCountTxt() {
        return eleAuvenirUserCountTxt;
    }

    public WebElement getEleAuvenirUserTxt() {
        return eleAuvenirUserTxt;
    }

    public WebElement getEleAuvenirUserImg() {
        return eleAuvenirUserImg;
    }

    public WebElement getEleAuditorsCountTxt() {
        return eleAuditorsCountTxt;
    }

    public WebElement getEleAuditorsTxt() {
        return eleAuditorsTxt;
    }

    public WebElement getEleAuditorsImg() {
        return eleAuditorsImg;
    }

    public WebElement getEleBusinessesCountTxt() {
        return eleBusinessesCountTxt;
    }

    public WebElement getEleBusinessesTxt() {
        return eleBusinessesTxt;
    }

    public WebElement getEleBusinessesImg() {
        return eleBusinessesImg;
    }

    public WebElement getEleEngagementsCountTxt() {
        return eleEngagementsCountTxt;
    }

    public WebElement getEleEngagementsTxt() {
        return eleEngagementsTxt;
    }

    public WebElement getEleEngagementsImg() {
        return eleEngagementsImg;
    }

    public WebElement getEleNameTxt() {
        return eleNameTxt;
    }

    public WebElement getEleUserTypeTxt() {
        return eleUserTypeTxt;
    }

    public WebElement getEleEmailTxt() {
        return eleEmailTxt;
    }

    public WebElement getEleDateCreatedTxt() {
        return eleDateCreatedTxt;
    }

    public WebElement getEleAuvenirRepTxt() {
        return eleAuvenirRepTxt;
    }

    public WebElement getEleCurrentCPATxt() {
        return eleCurrentCPATxt;
    }

    public WebElement getEleStatusTxt() {
        return eleStatusTxt;
    }

    public WebElement getEleStatusConfirmBtn() {
        return eleStatusConfirmBtn;
    }

    public WebElement getEleVerifyAuditorSuccessFullyBtn() {
        return eleVerifyAuditorSuccessFullyBtn;
    }

    public WebElement getEleConfirmBtn() {
        return eleConfirmBtn;
    }

    public WebElement getElePENDINGtoONBOARDINGTxt() {
        return elePENDINGtoONBOARDINGTxt;
    }

    public WebElement getEleWAITLISTtoONBOARDINGTxt() {
        return eleWAITLISTtoONBOARDINGTxt;
    }

    public WebElement getEleONBOARDINGtoACTIVETxt() {
        return eleONBOARDINGtoACTIVETxt;
    }

    public WebElement getEleUpdatedtoACTIVETxt() {
        return eleUpdatedtoACTIVETxt;
    }

    public WebElement getElePENDINGcanINVITEDTxt() {
        return elePENDINGcanINVITEDTxt;
    }

    public WebElement getEleUsercannotACTIVETxt() {
        return eleUsercannotACTIVETxt;
    }

    public WebElement getEleCloseIcn() {
        return eleCloseIcn;
    }

    public WebElement getElePopupCloseIcn() {
        return elePopupCloseIcn;
    }

    public WebElement getEleMailCloseIcn() {
        return eleMailCloseIcn;
    }

    public WebElement getEleDeletedTxt() {
        return eleDeletedTxt;
    }

    public WebElement getEleAuthIDTxt() {
        return eleAuthIDTxt;
    }

    public WebElement getEleAPIKeyTxt() {
        return eleAPIKeyTxt;
    }

    public WebElement getEleViewMessagesBtn() {
        return eleViewMessagesBtn;
    }

    public WebElement getEleThereNoEmailsTxt() {
        return eleThereNoEmailsTxt;
    }

    public WebElement getEleMyMessagesTxt() {
        return eleMyMessagesTxt;
    }

    public WebElement getEleNewMessageBtn() {
        return eleNewMessageBtn;
    }

    public WebElement getEleNewMessageTxt() {
        return eleNewMessageTxt;
    }

    public WebElement getEleNewMsgCloseIcn() {
        return eleNewMsgCloseIcn;
    }

    public WebElement getEleEmailToTxt() {
        return eleEmailToTxt;
    }

    public WebElement getEleEmailToTxtFld() {
        return eleEmailToTxtFld;
    }

    public WebElement getEleSubjectTxt() {
        return eleSubjectTxt;
    }

    public WebElement getEleSubjectTxtFld() {
        return eleSubjectTxtFld;
    }

    public WebElement getEleEmailBodyTxtFld() {
        return eleEmailBodyTxtFld;
    }

    public WebElement getEleSendBtn() {
        return eleSendBtn;
    }

    public WebElement getEleAttachmentIcn() {
        return eleAttachmentIcn;
    }

    public WebElement getEleInboxMsgImg() {
        return eleInboxMsgImg;
    }

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    public WebElement getEleYouHaveNoNotificationTxt() {
        return eleYouHaveNoNotificationTxt;
    }

    public WebElement getEleViewAllLnk() {
        return eleViewAllLnk;
    }

    public WebElement getEleMyNotificationsTxt() {
        return eleMyNotificationsTxt;
    }

    public WebElement getEleNotificationsIcn() {
        return eleNotificationsIcn;
    }

    public WebElement getEleYouDontHaveNotificationTxt() {
        return eleYouDontHaveNotificationTxt;
    }

    public WebElement getEleClickHereLnk() {
        return eleClickHereLnk;
    }

    public WebElement getEleSettingsTxt() {
        return eleSettingsTxt;
    }

    public WebElement getEleAccountSettingsTxt() {
        return eleAccountSettingsTxt;
    }

    public WebElement getEleAccountLnk() {
        return eleAccountLnk;
    }

    public WebElement getEleFirstLastNameTxt() {
        return eleFirstLastNameTxt;
    }

    public WebElement getEleFirstLastNameTxtFld() {
        return eleFirstLastNameTxtFld;
    }

    public WebElement getEleEmailAddressTxt() {
        return eleEmailAddressTxt;
    }

    public WebElement getEleEmailAddressTxtFld() {
        return eleEmailAddressTxtFld;
    }

    public WebElement getElePhomeNumberTxt() {
        return elePhomeNumberTxt;
    }

    public WebElement getElePhoneNumberTxtFld() {
        return elePhoneNumberTxtFld;
    }

    public WebElement getElePhotoImg() {
        return elePhotoImg;
    }

    public WebElement getEleYourPhotoTxt() {
        return eleYourPhotoTxt;
    }

    public WebElement getEleUpdateBtn() {
        return eleUpdateBtn;
    }

    public WebElement getEleDeactivateLnk() {
        return eleDeactivateLnk;
    }

    public WebElement getEleDeactivatAccTxt() {
        return eleDeactivatAccTxt;
    }

    public WebElement getEleAlertIcn() {
        return eleAlertIcn;
    }

    public WebElement getEleYouareAboutTxt() {
        return eleYouareAboutTxt;
    }

    public WebElement getEleCancelBtn() {
        return eleCancelBtn;
    }

    public WebElement getEleDeactivateBtn() {
        return eleDeactivateBtn;
    }

    public WebElement getEleDevicesLnk() {
        return eleDevicesLnk;
    }

    public WebElement getEleMyDevicesTxt() {
        return eleMyDevicesTxt;
    }

    public WebElement getEleYouRegisteredTxt() {
        return eleYouRegisteredTxt;
    }

    public WebElement getEleDeviceImg() {
        return eleDeviceImg;
    }

    public WebElement getEleDeviceCustomerNmTxt() {
        return eleDeviceCustomerNmTxt;
    }

    public WebElement getEleDeviceNameTxt() {
        return eleDeviceNameTxt;
    }

    public WebElement getEleViewBtn() {
        return eleViewBtn;
    }

    public WebElement getEleCustomerNameTxt() {
        return eleCustomerNameTxt;
    }

    public WebElement getEleDeviceViewImg() {
        return eleDeviceViewImg;
    }

    public WebElement getEleDisconnectDeviceBtn() {
        return eleDisconnectDeviceBtn;
    }

    public WebElement getEleDisconnectthisDeviceTxt() {
        return eleDisconnectthisDeviceTxt;
    }

    public WebElement getEleCancelDisconnectBtn() {
        return eleCancelDisconnectBtn;
    }

    public WebElement getEleDisconnectBtn() {
        return eleDisconnectBtn;
    }

    public WebElement getEleDeviceTxt() {
        return eleDeviceTxt;
    }

    public WebElement getEleOSTxt() {
        return eleOSTxt;
    }

    public WebElement getEleBrowserTxt() {
        return eleBrowserTxt;
    }

    public WebElement getEleLastUsedTxt() {
        return eleLastUsedTxt;
    }

    public WebElement getEleAddAnotherLnk() {
        return eleAddAnotherLnk;
    }

    public WebElement getEleRegisterDeviceTxt() {
        return eleRegisterDeviceTxt;
    }

    public WebElement getEleDownloadAuvenirTxt() {
        return eleDownloadAuvenirTxt;
    }

    public WebElement getEleTextMeTxtFld() {
        return eleTextMeTxtFld;
    }

    public WebElement getEleTextMeBtn() {
        return eleTextMeBtn;
    }

    public WebElement getEleRegisterMobileImg() {
        return eleRegisterMobileImg;
    }

    public WebElement getEleDownloadAppStoreImg() {
        return eleDownloadAppStoreImg;
    }

    public WebElement getEleGetItGooglePlayImg() {
        return eleGetItGooglePlayImg;
    }

    public void getEleClientEntryValidate(String UserType, String Email, String DateCreated, String ClientName) throws InterruptedException {
        Thread.sleep(10000);
//        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        WebElement getEleClientTxt =
                getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]"));
        validateDisPlayedElement(getEleClientTxt, "Client Text");
        WebElement getEleClientNameTxt = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + ClientName + "')]"));
        validateDisPlayedElement(getEleClientNameTxt, "Client Name Text");
        WebElement getEleClientEmailTxt = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]"));
        validateDisPlayedElement(getEleClientEmailTxt, "Client Email Text");
        WebElement getEleClientDateCreatedTxt = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + DateCreated + "')]"));
        validateDisPlayedElement(getEleClientDateCreatedTxt, "Client Date Created Text");
        WebElement getEleClientStatusDrpDwn = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//select"));
        validateDisPlayedElement(getEleClientStatusDrpDwn, "Client Status Drop Down");
    }

    /*public String getEleAuditorStatusLst(String UserType, String Email, String DateCreated) {
        waitSomeSeconds(1);
        SelectStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }*/

    /*public String getEleAuditorStatusLst(String Email) {
        waitSomeSeconds(1);
        WebElement status = getElementByXpath(xpathStatusCellOnUserTableAdminX, Email);
        Select select = new Select(status);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }*/

    public void getEleChangeOnBoardingStatus(String UserType, String Email, String DateCreated) throws InterruptedException {
        getLogger().info("Change status of auditor to Onboarding.");
        //Thread.sleep(10000);
        getLogger().info("Set status for auditor to Onboarding.");
        SelectStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        select.selectByVisibleText("Onboarding");

        //Thread.sleep(3000);
        getLogger().info("Wait for confirm popup render.");
        visibilityOfElementWait(getEleWAITLISTtoONBOARDINGTxt(), "Confirm Poup", waitTime);
        Assert.assertTrue(getEleWAITLISTtoONBOARDINGTxt().isDisplayed(), "Onboarding status is not selected");
//        NXGReports.addStep("Confirmation popup changing status from pending to onboarding is displayed", LogAs.PASSED, null);
        getLogger().info("Click confirm button.");
        getEleStatusConfirmBtn().click();
        visibilityOfElementWait(eleCredentialsCloseIcn, "Auditor onboarding successful message", waitTime);
        getLogger().info("Change Auditor to Onboarding successful.");
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[text()='Verified " + Email + " successfully.']")).isDisplayed(),
                "Wait-List user is verified");
//        NXGReports.addStep("Verified user is successfully displayed", LogAs.PASSED, null);
        eleCredentialsCloseIcn.click();
    }

    public void getEleChangeActiveStatus(String UserType, String Email, String DateCreated) throws InterruptedException {
        Thread.sleep(10000);
        SelectStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        select.selectByVisibleText("Active");
        Assert.assertTrue(getEleONBOARDINGtoACTIVETxt().isDisplayed(), "ACTIVE status is not selected");
//        NXGReports.addStep("Confirmation popup changing status from onboarding to active is displayed", LogAs.PASSED, null);
        Thread.sleep(3000);
        getEleStatusConfirmBtn().click();
        Thread.sleep(3000);
        Assert.assertTrue(getEleUpdatedtoACTIVETxt().isDisplayed(), "OnBoarding text is not displayed");
//        NXGReports.addStep("ONBoarding text is displayed", LogAs.PASSED, null);
        eleCredentialsCloseIcn.click();

    }

    public String getEleClientStatusLst(String UserType, String Email, String DateCreated) throws InterruptedException {
        Thread.sleep(10000);
        SelectStatus = getDriver().findElement(By.xpath(
                "//td[contains(text(),'" + UserType + "')]//..//td[contains(text(),'" + Email + "')]//..//td[contains(text(),'" + DateCreated + "')]//..//td//select"));
        Select select = new Select(SelectStatus);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }

    public void getEleDeleteTheCreatedUser(String Email) throws InterruptedException {
        WebElement deleteBtn = getDriver().findElement(By.xpath("//td[contains(text(),'" + Email + "')]//..//i[@title='Delete User']"));
        deleteBtn.click();
        getEleConfirmBtn().click();
    }

    public void verifyHeaderAdminPage() {
        /*try {
            waitForVisibleElement(eleAdminHdrTxt, "eleAdminHdrTxt");
            validateElementText(eleAdminHdrTxt, "Admin");
            Assert.assertEquals(validateElementText(eleAdminHdrTxt, "Admin"),"true");
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        Assert.assertEquals(validateElementText(eleAdminHdrTxt, "Admin"),"true");

    }

    public void verifyAdminHeaderText() {
        validateDisPlayedElement(getEleAdminHdrTxt(), "Auvenir Header Text");
    }

    public void verifyAdminDashBoard() {
        validateEnabledElement(getEleViewCredentialsBtn(), "View Credentials Button");
        validateDisPlayedElement(getEleAuvenirUserCountTxt(), "Auvenir User Count Text");
        validateDisPlayedElement(getEleAuvenirUserTxt(), "Auvenir User Text");
        validateDisPlayedElement(getEleAuvenirUserImg(), "Auvenir User Image");
        validateDisPlayedElement(getEleAuditorsCountTxt(), "Auvenir Count Text");
        validateDisPlayedElement(getEleAuditorsTxt(), "Auditor Text");
        validateDisPlayedElement(getEleAuditorsImg(), "Auditor Image");
        validateDisPlayedElement(getEleBusinessesCountTxt(), "Businesses Count Text");
        validateDisPlayedElement(getEleBusinessesTxt(), "Businesses Text");
        validateDisPlayedElement(getEleBusinessesImg(), "Businesses Image");
        validateDisPlayedElement(getEleEngagementsCountTxt(), "Engagements Count Text");
        validateDisPlayedElement(getEleEngagementsTxt(), "Engagements Text");
        validateDisPlayedElement(getEleEngagementsImg(), "Engagements Image");
    }

    public void verifyUserTable() {
        validateDisPlayedElement(getEleNameTxt(), "Name Text");
        validateDisPlayedElement(getEleUserTypeTxt(), "User Type Text");
        validateDisPlayedElement(getEleEmailTxt(), "Email Text");
        validateDisPlayedElement(getEleDateCreatedTxt(), "Date Created Text");
        validateDisPlayedElement(getEleStatusTxt(), "Status Text");
    }

    public void viewAndVerifyCredentials() {
        getEleViewCredentialsBtn().click();

        //        validateDisPlayedElement(getEleAuthIDTxt(), "Auth ID key");
        //        validateDisPlayedElement(getEleAPIKeyTxt(), "API Text");
    }

    public void verifyDropMenuMessage() {
        visibilityOfElementWait(getEleThereNoEmailsTxt(), "Inbox Icon", 15);
        getLogger().info("Check mail box.");
        validateDisPlayedElement(getEleThereNoEmailsTxt(), "There are no Emails - Text");
        getLogger().info("Check View message button.");
        validateEnabledElement(getEleViewMessagesBtn(), "View Messages - Button");
        getLogger().info("Check My message text is displayed.");
        validateDisPlayedElement(getEleMyMessagesTxt(), "My Messages - Text");
    }

    public void verifyBodyMessagePage() {
        visibilityOfElementWait(getEleNewMessageBtn(), "New Messages", 15);
        validateDisPlayedElement(getEleNewMessageBtn(), "New Messages - Button");
        validateDisPlayedElement(getEleInboxMsgImg(), "Inbox Messages - Images");
        validateDisPlayedElement(getEleYouDontHaveTxt(), "You dont have - Text");
    }

    public void clickNewMessage() {
        getEleNewMessageBtn().click();
    }

    public void verifyNewMessagePopup() {
        validateDisPlayedElement(getEleNewMessageTxt(), "New Message - Title");
        validateDisPlayedElement(getEleEmailToTxt(), "To: - Text");
        validateDisPlayedElement(getEleEmailToTxtFld(), "Email To: - Text Field");
        validateDisPlayedElement(getEleSubjectTxt(), "Subject: - Text");
        validateDisPlayedElement(getEleSubjectTxtFld(), "Subject - Text Field");
        validateDisPlayedElement(getEleEmailBodyTxtFld(), "Email body - Text Field");
        validateDisPlayedElement(getEleSendBtn(), "Send - Button");
        validateDisPlayedElement(getEleAttachmentIcn(), "Attachment - Icon");
        validateDisPlayedElement(getEleMailCloseIcn(), "Mail Close - Icon");
    }

    public void closeNewMessagePopup() {
        getEleMailCloseIcn().click();
    }

    public void verifyDropMenuNotification() {
        visibilityOfElementWait(getEleYouHaveNoNotificationTxt(), "You have no new - Text", 8);
        validateDisPlayedElement(getEleYouHaveNoNotificationTxt(), "you have no Notifications - Text");
        validateDisPlayedElement(getEleViewAllLnk(), "View All - Link");
    }

    public void clickViewAllNotification() {
        getEleViewAllLnk().click();
    }

    public void verifyBodyNotificationPage() {
        validateDisPlayedElement(getEleMyNotificationsTxt(), "My Notification - Text");
        validateDisPlayedElement(getEleNotificationsIcn(), "Notification - Icon");
        validateDisPlayedElement(getEleYouDontHaveNotificationTxt(), "My Messages - Text");
        validateDisPlayedElement(getEleClickHereLnk(), "View Messages - Button");
    }

    public void navigateToSettingAccountPage() {
//        auvenirPage.getEleNotificationImg().click();
        getEleViewAllLnk().click();
        visibilityOfElementWait(getEleClickHereLnk(), "Click Here - Link", 20);
        getEleClickHereLnk().click();
    }

    public void verifySettingAccountPage() {
        visibilityOfElementWait(getEleSettingsTxt(), "Settings Title", 20);
        validateDisPlayedElement(getEleSettingsTxt(), "Settings  - Title");
        validateDisPlayedElement(getEleAccountLnk(), "Account  - Link");
        validateDisPlayedElement(getEleDevicesLnk(), "Devices  - Link");
        validateDisPlayedElement(getEleAccountSettingsTxt(), "Account Settings  - Text");
        validateDisPlayedElement(getEleFirstLastNameTxt(), "First and Last Name  - Text");
        validateDisPlayedElement(getEleFirstLastNameTxtFld(), "First and Last Name  - Text Field");
        validateDisPlayedElement(getEleEmailAddressTxt(), "Email Address  - Text");
        validateDisPlayedElement(getEleEmailAddressTxtFld(), "Email Address  - Text Field");
        validateDisPlayedElement(getElePhomeNumberTxt(), "Phone Number  - Text");
        validateDisPlayedElement(getElePhoneNumberTxtFld(), "Phone Number  - Text Field");
        validateDisPlayedElement(getElePhotoImg(), "Photo  - Image");
        validateDisPlayedElement(getEleYourPhotoTxt(), "your Photo  - Text");
        validateDisPlayedElement(getEleUpdateBtn(), "Update   - Button");
        validateDisPlayedElement(getEleDeactivateLnk(), "Deactivate My Account - Link");
    }

    public void clickDeactiveLink() {
        getEleDeactivateLnk().click();
    }

    public void verifyDeactivePopup() {
        validateDisPlayedElement(getEleDeactivatAccTxt(), "Deactivate Account - Text");
        validateDisPlayedElement(getEleAlertIcn(), "Alert - Icon");
        validateDisPlayedElement(getEleYouareAboutTxt(), "You are about to - Text");
        validateDisPlayedElement(getEleCancelBtn(), "Cancel   - Button");
        validateDisPlayedElement(getEleDeactivateBtn(), "Deactivate   - Button");
    }

    public void closeDeactivePopup() {
        getEleCloseIcn().click();
    }

    public void navigateToSettingDevicesPage() {
        /*visibilityOfElementWait(auvenirPage.getEleNotificationImg(), "Notification Icon", 10);
        auvenirPage.getEleNotificationImg().click();*/
        visibilityOfElementWait(getEleViewAllLnk(), "Notification Icon", 10);
        getEleViewAllLnk().click();
        visibilityOfElementWait(getEleClickHereLnk(), "Notification Icon", 10);
        getEleClickHereLnk().click();
        visibilityOfElementWait(getEleSettingsTxt(), "Settings Title", 10);
        getEleDevicesLnk().click();
    }

    public void verifySettingDevicesPage() {
        validateDisPlayedElement(getEleMyDevicesTxt(), "MyDevices  - Title");
        validateDisPlayedElement(getEleYouRegisteredTxt(), "You Have Registered  - Text");
        validateDisPlayedElement(getEleDeviceImg(), "Devices  - Image");
        validateDisPlayedElement(getEleDeviceCustomerNmTxt(), "Customer Name  - Text");
        validateDisPlayedElement(getEleDeviceNameTxt(), "Device Type  - Text");
        validateDisPlayedElement(getEleViewBtn(), "View  - Button");
        validateDisPlayedElement(getEleAddAnotherLnk(), "Add Another - Link");
    }

    public void addAnotherDeviceLink() {
        getEleAddAnotherLnk().click();
    }

    public void verifyAddAnotherPopup() {
        visibilityOfElementWait(getEleRegisterDeviceTxt(), "Settings Title", 20);
        validateDisPlayedElement(getEleRegisterDeviceTxt(), "Register a New Device  - Text");
        validateDisPlayedElement(getEleDownloadAuvenirTxt(), "Download the Auvenir  - Text");
        validateDisPlayedElement(getEleTextMeBtn(), "Text me a Link  - Button");
        validateDisPlayedElement(getEleRegisterMobileImg(), "Register Mobile  - Image");
        validateDisPlayedElement(getEleDownloadAppStoreImg(), "Download App store - Image");
        validateDisPlayedElement(getEleGetItGooglePlayImg(), "Google Play - Image");
        validateDisPlayedElement(getElePopupCloseIcn(), "Register Device Close - Icn");
    }

    public void navigateToSettingDevicesDisconnect() {
        navigateToSettingDevicesPage();
        getEleViewBtn().click();
    }

    public void verifySettingDevicesDisconnectPopup() {
        validateDisPlayedElement(getEleCustomerNameTxt(), "Customer Name - Text");
        validateDisPlayedElement(getEleDeviceViewImg(), "Device - Image");
        validateDisPlayedElement(getEleDeviceNameTxt(), "Device Name - Text");
        validateDisPlayedElement(getEleOSTxt(), "Device OS - Text");
        validateDisPlayedElement(getEleBrowserTxt(), "Browser - Text");
        validateDisPlayedElement(getEleLastUsedTxt(), "Last Used: - Text");
        validateDisPlayedElement(getEleDisconnectDeviceBtn(), "Disconnect Devices - Button");
        validateDisPlayedElement(getEleDisconnectthisDeviceTxt(), "Disconnect this device - Text");
        validateDisPlayedElement(getEleCancelDisconnectBtn(), "Cancel - Button");
        validateDisPlayedElement(getEleDisconnectBtn(), "Disconnect - Button");
        validateDisPlayedElement(getEleCloseIcn(), "Disconnect this device Close - Icon");
    }

    public void verifyDisplayElementInDeActivePage() {
        validateDisPlayedElement(getEleDeactivateLnk(), "Deactivate My Account - Link");
        clickElement(getEleDeactivateLnk(), "Deactive link");
        validateDisPlayedElement(getEleDeactivatAccTxt(), "Deactivate Account - Text");
        validateDisPlayedElement(getEleAlertIcn(), "Alert - Icon");
        validateDisPlayedElement(getEleYouareAboutTxt(), "You are about to - Text");
        validateDisPlayedElement(getEleCancelBtn(), "Cancel   - Button");
        validateDisPlayedElement(getEleDeactivateBtn(), "Deactivate   - Button");
        clickElement(getEleCloseIcn(), "Close button");
    }

    public String getEleAuditorStatusLst(String Email) {
        WebElement status = getElementByXpath(xpathStatusCellOnUserTableAdminX, Email);
        Select select = new Select(status);
        String eleAuditorStatusLst = select.getAllSelectedOptions().get(0).getText();
        return eleAuditorStatusLst;
    }

    public void verifyUserStatusAsExpected(String userEmail, String expectedStatus){
        String status = getEleAuditorStatusLst(userEmail);
        Assert.assertEquals(expectedStatus, status);
    }

    public void changeStatusUser(String email, String status){
        WebElement statusEle = getElementByXpath(xpathStatusCellOnUserTableAdminX, email);
        selectOptionByText(statusEle, status, "User Status");
    }

    public void vefiryConfirmPopupDisplay(){
        getLogger().info("Validate Popup Confirm.");
        waitForVisibleElement(textViewOnPopupConfirm, "Are you sure you want to change user status from");
        validateElementText(textViewOnPopupConfirm, "Are you sure you want to change user status from");
    }

    public void clickConfirmButton(){
        waitForVisibleElement(getEleStatusConfirmBtn(), "Confirm Poup");
        waitForClickableOfElement(getEleStatusConfirmBtn(), "Confirm Poup");
        clickElement(getEleStatusConfirmBtn(), "Status Confirm Button");
    }

    public void verifyMessageSuccessful(){
        waitForVisibleElement(eleCredentialsCloseIcn, "Close Icon");
        waitForClickableOfElement(eleCredentialsCloseIcn, "Close Icon");
        clickElement(eleCredentialsCloseIcn, "Close Icon");
    }

    public void waitForProgressOverlayIsClosed() {
        getLogger().info("Try to waiting the ProgressOverlayIsClosed.");
        waitForCssValueChanged(progressingDiv, "Progress Overlay", "display", "none");
    }

    /*public void verifyUserIsChangeStatusOnTheList(String email, String expectedStatus) {
        getLogger().info("Verify user is changed status on the list.");
        try {
            String actualStatus = getEleAuditorStatusLst(email);
            Assert.assertTrue(actualStatus.equals(expectedStatus), String.format("Auditor is not created with %s status", actualStatus));
            NXGReports.addStep("Verify user is changed status on the list.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Verify user is changed status on the list. Expected: " + expectedStatus, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Verify user is changed status on the list. Expected: " + expectedStatus, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }


    }*/

    /**
     * verify info of user
     *
     * @param userType    type of user
     * @param userEmail   email
     * @param createdDate create date(today)
     * @param userStatus  status
     */
    /*public void verifyAuditorRowOnAdminUserTable(String userType, String userEmail, String createdDate, String userStatus) {
        try {
            WebElement type = getElementByXpath(xpathUserTypeCellOnUserTableAdminX, userEmail);
            WebElement email = getElementByXpath(xpathEmailCellOnUserTableAdminX, userEmail);
            WebElement date = getElementByXpath(xpathDateCreatedCellOnUserTableAdminX, userEmail);

            validateElementText(type, userType);
            validateElementText(email, userEmail);
            validateElementText(date, createdDate);

            verifyAuditorStatusOnAdminUserTable(userEmail, userStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }*/

    /**
     * verify status of user
     *
     * @param userEmail  email
     * @param userStatus status
     */
    /*public void verifyAuditorStatusOnAdminUserTable(String userEmail, String userStatus) {
        WebElement status = getElementByXpath(xpathStatusCellOnUserTableAdminX, userEmail);
        validateSelectedItemText(status, userStatus);
    }*/
    /*-----------end of huy.huynh on 30/05/2017.*/

    /**
     * verify status of user
     *
     * @param userEmail    email
     * @param chooseOption status wanna change to
     */
    /*public void changeTheStatusUser(String userEmail, String chooseOption) {
        try {
            getLogger().info(String.format("Try change status of user to %s", chooseOption));
            if (!getEleAuditorStatusLst(userEmail).equals(chooseOption)) {
                waitSomeSeconds(1);
                //            waitForVisibleElement(eleAdminHdrTxt, "Admin");
                //            validateElementText(eleAdminHdrTxt, "Admin");
                //            waitForVisibleElement(GeneralUtilities.getElementByXpath(getDriver(), xpathStatusCellOnUserTableAdminX, userEmail), "Dropdown Status.");

                WebElement status = getElementByXpath(xpathStatusCellOnUserTableAdminX, userEmail);
                selectOptionByText(status, chooseOption, "User Status");

                getLogger().info("Validate Popup Confirm.");
                waitForVisibleElement(textViewOnPopupConfirm, "Are you sure you want to change user status from");
                validateElementText(textViewOnPopupConfirm, "Are you sure you want to change user status from");

                waitForVisibleElement(getEleStatusConfirmBtn(), "Confirm Poup");
                waitForClickableOfElement(getEleStatusConfirmBtn(), "Confirm Poup");
                clickElement(getEleStatusConfirmBtn(), "Status Confirm Button");

                waitForProgressOverlayIsClosed();
                waitForVisibleElement(eleCredentialsCloseIcn, "Close Icon");
                waitForClickableOfElement(eleCredentialsCloseIcn, "Close Icon");
                clickElement(eleCredentialsCloseIcn, "Close Icon");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    /**
     * Click Close on Popup which warning about supporting only Chrome Browser.
     */
    /*public void clickClosePopupWarningBrowser() {
        try {
            if (GenericService.sBrowserData.equals("ff.")) {
                getLogger().info("Close Popup Warning Browser");
                Thread.sleep(3000);
                waitForVisibleElement(eleCredentialsCloseIcn, "Close Icon");
                waitForClickableOfElement(eleCredentialsCloseIcn, "Close Icon");
                clickElement(eleCredentialsCloseIcn, "Close Icon");
                waitForProgressOverlayIsClosed();
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            getLogger().info(e);
        }
    }*/

    /*public void verifyAdminSeeAllUser() {
        getLogger().info("Verify Admin can see all user in the system.");
        boolean result = true;
        try {
            //            String xpathUserTypeCellOnAdminPage = "/*//*[@id='w-mu-table']//tr/td[2][text()='%s']";
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement clientUser = getElementByXpath(xpathUserTypeCellOnAdminPage, "CLIENT");
            WebElement adminUser = getElementByXpath(xpathUserTypeCellOnAdminPage, "ADMIN");
            WebElement auditorUser = getElementByXpath(xpathUserTypeCellOnAdminPage, "AUDITOR");
            WebElement superAdmin = getElementByXpath(xpathUserTypeCellOnAdminPage, "SUPER ADMIN");
            getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            if (clientUser == null) {
                result = false;
            }
            if (adminUser == null) {
                result = false;
            }
            if (auditorUser == null) {
                result = false;
            }
            if (superAdmin == null) {
                result = false;
            }
            getLogger().info("User " + (clientUser != null ? "can" : "cannot") + " see all Client User.");
            getLogger().info("User " + (adminUser != null ? "can" : "cannot") + " see all Admin User.");
            getLogger().info("User " + (auditorUser != null ? "can" : "cannot") + " see all Auditor User.");
            getLogger().info("User " + (superAdmin != null ? "can" : "cannot") + " see Super Admin User.");
            Assert.assertTrue(result, "User should see all user in system.");
            NXGReports.addStep("User can see all user in system.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports
                    .addStep("Failed: User cannot see all user in system.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
        }
    }

    public void verifyAdminCannotChangeSttAdminUser() {
        getLogger().info("Verify Admin cannot change the status of Admin user.");
        boolean result = false;
        try {
            String xpathStatusCellOnAdmiPage = "/*//*[@id='w-mu-table']//tr/td[2][contains(text(),'%s')]/../td[5]/select";
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> userStatusDropdownList = getListElementsByXpath(xpathStatusCellOnAdmiPage, "ADMIN");
            getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            if (userStatusDropdownList.size() == 0) {
                result = true;
            }
            Assert.assertTrue(result, "Admin user should not able to change status of Admin user in system.");
            NXGReports.addStep("Admin user cannot change status of Admin user in system.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Admin user can change status of Admin user in system", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }*/

    /**
     * verify status of user
     *
     * @param superAdminEmail String Super Admin Email which is demoted
     * @param adminName       String  Admin Name which is assigned to Super Admin role
     */
    /*public void demoteSuperAdminRole(String superAdminEmail, String adminName, boolean confirmation) {
        getLogger().info("Demote Super Admin role");
        String contentConfirmDemoteUserPopup =
                "Are you sure you want to demote your Super Admin status? You will no longer have Super Admin privileges.";
        String contentSelectGrantedUserPopup = "Select one Admin User who will be promoted as Super Admin.";
        try {
            if (getEleAuditorStatusLst(superAdminEmail).equals("Active")) {
                WebElement status = getElementByXpath(xpathStatusCellOnUserTableAdminX, superAdminEmail);
                selectOptionByText(status, "Demote", "User Status");

                getLogger().info("Validate Demote Super Admin Popup Confirm.");
                waitForAnimation(demoteSuperAdminTitlePopup, "Demote Super Admin Title Layout");
                validateElementText(demoteSuperAdminTitleTextPopup, "Demote Super Admin Status?");

                if (demoteSuperAdminContentPopup.getText().equals(contentConfirmDemoteUserPopup))
                    clickElement(continueBtnOnDemotePopup, "Continue Button");

                if (demoteSuperAdminContentPopup.getText().equals(contentSelectGrantedUserPopup)) {
                    selectOptionByText(grantedUserDropdownList, adminName, "grantedUserDropdownList");
                    if (confirmation) {
                        clickElement(selectBtnOnDemotePopup, "Select Button");
                        waitForProgressOverlayIsClosed();
                    } else {
                        clickElement(cancelBtnOnDemotePopup, "Cancel Button");
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Demote Super Admin role", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());

        }
    }

    public void verifySuperAdminCanChangeSttAllUser() {
        getLogger().info("Verify Super Admin can change the status of all user.");
        boolean result = true;
        try {
            String xpathStatusCellOnAdminPage = "/*//*[@id='w-mu-table']//tr/td[2][text()='%s']/../td[5]/select";
            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> adminUserStatusDdl = getListElementsByXpath(xpathStatusCellOnAdminPage, "ADMIN");
            List<WebElement> auditorUserStatusDdl = getListElementsByXpath(xpathStatusCellOnAdminPage, "AUDITOR");
            List<WebElement> clientUserStatusDdl = getListElementsByXpath(xpathStatusCellOnAdminPage, "CLIENT");
            List<WebElement> superAdminUserStatusDdl = getListElementsByXpath(xpathStatusCellOnAdminPage, "SUPER ADMIN");
            getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            if (adminUserStatusDdl.size() == 0) {
                result = false;
            }
            if (auditorUserStatusDdl.size() == 0) {
                result = false;
            }
            if (clientUserStatusDdl.size() == 0) {
                result = false;
            }
            if (superAdminUserStatusDdl.size() == 0) {
                result = false;
            }
            getLogger().info("User " + (clientUserStatusDdl.size() != 0 ? "can" : "cannot") + " change status of Client User.");
            getLogger().info("User " + (adminUserStatusDdl.size() != 0 ? "can" : "cannot") + " change status of Admin User.");
            getLogger().info("User " + (auditorUserStatusDdl.size() != 0 ? "can" : "cannot") + " change status of Auditor User.");
            getLogger().info("User " + (superAdminUserStatusDdl.size() != 0 ? "can" : "cannot") + " change status of Super Admin User.");
            Assert.assertTrue(result, "Super Admin User should able to change status of Admin user in system.");
            NXGReports.addStep("Super Admin User can change status of Admin user in system.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Super Admin User cannot change status of Admin user in system.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }*/

    /*public void verifyUserRoleOfEmail(String email, String role) {
        getLogger().info(String.format("Verify User '%s'  has '%s' role", email, role));
        boolean result = true;
        try {
            String xpathRoleCellOnAdminPage = "/*//*[@id='w-mu-table']//tr/td[3][text()='%s']/../td[2]";
            WebElement actualUserRole = getElementByXpath(xpathRoleCellOnAdminPage, email);
            result = validateElementText(actualUserRole, role);
            Assert.assertTrue(result, String.format("User '%s'  should have '%s' role", email, role));
            NXGReports.addStep(String.format("Verify User '%s'  has '%s' role", email, role), LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep(String.format("Failed: Verify User '%s'  has '%s' role", email, role), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    public boolean verifyOnlyOneSuperAdmin() {
        getLogger().info("Verify Only One Super Admin is displayed.");
        boolean result = false;
        try {
            List<WebElement> superAdmin = getListElementsByXpath(xpathUserTypeCellOnAdminPage, "SUPER ADMIN");
            if (superAdmin.size() == 1) {
                result = true;
            }
            Assert.assertTrue(result, "The system should have only one Super Admin.");
            NXGReports.addStep("Verify Only One Super Admin is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Failed: Verify Only One Super Admin is displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
        return result;
    }

    public void scrollToUser(String email) {
        hoverElement(getElementByXpath(xpathDueDateByName, email), "Cell " + email);
        ((JavascriptExecutor) getDriver()).executeScript("javascript:window.scrollBy(250,450)");
    }*/

    /**
     * Add new by huy.huynh on 31/07/2017.
     * R2.1 Group Permission
     */

    /**
     * verify status of user
     *
     * @param userEmail email
     * @param userType  status
     */
    /*public void verifyUserTypeOnAdminUserTable(String userEmail, String userType, boolean possible) {
        WebElement type = getElementByXpath(xpathUserTypeCellOnUserTableAdminX, userEmail);
        if (userType.equalsIgnoreCase(type.getText()) == possible) {
            NXGReports.addStep("Verify user type on Admin user table", LogAs.PASSED, null);
        } else {
            NXGReports
                    .addStep("Failed: Verify user type on Admin user table", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            "Possible= " + possible + ", userTpe= " + userType);
        }
    }*/
    /*-----------end of huy.huynh on 06/07/2017.*/

}
