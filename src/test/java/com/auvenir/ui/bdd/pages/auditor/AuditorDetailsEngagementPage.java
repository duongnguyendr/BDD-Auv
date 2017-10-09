package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.DetailsEngagementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

    @FindBy(xpath = "//*[@id='CreateEngagementParent']/../../../..")
    private WebElement createEngagementPopupEle;

    @FindBy(xpath = "//div[@class='ui dropdown client todo-bulkDdl ']/div[@class='text']")
    private List<WebElement> eleToDoAssignList;

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - Start
     */

    @FindBy(xpath = "//nav[@id='dashboardLinks']/div[@id='engagementFileMangerLink']")
    private WebElement eleFileManagerLink;
    @FindBy(id = "engagementUserBtn")
    private WebElement buttonInviteClient;

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
        clickElement(eleFileManagerLink, "file manager link");
    }

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - End
     */
    public void clickOnContactLink() {
        waitForClickableOfElement(eleContactLink, "contact link");
        clickElement(eleContactLink, "contact link");
    }

    public void verifyNewEngagementPopupClose() {
        boolean result = waitForCssValueChanged(createEngagementPopupEle, "Create Engagement Popup", "display", "none");
        Assert.assertTrue(result);
    }

    public void clickOnInviteClientBtn() {
        waitForClickableOfElement(buttonInviteClient, "buttonInviteClient");
        clickElement(buttonInviteClient, "buttonInviteClient");
        waitForProgressOverlayIsClosed();
        waitSomeSeconds(2);
    }

    /**
     * Click Invite button
     */
    public void clickInviteClientButton() throws Exception {
        validateElementText(buttonInviteClient, "Invite Client");
        clickElement(buttonInviteClient, "Button Invite Client");
    }

    @FindBy(className = "m-ic-subTitle")
    private WebElement titleInviteClient;

    @FindBy(xpath = "//input[@id='m-ci-step-one-input']")
    private WebElement selectOptionInviteClient;

    public void verifyInviteYourClientPage() {
        waitSomeSeconds(2);
        boolean result = validateElementText(titleInviteClient, "Invite Your Client");
        Assert.assertTrue(result);
    }

    public void selectClientWithFullName(String fullName) {
        verifyInviteYourClientPage();
        clickElement(selectOptionInviteClient, "Select Client");
//        String xpathOptionAdminClientName = "//ul[@class='ddlLink inputDdl inputDdl-after']//a[contains(text()='%s')]";
        String xpathOptionAdminClientName = ".//a[@class='ddlText auv-inputDdl-text' and contains(text(), '%s')]";
        clickElement(getElementByXpath(xpathOptionAdminClientName, fullName), "Option Admin Client Name");
        waitSomeSeconds(1);
    }

    @FindBy(id = "m-ic-continueBtn")
    WebElement buttonInvite;

    public void clickInviteButton() {
        clickElement(buttonInvite, "Button Invite");
        waitForProgressOverlayIsClosed();
    }

    public void verifyInviteClientSuccess() {
        waitForProgressOverlayIsClosed();
        //waitSomeSeconds(1);
        verifyContentOfSuccessToastMessage("Your engagement invitation has been sent.");
    }


    //////////////////////////////Lead Client can see to-dos - AUV-1171////////////////////////////////
    /**
     * Check all ToDo in list is assigned for user
     * @param assignUser : user name need check
     * @return true : all ToDo assign | false : still at least one ToDo was not assign
     */
    private boolean checkAllToDoAssignForUser(String assignUser){
        if(eleToDoAssignList.size() == 0)
            return false;
        for(int i=0; i<eleToDoAssignList.size();i++){
            String todoAssign = eleToDoAssignList.get(i).getText().trim();
            if(!todoAssign.equalsIgnoreCase(assignUser)){
                return false;
            }
        }

        return true;
    }

    /**
     * Verify ser can see all ToDo assigned.
     * @param assignUser : user name need check
     */
    public void verifyToDoListAssignForUser(String assignUser){
        boolean result = checkAllToDoAssignForUser(assignUser);
        Assert.assertTrue(result);
    }
    ///////////////////////////////////////////////////End////////////////////////////////////////////
}

