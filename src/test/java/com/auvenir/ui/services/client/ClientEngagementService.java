package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.engagement.ClientEngagementPage;
import com.auvenir.ui.pages.common.EngagementPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 15/06/2017.
 */
public class ClientEngagementService extends AbstractService {
    private ClientEngagementPage clientEngagementPage;
    private EngagementPage engagementPage;

    public ClientEngagementService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientEngagementPage = new ClientEngagementPage(getLogger(), getDriver());
        engagementPage = new EngagementPage(getLogger(), getDriver());
    }

    public void verifyNavigatedToClientEngagementPage() {
        clientEngagementPage.verifyNavigatedToEngagementPage();
    }

    public void verifyUIListEngagementHeader(String logoHeaderBluePartialLink, String headerEngagementsText, String headerContactsText,
            String dashboardUsernameText, String dashboardSettingsText, String dashboardSignOutText) {
        clientEngagementPage.verifyUIListEngagementHeader(logoHeaderBluePartialLink, headerEngagementsText, headerContactsText, dashboardUsernameText,
                dashboardSettingsText, dashboardSignOutText);
    }

    public void verifyUIListEngagementBody(String previewHeaderText, String engagementFiltersText, String filterAllText,
            String filterTypeOfEngagementText, String typeOfEngagementFinancialAuditText, String typeOfEngagementReviewText,
            String typeOfEngagementNoticeToReaderCompilationText, String typeOfEngagementOtherText, String engagementSearchText,
            String engagementColumnText, String auditFirmColumnText, String statusColumnText, String auditAssigneeColumnText,
            String completedDocsColumnText, String clientColumnText, String activityColumnText, String dueDateColumnText) {
        clientEngagementPage.verifyUIListEngagementBody(previewHeaderText, engagementFiltersText, filterAllText, filterTypeOfEngagementText,
                typeOfEngagementFinancialAuditText, typeOfEngagementReviewText, typeOfEngagementNoticeToReaderCompilationText,
                typeOfEngagementOtherText, engagementSearchText, engagementColumnText, auditFirmColumnText, statusColumnText, auditAssigneeColumnText,
                completedDocsColumnText, clientColumnText, activityColumnText, dueDateColumnText);
    }

    public void verifyUIListEngagementFooter(String companyInfoText, String termsOfServiceText, String termsOfServicePartialLink,
            String privacyStatementText, String privacyStatementPartialLink, String cookieNoticeText, String cookieNoticePartialLink) {
        clientEngagementPage.verifyUIListEngagementFooter(companyInfoText, termsOfServiceText, termsOfServicePartialLink, privacyStatementText,
                privacyStatementPartialLink, cookieNoticeText, cookieNoticePartialLink);
    }


    public void verifyEngagementPage() {
        clientEngagementPage.verifyEngagementPage();
    }

    public void viewEngagementDetailsPage(String engagementName) {
        clientEngagementPage.viewEngagementDetailsPage(engagementName);
    }
}
