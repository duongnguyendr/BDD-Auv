package com.auvenir.ui.bdd.runner;

import com.auvenir.ui.bdd.common.GenerateReport;
import com.auvenir.ui.bdd.common.Generic;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 8/21/2017.
 */
//@RunWith(Cucumber.class)
@Test
@CucumberOptions(features = {"src/test/java/com/auvenir/ui/bdd/features/smokeTest.feature"}
,format={"json:target/cucumber-report.json","html:target/site/cucumber-pretty"}
,glue="com.auvenir.ui.bdd.stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{

    @Parameters({"browser", "version", "os"})
    @BeforeMethod
    public  void beforeSuite(String browser, String version, String os){
        Generic.sBrowser = browser;
        Generic.sVersion = version;
        Generic.sOS = os;
    }

    /*@AfterSuite
    public void afterSuite(){
        System.out.println("This is after method.");
        System.out.println("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }*/
}

