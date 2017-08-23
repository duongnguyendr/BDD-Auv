package com.auvenir.ui.tests.auditor.todo;

import com.auvenir.ui.dataprovider.auditor.todo.AuditorCommentDataProvider;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.ui.services.auditor.AuditorCreateToDoService;
import com.auvenir.ui.services.auditor.AuditorDetailsEngagementService;
import com.auvenir.ui.services.auditor.AuditorEngagementService;
import com.auvenir.ui.services.auditor.AuditorTodoListService;
import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 7/20/2017.
 */
public class AuditorCommentTest extends AbstractTest {

    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEngagementService auditorEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private MarketingService marketingService;
    private ClientService clientService;

    @Test(priority = 1, enabled = true, description = "Verify To-do Details Commenting", dataProvider = "verifyToDoDetailsCommenting",
            dataProviderClass = AuditorCommentDataProvider.class)
    public void verifyAuditorToDoDetailsCommenting(String auditorId, String auditorPwd, String engagementName, String todoName, String inputComment)
            throws Exception {
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
            //            auditorDetailsEngagementService.verifyDetailsEngagementPage("engagement2299");
            // Will edit when the code is updated with the new xpath and business.
            //            auditorTodoListService.verifyTodoListPage();
            auditorCreateToDoService.navigateToDoListPage();

            // Will uncomment when the code is updated with the new xpath and business.
            auditorCreateToDoService.createNewToDoTask(todoName);
            //            auditorCreateToDoService.verifyCreateToDoTaskWithoutCategory("Task2299");
            //            auditorCreateToDoService.closeSuccessToastMes();
            auditorCreateToDoService.selectToDoTaskName(todoName);
            auditorCreateToDoService.clickCommentIconPerTaskName(todoName);
            auditorCreateToDoService.verifyInputAComment(inputComment);
            int numberOfListCommentlist = auditorCreateToDoService.getNumberOfListComment();
            auditorCreateToDoService.clickOnPostCommentButton();
            auditorCreateToDoService.verifyNewCommentIsDisplayed(numberOfListCommentlist, inputComment);
            auditorCreateToDoService.verifyBoxTitleComment();
            auditorCreateToDoService.verifyClickOnInputCommentField();
            auditorCreateToDoService.verifyGUIPostButton();
            auditorCreateToDoService.verifyDefaultHintValueInputComment();
            auditorCreateToDoService.verifyGUICommentList(inputComment);
            auditorCreateToDoService.verifyUserInputNoContentComment();
            auditorCreateToDoService.verifyInputMaxLenghtContentComment(512);
            auditorCreateToDoService.verifyInputSpecialCharactersContentComment();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script should be passed all steps");
            NXGReports.addStep("Verify To Do Details Commenting.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("TestScript Failed: Verify To Do Details Commenting.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            getLogger().info(e);
            throw e;
        }
    }
}
