package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.EngagementPage;
import com.auvenir.utilities.GeneralUtilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

//import com.auvenir.ui.pages.marketing.engagement.BaseEngagementPO;

public class AuditorEngagementPage extends EngagementPage {


    AuditorEngagementPage auditorEngagementPage = null;

    public AuditorEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(css = "img[class='header-auvenirLogo']")
    private WebElement eleAuvenirLogoImg;

    public WebElement getEleAuvenirLogoImg() {
        return eleAuvenirLogoImg;
    }

    @FindBy(xpath = "//span[text()='My Engagements']")
    private WebElement eleMyEngmntTxt;

    public WebElement getEleMyEngmntTxt() {
        return eleMyEngmntTxt;
    }

    @FindBy(id = "tooltip-createEngagement-mainText")
    private WebElement eleClickhereTipTxt;

    public WebElement getEleClickhereTipTxt() {
        return eleClickhereTipTxt;
    }

    @FindBy(className = "noEngagement-txt")
    private WebElement eleYouDontHaveTxt;

    public WebElement getEleYouDontHaveTxt() {
        return eleYouDontHaveTxt;
    }

    @FindBy(id = "dashboardUsername")
    private WebElement eleAuditorNameDrpDwn;

    public WebElement getEleAuditorNameDrpDwn() {
        return eleAuditorNameDrpDwn;
    }

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement eleSettingsLnk;

    public WebElement getEleSettingsLnk() {
        return eleSettingsLnk;
    }

    @FindBy(id = "h-ddl-signOut")
    private WebElement eleSignOutLnk;

    public WebElement getEleSignOutLnk() {
        return eleSignOutLnk;
    }

    @FindBy(id = "h-f-inbox-dropdown")
    private WebElement eleChatIcn;

    public WebElement getEleChatIcn() {
        return eleChatIcn;
    }

    @FindBy(xpath = "//div[@class='au-dropdown-trigger notification-trigger']")
    private WebElement eleNotificationIcn;

    public WebElement getEleNotificationIcn() {
        return eleNotificationIcn;
    }

    @FindBy(id = "h-engagementsLink")
    private WebElement eleEngagementLnk;

    public WebElement getEleEngagementLnk() {
        return eleEngagementLnk;
    }

    @FindBy(id = "h-clientListLink")
    private WebElement eleClientsLnk;

    public WebElement getEleClientsLnk() {
        return eleClientsLnk;
    }

    @FindBy(xpath = "//div[contains(@id,'progress-')]")
    private WebElement eleEngagementNameTxt;

    public WebElement getEleEngagementNameTxt() {
        return eleEngagementNameTxt;
    }

    @FindBy(xpath = "//p[contains(@id,'date-')]")
    private WebElement eleEngagementDateTxt;

    public WebElement getEleEngagementDateTxt() {
        return eleEngagementDateTxt;
    }

    @FindBy(xpath = "//img[contains(@id,'w-ei-bgimg-')]")
    private WebElement eleEngagementImg;

    public WebElement getEleEngagementImg() {
        return eleEngagementImg;
    }

    @FindBy(xpath = "//label[text()='Set schedule']")
    private WebElement eleSetScheduleLabel;

    public WebElement getEleSetScheduleLabel() {
        return eleSetScheduleLabel;
    }

    @FindBy(id = "h-clientListLink")
    private WebElement contactsLinkEle;

    @FindBy(xpath = "//button[contains(text(),'Add New')]")
    private WebElement eleAddNewBtn;

    //    @FindBy(xpath = "//div[@id='cpa-main']//p[@class='e-widget-auditTitle']")
    @FindBy(xpath = "//*[@id='engagement-tbody']/tr//td[8]")
    private List<WebElement> engagementTitleListEle;

    @FindBy(xpath = "//tbody[@id='engagement-tbody']/tr/td/a")
    List<WebElement> newEngagementTitleListEle;

    @FindBy(xpath = "//*[@id='CreateEnagementParent']/../../../..")
    WebElement popUpCreateEngagement;

