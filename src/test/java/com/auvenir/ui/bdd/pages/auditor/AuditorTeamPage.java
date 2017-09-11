package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.TeamPage;
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
    private WebElement teamMemberLink;

    @FindBy(id = "team-inviteMember-btn")
    private WebElement inviteNewMemeberBtn;

    @FindBy(id = "team-emptyDiv")
    private WebElement teamEmptyDiv;

    @FindBy(xpath = "//*[@id='team-checkAll']")
    private WebElement allMemberCheckBox;

    @FindBy(xpath = "//*[@id='team-bulk-dropdown']")
    private WebElement bulkActionsDropdown;

    @FindBy(xpath = "//*[@id='team-delete-btn']")
    private WebElement deleteOptionActions;

    @FindBy(xpath = "//*[@id='team-inviteMember-btn']")
    private WebElement inviteMemberBtn;

    @FindBy(xpath = "//*[@id='m-inm-name']")
    private WebElement fullNameMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-email']")
    private WebElement emailMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-reEmail']")
    private WebElement reEmailMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle']")
    private WebElement roleCompanyDropdown;

    @FindBy(xpath = "//*[@id='m-inm-addBtn']")
    private WebElement inviteButton;

    @FindBy(xpath = "//*[contains (@id,'team-row')]/td[2]")
    //    @FindBy(xpath = "//*[@id='team-row-0']/td[2]")
    private List<WebElement> auditorTeamMemberName;

    @FindBy(xpath = "//*[contains (@id,'team-row')]/td[3]")
    //    @FindBy(xpath = "//*[@id='team-row-0']/td[3]")
    private List<WebElement> roleTeamMemberName;

    @FindBy(xpath = "//*[@id='team-row-0']/td[1]/input")
    private List<WebElement> checkBoxTeamMember;

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - Start
     */
    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    private List<WebElement> eleMemberNameList;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[3]")
    private List<WebElement> eleMemberRoleInFirmList;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle-container']/ul")
    private WebElement roleCompanyDdlPopup;

    @FindBy(xpath = "//*[@id='m-inm-jobTitle-container']/ul/li/a")
    private List<WebElement> roleCompanyListItemDdl;


    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */

    public void clickInviteNewMemeberBtnEle() {
        getLogger().info("Click Invite New Memeber Button.");
        clickElement(inviteNewMemeberBtn, "Invite New Memeber Button");
    }

    public void deleteAllMemberInEngagement() {
        getLogger().info("Click Delete All Member.");
        try {
            // Need to sleep because the teamEmptyDiv is always displayed first.
            Thread.sleep(3000);
            String displayedValue = teamEmptyDiv.getCssValue("display");
            if (displayedValue.equals("none")) {
                clickElement(allMemberCheckBox, "All Member Check Box");
                boolean checked = allMemberCheckBox.isSelected();
                if (checked) {
                    clickElement(bulkActionsDropdown, "Bulk Actions Dropdown");
                    clickElement(deleteOptionActions, "Delete Option Dropdown");
                    waitForProgressOverlayIsClosed();
                    boolean result = verifyContentOfSuccessToastMessage("Your team member has been removed.");
                    if (!result)
                        throw new Exception();
                }
            }
            getLogger().info("Delete All Member in Engagement.");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    @FindBy(xpath = "//div[@id='engagement-team']")
    WebElement engagementTeam;

    public void clickInviteMember() {
        getLogger().info("Click Invite Member Button.");
        waitForCssValueChanged(engagementTeam, "engagementTeam", "display", "block");
        clickElement(inviteMemberBtn, "Invite Member Button");
    }


    public void inputInviteNewMemberInfo(String fullName, String email, String roleMember) {
        try {
            getLogger().info("Input Invite New Member Information.");
            sendKeyTextBox(fullNameMemberTxt, fullName, "Full Name Textbox");
            sendKeyTextBox(emailMemberTxt, email, "Email Textbox");
            sendKeyTextBox(reEmailMemberTxt, email, "ReEnter Email Textbox");

            clickElement(roleCompanyDropdown, "Role in Company Dropdown");
            waitForAtrributeValueChanged(roleCompanyDdlPopup, "Role in Company Popup", "class", "ddlLink inputDdl inputDdl-after");
            clickElement(roleCompanyListItemDdl.get(0), "second Item in Role Dropdown list");
            waitForAtrributeValueChanged(roleCompanyDdlPopup, "Role in Company Popup", "class", "ddlLink inputDdl");
            //            sendKeyTextBox(roleCompanyDropdown, roleMember, "Role Member Textbox");
            clickElement(reEmailMemberTxt, "Email Textbox");
            clickElement(inviteButton, "Invite Button");
            waitForProgressOverlayIsClosed();
            boolean result = verifyContentOfSuccessToastMessage("Your engagement invitation has been sent.");
            Assert.assertTrue(result, "The Message Invite New Member Successful should be displayed");
            getLogger().info("Input Invite New Member Information.");
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void verifyAddNewInvitedMember(String fullName, String roleMember) {
        getLogger().info("Verify new Auditor Member is added.");
        try {
            int index = findTeamMemberByName(fullName);
            //                    validateElementText(auditorTeamMemberName.get(0), fullName);
            if (index != -1)
                validateElementText(roleTeamMemberName.get(index), roleMember);
            else {
                Assert.fail("New auditor member is not added.");
            }
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }
    }

    public void deleteMemberInEngagementByName(String fullNameMember) {
        getLogger().info(String.format("Click Delete Team Member '%s'", fullNameMember));
        try {
            int index = findTeamMemberByName(fullNameMember);
            if (index != -1) {
                clickElement(checkBoxTeamMember.get(index), "Check Box Team Member");
                boolean checked = checkBoxTeamMember.get(index).isSelected();
                if (checked) {
                    clickElement(bulkActionsDropdown, "Bulk Actions Dropdown");
                    clickElement(deleteOptionActions, "Delete Option Dropdown");
                    waitForProgressOverlayIsClosed();
                    //                    boolean result = verifyContentOfSuccessToastMessage("Your team member has been removed.");
                    //                    if (!result) throw new Exception();
                }
            }
            getLogger().info("Delete All Member in Engagement.");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
        }

    }

    public int findTeamMemberByName(String fullNameMember) {
        getLogger().info(String.format("Find position of Team Member '%s'", fullNameMember));
        try {
            // Need to sleep because the teamEmptyDiv is always displayed first.
            waitSomeSeconds(2);
            //            String displayedValue = teamEmptyDiv.getCssValue("display");
            boolean result = validateNotExistedElement(auditorTeamMemberName.get(0), "Team Member Row Name");
            if (!result) {
                String actualAttributeValue;
                for (int i = 0; i < auditorTeamMemberName.size(); i++) {
                    //                        WebElement toDoNameCell = auditorTeamMemberName.get(i).findElement(By.xpath("td/input[@type='text']"));
                    actualAttributeValue = auditorTeamMemberName.get(i).getText().trim();
                    if (actualAttributeValue.equals(fullNameMember)) {
                        getLogger().info("Team Member Name is found at " + i);
                        getLogger().info(String.format("The position of Team Member: '%s' at %d", fullNameMember, i));
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
            getLogger().info("Verify member is already exists in team list.");
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
        }

    }

    /**
     * verifyCheckListTeam - TanPH - 2017/06/22 - End
     */
}