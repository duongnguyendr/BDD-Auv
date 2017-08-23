package com.auvenir.ui.tests.client.general;

import com.auvenir.ui.services.AbstractService;
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
 * Created by cuong.nguyen on 4/27/2017.
 * refactored by huy.huynh 23/06/2017(refactor this and it's used)
 */

public class AccountSettingsTest extends AbstractTest {
    private ClientService clientService;
    private MarketingService marketingService;

    private String clientId, clientAuvenirPassword;

    @Test(priority = 1, enabled = true, description = "Verify Footer in  client Account Settings page.")
    public void verifyFooterClientAccountSettingsPage() throws Exception {
        clientService = new ClientService(getLogger(), getDriver());
        marketingService = new MarketingService(getLogger(), getDriver());

        clientId = GenericService.getTestDataFromExcel("LoginData", "Valid User", "Client");
        clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("SmokeTest", "Valid User", "Client Auvenir Password");
        try {
            marketingService.loginUsingUsernamePassword(clientId, clientAuvenirPassword);

            clientService.verifyClientHomePage();
            clientService.navigateToClientSettingsPage();
            clientService.verifyAccountSettingsPage();
            clientService.verifyClientFooter();

            Assert.assertTrue(AbstractService.sStatusCnt == 0, "Script Failed");
            NXGReports.addStep("Verify client Account Settings page footer.", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Verify client Account Settings page footer", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            e.printStackTrace();
        }
    }

}


