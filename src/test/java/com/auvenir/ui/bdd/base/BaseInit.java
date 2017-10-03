package com.auvenir.ui.bdd.base;

import com.auvenir.ui.bdd.common.Generic;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by doai.tran on 8/7/2017.
 */
public class BaseInit {
    public static Logger logger = Logger.getLogger(BaseInit.class.getSimpleName());
    public static WebDriver driver = null;

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Description: Methods to get sBaseUrl
     */
    public static String baseUrl = "ariel.auvenir.com";
    public void setBaseUrl(String serverDomainName) {
        baseUrl = serverDomainName;
        logger.info("Url of testing server is: " + baseUrl);
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
        logger.info("Run Mode: " +  sRunMode);
    }
    public String getRunMode(){
        setRunMode(System.getProperty("runMode"));
        return sRunMode;
    }

    /**
     * Description: Methods to get SToEmail
     */
    public static String sToEmail = "";
    public void setToEmail(String toEmail){
        sToEmail = toEmail;
        logger.info("ToEmail: " +  sToEmail);
    }
    public String getToEmail(){
        setToEmail(System.getProperty("toEmail"));
        return sToEmail;
    }

    /**
     * Description: Methods to get SCcEmail
     */
    public static String sCcEmail = "";
    public void setCcEmail(String CcEmail){
        sCcEmail = CcEmail;
        logger.info("ToEmail: " +  sCcEmail);
    }
    public String getCcEmail(){
        setCcEmail(System.getProperty("ccEmail"));
        return sCcEmail;
    }

    /**
     * Description: Methods to get getDataBaseSer
     */

    public String dataBaseServer="192.168.1.222";
    public void setDataBaseSer(String serverDataBase){
        dataBaseServer= serverDataBase;
    }
    public String getDataBaseSer(){
        return dataBaseServer;
    }

    /**
     * Description: Methods to get getDataBase
     */
    public String dataBase ="auvenir";
    public void setDataBase(String sDataBase){
        dataBase= sDataBase;
        logger.info("DataBase: " + dataBase);
    }
    public String getDataBase(){
        return dataBase;
    }

    /**
     * Description: Methods to get getPort
     */
    public int port= 27017;
    public void setPort(int portNo){
        //port= Integer.parseInt(portNo);
        port= portNo;

        logger.info("Connection Port: " + port);
    }
    public int getPort(){
        return port;
    }

    /**
     * Description: Methods to get getUserName
     */
    public String userName = "";
    public void setUserName(String userNameDB){
        userName= userNameDB;
        logger.info("UserName: " + userName);
    }
    public String getUserName(){
        return userName;
    }

    /**
     * Description: Methods to get getPassword
     */
    public String password = "";
    public void setPassword(String PasswordDB){
        password= PasswordDB;
        logger.info("Password: " + password);
    }
    public String getPassword(){
        return password;
    }

    /**
     * Description: Methods to get getSSL
     */
    public String ssl ="No";
    public void setSSL(String SSL){
        ssl= SSL;
        logger.info("SSL: " + ssl);
    }
    public String getSSL(){
        return ssl;
    }
}
