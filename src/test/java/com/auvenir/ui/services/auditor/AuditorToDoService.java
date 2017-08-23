package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.todo.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.todo.AuditorToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 04/07/2017.
 */
public class AuditorToDoService extends AbstractService {

    private AuditorToDoPage auditorToDoPage;
    private AuditorCreateToDoPage auditorCreateToDoPage;

    public AuditorToDoService(Logger logger, WebDriver driver) {
        super(logger, driver);
        auditorToDoPage = new AuditorToDoPage(getLogger(), getDriver());
        auditorCreateToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    }

    /**
     * Add new by huy.huynh on 28/06/2017.
     * R2.1 NewFeature
     */
    public String getToDoDueDateOnRow(String todoName) {
        return auditorToDoPage.getToDoDueDateOnRow(todoName);
    }

    public void openPopupTodoDetail(String todoName) {
        auditorToDoPage.clickImageTodoDetails(todoName);
    }

    public void verifyDueDateMatching(String rowDueDate) {
        auditorToDoPage.verifyDueDateMatching(rowDueDate);
    }

    public void changeDueDateOnTodoDetail(int validDateIndex) {
        auditorToDoPage.changeDueDateOnTodoDetail(validDateIndex);
    }

    public void closePopupTodoDetail() {
        auditorCreateToDoPage.closeAddNewRequestWindow();
    }

    public void changeDueDateOnTodoRow(String todoName, int validDateIndex) {
        auditorToDoPage.changeDueDateOnTodoRow(todoName, validDateIndex);
    }

    public void verifyDatePickerShow() {
        auditorToDoPage.verifyDatePickerShow();
    }

    public void verifyDatePickerDateFormat() {
        auditorToDoPage.verifyDatePickerDateFormat();
    }

    public void verifyHoverOnField() {
        auditorToDoPage.verifyHoverOnField();
    }

    public void verifyDueDateFocusing() {
        auditorToDoPage.verifyDueDateFocusing();
    }

    public String getEngagementDueDate() {
        return auditorToDoPage.getEngagementDueDate();
    }

    public void verifyDisableDateAfterDueDate(String engagementDueDate) {
        auditorToDoPage.verifyDisableDateAfterDueDate(engagementDueDate);
    }

    public void openDatePickerOnTodoDetail() {
        auditorToDoPage.clickDueDateOnTodoDetail();
    }

    public int getValidDateHasIndex(int validDateIndex) {
        return auditorToDoPage.getValidDateHasIndex(validDateIndex);
    }

    public void verifyChoosingAnotherDate(int date) {
        auditorToDoPage.verifyChoosingAnotherDate(date);
    }

    public String getMonthYearTitle() {
        return auditorToDoPage.getMonthYearTitle();
    }

    public void goToNextMonth() {
        auditorToDoPage.clickNextMonthIcon();
    }

    public void goToPreviousMonth() {
        auditorToDoPage.clickPreviousMonthIcon();
    }

    public void verifyNextMonthIcon(String monthYear) {
        auditorToDoPage.verifyNextMonthIcon(monthYear);
    }

    public void verifyPreviousMonthIcon(String monthYear) {
        auditorToDoPage.verifyPreviousMonthIcon(monthYear);
    }

    public void inputToDueDate(String value) {
        auditorToDoPage.inputToDueDate(value);
    }

    public void resetEngagementDueDateToNextMonth(String todoName) {
        auditorToDoPage.resetEngagementDueDateToNextMonth(todoName);
    }
    /*-----------end of huy.huynh on 28/06/2017.*/

    public void openTodoDetailsByTodoNameEditable(String todoName) {
        auditorToDoPage.clickIconTodoDetailsByTodoName(todoName, true);
    }

    public void openTodoDetailsByTodoNameUneditable(String todoName) {
        auditorToDoPage.clickIconTodoDetailsByTodoName(todoName, false);
    }

}
