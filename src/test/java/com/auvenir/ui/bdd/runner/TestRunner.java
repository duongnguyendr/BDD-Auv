package com.auvenir.ui.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

/**
 * Created by doai.tran on 8/21/2017.
 */
//@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/java/com/auvenir/ui/bdd/features"}
,format={"json:target/cucumber-report.json","html:target/site/cucumber-pretty"}
,glue="com.auvenir.ui.bdd.stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{

    @AfterSuite
    public void afterSuite(){
        System.out.println("This is after method.");
        System.out.println("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }
}

