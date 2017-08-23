package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import org.testng.log4testng.Logger;

public class EngagementRequestPage extends AbstractPage {

    public EngagementRequestPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "dashboardUsername")
    private WebElement eleAllRequestsTxt;

    public WebElement getEleAllRequestsTxt() {
        return eleAllRequestsTxt;
    }

    @FindBy(id = "req-nav-newCatBtn")
    private WebElement eleCreateCategoryLnk;

    public WebElement getEleCreateCategoryLnk() {
        return eleCreateCategoryLnk;
    }

    @FindBy(xpath = "//div[text()='Financials']")
    private WebElement eleFINANCIALSLnk;

    public WebElement getEleFINANCIALSLnk() {
        return eleFINANCIALSLnk;
    }

    @FindBy(xpath = "//div[text()='General Ledger'][@class='req-nav-listTitle noSelect']")
    private WebElement eleGeneralLedgerLnk;

    public WebElement getEleGeneralLedgerLnk() {
        return eleGeneralLedgerLnk;
    }

    @FindBy(xpath = "//div[text()='Trial Balance']")
    private WebElement eleTrialBalanceLnk;

    public WebElement getEleTrialBalanceLnk() {
        return eleTrialBalanceLnk;
    }

    @FindBy(xpath = "//div[text()='Bank Statements']")
    private WebElement eleBankStatementsLnk;

    public WebElement getEleBankStatementsLnk() {
        return eleBankStatementsLnk;
    }

    @FindBy(id = "m-req-requestname")
    private WebElement eleGeneralLedgerTxt;

    public WebElement getEleGeneralLedgerTxt() {
        return eleGeneralLedgerTxt;
    }

    @FindBy(id = "m-req-description")
    private WebElement eleDescriptionTxt;

    public WebElement getEleDescriptionTxt() {
        return eleDescriptionTxt;
    }

    @FindBy(xpath = "//div[@class='auvicon-line-cloud-upload']")
    private WebElement eleFileUploadIcn;

    public WebElement getEleFileUploadIcn() {
        return eleFileUploadIcn;
    }

    @FindBy(id = "photoUploadText")
    private WebElement eleDragDropTxt;

    public WebElement getEleDragDropTxt() {
        return eleDragDropTxt;
    }

    @FindBy(id = "photoBrowseText")
    private WebElement eleBrowseFileTxt;

    public WebElement getEleBrowseFileTxt() {
        return eleBrowseFileTxt;
    }

    @FindBy(id = "request-totalNumber")
    private WebElement eleCompleteTxt;

    public WebElement getEleCompleteTxt() {
        return eleCompleteTxt;
    }

    @FindBy(id = "req-det-duedate")
    private WebElement eleDueDateTxt;

    public WebElement getEleDueDateTxt() {
        return eleDueDateTxt;
    }

    public void verifyDisplayElementInRequestPage(){
        validateDisPlayedElement(getEleAllRequestsTxt(), "All Requests Text");
        validateDisPlayedElement(getEleCreateCategoryLnk(), "Create Category Link");
        validateDisPlayedElement(getEleGeneralLedgerTxt(), "General Ledger Text");
        validateDisPlayedElement(getEleDescriptionTxt(), "Description Text");
        validateDisPlayedElement(getEleDueDateTxt(), "Due Date Text");
        validateDisPlayedElement(getEleFileUploadIcn(), "File Upload Icon");
        validateDisPlayedElement(getEleDragDropTxt(), "All Requests Text");
        validateDisPlayedElement(getEleBrowseFileTxt(), "Browse File Text");
        validateDisPlayedElement(getEleFINANCIALSLnk(), "Financials - Link");
        validateDisPlayedElement(getEleGeneralLedgerLnk(), "General Ledger - Link");
        validateDisPlayedElement(getEleTrialBalanceLnk(), "Trial Balance - Link");
        validateDisPlayedElement(getEleCompleteTxt(), "Complete - Text");
    }
}
