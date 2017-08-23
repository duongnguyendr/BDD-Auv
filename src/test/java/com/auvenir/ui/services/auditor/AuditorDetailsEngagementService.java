package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorDetailsEngagementPage;
import com.auvenir.ui.pages.auditor.engagement.AuditorEngagementFilePage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */

public class AuditorDetailsEngagementService extends AbstractService {

    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    AuditorEngagementFilePage auditorEngagementFilePage;

    /*
     * contructor
     */
    public AuditorDetailsEngagementService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(getLogger(), getDriver());
        auditorEngagementFilePage = new AuditorEngagementFilePage(getLogger(), getDriver());

    }


    public void navigateToClientSettingsPage() {

        try {
            getLogger().info("navigate to client Settings page.");
            //auditorEngagementTeamPage.navigateToClientSettingsPage();
            NXGReports.addStep("navigate to client setting tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to client settings tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyDetailsEngagementPage(String engagementName) {
        auditorDetailsEngagementPage.verifyDetailsEngagementPage(engagementName);
    }

    public void verifyDetailsEngagementPage(String engagementName, Boolean editablePage) {
        auditorDetailsEngagementPage.verifyDetailsEngagementPage(engagementName, editablePage);
    }

    public void verifyDetailsEngagementAtGeneralPage(String engagementName) {
        try {
            getLogger().info("verify Detail Engagement page.(Implemented later)");
            auditorDetailsEngagementPage.verifyDetailsEngagementAtGeneralPage(engagementName);
            NXGReports.addStep("verify Detail Engagement page.(Implemented later)", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Detail Engagement page.(Implemented later)", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToTeamTab() {
        auditorDetailsEngagementPage.navigateToTeamTab();
    }

    public void navigateToTaskList() {
        try {
            getLogger().info("navigate to task list page.");
            auditorDetailsEngagementPage.navigateToTaskList();
            NXGReports.addStep("navigate to task list tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to task list tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void navigateToTodoListPage() {
        try {
            getLogger().info("navigate to To Do list page.");
            auditorDetailsEngagementPage.navigateToTodoListPage();
            NXGReports.addStep("navigate to To Do list tab.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("navigate to To Do list tab.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - Start
     */

    /**
     * Click on file manager link
     */
    public void clickOnFileManagerLink() {
        auditorDetailsEngagementPage.clickOnFileManagerLink();
    }

    /**
     * Verify file manager page follow engagement name
     *
     * @param engagementName
     */
    public void verifyEngagementManagePage(String engagementName) {
        auditorEngagementFilePage.verifyDetailsEngagementPage(engagementName);
    }

    /**
     * Click on all file check box
     */
    public void clickOnAllFileCheckBox() {
        auditorEngagementFilePage.clickOnAllFileCheckBox();
    }

    /**
     * Click on down load icon
     */
    public void clickOnDownLoadIcon() {
        auditorEngagementFilePage.clickOnDownLoadIcon();
    }

    /**
     * Verify down load popup
     */
    public void verifyDownLoadPopup() {
        auditorEngagementFilePage.verifyDownLoadPopup();
    }

    /**
     * Click on down load button in popup
     */
    public void clickOnDownLoadButtonInPopup() {
        auditorEngagementFilePage.clickOnDownloadButtonInPopup();
    }

    /**
     * verifyDownloadAttachmentFromAllToDo - TanPh - 2017/06/22 - End
     */

    public void clickOnContactLink() {
        auditorDetailsEngagementPage.clickOnContactLink();
    }

    public void closeBrowserAfterDownLoad() throws InterruptedException {
        auditorEngagementFilePage.closeBrowserAfterDownLoad();
    }
}


