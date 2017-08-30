package com.auvenir.utilities;

//import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
//import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
//import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by huy.huynh on 12/05/2017.
 * Contain all popular utility methods
 */
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
            FileInputStream fis = new FileInputStream(GenericService.MONGODBPROPERTIESFILE);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static void toValidate(WebElement element, String sExpectedText, String checkType) throws InvalidElementStateException {
        System.out.println("verify present of: " + sExpectedText);
        //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        switch (checkType) {
            case "Displayed":
                try {
                    element.isDisplayed();
//                    NXGReports.addStep(sExpectedText + " is displayed", LogAs.PASSED, null);
                } catch (Exception e) {
                    //AbstractService.sStatusCnt++;
//                    NXGReports.addStep(sExpectedText + " is not displayed", LogAs.FAILED, null);
                }

                break;
            case "Enabled":
                try {
                    element.isEnabled();
//                    NXGReports.addStep(sExpectedText + " is enabled", LogAs.PASSED, null);
                } catch (Exception e) {
                    //AbstractService.sStatusCnt++;
//                    NXGReports.addStep(sExpectedText + " is not enabled", LogAs.FAILED, null);
                }

                break;
            case "Selected":
                try {
                    element.isSelected();
//                    NXGReports.addStep(sExpectedText + " is selected", LogAs.PASSED, null);
                } catch (Exception e) {
                    //AbstractService.sStatusCnt++;
//                    NXGReports.addStep(sExpectedText + " is not selected", LogAs.FAILED, null);
                }

            case "ElementText":
                try {
                    element.getText().equals(sExpectedText);
//                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.PASSED, null);
                } catch (Exception e) {
                    ///AbstractService.sStatusCnt++;
//                    NXGReports.addStep(sExpectedText + " text is displayed", LogAs.FAILED, null);
                }
                break;
        }
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
                        //AbstractService.sStatusCnt++;
//                        NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    }
                }
            }
        } catch (IOException ex) {
            //AbstractService.sStatusCnt++;
//            NXGReports.addStep("Delete file failed.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            ex.printStackTrace();
        }
        return result;
    }
}
