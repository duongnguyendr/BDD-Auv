package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tan.pham on 6/22/2017.
 */
public class AuditorEngagementFilePage extends AbstractPage {
    public AuditorEngagementFilePage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    private static final String PAGE_TITLE = "Files";
    private static final String DOWN_LOAD_POPUP_TITLE = "Ready To Download";
    private static final String DOWN_LOAD_POPUP_DESCRIPTION = "A zip file containing your selected items are ready.";

    @FindBy(xpath = "//div[@class='pageHeader-leftContainer']//input[@id='a-header-title']")
    private WebElement dashboardTextEle;

    @FindBy(xpath = "//h4[@id='module-filemanager-title']//span[@id='module-filemanager-titleSpan']")
    private WebElement elePageTitle;

    @FindBy(xpath = "//thead[@class='module-fm-tableHeader']/td/div")
    private WebElement eleAllFileCheckBox;

    @FindBy(xpath = "//*[@id='module-fm-download']")
    private WebElement eleDownloadIcon;

    @FindBy(xpath = "//button[@id='fm-downloadBtn']")
    private  WebElement eldDownloadButtonInPopup;

    @FindBy(xpath = "//*[@class='au-modal-container modalTransition-popUp-container']//label[contains(text(),'Ready To Download')]")
    private WebElement eleTitleDownLoadPopup;

    @FindBy(xpath = "//*[@id='module-fm-trashIcon']")
    private WebElement eleTrashIcon;

    @FindBy(xpath = "//*[@id='comp-fm-search']")
    private WebElement eleSearchTextBox;

    @FindBy(xpath = "//*[@class='au-modal-container modalTransition-popUp-container']//span[@class='files-deleteStorage-msg']")
    private WebElement eleDescriptionDownLoadPopup;

    @FindBy(xpath = "//*[@class='au-modal-container modalTransition-popUp-container']//img[@class='au-modal-closeBtn']")
    private WebElement eleCloseIconDownLoadPopup;

    @FindBy(xpath = "//span[@id='h-engagementsLink']")
    private WebElement eleEngagementLink;

    /**
     * Verify engagement file of engagement
     * @param engagementName : engagement name need check
     */
    public void verifyDetailsEngagementPage(String engagementName){
        waitForVisibleElement(dashboardTextEle, "dashboard text");
        validateAttributeElement(dashboardTextEle, "value", engagementName);
        waitForVisibleElement(elePageTitle, "page title");
        validateAttributeElement(elePageTitle, "text", PAGE_TITLE);
        waitForClickableOfElement(eleAllFileCheckBox, "all file check box");
        waitForClickableOfElement(eleDownloadIcon, "down load icon");
        waitForVisibleElement(eleTrashIcon, "trash icon");
        waitForVisibleElement(eleSearchTextBox, "search text box");
    }

    /**
     * Click on all file check box
     */
    public void clickOnAllFileCheckBox(){
        hoverElement(eleAllFileCheckBox, "hover all file check box");
        clickElement(eleAllFileCheckBox);
    }

    /**
     * Click on down load button in popup
     */
    public void clickOnDownloadButtonInPopup(){
        hoverElement(eldDownloadButtonInPopup, "hover download button icon");
        clickElement(eldDownloadButtonInPopup);
    }

    /**
     * Verify down load popup
     */
    public void verifyDownLoadPopup(){
        waitForVisibleElement(eleTitleDownLoadPopup, "down load popup title");
        validateElementText(eleTitleDownLoadPopup,DOWN_LOAD_POPUP_TITLE);
        waitForVisibleElement(eleDescriptionDownLoadPopup, "down load description");
        validateElementText(eleDescriptionDownLoadPopup, DOWN_LOAD_POPUP_DESCRIPTION);
        waitForVisibleElement(eldDownloadButtonInPopup, "down load button in popup");
        waitForVisibleElement(eleCloseIconDownLoadPopup, "close icon down load popup");
    }

    /**
     * Click on engagement link
     */
    public void clickOnDownLoadIcon(){
        hoverElement(eleDownloadIcon, "hover down load icon link");
        clickElement(eleDownloadIcon);
    }

    public void closeBrowserAfterDownLoad() throws InterruptedException{
        this.closeBrowserAfterDownLoad();
    }
}
