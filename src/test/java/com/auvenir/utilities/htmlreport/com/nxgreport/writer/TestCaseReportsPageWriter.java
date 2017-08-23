package com.auvenir.utilities.htmlreport.com.nxgreport.writer;

import com.auvenir.utilities.htmlreport.com.nxgreport.ReportLabels;
import com.auvenir.utilities.htmlreport.com.nxgreport.enums.Colors;
import com.auvenir.utilities.htmlreport.com.nxgreport.enums.ExceptionDetails;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.*;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class TestCaseReportsPageWriter {

    private static final int[] logStepNumber = {1, 2, 3, 4};

    public TestCaseReportsPageWriter() {
    }

    public static void printHeader(PrintWriter printWriter, ITestResult testResult) {
        printWriter.println("<!DOCTYPE html><html>\t<head>\t\t<title>Result for:-" + testResult
                .getName() + "</title>" + "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../" + getTestCaseHTMLPath(
                testResult) + TestDirectory.RESOURCESDIRName + "/CSS/design.css\" />\n" + "\t\t<script type=\"text/javascript\" src=\"../" + getTestCaseHTMLPath(
                testResult) + TestDirectory.RESOURCESDIRName + "/JS/jquery.min.js\"></script>\n" + "\t\t<!--[if lt IE 9]>\n" + "\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"../" + getTestCaseHTMLPath(
                testResult) + TestDirectory.RESOURCESDIRName + "/JS/excanvas.js\"></script>\n" + "\t\t<![endif]-->\n" + "\t\t\t<script language=\"javascript\" type=\"text/javascript\">" + "\t\t\t\t$(document).ready(function() { $(\".video\").hide();" + "\t\t\t\t\t$(\"#showmenu\").show(); " + "\t\t\t\t\t$('#showmenu').click(function(){ " + "\t\t\t\t\t\t$('.video').toggle(\"slide\"); " + "\t\t\t\t\t}); " + "\t\t\t\t});" + "\t\t\t</script>" + "\t\t\t<style>" + "\t\t\t\t\t#showmenu{text-align:center; padding-top:20px;color: #585858; font-size: 14px;}" + "\t\t\t\t\t#video{height: 550px;margin-top: 5px;width: 97%;border-style: solid;border-width: 1px;border-color: #21ABCD;/* Shadow for boxes */  -moz-box-shadow: 0 0 10px #CCCCCC;    -ms-box-shadow: 0 0 10px #CCCCCC;    -webkit-box-shadow: 0 0 10px #CCCCCC;    box-shadow: 0 0 10px #CCCCCC;    zoom: 1;    filter: progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=0),        progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=90),        progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=180),        progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=270);    background-color: white;}" + "\t\t\t</style>" + "\t</head>\n" + "\t<body>\n" + "\t\t<table id=\"mainTable\">\n" + "\t\t\t<tr id=\"header\" >\n" + "\t\t\t\t<td id=\"logo\">" + "\t\t\t\t\t<img src=\"../" + getTestCaseHTMLPath(
                testResult) + TestDirectory.RESOURCESDIRName + "/IMG/" + "Auvenir_01.png" + "\" alt=\"Logo\" height=\"80\" width=\"140\" /> " + "<br/>" + ReportLabels.CAPTION
                .getLabel() + "\t\t\t\t</td>\n" + "\t\t\t\t<td id=\"headertext\">\n" + "\t\t\t\t\t" + ReportLabels.HEADER_TEXT
                .getLabel() + "\n" + "\t\t\t\t</td>\n" + "\t\t\t</tr>");
    }

    private static String getTestCaseHTMLPath(ITestResult result) {
        String htmlPath = result.getAttribute("reportDir").toString();
        htmlPath = htmlPath.substring(htmlPath.indexOf(TestDirectory.RUNDIR) + TestDirectory.RUNDIR.length() + 1);
        String[] paths = htmlPath.replace(TestDirectory.SEP, "##@##@##").split("##@##@##");
        htmlPath = "";

        for (int i = 0; i < paths.length; ++i) {
            htmlPath = htmlPath + "../";
        }

        return htmlPath;
    }

    public static void printMenuLink(PrintWriter printWriter, ITestResult testResult, int i) {
        getTestCaseHTMLPath(testResult);
        printWriter.println("\n            <tr id=\"container\">\n                <td id=\"menu\">\n                    <ul> \n");
        printWriter.println(" <li class=\"menuStyle\"><a href=\"../" + getTestCaseHTMLPath(
                testResult) + "index.html\" >Index</a></li>" + "<li style=\"padding-top: 4px;\"><a href=\"" + getTestCaseHTMLPath(
                testResult) + "Result.html\" >Full Result Page</a></li>\n");
        if (i == 1) {
            printWriter.println(
                    "\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + i + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + i + " </a></li>\n");
        } else {
            for (int var3 = 1; var3 <= i; ++var3) {
                if (var3 == i) {
                    printWriter.println(
                            "\n <li style=\"padding-top: 4px;padding-bottom: 4px;\"><a href=\"" + TestDirectory.RUNName + var3 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var3 + " </a></li>\n");
                    break;
                }

                printWriter.println(
                        "\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + var3 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var3 + " </a></li>\n");
            }
        }

        printWriter.println("\n                    </ul>\n                </td>\n\n");
    }

    public static void printContent(PrintWriter printWriter, ITestResult testResult, int runCount) {
        printWriter.println(
                "<td id=\"content\">\n\t\t<div class=\"info\">\n\t\t\tThe following table lists down the Sequential stepDefinitions during the Run <br/>\nTestCase Name: <b>" + testResult
                        .getName() + "  :  Iteration " + testResult.getAttribute("iteration")
                        .toString() + "</b><br/>" + "\t\t\tTime Taken for Executing: <b>" + getExecutionTime(
                        testResult) + "</b> <br/>\n" + "\t\t\tCurrent Run Number: <b>Run " + runCount + "</b></br>\n" + "Method Type: <b>" + com.auvenir.utilities.htmlreport.com.nxgreport.writer.ResultPageWriter
                        .getMethodType(
                                testResult) + "</b></br>" + "\t\t</div>" + "\t\t<!--div class=\"info\"><br/>" + "\t\t\t<b>Requirement Coverage/ TestCase Description</b><br/><br/>" + getReqCoverageInfo(
                        testResult) + "\t\t</div-->");
        if (TestDirectory.recordTestExecution) {
            printWriter.println(
                    "<div><p id=\"showmenu\">Click Me to Show/Hide the Execution Video</p><div id=\"video\" class=\"video\"><object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://downloads.videolan.org/pub/videolan/vlc/latest/win32/axvlc.cab\" width=\"400\" height=\"300\" id=\"vlc\" events=\"True\">  <param name=\"Src\" value=\"" + testResult
                            .getName() + ".mov\"></param>  <param name=\"ShowDisplay\" value=\"True\" ></param>    <param name=\"AutoLoop\" value=\"no\"></param>    <param name=\"AutoPlay\" value=\"no\"></param>    <embed type=\"application/x-google-vlc-plugin\" name=\"vlcfirefox\" autoplay=\"no\" loop=\"no\" width=\"99%\"  height=\"100%\" target=\"" + testResult
                            .getName() + ".mov\"></embed> </object>" + "</div>");
        } else {
            printWriter.println("<p id=\"showmenu\">No Video Recording Available</p>");
        }

        printWriter
                .print("\t\t<div class=\"chartStyle summary\" style=\"background-color: #646D7E;width: 225px; height: 200px;\">\n\t\t\t<b>Execution Platform Details</b><br/><br/>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>O.S</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>" + Platform.OS + ", " + Platform.OS_ARCH + "Bit, v" + Platform.OS_VERSION + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Java</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + Platform.JAVA_VERSION + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Hostname</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + Platform
                        .getHostName() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Selenium</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + Platform.DRIVER_VERSION + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t</table>  \n" + "\t\t</div>\n" + "\t\t<div class=\"chartStyle summary\" style=\"background-color: " + getColorBasedOnResult(
                        testResult) + ";margin-left: 20px; height: 200px;width: 225px; \">\n" + "\t\t\t<b>Summary</b><br/><br/>\n" + "\t\t\t<table>\n" + "\t\t\t<tr>\n" + "\t\t\t\t<td>Status</td>\n" + "\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t<td>" + getResult(
                        testResult) + "</td>\n" + "\t\t\t</tr>\n" + "\t\t\t<tr>\n" + "\t\t\t\t<td>Execution Date</td>\n" + "\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t<td>" + Utils
                        .getCurrentTime() + "</td>\n" + "\t\t\t</tr>\n" + "\t\t\t<tr>\n" + "\t\t\t\t<td>Browser</td>\n" + "\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t<td>" + getBrowserName(
                        testResult) + "," + getBrowserName(testResult) + "</td>\n" + "\t\t\t</tr>\n" + "\t\t\t</table> \n" + "\t\t</div>");
        AuthorDetails authorDetails = null;

        try {
            if (testResult.getAttribute("authorInfo") == null) {
                authorDetails = new AuthorDetails();
            } else {
                authorDetails = (AuthorDetails) testResult.getAttribute("authorInfo");
            }
        } catch (Exception var15) {
            ;
        }

        printWriter.println(
                "<div class=\"chartStyle summary\" style=\"background-color: #7F525D;margin-left: 20px; height: 200px;width: 225px; \">\n\t\t\t\t<b>Author Info</b><br/><br/>\n\t\t\t\t<table>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>Author Name</td>\n\t\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t\t<td>" + authorDetails
                        .getAuthorName() + "</td>" + "\t\t\t\t\t</tr>\n" + "\t\t\t\t\t<tr>\n" + "\t\t\t\t\t\t<td>Creation Date</td>\n" + "\t\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t\t<td>" + authorDetails
                        .getCreationDate() + "</td>\n" + "\t\t\t\t\t</tr>\n" + "\t\t\t\t\t<tr>\n" + "\t\t\t\t\t\t<td>Version</td>\n" + "\t\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t\t<td>" + authorDetails
                        .getVersion() + "</td>\n" + "\t\t\t\t\t</tr>\n" + "\t\t\t\t\t<tr>\n" + "\t\t\t\t\t\t<td>System User</td>\n" + "\t\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t\t<td>" + Platform.USER + "</td>\n" + "\t\t\t\t\t</tr>\n" + "\t\t\t\t</table> \n" + "\t\t\t</div>\n");
        int intCount;
        if (testResult.getStatus() != 3) {
            List<String> lstResult = Reporter.getOutput(testResult);
            printWriter.println(
                    "<div>\n\t\t\t<table class=\"chartStyle\" id=\"tableStyle\" style=\"height:50px; float: left\">\n\t\t\t\t<tr>\n\t\t\t\t\t<th>S.No</th>\n\t\t\t\t\t<th>Step Description</th>\n\t\t\t\t\t<th>Input Value</th>\n\t\t\t\t\t<th>Expected Value</th>\n\t\t\t\t\t<th>Actual Value</th>\n\t\t\t\t\t<th>Time</th>\n\t\t\t\t\t<th>Line No</th>\n\t\t\t\t\t<th>Status</th>\n\t\t\t\t\t<th>Screen shot</th>\n\t\t\t\t</tr>\n");
            if (Reporter.getOutput(testResult).size() <= 0) {
                printWriter.print("<tr>");
                printWriter.print("<td colspan=\"8\"><b>No stepDefinitions Available</b></td>");
                printWriter.print("</tr>");
            }

            intCount = 1;
            Iterator var7 = lstResult.iterator();

            while (var7.hasNext()) {
                String strResult = (String) var7.next();
                Steps steps = null;
                steps = (Steps) testResult.getAttribute(strResult);
                if (steps == null) {
                    printWriter.print("<tr><td>" + intCount + "</td>" + "<td style=\"text-align:left\" colspan=\"8\">" + strResult + "</td></tr>");
                    ++intCount;
                } else {
                    printWriter.print("<tr><td>" + intCount + "</td>" + "<td>" + steps.getDescription() + "</td>" + "<td>" + steps
                            .getInputValue() + "</td>" + "<td>" + steps.getExpectedValue() + "</td>" + "<td>" + steps
                            .getActualValue() + "</td>" + "<td>" + steps.getTime() + "</td>" + "<td>" + steps
                            .getLineNum() + "</td>" + "<td>" + getLogDescription(steps.getLogAs(), testResult) + "</td>");

                    try {
                        Integer.parseInt(steps.getScreenShot().trim());
                        printWriter.println(
                                "<td><a href=\"" + TestDirectory.SCREENSHOT_DIRName + "/" + intCount + ".PNG" + "\"><img alt=\"No Screenshot\" src=\"" + TestDirectory.SCREENSHOT_DIRName + "/" + intCount + ".PNG" + "\"/></a></td>");
                    } catch (Exception var14) {
                        printWriter.println("<td></td>");
                    }

                    printWriter.print("</tr>");
                    ++intCount;
                }
            }

            printWriter.print("\n</table>  \n");
        }

        if (testResult.getParameters().length > 0 || testResult.getStatus() == 3 || testResult.getStatus() == 2) {
            printWriter.println(
                    " <div class=\"chartStyle summary\" style=\"color: black;width: 98%; height: 100%; padding-bottom: 30px;\">          \n");
            if (testResult.getParameters().length > 0) {
                printWriter.print("<b>Parameters: </b><br/>");
                Object[] parameters = testResult.getParameters();
                intCount = parameters.length;

                for (int cntr = 0; cntr < intCount; ++cntr) {
                    Object parameter = parameters[cntr];
                    if (null != parameter) {
                        printWriter.print("Param: " + parameter.toString() + "<br/>");
                    }
                }
            }

            if (testResult.getStatus() == 3) {
                printWriter.print("<br/><br/>");
                printWriter.println("                      <b>Reason for Skipping</b><br/><br/>\n");
                String[] grpDepends = testResult.getMethod().getGroupsDependedUpon();
                String[] methodDepends = testResult.getMethod().getMethodsDependedUpon();
                String tmpGrpStr;
                int var10;
                int var11;
                String[] var12;
                String finGrpStr;
                if (grpDepends.length > 0) {
                    finGrpStr = "";
                    var12 = grpDepends;
                    var11 = grpDepends.length;

                    for (var10 = 0; var10 < var11; ++var10) {
                        tmpGrpStr = var12[var10];
                        finGrpStr = finGrpStr + tmpGrpStr + "<br/>";
                    }

                    printWriter.print("<b>Depends on Groups: </b><br/>" + finGrpStr);
                }

                if (methodDepends.length > 0) {
                    finGrpStr = "";
                    var12 = methodDepends;
                    var11 = methodDepends.length;

                    for (var10 = 0; var10 < var11; ++var10) {
                        tmpGrpStr = var12[var10];
                        finGrpStr = finGrpStr + tmpGrpStr + "<br/>";
                    }

                    printWriter.print("<b>Depends on Methods: </b><br/>" + finGrpStr + "<br/><br/>");
                }

                printWriter.print("</div>");
            }

            if (testResult.getStatus() == 2) {
                /*printWriter.println("<br/><br/><b>Reason for Failure:&nbsp;&nbsp;</b>" + getExceptionDetails(testResult) + "<br/><br/>\n" + "<b id=\"showmenu\">Click Me to Show/Hide the Full Stack Trace</b>" + "<div class=\"exception\">");*/
                printWriter.println("<b>Step Fail:&nbsp;&nbsp;</b>\n" + "<div class=\"exception\">");
                List<String> lstResult = Reporter.getOutput(testResult);
                printWriter.println(
                        "\n\t\t\t<table class=\"chartStyle\" id=\"tableStyle\" style=\"height:50px; float: left\">\n\t\t\t\t<tr>\n\t\t\t\t\t<th>S.No</th>\n\t\t\t\t\t<th>Step Description</th>\n\t\t\t\t\t<th>Error Reason</th>\n\t\t\t\t\t</tr>\n");
                intCount = 1;
                Iterator var7 = lstResult.iterator();

                while (var7.hasNext()) {
                    String strResult = (String) var7.next();
                    Steps steps = null;
                    steps = (Steps) testResult.getAttribute(strResult);
                    if (steps != null && null != steps.getStepException()) {
                        printWriter.print("<tr><td>" + intCount + "</td>" + "<td>" + steps.getDescription() + "</td>" + "<td>" + steps
                                .getStepException() + "</td>" + "</tr>");
                        ++intCount;
                    }
                }
                /*try {
                    testResult.getThrowable().printStackTrace(printWriter);
                } catch (Exception var13) {
                    ;
                }*/
                printWriter.print("\n</table>  \n");

                printWriter.print("</div>");
            }

            printWriter.print("</div>");
        }

        printWriter.print("</div>\n\n </td>\n</tr>");
    }

    private static String getExceptionDetails(ITestResult testResult) {
        try {
            testResult.getThrowable().toString();
        } catch (Throwable var4) {
            return "";
        }

        String strThrowable = testResult.getThrowable().toString();
        String strThrowable_ = strThrowable;
        if (strThrowable.contains(":")) {
            strThrowable_ = strThrowable.substring(0, strThrowable.indexOf(":")).trim();
        } else {
            strThrowable = "";
        }

        try {
            strThrowable_ = getExceptionClassName(strThrowable_, strThrowable);
            if (strThrowable_.equals("Assertion Error")) {
                if (strThrowable.contains(">")) {
                    strThrowable_ =
                            strThrowable_ + strThrowable.substring(strThrowable.indexOf(":"), strThrowable.lastIndexOf(">") + 1).replace(">", "\"");
                    strThrowable_ = strThrowable_.replace("<", "\"");
                }

                if (testResult.getThrowable().getMessage().trim().length() > 0) {
                    strThrowable_ = testResult.getThrowable().getMessage().trim();
                }
            } else if (strThrowable.contains("{")) {
                strThrowable_ = strThrowable_ + strThrowable.substring(strThrowable.indexOf("{"), strThrowable.lastIndexOf("}"));
                strThrowable_ = strThrowable_.replace("{\"method\":", " With ").replace(",\"selector\":", " = ");
            } else if (strThrowable_.equals("Unable to connect Browser") && strThrowable.contains(".")) {
                strThrowable_ = strThrowable_ + ": Browser is Closed";
            } else if (strThrowable_.equals("WebDriver Exception")) {
                strThrowable_ = testResult.getThrowable().getMessage();
            }
        } catch (Exception var5) {
            ;
        }

        strThrowable_ = strThrowable_.replace(">", "\"");
        strThrowable_ = strThrowable_.replace("<", "\"");
        return strThrowable_;
    }

    private static String getExceptionClassName(String strThrowable_, String strThrowable) {
        String exceptionClass = "";

        try {
            exceptionClass = ExceptionDetails.valueOf(strThrowable_.trim().replace(".", "_")).getExceptionInfo();
        } catch (Exception var4) {
            exceptionClass = strThrowable_;
        }

        return exceptionClass;
    }

    private static String getLogDescription(LogAs logAs, ITestResult testResult) {
        switch (logAs) {
            case FAILED:
                return "<img style=\"height:18px;width:18px;border:none\"  alt=\"FAIL\" src=\"../" + getTestCaseHTMLPath(
                        testResult) + "/" + TestDirectory.RESOURCESDIRName + "/IMG/logfail.png\" />";
            case PASSED:
                return "<img style=\"height:20px;width:20px;border:none\"  alt=\"PASS\" src=\"../" + getTestCaseHTMLPath(
                        testResult) + "/" + TestDirectory.RESOURCESDIRName + "/IMG/logpass.png\" />";
            case INFO:
                return "<img style=\"height:20px;width:20px;border:none\" alt=\"INFO\" src=\"../" + getTestCaseHTMLPath(
                        testResult) + "/" + TestDirectory.RESOURCESDIRName + "/IMG/loginfo.png\" />";
            case WARNING:
                return "<img style=\"height:20px;width:20px;border:none\"  alt=\"WARNING\" src=\"../" + getTestCaseHTMLPath(
                        testResult) + "/" + TestDirectory.RESOURCESDIRName + "/IMG/logwarning.png\" />";
            default:
                return "img";
        }
    }

    private static String getBrowserName(ITestResult testResult) {
        try {
            return testResult.getAttribute(Platform.BROWSER_NAME_PROP).toString();
        } catch (Exception var2) {
            return "";
        }
    }

    private static String getResult(ITestResult testResult) {
        if (testResult.getStatus() == 1) {
            try {
                return testResult.getAttribute("passedButFailed").equals("passedButFailed") ? "Failed" : "Passed";
            } catch (Exception var2) {
                return "Passed";
            }
        } else {
            return testResult.getStatus() == 2 ? "Failed" : (testResult.getStatus() == 3 ? "Skipped" : "Unknown");
        }
    }

    private static String getColorBasedOnResult(ITestResult testResult) {
        return testResult.getStatus() == 1 ? Colors.PASS.getColor() : (testResult.getStatus() == 2 ? Colors.FAIL.getColor() : (testResult
                .getStatus() == 3 ? Colors.SKIP.getColor() : Colors.PASS.getColor()));
    }

    private static String getReqCoverageInfo(ITestResult testResult) {
        try {
            return testResult.getAttribute("reqCoverage") == null ? ReportLabels.TC_INFO_LABEL.getLabel() : testResult.getAttribute("reqCoverage")
                    .toString();
        } catch (Exception var2) {
            return ReportLabels.TC_INFO_LABEL.getLabel();
        }
    }

    private static String getExecutionTime(ITestResult testResult) {
        long var1 = testResult.getEndMillis() - testResult.getStartMillis();
        if (var1 > 1000L) {
            var1 /= 1000L;
            return var1 + " Sec";
        } else {
            return var1 + " Milli Sec";
        }
    }

    public static void printFooter(PrintWriter printWriter) {
        printWriter.println(
                "\t\t\t<tr id=\"footer\">\n\t\t\t\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t\t\t\tBest Viewed in &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.mozilla.org/en-US/firefox/new/\">Firefox</a> &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.apple.com/in/safari/\">Safari</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.google.com/chrome/\">Chrome</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://windows.microsoft.com/en-IN/internet-explorer/download-ie\">IE 9 & Above</a>&nbsp;\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\tNXG Reporter Version: v1.0.0&nbsp;\n\t\t\t\t\t\t\tReports by: <a href=\"http://seleniumbyneeds.blogspot.in/\">Selenium By Needs</a>\n\t\t\t\t\t</td>\n \t\t\t\t</tr>\n\t\t\t</table>\n\t\t</body>\n</html>");
    }
}
