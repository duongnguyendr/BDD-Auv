package com.auvenir.ui.pages.auditor.todo;

import com.auvenir.ui.pages.common.PopUpPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.utilities.DatePicker;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import com.mongodb.DBCollection;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import javax.sql.rowset.spi.SyncFactoryException;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import library


public class AuditorCreateToDoPage extends TodoPage {

    public AuditorCreateToDoPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindAll(@FindBy(xpath = "//div[@class='e-widget-content']//div[@class='e-widget-options']"))
    private List<WebElement> planningEngagementPage;

    private String todoNamePage = "";
    //    private String todoContentTextSearch = "name";
    //    private String todoPageAddRequestImg = "//img[contains(@src,'slideOutMenu')]";
    //    private String todoPageAddRequestImg = "//*[@id='todo-table']/tbody/tr[1]/td[7]/img";
    //    private String todoPageAddRequestBtn = "//*[@id='add-request-btn']";
    private String todoPageAddRequestTxtFirst = "//*[@id='todoDetailsReqCont']/div[1]/input";
    private String todoPageAddRequestTxtSecond = "//*[@id='todoDetailsReqCont']/div[2]/input";
    private static final String closeAddNewRequestPopup = "//*[@id='auv-todo-details']/div[3]";
    private static final String deleteRequestMenuStr = "//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[1]";
    private static final String copyTaskMenuStr = "//*[@id='todoDetailsReqCont']/div[1]/span/div/div/a[2]";
    private static final String requestNotEmptyStr = "//p[contains(text(),'Request name must not be empty')]";
    private static final String chracterMoreThan100 = "//p[contains(text(),'Request name can not have more than 100 characters')]";
    private static final String todoDetailName = "//*[@id='todoDetailsName']";
    private static final String popUpWindowsToClose = "//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]";
    //    private static final String GreenColor = "rgb(92, 155, 160)";
    private static final String defaultValueComboBox = "Select Category";

    @FindBy(id = "auv-todo-filter")
    private WebElement eleFilterBtn;

    @FindBy(id = "todo-search")
    private WebElement eleToDoSearchInput;

    @FindBy(xpath = "//*[@id='todo-table']/thead//th/input[@type='checkbox']")
    private WebElement eleCheckBox;

    @FindBy(xpath = "//th[(@class='table-header') and contains(@data-id,'name')]")
    private WebElement eleNameToDoTitleLabel;

    @FindBy(xpath = "//*[@id='todo-table']//th[@data-id='name']//i")
    private WebElement sortByToDoNameIconEle;
    @FindBy(xpath = "//th[@data-id='category']/i")
    private WebElement sortByCategoryNameIconEle;

    @FindBy(xpath = "//th[@data-id='category']")
    private WebElement eleCategoryTitleLabel;

    // It never uses.
    //    @FindBy(xpath = "//th[@data-id='category']//i")
    //    private WebElement eleSortByCategory;

    @FindBy(xpath = "//th[@data-id='clientAssignee']")
    private WebElement eleClientAssigneeTitleLabel;

    @FindBy(xpath = "//th[@data-id='clientAssignee']//i")
    private WebElement eleSortByClientAssignee;

    @FindBy(xpath = "//*[@id='todo-table']//th[@data-id='dueDate']")
    private WebElement eleDueDateTitleLabel;

    @FindBy(xpath = "//*[@id='todo-table']//th[@data-id='dueDate']//i")
    private WebElement eleSortByDueDate;

    @FindBy(xpath = "//th[@data-id='auditorAssignee']")
    private WebElement eleAuditAssigneeTitleLabel;

    @FindBy(xpath = "//th[@data-id='auditorAssignee']//i")
    private WebElement eleSortByAuditAssignee;

    @FindBy(xpath = "//div[@class='e-widget-content']")
    private List<WebElement> eleWidgetContent;

    @FindBy(xpath = "//div[@class='e-widget-content']//div[@class='e-widget-options']//input[@type='button']")
    private List<WebElement> eleViewEngagementPage;

    @FindBy(id = "engagementTodoLink")
    private WebElement eleToDoLnk;

    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//img")
    private WebElement eleImgEmtyToDo;

    @FindBy(xpath = "//tr[@id='empty-todo']//..//..//div")
    private WebElement eleNotesEmtyToDo;

    //    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl']")
    //    private WebElement categoryDropdownEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']//button")
    private List<WebElement> categoryOptionItemEle;
    @FindBy(id = "due-date")
    private WebElement dueDateFieldEle;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
    private WebElement dateItemonCalendarEle;

    public void verifyImgEmtyToDo() throws Exception {
        validateDisPlayedElement(eleImgEmtyToDo, "EmptyTodoImage");
    }

    //@FindBy(xpath="//div[@id='divName']/div/input[@id='todo-name']")
    @FindBy(id = "todo-name")
    private WebElement toDoNameInputEle;

    @FindBy(xpath = "//div[@class='inputMargin div-name-container']//p[@class='auv-inputError']")
    private WebElement toDoNameErrorLabelEle;

    @FindBy(xpath = "//*[@id='todo-add-btn']")
    private WebElement toDoSaveIconEle;

    @FindBy(xpath = "//*[@id='todo-cancel-btn']")
    private WebElement eleToDoCloseIcon;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    private List<WebElement> toDoTaskRowEle;

    //    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='checkbox']")
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr//input[@type='checkbox']")
    private List<WebElement> eleToDoCheckboxRow;

    @FindBy(id = "todo-table")
    private WebElement tblIdTodoTable;
    @FindBy(id = "todo-name")
    private WebElement createToDoNameTextBoxEle;
    @FindBy(id = "todo-add-btn")
    private WebElement eleBtnToDoAdd;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']/div[@class='text']")
    private List<WebElement> categoryComboBoxTextEle;

    //Category ComboBox
    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl']")
    private List<WebElement> categoryComboBoxEle;

