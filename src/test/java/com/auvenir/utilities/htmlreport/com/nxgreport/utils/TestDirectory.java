package com.auvenir.utilities.htmlreport.com.nxgreport.utils;

import com.auvenir.utilities.htmlreport.com.nxgreport.ReportLabels;
import com.auvenir.utilities.htmlreport.com.nxgreport.exceptions.KIRWAReportException;
import com.auvenir.utilities.htmlreport.com.nxgreport.writer.ResourceFilesWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class TestDirectory {
    public static String REPORTSDIR;
    public static Object REPORTSDIRNAME = "KIRWA_Reports";
    public static final String CURRENTDIR = System.getProperty("user.dir");
    public static String RESOURCESDIR;
    public static String JSDIRName;
    public static String CSSDIRName;
    public static String IMGDIRName;
    public static String JSDIR;
    public static String CSSDIR;
    public static String IMGDIR;
    public static String RESOURCESDIRName;
    public static String RUNDIRName;
    public static String RUNDIR;
    public static String SCREENSHOT_DIRName = "captures";
    public static int RUNName;
    public static boolean continueExecutionAfterStepFailed = true;
    public static boolean takeScreenshot = true;
    public static boolean generateExcelReports = false;
    public static boolean recordSuiteExecution = false;
    public static boolean recordTestExecution = false;
    public static String testSuiteDescription = "";
    public static String runDisplayFormat = "ddMMMyy-hh:mm";
    public static final String SEP = "/";
    public static final String runStamp = (new SimpleDateFormat("dd_MM_yy_hh_mm_ss_SS")).format(new Date());

    static {
        REPORTSDIR = CURRENTDIR + SEP + REPORTSDIRNAME;
        RESOURCESDIRName = "Resources";
        RESOURCESDIR = REPORTSDIR + SEP + RESOURCESDIRName;
        CSSDIRName = "Css";
        CSSDIR = RESOURCESDIR + SEP + CSSDIRName;
        IMGDIRName = "Img";
        IMGDIR = RESOURCESDIR + SEP + IMGDIRName;
        JSDIRName = "JS";
        JSDIR = RESOURCESDIR + SEP + JSDIRName;
        RUNDIRName = "Run_" + runStamp;
        RUNDIR = REPORTSDIR + SEP + RUNDIRName;
        SCREENSHOT_DIRName = "captures";
    }

    public TestDirectory() {
    }

    public static void init(String runStamp1) throws KIRWAReportException {
        initProperties();
        verifyRequiredFiles();
    }

    private static void verifyRequiredFiles() {
        mkDirs(REPORTSDIR);
        if(!exists(RESOURCESDIR)) {
            mkDirs(RESOURCESDIR);
            mkDirs(CSSDIR);
            mkDirs(JSDIR);
            mkDirs(IMGDIR);
            ResourceFilesWriter.writeCSS();
            ResourceFilesWriter.writeIMG();
            ResourceFilesWriter.writeJS();
        }

        mkDirs(RUNDIR);
    }

    private static void initProperties() throws KIRWAReportException {
        if(getCustomProperties() != null) {
            Properties customProperties = new Properties();

            try {
                customProperties.load(new FileReader(getCustomProperties()));
                String reportDir = customProperties.getProperty("KIRWA.reports.dir").trim();
                String proj_headerText = customProperties.getProperty("KIRWA.proj.header").trim();
                String proj_logo = customProperties.getProperty("KIRWA.proj.logo").trim();
                String proj_description = customProperties.getProperty("KIRWA.proj.description").trim();
                String generateSuiteVideo = customProperties.getProperty("KIRWA.reports.recordsuitevideo").trim();
                String generateTestVideo = customProperties.getProperty("KIRWA.reports.recordtestvideo").trim();

                try {
                    if(proj_headerText != null && proj_headerText.length() > 0) {
                        ReportLabels.HEADER_TEXT.setLabel(proj_headerText);
                    }

                    if(proj_logo != null && proj_logo.length() > 0) {
                        ReportLabels.PROJLOGO.setLabel(proj_logo);
                    }

                    if(reportDir != null && reportDir.length() > 0) {
                        REPORTSDIR = reportDir;
                        REPORTSDIRNAME = (new File(REPORTSDIR)).getName();
                        RESOURCESDIRName = "Resources";
                        RESOURCESDIR = REPORTSDIR + SEP + RESOURCESDIRName;
                        JSDIRName = "Js";
                        CSSDIRName = "Css";
                        IMGDIRName = "Img";
                        JSDIR = RESOURCESDIR + SEP + JSDIRName;
                        CSSDIR = RESOURCESDIR + SEP + CSSDIRName;
                        IMGDIR = RESOURCESDIR + SEP + IMGDIRName;
                        RUNDIRName = "Run_" + runStamp;
                        RUNDIR = REPORTSDIR + SEP + RUNDIRName;
                        SCREENSHOT_DIRName = "captures";
                    }

                    if(generateSuiteVideo != null && generateSuiteVideo.length() > 0) {
                        recordSuiteExecution = Boolean.parseBoolean(generateSuiteVideo);
                    }

                    if(generateTestVideo != null && generateTestVideo.length() > 0) {
                        recordTestExecution = Boolean.parseBoolean(generateTestVideo);
                    }

                    if(proj_description != null && proj_description.length() > 0) {
                        testSuiteDescription = proj_description;
                    }
                } catch (Exception var8) {
                    throw new KIRWAReportException(var8.toString());
                }
            } catch (FileNotFoundException var9) {
                throw new KIRWAReportException("The Path for the Custom Properties file could not be found");
            } catch (IOException var10) {
                throw new KIRWAReportException("Problem Occured while reading the ATU Reporter Config File");
            }
        }

    }

    private static String getCustomProperties() {
        return System.getProperty("HTMLREPORT.reporter.config");
    }

    public static void mkDirs(String dirName) {
        File var1 = new File(dirName);
        if(!var1.exists()) {
            var1.mkdirs();
        }

    }

    private static boolean exists(String fileName) {
        File var1 = new File(fileName);
        return var1.exists();
    }
}
