package com.auvenir.ui.bdd.common;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.*;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

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
        LinkedList<List<String>> listDataTable;
        listDataTable = new LinkedList<List<String>>( dataTable.raw());
        listDataTable.remove(0);
        return listDataTable;
    }
    public static List getList ( DataTable dataTable){
/*note: Get form 1 to List size because first row is the header of file
*/
        LinkedList<String>listDataList;
        listDataList = new LinkedList<String>(dataTable.asList(String.class));
        listDataList.remove(0);
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

    public static String calculateMD5(String fileMD5) {
        String md5 = null;
        try {
            FileInputStream fis = new FileInputStream(fileMD5);
            System.out.println("fileMD5 = " + fileMD5);
            md5 = md5Hex(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to calculate MD5 file.");
        }
        return md5;

    }

    public static void verifyDownloadFileSuccessAndChecksum(String fileName) {
        String concatUpload = Generic.FOLDER_UPLOAD.concat(fileName);
        String concatDownload = Generic.FOLDER_DOWNLOAD.concat(fileName);
        boolean fileExisted = GeneralUtilities.checkFileExists(concatDownload, false);
        Assert.assertTrue(fileExisted, String.format("File 's' should be existed."));
        if (fileExisted) {
            String checkMd5UploadFile = GeneralUtilities.calculateMD5(concatUpload);
            System.out.println("md5 upload is: " + checkMd5UploadFile);
            String checkMd5DownloadFile = GeneralUtilities.calculateMD5(concatDownload);
            System.out.println("md5 download is: " + checkMd5DownloadFile);
            Assert.assertEquals(checkMd5DownloadFile,checkMd5DownloadFile, "Checksum Download File and Upload File should be matched.");
        }
    }

    public static void focusWebBrowser(){
        Robot robot = null;
        System.out.println("Focus on Web Browser.");
        try {
            Thread.sleep(1000);
            robot = new Robot();
            robot.delay(2);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_M);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_ALT);
            Thread.sleep(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
