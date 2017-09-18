package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p[@class='detComment']")
    private List<WebElement> listCommentItem;

    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    private WebElement titleCommentbox;

    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement buttonTodoPageAddRequest;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    WebElement tableNewRequest;

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
            return listCommentItem.size();
        }
    }

    public void waitForSizeListCommentChanged(int numberListCommentBeforeAdding) {
        boolean result = waitForSizeListElementChanged(listCommentItem, "List Comment Item",
                numberListCommentBeforeAdding + 1);
        Assert.assertTrue(result, "Comment list should be changed(plus one).");
    }

    public void verifyCommentContentIsDisplayed(String commentContent) {
        logger.info("Verify Comment Content is displayed");
        validateDisPlayedElement(listCommentItem.get(listCommentItem.size() - 1), "Comment Content Field");
        boolean result = validateElementText(listCommentItem.get(listCommentItem.size() - 1), commentContent);
        Assert.assertTrue(result, "Comment should be displayed on list comment.");
    }

    public void clickAddRequestBtn() {
        logger.info("Click the add request button");
        waitForTextValueChanged(buttonTodoPageAddRequest, "Text of totoPageAddRequestBtn", "Add New Request");
        clickElement(buttonTodoPageAddRequest, "click to totoPageAddRequestBtn");
    }

    public void createNewRequest(String newRequest, String position) {
            logger.info("Create request: " + newRequest + " with position: " + position);
            waitForCssValueChanged(tableNewRequest.findElement(By.xpath("./div[" + position + "]/span")), "", "display", "inline-block");
            clickElement(tableNewRequest.findElement(By.xpath("./div[" + position + "]/span")), "");
            clearTextBox(tableNewRequest.findElement(By.xpath("./div[" + position + "]/input")), "");
            sendKeyTextBox(tableNewRequest.findElement(By.xpath("./div[" + position + "]/input")), newRequest, "");
    }
}
