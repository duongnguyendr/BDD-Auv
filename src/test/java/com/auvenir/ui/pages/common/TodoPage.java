package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.DatePicker;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * Created by vien.pham on 7/21/2017.
 */
public abstract class TodoPage extends AbstractPage {
    public TodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    //==============================**************===================================================

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    protected List<WebElement> toDoTaskRowEle;

    @FindBy(id = "empty-todo")
    protected WebElement emptyTodo;

    @FindBy(xpath = "//div[contains(@class,'ui dropdown client todo-bulkDdl ')]")
    protected List<WebElement> listClientAssigneeDdl;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td[7]/img")
    protected List<WebElement> listIconTodoDetails;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//span[contains(@class,'detCommentUser')]")
    protected List<WebElement> userNameCommenterEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p[@class='detComment']")
    protected List<WebElement> descriptionCommentEle;

    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    protected WebElement typeCommentFieldEle;

    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    protected WebElement commentboxTitleEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p")
    protected List<WebElement> listCommentItemEle;

    @FindBy(xpath = "//*[@id='comment-button']")
    protected WebElement postCommentButton;

    @FindBy(xpath = "//tr[contains(@class,'newRow')]")
    protected List<WebElement> listRow;

    @FindBy(xpath = "//span[@class='todo-name-readonly']")
    protected List<WebElement> listDisableTodoTextbox;

    @FindBy(xpath = "//tr[@class='newRow']//input[@type='text']")
    protected List<WebElement> listEnableTodoTextbox;

    @FindBy(xpath = "//tr[@class='newRow']//span[contains(@class,'todo-category')]")
    protected List<WebElement> listDisableCategoryBtn;

    @FindBy(xpath = "//div[contains(@class,'ui dropdown todoCategory')]")
    protected List<WebElement> listEnableCategoryBtn;

    @FindBy(xpath = "//tr[@class='newRow']//input[contains(@class,'input-due-date ')]")
    private List<WebElement> dueDateBtn;

    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    protected List<WebElement> listNewRequest;

    @FindBy(xpath = "(//div[@id='todoDetailsReqCont']/div)[1]")
    protected WebElement firstRequest;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    protected WebElement newRequestTable;

    @FindBy(xpath = "//div[contains(@class,'auvicon-line-circle-more')]")
    protected List<WebElement> listRequestOptionBtn;

    @FindBy(xpath = "//div[contains(@class,'auvicon-line-circle-more')]/div[@class='menu']/a")
    protected List<WebElement> listRequestSelection;

    @FindBy(xpath = "//div[@class='menu']/a[text()='Delete request']")
    protected List<WebElement> deleteRequestSelection;

    @FindBy(xpath = "(//div[@class='menu']/a[text()='Delete request'])[1]")
    protected WebElement firstDeleteRequestSelection;

    @FindBy(xpath = "(//div[contains(@class,'auvicon-line-circle-more')])[1]")
    protected WebElement firstRequestOptionBtn;

    @FindBy(xpath = "//div[@class='auvicon-ex']")
    protected WebElement requestCloseBtn;

    @FindBy(xpath = "//div[@id='auv-todo-details']")
    protected WebElement addNewRequestWindow;

    protected String activeStatus = "ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover active";
    @FindBy(id = "auv-todo-createToDo")
    protected WebElement createToDoBtnEle;

    @FindBy(id = "engOverview-status")
    protected WebElement engOveviewStatus;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[contains(@class,'newTodoInput')]")
    protected List<WebElement> toDoNameTextColumnEle;

    @FindBy(xpath = "//div[@id='auv-todo-detailsReqBox']//div[@id='todoDetailsReqCont']/div[contains(@id, 'todo-req-box')]/span[1]")
    protected List<WebElement> listRequestEle;

    @FindBy(xpath = "//div[contains(@class,'ui dropdown todoCategory')]")
    protected List<WebElement> listCategoryButton;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr//input[@type='checkbox']")
    protected List<WebElement> eleToDoCheckboxRow;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div/div[2]")
    protected List<WebElement> uploadRequestList;

    @FindBy(xpath = "//div[contains(text(),'Assign to')]")
    protected WebElement optionAssignTo;

    @FindBy(xpath = "//div[contains(text(),'Assign to')]/div[contains(@class,'menu')]/button")
    protected List<WebElement> childItemAssigneeBulkDrpEle;

    @FindBy(xpath = "//*[@id='engOverview-status']")
    protected WebElement eleEngagementOverViewStatusText;

    @FindBy(xpath = "//*[@id='engOverview-todo']")
    protected WebElement eleEngagementOverViewToDoText;

    @FindBy(xpath = "//div[@class='ui dropdown']")
    protected WebElement bulkActionsDropdownEle;

    @FindBy(xpath = "//div[contains(@id, 'Mark As Complete')]//div[@class='ce-footer']//button[@class='auvbtn primary']")
    protected WebElement archiveMarkPopupBtn;

    @FindBy(xpath = "//table[@id='todo-table']//td/div[@class='auvicon-circle-checkmark completeBtn priColor']/../../td/span")
    protected List<WebElement> listTodoCompleted;

    //  Old:  @FindBy(xpath = "//*[@id='m-ce-systemContainer']//h3[contains(text(),'Mark As Complete?')]")
    @FindBy(xpath = "//label[contains(@id,'m-Mark As Complete')]")
    protected WebElement markAsCompleteTitle;

    @FindBy(xpath = "//div[@id='todo-bulk-dropdown']/div[@class='menu']")
    protected WebElement bulkActionsDropdownMenuEle;

    @FindBy(xpath = "//div[starts-with(@id,'Mark As Complete') and contains(@class,'au-modal')]")
    protected WebElement popUpMarkCompleteWindows;

    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']//button[contains(text(),'Cancel')]")
    protected WebElement cancelMarkPopupBtn;