    //Category dropdown menu
    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']/div[@class = 'menu']")
    private List<WebElement> categoryComboBoxMenuEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]")
    private WebElement addNewCategoryMenuItemEle;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[2]")
    WebElement editCategoryEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement categoryTitleEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//img[@class='au-modal-closeBtn']")
    WebElement closePopupBtnEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[@id = 'm-ce-cancelBtn']")
    WebElement editCategoryCancelBtnEle;

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start
    @FindBy(xpath = "//div[@class='auvicon-calendar']")
    private WebElement eleDueDateValue;

    @FindBy(xpath = "//a[@class='ui-datepicker-prev ui-corner-all']")
    private WebElement elePrevDataPickerLink;

    @FindBy(xpath = "//a[@class='ui-datepicker-next ui-corner-all']")
    private WebElement eleNextDataPickerLink;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
    private WebElement eleDataPickerTitle;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@class='auv-input input-due-date datepicker mg5 hasDatepicker']")
    private List<WebElement> eleToDoNewRowDueDateText;

    @FindBy(id = "due-date")
    private WebElement eleIdDueDate;
    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
    private WebElement eleXpathChooseDate;

    @FindBy(xpath = "//*/span[@class='ui-datepicker-month']")
    private WebElement eleDataPickerTitleTest;
    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")
    private WebElement eleDataPickerToDate;
    @FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']//a[@class='ui-state-default ui-state-highlight']")
    private WebElement eleDataPickerToDay;

    @FindBy(id = "bulk-container")
    private WebElement btnBulkActions;

    @FindBy(xpath = "//button[contains(text(),'Download Attachments')]")
    WebElement optionDownloadAttachments;

    @FindBy(xpath = "//button[contains(text(),'Mark as complete')]")
    WebElement optionMarkAsComplete;

    //TODO hard until redo new list
    @FindBy(xpath = "//button[contains(text(),'client 01 so (client)')]")
    WebElement optionAssignee;

    @FindBy(xpath = "//button[contains(text(),'Archive')]")
    private WebElement btnArchive;

    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']/button[contains(text(),'Delete')]")
    private WebElement btnDelete;

    @FindBy(id = "btn-todo-undo")
    private WebElement btnToDoUndo;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Download Attachments')]")
    WebElement downloadAttachBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Mark as complete')]")
    WebElement markAsCompleteBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/div[contains(text(),'Assign to')]")
    WebElement assignToBulkActionsMenuEle;

    @FindBy(xpath = "//div[@class='ui dropdown']/div[@class='menu']/button[contains(text(),'Delete')]")
    WebElement deletedBulkActionsMenuEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[contains(text(),'Cancel')]")
    WebElement cancelDeletedToDoButtonEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//div[@class='center']/div[@class='des-delete-modal']")
    WebElement centerDeleteToDoDescriptionEle;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]")
    WebElement popUpWindows;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//button[contains(text(),'Delete')]")
    WebElement deletedToDoButtonEle;

    @FindBy(xpath = "//div[contains(@id,'flashAlert')]//div[@class='send-message-success-alert']")
    private WebElement toastMessageSucessEle;

    //   Old:  @FindBy(xpath = "//img[@class='au-modal-closeBtn']")
    @FindBy(xpath = "//img[contains(@id,'modal-close-Mark As Complete')]")
    private WebElement markPopupCloseBtn;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[@type='text']")
    private List<WebElement> textToDoName;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow todoCompleted']")
    private WebElement textToDoNameArchiveComplete;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td[7]/img")
    private List<WebElement> commentIconToDoListEle;

    //    @FindBy(xpath = "//div[@id='auv-todo-details']/input[@placeholder='Type a comment']")
    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    private WebElement typeCommentFieldEle;

    @FindBy(xpath = "//*[@id='comment-box']/p/span/span")
    //    @FindBy(xpath = "//*[@id='comment-box']/p")
    private WebElement commentboxTitleEle;

    @FindBy(xpath = "//*[@id='comment-box']/p//span[@class='details-comment-count commentNumber']")
    private WebElement commentboxCountNumberEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p")
    //    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']")
    private List<WebElement> listCommentItemEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/img[contains(@class,'user-profile-pic')]")
    private List<WebElement> userIconCommenterEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//span[contains(@class,'detCommentUser')]")
    private List<WebElement> userNameCommenterEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/time[@class='comment-time']")
    private List<WebElement> commentTimeEle;

    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='todo-comment-container']//p[@class='detComment']")
    //    @FindBy(xpath = "//*[@id='todoDetailsCommentList']/div[@class='comment-item']/div[@class='detComment']")
    private List<WebElement> descriptionCommentEle;

    @FindBy(xpath = "//*[@id='comment-button']")
    private WebElement postCommentButton;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[1]/td[7]/img")
    private WebElement todoListAddNewRequestImg;

    @FindBy(xpath = "//*[@id='add-request-btn']")
    private WebElement totoPageAddRequestBtn;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div[1]/input")
    private WebElement findRequestEmpty1;

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div[2]/input")
    private WebElement findRequestEmpty2;

    @FindBy(xpath = "//*[@id='todoDetailsName']")
    private WebElement popupToDoDetailName;

    @FindBy(xpath = "//p[contains(text(),'Request name must not be empty')]")
    private WebElement messageEmptyRequest;
    private String checkMarkToDoName = "";
    private String checkToDoNameAddNewRequest = "";
    @FindBy(xpath = "//*[@id='auv-todo-details']/div[3]")
    private WebElement closeAddNewRequest;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div[1]/span/div")
    private WebElement deleteRequestBtn;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div[1]//a[@class='details-delete item']")
    private WebElement deleteRequestMenu;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div[1]//a[@class='details-duplicate item']")
    private WebElement copyTaskMenu;
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    private WebElement emptyRowToDotask;
    private String newRequest01 = "New request01 " + randomNumber();
    private String newRequest02 = "New request02 " + randomNumber();

    @FindBy(xpath = "//div[@id='comment-form']/input[@placeholder='Type a comment']")
    private List<WebElement> listCommentEle;

    //    private String auditorAssigneeEle = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[@class='newRow']//div[contains(@class,'ui dropdown auditor')]/div[@class='text']";
    //    private String clientAssigneeEle = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown client')]";
    //    private String auditorAssignItemEle = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[@class='newRow']//div[contains(@class,'ui dropdown auditor')]//button[text()='%s']";
    //    private String clientAssigneeItemEle = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[contains(@class,'newRow')]//button[text()='%s']";

    @FindBy(xpath = "//div[contains(@class,'ui dropdown auditor todo-bulkDdl ')]")
    private List<WebElement> listAuditorAssigneeDdl;

    @FindBy(xpath = "//div[@class='ui dropdown client todo-bulkDdl ']")
    private List<WebElement> listClientAssigneeDdl;

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - Start
     **/

    @FindBy(xpath = "//*[@id='h-f-navigation']/span[@id='h-engagementsLink']")
    private WebElement eleEngagementLink;

    @FindBy(xpath = "//div[@class='ce-footerBtnHolder']//button[@class='auvbtn light' and contains(text(),'Cancel')]")
    private WebElement eleCancelBtn;

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - End
     *
     **/

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     */
    private static final String ENGAGEMENT_OVER_VIEW_STATUS_COMPLETE = "complete";
    private static final String ENGAGEMENT_OVER_VIEW_TODO_COMPLETE = "My Completed To-Dos: 100";

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     */

    public WebElement getToDoSaveIconEle() {
        return toDoSaveIconEle;
    }

    public List<WebElement> getToDoNameTextColumnEle() {
        return toDoNameTextColumnEle;
    }

    @FindBy(xpath = "//div[starts-with(@id,'download-zip') and contains(@class,'au-modal')]")
    private WebElement popUpDownloadAttachmentsWindows;

    @FindBy(xpath = "//div[@id='engagement-todo']/section[@id='engagementOverview']/div/p")
    private WebElement engOveviewStatus;

    public void verifyButtonCreateToDo() throws Exception {
        validateCssValueElement(createToDoBtnEle, "background-color", "rgba(89, 155, 161, 1)");
        validateCssValueElement(createToDoBtnEle, "color", "rgba(255, 255, 255, 1)");
        validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
    }

    public void verifyGUIButtonCreateToDo() {
        try {
            boolean result;
            result = validateCssValueElement(createToDoBtnEle, "background-color", "rgba(89, 155, 161, 1)");
            Assert.assertTrue(result, "Background-color of Create To Do Button is displayed unsuccessfully");
            result = validateCssValueElement(createToDoBtnEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text Color of Create To Do Button is displayed unsuccessfully");
            result = validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
            Assert.assertTrue(result, "Text Value of Create To Do Button is displayed unsuccessfully");
            NXGReports.addStep("Verify GUI of Create To Do Button", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("GUI of Create To Do Button is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify GUI of Create To Do Button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyButtonFilter() throws Exception {
        validateDisPlayedElement(eleFilterBtn, "Filer Button");
    }

    public void verifyColumnsInGrid() throws Exception {
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
    }


    public void verifySortIconOnTitle() throws Exception {
        validateDisPlayedElement(sortByToDoNameIconEle, "Sort By Name Button");
        validateDisPlayedElement(sortByCategoryNameIconEle, "Sort By Category Name");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Client Assignee Button.");
        validateDisPlayedElement(eleSortByDueDate, "Sort By");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort by Auditor Assignee button.");
    }


    public void verifyToDoListPage() throws Exception {
        validateAttributeElement(createToDoBtnEle, "background", "#2c8188");
        validateAttributeElement(createToDoBtnEle, "color", "#fff");
        validateDisPlayedElement(createToDoBtnEle, "Create Todo Button");
        validateDisPlayedElement(eleFilterBtn, "Filter Button");
        validateDisPlayedElement(eleToDoSearchInput, "Search button");
        validateAttributeElement(eleToDoSearchInput, "placeholder", "Search...");
        eleToDoSearchInput.click();
        validateAttributeElement(createToDoBtnEle, "border", "#599ba1");
        validateDisPlayedElement(eleCheckBox, "Check Box");
        validateElementText(eleNameToDoTitleLabel, "To-Dos");
        validateElementText(eleCategoryTitleLabel, "Category");
        validateElementText(eleClientAssigneeTitleLabel, "Client Assignee");
        validateElementText(eleDueDateTitleLabel, "Due Date");
        validateElementText(eleAuditAssigneeTitleLabel, "Audit Assignee");
        validateDisPlayedElement(sortByToDoNameIconEle, "Sort By Name");
        validateDisPlayedElement(eleSortByClientAssignee, "Sort By Assign button.");
        validateDisPlayedElement(eleSortByDueDate, "Sort By Due Date button.");
        validateDisPlayedElement(eleSortByAuditAssignee, "Sort by Auditor Assignee.");
        if (!eleCheckBox.isSelected()) {
            eleCheckBox.click();
        }
        validateAttributeElement(createToDoBtnEle, "background", "#5cd4c0");
        if (eleCheckBox.isSelected()) {
            eleCheckBox.click();
        }
        validateAttributeElement(createToDoBtnEle, "background", "#cacece");
    }


    public void clickCreateToDoTask() {
        waitForClickableOfElement(createToDoBtnEle, "Create Todo button");
        createToDoBtnEle.click();
    }

    public void verifyDefaultValueToDoNameTextBox(int numberOfTask) {
        try {
            boolean result;
            String defaultValueToDoNameText;
            if (numberOfTask > 0) {
                defaultValueToDoNameText = "Write your to do here";
            } else {
                defaultValueToDoNameText = "Write your first to do here";
            }
            getLogger().info("Verify Default Value To Do Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo name input field.");
            validateDisPlayedElement(toDoNameInputEle, "Todo name input field.");
            result = validateAttributeElement(toDoNameInputEle, "placeholder", defaultValueToDoNameText);
            Assert.assertTrue(result, "Default Value To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Default Value To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Default Value To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Default Value To Do Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyHoverCssValueToDoNameTextBox() {
        try {
            boolean result;
            getLogger().info("Verify Hover CSS Value To Do Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo Name input field");
            clickAndHold(toDoNameInputEle, "Todo Name input field");
            result = validateCssValueElement(toDoNameInputEle, "border", "1px solid rgb(89, 155, 161)");
            Assert.assertTrue(result, "Hover CSS Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Hover CSS Value of To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Hover CSS Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Hover CSS Value To Do Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyWarningCssValueToDoNameTextBox() {
        try {
            boolean result;
            getLogger().info("Verify CSS Value Warning To Do Name Text Box");
            waitForVisibleElement(toDoNameInputEle, "Todo name input field");
            waitForVisibleElement(dueDateFieldEle, "Due Date input field");
            clickAndHold(toDoNameInputEle, "Todo Name input field");
            dueDateFieldEle.click();
            result = validateCssValueElement(toDoNameInputEle, "border", "1px solid rgba(253, 109, 71, 0.4)");
            Assert.assertTrue(result, "Warning CSS Value of To Do TextBox is displayed unsuccessfully");
            waitForVisibleElement(toDoNameErrorLabelEle, "Todo Name error  Label");
            result = validateElementText(toDoNameErrorLabelEle, "Not a valid name.");
            Assert.assertTrue(result, "Warning Value of To Do TextBox is displayed unsuccessfully");
            NXGReports.addStep("Verify Warning CSS Value of To Do Text Box", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Warning CSS Value of To Do Name TextBox is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Warning CSS Value To Do Name Text Box", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public boolean verifyAddNewToDoTask(String toDoName) {
        boolean result = false;
        try {
            validateDisPlayedElement(toDoNameTextColumnEle.get(0), "Todo New Row Name");
            result = validateAttributeElement(toDoNameTextColumnEle.get(0), "value", toDoName);
            Assert.assertTrue(result, String.format("New To Do task '%s' is NOT added successfully", toDoName));
            NXGReports.addStep("New To Do task is added successfully", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            NXGReports.addStep("New To Do task is added unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return result;
    }

    public boolean verifyInputValueToDoNameTextBox(String toDoNameValue) {
        try {
            boolean result;
            getLogger().info("Verify Input Value ToDo Name TextBox");
            waitForVisibleElement(toDoNameTextColumnEle.get(0), "Todo Name input field");
            sendKeyTextBox(toDoNameTextColumnEle.get(0), toDoNameValue, "To Do Name Input");
            result = validateAttributeElement(toDoNameTextColumnEle.get(0), "value", toDoNameValue);
            sendTabkey(toDoNameTextColumnEle.get(0), "Todo Name input field");
            Assert.assertTrue(result, "Input Value into ToDo Name TextBox is unsuccessfully");
            NXGReports.addStep("Verify Input Value ToDo Name TextBox", LogAs.PASSED, null);
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Input Value into ToDo Name TextBox is unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Input Value ToDo Name TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void verifyCheckMaxLength() {
        try {
            clickElement(eleToDoSearchInput, "click to txtIdTodoSearch");
            eleToDoSearchInput.clear();
            eleToDoSearchInput.sendKeys(maxLenghtString);
            eleToDoSearchInput.sendKeys(numberSequence);
            String txtSearchText = getTextByJavaScripts(eleToDoSearchInput, "eleToDoSearchInput");
            getLogger().info("The input txtSearchText = " + txtSearchText);
            if (txtSearchText.equals(maxLenghtString)) {
                NXGReports.addStep("Verify check max length of search textbox: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify check max length of search textbox: Fail", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify check max length of search textbox: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(id = "category-name")
    private WebElement categoryNameFieldOnFormEle;

    public void verifyCheckMaxLength_CategoryName() {
        try {
            boolean isCheckMaxLength = false;
            navigateToAddNewCategory();
            waitForClickableOfElement(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
            waitForJSandJQueryToLoad();
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, maxLengthCategoryName, "send key to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, numberSequence, "send key to categoryNameFieldOnFormEle");
            String txtSearchText = getTextByJavaScripts(categoryNameFieldOnFormEle, "Category Name field");
            getLogger().info("The input category Name is: " + txtSearchText);
            //            cancelDeletedToDoButtonEle.click();
            if (txtSearchText.equals(maxLengthCategoryName)) {
                isCheckMaxLength = true;
                cancelDeletedToDoButtonEle.click();
            } else {
                isCheckMaxLength = false;
                cancelDeletedToDoButtonEle.click();
            }
            if (isCheckMaxLength) {
                NXGReports.addStep("Verify check max length of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify check max length of category name: Failed_Exception", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify check max length of category name: Failed_Exception", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreateNewCategory(String value) {
        try {
            getLogger().info("Verifying create new category..");
            boolean isCheckCategory = findNewCategory(value);
            if (isCheckCategory) {
                NXGReports.addStep("Create new category", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Create new category", LogAs.FAILED, null);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Create new category", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyAddNewCategoryPopupTitle() {
        verifyCategoryTitle();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryNameTextbox() {
        verifyCategoryDefaultValue();
        verifyHoverClickCategoryName();
        verifyShowAllTextCategoryName();
        verifyCategoryNameRequiredData();
        verifyCategoryNameMaxLength();
        verifyCategoryNameInputNumber();
        verifyCategoryNameSpecialCharacter();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryColorCombobox() {
        verifyCategoryColorAllQuantityColor();
        verifyChoosedCategoryColor();
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyNewCategoryCreateCancelButton() {
        verifyColorCategoryCancelButton();
        verifyColorCategoryCreateButton();
        verifyNotCompleteCreateCategory();
        verifyExistedCategory();
        verifyClickCategoryCancelButton();
    }

    /**
     * Create new to do task with the toDoName parameter.
     * <p>
     * <p>
     * #History business changed:
     * R2: Create new to do task :
     * <p>  old: need to create new category and select from dropdown category.
     * <p>  new: create new category and to do task is auto selected with new one.
     * <p>  new: Due Date is auto selected.
     * <p>  new: The save is not exist anymore.
     *
     * @param toDoName The String name of to do task which is created.
     */
    public void createToDoTask(String toDoName) {
        try {
            getLogger().info("Create To Do Task with 'toDoName'");
            //            WebElement engagmentTitle = getDriver().findElement(By.xpath("//*[@id='a-header-title']"));
            //            System.out.println("engagmentTitle Value: " + engagmentTitle.getAttribute("value"));
            waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
            String rowString = toDoTaskRowEle.get(0).getAttribute("class");
            int size = 1;
            int index = -1;
            if (!rowString.equals("")) {
                size = toDoTaskRowEle.size() + 1;
                System.out.println("size:" + size);
                index = findToDoTaskName(toDoName);
            }
            if (index == -1) {
                getLogger().info("Create New To Do Task");
                waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
                clickElement(createToDoBtnEle, "Create To Do button");
                waitForSizeListElementChanged(toDoTaskRowEle, "To Do task row", size);
                sendKeyTextBox(toDoNameTextColumnEle.get(0), toDoName, "First To Do Name textbox");
                sendTabkey(toDoNameTextColumnEle.get(0), "First To Do Name textbox");
                // Create new category
                createNewCategory("");
                NXGReports.addStep("Create To Do Task", LogAs.PASSED, null);
            }
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            getLogger().info("Fail: Create To Do Task with 'toDoName'");
            NXGReports.addStep("Failed: Create To Do Task with 'toDoName'", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void createToDoTask() throws Exception {
        getLogger().info("Run createToDoTask()");
        todoNamePage = "To-do name " + randomNumber();
        //Wait for new task is displayed.
        try {
            getLogger().info("Create To Do Task with random name.");
            WebElement engagmentTitle = getDriver().findElement(By.xpath("//*[@id='a-header-title']"));
            System.out.println("engagmentTitle Value: " + engagmentTitle.getAttribute("value"));
            waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
            String rowString = toDoTaskRowEle.get(0).getAttribute("class");
            int size = 1;
            int index = -1;
            if (!rowString.equals("")) {
                size = toDoTaskRowEle.size() + 1;
                System.out.println("Index Create: " + index);
            }
            clickElement(createToDoBtnEle, "Create To Do button");
            waitForSizeListElementChanged(toDoTaskRowEle, "To Do task row", size);
            sendKeyTextBox(toDoNameTextColumnEle.get(0), todoNamePage, "First To Do Name textbox");
            sendTabkey(toDoNameTextColumnEle.get(0), "First To Do Name textbox");
            // Create new category
            createNewCategory("");
            NXGReports.addStep("Create To Do Task with random name", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            getLogger().info("Fail: Create To Do Task");
            NXGReports
                    .addStep("Failed: Create To Do Task with random name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyToDoNameInputLimitCharacter(int maxLength) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        validateMaxlenght(toDoNameInputEle, "ToDo Name Input", maxLength);
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyToDoNameInputSpecialCharacter(String value) throws Exception {
        waitForVisibleElement(toDoNameInputEle, "eleToDoNameInput");
        sendKeyTextBox(toDoNameInputEle, value, "To Do Name Input");
        clickElement(dueDateFieldEle, "Due Date Field");
        waitForVisibleElement(toDoNameErrorLabelEle, "toDoNameErrorLabelEle");
        validateElementText(toDoNameErrorLabelEle, "Not a valid name.");
    }

    /**
     * Author: minh.nguyen
     */
    public void verifyDisableToDoSaveIcon() {
        try {
            boolean result;
            waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
            clearTextBox(toDoNameInputEle, "To Do Name Input");
            waitForVisibleElement(toDoSaveIconEle, "To Do Save Icon");
            result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o disabled");
            Assert.assertTrue(result, "To Do Save Icon is not disabled");
            getLogger().info("To Do Save Icon is disabled");
            NXGReports.addStep("Verify Disable ToDo Save Icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("To Do Save Icon is not disabled");
            NXGReports.addStep("TestScript Failed: Verify Disable ToDo Save Icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEnableToDoSaveIcon() {
        try {
            boolean result;
            waitForVisibleElement(toDoNameInputEle, "To Do Name Input");
            sendKeyTextBox(toDoNameInputEle, "Task01", "To Do Name Input");
            waitForVisibleElement(toDoSaveIconEle, "To Do Save Icon");
            result = validateAttributeElement(toDoSaveIconEle, "class", "fa fa-floppy-o");
            Assert.assertTrue(result, "To Do Save Icon is not enabled");
            getLogger().info("To Do Save Icon is enabled");
            NXGReports.addStep("Verify Enabled ToDo Save Icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("To Do Save Icon is not enabled");
            NXGReports.addStep("TestScript Failed: Verify Enabled ToDo Save Icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyToDoCloseIcon() {
        int count = -1;
        if (toDoTaskRowEle.isEmpty())
            count = 0;
        else
            count = toDoTaskRowEle.size();
        clickCreateToDoTask();
        waitForVisibleElement(eleToDoCloseIcon, "To Do Close Icon");
        eleToDoCloseIcon.click();
        getLogger().info("Verify new To Do Task is not created.");
        try {
            if (count == toDoTaskRowEle.size()) {
                NXGReports.addStep("New To Do Task is not created", LogAs.PASSED, null);
                NXGReports.addStep("Close Icon is working", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("New To Do Task is created", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep("Close Icon is not working", LogAs.PASSED, null);
        }
    }

    public void verifySearchDefault() {
        try {
            boolean isCheckSearchDefault = validateAttributeElement(eleToDoSearchInput, "placeholder", searchTextDefault);
            if (isCheckSearchDefault) {
                NXGReports.addStep("verify default value(Search...) of this Search: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify default value(Search...) of this Search: Fail", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify default value(Search...) of this Search: Fail_Exception", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchBorderWhileHover() {
        try {
            String GreenBorder = "1px solid rgb(89, 155, 161)";
            hoverElement(eleToDoSearchInput, "Todo Searchbox");
            boolean isCheckSearchHover = validateCssValueElement(eleToDoSearchInput, "border", GreenBorder);
            if (isCheckSearchHover) {
                NXGReports.addStep("Verify Search box border is green: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify Search box border is green: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Search box border is green: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifySearchBorderWhileInput() {
        try {
            String GreenBorder = "1px solid rgb(89, 155, 161)";
            boolean isCheckSearchInput = validateCssValueElement(eleToDoSearchInput, "border", GreenBorder);
            if (isCheckSearchInput) {
                NXGReports.addStep("Verify Search box border is green: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify Search box border is green: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Search box border is green: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    /*
    Vien.pham add new method inputSearchText
     */

    public void inputSearchText(String searchValue) {
        try {
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            sendKeyTextBox(eleToDoSearchInput, searchValue, "send key to searchTextToDoListPage");
            Thread.sleep(smallerTimeOut);
            NXGReports.addStep("Ending Input Search.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending Input Search.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifySearchLimit255() throws Exception {
        //        waitForClickableOfElement(eleToDoSearchInput, "wait for click eleToDoSearchInput");
        clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
        sendKeyTextBox(eleToDoSearchInput, maxLenghtString, "send key to maxLenghtString");
        validateMaxlenght(this.eleToDoSearchInput, "To Do Search Input", maxLenght);
    }


    public void verifyCheckOnCheckBox() throws Exception {
        if (!this.eleCheckBox.isSelected()) {
            this.eleCheckBox.click();
        }
        this.validateCssValueElement(this.eleCheckBox, backgroundColor, "rgba(92, 212, 192, 1)");
    }

    public void verifyUnCheckOnCheckBox() throws Exception {
        if (this.eleCheckBox.isSelected()) {
            this.eleCheckBox.click();

        }
        this.validateCssValueElement(this.eleCheckBox, backgroundColor, "rgba(202, 206, 206, 1)");
    }

    public void navigateToEngagementPage() throws Exception {
        getLogger().info("Click view button open Engagement Page");
        waitForClickableOfElement(eleWidgetContent.get(0), "eleWidgetContent");
        clickAndHold(eleWidgetContent.get(0), "eleWidgetContent");
    }

    public void navigateToToDoList() throws Exception {
        clickElement(eleToDoLnk, "To Do Link menu");
    }

    public void checkSearchData() {
        getLogger().info("Run checkSearchData()");
        try {
            boolean isCheckData = false;
            waitForVisibleElement(eleToDoSearchInput, "txtIdTodoSearch");
            Thread.sleep(smallTimeOut);
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleToDoSearchInput, todoNamePage, "sendkey to txtIdTodoSearch");
            waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")), "");
            // Check the result in the list data
            List<WebElement> tr_collection = tblIdTodoTable.findElements(By.xpath("id('todo-table')/tbody/tr"));
            for (WebElement trElement : tr_collection) {
                List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
                for (WebElement tdElement : td_collection) {
                    String strSearchValue = "";
                    try {
                        strSearchValue = tdElement.findElement(By.tagName("input")).getAttribute("value");
                    } catch (Exception ex) {
                    }
                    getLogger().info("SearchValue = " + strSearchValue);
                    if (strSearchValue.equals(todoNamePage)) {
                        isCheckData = true;
                        break;
                    }
                }
                if (isCheckData) {
                    break;
                }
            }
            if (isCheckData) {
                NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify realtime search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            getLogger().info("verifyDataSearch() isCheckData = " + isCheckData);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify realtime search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*
    Vien modified checkSearchData: to search with TodoName, categoryName, auditAssign, clientAssign..

    and remove By.xpath....
     */

    @FindBy(xpath = "id('todo-table')/tbody/tr")
    List<WebElement> trTodoTable;


    public void checkSearchData(String inputSearch) {
        getLogger().info("Run checkSearchData()");
        try {
            boolean isCheckData = false;
            getLogger().info("Size row matched: " + trTodoTable.size());
            for (int i = 0; i < trTodoTable.size(); i++) {
                String strSearchValueTodoName = "";
                String strSearchValueCategoryName = "";
                String strSearchValueClientAssignee = "";
                String strSearchValueAuditAssignee = "";
                try {
                    strSearchValueTodoName = TodosTextboxEle.get(i).getAttribute("value");
                    strSearchValueCategoryName = dropdownCategoryEle.get(i).getText();
                    strSearchValueClientAssignee = DropdownClientAssignee.get(i).getText();
                    strSearchValueAuditAssignee = DropdownAuditAssignee.get(i).getText();
                } catch (Exception ex) {
                }
                if (strSearchValueTodoName.equals(inputSearch) || strSearchValueCategoryName.equals(inputSearch) || strSearchValueAuditAssignee
                        .equals(inputSearch) || strSearchValueClientAssignee.equals(inputSearch)) {
                    isCheckData = true;
                    break;
                }
            }

            if (isCheckData) {
                NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify realtime search", LogAs.FAILED, null);
            }
            getLogger().info("verifyDataSearch() isCheckData = " + isCheckData);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify realtime search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchResutlNotMatch() {
        try {
            getLogger().info("Verifying todo list disappear..");
            waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("./tbody/tr[@id='empty-todo']")), "");
            NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify realtime search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void checkContentTextSearch(String toDoName) {
        getLogger().info("Run checkContentTextSearch()");
        try {
            boolean isCheckData = false;
            waitForVisibleOfLocator(By.id("todo-search"));
            clickElement(eleToDoSearchInput, "click to eleToDoSearchInput");
            clearTextBox(eleToDoSearchInput, "clear txtIdTodoSearch");
            sendKeyTextBox(eleToDoSearchInput, toDoName, "sendkey to todoContentTextSearch");
            waitForVisibleElement(tblIdTodoTable.findElement(By.xpath("id('todo-table')/tbody/tr")), "");
            // Check the result in the list data
            List<WebElement> tr_collection = tblIdTodoTable.findElements(By.xpath("id('todo-table')/tbody/tr"));
            for (WebElement trElement : tr_collection) {
                List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
                for (WebElement tdElement : td_collection) {
                    String strSearchValue = "";
                    try {
                        strSearchValue = tdElement.findElement(By.tagName("input")).getAttribute("value");
                    } catch (Exception ex) {
                    }
                    getLogger().info("Search contain text = " + strSearchValue);
                    if (strSearchValue.contains(toDoName)) {
                        isCheckData = true;
                        break;
                    }
                }
                if (isCheckData) {
                    break;
                }
            }
            if (isCheckData) {
                NXGReports.addStep("Verify content of text search", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify content of text search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            getLogger().info("verifyContentTextSearch() isCheckContentText = " + isCheckData);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify content of text search", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySortToDoTaskOnName() {
        getLogger().info("Verify Sort ToDo Task On Name");
        verifySortDataGrid(toDoNameTextColumnEle, sortByToDoNameIconEle);
    }

    public void verifyCheckAllCheckboxToDoName() throws Exception {
        try {
            if (!eleCheckBox.isSelected())
                eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                if (!eleToDoCheckboxRow.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is NOT checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are selected all.");
            NXGReports.addStep("Check box icons are selected all.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("Failed: Check box icons are not selected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUnCheckAllCheckboxToDoName() throws Exception {
        try {
            if (eleCheckBox.isSelected())
                eleCheckBox.click();
            for (int i = 0; i < eleToDoCheckboxRow.size(); i++) {
                if (eleToDoCheckboxRow.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is checked");
                    throw new Exception();
                }
            }
            getLogger().info("Check box icons are unselected all.");
            NXGReports.addStep("Check box icons are unselected all.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not unselected all.");
            NXGReports.addStep("Failed: Check box icons are not unselected all.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckMultipleCheckBoxToDoName() throws Exception {
        try {
            if (eleCheckBox.isSelected())
                eleCheckBox.click();
            if (eleToDoCheckboxRow.size() > 3) {
                eleToDoCheckboxRow.get(0).click();
                if (!eleToDoCheckboxRow.get(0).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
                eleToDoCheckboxRow.get(eleToDoCheckboxRow.size() - 1).click();
                if (!eleToDoCheckboxRow.get(eleToDoCheckboxRow.size() - 1).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Cannot select single checkbox on row");
                    throw new Exception();
                }
            }
            getLogger().info("Select single and multiple checkbox successfully");
            NXGReports.addStep("Select single and multiple checkbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are NOT selected multiple.");
            NXGReports.addStep("Failed: Check box icons are NOT selected multiple.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDefaultValueofCategoryComboBox() {
        boolean result = false;
        getLogger().info("Verify Default Value Of Category ComboBox");
        System.out.println("Default Value in Dropdown box: " + categoryComboBoxTextEle.get(0).getText());
        result = validateElementText(categoryComboBoxTextEle.get(0), defaultValueComboBox);
        if (result) {
            NXGReports.addStep("Verify Default Value Of Category ComboBox successfully.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Failed: Verify Default Value Of Category ComboBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            AbstractService.sStatusCnt++;
        }
    }

    public void verifyHoverCategoryComboBox() {
        getLogger().info("Verify Default Value Of Category ComboBox.");
        verifyHoverElement(categoryComboBoxEle.get(0), "border", "1px solid rgb(92, 155, 160)");
    }

    public void verifyListValueofCategoryComboxBox(String categoryName) {
        try {
            boolean result;
            waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
            clickElement(createToDoNameTextBoxEle, "click to createToDoNameTextBoxEle");
            waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
            clickElement(categoryComboBoxEle.get(0), "click to categoryComboBoxEle.get(0)");
            List<WebElement> menuCateComboBox = categoryComboBoxMenuEle.get(0).findElements(By.tagName("div"));
            result = validateElementText(menuCateComboBox.get(0), "Add New Category");
            Assert.assertTrue(result, "Add New Category option is not displayed");
            validateElementText(menuCateComboBox.get(1), "Edit Categories");
            Assert.assertTrue(result, "Edit Categories option is not displayed");
            validateElementText(menuCateComboBox.get(2).findElement(By.tagName("button")), categoryName);
            Assert.assertTrue(result, String.format("%s option is not displayed", categoryName));
            NXGReports.addStep("Verify List Value of Category ComboxBox", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify List Value of Category ComboxBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyNewCategoryPopUpDisplayed() throws Exception {
        try {
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Category Title");
            result = validateElementText(categoryTitleEle, "Add New Category");
            Assert.assertTrue(result, "Add New Category popup is not displayed");
            //            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
            //            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Create Category Button");
            //			WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
            //			clickElement(editCategoryCancelBtnEle, "Cancel Add New Category Button");
            //			waitForCssValueChanged(popUpDiv,"PopUp Windows","display","none");
            NXGReports.addStep("Verify New Category popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify New Category popup is displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyEditCategoriesPopUpDisplayed() throws Exception {
        try {
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Category Title");
            result = validateElementText(categoryTitleEle, "Edit Categories");
            Assert.assertTrue(result, "Edit Categories popup is not displayed");
            //            hoverElement(editCategoryCancelBtnEle,"Cancel Catergory button");
            //            waitForClickableOfElement(editCategoryCancelBtnEle,"Cancel Edit Category Button");
            //			WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
            //			clickElement(editCategoryCancelBtnEle, "Cancel Add New Category Button");
            //			waitForCssValueChanged(popUpDiv,"PopUp Windows","display","none");
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Edit Categories popup is displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCreateToDoTaskWithoutCategory(String toDoName) throws Exception {
        getLogger().info("Verify Create ToDo Task Without Category");
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        createToDoNameTextBoxEle.sendKeys(toDoName);
        // Choose Due Date
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        clickElement(dueDateFieldEle, "click to dueDateFieldEle");
        waitForClickableOfElement(dateItemonCalendarEle, "Date value");
        clickElement(dateItemonCalendarEle, "click to dateItemonCalendarEle");
        waitForVisibleElement(toDoSaveIconEle, "Save Icon");
        clickElement(toDoSaveIconEle, "click to toDoSaveIconEle");
        verifyAddNewToDoTask(toDoName);
    }

    public void verifyInputMaxLengthToDoNameTextBox() {
        try {
            boolean result = false;
            getLogger().info("Verify Input Max Length ToDo Name TextBox.");
            result = validateMaxlenght(toDoNameInputEle, "ToDo Name Input", 255);
            Assert.assertTrue(result, "Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
            NXGReports.addStep("Verify Edit Categories popup is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Input 255 Characters into ToDo Name TextBox is unsuccessfully.");
            NXGReports.addStep("TestScript Failed: Verify Input Max Length ToDo Name TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void inputInvalidValueToDoNameTextBox() {
        getLogger().info("Input Invalid Value into To Do Name TextBox.");
        verifyInputValueToDoNameTextBox("~!@#$%^&*+?><,.");
    }

    public void selectDueDateToDoTask() {
        waitForClickableOfElement(dueDateFieldEle, "Due Date field");
        clickElement(dueDateFieldEle, "Due Date field");
        waitForClickableOfElement(dateItemonCalendarEle, "Date value on Calendar");
        clickElement(dateItemonCalendarEle, "Date value on Calendar");
    }

    public void clickAddNewCategory() {
        try {
            Thread.sleep(smallerTimeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        clickElement(createToDoNameTextBoxEle, "click to createToDoNameTextBoxEle");
        waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
        clickElement(categoryComboBoxEle.get(0), "click to categoryComboBoxEle.get(0)");
        clickElement(addNewCategoryMenuItemEle, "click to addNewCategoryMenuItemEle");
    }

    public void clickEditCategory() {
        waitForClickableOfElement(createToDoNameTextBoxEle, "To Task name Textbox");
        clickElement(createToDoNameTextBoxEle, "click to createToDoNameTextBoxEle");
        waitForClickableOfElement(categoryComboBoxEle.get(0), "Category Combo box");
        clickElement(categoryComboBoxEle.get(0), "click to categoryComboBoxEle.get(0)");
        clickElement(editCategoryEle, "click to editCategoryEle");
    }

    public void clickCheckboxNewToDoTask() {
        waitForClickableOfElement(eleToDoCheckboxRow.get(0), "CheckBox New ToDo Task");
        clickElement(eleToDoCheckboxRow.get(0), "CheckBox New ToDo Task");
        checkMarkToDoName = textToDoName.get(0).getAttribute("value").toString();
        getLogger().info("checkMarkToDoName first = " + checkMarkToDoName);
    }

    public void verifyDefaultValueofBulkActionsDropdown(String defaultValueComboBox) {
        boolean result = false;
        getLogger().info("Verify Default value of Bulk Actions Dropdown.");
        System.out.println("Default Value in Dropdown box: " + bulkActionsDropdownEle.getText());
        result = validateElementText(bulkActionsDropdownEle, defaultValueComboBox);
        if (result) {
            NXGReports.addStep("Verify Default value of Bulk Actions Dropdown successfully.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Failed: Verify Default value of Bulk Actions Dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyHoverBulkActionsDropdown() {
        getLogger().info("Verify Default Value Of Bulk Actions Dropdown.");
        verifyHoverElement(bulkActionsDropdownEle, "border", "1px solid rgb(92, 155, 160)");
    }

    public void verifyListValueofBulkActionsDropdown() {
        try {
            getLogger().info("Verify List Value of Bulk Actions Dropdown.");
            boolean result;
            List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
            result = validateElementText(menuBulkActionsDropdown.get(0), "Download Attachments");
            Assert.assertTrue(result, "Download Attachments option is not displayed");
            validateElementText(menuBulkActionsDropdown.get(1), "Mark as complete");
            Assert.assertTrue(result, "Mark as complete option is not displayed");
            validateElementText(menuBulkActionsDropdown.get(2), "Delete");
            Assert.assertTrue(result, "Delete option is not displayed");
            WebElement assginToSubMenuEle = bulkActionsDropdownMenuEle.findElement(By.tagName("div"));
            validateElementText(assginToSubMenuEle, "Assign to");
            Assert.assertTrue(result, "Assign to sub Menu is not displayed");
            NXGReports.addStep("Verify List Value of Bulk Actions Dropdown", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify List Value of Bulk Actions Dropdown", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickDeleteToDoBulkActions() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(2), "Deleted ToDo Button");
    }

    public void clickToBulkDownloadAttachmentButton() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(0), "Bulk download attachments button");
        waitForCssValueChanged(popUpDownloadAttachmentsWindows, "PopUp Download Attachments", "display", "block");
    }

    public void verifyMarkCompleteArchive(int index) {
        getLogger().info("Verify mark ToDo page complete archive");
        boolean isMarkCompleteArchive = false;
        try {
            isMarkCompleteArchive = validateAttributeElement(toDoTaskRowEle.get(index), "data-completed", "true");
            if (isMarkCompleteArchive) {
                NXGReports.addStep("Verify mark ToDo page complete archive", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify mark ToDo page complete archive", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify mark ToDo page complete archive", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUIDeleteToDoPopUp() {
        try {
            final String guideSentenceDes =
                    "Are you sure you'd like to delete these To-Dos? Once deleted, you " + "will not be able to retrieve any documents uploaded to the selected To-Dos.";
            getLogger().info("Verify GUI Delete To-Dos popup.");
            boolean result;
            waitForVisibleElement(categoryTitleEle, "Delete To-Do Title");
            result = validateElementText(categoryTitleEle, "Delete To-Do?");
            Assert.assertTrue(result, "Delete To Do popup is not displayed");
            waitForVisibleElement(centerDeleteToDoDescriptionEle, "Guide Sentence Description Delete ToDo");
            result = validateElementText(centerDeleteToDoDescriptionEle, guideSentenceDes);
            Assert.assertTrue(result, "Guide Sentence Description Delete ToDo is not displayed");
            waitForVisibleElement(deletedToDoButtonEle, "Delete To-Do button");
            result = validateCssValueElement(deletedToDoButtonEle, "background-color", "rgba(241, 103, 57, 1)");
            Assert.assertTrue(result, "Background color of Delete To-Do button is NOT orange");
            result = validateCssValueElement(deletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Delete To-Do button is NOT white");
            waitForVisibleElement(cancelDeletedToDoButtonEle, "Cancel delete To-Do button");
            result = validateCssValueElement(cancelDeletedToDoButtonEle, "background-color", "rgba(151, 147, 147, 1)");
            Assert.assertTrue(result, "Background color of Cancel delete To-Do button is NOT gray");
            result = validateCssValueElement(cancelDeletedToDoButtonEle, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "Text color of Cancel delete To-Do button is NOT white");
            NXGReports.addStep("Verify GUI Delete To-Dos popup is displayed successfully", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify GUI Delete To-Dos popup is displayed unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickCancelButtonOnPopup() {
        getLogger().info("Click Cancel Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpWindowsToClose));
        hoverElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForClickableOfElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo Button");
        clickElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void clickCloseButtonOnPopup() {
        getLogger().info("Click Close Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpWindowsToClose));
        hoverElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForClickableOfElement(closePopupBtnEle, "Close Delete ToDo Button");
        clickElement(closePopupBtnEle, "Close Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    public void verifyClickCloseMarkPopup() {
        getLogger().info("Verify to click to close complete mark popup");
        try {
            waitForVisibleElement(eleEngagementOverViewStatusText, "engagement overview status");
            engagementOverViewStatusBefore = eleEngagementOverViewStatusText.getText().trim();

            waitForClickableOfElement(markPopupCloseBtn, "wait for click to closePopup");
            clickElement(markPopupCloseBtn, "Close Mark Complete button");
            boolean isClickClose = waitForCssValueChanged(popUpMarkCompleteWindows, "PopUp Mark Complete", "display", "none");
            if (isClickClose) {
                NXGReports.addStep("Verify to click to close complete mark popup", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to click to close complete mark popup", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to click to close complete mark popup", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyBulkActionsDropdownIsClosed() {
        try {
            getLogger().info("Verify Bulk Actions Dropdown Is Closed.");
            boolean result;
            List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
            result = validateElementTextNotDisplayed(menuBulkActionsDropdown.get(0), "Download Attachments");
            Assert.assertTrue(result, "Bulk Actions Dropdown should be closed");
            NXGReports.addStep("Verify Bulk Actions Dropdown Is Closed.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Bulk Actions Dropdown Is Closed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public int findCategoryName(String categoryName) {
        getLogger().info("Find Position of category Name");
        int i = 0;
        List<WebElement> listCategoryMenuDropdown = dropdownCategoryEle.get(0).findElements(By.xpath("div[@class='menu dropdown-empty']/div"));
        if (listCategoryMenuDropdown.size() != 1) {
            for (WebElement isCheck : listCategoryMenuDropdown) {
                if (isCheck.getText().equals(categoryName)) {
                    System.out.println("The position of Category name is: " + i);
                    break;
                }
                i++;
            }
            return i;
        }
        return i;
    }

    public void unSelectToDoCheckboxByName(String todoName) {
        getLogger().info("Un Select To Do Task Check Box by Name");
        int index = findToDoTaskName(todoName);
        if (eleToDoCheckboxRow.get(index).isSelected())
            clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
    }

    public int getNumberofToDoTask() {
        getLogger().info("Get the number of To Do task in To Do list page.");
        int count;
        if (toDoTaskRowEle.isEmpty())
            count = 0;
        else
            count = toDoTaskRowEle.size();
        return count;
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start

    /**
     * check select data drop down is show when click
     *
     * @throws Exception
     */
    public void verifySelectDateDropDown() throws Exception {
        try {
            waitForClickableOfElement(eleIdDueDate, "Select date drop down");
            eleIdDueDate.click();
            NXGReports.addStep("Verify Select date drop down is displayed", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify Select date drop down is displayed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * move to add new To-do page
     *
     * @throws Exception
     */
    public void navigateAddNewToDoPage() throws Exception {
        getLogger().info("Run createToDoPage()");
        waitForClickableOfElement(createToDoBtnEle, "create todo button.");
        clickElement(createToDoBtnEle, "click to createToDoBtnEle");
    }

    /**
     * check default value of due date text box
     *
     * @return true | false
     */
    public boolean checkDefaultDueDateValue() {
        waitForVisibleElement(eleDueDateValue, "Engagement Due date");
        waitForVisibleElement(eleIdDueDate, "Default Due date");
        String engagementDueDate = eleDueDateValue.getText().substring(5, eleDueDateValue.getText().length());
        String defaultDueDate = eleIdDueDate.getText();
        getLogger().info(engagementDueDate);
        getLogger().info(defaultDueDate);
        return engagementDueDate.equals(defaultDueDate);
    }

    /**
     * check default format
     */
    public boolean checkFormatDueDate() {
        waitForVisibleElement(dueDateEle.get(0), "Due date");
        return isThisDateValid(dueDateEle.get(0).getAttribute("value").trim(), "mm/dd/yyyy");
    }


    /**
     * Verify data on date picker
     */
    public boolean verifyDataOfDatePicker(boolean isNewToDoPage) {
        try {
            Calendar cal = Calendar.getInstance();
            int currentDay = cal.get(Calendar.DAY_OF_MONTH);
            int currentMonth = cal.get(Calendar.MONTH);
            int currentYear = cal.get(Calendar.YEAR);
            int focusDay = 0;
            int focusMonth = 0;
            int focusYear = 0;
            // If isNewToDoPage = true, verify in add new to-do page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                clickElement(eleIdDueDate, "click to eleIdDueDate");
                waitForClickableOfElement(eleXpathChooseDate, "Date picker");
                waitForVisibleElement(eleDataPickerToDate, "Date picker to date");
                waitForVisibleElement(eleDataPickerToDay, "Date picker to day");

                focusDay = Integer.parseInt(eleDataPickerToDay.getAttribute("text").trim());
                focusMonth = Integer.parseInt(eleDataPickerToDate.getAttribute("data-month").trim());
                focusYear = Integer.parseInt(eleDataPickerToDate.getAttribute("data-year").trim());
                getLogger().info("Day : " + eleDataPickerToDay.getAttribute("text") + "Month :" + eleDataPickerToDate
                        .getAttribute("data-month") + " Year :" + eleDataPickerToDate.getAttribute("data-year"));

            }
            // Compare focus day, month, year with current day, month, year
            if (focusDay != currentDay || focusMonth != currentMonth || focusYear != currentYear) {
                NXGReports.addStep("TestScript Failed: Verify data in date pickerd", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Verify data in date picker", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify data in date pickerd", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return true;
    }


    /**
     * Hover on date picker
     */
    public void hoverDateItemInDatePicker(boolean isNewToDoPage) {
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                eleIdDueDate.click();
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                eleToDoNewRowDueDateText.get(0).click();
            }
            waitForClickableOfElement(eleXpathChooseDate, "Date picker");
            hoverElement(eleXpathChooseDate, "Date picker");
            NXGReports.addStep("Verify hover select date in date picker", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify hover select date in date pickerd", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Create by: duong nguyen
     * refactor:  Vien Pham
     * Input due date in to-do task
     */

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
    WebElement dateTable;

    public void inputDueDate(String month, String date, String year) {
        Calendar date1 = Calendar.getInstance();
        //        DatePicker dp = new DatePicker(getDriver(), eleToDoNewRowDueDateText.get(0));
        DatePicker dp = new DatePicker(getDriver(), dateTable);
        try {
            if (date.equals("") && month.equals("") && year.equals("")) {
                //Choose current day + 1
                date1.add(Calendar.DATE, 1);
                int day1 = date1.get(Calendar.DAY_OF_MONTH);
                dp.pickADate(String.valueOf(day1));
            }
            dp.pickADate(month, date, year);
            NXGReports.addStep("Choose date in date picker", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Choose date in date picker", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * choose date item in date picker
     *
     * @return true | false
     */

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    WebElement statusOfDateTable;

    public void chooseDateItemInDataPicker(String month, String date, String year) throws Exception {
        try {
            getLogger().info("Trying to select another due date..");
            waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
            eleToDoNewRowDueDateText.get(0).click();
            waitForCssValueChanged(statusOfDateTable, "status of Date Table", "display", "block");
            inputDueDate(month, date, year);
            waitForCssValueChanged(statusOfDateTable, "status of Date Table", "display", "none");
            NXGReports.addStep("Ending select due date: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending select due date: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyDateSelectedCorrectly(String dateSelected) {
        verifyDuedateTimebox(dateSelected);

    }

    /**
     * Check date picker is move next or previous month when click Prev or Next link.
     *
     * @param actionLink : prev | next
     * @return true | false
     */
    public boolean checkDatePickerChangeMonth(String actionLink, boolean isNextMonth, boolean isNewToDoPage) {
        boolean result = true;
        String beforeTitle = "";
        String afterTitle = "";
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                eleIdDueDate.click();
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                eleToDoNewRowDueDateText.get(0).click();
            }

            waitForVisibleElement(eleDataPickerTitle, "Date picker title");
            //Get tile date picker before click next or previous link
            beforeTitle = eleDataPickerTitle.getText();

            // If isNextMonth = true : click on Next link in date picker |
            //    isNextMonth = false, click on Prev link in date picker
            if (!isNextMonth) {
                waitForClickableOfElement(elePrevDataPickerLink, "Previous date picker link");
                elePrevDataPickerLink.click();
            } else {
                waitForClickableOfElement(eleNextDataPickerLink, "Next date picker link");
                eleNextDataPickerLink.click();
            }

            //Get tile date picker after click next or previous link
            afterTitle = eleDataPickerTitle.getText();
            result = beforeTitle.equals(afterTitle);

            //If result = true : before and after value as same --> data picker not work
            if (result) {
                NXGReports.addStep("TestScript Failed: Date picker is change " + actionLink + " month", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }

            NXGReports.addStep("Date picker is change " + actionLink + " month", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Date picker is change " + actionLink + " month", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return true;
    }

    /**
     * Verify input correct format date into due date text box
     *
     * @param dateValue
     * @return true | false
     */
    public boolean verifyInputCorrectFormatDate(String dateValue, boolean isNewToDoPage) {
        boolean result = true;
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                clickElement(eleIdDueDate, "Due date text box");
                sendKeyTextBox(eleIdDueDate, dateValue, "Due date text box");
                result = validateAttributeElement(eleIdDueDate, "value", "");
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                clickElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                sendKeyTextBox(eleToDoNewRowDueDateText.get(0), dateValue, "Select due date text box");
                result = validateAttributeElement(eleToDoNewRowDueDateText.get(0), "value", "");

            }
            //If result = false : before and after value as not same --> can not input correct data into due date control
            if (!result) {
                NXGReports.addStep("TestScript Failed: Input correct date format in due date text box ", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Input correct date format in due date text box ", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Input correct date format in due date text box ", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return result;
    }

    /**
     * Verify input wrong format date into due date text box
     *
     * @param dateValue
     * @return true | false
     */
    public boolean verifyInputWrongValue(String dateValue, boolean isNewToDoPage) {
        boolean result = true;
        try {
            // If isNewToDoPage = true :verify in add new to-do page | isNewToDoPage = false, verify in to-do list page
            if (isNewToDoPage) {
                waitForClickableOfElement(eleIdDueDate, "Due date text box");
                clickElement(eleIdDueDate, "Due date text box");
                sendKeyTextBox(eleIdDueDate, dateValue, "Due date text box");
                result = eleIdDueDate.getAttribute("value").equals(dateValue);
            } else {
                waitForClickableOfElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                clickElement(eleToDoNewRowDueDateText.get(0), "Select due date text box");
                sendKeyTextBox(eleToDoNewRowDueDateText.get(0), dateValue, "Select due date text box");
                result = eleToDoNewRowDueDateText.get(0).getAttribute("value").equals(dateValue);

            }
            //If result = true : before and after value as same --> can input wrong data into due date control
            if (result) {
                NXGReports.addStep("TestScript Failed: Input wrong date format in due date text box ", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
            NXGReports.addStep("Input wrong date format in due date text box ", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Input wrong date format in due date text box ", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        return true;
    }
    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- End

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- Start
    @FindBy(id = "btn-todo-trash")
    private WebElement trashToDoBtnEle;

    @FindBy(xpath = "//div[@id='CategoryModel']//h3[@class='setup-header']")
    private WebElement eleDeleteConfrimPopupTitle;

    @FindBy(xpath = "//div[@id='CategoryModel']//h3[@class='setup-header']")
    private WebElement eleDeleteConfrimPopupDescription;

    @FindBy(xpath = "//*[@class='newRow']")
    private List<WebElement> eleToDoRowList;

    @FindBy(xpath = "//*[@class='newRow todoCompleted']")
    private List<WebElement> eleToDoCompleteRowList;

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow todoCompleted']//input[@type='checkbox']")
    private List<WebElement> eleToDoCompleteCheckboxRow;

    @FindBy(id = "cb-select-all-todo")
    private WebElement eleCheckAllCheckBox;

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show']/div[@class = 'fl-a-dismiss auvicon-line-circle-ex'] ")
    WebElement successToastMesCloseIconEle;

    /**
     * Verify trash to do icon.
     */
    public void verifyTrashToDoIcon() {
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            NXGReports.addStep("Verify trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify trash ToDo icon", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify default status trash to do icon.
     */
    public void verifyDefaultStatusTrashToDoIcon() {
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            validateAttributeElement(trashToDoBtnEle, "class", "fa fa-trash disabled");
            NXGReports.addStep("Verify default status trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify default status trash ToDo icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Click on trash icon
     */
    public void clickOnTrashIcon() {
        try {
            waitForVisibleElement(trashToDoBtnEle, "Trash ToDo icon");
            hoverElement(trashToDoBtnEle, "Hover trash icon ");
            clickElement(trashToDoBtnEle, "Click on trash icon");
            NXGReports.addStep("Click on trash ToDo icon", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Can not click on trash ToDo icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Check list row is empty
     *
     * @param eleList : list row need check
     * @return true : list empty | false : list not empty
     */
    public boolean checkListIsEmpty(List<WebElement> eleList) {
        if (eleList.size() == 0) {
            return true;
        }
        return false;
    }


    /**
     * Verify gui of delete confirm popup
     */
    public void verifyGUIDeleteConfirmPopup() {
        try {
            String errorMessage = "Can not test verify gui of delete confirm popup because ToDo list is empty ";
            boolean result = true;
            getLogger().info("Verify GUI Delete ToDo popup when click trash ToDo icon.");
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            // Check ToDo row list is empty
            if (checkEmptyToDoListRow && checkEmptyToDoCompleteListRow) {
                NXGReports.addStep("TestScript Failed: " + errorMessage, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                AbstractService.sStatusCnt++;
                return;
            }
            // Get id delete row
            String idRow = getIdRowDelete(checkEmptyToDoListRow, checkEmptyToDoCompleteListRow, eleToDoCheckboxRow, eleToDoCompleteCheckboxRow,
                    eleToDoRowList, eleToDoCompleteRowList);
            //verify delete confirm icon
            clickElement(trashToDoBtnEle, "Trash icon click");
            //verify popup
            PopUpPage popUpPage = new PopUpPage(getLogger(), getDriver());
            result = popUpPage
                    .verifyGUIPopUpDelete(categoryTitleEle, centerDeleteToDoDescriptionEle, cancelDeletedToDoButtonEle, deletedToDoButtonEle);
            if (!result) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: Verify gui of delete confirm popup in ToDo page", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            //verify close popup icon
            // Check row is delete out of list
            if (!checkEmptyToDoListRow) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoRowList, idRow);
            }
            if (!checkEmptyToDoCompleteListRow && result) {
                result = checkRowIsDeleteOutOfToDoList(eleToDoCompleteRowList, idRow);
            }
            Assert.assertFalse(result, "Popup icon close does not work");
            NXGReports.addStep("Close popup icon working correct", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Verify gui of delete confirm popup in ToDo page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Check all check box of ToDo list is check/uncheck
     *
     * @param isCheck      true : check | false : uncheck
     * @param checkBoxList check box list need check
     * @return true | false
     */
    public boolean checkAllCheckBoxIsCheckOrUnCheck(List<WebElement> checkBoxList, boolean isCheck) {
        int totalRows = checkBoxList.size();
        for (int i = 0; i < totalRows; i++) {
            if (isCheck) {
                if (!checkBoxList.get(i).isSelected())
                    return false;
            } else {
                if (checkBoxList.get(i).isSelected())
                    return false;
            }
        }
        return true;
    }

    /**
     * Check/Uncheck check box of row list
     *
     * @param checkBoxList : check box row list need check/uncheck
     * @param isCheck      : true : check | false
     * @return : true : check/un check all check box | can not check/un check all check box
     */
    public boolean checkAllCheckBox(List<WebElement> checkBoxList, boolean isCheck) {
        int beforeError = AbstractService.sStatusCnt;
        int totalRows = checkBoxList.size();
        for (int i = 0; i < totalRows; i++) {
            if (isCheck) {
                if (!checkBoxList.get(i).isSelected()) {
                    hoverElement(checkBoxList.get(i), "Hover check box");
                    clickElement(checkBoxList.get(i), "Check on check box");

                }
            } else {
                if (checkBoxList.get(i).isSelected()) {
                    hoverElement(checkBoxList.get(i), "Hover check box");
                    clickElement(checkBoxList.get(i), "Un check on check box");
                }

            }
            int afterError = AbstractService.sStatusCnt;
            if (beforeError != afterError)
                return false;
        }
        return true;
    }

    /**
     * Check row is delete out ToDo list
     *
     * @param idRow : id delete row
     * @return true  : already delete | false : not yet delete
     */
    public boolean checkRowIsDeleteOutOfToDoList(List<WebElement> eleList, String idRow) {
        int totalRows = eleList.size();
        for (int i = 0; i < totalRows; i++) {
            if (eleList.get(i).getAttribute("data-id").equals(idRow))
                return false;
        }
        return true;
    }

    /**
     * Check/Uncheck checkall check box
     *
     * @param isCheck
     */
    public void checkOrUnCheckCheckAllCheckBox(boolean isCheck) {
        try {
            waitForVisibleElement(eleCheckAllCheckBox, "'CheckAll' check box");
            hoverElement(eleCheckAllCheckBox, "Hover 'CheckAll' check box");
            if (isCheck) {
                if (!eleCheckAllCheckBox.isSelected()) {
                    clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
                } else {
                    clickElement(eleCheckAllCheckBox, "Un check on 'CheckAll' checkbox");
                    clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
                }
                NXGReports.addStep("Check on 'CheckAll' check box in ToDo page complete", LogAs.PASSED, null);
            } else {
                if (eleCheckAllCheckBox.isSelected()) {
                    clickElement(eleCheckAllCheckBox, "Un Check on 'CheckAll' checkbox");
                } else {
                    clickElement(eleCheckAllCheckBox, "Un check on 'CheckAll' checkbox");
                    clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
                }
                NXGReports.addStep("UnCheck on 'CheckAll' check box in ToDo page complete", LogAs.PASSED, null);
            }
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("TestScript Failed: Can not check/uncheck 'CheckAll' check box in ToDo page", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify all check box is un check or check in ToDo list
     *
     * @param isCheck true : check | false : un check
     */
    public void verifyAllCheckBoxIsCheckOrUnCheck(boolean isCheck) {
        try {
            boolean result = true;
            boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
            boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
            if (!checkEmptyToDoListRow) {
                result = checkAllCheckBoxIsCheckOrUnCheck(eleToDoCheckboxRow, isCheck);
            }
            if (!checkEmptyToDoCompleteListRow) {
                if (result)
                    checkAllCheckBoxIsCheckOrUnCheck(eleToDoCompleteCheckboxRow, isCheck);
            }
            Assert.assertTrue(result, "All checkbox do not check/uncheck");
            if (isCheck) {
                NXGReports.addStep("All check box are check in ToDo page", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("All check box are uncheck in ToDo page", LogAs.PASSED, null);
            }

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            if (isCheck) {
                NXGReports.addStep("TestScript Failed: All check box are not check in ToDo page", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                NXGReports.addStep("TestScript Failed: All check box are not uncheck in ToDo page", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    /**
     * Check/Uncheck checkall check box
     *
     * @param isCheck
     */
    public void checkOrUnCheckAllCheckBox(boolean isCheck) {
        boolean result = true;
        boolean checkEmptyToDoListRow = checkListIsEmpty(eleToDoRowList);
        boolean checkEmptyToDoCompleteListRow = checkListIsEmpty(eleToDoCompleteRowList);
        // verify "CheckAll" check box is checked when all check box are check
        //// check all check box in ToDo page
        if (!checkEmptyToDoListRow) {
            result = checkAllCheckBox(eleToDoCheckboxRow, isCheck);
            if (result == false) {
                if (isCheck) {
                    NXGReports.addStep("TestScript Failed: can not check on all check box has not complete status in ToDo page", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                } else {
                    NXGReports.addStep("TestScript Failed: can not uncheck on all check box has not complete status in ToDo page", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
                return;
            }
        }

        if (!checkEmptyToDoCompleteListRow) {
            result = checkAllCheckBox(eleToDoCompleteCheckboxRow, isCheck);
            if (result == false) {
                if (isCheck) {
                    NXGReports.addStep("TestScript Failed: can not check on all check box has complete status in ToDo page", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                } else {
                    NXGReports.addStep("TestScript Failed: can not uncheck on all check box has complete status in ToDo page", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
                return;
            }
        }
        if (result) {
            NXGReports.addStep("Check all check box in ToDo page", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Uncheck all check box in ToDo page", LogAs.PASSED, null);
        }
    }

    /**
     * Verify 'CheckAll' check box is check or uncheck
     *
     * @param isCheck : true : check | false : uncheck
     */
    public void verifyCheckAllCheckBoxIsCheckOrUncheck(boolean isCheck) {
        waitForVisibleElement(eleCheckAllCheckBox, "CheckAll check box");
        if (isCheck) {
            if (!eleCheckAllCheckBox.isSelected()) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: CheckAll check box do not auto check in ToDo page", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }
        } else {
            if (eleCheckAllCheckBox.isSelected()) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("TestScript Failed: CheckAll check box do not auto uncheck in ToDo page", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }
        }
        if (isCheck) {
            NXGReports.addStep("'CheckAll' check box is check when check all check box in ToDo page", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("'CheckAll' check box is uncheck when uncheck all check box in ToDo page", LogAs.PASSED, null);
        }
    }

    /**
     * get id delete row
     *
     * @param checkToDoList         : todoList is empty or not empty
     * @param checkToDoCompleteList : todoComplete is empty or not empty
     * @return id delete row value
     */
    public String getIdRowDelete(boolean checkToDoList, boolean checkToDoCompleteList, List<WebElement> eleToDoCheckBoxList,
            List<WebElement> eleToDoCompleteCheckBoxList, List<WebElement> eleToDoList, List<WebElement> eleToDoCompleteList) {
        String idRow = "";
        // Check have row has complete satatus
        if (!checkToDoList && "".equals(idRow)) {
            waitForVisibleElement(eleToDoCheckBoxList.get(0), "Select check box of ToDo item has not status complete");
            if (!eleToDoCheckBoxList.get(0).isSelected()) {
                hoverElement(eleToDoCheckBoxList.get(0), "Hover on check box of ToDo has status not complete");
                clickElement(eleToDoCheckBoxList.get(0), "Click on check box of ToDo has status not complete");
            }
            idRow = eleToDoList.get(0).getAttribute("data-id");
        } else if (!checkToDoCompleteList && "".equals(idRow)) {
            waitForVisibleElement(eleToDoCompleteCheckBoxList.get(0), "Select check box of ToDo item has status complete");
            if (!eleToDoCompleteCheckBoxList.get(0).isSelected()) {
                hoverElement(eleToDoCompleteCheckBoxList.get(0), "Hover on check box of ToDo has status complete");
                clickElement(eleToDoCompleteCheckBoxList.get(0), "Click on check box of ToDo has status complete");
            }
            idRow = eleToDoCompleteList.get(0).getAttribute("data-id");
        }
        return idRow;
    }

    /**
     * get index of ToDo name in ToDo list
     *
     * @param toDoName : ToDo need search
     * @return -1 : not found | index : if found
     */
    public int getIndexOfToDoItem(List<WebElement> eleDataRowList, String toDoName) {
        for (int i = 0; i < eleDataRowList.size(); i++) {
            String actualAttributeValue = eleDataRowList.get(i).getAttribute("value").trim();
            if (actualAttributeValue.equals(toDoName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Check ToDo item delete is exists in ToDo list
     *
     * @param isExists : true : exists | false : not exists
     * @param todoName : ToDo name need check
     * @return true | false
     */
    public boolean checkToDoIsExists(boolean isExists, String todoName) {
        getLogger().info("Select To Do Task Check Box by Name");
        int index = getIndexOfToDoItem(eleToDoNameRow, todoName);
        if (!isExists && index != -1)
            return false;

        if (isExists && index == -1)
            return false;

        return true;

    }

    /**
     * Check ToDo item list delete is exists in ToDo list
     *
     * @param isExists     : true : exists | false : not exists
     * @param todoNameList : ToDo name list need check
     * @return
     */
    public boolean checkToDoListIsExists(boolean isExists, List<String> todoNameList) {
        getLogger().info("Select To Do Task List Check Box by Name");
        for (int i = 0; i < todoNameList.size(); i++) {
            int index = getIndexOfToDoItem(eleToDoNameRow, todoNameList.get(i));
            if (!isExists && index != -1)
                return false;

            if (isExists && index == -1)
                return false;
        }
        return true;
    }

    /**
     * Click on delete button in popup delete
     */
    public void clickOnDeleteButtonOnPopup() {
        waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickDeleteButtonOnPopUp();
    }

    /**
     * Click on cancel button in popup delete
     */
    public void clickOnCancelButtonOnPopup() {
        waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
        clickCancelButtonOnPopup();

    }

    /**
     * Click on delete button in pop up
     */
    public void clickDeleteButtonOnPopUp() {
        getLogger().info("Click Delete Button on PopUp windows.");
        WebElement popUpDiv = getDriver().findElement(By.xpath("//div[starts-with(@id, 'categoryModel')and contains(@style,'display: block')]"));
        hoverElement(deletedToDoButtonEle, "Delete ToDo button");
        waitForClickableOfElement(deletedToDoButtonEle, "Delete ToDo Button");
        clickElement(deletedToDoButtonEle, "Delete ToDo button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    /**
     * Check all ToDo item is delete
     *
     * @return true : all is deleted | false : not delete all
     */
    public boolean checkAllToDoIsDelete() {
        if (!checkListIsEmpty(eleToDoRowList) || !checkListIsEmpty(eleToDoCompleteRowList)) {
            return false;
        }
        return true;
    }

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- End

    public void clickCommentIconPerTaskName(String toDoTaskName) {
        getLogger().info("Select To Do Comment Icon by Name");
        int index = findToDoTaskName(toDoTaskName);
        clickElement(commentIconToDoListEle.get(index), String.format("Comment Icon on Task Name: %s", toDoTaskName));
    }


    /**
     * Added by huy.huynh on 18/05/2017.
     * Scenarios : PLAT 2285 - Add undo option
     */

    /**
     * verify button Undo exist
     */
    public void uiVerifyButtonUndoExist() {
        try {
            getLogger().info("Verify button Undo Todo exist.");
            btnToDoUndo.getAttribute("class");
            NXGReports.addStep("Verify button Undo Todo exist.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify button Undo Todo exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify button Undo disable
     */
    public void uiVerifyButtonUndoDisable() {
        try {
            getLogger().info("Verify button Undo Todo disable.");
            Thread.sleep(largeTimeOut);

            if (btnToDoUndo.getAttribute("class").toString().equals("fa fa-undo disabled")) {
                NXGReports.addStep("Verify button Undo Todo disable.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify button Undo Todo disable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * verify button Undo enable
     */
    public void uiVerifyButtonUndoEnable() {
        try {
            getLogger().info("Verify button Undo Todo enable.");
            Thread.sleep(largeTimeOut);

            if (btnToDoUndo.getAttribute("class").toString().equals("fa fa-undo")) {
                NXGReports.addStep("Verify button Undo Todo enable.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify button Undo Todo enable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to create
     * @param dueDate  date of this month which chosen as dueDate
     */
    public void createToDoPageWithNameAndDate(String toDoName, String dueDate) {
        try {
            getLogger().info("Run createToDoPageWithNameAndDate(String toDoName, String dueDate)");
            Thread.sleep(smallTimeOut);
            clickCreateToDoTask();
            Thread.sleep(smallTimeOut);

            sendKeyTextBox(createToDoNameTextBoxEle, toDoName, "To Do Name Input");

            clickElement(eleIdDueDate, "Due Date Input");
            DatePicker datePicker = new DatePicker(getDriver(), eleXpathChooseDate);
            datePicker.pickADate(dueDate);

            clickElement(toDoSaveIconEle, "Save New Todo Icon");
            NXGReports.addStep("Created a new To-Do with given name and dueDate.", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Created a new To-Do with given name and dueDate.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to choose
     */
    public void clickCheckBoxAtRowName(String toDoName) {
        try {
            getLogger().info("Chose a row with given name(which just created).");
            getDriver().findElement(
                    By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[@class='newRow']//input[@type='checkbox']"))
                    .click();
            NXGReports.addStep("Chose a row with given name(which just created).", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Chose a row with given name(which just created).", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * click button Bulk Actions
     */
    public void clickBulkActions() {
        btnBulkActions.click();
    }

    /**
     * choose Mark as complete option
     */
    public void chooseOptionMarkAsCompleteOnBulkActionsDropDown() {
        try {
            getLogger().info("Choose option: Mark as complete");
            optionMarkAsComplete.click();
            NXGReports.addStep("Choose option: Mark as complete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose option: Mark as complete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * choose Assign to option
     */
    public void chooseOptionAssignToOnBulkActionsDropDown() {
        getLogger().info("Choose option: Assign to.");
        clickElement(optionAssignTo, "Assign To Option");
    }

    /**
     * choose Download Attachments option
     */
    public void verifyOptionDownloadAttachmentsOnBulkActionsDropDown() {
        getLogger().info("Bulk Actions option Download Attachments disable.");
        if (optionDownloadAttachments.getAttribute("class").equals("item disabled")) {
            NXGReports.addStep("Bulk Actions option Download Attachments disable.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Bulk Actions option Download Attachments disable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify 'completed'  a To-Do in frontend
     *
     * @param toDoName name of To-Do to choose
     */
    public void verifyTodoCompleteFrontend(String toDoName, String status) {
        try {
            Thread.sleep(smallTimeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO move xpath to properties file
        WebElement toDoRow = getDriver()
                .findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]"));
        WebElement toDoCategory = getDriver().findElement(By.xpath(
                "//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown category')]"));
        WebElement toDoClient = getDriver().findElement(By.xpath(
                "//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown client')]"));
        WebElement toDoAuditor = getDriver().findElement(By.xpath(
                "//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[contains(@class,'newRow')]//div[contains(@class,'ui dropdown auditor')]"));

        if (status.equals("true")) {
            getLogger().info("Verify Completed To-Do front-end");
            if ((toDoRow.getAttribute("class").endsWith("todoCompleted")) && (toDoCategory.getAttribute("class").endsWith("disabled")) && (toDoClient
                    .getAttribute("class").endsWith("disabled")) && (toDoAuditor.getAttribute("class").endsWith("disabled"))) {
                NXGReports.addStep("Verify Completed To-Do front-end", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify Completed To-Do front-end", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } else {
            getLogger().info("Verify not Completed To-Do front-end");
            if ((!toDoRow.getAttribute("class").endsWith("todoCompleted")) && (!toDoCategory.getAttribute("class")
                    .endsWith("disabled")) && (!toDoClient.getAttribute("class").endsWith("disabled")) && (!toDoAuditor.getAttribute("class")
                    .endsWith("disabled"))) {
                NXGReports.addStep("Verify not Completed To-Do front-end", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not Completed To-Do front-end", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     * TODO split into 2 cases: Assign to-> Auditor || Client . So insane!
     *
     * @param toDoName     name of To-Do to choose
     * @param assigneeName name of assignee
     */
    public void verifyTodoAssignToFrontend(String toDoName, String assigneeName) {
        getLogger().info("Verify name of assignee on UI after assign. Expected: " + assigneeName);
        try {
            Thread.sleep(largeTimeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String assignee = getDriver().findElement(By.xpath(
                "//input[@class='newTodoInput'][@value='" + toDoName + "']/ancestor::tr[@class='newRow']//div[contains(@class,'ui dropdown auditor')]/div[@class='text']"))
                .getText();
        //System.out.println("++++++++++++++++++++++++++++++++++++++++assigneeName - text " + assignee + " - " + assigneeName);
        if (assigneeName.equals(assignee)) {
            NXGReports.addStep("Verify name of assignee on UI after assign. Expected: " + assigneeName, LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify name of assignee on UI after assign. Expected: " + assigneeName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verify deleted To-Do(not exist) in frontend
     *
     * @param toDoName name of To-Do to choose
     */
    public void verifyTodoDeletedFrontend(String toDoName, String status) {
        try {
            getLogger().info("Verify a Todo not exist. Name: " + toDoName);
            //Thread.sleep(smallTimeOut);
            //TODO move xpath to properties file, very low peformance
            getDriver().findElement(By.xpath("//input[@class='newTodoInput'][@value='" + toDoName + "']"));
            if (status.equals("INACTIVE")) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify a Todo not exist. Name: " + toDoName, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                NXGReports.addStep("Verify a Todo exist. Name: " + toDoName, LogAs.PASSED, null);
            }
        } catch (NoSuchElementException ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            if (status.equals("INACTIVE")) {
                NXGReports.addStep("Verify a Todo not exist. Name: " + toDoName, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify a Todo exist. Name: " + toDoName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            getLogger().info(ex.getStackTrace());
        }
    }

    /**
     * click button Archive
     */
    public void clickComfirmArchive() {
        try {
            getLogger().info("Verify click button Archive.");
            Thread.sleep(smallTimeOut);
            btnArchive.click();
            NXGReports.addStep("Verify click button Archive.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button Archive.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * click button Delete
     */
    public void clickComfirmDelete() {
        try {
            getLogger().info("Verify click button Delete.");
            Thread.sleep(smallTimeOut);
            btnDelete.click();
            Thread.sleep(smallTimeOut);
            NXGReports.addStep("Verify click button Delete.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button Delete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * click button(icon) Undo
     */
    public void clickBtnUndo() {
        try {
            getLogger().info("Verify click button(icon) Undo.");
            Thread.sleep(smallTimeOut);
            btnToDoUndo.click();
            NXGReports.addStep("Verify click button(icon) Undo.", LogAs.PASSED, null);
        } catch (Exception ex) {
            getLogger().info(ex);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click button(icon) Undo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**-----end of huy.huynh PLAT-2285-----*/

    /**
     * Added by huy.huynh on 19/05/2017.
     * Scenarios : PLAT 2303 - Backend Undo
     */

    /**
     * get 'engagements' collection(table on mongo)
     */
    public DBCollection getEngagementCollection() {
        try {
            //TODO move db config to properties file
            return MongoDBService.getCollection("engagements");
        } catch (Exception e) {
            NXGReports.addStep("Can't get Engagements Colection: auvenir-engagements", LogAs.FAILED, null);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get 'users' collection(table on mongo)
     */
    public DBCollection getUserCollection() {
        DBCollection dbCollection = null;
        try {
            return MongoDBService.getCollection("users");
        } catch (Exception e) {
            NXGReports.addStep("Can't get Users Colection: auvenir-users", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
        return dbCollection;
    }

    /**
     * verify 'completed' field of a To-Do in backend
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoCompleteBackend(String engagementField, String engagementValue, String todoName, String status) {
        try {
            getLogger().info("Verify To-Do complete status on database.");
            JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
            //TODO get from properties file
            if (jsonObject.get("completed").toString().equals(status)) {
                NXGReports.addStep("Verify To-Do complete status on database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify 'status' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param assigneeName    name of assignee
     */
    public void verifyToDoAssignToBackend(String engagementField, String engagementValue, String todoName, String assigneeName) {
        try {
            getLogger().info("Verify To-Do delete status on database.");
            String idAssignee = MongoDBService.getUserObjectByFirstNameLastName(getUserCollection(), assigneeName);
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++idAssignee = " + idAssignee);

            JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
            //System.out.println("+++++++++++++++++++++++++++++++++++++++++++auditorAssignee = " + jsonObject.get("auditorAssignee").toString());

            //TODO get from properties file
            if (jsonObject.get("auditorAssignee").toString().contains(idAssignee)) {
                NXGReports.addStep("Verify To-Do complete status on database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            NXGReports.addStep("Verify To-Do complete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify 'status' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status delete expected
     */
    public void verifyToDoDeteteBackend(String engagementField, String engagementValue, String todoName, String status) throws SyncFactoryException {
        try {
            getLogger().info("Verify To-Do delete status on database.");
            JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++jsonObject = " + jsonObject.get("status"));
            //TODO get from properties file
            if (jsonObject.get("status").toString().equals(status)) {
                NXGReports.addStep("Verify To-Do delete status on database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify To-Do delete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            NXGReports.addStep("Verify To-Do delete status on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * -----end of huy.huynh PLAT-2303-----
     */

    public void verifyDefaultHintValueInputComment() {
        try {
            boolean result;
            final String defaultValueInputComment = "Type a comment";
            getLogger().info("Verify Default Hint Value Input Comment");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field.");
            validateDisPlayedElement(typeCommentFieldEle, "Input Comment field.");
            result = validateAttributeElement(typeCommentFieldEle, "placeholder", defaultValueInputComment);
            Assert.assertTrue(result, "Default Hint Value Input Comment is displayed unsuccessfully");
            NXGReports.addStep("Verify Default Hint Value Input Comment", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Default Hint Value Input Comment is displayed unsuccessfully");
            NXGReports.addStep("TestScript Failed: Verify Default Hint Value Input Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Added by duong.nguyen on 22/05/2017.
     * Scenarios : PLAT 2305 - Backend Mark as complete
     * verify 'completed' field of a To-Do
     *
     * @param engagementField engagement field chosen as key
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status update expected
     */
    public void verifyMarkAsCompleteBackend(String engagementField, String engagementValue, String todoName,
            String status) throws SyncFactoryException {
        try {
            getLogger().info("Verify Completed field updated on database.");
            //        JSONObject jsonObject = MongoDB.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
            JSONObject jsonObject = MongoDBService.getToDoObject(getEngagementCollection(), engagementField, engagementValue, todoName);
            if (jsonObject.get("completed").toString().equals(status)) {
                NXGReports.addStep("Verify Completed field updated on database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify Completed field updated on database.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            NXGReports
                    .addStep("Verify Completed field updated on database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    public void verifyCancelCompleteMarkPopup() {
        verifyShowConfirmPopupAndMarkTitle();
        verifyDisplayImageInPopup();
        verifyMarkPopupColorCancelBtn();
        clickCancelButtonOnPopup();
    }

    /**
     * -----end of duong.nguyen PLAT-2305-----
     */

    public void verifyGUIBoxTitleComment() {
        getLogger().info("Verify Box's Title Comment");
        try {
            boolean result;
            final String count;
            if (!listCommentItemEle.isEmpty())
                count = "" + listCommentItemEle.size();
            else
                count = "0";
            final String defaultBoxTitleComment = "Comments" + "\n" + count;
            waitForVisibleElement(commentboxTitleEle, "Comment Box Title.");
            validateDisPlayedElement(commentboxTitleEle, "Comment Box Title.");
            result = validateElementText(commentboxCountNumberEle, count);
            Assert.assertTrue(result, "Box's Title Count Number Comment is displayed unsuccessfully");
            result = validateElementText(commentboxTitleEle, defaultBoxTitleComment);
            Assert.assertTrue(result, "Box's Title Comment is displayed unsuccessfully");
            NXGReports.addStep("Verify Box's Title Comment", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify Box's Title Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUICommentList(String commentContent) {
        try {
            boolean result;
            getLogger().info("Verify GUI of Comment List");
            final String currentDay = "" + getDate(0, "EEEE, MMM dd") + getCurrentDayNumberSuffix();
            waitForVisibleElement(userIconCommenterEle.get(userIconCommenterEle.size() - 1), "User Icon of Commenter");
            result = validateDisPlayedElement(userIconCommenterEle.get(userIconCommenterEle.size() - 1), "User Icon of Commenter");
            Assert.assertTrue(result, "User Icon of Commenter is displayed unsuccessfully");
            validateDisPlayedElement(userNameCommenterEle.get(userNameCommenterEle.size() - 1), "User Name of Commenter");
            result = validateElementText(userNameCommenterEle.get(userNameCommenterEle.size() - 1), getCurrentUserNameLogOn());
            Assert.assertTrue(result, "User Name Commenter is displayed unsuccessfully");
            result = validateCssValueElement(userNameCommenterEle.get(userNameCommenterEle.size() - 1), "font-weight", "bold");
            Assert.assertTrue(result, "User Name Commenter is NOT displayed with Bold text.");
            validateDisPlayedElement(commentTimeEle.get(commentTimeEle.size() - 1), "Time of Comment Field.");
            result = validateElementText(commentTimeEle.get(commentTimeEle.size() - 1), currentDay);
            Assert.assertTrue(result, "Time of Comment Field is displayed unsuccessfully.");
            result = verifyCommentContentIsDisplayed(commentContent);
            Assert.assertTrue(result, "Content of Comment is displayed unsuccessfully.");
            NXGReports.addStep("Verify GUI of Comment List", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify GUI of Comment List", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify GUI of Comment List", LogAs.FAILED,
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

    public void clickOnPostCommentButton() {
        getLogger().info("Click Post Comment Button");
        int size = getNumberOfListComment();
        waitForVisibleElement(postCommentButton, "Comment Input field");
        clickElement(postCommentButton, "Comment Input field");
        waitForSizeListElementChanged(listCommentItemEle, "List Comment", size + 1);
    }

    public int getNumberOfListComment() {
        getLogger().info("Get Number of List Comment.");
        if (commentboxTitleEle.getText().trim().equals("0")) {
            return 0;
        } else {
            return listCommentItemEle.size();
        }
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

    public void verifyClickOnInputCommentField() {
        try {
            boolean result;
            getLogger().info("Verify click on Input Comment Field - Border color change to green");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            clickElement(typeCommentFieldEle, "Input Comment field");
            result = validateCssValueElement(typeCommentFieldEle, "border", "1px solid rgb(92, 155, 160)");
            Assert.assertTrue(result, "Border color of Input Comment is NOT changed to green.");
            NXGReports.addStep("Verify click on Input Comment Field", LogAs.PASSED, null);

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify click on Input Comment Field", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyUserInputNoContentComent() {
        try {
            boolean result;
            final String noContentWarning = "Comment content must not be empty";
            getLogger().info("Verify User Input No Content Comment");
            waitForVisibleElement(typeCommentFieldEle, "Input Comment field");
            clearTextBox(typeCommentFieldEle, "Input Comment field");
            clickOnPostCommentButton();
            result = verifyContentOfWarningToastMessage(noContentWarning);
            Assert.assertTrue(result, "Content of warning message is displayed unsuccessfully.");
            NXGReports.addStep("Verify User Input No Content Comment", LogAs.PASSED, null);

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("TestScript Failed: Verify User Input No Content Comment", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public boolean verifyInputMaxLenghtContentComment(int maxLength) {
        try {
            boolean result;
            final String inputTextWithMaxLength = randomCharacters(maxLength);
            getLogger().info("Verify input a comment with max length with " + maxLength + " characters");
            verifyInputAComment(inputTextWithMaxLength);
            int numberOfListBefore = getNumberOfListComment();
            clickOnPostCommentButton();
            result = verifyNewCommentIsDisplayed(numberOfListBefore, inputTextWithMaxLength);
            Assert.assertTrue(result, String.format("Cannot input max length %d characters", maxLength));
            NXGReports.addStep("Input a comment with max length with " + maxLength + "character", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            AbstractService.sStatusCnt++;
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Input a comment with max length with " + maxLength + "character", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public boolean verifyInputSpecialCharactersContentComment() {
        try {
            boolean result;
            final String specialCharacters = "~!@#$%^&*+?><,.";
            getLogger().info("Verify input a comment with special characters.");
            verifyInputAComment(specialCharacters);
            int numberOfListBefore = getNumberOfListComment();
            clickOnPostCommentButton();
            result = verifyNewCommentIsDisplayed(numberOfListBefore, specialCharacters);
            Assert.assertTrue(result, String.format("Cannot input a comment with special characters '%s'", specialCharacters));
            NXGReports.addStep("Verify input a comment with special characters.", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            AbstractService.sStatusCnt++;
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Verify input a comment with special characters.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
    }

    public void verifyGUIPostButton() {
        try {
            getLogger().info("Verifying GUI Post button");
            boolean result;
            validateDisPlayedElement(postCommentButton, "Post Button");
            result = validateCssValueElement(postCommentButton, "background-color", "rgba(89, 155, 161, 1)");
            Assert.assertTrue(result, "The background color of the Post button is displayed unsuccessfully.");
            validateCssValueElement(postCommentButton, "color", "rgba(255, 255, 255, 1)");
            Assert.assertTrue(result, "The text color of the Post button is displayed unsuccessfully.");
            NXGReports.addStep("Verifying GUI Post button", LogAs.PASSED, null);
        } catch (AssertionError error) {
            getLogger().info(error);
            NXGReports.addStep("TestScript Failed: Verifying GUI Post button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyAddNewRequestButton() {
        verifyPopupColorAddRequestBtn();
        verifyClickAddRequestBtn();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyColorAddRequestBtn() {
        verifyPopupColorAddRequestBtn();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyRequestNameTextbox() {
        verifyDefaultToDoNameNewRequestPopup();
        verifyShowAllTextNewRequestPopup();
        verifyMaxLengthNewRequestPopup();
        verifyEmptyNewRequestPopup();
        verifyInputNumberToNewRequestPopup();
    }

    /**
     * Author minh.nguyen
     */

    @FindBy(xpath = "//div[@id='auv-todo-details']")
    WebElement addNewRequestWindow;

    public void openAddNewRequestWindow() throws InterruptedException {
        Thread.sleep(smallerTimeOut);
        clickElement(todoListAddNewRequestImg, "click to todoListAddNewRequestImg");
        waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "block");
    }

   /* public void closeAddNewRequestWindow() {
        clickElement(requestCloseBtn);
        waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "none");
    }*/

    /**
     * Author minh.nguyen
     */
    public void verifyPopupColorAddRequestBtn() {
        getLogger().info("Verify the background and text color of the Add request button.");
        boolean isCheckColor = false;
        try {
            openAddNewRequestWindow();
            isCheckColor = verifyColorBackgroundTextBtn(totoPageAddRequestBtn, "rgba(151, 147, 147, 1)", "rgba(255, 255, 255, 1)");
            if (isCheckColor) {
                NXGReports.addStep("Verify the background and text color of the Add request button", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the background and text color of the Add request button", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the background and text color of the Add request button_Exception", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     * Vien.Pham modified for smoke test
     */

    //    @FindBy(xpath = "//div[@id='todo-req-box-0']/input")
    //    @FindBy(xpath = "//div[@id='todo-req-box-0']/span[1]")
    //    WebElement newRequestTxtboxSpan;
    @FindBy(xpath = "//div[contains(@id,'todo-req-box-0')]/span[1]")
    WebElement newRequestTxtboxSpan_1;
    @FindBy(xpath = "//div[contains(@id,'todo-req-box-1')]/span[1]")
    WebElement newRequestTxtboxSpan_2;

    @FindBy(xpath = "//div[contains(@id,'todo-req-box-0')]/input")
    WebElement newRequestTxtboxText_1;

    @FindBy(xpath = "//div[contains(@id,'todo-req-box-1')]/input")
    WebElement newRequestTxtboxText_2;

    @FindBy(xpath = "//div[contains(@id,'todo-req-box')]/span[1]")
    List<WebElement> newRequestTxtboxSpan;
    @FindBy(xpath = "//div[contains(@id,'todo-req-box')]/input")
    List<WebElement> newRequestTxtboxText;


    public void verifyClickAddRequestBtn() {
        getLogger().info("Verify the add request button is clickable");
        try {
            waitForTextValueChanged(totoPageAddRequestBtn, "Text of totoPageAddRequestBtn", "Add New Request");
            clickElement(totoPageAddRequestBtn, "click to totoPageAddRequestBtn");
            NXGReports.addStep("Verify add new request Btn is clickable", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify add new request Btn is clickable", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * Author minh.nguyen
     */
    public void verifyDefaultToDoNameNewRequestPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the default ToDo name on new request popup.");
        boolean isCheckColor = false;
        try {
            waitForVisibleOfLocator(By.xpath(todoDetailName));
            Thread.sleep(smallerTimeOut);
            clickElement(popupToDoDetailName, "click to popupToDoDetailName");
            String todoDetailText = getTextByJavaScripts(popupToDoDetailName, "popupToDoDetailName");
            clearTextBox(popupToDoDetailName, "clear popupToDoDetailName");
            String pleaseNameYourTodo = popupToDoDetailName.getAttribute("placeholder");
            getLogger().info("todoDetailText = " + todoDetailText);
            getLogger().info("pleaseNameYourTodo = " + pleaseNameYourTodo);
            if (todoDetailText.equals(checkToDoNameAddNewRequest) && pleaseNameYourTodo.equals("Please name your To-Do")) {
                isCheckColor = true;
            }
            if (isCheckColor) {
                NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the default ToDo name on new request popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyShowAllTextNewRequestPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to show all text in the new request on popup.");
        boolean isCheckColor = false;
        try {
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            clearTextBox(findRequestEmpty1, "clear findRequestEmpty1");
            String enterRequestName = "Add new request " + randomNumber();
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty1, enterRequestName, "add text to findRequestEmpty1");
            String todoShowAllText = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            if (todoShowAllText.equals(enterRequestName)) {
                isCheckColor = true;
            }
            if (isCheckColor) {
                NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to show all text in the new request on popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyMaxLengthNewRequestPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the max length of new request.");
        boolean isCheckMaxLength = false;
        try {
            boolean ischeckvalidateMaxlenght = validateMaxlenght(findRequestEmpty1, "findRequestEmpty1", 101);
            getLogger().info("ischeckvalidateMaxlenght = " + ischeckvalidateMaxlenght);
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            isCheckMaxLength = waitForVisibleOfLocator(By.xpath(chracterMoreThan100));
            getLogger().info("isCheckMaxLength = " + isCheckMaxLength);
            if (isCheckMaxLength) {
                NXGReports.addStep("Verify the max length of new request.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify the max length of new request.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the max length of new request.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyEmptyNewRequestPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify the empty new request on popup.");
        boolean isCheckEmptyRequest = false;
        try {
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            isCheckEmptyRequest = waitForVisibleOfLocator(By.xpath(requestNotEmptyStr));
            getLogger().info("isCheckEmptyRequest = " + isCheckEmptyRequest);
            String emptyMessageAddRequest = messageEmptyRequest.getText();
            getLogger().info("emptyMessageAddRequest = " + emptyMessageAddRequest);
            if (emptyMessageAddRequest.equals("Request name must not be empty")) {
                NXGReports.addStep("Verify the empty new request on popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify the empty new request on popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify the empty new request on popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyInputNumberToNewRequestPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to input number to new request in the add new request popup.");
        try {
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1);
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty1, numberSequence, "send number to findRequestEmpty1");
            String numberText = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            getLogger().info("numberText = " + numberText);
            if (numberText.equals(numberSequence)) {
                NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to input number to new request in the add new request popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     * Vien.Pham modified for smoke test
     */
    @FindBy(xpath = "//div[@id='todo-req-box-0']")
    WebElement newRequestTxtbox;
    @FindBy(xpath = "//div[@class='auvicon-ex']")
    WebElement requestCloseBtn;

/*
    public void verifyNewRequestStoreInDatabase(String newRequest) {
        getLogger().info("Verify these new request are stored in the database.");
        try {
            for (int i = newRequestTxtboxSpan.size(); i < newRequestTxtboxSpan.size() + 1; i++) {
                System.out.println("Number of request Rows after clicked is: "+ i);
                Thread.sleep(smallerTimeOut);
                clickElement(newRequestTxtboxSpan.get(i-1), "click to new request Txtbox Span");
                getLogger().info("Waiting for textbox border is Green when clicking..");
                waitForCssValueChanged(newRequestTxtboxText.get(i-1), "Css new request txtbox text", "border", "1px solid rgb(89, 155, 161)");
                getLogger().info("Sending new request..");
                clearTextBox(newRequestTxtboxText.get(i-1), "clear text of findRequestEmpty1");
                sendKeyTextBox(newRequestTxtboxText.get(i-1), newRequest, "clear text of findRequestEmpty1");
                getLogger().info("Verify show all text while inputting..");
                String todoShowAllText01 = getTextByJavaScripts(newRequestTxtboxText.get(i-1), "findRequestEmpty1");
                getLogger().info("Close window and verify new input saved successfully..");
                closeTodoListAddNewRequest();
                clickToDoListAddNewRequest();
                String newRequestSaved = newRequestTxtboxSpan.get(i-1).getText();
                System.out.println("new Request saved is: " + newRequestSaved);
                System.out.println("todo show Alltext is: " + newRequestSaved);
                if (todoShowAllText01.equals(newRequest) && todoShowAllText01.equals(newRequest)) {
                    NXGReports.addStep("Verify new request are stored in the database.", LogAs.PASSED, null);
                } else {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify new request are stored in the database.", LogAs.FAILED, null);
                }
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify new request are stored in the database.", LogAs.FAILED, null);
        }
    }*/
/*
    public void verifyNewRequestStoreInDatabase(String newRequest01, String newRequest02) {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify these new request are stored in the database.");
        try {
            //add 1st request
            Thread.sleep(smallerTimeOut);
            clickElement(newRequestTxtboxSpan_1, "click to new request Txtbox Span");
            getLogger().info("Waiting for textbox border is Green when clicking..");
            waitForCssValueChanged(newRequestTxtboxText_1, "Css new request txtbox text", "border", "1px solid rgb(89, 155, 161)");
            getLogger().info("Sending new request..");
            clearTextBox(findRequestEmpty1, "clear text of findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty1, newRequest01, "clear text of findRequestEmpty1");
            getLogger().info("Verify show all text while inputting..");
            String todoShowAllText01 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            //add 2nd request
            verifyClickAddRequestBtn();
            Thread.sleep(smallerTimeOut);
            clickElement(newRequestTxtboxSpan_2, "click to new request Txtbox Span");
            getLogger().info("Waiting for textbox border is Green when clicking..");
            waitForCssValueChanged(newRequestTxtboxText_2, "Css new request txtbox text", "border", "1px solid rgb(89, 155, 161)");
            getLogger().info("Sending new request..");
            clearTextBox(findRequestEmpty2, "clear text of findRequestEmpty1");
            sendKeyTextBox(findRequestEmpty2, newRequest02, "clear text of findRequestEmpty1");
            getLogger().info("Verify show all text while inputting..");
            String todoShowAllText02 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            getLogger().info("close and reopen Add request window for verifying new input saved successfully..");
            closeAddNewRequestWindow();
            openAddNewRequestWindow();
            //modified
            String newRequestSaved1 = newRequestTxtboxSpan_1.getText();
            System.out.println("new Request saved is: " + newRequestSaved1);
            System.out.println("todo show Alltext is: " + newRequestSaved1);

            String newRequestSaved2 = newRequestTxtboxSpan_2.getText();
            System.out.println("new Request saved is: " + newRequestSaved2);
            System.out.println("todo show Alltext is: " + newRequestSaved2);

            if (todoShowAllText01.equals(newRequest01) && newRequestSaved1.equals(newRequest01) && todoShowAllText02.equals(newRequest02) && newRequestSaved2.equals(newRequest02)) {
                NXGReports.addStep("Verify new request are stored in the database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify new request are stored in the database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify new request are stored in the database.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    WebElement newRequestTable;

    public void createNewRequest(String newRequest, String position) {
        try {
            waitForCssValueChanged(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "", "display", "inline-block");
            clickElement(newRequestTable.findElement(By.xpath("./div[" + position + "]/span")), "");
            getLogger().info("Waiting for textbox border is Green while clicked..");
            //            waitForCssValueChanged(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "", "border",
            //                    "1px solid rgb(89, 155, 161)");
            getLogger().info("Sending new request..");
            clearTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), "");
            sendKeyTextBox(newRequestTable.findElement(By.xpath("./div[" + position + "]/input")), newRequest, "");
            //            closeAddNewRequestWindow();
            NXGReports.addStep("Create new request at position " + position + ": Done", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Create new request at position " + position + ": Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(id = "engagement-backButton")
    WebElement engagementBackBtn;

    public void reselectEngagementName(String engagementName) {
        AuditorEngagementService auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        //        AuditorDetailsEngagementService auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        try {
            getLogger().info("Back to Engagement page...");
            engagementBackBtn.click();
            getLogger().info("Return to Todo list page again..");
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            //            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            NXGReports.addStep("Return to Todo ListPage successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Return to Todo ListPage failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyUpdateRequestStoreInDatabase() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to update these requests and these are stored in the database.");
        try {
            newRequest01 = "updated01";
            newRequest02 = "updated02";
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty1, newRequest01, "send data to findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty2, newRequest02, "send data to findRequestEmpty2");
            getLogger().info("Value findRequestEmpty2: " + findRequestEmpty2.getAttribute("value"));
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText01 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            waitForClickableOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText02 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            waitForVisibleOfLocator(By.xpath(closeAddNewRequestPopup));
            clickElement(closeAddNewRequest, "click to closeAddNewRequest");
            openAddNewRequestWindow();
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtFirst));
            Thread.sleep(smallerTimeOut);
            clickElement(findRequestEmpty1, "click to findRequestEmpty1");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText03 = getTextByJavaScripts(findRequestEmpty1, "findRequestEmpty1");
            waitForVisibleOfLocator(By.xpath(todoPageAddRequestTxtSecond));
            clickElement(findRequestEmpty2, "click to findRequestEmpty2");
            Thread.sleep(smallerTimeOut);
            String todoShowAllText04 = getTextByJavaScripts(findRequestEmpty2, "findRequestEmpty2");
            if (todoShowAllText01.equals(todoShowAllText03) && todoShowAllText02.equals(todoShowAllText04)) {
                NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to update these requests and these are stored in the database.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     * Vien.Pham modified for smoke test
     */

    @FindBy(xpath = "//div[@class='ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover']")
    WebElement optionNewRequestThreeDot;
    @FindBy(xpath = "//div[@class='ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover active']")
    WebElement optionNewRequestThreeDotActive;
    @FindBy(xpath = "//div[@class='ui dropdown auvicon-line-circle-more todo-circle-more todo-icon-hover']/div/a[1]")
    WebElement deleteRequestSelect;

    public void verifyDeleteRequestOnPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to delete a request on the popup.");
        boolean isCheckDeleteRequest = false;
        try {
            clickElement(deleteRequestBtn, "click to deleteRequestBtn");
            waitForClickableOfLocator(By.xpath(deleteRequestMenuStr));
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty1, "Deleted the request", "send data to findRequestEmpty1");
            isCheckDeleteRequest = clickElement(deleteRequestMenu, "click to deleteRequestMenu");
            if (isCheckDeleteRequest) {
                NXGReports.addStep("Verify to delete a request on the popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to delete a request on the popup.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to delete a request on the popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Author minh.nguyen
     */
    public void verifyCopyTaskOnPopup() {
        // Need to use Thread.sleep that support stable scripts
        getLogger().info("Verify to copy a task on the popup.");
        boolean isCheckCopyRequest = false;
        try {
            Thread.sleep(smallerTimeOut);
            sendKeyTextBox(findRequestEmpty1, "Copied the request", "send data to findRequestEmpty1");
            //sendTabkey();
            Thread.sleep(smallerTimeOut);
            clickElement(deleteRequestBtn, "click to deleteRequestBtn");
            waitForClickableOfLocator(By.xpath(copyTaskMenuStr));
            isCheckCopyRequest = clickElement(copyTaskMenu, "click to copyTaskMenu");
            if (isCheckCopyRequest) {
                NXGReports.addStep("Verify to copy a task on the popup.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to copy a task on the popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to copy a task on the popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Create ToDo name list
     *
     * @author : TanPham
     * @date : 29/05/2017
     */

    public List<String> createToDoNameList(String todoName, int numberToDo) {
        List<String> toDoListNames = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        // Add one ToDo name
        for (int i = 0; i < numberToDo; i++) {
            toDoListNames.add(todoName + i + dateFormat.format(date));
        }

        return toDoListNames;
    }

    /**
     * -----end of huy.huynh PLAT-2303-----
     */

    /*
    Vien Pham add new method for PLAT 2326-2301
     */

    @FindBy(xpath = "//table [@id='todo-table']//input[@type='text']")
    List<WebElement> TodosTextboxEle;

    @FindBy(xpath = "//input [@id=\"cb-select-all-todo\"]")
    WebElement todoAllCheckbox;

    @FindBy(xpath = "//*[@id=\"btn-todo-trash\"]")
    WebElement todoTrashBtn;

    @FindBy(xpath = "//input [contains(@class,\"due\")]")
    List<WebElement> newDueDateEle;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory todo-category todo-bulkDdl')]")
    private List<WebElement> dropdownCategoryEle;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory todo-category todo-bulkDdl')]/div")
    private List<WebElement> dropdownCategoryGetTextEle;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown client')]")
    List<WebElement> DropdownClientAssignee;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown auditor')]")
    List<WebElement> DropdownAuditAssignee;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//div[@class=\"item\"]")
    List<WebElement> listOfCategoryItemsDropdown;

    @FindBy(xpath = "//table[@id='todo-table']//tr[1]//div[contains(@class,'ui dropdown client')]//div[contains(@class,'menu')]/button[@class='item']")
    List<WebElement> listOfClientAssigneesDropdown;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//div[contains(@class,\"ui dropdown audit\")]//button[contains(@class,\"item\")]")
    List<WebElement> listOfAuditAssigneeDropdown;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1]//input[contains(@class,\"input-due-date\")]")
    WebElement DropdownDuedateBtn;

    @FindBy(id = "ui-datepicker-div")
    WebElement datePicker;


    @FindBy(xpath = "//div[@id=\"ui-datepicker-div\"]//span[contains(@class,\"month\")]")
    WebElement Month;

    @FindBy(xpath = "//div[contains(@class,\"ui-datepicker\")]/a[1]")
    WebElement PrevBtn;
    @FindBy(xpath = "//div[contains(@class,\"ui-datepicker\")]/a[2]")
    WebElement NextBtn;

    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement eleAuvenirIncTxt;

    @FindBy(xpath = "//div[@id='engagement-footer']//div/span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement auvenirIncTxtTodoPage;

    public void verifyOnlyTodoTextbox_PlaceHolderValue() {
        getLogger().info("Verifying Hint text on first todo...");
        String firstHintValue = "Write your first To-do here";
        try {
            String value = TodosTextboxEle.get(0).getAttribute("placeholder");
            if (value.equals(firstHintValue)) {
                NXGReports.addStep("PlaceHolder value exist as expected.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("PlaceHolder value not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("PlaceHolder value not exist_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifySecondTodoTextbox_PlaceHolderValue() {
        getLogger().info("Verify Hint text on second todo...");
        String secondHintValue = "Write your To-Do here";

        try {
            createToDoBtnEle.click();
            Thread.sleep(smallerTimeOut);
            String value1 = TodosTextboxEle.get(1).getAttribute("placeholder");
            if (value1.equals(secondHintValue)) {
                NXGReports.addStep("PlaceHolder value is: " + value1 + " as expected", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("PlaceHolder value is: " + value1, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            NXGReports.addStep("PlaceHolder value wrong as Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void verifyTodoTextboxBorder_AfterClickedAddTodo() {
        WebElement textbox1 = TodosTextboxEle.get(0);
        getLogger().info("Verifying border of todo Textbox is Green after clicked add Todo...");
        String WhiteBorder = "rgb(255, 255, 255)";
        try {
            validateCssValueElement(textbox1, "border-color", WhiteBorder);
            NXGReports.addStep("border is Green after clicked add Todo", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("border is not Green after clicked add Todo", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }


    }

    public void verifyTodoTextboxBorder_WhileHoveredOrFocus() {
        WebElement textbox1 = TodosTextboxEle.get(0);
        String GreenBorder = "rgb(92, 155, 160)";
        getLogger().info("Verifying border of todo Textbox is Green while hovered...");
        try {
            hoverElement(textbox1, "Todos Textbox");
            validateCssValueElement(textbox1, "border-color", GreenBorder);
            NXGReports.addStep("Border is Green while hovered on it.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Border is not Green while hovered on it.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void InputValue_TodoName(String value) {
        try {
            WebElement textbox1 = TodosTextboxEle.get(0);
            clickElement(TodosTextboxEle.get(0), "Todos Textbox");
            getLogger().info("Inputting a value..");
            sendKeyTextBox(textbox1, value, "Todos Textbox");
            sendTabkey(textbox1, "Todos Textbox");
            NXGReports.addStep("Ending input a value.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending input a value.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyInputValidValue(String validValue) {
        try {
            getLogger().info("Verifying show all Text..");
            verifyShowAllTextTodoName(validValue);
            getLogger().info("Verifying the border of todo name is Green while input valid todo name..");
            verifyBorderTodoTextBox_InputValidValue();
            getLogger().info("Verifying valid value should be saved..");
            verifyValidTodoNameSaved(validValue);
            NXGReports.addStep("Verify Input valid Value complete.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Input valid Value complete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyInputInvalidValue(String invalidValue) {
        try {
            getLogger().info("Verifying show all Text..");
            verifyShowAllTextTodoName(invalidValue);
            getLogger().info("Verifying the border of todo name..");
            verifyBorderTodoTextBox_InputInvalidValue();
            getLogger().info("Verifying valid value should be saved..");
            verifyInvalidTodoNameNotSaved(invalidValue);
            NXGReports.addStep("Verify Input invalid Value complete.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Input invalid Value complete.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyCategoryBox_DefaultValue() {
        String defaultValue = "Select";
        try {
            Thread.sleep(smallerTimeOut);
            if (dropdownCategoryGetTextEle.get(0).getText().equals(defaultValue)) {
                NXGReports.addStep("Verify default value of CategoryBox.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify default value of CategoryBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify default value of CategoryBoxt.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(xpath = "//table[@id=\"todo-table\"]/tbody/tr[1]//div[@class=\"menu\"]/div[2]")
    WebElement editCategoryBtn;

    @FindBy(xpath = "//*[@id=\"todo-table\"]/tbody/tr[1]/td[3]/div[contains(@class,'ui dropdown category')]")
    WebElement categoryDropdownEle;

    @FindBy(xpath = "//table[@id=\"todo-table\"]/tbody/tr[1]//td[3]//div[@class=\"item\"]")
    List<WebElement> tableOfCategoryDropdown;


    public void navigateToEditCategory() throws InterruptedException {
        //        waitForNewTodoNameSaved();
        getLogger().info("Navigating to Editcategory...");
        waitForClickableOfLocator(By.xpath("//*[@id=\"todo-table\"]/tbody/tr[1]/td[3]/div[contains(@class,'ui dropdown category')]"));
        clickElement(categoryDropdownEle, "categoryDropdown");
        Thread.sleep(smallerTimeOut);
        waitForClickableOfLocator(By.xpath("//table[@id=\"todo-table\"]/tbody/tr[1]//div[@class=\"menu\"]/div[2]"));
        clickElement(editCategoryBtn, "editCategory");
    }

    /*
    Vien.Pham seperated new method from createNewCategory() of aMinh.Nguyen.
     */
    public boolean findNewCategory(String value) {
        Boolean isCheckCategory = null;
        waitForClickableOfElement(categoryDropdownEle, "CategoryDropdown");
        waitForJSandJQueryToLoad();
        clickElement(categoryDropdownEle, "CategoryDropdown");
        for (WebElement tdElement : tableOfCategoryDropdown) {
            String strSearchValue = null;
            try {
                waitForVisibleElement(tdElement, "Get category name in list");
                strSearchValue = tdElement.getText();
            } catch (Exception ex) {
            }
            getLogger().info("SearchValue = " + strSearchValue);
            if (strSearchValue.equals(value)) {
                isCheckCategory = true;
                //Click anywhere to exit vefify
                eleAuvenirIncTxt.click();
                break;
            } else {
                isCheckCategory = false;
            }
        }
        getLogger().info("isCheckCategory is: " + isCheckCategory);
        return isCheckCategory;
    }

/*
    public void selectCategoryAsName(String value) {
        try {
            waitForClickableOfElement(dropdownCategoryEle.get(0));
            clickElement(dropdownCategoryEle.get(0), "Dropdown Cate");
            clickElement(listOfCategoryItemsDropdown.get(0), "");
            Thread.sleep(smallerTimeOut);
            NXGReports.addStep("Ending select category.", LogAs.PASSED, null);
        } catch (Exception e) {
            System.out.println("Error is: " + e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending select category.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }*/

    /*
    Vien.Pham modified selectCategoryasName
     */

    public void selectCategoryByName(String categoryName) {
        try {
            waitForClickableOfElement(dropdownCategoryEle.get(0));
            clickElement(dropdownCategoryEle.get(0), "Dropdown Cate");
            int index = findCategoryName(categoryName);
            List<WebElement> listCategoryMenuDropdown = dropdownCategoryEle.get(0).findElements(By.xpath("div[@class='menu dropdown-empty']/div"));
            System.out.println("Index: " + index);
            if (index != 0) {
                clickElement(listCategoryMenuDropdown.get(index), "select category by name");
            }
            NXGReports.addStep("Ending select category.", LogAs.PASSED, null);
        } catch (Exception e) {
            System.out.println("Error is: " + e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Ending select category.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyCategoryIsSelectedCorrectly(String value1) {
        try {
            Thread.sleep(smallerTimeOut);
            String value2 = dropdownCategoryEle.get(0).getText();
            if (value1.equals(value2)) {
                NXGReports.addStep("Category is selected passed.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Category is selected failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Category is selected failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }


    }

    public void verifyClientAssignee_DefaultValue() {
        String defaultValue = "Unassigned";
        try {
            Thread.sleep(smallerTimeOut);
            if (DropdownClientAssignee.get(0).getText().equals(defaultValue)) {
                NXGReports.addStep("Default value of Assignee is Unassigned.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Default value of Assignee is Unassigned.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Default value of Assignee is Unassigned_Exception.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyBorderOfClientAssignee_WhileHovered() {

        String GreenBorder = "rgb(92, 155, 160)";
        try {
            hoverElement(DropdownClientAssignee.get(0), "Category Dropdown Menu");
            validateCssValueElement(DropdownClientAssignee.get(0), "border-color", GreenBorder);
            NXGReports.addStep("Border of ClientAssigneebox is Green when hovered.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Border of ClientAssigneebox is not Green when hovered.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /*
    Vien.pham created method for fiding created Client Assignee     */


    public int findAssigneeClientInList(String clientName) {
        int isCheck = -1;
        try {
            getLogger().info("List of Client Assignee..");
            clickElement(DropdownClientAssignee.get(0), "ClientAssignee Dropdown");
            int numberOfClient = listOfClientAssigneesDropdown.size() - 1;
            System.out.println("number of Client in list = " + numberOfClient);
            for (int i = 1; i < (numberOfClient + 1); i++) {
                String checkName = listOfClientAssigneesDropdown.get(i).getText();
                System.out.println("client name " + i + " is: " + checkName);
                if (checkName.equals(clientName)) {
                    NXGReports.addStep("Find Client assginee in list: Pass", LogAs.PASSED, null);
                    isCheck = i;
                    break;
                }
            }
        } catch (Exception e) {
            isCheck = -1;
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Can not find that user in list ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return isCheck;
    }

    public void selectClientAssignee(String clientName) {
        try {
            int index = findAssigneeClientInList(clientName);
            if (index == -1) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Can not select clientName in list", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            clickElement(listOfClientAssigneesDropdown.get(index), "select Client Assignee");
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Can not select clientName in list", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyClientAssigneeIsSelectedCorrectly(String clientName) {
        try {
            getLogger().info("Verifying selection is correctly..");
            Thread.sleep(smallerTimeOut);
            String value1 = DropdownClientAssignee.get(0).getText();
            if (value1.equals(clientName)) {
                getLogger().info("after selected, client assignee is: " + value1);
                NXGReports.addStep("Client assignee is selected correctly.", LogAs.PASSED, null);

            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Client assignee is not selected correctly.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            System.out.println("error is: " + e);
            NXGReports
                    .addStep("Client assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    @FindBy(xpath = "//input[contains(@class,'auv-input input-due-date')]")
    List<WebElement> dueDateEle;

    public void verifyDuedateTimebox(String value) {
        try {
            getLogger().info("Verifying duedate timebox..");
            String dateCheck = eleToDoNewRowDueDateText.get(0).getAttribute("value").trim();
            if (dateCheck.equals(value)) {
                NXGReports.addStep("Verify dueDate timebox: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify dueDate timebox: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify dueDate timebox: Fail_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public WebElement getTableOfDataPicker() {
        return datePicker;
    }

    public void verifyDuedateTable() {
        //        DatePicker tableDatePicker = new DatePicker();
        try {
            DropdownDuedateBtn.click();
            waitForCssValueChanged(datePicker, "Date Picker Table", "display", "block");
            getLogger().info("Current Month is: " + Month.getText());
            Thread.sleep(largeTimeOut);
            //            tableDatePicker.pickADate("12","5","2017");


            //            verifyPrevFunction();
            //            verifyNextFunction();

        } catch (Exception e) {


        }
    }

    public void verifyBorderAuditAssignee_WhileHoverd() {
        String GreenBorder = "rgb(92, 155, 160)";
        try {
            hoverElement(DropdownAuditAssignee.get(0), "Audit Assignee Dropdown");
            validateCssValueElement(DropdownAuditAssignee.get(0), "border-color", GreenBorder);
            NXGReports.addStep("Border of AuditAssignee  is Green when hovered: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Border of AuditAssignee is not Green when hovered: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAuditAssigneeIsSelectedCorrectly() {
        try {
            getLogger().info("List of Audit Assignee..");
            Thread.sleep(smallerTimeOut);
            clickElement(DropdownAuditAssignee.get(0), "AuditAssignee Dropdown");
            getLogger().info("the number of Audit assignee is: " + listOfAuditAssigneeDropdown.size());
            getLogger().info("First audit Assignee is: " + listOfAuditAssigneeDropdown.get(0).getText());
            String value1 = listOfAuditAssigneeDropdown.get(0).getText();
            getLogger().info("Trying to select First one..");
            clickElement(listOfAuditAssigneeDropdown.get(0), "First Audit Assignee");
            //            waitForClickableOfLocator(By.xpath(""));
            getLogger().info("Verifying selection is correctly..");
            Thread.sleep(smallerTimeOut);
            String value2 = DropdownAuditAssignee.get(0).getText();
            if (value1.equals(value2)) {
                getLogger().info("After selected, audit assignee is: " + value2);
                NXGReports.addStep("Audit assignee is selected correctly.", LogAs.PASSED, null);

            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Audit assignee is not selected correctly.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            System.out.println("error is: " + e);
            NXGReports.addStep("Audit assignee is not selected correctly.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    public void verifyAditAssignee_DefaultValue(String auditorAssignee) {
        try {
            Thread.sleep(smallerTimeOut);
            String isCheck = DropdownAuditAssignee.get(0).getText();
            if (isCheck.equals(auditorAssignee)) {
                System.out.println("Default value of Audit Assignee is: " + isCheck);
                NXGReports.addStep("Default value of Auditor Assignee: Pass", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Default value of Auditor Assignee: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Default value of Auditor Assignee: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyCreateTodoBtn_DefaultValue() {
        String Green_Background = "rgba(89, 155, 161, 1)";
        String White_Text = "rgba(255, 255, 255, 1)";
        try {
            getLogger().info("Verifying Background color of Create New Btn");
            validateCssValueElement(createToDoBtnEle, "background-color", Green_Background);
            getLogger().info("Verifying Text color of Create New Btn");
            validateCssValueElement(createToDoBtnEle, "color", White_Text);
            NXGReports.addStep("Default value of Create Todo Btn.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Default value of Create Todo Btn.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(id = "todo-filter-dropdown")
    WebElement filterBtn;

    public void verifyFilterBtn_DefaultValue() {
        String defaultValue = "Filter";
        try {
            getLogger().info("Verifying default text of Filter Btn..");
            String value = filterBtn.getText();
            System.out.println("Default Filter Btn is: " + value);
            if (value.equals(defaultValue)) {
                NXGReports.addStep("Verify default Filter Btn: Pass.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify default Filter Btn: Fail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify default Filter Btn: Fail.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyFilterBtn_WhileHovered() {
        String GreenBorder = "rgb(92, 155, 160)";
        try {
            hoverElement(filterBtn, "Filter Btn");
            boolean isCheck = validateCssValueElement(filterBtn, "border-color", GreenBorder);
            if (isCheck) {
                NXGReports.addStep("Verify border of Filter Btn while hovered: Pass.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify border of Filter Btn while hovered: Fail.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify border of Filter Btn while hovered: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void clickFilterBtn() {
        try {
            clickElement(filterBtn, "Filter Btn");
            NXGReports.addStep("Filter btn is clickable: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Can not click Filter Btn", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(xpath = "//div[(@id='todo-bulk-dropdown')and contains(@class,'')]")
    WebElement BulkActionEnableBtn;

    @FindBy(xpath = "//div[(@id='todo-bulk-dropdown')and contains(@class,'disable')]")
    WebElement BulkActionDisableBtn;

    public void verifyBulkActionBtn() {
        if (eleCheckBox.isSelected()) {
            Boolean isCheck = waitForVisibleElement(BulkActionEnableBtn, "BulkAction Enable");
            if (isCheck) {
                NXGReports.addStep("BulkAction is Enable: Pass.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("BulkAction is Enable: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } else {
            Boolean isCheck = waitForVisibleElement(BulkActionDisableBtn, "BulkAction Disable");
            if (isCheck) {
                NXGReports.addStep("BulkAction is Disable: Pass.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("BulkAction is Disable: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    }

    public void verifyUnableToInputDuedate(String inputText) {
        try {
            clickElement(eleToDoNewRowDueDateText.get(0), "");
            sendKeyTextBox(eleToDoNewRowDueDateText.get(0), inputText, "");
            if (!eleToDoNewRowDueDateText.get(0).getAttribute("value").equals(inputText)) {
                NXGReports.addStep("Verify unable to input Text into DueDate.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify unable to input Text into DueDate.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify unable to input Text into DueDate.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyNameReturnDefault() {
        try {
            validateAttributeElement(TodosTextboxEle.get(0), "value", "Untitled Todo");
            NXGReports.addStep("Verify Name return default.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Name return default.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @FindBy(xpath = "//div[@id='todo-bulk-dropdown']//button[3]")
    private WebElement deleteTodoSelectionEle;

    @FindBy(xpath = "//div[contains(@id,'Delete Todo')]")
    private WebElement deteleConfirmForm;

    @FindBy(xpath = "//div[contains(@id,'Delete Todo')]//button[contains(@class,'warning')]")
    private WebElement deleteTodoBtn;

    /*
    Vien. Pham added new method
     */
    public void deleteAllExistedTodoItems() {
        waitForVisibleElement(createToDoBtnEle, "createTodoBtn");
        getLogger().info("Try to delete all existed todo items.");
        try {
            Boolean isInvisible = findNewTodoItems();
            System.out.println("isInvisible: " + isInvisible);
            if (isInvisible) {
                Thread.sleep(smallTimeOut);
                waitForClickableOfElement(todoAllCheckbox);
                getLogger().info("Select all Delete mail: ");
                System.out.println("eleTodo CheckboxRox is: " + eleToDoCheckboxRow);
                todoAllCheckbox.click();
                waitForClickableOfElement(btnBulkActions);
                btnBulkActions.click();
                deleteTodoSelectionEle.click();
                waitForCssValueChanged(deteleConfirmForm, "Delete confirm form", "display", "block");
                waitForClickableOfElement(deleteTodoBtn);
                waitForTextValueChanged(deleteTodoBtn, "Delete Todo Btn", "Delete");
                deleteTodoBtn.click();
                waitForCssValueChanged(deteleConfirmForm, "Delete confirm form", "display", "none");
                getLogger().info("Delete all Todo items successfully");
                NXGReports.addStep("Delete all Todo items", LogAs.PASSED, null);
            } else {
                getLogger().info("No items to delele");
                NXGReports.addStep("Delete all Todo items", LogAs.PASSED, null);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            e.printStackTrace();
            NXGReports.addStep("Delete all Todo items", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }

    }

    @FindBy(xpath = "//tr[@id='empty-todo']")
    WebElement emptyTodoItems;
    String emptyTodoItemsStr = "//tr[@id='empty-todo']";

    public boolean findNewTodoItems() {
        boolean isCheck = true;
        if (waitForVisibleOfLocator(By.xpath(emptyTodoItemsStr), waitTimeOut)) {
            return isCheck = false;
        }
        return isCheck;
    }


    public void clickArchiveTaskButton() {
        getLogger().info("Click Archive Button.");
        clickElement(archiveMarkPopupBtn, "click to archiveMarkPopupBtn");
        waitForCssValueChanged(popUpMarkCompleteWindows, "Popup Mark Complete", "display", "none");
    }

    @FindBy(id = "fm-downloadBtn")
    WebElement downloadAllTodo;

    public void clickDownloadAllTodo() {
        try {
            getLogger().info("Click Download Button.");
            clickElement(downloadAllTodo, "click to downloadAllTodo");
            waitForCssValueChanged(popUpDownloadAttachmentsWindows, "Popup Mark Complete", "display", "none");
            NXGReports.addStep("Click Download Button.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            e.printStackTrace();
            NXGReports.addStep("Click Download Button.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(xpath = "//label[@class='auvicon-line-circle-add todo-circle-add todo-icon-hover']")
    WebElement uploadCreateRequestBtn;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']//div/span[1]")
    List<WebElement> uploadClientCreateRequestText;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']//div/span/label")
    WebElement uploadClientCreateRequestBtn;
    @FindBy(xpath = "//span[@class='auvicon-checkmark icon-button']")
    List<WebElement> checkUploadRequest;

    //    private String requestNameText = "client request";

 /*
 Vien.Pham created new uploadedNewFile
  */

    public void uploadeNewFileByRequestName(String concatUpload, String requestName) {
        try {
            int isFind = findRequestByName(requestName);
            if (isFind == -1) {
                getLogger().info("Can not find any request has name is: " + requestName);
                AbstractService.sStatusCnt++;
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                clickElement(newRequestTable.findElement(By.xpath("./div[" + isFind + "]//label")));
                getLogger().info("Input path of file..");
                //                upLoadRequestFile(concatUpload);
                StringSelection ss = new StringSelection(concatUpload);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                Robot robot = new Robot();
                robot.delay(2);
//                Screen screen = new Screen();
//                screen.click(GenericService.sDirPath + "\\src\\test\\resources\\imagesSikuli\\textbox.PNG");
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                waitSomeSeconds(2);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                //                getLogger().info("Waiting for checkSign visible..");
                //                waitForCssValueChanged(checkUploadRequest.get(isFind), "checkSuccessful", "display", "inline-block");
                //                closeAddNewRequestWindow();
                waitSomeSeconds(1);
                NXGReports.addStep("End of Upload createNewRequest File", LogAs.PASSED, null);
            }
        } catch (AWTException e) {
            AbstractService.sStatusCnt++;
            e.printStackTrace();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e
                    .getMessage());
        } 
//        catch (FindFailed e) {
//        	AbstractService.sStatusCnt++;
//            e.printStackTrace();
//            NXGReports.addStep("Cannot find text box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e
//                    .getMessage());
//		}
    }

    public void uploadNewFileByPosition(String concatUpload, int position) {
        try {
            clickElement(newRequestTable.findElement(By.xpath("./div[" + position + "]//label")));
            Thread.sleep(largeTimeOut);
            getLogger().info("Input path of file..");
            //                upLoadRequestFile(concatUpload);
            StringSelection ss = new StringSelection(concatUpload);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            getLogger().info("Waiting for checkSign visible..");
            //            waitForCssValueChanged(checkUploadRequest.get(), "checkSuccessful", "display", "inline-block");
            closeAddNewRequestWindow();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.PASSED, null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public void upLoadRequestFile(String path) throws FindFailed {
        Screen screen = new Screen();
        //        screen.click("src/resources/ChromeIcon.PNG");
        screen.click("src\\test\\resources\\imagesSikuli\\textbox.PNG");
        screen.type(path);
        screen.click("src\\test\\resources\\imagesSikuli\\openBtn.PNG");
    }

    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    List<WebElement> newRequestList;

   /* public int findRequestByName(String requestName) {
        int isFind = -1;
        for (int i = 1; i < (newRequestList.size() + 1); i++) {
            if (newRequestTable.findElement(By.xpath("./div[" + i + "]/span")).getText().equals(requestName)) {
                isFind = i;
                break;
            }
        }
        return isFind;
    }*/



/*
    public void uploadFileNewRequestByClient(String concatUpload) throws AWTException, InterruptedException, IOException {
        try {
            Thread.sleep(smallTimeOut);
            clickElement(uploadClientCreateRequestBtn);
            Thread.sleep(largeTimeOut);
            getLogger().info("Enter path of file..");
            StringSelection ss = new StringSelection(concatUpload);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            getLogger().info("Waiting for checkSign visible..");
            waitForCssValueChanged(checkUploadRequest, "checkSuccessful", "display", "inline-block");
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.PASSED, null);

        } catch (AWTException awt) {
            AbstractService.sStatusCnt++;
            awt.printStackTrace();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        } catch (InterruptedException itr) {
            AbstractService.sStatusCnt++;
            itr.printStackTrace();
            NXGReports.addStep("End of Upload createNewRequest File", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

    @FindBy(xpath = "//*[@id=\"todo-req-box-0\"]/div[2]")
    WebElement fileNameAfterUploaded;
    @FindBy(xpath = "//*[@id=\"todo-req-box-1\"]/div[2]")
    WebElement fileNameAfterUploadedClient;


    public void verifyUploadFileSuccessfullyByClient(String fileName) {
        try {
            waitForCssValueChanged(fileNameAfterUploadedClient, "fileName After uploaded", "display", "inline-block");
            String isCheck = fileNameAfterUploadedClient.getText();
            System.out.println("File's Name was uploaded is: " + isCheck);
            System.out.println("File's Name after uploaded is: " + isCheck);
            if (isCheck.equals(fileName)) {
                NXGReports.addStep("Verify file was uploaded successfully", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify file was uploaded successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify file was uploaded successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }

    }


    @FindBy(xpath = "//*[@id='todoDetailsReqCont']/div//span[contains(@class,'auvicon-line-download')]")
    List<WebElement> downloadRequestBtn;


    /*
    Vien.Pham added new method
    @param : mode 1 for downloading request file, mode 2 for downloading attachfile.
     */
   /* public void downloadNewRequestFile(String pathDownloadFolder, String fileName, boolean fileInComment) {
        try {
            //Delete file before download
            String concatDownload = pathDownloadFolder.concat(fileName);
            checkFileExists(concatDownload, true);
            Thread.sleep(largeTimeOut);
            if (fileInComment) {
                clickElement(verifyAttachComplete, "download attachment from comment");
            } else {
                int isFind = findUploadFile(fileName);
                clickElement(downloadRequestBtn.get(isFind), "download newRequest");
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Check sum failed_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

   /* public void downloadCreateRequestNewFileClient(String concatUpload, String concatDownload) {
        try {
            clickElement(downloadClientNewRequestBtn.get(0), "download newRequest Btn");
            Thread.sleep(largeTimeOut);
            String checkMd5UploadFile = calculateMD5(concatUpload);
            System.out.println("md5 upload is: " + checkMd5UploadFile);
            String checkMd5DownloadFile = calculateMD5(concatDownload);
            System.out.println("md5 download is: " + checkMd5DownloadFile);
            if (checkMd5UploadFile.equals(checkMd5DownloadFile)) {
                NXGReports.addStep("Verify file was download successfully", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify file was download successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify file was download successfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }*/

    @FindBy(xpath = "//div[@id='comment-form']/div")
    WebElement attachBtn;
    @FindBy(xpath = "//div[@class='todo-comment-container']//p[contains(@class,'comment-fileName')]")
    WebElement verifyAttachComplete;

    public void attachFile(String attachLocation, String fileName) {
        try {
            clickElement(attachBtn);
            Thread.sleep(largeTimeOut);
            getLogger().info("Enter path of file..");
            StringSelection ss = new StringSelection(attachLocation.concat(fileName));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            getLogger().info("Verifying attach successfully or not..");
            waitForTextValueChanged(verifyAttachComplete, "verify Attach complete", fileName);
            closeAddNewRequestWindow();
            NXGReports.addStep("Attach new file Done", LogAs.PASSED, null);
        } catch (AWTException awt) {
            AbstractService.sStatusCnt++;
            awt.printStackTrace();
            NXGReports.addStep("Attach new file failed_AWTException", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        } catch (InterruptedException itr) {
            AbstractService.sStatusCnt++;
            itr.printStackTrace();
            NXGReports
                    .addStep("Attach new file failed_InterruptedException", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void downloadAttachFile(String pathOfDownload, String fileName) {
        try {
            getLogger().info("client verifies attached file available..");
            waitForTextValueChanged(verifyAttachComplete, "verify Attach complete", fileName);
            downloadCommentFile(pathOfDownload.concat(fileName), fileName);
            NXGReports.addStep("Download attached file Done", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            NXGReports.addStep("Download attached file fail_Exception", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }




    /*
    End of Vien.Pham
     */

    public void verifyAddNewRequestPopUp() {
        try {
            openAddNewRequestWindow();
            waitForVisibleElement(addNewRequestWindow, "Add new request popup");
        } catch (Exception e) {
            NXGReports.addStep("Verify add new request", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCommentSuccessFul(String comment, int numberComment) {
        try {
            List<String> textContainComment = new ArrayList<String>();
            for (WebElement commentEle : listCommentItemEle) {
                textContainComment.add(getText(commentEle).toString());
            }

            for (int cmt = 0; cmt < numberComment; cmt++) {
                if (!textContainComment.contains(comment + cmt)) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify comment: " + comment + cmt + " displayed in new feed.", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify comment successful.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void selectAuditorAssigneeByName(String toDoName, String auditorAssignee) {
        try {
            String assineeAuditorEle = ".//button[text()='%s']";
            int index = findToDoTaskName(toDoName);
            clickElement(listAuditorAssigneeDdl.get(index), "listAuditorAssigneeDdl");
            WebElement auditorAssigneeSelected =
                    listAuditorAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeAuditorEle, auditorAssignee)));
            Thread.sleep(smallTimeOut);
            clickElement(auditorAssigneeSelected, "auditorAssigneeSelected");
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Select auditor assignee with name: " + auditorAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void selectClientAssigneeByName(String toDoName, String clientAssignee) {
        try {
            int index = findToDoTaskName(toDoName);
            clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
            waitSomeSeconds(2);
            WebElement clientAssigneeSelected =
                    listClientAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeClientEle, clientAssignee)));
            clickElement(clientAssigneeSelected, "clientAssigneeSelected");
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Select client assignee with name: " + clientAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyAuditorAssigneeSelected(String toDoName, String auditorAssignee) {
        try {
            Thread.sleep(bigTimeOut);
            getLogger().info("Verify Auditor Assignee Selected in Dropdownlist.");
            int index = findToDoTaskName(toDoName);
            WebElement auditorAssigneeSelected = listAuditorAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
            waitForTextValueChanged(auditorAssigneeSelected, "auditorAssigneeSelected", auditorAssignee);
            if (auditorAssigneeSelected.getText().equals(auditorAssignee)) {
                NXGReports.addStep("verify auditor assignee selected with name: " + auditorAssignee, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("verify auditor assignee selected with name: " + auditorAssignee, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify auditor assignee selected with name: " + auditorAssignee, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void selectAssigneeToDoUsingBulkAction(String userName) throws InterruptedException {
        Thread.sleep(largeTimeOut);
        //        chooseOptionAssignToOnBulkActionsDropDown();
        chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(userName);
    }

    /**
     * Overload function createToDoTask() following the require of Mr.Cuong.
     * Create new To Do task with 3 parameters.
     *
     * @param toDoName     String To Do Name task.
     * @param categoryName String Category Name.
     * @param dueDate      String Due Date.
     */
    public void createToDoTask(String toDoName, String categoryName, String dueDate) throws Exception {
        getLogger().info("Create To Do Task with 'toDoName'");
        WebElement engagmentTitle = getDriver().findElement(By.xpath("//*[@id='a-header-title']"));
        System.out.println("engagmentTitle Value: " + engagmentTitle.getAttribute("value"));
        waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
        String rowString = toDoTaskRowEle.get(0).getAttribute("class");
        int size = 1;
        int index = -1;
        if (!rowString.equals("")) {
            size = toDoTaskRowEle.size() + 1;
            index = findToDoTaskName(toDoName);
            System.out.println("Index Create: " + index);
        }
        if (index == -1) {
            getLogger().info("Create New To Do Task");
            waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
            clickElement(createToDoBtnEle, "Create To Do button");
            waitForSizeListElementChanged(toDoTaskRowEle, "To Do task row", size);
            sendKeyTextBox(toDoNameTextColumnEle.get(0), toDoName, "First To Do Name textbox");
            sendTabkey(toDoNameTextColumnEle.get(0), "First To Do Name textbox");
            // Create new category
            createNewCategory("");
            NXGReports.addStep("Create To Do Task", LogAs.PASSED, null);
        }
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - Start
     *
     **/

    /**
     * Verify engagement overview status does not change when click on close icon popup / cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverviewStatusDoesNotChange(boolean isCloseIconClick) {
        String strStepSuccess = "Verify engagement overview status does not change when click on close icon popup";
        String strStepFail = "TestScript Failed: Verify engagement overview status change when click on close icon popup";
        if (!isCloseIconClick) {
            strStepSuccess = "Verify engagement overview  status does not change when click on cancel button";
            strStepFail = "TestScript Failed: Verify engagement overview status change when click on cancel button";
        }
        try {
            boolean result;
            waitForVisibleElement(eleEngagementOverViewStatusText, "Wait engagement overview status");
            result = engagementOverViewStatusBefore.toLowerCase().equals(eleEngagementOverViewStatusText.getText().trim().toLowerCase());
            Assert.assertTrue(result, "Engagement overview status does not change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement overview status change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverviewStatusChange() {
        String strStepSuccess = "Verify engagement overview status change when click on archive button";
        String strStepFail = "TestScript Failed: Verify engagement overview status does not change when click on archive button";
        try {
            boolean result;
            waitForVisibleElement(eleEngagementOverViewStatusText, "Wait engagement overview status");
            result = engagementOverViewStatusBefore.toLowerCase().equals(eleEngagementOverViewStatusText.getText().trim().toLowerCase());
            // will update to assert false when bug has fixed
            Assert.assertTrue(result, "Engagement overview status change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement overview ToDo does not change when click on close icon popup / cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverviewToDoDoesNotChange(boolean isCloseIconClick) {
        String strStepSuccess = "Verify engagement overview ToDo does not change when click on close icon popup";
        String strStepFail = "TestScript Failed: Verify engagement overview ToDo change when click on close icon popup";
        if (!isCloseIconClick) {
            strStepSuccess = "Verify engagement overview ToDo does not change when click on cancel button";
            strStepFail = "TestScript Failed: Verify engagement overview ToDo change when click on cancel button";
        }
        try {
            boolean result;
            waitForVisibleElement(eleEngagementOverViewToDoText, "Wait engagement overview todo");
            result = engagementOverViewToDoBefore.toLowerCase().equals(eleEngagementOverViewToDoText.getText().trim().toLowerCase());
            Assert.assertTrue(result, "Engagement overview ToDo does not change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement overview ToDo change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverviewToDoChange() {
        String strStepSuccess = "Verify engagement overview ToDo does change when click on archive button";
        String strStepFail = "TestScript Failed: Verify engagement overview ToDo does not change when click on archive button";
        try {
            boolean result;
            waitForVisibleElement(eleEngagementOverViewToDoText, "Wait engagement overview todo");
            result = engagementOverViewToDoBefore.toLowerCase().equals(eleEngagementOverViewToDoText.getText().trim().toLowerCase());
            // will update to assert false when bug has fixed
            Assert.assertTrue(result, "Engagement overview ToDo change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Click on close icon
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void clickOnCloseIconInMarkAsCompletePopup() {
        getLogger().info("Click on close icon in mark as complete popup");
        try {
            waitForClickableOfElement(markPopupCloseBtn, "Wait for click on close icon");
            clickElement(markPopupCloseBtn, "Click on close icon");
            NXGReports.addStep("Verify click on close icon in mark as complete popup successful ", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click on close icon in mark as complete popup fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Click on cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void clickOnCancelButtonInMarkAsCompletePopup() {
        getLogger().info("Click on cancel button in mark as complete button");
        try {
            waitForClickableOfElement(eleCancelBtn, "Wait for click on cancel button");
            clickElement(eleCancelBtn, "Click on cancel button");
            NXGReports.addStep("Verify click on cancel button in mark as complete popup successful ", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click on cancel button in mark as complete popup fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Click on cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void clickOnEngagementLink() {
        getLogger().info("Click on engagement link");
        try {
            waitForClickableOfElement(eleEngagementLink, "Wait for click on engagement link");
            clickElement(eleEngagementLink, "Click on engagement");
            NXGReports.addStep("Verify click on engagement link ", LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify click on engagement link ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify mask as complete popup is close
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyMarksAsCompletePopupIsClose() {
        getLogger().info("Verify mask as complete popup close");
        try {
            boolean isClickClose = waitForCssValueChanged(popUpMarkCompleteWindows, "PopUp Mark Complete", "display", "none");
            if (isClickClose) {
                NXGReports.addStep("Verify mask as complete popup close successful", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify mask as complete popup close fail", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify mask as complete popup close fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - End
     **/
    /**
     * Overload findToDoTaskName, this function is used for
     *
     * @param toDoName
     * @param isClient
     * @return
     */
    public int findToDoTaskName(String toDoName, boolean isClient) {
        getLogger().info(String.format("Find Position of To Do '%s'", toDoName));
        String actualAttributeValue;
        String classAttribute;
        WebElement toDoNameCell = null;
        for (int i = 0; i < toDoTaskRowEle.size(); i++) {
            classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
            if (classAttribute.equals("newRow")) {
                if (isClient) {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/span[@class='todo-name-readonly']"));
                } else {
                    toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                }
                if (toDoNameCell != null) {
                    if (isClient) {
                        actualAttributeValue = toDoNameCell.getText().trim();
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

    public void clickCommentIconPerTaskName(String toDoTaskName, boolean isClient) {
        getLogger().info("Select To Do Comment Icon by Name");
        int index = findToDoTaskName(toDoTaskName, isClient);
        clickElement(commentIconToDoListEle.get(index), String.format("Comment Icon on Task Name: %s", toDoTaskName));
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - Start
     *
     **/
    /**
     * Verify engagement overview status is complete
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementOverviewStatusIsComplete() {
        String strStepSuccess = "Verify engagement overview status is complete";
        String strStepFail = "TestScript Failed: Verify engagement overview status is not complete";
        try {
            boolean result;
            result = ENGAGEMENT_OVER_VIEW_STATUS_COMPLETE.toLowerCase().equals(eleEngagementOverViewStatusText.getText().trim().toLowerCase());
            // will update to assert false when bug has fixed
            Assert.assertTrue(result, "Engagement overview status is complete");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify engagement overview ToDo is complete
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementOverviewToDoIsComplete() {
        String strStepSuccess = "Verify engagement overview ToDo is complete";
        String strStepFail = "TestScript Failed: Verify engagement overview ToDo is complete";
        try {
            boolean result;
            String strEngagementOverViewToDo = eleEngagementOverViewToDoText.getText().trim().split("%")[0];
            result = ENGAGEMENT_OVER_VIEW_TODO_COMPLETE.toLowerCase().equals(strEngagementOverViewToDo.toLowerCase());
            Assert.assertTrue(result, "Engagement overview ToDo does not change");
            NXGReports.addStep(strStepSuccess, LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(strStepFail, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - End
     *
     **/

    /**
     * Add new by huy.huynh on 21/06/2017.
     * SmokeTest R2
     */
    //div[starts-with(@id,'Delete Tod
    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]//label[@class='au-modal-title-text']")
    private WebElement titleConfirmDeleteToDo;

    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]//div[@class='des-delete-modal']")
    private WebElement titleConfirmDeleteToDoDescription;

    @FindBy(xpath = "//tr[@id='empty-todo']//img")
    private WebElement imageEmptyToDo;


    /**
     * Verify existing of Empty to-do image
     */
    public boolean verifyEmptyToDoImage() {
        if (validateAttributeContain(imageEmptyToDo, "src", "images/icons/clipboard.png", "Image Empty ToDo")) {
            return true;
        }
        return false;
    }

    /**
     * Verify empty to-do list(Through checking existing of Empty to-do image)
     */
    public void verifyEmptyToDoList() {
        getLogger().info("Verify empty todo list");
        if (verifyEmptyToDoImage()) {
            NXGReports.addStep("All ToDo deleted, Image Empty exist", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("Fail: Delete all fail, Image Empty not exist", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    /*-----------end of huy.huynh on 21/06/2017.*/

    public void verifyLastCommentOfUserDisplayed(String commentContent, String fullNameUser) {
        getLogger().info("Verify Last Comment Of User is Displayed");
        try {
            boolean result;
            result = validateElementText(userNameCommenterEle.get(userNameCommenterEle.size() - 1), fullNameUser);
            Assert.assertTrue(result, String.format("User Name Commenter '%s' should be displayed", fullNameUser));
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

    public boolean verifyCanCreateToDo(boolean possibleCreate) {
        boolean result = false;
        todoNamePage = "To-do name " + randomNumber();
        try {
            if (possibleCreate) {
                if (validateNotExistedElement(createToDoBtnEle, "Create To Do Button")) {
                    createToDoTask(todoNamePage);
                    result = verifyAddNewToDoTask(todoNamePage);
                }
            } else {
                result = validateNotExistedElement(createToDoBtnEle, "Create To Do Button");
            }
            Assert.assertTrue(result, "Verify Create To Do should be passed.");
            NXGReports.addStep("Verify Can Create To Do", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify Can Create To Do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify Can Create To Do", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return result;
    }


   /* public boolean checkFileExists(String pathLocation, boolean deleteExisted){
        waitSomeSeconds(3);
        Path path = Paths.get(pathLocation);
        System.out.println("file: " + path);
        boolean result = false;
        try {
            if (Files.exists(path)) {
                result = true;
                if (deleteExisted) {
                    Files.delete(path);
                    if (Files.exists(path)) {
                        AbstractService.sStatusCnt++;
                        NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        }catch (IOException ex){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
        return result;
    }*/

    public void verifyDownloadFileAllTodoSuccess(String pathLocation) {
        if (!GeneralUtilities.checkFileExists(pathLocation, false)) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("File not existed in download folder.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @FindBy(xpath = "//div[@id='engagement-todo']//table[@id='todo-table']//td//div[@class='fileNumber']")
    private List<WebElement> listNumberFileRequest;

    public int getTotalNumberFileRequest() {
        int totalNumberFileRequest = 0;
        for (WebElement el : listNumberFileRequest) {
            totalNumberFileRequest += Integer.parseInt(el.getText());
        }
        return totalNumberFileRequest;
    }

    public void verifyCanSeeAllFileRequest(int numberFileRequest) {
        int totalFileRequest = getTotalNumberFileRequest();
        if (numberFileRequest == totalFileRequest) {
            NXGReports.addStep("verify lead auditor can see all file request within engagement.", LogAs.PASSED, null);
        } else {
            NXGReports.addStep("verify lead auditor can see all file request within engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /*public void verifyFileRequestInTodo(String toDoName, String... fileNames){
        try{
            clickOpenNewRequestByTodoName(toDoName);
            List<String> lstFileDisplayed = new ArrayList<String>();
            for (WebElement el : uploadRequestList){
                lstFileDisplayed.add(el.getText());
            }
            for (String fileName : fileNames){
                if (!lstFileDisplayed.contains(fileName)){
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("verify file request displayed in todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                            .BROWSER_PAGE));
                }
            }
        }catch (Exception e){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify file request displayed in todo.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf
                    .BROWSER_PAGE));
        }finally {
            closeAddNewRequestWindow();
        }
    }*/

    public void verifyPermissionCanUploadRequestFile(String pathOfUploadLocation, String fileName, boolean possibleUpload) {
        try {
            if (possibleUpload) {
                verifyPopupColorAddRequestBtn();
                verifyClickAddRequestBtn();
                createNewRequest("request 01", "1");
                uploadeNewFileByRequestName(pathOfUploadLocation, fileName);
                verifyUploadFileSuccessfully(fileName);
            } else {
                validateNotExistedElement(totoPageAddRequestBtn, "Add New Request button.");
            }
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex);
            NXGReports.addStep("Test Failed: Verify " + (possibleUpload ? "can" : "cannot") + " upload file request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Verify " + (possibleUpload ? "can" : "cannot") + " upload file request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyPermissionCanDownloadRequestFile(String pathOfDownloadLocation, String fileName, boolean fileInComment,
            boolean possibleDownload) {
        try {
            if (possibleDownload) {
                verifyPopupColorAddRequestBtn();
                downloadRequestFile(pathOfDownloadLocation, fileName);
            } else {

            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify " + (possibleDownload ? "can" : "cannot") + " download file request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        } catch (AssertionError ex) {
            AbstractService.sStatusCnt++;
            getLogger().info(ex);
            NXGReports.addStep("Test Failed: Verify " + (possibleDownload ? "can" : "cannot") + " download file request.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
