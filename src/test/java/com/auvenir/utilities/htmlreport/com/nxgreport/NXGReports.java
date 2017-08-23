//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.auvenir.utilities.htmlreport.com.nxgreport;

import com.google.common.io.Files;
import com.auvenir.utilities.htmlreport.com.nxgreport.exceptions.NXGReporterStepFailedException;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.AuthorDetails;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.Platform;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.Steps;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.TestDirectory;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;

public class NXGReports {
    private static WebDriver driver;
    public static String indexPageDescription = "Reports Description";
    public static String currentRunDescription;
    private static String screenShotNumber;
    private static long currentExecutionTime;
    private static long lastExecutionTime;

    static {
        try {
            lastExecutionTime = Reporter.getCurrentTestResult().getStartMillis();
        } catch (Exception var1) {
            ;
        }

    }

    public NXGReports() {
    }

    public static void setWebDriver(WebDriver driver1) {
        driver = driver1;
        Platform.prepareDetails(driver);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setAuthorInfo(String authorname, String creationdate, String version) {
        AuthorDetails authorDetails = new AuthorDetails();
        authorDetails.setAuthorName(authorname);
        authorDetails.setCreationDate(creationdate);
        authorDetails.setVersion(version);
        Reporter.getCurrentTestResult().setAttribute("authorInfo", authorDetails);
    }

    public static void setTestCaseReqCoverage(String coverage) {
        Reporter.getCurrentTestResult().setAttribute("reqCoverage", coverage);
    }

    private static void stepFailureHandler(ITestResult testResult, Steps steps, LogAs logas) {
        if(logas == LogAs.FAILED) {
            buildReportData(steps);
            if(!TestDirectory.continueExecutionAfterStepFailed) {
                throw new NXGReporterStepFailedException();
            }

            testResult.setAttribute("passedButFailed", "passedButFailed");
        } else {
            buildReportData(steps);
        }

    }

    private static void takeCaptureScreen(CaptureScreen captureScreen){
        if(captureScreen != null) {
            if(captureScreen.isCaptureBrowserPage()) {
                takeBrowserPageScreenShot();
            } else if(captureScreen.isCaptureDesktop()) {
                takeDesktopScreenshot();
            } else if(captureScreen.isCaptureWebElement()) {
                takeWebElementScreenShot(captureScreen.getElement());
            }
        }
    }

    public static void addStep(String discription, LogAs logas, CaptureScreen captureScreen, String stepException) {

        takeCaptureScreen(captureScreen);

        Steps steps = new Steps();
        steps.setDescription(discription);
        steps.setInputValue("");
        steps.setExpectedValue("");
        steps.setActualValue("");
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(logas);
        steps.setStepException(stepException);

        stepFailureHandler(Reporter.getCurrentTestResult(), steps, logas);
    }

    public static void addStep(String discription, LogAs logas, CaptureScreen captureScreen) {
        takeCaptureScreen(captureScreen);

        Steps steps = new Steps();
        steps.setDescription(discription);
        steps.setInputValue("");
        steps.setExpectedValue("");
        steps.setActualValue("");
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(logas);
        stepFailureHandler(Reporter.getCurrentTestResult(), steps, logas);
    }

    public static void addStep(String description, String inputValue, LogAs logas, CaptureScreen captureScreen) {
        takeCaptureScreen(captureScreen);

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue(inputValue);
        steps.setExpectedValue("");
        steps.setActualValue("");
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(logas);
        stepFailureHandler(Reporter.getCurrentTestResult(), steps, logas);
    }

    public static void addStep(String description, String expectedValue, String actualValue, LogAs logas, CaptureScreen captureScreen) {
        takeCaptureScreen(captureScreen);

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue("");
        steps.setExpectedValue(expectedValue);
        steps.setActualValue(actualValue);
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(logas);
        stepFailureHandler(Reporter.getCurrentTestResult(), steps, logas);
    }

    public static void addStep(String description, String inputs, String expectedValue, String actualValue, LogAs logas, CaptureScreen captureScreen) {
        takeCaptureScreen(captureScreen);

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue(inputs);
        steps.setExpectedValue(expectedValue);
        steps.setActualValue(actualValue);
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(logas);
        stepFailureHandler(Reporter.getCurrentTestResult(), steps, logas);
    }

    private static void buildReportData(Steps steps) {
        screenShotNumber = null;
        int intRptSize = Reporter.getOutput().size() + 1;
        Reporter.getCurrentTestResult().setAttribute("STEP" + intRptSize, steps);
        Reporter.log("STEP" + intRptSize);
    }

    private static String getExecutionTime() {
        currentExecutionTime = System.currentTimeMillis();
        long executionTime = currentExecutionTime - lastExecutionTime;
        if(executionTime > 1000L) {
            executionTime /= 1000L;
            lastExecutionTime = currentExecutionTime;
            return executionTime + " Sec";
        } else {
            lastExecutionTime = currentExecutionTime;
            return executionTime + " Milli Sec";
        }
    }

    private static String getLineNumDesc() {
        String lineNumber = "" + Thread.currentThread().getStackTrace()[3].getLineNumber();
        return lineNumber;
    }

    private static void takeDesktopScreenshot() {
        if(TestDirectory.takeScreenshot) {
            ITestResult testResult = Reporter.getCurrentTestResult();
            String imagePath = testResult.getAttribute("reportDir").toString() + TestDirectory.SEP + TestDirectory.SCREENSHOT_DIRName;
            screenShotNumber = String.valueOf(Reporter.getOutput(Reporter.getCurrentTestResult()).size() + 1);
            File screenShotFile = new File(imagePath + TestDirectory.SEP + screenShotNumber + ".PNG");

            try {
                Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage robot = (new Robot()).createScreenCapture(rectangle);
                ImageIO.write(robot, "PNG", screenShotFile);
            } catch (Exception var5) {
                screenShotNumber = null;
            }
        }

    }

    private static void takeBrowserPageScreenShot() {
        if(TestDirectory.takeScreenshot) {
            if(getWebDriver() == null) {
                screenShotNumber = null;
            } else {
                ITestResult testResult = Reporter.getCurrentTestResult();
                String path = testResult.getAttribute("reportDir").toString() + TestDirectory.SEP + TestDirectory.SCREENSHOT_DIRName;
                screenShotNumber = String.valueOf(Reporter.getOutput(Reporter.getCurrentTestResult()).size() + 1);
                File imageFile = new File(path + TestDirectory.SEP + screenShotNumber + ".PNG");

                try {
                    WebDriver driver;
                    if(getWebDriver().getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")) {
                        driver = (new Augmenter()).augment(getWebDriver());
                    } else {
                        driver = getWebDriver();
                    }

                    if(driver instanceof TakesScreenshot) {
                        byte[] bitData = (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                        Files.write(bitData, imageFile);
                    } else {
                        screenShotNumber = null;
                    }
                } catch (Exception var5) {
                    screenShotNumber = null;
                }
            }
        }

    }

    private static void takeWebElementScreenShot(WebElement webElement) {
        if(TestDirectory.takeScreenshot) {
            if(getWebDriver() == null) {
                screenShotNumber = null;
            } else {
                ITestResult testResult = Reporter.getCurrentTestResult();
                String imgePath = testResult.getAttribute("reportDir").toString() + TestDirectory.SEP + TestDirectory.SCREENSHOT_DIRName;
                screenShotNumber = String.valueOf(Reporter.getOutput(Reporter.getCurrentTestResult()).size() + 1);
                File imageFile = new File(imgePath + TestDirectory.SEP + screenShotNumber + ".PNG");

                try {
                    WebDriver myDriver;
                    if(getWebDriver().getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")) {
                        myDriver = (new Augmenter()).augment(getWebDriver());
                    } else {
                        myDriver = getWebDriver();
                    }

                    if(myDriver instanceof TakesScreenshot) {
                        File screeFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                        BufferedImage bufferdImg = ImageIO.read(screeFile);
                        Point point = webElement.getLocation();
                        int width = webElement.getSize().getWidth();
                        int height = webElement.getSize().getHeight();
                        BufferedImage bufferedImg = bufferdImg.getSubimage(point.getX(), point.getY(), width, height);
                        ImageIO.write(bufferedImg, "PNG", imageFile);
                    } else {
                        screenShotNumber = null;
                    }
                } catch (Exception var11) {
                    screenShotNumber = null;
                }
            }
        }

    }

    /** @deprecated */
    @Deprecated
    public static void addStep(String description, boolean takeScreenShot) {
        if(takeScreenShot) {
            takeScreenShot();
        }

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue("");
        steps.setExpectedValue("");
        steps.setActualValue("");
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(LogAs.PASSED);
        buildReportData(steps);
    }

    /** @deprecated */
    @Deprecated
    public static void addStep(String description, String inputs, boolean takeScreenShot) {
        if(takeScreenShot) {
            takeScreenShot();
        }

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue(inputs);
        steps.setExpectedValue("");
        steps.setActualValue("");
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(LogAs.PASSED);
        buildReportData(steps);
    }

    /** @deprecated */
    @Deprecated
    public static void addStep(String description, String expectedValue, String actualValue, boolean takeScreenShot) {
        if(takeScreenShot) {
            takeScreenShot();
        }

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue("");
        steps.setExpectedValue(expectedValue);
        steps.setActualValue(actualValue);
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(LogAs.PASSED);
        buildReportData(steps);
    }

    /** @deprecated */
    @Deprecated
    public static void addStep(String description, String inputs, String expectedValue, String actualVlue, boolean takeScreenShot) {
        if(takeScreenShot) {
            takeScreenShot();
        }

        Steps steps = new Steps();
        steps.setDescription(description);
        steps.setInputValue(inputs);
        steps.setExpectedValue(expectedValue);
        steps.setActualValue(actualVlue);
        steps.setTime(getExecutionTime());
        steps.setLineNum(getLineNumDesc());
        steps.setScreenShot(screenShotNumber);
        steps.setLogAs(LogAs.PASSED);
        buildReportData(steps);
    }

    private static void takeScreenShot() {
        if(TestDirectory.takeScreenshot) {
            if(getWebDriver() == null) {
                screenShotNumber = null;
            } else {
                ITestResult testResult = Reporter.getCurrentTestResult();
                String imgPath = testResult.getAttribute("reportDir").toString() + TestDirectory.SEP + TestDirectory.SCREENSHOT_DIRName;
                screenShotNumber = String.valueOf(Reporter.getOutput(Reporter.getCurrentTestResult()).size() + 1);
                File imgFile = new File(imgPath + TestDirectory.SEP + screenShotNumber + ".PNG");

                try {
                    WebDriver myDriver;
                    if(getWebDriver().getClass().getName().equals("org.openqa.selenium.remote.RemoteWebDriver")) {
                        myDriver = (new Augmenter()).augment(getWebDriver());
                    } else {
                        myDriver = getWebDriver();
                    }

                    if(myDriver instanceof TakesScreenshot) {
                        byte[] imgBytes = (byte[])((TakesScreenshot)myDriver).getScreenshotAs(OutputType.BYTES);
                        Files.write(imgBytes, imgFile);
                    } else {
                        screenShotNumber = null;
                    }
                } catch (Exception var5) {
                    screenShotNumber = null;
                }
            }
        }

    }

    public static void main(String[] args) {
    }
}
