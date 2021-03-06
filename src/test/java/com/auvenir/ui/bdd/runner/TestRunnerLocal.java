package com.auvenir.ui.bdd.runner;

import com.auvenir.ui.bdd.common.Generic;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by doai.tran on 8/21/2017.
 */
//@RunWith(Cucumber.class)
//This file config belong to marketing page

@CucumberOptions(features = {"src/test/java/com/auvenir/ui/bdd/features/toDoTest.feature"}, format =
        {"json:target/cucumber-report.json", "html:target/site/cucumber-pretty"}, glue = "com.auvenir.ui.bdd" + "" +
        ".stepDefinitions")
public class TestRunnerLocal extends AbstractTestNGCucumberTests {

    @Parameters({"browser", "version", "os"})
    @BeforeMethod
    public void beforeSuite(String browser, String version, String os) {
        Generic.sBrowser = browser;
        Generic.sVersion = version;
        Generic.sOS = os;
    }
}

