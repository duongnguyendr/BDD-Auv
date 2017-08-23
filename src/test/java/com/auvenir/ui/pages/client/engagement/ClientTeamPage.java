package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.TeamPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vien.pham on 7/19/2017.
 */
public class ClientTeamPage extends TeamPage {

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//input[@type='checkbox']")
    List<WebElement> listCheckboxTeamMember;

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']//span[contains(@id,'team-trash')]")
    List<WebElement> listTrashIconTeamMember;

    @FindBy(xpath = "//div[@class='send-message-success-alert']")
    WebElement messageRemoveMemberDone;

    @FindBy(xpath = "//div[@class='fl-a-container fl-a-container-show']")
    WebElement popUpRemoveMemberDone;

    public ClientTeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * Vien.Pham added method removeTeamMember() for removing member in list.
     *
     * @param memberFullName: input memberFullName to filter corresponding row include it.
     */
    public void removeTeamMember(String memberFullName) {
        try {
            System.out.println("The number of Team member before removing is: " + listTeamMember.size());
            int index = findMemberByName(memberFullName);
            clickElement(listCheckboxTeamMember.get(index), "select member check box");
            waitForCssValueChanged(listTrashIconTeamMember.get(index), "member trash icon", "display", "block");
            clickElement(listTrashIconTeamMember.get(index));
            NXGReports.addStep("Completing do remove action: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Completing do remove action: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }


    public void verifyRemoveTeamMember(String memberName) {
        System.out.println("The number of Team member after removing is: " + listTeamMember.size());
        int isCheck = findMemberByName(memberName);
        if (isCheck == -1) {
            NXGReports.addStep("Verify team member is removed : Pass.", LogAs.PASSED, null);
        } else {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify team member is removed : Failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyMessageFromRemovingTeamMember(String message) {
        waitForVisibleElement(popUpRemoveMemberDone, "Popup alerts remove member done");
        validateElementText(messageRemoveMemberDone, message);
    }

}
