package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.DetailsEngagementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorDetailsEngagementPage extends DetailsEngagementPage {


    public AuditorDetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagementTodoLink")
    private WebElement eleToDoListLnk;

    @FindBy(id = "engagementDashboardLink")
    private WebElement dashBoardLinkEle;
    //@FindBy(xpath = "//p[contains(text(),'Engagement Overview')]")
    @FindBy(id = "a-header-title")
    private WebElement dashboardTextEle;

    @FindBy(id = "a-header-title")
    private WebElement dashboardTextAtGeneralPage;

    @FindBy(xpath = "//div[contains(text(),'To-Dos')]")
    private WebElement toDoLinkTextEle;

    @FindBy(id = "engagementTeamLink")
    private WebElement TeamMemberLinkEle;

    @FindBy(id = "h-clientListLink")
    private WebElement eleContactLink;

    @FindBy(id = "engagementOverview")
    private WebElement engagementOverviewEle;

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - Start
     */

    @FindBy(xpath = "//nav[@id='dashboardLinks']/div[@id='engagementFileMangerLink']")
    private WebElement eleFileManagerLink;

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - End
     */
    public void verifyDetailsEngagementPage(String engagementName) {
        verifyDetailsEngagementPage(engagementName, true);
    }

    public void verifyDetailsEngagementAtGeneralPage(String engagementName) {
        waitForVisibleElement(dashboardTextAtGeneralPage, "dashboard text");
        validateElementText(dashboardTextAtGeneralPage, engagementName);
    }

    public void navigateToTaskList() throws Exception {
        clickElement(eleToDoListLnk, "Todo List");
    }

    public void navigateToTodoListPage() throws Exception {
        waitForVisibleElement(eleToDoListLnk, "Todo link text");
        //waitForClickableOfElement(eleToDoListLnk,"Todo Link");
        clickElement(eleToDoListLnk, "Todo Link");
    }

    public void navigateToEngagementDetailPage() {
        waitForVisibleElement(eleToDoListLnk, "Todo link text");
    }

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - Start
     */

    /**
     * Click on file manager link
     */
    public void clickOnFileManagerLink() {
        waitForClickableOfElement(eleFileManagerLink, "file manager link");
        clickElement(eleFileManagerLink,"file manager link");
    }

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - End
     */
    public void clickOnContactLink() {
        waitForClickableOfElement(eleContactLink, "contact link");
        clickElement(eleContactLink, "contact link");
    }

}

