package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
import com.auvenir.ui.bdd.pages.common.GetTable;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class TodoStepDefinition extends BaseInit {
    private  BaseInit baseInit;
    AuditorTodoPage auditorTodoPage;
    TodoPage todoPage;
    GetTable getTable;
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
    @Then("^I verify Client Assignee Selected$")
    public void verifyClientAssigneeSelected(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I verify Auditor Assignee Selected =====");

        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);
        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Client name is: "+lisTodoAnduser.userName);
            System.out.println("The To-Do name is: "+lisTodoAnduser.todoName);
            todoPage.verifyClientAssigneeSelected(lisTodoAnduser.todoName,lisTodoAnduser.userName);
        }
    }

    @Then("^I create To-Do with name and category$")
    public void CreateToDoWithNameAndCategory(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I create To-Do with name and category =====");
//         getTable = new GetTable("ToDoname","category");
        List<GetTable> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(GetTable.class);
        for (GetTable lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Client name is: "+lisTodoAnduser.getColumn0());
            System.out.println("The Catalog: "+lisTodoAnduser.getColumn1());
            todoPage.verifyClientAssigneeSelected(lisTodoAnduser.getColumn0(),lisTodoAnduser.getColumn1());

        }
    }
}
