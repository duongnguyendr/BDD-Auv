package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.KeyWord;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
import com.auvenir.ui.bdd.pages.common.TodoDetailsPage;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.auvenir.ui.bdd.common.GeneralUtilities.getList;
import static com.auvenir.ui.bdd.common.GeneralUtilities.getTable;

/**
 * Created by duong.nguyen on 9/13/2017.
 */
public class TodoStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    AuditorTodoPage auditorTodoPage;
    TodoDetailsPage todoDetailsPage;

    TodoPage todoPage;
    KeyWord keyWord;

    public TodoStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        auditorTodoPage = new AuditorTodoPage(logger, driver);
        todoPage = new TodoPage(logger, driver);
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
        todoPage.selectToDoCheckboxByName(todoName);
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
        List<List<String>> listTodoAndusers = getTable(table);
        String toDo;
        String user;

        for (List<String> listTodoAnduser : listTodoAndusers) {
           toDo=  listTodoAnduser.get(1);
            user= listTodoAnduser.get(0);
            auditorTodoPage.selectAuditorAssigneeByName(toDo, user);
        }
    }

    @Then("^I verify Auditor Assignee Selected$")
    public void verifyAuditorAssigneeSelected(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I verify Auditor Assignee Selected =====");
        String toDo;
        String user;
        List<List<String>> listTodoAndusers = getTable(table);

        for (List<String> listTodoAnduser : listTodoAndusers) {
            toDo=  listTodoAnduser.get(1);
            user= listTodoAnduser.get(0);
            auditorTodoPage.verifyAuditorAssigneeSelected(toDo,user);
        }
    }

    @And("^I assignee list To-Do to Client")
    public void verifyAssigneeListToDotoClient(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I assignee list To-Do to Lead Client =====");


        List<List<String>> listToDoAndUserClient = getTable(table);
        for (int i = 0; i < listToDoAndUserClient.size(); i++) {
            System.out.println("The Client name is: " + listToDoAndUserClient.get(i).get(0));
            System.out.println("The To-Do name is: " + listToDoAndUserClient.get(i).get(1));
            todoPage.selectClientAssigneeByName(listToDoAndUserClient.get(i).get(1),
                    listToDoAndUserClient.get(i).get(0));
        }
    }

    @Then("^I verify Client Assignee Selected$")
    public void verifyClientAssigneeSelected(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I verify Auditor Assignee Selected =====");

        List<List<String>> listToDoAndUserClient = getTable(table);
        for (int i = 0; i < listToDoAndUserClient.size(); i++) {
            System.out.println("The Client name is: " + listToDoAndUserClient.get(i).get(0));
            System.out.println("The To-Do name is: " + listToDoAndUserClient.get(i).get(1));
            todoPage.verifyClientAssigneeSelected(listToDoAndUserClient.get(i).get(1),
                    listToDoAndUserClient.get(i).get(0));
        }
    }

    @Then("^I create To-Do with name and category$")
    public void CreateToDoWithNameAndCategory(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("===== I create To-Do with name and category =====");

        List<List<String>> toDonameAndategory = getTable(table);
        for (int i = 0; i < toDonameAndategory.size(); i++) {
            System.out.println("The Client name is: " + toDonameAndategory.get(i).get(0));
            System.out.println("The Catalog: " + toDonameAndategory.get(i).get(1));
            auditorTodoPage.createToDoTaskWithCategoryName(toDonameAndategory.get(i).get(0), toDonameAndategory.get(i).get(1));

        }
    }

    @And("^I click slide out menu on selected To-do: \"([^\"]*)\"$")
    public void clickSlideOutMenuOnSelectedToDo(String todoName) throws Throwable {
        logger.info("===== I click slide out panel on selected To-do =====");
        todoPage.clickSlideOutMenuOnTodo(todoName);
    }


    @Then("^I should see the Todo detail opened$")
    public void verifyTodoDetailOpened() throws Throwable {
        logger.info("===== I should see the Todo detail opened =====");
        auditorTodoPage.verifyTodoDetailOpened();
    }

