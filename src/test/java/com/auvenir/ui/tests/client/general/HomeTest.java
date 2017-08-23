package com.auvenir.ui.tests.client.general;

import com.auvenir.ui.services.client.ClientService;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.testng.annotations.Test;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class HomeTest extends AbstractTest {
    private ClientService clientService;

    @Test(priority=1,enabled=true, description="Verify Footer in Client Home page.")
    public void verifyFooterClientHomePage() throws Exception {
        clientService = new ClientService(getLogger(),getDriver());
        String userId = GenericService.getTestDataFromExcelNoBrowserPrefix("ClientTestData", "Valid User", "Client");
        try {
            clientService.loginWithUserRole(userId);
            clientService.navigateToClientDashboardPage();
            clientService.navigateToInProgressTab();
            clientService.verifyClientFooter();
            clientService.navigateToCompletedTab();
            clientService.verifyClientFooter();
            NXGReports.addStep("Verify client home page footer.", LogAs.PASSED, null);
        } catch (Exception e){
            NXGReports.addStep("Verify client home page footer.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

}


