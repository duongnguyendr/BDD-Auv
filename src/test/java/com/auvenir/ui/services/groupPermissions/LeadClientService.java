package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class LeadClientService extends AbstractService {

    ClientToDoPage clientToDoPage;

    public LeadClientService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientToDoPage = new ClientToDoPage(getLogger(), getDriver());
    }

    public void verifyLeadClientCanNotChangeRequestName(String requequestName, String newRequestName) {
        clientToDoPage.verifyEditRequestNameCapability(requequestName, newRequestName, false);
    }

    public void verifyLeadClientCanNotDeleteRequest(String requestName) {
        clientToDoPage.verifyRequestDeletionCapability(requestName, false);
    }


    public void verifyLeadClientCannotCreateTodo() {
        clientToDoPage.verifyGroupPermissionCannotCreateTodo();
    }

    public void verifyLeadClientCannotAssignToDoToAuditor(List<String> listTodo) {
        clientToDoPage.verifyGroupPermissionCannotAssignTodoToAuditor(listTodo, false);
    }

    public void verifyLeadClientCanSeeAllFileWithinToDo(List<String> listFile) {
        clientToDoPage.verifyCanSeeAllFileWithinToDo(listFile);
    }

    public void verifyLeadClientCanCommentOnTodoNotAssignTo(String todoName, String comment) {
        clientToDoPage.verifyGroupPermissionCanAddComment(todoName, comment, true, true, false);
    }

    public void verifyLeadClientCanNotEditCategory(String todoName, String oldCategoryName, String newCategoryName) {
        clientToDoPage.verifyCategoryEditableCapability(todoName,oldCategoryName,newCategoryName,false);
    }

    public void verifyLeadClientCanNotChangeDueDate(String todoName, String month, String day, String year) {
        clientToDoPage.verifyDueDateEditableCapability(todoName,month,day,year,false);
    }
}
