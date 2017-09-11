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
}
