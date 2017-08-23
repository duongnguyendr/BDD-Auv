package com.auvenir.ui.services.auditor;

/**
 * Created by tan.pham on 6/30/2017.
 */
import com.auvenir.ui.pages.auditor.contact.AuditorContactsPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AuditorContactService extends AbstractService{
    AuditorContactsPage auditorContactsPage;
    /*
     * contructor
     */
    public AuditorContactService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorContactsPage = new AuditorContactsPage(getLogger(), getDriver());

    }

    public void verifyAuditorContactPage(){
        auditorContactsPage.verifyAuditorContactsPage();
    }

    public void clickOnEngagementLink(){
        auditorContactsPage.clickOnEngagementLink();
    }

    public void verifyGUIDataTableContactPage(){
        auditorContactsPage.verifyGUIDataTableInContactPage();
    }

    public void verifyAuditorFooter() {

        try {
            auditorContactsPage.scrollPageDown();
            getLogger().info("verify footer page.");
            auditorContactsPage.verifyFooterOfHomepage();
            getLogger().info("verfify term of service link.");
            auditorContactsPage.verifyTermsOfServiceLink();
            getLogger().info("verify privacy state link.");
            auditorContactsPage.verifyPrivacyStateLink();
            getLogger().info("verify cookies notice link.");
            auditorContactsPage.verifyCookieNotice();
            auditorContactsPage.scrollPageUp();
            NXGReports.addStep("verify footer page", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("verify footer page", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }
}
