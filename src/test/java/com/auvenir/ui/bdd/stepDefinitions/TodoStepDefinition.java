package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
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
    public TodoStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorTodoPage = new AuditorTodoPage(logger,driver);
    }

    public class LisTodoAnduser{
        public String auditorName;
        public String todoName;
        public LisTodoAnduser (String userBeAssign, String LisTodoAnduser ){
            auditorName = userBeAssign;
            todoName = LisTodoAnduser;
        }
    }
    @Then("^I assignee list To-Do to General Auditor$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getLogger().info("===== I assignee list To-Do to General Auditor =====");

        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);
        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Email is: "+lisTodoAnduser.auditorName);
            System.out.println("The Password is: "+lisTodoAnduser.todoName);
            auditorTodoPage.selectAuditorAssigneeByName(lisTodoAnduser.todoName, lisTodoAnduser.auditorName);
        }
    }
}
