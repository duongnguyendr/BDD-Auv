package com.auvenir.ui.bdd.runner;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.Configuration;
//import org.testng.internal.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doai.tran on 29/08/17.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport(){
        try{
            System.out.println("START");
            File reportOutputDirectory = new File("target");
            List<String> jsonFiles = new ArrayList<>();
            jsonFiles.add("./target/cucumber-report.json");
            //jsonFiles.add("cucumber-report-2.json");

            String buildNumber = "1";
            String projectName = "cucumberProject";
            boolean runWithJenkins = false;
            boolean parallelTesting = false;

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
            configuration.addClassifications("Platform", "Windows");
            configuration.addClassifications("Browser", "Firefox");
            configuration.addClassifications("Branch", "release/1.0");

            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            Reportable result = reportBuilder.generateReports();
            System.out.println("DONE REPORT");
// and here validate 'result' to decide what to do
// if report has failed features, undefined steps etc
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

