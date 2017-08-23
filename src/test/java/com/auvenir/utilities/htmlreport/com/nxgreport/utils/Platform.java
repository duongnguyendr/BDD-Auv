package com.auvenir.utilities.htmlreport.com.nxgreport.utils;

import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.BuildInfo;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class Platform {
    private static BuildInfo driverInfo = new BuildInfo();
    public static final String DRIVER_VERSION;
    public static final String DRIVER_REVISION;
    public static final String USER;
    public static final String OS;
    public static final String OS_ARCH;
    public static final String OS_VERSION;
    public static final String JAVA_VERSION;
    public static String BROWSER_NAME;
    public static String BROWSER_VERSION;
    public static String BROWSER_NAME_PROP;
    public static String BROWSER_VERSION_PROP;

    static {
        DRIVER_VERSION = driverInfo.getReleaseLabel();
        DRIVER_REVISION = driverInfo.getBuildRevision();
        USER = System.getProperty("user.name");
        OS = System.getProperty("os.name");
        OS_ARCH = System.getProperty("os.arch");
        OS_VERSION = System.getProperty("os.version");
        JAVA_VERSION = System.getProperty("java.version");
        BROWSER_NAME = "Unknown";
        BROWSER_VERSION = "";
        BROWSER_NAME_PROP = "BrowserName";
        BROWSER_VERSION_PROP = "BrowserVersion";
    }

    public Platform() {
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var1) {
            return "Unknown";
        }
    }

    public static void setPlatfromBrowserDetails(ITestResult testResult) {
        prepareDetails(NXGReports.getWebDriver());
        testResult.setAttribute(BROWSER_NAME_PROP, BROWSER_NAME);
        testResult.setAttribute(BROWSER_VERSION_PROP, BROWSER_VERSION);
    }

    public static void prepareDetails(WebDriver driver) {
        BROWSER_VERSION = "";
        BROWSER_NAME = "UnKnown";
        if(driver == null) {
            BROWSER_VERSION = "";
            BROWSER_NAME = "UnKnown";
        } else {
            try {
                String strUserAgent = (String)((JavascriptExecutor)driver).executeScript("return navigator.userAgent;", new Object[0]);
                if(strUserAgent.contains("MSIE")) {
                    BROWSER_VERSION = strUserAgent.substring(strUserAgent.indexOf("MSIE") + 5, strUserAgent.indexOf("Windows NT") - 2);
                    BROWSER_NAME = "Internet Explorer";
                } else if(strUserAgent.contains("Firefox/")) {
                    BROWSER_VERSION = strUserAgent.substring(strUserAgent.indexOf("Firefox/") + 8);
                    BROWSER_NAME = "Mozilla Firefox";
                } else if(strUserAgent.contains("Chrome/")) {
                    BROWSER_VERSION = strUserAgent.substring(strUserAgent.indexOf("Chrome/") + 7, strUserAgent.lastIndexOf("Safari/"));
                    BROWSER_NAME = "Google Chrome";
                } else if(strUserAgent.contains("AppleWebKit") && strUserAgent.contains("Version/")) {
                    BROWSER_VERSION = strUserAgent.substring(strUserAgent.indexOf("Version/") + 8, strUserAgent.lastIndexOf("Safari/"));
                    BROWSER_NAME = "Apple Safari";
                } else {
                    if(!strUserAgent.startsWith("Opera/")) {
                        return;
                    }

                    BROWSER_VERSION = strUserAgent.substring(strUserAgent.indexOf("Version/") + 8);
                    BROWSER_NAME = "Opera";
                }

                getCapabilitiesDetails(driver);
            } catch (Exception var4) {
                try {
                    getCapabilitiesDetails(driver);
                    return;
                } catch (Exception var3) {
                    return;
                }
            }

            BROWSER_VERSION = "v" + BROWSER_VERSION;
        }

    }

    private static void getCapabilitiesDetails(WebDriver driver) {
        Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
        BROWSER_NAME = cap.getBrowserName();
        BROWSER_VERSION = cap.getVersion();
    }
}
