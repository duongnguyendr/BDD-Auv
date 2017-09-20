package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.GeneralUtilities;
import com.auvenir.ui.bdd.common.Generic;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by huy.huynh on 15/09/2017.
 */
public class TodoDetailsPage extends CommonPage {
    private static Logger logger = Logger.getLogger(TodoDetailsPage.class.getSimpleName());

    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    private WebElement inputTypeComment;

    @FindBy(xpath = "//*[@id='comment-button']")
    private WebElement buttonPostComment;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p[contains(@class,'detComment')]")
    private List<WebElement> listCommentItem;

    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    private WebElement titleCommentbox;

    @FindBy(xpath = "//div[@id='comment-form']/div[@class='auvicon-line-attach comment-attachment']")
    private WebElement iconAttachCommentFile;
    //    @FindBy(xpath = "//*[@id='add-request-btn']")
    //    private WebElement totoPageAddRequestBtn;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    protected List<WebElement> listNewRequest;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    protected WebElement newRequestTable;

    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div[@class='detReqForFile']/span[@class='todo-req-name-label']")
    protected List<WebElement> listRequestNameLabel;

    @FindBy(xpath = "//label[@class='auvicon-line-circle-add todo-circle-add todo-icon-hover']")
    protected List<WebElement> addFileIcon;

    @FindBy(xpath = "//*[@id='add-request-btn']")
    protected WebElement buttonTodoPageAddRequest;

    @FindBy(xpath = "//div[@class='auvicon-ex']")
    protected WebElement todoDetailPopupCloseBtn;

    @FindBy(xpath = "//div[@id='auv-todo-details']")
    protected WebElement todoDetailPopup;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']//span[4]")
    protected List<WebElement> uploadRequestList;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div//span[contains(@class,'auvicon-line-download')]")
    protected List<WebElement> buttonDownloadRequest;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    protected WebElement tableNewRequest;

    @FindBy(xpath = "//div[@id='todo-req-box-adding']/input")
    private WebElement nameRequestInput;

    @FindBy(id = "comment-input")
    WebElement commentInput;

    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement todoPageAddRequestBtn;

    @FindBy(xpath = "//div[@class='todo-comment-container']//p[contains(@class,'comment-fileName')]")
    List<WebElement> listCommentFilesName;

    public TodoDetailsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void inputCommentWithContent(String commentContent) {
        boolean result;
        logger.info("Verify Input a Comment");
        waitForVisibleElement(inputTypeComment, "Input Comment field");
        sendKeyTextBox(inputTypeComment, commentContent, "Input Comment field");
        result = validateAttributeElement(inputTypeComment, "value", commentContent);
        Assert.assertTrue(result, "Comment content should be filled on comment box.");
    }

    public void clickOnPostCommentButton() {
        logger.info("Click Post Comment Button");
        waitForVisibleElement(buttonPostComment, "Comment Input field");
        clickElement(buttonPostComment, "Comment Input field");
    }

    public int getNumberOfListComment() {
        logger.info("Get Number of List Comment.");
        if (titleCommentbox.getText().trim().equals("0")) {
            return 0;
        } else {
            return Integer.valueOf(titleCommentbox.getText().trim());
        }
    }

    public void waitForSizeListCommentChanged(int numberListCommentBeforeAdding) {
        boolean result = waitForSizeListElementChanged(listCommentItem, "List Comment Item",
                numberListCommentBeforeAdding + 1);
        Assert.assertTrue(result, "Comment list should be changed(plus one).");

    }

//    public void verifyListCommentConsistentWithCounter(){
//        int commentQuantity= Integer.valueOf(titleCommentbox.getText().trim())
//        if(listCommentItem.size()!=Integer.valueOf(titleCommentbox.getText().trim())){
//
//        }
//    }

    public void verifyCommentContentDisplayed(String commentContent) {
        logger.info("Verify Comment Content is displayed");
        validateDisPlayedElement(listCommentItem.get(listCommentItem.size() - 1), "Comment Content Field");
        boolean result = validateElementText(listCommentItem.get(listCommentItem.size() - 1), commentContent);
        Assert.assertTrue(result, "Comment should be displayed on list comment.");
    }

    public void clickAttachCommentIcon() {
        clickElement(iconAttachCommentFile, "Icon Attach File to Comment");
    }

