package com.auvenir.ui.dataprovider.auditor.todo;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/21/2017.
 */
public class AuditorCommentDataProvider {
    //Data login of Auditor User. Not use for modified testing user.
    protected static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    protected static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
    protected static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

    @DataProvider(name = "verifyToDoDetailsCommenting")
    public static Object[][] getVerifyToDoDetailsCommenting(){

        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String inputComment = "commentTest";
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName, inputComment}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName, inputComment}};
        }
        return  arrayData;
    }
}
