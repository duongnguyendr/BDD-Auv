package com.auvenir.ui.pages.auditor.todo;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.pages.common.TodoPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.DatePicker;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by huy.huynh on 04/07/2017.
 */
public class AuditorToDoPage extends TodoPage {
    public AuditorToDoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * Add new by huy.huynh on 28/06/2017.
     * R2.1 NewFeature
     */
    @FindBy(id = "ui-datepicker-div")
    WebElement datePicker;

    @FindBy(id = "auv-todo-details")
    private WebElement dialogTodoDetail;

    @FindBy(id = "todo-detail-dueDate")
    private WebElement dueDateOnTodoDetail;

    @FindBy(id = "engOverview-dueDate")
    private WebElement engagementDueDate;

    private String xpathDueDateByName = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[@class='newRow']//input[@id]";
    private String xpathImageTodoDetailByName = "//input[@class='newTodoInput'][@value='%s']/ancestor::tr[@class='newRow']//img";

    public String getToDoDueDateOnRow(String todoName) {
        getLogger().info("Get DueDate on Todo Row.");
        waitSomeSeconds(3);
        return getTextByAttributeValue(getElementByXpath(xpathDueDateByName, todoName), "DueDate On Row");
    }

    public void clickImageTodoDetails(String todoName) {
        getLogger().info("Click Image Todo Detail.");
        clickElement(getElementByXpath(xpathImageTodoDetailByName, todoName), "Image Todo Detail");
    }