    public void attachCommentFile(String commentFile) throws AWTException {
        String pathAttachLocation = Generic.FOLDER_UPLOAD;
        waitSomeSeconds(2);
        StringSelection ss = new StringSelection(pathAttachLocation.concat(commentFile));
        System.out.println("Path is: " + pathAttachLocation.concat(commentFile));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
        Robot robot = new Robot();
        robot.delay(2);
        waitSomeSeconds(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        waitSomeSeconds(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitSomeSeconds(2);
    }


    public void clickAddRequestBtn() {
        logger.info("Click the add request button");
        waitForTextValueChanged(buttonTodoPageAddRequest, "Text of totoPageAddRequestBtn", "Add New Request");
        clickElement(buttonTodoPageAddRequest, "click to totoPageAddRequestBtn");
    }

    public void createNewRequest(String newRequest, String position) {
        logger.info("Create request: " + newRequest + " with position: " + position);
        waitForCssValueChanged(tableNewRequest.findElement(By.xpath("./div[" + position + "]/span")), "", "display",
                "inline-block");
        clickElement(tableNewRequest.findElement(By.xpath("./div[" + position + "]/span")), "");
        clearTextBox(tableNewRequest.findElement(By.xpath("./div[" + position + "]/input")), "");
        sendKeyTextBox(tableNewRequest.findElement(By.xpath("./div[" + position + "]/input")), newRequest, "");
    }

    protected int findRequestByName(String requestName) {
        int isFind = -1;
        for (int i = 0; i < listRequestNameLabel.size(); i++) {
            System.out.println("Size list New Request: " + listRequestNameLabel.size());
            System.out.println(listRequestNameLabel.get(i).getText());
            if (listRequestNameLabel.get(i).getText().equals(requestName)) {
                isFind = i;
                logger.info("Request " + requestName + " at position: " + isFind);
                break;
            }
        }
        return isFind;
    }

    public void uploadFileOnRequestByName(String fileName, String requestName) throws AWTException {
        String concatUpload = Generic.FOLDER_UPLOAD.concat(fileName);
        System.out.println("concatUpload: " + concatUpload);
        int isFind = findRequestByName(requestName);
        if (isFind == -1) {
            logger.info("Can not find any request has name is: " + requestName);
        } else {
            clickElement(addFileIcon.get(isFind), "Add File Icon");
            waitSomeSeconds(2);
            logger.info("Input path of file..");
            StringSelection ss = new StringSelection(concatUpload);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
            Robot robot = new Robot();
            robot.delay(2);
            //            waitSomeSeconds(1);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            waitSomeSeconds(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitSomeSeconds(1);
        }
    }


    public void closeAddNewRequestWindow() {
        clickElement(todoDetailPopupCloseBtn, "Close To Do detail popup");
        waitForCssValueChanged(todoDetailPopup, "Add new Request Window", "display", "none");
    }

    public int findRequestUploadFile(String fileName) {
        logger.info(String.format("Verifying this file '%s' existed in the list..", fileName));
        int isFind = -1;
        for (int i = 0; i < uploadRequestList.size(); i++) {
            if (uploadRequestList.get(i).getText().equals(fileName)) {
                isFind = i;
                break;
            }
        }
        return isFind;
    }

    public void verifyUploadFileSuccessfully(String fileName) {
        int isFind = findRequestUploadFile(fileName);
        System.out.println("File Name: " + fileName + " is found at : " + isFind);
        Assert.assertTrue(isFind != -1, String.format("File '%s' should be uploaded successfully.", fileName));
    }

    public void downloadRequestFile(String fileName) {

        //Delete file before download

        String concatDownload = Generic.FOLDER_DOWNLOAD.concat(fileName);
        GeneralUtilities.checkFileExists(concatDownload, true);
        waitSomeSeconds(1);
        int index = findRequestUploadFile(fileName);
        Assert.assertTrue(index != -1, String.format("File '%s' should be found.", fileName));
        clickElement(buttonDownloadRequest.get(index), "Button download request");
        waitSomeSeconds(3);
    }

    public void createNewRequest(String newRequestName) {
        logger.info("Input name request :  " + newRequestName);
        sendKeyTextBox(nameRequestInput, newRequestName, "name request");
        clickElement(commentInput, "comment Input ");
    }

    public void selectAddNewRequest() {
        clickElement(todoPageAddRequestBtn, "Add new request Btn");
    }
}
