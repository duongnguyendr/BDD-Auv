package com.auvenir.ui.bdd.common.listeners;

/**
 * Created by doai.tran on 8/29/2017.
 */
import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.reportLB.GeneratePDF;
import com.auvenir.ui.bdd.common.reportLB.GenerateReport;
import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.common.reportLB.SendReportMail;
import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.Reportable;
import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;

import java.io.File;
import java.io.IOException;

public class TestNGExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("***** TestNG is staring the execution *****");
        try {
            initReportsFolder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onExecutionFinish() {
        System.out.println("***** Generating the Master thought Report *****");
        // Generate HTML Report
        String timeStamp = Generic.GetTimeStampValue();
        Reportable result = GenerateReport.GenerateMasterthoughtReport(timeStamp);
        File sDateReports = new File(Generic.sDirPath+"//Reports//ImageReports//" + timeStamp);
        try {
            if (!sDateReports.exists()) {
                FileUtils.forceMkdir(sDateReports);
            }
            sPdfReports = new File(sPdfReports+"\\PDFReports_"+ timeStamp +".pdf");
            // Create Bar char
            Generic.getFeaturesChart(result.getPassedFeatures(), result.getFailedFeatures(),0, timeStamp);
            // Create Pie char
            Generic.getScenariosChart(result.getPassedScenarios(), result.getFailedScenarios(),0, timeStamp);
            // Create report result
            ReportResult reportResult= GenerateReport.createReportDetail(timeStamp);
            // Generate PDF File
            pdf.toExecute(sPdfReports,timeStamp, reportResult);
            //Send mail
            if((null != BaseInit.sToEmail) || (null != BaseInit.sCcEmail)){
                SendReportMail.sendMail(sPdfReports,timeStamp, reportResult);
            }


        }catch (Exception ex){

        }

        //Send Email

        System.out.println("***** TestNG has finished, the execution *****");
    }
    public static File sHtmlReports;
    public static File sPdfReports;
    public static GeneratePDF pdf;

    public void initReportsFolder() throws IOException {
        try{
            System.out.println("***** Start initialize Report folders *****");
        sHtmlReports = new File(Generic.sDirPath + "//Reports//HTMLReports");
        sPdfReports = new File(Generic.sDirPath + "//Reports//PDFReports");
        if (!sHtmlReports.exists()) {
            FileUtils.forceMkdir(sHtmlReports);
        }
        if (!sPdfReports.exists()) {
            FileUtils.forceMkdir(sPdfReports);
        }
        }catch(Exception e){
            System.out.println("***** Unable to create reportLB folders: "+e.getMessage());
        }
    }
}
