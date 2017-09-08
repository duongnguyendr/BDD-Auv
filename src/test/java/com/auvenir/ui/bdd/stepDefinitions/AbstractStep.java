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
import org.openqa.selenium.firefox.FirefoxDriver;
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
        baseUrl=getConfigValue(PROPERTIES_FILE,"BASE_URL");

        if(Generic.sBrowser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", GenericService.sDirPath + "/src/test/resources/webDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(Generic.sBrowser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", GenericService.sDirPath + "/src/test/resources/webDrivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(Generic.sBrowser.equalsIgnoreCase("internetexplorer")) {

        }else if(Generic.sBrowser.equalsIgnoreCase("edge")){

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println("Open browser");
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

    }
    @BeforeSuite
    public void beforeSuite(){
        getBaseUrl();
    }
}