    public WebElement getEleAddNewBtn() {
        return eleAddNewBtn;
    }

    final String viewButtonOnEngagement = ".//div/div/div[2]/div[2]/input";

    @FindBy(id = "newEngagement")
    private WebElement eleNewEngagement;

    public WebElement getEleNewEngagement() {
        return eleNewEngagement;
    }

    @FindBy(id = "filter")
    private WebElement eleFilter;

    public WebElement getEleFilter() {
        return eleFilter;
    }

    @FindBy(id = "engagement-search")
    private WebElement eleSearch;

    public WebElement getElSearch() {
        return eleSearch;
    }

    @FindBy(xpath = "//*[@id=\"company-sort\"]/i")
    private WebElement eleCompany;

    public WebElement getEleCompany() {
        return eleCompany;
    }

    @FindBy(xpath = "//*[@id=\"engagement-sort\"]/i")
    private WebElement eleEngagementName;

    public WebElement getEleEngagementName() {
        return eleEngagementName;
    }

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]")
    private WebElement companyEle;
    private String companyEleStr = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]";

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[1]")
    private List<WebElement> listCompanyEle;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr[1]/td[1]/a[1]")
    private WebElement engagementNameEle;
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td/a")
    private List<WebElement> listEngagementNameEle;
    private String engagementNameStr = "//*[@id=\"engagement-tbody\"]/tr/td/a";
    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[3]/span")
    private List<WebElement> listEngagementStatusEle;
    @FindBy(xpath = "//*[@id=\"status-sort\"]/i")
    private WebElement engagementStatusHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[4]")
    private List<WebElement> listEngagementAssigneeEle;
    @FindBy(xpath = "//*[@id=\"audit-sort\"]/i")
    private WebElement engagementAssigneeHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[5]/span")
    private List<WebElement> listEngagementCompleteToDosEle;
    @FindBy(xpath = "//*[@id=\"todo-sort\"]/i")
    private WebElement engagementCompleteToDosHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[6]")
    private List<WebElement> listEngagementClientAssigneeEle;
    @FindBy(xpath = "//*[@id=\"client-sort\"]/i")
    private WebElement engagementClientAssigneeHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[7]/span")
    private List<WebElement> listEngagementCompleteDocsEle;
    @FindBy(xpath = "//*[@id=\"docs-sort\"]/i")
    private WebElement engagementCompleteDocsHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/td[8]")
    private List<WebElement> listEngagementLastActivityEle;
    @FindBy(xpath = "//*[@id=\"activity-sort\"]/i")
    private WebElement engagementLastActivityHeader;

    @FindBy(xpath = "//*[@id=\"engagement-tbody\"]/tr/div")
    private List<WebElement> listEngagementDueDateEle;
    @FindBy(xpath = "//*[@id=\"duedate-sort\"]/i")
    private WebElement engagementDueDateHeader;

    /**
     * Added by huy.huynh on 08/06/2017.
     * Verify UI Engagement list
     */
    @FindBy(id = "header-blue-logo")
    private WebElement imageLogoHeaderBlue;

    @FindBy(id = "h-engagementsLink")
    private WebElement tabHeaderEngagements;

    @FindBy(id = "h-clientListLink")
    private WebElement tabHeaderContacts;

    @FindBy(id = "dashboardUsername")
    private WebElement dashboardUsername;

    @FindBy(xpath = "//div[@id='h-ddl-item-settings']/a")
    private WebElement dashboardSettings;

    @FindBy(id = "h-ddl-signOut")
    private WebElement dashboardSignOut;

    @FindBy(xpath = "//div[@id='preview-header-left']/span")
    private WebElement titlePreviewHeader;

    @FindBy(xpath = "//div[@id='engagement-filters']/span")
    private WebElement selectEngagementFilters;

    @FindBy(xpath = "//div[@type='All']/span")
    private WebElement optionFilterAll;

    @FindBy(xpath = "//div[@type='Type of Engagement']/span")
    private WebElement optionFilterTypeOfEngagement;

    @FindBy(xpath = "//div[@class='menu transition visible']/div")
    private List<WebElement> listOptionTypeOfEngagement;

    @FindBy(xpath = "//div[@class='item'][text()='Financial Audit']")
    private WebElement optionTypeOfEngagementFinancialAudit;

    @FindBy(xpath = "//div[@class='item'][text()='Review']")
    private WebElement optionTypeOfEngagementReview;

    @FindBy(xpath = "//div[@class='item'][text()='Notice to Reader / Compilation']")
    private WebElement optionTypeOfEngagementNoticeToReaderCompilation;

    @FindBy(xpath = "//div[@class='item'][text()='Other']")
    private WebElement optionTypeOfEngagementOther;

    @FindBy(id = "engagement-search")
    private WebElement inputEngagementSearch;

    @FindBy(id = "company-sort")
    private WebElement thCompany;

    @FindBy(id = "engagement-sort")
    private WebElement thEngagement;

    @FindBy(id = "status-sort")
    private WebElement thStatus;

    @FindBy(id = "audit-sort")
    private WebElement thAudit;

    @FindBy(id = "todo-sort")
    private WebElement thToDo;

    @FindBy(id = "client-sort")
    private WebElement thClient;

    @FindBy(id = "docs-sort")
    private WebElement thDocs;

    @FindBy(id = "activity-sort")
    private WebElement thActivity;

    @FindBy(id = "duedate-sort")
    private WebElement thDueDate;

    @FindBy(xpath = "//div[@id='preview-footer']//span")
    private WebElement titleCompanyInfo;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][1]")
    private WebElement titleTermsOfService;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][2]")
    private WebElement titlePrivacyStatement;

    @FindBy(xpath = "//div[@id='preview-footer']//a[@href][3]")
    private WebElement titleCookieNotice;

    @FindBy(xpath = "//td[@class='engagement-name']/a")
    private List<WebElement> eleEngagementNameList;

    @FindBy(xpath = "//tbody[@id='engagement-tbody']/tr/td[1]")
    private List<WebElement> eleEngagementCompanyList;

    /**
     * verifyEngagementStatusWhenCheckCompleteToDo - TanPh - 2017/06/21 - Start
     **/
    private static String engagementStatusBefore = "planning";
    private static String engagementToDoBefore = "";


    @FindBy(xpath = "//td[@class='status']/span")
    private List<WebElement> eleEngagementStatusList;

    @FindBy(xpath = "//td[@class='completed-todos']/span[@class='warning']")
    private List<WebElement> eleEngagementToDoList;

    @FindBy(xpath = "//div[@id='engagement-filters']")
    private WebElement auditorEngagementFilter;

    @FindBy(xpath = "//span[contains(text(),'Type of Engagement')]")
    private WebElement filterTypeOfEngagement;

    @FindBy(xpath = "//div[contains(text(),'Financial Audit')]")
    private WebElement filterEngaFinancialAudit;

    @FindBy(xpath = "//div[contains(text(),'Review')]")
    private WebElement filterEngaReview;

    @FindBy(xpath = "//div[contains(text(),'Notice to Reader / Compilation')]")
    private WebElement filterEngaNoticeCompilation;

    @FindBy(xpath = "//div[contains(text(),'Other')]")
    private WebElement filterEngaOther;

    @FindBy(xpath = "//td[@class='completed-todos']/span[contains(text(),'0% (0/0)')]")
    private List<WebElement> hoverCompleteToDos;

    @FindBy(xpath = "//div[@class='ui special popup completed-todo-popup top left transition visible']")
    private WebElement hoverCompleteToDosResult;

    @FindBy(xpath = "//td[@class='completed-docs']/span[contains(text(),'0% (0/0)')]")
    private List<WebElement> hoverCompleteDocs;

    @FindBy(xpath = "//div[@class='ui special popup completed-todo-popup top left transition visible']")
    private WebElement hoverCompleteDocsResult;

    //Review

    /**
     * verifyEngagementStatusWhenCheckCompleteToDo - TanPh - 2017/06/20 - End
     *
     */

    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     */
    private static final String ENGAGEMENT_STATUS_COMPLETE = "complete";
    private static final String ENGAGEMENT_TODO_COMPLETE = "100";
    /**
     * verifyClientSeeMarkAsComplete - TanPh - 2017/06/21 - End
     */


    protected String dateFormat = "MM/dd/YY";
    protected SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public enum EngagementStatus {
        ACTIVE(2), PLANING(5), COMPLETED(4), ARCHIVED(3), ABANDONED(1);

        private final int levelStatus;

        private EngagementStatus(int levelStatus) {
            this.levelStatus = levelStatus;
        }
    }

    public enum UserType {
        AUDITOR(1), CLIENT(2);

        private final int levelType;

        private UserType(int levelType) {
            this.levelType = levelType;
        }
    }

    public enum UserStatus {
        ACTIVE(1), DEACTIVED(2), LOCKED(3), PENDING(4);

        private final int levelUserStatus;

        private UserStatus(int levelUserStatus) {
            this.levelUserStatus = levelUserStatus;
        }
    }

    @FindBy(id = "")
    private WebElement eleTabEngagements;

    public WebElement getEleTabEngagements() {
        return eleTabEngagements;
    }

    @FindBy(id = "")
    private WebElement eleTabContacts;

    public WebElement getEleTabContacts() {
        return eleTabContacts;
    }


    @FindBy(xpath = "//th[@id='company-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleCompanyIconSortDown;

    @FindBy(xpath = "//th[@id='company-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleCompanyIconSortUp;

    @FindBy(xpath = "//th[@id='engagement-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementNameIconSortDown;

    @FindBy(xpath = "//th[@id='engagement-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementNameIconSortUp;

    @FindBy(xpath = "//th[@id='status-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementStatusIconSortDown;

    @FindBy(xpath = "//th[@id='status-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementStatusIconSortUp;

    @FindBy(xpath = "//th[@id='audit-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementAuditIconSortDown;

    @FindBy(xpath = "//th[@id='audit-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementAuditIconSortUp;

    @FindBy(xpath = "//th[@id='todo-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementToDoIconSortDown;

    @FindBy(xpath = "//th[@id='todo-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementToDoIconSortUp;

    @FindBy(xpath = "//th[@id='client-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementClientIconSortDown;

    @FindBy(xpath = "//th[@id='client-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementClientIconSortUp;

    @FindBy(xpath = "//th[@id='docs-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementDocIconSortDown;

    @FindBy(xpath = "//th[@id='docs-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementDocIconSortUp;

    @FindBy(xpath = "//th[@id='activity-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementActivityIconSortDown;

    @FindBy(xpath = "//th[@id='activity-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementActivityIconSortUp;

    @FindBy(xpath = "//th[@id='duedate-sort']/i[@class='auvicon-sort-down']")
    private WebElement eleEngagementDueDateIconSortDown;

    @FindBy(xpath = "//th[@id='duedate-sort']/i[@class='auvicon-sort-up']")
    private WebElement eleEngagementDueDateIconSortUp;

    public void auditorPageHeaderContent() {
        auditorEngagementPage = new AuditorEngagementPage(getLogger(), getDriver());
        GeneralUtilities.toValidate(auditorEngagementPage.getEleAuvenirLogoImg(), "Auvenir Logo", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleEngagementLnk(), "Engagement Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleClientsLnk(), "Clients Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleAuditorNameDrpDwn(), "Auditor Name Dropdown", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleSettingsLnk(), "Dropdown Settings Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleSignOutLnk(), "Dropdown SignOut Link", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleChatIcn(), "Chat Icon", "Displayed");
        GeneralUtilities.toValidate(auditorEngagementPage.getEleNotificationIcn(), "Notification Icon", "Displayed");
    }

    public void verifyAuditorEngagementFilter() {
        boolean isAuditorEngagementFilter, isFilterTypeOfEngagement, isFilterEngaFinancialAudit, isFilterEngaNoticeCompilation, isFilterEngaReview,
                isFilterEngaOther = false;
        isAuditorEngagementFilter = clickElement(auditorEngagementFilter, "click to auditorEngagementFilter");
        isFilterTypeOfEngagement = clickElement(filterTypeOfEngagement, "click to filterTypeOfEngagement");
        isFilterEngaFinancialAudit = validateDisPlayedElement(filterEngaFinancialAudit, "display filterEngaFinancialAudit");
        isFilterEngaNoticeCompilation = validateDisPlayedElement(filterEngaNoticeCompilation, "display filterEngaNoticeCompilation");
        isFilterEngaReview = validateDisPlayedElement(filterEngaReview, "display filterEngaReview");
        isFilterEngaOther = validateDisPlayedElement(filterEngaOther, "display filterEngaOther");
        if (isAuditorEngagementFilter && isFilterTypeOfEngagement && isFilterEngaFinancialAudit && isFilterEngaNoticeCompilation && isFilterEngaReview && isFilterEngaOther) {
            getLogger().info("Verify Auditor Engagement filter");
        } else {
            Assert.fail("Verify Auditor Engagement filter");
        }
    }

    public void verifyAuditorEngagementHover() {
        boolean isHoverCompleteToDosResult, isHoverCompleteDocsResult = false;
        hoverElement(hoverCompleteToDos.get(0), "hover to hoverCompleteToDos");
        isHoverCompleteToDosResult = validateDisPlayedElement(hoverCompleteToDosResult, "display hoverCompleteToDosResult");
        hoverElement(hoverCompleteDocs.get(0), "hover to hoverCompleteDocs");
        isHoverCompleteDocsResult = validateDisPlayedElement(hoverCompleteDocsResult, "display hoverCompleteDocsResult");
        if (isHoverCompleteToDosResult && isHoverCompleteDocsResult) {
            getLogger().info("Verify Auditor Engagement hover");
        } else {
            Assert.fail("Verify Auditor Engagement hover");
        }
    }

    public void navigateToContactsTab() {
        waitForClickableOfElement(contactsLinkEle, "contactsLinkEle");
        clickElement(contactsLinkEle, "click to contactsLinkEle");
    }

    public void clickNewEngagementButton() {
        waitForVisibleElement(buttonNewEngagement, "New Engagement Button");
        waitForClickableOfElement(buttonNewEngagement, "New Engagement Button");
        clickElement(buttonNewEngagement, "New Engagement Button");
    }

    public void enterEngagementDetailWithName(String engagementTitle, String engagementName) throws Exception {
        WebElement webElement =
                getDriver().findElement(By.xpath("//p[contains(text(),'" + engagementTitle + "')]/ancestor::div[@id='cpa-main']//input"));
        System.out.println("+++++++++++++++++++++++++++++  " + engagementTitle);
        //current we cannot view engagement by name we test with first engagment
        //TODO bug here, fix later
        hoverElement(webElement, engagementName);
        waitForClickableOfElement(webElement, engagementName);
        clickAndHold(webElement, engagementName);
    }

    /*
    Vien.Pham moved createAndSelectNewEnagement Method
     */

    /**
     * Get the list ID of Engagement on Engagement Page.
     *
     * @return List<String> the list ID of Engagement on Engagement Page.
     */
    public List<String> getListIdOfEngagement() {
        List<String> listIdOfEngagement = new ArrayList<String>();
        if (!listIdOfEngagement.isEmpty()) {
            for (int i = 0; i < engagementTitleListEle.size(); i++) {
                listIdOfEngagement.add(engagementTitleListEle.get(i).getText());
                //                listIdOfEngagement.add(engagementTitleListEle.get(i).getAttribute("id"));
            }
        }
        return listIdOfEngagement;
    }

    /**
     * Find the new engagement which is just created.
     *
     * @param listIdOfEngagementBeforeCreate List Engagement ID before creating new one.
     * @param listIdOfEngagementAfterCreate  List Engagement ID after creating new one.
     * @return position of Engagement on Engagement page base on ID.
     */
    public int findNewEngagement(List<String> listIdOfEngagementBeforeCreate, List<String> listIdOfEngagementAfterCreate) {
        listIdOfEngagementAfterCreate.remove(listIdOfEngagementAfterCreate);
        if (!listIdOfEngagementBeforeCreate.isEmpty()) {
            for (int i = 0; i < listIdOfEngagementBeforeCreate.size(); i++) {
                String idOfEngagement = listIdOfEngagementBeforeCreate.get(i);
                for (int j = 0; j < listIdOfEngagementAfterCreate.size(); j++) {
                    if (idOfEngagement.equals(listIdOfEngagementAfterCreate.get(j))) {
                        listIdOfEngagementAfterCreate.remove(j);
                        break;
                    }
                }
            }

        }
        int sizeOflistIdOfEngagementAfterCreate = listIdOfEngagementAfterCreate.size();
        String idOfNewEngegement = listIdOfEngagementAfterCreate.get(sizeOflistIdOfEngagementAfterCreate - 1).toString();
        return findElementByAttribute(engagementTitleListEle, idOfNewEngegement, "id");
    }


    /**
     * Click Engagement on Engagement Page with the position of Engagement
     *
     * @param engagementPosition int the Engagement position which is clicked.
     */
    public void clickEngagementByPosition(int engagementPosition) throws InterruptedException {
        System.out.println("Size: " + engagementListEle.size());
        System.out.println(engagementListEle.get(engagementPosition));
        System.out.println("Position: " + engagementPosition);
        //        hoverElement(engagementListEle.get(engagementPosition), "Engagement View Ite");
        //        WebElement popUpCreateEngagement = getDriver().findElement(By.xpath("//*[@id='CreateEnagementParent']/../../../.."));
        waitForCssValueChanged(popUpCreateEngagement, "PopUp Create", "display", "none");
        //        Thread.sleep(3000);
        waitForClickableOfElement(engagementListEle.get(engagementPosition), "Engagement View Item");
        clickElement(engagementListEle.get(engagementPosition), "Engagement View Item");
        //        clickElement(engagementListEle.get(engagementPosition));
        //        hoverElement(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
        //        waitForClickableOfElement(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
        //        clickAndHold(engagementListEle.get(engagementPosition).findElement(By.xpath(viewButtonOnEngagement)), "Engagement View Item");
    }

    public void clickClientsLink() {
        waitForClickableOfElement(eleClientsLnk, "Client link");
        clickElement(eleClientsLnk, "Client link");
    }

    public void clickAddNewButton() {
        waitForClickableOfElement(eleAddNewBtn, "Add new button");
        clickElement(eleAddNewBtn, "Add new button");
    }

    public void clickdropDownSetingLink() {
        waitForClickableOfElement(eleSettingsLnk, "Drop down setting");
        clickElement(eleSettingsLnk, "Drop down setting");
    }

    public void clickAuditorNameDropDown() {
        waitForClickableOfElement(eleAuditorNameDrpDwn, "Auditor name drop down");
        clickElement(eleAuditorNameDrpDwn, "Auditor name drop down");
    }


    /**
     * verify UI of List Engagement page - Header
     */
    public void verifyUIListEngagementHeader() {
        try {
            validateAttributeContain(imageLogoHeaderBlue, "src", "images/logos/auvenir/auvenir.svg", "Logo Auvenir Blue");
            validateElementText(tabHeaderEngagements, "Engagements");
            validateElementText(tabHeaderContacts, "Contacts");
            clickElement(dashboardUsername, "Dashboard Username");
            validateElementText(dashboardSettings, "Settings");
            validateElementText(dashboardSignOut, "Sign Out");
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * verify UI of List Engagement page - Body
     */
    public void verifyUIListEngagementBody() {
        try {
            validateElementText(titlePreviewHeader, "All Engagements");
            validateElementText(buttonNewEngagement, "New Engagement");

            validateElementText(selectEngagementFilters, "Filter");
            clickElement(selectEngagementFilters, "Select Engagement Filters");
            validateElementText(optionFilterAll, "All");
            validateElementText(optionFilterTypeOfEngagement, "Type of Engagement");

            clickElement(optionFilterTypeOfEngagement, "Select Engagement Filters");
            validateElementsQuantity(listOptionTypeOfEngagement, 4, "List Option Type Of Engagement");
            validateElementText(optionTypeOfEngagementFinancialAudit, "Financial Audit");
            validateElementText(optionTypeOfEngagementReview, "Review");
            validateElementText(optionTypeOfEngagementNoticeToReaderCompilation, "Notice to Reader / Compilation");
            validateElementText(optionTypeOfEngagementOther, "Other");
            validatePlaceholder(inputEngagementSearch, "Search...", "Input Engagement Search");
            clickElement(inputEngagementSearch, "Input Engagement Search");

            validateElementText(thCompany, "Company");
            validateElementText(thEngagement, "Engagement Name");
            validateElementText(thStatus, "Status");
            validateElementText(thAudit, "Audit Assignee");
            validateElementText(thToDo, "Completed To-Dos");
            validateElementText(thClient, "Client Assignee");
            validateElementText(thDocs, "Completed Docs");
            validateElementText(thActivity, "Last Activity");
            validateElementText(thDueDate, "Due Date");
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * verify UI of List Engagement page - Footer
     */
    public void verifyUIListEngagementFooter() {
        try {
            validateElementText(titleCompanyInfo, "© 2017 Auvenir Inc. All rights reserved.");
            validateElementText(titleTermsOfService, "Terms of Service");
            validateAttributeContain(titleTermsOfService, "href", "terms", "Terms Of Service");
            validateElementText(titlePrivacyStatement, "Privacy Statement");
            validateAttributeContain(titlePrivacyStatement, "href", "privacy", "Privacy Statement");
            validateElementText(titleCookieNotice, "Cookie Notice");
            validateAttributeContain(titleCookieNotice, "href", "cookies", "Cookie Notice");
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }
    /*-----------end of huy.huynh on 08/06/2017.*/

    public void sendKeyCompanyName(String companyName) {
        try {
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleSearch, companyName, "search key keyCompany");
            Thread.sleep(smallTimeOut);
        } catch (InterruptedException e) {
            getLogger().info(e.getMessage());
        }
    }

    public void verifyCompanyName(String companyName) {
        try {
            getLogger().info("companyName = " + companyName);
            boolean isCheckCompany = false;
            if (waitForVisibleOfLocator(By.xpath(companyEleStr))) {
                for (WebElement companyEle : listCompanyEle) {
                    getLogger().info("companyEle.getText() = " + companyEle.getText());
                    Thread.sleep(1000);
                    if (companyEle.getText().equals(companyName)) {
                        isCheckCompany = true;
                        break;
                    }
                }
            }
            if (!isCheckCompany) {
                Assert.fail("Search engagement with company key: " + companyName);
            } else {
                getLogger().info("Search engagement with company key: " + companyName);
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    public void sendKeyEngagementName(String engagementName) {
        try {
            Thread.sleep(smallTimeOut);
            sendKeyTextBox(eleSearch, engagementName, "search key keyEngagement");
            Thread.sleep(smallTimeOut);
        } catch (InterruptedException e) {
            getLogger().info(e.getMessage());
        }
    }

    public void verifyEngagementName(String engagementName) {
        try {
            getLogger().info("engagementName = " + engagementName);
            boolean isCheckEngagement = false;
            //Checking for result
            if (waitForVisibleOfLocator(By.xpath(engagementNameStr))) {
                for (WebElement engagementNameEle : listEngagementNameEle) {
                    getLogger().info("engagementNameEle.getText() = " + engagementNameEle.getText());
                    Thread.sleep(1000);
                    if (engagementNameEle.getText().equals(engagementName)) {
                        isCheckEngagement = true;
                        break;
                    }
                }
            }
            if (!isCheckEngagement) {
                Assert.fail("Search engagement with engagement name key: " + engagementName);
            } else {
                getLogger().info("Search engagement with engagement name key: " + engagementName);
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

}