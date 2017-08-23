package com.auvenir.ui.dataprovider.client;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 11/07/2017.
 */
public class ClientDataProvider {
    private static String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
    private static String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Auvenir Password");
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    private static String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
    private static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
    private static String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Auvenir Password");
    private static String clientEmailPassword = GenericService
            .getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");
    private static String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Assignee");
    private static String invalidClientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Invalid User", "Client");

    private static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");

    private static String imageLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Image Logo", "Valid Value");
    private static String greetingTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Greeting Title", "Valid Value");
    private static String announcementTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Announcement Title", "Valid Value");
    private static String auvenirIntroducingTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Auvenir Introducing Title", "Valid Value");
    private static String introducingBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Introducing Benefit Title", "Valid Value");
    private static String firstBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "First Benefit Title", "Valid Value");
    private static String secondBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Second Benefit Title", "Valid Value");
    private static String thirdBenefitTitle = GenericService
            .getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Third Benefit Title", "Valid Value");
    private static String feedbackTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Feedback Title", "Valid Value");
    private static String goodbyeTitle = GenericService.getTestDataFromExcelNoBrowserPrefix("EmailTemplateData", "Goodbye Title", "Valid Value");

    private static String personalPhoneNumber = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientSignUpTest", "Personal Phone Number", "Valid Value");
    private static String parentStakeholders = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientSignUpTest", "Parent Stakeholders", "Valid Value");

    private static String logoHeaderBluePartialLink = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Logo Header White Partial Link", "Valid Value");
    private static String headerEngagementsText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Header Engagements", "Valid Value");
    private static String headerContactsText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Header Contacts", "Valid Value");
    private static String dashboardUsernameText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Dashboard Username", "Valid Value");
    private static String dashboardSettingsText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Dashboard Settings", "Valid Value");
    private static String dashboardSignOutText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Dashboard Sign Out", "Valid Value");
    private static String previewHeaderText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Preview Header", "Valid Value");
    private static String engagementFiltersText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Engagement Filters", "Valid Value");
    private static String filterAllText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Filter All", "Valid Value");
    private static String filterTypeOfEngagementText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Filter Type Of Engagement", "Valid Value");
    private static String typeOfEngagementFinancialAuditText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Type Of Engagement Financial Audit", "Valid Value");
    private static String typeOfEngagementReviewText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Type Of Engagement Review", "Valid Value");
    private static String typeOfEngagementNoticeToReaderCompilationText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Type Of Engagement Notice To Reader Compilation", "Valid Value");
    private static String typeOfEngagementOtherText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Type Of Engagement Other", "Valid Value");
    private static String engagementSearchText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Engagement Search", "Valid Value");
    private static String engagementColumnText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Engagement Column", "Valid Value");
    private static String auditFirmColumnText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Audit Firm Column", "Valid Value");
    private static String statusColumnText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Status Column", "Valid Value");
    private static String auditAssigneeColumnText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Audit Assignee Column", "Valid Value");
    private static String completedDocsColumnText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Completed Docs Column", "Valid Value");
    private static String clientColumnText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Client Column", "Valid Value");
    private static String activityColumnText = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Activity Column", "Valid Value");
    private static String dueDateColumnText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "DueDate Column", "Valid Value");
    private static String companyInfoText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Company Info", "Valid Value");
    private static String termsOfServiceText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Terms Of Service Text", "Valid Value");
    private static String termsOfServicePartialLink = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Terms Of Service Partial Link", "Valid Value");
    private static String privacyStatementText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Privacy Statement Text", "Valid Value");
    private static String privacyStatementPartialLink = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Privacy Statement Partial Link", "Valid Value");
    private static String cookieNoticeText = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Cookie Notice Text", "Valid Value");
    private static String cookieNoticePartialLink = GenericService
            .getTestDataFromExcelNoBrowserPrefix("ClientUITest", "Cookie Notice Partial Link", "Valid Value");

    @DataProvider(name = "verifyInvitingNewClient")
    public static Object[][] getVerifyInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminId, adminPassword, auditorId, auditorPassword, clientId, clientEmailPassword, clientFullName, invalidClientId, engagementName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminId, adminPassword, auditorId, auditorPassword, clientId, clientEmailPassword, clientFullName, invalidClientId,
                            engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyInvitationEmail")
    public static Object[][] getVerifyInvitationEmail() {
        Object[][] arrayData = new Object[][]{
                {clientId, clientEmailPassword, imageLogo, greetingTitle, announcementTitle, auvenirIntroducingTitle, introducingBenefitTitle,
                        firstBenefitTitle, secondBenefitTitle, thirdBenefitTitle, feedbackTitle, goodbyeTitle}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {clientId, clientEmailPassword, imageLogo, greetingTitle, announcementTitle, auvenirIntroducingTitle, introducingBenefitTitle,
                            firstBenefitTitle, secondBenefitTitle, thirdBenefitTitle, feedbackTitle, goodbyeTitle}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive() {
        Object[][] arrayData = new Object[][]{
                {clientId, clientEmailPassword, personalPhoneNumber, parentStakeholders, clientPassword, engagementName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientId, clientEmailPassword, personalPhoneNumber, parentStakeholders, clientPassword, engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientHomePage")
    public static Object[][] getVerifyClientHomePage() {
        Object[][] arrayData = new Object[][]{
                {logoHeaderBluePartialLink, headerEngagementsText, headerContactsText, dashboardUsernameText, dashboardSettingsText,
                        dashboardSignOutText, previewHeaderText, engagementFiltersText, filterAllText, filterTypeOfEngagementText,
                        typeOfEngagementFinancialAuditText, typeOfEngagementReviewText, typeOfEngagementNoticeToReaderCompilationText,
                        typeOfEngagementOtherText, engagementSearchText, engagementColumnText, auditFirmColumnText, statusColumnText,
                        auditAssigneeColumnText, completedDocsColumnText, clientColumnText, activityColumnText, dueDateColumnText, companyInfoText,
                        termsOfServiceText, termsOfServicePartialLink, privacyStatementText, privacyStatementPartialLink, cookieNoticeText,
                        cookieNoticePartialLink}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {logoHeaderBluePartialLink, headerEngagementsText, headerContactsText, dashboardUsernameText, dashboardSettingsText,
                            dashboardSignOutText, previewHeaderText, engagementFiltersText, filterAllText, filterTypeOfEngagementText,
                            typeOfEngagementFinancialAuditText, typeOfEngagementReviewText, typeOfEngagementNoticeToReaderCompilationText,
                            typeOfEngagementOtherText, engagementSearchText, engagementColumnText, auditFirmColumnText, statusColumnText,
                            auditAssigneeColumnText, completedDocsColumnText, clientColumnText, activityColumnText, dueDateColumnText,
                            companyInfoText, termsOfServiceText, termsOfServicePartialLink, privacyStatementText, privacyStatementPartialLink,
                            cookieNoticeText, cookieNoticePartialLink}};
        }
        return arrayData;
    }
}
