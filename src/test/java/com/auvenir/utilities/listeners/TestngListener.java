/***********************************************************************
 * @author 			:		LAKSHMI BS
 * @description		: 		Implemented ITestListener interface and overrided methods as per requirement. It listenes to all the events performed by Testng and keep track of it.
 */
package com.auvenir.utilities.listeners;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Parameters({"server"})
public class TestngListener implements ITestListener {
	public static File sHtmlReports;
	public static File sTestngReports;
	public static File sPdfReports;
	public static File sImageReports;
	public static String sdateTime;
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	public static int iTotalExecuted=0;
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	public static ArrayList sDescription= new ArrayList<String>();
	public static File pdfReports;
	public static PdfGenerater pdf;
	
	public TestngListener() throws IOException 
	{
		Date date = new Date();
	    SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
	    sdateTime = sdtf.format(date);
		sHtmlReports=new File(GenericService.sDirPath+"//Reports//HTMLReports");
		sTestngReports= new File(GenericService.sDirPath+"//Reports//TestNGReports");
		sPdfReports = new File(GenericService.sDirPath+"//Reports//PDFReports");
		sImageReports = new File(GenericService.sDirPath+"//Reports//ImageReports");
		if(!sHtmlReports.exists())
		{
			FileUtils.forceMkdir(sHtmlReports);
		}
		if(!sTestngReports.exists())
		{
			FileUtils.forceMkdir(sTestngReports);	
		}
		if(!sPdfReports.exists())
		{
			FileUtils.forceMkdir(sPdfReports);	
		}

		if(!sImageReports.exists())
		{
			FileUtils.forceMkdir(sImageReports);
		}

		/*System.setProperty("KIRWA.reporter.config", "KIRWA.properties");*/
		System.setProperty("HTMLREPORT.reporter.config", "KIRWA.properties");

	}

	public void onTestStart(ITestResult result) 
	{
		//GenericService.setConfigValue(GenericService.sConfigFile, "DATE", sdateTime);
	}

	public void onTestSuccess(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iPassCount = iPassCount+1;
		sTestName.add(result.getName().toString());
		if(null != result.getAttribute("passedButFailed") && result.getAttribute("passedButFailed").equals("passedButFailed")) {
			sStatus.add("Failed");
		}else {
			sStatus.add("Passed");
		}
	}

	public void onTestFailure(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iFailCount = iFailCount+1;
		sTestName.add(result.getName().toString());
		sStatus.add("Failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iSkippedCount = iSkippedCount+1;
		sTestName.add(result.getName().toString());
		sStatus.add("Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}

	public void onStart(ITestContext context) 
	{
	}

	public void onFinish(ITestContext context) 
	{
		 File testOuput = new File(GenericService.sDirPath+"\\tests-output");
		 String sTestngReports= GenericService.sDirPath+"\\..\\Reports\\TestNGReports\\TestNG_"+sdateTime;
		 pdfReports = new File(sPdfReports+"\\PDFReports"+sdateTime+".pdf");
		 iPassCount=context.getPassedTests().size();
	     iFailCount=context.getFailedTests().size(); 
	     iSkippedCount=context.getSkippedTests().size(); 
	     iTotalExecuted = iPassCount+iFailCount+iSkippedCount;
	     //GenericService.getPieChart(iPassCount,iFailCount,iSkippedCount);
		//GenericService.getBarChart(iPassCount,iFailCount,iSkippedCount);
		 /*GenericService.getPieChartFollowBrowser(sTestName,sStatus);
		 GenericService.getBarChartFollowBrowser(sTestName,sStatus);*/
         pdf = new PdfGenerater();

     	try
        {
     		FileUtils.copyDirectoryToDirectory(testOuput,new File(sTestngReports));
     		//GenericService.sendMail(iPassCount, iFailCount, iSkippedCount, iTotalExecuted, pdfReports);
     		System.out.println("testoutput is moved");
        }
        catch(Exception e)
        {
        	System.out.println("testoutput is not moved");
        }
	}
}
