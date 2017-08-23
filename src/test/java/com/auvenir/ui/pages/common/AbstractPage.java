package com.auvenir.ui.pages.common;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hungcuong1105 on 4/15/2017.
 * Updated by Doai.Tran on 5/9/2017.
 */
public class AbstractPage {
    private Logger logger = null;
    private WebDriver driver = null;
    public static final int waitTime = 30;
    public static final int waitTimeOut = 10;
    public static final int smallerTimeOut = 500;
    public static final int smallTimeOut = 1000;
    public static final int largeTimeOut = 2000;
    public static final int bigTimeOut = 3000;
    public static final String categoryIndiMode = "indicategory";
    public static final String categoryTitleOfAddNew = "Add New Category";
    public static final String backgroundColor = "background-color";
    public static final String numberSequence = "123456";
    public static final String maxLengthCategoryName = "1234567890";
    public static final String maxLenghtString =
            "limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit with 255 character limit";
    public static final String borderColor = "border-color";
    public static final String border = "border";
    public static final String background = "background";
    public static final String searchTextToDoListPage = "Search to do";
    public static final String searchTextDefault = "Search...";
    public static final String greenColor = "1px solid rgb(89, 155, 161)";
    public static final String blueColor = "rgb(43, 72, 117) none repeat scroll 0% 0% / auto padding-box border-box";
    public static final String greyColor = "1px solid rgb(151, 147, 147)";
    public static final String whiteColor = "1px solid rgb(255, 255, 255)";
    public static final String color = "color";
    public static final String categoryNameAllText = "category name all text";
    public static final String notValidNameMessage = "Not a valid name.";
    public static final String specialCharacter = "~!@#$%^&*+?><,.";
    public static final String existedCategoryName = "Category name already existed";
    public static final int maxLenght = 255;
    public static final int maxLenghtOneHundred = 100;
    public static final String nullChars = "";
    public static final String categoryColor = "//*[@id='category-color']";
    public static final String categoryColorContainer = "//*[@id='category-color-container']/ul/li[4]";
    public static final String dropdownCategoryToDoBulkDdl = "//*[@class='ui dropdown category todo-bulkDdl ']";
    public static final String dropdownCategoryToDoBulkDdlDiv1 = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]";
    public static final String popUpDivCategoryModel = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]";
    public static final String dropdownCategoryToDoBulkDllDivDiv = "//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div/div";
    private String categoryCreateBtnXpath = "//*[@id='todo-table']/tbody/tr[1]/td[3]//div[@class='menu']/div[1]";
    //    public final String warningBorderCSSColor = "rgb(253, 109, 71)";
    //public final String warningBorderCSSColor = "rgba(253, 109, 71, 0.43)";
    public final String warningBorderCSSColor = "rgb(253, 109, 71)";
    public final String warningBackgroundCSSColor = "rgba(241, 103, 57, 0.2)";

    /**
     * @param logger
     * @param driver
     */
    public AbstractPage(Logger logger, WebDriver driver) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public Logger getLogger() {
        return logger;
    }

    @FindBy(xpath = "//span[contains(text(),'© 2017 Auvenir Inc')]")
    private WebElement eleAuvenirIncTxt;

    @FindBy(xpath = "//div[@id='preview-footer']/footer/div/div/div[2]/a[@href='/terms']")
    private WebElement eleTermsOfServiceLnk;

    @FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()-1]")
    private WebElement eleTermsOfServiceDotTxt;

    @FindBy(xpath = "//div[@id='preview-footer']/footer/div/div/div[2]/a[@href='/privacy']")
    private WebElement elePrivacyStatementLnk;

    @FindBy(xpath = "(//span[contains(text(),'© 2017 Auvenir Inc')]//..//..//a[contains(text(),'.')])[last()]")
    private WebElement elePrivacyStatementDotTxt;

    @FindBy(xpath = "//div[@id='preview-footer']/footer/div/div/div[2]/a[@href='/cookies']")
    private WebElement eleCookieNoticeLnk;

    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUserNameEle;

    @FindBy(id = "h-ddl-item-settings")
    WebElement settingsTabEle;

    @FindBy(id = "navTitle")
    WebElement settingsTitle;

    // ====================== ======================
    // Vien.Pham added EditCategories Elements

    @FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[2]")
    WebElement eleEditCategory;
    @FindBy(xpath = "//*[@id=\"m-ce-systemContainer\"]/h3/text()")
    WebElement eleEditCategoryTitle;
    @FindBy(xpath = "//*[@id=\"edit-category-container\"]/div[1]")
    WebElement eleEditCategoryGuide;
    @FindBy(id = "cat-edit-btn")
    WebElement eleEditCategoryPen;
    @FindBy(id = "cat-trash-btn")
    WebElement eleEditCategoryTrash;
    @FindBy(id = "m-ce-cancelBtn")
    WebElement eleEditCategoryCancelBtn;
    @FindBy(id = "category-updateBtn")
    WebElement eleEditCategorySaveBtn;
    @FindBy(xpath = "//img[@id='modal-close-categoryModel-2Dd9bM38sb25ObfMVSJG6Ui8tLVE205c']")
    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown category')]")
    List<WebElement> listOfCategoryDropdown;

    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory')]//div[text()='Add New Category']")
    List<WebElement> listOfAddNewCategory;

    @FindBy(xpath = "//table[@id=\"todo-table\"]//tr[1][contains(@class,\"newRow\")]/td[3]//div[@class=\"item act_item\"]")
    WebElement addNewCategoryEle;
    /*
    Elements for create a Category
    Create by: Minh.Nguyen & Thuan.Duong
    Update: Doai.Tran
     */

    @FindBy(xpath = "/*//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryCombobox;
    // Create Category
    @FindBy(xpath = "//*[@id='category-dropdown']/div[@class='text']")
    private WebElement eleCategoryComboBox;

    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']//div[@class='menu']/div[1]")
    private WebElement addNewCategoryMenuEle;

    @FindBy(id = "category-name")
    private WebElement categoryNameFieldOnFormEle;

    @FindBy(xpath = "//*[@id='category-color']")
    private WebElement categoryColorFieldOnFromEle;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li[4]")
    private WebElement detailCateColorEle;
    @FindBy(id = "category-addBtn")
    private WebElement eleIdBtnAddCategory;

    //    @FindBy(xpath = "//*[@class='ui dropdown category todo-bulkDdl ']")
    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory todo-category todo-bulkDdl')]")
    private List<WebElement> dropdownCategoryEle;

    @FindBy(id = "todo-table")
    private WebElement tblXpathTodoTable;
    @FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div/button")
    private WebElement eleCategoryText;

    @FindBy(xpath = "//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div/div")
    private WebElement eleIndiCategoryText;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li")
    private WebElement categoryColors;

    //  Old Xpath: @FindBy(xpath = "//div[contains(@class,'ce-parent todo-modal-container')]/div/h3")
    @FindBy(xpath = "//label[contains(@id,'m-categoryModel') and contains(@id,'title-text')]")
    private WebElement idTitleCategory;

    @FindBy(xpath = "//*[@id='setup-component-body']/div/div[1]//p[contains(text(),'Not a valid name.')]")
    private WebElement xpathRequiredDataCategoryName;

    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li")
    private WebElement xpathAllCategoryColor;
    @FindBy(xpath = "//p[contains(text(),'Category name already existed')]")
    private WebElement xpathCategoryExistedText;
    @FindBy(xpath = "//div[contains(text(),'Select Category')]")
    private WebElement containsSelectCategoryText;
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[1]/td[7]/img")
    private WebElement imgListTodoPage;


    @FindBy(xpath = "//input[contains(@id,'forge-InputBox')]")
    private List<WebElement> listOfCategoriesItemEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-trash-btn\")]")
    private List<WebElement> listOfEditTrashEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-edit-btn\")]")
    private List<WebElement> listOfEditPenEle;

    @FindBy(xpath = "//div[@id=\"category-dropdown-menu\"]/div[@class=\"\"]")
    private List<WebDriver> listOfCategoriesDropdownTableEle;

    @FindBy(xpath = "//div[contains(@class,'au-modal-container modalTransition-popUp-container')]//button[contains(text(),'Cancel')]")
    private WebElement cancelDeletedToDoButtonEle;

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show']/div[@class = 'fl-a-dismiss auvicon-line-circle-ex'] ")
    private WebElement successToastMesCloseIconEle;

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-orange fl-a-container-show']//p[@class = 'fl-a-text']")
    private WebElement warningToastMesDescriptionEle;

    @FindBy(xpath = "//*[@class = 'header-userName']")
    private WebElement userNameHeaderEle;

    @FindBy(xpath = "//*[@class='progress-overlay']")
    private WebElement progressingDiv;

    @FindBy(xpath = "//img[@class='header-auvenirLogo']")
    private WebElement eleAuvenirHeaderImg;

    public WebElement getEleAuvenirHeaderImg() {
        return eleAuvenirHeaderImg;
    }

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show'] //div[@class='send-message-success-alert']/span")
    private WebElement successToastMesDescriptionEle;

    private String termsPrivacyCookieText = "//div[@id='marketing-header']//div[@class='ui center aligned header header-main-text']";
    private List<String> tabs = null;

    @FindBy(xpath = "//*[@id='language-flag']/button")
    private WebElement changeLanguageBTN;
    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement loginBTN;
    @FindBy(xpath = "//form[@class='ui form login-form']//input[@name='email']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//form[@class='ui form login-form']//input[@name='password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//form[@class='ui form login-form']//button")
    private WebElement submitBTN;
    @FindBy(className = "ui label userAligment")
    private WebElement profileLink;
    @FindBy(xpath = "//div[@class='menu transition visible']//div[2]/span")
    private WebElement logoutBTN;

    public void verifyFooterOfHomepage() {
        boolean isAuvenirIncTxt, isTermsOfServiceLnk, isTermsOfServiceDotTxt, isPrivacyStatementLnk, isPrivacyStatementDotTxt, isCookieNoticeLnk =
                false;
        isAuvenirIncTxt = validateDisPlayedElement(eleAuvenirIncTxt, "eleAuvenirIncTxt");
        if (!isAuvenirIncTxt) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("eleAuvenirIncTxt is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isTermsOfServiceLnk = validateDisPlayedElement(eleTermsOfServiceLnk, "eleTermsOfServiceLnk");
        if (!isTermsOfServiceLnk) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("eleTermsOfServiceLnk is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isTermsOfServiceDotTxt = validateDisPlayedElement(eleTermsOfServiceDotTxt, "eleTermsOfServiceDotTxt");
        if (!isTermsOfServiceDotTxt) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("eleTermsOfServiceDotTxt is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isPrivacyStatementLnk = validateDisPlayedElement(elePrivacyStatementLnk, "elePrivacyStatementLnk");
        if (!isPrivacyStatementLnk) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("elePrivacyStatementLnk is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isPrivacyStatementDotTxt = validateDisPlayedElement(elePrivacyStatementDotTxt, "elePrivacyStatementDotTxt");
        if (!isPrivacyStatementDotTxt) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("elePrivacyStatementDotTxt is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        isCookieNoticeLnk = validateDisPlayedElement(eleCookieNoticeLnk, "eleCookieNoticeLnk");
        if (!isCookieNoticeLnk) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("eleCookieNoticeLnk is not displayed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
        if (isAuvenirIncTxt && isTermsOfServiceLnk && isTermsOfServiceDotTxt && isPrivacyStatementLnk && isPrivacyStatementDotTxt && isCookieNoticeLnk) {
            NXGReports.addStep("verify Footer.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyTermsOfServiceLink() {
        try {
            getLogger().info("Verify Terms of service link.");
            boolean isCheckTermOfService = false;
            hoverElement(eleTermsOfServiceLnk, "hover terms of service link");
            clickElement(eleTermsOfServiceLnk, "click to eleTermsOfServiceLnk");
            getLogger().info("verify texts are rendered.");
            switchToOtherTab(1);
            waitForVisibleOfLocator(By.xpath(termsPrivacyCookieText));
            WebElement terms = findWebElementByXpath(termsPrivacyCookieText);
            isCheckTermOfService = validateElementText(terms, "Terms of Service");
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)).close();
            Thread.sleep(smallTimeOut);
            if (isCheckTermOfService) {
                NXGReports.addStep("verify Terms Of Service Link.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify Terms Of Service Link.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public void verifyPrivacyStateLink() {
        try {
            boolean isPrivacyState = false;
            getLogger().info("Verify Pricacy statement link.");
            switchToOtherTab(0);
            clickElement(elePrivacyStatementLnk, "click to elePrivacyStatementLnk");
            switchToOtherTab(1);
            WebElement privacy = findWebElementByXpath(termsPrivacyCookieText);
            isPrivacyState = validateElementText(privacy, "Privacy Policy");
            tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)).close();
            Thread.sleep(smallTimeOut);
            if (isPrivacyState) {
                NXGReports.addStep("verify Privacy State Link.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("verify Privacy State Link.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    public void verifyCookieNotice() {
        try {
            boolean isCheckCookieNotice = false;
            getLogger().info("verify cookie notices page.");
            switchToOtherTab(0);
            clickElement(eleCookieNoticeLnk, "click to eleCookieNoticeLnk");
            switchToOtherTab(1);
            WebElement cookie = findWebElementByXpath(termsPrivacyCookieText);
            isCheckCookieNotice = validateElementText(cookie, "Cookie Notice");
            if (isCheckCookieNotice) {
                NXGReports.addStep("verify Cookie Notice.", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify Cookie Notice.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * @param webElement
     * @param elementName
     * @param waitTime
     */
    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            WebDriverWait sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            NXGReports.addStep(elementName + " is visibility.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(elementName + " is not visibility.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
    public boolean validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check rendered of text: " + elementText.trim());
            getLogger().info("Actual Text is displayed: " + getText(webElement).trim());
            Assert.assertEquals(getText(webElement).trim(), elementText.trim());
            NXGReports.addStep(elementText + " rendered", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("AssertionError: " + elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            error.getMessage());
            return false;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Exception: " + elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    /**
     * Create by Minh.Nguyen on June 19, 2017
     *
     * @param xpathElement
     * @return Web element by xpath
     */
    public WebElement findWebElementByXpath(String xpathElement) {
        WebElement resultWebElement = null;
        try {
            getLogger().info("The xpath of web element = " + xpathElement);
            resultWebElement = getDriver().findElement(By.xpath(xpathElement));
            NXGReports.addStep("Find web element by xpath", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Find web element by xpath", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
        return resultWebElement;
    }

    /**
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public boolean validateDisPlayedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify Displayed of: " + elementName);
        try {
            element.isDisplayed();
            getLogger().info("Element : " + elementName + " is presented");
            NXGReports.addStep("Element : " + elementName + " is presented.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element + "is not presented");
            NXGReports.addStep("Element : " + elementName + "is not presented", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */

    public boolean validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify enabled of: " + elementName);
        try {
            element.isEnabled();
            getLogger().info("Element : " + elementName + "is enable");
            NXGReports.addStep(elementName + " is enable.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + elementName + "is not enable.");
            NXGReports.addStep("Element : " + elementName + "is not enable", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify selected of: " + elementName);
        try {
            element.isSelected();
            getLogger().info("Element : " + element.getText() + "is selected.");
            NXGReports.addStep("Element: " + elementName + " is selected.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() + "is not selected.");
            NXGReports
                    .addStep("Element : " + elementName + "is not selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateNotSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify not selected of: " + elementName);
        try {
            if (!element.isSelected()) {
                getLogger().info("Element : " + element.getText() + "is not selected.");
                NXGReports.addStep("Element : " + elementName + " is not selected.", LogAs.PASSED, null);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() + "is selected.");
            NXGReports.addStep("Element : " + elementName + "is selected", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    public boolean validateMaxlenght(WebElement webElement, String webElementName, int maxLength) {
        try {
            String inputTextwithMaxLength = randomCharacters(maxLength);
            getLogger().info("Verify input with max length with " + maxLength + " characters");
            clickElement(webElement, webElementName);
            clearTextBox(webElement, webElementName);
            webElement.sendKeys(inputTextwithMaxLength);
            String actualTextInput = webElement.getAttribute("value");
            Assert.assertEquals(actualTextInput, inputTextwithMaxLength, String.format("%s cannot input %d characters", webElementName, maxLength));
            NXGReports.addStep("input with max length with " + maxLength + "character", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports.addStep("input with max length with " + maxLength + "character", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), error.getMessage());
            return false;
        }
    }

    /*
            Improvement to detect value: true/ false after take actions
            Updated by: Doai.Tran 8/5/2017
             */
    public void scrollPageUp() {
        getLogger().info("Try to scroll Page up.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
            NXGReports.addStep("Scrolled Page up.", LogAs.PASSED, null);

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page up unsuccessfully.");
            NXGReports.addStep("scroll Page up unsuccessfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /*
    Method to scrollPageDown
     */
    public void scrollPageDown() {
        getLogger().info("Try to scroll Page down.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            NXGReports.addStep("Scrolled Page down.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page down unsuccessfully.");
            NXGReports.addStep("scroll Page down unsuccessfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForVisibleElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForVisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("Element: " + elementName + " is visible.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            //NXGReports.addStep("Element: " + elementName + " is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports
                    .addStep("Element: " + elementName + " is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be present by locator.
     */
    public boolean waitForPresentOfLocator(By by) {
        getLogger().info("Try to waitForPresentOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            NXGReports.addStep("Element is presented.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not present.");
            NXGReports.addStep("Element is not present.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible by locator.
     */
    public boolean waitForVisibleOfLocator(By by) {
        getLogger().info("Try to waitForVisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            NXGReports.addStep("Element is visible.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible.");
            NXGReports.addStep("Element is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * created by: minh.nguyen
     *
     * @Description In order to wait element to be visible by locator with seconds input.
     */
    public boolean waitForVisibleOfLocator(By locator, int seconds) {
        getLogger().info("Try to waitForVisibleOfLocator by seconds");
        boolean isResult = false;
        try {
            int i = 0;
            while (i < seconds) {
                try {
                    getDriver().findElement(locator);
                    isResult = true;
                    NXGReports.addStep("Try to waitForVisibleOfLocator by seconds", LogAs.PASSED, null);
                    break;
                } catch (Exception ex) {
                }
                try {
                    Thread.sleep(smallTimeOut);
                    i++;
                } catch (Exception e) {

                }
            }
            if (!isResult) {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Element is not visible, try to waitForVisibleOfLocator by seconds.", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            return isResult;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible, try to waitForVisibleOfLocator by seconds.");
            NXGReports.addStep("Element is not visible, try to waitForVisibleOfLocator by seconds.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return isResult;
        }
    }

    /**
     * @Description In order to wait element to be invisible by locator.
     */
    public boolean waitForInvisibleOfLocator(By by) {
        getLogger().info("Try to waitForInvisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            NXGReports.addStep("eElement is invisible.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible.");
            NXGReports
                    .addStep("eElement: is not invisible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be clickable by locator.
     */
    public boolean waitForClickableOfLocator(By by) {
        getLogger().info("Try to waitForClickableOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            NXGReports.addStep("eElement is clickable.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable.");
            NXGReports
                    .addStep("eElement: is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForClickableOfElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForClickableOfElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            NXGReports.addStep("Element: " + elementName + " is  clickable.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + element.getText());
            //NXGReports.addStep("Element: " + elementName + " is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep("Element: " + elementName + " is not clickable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible.
     * @Author: minh.nguyen
     */
    public void waitForClickableOfElement(WebElement element) {
        getLogger().info("Try to waitForClickableOfElement: " + element);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + e.getMessage());
            NXGReports.addStep("Element is not clickable.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForInvisibleElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForInvisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            NXGReports.addStep("Element: " + elementName + " is invisible.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible on Element: " + elementName);
            NXGReports.addStep("Element: " + elementName + " is not invisible.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean validateDisabledElement(WebElement element, String elementName) {
        getLogger().info("verify disable of: " + elementName);
        try {
            if (!(element.isEnabled())) {
                getLogger().info(element.getTagName() + " is disabled");
                NXGReports.addStep("Element: " + elementName + " is disable.", LogAs.PASSED, null);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(elementName + " is  not disabled");
            NXGReports.addStep("Element: " + elementName + " is not disabled.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /*
    Method to go to setting page for Admin, Auditor, Client
     */
    public void navigateToSettingsPage() {
        getLogger().info("navigate to Admin Setting page.");
        try {
            waitForClickableOfElement(dashboardUserNameEle, "dashboardUserNameEle");
            clickElement(dashboardUserNameEle, "click to dashboardUserNameEle");
            waitForClickableOfElement(settingsTabEle, "dashboardUserNameEle");
            clickElement(settingsTabEle, "click to settingsTabEle");
            boolean result = validateElementText(settingsTitle, "Settings");
            Assert.assertTrue(result, "The Settings page should be navigated.");
            NXGReports.addStep("Go to settings page successfully.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to go to setting page.");
            NXGReports.addStep("Unable to go to setting page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click
     * @Description: Click on element
     */
    public boolean clickElement(WebElement element, String elementName) {
        getLogger().info("Try to ClickElement: " + elementName);
        try {
            waitForClickableOfElement(element, "click to " + elementName);
            element.click();
            NXGReports.addStep("Clicked on element: " + elementName, LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            System.out.println("exception: " + e.getMessage());
            getLogger().info("Unable to Click on: " + elementName);
            //NXGReports.addStep("Unable to Click on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep("Unable to Click on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    /**
     * @Description: Click on element
     * @Author: minh.nguyen
     */
    public void clickElement(WebElement element) {
        getLogger().info("Try to ClickElement: " + element);
        try {
            waitForClickableOfElement(element);
            element.click();
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to Click on: " + e.getMessage());
            NXGReports.addStep("Unable to Click on: ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click and hold
     * @Description: Click and Hold on element
     */
    public void clickAndHold(WebElement element, String elementName) {
        getLogger().info("Try to ClickAndHold: " + elementName);
        try {
            if (GenericService.sBrowserData.equals("chr.")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.click(element);
                actions.perform();
            } else
                element.click();
            NXGReports.addStep("Clicked and Hold on element: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to ClickAndHold on: " + elementName);
            NXGReports.addStep("Unable to ClickAndHold on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to hover to
     * @Description: Hover on element
     */
    public void hoverElement(WebElement element, String elementName) {
        getLogger().info("Try to hoverElement: " + elementName);
        try {
            if ((GenericService.sBrowserData).equals("chr.")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.build().perform();
            }
            NXGReports.addStep("Hover on element: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to hoverElement on: " + elementName);
            NXGReports.addStep("Unable to hoverElement on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param text        The content of text that we want to input.
     * @param elementName Name of element that we want to input value.
     * @Description: Send a String to textBox.
     * @Description: Send a String to textBox.
     */
    public boolean sendKeyTextBox(WebElement element, String text, String elementName) {
        getLogger().info("Try to sendKey on : " + elementName);
        try {
            waitForClickableOfElement(element, "wait for click to " + elementName);
            //element.click();
            element.clear();
            waitForClickableOfElement(element, "wait for click to " + elementName);
            element.sendKeys(text);
            NXGReports.addStep("Send text: " + text + " on element: " + elementName, LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendKey on: " + elementName);
            getLogger().info(e);
            //NXGReports.addStep("Unable to sendKey on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            NXGReports.addStep("Unable to sendKey on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to input value.
     * @Description: Clear all Strings to textBox.
     * @Description: Clear all Strings to textBox.
     */
    public void clearTextBox(WebElement element, String elementName) {
        getLogger().info("Try to clear text on : " + elementName);
        try {
            element.clear();
            NXGReports.addStep("Cleared text: on element: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to clear on: " + elementName);
            NXGReports.addStep("Unable to clear on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to click
     * @Description: Click on checkbox
     */
    public void clickOnCheckBox(WebElement element, String elementName) {
        getLogger().info("Try to click on checkbox: " + elementName);
        try {
            element.click();
            NXGReports.addStep("Click on checkbox: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to click on checkbox element: " + elementName);
            NXGReports
                    .addStep("Unable to click on checkbox: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param selText     Visible text that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public boolean selectByVisibleText(WebElement element, String selText, String elementName) {
        getLogger().info("Try to selectByVisibleText on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selText);
            NXGReports.addStep("selectByVisibleText on checkbox: " + elementName, LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByVisibleText on element: " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param selValue    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectByValue(WebElement element, String selValue, String elementName) {
        getLogger().info("Try to selectByValue on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByValue(selValue);
            NXGReports.addStep("selectByValue on checkbox: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByValue on element: " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param selIndex    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectByIndex(WebElement element, int selIndex, String elementName) {
        getLogger().info("Try to selectByIndex on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByIndex(selIndex);
            NXGReports.addStep("selectByIndex on checkbox: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to selectByIndex on element: " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     * @Description: Send TabKey
     * @Description: Send TabKey
     */
    public void sendTabkey(WebElement element, String elementName) {
        getLogger().info("Try to sendTabkey: " + elementName);
        try {
            element.sendKeys(Keys.TAB);
            NXGReports.addStep("sendTabkey on element: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendTabkey on: " + elementName);
            NXGReports.addStep("Unable to sendTabkey on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public void sendEnterkey(WebElement element, String elementName) {
        getLogger().info("Try to sendEnterkey: " + elementName);
        try {
            element.sendKeys(Keys.ENTER);
            NXGReports.addStep("sendEnterkey on element: " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendEnterkey on: " + elementName);
            NXGReports.addStep("Unable to sendEnterkey on: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    /**
     * @param element                element defined on page class
     * @param attributeName          Attribute that we want to validate
     * @param expectedAttributeValue Expected value that we want to validate
     */
    public boolean validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue) {
        getLogger().info("verify Attribute " + attributeName + " of: " + element.toString());
        String actualAttributeValue = null;
        try {
            actualAttributeValue = element.getAttribute(attributeName).trim();
            getLogger().info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
            if (actualAttributeValue.equals(expectedAttributeValue)) {
                getLogger().info(element.getTagName() + " has attribute " + actualAttributeValue);
                NXGReports.addStep(element.getTagName() + " has attribute " + actualAttributeValue, LogAs.PASSED, null);
                return true;
            } else {
                throw new Exception(String.format("Expected ['%s'] but found ['%s']", expectedAttributeValue, actualAttributeValue));
            }
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            getLogger().info("Error: " + element.getTagName() + " has attribute not as expected with actual: " + actualAttributeValue);
            NXGReports.addStep(element.getTagName() + " has attribute not as expected with actual:" + actualAttributeValue, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element        element defined on page class
     * @param attributeName  AttributeCSSS that we want to validate
     * @param attributeValue Expected value that we want to validate
     */
    public boolean validateCssValueElement(WebElement element, String attributeName, String attributeValue) throws InvalidElementStateException {
        getLogger().info("verify style with " + attributeName);
        try {
            getLogger().info("CurrentL: " + element.getCssValue(attributeName).trim());
            Assert.assertEquals(element.getCssValue(attributeName).trim(), attributeValue);
            NXGReports.addStep("Element has expected style with  " + attributeName, LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element has a unexpected style " + attributeName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element has a unexpected style  " + attributeName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }

    }

    public boolean validateIsNotDisPlayedElement(WebElement element, String elementName) {
        getLogger().info("Verify element is not displayed of: " + elementName);
        try {
            if (!element.isDisplayed()) {
                NXGReports.addStep(elementName + " is NOt displayed", LogAs.PASSED, null);
                return true;
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(elementName + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;

            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep(elementName + " is displayed", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }

    }

    /**
     * @param eleGetText  Element defined in page class
     * @param elementName The text name of element
     * @return The text of web element
     */
    public String getTextByJavaScripts(WebElement eleGetText, String elementName) {
        getLogger().info("Get text by javascript of element " + elementName);
        String textOfElement = "";
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            textOfElement = (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;", eleGetText);
            NXGReports.addStep("Get text by javascript of element " + elementName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Get text by javascript of element " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            getLogger().info(e.getMessage());
        }
        return textOfElement;
    }

    public void verifySortDataGrid(List<WebElement> elementRowValue, WebElement elementSortIcon) {
        try {
            List<String> listToDoTaskName = new ArrayList<String>();
            List<String> listSortedToDoTaskName;
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            listSortedToDoTaskName = listToDoTaskName;
            Collections.sort(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Ascending sort is NOT as expected");
            NXGReports.addStep("The data on Data Grid is sorted in ascending order successfully", LogAs.PASSED, null);
            Collections.reverse(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Descending sort is NOT as expected");
            NXGReports.addStep("The data on Data Grid is sorted in descending order successfully", LogAs.PASSED, null);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot sort data on Data Grid View.");
            NXGReports.addStep("The data on Data Grid is sorted unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void chooseCategoryColorInPopup() throws Exception {
        hoverElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColor));
        waitForClickableOfElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
        clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColorContainer));
        waitForClickableOfElement(detailCateColorEle, "detailCateColorEle");
        clickElement(detailCateColorEle, "click to detailCateColorEle");
    }

    public void clickNewCategoryCreateButton() throws Exception {
        waitForClickableOfElement(eleIdBtnAddCategory, "Add Category Button");
        waitForJSandJQueryToLoad();
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpDivCategoryModel));
        clickElement(eleIdBtnAddCategory, "Add Category Button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }

    /**
     * categoryMode = categoryIndiMode: create new category from list ToDoPage
     * categoryMode = "": create new category in a ToDoPage
     */


    public void createNewCategory(String categoryNameInput) throws Exception {
        Thread.sleep(smallerTimeOut);
        String categoryName = null;
        if (categoryNameInput == "") {
            categoryName = "Category " + randomNumber();
        } else {
            categoryName = categoryNameInput;
        }
        getLogger().info("Adding new category...");
        navigateToAddNewCategory();
        waitForClickableOfElement(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
        waitForJSandJQueryToLoad();
        clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
        sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
        chooseCategoryColorInPopup();
        clickNewCategoryCreateButton();
        //        closeSuccessToastMes();
    }

    public void selectCategory(String categoryName) {
        try {
            int categoryExist = checkCategoryExist(categoryName);
            if (categoryExist != -1) {
                clickElement(dropdownCategoryEle.get(0).findElements(By.xpath(".//div[@class='item']")).get(categoryExist));
            } else {
                sendTabkey(dropdownCategoryEle.get(0), "dropdownCategoryEle");
                createNewCategory(categoryName);
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Create category.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }

    }

    public int checkCategoryExist(String categoryName) {
        int index = -1;
        try {
            Thread.sleep(3000);
            clickElement(dropdownCategoryEle.get(0), "click to dropdownCategoryEle");
            List<WebElement> listCategory = dropdownCategoryEle.get(0).findElements(By.xpath(".//div[@class='item']"));
            for (int i = 0; i < listCategory.size(); i++) {
                if (listCategory.get(i).getAttribute("textContent").equals(categoryName)) {
                    index = i;
                    break;
                }
            }
            return index;
        } catch (Exception e) {
            return index;
        }
    }

    public boolean chooseCategoryByNameFromDll(String categoryName) {
        boolean isCheckCategoryName = false;
        getLogger().info("Choose category by name from dropdownlist");
        try {
            List<WebElement> listCategoryName = new ArrayList<>();
            hoverElement(dropdownCategoryEle.get(0), "dropdownCategoryEle");
            waitForClickableOfElement(dropdownCategoryEle.get(0), "dropdownCategoryEle");
            waitForJSandJQueryToLoad();
            waitForVisibleElement(imgListTodoPage, "wait for imgListTodoPage");
            clickElement(dropdownCategoryEle.get(0), "click to dropdownCategoryEle");
            waitForVisibleElement(eleIndiCategoryText, "eleIndiCategoryText");
            listCategoryName = tblXpathTodoTable.findElements(By.xpath(dropdownCategoryToDoBulkDllDivDiv));
            for (WebElement categoryNameEle : listCategoryName) {
                String strSearchValue = "";
                try {
                    waitForVisibleElement(categoryNameEle, "eleIndiCategoryText Get category name in list");
                    strSearchValue = categoryNameEle.getText();
                } catch (Exception ex) {
                }
                getLogger().info("SearchValue = " + strSearchValue);
                if (strSearchValue.equals(categoryName)) {
                    clickElement(categoryNameEle, "click to " + categoryNameEle);
                    isCheckCategoryName = true;
                    NXGReports.addStep("Choose category by name from dropdownlist", LogAs.PASSED, null);
                    break;
                }
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose category by name from dropdownlist", LogAs.FAILED, null);
        }
        return isCheckCategoryName;
    }

    public boolean countCategoryColor() {
        boolean isCountColor = false;
        waitForClickableOfElement(categoryColors, "categoryColors");
        return isCountColor;
    }

    public int randomNumber() {
        Random randNum = new Random();
        int intRanNum = randNum.nextInt(10000) + 1;
        return intRanNum;
    }

    public void verifyDefaultValueOfElement(WebElement element, String attributeName, String defaultValue) {
        waitForVisibleElement(element, "Element");
        validateDisPlayedElement(element, "Element");
        validateAttributeElement(element, attributeName, defaultValue);
    }

    public void verifyHoverElement(WebElement element, String cssValueName, String expectedCssValue) {
        hoverElement(element, "Element");
        validateCssValueElement(element, cssValueName, expectedCssValue);
    }

    /**
     * @param elements List<WebElement></WebElement>
     * @return true: All checkbox on Element list be selected
     * @throws Exception
     */
    public boolean verifyCheckAllCheckboxList(List<WebElement> elements, String elementListName) throws Exception {
        try {
            for (int i = 0; i < elements.size(); i++) {
                if (!elements.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is NOT checked");
                    throw new Exception();
                } else {
                    System.out.println("Checkbox is selected:? " + elements.get(i).isSelected());
                }
            }
            getLogger().info("Check box icons are selected all.");
            NXGReports.addStep("All checkbox: " + elementListName + " is selected", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("All checkbox: " + elementListName + " is NOT selected", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param elements List<WebElement></WebElement>
     * @return true: All checkbox on Element list be not selected
     * @throws Exception
     */
    public boolean verifyUnCheckAllCheckboxList(List<WebElement> elements, String elementListName) throws Exception {
        try {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).isSelected()) {
                    AbstractService.sStatusCnt++;
                    getLogger().info("Check box icon at position " + i + " is checked");
                    throw new Exception();
                } else {
                    System.out.println("Checkbox is not selected:? " + elements.get(i).isSelected());
                }
            }
            getLogger().info("Check box icons are not selected all.");
            NXGReports.addStep("All checkbox: " + elementListName + " is NOT selected", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Check box icons are  selected all.");
            NXGReports.addStep("All checkbox: " + elementListName + " is selected", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     The element that we want to check.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean hoverAndWaitForClickableOfElement(WebElement element, String elementName) {
        getLogger().info("Try to HoverAnd waitForClickableOfElement: " + elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            NXGReports.addStep("Element: " + elementName + " is  clickable.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + element.getText());
            NXGReports.addStep("Element: " + elementName + " is not clickable.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     The element that we want to check.
     * @param verifyText  The expected text should be displayed.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean HoverAndWaitForPresentOfElement(WebElement element, String verifyText, String elementName) {
        getLogger().info("Try to waitForClickableOfElement: " + elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.textToBePresentInElement(element, verifyText));
            NXGReports.addStep("Element: " + elementName + " is  presented and have the correct text.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + element.getText());
            NXGReports.addStep("Element: " + elementName + " is not presented and have the incorrect text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     The element that we want to check.
     * @param elementName Name of element we are verifying.
     * @return
     */
    public boolean HoverAndWaitForVisibleOfElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForClickableOfElement: " + elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            NXGReports.addStep("Element: " + elementName + " is  visible.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + element.getText());
            NXGReports
                    .addStep("Element: " + elementName + " is not visible.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
            return false;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryTitle() {
        boolean isCheckTitle = false;
        getLogger().info("Verify category title");
        try {
            navigateToAddNewCategory();
            waitForVisibleElement(idTitleCategory, "wait idTitleCategory");
            String strCategoryTitle = idTitleCategory.getText();
            if (categoryTitleOfAddNew.equals(strCategoryTitle)) {
                isCheckTitle = true;
                NXGReports.addStep("Verify category title", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify category title", LogAs.FAILED, null);
            }
            return isCheckTitle;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category title", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckTitle;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryDefaultValue() {
        boolean isCheckDetaultValue = false;
        getLogger().info("Verify category default value");
        try {
            waitForClickableOfElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            String strCateDefaultValue = getTextByJavaScripts(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
            if (strCateDefaultValue.equals("")) {
                isCheckDetaultValue = true;
                NXGReports.addStep("Verify category default value", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify category default value", LogAs.FAILED, null);
            }

            return isCheckDetaultValue;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify category default value", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckDetaultValue;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyHoverClickCategoryName() {
        boolean isCheckBorderColor = false;
        getLogger().info("Verify hover and click to category name");
        try {
            // Green color
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            //sendKeyTextBox(categoryNameFieldOnFormEle,"test color", "send key to test color");
            isCheckBorderColor = validateCssValueElement(categoryNameFieldOnFormEle, border, greenColor);
            getLogger().info("isCheckBorderColor = " + isCheckBorderColor);
            if (isCheckBorderColor) {
                NXGReports.addStep("Verify hover and click to category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports
                        .addStep("Verify hover and click to category name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
            return isCheckBorderColor;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify hover and click to category name", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(ex.getMessage());
            return isCheckBorderColor;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyShowAllTextCategoryName() {
        boolean isCheckShowAllText = false;
        getLogger().info("Verify check show all text of category name");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, categoryNameAllText, "send key to categoryNameFieldOnFormEle");
            String strGetCategoryName = getTextByJavaScripts(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
            if (categoryNameAllText.equals(strGetCategoryName)) {
                isCheckShowAllText = true;
                NXGReports.addStep("Verify check show all text of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            }
            return isCheckShowAllText;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckShowAllText;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryNameRequiredData() {
        boolean isCheckRequiredData = false;
        getLogger().info("Verify to check required data of category name");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
            boolean isCheckDisplay = waitForVisibleElement(xpathRequiredDataCategoryName, "wait for visible xpathRequiredDataCategoryName");
            getLogger().info("isCheckDisplay = " + isCheckDisplay);
            String strRequiredDataMessage = xpathRequiredDataCategoryName.getText();
            getLogger().info("strRequiredDataMessage = " + strRequiredDataMessage);
            if (strRequiredDataMessage.equals(notValidNameMessage)) {
                isCheckRequiredData = true;
                NXGReports.addStep("Verify to check required data of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check required data of category name", LogAs.FAILED, null);
            }
            return isCheckRequiredData;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check required data of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckRequiredData;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryNameMaxLength() {
        boolean isCheckMaxLength = false;
        getLogger().info("Verify to check max length of category name");
        try {
            isCheckMaxLength = validateMaxlenght(categoryNameFieldOnFormEle, "Category Name TextBox", maxLenghtOneHundred);
            getLogger().info("isCheckMaxLength = " + isCheckMaxLength);
            if (isCheckMaxLength) {
                NXGReports.addStep("Verify to check max length of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check max length of category name", LogAs.FAILED, null);
            }
            return isCheckMaxLength;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check max length of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckMaxLength;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryNameInputNumber() {
        boolean isCheckMaxLength = false;
        getLogger().info("Verify to check the number value of category name");
        try {
            waitForClickableOfElement(categoryNameFieldOnFormEle, "wait for click categoryNameFieldOnFormEle");
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, numberSequence, "send key to categoryNameFieldOnFormEle");
            String strNumberValue = getTextByJavaScripts(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
            if (strNumberValue.equals(numberSequence)) {
                isCheckMaxLength = true;
                NXGReports.addStep("Verify to check the number value of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check the number value of category name", LogAs.FAILED, null);
            }

            return isCheckMaxLength;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check the number value of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckMaxLength;
        }
    }

    public String randomCharacters(int maxLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String results = sb.toString();
        return results;
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryNameSpecialCharacter() {
        boolean isCheckSpecialCharacter = false;
        getLogger().info("Verify to check special character of category name");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear text categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, specialCharacter, "send special character to categoryNameFieldOnFormEle");
            clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
            waitForVisibleElement(xpathRequiredDataCategoryName, "wait for visible xpathRequiredDataCategoryName");
            String strRequiredDataMessage = xpathRequiredDataCategoryName.getText();
            if (strRequiredDataMessage.equals(notValidNameMessage)) {
                isCheckSpecialCharacter = true;
                NXGReports.addStep("Verify to check special character of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check special character of category name", LogAs.FAILED, null);
            }
            return isCheckSpecialCharacter;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check special character of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckSpecialCharacter;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyCategoryColorAllQuantityColor() {
        boolean isCheckAllQuantityColor = false;
        getLogger().info("Verify to check all quantity color of category color");
        try {
            waitForVisibleElement(xpathAllCategoryColor, "wait for visible xpathAllCategoryColor");
            List<WebElement> listCategoryColor = getDriver().findElements(By.xpath("//*[@id=\"category-color-container\"]/ul/li"));
            if (listCategoryColor.size() == 10) {
                isCheckAllQuantityColor = true;
                NXGReports.addStep("Verify to check all quantity color of category color", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to check all quantity color of category color", LogAs.FAILED, null);
            }
            return isCheckAllQuantityColor;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to check all quantity color of category color", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckAllQuantityColor;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyChoosedCategoryColor() {
        boolean isCheckChoosedColor = false;
        getLogger().info("Verify to choose the category color");
        try {
            // blue color
            chooseCategoryColorByColorName("#2b4875");
            isCheckChoosedColor = validateCssValueElement(categoryColorFieldOnFromEle, background, blueColor);
            if (isCheckChoosedColor) {
                NXGReports.addStep("Verify to choose the category color", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to choose the category color", LogAs.FAILED, null);
            }
            return isCheckChoosedColor;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to choose the category color", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckChoosedColor;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public void chooseCategoryColorByColorName(String colorName) {
        boolean isCheckAllQuantityColor = false;
        getLogger().info("Choose category color by color name");
        try {
            waitForVisibleElement(xpathAllCategoryColor, "wait for visible xpathAllCategoryColor");
            List<WebElement> listCategoryColor = getDriver().findElements(By.xpath("//*[@id=\"category-color-container\"]/ul/li/a"));
            for (WebElement colorNameEle : listCategoryColor) {
                if (colorNameEle.getText().equals(colorName)) {
                    clickElement(colorNameEle, "click to colorNameEle");
                    isCheckAllQuantityColor = true;
                    break;
                }
            }
            if (isCheckAllQuantityColor) {
                NXGReports.addStep("Choose category color by color name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Choose category color by color name", LogAs.FAILED, null);
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Choose category color by color name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyColorCategoryCancelButton() {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify color of Category cancel button");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear text categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, "CreateCancel", "send key to categoryNameFieldOnFormEle");
            isCheckColorCancelButton = verifyColorBackgroundTextBtn(eleEditCategoryCancelBtn, "rgba(151, 147, 147, 1)", "rgba(255, 255, 255, 1)");
            if (isCheckColorCancelButton) {
                NXGReports.addStep("Verify color of Category cancel button", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify color of Category cancel button", LogAs.FAILED, null);
            }
            return isCheckColorCancelButton;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify color of Category cancel button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckColorCancelButton;
        }
    }

    /**
     * Author: minh.nguyen
     * buttonNeedCheck : for example eleEditCategoryCancelBtn
     * backgroundColor: for example "rgba(151, 147, 147, 1)"
     * color: for example "rgba(255, 255, 255, 1)"
     */
    public boolean verifyColorBackgroundTextBtn(WebElement buttonNeedCheck, String backgroundColorBtn, String textColor) {
        boolean isCheckColorCancelButton = false;
        getLogger().info("Verify background and text color of the button " + buttonNeedCheck);
        try {
            isCheckColorCancelButton = validateCssValueElement(eleEditCategoryCancelBtn, backgroundColor, backgroundColorBtn);
            isCheckColorCancelButton = validateCssValueElement(eleEditCategoryCancelBtn, color, textColor);
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return isCheckColorCancelButton;
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyColorCategoryCreateButton() {
        boolean isCheckColorCreateButton = false;
        getLogger().info("Verify color of Category create button");
        try {
            isCheckColorCreateButton = validateCssValueElement(eleIdBtnAddCategory, backgroundColor, "rgba(89, 155, 161, 1)");
            isCheckColorCreateButton = validateCssValueElement(eleIdBtnAddCategory, color, "rgba(255, 255, 255, 1)");
            if (isCheckColorCreateButton) {
                NXGReports.addStep("Verify color of Category create button", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify color of Category create button", LogAs.FAILED, null);
            }
            return isCheckColorCreateButton;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify color of Category create button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckColorCreateButton;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyClickCategoryCancelButton() {
        boolean isCheckCancelClick = false;
        getLogger().info("Verify to click Category cancel button");
        try {
            // click to cancel button
            navigateToAddNewCategory();
            hoverElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");
            waitForClickableOfLocator(
                    By.xpath("//div[contains(@class,'au-modal-container modalTransition-popUp-container')]//button[contains(text(),'Cancel')]"));
            waitForClickableOfElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo Button");
            isCheckCancelClick = clickElement(cancelDeletedToDoButtonEle, "Cancel Delete ToDo button");

            getLogger().info("isCheckCancelClick = " + isCheckCancelClick);
            if (isCheckCancelClick) {
                NXGReports.addStep("Verify to click Category cancel button", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify to click Category cancel button", LogAs.FAILED, null);
            }
            return isCheckCancelClick;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify to click Category cancel button", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckCancelClick;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyNotCompleteCreateCategory() {
        boolean isCheckCreateCateFail = false;
        getLogger().info("Verify not complete to create category");
        try {
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear text categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, "create", "send key to categoryNameFieldOnFormEle");
            //clickElement(eleIdBtnAddCategory, "click to eleIdBtnAddCategory");
            isCheckCreateCateFail = waitForVisibleElement(eleIdBtnAddCategory, "wait for visible eleIdBtnAddCategory");
            if (isCheckCreateCateFail) {
                NXGReports.addStep("Verify not complete to create category", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            }
            return isCheckCreateCateFail;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckCreateCateFail;
        }
    }

    /**
     * Author: minh.nguyen
     */
    public boolean verifyExistedCategory() {
        boolean isCheckExistedCategory = false;
        getLogger().info("Verify existed category");
        try {
            String categoryName = "Existed category " + randomNumber();
            //Thread.sleep(smallerTimeOut);
            waitForJSandJQueryToLoad();
            waitForClickableOfLocator(By.id("category-name"));
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            clearTextBox(categoryNameFieldOnFormEle, "clear categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
            chooseCategoryColorInPopup();
            clickNewCategoryCreateButton();
            navigateToAddNewCategory();
            waitForJSandJQueryToLoad();
            waitForClickableOfLocator(By.id("category-name"));
            clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
            sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
            chooseCategoryColorInPopup();
            clickNewCategoryCreateButton();

            waitForVisibleElement(xpathCategoryExistedText, "wait for xpathCategoryExistedText");
            String strGetExistedMessage = xpathCategoryExistedText.getText();
            if (strGetExistedMessage.equals(existedCategoryName)) {
                isCheckExistedCategory = true;
            }
            if (isCheckExistedCategory) {
                NXGReports.addStep("Verify not complete to create category", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            }
            return isCheckExistedCategory;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify not complete to create category", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckExistedCategory;
        }
    }


    /*
    Author: Vien Pham
     */
    public void hoverElementAndClickToOtherElement(WebElement element1, String elementName1, WebElement element2, String elementName2) {
        getLogger().info("Try to hoverElement: " + elementName1 + " and click to " + elementName2);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element1).moveToElement(element2).click(element2);
            actions.build().perform();
            NXGReports.addStep("Hover and click", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Hover and click", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void editSameMultiItems(String newValue, int numberOfItems) throws Exception {
        int i;
        try {
            for (i = 0; i < numberOfItems; i++) {
                waitForVisibleElement(listOfCategoriesItemEle.get(i), "Category Item " + i);
                hoverElementAndClickToOtherElement(listOfCategoriesItemEle.get(i), "Category Item " + i, listOfEditPenEle.get(i), "Edit Pen " + i);
                sendKeyTextBox(listOfCategoriesItemEle.get(i), newValue, String.format("Category Item %d", i));
                Thread.sleep(smallerTimeOut);
            }
            NXGReports.addStep("Enter new value", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Enter new value", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void removeCategories(int numberOfItems) throws Exception {
        int i;
        try {
            for (i = 0; i < numberOfItems; i++) {
                waitForVisibleElement(listOfCategoriesItemEle.get(i), "Category Item " + i);
                hoverElementAndClickToOtherElement(listOfCategoriesItemEle.get(i), "Category Item " + i, listOfEditTrashEle.get(i), "Trash " + i);
                Thread.sleep(smallTimeOut);
            }
            NXGReports.addStep("Temporary Remove categories", LogAs.PASSED, null);


        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Temporary Remove categories", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));


        }

    }

    /*

    End of Vien Pham.
     */

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForCssValueChanged(WebElement element, String elementName, String cssName, String cssValue) {
        getLogger().info("Try to waitForCssValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualcssValue = element.getCssValue(cssName);
                    System.out.println("Actual Displayed Value: " + actualcssValue);
                    if (actualcssValue.equals(cssValue))
                        return true;
                    else
                        return false;
                }
            });
            return true;
        } catch (Exception e) {
            getLogger().info("CSS Value is not changed");
            return false;
        }
    }

    /*public boolean waitForClassNameChanged(WebElement element, String elementName, String expectedValue) {
        getLogger().info("Try to waitForCLassNameChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualClassName = element.getClass().getName();
                    System.out.println("Actual Displayed Name: " + actualClassName);
                    if (actualClassName.equals(expectedValue))
                        return true;
                    else
                        return false;
                }
            });
            return true;
        } catch (Exception e) {
            getLogger().info("Class name is not changed");
            return false;
        }
    }*/


    /**
     * @param webElement  WebElement
     * @param elementText Text of Element not be presented.
     */
    public boolean validateElementTextNotDisplayed(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            getLogger().info("Actual Text is displayed: " + webElement.getText().trim());
            Assert.assertNotEquals(webElement.getText().trim(), elementText);
            NXGReports.addStep(elementText + " did not rendered", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), error.getMessage());
            return false;
        }
    }

    /**
     * Find the index(position) of Web Element in the list Web Element by attribute value
     *
     * @param listElement List WebElement
     * @param textValue   String text which is compared with each WebElements.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByAttributeValue(List<WebElement> listElement, String textValue) {
        try {
            String actualAttributeValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualAttributeValue = listElement.get(i).getAttribute("value").trim();
                if (actualAttributeValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;
        } catch (Exception e) {
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;
        }
    }

    //[PLAT-2294] Add select date dropdown TanPH 2017/05/15 -- Start
    public boolean isThisDateValid(String dateToValidate, String dateFromat) {

        if (dateToValidate == null || "".equals(dateToValidate)) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
    Method to wait Ajax function on Site be loaded successfully.
     */
    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public boolean waitForDisappearElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForDisappearElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
            NXGReports.addStep("Element: " + elementName + " is disappear.", LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element: " + element.getText() + "is not disappear.");
            NXGReports.addStep("Element: " + elementName + " is not disappear.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    public void waitPageLoad() throws InterruptedException {
        getLogger().info("Just a moment. Page is loading.");
        Thread.sleep(smallerTimeOut);
    }


    /*
    Vien.Pham add for ticket 2291
     */
    public int verifyListOfCurrentCategories(List<WebElement> webElement) {
        int numberOfItemsBefore = 0;
        for (WebElement tdElement : webElement) {
            String isCheckCategory = null;
            try {
                isCheckCategory = tdElement.getAttribute("data-dbdata");
                numberOfItemsBefore++;
            } catch (Exception ex) {
                AbstractService.sStatusCnt++;
            }
        }
        return numberOfItemsBefore;
    }


    /*
    Vien.pham added for 2291
     */
    public void verifyItemsRemovedOrNot(int numberOfItemsBefore, int numberOfItemsbeRemoved, List<WebElement> webElement) {
        int numberOfItemDisplayed = 0;
        int result = numberOfItemsBefore - numberOfItemsbeRemoved;
        try {
            for (WebElement tdElement : webElement) {
                String isCheckCategory = nullChars;
                isCheckCategory = tdElement.getAttribute("data-dbdata");
                if (isCheckCategory == null) {
                    numberOfItemDisplayed = 0;
                    break;
                } else {
                    numberOfItemDisplayed++;
                }
            }

            if (numberOfItemDisplayed == result) {
                NXGReports.addStep("Remove completed ", LogAs.PASSED, null);

            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Remove completed ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }

            System.out.println("Number of items after removed: " + result);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Remove completed ", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }

    }

    /**
     * Find the index(position) of Web Element in the list Web Element by text value
     *
     * @param listElement List WebElement
     * @param textValue   String text which is compared with each WebElements.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByText(List<WebElement> listElement, String textValue) {
        try {
            String actualTextValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualTextValue = listElement.get(i).getText().trim();
                if (actualTextValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;

        } catch (Exception e) {
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;
        }
    }

    /**
     * Find the index(position) of Web Element in the list Web Element by attribute value
     *
     * @param listElement   List WebElement
     * @param textValue     String text which is compared with each WebElements.
     * @param attributeName String attributeName which attribute will be found with get Attribute method.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByAttribute(List<WebElement> listElement, String textValue, String attributeName) {
        try {
            String actualAttributeValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualAttributeValue = listElement.get(i).getAttribute(attributeName).trim();
                if (actualAttributeValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    NXGReports.addStep(String.format("The position of the text name '%s' at %d", textValue, i), LogAs.PASSED, null);
                    return i;
                }
            }
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return -1;

        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            NXGReports.addStep(String.format("Cannot find the text name: %s", textValue), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return -1;
        }
    }

    public boolean closeSuccessToastMes() {
        try {
            getLogger().info("Close the Success Toast Message.");
            boolean result;
            waitForClickableOfElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
            result = clickElement(successToastMesCloseIconEle, "Close Icon Success Toast Message");
            Assert.assertTrue(result, "The Toast Message should be closed.");
            NXGReports.addStep("The Toast Message is closed successfully", LogAs.PASSED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return true;

        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot close the Success Toast Message.");
            NXGReports.addStep("The Toast Message is closed unsuccessfully", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        }
    }

    public String getDate(int day) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat.format(date.getTime());
    }

    public String getDate(int day, String formatDate) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
        return simpleDateFormat.format(date.getTime());
    }

    public String getCurrentDayNumberSuffix() {
        Date date = new Date();
        SimpleDateFormat formatDayOfMonth = new SimpleDateFormat("d");
        int day = Integer.parseInt(formatDayOfMonth.format(date));
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait text value of Element is changed.
     */
    public boolean waitForTextValueChanged(WebElement element, String elementName, String textValue) {
        getLogger().info("Try to waitForTextValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualTextValue = element.getText().trim();
                    System.out.println("Actual Displayed Value: " + actualTextValue);
                    System.out.println("Expected Displayed Value: " + textValue);
                    if (actualTextValue.equals(textValue))
                        return true;
                    else
                        return false;
                }
            });
            NXGReports.addStep(String.format("Text Value of element '%s' is changed to '%s'", elementName, textValue), LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("CSS Value is not changed");
            NXGReports.addStep(String.format("Text Value of element '%s' is NOT changed", elementName), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait the size of Element is changed.
     */
    public boolean waitForSizeListElementChanged(List<WebElement> element, String elementName, int sizeListElement) {
        getLogger().info("Try to waitForSizeListElementChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    int actualSizeListElement = element.size();
                    System.out.println("Actual Size of List Element: " + actualSizeListElement);
                    System.out.println("Expected Size of List Element: " + sizeListElement);
                    if (actualSizeListElement == sizeListElement)
                        return true;
                    else
                        return false;
                }
            });
            NXGReports.addStep(String.format("Size of list element '%s' is changed to '%d'", elementName, sizeListElement), LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Size of Element is not changed");
            NXGReports.addStep(String.format("Size of list element '%s' is NOT changed", elementName), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to verify the content of Toast Message.
     */
    public boolean verifyContentOfToastMessage(WebElement element, String elementName, String expectedContent) {
        getLogger().info("Try to Verify Content Of Toast Message: " + elementName);
        try {
            boolean result;
            //            Thread.sleep(3000);
            waitForVisibleElement(element, elementName);
            //            Thread.sleep(smallTimeOut);
            result = validateElementText(element, expectedContent);
            Assert.assertTrue(result, "The content of toast message is displayed successfully.");
            return true;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("The content of toast message is displayed unsuccessfully.");
            return false;
        }
    }

    /**
     * Verify the content of warning toast message is displayed.
     *
     * @param expectedContent The content is expected to displayed on Warning Message.
     * @return true if the content is displayed, otherwise it returns false.
     */
    public boolean verifyContentOfWarningToastMessage(String expectedContent) {
        getLogger().info("Try to Verify Content Of Warning Toast Message ");
        return verifyContentOfToastMessage(warningToastMesDescriptionEle, "Warning Toast Message Content", expectedContent);
    }

    /**
     * Get the Current Username Logged on.
     *
     * @return String UserName of Current User Logged on.
     */
    public String getCurrentUserNameLogOn() {
        getLogger().info("Get the Current Username Logged on. ");
        validateDisPlayedElement(userNameHeaderEle, "User Name Header.");
        return userNameHeaderEle.getText();
    }

    /**
     * Waiting for The Progressing Overlay is closed.
     */
    public void waitForProgressOverlayIsClosed() {
        getLogger().info("Try to waiting the ProgressOverlayIsClosed.");
        waitForCssValueChanged(progressingDiv, "Progress Overlay", "display", "none");
    }

    public static boolean IS_ENGLISH_LANGUAGE = true;

    public enum Element_Type {
        DISPLAYED, ISENABLE, ISSELECTED, HIDDEN, TEXT_VALUE, NOT_EXIST
    }

    /**
     * Check properties of element
     *
     * @param webElement
     * @param expected
     * @param type
     */
    public void validateElememt(WebElement webElement, String expected, Element_Type type) {
        switch (type) {
            case DISPLAYED:
                try {
                    Assert.assertTrue(webElement.isDisplayed(), expected + " is not displayed.");
                    NXGReports.addStep(expected + "is displayed.", LogAs.PASSED, null);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISENABLE:
                try {
                    Assert.assertTrue(webElement.isEnabled(), expected + " is not enabled.");
                    NXGReports.addStep(expected + "is enabled.", LogAs.PASSED, null);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISSELECTED:
                try {
                    Assert.assertTrue(webElement.isSelected(), expected + " is not selected  ");
                    NXGReports.addStep(expected + "is selected.", LogAs.PASSED, null);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case HIDDEN:
                try {
                    Assert.assertFalse(webElement.isDisplayed(), expected + " is not hidden.");
                    NXGReports.addStep(expected + "is not displayed.", LogAs.PASSED, null);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case TEXT_VALUE:
                try {
                    Assert.assertEquals(getText(webElement), expected);
                    NXGReports.addStep(expected + "is matched.", LogAs.PASSED, null);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case NOT_EXIST:
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                try {
                    webElement.click();
                    throw new AssertionError(expected + " is still displayed.");
                } catch (NoSuchElementException e) {
                    NXGReports.addStep(expected + " is not exist.", LogAs.PASSED, null, e.getMessage());
                }

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            default:
                break;
        }
    }

    public AbstractPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * @param url
     */
    public void getUrl(String url) {
        driver.get(url);
    }

    /**
     * Select option in select element by text
     *
     * @param webElement
     * @param item
     */
    public void selectOptionByText(WebElement webElement, String item, String elementName) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(item);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Can't select item: " + item + " of Dropdown " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    /**
     * Select option in select element by value
     *
     * @param ele
     * @param val
     */
    public void selectOptionByValue(WebElement ele, String val) {
        try {
            Select select = new Select(ele);
            select.selectByValue(val);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Select option in select element by index
     *
     * @param ele
     * @param index
     */
    public void selectOptionByIndex(WebElement ele, int index) {
        try {
            Select select = new Select(ele);
            select.selectByIndex(index);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Switch to other tab
     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
     *
     * @param tabIndex
     */
    public void switchToOtherTab(int tabIndex) {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    /**
     * Get text value of element
     *
     * @param webElement
     * @return
     */
    public String getText(WebElement webElement) {
        if (webElement.getTagName().equals("input") || webElement.getTagName().equals("textarea"))
            return webElement.getAttribute("value");
        return webElement.getText();
    }

    /**
     * TODO
     * Execute javascript
     *
     * @param script
     * @return
     */
    public String executeJavascript(String script) {
        return "";
    }

    /**
     * @param webElement
     * @param timeOut
     */
    public void waitUtilElementClickable(WebElement webElement, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * @param webElement
     * @param timeOut
     * @param text
     */
    public void waitUtilTextPresent(WebElement webElement, long timeOut, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait Web Element is util hidden
     *
     * @param by
     * @param timeOut
     */
    public void waitUtilElementHidden(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param IframeName
     */
    public void switchToFrame(String IframeName) {
        try {
            getLogger().info("Try to switch to iFrame: " + IframeName);
            driver.switchTo().frame(IframeName);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to switch to iFrame: " + IframeName + "with error: " + e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param iFrameId
     */
    public void switchToFrame(int iFrameId) {
        try {
            getLogger().info("Try to switch to iFrame with id: " + iFrameId);
            driver.switchTo().frame(iFrameId);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Try to switch to iFrame with id: " + iFrameId + "with error: " + e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param eleFrame
     */
    public void switchToFrame(WebElement eleFrame) {
        try {
            getLogger().info("Try to switch to iFrame with WebElement: " + eleFrame);
            driver.switchTo().frame(eleFrame);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Try to switch to iFrame with WebElement: " + eleFrame + "with error: " + e.getMessage());
        }
    }

    /**
     * Verify CSS value of element
     *
     * @param webElement
     * @param cssName
     * @param expected
     */
    public void verifyCssValue(WebElement webElement, String cssName, String expected) {

        try {

            String actualValue = webElement.getCssValue(cssName);
            System.out.println("Actual CSS Value: " + actualValue);
            if (cssName.contains("color")) {
                actualValue = GenericService.parseRgbTohex(actualValue);
            }

            Assert.assertEquals(actualValue, expected);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Get css value of element:before
     *
     * @param element
     * @param cssType
     * @return
     */
    public void getValueCssOfBeforeElement(WebElement element, String cssType, String expectedResult) {
        try {
            WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
            String actual = ((JavascriptExecutor) driver)
                    .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('" + cssType + "');", parent).toString();
            Assert.assertEquals(actual, expectedResult);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }


    /*
    This method to use to login to Advertisement site and Marketing site.
     */
    public void loginToMarketingPage(String username, String password) {
        try {
            clickElement(loginBTN, "loginBTN");
            sendKeyTextBox(emailTextBox, username, "emailTextBox");
            sendKeyTextBox(passwordTextBox, password, "passwordTextBox");
            clickElement(submitBTN, "submitBTN");
            waitForVisibleElement(profileLink, "profileLink");
            Assert.assertTrue(driver.getTitle().equals("Auvenir - Automating financial audit!"));
            getLogger().info("Login Successfully.");
            NXGReports.addStep("Login Successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("unable to login to marketing home page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        } catch (Error er) {
            NXGReports.addStep("unable to login to marketing home page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    er.getMessage());
        }
    }

    /*
    This method to change language of page to French
     */
    public void changeLanguage() {
        try {
            getLogger().info("Try to change language of page.");
            clickElement(changeLanguageBTN, "changeLanguageBTN");
            getLogger().info("Change language successfully.");
            NXGReports.addStep("Change language successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("unable to Change language.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    public void deleteAllCookies() {
        try {
            getLogger().info("Try to delete all cookies.");
            driver.manage().deleteAllCookies();
            NXGReports.addStep("Delete all cookies successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Delete all cookies successfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public void deleteCookieName(String cookieName) {
        try {
            getLogger().info("Delete Cookie Name.");
            driver.manage().deleteCookieNamed(cookieName);
            NXGReports.addStep("Delete all cookies :" + cookieName, LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Delete cookie successfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());

        }
    }

    public void refreshPage() {
        try {
            getLogger().info("Refresh Page.");
            getDriver().navigate().refresh();
            NXGReports.addStep("Refresh page successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to refresh page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    public void navigateBack() {
        try {
            getDriver().navigate().back();
            NXGReports.addStep("Back to previous page successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to back to previous page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public void navigateForward() {
        try {
            getDriver().navigate().forward();
            NXGReports.addStep("Forward to previous page successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Unable to forward to previous page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        }
    }

    public boolean validateNotExistedElement(WebElement element, String elementName) {
        try {
            getLogger().info("Try to validate Element is not existed.");
            //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.click();
            element.getText();
            return false;
        } catch (NoSuchElementException e) {
            getLogger().info("Element is not existed.");
            //NXGReports.addStep(elementName + " is not exist.", LogAs.PASSED, null, e.getMessage());
            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        } catch (ElementNotVisibleException e) {
            getLogger().info("Element is visible.");
            //NXGReports.addStep(elementName + " is not exist.", LogAs.PASSED, null, e.getMessage());
            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        } catch (IndexOutOfBoundsException outEx) {
            getLogger().info("List element is empty.");
            return true;
        } catch (Exception e) {
            getLogger().info("Element is still displayed.");
            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }

    public boolean validateExistedElement(WebElement element, String elementName) {
        try {
            getLogger().info("Validating " + elementName + " is existed.");
            element.getText();
            return true;
        } catch (NoSuchElementException e) {
            getLogger().info(elementName + " is not existed.");
            return false;
        } catch (ElementNotVisibleException e) {
            getLogger().info(elementName + " is visible.");
            return false;
        } catch (IndexOutOfBoundsException outEx) {
            getLogger().info("List " + elementName + " is empty.");
            return false;
        } catch (Exception e) {
            getLogger().info("Error: Finding " + elementName + " error.");
            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }

    /*
    Vien edited clicktoNewCategoryDllInList
     */

    @FindBy(xpath = "//table [@id=\"todo-table\"]//input[@type=\"text\"]")
    List<WebElement> TodosTextboxEle;

    @FindBy(xpath = "//table [@id=\"todo-table\"]//input[@type=\"text\"]")
    List<WebElement> listTodosTextboxEle;

    @FindBy(id = "engagement-backButton")
    WebElement engagementBackBtn;

    public void waitForNewTodoNameSaved() {
        String deFaultBorder = "1px solid rgb(255, 255, 255)";
        try {
            getLogger().info("Click anywhere...");
            clickElement(eleAuvenirIncTxt, "Auvernir Inc");
            getLogger().info("Verifying the Todo TextName border is transfered from Green to White or not...");
            boolean i = waitForCssValueChanged(listTodosTextboxEle.get(0), "To Do Name textbox", "border", deFaultBorder);
            if (i) {
                NXGReports.addStep("Border is White.", LogAs.PASSED, null);
            } else {
                NXGReports.addStep("Border is White.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

            }
        } catch (Exception e) {
            NXGReports.addStep("Border is White.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    /*
    Vien.Pham modified this method
     */
    public void navigateToAddNewCategory() throws Exception {
        try {
            clickElement(dropdownCategoryEle.get(0), "categoryDropdownEle");
            waitForTextValueChanged(listOfAddNewCategory.get(0), "categoryCreateEle", "Add New Category");
            hoverElement(listOfAddNewCategory.get(0), "categoryCreateEle");
            clickElement(listOfAddNewCategory.get(0), "categoryCreateEle");
            NXGReports.addStep("Navigate to Add new category: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Navigate to Add new category: Fail", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void verifyInvalidTodoNameNotSaved(String invalidName) {
        try {
            Thread.sleep(smallerTimeOut);
            getLogger().info("Make sure invalid name was not saved after return to Todo list Page again...");
            returnToTodoListPage_LoginToEngagementAgain();
            getLogger().info("Comparing...");
            WebElement textbox1 = TodosTextboxEle.get(0);
            String comparedValue = textbox1.getAttribute("value");
            if (!comparedValue.equals(invalidName)) {
                NXGReports.addStep("Invalid name was not saved as expected.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Invalid name still be saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Invalid name still be saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyValidTodoNameSaved(String validName) {
        try {
            Thread.sleep(smallerTimeOut);
            getLogger().info("Make sure valid name was saved after return to Todo list Page again...");
            returnToTodoListPage_LoginToEngagementAgain();
            getLogger().info("Comparing...");
            WebElement textbox1 = TodosTextboxEle.get(0);
            String comparedValue = textbox1.getAttribute("value");
            System.out.println("Currently value is: " + comparedValue);
            if (comparedValue.equals(validName)) {
                NXGReports.addStep("Valid Todo name was saved as expected.", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Valid Todo name still not saved.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            e.printStackTrace();
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Valid Todo name still not saved_Exception.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void returnToTodoListPage_LoginToEngagementAgain() {
        AuditorEngagementService auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        AuditorDetailsEngagementService auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        try {
            getLogger().info("Back to Engagement page...");
            engagementBackBtn.click();
            getLogger().info("Return to Todo list page again..");
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            NXGReports.addStep("Return to Todo ListPage successfully.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Return to Todo ListPage failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyBorderTodoTextBox_InputValidValue() {
        String greenBorder = "1px solid rgb(92, 155, 160)";
        try {
            WebElement textbox1 = TodosTextboxEle.get(0);
            getLogger().info("Verifying textbox border is Green when inputed valid todo name...");
            //            validateCssValueElement(textbox1, "border", whiteBorder);
            waitForCssValueChanged(textbox1, "Textbox", "border", greenBorder);
            NXGReports.addStep("Border color is green while inputed valid todo name", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Border color is green while inputed valid todo name", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyBorderTodoTextBox_InputInvalidValue() {
        String OrangeBorder = "1px solid rgba(253, 109, 71, 0.4)";
        try {
            WebElement textbox1 = TodosTextboxEle.get(0);
            getLogger().info("Verifying border of todo Textbox is Orange while missed or entered invalid values or not...");
            waitForCssValueChanged(TodosTextboxEle.get(0), "Todo TextBox", "border", OrangeBorder);
            validateCssValueElement(textbox1, "border", OrangeBorder);
            NXGReports.addStep("Border color is Orange while inputting invalid value.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Border color is Orange while inputting invalid value.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }


    public boolean verifyShowAllTextTodoName(String todoNameAllText) {
        boolean isCheckShowAllText = false;
        getLogger().info("Verify check show all text of todo name..");
        try {
            String strGetTodoName = getTextByJavaScripts(TodosTextboxEle.get(0), "Todos Textbox");
            if (todoNameAllText.equals(strGetTodoName)) {
                isCheckShowAllText = true;
                NXGReports.addStep("Verify check show all text of category name", LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            }
            return isCheckShowAllText;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify check show all text of category name", LogAs.FAILED, null);
            getLogger().info(ex.getMessage());
            return isCheckShowAllText;
        }
    }




    /*
    End of VienPham
     */

    /**
     * Author: Thuan Duong.
     * Verify the content of success toast message is displayed.
     *
     * @param expectedContent The content is expected to displayed on Success Message.
     * @return true if the content is displayed, otherwise it returns false.
     */
    public boolean verifyContentOfSuccessToastMessage(String expectedContent) {
        getLogger().info("Try to Verify Content Of Warning Toast Message ");
        return verifyContentOfToastMessage(successToastMesDescriptionEle, "Success Toast Message Content", expectedContent);
    }

    /**
     * Added by huy.huynh on 31/05/2017.
     * New for smoke test
     */

    /**
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
    public boolean validateSelectedItemText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check renderd of text: " + elementText);
            getLogger().info("Actual Text is displayed: " + new Select(webElement).getFirstSelectedOption().getText());
            Assert.assertEquals(new Select(webElement).getFirstSelectedOption().getText(), elementText);
            NXGReports.addStep(elementText + " rendered", LogAs.PASSED, null);
            return true;
        } catch (AssertionError error) {
            System.out.println("Error is: " + error);
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep(elementText + " rendered", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), error.getMessage());
            return false;
        }
    }
    /*-----------end of huy.huynh on 31/05/2017.*/

    /**
     * Author: Thuan Duong.
     *
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to change Attribute value.
     */
    public boolean waitForAtrributeValueChanged(WebElement element, String elementName, String attributeName, String attributeValue) {
        getLogger().info("Try to waitForAtrributeValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualAttributeValue = null;
                    if (element.getAttribute(attributeName) != null) {
                        actualAttributeValue = element.getAttribute(attributeName);
                        System.out.println("Actual Displayed Value: " + actualAttributeValue);
                    } else {
                        getLogger().info(String.format("Attribute %s is null", attributeName));
                        return false;
                    }
                    if (actualAttributeValue.equals(attributeValue))
                        return true;
                    else
                        return false;
                }
            });
            NXGReports.addStep(String.format("Attribute '%s' of element '%s' is changed to '%s'", attributeName, elementName, attributeValue),
                    LogAs.PASSED, null);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Attribute Value is not changed");
            NXGReports.addStep(String.format("Attribute '%s' of element '%s' is NOT changed", attributeName, elementName), LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            return false;
        }
    }


    /**
     * Author: Thuan Duong.
     * Input a value into a control element (Ex: Textbox, Listbox,..)
     *
     * @param element     Element will be input the value.
     * @param elementName Element name
     * @param textValue   Value which is input.
     */
    public void inputValueIntoControl(WebElement element, String elementName, String textValue) {
        try {
            getLogger().info("Input Value Into Control " + elementName);
            waitForVisibleElement(element, elementName);
            clickElement(element, elementName);
            sendKeyTextBox(element, textValue, elementName);
            NXGReports.addStep("Input " + elementName, LogAs.PASSED, null);
        } catch (NoSuchElementException e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Element is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Added by huy.huynh on 06/06/2017.
     * check element on dev-branch
     */

    /**
     * validate element list size equal
     *
     * @param elements    list element
     * @param quantity    Expected quantity
     * @param elementName Element name
     */
    public void validateElementsQuantity(List<WebElement> elements, int quantity, String elementName) {
        try {
            getLogger().info("Validate elements quantity" + elementName);
            if (elements.size() == quantity) {
                NXGReports.addStep(elementName + " quantity equal: " + quantity, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(elementName + " quantity not equal: [Expected]= " + quantity + " /[Actual]= " + elements.size(), LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Check quantity fail: " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * validate placeholder text
     *
     * @param webElement  element need to validate
     * @param value       Expected placeholder text
     * @param elementName Element name
     */
    public void validatePlaceholder(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate placeholder " + elementName);
            if (webElement.getAttribute("placeholder").equals(value)) {
                NXGReports.addStep(elementName + " placeholder equal: " + value, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(
                        elementName + " placeholder not equal: [Expected]= " + value + " /[Actual]= " + webElement.getAttribute("placeholder"),
                        LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Validate placeholder " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * validate if attribute contain given value
     *
     * @param webElement  element need to validate
     * @param attribute   attribute name
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public boolean validateAttributeContain(WebElement webElement, String attribute, String value, String elementName) {
        try {
            getLogger().info("Validate Style Attribute Exist " + elementName);
            if (webElement.getAttribute(attribute).contains(value)) {
                NXGReports.addStep(value + " exist on " + attribute + " on element: " + elementName, LogAs.PASSED, null);
                return true;
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(value + " still exist on " + attribute + " on element: " + elementName, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                return false;
            }
        } catch (NoSuchElementException e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not existed.");
            NXGReports.addStep("Error: " + elementName + " is not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
            return false;
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Validate attribute contain " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * validate if attribute not contain given value
     *
     * @param webElement  element need to validate
     * @param attribute   attribute name
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateAttributeNotContain(WebElement webElement, String attribute, String value, String elementName) {
        try {
            getLogger().info("Validate Style Attribute Not Exist " + elementName);
            if (!webElement.getAttribute(attribute).contains(value)) {
                NXGReports.addStep(value + " not exist on " + attribute + " on element: " + elementName, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(value + " still exist on " + attribute + " on element: " + elementName, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Validate not exist " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * validate text get by JS contain given value
     *
     * @param webElement  element need to validate
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateElementJavaScriptTextContain(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate Element JavaScript Text Contain " + elementName);
            if (getTextByJavaScripts(webElement, elementName).contains(value)) {
                NXGReports.addStep(elementName + "'s JavaScript text contain: " + value, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Fail: " + elementName + "'s JavaScript text not contain: " + value, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Error: Validate JavaScript text contain " + elementName, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), ex.getMessage());
            ex.printStackTrace();
        }
    }

    /*-----------end of huy.huynh on 06/06/2017.*/

    /**
     * Added by huy.huynh on 12/06/2017.
     * check element on dev-branch
     */
    /**
     * @param webElement  Element defined in page class
     * @param elementName The text name of element
     */
    public void clickByJavaScripts(WebElement webElement, String elementName) {
        getLogger().info("Click by javascript of element " + elementName);
        String textOfElement = "";
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("arguments[0].click()", webElement);
            NXGReports.addStep("Click by javascript of element " + elementName, LogAs.PASSED, null);
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Click by javascript of element " + elementName, LogAs.FAILED, null, ex.getMessage());
            getLogger().info(ex.getMessage());
        }
    }
    /*-----------end of huy.huynh on 12/06/2017.*/

    /**
     * Added by huy.huynh on 15/06/2017.
     * Fixed 22/06/2017
     * SmokeTest R2
     */
    /**
     * /**
     * Scroll to footer of current page
     * TODO: duplicating with scrollToFooter on AbstractService, find solution later
     */
    public void scrollToFooter() {
        getLogger().info("Scroll down to see page footer.");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void chooseFirstOptionOfInputSelect(List<WebElement> list, String elementName) {
        clickElement(list.get(0), elementName);
    }

    /**
     * @param webElement  Element defined in page class
     * @param elementName The text name of element
     * @return The text of web element
     */
    public String getTextByAttributeValue(WebElement webElement, String elementName) {
        getLogger().info("Get text by attribute 'value' " + elementName);
        try {
            return webElement.getAttribute("value");
        } catch (NoSuchElementException e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not existed.");
            NXGReports.addStep("Error: " + elementName + " is not exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    e.getMessage());
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Get text by by attribute 'value' " + elementName, LogAs.FAILED, null, ex.getMessage());
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    /**
     * wait some seconds- should be use when can't apply ExplicitWait
     *
     * @param seconds seconds to wait
     */
    public void waitSomeSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * get element which cant use @FindBy to find
     *
     * @param xpath xpath to get element
     * @param arg   vararg for formating
     */
    public WebElement getElementByXpath(String xpath, String... arg) {
        WebElement webElement = null;
        xpath = String.format(xpath, arg);
        try {
            webElement = getDriver().findElement(By.xpath(xpath));
        } catch (Exception ex) {
            NXGReports.addStep("Can't find element for xpath: " + xpath, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    ex.getMessage());
        }
        return webElement;
    }

    /**
     * wait until animation for element finish
     *
     * @param webElement  xpath to get element
     * @param elementName vararg for formating
     */
    public void waitForAnimation(WebElement webElement, String elementName) {
        // This function is waiting to Popup Delete To Do task is displayed after running animation.
        // We can move this function to Abstract Page or Common Page.
        try {
            getLogger().info("Waiting For Animation: " + elementName);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until((WebDriver driver) -> {
                boolean result = false;
                result = (boolean) ((JavascriptExecutor) driver).executeScript(
                        "var elm = arguments[0];" + "var doc1 = elm.ownerDocument || document;" + "var rect = elm.getBoundingClientRect();" + "return elm === doc1.elementFromPoint(rect.left, rect.top);",
                        webElement);
                getLogger().info("result: " + result);
                return result;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * validate text contain given value
     *
     * @param webElement  element need to validate
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateElementTextContain(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate Element Text Contain " + elementName);
            System.out.println("expected = " + value);
            System.out.println("actualll = " + webElement.getText());
            if (webElement.getText().contains(value)) {
                NXGReports.addStep(elementName + "'s text contain: " + value, LogAs.PASSED, null);
            } else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep(elementName + "'s text not contain: " + value, LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports
                    .addStep("Error: Validate text contain " + elementName, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            ex.getMessage());
            ex.printStackTrace();
        }
    }

    /*
        Method to scrollPageDown
     */
    public void scrollWithKeyDown() {
        getLogger().info("Try to key down.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            NXGReports.addStep("Key down.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Key down unsuccessfully.");
            NXGReports.addStep("Key down unsuccessfully.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE), e.getMessage());
        }
    }

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-orange fl-a-container-show']/div[@class = 'fl-a-dismiss auvicon-line-circle-ex'] ")
    private WebElement iconCloseWarningToastMessage;

    public boolean closeWarningToastMessage() {
        try {
            getLogger().info("Close the Warning Toast Message.");
            waitForClickableOfElement(iconCloseWarningToastMessage, "Icon Close Warning Toast Message");
            return clickElement(iconCloseWarningToastMessage, "Icon Close Warning Toast Message");
        } catch (Exception e) {
            getLogger().info("Cannot close the Warning Toast Message.");
            return false;
        }
    }
     /*-----------end of huy.huynh on 15/06/2017.*/

    /**
     * get list elements which cant use @FindBy to find
     *
     * @param xpath xpath to get element
     * @param arg   vararg for formating
     */
    public List<WebElement> getListElementsByXpath(String xpath, String... arg) {
        List<WebElement> webElement = null;
        xpath = String.format(xpath, arg);
        try {
            webElement = getDriver().findElements(By.xpath(xpath));
        } catch (Exception ex) {
            NXGReports
                    .addStep("Can't find list elements for xpath: " + xpath, LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                            ex.getMessage());
        }
        return webElement;
    }

    public void closeBrowserAfterDownLoad() throws InterruptedException {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)).close();
        Thread.sleep(smallTimeOut);
    }

    public void clickElementActions(WebElement element, String ElementName) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
        } catch (Exception e) {

        }
    }

}