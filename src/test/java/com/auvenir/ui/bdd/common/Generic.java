package com.auvenir.ui.bdd.common;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
import org.codehaus.groovy.runtime.powerassert.SourceText;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * Created by doai.tran on 8/31/2017.
 */
public class Generic extends BaseInit{
    private static BaseInit base;
    public Generic(BaseInit base) {
        this.base = base;
    }
    public static String sDirPath = System.getProperty("user.dir");
    public static String sUserPath = System.getProperty("user.home");
    public static String sBrowser = null;
    public static String sVersion = null;
    public static String sOS = null;
    public final static String PROPERTIES_FILE = sDirPath + "\\TestBDD.properties";
    public static String sExecuteTime = null;
    public static String sExecutionDate = null;

    /**
     * Description: Method to read the configuration from Config file.
     * @param sFile FILE Destination
     * @param sKey KeyWord to read value.
     * @return
     */
    public static String getConfigValue(String sFile, String sKey) {
        getLogger().info("**** Read Configuration file ****");
        Properties prop = new Properties();
        String sValue = null;
        try {
            InputStream input = new FileInputStream(sFile);
            prop.load(input);
            sValue = prop.getProperty(sKey);
            getLogger().info("**** Value from Properties file of Parameter: "+sKey+": "+sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            getLogger().info("**** Can not find the properties file ****"+sValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sValue;
    }

    /**
     * Description: Method to set the configuration from Config file.
     * @param sFile
     * @param sKey
     * @param sValue
     */
    public static void setConfigValue(String sFile, String sKey, String sValue) {
        getLogger().info("**** Read Configuration file ****");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(sFile));
            prop.load(fis);
            fis.close();
            FileOutputStream fos = new FileOutputStream(new File(sFile));
            prop.setProperty(sKey, sValue);
            prop.store(fos, "Updating folder path");
            fos.close();
            getLogger().info("**** Value from Properties file of Parameter: "+sKey+"be set: "+sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GetTimeStampValue(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":","");
        systime = systime.replace("-","");
        return systime;
    }
}
