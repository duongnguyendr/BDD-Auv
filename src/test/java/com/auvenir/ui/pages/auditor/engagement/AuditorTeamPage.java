package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.TeamPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


/**
 * Created by thuan.duong on 6/16/2017.
 */
public class AuditorTeamPage extends TeamPage {

    public AuditorTeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "engagementTeamLink")
    private WebElement teamMemberLinkEle;

    @FindBy(id = "team-inviteMember-btn")
    private WebElement inviteNewMemeberBtnEle;

    @FindBy(id = "team-emptyDiv")
    private WebElement teamEmptyDivEle;

    @FindBy(xpath = "//*[@id='team-checkAll']")
    private WebElement allMemberCheckBoxEle;

    @FindBy(xpath = "//*[@id='team-bulk-dropdown']")
    private WebElement bulkActionsDropdownEle;

    @FindBy(xpath = "//*[@id='team-delete-btn']")
    private WebElement deleteOptionActionsEle;

    @FindBy(xpath = "//*[@id='team-inviteMember-btn']")
    private WebElement inviteMemberBtnEle;

    @FindBy(xpath = "//*[@id='m-inm-name']")
    private WebElement fullNameMemberTxtEle;

    @FindBy(xpath = "//*[@id='m-inm-email']")
    private WebElement emailMemberTxtEle;

    @FindBy(xpath = "//*[@id='m-inm-reEmail']")
    private WebElement reEmailMemberTxtEle;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle']")
    private WebElement roleCompanyDropdownEle;

    @FindBy(xpath = "//*[@id='m-inm-addBtn']")
    private WebElement inviteButtonEle;

    @FindBy(xpath = "//*[contains (@id,'team-row')]/td[2]")
    //    @FindBy(xpath = "//*[@id='team-row-0']/td[2]")
    private List<WebElement> auditorTeamMemberNameEle;

    @FindBy(xpath = "//*[contains (@id,'team-row')]/td[3]")
    //    @FindBy(xpath = "//*[@id='team-row-0']/td[3]")
    private List<WebElement> roleTeamMemberNameEle;

    @FindBy(xpath = "//*[@id='team-row-0']/td[1]/input")
    private List<WebElement> checkBoxTeamMemberEle;

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - Start
     */
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    private List<WebElement> eleMemberNameList;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[3]")
    private List<WebElement> eleMemberRoleInFirmList;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle-container']/ul")
    private WebElement roleCompanyDdlPopupEle;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle-container']/ul/li/a")
    private List<WebElement> roleCompanyListItemDdlEle;


    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */

    public void clickInviteNewMemeberBtnEle() {
        getLogger().info("Click Invite New Memeber Button.");
        clickElement(inviteNewMemeberBtnEle, "Invite New Memeber Button");
    }

    public void deleteAllMemberInEngagement() {
        getLogger().info("Click Delete All Member.");
        try {
            // Need to sleep because the teamEmptyDiv is always displayed first.
            Thread.sleep(3000);
            String displayedValue = teamEmptyDivEle.getCssValue("display");
            if (displayedValue.equals("none")) {
                clickElement(allMemberCheckBoxEle, "All Member Check Box");
                boolean checked = allMemberCheckBoxEle.isSelected();
                if (checked) {
                    clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown");
                    clickElement(deleteOptionActionsEle, "Delete Option Dropdown");
                    waitForProgressOverlayIsClosed();
                    boolean result = verifyContentOfSuccessToastMessage("Your team member has been removed.");
                    if (!result)
                        throw new Exception();
                }
            }
            NXGReports.addStep("Delete All Member in Engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed:  Delete All Member in Engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @FindBy(xpath = "//div[@id='engagement-team']")
    WebElement engagementTeam;

    public void clickInviteMember() {
        getLogger().info("Click Invite Member Button.");
        waitForCssValueChanged(engagementTeam, "engagementTeam", "display", "block");
        clickElement(inviteMemberBtnEle, "Invite Member Button");
    }


    public void inputInviteNewMemberInfo(String fullName, String email, String roleMember) {
        try {
            getLogger().info("Input Invite New Member Information.");
            sendKeyTextBox(fullNameMemberTxtEle, fullName, "Full Name Textbox");
            sendKeyTextBox(emailMemberTxtEle, email, "Email Textbox");
            sendKeyTextBox(reEmailMemberTxtEle, email, "ReEnter Email Textbox");

            clickElement(roleCompanyDropdownEle, "Role in Company Dropdown");
            waitForAtrributeValueChanged(roleCompanyDdlPopupEle, "Role in Company Popup", "class", "ddlLink inputDdl inputDdl-after");
            clickElement(roleCompanyListItemDdlEle.get(0), "second Item in Role Dropdown list");
            waitForAtrributeValueChanged(roleCompanyDdlPopupEle, "Role in Company Popup", "class", "ddlLink inputDdl");
            //            sendKeyTextBox(roleCompanyDropdownEle, roleMember, "Role Member Textbox");
            clickElement(reEmailMemberTxtEle, "Email Textbox");
            clickElement(inviteButtonEle, "Invite Button");
            waitForProgressOverlayIsClosed();
            boolean result = verifyContentOfSuccessToastMessage("Your engagement invitation has been sent.");
            Assert.assertTrue(result, "The Message Invite New Member Successful should be displayed");
            NXGReports.addStep("Input Invite New Member Information.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Input Invite New Member Information.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            getLogger().info(e);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed: Input Invite New Member Information.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            getLogger().info(e);
        }
    }

    public void verifyAddNewInvitedMember(String fullName, String roleMember) {
        getLogger().info("Verify new Auditor Member is added.");
        try {
            int index = findTeamMemberByName(fullName);
            //                    validateElementText(auditorTeamMemberNameEle.get(0), fullName);
            if (index != -1) {
                validateElementText(roleTeamMemberNameEle.get(index), roleMember);
            }
            else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("New auditor member is not added.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed:  verify invite new member.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void deleteMemberInEngagementByName(String fullNameMember) {
        getLogger().info(String.format("Click Delete Team Member '%s'", fullNameMember));
        try {
            int index = findTeamMemberByName(fullNameMember);
            if (index != -1) {
                clickElement(checkBoxTeamMemberEle.get(index), "Check Box Team Member");
                boolean checked = checkBoxTeamMemberEle.get(index).isSelected();
                if (checked) {
                    clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown");
                    clickElement(deleteOptionActionsEle, "Delete Option Dropdown");
                    waitForProgressOverlayIsClosed();
                    //                    boolean result = verifyContentOfSuccessToastMessage("Your team member has been removed.");
                    //                    if (!result) throw new Exception();
                }
            }
            NXGReports.addStep("Delete All Member in Engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed:  Delete All Member in Engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public int findTeamMemberByName(String fullNameMember) {
        getLogger().info(String.format("Find position of Team Member '%s'", fullNameMember));
        try {
            // Need to sleep because the teamEmptyDiv is always displayed first.
            waitSomeSeconds(2);
            //            String displayedValue = teamEmptyDivEle.getCssValue("display");
            boolean result = validateNotExistedElement(auditorTeamMemberNameEle.get(0), "Team Member Row Name");
            if (!result) {
                String actualAttributeValue;
                for (int i = 0; i < auditorTeamMemberNameEle.size(); i++) {
                    //                        WebElement toDoNameCell = auditorTeamMemberNameEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                    actualAttributeValue = auditorTeamMemberNameEle.get(i).getText().trim();
                    if (actualAttributeValue.equals(fullNameMember)) {
                        getLogger().info("Team Member Name is found at " + i);
                        NXGReports.addStep(String.format("The position of Team Member: '%s' at %d", fullNameMember, i), LogAs.PASSED, null);
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        } catch (Exception e) {
            getLogger().info(e);
            return -1;
        }
    }

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - Start
     */
    /**
     * Check member is exists in team list
     *
     * @param memberFullName : member full name need check
     * @param roleInFirm     : role in firm need check
     * @return true : found | false : not found
     */
    public boolean checkMemberTeamIsExists(String memberFullName, String roleInFirm) {
        for (int i = 0; i < eleMemberNameList.size(); i++) {
            if (eleMemberNameList.get(i).getText().trim().equals(memberFullName)) {
                if (eleMemberRoleInFirmList.get(i).getText().trim().equals(roleInFirm)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Verfiy member is exists in team list
     *
     * @param memberFullName : member full name need check
     * @param roleInFirm     : role in firm need check
     */
    public void verifyMemberIsShownInTeamList(String memberFullName, String roleInFirm) {
        getLogger().info(String.format("Verify member is already exists in team list"));
        try {
            boolean result = checkMemberTeamIsExists(memberFullName, roleInFirm);
            Assert.assertTrue(result);
            NXGReports.addStep("Verify member is already exists in team list.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Test Failed:  Verify member is already exists in team list.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */
}
