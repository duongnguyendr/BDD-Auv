package com.auvenir.ui.tests.groupPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.dataprovider.groupPermissions.GroupPermissionsDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.admin.AdminService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.client.ClientTeamService;
import com.auvenir.ui.services.groupPermissions.AdminAuditorService;
import com.auvenir.ui.services.marketing.AuditorSignUpService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by huy.huynh on 17/07/2017.
 */
public class AdminAuditorTest extends AbstractTest {
    private MarketingService marketingService;
    private AuditorEngagementService auditorEngagementService;
    private AdminAuditorService adminAuditorService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private ClientService clientService;
    private AuditorSignUpService auditorSignUpService;
    private AdminService adminService;
    private ClientTeamService clientTeamService;
    private AuditorToDoService auditorToDoService;

    @Test(priority = 1, enabled = true, description = "Verify admin auditor can create an engagement.", testName = "AA_1",
            dataProvider = "verifyAdminAuditorCreateAnEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCreateAnEngagement(String adminAuditorUser, String adminAuditorAuvenirPwd) {
        getLogger().info("Verify admin auditor can create an engagement.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();

            adminAuditorService.verifyCanCreateAnEngagement();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can create an engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can create an engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = true, description = "Verify admin auditor can see all engagements within firm.", testName = "AA_3",
            dataProvider = "verifyAdminAuditorSeeAllEngagementsWithinFirm", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorSeeAllEngagementsWithinFirm(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName1,
            String engagementName2) {
        getLogger().info("Verify admin auditor can see all engagements within firm.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        String engagementListNames[] = {engagementName1, engagementName2};
        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();

            adminAuditorService.verifyCanSeeAllEngagementsWithinFirm(Arrays.asList(engagementListNames));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can see all engagements within firm.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can see all engagements within firm.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 5, enabled = true, description = "Verify admin auditor cant invite client into engagement.", testName = "AA_5",
            dataProvider = "verifyAdminAuditorInviteClientIntoEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInviteClientIntoEngagement(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName1) {
        getLogger().info("Verify admin auditor can invite client into engagement.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            adminAuditorService.verifyCantInviteClientIntoEngagement();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can invite client into engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can invite client into engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 6, enabled = true, description = "Verify admin auditor can't invite general client into engagement.", testName = "AA_6",
            dataProvider = "verifyAdminAuditorInviteGeneralClientIntoEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorInviteGeneralClientIntoEngagement(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName1,
            String leadClientFullName, String leadClientUser, String roleClient, String successMessageInvitation, String adminUser, String adminPwd,
            String userType) {
        getLogger().info("Verify admin auditor can't invite general client into engagement.");
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        clientService = new ClientService(getLogger(), getDriver());
        adminService = new AdminService(getLogger(), getDriver());
        auditorSignUpService = new AuditorSignUpService(getLogger(), getDriver());
        clientTeamService = new ClientTeamService(getLogger(), getDriver());

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);
        leadClientUser = GenericService.addBrowserPrefix(leadClientUser);
        adminUser = GenericService.addBrowserPrefix(adminUser);

        try {
            auditorSignUpService.deleteUserUsingApi(leadClientUser);

            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName1);

            auditorDetailsEngagementService.navigateToTeamTab();
            clientTeamService.inviteNewMemberToTeam();
            clientService.fillInfoToInviteNewMember(leadClientFullName, leadClientUser, roleClient);
            clientService.verifyInviteClientSuccess(successMessageInvitation);

            marketingService.loginUsingUsernamePassword(adminUser, adminPwd);
            adminService.verifyPageLoad();
            adminService.scrollToFooter(getDriver());
            adminService.verifyUserTypeOnAdminUserTable(leadClientUser, userType);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify admin auditor can't invite general client into engagement.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Error: Verify admin auditor can't invite general client into engagement.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

    @Test(priority = 7, enabled = true, description = "To Verify Admin Auditor can not remove Auditor", testName = "AA_7",
            dataProvider = "verifyAdminAuditorCanNotRemoveAuditor", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotRemoveAuditor(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2,
            String leadAuditorFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorDetailsEngagementService.navigateToTeamTab();
            adminAuditorService.verifyAdminAuditorCanNotRemoveAuditor(leadAuditorFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not remove client from Engagement: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not remove client from Engagement: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 8, enabled = true, description = "To Verify Admin Auditor can not remove client from Engagement", testName = "AA_8",
            dataProvider = "verifyAdminAuditorCanNotRemoveClients", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotRemoveClients(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2,
            String leadClientFullName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            auditorDetailsEngagementService.navigateToTeamTab();
            adminAuditorService.verifyAdminAuditorCanNotRemoveClient(leadClientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not remove client from Engagement: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not remove client from Engagement: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 9, enabled = true, description = "To Verify Permission Admin Auditor see all to-dos", testName = "AA_9",
            dataProvider = "verifyAdminAuditorCanSeeAllToDosWithinEngagement", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanSeeAllToDosWithinEngagement(String adminAuditorUser, String adminAuditorAuvenirPwd, String engagementName2,
            String todo1, String todo2, String todo3, String todo4, boolean isToDo1Visible, boolean isToDo2Visible, boolean isToDo3Visible,
            boolean isToDo4Visible) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        String toDoNamesList[] = {todo1, todo2, todo3, todo4};
        Boolean todosVisibleList[] = {isToDo1Visible, isToDo2Visible, isToDo3Visible, isToDo4Visible};

        adminAuditorUser = GenericService.addBrowserPrefix(adminAuditorUser);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorUser, adminAuditorAuvenirPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);

            adminAuditorService.verifyCanSeeAllToDosWithinEngagement(Arrays.asList(toDoNamesList), Arrays.asList(todosVisibleList));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Permission Admin Auditor See ToDos: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 10, enabled = true, description = "Verify permission Admin Auditor see all to-dos assigned to them")
    public void verifyAdminAuditorCanSeeAllToDosAssignedToThem() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());

        String adminAuditorId = "chr.auvenirauditor@gmail.com";
        String adminAuditorPwd = "Changeit@123";
        String toDo1Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 1 name", "Valid Value");
        String toDo2Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 2 name", "Valid Value");
        String toDo3Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 3 name", "Valid Value");
        String toDo4Name = GenericService.getTestDataFromExcelNoBrowserPrefix("GroupPermissionTest", "To Do 4 name", "Valid Value");
        String engagementName2 = "Engagement Huy 02";

        boolean isToDo1Visible = true;
        boolean isToDo2Visible = true;
        boolean isToDo3Visible = true;
        boolean isToDo4Visible = true;

        String toDoNamesList[] = {toDo1Name, toDo2Name, toDo3Name, toDo4Name};
        Boolean todosVisibleList[] = {isToDo1Visible, isToDo2Visible, isToDo3Visible, isToDo4Visible};
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);

            adminAuditorService.verifyCanSeeAllToDosWithinEngagement(Arrays.asList(toDoNamesList), Arrays.asList(todosVisibleList));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Finish: Verify permission Admin Auditor see all to-dos assigned to them.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Fail: Verify permission Admin Auditor see all to-dos assigned to them", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 16, enabled = true, description = "Verify Admin Auditor can not mark todo completed.", testName = "AA-16")
    //    public void verifyAdminAuditorCanNotMarkTodoCompleted (String adminUser, String adminPassword, String engagementName2,
    //            String todo1, String todo2, String todo3, String todo4, String todo5, String todo6) throws Exception {
    public void verifyAdminAuditorCanNotMarkTodoCompleted() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
        //        listTodo.add(todo1);
        //        listTodo.add(todo2);
        //        listTodo.add(todo3);
        //        listTodo.add(todo4);
        //        listTodo.add(todo5);
        //        listTodo.add(todo6);
        listTodo.add("Todo 1");
        listTodo.add("Todo 2");
        listTodo.add("Todo 4");
        listTodo.add("Todo 5");
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotMarkCompleteTodo(listTodo);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not mark todo completed.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not mark todo completed: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 17, enabled = true, description = "Verify Admin Auditor cannot assign auditor.", testName = "AA-17")
    public void verifyAdminAuditorCanNotAssignAuditor() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
        //        listTodo.add(todo1);
        //        listTodo.add(todo2);
        //        listTodo.add(todo3);
        //        listTodo.add(todo4);
        //        listTodo.add(todo5);
        //        listTodo.add(todo6);
        listTodo.add("Todo 1");
        listTodo.add("Todo 2");
        listTodo.add("Todo 4");
        listTodo.add("Todo 5");
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotAssignAuditor(listTodo);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 13, enabled = true, description = "Verify Admin Auditor cannot create todo.", testName = "AA-13")
    public void verifyAdminAuditorCanNotCreateTodo() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);
            adminAuditorService.verifyAdminAuditorCannotCreateTodo();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 14, enabled = true, description = "Verify Admin Auditor cannot remove todo.", testName = "AA-14+15")
    public void verifyAdminAuditorCannotRemoveTodo() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String[] todoName = {"Todo 1"};
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotRemoveTodo(Arrays.asList(todoName));

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot create todo.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot create todo: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Admin Auditor cannot assign todo to lead client.", testName = "AA-18")
    public void verifyAdminAuditorCanNotAssignToDoToLeadClient() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
        listTodo.add("Todo 1");
        listTodo.add("Todo 2");
        listTodo.add("Todo 4");
        listTodo.add("Todo 5");
//        String [] listTodo = {"Todo 1", };
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String clientFullName = "Lead Client";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotAssignClient(listTodo, clientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to lead client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to lead client: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 18, enabled = true, description = "Verify Admin Auditor cannot assign todo to general client.", testName = "AA-19")
    public void verifyAdminAuditorCanNotAssignTodoToGeneralClient() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        List<String> listTodo = new ArrayList<>();
        listTodo.add("Todo 1");
        listTodo.add("Todo 2");
        listTodo.add("Todo 4");
        listTodo.add("Todo 5");
//        String [] listTodo = {"Todo 1", };
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String clientFullName = "General Client";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCannotAssignClient(listTodo, clientFullName);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to general client.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to general client: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 20, enabled = true, description = "Verify Admin Auditor cannot comment on todo they are not assign to.", testName = "AA-20")
    public void verifyAdminAuditorCanNotComment() throws Exception {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        //        listTodo.add(todo1);
        //        listTodo.add(todo2);
        //        listTodo.add(todo3);
        //        listTodo.add(todo4);
        //        listTodo.add(todo5);
        //        listTodo.add(todo6);
        String todoName = "Todo 4";
        String adminUser = "duong.auditor.adm@mailinator.com";
        String adminPassword = "Changeit@123";
        String engagementName2 = "Engagement Dr02";
        String comment = "";
        try {
            marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName2);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName2);

