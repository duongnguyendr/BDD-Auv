package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class GeneralAuditorService extends AbstractService {
    private AuditorToDoPage auditorToDoPage;

    public GeneralAuditorService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorToDoPage = new AuditorToDoPage(getLogger(), getDriver());
    }

    public void verifyGeneralAuditorCanChangeRequestNameBeAssigned(String oldRequestName, String newRequestName) {
        auditorToDoPage.verifyEditRequestNameCapability(oldRequestName, newRequestName, true);
    }

    public void verifyGeneralAuditorCanNotAssignTodoToAuditor(List<String> listTodo) {
        auditorToDoPage.verifyGroupPermissionCannotAssignTodoToAuditor(listTodo, true);
    }

    public void verifyGeneralAuditorCannotAssignToDoToGeneralClient(List<String> listTodo, String clientFullName) {
        auditorToDoPage.verifyGroupPermissionCannotAssignTodoToClient(listTodo, clientFullName, true);
    }

    public void verifyGeneralAuditorCanDeleteRequestBeAssigned(String requestName) {
        auditorToDoPage.verifyRequestDeletionCapability(requestName, true);
    }

    public void verifyGeneralAuditorCannotCommentOnTodoNotAssignedTo(String todoName, String comment) {
        auditorToDoPage.verifyGroupPermissionCanAddComment(todoName, comment, false, false, true);
    }

    public void verifyGeneralAuditorCanSeeAllFileWithinToDo(List<String> listFile) {
        auditorToDoPage.verifyCanSeeAllFileWithinToDo(listFile);
    }

    public void verifyGeneralAuditorCanEditCategoryBeAssigned(String todoName, String oldCategoryName, String newCategoryName) {
        auditorToDoPage.verifyCategoryEditableCapability(todoName,oldCategoryName,newCategoryName,true);
    }

    public void verifyGeneralAuditorCanChangeDueDateBeAssigned(String todoName, String month, String day, String year) {
        auditorToDoPage.verifyDueDateEditableCapability(todoName,month,day,year,true);
    }
}
