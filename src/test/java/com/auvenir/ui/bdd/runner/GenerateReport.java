package com.auvenir.ui.bdd.runner;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.Configuration;
//import org.testng.internal.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by doai.tran on 29/08/17.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport(){
        try{
            System.out.println("START");

            File reportOutputDirectory = new File("Reports/Report_"+GetTimeStampValue());
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("./target/cucumber-report.json");
            //jsonFiles.add("cucumber-report-2.json");

            String buildNumber = "1";
            String projectName = "BDD Auvenir Automation Testing";
            boolean runWithJenkins = false;
            boolean parallelTesting = false;

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Chrome");
            configuration.addClassifications("Branch", "release/1.0");
            configuration.addClassifications("Created by","Doai Tran");

            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            Reportable result = reportBuilder.generateReports();
            System.out.println("DONE REPORT");
    // and here validate 'result' to decide what to do
    // if report has failed features, undefined steps etc
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  static String GetTimeStampValue()throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":","");
        systime = systime.replace("-","");
        return systime;
    }
}

