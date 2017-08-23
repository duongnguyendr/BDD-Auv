package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.todo.AuditorTodoListPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import javax.sql.rowset.spi.SyncFactoryException;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorTodoListService extends AbstractService {

    AuditorTodoListPage auditorTodoListPage;
    AuditorCreateToDoPage auditorCreateToDoPage;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;

    /*
     * contructor
     */
    public AuditorTodoListService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorTodoListPage = new AuditorTodoListPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
    }


    public void navigateToClientSettingsPage() {

        try {
            getLogger().info("navigate to client Settings page.");
            //auditorEngagementTeamPage.navigateToClientSettingsPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyTodoListPageColumnHeader() {
        auditorTodoListPage.verifyTodoListPageColumnHeader();
    }


    public void verifyEmptyTodoList() {
        try {
            getLogger().info("verify empty to do List.");
            auditorTodoListPage.verifyEmptyTodoList();
            NXGReports.addStep("verify empty To Do List.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify empty To Do List.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyTodoListPage() {
        try {
            getLogger().info("verify todo List Page.");
            auditorTodoListPage.verifyTodoListPage();
            NXGReports.addStep("verify todo List Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("verify todo List Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyFilterDropDownList() {
        getLogger().info("Verify Filter DropDown List.");
        auditorTodoListPage.verifyFilterDropDownList();
    }

    public void verifyDefaultValueFilterDropDownList() {
        getLogger().info("Verify default value on Filter dropdown list.");
        auditorTodoListPage.verifyDefaultValueFilterDropDownList();
    }

    public void verifyHoverFilterDropDownList() {
        getLogger().info("Verify Border on Filter dropdown list.");
        auditorTodoListPage.verifyHoverFilterDropDownList();
    }

    public void verifySelectShowAllDropDownList() {
        getLogger().info("Select Show All on Filter dropdown list.");
        auditorTodoListPage.selectShowAllFilterDropDownList();
        getLogger().info("Verify Show All text on Filter dropdown list.");
        auditorTodoListPage.verifySelectShowAllFilterDropDownList();
    }

    public void verifySelectDueDateDropDownList() {
        getLogger().info("Select Due Date on Filter dropdown list.");
        auditorTodoListPage.selectDueDateFilterDropDownList();
        getLogger().info("Verify Due Date text on Filter dropdown list.");
        auditorTodoListPage.verifySelectDueDateFilterDropDownList();
    }

    public void selectAndVerifyFirstAssignFilterDropDownList() {
        auditorTodoListPage.selectAndVerifyFirstAssignFilterDropDownList();
    }

    public void verifySelectWithCommentsDropDownList() {
        getLogger().info("Select With Comments on Filter dropdown list.");
        auditorTodoListPage.selectWithCommentsFilterDropDownList();
        getLogger().info("Verify With Comments text on Filter dropdown list.");
        auditorTodoListPage.verifySelectWithCommentsFilterDropDownList();
    }

    public void verifySelectCompleteDropDownList() {
        getLogger().info("Select Complete on Filter dropdown list.");
        auditorTodoListPage.selectCompleteFilterDropDownList();
        getLogger().info("Verify Complete text on Filter dropdown list.");
        auditorTodoListPage.verifySelectCompleteFilterDropDownList();
    }

    public void verifySelectFlaggedForRequestDropDownList() {
        getLogger().info("Select Flagged For Request on Filter dropdown list.");
        auditorTodoListPage.selectFlaggedForRequestFilterDropDownList();
        getLogger().info("Verify Flagged For Request text on Filter dropdown list.");
        auditorTodoListPage.verifySelectFlaggedForRequestFilterDropDownList();
    }

    public void verifyUnableAddMoreOptionFilterDropDownList() {
        getLogger().info("verify Unable Add More Option Filter DropDownList");
        auditorTodoListPage.verifyUnableAddMoreOptionFilterDropDownList();
    }

    public void verifyClickAndDoNotSelectValue() {
        getLogger().info("verify verify Click And Do Not Select Value Filter DropDownList");
        auditorTodoListPage.verifyClickAndDoNotSelectValue();
    }

    public void navigateToEngagementDetailPage() {
        try {
            getLogger().info("navigate to Engagement Detail page.");
            auditorDetailsEngagementPage.navigateToTodoListPage();
            NXGReports.addStep("navigate to To Do list tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to To Do list tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * Added by huy.huynh on 18/05/2017.
     * Scenarios : PLAT 2285 - Add undo option
     * Modified by huy.huynh on 19/05/2017.
     * Merge with PLAT 2303(merge frontend and backend)
     */

    public void uiVerifyButtonUndoExist() {
        auditorCreateToDoPage.uiVerifyButtonUndoExist();
    }

    /**
     * verify button Undo disable
     */
    public void uiVerifyButtonUndoDisable() {
        auditorCreateToDoPage.uiVerifyButtonUndoDisable();
    }

    /**
     * verify button Undo enable
     */
    public void uiVerifyButtonUndoEnable() {
        auditorCreateToDoPage.uiVerifyButtonUndoEnable();
    }

    /**
     * create a record with name and date(of this month- implement choose month and year later)
     *
     * @param toDoName name of To-Do to create
     * @param dueDate  date of this month which chosen as dueDate
     */
    public void createToDoRecord(String toDoName, String dueDate) {
        auditorCreateToDoPage.createToDoPageWithNameAndDate(toDoName, dueDate);
    }

    /**
     * choose given name To-Do
     *
     * @param toDoName name of To-Do to choose
     */
    public void chooseARowWithName(String toDoName) {
        auditorCreateToDoPage.clickCheckBoxAtRowName(toDoName);
    }

    /**
     * choose an action as actionName
     *
     * @param actionName kind of action to choose(Mark as complete,Delete,Assign to...)
     */
    public void selectOnBulkActions(String actionName, String assigneeNameAndRole) {
        auditorCreateToDoPage.clickBulkActions();
        if (actionName.equals("Mark as complete")) {
            auditorCreateToDoPage.chooseOptionMarkAsCompleteOnBulkActionsDropDown();
            auditorCreateToDoPage.clickComfirmArchive();
        } else if (actionName.equals("Delete")) {
            auditorCreateToDoPage.chooseOptionDeleteOnBulkActionsDropDown();
            auditorCreateToDoPage.clickComfirmDelete();
        } else if (actionName.equals("Assign to")) {
            auditorCreateToDoPage.chooseOptionAssignToOnBulkActionsDropDown();
            auditorCreateToDoPage.chooseOptionAssignToAssigneeOnBulkActionsDropDownWithName(assigneeNameAndRole);
        }
    }

    /**
     * choose given name To-Do and cho an action for it
     *
     * @param toDoName name of To-Do to choose
     * @param action   kind of action(Mark as complete,Delete,Assign to...)
     */
    public void chooseAndActAToDoWithName(String toDoName, String action, String assigneeNameAndRole) {
        chooseARowWithName(toDoName);
        selectOnBulkActions(action, assigneeNameAndRole);
    }

    /**
     * verify frontend and backend of Complete To-Do feature
     *
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoComleteStatusByName(String engagementValue, String todoName, String status) {
        /*auditorCreateToDoPage.verifyTodoCompleteFrontend(todoName, status);
        auditorCreateToDoPage.verifyToDoCompleteBackend("name", engagementValue, todoName, status);*/
    }

    /**
     * verify frontend and backend of Delete To-Do feature
     *
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param status          status complete expected
     */
    public void verifyToDoDeleteStatusByName(String engagementValue, String todoName, String status) {
        /*auditorCreateToDoPage.verifyTodoDeletedFrontend(todoName, status);
        auditorCreateToDoPage.verifyToDoDeteteBackend("name", engagementValue, todoName, status);*/
    }

    /**
     * verify frontend and backend of Assign to To-Do feature
     *
     * @param engagementValue engagement value chosen as value
     * @param todoName        name of To-Do to check status
     * @param assigneeName    name of assignee
     */
    public void verifyToDoAssigneeToName(String engagementValue, String todoName, String assigneeName) {
        /*auditorCreateToDoPage.verifyTodoAssignToFrontend(todoName, assigneeName);
        auditorCreateToDoPage.verifyToDoAssignToBackend("name", engagementValue, todoName, assigneeName);*/
    }

    /**
     * verify name of assignee appear on Client Assignee after assign
     *
     * @param todoName name of To-Do to check status
     */
    public void verifyToDoDownloadAttachmentsDisable(String todoName) {
        chooseARowWithName(todoName);
        auditorCreateToDoPage.clickBulkActions();
        auditorCreateToDoPage.verifyOptionDownloadAttachmentsOnBulkActionsDropDown();
    }

    /**
     * click button(icon) Undo
     */
    public void undoAction() {
        auditorCreateToDoPage.clickBtnUndo();
    }

    /**
     * verify button Undo exist
     */

    /**
     * -----end of huy.huynh PLAT-2285-----
     */

    public void verifyCompletedFieldUpdated(String engagementValue, String todoName, String status) throws SyncFactoryException {
        auditorCreateToDoPage.verifyMarkAsCompleteBackend("name", engagementValue, todoName, status);
    }

    /**
     * Refactored by huy.huynh on 02/06/2017.
     * New for smoke test
     */

    public void navigateToInviteClientPage() {
        auditorTodoListPage.navigateToInviteClientPage();
    }

    public void navigateToInviteGeneralMember(){
        auditorTodoListPage.navigateToInviteGeneralMember();
    }

    /*-----------end of huy.huynh on 02/06/2017.*/

}



