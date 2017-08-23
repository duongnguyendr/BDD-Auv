package com.auvenir.ui.tests.groupPermissions;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.pages.client.engagement.ClientDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorToDoService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.client.ClientTodoService;
import com.auvenir.ui.services.groupPermissions.GeneralClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class GeneralClientTest extends AbstractTest {
    private MarketingService marketingService;
    private ClientEngagementService clientEngagementService;
    private ClientDetailsEngagementPage clientDetailsEngagementService;
    private GeneralClientService generalClientService;
    private ClientTodoService clientTodoService;

    @Test(priority = 22, enabled = true, description = "To Verify general Client can not change request name ")
    public void verifyGeneralClientCanNotChangeRequestName() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        generalClientService = new GeneralClientService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(), getDriver());

        String generalClientId = "chr.vienpham.client@gmail.com";
        String generalClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "request1";
        String newRequestName = "request1 modify";
        try {
            marketingService.loginUsingUsernamePassword(generalClientId, generalClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientTodoService.openTodoDetailsByTodoNameUneditable(todoName);
            generalClientService.verifyGeneralClientCanNotChangeRequestName(requestName, newRequestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can not change request Name : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can not change request Name : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 23, enabled = true, description = "To Verify general client can not delete request")
    public void verifyGeneralClientCanNotDeleteRequest() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
        generalClientService = new GeneralClientService(getLogger(), getDriver());
        clientTodoService = new ClientTodoService(getLogger(),getDriver());

        String generalClientId = "chr.vienpham.client@gmail.com";
        String generalClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String requestName = "request1";
        try {
            marketingService.loginUsingUsernamePassword(generalClientId, generalClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            clientTodoService.openTodoDetailsByTodoNameUneditable(todoName);
            generalClientService.verifyGeneralClientCanNotDeleteRequest(requestName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general client can not delete request: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general client can not delete request: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    @Test(priority = 24, enabled = true, description = "To Verify general client can not change Duedate.")
    public void verifyGeneralClientCanNotChangeDuedate() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(),getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(),getDriver());
        generalClientService = new GeneralClientService(getLogger(), getDriver());
        String generalClientId = "chr.vienpham.client@gmail.com";
        String generalClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String month = "8";
        String day= "15";
        String year = "2017";
        try {
            marketingService.loginUsingUsernamePassword(generalClientId, generalClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            generalClientService.verifyGeneralClientCanNotChangeDueDate(todoName,month,day,year);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general client can not change duedate : Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general client can not change duedate : Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    @Test(priority = 25, enabled = true, description = "To Verify general Client can not edit Category")
    public void verifyGeneralClientCanNotEditCategory() {
        marketingService = new MarketingService(getLogger(), getDriver());
        clientEngagementService = new ClientEngagementService(getLogger(),getDriver());
        clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(),getDriver());
        generalClientService = new GeneralClientService(getLogger(),getDriver());
        String generalClientId = "chr.vienpham.client@gmail.com";
        String generalClientPwd = "Changeit@123";
        String engagementName = "Engagement LeadAuditor";
        String todoName = "lead vien1";
        String oldCategoryName = "catego3";
        String newCategoryName = "catego4";
        try {
            marketingService.loginUsingUsernamePassword(generalClientId, generalClientPwd);
            clientEngagementService.verifyNavigatedToClientEngagementPage();
            clientEngagementService.viewEngagementDetailsPage(engagementName);
            clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName);
            generalClientService.verifyGeneralClientCanNotEditCategory(todoName,oldCategoryName,newCategoryName);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify general Client can not edit any Category: Pass.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify general Client can not edit any Category: Fail.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
    
    @Test(priority = 14, enabled = true, description = "Verify General Client cannot create todo.", testName = "C-14")
	public void verifyGeneralClientCanNotCreateTodo() throws Exception {
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotCreateTodo();

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot create todo.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot create todo: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

    @Test(priority = 16, enabled = true, description = "Verify General Client cannot remove todo.", testName = "C-16")
    public void verifyGeneralClientCannotRemoveTodo(){
    	marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 04", "ToDo 06", "ToDo 09"};
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotRemoveTodo(Arrays.asList(listTodo));

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot remove todo.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot remove todo: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(priority = 17, enabled = true, description = "Verify General Client cannot mark a todo completed.", testName = "C-17")
    public void verifyGeneralCannotMarkTodoCompleted(){
    	marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 04", "ToDo 06", "ToDo 09"};
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotMarkTodoCompleted(Arrays.asList(listTodo));

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot mark a todo completed.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot mark a todo completed: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(priority = 18, enabled = true, description = "Verify General Client cannot mark a todo completed.", testName = "C-18")
    public void verifyGeneralCannotAssignTodoToAuditor(){
    	marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 04", "ToDo 06", "ToDo 09"};
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotAssignTodoToAuditor(Arrays.asList(listTodo));

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot mark a todo completed.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot mark a todo completed: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
    }
    
    @Test(priority = 19, enabled = true, description = "Verify General Client cannot assign todo to lead client.", testName = "AC-19")
	public void verifyGeneralClientCannotAssignTodoToLeadClient(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 04", "ToDo 06", "ToDo 09"};
		String clientFullName = "Lead Client";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotAssignTodoToClient(Arrays.asList(listTodo), clientFullName);

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot assign todo to lead client.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot assign todo to lead client: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 20, enabled = true, description = "Verify General Client cannot assign todo to general client.", testName = "AC-20")
	public void verifyGeneralClientCannotAssignTodoToGeneralClient(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		generalClientService = new GeneralClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 04", "ToDo 06", "ToDo 09"};
		String clientFullName = "General Client";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			generalClientService.verifyGeneralClientCannotAssignTodoToClient(Arrays.asList(listTodo), clientFullName);

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify General Client cannot assign todo to general client.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify General Client cannot assign todo to general client: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
