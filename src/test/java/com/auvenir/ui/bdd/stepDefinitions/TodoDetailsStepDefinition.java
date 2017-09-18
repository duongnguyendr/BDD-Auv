package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.KeyWord;
import com.auvenir.ui.bdd.pages.common.TodoDetailsPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.auvenir.ui.bdd.common.GeneralUtilities.getTable;

/**
 * Created by huy.huynh on 9/18/2017.
 */
public class TodoDetailsStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoDetailsStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    //AuditorTodoPage auditorTodoPage;
    private TodoDetailsPage todoDetailsPage;
    private KeyWord keyWord;

    public TodoDetailsStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        //auditorTodoPage = new AuditorTodoPage(logger,driver);
        todoDetailsPage = new TodoDetailsPage(logger, driver);
    }

    @Then("^I input comment content: \"([^\"]*)\"$")
    public void inputCommentContent(String commentContent) throws Throwable {
        logger.info("===== I input comment content =====");
        todoDetailsPage.inputCommentWithContent(commentContent);
    }

    @Then("^I click on post comment button and verify$")
    public void clickOnConfirmDeleteButton() throws Throwable {
        logger.info("===== I input comment content =====");
        int numberOfListCommentlist = todoDetailsPage.getNumberOfListComment();
//        keyWord.waitForSizeListElementChanged();
    }
    //    @And("^I select todo: \"([^\"]*)\" check box on todo page$")
    //    public void iSelectTodoCheckBoxOnTodoPage(String todoName) throws Throwable {
    //        // Write code here that turns the phrase above into concrete actions
    //        todoPage.selectToDoCheckboxByName(todoName);
    //    }

    @And("^I creates some new requests$")
    public void createsSomeNewRequests(DataTable table) throws Throwable {
        logger.info("===== I creates some new Request name =====");
        List<TodoStepDefinition.ListNewRequest> listNewRequests = new ArrayList<>();
        listNewRequests = table.asList(TodoStepDefinition.ListNewRequest.class);
        for (TodoStepDefinition.ListNewRequest listNewRequest: listNewRequests){
            System.out.println("Prepare to create: "+listNewRequest.newRequestName);
            todoDetailsPage.selectAddNewRequest();
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
        for(String fileName : listFileName) {
            todoDetailsPage.verifyUploadFileSuccessfully(fileName);
        }
    }

    @And("^I click download list files on Todo detail popup: (.*)$")
    public void clickDownloadListFileOnToDoDetailPopup(List<String> listFileName) throws Throwable {
        logger.info("===== I click download list file on Todo detail popup =====");
        for(String fileName : listFileName) {
            todoDetailsPage.downloadRequestFile(fileName);
        }
    }

    @And("^I should see list files which are downloaded successfully: (.*)$")
    public void verifyDownloadListFilesSuccess(List<String> listFileName) throws Throwable {
        logger.info("===== I click download list file on Todo detail popup =====");
        for(String fileName : listFileName) {
            todoDetailsPage.verifyDownloadFileSuccess(fileName);
        }
    }
}