//    @Then("^I verify Client Assignee Selected on Uneditabe Page$")
//    public void verifyClientAssigneeSelectedOnUneditabePage(DataTable table) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        logger.info("===== I verify Auditor Assignee Selected =====");
//
//        List<List<String>> listToDoAndUserClient = getTable(table);
//        for (int i = 1; i < listToDoAndUserClient.size(); i++) {
//            System.out.println("The Client name is: " + listToDoAndUserClient.get(i).get(0));
//            System.out.println("The To-Do name is: " + listToDoAndUserClient.get(i).get(1));
//            todoPage.verifyClientAssigneeSelectedOnUneditablePage(listToDoAndUserClient.get(i).get(1),
//                    listToDoAndUserClient.get(i).get(0));
//        }
//    }

    @And("^I create requests from To-Do$")
    public void createRequestsFromToDo(DataTable table) throws Throwable {
        logger.info("===== I create requests from To-Do =====");
        Map<String, String> maptable = new HashMap<>();
        maptable = table.asMap(String.class, String.class);

        for (String toDo : maptable.keySet()) { // for To-Do to create request
            clickSlideOutMenuOnSelectedToDo(toDo);
            verifyTodoDetailOpened();
            String[] requestNames = maptable.get(toDo).split(",");
            for (String requestName : requestNames) {
                todoDetailsPage.selectAddNewRequest();
                todoDetailsPage.createNewRequest(requestName);
            }
            auditorTodoPage.closeAddNewRequestWindow();
        }
    }

    @Then("^I verify Auditor Create requests from To-Do: (.*)$")
    public void  verifyAuditorCreateRequestsFromToDo(List<String> listToDo, DataTable table) throws Throwable {
        logger.info("===== I verify Auditor Create requests from To-Do: =====");
        List<String> listRequestname = getList(table);

        for (String toDoName : listToDo) {
            clickSlideOutMenuOnSelectedToDo(toDoName);
            verifyTodoDetailOpened();
            auditorTodoPage.verifyRequestCreated(listRequestname);
        }

    }

    @Then("^I should see all to do assigned : (.*)")
    public void iShouldSeeAllToDoAssigned(List<String> toDoList) throws Throwable {
        logger.info("=====I should see all to do assigned=====");
        todoPage.verifyUserSeeToDo(toDoList);
    }

    @Then("^I should see all to do : (.*)")
    public void iShouldSeeAllToDo(List<String> toDoList) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("=====I should see all to do =====");
        todoPage.verifyUserSeeToDo(toDoList);
    }

    @And("^I verify Existed request name from Todo$")
    public void verifyCreatedRequestNameFromTodo(DataTable table) throws Throwable {
        logger.info("===== Verify Existed request name from Todos=====");
        List<List<String>> listTodoAndRequestName = getTable(table);
        for (List<String> todoAndRequestName : listTodoAndRequestName) {
            logger.info("On Todo name: " + todoAndRequestName.get(0));
            clickSlideOutMenuOnSelectedToDo(todoAndRequestName.get(0));
            verifyTodoDetailOpened();
            String[] requestNames = todoAndRequestName.get(1).split(",");
            for (String requestName : requestNames) {
                boolean isFind = todoPage.verifyExistedRequestName(requestName);
                Assert.assertTrue(isFind,"Can see request name");
            }
            todoPage.closeAddNewRequestWindow();
        }
    }

    @And("^I verify Existed request files from Todo$")
    public void iVerifyExistedRequestFilesFromTodo(DataTable table) throws Throwable {
        logger.info("===== Verify Existed request files from Todos=====");
        List<List<String>> listTodoAndRequestName = getTable(table);
        for (List<String> todoAndRequestName : listTodoAndRequestName) {
            logger.info("On Todo name: " + todoAndRequestName.get(0));
            clickSlideOutMenuOnSelectedToDo(todoAndRequestName.get(0));
            verifyTodoDetailOpened();
            String[] requestFiles = todoAndRequestName.get(1).split(",");
            for (String requestFile : requestFiles) {
                boolean isFind = todoPage.verifyExistedRequestFile(requestFile);
                Assert.assertTrue(isFind,"Can see request file");
            }
            todoPage.closeAddNewRequestWindow();
        }
    }

    @And("^I verify To-Do has been created and category$")
    public void verifyToDoHasBeenCreatedAndCategory(DataTable table) throws Throwable {
        logger.info("===== I verify To-Do has been created and category =====");
        List<List<String>> toDonameAndategorys = getTable(table);
        String toDoName;
        String category;
        for (List<String> toDonameAndategory :toDonameAndategorys) {
            toDoName= toDonameAndategory.get(0);
            category= toDonameAndategory.get(1);
            todoPage.checkToDoIsExists(toDoName);
            todoPage.checkCategoryIsExists(toDoName,category);

        }
    }
}
