package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.KeyWord;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import com.google.common.collect.Table;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import static com.auvenir.ui.bdd.common.GeneralUtilities.getTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class TodoStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoStepDefinition.class.getSimpleName());
    private  BaseInit baseInit;
    AuditorTodoPage auditorTodoPage;
    TodoPage todoPage;
    KeyWord keyWord;
    public TodoStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorTodoPage = new AuditorTodoPage(logger,driver);
        todoPage = new TodoPage(logger,driver);
    }

    @And("^I select todo: \"([^\"]*)\" check box on todo page$")
    public void iSelectTodoCheckBoxOnTodoPage(String todoName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.selectToDoCheckboxByName(todoName);
    }

    @And("^I click bulk action drop down on todo page$")
    public void iClickBulkActionDropDownOnTodoPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.clickBulkActionsDropdown();
    }

    @And("^I click mark complete button on bulk action$")
    public void iClickMarkCompleteButtonOnBulkAction() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.clickToBulkCompleteButton();
    }

    @Then("^I should see mark completed todo popup$")
    public void iShouldSeeMarkCompletedTodoPopUp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.verifyPopUpMarkCompletedDisplay();
    }

    @And("^I click on archive button on complete todo popup$")
    public void iClickOnArchiveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.clickOnArchiveButtonInMarkAsCompletePopup();
    }

    @Then("^I should see todo: \"([^\"]*)\" mark completed on todo page$")
    public void iShouldSeeTodoMarkCompletedOnTodoPage(String todoName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.verifyTodoMarkCompleted(todoName);
    }

    @And("^I click delete button on bulk action$")
    public void iClickDeleteButtonOnBulkAction() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.clickOptionDeleteOnBulkActionsDropDown();
    }

    @Then("^I should see delete todo popup$")
    public void iShouldSeeDeleteTodoPopup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.verifyPopUpDeleteTodoDisplay();
    }

    @And("^I click on confirm delete button on delete todo popup$")
    public void iClickOnConfirmDeleteButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.clickConfirmDeleteButton();
    }

    @Then("^I should see todo: \"([^\"]*)\" not existed in todo list$")
    public void iShouldSeeTodoNotExisted(String todoName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.verifyToDoNotExist(todoName);
    }

