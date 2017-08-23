package com.auvenir.ui.tests.groupPermissions;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auvenir.ui.pages.client.engagement.ClientDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.client.ClientEngagementService;
import com.auvenir.ui.services.groupPermissions.AdminClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;

/**
 * Created by vien.pham on 8/7/2017.
 */
public class AdminClientTest extends AbstractTest {
	private MarketingService marketingService;
	private ClientEngagementService clientEngagementService;
	private ClientDetailsEngagementPage clientDetailsEngagementService;
	private AdminClientService adminClientService;

	@Test(priority = 13, enabled = true, description = "Verify Admin Client cannot create todo.", testName = "AC-13")
	public void verifyAdminClientCanNotCreateTodo() throws Exception {
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "chr.vienpham.admin.client@gmail.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement_AdminAuditor";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotCreateTodo();

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot create todo.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot create todo: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 17, enabled = true, description = "Verify Admin Client cannot mark todo with in engagement as completed.", testName = "AC-17")
	public void verifyAdminClientCannotMarkTodoCompleted(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 02", "ToDo 04", "ToDo 05", "ToDo 06", "ToDo 07", "ToDo 09"};
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotMarkTodoCompleted(Arrays.asList(listTodo));

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot mark todo with in engagement as completed.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot mark todo with in engagement as completed: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 18, enabled = true, description = "Verify Admin Client cannot assign todo to an auditor.", testName = "AC-18")
	public void verifyAdminClientCannotAssignTodoToAuditor(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 02", "ToDo 04", "ToDo 05", "ToDo 06", "ToDo 07", "ToDo 09"};
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotAssignTodoToAuditor(Arrays.asList(listTodo));

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot assign todo to an auditor.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot assign todo to an auditor: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 19, enabled = true, description = "Verify Admin Client cannot assign todo to lead client.", testName = "AC-19")
	public void verifyAdminClientCannotAssignTodoToLeadClient(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 02", "ToDo 04", "ToDo 05", "ToDo 06", "ToDo 07", "ToDo 09"};
		String clientFullName = "Lead Client";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotAssignTodoToLeadClient(Arrays.asList(listTodo), clientFullName);

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot assign todo to lead client.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot assign todo to lead client: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 20, enabled = true, description = "Verify Admin Client cannot assign todo to general client.", testName = "AC-20")
	public void verifyAdminClientCannotAssignTodoToGeneralClient(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String [] listTodo = {"ToDo 01", "ToDo 02", "ToDo 04", "ToDo 05", "ToDo 06", "ToDo 07", "ToDo 09"};
		String clientFullName = "General Client";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotAssignTodoToLeadClient(Arrays.asList(listTodo), clientFullName);

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot assign todo to general client.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot assign todo to general client: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	@Test(priority = 21, enabled = true, description = "Verify Admin Client cannot comment on todo they are not assign to.", testName = "AC-21")
	public void verifyAdminClientCannotCommentOnTodoNotAssign(){
		marketingService = new MarketingService(getLogger(), getDriver());
		clientEngagementService = new ClientEngagementService(getLogger(), getDriver());
		clientDetailsEngagementService = new ClientDetailsEngagementPage(getLogger(), getDriver());
		adminClientService = new AdminClientService(getLogger(), getDriver());
		String adminUser = "duong.client.adm@mailinator.com";
		String adminPassword = "Changeit@123";
		String engagementName2 = "Engagement Dr02";
		String todoName = "ToDo 01";
		String comment = "Admin Client comment";
		try {
			marketingService.loginUsingUsernamePassword(adminUser, adminPassword);
			clientEngagementService.verifyNavigatedToClientEngagementPage();
			clientEngagementService.viewEngagementDetailsPage(engagementName2);
			clientDetailsEngagementService.verifyDetailsEngagementPage(engagementName2);

			adminClientService.verifyAdminClientCannotCommentOnTodoNotAssign(todoName, comment);

			Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
			NXGReports.addStep("Verify Admin Client cannot comment on todo they are not assign to.", LogAs.PASSED, null);
		} catch (Exception e) {
			NXGReports.addStep("Verify Admin Client cannot comment on todo they are not assign to: FAILED", LogAs.FAILED,
					new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}