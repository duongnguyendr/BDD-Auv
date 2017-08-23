package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.DatePicker;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorNewEngagementPage extends AbstractPage {

    //@FindBy(id = "team-component-header")
    @FindBy(id = "team-component-header")
    private WebElement teamMemberWizardHeader;

    @FindBy(id = "customize-component-header")
    private WebElement createNewTodoListTextEle;

    public AuditorNewEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagement-name")
    private WebElement eleEngagementNameInput;

    @FindBy(id = "engagement-type-container")
    private WebElement eleEngagementTypeSelect;

    @FindBy(xpath = "//div[@id='engagement-type-container']//..//..//..//a[@class='ddlText auv-inputDdl-text']")
    private List<WebElement> listEngagementType;

    @FindBy(id = "engagement-company")
    private WebElement eleCompanyNameInput;

    @FindBy(id = "engagement-deadline")
    private WebElement eleReportDeadlineInput;

    @FindBy(id = "engagement-date-range-start")
    private WebElement eleStartDateInput;

    @FindBy(id = "engagement-date-range-end")
    private WebElement eleEndDateInput;

    @FindBy(id = "m-ce-addBtn")
    private WebElement eleContinueBtn;

    @FindBy(id = "m-ce-cancelBtn")
    private WebElement eleCancelBtn;

    @FindBy(id = "team-continue-btn")
    private WebElement eleContinueNoMemberBtn;

    @FindBy(id = "team-add-btn")
    private WebElement eleAddMemberBtn;

    @FindBy(id = "customize-create-btn")
    private WebElement eleCustomizeCreateBtn;

    //@FindBy(xpath = "//h2[contains(text(),'New Engagement')]")
    @FindBy(id = "m-ce-modalTitle")
    private WebElement newEngagementHeaderTextTitle;

    @FindBy(xpath = "//*[@id='h-engagementsLink']")
    private WebElement linkEngagement;

    @FindBy(xpath = "//*[@id='CreateEngagementParent']/../../../..")
    private WebElement createEngagementPopupEle;

    /**
     * Added by huy.huynh on 06/06/2017.
     * Verify UI new engagement flow
     */
    @FindBy(className = "ce-headerTitle")
    private WebElement titleHeader;

    @FindBy(id = "link-ce-setuptitle")
    private WebElement tabProgressSetUpName;

    @FindBy(id = "link-ce-setupcircle")
    private WebElement tabProgressSetUpCircle;

    @FindBy(id = "link-ce-setupnum")
    private WebElement tabProgressSetUpNumber;

    @FindBy(id = "link-ce-teamtitle")
    private WebElement tabProgressTeamName;

    @FindBy(id = "link-ce-teamcircle")
    private WebElement tabProgressTeamCircle;

    @FindBy(id = "link-ce-teamnum")
    private WebElement tabProgressTeamNumber;

    @FindBy(id = "link-ce-customizetitle")
    private WebElement tabProgressCustomizeName;

    @FindBy(id = "link-ce-customizecircle")
    private WebElement tabProgressCustomizeCircle;

    @FindBy(id = "link-ce-customizenum")
    private WebElement tabProgressCustomizeNumber;

    @FindBy(xpath = "//h3[@class='m-ce-setup-header']")
    private WebElement titleSetUpHeader;

    @FindBy(xpath = "//p[@for='engagement-name']")
    private WebElement titleEngagementName;
    //eleEngagementNameInput
    @FindBy(xpath = "//p[@for='engagement-type']")
    private WebElement titleEngagementType;

    @FindBy(xpath = "//input[@id='engagement-type']")
    private WebElement inputEngagementType;

    @FindBy(xpath = "//div[@id='engagement-type-container']//a[@class='ddlText auv-inputDdl-text']")
    private List<WebElement> listEngagementTypeContain;

    @FindBy(xpath = "//ul[@class='ddlLink inputDdl inputDdl-after']//a[contains(text(),'Financial Audit')]")
    private WebElement optionFirstEngagementType;

    @FindBy(xpath = "//p[@for='engagement-company']")
    private WebElement titleEngagementCompany;

    @FindBy(xpath = "//input[@id='engagement-company']")
    private WebElement inputEngagementCompany;

    @FindBy(xpath = "//p[@for='engagement-deadline']")
    private WebElement titleEngagementReportDeadline;

    @FindBy(xpath = "//input[@id='engagement-deadline']")
    private WebElement inputEngagementReportDeadline;

    @FindBy(xpath = "//p[@for='engagement-date-range-start']")
    private WebElement titleEngagementDateRange;

    @FindBy(xpath = "//input[@id='engagement-date-range-start']")
    private WebElement inputEngagementDateRangeStart;

    @FindBy(xpath = "//input[@id='engagement-date-range-end']")
    private WebElement inputEngagementDateRangeEnd;

    @FindBy(xpath = "//button[@id='m-ce-addBtn']/following-sibling::button")
    private WebElement buttonEngagementCancel;

    @FindBy(id = "m-ce-addBtn")
    private WebElement buttonEngagementContinue;

    @FindBy(id = "team-component-header")
    private WebElement titleTeamHeader;

    @FindBy(xpath = "//button[@id='team-continue-btn']/preceding-sibling::img")
    private WebElement imageNotAddMember;

    @FindBy(xpath = "//button[@id='team-continue-btn']/preceding-sibling::p")
    private WebElement titleNotAddMember;

    @FindBy(id = "team-continue-btn")
    private WebElement buttonNotAddMember;

    @FindBy(xpath = "//button[@id='team-add-btn']/preceding-sibling::img")
    private WebElement imageAddMember;

    @FindBy(xpath = "//button[@id='team-add-btn']/preceding-sibling::p")
    private WebElement titleAddMember;

    @FindBy(id = "team-add-btn")
    private WebElement buttonAddMember;

    @FindBy(xpath = "//button[@id='customize-rollover-btn']/preceding-sibling::img")
    private WebElement imageRollover;

    @FindBy(xpath = "//button[@id='customize-rollover-btn']/preceding-sibling::p")
    private WebElement titleRollover;

    @FindBy(id = "customize-rollover-btn")
    private WebElement buttonRollover;

    @FindBy(xpath = "//button[@id='customize-create-btn']/preceding-sibling::img")
    private WebElement imageCreateToDoList;

    @FindBy(xpath = "//button[@id='customize-create-btn']/preceding-sibling::p")
    private WebElement titleCreateToDoList;

    @FindBy(id = "customize-create-btn")
    private WebElement buttonCreateToDoList;

    @FindBy(id = "ui-datepicker-div")
    private WebElement widgetDatePicker;

    DatePicker datePicker;

    //    @FindBy(xpath = "//p[contains(text(),'need to add any team members to this engagement')]")
    //    private WebElement teamContainerDivEle;

    public void verifyNewEngagementPage() {
        getLogger().info("Verify New engagement Page.");
        waitForVisibleElement(newEngagementHeaderTextTitle, "New Engagement Header");
        validateElementText(newEngagementHeaderTextTitle, "New Engagement");
    }

    /*
    public void enterDataForNewEngagementPage(String engagement01, String s, String s1) throws Exception {
    	
        getLogger().info("Enter engagement name.");
        enterEngagementName(engagement01);
        NXGReports.addStep("Enter engagement name.", LogAs.PASSED, null);
        
        getLogger().info("Select engagement type.");
        selectEngagementType(s);
        NXGReports.addStep("Select engagement type.", LogAs.PASSED, null);
                
        getLogger().info("Enter company name.");
        enterCompanyName(s1);
        NXGReports.addStep("Enter company name.", LogAs.PASSED, null);
        
        getLogger().info("Enter deadline date.");
        enterDeadLineDate(this.tmp(10));
        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);
    	
        getLogger().info("Enter start date.");
        enterStartDate(this.tmp(0));
        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);
        
        getLogger().info("Enter end date.");
        enterEndDate(this.tmp(10));
        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);
    	
        getLogger().info("Click Continue button.");
        this.clickContinueBtn();
        NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);
        
        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        this.clickNoMemberBtn();
        NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
        
        getLogger().info("Click create to do button.");
        this.clickCreateToDoBtn();
        NXGReports.addStep("Click create to do button.", LogAs.PASSED, null);
    }
    */
    public void enterDataForNewEngagementPage(String name, String engagementType, String company) {
        getLogger().info("Enter data for new Engagement form");
        enterEngagementName(name);
        selectEngagementType(engagementType);
        enterCompanyName(company);

        enterDeadLineDate(getDate(10));
        waitSomeSeconds(3);
        scrollToFooter();
        hoverAndWaitForClickableOfElement(eleEngagementNameInput, "engagement Name");
        clickElement(eleEngagementNameInput, "engagement Name");

        enterEndDate(getDate(10));
        hoverAndWaitForClickableOfElement(eleEngagementNameInput, "engagement Name");
        clickElement(eleEngagementNameInput, "engagement Name");

        enterStartDate(getDate(1));
        hoverAndWaitForClickableOfElement(eleEngagementNameInput, "engagement Name");
        clickElement(eleEngagementNameInput, "engagement Name");

        clickContinueBtn();
        verifyTeamMemberWizardPage();

        clickNoMemberBtn();
        waitForVisibleElement(createNewTodoListTextEle, "Create your To-Do list");

        clickCreateToDoBtn();
        waitForCssValueChanged(createEngagementPopupEle, "Create Engagement Popup", "display", "none");
    }

    public void clickEngagementMenuLink() throws Exception {

        //        getLogger().info("Enter engagement name.");
        //        enterEngagementName(name);
        //        NXGReports.addStep("Enter engagement name.", LogAs.PASSED, null);
        //
        //        getLogger().info("Select engagement type.");
        //        selectEngagementType(engagementType);
        //        NXGReports.addStep("Select engagement type.", LogAs.PASSED, null);
        //
        //        getLogger().info("Enter company name.");
        //        enterCompanyName(company);
        //        NXGReports.addStep("Enter company name.", LogAs.PASSED, null);
        //
        //        getLogger().info("Enter deadline date.");
        //        clickAndHold(eleReportDeadlineInput, "Deadline date Input");
        //        enterDeadLineDate(getDate(10));
        //        clickElement(eleEngagementNameInput, "engagement Name");
        //        NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);
        //
        //        getLogger().info("Enter end date.");
        //        enterEndDate(getDate(10));
        //        clickElement(eleEngagementNameInput, "engagement Name");
        //        NXGReports.addStep("Enter end date.", LogAs.PASSED, null);
        //
        //        getLogger().info("Enter start date.");
        //        clickAndHold(eleStartDateInput, "Start Date Input");
        //        enterStartDate(getDate(1));
        //        clickElement(eleEngagementNameInput, "engagement Name");
        //        NXGReports.addStep("Enter star date.", LogAs.PASSED, null);
        //
        //        getLogger().info("Click Continue button.");
        //        clickContinueBtn();
        //        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        //        clickNoMemberBtn();
        //        clickCreateToDoBtn();
        Thread.sleep(smallTimeOut);
        clickElement(linkEngagement, "click to linkEngagement");
    }

    /**
     * Refactored by Minh Nguyen on June 29, 2017
     *
     * @param name
     * @param engagementType
     * @param company
     * @param deadlineDate
     * @param endDate
     * @param startDate
     */
    public void enterDataForNewEngagementPage(String name, String engagementType, String company, String deadlineDate, String endDate,
            String startDate) {

        try {
            getLogger().info("Enter engagement name.");
            enterEngagementName(name);
            NXGReports.addStep("Enter engagement name.", LogAs.PASSED, null);

            getLogger().info("Select engagement type.");
            selectEngagementType(engagementType);
            NXGReports.addStep("Select engagement type.", LogAs.PASSED, null);

            getLogger().info("Enter company name.");
            enterCompanyName(company);
            NXGReports.addStep("Enter company name.", LogAs.PASSED, null);


            getLogger().info("Enter deadline date.");
            clickAndHold(eleReportDeadlineInput, "Deadline date Input");
            if (deadlineDate.equals("")) {
                enterDeadLineDate(getDate(10));
            }
            enterDeadLineDate(deadlineDate);
            clickElement(eleEngagementNameInput, "engagement Name");
            NXGReports.addStep("Enter deadline date.", LogAs.PASSED, null);

            getLogger().info("Enter start date.");
            clickAndHold(eleStartDateInput, "Start Date Input");
            if (startDate.equals("")) {
                enterStartDate(getDate(1));
            }
            enterStartDate(startDate);
            clickElement(eleEngagementNameInput, "engagement Name");
            NXGReports.addStep("Enter star date.", LogAs.PASSED, null);

            getLogger().info("Enter end date.");
            if (endDate.equals("")) {
                enterEndDate(getDate(10));
            }
            enterEndDate(endDate);
            clickElement(eleEngagementNameInput, "engagement Name");
            NXGReports.addStep("Enter end date.", LogAs.PASSED, null);


            getLogger().info("Click Continue button.");
            clickContinueBtn();
            NXGReports.addStep("Click Continue button.", LogAs.PASSED, null);
            verifyTeamMemberWizardPage();

            getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
            clickNoMemberBtn();
            NXGReports.addStep("Click continue button.(I don't need to add any team members to this engagement).", LogAs.PASSED, null);
            waitForVisibleElement(createNewTodoListTextEle, "Create your To-Do list");
            //old version
            //        clickContinueBtn();

            clickCreateToDoBtn();
            boolean isCheckCreateEngagement = false;
            isCheckCreateEngagement = waitForCssValueChanged(createEngagementPopupEle, "Create Engagement Popup", "display", "none");
            if (isCheckCreateEngagement) {
                NXGReports.addStep("Enter Data For New Engagement Page ", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Error:  Enter Data For New Engagement Page ", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Error:  Enter Data For New Engagement Page ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    private void verifyTeamMemberWizardPage() {
        getLogger().info("Verify team member wizard page.");
        waitForVisibleElement(teamMemberWizardHeader, "team member header");
        validateElementText(teamMemberWizardHeader, "Create your team");
    }


    public void enterEngagementName(String engagementName) {
        getLogger().info("Enter engagement name.");
        waitForClickableOfElement(eleEngagementNameInput, "EngagementName");
        sendKeyTextBox(eleEngagementNameInput, engagementName, "engagementName");
    }

    public void selectEngagementType(String engagementType) {
        getLogger().info("Select engagement type.");
        String engagementTypeText = "";
        clickElement(eleEngagementTypeSelect, "Select Engagement Type");
        if (engagementType.equals(""))
            listEngagementType.get(0).click();
        else {
            for (int i = 0; i < listEngagementType.size(); i++) {
                engagementTypeText = listEngagementType.get(i).getText();
                if (engagementTypeText.equals(engagementType)) {
                    listEngagementType.get(i).click();
                    break;
                }
            }
        }
    }


    public void enterCompanyName(String companyName) {
        getLogger().info("Enter company name.");
        sendKeyTextBox(eleCompanyNameInput, companyName, "Company field");
    }

    public void enterDeadLineDate(String dateLineDate) {
        getLogger().info("Enter deadline date.");
        sendKeyTextBox(eleReportDeadlineInput, dateLineDate, "DateLine");
        sendTabkey(eleReportDeadlineInput, "DateLine");
    }

    public void enterStartDate(String startDate) {
        getLogger().info("Enter start date.");
        sendKeyTextBox(eleStartDateInput, startDate, "StartDate");
    }

    public void enterEndDate(String endDate) {
        getLogger().info("Enter end date.");
        sendKeyTextBox(eleEndDateInput, endDate, "EndDate");
    }

    public void clickContinueBtn() {
        getLogger().info("Click Continue button.");
        clickElement(eleContinueBtn, "Continue Button");
    }

    public void clickNoMemberBtn() {
        getLogger().info("Click continue button.(I don't need to add any team members to this engagement).");
        waitForProgressOverlayIsClosed();
        clickElement(eleContinueNoMemberBtn, "Continue No member button");
    }


    public void clickCreateToDoBtn() {
        getLogger().info("Click Customize Create Button.");
        clickElement(eleCustomizeCreateBtn, "Customize Create Button");
    }


    /**
     * verify UI of New Engagement page - Header SetUp
     */
    public void verifyUINewEngagementHeaderSetUp() {
        try {
            waitUtilTextPresent(titleHeader, 5, "New Engagement");
            validateElementText(titleHeader, "New Engagement");
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressSetUpNumber, "1");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressTeamNumber, "2");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateElementText(titleSetUpHeader, "Set Up Your Engagement");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement - Header SetUp ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body SetUp
     */
    public void verifyUINewEngagementBodySetUp(String name) {
        try {
            validateElementText(titleEngagementName, "Name Your Engagement");
            sendKeyTextBox(eleEngagementNameInput, name, "Engagement Name Input");
            validateElementText(titleEngagementType, "Select Engagement Type");
            clickElement(inputEngagementType, "Engagement Type");
            validateElementsQuantity(listEngagementTypeContain, 4, "List Engagement Type");
            clickElement(optionFirstEngagementType);
            validateElementText(titleEngagementCompany, "Company Name");
            sendKeyTextBox(inputEngagementCompany, "company", "Engagement Name Input");
            validateElementText(titleEngagementReportDeadline, "Set Reporting Deadline");
            validatePlaceholder(inputEngagementReportDeadline, "DD/MM/YYYY", "Engagement Report Deadline");
            clickElement(inputEngagementReportDeadline);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("26");
            validateElementJavaScriptTextContain(inputEngagementReportDeadline, "26", "Engagement Report Deadline");
            validateElementText(titleEngagementDateRange, "Select a Date Range of Bank Statements to be requested from your client.");
            validatePlaceholder(inputEngagementDateRangeStart, "DD/MM/YYYY", "Engagement DateRange Start");
            waitForInvisibleElement(widgetDatePicker, "Date Picker");
            clickElement(inputEngagementDateRangeStart);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("27");
            validateElementJavaScriptTextContain(inputEngagementDateRangeStart, "27", "Engagement Report Deadline");
            validatePlaceholder(inputEngagementDateRangeEnd, "DD/MM/YYYY", "Engagement DateRange End");
            clickElement(inputEngagementDateRangeEnd);
            validateAttributeNotContain(widgetDatePicker, "style", "display: none", "Date Picker");
            datePicker = new DatePicker(getDriver(), widgetDatePicker);
            datePicker.pickADate("28");
            validateElementJavaScriptTextContain(inputEngagementDateRangeEnd, "28", "Engagement Report Deadline");

        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body SetUp ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Footer Setup
     */
    public void verifyUINewEngagementFooterSetup() {
        try {
            validateElementText(buttonEngagementCancel, "Cancel");
            validateElementText(buttonEngagementContinue, "Continue");

            clickElement(buttonEngagementContinue, "Button Engagement Continue");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Footer Setup ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Header Team
     */
    public void verifyUINewEngagementHeaderTeam(String name) {
        try {
            validateElementText(titleHeader, name);
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressTeamNumber, "2");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressSetUpNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressTeamCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Header Team", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body Team
     */
    public void verifyUINewEngagementBodyTeam() {
        try {
            validateAttributeContain(imageNotAddMember, "src", "images/create-engagement/single-man.png", "Image Not Add Member");
            validateElementText(titleNotAddMember, "I don't need to add any team members to this engagement");
            validateElementText(buttonNotAddMember, "Continue");
            validateAttributeContain(imageAddMember, "src", "images/create-engagement/three-men.png", "Image Add Member");
            validateElementText(titleAddMember, "I'd like to add team members to this engagement");
            validateElementText(buttonAddMember, "Add Members");

            clickElement(buttonNotAddMember, "Button Engagement Continue");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body Team ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Header Customize
     */
    public void verifyUINewEngagementHeaderCustomize(String name) {
        try {
            validateElementText(titleHeader, name);
            validateElementText(tabProgressSetUpName, "SET-UP");
            validateElementText(tabProgressTeamName, "TEAM");
            validateElementText(tabProgressCustomizeName, "CUSTOMIZE");
            validateElementText(tabProgressCustomizeNumber, "3");
            validateAttributeElement(tabProgressSetUpCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressSetUpNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressTeamCircle, "class", "ce-numberCircle ce-numberCircle-active");
            validateAttributeElement(tabProgressTeamNumber, "class", "ce-number auvicon-checkmark ce-nav-checkmark");
            validateAttributeElement(tabProgressCustomizeCircle, "class", "ce-numberCircle ce-numberCircle-active");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Header Customize ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }

    /**
     * verify UI of New Engagement page - Body Customize
     */
    public void verifyUINewEngagementBodyCustomize() {
        try {
            validateAttributeContain(imageRollover, "src", "images/create-engagement/file-box-grey.png", "Image Rollover");
            validateElementText(titleRollover, "Rollover a Saved Template");
            validateElementText(buttonRollover, "Rollover");
            validateAttributeContain(imageCreateToDoList, "src", "images/create-engagement/clipboard.png", "Image Create ToDo List");
            validateElementText(titleCreateToDoList, "Create your To-Do list");
            validateElementText(buttonCreateToDoList, "Create");

            clickElement(buttonCreateToDoList, "Button Create ToDo List");
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error:  New Engagement Body Customize ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
    }
    /*-----------end of huy.huynh on 06/06/2017.*/

    public void insertDataForNewEngagementPage(String name, String engagementType, String company) {
        try {
            getLogger().info("Insert data for new Engagement form");
            enterEngagementName(name);
            selectEngagementType(engagementType);
            enterCompanyName(company);

            String currentLastDate = getLastDateFollowCurrentMonth();
            String currentFirstDate = getFirstDateFollowCurrentMonth();

            enterDeadLineDate(currentLastDate);
            enterStartDate(currentFirstDate);
            enterEndDate(currentLastDate);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Insert data for new Engagement form", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    ex.getMessage());
        }
    }

    private String getLastDateFollowCurrentMonth() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String sCurrentLastDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        int currentMonth = (calendar.get((Calendar.MONTH)) + 1);
        String sCurrentMonth = currentMonth < 10 ? "0" + String.valueOf(currentMonth) : String.valueOf(currentMonth);
        String sCurrentYear = String.valueOf(calendar.get(Calendar.YEAR));

        return sCurrentMonth + "/" + sCurrentLastDay + "/" + sCurrentYear;
    }

    private String getFirstDateFollowCurrentMonth() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        String sCurrentFirstDay = "0" + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        int currentMonth = (calendar.get((Calendar.MONTH)) + 1);
        String sCurrentMonth = currentMonth < 10 ? "0" + String.valueOf(currentMonth) : String.valueOf(currentMonth);
        String sCurrentYear = String.valueOf(calendar.get(Calendar.YEAR));

        return sCurrentMonth + "/" + sCurrentFirstDay + "/" + sCurrentYear;
    }

}
