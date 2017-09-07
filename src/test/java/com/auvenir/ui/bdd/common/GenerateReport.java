package com.auvenir.ui.bdd.common;
import net.masterthought.cucumber.*;
import net.masterthought.cucumber.json.Feature;
//import org.testng.internal.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auvenir.ui.bdd.common.Generic.sExecuteTime;

/**
 * Created by doai.tran on 29/08/17.
 */
public class GenerateReport {

    private static Configuration createConfiguration(File reportOutputDirectory, String projectName){
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        String buildNumber = "1";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        // optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);

        // addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");
        configuration.addClassifications("Created by","Doai Tran");

        return configuration;
    }

    public static Reportable GenerateMasterthoughtReport(String sExecuteTime){
        Reportable result = null;
        try{
            System.out.println("START");
            File reportOutputDirectory = new File("Reports/HTMLReports/Report_"+sExecuteTime);
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("./target/cucumber-report.json");
            //jsonFiles.add("cucumber-report-2.json");


            String projectName = "BDD Auvenir Automation Testing";


            Configuration configuration = createConfiguration(reportOutputDirectory, projectName);
    /*// optional configuration
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);
    // addidtional metadata presented on main page
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Chrome");
            configuration.addClassifications("Branch", "release/1.0");
            configuration.addClassifications("Created by","Doai Tran");
*/
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            result = reportBuilder.generateReports();
            System.out.println("DONE REPORT");
    // and here validate 'result' to decide what to do
    // if report has failed features, undefined steps etc
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static ReportResult createReportDetail(String sExecuteTime){
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("./target/cucumber-report.json");
        File reportOutputDirectory = new File("Reports/HTMLReports/Report_"+sExecuteTime);
        String projectName = "BDD Auvenir Automation Testing";
        Configuration configuration = createConfiguration(reportOutputDirectory, projectName);
        ReportParser reportParser = new ReportParser(configuration);
        List<Feature> features = reportParser.parseJsonFiles(jsonFiles);
        ReportResult reportResult = new ReportResult(features, configuration.getSortingMethod());
        return reportResult;
    }

    /*public  static String GetTimeStampValue()throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":","");
        systime = systime.replace("-","");
        return systime;
    }*/
}

