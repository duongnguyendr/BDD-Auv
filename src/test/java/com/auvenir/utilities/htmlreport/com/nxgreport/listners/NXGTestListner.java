//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.auvenir.utilities.htmlreport.com.nxgreport.listners;

import com.auvenir.utilities.GenericService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.excel.ExcelReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.exceptions.NXGReporterStepFailedException;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.Platform;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.TestDirectory;
import com.auvenir.utilities.htmlreport.com.nxgreport.writer.IndexPageWriter;
import com.auvenir.utilities.htmlreport.com.nxgreport.writer.ResultPageWriter;
import com.auvenir.utilities.htmlreport.com.nxgreport.writer.TestCaseReportsPageWriter;
//import com.kirwa.screenrecorder.Recorder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

public class NXGTestListner implements ITestListener, ISuiteListener, IInvokedMethodListener {
    int runCount = 0;
    List<ITestResult> passedTests = new ArrayList();
    List<ITestResult> failedTests = new ArrayList();
    List<ITestResult> skippedTests = new ArrayList();
    ArrayList passBrowserTest= new ArrayList<String>();
    ArrayList failBrowserTest= new ArrayList<String>();
    ArrayList skipBrowserTest= new ArrayList<String>();
    /*private Recorder recorder;
    private Recorder testRecorder;*/
    private boolean isSuiteStarted = false;
    private boolean isSuiteFinshed = false;

    public NXGTestListner() {
    }

    public void onFinish(ITestContext arg0) {
    }

