package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.auditor.AuditorToDoListDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.client.ClientDetailsEngagementService;
import com.auvenir.ui.services.GmailLoginService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientSignUpService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.EmailTemplateService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


public class AuditorTodoTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;
    private MarketingService marketingService;
    private AuditorToDoService auditorToDoService;
    private AuditorSignUpService auditorSignUpService;


    String timeStamp;
    String firstEngagementTitleOnWeb;
    private ClientService clientService;
    private AdminService adminService;
    private GmailLoginService gmailLoginService;
    private EmailTemplateService emailTemplateService;
    private ClientSignUpService clientSignUpService;
    private ClientDetailsEngagementService clientDetailsEngagementService;
    int ToDoItemNumber = 4;

    @Test(priority = 1, enabled = true, description = "Verify Auditor empty Todo List page.", dataProvider = "verifyAuditorEmptyTodoListPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyAuditorEmptyTodoListPage(String auditorId, String auditorPwd, String engagementType, String companyName,
            String engagementName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();

            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);

            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyEmptyTodoList();
            auditorTodoListService.verifyTodoListPageColumnHeader();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.PASSED, null);
        } catch (Exception e) {
            getLogger().info(e);
            NXGReports.addStep("Verify Auditor empty Todo List page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 2, enabled = true, description = "Verify to create To-Do page and search data.",
            dataProvider = "verifyCreateToDoPageCategorySearchData", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCreateToDoPageCategorySearchData(String auditorId, String auditorPwd, String toDoName, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.verifyDataSearch();
            auditorCreateToDoService.verifyCheckMaxLength();
            auditorCreateToDoService.verifyContentTextSearch(toDoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify to create To-Do page, category and search data.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify new Category popup", dataProvider = "verifyNewCategoryPopup",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyNewCategoryPopup(String auditorId, String auditorPwd, String toDoName, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.verifyAddNewCategoryPopupTitle();
            auditorCreateToDoService.verifyNewCategoryNameTextbox();
            auditorCreateToDoService.verifyNewCategoryColorCombobox();
            auditorCreateToDoService.verifyNewCategoryCreateCancelButton();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 4, enabled = true, description = "verify displayed of this button filter", dataProvider = "verifyButtonFilter",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyButtonFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.verifyButtonFilter();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify displayed of this button filter", LogAs.PASSED, null);
        } catch (Exception e) {
            String stepException = "Verify displayed of this button filter failed because " + e.getMessage();
            NXGReports.addStep("verify displayed of this button filter", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),
                    stepException);
            throw e;
        }
    }

    @Test(priority = 5, enabled = true, description = "verify default value(Search...) of this Search", dataProvider = "verifySearchPlaceholder",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchPlaceholder(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);

            auditorCreateToDoService.verifySearchPlaceholder();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify default value(Search...) of this Search", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
        }
    }

    @Test(priority = 6, enabled = true, description = "verify when hover on Search change bounary color to green.",
            dataProvider = "verifySearchHover", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchHover(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);

            auditorCreateToDoService.verifySearchHover();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify when hover on Search change bounary color to green.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 7, enabled = true, description = "verify input text.", dataProvider = "verifySearchInputText",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifySearchInputText(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorCreateToDoService.inputSearchText("Search Todo");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify input text.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify input text.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 8, enabled = true, description = "Verify Data Grid after adding new To Do Task", dataProvider = "verifyDataGridToDoTaskPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDataGridToDoTaskPage(String auditorId, String auditorPwd, String engagementName, String[] toDoListNames) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createListToDoTask(Arrays.asList(toDoListNames));
            auditorCreateToDoService.verifySortDataGridIcon();
            auditorCreateToDoService.verifyCheckBoxToDoName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Data Grid after adding new To Do Task", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Data Grid after adding new To Do Task", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    //[PLAT 2289]: Verify 'Category' combo box on Create to-do
    @Test(priority = 9, enabled = true, description = "Verify 'Category' combo box on Create to-do",
            dataProvider = "verifyCategoryComboBoxOnCreateToDo", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCategoryComboxBoxOnCreateToDo(String auditorId, String auditorPwd, String engagementName, String toDoName,
            String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName, categoryName);
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyDefaultValueofCategoryComboBox();
            auditorCreateToDoService.verifyHoverCategoryComboBox();
            auditorCreateToDoService.verifyValueofCategoryComboBox(categoryName);
            auditorCreateToDoService.verifyNewCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCancelButtonOnPopup();
            auditorCreateToDoService.verifyEditCategoryPopUpDisplayed();
            auditorCreateToDoService.clickCancelButtonOnPopup();
            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task01 2289 without Category");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify 'Category' combo box on Create to-do", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify 'Category' combo box on Create to-do", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify Filter button next to create to-do button.",
            dataProviderClass = AuditorToDoListDataProvider.class, dataProvider = "verifyFilterButton")
    public void verifyFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyFilterDropDownList();
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Filter button next to create to-do button", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 11, enabled = true, description = "Verify default value on Filter dropdown.", dataProvider = "verifyDefaultValueFilterButton",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultValueFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyDefaultValueFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page: PASSED", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 12, enabled = true, description = "Verify border on Filter dropdown.", dataProvider = "verifyBorderOnFilterButton",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyBorderOnFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyHoverFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify border on Filter dropdown: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 13, enabled = true, description = "[PLAT 2283]: Verify default value on Filter dropdown.",
            dataProvider = "verifyChooseAnOptionFilterButton", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyChooseAnOptionFilterButton(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifySelectShowAllDropDownList();
            auditorTodoListService.verifySelectDueDateDropDownList();
            auditorTodoListService.selectAndVerifyFirstAssignFilterDropDownList();
            auditorTodoListService.verifySelectWithCommentsDropDownList();
            auditorTodoListService.verifySelectCompleteDropDownList();
            //OutStanding is not implemented by DEV team
            auditorTodoListService.verifySelectFlaggedForRequestDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify ChooseAnOption Filter Button: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }

    }

    @Test(priority = 14, enabled = true, description = "Verify Unable Add More Option Filter DropDownList",
            dataProvider = "verifyUnableAddMoreOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUnableAddMoreOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyUnableAddMoreOptionFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify ChooseAnOption Filter Button: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }

    }

    @Test(priority = 15, enabled = true, description = "verify select An VaLue On Assign Option Filter",
            dataProvider = "selectAnVaLueOnAssignOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void selectAnVaLueOnAssignOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;


        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.selectAndVerifyFirstAssignFilterDropDownList();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify select An VaLue On Assign Option Filter: PASSED.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    //[PLAT 2283]: verify click And Do Not Select Option Filter
    @Test(priority = 16, enabled = true, description = "[Verify click And Do Not Select Option Filter",
            dataProvider = "clickAndDoNotSelectOptionFilter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void clickAndDoNotSelectOptionFilter(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorTodoListService.verifyClickAndDoNotSelectValue();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("verify select An VaLue On Assign Option Filter: PASSED.", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify default value on Filter dropdown.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    //[PLAT 2282]-Verify To Do Name TextBox when Add new To Do
    @Test(priority = 17, enabled = true, description = "Verify To Do Name TextBox when Add new To Do", dataProvider = "verifyGUIToDoTextBox",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIToDoTextBox(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            //auditorDetailsEngagementService.navigateToTodoListPage();
            auditorTodoListService.verifyTodoListPage();

            int numberOfTask = auditorCreateToDoService.getNumberofToDoTask();
            auditorCreateToDoService.clickCreateToDoTask();
            auditorCreateToDoService.verifyGUIAddNewToDoNameTextBox(numberOfTask);
            auditorCreateToDoService.verifyInputDataToDoNameTextBox("Task01");
            auditorCreateToDoService.verifyInputMaxLengthToDoNameTextBox();
            auditorCreateToDoService.verifyInputInValidValueToDoNameTextBox();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify GUI auditor create to do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify GUI auditor create to do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    //[PLAT 2284]-Verify GUI Add Bulk Actions on To Do Page
    @Test(priority = 18, enabled = true, description = "Verify GUI Add Bulk Actions on To Do Page", dataProvider = "verifyGUIToDoAddBulkActions",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIToDoAddBulkActions(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();

            auditorCreateToDoService.createNewToDoTask("Task 01 2284");
            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.verifyDefaultValueofBulkActionsDropdown("Bulk Actions");
            auditorCreateToDoService.verifyHoverBulkActionsDropdown();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyListValueofBulkActionsDropdown();
            auditorCreateToDoService.clickDeleteToDoBulkActions();
            auditorCreateToDoService.verifyDeleteToDoPopUpDisplayed();
            auditorCreateToDoService.clickCloseButtonOnPopup();
            auditorCreateToDoService.verifyBulkActionsDropdownIsClosed();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify Add Bulk Actions on To do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify Add Bulk Actions on To do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 19, enabled = true, description = "Verify GUI of select date drop down in add new to-do page.",
            dataProvider = "verifyGUISelectDateDropDownInNewToDoPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUISelectDateDropDownInNewToDoPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Move to add new To-do page
            auditorCreateToDoService.navigateAddNewToDoPage();
            //Show Select date drop down
            auditorCreateToDoService.verifySelectDateDropDown();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of select date drop down on add new to-do page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of select date drop down on add new to-do page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "Verify mark as complete", dataProvider = "verifyMarkAsComplete",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyMarkAsComplete(String auditorId, String auditorPwd, String engagementName, String toDoName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);

            auditorCreateToDoService.createNewToDoTask(toDoName);
            auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.verifyClickCloseMarkPopup();

            auditorCreateToDoService.createNewToDoTask(toDoName);
            int index = auditorCreateToDoService.selectToDoTaskName(toDoName);
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            auditorCreateToDoService.clickArchiveTaskButton();
            auditorCreateToDoService.verifyMarkCompleteArchive(index);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify new Category popup", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify new Category popup", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }


    /**
     * (case)verify button Undo action exist
     */
    @Test(priority = 21, enabled = true, testName = "Verify GUI.", description = "verify Undo Button exist ", groups = "ui",
            dataProvider = "verifyButtonUndoExist", dataProviderClass = AuditorToDoListDataProvider.class)
    public void uiVerifyButtonUndoExist(String auditorId, String auditorPwd, String engagementName, String engagementType,
            String companyName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.uiVerifyButtonUndoExist();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify button Undo exist.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify button Undo exist.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify button Undo action disable
     */
    @Test(priority = 22, enabled = true, testName = "Undo arrow.", description = "verify button Undo action disable", groups = "ui",
            dataProvider = "verifyButtonUndoStatus", dataProviderClass = AuditorToDoListDataProvider.class)
    public void uiVerifyButtonUndoStatus(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName,
            String toDoName) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.uiVerifyButtonUndoDisable();

            auditorTodoListService.createToDoRecord(toDoName, "25");
            auditorTodoListService.chooseAndActAToDoWithName(toDoName, "Mark as complete", "");
            auditorTodoListService.uiVerifyButtonUndoEnable();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify button Undo status.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify button Undo status.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Complete a To-Do, verified change on database but UI
     */
    @Test(priority = 23, enabled = true, testName = "Undo successfully",
            description = "verify Undo action Complete a To-Do, verified change on " + "database but UI", groups = "workflow",
            dataProvider = "verifyUndoActionWithCompleteCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithCompleteCase(String auditorId, String auditorPwd, String engagementName, String engagementType,
            String companyName, String toDoName01, String toDoName02) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName01, "Mark as complete", "");
            auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, toDoName01, "true");

            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoComleteStatusByName(firstEngagementTitleOnWeb, toDoName01, "false");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Complete case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Complete case.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Assign to a To-Do, verified change on UI but database
     */
    @Test(priority = 24, enabled = true, testName = "Undo successfully",
            description = "verify Undo action Assign to a To-Do, verified change on UI" + " " + "but database", groups = "workflow",
            dataProvider = "verifyUndoActionWithAssignToCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithAssignToCase(String auditorId, String auditorPwd, String engagementName, String engagementType,
            String companyName, String toDoName01, String toDoName02) throws Exception {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName01, "Assign to", "huy assignee (auditor)");
            auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, toDoName01, "huy assignee");
            Thread.sleep(2000);
            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoAssigneeToName(firstEngagementTitleOnWeb, toDoName01, "huy huynh");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Assign to case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Assign to case.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    /**
     * (case)verify Undo action Delete a To-Do, verified change on database but UI
     */
    @Test(priority = 25, enabled = true, testName = "Undo successfully",
            description = "verify Undo action Delete a To-Do, verified change on " + "database but UI", groups = "workflow",
            dataProvider = "verifyUndoActionWithDeleteCase", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyUndoActionWithDeleteCase(String auditorId, String auditorPwd, String engagementName, String engagementType, String companyName,
            String toDoName01, String toDoName02) {
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {

            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();

            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, engagementType, companyName);
            auditorEngagementService.verifyAuditorEngagementPage();

            //delete later, business changed, dev code feature un-merge
            //            //TODO temporary code, remove later - always click on the first engagement on web pages, so following to get the title of first to verify on database
            //            firstEngagementTitleOnWeb = getDriver().findElement(By.xpath("//p[@class='e-widget-auditTitle'][1]")).getText();
            //            auditorEngagementService.viewEngagementDetailsPage("engagement" + timeStamp);
            //            auditorDetailsEngagementService.navigateToTodoListPage();

            auditorTodoListService.createToDoRecord(toDoName01, "25");
            auditorTodoListService.createToDoRecord(toDoName02, "26");

            auditorTodoListService.chooseAndActAToDoWithName(toDoName02, "Delete", "huy assignee (auditor)");
            auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, toDoName02, "INACTIVE");

            auditorTodoListService.undoAction();
            auditorTodoListService.verifyToDoDeleteStatusByName(firstEngagementTitleOnWeb, toDoName02, "ACTIVE");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Undo action with Delete case.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Undo action with Delete case.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }

    @Test(priority = 26, enabled = true, description = "Verify GUI of delete icon in ToDo page.", dataProvider = "verifyGUIDeleteIconInToDoListPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIDeleteIconInToDoListPage(String auditorId, String auditorPwd, String engagementName, String engagementType,
            String companyName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            //Login
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createAndSelectNewEnagement(engagementName, engagementType, companyName);
            // Verify trash to do icon
            auditorCreateToDoService.verifyTrashToDoIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify GUI of delete icon in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify GUI of delete icon in ToDo page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 27, enabled = true, description = "Verify default status of delete icon in ToDo page.",
            dataProvider = "verifyDefaultStatusDeleteIconInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultStatusDeleteIconInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Verify trash to do icon
            auditorCreateToDoService.verifyDefaultStatusTrashToDoIcon();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify default status of delete icon in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify default status of delete icon in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 28, enabled = true, description = "Verify gui of delete confirm popup in ToDo page.",
            dataProvider = "verifyGUIDeleteConfirmPopupInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyGUIDeleteConfirmPopupInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String todoName = "ToDo" + dateFormat.format(date);
            // Add one To-Do name
            ArrayList<String> toDoListNames = new ArrayList<String>();
            toDoListNames.add(todoName);
            // Create To-Do follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // verify GUI delete confirm popup
            auditorCreateToDoService.verifyGUIDeleteConfirmPopup();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify gui of delete confirm popup in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 29, enabled = true, description = "Verify work flow of 'CheckAll' check box in ToDo page.",
            dataProvider = "verifyCheckAllCheckBoxInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCheckAllCheckBoxInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            //Check on 'Check all' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            //Verify all check box is checked
            auditorCreateToDoService.verifyAllCheckBoxIsCheckOrUnCheck(true);
            //Un Check on 'Check all' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(false);
            //Verify all check box is un checked
            auditorCreateToDoService.verifyAllCheckBoxIsCheckOrUnCheck(false);
            //Check all check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            //Verify 'CheckAll' check box is check
            auditorCreateToDoService.verifyCheckAllCheckBoxIsCheckOrUncheck(true);
            //Uncheck all check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(false);
            //Verify 'CheckAll' check box is uncheck
            auditorCreateToDoService.verifyCheckAllCheckBoxIsCheckOrUncheck(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of 'CheckAll' check box in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 30, enabled = true, description = "Verify work flow of delete button in ToDo page.",
            dataProvider = "verifyWorkFlowOfDeleteButtonInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteButtonInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create To-Do name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, 1);
            // Create To-Do follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoIsExists(false, todoName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 31, enabled = true, description = "Verify work flow of cancel button in ToDo page.",
            dataProvider = "verifyWorkFlowOfCancelButtonInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelButtonInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create To-Do name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, 1);
            // Create To-Do follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select To-Do has just created
            auditorCreateToDoService.selectToDoTaskName(todoName);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickCancelButtonOnPopup();
            // Check To-Do has exists
            auditorCreateToDoService.checkToDoIsExists(true, todoName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel button in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


    /* Edit Categories Test into this page */
    @Test(priority = 32, enabled = true, description = "Verify EditCategories GUI ", dataProvider = "verifyDefaultEditCategoryGuiAtCreateNewTodoPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDefaultEditCategoryGuiAtCreateNewTodoPage(String auditorId, String auditorPwd, String categoryName01, String categoryName02,
            String categoryName03) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorCreateToDoService.navigateToDoListPage();
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategory(categoryName01, categoryName02, categoryName03);
            auditorEditCategoryService.returnToCreateNewTodoPage();
            auditorEditCategoryService.navigateToEditAtCreateTodoPage();
            auditorEditCategoryService.verifyEditCategoriesTitle();
            auditorEditCategoryService.verifyEditCategoriesGuide();
            auditorEditCategoryService.hoverOnCategoryItem();
            auditorEditCategoryService.verifyDefaultSaveButton();
            auditorEditCategoryService.verifyDefaultCancelButton();
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Default PopUp GUI.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 33, enabled = true, description = "Verify Edit Function", dataProvider = "verifyEditFunctionAtCreateNewTodoPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyEditFunctionAtCreateNewTodoPage(String auditorId, String auditorPwd, String engagementName, String categoryName,
            String editCategoryName, String numberCategoryName, String nullCategoryName, String specialCategoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createCategories(categoryName);
            auditorCreateToDoService.navigateToEditNewCategory();
            getLogger().info("Verifying Edit valid value..");
            auditorEditCategoryService.editValidValue(editCategoryName);
            auditorEditCategoryService.verifyValidValue(editCategoryName);
            getLogger().info("Verifying Edit only number..");
            auditorEditCategoryService.editOnlyNumber(Integer.valueOf(numberCategoryName));
            auditorEditCategoryService.verifyNumber(Integer.valueOf(numberCategoryName));
            getLogger().info("Verifying Edit null chars..");
            auditorEditCategoryService.editNullChars(nullCategoryName);
            auditorEditCategoryService.verifyNullChars(nullCategoryName);
            getLogger().info("Verifying Edit Special chars..");
            auditorEditCategoryService.editSpecialChars(specialCategoryName);
            auditorEditCategoryService.verifySpecialChars(specialCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Edit Fuction.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Edit Fuction.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    /* PLAT2291: Verify Remove function */
    @Test(priority = 34, enabled = true, description = "Verify Remove function", dataProvider = "verifyRemoveFunctionAtTodoListPage",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyRemoveFunctionAtTodoListPage(String auditorId, String auditorPwd, String engagementName, String categoryName01,
            String categoryName02, String categoryName03) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEditCategoryService = new AuditorEditCategoryService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;

        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.createMultiCategory(categoryName01, categoryName02, categoryName03);
            auditorCreateToDoService.navigateToEditNewCategory();
            getLogger().info("Verifying remove 1 item..");
            auditorEditCategoryService.removeItem(1);
            getLogger().info("Verifying remove multi items..");
            auditorEditCategoryService.removeItem(2);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Remove function.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Remove Function.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    /**
     * PLAT-2286 : Add new test suite : delete and cancel when user select multi ToDo item - Start
     */


    @Test(priority = 35, enabled = true, description = "Verify work flow of delete multi ToDo item in ToDo page.",
            dataProvider = "verifyWorkFlowOfDeleteMultiToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteMultiToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create ToDo name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo list has just created
            auditorCreateToDoService.selectMultiToDoTaskByNameList(toDoListNames);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoListIsExists(false, toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 36, enabled = true, description = "Verify work flow of delete all ToDo item in ToDo page.",
            dataProvider = "verifyWorkFlowOfDeleteAllToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfDeleteAllToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create ToDo name list
            String todoName = "ToDoDelete";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnDeleteButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkAllToDoIsDelete();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of delete all ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 37, enabled = true, description = "Verify work flow of cancel multi ToDo item in ToDo page.",
            dataProvider = "verifyWorkFlowOfCancelMultiToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelMultiToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create To-Do name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Select ToDo list has just created
            auditorCreateToDoService.selectMultiToDoTaskByNameList(toDoListNames);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkToDoListIsExists(true, toDoListNames);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel multi ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 38, enabled = true, description = "Verify work flow of cancel all ToDo item in ToDo page.",
            dataProvider = "verifyWorkFlowOfCancelAllToDoInToDoListPage", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyWorkFlowOfCancelAllToDoInToDoListPage(String auditorId, String auditorPwd, String engagementName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            // Move to engagement page
            auditorEngagementService.verifyAuditorEngagementPage();
            // Move to engagement detail page
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            // Create ToDo name list
            String todoName = "ToDoCancel";
            List<String> toDoListNames = auditorCreateToDoService.createToDoNameList(todoName, ToDoItemNumber);
            // Create ToDo follow name list
            auditorCreateToDoService.createListToDoTask(toDoListNames);
            // Check on 'CheckAll' check box
            auditorCreateToDoService.checkOrUnCheckCheckAllCheckBox(true);
            // Click on trash delete icon
            auditorCreateToDoService.clickOnTrashIcon();
            // Verify work flow of delete button
            auditorCreateToDoService.clickOnCancelButtonOnPopup();
            // Check To-Do has not exists
            auditorCreateToDoService.checkAllToDoIsDelete();

            Assert.assertFalse(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify work flow of cancel all ToDo in ToDo page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify work flow of cancel all ToDo in ToDo page.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    /**
     * PLAT-2286 : Add new test suite : delete and cancel when user select multi ToDo item - End
     */

    /**
     * Added by duong.nguyen on 22/05/2017.
     * Scenarios : PLAT 2305 - Backend Mark To-Do as complete
     */
    @Test(priority = 39, enabled = true, description = "PLAT-2305: Verify DB update completed field is true when archive mart as completed.",
            dataProvider = "verifyCompletedFieldUpdateSuccessful", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCompletedFieldUpdateSuccessful(String auditorId, String auditorPwd, String engagementName, String toDoName,
            String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        Random random = new Random();
        String engagementName = "Engagement-PLAT-2350" + random.nextInt(1000);
        String taskName = "Task-2305" + random.nextInt(1000);*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName, categoryName);
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCompleteMarkPopup();
            //Check status of completed field after archive mark as completed. Expected: true
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "true");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify DB update field completed is true when archive mart as completed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 40, enabled = true, description = "PLAT-2305: Verify DB not update field completed is true when cancel mart as completed.",
            dataProvider = "verifyCancelCompleteAction", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyCancelCompleteAction(String auditorId, String auditorPwd, String engagementName, String toDoName,
            String categoryName) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorNewEngagementService = new AuditorNewEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.sBrowserData + auditorId;
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        Random random = new Random();
        String engagementName = "Engagement-PLAT-2350" + random.nextInt(1000);
        String taskName = "Task-2305" + random.nextInt(1000);*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.navigateToNewEngagementPage();
            auditorNewEngagementService.verifyNewEngagementPage();
            auditorNewEngagementService.enterDataForNewEngagementPage(engagementName, "", "Company Auvenir");
            //will implement later, current we can not navigate engagment by name
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.createToDoTaskWithCategoryName(toDoName, categoryName);
            //Check status of completed field before mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");
            auditorCreateToDoService.clickCheckboxNewToDoTask();
            auditorCreateToDoService.clickBulkActionsDropdown();
            auditorCreateToDoService.verifyCancelCompleteMarkPopup();
            auditorTodoListService.verifyTodoListPage();
            //Check status of completed field after cancel mark as completed. Expected: false
            auditorTodoListService.verifyCompletedFieldUpdated(engagementName, toDoName, "false");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify DB not update field completed is true when cancel mart as completed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 41, enabled = true, description = "Verify notification email when Auditor invite a lead client",
            dataProvider = "verifyNotificationAuditorInviteClient", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyNotificationAuditorInviteClient(String auditorId, String auditorPwd, String engagementName, String clientId,
            String clientEmailPassword, String clientFullName, String auditorFullName, String subjectContent, String greetingContent,
            String announcementContent, String introducingContent, String introducingBenefitContent, String firstBenefitContent,
            String secondBenefitContent, String thirdBenefitContent, String feedBackContent, String goodbyeContent) throws Exception {

        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        emailTemplateService = new EmailTemplateService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        auditorId = GenericService.addBrowserPrefix(auditorId);
        clientId = GenericService.addBrowserPrefix(clientId);

        //        String phoneNumber = "0123456789";
        //        String parentStackHolder = "Titancorpvn";
        //
        //        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Password", "Valid Value");

        try {
            MongoDBService.removeClientAndIndicatedValueByEmail(clientId);
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);
            marketingService.loginUsingUsernamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);

            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess("Your engagement invitation has been sent.");

            gmailLoginService.gmailReLogin(clientEmailPassword);
            gmailLoginService.selectActiveEmaill();

            emailTemplateService.verifySubjectEmailAuditorInviteClient(auditorFullName, subjectContent);
            emailTemplateService.verifyGreetingContentEmailAuditorInviteClient(clientFullName, greetingContent);
            emailTemplateService.verifyAnnouncementEmailAuditorInviteClient(auditorFullName, announcementContent);
            emailTemplateService.verifyAuvenirIntroducingContent(introducingContent);
            emailTemplateService.verifyBenefitContentEmailAuditorInviteClient(introducingBenefitContent, firstBenefitContent, secondBenefitContent,
                    thirdBenefitContent);
            emailTemplateService.verifyFeedbackContent(feedBackContent);
            emailTemplateService.verifyGoodbyeContent(goodbyeContent);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 42, enabled = true, description = "Verify Todos Textbox", dataProvider = "verifyTodosTextBox",
                                            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyTodosTextBox(String auditorId, String auditorPwd, String engagementName,
                                    String validTodo, String number, String specialChars,
            String deadlineDate, String endDate, String startDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String number = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Todo Name  01");
        String specialChars = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Todo Name  01");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.verifyTodosTextBox_AfterClickedAddTodo();
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            auditorCreateToDoService.verifyInputValidValue(validTodo);
            auditorCreateToDoService.inputOnlyNumber(number);
            auditorCreateToDoService.verifyInputNumber(number);
            auditorCreateToDoService.InputSpecialChar(specialChars);
            auditorCreateToDoService.verifyInputSpecialChar(specialChars);
            auditorCreateToDoService.inputNullChar("");
            auditorCreateToDoService.verifyInputNullChar("");
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Todos Textbox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Todos Textbox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 43, enabled = true, description = "Verify Category Combo box", dataProvider = "verifyCategoryComboBox", dataProviderClass =
                                        AuditorToDoListDataProvider.class)
    public void verifyCategoryComboBox(String auditorId, String auditorPwd, String engagementName,
                                       String validTodo, String categoryName1,String categoryName2,
                                       String deadlineDate, String endDate, String startDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String categoryName1 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 01");
        String categoryName2 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 02");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            //            auditorCreateToDoService.createNewToDoTask(validTodo);
            auditorCreateToDoService.verifyCategoryComboBox_DefaultValue();
            auditorCreateToDoService.createCategories(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            auditorCreateToDoService.createCategories(categoryName2);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName2);
            auditorCreateToDoService.selectCategoryByName(categoryName1);
            auditorCreateToDoService.verifyCategoryComboBox_NewValue(categoryName1);
            //            auditorCreateToDoService.verifyCheckMaxLength_CategoryName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Category Combo box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Category Combo box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 44, enabled = true, description = "Verify that Auditor can invite a client", dataProvider = "verifyAuditorInvitingTheClient",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyAuditorInvitingTheClient(String clientId, String clientEmailPassword, String clientFullName,
                                               String adminId, String adminPassword, String auditorId, String auditorPwd, String engagementName,
                                               String deadlineDate, String endDate, String startDate,
                                               String engagementMessage, String clientStatus)throws Exception {
        getLogger().info("Verify Auditor inviting a client.");
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        adminId = GenericService.addBrowserPrefix(adminId);
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String adminId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Admin Auvenir Password");
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/

        //        timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        //   MongoDBService.removeUserObjectByEmail(MongoDBService.getCollection("users"), clientId);
        // MongoDBService.removeEngagementObjectByName(MongoDBService.getCollection("engagements"), engagementName);
        //need precondition for save engagement name, and delete this engagement or client on acl
        try {
            gmailLoginService.deleteAllExistedEmail(clientId, clientEmailPassword);
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorTodoListService.navigateToInviteClientPage();
            clientService.selectAddNewClient();
            clientService.fillInfoToInviteNewClient(clientFullName, clientId, "");
            clientService.verifyInviteClientSuccess(engagementMessage);
            marketingService.loginUsingUsernamePassword(adminId, adminPassword);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserStatusOnAdminUserTable(clientId, clientStatus);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Auditor inviting a client.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 45, enabled = true, description = "Verify that Client logs in and OnBoarding page is displayed", dataProvider =
                                          "verifyClientLogsInAndActive", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyClientLogsInAndActive(String clientId,String clientEmailPassword,String  clientAuvenirPassword,
                                            String engagementName,String  phoneNumber,String  parentStackHolder) throws Exception {
        getLogger().info("Verify client logs in and OnBoarding page is displayed.");
        gmailLoginService = new GmailLoginService(getLogger(), getDriver());
        clientSignUpService = new ClientSignUpService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementService(getLogger(), getDriver());

        /*String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Va*//*lue", "Engagement Name");*/
        //        MongoDBService.changeUserObjectField(MongoDBService.getCollection("users"), clientId, "status", "ONBOARDING");

        try {
            gmailLoginService.navigateToURL(GenericService.getConfigValue(GenericService.sConfigFile, "GMAIL_URL"));
            gmailLoginService.signInGmail(clientId, clientEmailPassword);
            gmailLoginService.filterEmail();
            gmailLoginService.navigateAuvenirFromInvitationLink();
            clientSignUpService.navigateToSignUpForm();
            clientSignUpService.fillUpPersonalForm(phoneNumber);//10 number required
            clientSignUpService.fillUpBusinessForm(parentStackHolder);
            clientSignUpService.fillUpBankForm();
            clientSignUpService.fillUpFileForm();
            clientSignUpService.fillUpSecurityForm(clientAuvenirPassword);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client logs in and OnBoarding page is displayed.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 46, enabled = true, description = "Verify Client Assignee Combo box", dataProvider = "verifyClientAssigneeComboBox",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyClientAssigneeComboBox(String auditorId,String auditorPwd,String clientFullName, String engagementName,
                                             String deadlineDate, String endDate, String startDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyClientAssigneeComboBox_DefaultValue();
            auditorCreateToDoService.selectClientAssignee(clientFullName);
            auditorCreateToDoService.verifyClientAssigneeIsSelectedCorrectly(clientFullName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 47, enabled = true, description = "Verify Due date Time box", dataProvider = "verifyDueDateTimebox", dataProviderClass =
                                        AuditorToDoListDataProvider.class)
    public void verifyDueDateTimebox(String auditorId,String auditorPwd,String engagementName,String deadlineDate,String endDate,String startDate,
                                     String sMonth,String sDate,String sYear, String sCorrectDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyDuedateTimebox_DefaultValue(deadlineDate);
            //            auditorCreateToDoService.checkFormatDueDate();
            //            auditorCreateToDoService.verifyUnableToInputDuedate("12/4/2017");
            auditorCreateToDoService.chooseDateItemInDatePicker(sMonth, sDate, sYear);
            auditorCreateToDoService.verifyDateSelectedCorrectly(sCorrectDate);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Due date Time box.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Due date Time box.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 48, enabled = true, description = "Verify Audit Assignee box", dataProvider = "verifyAuditAssigneeBox", dataProviderClass =
                            AuditorToDoListDataProvider.class)
    public void verifyAuditAssigneeBox(String auditorId,String auditorPwd,String engagementName,
                                       String deadlineDate,String endDate,String startDate,
                                       String auditAssigneeDefault) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyAuditAssigneeBox(auditAssigneeDefault);
            //            auditorCreateToDoService.verifyAuditAssigneeIsSelectedCorrectly();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 49, enabled = true, description = "Verify CreateNewTodo, Filter, BulkAction buttons", dataProvider = "verifyTodoPage_Buttons",
                                dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyTodoPage_Buttons(String auditorId,String auditorPwd,String engagementName,
                                       String deadlineDate,String endDate,String startDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyCreateTodoBtn();
            auditorCreateToDoService.verifyFilterBtn();
            auditorCreateToDoService.verifyBulkActionBtn();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Buttons of Todo Page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 50, enabled = true, description = "Verify SearchBox", dataProvider = "verifySearchBox", dataProviderClass =
                        AuditorToDoListDataProvider.class)
    public void verifySearchBox(String auditorId,String auditorPwd,String engagementName,
                                String deadlineDate,String endDate,String startDate,
                                String searchText,String searchNumber,String searchSpecialCharacter) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String searchText = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Search Input");
        String searchNumber = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Search Input");
        String searchSpecialCharacter = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Search Input");*/

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifySearchBox_DefaultGUI();
            auditorCreateToDoService.inputSearchText(searchText);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.inputSearchNumber(searchNumber);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.inputSearchCharacter(searchSpecialCharacter);
            auditorCreateToDoService.verifySearchWhileInput();
            auditorCreateToDoService.verifyCheckMaxLength();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 51, enabled = true, description = "Verify realtime Search", dataProvider = "verifyRealTimeSearch", dataProviderClass =
                                                AuditorToDoListDataProvider.class)
    public void verifyRealTimeSearch(String auditorId, String auditorPwd, String engagementName, String deadlineDate,
                                     String endDate, String startDate, String validTodo, String categoryName3, String clientFullName, String
                                       auditAssigneeDefault, String sMonth, String sDate, String sYear) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  02");
        String categoryName3 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 03");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");*/

        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.navigatetoCreateToDoTab();
            auditorCreateToDoService.inputValidValue_TodoName(validTodo);
            auditorCreateToDoService.createCategories(categoryName3);
            auditorCreateToDoService.selectClientAssignee(clientFullName);
            auditorCreateToDoService.chooseDateItemInDatePicker(sMonth, sDate, sYear);
            auditorCreateToDoService.inputSearchText(validTodo);
            auditorCreateToDoService.verifySearchResult(validTodo);
            auditorCreateToDoService.inputSearchText(categoryName3);
            auditorCreateToDoService.verifySearchResult(categoryName3);
            auditorCreateToDoService.inputSearchText(clientFullName);
            auditorCreateToDoService.verifySearchResult(clientFullName);
            auditorCreateToDoService.inputSearchText(auditAssigneeDefault);
            auditorCreateToDoService.verifySearchResult(auditAssigneeDefault);
            auditorCreateToDoService.inputSearchText("you can input anything");
            auditorCreateToDoService.verifySearchResutlNotMatch();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 52, enabled = true, description = "Verify Data Grid", dataProvider = "verifyDataGrid", dataProviderClass =
            AuditorToDoListDataProvider.class)
    public void verifyDataGrid(String auditorId, String auditorPwd, String engagementName,
                               String deadlineDate, String endDate, String startDate) throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");*/
        try {
            marketingService.goToAuvenirMarketingPageURL();
            marketingService.selectLoginBtn();
            marketingService.loginWithUserPwd(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName, deadlineDate, endDate, startDate);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            auditorCreateToDoService.verifyColumnsInGrid();
            auditorCreateToDoService.verifySortIconOnTitle();
            auditorCreateToDoService.verifySortDataGridIcon();
            auditorCreateToDoService.verifyCheckAllCheckBox();
            auditorCreateToDoService.verifyUncheckAllCheckbox();
            auditorCreateToDoService.verifyCheckBoxToDoName();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify SearchBox.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Client Assignee ComboBox.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 53, enabled = true, description = "Verify UI on Todo Detail Popup.", dataProvider = "verifyDueDateOnToDoDetailsUI",
            dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsUI(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify UI on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify UI on Todo Detail Popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify UI on Todo Detail Popup.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 54, enabled = true, description = "Verify Default Value on Todo Detail Popup.", dataProvider =
            "verifyDueDateOnToDoDetailsDefaultValue", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsDefaultValue(String auditorId, String auditorPassword, String engagementName,
                                                        String todoName, String dueDate) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String dueDate = "";*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify Default Value on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify Default Value on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify Default Value on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 55, enabled = true, description = "Verify Date Format on Todo Detail Popup.", dataProvider =
            "verifyDueDateOnToDoDetailsDateFormat", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsDateFormat(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerDateFormat();
            //auditorToDoService.verifyDatePickerShow();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify Date Format on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify Date Format on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify Date Format on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 56, enabled = true, description = "Verify date picker when mouse hover on a date.", dataProvider =
            "verifyDueDateOnToDoDetailsHoverOnField", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsHoverOnField(String auditorId, String auditorPassword,
                                                       String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyHoverOnField();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker when mouse hover on a date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker when mouse hover on a date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker when mouse hover on a date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 57, enabled = true, description = "Verify date picker focusing to the current due date.", dataProvider =
            "verifyDueDateOnToDoDetailsFocusingCurrentDueDate", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsFocusingCurrentDueDate(String auditorId, String auditorPassword,
                                                                 String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyDueDateFocusing();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker focusing to the current due date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker focusing to the current due date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker focusing to the current due date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 58, enabled = true, description = "Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.",
            dataProvider = "verifyDatePickerOnToDoDetailsDisableDateAfterDueDate", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDatePickerOnToDoDetailsDisableDateAfterDueDate(String auditorId, String auditorPassword,
                                                                     String engagementName, String todoName, String engagementDueDate) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        /*String engagementDueDate = "";*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            engagementDueDate = auditorToDoService.getEngagementDueDate();
            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDatePickerShow();

            auditorToDoService.verifyDisableDateAfterDueDate(engagementDueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker Disable Date after Engagement Due Date on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 59, enabled = true, description = "Verify dueDate on Todo Detail Popup when choose another date.", dataProvider =
            "verifyDueDateOnToDoDetailsChooseAnotherDate", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsChooseAnotherDate(String auditorId,String auditorPassword,
                                                            String engagementName, String todoName, int selectDate) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        int date;*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.openDatePickerOnTodoDetail();
            selectDate = auditorToDoService.getValidDateHasIndex(0);
            auditorToDoService.changeDueDateOnTodoDetail(0);
            auditorToDoService.verifyChoosingAnotherDate(selectDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup when choose another date.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 60, enabled = true, description = "Verify date picker previous month icon.", dataProvider =
            "verifyDueDateOnToDoDetailsDatePickerPreviousMonthIcon", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsDatePickerPreviousMonthIcon(String auditorId, String auditorPassword, String engagementName,
            String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        String monthYear = "";
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.resetEngagementDueDateToNextMonth(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.openDatePickerOnTodoDetail();

            auditorToDoService.goToNextMonth();
            monthYear = auditorToDoService.getMonthYearTitle();
            auditorToDoService.goToPreviousMonth();
            auditorToDoService.verifyPreviousMonthIcon(monthYear);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker previous month icon.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify date picker previous month icon.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify date picker previous month icon.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 61, enabled = true, description = "Verify date picker next month icon.", dataProvider =
            "verifyDueDateOnToDoDetailsDatePickerNextMonthIcon", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsDatePickerNextMonthIcon(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        String monthYear = "";
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.resetEngagementDueDateToNextMonth(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.openDatePickerOnTodoDetail();

            monthYear = auditorToDoService.getMonthYearTitle();
            auditorToDoService.goToNextMonth();
            auditorToDoService.verifyNextMonthIcon(monthYear);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify date picker next month icon.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports
                    .addStep("Error: Verify date picker next month icon.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports
                    .addStep("Error: Verify date picker next month icon.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 62, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Date Time.", dataProvider =
            "verifyDueDateOnToDoDetailsInputDateTime", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsInputDateTime(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);


            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("07/04/2017");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Date Time.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 63, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Text.", dataProvider =
            "verifyDueDateOnToDoDetailsInputText", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsInputText(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("abc xyz");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Text.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 64, enabled = true, description = "Verify dueDate on Todo Detail Popup can't input Special Character.", dataProvider =
            "verifyDueDateOnToDoDetailsInputSpecialCharacter", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsInputSpecialCharacter(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.inputToDueDate("~!@#$%^&*+?><,.");

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup can't input Special Character.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 65, enabled = true, description = "Verify change dueDate on Todo Detail Popup.", dataProvider =
            "verifyDueDateOnToDoDetailsChangeDueDateOnTodoDetail", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsChangeDueDateOnTodoDetail(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        String dueDate = "";
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.openDatePickerOnTodoDetail();
            auditorToDoService.changeDueDateOnTodoDetail(0);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify change dueDate on Todo Detail Popup.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Detail Popup.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 66, enabled = true, description = "Verify change dueDate on Todo Row.", dataProvider =
            "verifyDueDateOnToDoDetailsChangeDueDateOnTodoRow", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsChangeDueDateOnTodoRow(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        String dueDate = "";
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);

            auditorCreateToDoService.createNewToDoTask(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);

            auditorToDoService.changeDueDateOnTodoRow(todoName, 1);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify change dueDate on Todo Row.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify change dueDate on Todo Row.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

    @Test(priority = 67, enabled = true, description = "Verify dueDate on Todo Detail Popup is match with on Todo Row.", testName = "dp_",
            dataProvider = "verifyDueDateOnToDoDetailsMatchWithOnToDoRow", dataProviderClass = AuditorToDoListDataProvider.class)
    public void verifyDueDateOnToDoDetailsMatchWithOnToDoRow(String auditorId, String auditorPassword, String engagementName, String todoName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        //clientService = new ClientService(getLogger(), getDriver());
        auditorId = GenericService.addBrowserPrefix(auditorId);
        /*auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");*/
        String dueDate = "";
        try {
            marketingService.loginUsingUsernamePassword(auditorId, auditorPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createOrViewDetailsEngagement(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementPage(engagementName);


            auditorCreateToDoService.createNewToDoTask(todoName);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            auditorToDoService.openDatePickerOnTodoDetail();
            auditorToDoService.changeDueDateOnTodoDetail(0);
            auditorToDoService.closePopupTodoDetail();
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            auditorToDoService.closePopupTodoDetail();
            auditorToDoService.changeDueDateOnTodoRow(todoName, 0);
            dueDate = auditorToDoService.getToDoDueDateOnRow(todoName);
            auditorToDoService.openPopupTodoDetail(todoName);
            auditorToDoService.verifyDueDateMatching(dueDate);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.PASSED, null);
        } catch (AssertionError e) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        } catch (Exception ex) {
            NXGReports.addStep("Error: Verify dueDate on Todo Detail Popup is match with on Todo Row.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw ex;
        }
    }

}




