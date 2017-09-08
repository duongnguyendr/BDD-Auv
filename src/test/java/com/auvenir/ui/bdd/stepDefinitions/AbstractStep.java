package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.utilities.GenericService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.auvenir.ui.bdd.common.Generic.PROPERTIES_FILE;
import static com.auvenir.ui.bdd.common.Generic.getConfigValue;

/**
 * Created by doai.tran on 8/18/2017.
 */
public class AbstractStep extends BaseInit {

    private BaseInit base;

    @Before
    public void intializeWebDriver(){
        getBaseUrl();
        sBaseUrl=getConfigValue(PROPERTIES_FILE,"BASE_URL");
        if(sRunMode.equalsIgnoreCase("local")){
            if(Generic.sBrowser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", GenericService.sDirPath + "/src/test/resources/webDrivers/chromedriver.exe");
                driver = new ChromeDriver();
            }else if(Generic.sBrowser.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", GenericService.sDirPath + "/src/test/resources/webDrivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else if(Generic.sBrowser.equalsIgnoreCase("internetexplorer")) {
                System.setProperty("webdriver.ie.driver", GenericService.sDirPath + "/src/test/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }else if(Generic.sBrowser.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver", GenericService.sDirPath + "/src/test/resources/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            }
        }else {

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        getLogger().info("***** Open browser *****");
    }
    @After
    public void tearDownTest(Scenario scenario){
        if(scenario.isFailed()){
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario failed.");
        }else {
            scenario.write("Scenario Passed");
        }
        driver.close();
        driver.quit();
        System.out.println("***** Close browser *****");
    }
    @BeforeSuite
    public void beforeSuite(){
        getBaseUrl();
    }
}