    public void verifyDueDateMatching(String rowDueDate) {
        getLogger().info("Verify DueDate on Todo Detail Popup is match with on Todo Row.");
        getLogger().info("rowwww: " + rowDueDate);
        getLogger().info("detail: " + getTextByAttributeValue(dueDateOnTodoDetail, "DueDate On Todo Detail"));
        if (rowDueDate.equals(getTextByAttributeValue(dueDateOnTodoDetail, "DueDate On Todo Detail"))) {
            NXGReports.addStep("DueDate on Todo Detail Popup is match with on Todo Row.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: DueDate on Todo Detail Popup isn't match with on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void clickDueDateOnTodoDetail() {
        //waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "block");
        waitSomeSeconds(1);
        clickElement(dueDateOnTodoDetail, "DueDate On Row");
        //clickByJavaScripts(dueDateOnTodoDetail, "DueDate On Row");
    }

    public void changeDueDateOnTodoDetail(int validDateIndex) {
        try {
            //System.out.println("dueDateOnTodoDetail = " + dueDateOnTodoDetail.getAttribute("value"));
            DatePicker dp = new DatePicker(getDriver());
            clickElement(dp.getValidDateHasIndex(validDateIndex), "Valid date index " + validDateIndex);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Change Due Date On Todo Detail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void changeDueDateOnTodoRow(String todoName, int validDateIndex) {
        try {
            clickElement(getElementByXpath(xpathDueDateByName, todoName), "DueDate On Row");
            DatePicker dp = new DatePicker(getDriver());
            clickElement(dp.getValidDateHasIndex(validDateIndex), "Valid date index " + validDateIndex);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Change Due Date On Todo Row", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDatePickerShow() {
        waitSomeSeconds(1);
        clickElement(dueDateOnTodoDetail, "DueDate On Row");
        waitForCssValueChanged(datePicker, "Date Picker", "display", "block");
        waitSomeSeconds(1);
    }

    public void verifyDatePickerDateFormat() {
        try {
            waitSomeSeconds(1);
            String date = getTextByAttributeValue(dueDateOnTodoDetail, "DueDate On Todo Detail");
            if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Fail: DueDate format on Todo Detail Popup isn't match 'MM/dd/yyyy'.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
            NXGReports.addStep("DueDate format on Todo Detail Popup is match 'MM/dd/yyyy'.", LogAs.PASSED, null);
        } catch (ParseException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: DueDate on Todo Detail Popup is invalid.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    public void verifyHoverOnField() {
        DatePicker dp = new DatePicker(getDriver());
        List<WebElement> listValidDates = dp.getListValidDates();
        for (int i = 0; i < listValidDates.size(); i++) {
            hoverElement(listValidDates.get(i), "Valid Element index " + i);
            validateAttributeContain(listValidDates.get(i), "class", "ui-state-hover", "Enable date index " + i);
        }
    }

    public void verifyDueDateFocusing() {
        int date = Integer.parseInt(getText(dueDateOnTodoDetail).split("/")[1]);
        DatePicker dp = new DatePicker(getDriver());
        validateAttributeContain(dp.getADate(String.valueOf(date)), "class", "ui-state-active", "Current Due Date");
    }

    public void verifyDisableDateAfterDueDate(String engagementDueDate) {
        String todoDueDate = getText(dueDateOnTodoDetail);
        DatePicker dp = new DatePicker(getDriver());
        int maxDate = dp.getQuantityDateOfMonth();
        if ((getDueDateYear(engagementDueDate) == getDueDateYear(todoDueDate)) && (getDueDateMonth(engagementDueDate) == getDueDateMonth(todoDueDate))) {
            int loopDate = getDueDateDate(engagementDueDate) + 1;
            while (loopDate <= maxDate) {
                validateAttributeContain(dp.getADateParent(String.valueOf(loopDate)), "class", "ui-datepicker-unselectable ui-state-disabled", "Disable date: " + loopDate);
                loopDate++;
            }
        } else {
            NXGReports.addStep("Not automate for engagement month not equal todo month.", LogAs.PASSED, null);
        }
    }

    public String getEngagementDueDate() {
        return getText(engagementDueDate);
    }

    public int getDueDateDate(String dueDateString) {
        return Integer.parseInt(dueDateString.split("/")[1]);
    }

    public int getDueDateMonth(String dueDateString) {
        return Integer.parseInt(dueDateString.split("/")[0]);
    }

    public int getDueDateYear(String dueDateString) {
        return Integer.parseInt(dueDateString.split("/")[2]);
    }

    public int getValidDateHasIndex(int validDateIndex) {
        int date = 0;
        try {
            DatePicker dp = new DatePicker(getDriver());
            date = Integer.parseInt(dp.getValidDateHasIndex(validDateIndex).getText());
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Change Due Date On Todo Row", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        return date;
    }

    public void verifyChoosingAnotherDate(int date) {
        if (date == Integer.parseInt(getText(dueDateOnTodoDetail).split("/")[1])) {
            NXGReports.addStep("DueDate on Todo Detail Popup is match with date just re-choose.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: DueDate on Todo Detail Popup is match with date just re-choose.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String getMonthYearTitle() {
        DatePicker dp = new DatePicker(getDriver());
        return dp.getMonthYearTitle();
    }

    public void clickNextMonthIcon() {
        DatePicker dp = new DatePicker(getDriver());
        dp.clickNextButton();
    }

    public void clickPreviousMonthIcon() {
        DatePicker dp = new DatePicker(getDriver());
        dp.clickPreviousButton();
    }

    public void verifyNextMonthIcon(String monthYear) {
        String nextMonthYear = getMonthYearAdded(monthYear, 1);
        if (nextMonthYear.equals(getMonthYearTitle())) {
            NXGReports.addStep("Month year title on Datepicker change to next month.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: Month year title on Datepicker not change to next month.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyPreviousMonthIcon(String monthYear) {
        String previousMonthYear = getMonthYearAdded(monthYear, -1);
        if (previousMonthYear.equals(getMonthYearTitle())) {
            NXGReports.addStep("Month year title on Datepicker change to previous month.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Fail: Month year title on Datepicker not change to previous month.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public String getMonthYearAdded(String currentMonth, int amount) {
        String nextMonth = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            sdf.setLenient(false);

            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(currentMonth));
            c.add(Calendar.MONTH, amount);
            nextMonth = sdf.format(c.getTime()).toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nextMonth;
    }

    public void inputToDueDate(String value) {
        try {
            String before = getText(dueDateOnTodoDetail);
            dueDateOnTodoDetail.sendKeys(value);
            String after = getText(dueDateOnTodoDetail);
            if (before.equals(after)) {
                NXGReports.addStep("Value not change -> Due Date On Todo Detail can't input.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Fail: Value changed -> Due Date On Todo Detail can input.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void resetEngagementDueDateToNextMonth(String todoName) {
        try {
            if (getDueDateMonth(getEngagementDueDate()) == getDueDateMonth(getToDoDueDateOnRow(todoName))) {
                clickElement(engagementDueDate);
                DatePicker dp = new DatePicker(getDriver());
                dp.clickNextButton();
                clickElement(dp.getValidDateHasIndex(1), "Second valid date");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 28/06/2017.*/
}
