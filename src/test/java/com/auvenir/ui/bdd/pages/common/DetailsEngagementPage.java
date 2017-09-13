package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public class DetailsEngagementPage extends CommonPage {

    @FindBy(xpath = "//span[@id='a-header-title']")
    protected WebElement engagementNameUneditable;

    @FindBy(xpath = "//input[@id='a-header-title']")
    protected WebElement engagementNameEditable;

    @FindBy(id = "engagementUserBtn")
    private WebElement buttonInviteClient;

    @FindBy(id = "engagementTeamLink")
    private WebElement tabTeam;

    public DetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * @param engagementName : to verify engagement name displayed correctly
     */
    public void verifyDetailsEngagementPageUnEditable(String engagementName) {
            waitForVisibleElement(engagementNameUneditable, "Engagement name text");
            validateElementText(engagementNameUneditable, engagementName);
    }

    /**
     * @param engagementName : to verify engagement name displayed correctly
     */
    public void verifyDetailsEngagementPageEditable(String engagementName) {
        waitForVisibleElement(engagementNameEditable, "Engagement name text");
        clickElement(engagementNameEditable, "Engagement name text");
        sendTabKey(engagementNameEditable, "");
        validateAttributeElement(engagementNameEditable, "placeholder", engagementName);
    }

    //    public void verifyDetailsEngagementPage(String engagementName) {
    //        waitForVisibleElement(engagementNameText, "Engagement name text");
    //        if (engagementNameText.getTagName().equals("input")) {
    //            validateAttributeElement(engagementNameText, "value", engagementName);
    //        } else if (engagementNameText.getTagName().equals("span")) {
    //            validateElementText(engagementNameText, engagementName);
    //        } else {
    //            NXGReports.addStep("Fail: Engagement name tag name undefined.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
    //                    "Engagement name tag name must be input(editable) or span(uneditable). Actual tag: " + engagementNameText.getTagName());
    //        }
    //    }

    public void navigateToTeamTab() {
        clickElement(tabTeam, "Tab Team");
    }

    public void verifyCantInviteClientIntoEngagement(boolean possible) {
        if (validateExistedElement(buttonInviteClient, "Button Invite Client") == possible) {
            getLogger().info("Verify Invite Client Into Engagement.");
        } else {
            getLogger().info("Fail: Verify Invite Client Into Engagement.");
        }
    }



}
