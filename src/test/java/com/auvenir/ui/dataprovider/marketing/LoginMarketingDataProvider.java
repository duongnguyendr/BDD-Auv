package com.auvenir.ui.dataprovider.marketing;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/14/2017.
 */
public class LoginMarketingDataProvider extends CommonDataProvider {
    public static final String FRENCH_LANGUAGE = "French";

    private static String emailId = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","VALID VALUE");
    private static String emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");

    @DataProvider(name = "forgotPasswordTest")
    public static Object[][] getForgotPasswordTest(){
        int maxLength = 8;
        boolean isContainsUpperCase = true;
        boolean isContainsLowerCase = true;
        boolean isContainsDigit = true;
        boolean isContainsSpecialCharacter = true;
        String ranPassword = GenericService.genResetPassword(maxLength, isContainsUpperCase,isContainsLowerCase,isContainsDigit,isContainsSpecialCharacter);
        Object[][] arrayData = new Object[][]{{emailId, emailPassword, ranPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword, ranPassword}};
        }
        return  arrayData;
    }


    @DataProvider(name = "forgotPasswordWithBlankEmail")
    public static Object[][] getForgotPasswordWithBlankEmail(){
        String errorMessage = "Email can't be empty!";

        Object[][] arrayData = new Object[][]{{errorMessage}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{errorMessage}};
        }
        return  arrayData;
    }

    @DataProvider(name = "forgotPasswordWithInvalidEmail")
    public static Object[][] getForgotPasswordWithInvalidEmail(){
        String invalidEmailAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE");
        String invalidEmailAddress1 = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID VALUE1");
        String invalidEmailAddress2 = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","INVALID " +
                "VALUE2");
        String errorMessage = "The email is invalid!";

        Object[][] arrayData = new Object[][]{{invalidEmailAddress, invalidEmailAddress1, invalidEmailAddress2, errorMessage}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{invalidEmailAddress, invalidEmailAddress1, invalidEmailAddress2, errorMessage}};
        }
        return  arrayData;
    }


    @DataProvider(name = "forgotPasswordWithEmailIsNotExist")
    public static Object[][] getForgotPasswordWithEmailIsNotExist(){
        String invalidEmailAddress = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_ADDRESS","NOT EXIST");
        String errorMessage = "The email does not exist!";
        Object[][] arrayData = new Object[][]{{invalidEmailAddress, errorMessage}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{invalidEmailAddress, errorMessage}};
        }
        return  arrayData;
    }

    @DataProvider(name = "loginAndLogoutTest")
    public static Object[][] getLoginAndLogoutTest(){
        emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_NEW_PASSWORD","VALID VALUE");
        Object[][] arrayData = new Object[][]{{emailId, emailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "clearCookieAfterLoginSuccessTest")
    public static Object[][] getClearCookieAfterLoginSuccessTest(){
        emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_NEW_PASSWORD","VALID VALUE");

        Object[][] arrayData = new Object[][]{{emailId, emailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name="loginWithInvalidEmailAndPassword")
    public static Object[][] getLoginWithInvalidEmailAndPassword(){
        String emailInvalid1 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE1", "Auditor");
        String password = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String emailInvalid2 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE2", "Auditor");
        String emailInvalid3 = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "INVALID VALUE3", "Auditor");
        String emailNotExists = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "NOT EXIST", "Auditor");


        Object[][] arrayData = new Object[][]{{emailInvalid1, emailInvalid2, emailInvalid3, emailNotExists, password}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailInvalid1, emailInvalid2, emailInvalid3, emailNotExists, password}};
        }
        return  arrayData;
    }

    @DataProvider(name="forgotPasswordWithInvalidValue")
    public static Object[][] getForgotPasswordWithInvalidValue(){
        emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
        int maxLength = 7;
        boolean isContainsUpperCase = true;
        boolean isContainsLowerCase = true;
        boolean isContainsDigit = true;
        boolean isContainsLowerSpecialCharacter = true;
        String ranPasswordHas7Character =  GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                                                                                isContainsLowerSpecialCharacter) ;//"Aa@1231";
        maxLength = 8;
        isContainsUpperCase = false;
        String ranPasswordNotContainsUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                                                                                isContainsLowerSpecialCharacter);//"aa@1234a";
        isContainsUpperCase = true;
        isContainsLowerCase = false;
        String ranPasswordNotContainsLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                                                                                isContainsLowerSpecialCharacter);//"AA@1234A";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = false;
        String ranPasswordNotContainsDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                                                                                isContainsLowerSpecialCharacter);//"AA@!aabb";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordNotContainsSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                                                                               isContainsLowerSpecialCharacter);//"AAbbcc11";

        isContainsDigit = false;
        String ranPasswordContainsUpperLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                    isContainsDigit, isContainsLowerSpecialCharacter);//"AAbbccBB";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainsUpperCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                    isContainsDigit, isContainsLowerSpecialCharacter);//"AABB11111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsUpperCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                     isContainsDigit, isContainsLowerSpecialCharacter);//"AABB@!@!";

        isContainsUpperCase = false;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordContainsLowerCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                   isContainsDigit, isContainsLowerSpecialCharacter);//"aabb1111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsLowerCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                     isContainsDigit, isContainsLowerSpecialCharacter);//"aabb@@@@";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainDigitSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                                    isContainsDigit, isContainsLowerSpecialCharacter);//"2123@@@@";

        isContainsUpperCase = true;
        isContainsLowerCase = false;
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordOnlyUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                         isContainsDigit, isContainsLowerSpecialCharacter);//"AAAAAAAA";
        isContainsUpperCase = false;
        isContainsLowerCase = true;
        String ranPasswordOnlyLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                          isContainsDigit, isContainsLowerSpecialCharacter);//"aaaaaaaa";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordOnlyDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                     isContainsDigit, isContainsLowerSpecialCharacter);//"12345678";
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordOnlySpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                                                                     isContainsDigit, isContainsLowerSpecialCharacter);//"@@!!##$$";

        Object[][] arrayData = new Object[][]{{emailId, emailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                    ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                    ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                    ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                    ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        }
        return  arrayData;
    }

    @DataProvider(name="forgotPasswordWithRetypePasswordNotMatchTest")
    public static Object[][] getForgotPasswordWithRetypePasswordNotMatchTest(){
        emailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("ForgotPassword","AUDITOR_EMAIL_PASSWORD","VALID VALUE");
        String ranPassword = GenericService.genResetPassword(8, true, true, true, true);
        String ranReNewPassword = GenericService.genPassword(7, true, true, true);

        Object[][] arrayData = new Object[][]{{emailId, emailPassword, ranPassword, ranReNewPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{emailId, emailPassword, ranPassword, ranReNewPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyAdminResetPassword")
    public static Object[][] getVerifyAdminResetPassword(){
        adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Admin Auvenir Password");
        String adminEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Email Password");

        Object[][] arrayData = new Object[][]{{adminId, adminPassword, adminEmailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, adminPassword, adminEmailPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyAdminResetPasswordInvalidValue")
    public static Object[][] getVerifyAdminResetPasswordInvalidValue(){
        adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
        String adminEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Email Password");

        int maxLength = 7;
        boolean isContainsUpperCase = true;
        boolean isContainsLowerCase = true;
        boolean isContainsDigit = true;
        boolean isContainsLowerSpecialCharacter = true;
        String ranPasswordHas7Character =  GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter) ;//"Aa@1231";
        maxLength = 8;
        isContainsUpperCase = false;
        String ranPasswordNotContainsUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"aa@1234a";
        isContainsUpperCase = true;
        isContainsLowerCase = false;
        String ranPasswordNotContainsLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@1234A";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = false;
        String ranPasswordNotContainsDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@!aabb";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordNotContainsSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AAbbcc11";

        isContainsDigit = false;
        String ranPasswordContainsUpperLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAbbccBB";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainsUpperCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB11111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsUpperCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB@!@!";

        isContainsUpperCase = false;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordContainsLowerCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb1111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsLowerCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb@@@@";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainDigitSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"2123@@@@";

        isContainsUpperCase = true;
        isContainsLowerCase = false;
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordOnlyUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAAAAAAA";
        isContainsUpperCase = false;
        isContainsLowerCase = true;
        String ranPasswordOnlyLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aaaaaaaa";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordOnlyDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"12345678";
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordOnlySpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"@@!!##$$";


        Object[][] arrayData = new Object[][]{{adminId, adminEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, adminEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                    ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                    ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                    ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                    ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyAdminResetPasswordNotMatch")
    public static Object[][] getVerifyAdminResetPasswordNotMatch(){
        adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
        String adminEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Email Password");
        String ranPassword = GenericService.genResetPassword(8, true, true, true, true);
        String ranReNewPassword = GenericService.genPassword(7, true, true, true);

        Object[][] arrayData = new Object[][]{{adminId, adminEmailPassword, ranPassword, ranReNewPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{adminId, adminEmailPassword, ranPassword, ranReNewPassword}};
        }
        return  arrayData;
    }


    @DataProvider(name = "verifyAuditorResetPassword")
    public static Object[][] getVerifyAuditorResetPassword(){
        auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User2", "Auditor");
        String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        //String auditorEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Email Password");
        String auditorEmailPassword = "Changeit@123";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, auditorEmailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorPassword, auditorEmailPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyAuditorResetPasswordInValidValue")
    public static Object[][] getverifyAuditorResetPasswordInValidValue(){
        auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User2", "Auditor");
        //String auditorEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Email Password");
        String auditorEmailPassword = "Changeit@123";
        int maxLength = 7;
        boolean isContainsUpperCase = true;
        boolean isContainsLowerCase = true;
        boolean isContainsDigit = true;
        boolean isContainsLowerSpecialCharacter = true;
        String ranPasswordHas7Character =  GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter) ;//"Aa@1231";
        maxLength = 8;
        isContainsUpperCase = false;
        String ranPasswordNotContainsUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"aa@1234a";
        isContainsUpperCase = true;
        isContainsLowerCase = false;
        String ranPasswordNotContainsLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@1234A";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = false;
        String ranPasswordNotContainsDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@!aabb";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordNotContainsSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AAbbcc11";

        isContainsDigit = false;
        String ranPasswordContainsUpperLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAbbccBB";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainsUpperCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB11111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsUpperCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB@!@!";

        isContainsUpperCase = false;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordContainsLowerCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb1111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsLowerCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb@@@@";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainDigitSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"2123@@@@";

        isContainsUpperCase = true;
        isContainsLowerCase = false;
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordOnlyUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAAAAAAA";
        isContainsUpperCase = false;
        isContainsLowerCase = true;
        String ranPasswordOnlyLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aaaaaaaa";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordOnlyDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"12345678";
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordOnlySpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"@@!!##$$";

        Object[][] arrayData = new Object[][]{{auditorId, auditorEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                    ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                    ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                    ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                    ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyAuditorResetPasswordNotMatch")
    public static Object[][] getVerifyAuditorResetPasswordNotMatch(){
        auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User2", "Auditor");
        //String auditorEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Email Password");
        String auditorEmailPassword = "Changeit@123";
        String ranPassword = GenericService.genResetPassword(8, true, true, true, true);
        String ranReNewPassword = GenericService.genPassword(7, true, true, true);

        Object[][] arrayData = new Object[][]{{auditorId, auditorEmailPassword, ranPassword, ranReNewPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId, auditorEmailPassword, ranPassword, ranReNewPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyClientResetPassword")
    public static Object[][] getVerifyClientResetPassword(){
        clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
        String clientPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");


        Object[][] arrayData = new Object[][]{{clientId, clientPassword, clientEmailPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientPassword, clientEmailPassword}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyClientResetPasswordInValidValue")
    public static Object[][] getVerifyClientResetPasswordInValidValue(){
        clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");

        int maxLength = 7;
        boolean isContainsUpperCase = true;
        boolean isContainsLowerCase = true;
        boolean isContainsDigit = true;
        boolean isContainsLowerSpecialCharacter = true;
        String ranPasswordHas7Character =  GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter) ;//"Aa@1231";
        maxLength = 8;
        isContainsUpperCase = false;
        String ranPasswordNotContainsUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"aa@1234a";
        isContainsUpperCase = true;
        isContainsLowerCase = false;
        String ranPasswordNotContainsLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@1234A";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = false;
        String ranPasswordNotContainsDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AA@!aabb";
        isContainsUpperCase = true;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordNotContainsSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase, isContainsDigit,
                isContainsLowerSpecialCharacter);//"AAbbcc11";

        isContainsDigit = false;
        String ranPasswordContainsUpperLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAbbccBB";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainsUpperCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB11111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsUpperCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AABB@!@!";

        isContainsUpperCase = false;
        isContainsLowerCase = true;
        isContainsDigit = true;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordContainsLowerCaseDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb1111";

        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordContainsLowerCaseSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aabb@@@@";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordContainDigitSpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"2123@@@@";

        isContainsUpperCase = true;
        isContainsLowerCase = false;
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = false;
        String ranPasswordOnlyUpperCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"AAAAAAAA";
        isContainsUpperCase = false;
        isContainsLowerCase = true;
        String ranPasswordOnlyLowerCase = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"aaaaaaaa";

        isContainsLowerCase = false;
        isContainsDigit = true;
        String ranPasswordOnlyDigit = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"12345678";
        isContainsDigit = false;
        isContainsLowerSpecialCharacter = true;
        String ranPasswordOnlySpecial = GenericService.genResetPassword(maxLength,isContainsUpperCase, isContainsLowerCase,
                isContainsDigit, isContainsLowerSpecialCharacter);//"@@!!##$$";

        Object[][] arrayData = new Object[][]{{clientId, clientEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientEmailPassword, ranPasswordHas7Character, ranPasswordNotContainsUpperCase,
                    ranPasswordNotContainsLowerCase, ranPasswordNotContainsDigit, ranPasswordNotContainsSpecial,
                    ranPasswordContainsUpperLowerCase, ranPasswordContainsUpperCaseDigit, ranPasswordContainsUpperCaseSpecial,
                    ranPasswordContainsLowerCaseDigit, ranPasswordContainsLowerCaseSpecial, ranPasswordContainDigitSpecial,
                    ranPasswordOnlyUpperCase, ranPasswordOnlyLowerCase, ranPasswordOnlyDigit, ranPasswordOnlySpecial}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyClientResetPasswordNotMatch")
    public static Object[][] getVerifyClientResetPasswordNotMatch(){
        clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client Email Password");
        String ranPassword = GenericService.genResetPassword(8, true, true, true, true);
        String ranReNewPassword = GenericService.genPassword(7, true, true, true);

        Object[][] arrayData = new Object[][]{{clientId, clientEmailPassword, ranPassword, ranReNewPassword}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientId, clientEmailPassword, ranPassword, ranReNewPassword}};
        }
        return  arrayData;
    }
}
