package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by vien.pham on 7/28/2017.
 */
public abstract class TeamPage extends CommonPage {
    public TeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    protected List<WebElement> listTeamMember;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[@type='checkbox']")
    private List<WebElement> listCheckboxTeamMember;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[contains(@type,'checkbox') and (@disabled)]")
    private List<WebElement> listDisableCheckboxTeamMember;

    @FindBy(xpath = "//div[@id='engagement-team']")
    private WebElement engagementTeam;

    @FindBy(xpath = "//*[@id='team-inviteMember-btn']")
    private WebElement inviteMemberBtn;

    @FindBy(xpath = "//h3[@class='inm-subTitle']")
    private WebElement inviteNewMemberTitle;

    @FindBy(xpath = "//*[@id='m-inm-name']")
    protected WebElement fullNameMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-email']")
    protected WebElement emailMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-reEmail']")
    protected WebElement reEmailMemberTxt;

    @FindBy(xpath = "//*[@id='m-inm-addBtn']")
    protected WebElement inviteButton;

    @FindBy(xpath = "//div[@class='ui dropdown team-permission-dropdown']")
    private List<WebElement> permissionSelectBox;

    @FindBy(xpath = "//div[starts-with(@id,'Set User To Lead')]")
    private WebElement setUserToLeadPopup;

    @FindBy(xpath = "//div[starts-with(@id,'m-Set User To Lead')]/label")
    private WebElement setUserToLeadTitle;

    @FindBy(xpath = "//div[starts-with(@id,'Set User To Lead')]//button[@class='auvbtn warning']")
    private WebElement setLeadConfirmBtn;

//    @FindBy(xpath = "//div[@class='ui dropdown team-permission-dropdown']/div[contains(@class,'menu')]")
//    private List<WebElement> permissionMenuDropdown;

    @FindBy(xpath = "//div[@class='ui dropdown team-permission-dropdown']//div[@class='item']")
    private List<WebElement> leadPermissionOption;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//span")
    private List<WebElement> permissionLevel;

    public int findMemberByName(String memberName) {
        int index = -1;
        for (int i = 0; i < listTeamMember.size(); i++) {
            if (listTeamMember.get(i).getText().equals(memberName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void verifyPermisionToSeeMemberList(String memberFullName, boolean permissionToSee) {
        getLogger().info("Finding member in list...");
        int index = findMemberByName(memberFullName);
        if (permissionToSee) {
            if (index != -1) {

            }

        } else {
            if (index == -1) {
                getLogger().info("Can not see member: " + memberFullName + " in list");
            } else {
                Assert.fail("Can see member: " + memberFullName + " in list");
            }
        }
    }

    /**
     * Vien.Pham own this function
     *
     * @param memberFullName
     * @param permissionToSelect
     */
    public void verifyPermisionToSelectMemberCheckbox(String memberFullName, boolean permissionToSelect) {
        getLogger().info("Finding member in list...");
        int index = findMemberByName(memberFullName);
        getLogger().info("Verifying checkbox is disabled..");
        if (permissionToSelect) {

        } else {
            Boolean isDisplayed = validateDisPlayedElement(listDisableCheckboxTeamMember.get(index), "disable checkbox");
            if (isDisplayed) {
                getLogger().info("Cannot select member Checkbox.");
            } else {
                Assert.fail("Fail: Can select member Checkbox.");
            }
        }
    }

    @FindBy(id = "team-inviteMember-btn")
    private WebElement buttonInviteNewMember;

    @FindBy(xpath = "//img[contains(@id,'Set User To Lead')]/following-sibling::div//button[@class='auvbtn warning']")
    private WebElement buttonConfirmSetUserToLead;

    public void clickInviteNewMember() {
        clickElement(buttonInviteNewMember, "Button Invite New Member");
    }

    public void chooseLeadWithTeamMemberName(String name) {
        //        String xpathRadioButtonLeadClient = "//td[text()='%s']/following-sibling::td/input";
        String xpathSelectPermissionLevel = "//td[text()='%s']/following-sibling::td/div";
//        String xpathOptionLead = "//td[text()='%s']/following-sibling::td/div//div[@data-id='Lead']";
        String xpathOptionLead = "//td[text()='%s']/following-sibling::td/div//div[@class='menu show']/div[text()='Lead']";
        clickElement(getElementByXpath(xpathSelectPermissionLevel, name), "Select Permission Level");
        clickElement(getElementByXpath(xpathOptionLead, name), "Option Lead");
    }

    public void confirmSetUserToLead() {
        waitSomeSeconds(1);
        clickElement(buttonConfirmSetUserToLead, "Button Confirm Set User To Lead");
    }

    public void verifyLeadSetByName(String name, String leadText) {
        waitSomeSeconds(1);
        String xpathCellPermissionLevel = "//td[text()='%s']/following-sibling::td[2]";
        validateElementText(getElementByXpath(xpathCellPermissionLevel, name), leadText);
    }

    public void clickInviteMember() {
        getLogger().info("Click Invite Member Button.");
        waitForCssValueChanged(engagementTeam, "engagementTeam", "display", "block");
        clickElement(inviteMemberBtn, "Invite Member Button");
    }


    public void verifyInviteNewMemberPageDisplayed() {
        getLogger().info("Verify invite new member page load");
        boolean result = validateDisPlayedElement(inviteNewMemberTitle, "inviteNewMemberTitle");
        Assert.assertTrue(result);
    }

    public void inputFullName(String fullName) {
        sendKeyTextBox(fullNameMemberTxt, fullName, "Full Name Textbox");
    }

    public void inputEmail(String email) {
        sendKeyTextBox(emailMemberTxt, email, "Email Textbox");
    }

    public void inputEmailConfirm(String email) {
        sendKeyTextBox(reEmailMemberTxt, email, "ReEnter Email Textbox");
    }

    public void clickButtonInviteNewMember() {
        clickElement(inviteButton, "Invite Button");
        waitForProgressOverlayIsClosed();
    }


    public void verifyAddNewMemberSuccessful() {
        boolean result = verifyContentOfSuccessToastMessage("Your engagement invitation has been sent.");
        Assert.assertTrue(result, "The Message Invite New Member Successful should be displayed");
    }

    public void changePermissionOfMember(String memberName) {
        int index = findMemberByName(memberName);
        clickElement(permissionSelectBox.get(index), "Permisson Select box");
        clickElement(leadPermissionOption.get(index), "Lead Permission");
        waitForCssValueChanged(setUserToLeadPopup,"Set User to Lead Popup","display","block");
        validateElementText(setUserToLeadTitle,"Set User to Lead");
        clickElement(setLeadConfirmBtn,"Confirm Set Lead Btn");
    }
}
