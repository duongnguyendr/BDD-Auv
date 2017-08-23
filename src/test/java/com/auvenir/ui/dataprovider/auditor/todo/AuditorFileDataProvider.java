package com.auvenir.ui.dataprovider.auditor.todo;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/21/2017.
 */
public class AuditorFileDataProvider {
    protected static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    protected static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
    protected static String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
    protected static String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
    protected static String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
    protected static String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();

    @DataProvider(name ="verifyDownloadAttachmentsDisable")
    public static Object[][] getVerifyDownloadAttachmentsDisable(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01}};
        }
        return  arrayData;
    }
}
