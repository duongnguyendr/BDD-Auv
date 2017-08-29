package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.runner.GenerateReport;
import com.auvenir.utilities.GenericService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by doai.tran on 8/18/2017.
 */
public class AbstractStep extends BaseInit {

    private BaseInit base;



    @Before
    public void intializeWebDriver(){
        System.setProperty("webdriver.chrome.driver", GenericService.sDirPath + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://auvenir-qa-automation.com");
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
}
