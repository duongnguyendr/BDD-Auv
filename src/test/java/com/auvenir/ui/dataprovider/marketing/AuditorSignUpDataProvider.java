package com.auvenir.ui.dataprovider.marketing;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tan.pham on 7/13/2017.
 */
public class AuditorSignUpDataProvider extends CommonDataProvider {
    public static final String FRENCH_LANGUAGE = "French";

    // personal information
    private static String strFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");
    private static String strRoleFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Role in Firm", "Valid Value");
    private static String strPhone = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Auditor", "Valid Value");
    private static String strReference = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Reference to Auvenir", "Valid Value");
    // firm information
    private static String strName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Name", "Valid Value");
    private static String strPreName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Previous Name", "Valid Value");
    private static String strWebsite = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Firm Website", "Valid Value");
    private static String strStreetAddr = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Street Address", "Valid Value");
    private static String strOffNum = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Suite / Office Number", "Valid Value");
    private static String strZipCode = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Postal Code/ Zip Code", "Valid Value");
    private static String strCity = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "City", "Valid Value");
    private static String strCountry = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Country", "Valid Value");
    private static String strState = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Province / State", "Valid Value");
    private static String strMemberID = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D", "Valid Value");
    private static String strNumEmp = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Number of Employee", "Valid Value");
    private static String strPhoneFirm = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Phone Number Firm", "Valid Value");
    private static String strAffName = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Affiliated Firm's Name", "Valid Value");
    private static String strPathLogo = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Path Logo", "Valid Value");

    private static String passwordCreate = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_PASSWORD", "Valid Value");
    private static String localPropertiesDest = GenericService.sDirPath + "/local.properties";
    private static String testData = System.getProperty("user.dir") + "\\" + GenericService.getConfigValue(localPropertiesDest, "DATA_FILE");

    private static String leadClient = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "CLIENT_USER_ID", "Valid Value");
    private static String leadAuditor = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
    private static String leadAuditorPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_PASSWORD", "Valid Value");
    private static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Engagement Name", "Valid Value");
    private static String leadClientEmailPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "CLIENT_USER_EMAIL_PASSWORD", "Valid Value");
    private static String leadClientFullName = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "CLIENT_USER_FULLNAME", "Valid Value");
    private static String leadClientAuvenirPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "CLIENT_USER_PASSWORD", "Valid Value");
    private static String successTeamEmail = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
    private static String successTeamEmailPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid Value");
    private static String inviteClientSuccessfulMessage = "Your engagement invitation has been sent.";
    private static String updatePhoneNumber = "0123456789";
    private static String updateStackerHolder = "Titancorpvn";
    private static String roleClient = "";
    private static String generalAuditor = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_AUDITOR_USER_ID", "Valid Value");
    private static String generalAuditorEmailPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_AUDITOR_EMAIL_PASSWORD", "Valid Value");
    private static String generalAuditorAuvenirPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_AUDITOR_USER_PASSWORD", "Valid Value");
    private static String generalAuditorFullName = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_AUDITOR_USER_FULLNAME", "Valid Value");

    private static String generalClient = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_USER_ID", "Valid Value");
    private static String generalClientEmailPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_EMAIL_PASSWORD", "Valid Value");
    private static String generalClientAuvenirPwd = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_USER_PASSWORD", "Valid Value");
    private static String generalClientFullName = GenericService
            .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "GENERAL_CLIENT_USER_FULLNAME", "Valid Value");


    @DataProvider(name = "verifyRegisterAndActiveAuditorUser")
    public static Object[][] getVerifyRegisterAndActiveAuditorUser() {
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        String strAdminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Admin");
        String sStatusUser = onboardingStatus;

        Object[][] arrayData = new Object[][]{
                {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode,
                        strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo, passwordCreate, strAdminEmail,
                        strAdminPwd, sStatusUser}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum,
                            strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo, passwordCreate,
                            strAdminEmail, strAdminPwd, sStatusUser}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyAuditorFirmInputInvalidValue")
    public static Object[][] getVerifyAuditorFirmInputInvalidValue() {
        String strEmail = GenericService.getTestDataFromExcel("AuditorSignUpTest", "Email Address", "Valid Value");
        //Create List Invalid Data for Firm Name Text Box.
        List<String> firmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            firmNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 6));
        }
        //Create List Invalid Data for Previous Firm Name Text Box.
        List<String> preFirmNameInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            preFirmNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 7));
        }
        //Create List Invalid Data for Firm Website Text Box.
        List<String> firmWebsiteInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            firmWebsiteInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 8));
        }
        //Create List Invalid Data for Zip Code Text Box.
        List<String> zipCodeInvalidDataList = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            zipCodeInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 11));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> memberIdInvalidDataList = new ArrayList<>();
        memberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 14));
        for (int i = 4; i < 6; i++) {
            memberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 14));
        }
        //Create List Invalid Data for Member Id Text Box.
        List<String> phoneNumberIdInvalidDataList = new ArrayList<>();
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 2, 16));
        phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", 3, 16));
        for (int i = 5; i < 7; i++) {
            phoneNumberIdInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 16));
        }
        //Create List Invalid Data for AffFirm Text Box.
        List<String> affFirmInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            affFirmInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 17));
        }

        Object[][] arrayData = new Object[][]{
                {strFullName, strEmail, strRoleFirm, strPhone, strReference, firmNameInvalidDataList, preFirmNameInvalidDataList,
                        firmWebsiteInvalidDataList, zipCodeInvalidDataList, memberIdInvalidDataList, phoneNumberIdInvalidDataList,
                        affFirmInvalidDataList}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, strEmail, strRoleFirm, strPhone, strReference, firmNameInvalidDataList, preFirmNameInvalidDataList,
                            firmWebsiteInvalidDataList, zipCodeInvalidDataList, memberIdInvalidDataList, phoneNumberIdInvalidDataList,
                            affFirmInvalidDataList}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyAuditorPersonalInputInvalidValue")
    public static Object[][] getVerifyAuditorPersonalInputInvalidValue() {
        String strEmail = GenericService.getTestDataFromExcel("AuditorSignUpTest", "Email Address", "Valid Value");
        //Create List Invalid Data for First Last Name Text Box.
        List<String> firstLastNameInvalidDataList = new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            firstLastNameInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 1));
        }
        List<String> emailInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            emailInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 2));
        }
        String confirmEmailInvalidData = "test";
        List<String> phoneInvalidDataList = new ArrayList<>();
        for (int i = 2; i < 4; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 4));
        }
        for (int i = 5; i < 7; i++) {
            phoneInvalidDataList.add(GenericService.readExcelData(testData, "AuditorSignUpTest", i, 4));
        }

        Object[][] arrayData = new Object[][]{
                {firstLastNameInvalidDataList, emailInvalidDataList, strEmail, confirmEmailInvalidData, phoneInvalidDataList}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{firstLastNameInvalidDataList, emailInvalidDataList, strEmail, confirmEmailInvalidData, phoneInvalidDataList}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyAuditorSecurityInputInvalidPassword")
    public static Object[][] getVerifyAuditorSecurityInputInvalidPassword() {
        String blankPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "blankPassword", "Invalid Value");
        String invalidLengthPassword = GenericService
                .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "invalidLengthPassword", "Invalid Value");
        String noUpperCasePassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "noUpperCasePassword", "Invalid Value");
        String noLowerCasePassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "noLowerCasePassword", "Invalid Value");
        String noDigitsPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "noDigitsPassword", "Invalid Value");
        String noCharPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "noCharPassword", "Invalid Value");
        String successPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "successPassword", "Invalid Value");
        String confirmPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "confirmPassword", "Invalid Value");
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        String strAdminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
        String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Admin");
        String sStatusUser = onboardingStatus;

        Object[][] arrayData = new Object[][]{
                {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum, strZipCode,
                        strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo, passwordCreate, strAdminEmail,
                        strAdminPwd, sStatusUser, blankPassword, invalidLengthPassword, noUpperCasePassword, noLowerCasePassword, noDigitsPassword,
                        noCharPassword, successPassword, confirmPassword}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum,
                            strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo, passwordCreate,
                            strAdminEmail, strAdminPwd, sStatusUser, blankPassword, invalidLengthPassword, noUpperCasePassword, noLowerCasePassword,
                            noDigitsPassword, noCharPassword, successPassword, confirmPassword}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyProvinceAndStateWhenSignUp")
    public static Object[][] getVerifyProvinceAndStateWhenSignUp() {
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        String selectAnyCountry = "United States";
        String selectAnyState = "Florida";

        Object[][] arrayData = new Object[][]{
                {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strCountry, strState, selectAnyCountry, selectAnyState}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, emailCreate, strRoleFirm, strPhone, strReference, strCountry, strState, selectAnyCountry, selectAnyState}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyMemberIDWhenSignUp")
    public static Object[][] getVerifyMemberIDWhenSignUp() {
        String emailCreate = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        String memberIDAlphabet = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D Alphabet", "Valid Value");
        String memberIDNumeric = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D Numberic", "Valid Value");
        String memberIDSpecialChar = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D SpecialChar", "Valid Value");
        String memberIDMoreWords = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D More words", "Valid Value");
        String memberIDAlphaNumeric = GenericService
                .getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Member I.D AlphaNumberic", "Valid Value");

        Object[][] arrayData = new Object[][]{
                {strFullName, emailCreate, strRoleFirm, strPhone, strReference, memberIDAlphabet, memberIDNumeric, memberIDSpecialChar,
                        memberIDMoreWords, memberIDAlphaNumeric}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, emailCreate, strRoleFirm, strPhone, strReference, memberIDAlphabet, memberIDNumeric, memberIDSpecialChar,
                            memberIDMoreWords, memberIDAlphaNumeric}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyEmailToCustomerSuccessTeamAfterLeadAuditorSignedUp")
    public static Object[][] getVerifyEmailToCustomerSuccessTeamAfterLeadAuditorSignedUp() {
        String auditorAccount = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "AUDITOR_USER_ID", "Valid Value");
        String successTeamEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
        String successTeamEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid Value");

        Object[][] arrayData = new Object[][]{
                {strFullName, auditorAccount, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum,
                        strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo, successTeamEmail,
                        successTeamEmailPwd}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {strFullName, auditorAccount, strRoleFirm, strPhone, strReference, strName, strPreName, strWebsite, strStreetAddr, strOffNum,
                            strZipCode, strCity, strCountry, strState, strMemberID, strNumEmp, strPhoneFirm, strAffName, strPathLogo,
                            successTeamEmail, successTeamEmailPwd}};
        }

        return arrayData;
    }


    @DataProvider(name = "verifyAuditorInviteClient")
    public static Object[][] getVerifyAuditorInviteClient() {


        Object[][] arrayData = new Object[][]{
                {leadClient, leadAuditor, leadAuditorPwd, engagementName, leadClientEmailPwd, leadClientFullName, leadClientAuvenirPwd,
                        successTeamEmail, successTeamEmailPwd, inviteClientSuccessfulMessage, updatePhoneNumber, updateStackerHolder, roleClient}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {leadClient, leadAuditor, leadAuditorPwd, engagementName, leadClientEmailPwd, leadClientFullName, leadClientAuvenirPwd,
                            successTeamEmail, successTeamEmailPwd, inviteClientSuccessfulMessage, updatePhoneNumber, updateStackerHolder,
                            roleClient}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyAuditorInviteGeneralAuditor")
    public static Object[][] getVerifyAuditorInviteGeneralAuditor() {

        Object[][] arrayData = new Object[][]{
                {generalAuditor, leadAuditor, leadAuditorPwd, engagementName, generalAuditorEmailPwd, generalAuditorFullName,
                        generalAuditorAuvenirPwd, successTeamEmail, successTeamEmailPwd}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{generalAuditor, leadAuditor, leadAuditorPwd, engagementName, generalAuditorEmailPwd, generalAuditorFullName,
                    generalAuditorAuvenirPwd, successTeamEmail, successTeamEmailPwd}};
        }

        return arrayData;
    }

    @DataProvider(name = "verifyNoEmailToCustomerSuccessTeam")
    public static Object[][] getVerifyNoEmailToCustomerSuccessTeam() {
        String successTeamEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email", "Valid Value");
        String successTeamEmailPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "Success Team Email Pwd", "Valid Value");

        Object[][] arrayData = new Object[][]{{successTeamEmail, successTeamEmailPwd}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{{successTeamEmail, successTeamEmailPwd}};
        }

        return arrayData;
    }


    @DataProvider(name = "verifyLeadClientInviteGeneralClient")
    public static Object[][] getVerifyLeadClientInviteGeneralClient() {

        Object[][] arrayData = new Object[][]{
                {generalClient, leadClient, leadClientAuvenirPwd, engagementName, generalClientEmailPwd, generalClientFullName, generalClientAuvenirPwd,
                        successTeamEmail, successTeamEmailPwd,inviteClientSuccessfulMessage, updatePhoneNumber, updateStackerHolder}};

        if (GenericService.sLanguage.equals(FRENCH_LANGUAGE)) {
            arrayData = new Object[][]{
                    {generalClient, leadClient, leadClientAuvenirPwd, engagementName, generalClientEmailPwd, generalClientFullName, generalClientAuvenirPwd,
                            successTeamEmail, successTeamEmailPwd, inviteClientSuccessfulMessage,updatePhoneNumber, updateStackerHolder}};
        }

        return arrayData;
    }
}
