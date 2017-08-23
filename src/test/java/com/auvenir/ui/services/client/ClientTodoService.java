package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.todo.ClientToDoPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by vien.pham on 7/21/2017.
 */
public class ClientTodoService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */

    TodoPage todoPage;
    ClientToDoPage clientToDoPage;

    public ClientTodoService(Logger logger, WebDriver driver) {
        super(logger, driver);
        //        todoPage = new ClientToDoPage(getLogger(), getDriver());
        clientToDoPage = new ClientToDoPage(getLogger(), getDriver());
    }


    public void clickCommentIconPerTaskName(String todoTaskName, boolean editablePage) {
        clientToDoPage.clickIconTodoDetailsByTodoName(todoTaskName, editablePage);
    }

    public void openTodoDetailsByTodoNameUneditable(String todoName) {
        clientToDoPage.clickIconTodoDetailsByTodoName(todoName, false);
    }

    public void verifyLastCommentOfUserDisplayed(String commentContent, String userFullName) {
        clientToDoPage.verifyLastCommentOfUserDisplayed(commentContent, userFullName);
    }

    public void verifyClientSeeListTodos(List<String> listTodoNames) {
        clientToDoPage.verifyPermissionSeeListToDoTask(listTodoNames, true, true);
    }

    public void verifyInputAComment(String commentContent) {
        clientToDoPage.verifyInputAComment(commentContent);
    }

    public int getNumberOfListComment() {
        return clientToDoPage.getNumberOfListComment();
    }

    public void clickOnPostCommentButton() {
        clientToDoPage.clickOnPostCommentButton();
    }

    public void verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        clientToDoPage.verifyNewCommentIsDisplayed(numberListCommentBeforeAdding, commentContent);
    }

    public void selectCheckboxByTodoName(String todoName) {
        clientToDoPage.selectToDoCheckboxByName(todoName);
    }

    public void clickBulkActionsDropdown() throws InterruptedException {
        clientToDoPage.clickBulkActionsDropdown();
    }

    public void selectAssigneeToDoUsingBulkAction(String clientFullName) {
        clientToDoPage.chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(clientFullName);
    }

    public void verifyClientAssigneeSelected(String todo4, String clientFullName) {
        clientToDoPage.verifyClientAssigneeSelected(todo4, clientFullName);
    }

    public void uploadFileByRequestName(String pathUploadFile, List<String> listFile, List<String> listRequest) {
        for (int i = 0; i < listRequest.size(); i++) {
            clientToDoPage.uploadeNewFileByRequestName(pathUploadFile.concat(listFile.get(i)), listRequest.get(i));

        }
    }


    public void verifyUploadFileSuccessfully(List<String> listFile, List<String> listRequest) {
        for (int i = 0; i < listRequest.size(); i++) {
            clientToDoPage.verifyUploadFileSuccessfully(listFile.get(i));
        }
    }

    public void closePopupTodoDetail() {
        clientToDoPage.closeAddNewRequestWindow();
    }

    public void downloadFileFromRequestFile(String pathOfDownloadLocation, String fileName) {
        clientToDoPage.downloadFileFromRequest(pathOfDownloadLocation, fileName);
    }

    public void verifyDownloadFileFromRequestSuccessfully(String pathOfUploadLocation, String pathOfDownloadLocation, String fileName) {
        clientToDoPage.verifyDownloadFileSuccess(pathOfUploadLocation, pathOfDownloadLocation, fileName);
    }
}