    public void onStart(ITestContext arg0) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        /*if(TestDirectory.recordTestExecution) {
            try {
                this.testRecorder.stopRecording();
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }
        }*/

    }

    public void onTestFailure(ITestResult result) {
        this.failedTests.add(result);
        failBrowserTest.add(GenericService.sBrowserTestNameList.get(GenericService.sBrowserTestNameList.size()-1));
        /*if(TestDirectory.recordTestExecution) {
            try {
                this.testRecorder.stopRecording();
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }
        }*/

    }

    public void onTestSkipped(ITestResult result) {
        createReportDir(result);
        this.skippedTests.add(result);
        skipBrowserTest.add(GenericService.sBrowserTestNameList.get(GenericService.sBrowserTestNameList.size()-1));
       /* if(TestDirectory.recordTestExecution) {
            try {
                this.testRecorder.stopRecording();
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }
        }*/

    }

    public void onTestStart(ITestResult testResult) {
        createReportDir(testResult);
        setPlatfromBrowserDetails(testResult);
        /*if(TestDirectory.recordTestExecution) {
            try {
                this.testRecorder = new Recorder(getReportDir(testResult) + TestDirectory.SEP + testResult.getName() + ".mov");
                this.testRecorder.startRecording();
            } catch (Exception var3) {
                var3.printStackTrace();
            }

            System.out.println("started recording for " + getReportDir(testResult) + TestDirectory.SEP + testResult.getName() + ".mov");
        }*/

    }

    public void onTestSuccess(ITestResult result) {
        try {
            if(result.getAttribute("passedButFailed").equals("passedButFailed")) {
                result.setStatus(2);
                result.setThrowable(new NXGReporterStepFailedException());
                this.failedTests.add(result);
                failBrowserTest.add(GenericService.sBrowserTestNameList.get(GenericService.sBrowserTestNameList.size()-1));
                return;
            }
        } catch (NullPointerException var4) {
            ;
        }

        this.passedTests.add(result);
        passBrowserTest.add(GenericService.sBrowserTestNameList.get(GenericService.sBrowserTestNameList.size()-1));
       /* if(TestDirectory.recordTestExecution) {
            try {
                this.testRecorder.stopRecording();
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }
        }*/

    }

    public void onFinish(ISuite suite) {
        if(!this.isSuiteFinshed) {
            this.isSuiteFinshed = true;
            System.out.println("Suite finshed");
            suite.setAttribute("endExecution", Long.valueOf(System.currentTimeMillis()));
            long startTime = Long.parseLong(suite.getAttribute("startExecution").toString());
            this.generateIndexPage();
            this.generateCurrentRunPage(startTime, System.currentTimeMillis());
            this.generateJsonJs();
            this.generateTestsResults(this.passedTests);
            this.generateTestsResults(this.failedTests);
            this.generateTestsResults(this.skippedTests);
           /* if(TestDirectory.recordSuiteExecution) {
                try {
                    this.recorder.stopRecording();
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }

            if(TestDirectory.recordTestExecution) {
                try {
                    this.testRecorder.stopRecording();
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
*/
            if(TestDirectory.generateExcelReports) {
                ExcelReports.generateExcelReport(TestDirectory.RUNDIR + TestDirectory.SEP + "(" + TestDirectory.REPORTSDIRNAME + ") " + TestDirectory.RUNName + this.runCount + ".xlsx", this.passedTests, this.failedTests, this.skippedTests);
            }
        }

    }

    private void generateJsonJs() {
        File jsDataFile = new File(TestDirectory.JSDIR + TestDirectory.SEP + "runData.js");
        JsonArray jsResults = new JsonArray();
        JsonObject jsResult = new JsonObject();
        jsResult.addProperty("date", TestDirectory.runStamp);
        jsResult.addProperty("Passed", Integer.valueOf(this.passedTests.size()));
        jsResult.addProperty("Failed", Integer.valueOf(this.failedTests.size()));
        jsResult.addProperty("Skipped", Integer.valueOf(this.skippedTests.size()));

        try {
            jsResult.addProperty("displayname", (new SimpleDateFormat(TestDirectory.runDisplayFormat)).format((new SimpleDateFormat("dd_MM_yy_hh_mm_ss_SS")).parse(TestDirectory.runStamp)));
        } catch (ParseException var20) {
            var20.printStackTrace();
        }

        FileWriter fileWs = null;

        try {
            if(jsDataFile.exists()) {
                JsonParser parser = new JsonParser();
                String jsonStr = new String(Files.readAllBytes(jsDataFile.toPath()), StandardCharsets.UTF_8);
                Object obj = parser.parse(jsonStr.replace("function getChartDataForMe(){return(", "").replace(");}", ""));
                JsonArray jsonTestsObject = (JsonArray)obj;
                jsonTestsObject.add(jsResult);
                fileWs = new FileWriter(jsDataFile);
                fileWs.write("function getChartDataForMe(){return(" + jsonTestsObject.toString() + ");}");
            } else {
                fileWs = new FileWriter(jsDataFile);
                jsDataFile.createNewFile();
                jsResults.add(jsResult);
                fileWs.write("function getChartDataForMe(){return(" + jsResults.toString() + ");}");
            }
        } catch (IOException var18) {
            var18.printStackTrace();
        } finally {
            try {
                fileWs.flush();
                fileWs.close();
            } catch (IOException var17) {
                var17.printStackTrace();
            }

        }

    }

    private void generateTestsResults(List<ITestResult> tests) {
        PrintWriter printWriter = null;
        Iterator var4 = tests.iterator();

        while(var4.hasNext()) {
            ITestResult testResult = (ITestResult)var4.next();
            String reportDir = testResult.getAttribute("reportDir").toString();

            try {
                printWriter = new PrintWriter(reportDir + TestDirectory.SEP + testResult.getName() + ".html");
                TestCaseReportsPageWriter.printHeader(printWriter, testResult);
                TestCaseReportsPageWriter.printMenuLink(printWriter, testResult, 0);
                TestCaseReportsPageWriter.printContent(printWriter, testResult, this.runCount);
                TestCaseReportsPageWriter.printFooter(printWriter);
            } catch (FileNotFoundException var15) {
                var15.printStackTrace();
            } finally {
                try {
                    printWriter.close();
                } catch (Exception var14) {
                    printWriter = null;
                }

            }
        }

    }

    public void onStart(ISuite suite) {
        if(!this.isSuiteStarted) {
            this.isSuiteStarted = true;

            try {
                String ts = Long.valueOf(System.currentTimeMillis()).toString();
                suite.setAttribute("startExecution", ts);
                TestDirectory.init(ts);
                TestDirectory.mkDirs(TestDirectory.RUNDIR + TestDirectory.SEP + suite.getName());
                /*if(TestDirectory.recordSuiteExecution) {
                    this.recorder = new Recorder(TestDirectory.RUNDIR + TestDirectory.SEP + "suite.mov");
                    this.recorder.startRecording();
                }*/

                Iterator var4 = suite.getXmlSuite().getTests().iterator();

                while(var4.hasNext()) {
                    Object xmlTest = var4.next();
                    XmlTest test = (XmlTest)xmlTest;
                    TestDirectory.mkDirs(TestDirectory.RUNDIR + TestDirectory.SEP + suite.getName() + TestDirectory.SEP + test.getName());
                }
            } catch (Exception var6) {
                throw new IllegalStateException(var6);
            }
        }

    }

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        method.isConfigurationMethod();
        method.isTestMethod();
    }

    private static void createReportDir(ITestResult method) {
        String reportPath = getReportDir(method);
        TestDirectory.mkDirs(reportPath);
        TestDirectory.mkDirs(reportPath + TestDirectory.SEP + TestDirectory.SCREENSHOT_DIRName);
    }

    private static void setPlatfromBrowserDetails(ITestResult method) {
        Platform.prepareDetails(NXGReports.getWebDriver());
        method.setAttribute(Platform.BROWSER_NAME_PROP, Platform.BROWSER_NAME);
        method.setAttribute(Platform.BROWSER_VERSION_PROP, Platform.BROWSER_VERSION);
    }

    public static String getRelativePathFromSuiteLevel(ITestResult testResult) {
        String suiteName = testResult.getTestContext().getSuite().getName();
        String testName = testResult.getTestContext().getCurrentXmlTest().getName();
        String classname = testResult.getTestClass().getName().replace(".", TestDirectory.SEP);
        String methodName = testResult.getMethod().getMethodName();
        methodName = methodName + "_Iteration" + (testResult.getMethod().getCurrentInvocationCount() + 1);
        return suiteName + TestDirectory.SEP + testName + TestDirectory.SEP + classname + TestDirectory.SEP + methodName;
    }

    public static String getReportDir(ITestResult testResult) {
        String relativePath = getRelativePathFromSuiteLevel(testResult);
        testResult.setAttribute("relativeReportDir", relativePath);
        String rptDir = TestDirectory.RUNDIR + TestDirectory.SEP + relativePath;
        testResult.setAttribute("iteration", Integer.valueOf(testResult.getMethod().getCurrentInvocationCount() + 1));
        testResult.setAttribute("reportDir", rptDir);
        return rptDir;
    }

    public void generateIndexPage() {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(TestDirectory.REPORTSDIR + TestDirectory.SEP + "index.html");
            IndexPageWriter.printHeader(printWriter);
            IndexPageWriter.printContent(printWriter, NXGReports.indexPageDescription);
            IndexPageWriter.printFooter(printWriter);
        } catch (FileNotFoundException var11) {
            var11.printStackTrace();
        } finally {
            try {
                printWriter.close();
            } catch (Exception var10) {
                printWriter = null;
            }

        }

    }

    private void generateCurrentRunPage(long startTime, long endTime) {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(TestDirectory.RUNDIR + TestDirectory.SEP + "Result.html");
            ResultPageWriter.printHeader(printWriter, this.passBrowserTest, this.failBrowserTest, this.skipBrowserTest, this.passedTests, this.failedTests, this.skippedTests);
            ResultPageWriter.printMenuLink(printWriter, 0);
            ResultPageWriter.printContent(printWriter, this.passBrowserTest, this.failBrowserTest, this.skipBrowserTest, this.passedTests, this.failedTests, this.skippedTests, startTime, endTime);
            ResultPageWriter.printFooter(printWriter);
        } catch (FileNotFoundException var15) {
            var15.printStackTrace();
        } finally {
            try {
                printWriter.close();
            } catch (Exception var14) {
                printWriter = null;
            }

        }

    }
}
