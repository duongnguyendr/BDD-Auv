package com.auvenir.ui.bdd.common.listeners;

/**
 * Created by doai.tran on 8/29/2017.
 */
import com.auvenir.ui.bdd.common.GeneratePDF;
import com.auvenir.ui.bdd.common.GenerateReport;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
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
        GenerateReport.GenerateMasterthoughtReport();
        // Generate PDF File
        pdf.toExecute();
        //Send Email

        System.out.println("***** TestNG has finished, the execution *****");
    }
    public static File sHtmlReports;
    public static File sPdfReports;
    public static GeneratePDF pdf;

    public void initReportsFolder() throws IOException {
        try{
            System.out.println("***** Start initialize Report folders *****");
        sHtmlReports = new File(GenericService.sDirPath + "//Reports//HTMLReports");
        sPdfReports = new File(GenericService.sDirPath + "//Reports//PDFReports");
        if (!sHtmlReports.exists()) {
            FileUtils.forceMkdir(sHtmlReports);
        }
        if (!sPdfReports.exists()) {
            FileUtils.forceMkdir(sPdfReports);
        }
        }catch(Exception e){
            System.out.println("***** Unable to create reports folders: "+e.getMessage());
        }
    }
}
