package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import javax.enterprise.inject.New;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class TodoStepDefinition extends BaseInit {
    private  BaseInit baseInit;
    AuditorTodoPage auditorTodoPage;
    TodoPage todoPage;
    public TodoStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorTodoPage = new AuditorTodoPage(logger,driver);
        todoPage = new TodoPage(logger,driver);
    }



    public class LisTodoAnduser{
        public String userName;
        public String todoName;
        public LisTodoAnduser (String userBeAssign, String LisTodoAnduser ){
            userName = userBeAssign;
            todoName = LisTodoAnduser;
        }
    }

    public class ListNewRequest{
        public String newRequestName;
        public ListNewRequest(String newRequestName){
            this.newRequestName = newRequestName;
        }
    }
    @Then("^I assignee list To-Do to Auditor$")
    public void assigneelistToDotoAuditor(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I assignee list To-Do to General Auditor =====");



        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);
        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Auditor name is: "+lisTodoAnduser.userName);
            System.out.println("The To-Do name is: "+lisTodoAnduser.todoName);
            auditorTodoPage.selectAuditorAssigneeByName(lisTodoAnduser.todoName, lisTodoAnduser.userName);
        }
    }
    @Then("^I verify Auditor Assignee Selected$")
    public void verifyAuditorAssigneeSelected(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I verify Auditor Assignee Selected =====");

        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);
        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Auditor name is: "+lisTodoAnduser.userName);
            System.out.println("The To-Do name is: "+lisTodoAnduser.todoName);
            auditorTodoPage.verifyAuditorAssigneeSelected(lisTodoAnduser.todoName,lisTodoAnduser.userName);
        }
    }
    @Then("^I assignee list To-Do to Client")
    public void assigneelistToDotoClient(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I assignee list To-Do to General Auditor =====");



        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);
        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Client name is: "+lisTodoAnduser.userName);
            System.out.println("The To-Do name is: "+lisTodoAnduser.todoName);
            todoPage.selectClientAssigneeByName(lisTodoAnduser.todoName,lisTodoAnduser.userName);
        }
    }

    @And("^I click slide out menu on selected To-do: \"([^\"]*)\"$")
    public void iClickSlideOutMenuOnSelectedToDo(String todoName) throws Throwable {
        getLogger().info("===== I click slide out panel on selected To-do =====");
        auditorTodoPage.clickSlideOutMenuOnTodo(todoName);
    }


    @Then("^I should see the Todo detail opened$")
    public void verifyTodoDetailOpened() throws Throwable {
        getLogger().info("===== I should see the Todo detail opened =====");
        auditorTodoPage.verifyTodoDetailOpened();
    }

    @And("^I creates some new requests$")
    public void createsSomeNewRequests(DataTable table) throws Throwable {
        getLogger().info("===== I creates some new Request name =====");
        List<ListNewRequest> listNewRequests = new ArrayList<>();
        listNewRequests = table.asList(ListNewRequest.class);
        for (ListNewRequest listNewRequest: listNewRequests){
            System.out.println("Prepare to create: "+listNewRequest.newRequestName);
//            auditorTodoPage.clickElement();
//            auditorTodoPage.createNewRequest(listNewRequest.newRequestName);
        }

    }

}
