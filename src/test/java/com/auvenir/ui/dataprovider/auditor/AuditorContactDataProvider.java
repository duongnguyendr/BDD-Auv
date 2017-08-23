package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/12/2017.
 */
public class AuditorContactDataProvider {
    public static final String FRENCH_LANGUAGE = "French";
    public static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor");
    public static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
    public static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Engagement Name");

    @DataProvider(name = "verifyGUIAuditorContactsPage")
    public static Object[][] getVerifyGUIAuditorContactsPage(){
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyEngagementLinkInAuditorContactsPage")
    public static Object[][] getVerifyEngagementLinkInAuditorContactsPage(){
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyGUIDataTableAuditorContactsPage")
    public static Object[][] getVerifyGUIDataTableAuditorContactsPage(){
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return arrayData;
    }

    @DataProvider(name = "verifyFooterAuditorContactsPage")
    public static Object[][] getVerifyFooterAuditorContactsPage(){
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equals(FRENCH_LANGUAGE)){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return arrayData;
    }


}
