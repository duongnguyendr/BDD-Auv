package com.auvenir.ui.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by doai.tran on 8/21/2017.
 */
//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/auvenir/ui/bdd/features"}, glue="com.auvenir.ui.bdd.stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{

}
