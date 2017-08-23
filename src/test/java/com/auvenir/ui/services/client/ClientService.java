package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.client.engagement.CreateNewAuditPage;
import com.auvenir.ui.pages.admin.AdminPage;
import com.auvenir.ui.pages.auditor.auditorclient.AddNewClientPage;
import com.auvenir.ui.pages.client.general.*;
import com.auvenir.ui.pages.client.settings.*;
import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.pages.common.GmailPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 4/25/2017.
 * refactored by huy.huynh 23/06/2017
 */
public class ClientService extends AbstractService {

    ClientDashboardPage clientDashboardPage;
    ClientSettingsPage clientSettingsPage;
    ClientAccountSettingsPage clientAccountSettingsPage;
    ClientNotificationsSettingsPage clientNotificationsSettingsPage;
    ClientIntegrationsSettingsPage clientIntegrationsSettingsPage;
    ClientDevicesSettingsPage clientDevicesSettingsPage;
    ClientHomePage clientHomePage;
    ClientRequestPage clientRequestPage;
    ClientFilesPage clientFilesPage;
    ClientOnBoardingPage clientOnBoardingPage;
    ClientLoginPage clientLoginPage;
    AuvenirPage auvenirPage;
    GmailPage gmailPage;
    CreateNewAuditPage createNewAuditPage;
    AddNewClientPage addNewClientPage;
    AdminPage adminPage;
    ClientToDoPage clientToDoPage;


