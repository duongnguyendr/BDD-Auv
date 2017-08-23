package com.auvenir.ui.services.groupPermissions;

import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by thuan.duong on 8/9/2017.
 */
public class AdminClientService extends AbstractService {
	ClientToDoPage clientTodoPage;

    AuditorToDoPage auditorToDoPage;
    public AdminClientService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorToDoPage = new AuditorToDoPage(getLogger(),getDriver());
        clientTodoPage = new ClientToDoPage(getLogger(), getDriver());
    }

    public void verifyAdminClientCanSeeAllFileWithinToDo(List<String> listFile) {
        auditorToDoPage.verifyCanSeeAllFileWithinToDo(listFile);
    }
    
    public void verifyAdminClientCannotCreateTodo(){
    	clientTodoPage.verifyGroupPermissionCannotCreateTodo();
    }
    
    public void verifyAdminClientCannotMarkTodoCompleted(List<String> listTodo){
    	clientTodoPage.verifyGroupPermissionCannotMarkCompleted(listTodo);
    }
    
    public void verifyAdminClientCannotAssignTodoToAuditor(List<String> listTodo){
    	clientTodoPage.verifyGroupPermissionCannotAssignTodoToAuditor(listTodo, false);
    }
    
    public void verifyAdminClientCannotAssignTodoToLeadClient(List<String> listTodo, String clientFullName){
    	clientTodoPage.verifyGroupPermissionCannotAssignTodoToClient(listTodo, clientFullName, false);
    }
    
    public void verifyAdminClientCannotCommentOnTodoNotAssign(String todoName, String comment){
    	clientTodoPage.verifyGroupPermissionCanAddComment(todoName, comment, false, true, false);
    }
}
