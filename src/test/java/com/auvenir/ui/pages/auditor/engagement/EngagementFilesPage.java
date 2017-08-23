package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class EngagementFilesPage extends AbstractPage {

    public EngagementFilesPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "module-filemanager-titleSpan")
    private WebElement filesText;

    public WebElement getFilesText() {
        return filesText;
    }

    @FindBy(xpath = "//img[@class='module-fm-emptyClipboard']")
    private WebElement emptyClipboardImage;

    public WebElement getEmptyClipboardImage() {
        return emptyClipboardImage;
    }

    @FindBy(xpath = "//p[@class='module-fm-emptyText']")
    private WebElement noFilesText;

    @FindBy(xpath="//div[@id='fm-filter-filterName']")
    private WebElement filterNameDropdown;

    @FindBy(xpath = "//i[@id='module-fm-trashIcon']")
    private WebElement trashIcon;

    @FindBy (xpath = "//i[@id='module-fm-download']")
    private WebElement downloadIcon;

    @FindBy(xpath = "//input[@id='comp-fm-search']")
    private WebElement searchTextbox;

    public WebElement getNoFilesText() {
        return noFilesText;
    }

    /**
     * Refactor by Minh Nguyen on June 28, 2017
     */
    public void verifyDisplayElementInEngagementFilesPage(){
        boolean isFilterNameDropdown, isTrashIcon, isDownloadIcon, isSearchTextbox, isFilesText, isEmptyClipboardImage, isNoFilesText = false;
        isFilterNameDropdown = validateDisPlayedElement(filterNameDropdown, "Filter name");
        isTrashIcon = validateDisPlayedElement(trashIcon, "Trash icon");
        isDownloadIcon = validateDisPlayedElement(downloadIcon, "Download icon");
        isSearchTextbox = validateDisPlayedElement(searchTextbox, "Search textbox");
        isFilesText = validateDisPlayedElement(filesText, "Files Text");
        isEmptyClipboardImage = validateDisPlayedElement(emptyClipboardImage, "Empty Clipboard Image");
        isNoFilesText = validateDisPlayedElement(noFilesText, "'You haven't added any files yet.' text");
        if(isFilterNameDropdown && isTrashIcon && isDownloadIcon && isSearchTextbox && isFilesText && isEmptyClipboardImage && isNoFilesText)
        {
            NXGReports.addStep("Verify Auditor Engagement Files page", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        else
        {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify Auditor Engagement Files page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

}
