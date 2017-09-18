package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.GeneralUtilities;
import com.auvenir.ui.bdd.common.Generic;
import org.apache.log4j.Logger;
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

    public TodoDetailsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    private WebElement inputTypeComment;

    @FindBy(xpath = "//*[@id='comment-button']")
    private WebElement buttonPostComment;

    //    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']")
    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p")
    private List<WebElement> listCommentItem;

    //    @FindBy(xpath = "//*[@id='comment-box']/p")
    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    private WebElement commentboxTitle;
//    @FindBy(xpath = "//*[@id='add-request-btn']")
//    private WebElement totoPageAddRequestBtn;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    protected List<WebElement> listNewRequest;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    protected WebElement newRequestTable;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div[@class='detReqForFile']/span[@class='todo-req-name-label']")
    protected List<WebElement> listRequestNameLabel;
    @FindBy(xpath = "//label[@class='auvicon-line-circle-add todo-circle-add todo-icon-hover']")
    private List<WebElement> addFileIcon;
    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement todoPageAddRequestBtn;
    @FindBy(xpath = "//div[@class='auvicon-ex']")
    protected WebElement todoDetailPopupCloseBtn;
    @FindBy(xpath = "//div[@id='auv-todo-details']")
    protected WebElement todoDetailPopup;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']//span[4]")
    protected List<WebElement> uploadRequestList;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div//span[contains(@class,'auvicon-line-download')]")
    List<WebElement> buttonDownloadRequest;

    public void inputCommentWithContent(String commentContent) {
        boolean result;
        logger.info("Verify Input a Comment");
        waitForVisibleElement(inputTypeComment, "Input Comment field");
        sendKeyTextBox(inputTypeComment, commentContent, "Input Comment field");
        result = validateAttributeElement(inputTypeComment, "value", commentContent);
    }

    public void clickOnPostCommentButton() {
        logger.info("Click Post Comment Button");
        int size = getNumberOfListComment();
        waitForVisibleElement(buttonPostComment, "Comment Input field");
        clickElement(buttonPostComment, "Comment Input field");
        waitForSizeListElementChanged(listCommentItem, "List Comment", size + 1);
    }

    public int getNumberOfListComment() {
        logger.info("Get Number of List Comment.");
        if (commentboxTitle.getText().trim().equals("0")) {
            return 0;
        } else {
            return listCommentItem.size();
        }
    }

    public void clickAddRequestBtn() {
        logger.info("Click the add request button");
        waitForTextValueChanged(todoPageAddRequestBtn, "Text of totoPageAddRequestBtn", "Add New Request");
        clickElement(todoPageAddRequestBtn, "click to totoPageAddRequestBtn");
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
            clickElement(addFileIcon.get(isFind),"Add File Icon");
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

    public void selectAddNewRequest() {
        clickElement(todoPageAddRequestBtn,"Add new request Btn");
    }

    public void createNewRequest(String newRequestName) {
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

    public void downloadRequestFile(String  fileName) {

        //Delete file before download

        String concatDownload = Generic.FOLDER_DOWNLOAD.concat(fileName);
        GeneralUtilities.checkFileExists(concatDownload, true);
        waitSomeSeconds(1);
        int index = findRequestUploadFile(fileName);
        Assert.assertTrue(index != -1, String.format("File 's' should be found.", fileName));
        clickElement(buttonDownloadRequest.get(index), "Button download request");
        waitSomeSeconds(3);
    }

    public void verifyDownloadFileSuccess(String fileName) {
        String concatUpload = Generic.FOLDER_UPLOAD.concat(fileName);
        String concatDownload = Generic.FOLDER_DOWNLOAD.concat(fileName);
        boolean fileExisted = GeneralUtilities.checkFileExists(concatDownload, false);
        Assert.assertTrue(fileExisted, String.format("File 's' should not be existed."));
        if (fileExisted) {
            String checkMd5UploadFile = GeneralUtilities.calculateMD5(concatUpload);
            logger.info("md5 upload is: " + checkMd5UploadFile);
            String checkMd5DownloadFile = GeneralUtilities.calculateMD5(concatDownload);
            logger.info("md5 download is: " + checkMd5DownloadFile);
            Assert.assertEquals(checkMd5DownloadFile,checkMd5DownloadFile, "Checksum Download File and Upload File should be matched.");
        }
    }
}
