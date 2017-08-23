package com.auvenir.ui.pages.auditor.general;

import java.util.List;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class AuditorDashboardPage extends AbstractPage {


    public AuditorDashboardPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }


    @FindBy(id = "h-clientListLink")
    private WebElement eleClientsLnk;

    public WebElement getEleClientsLnk() {
        return eleClientsLnk;
    }

    @FindBy(id = "engagementUserBtn")
    private WebElement inviteBtn;

    public WebElement getInviteBtn() {
        return inviteBtn;
    }

    @FindBy(id = "w-tm-tasksDropdownSelected")
    private WebElement eleTaskDrpDwn;

    public WebElement getEleTaskDrpDwn() {
        return eleTaskDrpDwn;
    }

    @FindBy(id = "w-mc-inviteBtn")
    private WebElement eleSelectClientBtn;

    public WebElement getEleSelectClientBtn() {
        return eleSelectClientBtn;
    }

    @FindBy(id = "taskSelectClientDivBtn")
    private WebElement eleSelectBtn;

    public WebElement getEleSelectBtn() {
        return eleSelectBtn;
    }

    @FindBy(id = "taskRequestsDivBtn")
    private WebElement eleSetBtn;

    public WebElement getEleSetBtn() {
        return eleSetBtn;
    }

    @FindBy(id = "engagement-archive-button")
    private WebElement eleArchiveBtn;

    public WebElement getEleArchiveBtn() {
        return eleArchiveBtn;
    }

    @FindBy(xpath = "//*[text()='My Clients']")
    private WebElement eleMyClientTxt;

    public WebElement getEleMyClientTxt() {
        return eleMyClientTxt;
    }

    @FindBy(className = "w-mc-profilePicture")
    private WebElement eleProfileImg;

    public WebElement getEleProfileImg() {
        return eleProfileImg;
    }

    @FindBy(xpath = "//p[text()='No Client Selected']")
    private WebElement eleNoClientTxt;

    public WebElement getEleNoClientTxt() {
        return eleNoClientTxt;
    }

    @FindBy(id = "w-as-title")
    private WebElement eleStatusTxt;

    public WebElement getEleStatusTxt() {
        return eleStatusTxt;
    }

    @FindBy(xpath = "//button[text()='Add New']")
    private WebElement eleAddNewBtn;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    @FindBy(id = "engagementDashboardLink")
    private WebElement eleDashboardLnk;

    public WebElement getEleDashboardLnk() {
        return eleDashboardLnk;
    }

    @FindBy(id = "engagementRequestsLink")
    private WebElement eleRequestLnk;

    public WebElement getEleRequestLnk() {
        return eleRequestLnk;
    }

    @FindBy(id = "engagementFileMangerLink")
    private WebElement filesLink;

    public WebElement getFilesLink() {
        return filesLink;
    }

    @FindBy(id = "engagementActivityLink")
    private WebElement activityLink;

    public WebElement getActivityLink() {
        return activityLink;
    }

    @FindBy(id = "engagement-backButton")
    private WebElement eleEngagementBackBtn;

    public WebElement getEleEngagementBackBtn() {
        return eleEngagementBackBtn;
    }

    @FindBy(id = "a-header-title")
    private WebElement eleEngagementTitleTxt;

    public WebElement getEleEngagementTitleTxt() {
        return eleEngagementTitleTxt;
    }


    @FindBy(xpath = "//span[text()='Please']")
    private WebElement elePleaseTxt;

    public WebElement getElePleaseTxt() {
        return elePleaseTxt;
    }

    @FindBy(xpath = "//span[text()='Please']//..//span[@id='w-as-txtBtn']")
    private WebElement eleSetTxt;

    public WebElement getEleSetTxt() {
        return eleSetTxt;
    }

    @FindBy(xpath = "//span[text()='your client request list.']")
    private WebElement eleClientRqstTxt;

    public WebElement getEleClientRqstTxt() {
        return eleClientRqstTxt;
    }

    @FindBy(xpath = "//img[contains(@id,'w-mc-profilePicture-')]")
    private WebElement eleMyClientImg;

    public WebElement getEleMyClientImg() {
        return eleMyClientImg;
    }

    @FindBy(xpath = "//div[@class='archive-engagement-headerText']")
    private WebElement eleArchiveEngagementTxt;

    public WebElement getEleArchiveEngagementTxt() {
        return eleArchiveEngagementTxt;
    }

    @FindBy(xpath = "//img[@class='archive-engagement-fileContainer-icon']")
    private WebElement eleArchiveEngagementImg;

    public WebElement getEleArchiveEngagementImg() {
        return eleArchiveEngagementImg;
    }

    @FindBy(xpath = "//div[@class='archive-engagement-bodyText']")
    private WebElement eleYouWillNoTxt;

    public WebElement getEleYouWillNoTxt() {
        return eleYouWillNoTxt;
    }

    @FindBy(xpath = "//button[@class='btn archive-engagement-cancel-btn']")
    private WebElement eleCancelBtn;

    public WebElement getEleCancelBtn() {
        return eleCancelBtn;
    }

    @FindBy(xpath = "//button[@class='btn archive-engagement-yes-btn']")
    private WebElement eleYesBtn;

    public WebElement getEleYesBtn() {
        return eleYesBtn;
    }

    @FindBy(xpath = "//img[@src='images/icons/x-small.svg']")
    private WebElement eleCloseSmallIcn;

    public WebElement getEleCloseSmallIcn() {
        return eleCloseSmallIcn;
    }

    @FindBy(xpath = "//img[@class='inner-space tsk-p']")
    private List<WebElement> eleTaskFormTxts;

    public List<WebElement> getEleTaskFormTxts() {
        return eleTaskFormTxts;
    }

    @FindBy(xpath = "//h4[text()='Activity Feed']")
    private WebElement activityFeedText;

    public WebElement getActivityFeedText() {
        return activityFeedText;
    }

    @FindBy(className = "w-activity-date-text")
    private WebElement activityDayText;

    public WebElement getActivityDayText() {
        return activityDayText;
    }

    @FindBy(className = "w-activity-text")
    private WebElement activityCreatedText;

    @FindBy(xpath = "//div[@id='engagementTodoLink']")
    private WebElement toDosLink;

    @FindBy(xpath = "//div[@id='engagementTeamLink']")
    private WebElement teamLink;

    @FindBy(xpath = "//input[@id='engOverview-dueDate']")
    private WebElement overviewDueDateInput;

    @FindBy(xpath = "//p[contains(text(),'Engagement Overview')]")
    private WebElement engagementOverviewText;

    @FindBy(xpath = "//div[@id='engOverview-status']")
    private WebElement engagementOverviewStatus;

    @FindBy(xpath = "//p[@id='engOverview-todo']")
    private WebElement auditorCompleteToDo;

    @FindBy(xpath = "//p[@id='engOverview-clientTodo']")
    private  WebElement clientCompleteDocument;

    @FindBy(xpath = "//div[@class='auvicon-line-download']")
    private WebElement activityDownloadIcon;

    @FindBy(xpath = "//div[@id='team-bulk-dropdown-inner']")
    private WebElement teamBulkDropdown;

    @FindBy(xpath="//button[@id='team-addMember-btn']")
    private WebElement teamAddMember;

    @FindBy(xpath = "//button[@id='team-inviteMember-btn']")
    private WebElement teamInviteMember;

    public WebElement getActivityCreatedText() {
        return activityCreatedText;
    }

    /**
     * Refactored by Minh Nguyen on June 27, 2017
     */
    public void verifyDisplayElementOnAuditorDashBoardPage(){
        boolean isInviteBtn, isToDosLink, isFilesLink, isActivityLink, isTeamLink, isOverviewDueDateInput, isEngagementOverviewText, isEngagementOverviewStatus, isAuditorCompleteToDo, isClientCompleteDocument = false;
        isInviteBtn = validateDisPlayedElement(inviteBtn, "Invite Button");
        isToDosLink = validateDisPlayedElement(toDosLink, "To-Dos Link");
        isFilesLink = validateDisPlayedElement(filesLink, "Files Link");
        isActivityLink = validateDisPlayedElement(activityLink, "Activity Link");
        isTeamLink = validateDisPlayedElement(teamLink, "Team Link");
        isOverviewDueDateInput = validateDisPlayedElement(overviewDueDateInput, "Overview due date");
        isEngagementOverviewText = validateDisPlayedElement(engagementOverviewText, "Engagement overview text");
        isEngagementOverviewStatus = validateDisPlayedElement(engagementOverviewStatus, "Engagement overview status");
        isAuditorCompleteToDo = validateDisPlayedElement(auditorCompleteToDo, "auditor complete todo");
        isClientCompleteDocument = validateDisPlayedElement(clientCompleteDocument, "client complete todo");
        if(isInviteBtn && isToDosLink && isFilesLink && isActivityLink && isTeamLink && isOverviewDueDateInput && isEngagementOverviewText && isEngagementOverviewStatus && isAuditorCompleteToDo && isClientCompleteDocument)
        {
            NXGReports.addStep("Verify Auditor Engagement page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Engagement page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void clickRequestLink(){
        waitForClickableOfElement(eleRequestLnk, "Requests Link");
        clickElement(eleRequestLnk, "Requests Link");
    }
    public void clickFilesLink(){
        waitForClickableOfElement(filesLink, "File Link");
        clickElement(filesLink, "File link");
    }
    public void clickActivityLink(){
        waitForClickableOfElement(activityLink, "Activity link");
        clickElement(activityLink, "Activity link");
    }
    public void clickTeamLink(){
        waitForClickableOfElement(teamLink, "Team link");
        clickElement(teamLink, "Team link");
    }
    public void verifyDisplayElementInActivityPage(){
        boolean isActivityFeedText, isActivityDownloadIcon, isActivityDayText, isActivityCreatedText = false;
        isActivityFeedText = validateDisPlayedElement(activityFeedText, "Activity Feed Text");
        isActivityDownloadIcon = validateDisPlayedElement(activityDownloadIcon, "Activity Download Icon");
        isActivityDayText = validateDisPlayedElement(activityDayText, "Activity Day Text");
        isActivityCreatedText = validateDisPlayedElement(activityCreatedText, "You created a new Engagement- Text");
        if(isActivityFeedText && isActivityDownloadIcon && isActivityDayText && isActivityCreatedText)
        {
            NXGReports.addStep("Verify Auditor Engagement Activity page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Engagement Activity page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void verifyDisplayElementInTeamPage(){
        boolean isTeamBulkDropdown, isTeamAddMember, isTeamInviteMember = false;
        isTeamBulkDropdown = validateDisPlayedElement(teamBulkDropdown, "Team Bulk dropdown");
        isTeamAddMember = validateDisPlayedElement(teamAddMember, "Team Add Member");
        isTeamInviteMember = validateDisPlayedElement(teamInviteMember, "Team Invite Member");
        if(isTeamBulkDropdown && isTeamAddMember && isTeamInviteMember)
        {
            NXGReports.addStep("Verify Auditor Engagement Team page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Engagement Team page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    public void clickArchiveButton(){
        waitForClickableOfElement(eleArchiveBtn, "Archive button");
        clickElement(eleArchiveBtn, "Archive button");
    }
    public void verifyDisplayElementInArchivePage(){
        clickArchiveButton();
        validateDisPlayedElement(eleArchiveEngagementTxt, "Archive Engagement Header Text");
        validateDisPlayedElement(eleArchiveEngagementImg, "Archive Engagement Image");
        validateDisPlayedElement(eleYouWillNoTxt, "You will not longer be able to access - Text");
        validateDisPlayedElement(eleCancelBtn, "Cancel Button");
        validateDisPlayedElement(eleYesBtn, "Yes - Button");
        validateDisPlayedElement(eleCloseSmallIcn, "Close icon");
        clickElement(eleCancelBtn, "Cancel button");
    }
}
