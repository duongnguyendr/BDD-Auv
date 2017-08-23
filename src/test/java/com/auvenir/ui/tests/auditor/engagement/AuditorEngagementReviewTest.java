package com.auvenir.ui.tests.auditor.engagement;

import com.auvenir.ui.services.*;
import com.auvenir.ui.services.auditor.*;
import com.auvenir.ui.services.marketing.MarketingService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 5/8/2017.
 * Refactored by minh.nguyen on June 16, 2017
 */
public class AuditorEngagementReviewTest extends AbstractTest {
    private AuditorEngagementService auditorEngagementService;
    private AuditorNewEngagementService auditorNewEngagementService;
    private AuditorDetailsEngagementService auditorDetailsEngagementService;
    private AuditorTodoListService auditorTodoListService;
    private AuditorCreateToDoService auditorCreateToDoService;
    private AuditorEditCategoryService auditorEditCategoryService;
    private MarketingService marketingService;
    String auditorId, auditorPwd;
    String timeStamp;
    String firstEngagementTitleOnWeb;

    @Test(priority = 1, description = "Search engagement by company, engagement name")
    public void searchEngagementByCompanyAndNameTest() throws Exception {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        String engagementType = "Review";
        try
        {
            String engagementNameUnix = "enga" + GeneralUtilities.randomNumber();
            String companyNameUnix = "comau" + GeneralUtilities.randomNumber();
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.createAndSelectNewEnagement(engagementNameUnix, engagementType, companyNameUnix);
            auditorEngagementService.clickEngagementMenuLink();
            auditorEngagementService.sendKeyCompanyName(companyNameUnix);
            auditorEngagementService.verifySearchCompanyName(companyNameUnix);
            auditorEngagementService.sendKeyEngagementName(engagementNameUnix);
            auditorEngagementService.verifySearchEngagementName(engagementNameUnix);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to search engagement by company, engagement name.");
            NXGReports.addStep("Verify to search engagement by company, engagement name.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to search engagement by company, engagement name.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 2, description = "Sort Company name, Engagement name by ascending, descending")
    public void sortEngagementByCompanyNameTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortCompanyNameAscending(true);
            auditorEngagementService.verifySortCompanyNameDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Company name by ascending, descending.");
            NXGReports.addStep("Verify to sort Company name by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Company name by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 3, description = "Sort Engagement name by ascending, descending")
    public void sortEngagementByEngagementNameTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementNameAscending(true);
            auditorEngagementService.verifySortEngagementNameDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement name by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement name by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement name by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 4, description = "Sort Engagement Status by ascending, descending")
    public void sortEngagementByEngagementStatusTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementStatusAscending(true);
            auditorEngagementService.verifySortEngagementStatusDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Status by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Status by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Status by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    /*
    Currently, we do not have the values on ByEngagementAssignee
    => Temporary, we can hide this test.
    @Test(priority = 5, description = "Sort Engagement Audit Assignee by ascending, descending")
    public void sortEngagementByEngagementAssigneeTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        try {
            auditorId = GenericService.getTestDataFromExcel("LoginData", "Valid Userminh", "Auditor");
            auditorEngagementService.loginWithUserRole(auditorId);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementAssigneeAscending(true);
            auditorEngagementService.verifySortEngagementAssigneeDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify to sort Engagement Audit Assignee by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Audit Assignee by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }
    */

    @Test(priority = 6, description = "Sort Engagement Completed To Dos by ascending, descending.")
    public void sortEngagementByCompletedToDosTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementCompleteToDosAscending(true);
            auditorEngagementService.verifySortEngagementCompleteToDosDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Completed To Dos by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Completed To Dos by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Completed To Dos by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 7, description = "Sort Engagement Client Assignee by ascending, descending.")
    public void sortEngagementByClientAssigneeTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementClientAssigneeAscending(true);
            auditorEngagementService.verifySortEngagementClientAssigneeDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Client Assignee by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Client Assignee by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Client Assignee by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 8, description = "Sort Engagement Completed Docs by ascending, descending.")
    public void sortEngagementByCompleteDocsTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementClientAssigneeAscending(true);
            auditorEngagementService.verifySortEngagementClientAssigneeDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Completed Docs by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Completed Docs by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Completed Docs by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 9, description = "Sort Engagement Last Activity by ascending, descending.")
    public void sortEngagementByLastActivityTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementLastActivityAscending(true);
            auditorEngagementService.verifySortEngagementLastActivityDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Last Activity by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Last Activity by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Last Activity by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 10, description = "Sort Engagement Due Date by ascending, descending.")
    public void sortEngagementByDueDateTest() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementPage();
            auditorEngagementService.verifySortEngagementDueDateAscending(true);
            auditorEngagementService.verifySortEngagementDueDateDescending(false);
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Verify to sort Engagement Due Date by ascending, descending.");
            NXGReports.addStep("Verify to sort Engagement Due Date by ascending, descending.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify to sort Engagement Due Date by ascending, descending.", LogAs.FAILED, null);
            throw ex;
        }
    }

    @Test(priority = 11, description = "Filter and Hover on Engagement page.")
    public void verifyFilterHoverOnEngagementPage() throws InterruptedException {
        auditorCreateToDoService = new AuditorCreateToDoService(getLogger(), getDriver());
        auditorEngagementService = new AuditorEngagementService(getLogger(), getDriver());
        auditorDetailsEngagementService = new AuditorDetailsEngagementService(getLogger(), getDriver());
        auditorTodoListService = new AuditorTodoListService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());
        auditorId = GenericService.getTestDataFromExcel("SmokeTest", "Valid User", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Auditor Auvenir Password");
        try {
            marketingService.goToBaseURL();
            marketingService.openLoginDialog();
            marketingService.loginWithUserNamePassword(auditorId, auditorPwd);
            auditorEngagementService.verifyAuditorEngagementFilter();
            auditorEngagementService.verifyAuditorEngagementHover();
            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Filter and Hover on Engagement page.");
            NXGReports.addStep("Verify Filter and Hover on Engagement page.", LogAs.PASSED, null);
        }
        catch (Exception ex)
        {
            NXGReports.addStep("Verify Filter and Hover on Engagement page.", LogAs.FAILED, null);
            throw ex;
        }
    }
}
