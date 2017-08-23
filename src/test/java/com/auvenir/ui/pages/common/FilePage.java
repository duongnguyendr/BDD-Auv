package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vien.pham on 7/28/2017.
 */
public class FilePage extends AbstractPage {
    public FilePage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//table[@class='module-fm-table']//td[@class='module-fm-td']//div[contains(@id,'module-fm-fileName')][1]")
    private List<WebElement> listFileName;

    @FindBy(id = "engagementFileMangerLink")
    private WebElement tabFiles;

    @FindBy(xpath = "//table[@class='module-fm-table']//tr/td//input[@type='checkbox']")
    private List<WebElement> listCheckboxFile;

    @FindBy(xpath = "//table[@class='module-fm-table']//tr/td[6]")
    private List<WebElement> listFileUploaderName;

    @FindBy(xpath = "//table[@class='module-fm-table']//tr/td[@id='module-fm-fileTodo']/div")
    private List<WebElement> listToDoName;

    @FindBy(xpath = "//*[@id='module-fm-download']")
    private WebElement downloadFileIcon;

    @FindBy(xpath = "//*[@id='module-fm-trashIcon']")
    private WebElement deleteFileIcon;

    public void navigateToFilesTab() {
        getLogger().info("Navigate to Files Tab.");
        clickElement(tabFiles, "Tab Team");
    }

    public int findFileByName(String fileName) {
        int index = -1;
        try {
            for (int i = 0; i < listFileName.size(); i++) {
                if (listFileName.get(i).getText().equals(fileName)) {
                    index = i;
                    break;
                }
            }
            return index;
        } catch (Exception e) {
            getLogger().info(e);
            return index;
        }
    }

    public int findFileByName(String fileName, String uploaderName, String toDoName) {
        int index = -1;
        String actualFileName;
        String actualUploaderName;
        String actualToDoName;
        try {
            for (int i = 0; i < listFileName.size(); i++) {
                actualFileName = listFileName.get(i).getText();
                actualUploaderName = listFileUploaderName.get(i).getText();
                actualToDoName = listToDoName.get(i).getText();
                if(actualFileName.equals(fileName) && actualUploaderName.equals(uploaderName) && actualToDoName.equals(toDoName)) {
                    index = i;
                    break;
                }
            }
            return index;
        } catch (Exception e) {
            getLogger().info(e);
            return index;
        }
    }

    public void verifyUserDownloadFileInFileTab(String fileName, String uploaderName, String toDoName) {
        int index = -1;
        String pathDownloadFolder = GenericService.sDirPath + GenericService.downloadRelativePath;

        String concatDownload =  pathDownloadFolder.concat(fileName);
        GeneralUtilities.checkFileExists(concatDownload, true);
        waitSomeSeconds(3);
        try {
            index = findFileByName(fileName, uploaderName, toDoName);
            if (index == -1) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Can't find name " + fileName + " on list file in Files tab.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return;
            } else {
                clickElement(listCheckboxFile.get(index), "Check Box File");
                clickElement(downloadFileIcon, "Download Icon");
                waitSomeSeconds(3);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            NXGReports.addStep("Test Failed: Verify User Download file in Files tab.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }
}
