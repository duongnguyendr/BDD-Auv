package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public class DetailsEngagementPage extends CommonPage {
    private static Logger logger = Logger.getLogger(DetailsEngagementPage.class.getSimpleName());

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
        boolean result = validateElementText(engagementNameUneditable, engagementName);
        Assert.assertTrue(result,"Should see Detail Engagement.");
    }

    /**
     * @param engagementName : to verify engagement name displayed correctly
     */
    public void verifyDetailsEngagementPageEditable(String engagementName) {
        waitForVisibleElement(engagementNameEditable, "Engagement name text");
        clickElement(engagementNameEditable, "Engagement name text");
        sendTabKey(engagementNameEditable, "");
        boolean result = validateAttributeElement(engagementNameEditable, "placeholder", engagementName);
        Assert.assertTrue(result,"Should see Detail Engagement.");
    }

    //    public void verifyDetailsEngagementPage(String engagementName) {
    //        waitForVisibleElement(engagementNameText, "Engagement name text");
    //        if (engagementNameText.getTagName().equals("input")) {
    //            validateAttributeElement(engagementNameText, "value", engagementName);
    //        } else if (engagementNameText.getTagName().equals("span")) {
    //            validateElementText(engagementNameText, engagementName);
    //        } else {
    //            NXGReports.addStep("Fail: Engagement name tag name undefined.", LogAs.FAILED, new CaptureScreen
    // (CaptureScreen.ScreenshotOf.BROWSER_PAGE),
    //                    "Engagement name tag name must be input(editable) or span(uneditable). Actual tag: " +
    // engagementNameText.getTagName());
    //        }
    //    }

    public void navigateToTeamTab() {
        clickElement(tabTeam, "Tab Team");
    }

    public void verifyCantInviteClientIntoEngagement(boolean possible) {
        if (validateExistedElement(buttonInviteClient, "Button Invite Client") == possible) {
            logger.info("Verify Invite Client Into Engagement.");
        } else {
            logger.info("Fail: Verify Invite Client Into Engagement.");
        }
    }


}
