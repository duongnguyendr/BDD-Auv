package com.auvenir.ui.services;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.WebService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class AuvenirLoginService extends AbstractService {
    public AuvenirLoginService(Logger logger, WebDriver driver) {
        super(logger, driver);
    }
    //Getting the URl by passing Dev Auth ID and Authentication key
    public void setURL(String sEMAILID, String sAUTHID, String sLOGINURL, String sDevAuthID, String sApiKey) throws Exception {
        try {
            WebService http = new WebService(getLogger());
            http.gettingUserID(sEMAILID, sAUTHID, sDevAuthID, sApiKey);
            http.gettingURL(sEMAILID, sLOGINURL, sDevAuthID, sApiKey);
            System.out.println(GenericService.getConfigValue(GenericService.sConfigFile, sLOGINURL));
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load Logged-In Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }

    //Getting the URL by passing GetTokenURl and CheckTokenURL
    public void navigateToURL(String sEmailID, String sGetTokenURL, String sCheckTokenURL) {
        getDriver().get(sGetTokenURL + sEmailID);
        String s1 = getDriver().findElement(By.xpath("//pre")).getText();
        String[] parts = s1.split("(\")");
        String token = parts[3];
        getDriver().get(sCheckTokenURL + sEmailID + "&token=" + token);
    }

    //Loading the URL by keeping in config properties
    public void navigateToURL(String sUrl) {
        try {
            System.out.println(sUrl);
            getDriver().get(sUrl);
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
        } catch (AssertionError e) {
            NXGReports.addStep("Fail to load main Auvenir URL.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
            throw e;
        }
    }


}
