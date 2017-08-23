package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.AuvenirPage;
import com.auvenir.ui.pages.auditor.engagement.EngagementRequestPage;
import com.auvenir.ui.pages.admin.AdminPage;
import com.auvenir.ui.pages.auditor.auditorclient.AddNewClientPage;
import com.auvenir.ui.pages.auditor.auditorclient.AuditorClientPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.EngagementFilesPage;
import com.auvenir.ui.pages.auditor.general.AuditorDashboardPage;
import com.auvenir.ui.pages.auditor.general.AuditorOnBoardingPage;
import com.auvenir.ui.pages.auditor.settings.AuditorSettingsPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by duong.nguyen on 5/24/2017.
 */
public class AuditorService extends AbstractService {
    AuvenirPage auvenirPage;
    AuditorOnBoardingPage auditorOnBoardingPage;
    AdminPage adminPage;
    AuditorDashboardPage auditorDashboardPage;
    EngagementRequestPage engagementRequestPage;
    EngagementFilesPage engagementFilesPage;
    AuditorEngagementPage auditorEngagementPage;
    AddNewClientPage addNewClientPage;
    AuditorClientPage auditorClientPage;
    AuditorSettingsPage auditorSettingsPage;

    /*
     * Constructor
     */
    public AuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auvenirPage = new AuvenirPage(getLogger(), getDriver());
        auditorOnBoardingPage = new AuditorOnBoardingPage(getLogger(), getDriver());
        adminPage = new AdminPage(getLogger(), getDriver());
        auditorDashboardPage = new AuditorDashboardPage(getLogger(), getDriver());
        engagementRequestPage = new EngagementRequestPage(getLogger(), getDriver());
        engagementFilesPage = new EngagementFilesPage(getLogger(), getDriver());
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        addNewClientPage = new AddNewClientPage(getLogger(), getDriver());
        auditorClientPage = new AuditorClientPage(getLogger(), getDriver());
        auditorSettingsPage = new AuditorSettingsPage(getLogger(), getDriver());
    }

    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(getLogger());
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            System.out.println(GenericService.getConfigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    //Getting the URL by passing GetTokenURl and CheckTokenURL
    public void navigateToURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        getDriver().get(sGetTokenURL + sEmailID);
        String s1 = getDriver().findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        getDriver().get(sCheckTokenURL + sEmailID + "&token=" + token);
    }

    //Loading the URL by keeping in config properties
    public void navigateToURL(String sUrl) {
        try {
            System.out.println(sUrl);
            getDriver().get(sUrl);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void verifyBodyHomePage() {
        auvenirPage.verifyBodyHomePage();
    }

    public void verifyFooterHomePage() {
        auvenirPage.verifyFooterOfHomepage();
    }

    public void verifyEmailLoginForm() {
        auvenirPage.verifyFormLogin();
    }

    public void verifyLoginWithEmail(String email) {
        auvenirPage.verifyLoginWithEmail(email);
        //auvenirPage.verifyApprovePopupDisplayed();
    }

    public void verifyPersonalPage() {
        auditorOnBoardingPage.verifyOnBoardingPersonalInformationPage();
    }

    public void verifyInputPersonalInfomation(String auditorName, String phoneNumber) {
        auditorOnBoardingPage.verifyInputPersonalInfomation(auditorName, phoneNumber);
    }

    public void verifyFirmPage() {
        auditorOnBoardingPage.verifyOnBoardingFirmInfomationPage();
    }

    public void verifyInputFirmInformation(String firmName, String numberEmployee, String phoneNumber,
                                           String address, String unitNumber, String cityName, String provinceState,
                                           String countryName, String zipCode) {
        auditorOnBoardingPage.verifyInputFirmInformationOnboardingPage(firmName, numberEmployee, phoneNumber, address,
                unitNumber, cityName, provinceState, countryName, zipCode);
    }

    public void verifyFooterPage() {
        auvenirPage.verifyFooterPage();
    }

    public void verifyInputAffliateField(String affliateName) {
        auditorOnBoardingPage.verifyInputAffliateField(affliateName);
    }

    public void verifySecurityOnBoardingPage() {
        auditorOnBoardingPage.verifySecurityOnBoardingPage();
    }

    public void verifyAdminLoginPage() {
        adminPage.verifyHeaderAdminPage();
    }

    public void verifyChangeActiveStatus(String userType, String email, String dateCreated) throws InterruptedException {
        adminPage.getEleChangeActiveStatus(userType, email, dateCreated);
    }

    public void verifyheaderPage() {
        auvenirPage.verifyHeader();
    }

    public void verifyDisplayElementInAuditorDashBoardPage() {
        auditorDashboardPage.verifyDisplayElementOnAuditorDashBoardPage();
    }

    public void clickRequestLink() {
        auditorDashboardPage.clickRequestLink();
    }

    public void verifyDisplayElementInEngagementRequestPage() {
        engagementRequestPage.verifyDisplayElementInRequestPage();
    }

    public void verifyDisplayElementInEngagementFilesPage() {
        engagementFilesPage.verifyDisplayElementInEngagementFilesPage();
    }

    public void clickFilesLink() {
        auditorDashboardPage.clickFilesLink();
    }

    public void clickActivityLink() {
        auditorDashboardPage.clickActivityLink();
    }

    public void clickTeamLink() {
        auditorDashboardPage.clickTeamLink();
    }

    public void verifyDisplayElementInEngagementActivityPage() {
        auditorDashboardPage.verifyDisplayElementInActivityPage();
    }

    public void verifyDisplayElementInEngagementTeamPage() {
        auditorDashboardPage.verifyDisplayElementInTeamPage();
    }

    public void clickClientsLink() {
        auditorEngagementPage.clickClientsLink();
    }

    public void clickAddNewClientButton() {
        auditorEngagementPage.clickAddNewButton();
    }

    public void verifyDisplayElementInAddNewClientPage() {
        addNewClientPage.verifyDisplayElementInAddNewClientPage();
    }

    public void auditorPageHeaderContent() {
        auditorEngagementPage.auditorPageHeaderContent();
    }

    public void verifyDisplayElementInClientPage() {
        auditorClientPage.verifyDisplayElementInClientPage();
    }

    public void clickdropDownSetingLink() {
        auditorEngagementPage.clickdropDownSetingLink();
    }

    public void verifyDisplayElementInAuditorAccountSettingPage() {
        auditorSettingsPage.verifyDisplayElementInAuditorAccountSettingPage();
    }

    public void verifyDisplayElementInDeActivePage() {
        adminPage.verifyDisplayElementInDeActivePage();
    }

    public void navigateToAuditorAccountSetting() {
        auditorEngagementPage.clickAuditorNameDropDown();
        auditorEngagementPage.clickdropDownSetingLink();
    }

    public void verifyDisplayElementInAuditorNotificationSettingPage() {
        auditorSettingsPage.verifyDisplayElementInAuditorNotificationSettingPage();
    }

    public void verifyDisplayElementInArchivePage() {
        auditorDashboardPage.verifyDisplayElementInArchivePage();
    }

    /**
     * Refactored by huy.huynh on 01/06/2017.
     * New for smoke test
     */

    public void verifySecurityOnBoardingPageSimplelize(String password) {
        auditorOnBoardingPage.verifySecurityOnBoardingPageSimplelize(password);
    }

    public void verifyEpilogueOnBoardingPage(String email) {
        auditorOnBoardingPage.verifyEpilogueOnBoardingPage(email);
    }
    /*-----------end of huy.huynh on 01/06/2017.*/
}
