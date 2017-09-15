package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.Generic;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.auvenir.ui.bdd.common.Generic.PROPERTIES_FILE;
import static com.auvenir.ui.bdd.common.Generic.getConfigValue;

/**
 * Created by doai.tran on 8/18/2017.
 */
public class AbstractStep extends BaseInit {

    private BaseInit base;
    protected String SELENIUM_GRID_HUB = "http://jenkins.auvenir.com:4444/wd/hub";

    @Before
    public void intializeWebDriver() throws MalformedURLException {
        getBaseUrl();
        baseUrl = getConfigValue(PROPERTIES_FILE, "BASE_URL");
        getToEmail();
        getCcEmail();
        getRunMode();
        // Configure for run test local mode
        if (sRunMode == null) {
            if (Generic.sBrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", Generic.sDirPath + "/src/test/resources/webDrivers/chromedriver.exe");
                DesiredCapabilities cap = setDownloadLocationChrome();
                driver = new ChromeDriver(cap);
            } else if (Generic.sBrowser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", Generic.sDirPath + "/src/test/resources/webDrivers/geckodriver.exe");
                FirefoxProfile profileFF = setDownloadLocationFirefox();
                driver = new FirefoxDriver(profileFF);
            } else if (Generic.sBrowser.equalsIgnoreCase("internetexplorer")) {
                System.setProperty("webdriver.ie.driver", Generic.sDirPath + "/src/test/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (Generic.sBrowser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", Generic.sDirPath + "/src/test/resources/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
            // Configure for Selenium Grid mode, to run on Jenkins
        }else if (sRunMode.equalsIgnoreCase("SeleniumGrid")){
                if (Generic.sBrowser.equalsIgnoreCase("chrome")) {
                    DesiredCapabilities capabilitiesChrome;
                    capabilitiesChrome = DesiredCapabilities.chrome();
                    String downloadFilepath = Generic.sDirPath + "/src/test/resources/download/";
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", downloadFilepath);
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", chromePrefs);
                    capabilitiesChrome.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilitiesChrome.setPlatform(setOSForBrowser(Generic.sOS));
                    capabilitiesChrome.setVersion(Generic.sVersion);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesChrome, capabilitiesChrome);
                } else if (Generic.sBrowser.equalsIgnoreCase("firefox")) {
                    DesiredCapabilities capabilitiesFireFox;
                    capabilitiesFireFox = DesiredCapabilities.firefox();
                    FirefoxProfile profile = setDownloadLocationFirefox();
                    capabilitiesFireFox.setCapability(FirefoxDriver.PROFILE, profile);
                    capabilitiesFireFox.setPlatform(setOSForBrowser(Generic.sOS));
                    capabilitiesFireFox.setVersion(Generic.sVersion);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesFireFox, capabilitiesFireFox);
                } else if (Generic.sBrowser.equalsIgnoreCase("internet explorer")) {
                    DesiredCapabilities capabilitiesIE;
                    capabilitiesIE = DesiredCapabilities.internetExplorer();
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesIE, capabilitiesIE);
                } else if (Generic.sBrowser.equalsIgnoreCase("edge")) {
                    DesiredCapabilities capabilitiesEdge;
                    capabilitiesEdge = DesiredCapabilities.edge();
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesEdge, capabilitiesEdge);
                } else if (Generic.sBrowser.equalsIgnoreCase("safari")) {
                    DesiredCapabilities capabilitiesSafari;
                    capabilitiesSafari = DesiredCapabilities.safari();
                    capabilitiesSafari.setPlatform(setOSForBrowser(Generic.sOS));
                    capabilitiesSafari.setVersion(Generic.sVersion);
                    driver = new RemoteWebDriver(new URL(SELENIUM_GRID_HUB), capabilitiesSafari, capabilitiesSafari);
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            System.out.println("***** Open browser *****");
        }
    public Platform setOSForBrowser(String os) {
        Platform osType = null;
        System.out.println("Current OS: " + os);
        if (os.equalsIgnoreCase("WIN10")) {
            osType = Platform.WIN10;
        } else if (os.equalsIgnoreCase("WIN8")) {
            osType = Platform.WIN8;
        } else if (os.equalsIgnoreCase("WIN8.1")) {
            osType = Platform.WIN8_1;
        } else if (os.equalsIgnoreCase("MAC")) {
            osType = Platform.MAC;
        } else {
            osType = Platform.LINUX;
        }
        return osType;
    }
    /*
    Update for method: setDownload Location on Chrome
     */
    public DesiredCapabilities setDownloadLocationChrome() {
        String downloadFilepath = Generic.sDirPath + "\\src\\test\\resources\\testData\\download\\";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }

    /*
    Update for method: setDownload Location on Firefox
     */
    public FirefoxProfile setDownloadLocationFirefox() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        String downloadFilepath = Generic.sDirPath + "/src/test/resources/testData/download/";
        profile.setPreference("browser.download.dir", downloadFilepath);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-gzip");
        profile.setAcceptUntrustedCertificates(false);
        return profile;
    }
    @After
    public void tearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario failed.");
        } else {
            scenario.write("Scenario Passed");
        }
        driver.close();
        driver.quit();
        getLogger().info("***** Closed browser *****");
    }
}