            adminAuditorService.verifyAdminAuditorCanNotCommentOnTodoNotAssign(todoName, comment);

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor cannot assign todo to auditor: FAILED", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    @Test(priority = 22, enabled = true, description = "To Verify Admin Auditor can not change request name ",
            dataProvider = "verifyAdminAuditorCanNotChangeRequestName", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotChangeRequestName(String adminAuditorId, String adminAuditorPwd, String engagementName, String todoName,
            String requequestName, String newRequestName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        adminAuditorId = GenericService.addBrowserPrefix(adminAuditorId);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(todoName);
            adminAuditorService.verifyAdminAuditorCanNotChangeRequestName(requequestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not change request Name : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not change request Name : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 23, enabled = true, description = "To Verify Admin Auditor can not delete request",
            dataProvider = "verifyAdminAuditorCanNotDeleteRequest", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotDeleteRequest(String adminAuditorId, String adminAuditorPwd, String engagementName, String todoName,
            String requestName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());
        adminAuditorId = GenericService.addBrowserPrefix(adminAuditorId);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameUneditable(todoName);
            adminAuditorService.verifyAdminAuditorCanNotDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 24, enabled = true, description = "To Verify Admin Auditor can not change Duedate.",
            dataProvider = "verifyAdminAuditorCanNotChangeDuedate", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotChangeDuedate(String adminAuditorId, String adminAuditorPwd, String engagementName, String todoName,
            String month, String day, String year) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        adminAuditorId = GenericService.addBrowserPrefix(adminAuditorId);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            adminAuditorService.verifyAdminAuditorCanNotChangeDueDate(todoName, month, day, year);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not change duedate : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not change duedate : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25, enabled = true, description = "To Verify Admin Auditor can not edit Category",
            dataProvider = "verifyAdminAuditorCanNotEditCategory", dataProviderClass = GroupPermissionsDataProvider.class)
    public void verifyAdminAuditorCanNotEditCategory(String adminAuditorId, String adminAuditorPwd, String engagementName, String todoName,
            String oldCategoryName, String newCategoryName) {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        adminAuditorId = GenericService.addBrowserPrefix(adminAuditorId);
        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            adminAuditorService.verifyAdminAuditorCanNotEditCategory(todoName, oldCategoryName, newCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify Admin Auditor can not edit any Category: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify Admin Auditor can not edit any Category: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 26, enabled = true, description = "To Verify Admin Auditor can see all file in an engagement")
    public void verifyAdminAuditorCanSeeAllFiles() {
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        adminAuditorService = new AdminAuditorService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorToDoService = new AuditorToDoService(getLogger(), getDriver());

        String adminAuditorId = "thuan.auditor.adm@mailinator.com";
        String adminAuditorPwd = "Changeit@123";
        String engagementName = "Engagement02";
        String toDo2 = "todo2";
        String toDo4 = "todo4";
        String toDo5 = "todo6";
        String listFile[] =
                {"test auvenir(delete).pdf", "test auvenir.docx", "test auvenir.jpg", "test auvenir.png", "test auvenir.txt", "test auvenir.xlsx"};

        try {
            marketingService.loginUsingUsernamePassword(adminAuditorId, adminAuditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.viewEngagementDetailsPage(engagementName);
            auditorDetailsEngagementService.verifyDetailsEngagementAtGeneralPage(engagementName);
            auditorToDoService.openTodoDetailsByTodoNameEditable(toDo2);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorToDoService.closePopupTodoDetail();
            auditorToDoService.openTodoDetailsByTodoNameEditable(toDo4);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorToDoService.closePopupTodoDetail();
            auditorToDoService.openTodoDetailsByTodoNameEditable(toDo5);
            adminAuditorService.verifyAdminAuditorCanSeeAllFileWithinToDo(Arrays.asList(listFile));
            auditorToDoService.closePopupTodoDetail();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Pass", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("verify Admin Auditor Can See All Files in an engagement: Fail", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
