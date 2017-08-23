package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.EngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by huy.huynh on 15/06/2017.
 */
public class ClientEngagementPage extends EngagementPage {

    @FindBy(id = "header-blue-logo")
    private WebElement imageLogoHeaderBlue;

    @FindBy(id = "h-engagementsLink")
    private WebElement tabHeaderEngagements;

    @FindBy(id = "h-clientListLink")
    private WebElement tabHeaderContacts;

    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUsername;

    @FindBy(xpath = "//div[@id='h-ddl-item-settings']/a")
    private WebElement dashboardSettings;

    @FindBy(id = "h-ddl-signOut")
    private WebElement dashboardSignOut;

    @FindBy(xpath = "//div[@id='preview-header-left']/span")
    private WebElement titlePreviewHeader;
    //newAuditBtn
    @FindBy(xpath = "//div[@id='engagement-filters']/span")
    private WebElement selectEngagementFilters;

    @FindBy(xpath = "//div[@type='All']/span")
    private WebElement optionFilterAll;

    @FindBy(xpath = "//div[@type='Type of Engagement']/span")
    private WebElement optionFilterTypeOfEngagement;

    @FindBy(xpath = "//div[@class='menu transition visible']/div")
    private List<WebElement> listOptionTypeOfEngagement;

    @FindBy(xpath = "//div[@class='item'][text()='Financial Audit']")
    private WebElement optionTypeOfEngagementFinancialAudit;

    @FindBy(xpath = "//div[@class='item'][text()='Review']")
    private WebElement optionTypeOfEngagementReview;

    @FindBy(xpath = "//div[@class='item'][text()='Notice to reader / Compilation']")
    private WebElement optionTypeOfEngagementNoticeToReaderCompilation;

    @FindBy(xpath = "//div[@class='item'][text()='Other']")
    private WebElement optionTypeOfEngagementOther;

    @FindBy(id = "engagement-search")
    private WebElement inputEngagementSearch;

    @FindBy(id = "engagement-sort")
    private WebElement thEngagement;

    @FindBy(id = "firm-sort")
    private WebElement thAuditFirm;

    @FindBy(id = "status-sort")
    private WebElement thStatus;

    @FindBy(id = "audit-sort")
    private WebElement thAuditAssignee;

    @FindBy(id = "docs-sort")
    private WebElement thCompletedDocs;

    @FindBy(id = "client-sort")
    private WebElement thClient;

    @FindBy(id = "activity-sort")
    private WebElement thActivity;

    @FindBy(id = "duedate-sort")
    private WebElement thDueDate;

    @FindBy(xpath = "//div[@id='client-preview-footer']//span")
    private WebElement titleCompanyInfo;

    @FindBy(xpath = "//div[@id='client-preview-footer']//a[@href][1]")
    private WebElement titleTermsOfService;

    @FindBy(xpath = "//div[@id='client-preview-footer']//a[@href][2]")
    private WebElement titlePrivacyStatement;

    @FindBy(xpath = "//div[@id='client-preview-footer']//a[@href][3]")
    private WebElement titleCookieNotice;

    @FindBy(xpath = "//td[@class='engagement-name']/a")
    private List<WebElement> eleEngagementNameList;

    @FindBy(xpath = "//tbody[@id='engagement-tbody']/tr/td[1]")
    private List<WebElement> eleEngagementCompanyList;

    @FindBy(id = "newAuditBtn")
    private WebElement buttonNewEngagement;

    @FindBy(xpath = "//span[@id='a-header-title']")
    private WebElement dashboardTextAtPage;

    public ClientEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }


    /**
     * verify UI of List Engagement page - Header
     */
    public void verifyUIListEngagementHeader(String logoHeaderBluePartialLink, String headerEngagementsText, String headerContactsText,
            String dashboardUsernameText, String dashboardSettingsText, String dashboardSignOutText) {
        try {
            closeWarningToastMessage();
            //waitSomeSeconds(2);
            validateAttributeContain(imageLogoHeaderBlue, "src", logoHeaderBluePartialLink, "Logo Auvenir White");
            validateElementText(tabHeaderEngagements, headerEngagementsText);
            validateElementText(tabHeaderContacts, headerContactsText);
            clickElement(dashboardUsername, dashboardUsernameText);
            validateElementText(dashboardSettings, dashboardSettingsText);
            validateElementText(dashboardSignOut, dashboardSignOutText);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: List Engagement Header", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page - Body
     */
    public void verifyUIListEngagementBody(String previewHeaderText, String engagementFiltersText, String filterAllText,
            String filterTypeOfEngagementText, String typeOfEngagementFinancialAuditText, String typeOfEngagementReviewText,
            String typeOfEngagementNoticeToReaderCompilationText, String typeOfEngagementOtherText, String engagementSearchText,
            String engagementColumnText, String auditFirmColumnText, String statusColumnText, String auditAssigneeColumnText,
            String completedDocsColumnText, String clientColumnText, String activityColumnText, String dueDateColumnText) {
        try {
            validateElementText(titlePreviewHeader, previewHeaderText);
            //validateElementText(buttonNewEngagement, "New Engagement");

            validateElementText(selectEngagementFilters, engagementFiltersText);
            clickElement(selectEngagementFilters, "Select Engagement Filters");
            validateElementText(optionFilterAll, filterAllText);
            validateElementText(optionFilterTypeOfEngagement, filterTypeOfEngagementText);

            clickElement(optionFilterTypeOfEngagement, "Select Engagement Filters");
            validateElementsQuantity(listOptionTypeOfEngagement, 4, "List Option Type Of Engagement");
            validateElementText(optionTypeOfEngagementFinancialAudit, typeOfEngagementFinancialAuditText);
            validateElementText(optionTypeOfEngagementReview, typeOfEngagementReviewText);
            validateElementText(optionTypeOfEngagementNoticeToReaderCompilation, typeOfEngagementNoticeToReaderCompilationText);
            validateElementText(optionTypeOfEngagementOther, typeOfEngagementOtherText);
            validatePlaceholder(inputEngagementSearch, engagementSearchText, "Input Engagement Search");
            clickElement(inputEngagementSearch, "Input Engagement Search");

            validateElementText(thEngagement, engagementColumnText);
            validateElementText(thAuditFirm, auditFirmColumnText);
            validateElementText(thStatus, statusColumnText);
            validateElementText(thAuditAssignee, auditAssigneeColumnText);
            validateElementText(thCompletedDocs, completedDocsColumnText);
            validateElementText(thClient, clientColumnText);
            validateElementText(thActivity, activityColumnText);
            validateElementText(thDueDate, dueDateColumnText);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: List Engagement Body", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of List Engagement page - Footer
     */
    public void verifyUIListEngagementFooter(String companyInfoText, String termsOfServiceText, String termsOfServicePartialLink,
            String privacyStatementText, String privacyStatementPartialLink, String cookieNoticeText, String cookieNoticePartialLink) {
        try {
            validateElementText(titleCompanyInfo, companyInfoText);
            validateElementText(titleTermsOfService, termsOfServiceText);
            validateAttributeContain(titleTermsOfService, "href", termsOfServicePartialLink, "Terms Of Service");
            validateElementText(titlePrivacyStatement, privacyStatementText);
            validateAttributeContain(titlePrivacyStatement, "href", privacyStatementPartialLink, "Privacy Statement");
            validateElementText(titleCookieNotice, cookieNoticeText);
            validateAttributeContain(titleCookieNotice, "href", cookieNoticePartialLink, "Cookie Notice");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  List Engagement Footer", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
}
