package com.auvenir.ui.bdd.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class BaseInit {
    public static Logger logger = Logger.getLogger(BaseInit.class);
    public static WebDriver driver = null;
    /*
    public BaseInit(Logger logger, WebDriver driver){
        this.logger = logger;
        this.driver = driver;
    }
    */

    /**
     * Description: Set up to get sBaseUrl
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }
    public static Logger getLogger() {
        return logger;
    }

    public static String sBaseUrl = "ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName) {
        sBaseUrl = serverDomainName;
        getLogger().info("**** Url of testing server is: " + sBaseUrl);
    }

    public String getBaseUrl() {
        setBaseUrl(System.getProperty("serverDomainName"));
        return sBaseUrl;
    }

    /**
     * Description: set up to get sRunMode.
     * @return
     */
    public static String sRunMode = "local";
    public void setRunMode(String runMode){
        sRunMode = runMode;
        getLogger().info("***** Run mode:");
    }
    public String getRunMode(){
        setRunMode(System.getProperty("runMode"));
        return sRunMode;
    }
}
