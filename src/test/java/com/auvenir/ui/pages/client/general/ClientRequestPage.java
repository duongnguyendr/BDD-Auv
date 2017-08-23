package com.auvenir.ui.pages.client.general;

import com.auvenir.ui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

public class ClientRequestPage extends AbstractPage {

    WebDriver driver = null;
    Logger logger = null;

    public ClientRequestPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }

    @FindBy(xpath = "//span[contains(text(),'All Requests')]")
    private WebElement eleAllRequestTxt;

    public WebElement getEleAllRequestTxt() {
        return eleAllRequestTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Financials')]")
    private WebElement eleFinancialsTxt;

    public WebElement getEleFinancialsTxt() {
        return eleFinancialsTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'All Requests')]//..//..//..//..//div[contains(text(),'General Ledger')]")
    private WebElement eleGeneralLedgerTxt;

    public WebElement getEleGeneralLedgerTxt() {
        return eleGeneralLedgerTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'All Requests')]//..//..//..//..//div[contains(text(),'Trial Balance')]")
    private WebElement eleTrialBalanceTxt;

    public WebElement getEleTrialBalanceTxt() {
        return eleTrialBalanceTxt;
    }

    @FindBy(xpath = "//span[contains(text(),'All Requests')]//..//..//..//..//div[contains(text(),'Bank Statements')]")
    private WebElement eleBankStatementsTxt;

    public WebElement getEleBankStatementsTxt() {
        return eleBankStatementsTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description')]//..//..//div[contains(text(),'General')]")
    private WebElement eleGeneralLedgerHeaderTxt;

    public WebElement getEleGeneralLedgerHeaderTxt() {
        return eleGeneralLedgerHeaderTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description')]")
    private WebElement eleDescriptionGeneralLedgerTxt;

    public WebElement getEleDescriptionGeneralLedgerTxt() {
        return eleDescriptionGeneralLedgerTxt;
    }

    @FindBy(xpath = "//div[@id='req-detail-state2']")
    private WebElement eleGeneralLedgerContainerFld;

    public WebElement getEleGeneralLedgerContainerFld() {
        return eleGeneralLedgerContainerFld;
    }

    @FindBy(xpath = "//div[@class='auvicon-line-cloud-upload']")
    private WebElement eleUploadGeneralLedgerImg;

    public WebElement getEleUploadGeneralLedgerImg() {
        return eleUploadGeneralLedgerImg;
    }

    @FindBy(xpath = "//div[contains(text(),'Drag and drop')]")
    private WebElement eleDragAndDropGeneralLedgerTxt;

    public WebElement getEleDragAndDropGeneralLedgerTxt() {
        return eleDragAndDropGeneralLedgerTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Browse')]")
    private WebElement eleBrowseGeneralLedgerTxt;

    public WebElement getEleBrowseGeneralLedgerTxt() {
        return eleBrowseGeneralLedgerTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description Placeholder')]//..//..//div[contains(text(),'Trial')]")
    private WebElement eleTrialBalanceHeaderTxt;

    public WebElement getEleTrialBalanceHeaderTxt() {
        return eleTrialBalanceHeaderTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description Placeholder')]")
    private WebElement eleDescriptionTrialBalanceTxt;

    public WebElement getEleDescriptionTrialBalanceTxt() {
        return eleDescriptionTrialBalanceTxt;
    }

    @FindBy(xpath = "//div[@id='req-detail-state2']")
    private WebElement eleTrialBalanceContainerFld;

    public WebElement getEleTrialBalanceContainerFld() {
        return eleTrialBalanceContainerFld;
    }

    @FindBy(xpath = "//div[@class='auvicon-line-cloud-upload']")
    private WebElement eleUploadTrialBalanceImg;

    public WebElement getEleUploadTrialBalanceImg() {
        return eleUploadTrialBalanceImg;
    }

    @FindBy(xpath = "//div[contains(text(),'Drag and drop')]")
    private WebElement eleDragAndDropTrialBalanceTxt;

    public WebElement getEleDragAndDropTrialBalanceTxt() {
        return eleDragAndDropTrialBalanceTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Browse')]")
    private WebElement eleBrowseTrialBalanceTxt;

    public WebElement getEleBrowseTrialBalanceTxt() {
        return eleBrowseTrialBalanceTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description Placeholder')]//..//..//div[contains(text(),'Bank')]")
    private WebElement eleBankStatementsHeaderTxt;

    public WebElement getEleBankStatementsHeaderTxt() {
        return eleBankStatementsHeaderTxt;
    }

    @FindBy(xpath = "//div[contains(text(),'Description Placeholder')]")
    private WebElement eleDescriptionBankStatementsTxt;

    public WebElement getEleDescriptionBankStatementsTxt() {
        return eleDescriptionBankStatementsTxt;
    }

    @FindBy(xpath = "//div[@id='req-detail-state2']")
    private WebElement eleBankStatementContainerFld;

    public WebElement getEleBankStatementContainerFld() {
        return eleBankStatementContainerFld;
    }

    @FindBy(xpath = "//div[@class='auvicon-line-cloud-upload']")
    private WebElement eleUploadBankStatementsImg;

    public WebElement getEleUploadBankStatementsImg() {
        return eleUploadBankStatementsImg;
    }

    @FindBy(xpath = "//div[contains(text(),'Drag and drop')]")
    private WebElement eleDragAndDropBankStatementsTxt;

    public WebElement getEleDragAndDropBankStatementsTxt() {
        return eleDragAndDropBankStatementsTxt;
    }

    @FindBy(xpath = "//p[contains(text(),'Browse')]")
    private WebElement eleBrowseBankStatementsTxt;

    public WebElement getEleBrowseBankStatementsTxt() {
        return eleBrowseBankStatementsTxt;
    }

    public void verifyClientRequestPage() {
        getLogger().info("Verify the Client Request Page.");
        waitForVisibleElement(eleAllRequestTxt,"All Requests Text");
        validateDisPlayedElement(eleAllRequestTxt,"All Requests Text");
        validateElementText(eleAllRequestTxt, "All Requests");
        validateDisPlayedElement(eleFinancialsTxt, "Financials Text");
        validateDisPlayedElement(eleGeneralLedgerTxt, "General Ledger Menu Link");
        validateDisPlayedElement(eleTrialBalanceTxt, "Trial Balance Menu Link");
        validateDisPlayedElement(eleBankStatementsTxt, "Bank Statements Menu Link");
    }

    public void verifyGeneralLedgerTab() {
        getLogger().info("Verify the General Ledger Tab.");
        waitForVisibleElement(eleGeneralLedgerHeaderTxt,"General Legder Header Text");
        validateDisPlayedElement(eleGeneralLedgerHeaderTxt, "General Legder Header Text");
        validateElementText(eleGeneralLedgerHeaderTxt, "General Ledger");
        validateDisPlayedElement(eleDescriptionGeneralLedgerTxt, "Description General Legder Text");
        validateDisPlayedElement(eleGeneralLedgerContainerFld, "General Legder Container Field");
        validateDisPlayedElement(eleUploadGeneralLedgerImg, "Upload General Legder Image");
        validateDisPlayedElement(eleDragAndDropGeneralLedgerTxt, "Drag and Drop General Legder Text");
        validateDisPlayedElement(eleBrowseGeneralLedgerTxt, "Browse General Legder Text");
    }

    public void clickTrialBalanceMenuLink() {
        getLogger().info("Click Trial Balance Menu Link.");
        clickElement(eleTrialBalanceTxt, "Trial Balance Link.");
    }

    public void verifyTrialBalanceTab() {
        getLogger().info("Verify the Trial Balance Tab.");
        waitForVisibleElement(eleTrialBalanceHeaderTxt, "Trial Balance Header");
        validateDisPlayedElement(eleTrialBalanceHeaderTxt, "Trial Balance Header");
        validateElementText(eleTrialBalanceHeaderTxt, "Trial Balance");
        validateDisPlayedElement(eleDescriptionTrialBalanceTxt, "Description Trial Balance Text");
        validateDisPlayedElement(eleTrialBalanceContainerFld, "Trial Balance container Field");
        validateDisPlayedElement(eleUploadTrialBalanceImg,"Upload Trial Balance Image");
        validateDisPlayedElement(eleDragAndDropTrialBalanceTxt, "Drag and Drop Trial Balance Text");
        validateDisPlayedElement(eleBrowseTrialBalanceTxt,"Browse Trial Balance Text");
    }

    public void clickBankStatementsMenuLink() {
        getLogger().info("Click Bank Statements Menu Link.");
        clickElement(eleBankStatementsTxt, "Bank Statements");
    }

    public void verifyBankStatementsTab() {
        getLogger().info("Verify the Bank Statements Tab.");
        waitForVisibleElement(eleBankStatementsHeaderTxt, "Bank Statements Header");
        validateDisPlayedElement(eleBankStatementsHeaderTxt, "Bank Statements Header");
        validateElementText(eleBankStatementsHeaderTxt, "Bank Statements");
        validateDisPlayedElement(eleDescriptionBankStatementsTxt, "Description Bank Statements Text");
        validateDisPlayedElement(eleBankStatementContainerFld, "Bank Statements Container Field");
        validateDisPlayedElement(eleUploadBankStatementsImg, "Upload Bank Statements Image");
        validateDisPlayedElement(eleDragAndDropBankStatementsTxt, "Drag and Drop Bank Statements Text");
        validateDisPlayedElement(eleBrowseBankStatementsTxt, "Browse Bank Statements Text");
    }
}
