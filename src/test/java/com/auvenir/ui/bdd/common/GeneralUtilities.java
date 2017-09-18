package com.auvenir.ui.bdd.common;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public static List getList ( DataTable dataTable){
/*note: Get form 1 to List size because first row is the header of file
*/
        List<String>listDataList;
        listDataList = dataTable.asList(String.class);
        return listDataList;


    }


    //    public boolean checkFileExists(String downloadFile, boolean isDeletedFile){return false;}
    public static boolean checkFileExists(String pathLocation, boolean deleteExisted) {
        //        waitSomeSeconds(3);
        Path path = Paths.get(pathLocation);
        System.out.println("file: " + path);
        boolean result = false;
        try {
            if (Files.exists(path)) {
                result = true;
                if (deleteExisted) {
                    Files.delete(path);
                    if (Files.exists(path)) {
                        return false;
                    }
                }
            }
        } catch (IOException ex) {
            return false;
        }
        return result;
    }
}