    public ClientService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientDashboardPage = new ClientDashboardPage(getLogger(), getDriver());
        clientSettingsPage = new ClientSettingsPage(getLogger(), getDriver());
        clientAccountSettingsPage = new ClientAccountSettingsPage(getLogger(), getDriver());
        clientNotificationsSettingsPage = new ClientNotificationsSettingsPage(getLogger(), getDriver());
        clientIntegrationsSettingsPage = new ClientIntegrationsSettingsPage(getLogger(), getDriver());
        clientDevicesSettingsPage = new ClientDevicesSettingsPage(getLogger(), getDriver());
        clientHomePage = new ClientHomePage(getLogger(), getDriver());
        clientRequestPage = new ClientRequestPage(getLogger(), getDriver());
        clientFilesPage = new ClientFilesPage(getLogger(), getDriver());
        clientOnBoardingPage = new ClientOnBoardingPage(getLogger(), getDriver());
        clientLoginPage = new ClientLoginPage(getLogger(), getDriver());
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        gmailPage = new GmailPage(getLogger(), getDriver());
        createNewAuditPage = new CreateNewAuditPage(getLogger(), getDriver());
        addNewClientPage = new AddNewClientPage(getLogger(), getDriver());
        adminPage = new AdminPage(getLogger(), getDriver());
        clientToDoPage = new ClientToDoPage(getLogger(), getDriver());
    }


    public void navigateToClientDashboardPage() {
        getLogger().info("navigate to client dashboard page.");

        clientDashboardPage.clickAuvenirLogo();
    }

    public void navigateToInProgressTab() {
        try {
            getLogger().info("navigate to In Progress tab.");
            clientDashboardPage.navigateToInProgressTab();
            NXGReports.addStep("navigate to In Progress tab", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to In Progress tab", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    public void verifyClientFooter() {
        clientDashboardPage.verifyClientFooter();
    }

    public void navigateToCompletedTab() {

        try {
            getLogger().info("navigae to Completed Tab.");
            clientDashboardPage.navigateToCompletedTab();
            NXGReports.addStep("navigate to completed tab", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to completed Tab", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToClientSettingsPage() {
        clientDashboardPage.navigateToClientSettingsPage();
    }

    public void navigateToAccountTab() {

        try {
            getLogger().info("navigate to Account tab.");
            clientSettingsPage.navigateToAccountTab();
            NXGReports.addStep("navigate to account settings tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to account settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void navigateToIntegrationTab() {

        try {
            getLogger().info("Navigate to Integrations tab.");
            clientSettingsPage.navigatToIntegrationTab();
            NXGReports.addStep("navigate to integration tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to integration tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToDevicesTab() {

        try {
            getLogger().info("navigate to Devices tab.");
            clientSettingsPage.navigateToDevicesTab();
            NXGReports.addStep("navigate to Devices tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Devices tab tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToNotificationsTab() {

        try {
            getLogger().info("navigate to Notification tab.");
            clientSettingsPage.navigateToNotificationsTab();
            NXGReports.addStep("navigate to Notification tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to Notification tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyAccountSettingsPage() {
        clientAccountSettingsPage.verifyAccountSettingsPage();
    }

    public void verifyNotificationsSettingsPage() {
        try {
            getLogger().info("verify notification Settings Page.");
            clientNotificationsSettingsPage.verifyNotificationsSettingsPage();
            NXGReports.addStep("Notification Settings page rendered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Notification Settings page rendered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyIntegrationsSettingsPage() {
        try {
            getLogger().info("verify integrations Settings Page.");
            clientIntegrationsSettingsPage.verifyIntegrationsSettingsPage();
            NXGReports.addStep("integrations Settings page rendered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("integrations Settings page rendered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyDevicesSettingsPage() {
        try {
            getLogger().info("verify Devices Settings Page.");
            clientDevicesSettingsPage.verifyDevicesSettingsPage();
            NXGReports.addStep("integrations Settings page rendered.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("integrations Settings page rendered.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyClientHomePage() {
        clientDashboardPage.verifyClientHomePage();
    }

    public void verifyClientHeader() {
        clientDashboardPage.verifyClientHeader();
    }

    public void verifyClientInboxMessage() {
        clientDashboardPage.verifyClientInboxMessage();
    }

    public void verifyMyAuditsPage() {
        clientHomePage.verifyMyAuditsPage();
    }

    public void verifyClientRequestPage() {
        clientRequestPage.verifyClientRequestPage();
    }

    public void clickRequestLnk() {
        clientDashboardPage.clickRequestLink();
    }

    public void verifyGeneralLedgerTab() {
        clientRequestPage.verifyGeneralLedgerTab();
    }

    public void clickTrialBalanceMenuLink() {
        clientRequestPage.clickTrialBalanceMenuLink();
    }

    public void verifyTrialBalanceTab() {
        clientRequestPage.verifyTrialBalanceTab();
    }

    public void clickBankStatementsMenuLink() {
        clientRequestPage.clickBankStatementsMenuLink();
    }

    public void verifyBankStatementsTab() {
        clientRequestPage.verifyBankStatementsTab();
    }

    public void clickFilesLink() {
        clientDashboardPage.clickFilesLink();
    }

    public void verifyFilesTab() {
        clientFilesPage.verifyFilesTab();
    }

    public void clickDashBoardLink() {
        clientDashboardPage.clickDashBoardLink();
    }

    public void clickNewMessageButton() {
        clientDashboardPage.clickNewMessageButton();
    }

    public void verifyNewMessageForm() {
        clientDashboardPage.verifyNewMessageForm();
    }

    public void clickCloseMessageButton() {
        clientDashboardPage.clickCloseMessageButton();
    }

    public void verifyDashboardPage() {
        clientDashboardPage.verifyDashboardPage();
    }

    public void clickInboxMessage() {
        clientDashboardPage.clickInboxMessage();
    }

    public void verifyClientOnBoardingPersonalStep() {
        clientOnBoardingPage.verifyClientOnBoardingPersonalStep();
    }

    public void clickContinuePersonalInformationButton() {
        clientOnBoardingPage.clickContinuePersonalInformationButton();
    }

    public void verifyClientOnBoardingBusinessStep() {
        clientOnBoardingPage.verifyClientOnBoardingBusinessStep();
    }

    public void clickContinueBusinessInformationButton() {
        clientOnBoardingPage.clickContinueBusinessInformationButton();
    }

    public void verifyClientOnBoardingIntegrateFileStep() {
        clientOnBoardingPage.verifyClientOnBoardingIntegrateFileStep();
    }

    public void clickSkipIntegrateFileButton() {
        clientOnBoardingPage.clickSkipIntegrateFileButton();
    }

    public void verifyClientOnBoardingSecurityStep() {
        clientOnBoardingPage.verifyClientOnBoardingSecurityStep();
    }

    public void clickSkipSecurityButton() {
        clientOnBoardingPage.clickSkipSecurityButton();
    }

    public void verifySkipSecurityPopUp() {
        clientOnBoardingPage.verifySkipSecurityPopUp();
    }

    public void clickSkipSecurityWarning() {
        clientOnBoardingPage.clickSkipSecurityWarning();
    }

    public void verifyDashBoardText() {
        clientOnBoardingPage.verifyDashBoardText();
    }

    public void signInEmailOnClientLoginPage(String clientID) {
        clientLoginPage.signInEmailOnClientLoginPage(clientID);
    }

    public void verifyWelcomePleaseCheckTxtIsDisplayed() {
        auvenirPage.verifyWelcomePleaseCheckTxtIsDisplayed();
    }

    public void gmailLogin(String gmailUserName, String gmailPassword) throws InterruptedException {
        gmailPage.gmailLogin(gmailUserName, gmailPassword);
    }

    public void searchGmail(String GMAIL_SEARCHMAIL) {
        gmailPage.searchGmail(GMAIL_SEARCHMAIL);
    }

    public void signInEmail() {
        gmailPage.signInEmail();
    }

    public void verifyClientLoginPageAfterSignIn() {
        clientLoginPage.verifyClientLoginPageAfterSignIn();
    }

    public void accountActiveEmail() {
        gmailPage.accountActiveEmail();
    }

    public void verifyClientLoginPageAfterActiveAccount() {
        clientLoginPage.verifyClientLoginPageAfterActiveAccount();
    }

    public void inviteEmail() {
        gmailPage.inviteEmail();
    }

    public void verifyClientLoginPageInvitationEmail() {
        clientLoginPage.verifyClientLoginPageInvitationEmail();
    }

    public void clickStartAuditButton() {
        clientLoginPage.clickStartAuditButton();
    }

    public void clickSelectClientButton() {
        createNewAuditPage.clickSelectClientButton();
    }

    public void verifyPleaseSelectClientText() {
        createNewAuditPage.verifyPleaseSelectClientText();
    }

    public void clickCreateNewClient() {
        createNewAuditPage.clickCreateNewClient();
    }

    public void verifyAddNewClientPopUpDisplayed() {
        createNewAuditPage.verifyAddNewClientPopUpDisplayed();
    }

    public void inputDataKeyContactInfo(String name, String email, String phoneNumber) {
        addNewClientPage.inputDataKeyContactInfo(name, email, phoneNumber);
    }

    public void inputDataCompanyInfo(String legalName, String pleaseListParent, String address, String unitNumber, String city, String provinceState,
            String country, String postalCode) {
        addNewClientPage.inputDataCompanyInfo(legalName, pleaseListParent, address, unitNumber, city, provinceState, country, postalCode);
    }

    public void selectAllCheckboxInCompanyInformation() {
        addNewClientPage.selectAllCheckboxInCompanyInformation();
    }

    public void clickAddNewClientButton() {
        addNewClientPage.clickAddNewClientButton();
    }

    public void clickSelectClient(String clientName) {
        createNewAuditPage.clickSelectClient(clientName);
    }

    public void verifyClientIsSelected(String clientFirstName) {
        createNewAuditPage.verifyClientIsSelected(clientFirstName);
    }

    public void sendInvitationName() {
        createNewAuditPage.sendInvitationName();
    }

    public void closeSuccessToastMes() {
        createNewAuditPage.closeSuccessToastMes();
    }

    public void verifyAdminLoginPage() {
        adminPage.verifyHeaderAdminPage();
    }

    public void verifyUserIsChangeStatusOnTheList(String email, String expectedStatus) {
        adminPage.verifyUserIsChangeStatusOnTheList(email, expectedStatus);
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */
    public void selectAddNewClient() {
        createNewAuditPage.selectAddNewClient();
    }

    public void selectClientWithFullName(String fullName) {
        createNewAuditPage.selectClientWithFullName(fullName);
    }

    public void fillInfoToInviteNewClient(String fullName, String email, String role) {
        createNewAuditPage.fillInfoToInviteNewClient(fullName, email, role);
    }


    public void verifyInviteClientSuccess(String message) {
        createNewAuditPage.verifyInviteClientSuccess(message);
    }

    public void verifyInviteClientFailure(String message) {
        createNewAuditPage.verifyInviteClientFailure(message);
    }
     /*-----------end of huy.huynh on 02/06/2017.*/

    public void fillInfoToInviteNewMember(String fullName, String email, String role) {
        createNewAuditPage.fillInfoToInviteNewMember(fullName, email, role);
    }

    public void selectInviteNewMemberButton() {
        createNewAuditPage.selectInviteNewMemberButton();
    }

    public void verifyToDoTaskExist(String toDoName, boolean isClient) {
        clientToDoPage.verifyToDoTaskExist(toDoName, isClient);
    }

    public void selectClientAssigneeByName(String todoName, String clientAssignee) {
        clientToDoPage.selectClientAssigneeByName(todoName, clientAssignee);
    }

    public void verifyClientAssigneeSelected(String todoName, String clientAssignee) {
        clientToDoPage.verifyClientAssigneeSelected(todoName, clientAssignee);
    }

    public void inviteExistedClient() {
        createNewAuditPage.clickButtonInvite();
    }
}
