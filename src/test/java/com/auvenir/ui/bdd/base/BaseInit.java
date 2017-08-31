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
    public WebDriver getDriver() {
        return driver;
    }
    public Logger getLogger() {
        return logger;
    }

    public static String baseUrl = "ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName) {
        baseUrl = serverDomainName;
        getLogger().info("Url of testing server is: " + baseUrl);
    }
    public String getBaseUrl() {
        setBaseUrl(System.getProperty("serverDomainName"));
        return baseUrl;
    }

}
