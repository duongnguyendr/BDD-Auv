package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementPage;
import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorTodoListPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by hai.nguyen on 05/04/2017.
 */

public class AuditorCreateToDoService extends AbstractService {

    AuditorCreateToDoPage createToDoPage;
    AuditorTodoListPage todoListPage;
    AuditorEngagementPage engagementPage;
    AuditorDetailsEngagementPage detailsEngagementPage;

    /*
     * contructor
     */
    public AuditorCreateToDoService(Logger logger, WebDriver driver) {

        super(logger, driver);
        createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        todoListPage = new AuditorTodoListPage(getLogger(), getDriver());
        engagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        detailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
    }


    public void verifyGUIAddNewToDoNameTextBox(int numberOfTask) {
        getLogger().info("Verify GUI Add New To Do Text Box");
        createToDoPage.verifyDefaultValueToDoNameTextBox(numberOfTask);
        createToDoPage.verifyHoverCssValueToDoNameTextBox();
        createToDoPage.verifyWarningCssValueToDoNameTextBox();
        createToDoPage.verifyGUIButtonCreateToDo();
    }

    public void verifyAuditorCreateToDo() {

        try {
            //this.createToDoTask.navigateToEngagementTask();
            this.createToDoPage.navigateToToDoList();
            createToDoPage.verifyToDoListPage();
            NXGReports.addStep("verify create to do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify create to do page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    //    public void verifyGUIAddNewToDoNameTextBox() {
    //        try {
    //            createToDoTask.verifyDefaultValueToDoNameTextBox();
    //            createToDoTask.verifyHoverCssValueToDoNameTextBox();
    //            createToDoTask.verifyWarningCssValueToDoNameTextBox();
    //            NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.PASSED, null);
    //        } catch (Exception e) {
    //            NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.FAILED,
    //                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //        }
    //    }

    public void verifyButtonFilter() {
        try {
            todoListPage.verifyButtonFilter();
            NXGReports.addStep("verify Filter button displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Filter button displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigatetoCreateToDoTab() {
        getLogger().info("Navigate to CreateToDo Tab");
        try {
            todoListPage.clickCreateToDoBtn();
            Thread.sleep(1000);
            //            todoListPage.waitForNumberOfTodoListIncreased();
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifySearchPlaceholder() {
        getLogger().info("Todo page verify default value(Search...)");
        createToDoPage.verifySearchDefault();
    }

    public void verifyInputDataToDoNameTextBox(String toDoNameValue) {
        getLogger().info("Input data into ToDo name Textbox.");
        createToDoPage.verifyInputValueToDoNameTextBox(toDoNameValue);
    }

    public void verifySearchHover() {
        getLogger().info("Todo page search hover");
        createToDoPage.verifySearchBorderWhileHover();
    }

    public void inputSearchText(String inputSearch) {
        createToDoPage.inputSearchText(inputSearch);
    }

    public void inputSearchNumber(String number) {
        createToDoPage.inputSearchText(number);
    }

    public void inputSearchCharacter(String specialChars) {
        createToDoPage.inputSearchText(specialChars);
    }

    public void verifySearchResult(String inputSearch) {
        createToDoPage.checkSearchData(inputSearch);
    }

    public void verifySearchResutlNotMatch() {
        createToDoPage.verifySearchResutlNotMatch();
    }
    //	public void verifySearchLimit255(){
    //		try {
    //			createToDoTask.verifySearchLimit255();
    //			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}


    //	public void verifyColumnsInGrid(){
    //
    //		try {
    //			createToDoTask.verifyColumnsInGrid();
    //			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-14: verify show to-do list with : Check box, To-do title, Category title, Client Assignee title, Due date title, Audit Assignee title", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}
    //
    //	public void verifySotleOnTitle(){
    //
    //		try {
    //			createToDoTask.verifySotleOnTitle();
    //			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-15: verify after each column title have a arrow icon to sort.", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}
/*
    public void navigatetoCreateToDoTab() {
        getLogger().info("Navigate to CreateToDo Tab");
        try {
            //createToDoTask.navigateToEngagementTask();
            createToDoTask.navigateToToDoList();
            createToDoTask.clickCreateToDoTask();
            //createToDoTask.createNewToDoTask();
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Create ToDo TextBox", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
	*/
    //	public void verifyCheckOnCheckBox(){
    //
    //		try {
    //			createToDoTask.verifyCheckOnCheckBox();
    //			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}
    //
    //	public void verifyUnCheckOnCheckBox(){
    //
    //		try {
    //
    //			createToDoTask.verifyUnCheckOnCheckBox();
    //			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}

    public void navigateToDoListPage() throws Exception {
        //this.createToDoPage.navigateToEngagementPage();
        this.createToDoPage.navigateToToDoList();
    }


/*
    public void verifyInputDataToDoNameTextBox(String value) {
        getLogger().info("Input data into ToDo name Textbox.");
        try {
            createToDoTask.verifyInputValueToDoNameTextBox(value);
            NXGReports.addStep("Input value " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Input value " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
*/

    //	public void verifySearchLimit255(){
    //		try {
    //			createToDoTask.verifySearchLimit255();
    //			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.PASSED, null);
    //		} catch (Exception e) {
    //			NXGReports.addStep("[PLAT 2288]-09: verify input with max length limit with  255 character", LogAs.FAILED,
    //					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //		}
    //	}

    public void verifyToDoNameInputSpecialCharacter(String value) {
        getLogger().info("Input special characters into ToDo name Text box.");
        try {
            createToDoPage.verifyToDoNameInputSpecialCharacter(value);
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Input special characters: " + value + " on ToDo Name Textbox unsuccessfully.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyGUIToDoSaveIconDisabled() {
        getLogger().info("Verify GUI of the To Do Save Icon is disabled");
        createToDoPage.verifyDisableToDoSaveIcon();
    }

    public void verifyGUIToDoSaveIconEnabled() {
        getLogger().info("Verify GUI of the To Do Save Icon is enabled");
        createToDoPage.verifyEnableToDoSaveIcon();
    }

    public void verifyToDoCloseIcon() {
        getLogger().info("Verify To Do Close Icon.");
        createToDoPage.verifyToDoCloseIcon();
    }

    public void verifyColumnsInGrid() throws Exception {
        createToDoPage.verifyColumnsInGrid();

    }

    public void verifySortIconOnTitle() throws Exception {
        createToDoPage.verifySortIconOnTitle();
    }

    public void verifyCheckOnCheckBox() {

        try {
            createToDoPage.verifyCheckOnCheckBox();
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-16: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyCheckAllCheckBox() throws Exception {
        createToDoPage.verifyCheckAllCheckboxToDoName();
    }

    public void verifyUncheckAllCheckbox() throws Exception {
        createToDoPage.verifyUnCheckAllCheckboxToDoName();
    }

    public void verifyUnCheckOnCheckBox() {

        try {

            createToDoPage.verifyUnCheckOnCheckBox();
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("[PLAT 2288]-17: verify checkbox will change green color a have stick icon", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    // Vien.Pham added new numberCategories
    public void createToDoPage() {
        try {
            createToDoPage.createToDoTask();
            NXGReports.addStep("Create To-Do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Create To-Do page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    /*
        public void verifyGUIAddNewToDoNameTextBox() {
            try {
                createToDoTask.verifyDefaultValueToDoNameTextBox();
                createToDoTask.verifyHoverCssValueToDoNameTextBox();
                createToDoTask.verifyWarningCssValueToDoNameTextBox();
                NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.PASSED, null);
            } catch (Exception e) {
                NXGReports.addStep("verify GUI AddNew ToDo Text Box", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        }
    */
    public void createNewToDoTask(String toDoName) {
        createToDoPage.createToDoTask(toDoName);
    }

    public void verifySortDataGridIcon() {
        createToDoPage.verifySortToDoTaskOnName();
    }

    public void verifyCheckBoxToDoName() throws Exception {
        createToDoPage.verifyCheckAllCheckboxToDoName();
        createToDoPage.verifyUnCheckAllCheckboxToDoName();
        createToDoPage.verifyCheckMultipleCheckBoxToDoName();
    }

    public void verifyDefaultValueofCategoryComboBox() {
        createToDoPage.verifyDefaultValueofCategoryComboBox();
    }

    public void verifyHoverCategoryComboBox() {
        createToDoPage.verifyHoverCategoryComboBox();
    }

    public void verifyAddNewCategoryPopupTitle() {
        getLogger().info("Verify title of add new category popup");
        createToDoPage.verifyAddNewCategoryPopupTitle();
    }

    public void verifyNewCategoryNameTextbox() {
        getLogger().info("Verify new category name textbox");
        createToDoPage.verifyNewCategoryNameTextbox();
    }

    public void verifyNewCategoryColorCombobox() {
        getLogger().info("Verify new category color combobox");
        createToDoPage.verifyNewCategoryColorCombobox();
    }

    public void verifyNewCategoryCreateCancelButton() {
        getLogger().info("Verify new category create/cancel button");
        createToDoPage.verifyNewCategoryCreateCancelButton();
    }

    public void verifyDataSearch() {
        getLogger().info("Verify the search data");
        createToDoPage.checkSearchData();
    }

    public void verifyCheckMaxLength() throws Exception {
        getLogger().info("Verify to check max length");
        createToDoPage.verifyCheckMaxLength();
    }

    public void verifyCheckMaxLength_CategoryName() {
        getLogger().info("Verify to check max length");
        createToDoPage.verifyCheckMaxLength_CategoryName();
    }

    public void verifyContentTextSearch(String toDoName) {
        getLogger().info("Verify the content text search");
        createToDoPage.checkContentTextSearch(toDoName);
    }

    //    public void createFailedTodoPage() throws Exception {
    //        try {
    //            boolean isCheckData = createToDoPage.checkSearchData();
    //            if(isCheckData) {
    //                NXGReports.addStep("Verify realtime search", LogAs.PASSED, null);
    //            }
    //            else
    //            {
    //                NXGReports.addStep("Verify realtime search", LogAs.FAILED, null);
    //            }
    //            getLogger().info("verifyDataSearch() isCheckData = " + isCheckData);
    //        } catch (Exception e) {
    //            NXGReports.addStep("Verify realtime search", LogAs.FAILED,
    //                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
    //        }
    //    }

    public void createToDoTaskWithCategoryName(String toDoNameTask, String categoryName) throws Exception {
        createToDoPage.createToDoTaskWithCategoryName(toDoNameTask, categoryName);
    }

    public void createListTodoTaskWithCategoryName(List<String> toDoTaskNames, String categoryName) throws Exception {
        for (int i = 0; i < toDoTaskNames.size(); i++) {
            createToDoPage.createToDoTaskWithCategoryName(toDoTaskNames.get(i), categoryName);
        }

    }

    public void clickCreateToDoTask() throws Exception {
        createToDoPage.clickCreateToDoTask();
    }

    public void verifyValueofCategoryComboBox(String categoryName) throws Exception {
        createToDoPage.verifyListValueofCategoryComboxBox(categoryName);
    }

    public void verifyNewCategoryPopUpDisplayed() throws Exception {
        createToDoPage.clickAddNewCategory();
        createToDoPage.verifyNewCategoryPopUpDisplayed();
    }

    public void verifyEditCategoryPopUpDisplayed() throws Exception {
        createToDoPage.clickEditCategory();
        createToDoPage.verifyEditCategoriesPopUpDisplayed();
    }

    public void verifyCreateToDoTaskWithoutCategory(String todoName) throws Exception {
        createToDoPage.verifyCreateToDoTaskWithoutCategory(todoName);
    }

    public void verifyInputMaxLengthToDoNameTextBox() {
        createToDoPage.verifyInputMaxLengthToDoNameTextBox();
    }

    public void verifyInputInValidValueToDoNameTextBox() {
        createToDoPage.inputInvalidValueToDoNameTextBox();
        createToDoPage.selectDueDateToDoTask();
        createToDoPage.verifyWarningCssValueToDoNameTextBox();
    }

    public void setDueDateField() {
        createToDoPage.selectDueDateToDoTask();
    }

    public void createListToDoTask(List<String> toDoTaskNames) throws Exception {
        for (int i = 0; i < toDoTaskNames.size(); i++) {
            createToDoPage.createToDoTask(toDoTaskNames.get(i));
        }
    }

    public void clickCheckboxNewToDoTask() {
        createToDoPage.clickCheckboxNewToDoTask();
    }

    public void clickBulkActionsDropdown() {
        createToDoPage.clickBulkActionsDropdown();
    }

    public void verifyDefaultValueofBulkActionsDropdown(String defaultValueBulkActions) {
        createToDoPage.verifyDefaultValueofBulkActionsDropdown(defaultValueBulkActions);
    }

    public void verifyHoverBulkActionsDropdown() {
        createToDoPage.verifyHoverBulkActionsDropdown();
    }

    public void verifyListValueofBulkActionsDropdown() {
        createToDoPage.verifyListValueofBulkActionsDropdown();
    }

    public void clickDeleteToDoBulkActions() {
        createToDoPage.clickDeleteToDoBulkActions();
    }

    public void verifyCompleteMarkPopup() {
        createToDoPage.verifyCompleteMarkPopup();
    }

    public void verifyClickCloseMarkPopup() {
        createToDoPage.verifyClickCloseMarkPopup();
    }

    public void verifyDeleteToDoPopUpDisplayed() {
        createToDoPage.verifyGUIDeleteToDoPopUp();
    }

    public void clickCloseButtonOnPopup() {
        createToDoPage.clickCloseButtonOnPopup();
    }

    public void clickCancelButtonOnPopup() {
        createToDoPage.clickCancelButtonOnPopup();
    }

    public void verifyBulkActionsDropdownIsClosed() {
        createToDoPage.verifyBulkActionsDropdownIsClosed();
    }

    public int selectToDoTaskName(String toDoName) {
        return createToDoPage.selectToDoCheckboxByName(toDoName);
    }

    public void unselectToDoTaskName(String toDoName) {
        createToDoPage.unSelectToDoCheckboxByName(toDoName);
    }

    public int getNumberofToDoTask() {
        return createToDoPage.getNumberofToDoTask();
    }

    public void waitMessageIsDisappear() {
        //createToDoPage.waitMessageIsDisappear();
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start

    /**
     * Move add new to do page
     */
    public void navigateAddNewToDoPage() {

        try {
            createToDoPage.navigateAddNewToDoPage();
            NXGReports.addStep("Move Add new To-Do page", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Move Add new To-Do page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Verify select data drop down
     */
    public void verifySelectDateDropDown() throws Exception {
        createToDoPage.verifySelectDateDropDown();
    }

    /**
     * Check default value of due date text box
     */
    public void checkDefaultValueDueDate() {
        boolean result = createToDoPage.checkDefaultDueDateValue();
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Check deafult format due date
     */
    public void checkFormatDueDate() {
        boolean result = createToDoPage.checkFormatDueDate();
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify data in date picker
     */
    public void verifyDataOfDatePicker(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyDataOfDatePicker(isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }


    /**
     * Hover item in date picker
     */
    public void hoverItemInDatePikcer(boolean isNewToDoPage) {
        createToDoPage.hoverDateItemInDatePicker(isNewToDoPage);
    }

    /**
     * Choose date item in date picker
     */
    //    public void chooseDateItemInDatePicker(boolean isNewToDoPage) throws Exception {
    //        boolean result = createToDoPage.chooseDateItemInDataPicker(isNewToDoPage);
    //        if (!result)
    //            AbstractService.sStatusCnt++;
    //    }
    public void chooseDateItemInDatePicker(String month, String date, String year) throws Exception {
        createToDoPage.chooseDateItemInDataPicker(month, date, year);

    }

    public void verifyDateSelectedCorrectly(String dateSelected) {
        createToDoPage.verifyDuedateTimebox(dateSelected);
    }

    /**
     * Verify previous date picker link is click
     */
    public void verifyPreviousDatePickerLink(boolean isNewToDoPage) {
        boolean result = createToDoPage.checkDatePickerChangeMonth("prev", false, isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify next date picker link is click
     */
    public void verifyNextDatePickerLink(boolean isNewToDoPage) {
        boolean result = createToDoPage.checkDatePickerChangeMonth("next", true, isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input correct format date in due date text box
     */
    public void verifyInputCorrectFormatDate(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputCorrectFormatDate("05/20/2017", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input wrong format date in due date text box
     */
    public void verifyInputWrongFormatDate(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("055/20/2017", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputTextValue(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("dadasdasdad", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    /**
     * Verify input text in due date text box
     */
    public void verifyInputSpecialCharacterValue(boolean isNewToDoPage) {
        boolean result = createToDoPage.verifyInputWrongValue("~!@#$%^&*+?><,. ", isNewToDoPage);
        if (!result)
            AbstractService.sStatusCnt++;
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- End

    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- Start

    /**
     * Verify trash to do icon
     */
    public void verifyTrashToDoIcon() {
        createToDoPage.verifyTrashToDoIcon();
    }

    /**
     * Verify default status trash to do icon
     */
    public void verifyDefaultStatusTrashToDoIcon() {
        createToDoPage.verifyDefaultStatusTrashToDoIcon();
    }

    /**
     * Click on trash delete icon
     */
    public void clickOnTrashIcon() {
        createToDoPage.clickOnTrashIcon();
    }

    /**
     * Verify GUI and Close icon of delete confirm popup
     */
    public void verifyGUIDeleteConfirmPopup() {
        createToDoPage.verifyGUIDeleteConfirmPopup();
    }

    /**
     * Check or Uncheck CheckAll check box control
     *
     * @param isCheck : true check | false is un check
     */
    public void checkOrUnCheckCheckAllCheckBox(boolean isCheck) {
        createToDoPage.checkOrUnCheckCheckAllCheckBox(isCheck);
    }

    /**
     * Verify all check box is check or un check
     *
     * @param isCheck : true check | false is un check
     */
    public void verifyAllCheckBoxIsCheckOrUnCheck(boolean isCheck) {
        createToDoPage.verifyAllCheckBoxIsCheckOrUnCheck(isCheck);
    }

    /**
     * Check or Uncheck all check box control
     *
     * @param isCheck : true check | false is un check
     */
    public void checkOrUnCheckAllCheckBox(boolean isCheck) {
        createToDoPage.checkOrUnCheckCheckAllCheckBox(isCheck);
    }

    /**
     * Verify all check box is check or un check
     *
     * @param isCheck : true check | false is un check
     */
    public void verifyCheckAllCheckBoxIsCheckOrUncheck(boolean isCheck) {
        createToDoPage.verifyAllCheckBoxIsCheckOrUnCheck(isCheck);
    }

    /**
     * Click on delete button popup
     */
    public void clickOnDeleteButtonOnPopup() {
        createToDoPage.clickOnDeleteButtonOnPopup();
    }

    /**
     * Click on cancel button popup
     */
    public void clickOnCancelButtonOnPopup() {
        createToDoPage.clickOnCancelButtonOnPopup();
    }

    /**
     * Check ToDo item is exist
     *
     * @param isExists : true : is exists | false : is not exists
     * @param ToDoName : ToDo name need check
     */
    public void checkToDoIsExists(boolean isExists, String ToDoName) {
        if (!createToDoPage.checkToDoIsExists(isExists, ToDoName)) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Check ToDo item list is exists
     *
     * @param isExists  : true : is exists | false : is not exists
     * @param ToDoNames : ToDo name list need check
     */
    public void checkToDoListIsExists(boolean isExists, List<String> ToDoNames) {
        if (!createToDoPage.checkToDoListIsExists(isExists, ToDoNames)) {
            AbstractService.sStatusCnt++;
        }
    }

    public void verifyLeadAuditorSeeListToDoTask(boolean isExists, List<String> toDoNames) {
        createToDoPage.verifyPermissionSeeListToDoTask(toDoNames, false, isExists);
    }

    /**
     * Check all ToDo item is delete
     */
    public void checkAllToDoIsDelete() {
        if (!createToDoPage.checkAllToDoIsDelete()) {
            AbstractService.sStatusCnt++;
        }
    }


    //[PLAT-2286] Add delete icon TanPH 2017/05/17 -- End

    public void clickCommentIconPerTaskName(String toDoTaskName) {
        createToDoPage.clickCommentIconPerTaskName(toDoTaskName);
    }

    public void verifyDefaultHintValueInputComment() {
        createToDoPage.verifyDefaultHintValueInputComment();
    }

    public void verifyCancelCompleteMarkPopup() {
        createToDoPage.verifyCancelCompleteMarkPopup();
    }

    public void closeSuccessToastMes() {
        createToDoPage.closeSuccessToastMes();
    }

    public void verifyBoxTitleComment() {
        createToDoPage.verifyGUIBoxTitleComment();
    }

    public void verifyGUICommentList(String commentContent) {
        createToDoPage.verifyGUICommentList(commentContent);
    }

    public void verifyInputAComment(String commentContent) {
        createToDoPage.verifyInputAComment(commentContent);
    }

    public void verifyInputMultiComment(String commentType, int numberComment) {
        for (int i = 0; i < numberComment; i++) {
            createToDoPage.verifyInputAComment(commentType + i);
            clickOnPostCommentButton();
        }
    }

    public void clickOnPostCommentButton() {
        createToDoPage.clickOnPostCommentButton();
    }

    public int getNumberOfListComment() {
        return createToDoPage.getNumberOfListComment();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyAddNewRequestButton() {
        createToDoPage.verifyAddNewRequestButton();

    }

    public void verifyClickAddRequestBtn() {
        createToDoPage.verifyClickAddRequestBtn();
    }

    public void selectAddNewRequestButton() {
        createToDoPage.verifyClickAddRequestBtn();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyColorAddRequestBtn() {
        createToDoPage.verifyColorAddRequestBtn();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyRequestNameTextbox() {
        createToDoPage.verifyRequestNameTextbox();
    }

    /**
     * Author minh.nguyen
     * Vien.Pham modified for smoke test
     */
    //    public void verifyCreateRequest(String requestName1, String requestName2) {
    //        createToDoPage.verifyNewRequestStoreInDatabase(requestName1, requestName2);
    //    }
    public void createNewRequest(String newRequest, String position) {
        createToDoPage.createNewRequest(newRequest, position);
    }

    public void reselectEngagementName(String engagementName) {
        //        createToDoPage.returnToTodoListPage_LoginToEngagementAgain();
        createToDoPage.reselectEngagementName(engagementName);
    }

    /**
     * Author minh.nguyen
     * Vien.Pham added upload, download request file.
     */


    public void uploadeNewFileByRequestName(String uploadLocation, String fileName,
            String requestName) throws InterruptedException, AWTException, IOException {
        createToDoPage.uploadeNewFileByRequestName(uploadLocation.concat(fileName), requestName);

    }

    public void uploadNewFileByPosition(String uploadLocation, String fileName, int position) {
        createToDoPage.uploadNewFileByPosition(uploadLocation.concat(fileName), position);
    }

    public void verifyUploadFileSuccessfully(String fileName) {
        createToDoPage.verifyUploadFileSuccessfully(fileName);
    }

  /*  public void uploadFileNewRequestByClient(String uploadLocation, String fileName) throws InterruptedException, AWTException, IOException {
        createToDoPage.uploadFileNewRequestByClient(uploadLocation.concat(fileName));
    }*/

   /* public void verifyUploadFileNewRequestByClient(String fileName) throws InterruptedException, AWTException, IOException {
        createToDoPage.verifyUploadFileSuccessfullyByClient(fileName);
    }*/

    public void auditorAttachNewFile(String attachLocation, String fileName) {
        createToDoPage.attachFile(attachLocation, fileName);
    }

    public void clientDownloadAttachFile(String pathOfDownload, String fileName) {
        createToDoPage.downloadAttachFile(pathOfDownload, fileName);
    }

   /* public void downloadCreateRequestNewFileClient(String uploadLocation, String downloadLocation, String fileName) {
        createToDoPage.downloadCreateRequestNewFileClient(uploadLocation.concat(fileName), downloadLocation.concat(fileName));
//        createToDoPage.calculateMd5(downloadLocation.concat(fileName));
//        createToDoPage.verifyDownloadSuccessfully(uploadLocation,downloadLocation,fileName);
    }*/

    /**
     * Author minh.nguyen
     */
    public void verifyDeleteRequest() {
        createToDoPage.verifyDeleteRequestOnPopup();
    }

    /**
     * Author minh.nguyen
     */
    public void verifyCopyRequest() {
        createToDoPage.verifyCopyTaskOnPopup();
    }

    public void verifyNewCommentIsDisplayed(int numberListCommentBeforeAdding, String commentContent) {
        createToDoPage.verifyNewCommentIsDisplayed(numberListCommentBeforeAdding, commentContent);
    }

    public void verifyClickOnInputCommentField() {
        createToDoPage.verifyClickOnInputCommentField();
    }

    public void verifyUserInputNoContentComment() {
        createToDoPage.verifyUserInputNoContentComent();
    }

    public void verifyInputMaxLenghtContentComment(int maxLength) {
        createToDoPage.verifyInputMaxLenghtContentComment(maxLength);
    }

    public void verifyInputSpecialCharactersContentComment() {
        createToDoPage.verifyInputSpecialCharactersContentComment();
    }


    /**
     * Create ToDo name list
     *
     * @author : TanPham
     * @date : 29/05/2017
     */

    public List<String> createToDoNameList(String todoName, int numberToDo) {
        return createToDoPage.createToDoNameList(todoName, numberToDo);
    }

    /**
     * Select check box follow To-Do name list
     *
     * @author : TanPham
     * @date : 29/05/2017
     */
    public void selectMultiToDoTaskByNameList(List<String> toDoNameList) {
        for (int i = 0; i < toDoNameList.size(); i++) {
            createToDoPage.selectToDoCheckboxByName(toDoNameList.get(i));
        }
    }

    public void verifyGUIPostButton() {
        createToDoPage.verifyGUIPostButton();
    }

    /*
    Vien add new method for PLAT 2326-2301 TO verify To-dos textbox
     */


    public void waitForNewTodoNameApplied() {
        createToDoPage.waitForNewTodoNameSaved();
    }

    public void createCategories(String cate) throws Exception {
        createToDoPage.createNewCategory(cate);
    }

    public void createMultiCategory(String cate1, String cate2, String cate3) throws Exception {
        createToDoPage.createNewCategory(cate1);
        createToDoPage.createNewCategory(cate2);
        createToDoPage.createNewCategory(cate3);
    }

    public void navigateToEditNewCategory() throws InterruptedException {
        createToDoPage.navigateToEditCategory();

    }

    public void verifyTodosTextBox_AfterClickedAddTodo() throws InterruptedException {
        //        createToDoPage.verifyOnlyTodoTextbox_PlaceHolderValue();
        createToDoPage.verifyTodoTextboxBorder_AfterClickedAddTodo();
        //        createToDoPage.verifyTodoTextboxBorder_WhileHoveredOrFocus();
        //        createToDoPage.verifySecondTodoTextbox_PlaceHolderValue();
    }

    public void inputValidValue_TodoName(String validValue) {

        createToDoPage.InputValue_TodoName(validValue);
    }

    public void verifyInputValidValue(String validValue) {
        createToDoPage.verifyInputValidValue(validValue);
    }

    public void inputOnlyNumber(String number) {
        createToDoPage.InputValue_TodoName(number);
    }

    public void verifyInputNumber(String number) {
        createToDoPage.verifyInputValidValue(number);

    }

    public void InputSpecialChar(String specialChar) {

        createToDoPage.InputValue_TodoName(specialChar);
    }

    public void verifyInputSpecialChar(String specialChar) {

        createToDoPage.verifyInputInvalidValue(specialChar);
    }

    public void inputNullChar(String nullChar) {
        createToDoPage.InputValue_TodoName(nullChar);

    }

    public void verifyInputNullChar(String nullChar) {
        createToDoPage.verifyInputInvalidValue(nullChar);

    }

    public void verifyCategoryComboBox_DefaultValue() {
        createToDoPage.verifyCategoryBox_DefaultValue();
    }

    public void verifyCategoryComboBox_NewValue(String cate) {
        createToDoPage.verifyCategoryIsSelectedCorrectly(cate);
    }

    public void selectCategoryByName(String cate) {
        createToDoPage.selectCategoryByName(cate);
    }

    public void verifyNewCategoryChosenCorrectly(String cate1) {
        createToDoPage.verifyCategoryIsSelectedCorrectly(cate1);
    }

    public void verifyClientAssigneeComboBox_DefaultValue() {
        createToDoPage.verifyClientAssignee_DefaultValue();
        createToDoPage.verifyBorderOfClientAssignee_WhileHovered();
    }

    public void selectClientAssignee(String clientName) {
        createToDoPage.selectClientAssignee(clientName);
    }

    public void verifyClientAssigneeIsSelectedCorrectly(String clientName) {
        createToDoPage.verifyClientAssigneeIsSelectedCorrectly(clientName);
    }


    public void verifyDuedateTimebox_DefaultValue(String deadlineDate) {
        createToDoPage.verifyDuedateTimebox(deadlineDate);
    }

    public void verifyUnableToInputDuedate(String dateInput) {
        createToDoPage.verifyUnableToInputDuedate(dateInput);
    }

    public void verifyAuditAssigneeBox(String auditAssignee) {
        createToDoPage.verifyAditAssignee_DefaultValue(auditAssignee);
        createToDoPage.verifyBorderAuditAssignee_WhileHoverd();
    }

    public void verifyAuditAssigneeIsSelectedCorrectly() {
        createToDoPage.verifyAuditAssigneeIsSelectedCorrectly();
    }

    public void verifyCreateTodoBtn() {
        createToDoPage.verifyCreateTodoBtn_DefaultValue();
        //        createToDoPage.verifyCreateTodoBtn_Click();
    }

    public void verifyFilterBtn() {
        createToDoPage.verifyFilterBtn_DefaultValue();
        createToDoPage.verifyFilterBtn_WhileHovered();
        createToDoPage.clickFilterBtn();
        //        createToDoPage.verifyFilterDropdown();

    }

    public void verifyBulkActionBtn() throws Exception {
        createToDoPage.verifyBulkActionBtn();
        createToDoPage.verifyCheckAllCheckboxToDoName();
        createToDoPage.verifyBulkActionBtn();
    }

    public void verifySearchBox_DefaultGUI() {
        createToDoPage.verifySearchDefault();
        createToDoPage.verifySearchBorderWhileHover();
    }

    public void verifySearchWhileInput() {
        createToDoPage.verifySearchBorderWhileInput();
    }

    public void verifyNameReturnDefault() {
        createToDoPage.verifyNameReturnDefault();

    }

    public void clickArchiveTaskButton() {
        createToDoPage.clickArchiveTaskButton();
    }

    public void verifyMarkCompleteArchive(int index) {
        createToDoPage.verifyMarkCompleteArchive(index);
    }

    public void deleteAllExistedTodoItems() {
        createToDoPage.deleteAllExistedTodoItems();
    }

    public void verifyExistedCategory() {
        createToDoPage.verifyExistedCategory();
    }

    public void verifyAddNewRequestPopUp() {
        createToDoPage.verifyAddNewRequestPopUp();
    }

    public void verifyCommentSuccessFul(String comment, int numberOfComment) {
        createToDoPage.verifyCommentSuccessFul(comment, numberOfComment);
    }

    public void selectClientAssigneeByName(String toDoName, String clientAssignee) {
        createToDoPage.selectClientAssigneeByName(toDoName, clientAssignee);
    }

    public void selectAuditorAssigneeByName(List<String> listToDoName, String auditorAssignee) {
        for (String toDoName:listToDoName){
            createToDoPage.selectAuditorAssigneeByName(toDoName, auditorAssignee);
        }
    }

    public void verifyAuditorAssigneeSelected(List<String> listToDoName, String auditorAssignee) {
        for (String toDoName:listToDoName){
            createToDoPage.verifyAuditorAssigneeSelected(toDoName, auditorAssignee);
        }
    }

    public void verifyClientAssigneeSelected(String toDoName, String clientAssignee) {
        createToDoPage.verifyClientAssigneeSelected(toDoName, clientAssignee);
    }

    /**
     * Add new by thuan duong on 20/06/2017.
     * New for smoke test
     */
    public void selectAssigneeToDoUsingBulkAction(String userName) throws InterruptedException {
        createToDoPage.selectAssigneeToDoUsingBulkAction(userName);
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - Start
     *
     **/

    /**
     * Verify engagement overview status does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverViewStatusWhenClickOnCloseIconPopup() {
        createToDoPage.verifyEngagementOverviewStatusDoesNotChange(true);
    }

    /**
     * Verify engagement overview todo does not change when click on close icon popup
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverViewToDoWhenClickOnCloseIconPopup() {
        createToDoPage.verifyEngagementOverviewToDoDoesNotChange(true);
    }

    /**
     * Verify engagement overview status does not change when click on cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverViewStatusWhenClickOnCancelButton() {
        createToDoPage.verifyEngagementOverviewStatusDoesNotChange(false);
    }

    /**
     * Verify engagement overview todo does not change when click on cancel button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverViewToDoWhenClickOnCancelButton() {
        createToDoPage.verifyEngagementOverviewToDoDoesNotChange(false);
    }

    /**
     * Verify engagement overview status change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverviewStatusWhenClickOnArchiveButton() {
        createToDoPage.verifyEngagementOverviewStatusChange();
    }

    /**
     * Verify engagement overview todo change when click on archive button
     *
     * @author : TanPham
     * @date : 2017/06/20
     */
    public void verifyEngagementOverViewToDoWhenClickOnArchiveButton() {
        createToDoPage.verifyEngagementOverviewToDoChange();
    }


    /**
     * Click on close icon in mark as complete popup
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void clickOnCloseIconInMarkAsCompletePopup() {
        createToDoPage.clickOnCloseIconInMarkAsCompletePopup();
    }

    /**
     * Click on cancel button in mark as complete popup
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void clickOnCancelButtonInMarkAsCompletePopup() {
        createToDoPage.clickOnCancelButtonInMarkAsCompletePopup();
    }

    /**
     * Click on archive button in mark as complete popup
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void clickOnArchiveButtonInMarkAsCompletePopup() {
        createToDoPage.clickOnArchiveButtonInMarkAsCompletePopup();
    }

    /**
     * Verify mark as complete popup is close
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyMarksAsCompletePopupIsClose() {
        createToDoPage.verifyMarksAsCompletePopupIsClose();
    }

    /**
     * Click on engagement link
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void clickOnEngagementLink() {
        createToDoPage.clickOnEngagementLink();
    }

    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - Start
     **/


    public void clickCommentIconPerTaskName(String toDoTaskName, boolean isClient) {
        createToDoPage.clickCommentIconPerTaskName(toDoTaskName, isClient);
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
        createToDoPage.verifyEngagementOverviewStatusIsComplete();
    }

    /**
     * Verify engagement overview ToDo is complete
     *
     * @author : TanPham
     * @date : 2017/06/21
     */
    public void verifyEngagementOverviewToDoIsComplete() {
        createToDoPage.verifyEngagementOverviewToDoIsComplete();
    }
    /**
     * verifyAuditorMarkAsComplete - TanPh - 2017/06/20 - End
     *
     **/

    /**
     * Add new by huy.huynh on 21/06/2017.
     * SmokeTest R2
     */
    public void selectDeleteToDoUsingBulkAction() {
        createToDoPage.chooseOptionDeleteOnBulkActionsDropDown();
    }

    public void confirmDeleteButton() {
        createToDoPage.clickConfirmDeleteButton();
    }

    public void verifyToDoNotExist(String todoName) {
        createToDoPage.verifyToDoNotExist(todoName);
    }

    public void checkAllCheckBox() {
        createToDoPage.checkOrUnCheckCheckAllCheckBox(true);
    }

    public void verifyEmptyToDoList() {
        createToDoPage.verifyEmptyToDoList();
    }
    /*-----------end of huy.huynh on 21/06/2017.*/

    public void verifyLastCommentOfUserDisplayed(String commentContent, String fullNameUser) {
        createToDoPage.verifyLastCommentOfUserDisplayed(commentContent, fullNameUser);
    }

    public void verifyTodoMarkCompleted(String todoName) {
        createToDoPage.verifyTodoMarkCompleted(todoName);
    }

    public void clickToBulkDownloadAttachmentButton() {
        createToDoPage.clickToBulkDownloadAttachmentButton();
    }

    public void clickDownloadAllTodo() {
        createToDoPage.clickDownloadAllTodo();
    }

    public void checkFileDownloadExisted(String pathLocation) {
        GeneralUtilities.checkFileExists(pathLocation, true);
    }

    public void verifyDownloadFileAllTodoSuccess(String pathLocation) {
        createToDoPage.verifyDownloadFileAllTodoSuccess(pathLocation);
    }

    public void verifyRequestCreated(List<String> listRequest) {
        createToDoPage.verifyRequestCreated(listRequest);
    }

    public void verifyAssignTodotoClient(List<String> listTodo, String clientFullName) {
        for (String todo : listTodo) {
            selectClientAssigneeByName(todo, clientFullName);
            verifyClientAssigneeSelected(todo, clientFullName);
        }
    }

    public void verifyCreateNewRequest(List<String> listTodo, List<String> listRequest) {
        for (String todo : listTodo) {
            clickCommentIconPerTaskName(todo);
            for (int i = 1; i <= listRequest.size(); i++) {
                verifyClickAddRequestBtn();
                createNewRequest(listRequest.get(i - 1), String.valueOf(i));
            }
            createToDoPage.closeAddNewRequestWindow();
            clickCommentIconPerTaskName(todo);
            verifyRequestCreated(listRequest);
        }
    }

    /**
     * @param todoName:       Todo name
     * @param pathUploadFile: path location contains file upload
     * @param listRequest:    list request will create
     * @param listFile:       List file upload in request
     * @throws Exception: InterruptedException, AWTException, IOException
     */
    public void verifyAddFileToNewRequest(String todoName, String pathUploadFile, List<String> listRequest, List<String> listFile) throws Exception {
        for (int i = 0; i < listRequest.size(); i++) {
            clickCommentIconPerTaskName(todoName);
            uploadeNewFileByRequestName(pathUploadFile, listFile.get(i), listRequest.get(i));
            createToDoPage.closeAddNewRequestWindow();
            clickCommentIconPerTaskName(todoName);
            verifyUploadFileSuccessfully(listFile.get(i));
            createToDoPage.closeAddNewRequestWindow();
        }
    }

    public void downloadFileFromRequest(String downloadLocation, String fileName) {
        createToDoPage.downloadFileFromRequest(downloadLocation, fileName);
    }

    public void downloadFileFromComment(String downloadLocation, String fileName) {
        createToDoPage.downloadFileFromComment(downloadLocation, fileName);
    }

    public void downloadFilesFromRequest(String downloadLocation, List<String> filesName) {
        for (int i = 0; i < filesName.size(); i++) {
            createToDoPage.downloadFileFromRequest(downloadLocation, filesName.get(i));
        }
    }

    public void downloadFilesFromComment(String downloadLocation, List<String> filesName) {
        for (int i = 0; i < filesName.size(); i++) {
            createToDoPage.downloadFileFromComment(downloadLocation, filesName.get(i));
        }
    }

    public void verifyDownloadFileSuccessful(String pathUpload, String pathDownload, String fileName) {
        createToDoPage.verifyDownloadFileSuccess(pathUpload, pathDownload, fileName);
    }

    public void verifyDownloadFilesSuccessful(String pathUpload, String pathDownload, List<String> filesName) {
        for (int i = 0; i < filesName.size(); i++) {
            createToDoPage.verifyDownloadFileSuccess(pathUpload, pathDownload, filesName.get(i));
        }
    }

    public void uploadFileByRequestName(String pathOfUploadLocation, List<String> listFile, List<String> listRequest) {
        for (int i = 0; i < listRequest.size(); i++) {
            createToDoPage.uploadeNewFileByRequestName(pathOfUploadLocation.concat(listFile.get(i)), listRequest.get(i));

        }
    }

    public void verifyUploadFileSuccessfully(List<String> listFile, List<String> listRequest) {
        for (int i = 0; i < listRequest.size(); i++) {
            createToDoPage.verifyUploadFileSuccessfully(listFile.get(i));
        }

    }
}

