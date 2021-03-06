package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTodoPage;
import com.auvenir.ui.bdd.pages.common.TodoDetailsPage;
import com.auvenir.ui.bdd.pages.common.TodoPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.auvenir.ui.bdd.common.GeneralUtilities.getTable;

/**
 * Created by huy.huynh on 18/09/2017.
 */
public class TodoDetailsStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoDetailsStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    private TodoDetailsPage todoDetailsPage;
    private TodoPage todoPage;
    private AuditorTodoPage auditorTodoPage;
    String nameLastTodo = "";
    String nameTodo;
    String typeComment;
    String contentName;
    String userComment;

    public TodoDetailsStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        todoDetailsPage = new TodoDetailsPage(logger, driver);
        todoPage = new TodoPage(logger, driver);
        auditorTodoPage = new AuditorTodoPage(logger, driver);
    }

    @Then("^I input comment content: \"([^\"]*)\"$")
    public void inputCommentContent(String commentContent) throws Throwable {
        logger.info("===== I input comment content =====");
        todoDetailsPage.inputCommentWithContent(commentContent);
    }

    @Then("^I click on post comment button$")
    public void clickOnPostCommentButton() throws Throwable {
        logger.info("===== I click on post comment button =====");
        int numberOfListCommentlist = todoDetailsPage.getNumberOfListComment();
        todoDetailsPage.clickOnPostCommentButton();
        todoDetailsPage.waitForSizeListCommentChanged(numberOfListCommentlist);
    }

    @Then("^I should see this comment display on list: \"([^\"]*)\"$")
    public void verifyCommentDisplay(String commentContent) throws Throwable {
        logger.info("===== I should see this comment display on list =====");
        todoDetailsPage.verifyCommentContentDisplayed(commentContent);
    }

    @Then("^I attach to comment a file: \"([^\"]*)\"$")
    public void chooseAFile(String commentFile) throws Throwable {
        logger.info("===== I attach a file to comment =====");
        int numberOfListCommentlist = todoDetailsPage.getNumberOfListComment();
        todoDetailsPage.clickAttachCommentIcon();
        todoDetailsPage.attachCommentFile(commentFile);
        todoDetailsPage.waitForSizeListCommentChanged(numberOfListCommentlist);
    }


    @And("^I creates some new requests$")
    public void createsSomeNewRequests(DataTable table) throws Throwable {
        logger.info("===== I creates some new Request name =====");
        List<TodoStepDefinition.ListNewRequest> listNewRequests = new ArrayList<>();
        listNewRequests = table.asList(TodoStepDefinition.ListNewRequest.class);
        for (TodoStepDefinition.ListNewRequest listNewRequest : listNewRequests) {
            System.out.println("Prepare to create: " + listNewRequest.newRequestName);
            todoDetailsPage.clickAddRequestBtn();
            todoDetailsPage.createNewRequest(listNewRequest.newRequestName);
        }
    }

    @And("^I uploads list files on list requests$")
    public void uploadListFilesOnRequest(DataTable table) throws Throwable {
        logger.info("===== I uploads list files on request =====");
        List<List<String>> listFilesOnListRequests = getTable(table);

        for (List<String> fileOnRequest : listFilesOnListRequests) {
            System.out.println("File Name: " + fileOnRequest.get(0) + "--Request: " + fileOnRequest.get(1));
            todoDetailsPage.uploadFileOnRequestByName(fileOnRequest.get(0), fileOnRequest.get(1));
        }
    }

    @And("^I closes the To Do detail popup$")
    public void closeToDoDetailPopup() throws Throwable {
        logger.info("===== I closes the To Do detail popup =====");
        todoDetailsPage.closeAddNewRequestWindow();
    }

    @And("^I should see list files: (.*)$")
    public void verifyListFilesOnListRequests(List<String> listFileName) throws Throwable {
        logger.info("===== I should see list files on list requests =====");
        for (String fileName : listFileName) {
            todoDetailsPage.verifyUploadFileSuccessfully(fileName);
        }
    }

    @And("^I click download list files on Todo detail popup: (.*)$")
    public void clickDownloadListFileOnToDoDetailPopup(List<String> listFileName) throws Throwable {
        logger.info("===== I click download list file on Todo detail popup =====");
        for (String fileName : listFileName) {
            todoDetailsPage.downloadRequestFile(fileName);
        }
    }

    @And("^I verify comment at list To-Do$")
    public void verifyCommentAtListToDo(DataTable Table) throws Throwable {
        logger.info("===== I verify comment at list To-Do =====");
        List<List<String>> listToDo = getTable(Table);
        for (int i = 0; i < listToDo.size(); i++) {
            nameTodo = listToDo.get(i).get(0);
            userComment = listToDo.get(i).get(1);
            contentName = listToDo.get(i).get(2);
            logger.info(String.format("Todo Name: %s, User: %s, Comment: %s", nameTodo, userComment, contentName));
            if(nameLastTodo.isEmpty()){
                nameLastTodo = nameTodo;
                todoPage.clickSlideOutMenuOnTodo(nameTodo);
            }else if (!nameTodo.equals(nameLastTodo)){
                auditorTodoPage.closeAddNewRequestWindow();
                nameLastTodo = nameTodo;
                todoPage.clickSlideOutMenuOnTodo(nameTodo);
            }
            auditorTodoPage.verifyTodoDetailOpened();
            todoDetailsPage.verifyCommentUnknowType(contentName, userComment);
        }
    }
}
