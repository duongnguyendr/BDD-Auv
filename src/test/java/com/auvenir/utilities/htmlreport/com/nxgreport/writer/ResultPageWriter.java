package com.auvenir.utilities.htmlreport.com.nxgreport.writer;

import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.ReportLabels;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.Platform;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.TestDirectory;
import com.auvenir.utilities.htmlreport.com.nxgreport.utils.Utils;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class ResultPageWriter {
    public ResultPageWriter() {
    }

    public static void printHeader(PrintWriter printWriter, ArrayList<String> passedBrowserTest, ArrayList<String> failedBrowserTest, ArrayList<String> skippedBrowserTest , List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests) {
        int passChromeCount = countStatusStepTest(passedBrowserTest,passedTests,"CHROME");
        int failChromeCount = countStatusStepTest(failedBrowserTest,failedTests,"CHROME");
        int skipChromeCount = countStatusStepTest(skippedBrowserTest, skippedTests, "CHROME");

        int passFireFoxCount = countStatusStepTest(passedBrowserTest,passedTests,"FIREFOX");
        int failFireFoxCount = countStatusStepTest(failedBrowserTest,failedTests,"FIREFOX");
        int skipFireFoxCount = countStatusStepTest(skippedBrowserTest, skippedTests, "FIREFOX");

        int passSafariCount = countStatusStepTest(passedBrowserTest,passedTests,"SAFARI");
        int failSafariCount = countStatusStepTest(failedBrowserTest,failedTests,"SAFARI");
        int skipSafariCount = countStatusStepTest(skippedBrowserTest, skippedTests, "SAFARI");

        int passEdgeCount = countStatusStepTest(passedBrowserTest,passedTests,"EDGE");
        int failEdgeCount = countStatusStepTest(failedBrowserTest,failedTests,"EDGE");
        int skipEdgeCount = countStatusStepTest(skippedBrowserTest, skippedTests, "EDGE");

        printWriter.println("<!DOCTYPE html>\n\n<html>\n<head>\n\t\t<title>Suite Report</title>\n\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.CSSDIRName + "/design.css\" />\n" + "\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>" + "     <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css\">" + "\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\"></script>"  + "\t\t\t<!--[if lt IE 9]>\n" + "\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/excanvas.js\"></script>\n" + "\t\t\t<![endif]-->\n\n" + "\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/amcharts.js\"></script>\n" + "\t\t\t<script type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/pie.js\">\n</script>\n" + "\t\n\t\t<script language=\"javascript\" type=\"text/javascript\">" + "\t\n\t\t\t$(document).ready(function() { $(\".video\").hide();" + "\t\n\t\t\t\t$(\"#showmenu\").show(); " + "\t\n\t\t\t\t$('#showmenu').click(function(){ " + "\t\n\t\t\t\t\t$('.video').toggle(\"slide\"); " + "\t\n\t\t\t\t}); " + "\t\n\t\t\t});" + "\t\n\t\t</script>" + "\t\n\t\t<style>" + "\t\n\t\t\t\t#showmenu{text-align:center; padding-top:20px;color: #585858; font-size: 14px;}" + "\t\n\t\t\t\t#video{height: 550px;margin-top: 5px;width: 97%;border-style: solid;border-width: 1px;border-color: #21ABCD;/* Shadow for boxes */ -moz-box-shadow: 0 0 10px #CCCCCC; -ms-box-shadow: 0 0 10px #CCCCCC; -webkit-box-shadow: 0 0 10px #CCCCCC; box-shadow: 0 0 10px #CCCCCC; zoom: 1; filter: progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=0), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=90), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=180), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=270); background-color: white;}" + "\t\n\t\t</style>" + "\t\n\t\t<script language=\"javascript\" type=\"text/javascript\">\n" + "\t\n\t\t\t$(document).ready(function(){\n" + "\t\n\t\t\t\t$('#tcFilterCHROME').on('change',function(){" + "\t\n\t\t\t\t\tif($(this).val()=='pass'){" + "\t\n\t\t\t\t\t\t$('.passCHROME').show();" + "\t\n\t\t\t\t\t\t$('.failCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.configCHROME').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='fail'){" + "\t\n\t\t\t\t\t\t$('.passCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.failCHROME').show();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.configCHROME').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='skip'){" + "\t\n\t\t\t\t\t\t$('.passCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.failCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').show();" + "\t\n\t\t\t\t\t\t$('.configCHROME').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='tests'){ " + "\t\n\t\t\t\t\t\t$('.passCHROME').show(); " + "\t\n\t\t\t\t\t\t$('.failCHROME').show();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').show(); " + "\t\n\t\t\t\t\t\t$('.configCHROME').hide(); " + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='config'){" + "\t\n\t\t\t\t\t\t$('.passCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.failCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').hide();" + "\t\n\t\t\t\t\t\t$('.configCHROME').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='all'){" + "\t\n\t\t\t\t\t\t$('.passCHROME').show();" + "\t\n\t\t\t\t\t\t$('.failCHROME').show();" + "\t\n\t\t\t\t\t\t$('.skipCHROME').show();" + "\t\n\t\t\t\t\t\t$('.configCHROME').show();" + "\t\n\t\t\t\t\t}"  + "\t\n\t\t\t});" + "\t\n\t\t\t\t$('#tcFilterFIREFOX').on('change',function(){" + "\t\n\t\t\t\t\tif($(this).val()=='pass'){" + "\t\n\t\t\t\t\t\t$('.passFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.failFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.configFIREFOX').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='fail'){" + "\t\n\t\t\t\t\t\t$('.passFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.failFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.configFIREFOX').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='skip'){" + "\t\n\t\t\t\t\t\t$('.passFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.failFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.configFIREFOX').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='tests'){ " + "\t\n\t\t\t\t\t\t$('.passFIREFOX').show(); " + "\t\n\t\t\t\t\t\t$('.failFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').show(); " + "\t\n\t\t\t\t\t\t$('.configFIREFOX').hide(); " + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='config'){" + "\t\n\t\t\t\t\t\t$('.passFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.failFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').hide();" + "\t\n\t\t\t\t\t\t$('.configFIREFOX').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='all'){" + "\t\n\t\t\t\t\t\t$('.passFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.failFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.skipFIREFOX').show();" + "\t\n\t\t\t\t\t\t$('.configFIREFOX').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t});"  + "\t\n\t\t\t\t$('#tcFilterSAFARI').on('change',function(){" + "\t\n\t\t\t\t\tif($(this).val()=='pass'){" + "\t\n\t\t\t\t\t\t$('.passSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.failSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.configSAFARI').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='fail'){" + "\t\n\t\t\t\t\t\t$('.passSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.failSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.configSAFARI').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='skip'){" + "\t\n\t\t\t\t\t\t$('.passSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.failSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.configSAFARI').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='tests'){ " + "\t\n\t\t\t\t\t\t$('.passSAFARI').show(); " + "\t\n\t\t\t\t\t\t$('.failSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').show(); " + "\t\n\t\t\t\t\t\t$('.configSAFARI').hide(); " + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='config'){" + "\t\n\t\t\t\t\t\t$('.passSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.failSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').hide();" + "\t\n\t\t\t\t\t\t$('.configSAFARI').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='all'){" + "\t\n\t\t\t\t\t\t$('.passSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.failSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.skipSAFARI').show();" + "\t\n\t\t\t\t\t\t$('.configSAFARI').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t});" + "\t\n\t\t\t\t$('#tcFilterEDGE').on('change',function(){" + "\t\n\t\t\t\t\tif($(this).val()=='pass'){" + "\t\n\t\t\t\t\t\t$('.passEDGE').show();" + "\t\n\t\t\t\t\t\t$('.failEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.configEDGE').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='fail'){" + "\t\n\t\t\t\t\t\t$('.passEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.failEDGE').show();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.configEDGE').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='skip'){" + "\t\n\t\t\t\t\t\t$('.passEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.failEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').show();" + "\t\n\t\t\t\t\t\t$('.configEDGE').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='tests'){ " + "\t\n\t\t\t\t\t\t$('.passEDGE').show(); " + "\t\n\t\t\t\t\t\t$('.failEDGE').show();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').show(); " + "\t\n\t\t\t\t\t\t$('.configEDGE').hide(); " + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='config'){" + "\t\n\t\t\t\t\t\t$('.passEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.failEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').hide();" + "\t\n\t\t\t\t\t\t$('.configEDGE').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='all'){" + "\t\n\t\t\t\t\t\t$('.passEDGE').show();" + "\t\n\t\t\t\t\t\t$('.failEDGE').show();" + "\t\n\t\t\t\t\t\t$('.skipEDGE').show();" + "\t\n\t\t\t\t\t\t$('.configEDGE').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t});" + "\t\n\t\t\t});" + "\t\n\t\t</script>" + " \n <script> " + " \n var chartChrome; " + " \n var legend; " + " \n " + " \n var chartDataChrome = [ " + " \n { " + " \n 'status': 'Passed', " + " \n 'value': " + passChromeCount + ", 'color':'#0F9D28' " + " \n }, " + " \n { " + " \n 'status': 'Failed', " + " \n 'value': " + failChromeCount + ", 'color':'#DF0C12' " + " \n }, " + " \n { " + " \n 'status': 'Skipped', " + " \n 'value': " + skipChromeCount + ", 'color':'#F3F24D' " + " \n } " + " \n ]; " + " \n " + " \n AmCharts.ready(function () { " + " \n // PIE CHART " + " \n chartChrome = new AmCharts.AmPieChart(); " + " \n chartChrome.dataProvider = chartDataChrome; " + " \n chartChrome.titleField = 'status'; " + " \n chartChrome.valueField = 'value'; " + " \n chartChrome.outlineColor = '#FFFFFF'; " + " \n chartChrome.outlineAlpha = 0.8; " + " \n chartChrome.outlineThickness = 2; " + " \n chartChrome.colorField = 'color'; " + " \n chartChrome.balloonText = '[[title]]<br><span style=\"font-size:14px\"><b>[[status]]</b> ([[value]])</span>';" + " \n // this makes the chart 3D " + " \n chartChrome.depth3D = 15; " + " \n chartChrome.angle = 30; " + " \n " + " \n // WRITE " + " \n chartChrome.write('chartCHROME'); " + " \n }); " + " \n var chartFireFox; " + " \n " + " \n var chartDataFireFox = [ " + " \n { " + " \n 'status': 'Passed', " + " \n 'value': " + passFireFoxCount + ", 'color':'#0F9D28' " + " \n }, " + " \n { " + " \n 'status': 'Failed', " + " \n 'value': " + failFireFoxCount + ", 'color':'#DF0C12' " + " \n }, " + " \n { " + " \n 'status': 'Skipped', " + " \n 'value': " + skipFireFoxCount + ", 'color':'#F3F24D' " + " \n } " + " \n ]; " + " \n " + " \n AmCharts.ready(function () { " + " \n // PIE CHART " + " \n chartFireFox = new AmCharts.AmPieChart(); " + " \n chartFireFox.dataProvider = chartDataFireFox; " + " \n chartFireFox.titleField = 'status'; " + " \n chartFireFox.valueField = 'value'; " + " \n chartFireFox.outlineColor = '#FFFFFF'; " + " \n chartFireFox.outlineAlpha = 0.8; " + " \n chartFireFox.outlineThickness = 2; " + " \n chartFireFox.colorField = 'color'; " + " \n chartFireFox.balloonText = '[[title]]<br><span style=\"font-size:14px\"><b>[[status]]</b> ([[value]])</span>';" + " \n // this makes the chart 3D " + " \n chartFireFox.depth3D = 15; " + " \n chartFireFox.angle = 30; " + " \n " + " \n // WRITE " + " \n chartFireFox.write('chartFIREFOX'); " + " \n }); " + " \n var chartSafari; " + " \n " + " \n var chartDataSafari = [ " + " \n { " + " \n 'status': 'Passed', " + " \n 'value': " + passSafariCount + ", 'color':'#0F9D28' " + " \n }, " + " \n { " + " \n 'status': 'Failed', " + " \n 'value': " + failSafariCount + ", 'color':'#DF0C12' " + " \n }, " + " \n { " + " \n 'status': 'Skipped', " + " \n 'value': " + skipSafariCount + ", 'color':'#F3F24D' " + " \n } " + " \n ]; " + " \n " + " \n AmCharts.ready(function () { " + " \n // PIE CHART " + " \n chartSafari = new AmCharts.AmPieChart(); " + " \n chartSafari.dataProvider = chartDataSafari; " + " \n chartSafari.titleField = 'status'; " + " \n chartSafari.valueField = 'value'; " + " \n chartSafari.outlineColor = '#FFFFFF'; " + " \n chartSafari.outlineAlpha = 0.8; " + " \n chartSafari.outlineThickness = 2; " + " \n chartSafari.colorField = 'color'; " + " \n chartSafari.balloonText = '[[title]]<br><span style=\"font-size:14px\"><b>[[status]]</b> ([[value]])</span>';" + " \n // this makes the chart 3D " + " \n chartSafari.depth3D = 15; " + " \n chartSafari.angle = 30; " + " \n " + " \n // WRITE " + " \n chartSafari.write('chartSAFARI'); " + " \n }); " + " \n var chartEdge; " + " \n " + " \n var chartDataEdge = [ " + " \n { " + " \n 'status': 'Passed', " + " \n 'value': " + passEdgeCount + ", 'color':'#0F9D28' " + " \n }, " + " \n { " + " \n 'status': 'Failed', " + " \n 'value': " + failEdgeCount + ", 'color':'#DF0C12' " + " \n }, " + " \n { " + " \n 'status': 'Skipped', " + " \n 'value': " + skipEdgeCount + ", 'color':'#F3F24D' " + " \n } " + " \n ]; " + " \n " + " \n AmCharts.ready(function () { " + " \n // PIE CHART " + " \n chartEdge = new AmCharts.AmPieChart(); " + " \n chartEdge.dataProvider = chartDataEdge; " + " \n chartEdge.titleField = 'status'; " + " \n chartEdge.valueField = 'value'; " + " \n chartEdge.outlineColor = '#FFFFFF'; " + " \n chartEdge.outlineAlpha = 0.8; " + " \n chartEdge.outlineThickness = 2; " + " \n chartEdge.colorField = 'color'; " + " \n chartEdge.balloonText = '[[title]]<br><span style=\"font-size:14px\"><b>[[status]]</b> ([[value]])</span>';" + " \n // this makes the chart 3D " + " \n chartEdge.depth3D = 15; " + " \n chartEdge.angle = 30; " + " \n " + " \n // WRITE " + " \n chartEdge.write('chartEDGE'); " + " \n }); " + " \n   $(function() {" + " \n     $( '#tabs' ).tabs();" + " \n   });" + " \n </script> " + "\t\t</head>" + "\t\t<body>" + "\t\t\t<table id=\"mainTable\">" + "\t\t\t\t<tr id=\"header\" >" + "\t\t\t\t\t<td id=\"logo\"><img src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/" + "Auvenir_01.png" + "\" alt=\"Logo\" height=\"70\" width=\"140\" /> " + "<br/>" + ReportLabels.CAPTION.getLabel() + "</td>\n" + " \t <td id=\"headertext\">\n" + ReportLabels.HEADER_TEXT.getLabel() + "\t\t\t\t\t</td>\n" + "\t\t\t\t</tr>");
    }

    public static void printMenuLink(PrintWriter printWriter, int i) {
        printWriter.println("<tr id=\"container\">\n\t\t<td id=\"menu\">\n<ul>\t<li class=\"menuStyle\"><a href=\"../index.html\" >Index</a></li>\n");
        if(i == 1) {
            printWriter.println("\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + i + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + i + " </a></li>\n");
        } else {
            for(int var2 = 1; var2 <= i; ++var2) {
                if(var2 == i) {
                    printWriter.println("\n <li style=\"padding-top: 4px;padding-bottom: 4px;\"><a href=\"" + TestDirectory.RUNName + var2 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var2 + " </a></li>\n");
                    break;
                }

                printWriter.println("\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + var2 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var2 + " </a></li>\n");
            }
        }

        printWriter.println("\n </ul>\n </td>\n\n");
    }

    public static void printContent(PrintWriter printWriter, ArrayList<String> passedBrowserTest, ArrayList<String> failedBrowserTest, ArrayList<String> skippedBrowserTest , List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests, long startTime, long endTime) {
        printWriter.println("<td id=\"content\">\n\t\t<div id='tabs' style=\"border-style: none;\"> \n\t\t  <ul> \n\t\t\t<li><a href='#tabs-1'>CHROME</a></li> \n\t\t\t<li><a href='#tabs-2'>FIREFOX</a></li>\n\t\t <li><a href='#tabs-3'>SAFARI</a></li>\n\t\t  <li><a href='#tabs-4'>EDGE</a></li>\n\t\t </ul> ");
        printWriter.println("\n\t\t  <div id='tabs-1'> \n\t\t\t\t<div style=\"width:100%;\" id='myChromeChart'>");
        printContentFollowBrowser(printWriter, passedBrowserTest, failedBrowserTest, skippedBrowserTest, passedTests, failedTests, skippedTests, "CHROME");
        printWriter.println("</div> \n\t\t  </div> \n\t\t  </div>");
        printWriter.println("\n\t\t  <div id='tabs-2'> \n\t\t\t<div style=\"width:100%;\" id='myFireFoxChart'>");
        printContentFollowBrowser(printWriter, passedBrowserTest, failedBrowserTest, skippedBrowserTest, passedTests, failedTests, skippedTests, "FIREFOX");
        printWriter.println("</div> \n\t\t  </div> \n\t\t  </div>");
        printWriter.println("\n\t\t  <div id='tabs-3'> \n\t\t\t<div style=\"width:100%;\" id='mySafariChart'>");
        printContentFollowBrowser(printWriter, passedBrowserTest, failedBrowserTest, skippedBrowserTest, passedTests, failedTests, skippedTests, "SAFARI");
        printWriter.println("</div> \n\t\t  </div> \n\t\t  </div>");
        printWriter.println("\n\t\t  <div id='tabs-4'> \n\t\t\t<div style=\"width:100%;\" id='myEdgeChart'>");
        printContentFollowBrowser(printWriter, passedBrowserTest, failedBrowserTest, skippedBrowserTest, passedTests, failedTests, skippedTests, "EDGE");
        printWriter.println("</div> \n\t\t  </div> \n\t\t  </div>");
        printWriter.print("</td>\n </tr>");

        /*int var13 = passedTests.size() + failedTests.size() + skippedTests.size();
        printWriter.println("<td id=\"content\">\n\t\t<div class=\"info\">\n\t\t\tThe following pie chart demonstrates the percentage of Passed, Failed and Skipped Test Cases<br/>\n\t\t\tTime Taken for Executing below Test Cases: <b>" + getExecutionTime(startTime, endTime) + "</b> <br/>\n" + "\t\t\tCurrent Run Number: <b>Run " + 1 + "</b>\n" + "\t\t</div>\n" + "\t\t<div class=\"info\"><br/>" + "\t\t\t<b>Run Description</b>" + "\t\t\t<br/><br/>" + NXGReports.currentRunDescription + "\t\t</div>" + "\t\t<div>\n");
        if(TestDirectory.recordSuiteExecution) {
            printWriter.println("<p id=\"showmenu\">Click Me to Show/Hide the Execution Video</p><div id=\"video\" class=\"video\"><object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://downloads.videolan.org/pub/videolan/vlc/latest/win32/axvlc.cab\" width=\"400\" height=\"300\" id=\"vlc\" events=\"True\"> <param name=\"Src\" value=\"suite.mov\"></param> <param name=\"ShowDisplay\" value=\"True\" ></param> <param name=\"AutoLoop\" value=\"no\"></param> <param name=\"AutoPlay\" value=\"no\"></param> <embed type=\"application/x-google-vlc-plugin\" name=\"vlcfirefox\" autoplay=\"no\" loop=\"no\" width=\"99%\" height=\"100%\" target=\"suite.mov\"></embed> </object></div>");
        } else {
            printWriter.println("<p id=\"showmenu\">No Video Recording Available</p>");
        }

        printWriter.println("\t\t<div class=\"chartStyle summary\" style=\"width: 32%;background-color: #3B9C9C;\">\n\t\t\t<b>Summary</b><br/><br/>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>Execution Date</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>" + Utils.getCurrentTime() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Total Test Cases</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + var13 + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Passed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + passedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Failed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + failedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Skipped</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + skippedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t</table> \n" + "\t\t</div>" + "\t\t<div class=\"chartStyle\" style=\"text-align: left;margin-left: 30px;float: left;width: 60%;\">\n" + "\t\t\t<div id=\"chart\" style=\"height:300px;color:black;\"></div>\n" + "\t\t</div>\n" + "\t</div>\n" + " <div>\n");
        printWriter.println("<div style=\"float:left; color: #585858; font-size: 14px;\">\n\t\t<select id=\"tcFilter\" class=\"filter\">\n\t\t\t<option class=\"filterOption\" value=\"all\">All Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"tests\">Test Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"pass\">Passed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"fail\">Failed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"skip\">Skipped Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"config\">Configuration Methods</option>\n\t\t</select>Filter The Methods Based on Selection</div>");
        printWriter.println("<table id=\"tableStyle\" class=\"chartStyle\" style=\"height:50px; float: left\">\n\t\t<tr>\t\t\t<th>Package Name</th>\n\t\t\t<th>Class Name</th>\n\t\t\t<th>Method Type</th>\n\t\t\t<th>Test Case Name</th>\n<th>Iteration</th>\t\t\t<th>Time</th>\n\t\t\t<th style=\"width: 7%\">Status</th>\n\t\t</tr>\n");
        writePassedData(printWriter, passedTests, 1);
        writeFailedData(printWriter, failedTests, 1);
        writeSkippedData(printWriter, skippedTests, 1);
        printWriter.print(" </table>\n </div>\n </td>\n </tr>");*/
    }

    public static void printFooter(PrintWriter printWriter) {
        printWriter.println("\t\t\t<tr id=\"footer\">\n\t\t\t\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t\t\t\tBest Viewed in &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.mozilla.org/en-US/firefox/new/\">Firefox</a> &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.apple.com/in/safari/\">Safari</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.google.com/chrome/\">Chrome</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://windows.microsoft.com/en-IN/internet-explorer/download-ie\">IE 9 & Above</a>&nbsp;\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\tNXG Reporter Version: v1.0.0&nbsp;\n\t\t\t\t\t\t\tReports by: <a href=\"http://seleniumbyneeds.blogspot.in/\">Selenium By Needs</a>\n\t\t\t\t\t</td>\n \t\t\t\t</tr>\n\t\t\t</table>\n\t\t</body>\n</html>");
    }

    private static void writeSkippedData(PrintWriter printWriter, List<ITestResult> skippedTests, int runNumber) {
        String strPass = "skip";
        Iterator var5 = skippedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/skip.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static void writeFailedData(PrintWriter printWriter, List<ITestResult> failedTests, int runNumber) {
        String strPass = "fail";
        Iterator var5 = failedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/fail.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static void writePassedData(PrintWriter printWriter, List<ITestResult> passedTests, int runNumber) {
        String strPass = "pass";
        Iterator var5 = passedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/pass.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static String getExecutionTime(ITestResult testResult) {
        long var1 = testResult.getEndMillis() - testResult.getStartMillis();
        if(var1 > 1000L) {
            var1 /= 1000L;
            return var1 + " Sec";
        } else {
            return var1 + " Milli Sec";
        }
    }

    private static String getIteration(ITestResult testResult) {
        return testResult.getAttribute("iteration").toString();
    }

    private static String getTestCaseName(ITestResult testResult) {
        return testResult.getName();
    }

    public static String getMethodType(ITestResult testResult) {
        ITestNGMethod var1 = testResult.getMethod();
        return var1.isAfterClassConfiguration()?"After Class":(var1.isAfterGroupsConfiguration()?"After Groups":(var1.isAfterMethodConfiguration()?"After Method":(var1.isAfterSuiteConfiguration()?"After Suite":(var1.isAfterTestConfiguration()?"After Test":(var1.isBeforeClassConfiguration()?"Before Class":(var1.isBeforeGroupsConfiguration()?"Before Groups":(var1.isBeforeMethodConfiguration()?"Before Method":(var1.isBeforeSuiteConfiguration()?"Before Suite":(var1.isBeforeTestConfiguration()?"Before Test":(var1.isTest()?"Test Method":"Unknown"))))))))));
    }

    private static String getClassName(ITestResult testResult) {
        return testResult.getTestClass().getRealClass().getSimpleName();
    }

    private static String getTestCaseHTMLPath(ITestResult testResult, int runCount) {
        String reportDir = testResult.getAttribute("relativeReportDir").toString();
        return reportDir + TestDirectory.SEP + getTestCaseName(testResult) + ".html";
    }

    private static String getPackageName(ITestResult testResult) {
        return testResult.getTestClass().getRealClass().getPackage().getName();
    }

    private static String getExecutionTime(long startTime, long endTime) {
        long executionTime = endTime - startTime;
        if(executionTime > 1000L) {
            executionTime /= 1000L;
            return executionTime + " Sec";
        } else {
            return executionTime + " Milli Sec";
        }
    }

    private static void printContentFollowBrowser(PrintWriter printWriter, ArrayList<String> passedBrowserTest, ArrayList<String> failedBrowserTest, ArrayList<String> skippedBrowserTest , List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests, String browserName){
        int passCount = countStatusStepTest(passedBrowserTest,passedTests,browserName);
        int failCount = countStatusStepTest(failedBrowserTest,failedTests,browserName);
        int skipCount = countStatusStepTest(skippedBrowserTest, skippedTests, browserName);
        //int var13 = passedTests.size() + failedTests.size() + skippedTests.size();
        int var13 = passCount + failCount + skipCount;
        String executionTime = getExecutionTimeFollowBrowser(passedBrowserTest,failedBrowserTest,skippedBrowserTest,passedTests,failedTests,skippedTests,browserName);
        printWriter.println("\n\t\t<div class=\"info\" style=\"border-style: none;\" >\n\t\t\tThe following pie chart demonstrates the percentage of Passed, Failed and Skipped Test Cases<br/>\n\t\t\tTime Taken for Executing below Test Cases: <b>" + executionTime + "</b> <br/>\n" + "\t\t\tCurrent Run Number: <b>Run " + 1 + "</b>\n" + "\t\t</div>\n" + "\t\t<div class=\"info\" style=\"border-style: none;\"><br/>" + "\t\t\t<b>Run Description</b>" + "\t\t\t<br/><br/>" + NXGReports.currentRunDescription + "\t\t</div>" + "\t\t<div>\n");
        if(TestDirectory.recordSuiteExecution) {
            printWriter.println("<p id=\"showmenu\">Click Me to Show/Hide the Execution Video</p><div id=\"video\" class=\"video\"><object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://downloads.videolan.org/pub/videolan/vlc/latest/win32/axvlc.cab\" width=\"400\" height=\"300\" id=\"vlc\" events=\"True\"> <param name=\"Src\" value=\"suite.mov\"></param> <param name=\"ShowDisplay\" value=\"True\" ></param> <param name=\"AutoLoop\" value=\"no\"></param> <param name=\"AutoPlay\" value=\"no\"></param> <embed type=\"application/x-google-vlc-plugin\" name=\"vlcfirefox\" autoplay=\"no\" loop=\"no\" width=\"99%\" height=\"100%\" target=\"suite.mov\"></embed> </object></div>");
        } else {
            printWriter.println("<p id=\"showmenu\">No Video Recording Available</p>");
        }

        printWriter.println("\t\t<div class=\"chartStyle summary\" style=\"width: 32%;background-color: #3B9C9C;\">\n\t\t\t<b>Summary</b><br/><br/>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>Execution Date</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>" + Utils.getCurrentTime() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Total Test Cases</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + var13 + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Passed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + passCount + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Failed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + failCount + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Skipped</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + skipCount + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t</table> \n" + "\t\t</div>" + "\t\t<div class=\"chartStyle\" style=\"text-align: left;margin-left: 30px;float: left;width: 60%;\">\n" + "\t\t\t<div id=\"chart" +  browserName +"\" style=\"height:300px;color:black;\"></div>\n" + "\t\t</div>\n" + "\t</div>\n" + " <div>\n");
        printWriter.println("<div style=\"float:left; color: #585858; font-size: 14px;\">\n\t\t<select id=\"tcFilter" + browserName +"\" class=\"filter\">\n\t\t\t<option class=\"filterOption\" value=\"all\">All Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"tests\">Test Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"pass\">Passed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"fail\">Failed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"skip\">Skipped Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"config\">Configuration Methods</option>\n\t\t</select>Filter The Methods Based on Selection</div>");
        printWriter.println("<table id=\"tableStyle\" class=\"chartStyle\" style=\"height:50px; float: left\">\n\t\t<tr>\t\t\t<th>Package Name</th>\n\t\t\t<th>Class Name</th>\n\t\t\t<th>Method Type</th>\n\t\t\t<th>Test Case Name</th>\n<th>Iteration</th>\t\t\t<th>Time</th>\n\t\t\t<th style=\"width: 7%\">Status</th>\n\t\t</tr>\n");
        writePassedDataFollowBrowser(printWriter, passedTests, passedBrowserTest, browserName, 1);
        writeFailedDataFollowBrowser(printWriter, failedTests, failedBrowserTest, browserName, 1);
        writeSkippedDataFollowBrowser(printWriter, skippedTests, skippedBrowserTest, browserName, 1);
        printWriter.print("</table>");
    }

    private static int countStatusStepTest(ArrayList<String> browserTest , List<ITestResult> testResult, String browserName){
        int count =0;
        for(int i=0; i<testResult.size();i++){
            if(testResult.get(i).getAttribute(Platform.BROWSER_NAME_PROP).toString().toUpperCase().equals(browserName)){
                count++;
            }
        }
        return count;
    }

    private static void writeSkippedDataFollowBrowser(PrintWriter printWriter, List<ITestResult> skippedTests, ArrayList<String> skippedBrowserTest, String browserName, int runNumber) {
        String strPass = "skip"+ browserName;
        Iterator var5 = skippedTests.iterator();
        int i = 0;
        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult) var5.next();
            if(testResult.getAttribute(Platform.BROWSER_NAME_PROP).toString().toUpperCase().equals(browserName)) {
                printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/skip.png\"></td>\n" + "\t</tr>\n");
                if (!testResult.getMethod().isTest()) {
                    strPass = "config" + browserName;
                }
            }
            i++;
        }

    }

    private static void writeFailedDataFollowBrowser(PrintWriter printWriter, List<ITestResult> failedTests, ArrayList<String> failedBrowserTest, String browserName, int runNumber) {
        String strPass = "fail" + browserName;
        Iterator var5 = failedTests.iterator();
        int i = 0;
        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult) var5.next();
            if(testResult.getAttribute(Platform.BROWSER_NAME_PROP).toString().toUpperCase().equals(browserName)) {
                printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/fail.png\"></td>\n" + "\t</tr>\n");
                if (!testResult.getMethod().isTest()) {
                    strPass = "config" + browserName;
                }
            }
            i++;
        }

    }

    private static void writePassedDataFollowBrowser(PrintWriter printWriter, List<ITestResult> passedTests,ArrayList<String> passBrowserTest, String browserName , int runNumber) {
        String strPass = "pass" + browserName;
        Iterator var5 = passedTests.iterator();
        int i=0;
        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult) var5.next();
            if(testResult.getAttribute(Platform.BROWSER_NAME_PROP).toString().toUpperCase().equals(browserName)) {
                printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/pass.png\"></td>\n" + "\t</tr>\n");
                if (!testResult.getMethod().isTest()) {
                    strPass = "config" + browserName;
                }
            }
            i++;
        }

    }

    private static long getExecutionTimeFollowBrowser(List<ITestResult> resultTests,ArrayList<String> resultBrowserTest, String browserName) {
        long var1 = 0L;
        Iterator var5 = resultTests.iterator();
        int i=0;
        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult) var5.next();
            if(testResult.getAttribute(Platform.BROWSER_NAME_PROP).toString().toUpperCase().equals(browserName)) {
                var1+= testResult.getEndMillis() - testResult.getStartMillis();
            }
            i++;
        }
        return var1;
    }
    private static String getExecutionTimeFollowBrowser(ArrayList<String> passedBrowserTest, ArrayList<String> failedBrowserTest, ArrayList<String> skippedBrowserTest ,
                                                        List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests,
                                                        String browserName) {
        long var1 = 0L;
        var1+= getExecutionTimeFollowBrowser(passedTests,passedBrowserTest,browserName);
        var1+= getExecutionTimeFollowBrowser(failedTests,failedBrowserTest,browserName);
        var1+= getExecutionTimeFollowBrowser(skippedTests,skippedBrowserTest,browserName);

        if(var1 > 1000L) {
            var1 /= 1000L;
            return var1 + " Sec";
        } else {
            return var1 + " Milli Sec";
        }
    }
}
