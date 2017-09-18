package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement totoPageAddRequestBtn;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    WebElement newRequestTable;

    public void verifyInputAComment(String commentContent) {
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
        waitForTextValueChanged(totoPageAddRequestBtn, "Text of totoPageAddRequestBtn", "Add New Request");
        clickElement(totoPageAddRequestBtn, "click to totoPageAddRequestBtn");
    }

    public void createNewRequest(String newRequest, String position) {
            logger.info("Create request: " + newRequest + " with position: " + position);
            waitForCssValueChanged(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "", "display", "inline-block");
            clickElement(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "");
            clearTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
            sendKeyTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), newRequest, "");
    }
}
