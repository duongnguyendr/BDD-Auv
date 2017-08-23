package com.auvenir.ui.dataprovider.groupPermissions;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class GroupPermissionsDataProvider extends CommonDataProvider {
    private final static String SHEET_NAME = "GroupPermissionTest";
    private final static String VALID_VALUE_COLUMN = "Valid Value";
    public static final String FRENCH_LANGUAGE = "French";

    private static String adminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin", VALID_VALUE_COLUMN);
    private static String adminAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auvenir Password", VALID_VALUE_COLUMN);

    private static String superAdminUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin", VALID_VALUE_COLUMN);
    private static String superAdminPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Super Admin Auvenir Password", VALID_VALUE_COLUMN);


    private static String adminAuditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor", VALID_VALUE_COLUMN);
    private static String adminAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Email Password", VALID_VALUE_COLUMN);
    private static String adminAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String adminAuditorFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor Full Name", VALID_VALUE_COLUMN);

    private static String roleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Role in Firm", VALID_VALUE_COLUMN);
    private static String phoneNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Phone Number Auditor", VALID_VALUE_COLUMN);
    private static String referenceToAuvenir =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Reference to Auvenir", VALID_VALUE_COLUMN);
    // firm information
    //    private static String firmName = "Test Audits LLC";
    private static String firmName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Name", VALID_VALUE_COLUMN);
    private static String firmPreName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Previous Name", VALID_VALUE_COLUMN);
    private static String firmWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Firm Website", VALID_VALUE_COLUMN);
    private static String streetAddress = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Street Address", VALID_VALUE_COLUMN);
    private static String officeNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Suite / Office Number", VALID_VALUE_COLUMN);
    private static String zipCode = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Postal Code/ Zip Code", VALID_VALUE_COLUMN);
    private static String city = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "City", VALID_VALUE_COLUMN);
    private static String country = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Country", VALID_VALUE_COLUMN);
    private static String stateNumber = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Province / State", VALID_VALUE_COLUMN);
    private static String memberID = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Member I.D", VALID_VALUE_COLUMN);
    private static String numberEmployee = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Number of Employee", VALID_VALUE_COLUMN);
    private static String phoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Phone Number Firm", VALID_VALUE_COLUMN);
    private static String affiliateFirmName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Affiliated Firm's Name", VALID_VALUE_COLUMN);
    private static String pathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Path Logo", VALID_VALUE_COLUMN);

    private static String engagementName1 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Engagement 1 Name", VALID_VALUE_COLUMN);

    private static String engagementName2 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Engagement 2 Name", VALID_VALUE_COLUMN);

    private static String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Company Name", VALID_VALUE_COLUMN);

    private static String leadAuditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor", VALID_VALUE_COLUMN);
    private static String leadAuditorFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Full Name", VALID_VALUE_COLUMN);
    private static String leadAuditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String leadAuditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Email Password", VALID_VALUE_COLUMN);

    private static String adminClientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client", VALID_VALUE_COLUMN);
    private static String adminClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String adminClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Email Password", VALID_VALUE_COLUMN);
    private static String adminClientFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client Full Name", VALID_VALUE_COLUMN);
    private static String roleClient = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Role Client", VALID_VALUE_COLUMN);

    private static String clientPhoneNumber =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Phone Number", VALID_VALUE_COLUMN);
    private static String parentStackHolder =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Parent Stack Holder", VALID_VALUE_COLUMN);

    private static String auditorUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor", VALID_VALUE_COLUMN);
    private static String auditorFullName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Full Name", VALID_VALUE_COLUMN);
    private static String auditorAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Auvenir Password", VALID_VALUE_COLUMN);
    private static String auditorEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor Auvenir Password", VALID_VALUE_COLUMN);

    private static String leadClientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client", VALID_VALUE_COLUMN);
    private static String leadClientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Email Password", VALID_VALUE_COLUMN);
    private static String leadClientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String leadClientFullName =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client Full Name", VALID_VALUE_COLUMN);

    private static String successMessageInvitation =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Success Message Invitation", VALID_VALUE_COLUMN);
    private static String successMessageRemoveTeamMember =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Success Message Remove Team Member", VALID_VALUE_COLUMN);

    private static String clientUser = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client", VALID_VALUE_COLUMN);
    private static String clientEmailPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Email Password", VALID_VALUE_COLUMN);
    private static String clientAuvenirPwd =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Auvenir Password", VALID_VALUE_COLUMN);
    private static String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client Full Name", VALID_VALUE_COLUMN);

    private static String leadText = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Text", VALID_VALUE_COLUMN);

    private static String todo1 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 1 name", VALID_VALUE_COLUMN);
    private static String todo2 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 2 name", VALID_VALUE_COLUMN);
    private static String todo3 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 3 name", VALID_VALUE_COLUMN);
    private static String todo4 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 4 name", VALID_VALUE_COLUMN);
    private static String todo5 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 5 name", VALID_VALUE_COLUMN);
    private static String todo6 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 6 name", VALID_VALUE_COLUMN);
    private static String todo7 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 7 name", VALID_VALUE_COLUMN);
    private static String todo8 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 8 name", VALID_VALUE_COLUMN);
    private static String todo9 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 9 name", VALID_VALUE_COLUMN);
    private static String todo10 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "To Do 10 name", VALID_VALUE_COLUMN);

    private static String requestName1 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 1", VALID_VALUE_COLUMN);
    private static String requestName2 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 2", VALID_VALUE_COLUMN);
    private static String requestName3 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 3", VALID_VALUE_COLUMN);
    private static String requestName4 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 4", VALID_VALUE_COLUMN);
    private static String requestName5 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 5", VALID_VALUE_COLUMN);
    private static String requestName6 = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Request Name 6", VALID_VALUE_COLUMN);

    private static String fileRequestName1 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 1", VALID_VALUE_COLUMN);
    private static String fileRequestName2 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 2", VALID_VALUE_COLUMN);
    private static String fileRequestName3 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 3", VALID_VALUE_COLUMN);
    private static String fileRequestName4 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 4", VALID_VALUE_COLUMN);
    private static String fileRequestName5 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 5", VALID_VALUE_COLUMN);
    private static String fileRequestName6 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Request Name 6", VALID_VALUE_COLUMN);

    private static String fileCommentName1 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 1", VALID_VALUE_COLUMN);
    private static String fileCommentName2 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 2", VALID_VALUE_COLUMN);
    private static String fileCommentName3 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 3", VALID_VALUE_COLUMN);
    private static String fileCommentName4 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 4", VALID_VALUE_COLUMN);
    private static String fileCommentName5 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 5", VALID_VALUE_COLUMN);
    private static String fileCommentName6 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "File Comment Name 6", VALID_VALUE_COLUMN);

    private static String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Category Name", VALID_VALUE_COLUMN);

    private static String newCategoryName1 =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "New Category Name 1", VALID_VALUE_COLUMN);

    private static String leadAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Auditor Comment  1", VALID_VALUE_COLUMN);

    private static String pathDownload = GenericService.sDirPath + GenericService
            .getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Path of Download Location", "Valid Value");

    private static String pathUpload = GenericService.sDirPath + GenericService
            .getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "Path of Upload Location", "Valid Value");

    private static String generalAuditorCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "General Auditor Comment  4", VALID_VALUE_COLUMN);

    private static String leadClientCmt = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Comment  1", VALID_VALUE_COLUMN);

    private static String generalClientCmt =
            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "General Client Comment  2", VALID_VALUE_COLUMN);


    private static String sMonth = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Month", VALID_VALUE_COLUMN);
    private static String sDay = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Day", VALID_VALUE_COLUMN);
    private static String sYear = GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Year", VALID_VALUE_COLUMN);

    //    private static String isAdminAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Auditor", "Can Create An Engagement");
    //    private static String isAuditorCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Auditor", "Can Create An Engagement");
    //    private static String isAdminClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Admin Client", "Can Create An Engagement");
    //    private static String isLeadClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Lead Client", "Can Create An Engagement");
    //    private static String isClientCanCreateAnEngagement =
    //            GenericService.getTestDataFromExcelNoBrowserPrefix(SHEET_NAME, "Client", "Can Create An Engagement");
    @DataProvider(name = "verifySuperAdminLogin")
    public static Object[][] getVerifySuperAdminLogin() {
        Object[][] arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        if (GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{superAdminUser, superAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminLogin")
    public static Object[][] getVerifyAdminLogin() {
        Object[][] arrayData = new Object[][]{{adminUser, adminAuvenirPwd}};
        if (GenericService.sLanguage.equalsIgnoreCase(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{adminUser, adminAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCreateAnEngagement")
    public static Object[][] getVerifyAdminAuditorCreateAnEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifySignUpAuditorUser")
    public static Object[][] getVerifySignUpAuditorUser() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorUser, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite, streetAddress,
                        officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName, pathLogo}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorUser, adminAuditorFullName, firmName, roleFirm, phoneNumber, referenceToAuvenir, firmPreName, firmWebsite,
                            streetAddress, officeNumber, zipCode, city, country, stateNumber, memberID, numberEmployee, phoneFirm, affiliateFirmName,
                            pathLogo}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminChangeStatusUserToOnBoarding")
    public static Object[][] getVerifyAdminChangeStatusUserToOnBoarding() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminUser, adminAuditorEmailPwd, adminAuvenirPwd, onboardingStatus}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminUser, adminAuditorEmailPwd, adminAuvenirPwd, onboardingStatus}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorLoginGmailAndActiveUser")
    public static Object[][] getVerifyAuditorLoginGmailAndActiveUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorEmailPwd, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLoginAuditorUser")
    public static Object[][] getVerifyLoginAuditorUser() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCreateSimpleEngagement")
    public static Object[][] getVerifyAdminAuditorCreateSimpleEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, engagementName1, companyName, adminAuditorAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, engagementName1, companyName, adminAuditorAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteNewMemberAuditor")
    public static Object[][] getVerifyAdminAuditorInviteNewMemberAuditor() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName, partnerRole,
                        leadAuditorEmailPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadAuditorFullName,
                            partnerRole, leadAuditorEmailPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInvitingNewClient")
    public static Object[][] getVerifyAdminAuditorInvitingNewClient() {
        Object[][] arrayData = new Object[][]{
                {adminUser, adminAuvenirPwd, adminClientUser, adminClientEmailPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1,
                        adminClientFullName, roleClient, onboardingStatus, leadClientUser, clientUser}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminUser, adminAuvenirPwd, adminClientUser, adminClientEmailPwd, adminAuditorUser, adminAuditorAuvenirPwd, engagementName1,
                            adminClientFullName, roleClient, onboardingStatus, leadClientUser, clientUser}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive() {
        Object[][] arrayData =
                new Object[][]{{adminClientUser, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientEmailPwd, clientPhoneNumber, parentStackHolder, adminClientAuvenirPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientActiveAfterSignUpSuccess")
    public static Object[][] getVerifyClientActiveAfterSignUpSuccess() {
        Object[][] arrayData = new Object[][]{{adminUser, adminAuvenirPwd, adminClientUser, activeStatus, adminClientAuvenirPwd}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminUser, adminAuvenirPwd, adminClientUser, activeStatus, adminClientAuvenirPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateNewEngagement")
    public static Object[][] getVerifyLeadAuditorCreateNewEngagement() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, companyName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, companyName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInviteNewAuditorMember")
    public static Object[][] getVerifyLeadAuditorInviteNewAuditorMember() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, auditorUser, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                        partnerRole}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, auditorUser, auditorEmailPwd, auditorAuvenirPwd, engagementName2, auditorFullName,
                            partnerRole}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorInvitingAdminClient")
    public static Object[][] getVerifyLeadAuditorInvitingAdminClient() {
        String adminClientFullNameAndCompany = adminClientFullName + " (" + companyName + ")";

        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, adminClientUser, adminClientEmailPwd, adminClientAuvenirPwd, engagementName2,
                        adminClientFullNameAndCompany, clientPhoneNumber, parentStackHolder}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, adminClientUser, adminClientEmailPwd, adminClientAuvenirPwd, engagementName2,
                            adminClientFullNameAndCompany, clientPhoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminClientCanInviteClient")
    public static Object[][] getVerifyPermissionAdminClientCanInviteClient() {
        Object[][] arrayData = new Object[][]{
                {adminClientUser, adminClientAuvenirPwd, leadClientUser, leadClientEmailPwd, adminUser, adminAuvenirPwd, engagementName2,
                        leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientAuvenirPwd, leadClientUser, leadClientEmailPwd, adminUser, adminAuvenirPwd, engagementName2,
                            leadClientFullName, successMessageInvitation, onboardingStatus, roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientCanActiveViaEmail")
    public static Object[][] getVerifyPermissionClientCanActiveViaEmail() {
        Object[][] arrayData =
                new Object[][]{{leadClientUser, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData =
                    new Object[][]{{leadClientUser, leadClientEmailPwd, clientPhoneNumber, parentStackHolder, leadClientAuvenirPwd, engagementName2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadPermissionCanBeTranfered")
    public static Object[][] getVerifyPermissionLeadPermissionCanBeTranfered() {
        Object[][] arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, leadClientFullName, leadText}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientRemoveAdminClient")
    public static Object[][] getVerifyLeadClientRemoveAdminClient() {
        Object[][] arrayData =
                new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, adminClientFullName, successMessageRemoveTeamMember}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientInviteClient")
    public static Object[][] getVerifyLeadClientInviteClient() {
        Object[][] arrayData = new Object[][]{
                {leadClientUser, leadClientAuvenirPwd, clientUser, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                        roleClient}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientUser, leadClientAuvenirPwd, clientUser, clientEmailPwd, engagementName2, clientFullName, successMessageInvitation,
                            roleClient}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientActive")
    public static Object[][] getVerifyGeneralClientActive() {
        Object[][] arrayData = new Object[][]{{clientUser, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientEmailPwd, clientAuvenirPwd, engagementName2, phoneNumber, parentStackHolder}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCreateTodoAndAssignClient")
    public static Object[][] getVerifyLeadAuditorCreateTodoAndAssignClient() {
        Object[][] arrayData =
                new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, todo5, leadClientFullName,
                        categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData =
                    new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, todo5, leadClientFullName,
                            categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToGeneralAuditor")
    public static Object[][] verifyLeadAuditorAssignToGeneralAuditor() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, auditorFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCommenting")
    public static Object[][] verifyLeadAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, leadAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, leadAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorMarkCompleted")
    public static Object[][] verifyLeadAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAssignToDoBulkAction")
    public static Object[][] verifyLeadAuditorAssignToDoBulkAction() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3, auditorFullName, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDeleteTodo")
    public static Object[][] verifyLeadAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo3}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDownloadFromAllTodo")
    public static Object[][] verifyLeadAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCreateTodo")
    public static Object[][] getVerifyGeneralAuditorCreateTodo() {
        Object[][] arrayData = new Object[][]{
                {auditorUser, auditorAuvenirPwd, engagementName2, todo6, todo7, todo8, todo9, todo10, leadClientFullName, categoryName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorUser, auditorAuvenirPwd, engagementName2, todo6, todo7, todo8, todo9, todo10, leadClientFullName, categoryName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorCommenting")
    public static Object[][] getVerifyGeneralAuditorCommenting() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo9, generalAuditorCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo9, generalAuditorCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorMarkCompleted")
    public static Object[][] getVerifyGeneralAuditorMarkCompleted() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo7}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo7}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDeleteTodo")
    public static Object[][] getVerifyGeneralAuditorDeleteTodo() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo8}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo8}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDownloadFromAllTodo")
    public static Object[][] getVerifyGeneralAuditorDownloadFromAllTodo() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientMakeComment")
    public static Object[][] verifyLeadClientMakeComment() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, leadClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, leadClientCmt}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientViewComment")
    public static Object[][] verifyGeneralClientViewComment() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo6, leadClientCmt, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo6, leadClientCmt, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientPostComment")
    public static Object[][] verifyGeneralClientPostComment() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, generalClientCmt}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientViewComment")
    public static Object[][] verifyLeadClientViewComment() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, generalClientCmt, clientFullName}};
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientSeeToDo")
    public static Object[][] getVerifyLeadClientSeeToDo() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo4, todo5, todo6, todo7, todo9}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo2, todo4, todo5, todo6, todo7, todo9}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientAssignTodoTaskToClient")
    public static Object[][] getVerifyLeadClientAssignTodoTaskToClient() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo6, todo9, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo6, todo9, clientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientCanViewTodoTaskAssigned")
    public static Object[][] getVerifyGeneralClientCanViewTodoTaskAssigned() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorSeeAllEngagementsWithinFirm")
    public static Object[][] getVerifyAdminAuditorSeeAllEngagementsWithinFirm() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, engagementName2}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, engagementName2}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteClientIntoEngagement")
    public static Object[][] getVerifyAdminAuditorInviteClientIntoEngagement() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorInviteGeneralClientIntoEngagement")
    public static Object[][] getVerifyAdminAuditorInviteGeneralClientIntoEngagement() {
        Object[][] arrayData = new Object[][]{
                {adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadClientFullName, leadClientUser, roleClient, successMessageInvitation,
                        adminUser, adminPwd, GenericData.UserRole.Client.value}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName1, leadClientFullName, leadClientUser, roleClient,
                    successMessageInvitation, adminUser, adminPwd, GenericData.UserRole.Client.value}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCanNotRemoveAuditor")
    public static Object[][] getVerifyAdminAuditorCanNotRemoveAuditor() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, leadAuditorFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, leadAuditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCanNotRemoveClients")
    public static Object[][] getVerifyAdminAuditorCanNotRemoveClients() {
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, leadClientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, leadClientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCanSeeAllToDosWithinEngagement")
    public static Object[][] getVerifyAdminAuditorCanSeeAllToDosWithinEngagement() {
        boolean isToDo1Visible = true;
        boolean isToDo2Visible = true;
        boolean isToDo3Visible = true;
        boolean isToDo4Visible = true;
        Object[][] arrayData = new Object[][]{
                {adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, isToDo1Visible, isToDo2Visible,
                        isToDo3Visible, isToDo4Visible}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, isToDo1Visible, isToDo2Visible,
                            isToDo3Visible, isToDo4Visible}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAddNewRequest")
    public static Object[][] getVerifyLeadAuditorAddNewRequest() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, todo5, requestName1, requestName2, requestName3, requestName4, requestName5,
                        requestName6}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo2, todo3, todo4, todo5, requestName1, requestName2, requestName3, requestName4,
                            requestName5, requestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorAddFileToNewRequest")
    public static Object[][] getVerifyLeadAuditorAddFileToNewRequest() {
        Object[][] arrayData = new Object[][]{
                {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, requestName1, requestName2, requestName3, requestName4, requestName5,
                        requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                        pathUpload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, requestName1, requestName2, requestName3, requestName4,
                            requestName5, requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5,
                            fileRequestName6, pathUpload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorAddFileToNewRequest")
    public static Object[][] getVerifyGeneralAuditorAddFileToNewRequest() {
        Object[][] arrayData = new Object[][]{
                {auditorUser, auditorAuvenirPwd, engagementName2, todo9, requestName1, requestName2, requestName3, requestName4, requestName5,
                        requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                        pathUpload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorUser, auditorAuvenirPwd, engagementName2, todo9, requestName1, requestName2, requestName3, requestName4, requestName5,
                            requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                            pathUpload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorAddNewRequest")
    public static Object[][] getVerifyGeneralAuditorAddNewRequest() {
        Object[][] arrayData = new Object[][]{
                {auditorUser, auditorAuvenirPwd, engagementName2, todo6, todo7, todo8, todo9, todo10, requestName1, requestName2, requestName3, requestName4,
                        requestName5, requestName6}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorUser, auditorAuvenirPwd, engagementName2, todo6, todo7, todo8, todo9, todo10, requestName1, requestName2, requestName3, requestName4,
                            requestName5, requestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorDownloadRequestFile")
    public static Object[][] getVerifyLeadAuditorDownloadRequestFile() {
        Object[][] arrayData =
                new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, pathUpload, pathDownload, fileRequestName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo4, pathUpload, pathDownload, fileRequestName1}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralAuditorDownloadRequestFile")
    public static Object[][] getVerifyGeneralAuditorDownloadRequestFile() {
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, pathUpload, pathDownload, fileRequestName1}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo4, pathUpload, pathDownload, fileRequestName1}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientUseBulkActionToAssignTodoTask")
    public static Object[][] getVerifyLeadClientUseBulkActionToAssignTodoTask() {
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo4, clientFullName}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo4, clientFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientAddFileToNewRequest")
    public static Object[][] getVerifyLeadClientAddFileToNewRequest() {
        Object[][] arrayData = new Object[][]{
                {leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, requestName1, requestName2, requestName3, requestName4, requestName5,
                        requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                        pathUpload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, requestName1, requestName2, requestName3, requestName4,
                            requestName5, requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5,
                            fileRequestName6, pathUpload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGeneralClientAddFileToNewRequest")
    public static Object[][] getVerifyGeneralClientAddFileToNewRequest() {
        Object[][] arrayData = new Object[][]{
                {clientUser, clientAuvenirPwd, engagementName2, todo1, requestName1, requestName2, requestName3, requestName4, requestName5,
                        requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                        pathUpload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {clientUser, clientAuvenirPwd, engagementName2, todo1, requestName1, requestName2, requestName3, requestName4, requestName5,
                            requestName6, fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6,
                            pathUpload}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientDownloadFileToNewRequest")
    public static Object[][] getVerifyLeadClientDownloadFileToNewRequest() {
        Object[][] arrayData =
                new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, fileRequestName1, pathUpload, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo6, fileRequestName1, pathUpload, pathDownload}};
        }
        return arrayData;
    }


    @DataProvider(name = "verifyGeneralClientDownloadFileToNewRequest")
    public static Object[][] getVerifyGeneralClientDownloadFileToNewRequest() {
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, fileRequestName2, pathUpload, pathDownload}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, fileRequestName2, pathUpload, pathDownload}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCanSeeAllFiles")
    public static Object[][] getVerifyAdminAuditorCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2,
                            fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCanSeeAllFiles")
    public static Object[][] getVerifyLeadAuditorCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2,
                            fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorCanSeeAllFiles")
    public static Object[][] getVerifyAuditorCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorUser, auditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2,
                            fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminClientCanSeeAllFiles")
    public static Object[][] getVerifyAdminClientCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2,
                            fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientCanSeeAllFiles")
    public static Object[][] getVerifyLeadClientCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2,
                            fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientCanSeeAllFiles")
    public static Object[][] getVerifyClientCanSeeAllFiles() {
        String listFile[] = {fileRequestName1, fileRequestName2, fileRequestName3, fileRequestName4, fileRequestName5, fileRequestName6};
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileRequestName1, fileRequestName2, fileRequestName3,
                            fileRequestName4, fileRequestName5, fileRequestName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminAuditorCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyAdminAuditorCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminAuditorUser, adminAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2,
                            fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadAuditorCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyLeadAuditorCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadAuditorUser, leadAuditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2,
                            fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyAuditorCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{auditorUser, auditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {auditorUser, auditorAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2,
                            fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAdminClientCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyAdminClientCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{adminClientUser, adminClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {adminClientUser, adminClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2,
                            fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyLeadClientCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyLeadClientCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {leadClientUser, leadClientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2,
                            fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientCanDownloadFileFromTodoComment")
    public static Object[][] getVerifyClientCanDownloadFileFromTodoComment() {
        String listFile[] = {fileCommentName1, fileCommentName2, fileCommentName3, fileCommentName4, fileCommentName5, fileCommentName6};
        Object[][] arrayData = new Object[][]{{clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, listFile}};
        if (GenericService.sLanguage.equals("French")) {
            arrayData = new Object[][]{
                    {clientUser, clientAuvenirPwd, engagementName2, todo1, todo4, todo6, todo9, fileCommentName1, fileCommentName2, fileCommentName3,
                            fileCommentName4, fileCommentName5, fileCommentName6}};
        }
        return arrayData;
    }
}
