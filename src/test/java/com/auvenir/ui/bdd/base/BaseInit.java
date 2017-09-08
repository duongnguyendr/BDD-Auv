package com.auvenir.ui.bdd.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class BaseInit {
    public static Logger logger = Logger.getLogger(BaseInit.class);
    public static WebDriver driver = null;

    public WebDriver getDriver() {
        return driver;
    }
    public static Logger getLogger() {
        return logger;
    }

    /**
     * Description: Methods to get sBaseUrl
     */
    public static String baseUrl = "ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName) {
        baseUrl = serverDomainName;
        getLogger().info("Url of testing server is: " + baseUrl);
    }
    public String getBaseUrl() {
        setBaseUrl(System.getProperty("serverDomainName"));
        return baseUrl;
    }

    /**
     * Description: Methods to get sRunMode
     */
    public static String sRunMode = "local";
    public void setRunMode(String runMode){
        sRunMode = runMode;
        getLogger().info("Run Mode: " +  sRunMode);
    }
    public String getRunMode(){
        setRunMode(System.getProperty("runMode"));
        return sRunMode;
    }
}
