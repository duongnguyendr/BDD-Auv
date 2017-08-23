package com.auvenir.ui.pages.auditor.todo;

//import library

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AuditorTodoListPage extends AbstractPage {

    public AuditorTodoListPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "auv-todo-createToDo")
    private WebElement eleCreateToDoBtn;

    @FindBy(id = "todo-filter-dropdown")
    private WebElement eleFilterBtn;

    @FindBy(id = "todo-search")
    private WebElement eleToDoSearchInput;
    @FindBy(xpath = "//button[contains(text(),'Create To-Do')]")
    private WebElement createTodoTextEle;

    @FindBy(xpath = "//table[@id='todo-table']//..//..//th//input[@type='checkbox']")
    private WebElement eleCheckBox;

    @FindBy(xpath = "//table[@id='todo-table']//th[@data-id='name']")
    private WebElement eleNameToDoTitleLabel;

    @FindBy(xpath = "//table[@id='todo-table']//th[@data-id='name']//i")
    private WebElement eleSortByNameToDo;

    @FindBy(xpath = "//th[@data-id='category']")
    private WebElement eleCategoryTitleLabel;

    @FindBy(xpath = "//th[@data-id='category']//i")
    private WebElement eleSortByCategory;

    @FindBy(xpath = "//th[@data-id='clientAssignee']")
    private WebElement eleClientAssigneeTitleLabel;

    @FindBy(xpath = "//th[@data-id='clientAssignee']//i")
    private WebElement eleSortByClientAssignee;

    @FindBy(xpath = "//table[@id='todo-table']//th[@data-id='dueDate']")
    private WebElement eleDueDateTitleLabel;

    @FindBy(xpath = "//table[@id='todo-table']//th[@data-id='dueDate']//i")
    private WebElement eleSortByDueDate;

    @FindBy(xpath = "//th[@data-id='auditorAssignee']")
    private WebElement eleAuditAssigneeTitleLabel;
    @FindBy(xpath = "//th[@data-id='auditorAssignee']//i")
    private WebElement eleSortByAuditAssignee;


    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//img")
    private WebElement eleImgEmtyToDo;

    @FindBy(xpath = "//tr[@id='empty-todo']//td//div//div")
    private WebElement eleNotesEmtyToDo;

    /*
    Filter elements
     */
    @FindBy(id = "filter-container")
    private WebElement eleFilterDropDownList;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Show All')]")
    private WebElement eleShowAllBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Due Date')]")
    private WebElement eleDueDateBTN;
    @FindBy(xpath = "//*[@id='filter-container']//div[contains(text(),'Assigned')]")
    private WebElement eleAssignedBTN;
    @FindBy(xpath = "//*[@id='filter-container']//div[contains(text(),'Assigned')]//button")
    private List<WebElement> AssignValue;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'With Comments')]")
    private WebElement eleWithCommentBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Complete')]")
    private WebElement eleCompleteBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Outstanding')]")
    private WebElement eleOutstandingBTN;
    @FindBy(xpath = "//*[@id='filter-container']//button[contains(text(),'Flagged For Request')]")
    private WebElement eleFlaggedForRequest;


    @FindBy(xpath = "//tr[@class=\"newRow\"]")
    List<WebElement> tableTodoList;

    /////////////////////////////////////////////////
    public void verifyTodoListPageColumnHeader() {
        getLogger().info("verify To Do List page.");
        verifyButtonCreateToDo();
        verifyFilterDropDownList();
        verifyCheckOnCheckBox();
        verifyUnCheckOnCheckBox();
        verifyColumnsInGrid();
        verifySortIconOnEachColumn();
        verifySearchHover();
        verifySearchInputText();
        verifySearchInputNumber();
        verifySearchDefault();
    }

    /*
    Vien.Pham changed Boolean for verifyEmptyTodoList.
     */
    public void verifyEmptyTodoList() throws Exception {
        waitForVisibleElement(eleImgEmtyToDo, "Empty Todo Image");
        validateDisPlayedElement(eleImgEmtyToDo, "Empty Todo Image");
        waitForVisibleElement(eleNotesEmtyToDo, "Empty Todo Note");
        validateDisPlayedElement(eleNotesEmtyToDo, "Empty Todo Note");
    }


    public void verifyButtonCreateToDo() {
        getLogger().info("Verify create to do button.");
        boolean result;
        int countFail = 0;
        validateDisPlayedElement(eleCreateToDoBtn, "Create Todo Button");
        result = validateCssValueElement(eleCreateToDoBtn, "background-color", "rgba(89, 155, 161, 1)");
        if (!result) {
            countFail++;
            NXGReports.addStep("Fail: Verify background-color create to do button.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        result = validateCssValueElement(eleCreateToDoBtn, "color", "rgba(255, 255, 255, 1)");
        if (!result) {
            countFail++;
            NXGReports.addStep("Fail: Verify color create to do button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        if (countFail == 0) {
            NXGReports.addStep("Verify create to do button.", LogAs.PASSED, null);
        }
    }

    public void verifyButtonFilter() throws Exception {
        validateDisPlayedElement(eleFilterBtn, "Filter button");
    }

    public void verifySearchDefault() {
        getLogger().info("Verify default value(hint) field search.");
        boolean result = validateAttributeElement(eleToDoSearchInput, "placeholder", "Search...");
        if (result) {
            NXGReports.addStep("Verify default value(hint) field search.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Verify default value(hint) field search.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchHover() {
        getLogger().info("Verify search hover.");
        clickAndHold(eleToDoSearchInput, "Search Button");
        waitForVisibleElement(eleToDoSearchInput, "Search Button");
        boolean result = validateCssValueElement(eleToDoSearchInput, "border-color", "rgb(89, 155, 161)");
        if (result) {
            NXGReports.addStep("Verify search hover.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Verify search hover.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchInputText() {
        getLogger().info("Verify input text for field search.");
        enterSearchToDoTask("To do task name");
        boolean result = validateAttributeElement(eleToDoSearchInput, "value", "To do task name");
        if (result) {
            NXGReports.addStep("Verify input text for field search.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Verify input text for field search.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifySearchInputNumber() {
        getLogger().info("Verify input number for field search.");
        enterSearchToDoTask("123");
        boolean result = validateAttributeElement(eleToDoSearchInput, "value", "123");
        if (result) {
            NXGReports.addStep("Verify input number for field search.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Verify input number for field search.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyColumnsInGrid() {
        getLogger().info("Verify columns in gird.");
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
    }


    public void verifySortIconOnEachColumn() {
        getLogger().info("Verify Sort Icon on each column.");
        validateDisPlayedElement(eleSortByNameToDo, "Sort By name");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Client Assignee");
        validateDisPlayedElement(eleSortByDueDate, "Sort By due Date");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort By Auditor Assignee");
    }

    public void verifyCheckOnCheckBox() {
        getLogger().info("Verify check on checkbox.");
        checkAllToDoTask();
        waitForVisibleElement(eleCheckBox, "Check Box All To Do list");
        boolean result = validateCssValueElement(eleCheckBox, "background-color", "rgba(89, 155, 161, 1)");
        if (result)
            NXGReports.addStep("Verify check on checkbox.", LogAs.PASSED, null);
        else
            NXGReports.addStep("Verify check on checkbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    }

    public void verifyUnCheckOnCheckBox() {
        getLogger().info("Verify UnCheck on checkbox.");
        unCheckAllToDoTask();
        waitForVisibleElement(eleCheckBox, "Check Box All To Do list");
        boolean result = validateCssValueElement(eleCheckBox, "background-color", "rgba(255, 255, 255, 1)");
        if (result)
            NXGReports.addStep("Verify uncheck on checkbox.", LogAs.PASSED, null);
        else
            NXGReports.addStep("Verify uncheck on checkbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    }

    public void clickCreateToDoBtn() throws Exception {
        getLogger().info("Click Create ToDo Button");
        waitForTextValueChanged(eleCreateToDoBtn, "Create Todo Butto", "Create To-Do");
        clickElement(eleCreateToDoBtn, "Create Todo Button");
    }

    public void checkAllToDoTask() {
        getLogger().info("Click Check All To Do Task.");
        if (!eleCheckBox.isSelected()) {
            clickOnCheckBox(eleCheckBox, "All Check Box");
        }
    }

    public void unCheckAllToDoTask() {
        getLogger().info("UnCheck All To Do Task.");
        if (eleCheckBox.isSelected()) {
            clickOnCheckBox(eleCheckBox, "CheckBox");
        }
    }

    public void enterSearchToDoTask(String searchValue) {
        sendKeyTextBox(eleToDoSearchInput, searchValue, "Search Field");
    }

    public void clickSortByNameToDoTask() {
        clickElement(eleSortByNameToDo, "Sort By Name");
    }

    public void clickSortByAuditAssignee() {
        clickElement(eleSortByAuditAssignee, "Sort By auditor Assignee");
    }

    public void clickSortByCategory() {
        clickElement(eleSortByCategory, "Sort by Category");
    }

    public void clickSortByDueDate() {
        clickElement(eleSortByDueDate, "Sort By Due Date");
    }

    public void clickSortByClientAssignee() {
        clickElement(eleSortByClientAssignee, "Sort By client assignee");
    }


    public void verifyTodoListPage() {
        //waitForClickableOfElement(eleCreateToDoBtn,"Create Todo button");
        //validateElementText(eleCreateToDoBtn,"Create To-Do");
        waitForClickableOfElement(createTodoTextEle, "Create Todo text");

    }

    public void verifyFilterDropDownList() {
        getLogger().info("Verify filter button.");
        boolean result;
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        result = clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        if (!result)
            NXGReports.addStep("Verify filter button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        else
            NXGReports.addStep("Verify filter button.", LogAs.PASSED, null);
        waitForVisibleElement(eleShowAllBTN, "eleShowAllBTN");
        // Busniess rule is changed, remove Due Date and FlagForRequest Option.
        //        waitForVisibleElement(eleDueDateBTN, "eleDueDateBTN");
        //        waitForClickableOfElement(eleFlaggedForRequest, "eleFlaggedForRequest");
        //        waitForClickableOfElement(eleDueDateBTN, "eleDueDateBTN");
        //        waitForVisibleElement(eleFlaggedForRequest, "eleFlaggedForRequest");
        waitForVisibleElement(eleAssignedBTN, "eleAssignedBTN");
        waitForVisibleElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForVisibleElement(eleCompleteBTN, "eleCompleteBTN");
        waitForVisibleElement(eleOutstandingBTN, "eleOutstandingBTN");
        waitForClickableOfElement(eleShowAllBTN, "eleShowAllBTN");
        waitForClickableOfElement(eleAssignedBTN, "eleAssignedBTN");
        waitForClickableOfElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        waitForClickableOfElement(eleOutstandingBTN, "eleOutstandingBTN");
    }

    public void verifyDefaultValueFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Filter");
    }

    public boolean verifyHoverFilterDropDownList() {
        boolean isCheckBorderColor = false;
        getLogger().info("Verify hover on Filter DropDown list.");
        try {
            // Green color
            hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
            isCheckBorderColor = validateCssValueElement(eleFilterDropDownList, "border-bottom-color", "rgba(117, 117, 117, 1)");
            if (isCheckBorderColor) {
                NXGReports.addStep("Verify  hover on Filter DropDown list: PASSED", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify  hover on Filter DropDown list: FAILED", LogAs.FAILED, null);
            }
            return isCheckBorderColor;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify  hover on Filter DropDown list: FAILED", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckBorderColor;
        }
    }

    public void selectShowAllFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleShowAllBTN, "eleShowAllBTN");
        clickElement(eleShowAllBTN, "eleShowAllBTN");
    }

    public void verifySelectShowAllFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Show All");
    }

    public void selectDueDateFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleDueDateBTN, "eleDueDateBTN");
        clickElement(eleDueDateBTN, "eleDueDateBTN");
    }

    public void verifySelectDueDateFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Due Date");
    }

    public void selectAndVerifyFirstAssignFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleAssignedBTN, "eleAssignedBTN");
        getLogger().info("Select the first value on  Assign.");
        String firstTextValue = AssignValue.get(0).getText().trim();
        clickElement(AssignValue.get(0), "AssignValue");
        validateElementText(eleFilterDropDownList, firstTextValue);
    }

    public void selectWithCommentsFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleWithCommentBTN, "eleWithCommentBTN");
        clickElement(eleWithCommentBTN, "eleWithCommentBTN");
    }

    public void verifySelectWithCommentsFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "With Comments");
    }

    public void selectCompleteFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        clickElement(eleCompleteBTN, "eleCompleteBTN");
    }

    public void verifySelectCompleteFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Complete");
    }

    public void selectFlaggedForRequestFilterDropDownList() {
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForClickableOfElement(eleCompleteBTN, "eleCompleteBTN");
        clickElement(eleFlaggedForRequest, "eleFlaggedForRequest");
    }

    public void verifySelectFlaggedForRequestFilterDropDownList() {
        validateElementText(eleFilterDropDownList, "Flagged For Request");
    }

    public void verifyUnableAddMoreOptionFilterDropDownList() {
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        waitForVisibleElement(eleShowAllBTN, "eleShowAllBTN");
        waitForVisibleElement(eleDueDateBTN, "eleDueDateBTN");
        waitForVisibleElement(eleAssignedBTN, "eleAssignedBTN");
        waitForVisibleElement(eleWithCommentBTN, "eleWithCommentBTN");
        waitForVisibleElement(eleCompleteBTN, "eleCompleteBTN");
        waitForVisibleElement(eleOutstandingBTN, "eleOutstandingBTN");
        waitForVisibleElement(eleFlaggedForRequest, "eleFlaggedForRequest");
        NXGReports.addStep("Dropdown list have only above options.", LogAs.PASSED, null);
    }

    public void verifyClickAndDoNotSelectValue() {
        waitForVisibleElement(eleFilterDropDownList, "eleFilterDropDownList");
        hoverElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
        clickElement(eleFilterDropDownList, "eleFilterDropDownList");
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */
    @FindBy(id = "engagementUserBtn")
    private WebElement buttonInviteClient;

    /**
     * Click Invite button
     */
    public void navigateToInviteClientPage() {
        validateElementText(buttonInviteClient, "Invite Client");
        clickByJavaScripts(buttonInviteClient, "Button Invite Client");
    }
    /*-----------end of huy.huynh on 02/06/2017.*/

    /*
 Vien.Pham add new method.
  */
    @FindBy(xpath = "//span[@class='auvicon-team engagement-icon']")
    WebElement teamBtn;
    @FindBy(xpath = "//button[@id='team-inviteMember-btn']")
    WebElement inviteMemberBtn;

    @FindBy(xpath = "//div[@id='engagement-team']")
    WebElement engagementTeam;

    public void navigateToInviteGeneralMember() {
        clickElement(teamBtn);
        waitForCssValueChanged(engagementTeam, "engagementTeam", "display", "block");
        //        waitForTextValueChanged(inviteMemberBtn,"invite auditor Btn","Invite New Member");
        clickElement(inviteMemberBtn);
    }

}