//    @And("^I click assignee to client on bulk action drop down: \"([^\"]*)\"$")
//    public void iClickAssigneeToClient(String clientFullName) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        logger.info("I click assignee to client on bulk action drop down: " + clientFullName);
//        todoPage.chooseBulkActionAssignee(clientFullName);
//    }
//
//    @And("^I click assignee to auditor on bulk action drop down: \"([^\"]*)\"$")
//    public void iClickAssigneeToAuditor(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    @And("^I click assignee to :\"([^\"]*)\" on bulk action drop down$")
    public void iClickAssigneeToOnBulkActionDropDown(String fullName) throws Throwable {
        logger.info("I click assignee to :" + fullName + " on bulk action drop down");
        todoPage.chooseBulkActionAssignee(fullName);
    }

    @And("^I click check box all todo on todo page$")
    public void iClickCheckBoxAllTodo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.checkOrUnCheckCheckAllCheckBox(true);
    }

    @And("^I click download attachments on bulk action$")
    public void iClickDownloadAttachments() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click download attachments on bulk action.");
        todoPage.clickToBulkDownloadAttachmentButton();
    }

    @Then("^I should see popup download attachments on todo page$")
    public void iShouldSeePopupDownloadAttachments() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I should see popup download attachments on todo page.");
        todoPage.verifyPopUpDownloadAttachmentsDisplay();
    }

    @And("^I click download button on attachment download popup$")
    public void iClickDownloadButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("I click download button on attachment download popup.");
        todoPage.clickDownloadAllTodo();
    }

    @Then("^I verify file \"([^\"]*)\" existed in computer$")
    public void iVerifyFileExistedInComputer(String fileName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todoPage.verifyFileDownloadSuccessful(fileName);
    }

    @And("^I select todo: \"([^\"]*)\" check box on Uneditable To-do page$")
    public void selectTodoCheckBoxOnUneditableToDoPage(String todoName) throws Throwable {
      todoPage.selectUnEditableToDoCheckboxByName(todoName);
    }

    public class LisTodoAnduser{
        public String userName;
        public String todoName;
        public LisTodoAnduser (String userBeAssign, String LisTodoAnduser ){
            userName = userBeAssign;
            todoName = LisTodoAnduser;
        }
    }

    public class ListNewRequest {
        public String newRequestName;

        public ListNewRequest(String newRequestName) {
            this.newRequestName = newRequestName;
        }
    }

    public class ListFilesOnListRequests {
        public String fileName;
        public String requestName;
        public ListFilesOnListRequests(String fileName, String requestName) {
            this.fileName = fileName;
            this.requestName = requestName;
        }
    }

    @Then("^I assignee list To-Do to Auditor$")
    public void assigneelistToDotoAuditor(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I assignee list To-Do to General Auditor =====");
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
        logger.info("===== I verify Auditor Assignee Selected =====");

        List<LisTodoAnduser> lisTodoAndusers = new ArrayList<>();
        lisTodoAndusers = table.asList(LisTodoAnduser.class);

        for (LisTodoAnduser lisTodoAnduser: lisTodoAndusers){
            System.out.println("The Auditor name is: "+lisTodoAnduser.userName);
            System.out.println("The To-Do name is: "+lisTodoAnduser.todoName);
            auditorTodoPage.verifyAuditorAssigneeSelected(lisTodoAnduser.todoName,lisTodoAnduser.userName);
        }
    }
    @Then("^I assignee list To-Do to Client")
    public void verifyAssigneeListToDotoClient(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I assignee list To-Do to Lead Client =====");


         List<List<String>>listToDoAndUserClient =getTable(table);
        for (int i =1;i<listToDoAndUserClient.size();i++){
            System.out.println("The Client name is: "+listToDoAndUserClient.get(i).get(0));
            System.out.println("The To-Do name is: "+listToDoAndUserClient.get(i).get(1));
            todoPage.selectClientAssigneeByName(listToDoAndUserClient.get(i).get(1),listToDoAndUserClient.get(i).get(0));
        }
    }
    @Then("^I verify Client Assignee Selected$")
    public void verifyClientAssigneeSelected(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I verify Auditor Assignee Selected =====");

        List<List<String>>listToDoAndUserClient =getTable(table);
        for (int i =1;i<listToDoAndUserClient.size();i++){
            System.out.println("The Client name is: "+listToDoAndUserClient.get(i).get(0));
            System.out.println("The To-Do name is: "+listToDoAndUserClient.get(i).get(1));
            todoPage.verifyClientAssigneeSelected(listToDoAndUserClient.get(i).get(1),listToDoAndUserClient.get(i).get(0));
        }
    }

    @Then("^I create To-Do with name and category$")
    public void CreateToDoWithNameAndCategory(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I create To-Do with name and category =====");

        List<List<String>> toDonameAndategory  = getTable(table);
        for (int i = 1; i < toDonameAndategory.size() ; i++) {
            System.out.println("The Client name is: "+toDonameAndategory.get(i).get(0));
            System.out.println("The Catalog: "+toDonameAndategory.get(i).get(1));
            auditorTodoPage.createToDoTaskWithCategoryName(toDonameAndategory.get(i).get(0),toDonameAndategory.get(i).get(1));

        }
    }
    @And("^I click slide out menu on selected To-do: \"([^\"]*)\"$")
    public void iClickSlideOutMenuOnSelectedToDo(String todoName) throws Throwable {
        logger.info("===== I click slide out panel on selected To-do =====");
        auditorTodoPage.clickSlideOutMenuOnTodo(todoName);
    }


    @Then("^I should see the Todo detail opened$")
    public void verifyTodoDetailOpened() throws Throwable {
        logger.info("===== I should see the Todo detail opened =====");
        auditorTodoPage.verifyTodoDetailOpened();
    }

    @And("^I creates some new requests$")
    public void createsSomeNewRequests(DataTable table) throws Throwable {
        logger.info("===== I creates some new Request name =====");
        List<ListNewRequest> listNewRequests = new ArrayList<>();
        listNewRequests = table.asList(ListNewRequest.class);
        for (ListNewRequest listNewRequest: listNewRequests){
            System.out.println("Prepare to create: "+listNewRequest.newRequestName);
            auditorTodoPage.selectAddNewRequest();
            auditorTodoPage.createNewRequest(listNewRequest.newRequestName);
        }
    }

//    "([^"]*)"
    @And("^I uploads list files on list requests$")
    public void uploadListFilesOnRequest(DataTable table) throws Throwable {
        logger.info("===== I uploads list files on request =====");
        List<ListFilesOnListRequests> listFilesOnListRequests = new ArrayList<>();
        listFilesOnListRequests = table.asList(ListFilesOnListRequests.class);
        for (ListFilesOnListRequests fileOnRequest : listFilesOnListRequests) {
            System.out.println("File Name: " + fileOnRequest.fileName + "--Request: " + fileOnRequest.requestName);
            todoPage.uploadFileOnRequestByName(fileOnRequest.fileName, fileOnRequest.requestName);
        }
    }
    @Then("^I verify Client Assignee Selected on Uneditabe Page$")
    public void verifyClientAssigneeSelectedOnUneditabePage(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I verify Auditor Assignee Selected =====");

        List<List<String>> listToDoAndUserClient = getTable(table);
        for (int i = 1; i < listToDoAndUserClient.size(); i++) {
            System.out.println("The Client name is: " + listToDoAndUserClient.get(i).get(0));
            System.out.println("The To-Do name is: " + listToDoAndUserClient.get(i).get(1));
            todoPage.verifyClientAssigneeSelectedOnUneditablePage(listToDoAndUserClient.get(i).get(1), listToDoAndUserClient.get(i).get(0));
        }
    }

    @Then("^I should see all to do assigned : (.*)")
    public void iShouldSeeAllToDoAssigned(List<String> toDoList) throws Throwable {
        logger.info("=====I should see all to do assigned=====");
        todoPage.verifyUserSeeToDo(toDoList);
    }
}
