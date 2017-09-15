package com.auvenir.ui.bdd.common;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class GeneralUtilities {

    /**
     * string timestamp to add to name for unique
     */
    public static String getTimeStampForNameSuffix() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_ddMMyy");
        Date date = new Date();
        return sdf.format(date);
    }

    public static int randomNumber() {
        Random randNum = new Random();
        int intRanNum = randNum.nextInt(10000) + 1;
        return intRanNum;
    }

    public static boolean verifyElementExist(WebDriver webDriver, WebElement webElement) {
        return true;
    }

    public static Properties getMongoDBProperties() {
        Properties properties = null;
        try {
            FileInputStream fis = new FileInputStream(Generic.MONGODBPROPERTIESFILE);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static boolean isEmptyString(String input) {
        if ((null != input) && (!"".equals(input))) {
            return false;
        }
        return true;
    }
    public static List getTable ( DataTable dataTable){
/*note: Get form 1 to List size because first row is the header of file
*/
        List<List<String>>listDataTable;
        listDataTable = dataTable.raw();
        return listDataTable;
    }
}
