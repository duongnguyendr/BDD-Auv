package com.auvenir.ui.dataprovider.marketing;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/20/2017.
 */
public class MailAccessDataProvider extends CommonDataProvider {

    public static final String FRENCH_LANGUAGE = "French";
    private static String auditorID = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User3", "Auditor");
    private static String password = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
    private static String strAdminEmail = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
    private static String strAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin Auvenir Password");
    private static String clientID = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");

    @DataProvider(name = "verifyAdminGiveAuditorAccess")
    public static Object[][] getVerifyAdminGiveAuditorAccess(){
        Object[][] arrayData = new Object[][]{{auditorID, password,strAdminEmail, strAdminPwd}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, password,strAdminEmail, strAdminPwd}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyActiveEmailTemplate")
    public static Object[][] getVerifyActiveEmailTemplate(){
        Object[][] arrayData = new Object[][]{{auditorID, password}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, password}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorSignUp")
    public static Object[][] getVerifyAuditorSignUp(){
        String auditorFullName = "Auditor Test";
        Object[][] arrayData = new Object[][]{{auditorID, clientID, password, auditorFullName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, clientID, password, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyAuditorInviteClient")
    public static Object[][] getVerifyAuditorInviteClient(){
        String engagementName = "New World";
        String engagementType = "";
        String companyName = "Company";
        String fullNameClient = "Titan client";
        String roleName = "Leader";
        String engagementMessage = "Your engagement invitation has been sent.";
        Object[][] arrayData = new Object[][]{{auditorID, clientID, password,
                                               engagementName, engagementType, companyName, fullNameClient, roleName, engagementMessage}};

        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, clientID, password,
                    engagementName, engagementType, companyName, fullNameClient, roleName, engagementMessage}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyClientInviteEmailTemplate")
    public static Object[][] getVerifyClientInviteEmailTemplate(){
        Object[][] arrayData = new Object[][]{{clientID, password}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{clientID, password}};
        }
        return arrayData;
    }

    @DataProvider(name = "openGMailForAuditorRegister")
    public static Object[][] getOpenGMailForAuditorRegister(){
        String auditorFullName = "Auditor Test";
        Object[][] arrayData = new Object[][]{{auditorID, password, auditorFullName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, password, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyMailAuditorJoin")
    public static Object[][] getVerifyMailAuditorJoin(){
        String auditorFullName = "Auditor Test";
        Object[][] arrayData = new Object[][]{{auditorID, password, auditorFullName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, password, auditorFullName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyNotificationMailAuditorInvite")
    public static Object[][] getVerifyNotificationMailAuditorInvite(){
        String engagementName = "Engagement-Test";
        String fullNameClient = "Titan client";
        String roleName = "Leader";
        String engagementMessage = "Your engagement invitation has been sent.";
        Object[][] arrayData = new Object[][]{{auditorID, password, clientID, engagementName, fullNameClient, roleName, engagementMessage}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorID, password, clientID, engagementName, fullNameClient, roleName, engagementMessage}};
        }
        return arrayData;
    }

}
