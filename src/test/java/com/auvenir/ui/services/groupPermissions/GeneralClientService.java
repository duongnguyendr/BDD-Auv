package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class GeneralClientService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */
    ClientToDoPage clientToDoPage;
    public GeneralClientService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientToDoPage = new ClientToDoPage(getLogger(),getDriver());
    }

    public void verifyGeneralClientCanNotChangeRequestName(String requequestName, String newRequestName) {
        clientToDoPage.verifyEditRequestNameCapability(requequestName,newRequestName,false);
    }

    public void verifyGeneralClientCanNotDeleteRequest(String requestName) {
        clientToDoPage.verifyRequestDeletionCapability(requestName,false);
    }

    public void verifyGeneralClientCanSeeAllFileWithinToDo(List<String> listFile) {
        clientToDoPage.verifyCanSeeAllFileWithinToDo(listFile);
    }

    public void verifyGeneralClientCanNotEditCategory(String todoName, String oldCategoryName, String newCategoryName) {
        clientToDoPage.verifyCategoryEditableCapability(todoName,oldCategoryName,newCategoryName,false);
    }

    public void verifyGeneralClientCanNotChangeDueDate(String todoName, String month, String day, String year) {
        clientToDoPage.verifyDueDateEditableCapability(todoName,month,day,year,false);
    }
    
    public void verifyGeneralClientCannotCreateTodo(){
    	clientToDoPage.verifyGroupPermissionCannotCreateTodo();
    }
    
    public void verifyGeneralClientCannotRemoveTodo(List<String> listTodo){
    	clientToDoPage.verifyGroupPermissionCannotRemoveTodo(listTodo);
    }
    
    public void verifyGeneralClientCannotMarkTodoCompleted(List<String> listTodo){
    	clientToDoPage.verifyGroupPermissionCannotMarkCompleted(listTodo);
    }
    
    public void verifyGeneralClientCannotAssignTodoToAuditor(List<String> listTodo){
    	clientToDoPage.verifyGroupPermissionCannotAssignTodoToAuditor(listTodo, false);
    }
    
    public void verifyGeneralClientCannotAssignTodoToClient(List<String> listTodo, String clientFullName){
    	clientToDoPage.verifyGroupPermissionCannotAssignTodoToClient(listTodo, clientFullName, false);
    }
}