    @FindBy(xpath = "//button[contains(text(),'Delete')][@class='item']")
    protected WebElement optionDelete;

    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]/div/div[starts-with(@id,'m-Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDoAnimate;

    @FindBy(xpath = "//div[contains(@id,'m-Delete Todo Modal')]/following-sibling::div//button[@class='auvbtn warning']")
    protected WebElement buttonConfirmDeleteToDo;

    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDo;

    @FindBy(className = "newTodoInput")
    protected List<WebElement> eleToDoNameRow;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    protected WebElement statusOfDateTable;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
    protected WebElement dateTable;

    protected String auditAssignNotEditPath = "//td/span[text()='%s']/../../td[6]/p";
    protected String auditAssignCanEditPath = "//td/input[@value='%s']/../../td[6]/p";
    protected String clientAssignPath = "//td/span[text()='%s']/../../td[4]/p";
    protected String assineeClientEle = ".//button[text()='%s']";
    protected String newRequestImgByTodoNameAtAdminPage = "//*[@id='todo-table']/tbody/tr/td/span[text()='%s']//../../td/img";
    protected String newRequestImgByTodoName = "//*[@id='todo-table']/tbody/tr/td/input[@data-dbname='%s']//../../td/img";
    protected static String engagementOverViewStatusBefore = "";
    protected static String engagementOverViewToDoBefore = "";
    protected static final String displayImageInPopup = "img[src='../../images/icons/clipboard-yellow.png']";
    protected static final String markCompletePopupCancelBtn = "//div[@class='ce-footerBtnHolder']/button[contains(text(),'Cancel')]";
    protected static final String markCompletePopupArchiveBtn = "//*[contains(@id,'Mark As Complete')]//button[@class='auvbtn primary']";

    @FindBy(xpath = "//div[contains(@id,'Category Edit')]")
    private WebElement editCategoryPopUp;

    @FindBy(xpath = "//div[@id='cat-edit-btn']")
    private List<WebElement> catEditBtn;

    @FindBy(xpath = "//input[@class='auv-input edit-category']")
    private List<WebElement> categoryNameInput;

    @FindBy(xpath = "//img[contains(@id,'modal-close-Category Edit')]")
    private WebElement closeCategoryPopupBtn;

    @FindBy(xpath = "//button[@id='category-updateBtn']")
    private WebElement saveCategoryBtn;

    public int findToDoTaskName(String toDoName, boolean isClient) {
        getLogger().info("Find Position of To Do Task Name");
        String actualAttributeValue;
        String classAttribute;
        WebElement toDoNameCell = null;
        for (int i = 0; i < toDoTaskRowEle.size(); i++) {
            classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
            if (classAttribute.contains("newRow")) {
                if (isClient) {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/span[@class='todo-name-readonly']"));
                } else {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                }
                if (toDoNameCell != null) {
                    if (isClient) {
                        actualAttributeValue = toDoNameCell.getText().trim();
                        System.out.println("To Do Name: " + actualAttributeValue);
                    } else {
                        actualAttributeValue = toDoNameCell.getAttribute("value").trim();
                    }
                    if (actualAttributeValue.equals(toDoName)) {
                        getLogger().info("Element is found at " + i);
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public void verifyLastCommentOfUserDisplayed(String commentContent, String userFullName) {
        getLogger().info("Verify Last Comment Of User is Displayed");
        try {
            boolean result;
            result = validateElementText(userNameCommenterEle.get(userNameCommenterEle.size() - 1), userFullName);
            Assert.assertTrue(result, String.format("User Name Commenter '%s' should be displayed", userFullName));
            verifyCommentContentIsDisplayed(commentContent);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify Last Comment Of User is Displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify Last Comment Of User is Displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public boolean verifyCommentContentIsDisplayed(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify Comment Content is displayed");
            validateDisPlayedElement(descriptionCommentEle.get(descriptionCommentEle.size() - 1), "Comment Content Field");
            result = validateElementText(descriptionCommentEle.get(descriptionCommentEle.size() - 1), commentContent);
            Assert.assertTrue(result, "Comment Content is displayed unsuccessfully.");
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            return false;
        }
    }

    public boolean verifyPermissionSeeListToDoTask(List<String> listToDoName, boolean isNotEditedToDo, boolean possibleSee) {
        boolean result = true;
        try {
            for (int i = 0; i < listToDoName.size(); i++) {
                if (!verifyPermissionSeeToDoTask(listToDoName.get(i), isNotEditedToDo, possibleSee)){
                    result = false;
                    NXGReports.addStep("Verify To Do ' " + listToDoName.get(i) + (possibleSee ? "' is" : "' is not") + " displayed.",
                            LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), "To Do ' " + listToDoName.get(i) + (possibleSee ? "' is not" : "' is") + " displayed.");
                }
            }
            Assert.assertTrue(result, "User " + (possibleSee ? "should" : "should not") + " has permission to see list ToDo task");
            NXGReports.addStep("Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify User " + (possibleSee ? "has" : "does not have") + " permission to see list ToDo task",
                    LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
        return result;
    }

    public boolean verifyPermissionSeeToDoTask(String toDoName, boolean isNotEditedToDo, boolean isDisplayed) {
        boolean result = false;
        try {
            int count = findToDoTaskName(toDoName, isNotEditedToDo);
            if (isDisplayed) {
                if (count != -1)
                    result = true;
            } else {
                if (count == -1)
                    result = true;
            }
            Assert.assertTrue(result, "To Do Name is not displayed");
            NXGReports.addStep(String.format("Verify To Do '%s' is displayed", toDoName), LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports
                    .addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Test Failed: Verify ToDo Name is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return result;
    }

    public boolean verifyInputAComment(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify Input a Comment");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            sendKeyTextBox(typeCommentFieldEle, commentContent, "Input Comment field");
            result = validateAttributeElement(typeCommentFieldEle, "value", commentContent);
            Assert.assertTrue(result, "Input a Comment is unsuccessfully");
            NXGReports.addStep("Verify Input Comment", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify Input a Comment", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public int getNumberOfListComment() {
        getLogger().info("Get Number of List Comment.");
        if (commentboxTitleEle.getText().trim().equals("0")) {
            return 0;
        } else {
            return listCommentItemEle.size();
        }
    }

    public void clickOnPostCommentButton() {
        getLogger().info("Click Post Comment Button");
        int size = getNumberOfListComment();
        waitForVisibleElement(postCommentButton, "Comment Input field");
        clickElement(postCommentButton, "Comment Input field");
        waitForSizeListElementChanged(listCommentItemEle, "List Comment", size + 1);
    }

    public boolean verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify New Comment is displayed");
            int count = numberListCommentBeforeAdding + 1;
            result = waitForSizeListElementChanged(listCommentItemEle, "List Comment", count);
            Assert.assertTrue(result, "No New Comment is displayed.");
            result = verifyCommentContentIsDisplayed(commentContent);
            Assert.assertTrue(result, "Content of comment is NOT displayed.");
            NXGReports.addStep("Verify New Comment Is Displayed", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify New Comment Is Displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    /**
     * Vien.Pham own this function
     *
     * @param todoName: to find row correspoding with todoName inputed.
     * @param editable: true: editable or False:  not editable
     */
    public void verifyCategoryEditableCapability(String todoName, String oldCategoryName, String newCategoryName, boolean editable) {
        try {
            if (editable) {
                navigateToEditCategoryPopUp(todoName);
                editCategoryAction(oldCategoryName, newCategoryName);
                boolean isverify = verifyEditCategoryDone(todoName, newCategoryName);
                Assert.assertTrue(isverify);
                NXGReports.addStep("Verify category is " + (editable ? "editable" : "not editable") + " :Pass.", LogAs.PASSED, null);
            } else {
                int index = findRowByTodoName(todoName, false);
                boolean isVerify = validateAttributeContain(listDisableCategoryBtn.get(index), "class", "ui label", "Category Dropdown");
                if (isVerify) {
                    getLogger().info("Category is disable");
                    NXGReports.addStep("Verify category is " + (editable ? "editable" : "not editable") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify category is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (AssertionError ass) {
            ass.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category is " + (editable ? "editable" : "not editable" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Vien Pham own this function
     *
     * @param todoName: select category from corresponding todoName
     */
    public void navigateToEditCategoryPopUp(String todoName) {
        try {
            int index = findRowByTodoName(todoName, true);
            clickElement(listCategoryButton.get(index));
            clickElement(listCategoryButton.get(index).findElement(By.xpath(".//div[contains(text(),'Edit Categories')]")));
            waitForCssValueChanged(editCategoryPopUp, "edit category popup", "display", "block");
            NXGReports.addStep("Navigate to edit category popup: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Navigate to edit category popup: Fail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    /**
     * Vien.Pham own this function
     *
     * @param oldCategoryName: select categoryName want tobe changed
     * @param newCategoryName
     */
    public void editCategoryAction(String oldCategoryName, String newCategoryName) {
        try {
            int index = findCategoryForEditing(oldCategoryName);
            waitForVisibleElement(categoryNameInput.get(index), "Category Name input");
            hoverElement(categoryNameInput.get(index), "Category Name input");
            clickElement(catEditBtn.get(index));
            sendKeyTextBox(categoryNameInput.get(index), newCategoryName, "category input");
            clickElement(saveCategoryBtn);
            waitSomeSeconds(1);
        } catch (Exception e) {

        }

    }

    /**
     * VienPham
     *
     * @param todoName
     * @param newCategoryName
     * @return
     */
    public boolean verifyEditCategoryDone(String todoName, String newCategoryName) {
        boolean isVerify = false;
        int index = findRowByTodoName(todoName, true);
        clickElement(listCategoryButton.get(index));
        List<WebElement> listCategoryDropdown = listCategoryButton.get(index).findElements(By.xpath(".//div[@data-name]"));
        for (int i = 0; i < listCategoryDropdown.size(); i++) {
            if (listCategoryDropdown.get(i).getText().equals(newCategoryName)) {
                getLogger().info("new category name: " + newCategoryName + " is saved");
                isVerify = true;
                break;
            }
        }
        return isVerify;
    }

    /**
     * Vien.Pham own this function
     *
     * @param todoName
     * @param categoryName
     */
    public void doSelectCategoryByName(String todoName, String categoryName) {
        int index1 = findRowByTodoName(todoName, true);
        int index2 = 0;
        clickElement(listCategoryButton.get(index1));
        List<WebElement> listCategoryDropdown = listCategoryButton.get(index1).findElements(By.xpath(".//div[@data-name]"));
        for (int i = 0; i < listCategoryDropdown.size(); i++) {
            if (listCategoryDropdown.get(i).getText().equals(categoryName)) {
                index2 = i;
                break;
            }
        }
        clickElement(listCategoryDropdown.get(index2));
        waitSomeSeconds(1);
    }

    /**
     * Vien.Pham own this function
     *
     * @param todoName
     * @param categoryName
     */
    public void verifySelectCategory(String todoName, String categoryName) {
        try {
            int index = findRowByTodoName(todoName, true);
            String actualName = listCategoryButton.get(index).getText();
            System.out.println("actual name is: " + actualName);
            Assert.assertEquals(actualName, categoryName);
            NXGReports.addStep("New category saved: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("New category saved: Fail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    /**
     * Vien.Pham
     *
     * @param categoryName
     * @return
     */
    private int findCategoryForEditing(String categoryName) {
        int index = -1;
        for (int i = 0; i < categoryNameInput.size(); i++) {
            if (categoryNameInput.get(i).getAttribute("data-dbdata").equals(categoryName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Vien.Pham own this function
     *
     * @param todoName: to find row correspoding with todoName inputed. if "All": verify all rows.
     * @param editable: true: can be changed or False: can not be changed.
     */
    public void verifyDueDateEditableCapability(String todoName, String month, String day, String year, boolean editable) {
        try {
            if (editable) {
                openDatePickerTable(todoName);
                chooseDate(month, day, year);
                //                Boolean isVerify = verifyDuedate(todoName);
                //                Assert.assertTrue(isVerify);
                NXGReports.addStep("Verify DueDate can " + (editable ? "changed" : "not changed") + " :Pass.", LogAs.PASSED, null);
            } else {
                int index = findRowByTodoName(todoName, editable);
                boolean isVerify = dueDateBtn.get(index).getAttribute("class").contains("hasDatepicker");
                if (!isVerify) {
                    getLogger().info("Duedate can not be changed");
                    NXGReports.addStep("Verify DueDate can " + (editable ? "changed" : "not changed") + " :Pass.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (AssertionError ass) {
            ass.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify DueDate can " + (editable ? "changed" : "not changed" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void chooseDate(String month, String day, String year) throws Exception {
        try {
            selectDatePicker(month, day, year);
            waitForCssValueChanged(statusOfDateTable, "status of Date Table", "display", "none");
            NXGReports.addStep("Ending select due date: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending select due date: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    private void selectDatePicker(String month, String date, String year) {
        DatePicker dp = new DatePicker(getDriver(), dateTable);
        try {
            dp.pickADate(month, date, year);
            NXGReports.addStep("Choose date in date picker", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Choose date in date picker", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public Boolean verifyDuedate() {
        boolean isCheck = false;


        return isCheck;
    }


    public void openDatePickerTable(String todoName) {
        int index = findRowByTodoName(todoName, true);
        waitSomeSeconds(1);
        clickElement(dueDateBtn.get(index), "Duedate Btn");
        waitForCssValueChanged(statusOfDateTable, "status of Date Table", "display", "block");
    }

    private int findRowByTodoName(String todoName, boolean editablePage) {
        int index = -1;
        try {
            if (editablePage) {
                for (int i = 0; i < listEnableTodoTextbox.size(); i++) {
                    String actualName = listEnableTodoTextbox.get(i).getAttribute("value").trim();
                    if (actualName.equals(todoName)) {
                        index = i;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < listDisableTodoTextbox.size(); i++) {
                    String actualName = listDisableTodoTextbox.get(i).getText().trim();
                    if (actualName.equals(todoName)) {
                        index = i;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    /**
     * Vien.Pham own this function
     *
     * @param requestName:find         corresponding requestName
     * @param deleteRequestCapability: true: can delete request or False: can not delete request.
     */
    public void verifyRequestDeletionCapability(String requestName, boolean deleteRequestCapability) {
        try {
            int index = findRequestByName(requestName);
            clickElement(listRequestOptionBtn.get(index - 1));
            if (deleteRequestCapability) {
                int numberRequestBeforeDelete = listNewRequest.size();
                clickElement(deleteRequestSelection.get(index - 1));
                boolean isVerify = verifyDeleteRequest(numberRequestBeforeDelete);
                if (isVerify) {
                    NXGReports.addStep("Verify request can  " + (deleteRequestCapability ? "be deleted" : "not be deleted") + " :Pass.", LogAs.PASSED,
                            null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                boolean isVerify = validateNotExistedElement(firstDeleteRequestSelection, "delete selection");
                if (isVerify) {
                    getLogger().info("Delete request option is invisible");
                    NXGReports.addStep("Verify request can  " + (deleteRequestCapability ? "be deleted" : "not be deleted") + " :Pass.", LogAs.PASSED,
                            null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request can " + (deleteRequestCapability ? "be deleted" : "not be deleted" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public boolean verifyDeleteRequest(int numberRequestBeforeDelete) {
        boolean isVerify = false;
        if (numberRequestBeforeDelete > 1) {
            boolean isWait = waitForSizeListElementChanged(listNewRequest, "list new request", numberRequestBeforeDelete - 1);
            if (isWait) {
                isVerify = true;
            }
        } else {
            boolean isNotDisplayed = validateNotExistedElement(firstRequest, "Request");
            if (isNotDisplayed) {
                isVerify = true;
                System.out.println("List of request is empty after deleted");
            }
        }
        return isVerify;
    }


    protected int findRequestByName(String requestName) {
        int isFind = -1;
        for (int i = 1; i < (listNewRequest.size() + 1); i++) {
            System.out.println("Size list New Request: " + listNewRequest.size());
            if (newRequestTable.findElement(By.xpath("./div[" + i + "]/span")).getText().equals(requestName)) {
                isFind = i;
                getLogger().info("Request " + requestName + " at position: " + isFind);
                break;
            }
        }
        return isFind;
    }

    public void clickIconTodoDetailsByTodoName(String todoName, boolean editablePage) {
        getLogger().info("Select To Do Comment Icon by Todo Name");
        int index = findRowByTodoName(todoName, editablePage);
        if (index != -1) {
            clickElement(listIconTodoDetails.get(index), String.format("Comment Icon on Task Name: %s", todoName));
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Select To Do Comment Icon by Todo Name.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGroupPermissionCannotMarkCompleted(List<String> listTodo) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                int todoIndexCanChecked = selectToDoCheckboxByName(listTodo.get(i));
                if (todoIndexCanChecked == -1) {
                    NXGReports.addStep("Verify user cannot mark complete todo." + listTodo.get(i), LogAs.PASSED, null);
                } else {
                	clickBulkActionsDropdown();
                	boolean result = verifyMarkCompletedButtonDissable();
                	if(result){
                		NXGReports.addStep("Verify Mark Completed button dissable." + listTodo.get(i), LogAs.PASSED, null);
                	}else{
                		AbstractService.sStatusCnt++;
                        NXGReports.addStep("Verify Mark Completed button dissable.", LogAs.FAILED,
                                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        break;
                	}
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify user cannot mark complete todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    public int selectToDoCheckboxByName(String todoName) {
        getLogger().info("Select To Do Task Check Box by Name");
        try{
	        int index = findToDoTaskName(todoName);
	        System.out.println("Index: " + index);
	        if (index != -1) {
	            if (!eleToDoCheckboxRow.get(index).isSelected())
	                clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
	        }
	        return index;
        }catch (Exception e) {
			return -1;
		}
    }


    public void clickBulkActionsDropdown() {
        waitForVisibleElement(eleEngagementOverViewStatusText, "Engagement overview status");
        engagementOverViewStatusBefore = eleEngagementOverViewStatusText.getText().trim();

        waitForVisibleElement(eleEngagementOverViewToDoText, "Engagement overview todo");
        engagementOverViewToDoBefore = eleEngagementOverViewToDoText.getText().trim();

        clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown List");
    }

    /**
     * Click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void clickOnArchiveButtonInMarkAsCompletePopup() {
        getLogger().info("Click on archive button in mark as complete button");
        try {
            waitForClickableOfElement(archiveMarkPopupBtn, "Wait for click on archive button");
            clickElement(archiveMarkPopupBtn, "Click on archive button");
            NXGReports.addStep("Verify click on archive button in mark as complete popup successful ", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click on archive button in mark as complete popup fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyTodoMarkCompleted(String todoName) {
        boolean result = false;
        try {
            waitSomeSeconds(2);
            for (WebElement todo : listTodoCompleted) {
                System.out.println("Todo Copleted text: " + todo.getText());
                if (todoName.equals(todo.getText())) {
                    result = true;
                }
            }

            System.out.println("This is resule: " + result);
            if (result) {
                NXGReports.addStep("Todo " + todoName + " is mark completed.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Todo " + todoName + " is mark completed.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Todo " + todoName + " is mark completed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public void verifyCompleteMarkPopup() {
        verifyShowConfirmPopupAndMarkTitle();
        verifyDisplayImageInPopup();
        verifyMarkPopupColorCancelBtn();
        verifyMarkPopupColorArchiveBtn();
    }

    public void verifyShowConfirmPopupAndMarkTitle() {
        getLogger().info("Verify complete mark popup");
        boolean result;
        try {
            clickToBulkCompleteButton();
            result = validateElementText(markAsCompleteTitle, "Mark As Complete?");
            Assert.assertTrue(result, "Complete Mark Popup should be displayed.");
            NXGReports.addStep("Verify complete mark popup", LogAs.PASSED, null);
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex.getMessage());
            NXGReports.addStep("Verify complete mark popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDisplayImageInPopup() {
        getLogger().info("Verify to display image in popup");
        boolean result;
        try {
            waitForVisibleOfLocator(By.cssSelector(displayImageInPopup));
            WebElement imageInPopup = getDriver().findElement(By.cssSelector(displayImageInPopup));
            result = validateDisPlayedElement(imageInPopup, "Image Mark Complete Popup");
            Assert.assertTrue(result, "Image Mark Complete Popup should be displayed.");
            NXGReports.addStep("Verify to display image in popup", LogAs.PASSED, null);
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex.getMessage());
            NXGReports.addStep("Verify to display image in popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMarkPopupColorArchiveBtn() {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify the archive button in Mark as complete popup");
        try {
            waitForPresentOfLocator(By.xpath(markCompletePopupArchiveBtn));
            isCheckColorCancelButton = validateCssValueElement(archiveMarkPopupBtn, backgroundColor, "rgba(89, 155, 161, 1)");
            Assert.assertTrue(isCheckColorCancelButton, "BackgroundColor should be rgba(89, 155, 161, 1)");
            isCheckColorCancelButton = validateCssValueElement(archiveMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
            Assert.assertTrue(isCheckColorCancelButton, "Color should be rgba(255, 255, 255, 1)");
            NXGReports.addStep("Verify the archive button in Mark as complete popup", LogAs.PASSED, null);
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex.getMessage());
            NXGReports.addStep("Verify the archive button in Mark as complete popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMarkPopupColorCancelBtn() {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify the cancel button in Mark as complete popup");
        try {
            waitForPresentOfLocator(By.xpath(markCompletePopupCancelBtn));
            isCheckColorCancelButton = validateCssValueElement(cancelMarkPopupBtn, backgroundColor, "rgba(151, 147, 147, 1)");
            Assert.assertTrue(isCheckColorCancelButton, "BackgroundColor should be rgba(151, 147, 147, 1)");
            isCheckColorCancelButton = validateCssValueElement(cancelMarkPopupBtn, color, "rgba(255, 255, 255, 1)");
            Assert.assertTrue(isCheckColorCancelButton, "Color should be rgba(255, 255, 255, 1)");
            NXGReports.addStep("Verify the cancel button in Mark as complete popup", LogAs.PASSED, null);
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex.getMessage());
            NXGReports.addStep("Verify the cancel button in Mark as complete popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickToBulkCompleteButton() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(1), "Bulk complete button");
        waitForCssValueChanged(popUpMarkCompleteWindows, "PopUp Mark Complete", "display", "block");
    }

    public void verifyGroupPermissionCannotAssignTodoToAuditor(List<String> listTodo, boolean canEdit) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                boolean result = false;
                if (canEdit) {
                    result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(auditAssignCanEditPath, listTodo.get(i)))),
                            listTodo.get(i));
                } else {
                    result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(auditAssignNotEditPath, listTodo.get(i)))),
                            listTodo.get(i));
                }
                Assert.assertTrue(result, "verify auditor assign element.");
                NXGReports.addStep("verify user assign element.", LogAs.PASSED, null);
                if (!result) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify user cannot assign todo to Auditor.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    break;
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Verify user cannot assign todo to Auditor.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * @param listTodo
     * @param clientFullName
     * @param possibleEditTodo: Todo can/cannot edit
     */
    public void verifyGroupPermissionCannotAssignTodoToClient(List<String> listTodo, String clientFullName, boolean possibleEditTodo) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                if (possibleEditTodo) {
                    boolean clientAssignExist = verifyClientAssignExist(listTodo.get(i), clientFullName);
                    Assert.assertFalse(clientAssignExist, "verify client assign exists.");
                    if (clientAssignExist) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Client assign: " + clientFullName + " shouldn't display.", LogAs.FAILED,
                                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                } else {
                    boolean result = validateDisPlayedElement(getDriver().findElement(By.xpath(String.format(clientAssignPath, listTodo.get(i)))),
                            listTodo.get(i));
                    Assert.assertTrue(result, "verify client assign element.");
                    NXGReports.addStep(String.format("Verify user cannot assign todo to client.", listTodo.get(i)), LogAs.PASSED, null);
                    if (!result) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Verify user cannot assign todo to client" + listTodo.get(i), LogAs.FAILED,
                                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify user cannot assign todo to client", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGroupPermissionCannotCreateTodo() {
        try {
        	getLogger().info("Verify user can create todo.");
            boolean result = validateNotExistedElement(createToDoBtnEle, "createToDoBtnEle");
            Assert.assertTrue(result, "Verify create todo button displayed.");
            NXGReports.addStep("Verify create todo button displayed.", LogAs.PASSED, null);
            if (!result) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify user cannot create todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify user cannot create todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * @param listTodo
     */
    public void verifyGroupPermissionCannotRemoveTodo(List<String> listTodo) {
        try {
            for (int i = 0; i < listTodo.size(); i++) {
                int todoIndexCanChecked = selectToDoCheckboxByName(listTodo.get(i));
                if (todoIndexCanChecked == -1) {
                    NXGReports.addStep("Verify user cannot remove todo.", LogAs.PASSED, null);
                } else {
                	clickBulkActionsDropdown();
                	boolean result = verifyDeleteButtonDissable();
                	if (result){
                		NXGReports.addStep("Verify Delete button dissable.", LogAs.PASSED, null);
                	}else{
                		AbstractService.sStatusCnt++;
                        NXGReports.addStep("Verify Delete button dissable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                        break;
                	}
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify user cannot remove todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    /**
     * choose Delete option
     */
    public void chooseOptionDeleteOnBulkActionsDropDown() {
        try {
            getLogger().info("Choose option: Delete.");
            clickElement(optionDelete, "Option Delete");
            NXGReports.addStep("Choose option: Delete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose option: Delete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Click 'Delete' on Delete To-do popup
     * TODO: need to find appropriate method to wait before click
     */
    public void clickConfirmDeleteButton() {
        waitForAnimation(divConfirmDeleteToDoAnimate, "Div Confirm Delete ToDo Animation");
        clickElement(buttonConfirmDeleteToDo, "Button Confirm Delete ToDo");
        waitForCssValueChanged(divConfirmDeleteToDo, "Div Confirm Delete ToDo", "display", "none");
    }

    /**
     * Verify to-do not existed on list To-dos
     *
     * @param todoName : name of to-to to verify
     */
    public void verifyToDoNotExist(String todoName) {
        try {
            getLogger().info("Verify deleted todo: " + todoName);
            boolean isExisted = false;
            for (int i = 0; i < eleToDoNameRow.size(); i++) {
                if (todoName.equals(getTextByAttributeValue(eleToDoNameRow.get(i), "Todo expected not Exist"))) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Fail: Todo still existed: " + todoName, LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    isExisted = true;
                }
            }
            if (!isExisted) {
                NXGReports.addStep("Todo deleted success", LogAs.PASSED, null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param todoName
     * @param possibleComment: user can/cannot add comment
     */
    public void verifyGroupPermissionCanAddComment(String todoName, String comment, boolean possibleComment, boolean possibleSeeTodo,
            boolean possibleEdit) {
        try {
            if (possibleComment) {
                clickIconTodoDetailsByTodoName(todoName, possibleEdit);
                boolean commentExists = validateDisPlayedElement(typeCommentFieldEle, "Comment input");
                NXGReports.addStep("verify user can input comment.", LogAs.PASSED, null);
                Assert.assertTrue(commentExists, "User can comment.");
                verifyInputAComment(comment);
                int numCommentBefore = getNumberOfListComment();
                clickOnPostCommentButton();
                verifyNewCommentIsDisplayed(numCommentBefore, comment);
                if (!commentExists) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                if (possibleSeeTodo) {
                    clickOpenNewRequestByTodoNameAtAdminPage(todoName);
                    boolean commentExists = validateNotExistedElement(typeCommentFieldEle, "Comment input");
                    NXGReports.addStep("verify user can input comment.", LogAs.PASSED, null);
                    Assert.assertTrue(commentExists, "User can comment.");
                    if (!commentExists) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                } else {
                    int index = findToDoTaskName(todoName);
                    if (index != -1) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Verify todo: " + todoName + "not displayed in list todo.", LogAs.FAILED,
                                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    } else {
                        NXGReports.addStep("Verify todo: " + todoName + "not displayed in list todo.", LogAs.PASSED, null);
                    }
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleComment ? "can" : "cannot") + " comment.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    public void clickOpenNewRequestByTodoNameAtAdminPage(String toDoName) {
        try {
            WebElement addNewRequestImg = getDriver().findElement(By.xpath(String.format(newRequestImgByTodoNameAtAdminPage, toDoName)));
            clickElement(addNewRequestImg, "Click open request windows.");
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Click open request windows.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void createToDoTaskWithCategoryName(String toDoName, String categoryName) {
        getLogger().info("Create To Do Task with 'toDoName' and 'categoryName'");
        waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
        String rowString = toDoTaskRowEle.get(0).getAttribute("class");
        //Thuan Duong: Have a bug, need to start with size 2;
        int size = 1;
        int index = -1;
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (validateExistedElement(emptyTodo, "emptyTodo")) {
            size ++;
        }
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!rowString.equals("")) {
            size = toDoTaskRowEle.size() + 1;
            index = findToDoTaskName(toDoName);
        }

        if (index == -1) {
            getLogger().info("Create New To Do Task");
            waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
            clickElement(createToDoBtnEle, "Create To Do button");
            waitForSizeListElementChanged(toDoTaskRowEle, "To Do task row", size);
            sendKeyTextBox(toDoNameTextColumnEle.get(0), toDoName, "First To Do Name textbox");
            clickElement(engOveviewStatus);

            // Create new category
            selectCategory(categoryName);
            waitSomeSeconds(1);
            NXGReports.addStep("Create To Do Task", LogAs.PASSED, null);
        }
    }

    /**
     * choose an assignee on list Assign to
     * TODO hardcoding, rewrite later, list assignee not stable now
     */
    public void chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(String assigneeName) {
        getLogger().info(String.format("Choose Assignee '%s' in Bulk Dropdown list", assigneeName));
        try {
            String listUser = "";
            boolean result = false;
            clickElement(optionAssignTo, "Assign To Option");
            waitSomeSeconds(2);
            for (int i = 0; i < childItemAssigneeBulkDrpEle.size(); i++) {
//                listUser = childItemAssigneeBulkDrpEle.get(i).getText();
                listUser = childItemAssigneeBulkDrpEle.get(i).getAttribute("textContent");
                System.out.println("list User: " + listUser);
                if (listUser.contains(assigneeName)) {
                    result = clickElement(childItemAssigneeBulkDrpEle.get(i), "Child Item Assignee");
                    NXGReports.addStep("Choose first assignee(any) to assign.", LogAs.PASSED, null);
                    break;
                }
            }
            if (result) {
                NXGReports.addStep("Choose first assignee(any) to assign.", LogAs.PASSED, null);
            } else {
                getLogger().info(String.format("Cannot choose assignee '%s' in Bulk Dropdown list", assigneeName));
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Fail: Choose first assignee(any) to assign.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Fail: Choose first assignee(any) to assign.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyClientAssigneeSelected(String toDoName, String clientAssignee) {
        try {
            Thread.sleep(bigTimeOut);
            int index = findToDoTaskName(toDoName);
            WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
            waitForTextValueChanged(clientAssigneeSelected, "listClientAssigneeDdl", clientAssignee);
            if (clientAssigneeSelected.getText().equals(clientAssignee)) {
                NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify auditor assignee selected with name: " + clientAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    /**
     * Verify client assign exist in list client assign dropdown
     *
     * @param toDoName
     * @param clientFullName
     * @return
     */
    public boolean verifyClientAssignExist(String toDoName, String clientFullName) {
        boolean result = false;
        try {
            int index = findToDoTaskName(toDoName);
            clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
            List<WebElement> clientAssigneeSelected = listClientAssigneeDdl.get(index).findElements(By.xpath(".//button"));
            for (WebElement item : clientAssigneeSelected) {
                if (clientFullName.equals(item.getText())) {
                    result = true;
                    break;
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Error: Verify client assign existed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
        return result;
    }

    /**
     * Vien.Pham own this function
     *
     * @param requestName:               to find corresponding requestName.
     * @param editRequestNameCapability: true: can change requestName or False: can not change
     */
    public void verifyEditRequestNameCapability(String requestName, String newRequestName, boolean editRequestNameCapability) {
        try {
            if (editRequestNameCapability) {
                getLogger().info("Name of old request: " + requestName);
                inputRequestName(requestName, newRequestName);
                boolean isVerify = verifyNewRequestSaved(newRequestName);
                if (isVerify) {
                    NXGReports.addStep("Verify request Name can  " + (editRequestNameCapability ? "be changed" : "not be changed") + " :Pass.",
                            LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"),
                            LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }

            } else {
                int index = findRequestByName(requestName);
                clickElement(newRequestTable.findElement(By.xpath("./div[" + index + "]/span")), "");
                waitSomeSeconds(1);
                boolean isCheck =
                        validateCssValueElement(newRequestTable.findElement(By.xpath("./div[" + index + "]/span")), "display", "inline-block");
                if (isCheck) {
                    NXGReports.addStep("Verify request Name can  " + (editRequestNameCapability ? "be changed" : "not be changed") + " :Pass.",
                            LogAs.PASSED, null);

                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"),
                            LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request Name can " + (editRequestNameCapability ? "be changed" : "not be changed" + " :Fail"), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * Vien.Pham
     *
     * @param oldRequestName
     * @param newRequestName
     */
    public void inputRequestName(String oldRequestName, String newRequestName) {
        try {
            int position = findRequestByName(oldRequestName);
            clickElement(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "");
            clearTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
            sendKeyTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), newRequestName, "");
            sendTabkey(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Can not change request name");
        }

    }

    public void closeAddNewRequestWindow() {
        clickElement(requestCloseBtn);
        waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "none");
    }


    public boolean verifyNewRequestSaved(String newRequestName) {
        boolean isVerify = false;
        try {
            int index = findRequestByName(newRequestName);
            if (index != -1) {
                System.out.println("Name of new request: " + newRequestName);
                NXGReports.addStep("Verify request saved: Pass", LogAs.PASSED, null);
                isVerify = true;
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify request saved: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request saved: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return isVerify;
    }

    public void verifyRequestCreated(List<String> listRequest) {
        try {
            List<String> lstRequestDisplayed = new ArrayList<>();
            for (WebElement requestEle : listRequestEle) {
                lstRequestDisplayed.add(requestEle.getText());
            }
            for (int i = 0; i < listRequest.size(); i++) {
                if (!lstRequestDisplayed.contains(listRequest.get(i))) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify request: " + listRequest.get(i) + " created: Fail", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
            closeAddNewRequestWindow();

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify request created: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCanSeeAllToDosWithinEngagement(List<String> todoListNames, List<Boolean> todoListVisible, String role) {
        //        String xpathEngagementName = "//input[@class='newTodoInput'][@value='%s']";
        String xpathToDosName = "//tr[contains(@class,'newRow')]/td[2]/*";
        boolean exist = true;
        List<WebElement> webElements = getListElementsByXpath(xpathToDosName);
        for (int i = 0; i < todoListNames.size(); i++) {
            String xpathToDoName = getFullXpath(webElements, xpathToDosName, todoListNames.get(i));
            if (todoListVisible.get(i)) {
                if (getElementByXpath(xpathToDoName) == null) {
                    System.out.println("name= " + todoListNames.get(i));
                    exist = false;
                }
            } else {
                if (getElementByXpath(xpathToDoName) != null) {
                    System.out.println("name= " + todoListNames.get(i));
                    exist = false;
                }
            }
        }
        if (exist) {
            NXGReports.addStep("Verify " + role + " can see all engagements within firm", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: Verify " + role + " can see all engagements within firm", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String getFullXpath(List<WebElement> webElements, String xpath, String todoName) {
        for (int i = 0; i < webElements.size(); i++) {
            if (webElements.get(i).getTagName().equals("span")) {
                if (webElements.get(i).getText().equals(todoName)) {
                    //System.out.println("webElements i = " + webElements.get(i).getText());
                    return xpath + "[text()='" + todoName + "']";
                }
            } else if (webElements.get(i).getTagName().equals("input")) {
                if (webElements.get(i).getAttribute("value").equals(todoName)) {
                    //System.out.println("webElements i = " + webElements.get(i).getAttribute("value"));
                    return xpath + "[@value='" + todoName + "']";
                }
            }
        }
        return "";
    }

    public void uploadeNewFileByRequestName(String concatUpload, String requestName) {
        try {
            int isFind = findRequestByName(requestName);
            if (isFind == -1) {
                getLogger().info("Can not find any request has name is: " + requestName);
                AbstractService.sStatusCnt++;
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                clickElement(newRequestTable.findElement(By.xpath("./div[" + isFind + "]//label")));
                waitSomeSeconds(2);
                getLogger().info("Input path of file..");
                //                upLoadRequestFile(concatUpload);
                Robot robot = new Robot();
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.setAutoDelay(2000);
                StringSelection ss = new StringSelection(concatUpload);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
                robot.setAutoDelay(1000);
//                Screen screen = new Screen();
//                screen.click(GenericService.sDirPath + "\\src\\test\\resources\\imagesSikuli\\textbox.PNG");
//                robot.keyPress(KeyEvent.VK_ENTER);
//                robot.keyRelease(KeyEvent.VK_ENTER);
//                waitSomeSeconds(2);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                waitSomeSeconds(1);
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.PASSED, null);
            }
        } catch (AWTException e) {
        	AbstractService.sStatusCnt++;
            e.printStackTrace();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        } 
//        catch (FindFailed e) {
//        	AbstractService.sStatusCnt++;
//            e.printStackTrace();
//            NXGReports.addStep("Cannot find text box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e
//                    .getMessage());
//		}

    }

    /*
   Vien.Pham added new method
    */
    public void verifyUploadFileSuccessfully(String fileName) {
        try {
            int isFind = findRequestUploadFile(fileName);
            System.out.println("value is: " + isFind);
            if (isFind != -1) {
                NXGReports.addStep(String.format("File '%s' is displayed successfully.", fileName), LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(String.format("File '%s' is NOT displayed", fileName), LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(String.format("File '%s' is NOT displayed", fileName), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            e.printStackTrace();
        }
    }


    public int findRequestUploadFile(String fileName) {
        getLogger().info(String.format("Verifying this file '%s' existed in the list..", fileName));
        int isFind = -1;
        for (int i = 0; i < uploadRequestList.size(); i++) {
            System.out.println("UploadName at position: " + i + " is " + uploadRequestList.get(i).getText());
            if (uploadRequestList.get(i).getText().equals(fileName)) {
                isFind = i;
                break;
            }
        }
        return isFind;
    }

    public int findCommentUploadFile(String fileName) {
        getLogger().info(String.format("Verifying this file '%s' existed in the list..", fileName));
        int isFind = -1;
        for (int i = 0; i < commentFilesName.size(); i++) {
            System.out.println("UploadName at position: " + i + " is " + commentFilesName.get(i).getText());
            if (commentFilesName.get(i).getText().equals(fileName)) {
                isFind = i;
                break;
            }
        }
        return isFind;
    }

    public void downloadFileFromRequest(String downloadLocation, String fileName) {
        downloadRequestFile(downloadLocation, fileName);
    }

    public void downloadFileFromComment(String downloadLocation, String fileName) {
        downloadCommentFile(downloadLocation, fileName);
    }

    //    public void downloadNewRequestFile(String downloadLocation, String fileName, boolean fileInComment){}

    @FindBy(xpath = "//div[@class='todo-comment-container']//p[contains(@class,'comment-fileName')]")
    List<WebElement> commentFilesName;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div//span[contains(@class,'auvicon-line-download')]")
    List<WebElement> buttonDownloadRequest;

    public void downloadRequestFile(String pathDownloadFolder, String fileName) {
        try {
            //Delete file before download
            String concatDownload = pathDownloadFolder.concat(fileName);
            GeneralUtilities.checkFileExists(concatDownload, true);
            waitSomeSeconds(3);
            int index = findRequestUploadFile(fileName);
            if (index == -1) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Can't find name " + fileName + " on list request file.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }
            clickElement(buttonDownloadRequest.get(index), "Button download request");
            waitSomeSeconds(3);
            NXGReports.addStep("Download request file successfully.", LogAs.PASSED, null);


        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void downloadCommentFile(String pathDownloadFolder, String fileName) {
        try {
            //Delete file before download
            String concatDownload = pathDownloadFolder.concat(fileName);
            GeneralUtilities.checkFileExists(concatDownload, true);
            waitSomeSeconds(3);
            int index = findCommentUploadFile(fileName);
            if (index == -1) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Can't find name " + fileName + " on list comment file.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }

            clickElement(commentFilesName.get(index), "Comment File Name");
            waitSomeSeconds(3);
            NXGReports.addStep("Download attachment comment file successfully.", LogAs.PASSED, null);

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDownloadFileSuccess(String pathUpload, String pathDownload, String fileName) {
        try {
            String concatUpload = pathUpload.concat(fileName);
            String concatDownload = pathDownload.concat(fileName);
            boolean fileExisted = GeneralUtilities.checkFileExists(concatDownload, false);
            if (fileExisted) {
                String checkMd5UploadFile = calculateMD5(concatUpload);
                getLogger().info("md5 upload is: " + checkMd5UploadFile);
                String checkMd5DownloadFile = calculateMD5(concatDownload);
                getLogger().info("md5 download is: " + checkMd5DownloadFile);
                if (checkMd5UploadFile.equals(checkMd5DownloadFile)) {
                    NXGReports.addStep("Check sum done", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Check sum failed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Download file failed, file: " + fileName + "not in " + pathDownload, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String calculateMD5(String fileMD5) {
        String md5 = null;
        try {
            FileInputStream fis = new FileInputStream(fileMD5);
            System.out.println("fileMD5 = " + fileMD5);
            md5 = md5Hex(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().info("Unable to calculate MD5 file.");
        }

        return md5;

    }

//    //    public boolean checkFileExists(String downloadFile, boolean isDeletedFile){return false;}
//    public boolean checkFileExists(String pathLocation, boolean deleteExisted) {
//        //        waitSomeSeconds(3);
//        Path path = Paths.get(pathLocation);
//        System.out.println("file: " + path);
//        boolean result = false;
//        try {
//            if (Files.exists(path)) {
//                result = true;
//                if (deleteExisted) {
//                    Files.delete(path);
//                    if (Files.exists(path)) {
//                        AbstractService.sStatusCnt++;
//                        NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//                    }
//                }
//            }
//        } catch (IOException ex) {
//            AbstractService.sStatusCnt++;
//            NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
//            ex.printStackTrace();
//        }
//        return result;
//    }

    public int findToDoTaskName(String toDoName) {
        getLogger().info("Find Position of To Do Task Name");
        try {
            String actualAttributeValue;
            String classAttribute;
            for (int i = 0; i < toDoTaskRowEle.size(); i++) {
                classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
                if (classAttribute.equals("newRow")) {
                    boolean elementExisted =
                            validateNotExistedElement(toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']")), "toDoTaskRowEle");
                    if (!elementExisted) {
                        WebElement toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                        actualAttributeValue = toDoNameCell.getAttribute("value").trim();

                        if (actualAttributeValue.equals(toDoName)) {
                            getLogger().info("Element is found at " + i);
                            NXGReports.addStep(String.format("The position of To Do task: '%s' at %d", toDoName, i), LogAs.PASSED, null);
                            return i;
                        }
                    }
                }
            }
            return -1;
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

    /**
     * Created by Thuan Duong.
     * Verify all File will be displayed.
     *
     * @param listFileName list file will be verified
     */
    public void verifyCanSeeAllFileWithinToDo(List<String> listFileName) {
        try {
            int isFind = -1;
            boolean result = true;
            for (int i = 0; i < listFileName.size(); i++) {
                isFind = findRequestUploadFile(listFileName.get(i));
                System.out.println("value is: " + isFind);
                if (isFind == -1) {
                    result = false;
                    System.out.println(String.format("File Name '%s' is not displayed: ", listFileName.get(i)));
                    break;
                }
            }
            if (result) {
                NXGReports.addStep("All file '%s' is displayed successfully.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("All file '%s' is NOT displayed successfully", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("All file '%s' is NOT displayed successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Create by Duong Nguyen
     * Verify User cannot comment on todo they are not assign to
     *
     * @param
     */
    public void verifyGroupPermissionCannotCommentOnToDoNotAssigTo(String toDoName, boolean canSeeTodo) {
        try {
            if (canSeeTodo) {

            } else {
                int index = findToDoTaskName(toDoName);
                if (index != -1) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify user cannot comment on todo they are not assign to.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                } else {
                    NXGReports.addStep("Verify user cannot comment on todo they are not assign to.", LogAs.PASSED, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Bug: Mark completed button in client side is invisible, implement later.
     */
    public boolean verifyMarkCompletedButtonDissable(){
    	AbstractService.sStatusCnt++;
        NXGReports.addStep("Mark completed button in client side invisible.", LogAs.FAILED,
                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        return false;
    }

    /**
     *  Bug: Bulk Action Deleted button in client side is invisible, implement later.
     */
    public boolean verifyDeleteButtonDissable(){
    	AbstractService.sStatusCnt++;
        NXGReports.addStep("Bulk Action Deleted button in client side is invisible.", LogAs.FAILED,
                new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        return false;
    }
}
