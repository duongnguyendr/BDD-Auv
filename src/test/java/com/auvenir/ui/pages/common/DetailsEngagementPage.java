package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public abstract class DetailsEngagementPage extends AbstractPage {

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
     * @param isLeadAuditor: true: elements of Page can be edited or false: elements of Page can not be edited
     */
    public void verifyDetailsEngagementPage(String engagementName, boolean isLeadAuditor) {
        if (isLeadAuditor) {
            waitForVisibleElement(engagementNameEditable, "Engagement name text");
            clickElement(engagementNameEditable);
            sendTabkey(engagementNameEditable, "");
            validateAttributeElement(engagementNameEditable, "placeholder", engagementName);
        } else {
            waitForVisibleElement(engagementNameUneditable, "Engagement name text");
            validateElementText(engagementNameUneditable, engagementName);
        }
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
            NXGReports.addStep("Verify Invite Client Into Engagement.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Fail: Verify Invite Client Into Engagement.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
