package com.auvenir.utilities;

import com.auvenir.ui.services.AbstractService;
/*import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;*/
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by huy.huynh on 15/05/2017.
 * add more 18/05/2017
 */
public class DatePicker {
    private WebElement datePicker;

    @FindBy(className = "ui-icon-circle-triangle-w")
    private WebElement btnPrev;

    @FindBy(className = "ui-icon-circle-triangle-e")
    private WebElement btnNext;

    @FindBy(id = "ui-datepicker-div")
    private WebElement defaultDatePickerElement;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//td[@data-handler]/a")
    private List<WebElement> listValidDates;

    @FindBy(xpath = "//*[contains(@class,'ui-state-default')]")
    private List<WebElement> listDates;

    @FindBy(className = "ui-datepicker-title")
    private WebElement titleMonthYear;

    private String validDate = "//a[contains(text(),'%s')][@href='#']";
    private String parentDate = "//*[text()='%s']/ancestor::td";

    public DatePicker(WebDriver driver, WebElement ele) {
        PageFactory.initElements(driver, this);
        datePicker = ele;
    }

    public DatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.datePicker = defaultDatePickerElement;
    }

    /**
     * go to previous month
     */
    public void clickPreviousButton() {
        clickElement(btnPrev, "Button previous Datepicker");
    }

    /**
     * go to next month
     */
    public void clickNextButton() {
        clickElement(btnNext, "Button next Datepicker");
    }

    /**
     * choose given date of current month
     *
     * @param date name of To-Do to choose
     */
    public void pickADate(String date) throws Exception {
        clickElement(getElementByXpath(validDate, date), "Datepicker date: " + date);
    }

    /**
     * choose given date as paramaters
     *
     * @param date  date of month
     * @param month month of year
     * @param year  year AD
     */
    public void pickADate(String month, String date, String year) throws Exception {
        int monthDif = monthDif(year, month);
        if (monthDif > 0) {
            for (int i = 0; i < Math.abs(monthDif); i++) {
                clickNextButton();
                Thread.sleep(500);
            }
        }
        if (monthDif < 0) {
            for (int i = 0; i < Math.abs(monthDif); i++) {
                clickPreviousButton();
                Thread.sleep(500);
            }
        }
        pickADate(date);
    }

    /**
     * get a valid date
     *
     * @param date month of year
     */
    public WebElement getADate(String date) {
        return getElementByXpath(validDate, date);
    }

    /**
     * get parent element of a date on date picker
     *
     * @param date month of year
     */
    public WebElement getADateParent(String date) {
        return getElementByXpath(parentDate, date);
    }

    /**
     * list WebElement of valid dates
     */
    public List<WebElement> getListValidDates() {
        return listValidDates;
    }

    /**
     * get Quantity Date Of this Month
     */
    public int getQuantityDateOfMonth() {
        return listDates.size();
    }

    /**
     * get valid date number 'idx'(idx count from 0)
     *
     * @param idx valid date index
     */
    public WebElement getValidDateHasIndex(int idx) throws Exception {
        return listValidDates.get(idx);
    }

    /**
     * get string Month Year on date picker: ex July 2017
     */
    public String getMonthYearTitle() {
        return titleMonthYear.getText();
    }

    //    public boolean isMouseHovering(WebElement webElement){
    //
    //    }

    /**
     * count months from now
     *
     * @param month month of year
     * @param year  year AD
     */
    private int monthDif(String year, String month) throws Exception {
        Date date = new SimpleDateFormat("MMMM yyyy").parse(titleMonthYear.getText());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int yearDif = Integer.parseInt(year) - cal.get(Calendar.YEAR);
        int monthOfYearDif = Integer.parseInt(month) - (cal.get(Calendar.MONTH) + 1);
        return yearDif * 12 + monthOfYearDif;
    }

    /**
     * choose given name To-Do and cho an action for it
     *
     * @param date  date of month
     * @param month month of year
     * @param year  year AD
     */
    private boolean timeValidation(String date, String month, String year) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(date + "-" + month + "-" + year);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * get element which cant use @FindBy to find
     *
     * @param xpath xpath to get element
     * @param arg   vararg for formating
     */
    public WebElement getElementByXpath(String xpath, String... arg) {
        WebElement webElement = null;
        xpath = String.format(xpath, arg);
        try {
            webElement = datePicker.findElement(By.xpath(xpath));
        } catch (Exception ex) {
//            NXGReports.addStep("Can't find element for xpath: " + xpath, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
//                    ex.getMessage());
        }
        return webElement;
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click
     * @Description: Click on element
     */
    public boolean clickElement(WebElement element, String elementName) {
        try {
            element.click();
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            System.out.println("Unable to click on: " + elementName);
//            NXGReports.addStep("Unable to Click on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
//                    e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
