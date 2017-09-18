package com.auvenir.ui.bdd.common;

import com.auvenir.ui.bdd.base.BaseInit;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by doai.tran on 8/31/2017.
 */
public class Generic extends BaseInit{
    private static Logger logger = Logger.getLogger(Generic.class.getSimpleName());
    private static BaseInit base;
    public Generic(BaseInit base) {
        this.base = base;
    }
    public static String sDirPath = System.getProperty("user.dir");
    public static String sUserPath = System.getProperty("user.home");
    public static String sBrowser = null;
    public static String sVersion = null;
    public static String sOS = null;
    public final static String PROPERTIES_FILE = sDirPath + "\\TestBDD.properties";
    public static String sTestDataFile = sDirPath + "\\testData.xlsx";
    public static String sExecuteTime = null;
    public static String sExecutionDate = null;
    public static ArrayList sBrowserTestNameList = new ArrayList<String>();
    public static int iPassCount = 0;
    public static int iFailCount = 0;
    public static int iSkippedCount = 0;
    public static String sConfigFile = null;
    public static String sBrowserData = null;
    public final static String MONGODBPROPERTIESFILE = sDirPath + "\\src\\test\\resources\\properties\\MongoDB.properties";
    public static final String FOLDER_DOWNLOAD  = "\\src\\test\\resources\\testData\\download\\";


    /**
     * Description: Method to read the configuration from Config file.
     * @param sFile FILE Destination
     * @param sKey KeyWord to read value.
     * @return
     */
    public static String getConfigValue(String sFile, String sKey) {
        logger.info("**** Read Configuration file ****");
        Properties prop = new Properties();
        String sValue = null;
        try {
            InputStream input = new FileInputStream(sFile);
            prop.load(input);
            sValue = prop.getProperty(sKey);
            logger.info("**** Value from Properties file of Parameter: "+sKey+": "+sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info("**** Can not find the properties file ****"+sValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sValue;
    }

    /**
     * Description: Method to set the configuration from Config file.
     * @param sFile
     * @param sKey
     * @param sValue
     */
    public static void setConfigValue(String sFile, String sKey, String sValue) {
        logger.info("**** Read Configuration file ****");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(sFile));
            prop.load(fis);
            fis.close();
            FileOutputStream fos = new FileOutputStream(new File(sFile));
            prop.setProperty(sKey, sValue);
            prop.store(fos, "Updating folder path");
            fos.close();
            logger.info("**** Value from Properties file of Parameter: "+sKey+"be set: "+sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GetTimeStampValue(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss_SSS");
        String systime = sdf.format(new Date());
        systime = systime.replace(":","");
        systime = systime.replace("-","");
        return systime;
    }
    public static void getFeaturesChart(int iPassCount, int iFailCount, int iSkippedCount, String timeStamp){
        getPieChart(iPassCount,  iFailCount, iSkippedCount, timeStamp, "Features");
    }

    public static void getScenariosChart(int iPassCount, int iFailCount, int iSkippedCount, String timeStamp){
        getPieChart(iPassCount,  iFailCount, iSkippedCount, timeStamp, "Scenarios");
    }
    private static void getPieChart(int iPassCount, int iFailCount, int iSkippedCount, String timeStamp, String nameChart) {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("FAIL", new Integer(iFailCount));
        //pieDataset.setValue("SKIP", new Integer(iSkippedCount));
        pieDataset.setValue("PASS", new Integer(iPassCount));

        JFreeChart piechart = ChartFactory.createPieChart(nameChart, pieDataset, true, true, false);
        PiePlot plot = (PiePlot) piechart.getPlot();

        plot.setSectionPaint("FAIL", Color.RED);
        // plot.setSectionPaint("SKIP", Color.ORANGE);
        plot.setSectionPaint("PASS", new Color(192 * 85 + 192 * 104 + 192 * 47));
        plot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));
        plot.setExplodePercent("FAIL", 0.05);
        plot.setSimpleLabels(true);
        plot.setSectionOutlinesVisible(true);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        try {
            ChartUtilities
                    .saveChartAsJPEG(new File(System.getProperty("user.dir")
                            + "\\Reports\\ImageReports\\" + timeStamp + "\\" + nameChart + "Chart" + "_" + timeStamp + ".png"), piechart, 400, 400);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getBarChart(int iPassCount, int iFailCount, int iSkippedCount, String timeStamp) {
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";
        final String category1 = "Status";

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(iPassCount, series1, "Status");
        dataSet.addValue(iFailCount, series2, "Status");
        dataSet.addValue(iSkippedCount, series3, "Status");

        JFreeChart chart =
                ChartFactory.createBarChart("Bar Graph", "Execution Status", "Testcases", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barplot = chart.getCategoryPlot();
        // barplot.setBackgroundPaint(paint);
        barplot.setBackgroundPaint(Color.white);
        barplot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));

        barplot.setDomainGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) barplot.getRangeAxis();
        rangeAxis.setRange(0.0, 70.0);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        final BarRenderer renderer = (BarRenderer) barplot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.20);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(192 * 85 + 192 * 104 + 192 * 47), 0.0f, 0.0f, Color.lightGray);
        final GradientPaint gp1 = new GradientPaint(

                0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);

        final GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.orange, 0.0f, 0.0f, Color.lightGray);
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        try {
            ChartUtilities
                    .saveChartAsJPEG(new File(System.getProperty("user.dir")
                            + "\\Reports\\ImageReports\\" + timeStamp + "\\BarChart" + "_" + timeStamp + ".png"), chart, 400, 400);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String[] toReadExcelData(String sTestCaseID) {
        String sData[] = null;
        try {

            FileInputStream fis = new FileInputStream(sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet("testData");
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    for (int j = 0; j < iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }

    private static String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generate radom password
     *
     * @param lenght
     * @return
     */
    public static String genPassword(int lenght, boolean isContainsUpperCase, boolean isContainsLowerCase, boolean isContainsDigit) {
        Random r = new Random();
        while (true) {
            char[] password = new char[lenght];
            boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
            for (int i = 0; i < password.length; i++) {
                char ch = symbols.charAt(r.nextInt(symbols.length()));
                if (isContainsUpperCase && Character.isUpperCase(ch))
                    hasUpper = true;
                else if (isContainsLowerCase && Character.isLowerCase(ch))
                    hasLower = true;
                else if (isContainsDigit && Character.isDigit(ch))
                    hasDigit = true;
                password[i] = ch;
            }
            if (hasUpper && hasLower && hasDigit) {
                return new String(password);
            }
        }
    }

    private static String symbolsResetPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

    /**
     * Generate radom password
     *
     * @param lenght
     * @return
     */
    public static String genResetPassword(int lenght, boolean isContainsUpperCase, boolean isContainsLowerCase, boolean isContainsDigit,
                                          boolean isContainsSpecialCharacter) {
        Random r = new Random();
        while (true) {
            char[] password = new char[lenght];
            boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
            for (int i = 0; i < password.length; i++) {
                char ch = symbolsResetPassword.charAt(r.nextInt(symbolsResetPassword.length()));
                if (Character.isUpperCase(ch))
                    hasUpper = true;
                else if (Character.isLowerCase(ch))
                    hasLower = true;
                else if (Character.isDigit(ch))
                    hasDigit = true;
                else
                    hasSpecial = true;
                password[i] = ch;
            }
            if ((hasUpper == isContainsUpperCase) && (hasLower == isContainsLowerCase) && (hasDigit == isContainsDigit) && (hasSpecial == isContainsSpecialCharacter)) {
                return new String(password);
            }
        }
    }

    /**
     * Parse Rgb to color to hex
     *
     * @param rgb
     * @return
     */
    public static String parseRgbTohex(String rgb) {
        String value = null;
        try {
            int indexOpen = rgb.indexOf("(");
            rgb = rgb.substring(indexOpen + 1, rgb.length() - 1);

            String[] temp = rgb.split(",");

            int r = Integer.parseInt(temp[0].trim());
            int g = Integer.parseInt(temp[1].trim());
            int b = Integer.parseInt(temp[2].trim());


            value = String.format("#%02x%02x%02x", r, g, b);
        } catch (Exception e) {
        }
        return value;
    }

    /**
     * Validate email address
     *
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(String email) {
        String ePattern =
                "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @return
     */
    public static String readExcelData(String fileName, String sheetName, int numberColumn, int numberRow) {
        String cellValue = null;
        try {
            // Read the spreadsheet
            FileInputStream fis = new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            cellValue = String.valueOf(sheet.getRow(numberRow).getCell(numberColumn).getStringCellValue());
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellValue;
    }

    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @param data
     */
    public static void updateExcelData(String fileName, String sheetName, int numberColumn, int numberRow, String data) {
        try {
            //Read the spreadsheet that needs to be updated
            FileInputStream fis = new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            sheet.getRow(numberRow).getCell(numberColumn).setCellValue(data);

            //write this workbook in excel file.
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get browser list not duplicate
     *
     * @return browser list
     */
    private static java.util.List<String> getBrowserList() {
        java.util.List<String> result = new ArrayList<String>();
        int totalRow = sBrowserTestNameList.size();
        for (int i = 0; i < totalRow; i++) {
            if (!result.contains(sBrowserTestNameList.get(i).toString())) {
                result.add(sBrowserTestNameList.get(i).toString());
            }
        }
        return result;
    }

    /**
     * Count total test name follow status
     *
     * @param sTestNames   : test name list
     * @param sBrowserList : browser list
     * @param sBrowser     : browser need check
     * @param sStatus      : status test name list
     * @param statusTest   : status need check
     * @return 0 | >0
     */
    private static int countTotalTestNameStatusFollowBrowser(ArrayList sTestNames, ArrayList sBrowserList, String sBrowser, ArrayList sStatus,
                                                             String statusTest) {
        int count = 0;
        if ((sBrowserList.size() != sTestNames.size()) || (sStatus.size() != sTestNames.size())) {
            return count;
        }

        for (int i = 0; i < sTestNames.size(); i++) {
            if (sBrowserList.get(i).equals(sBrowser) && sStatus.get(i).equals(statusTest)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get pie chart follow browser list
     * Author : TanPham 01/06/2017
     *
     * @param sTestNames : test name list
     * @param sStatus    : status test name list
     */
    public static void getPieChartFollowBrowser(ArrayList sTestNames, ArrayList sStatus, String timeStamp) {
        java.util.List<String> browserList = getBrowserList();
        int totalBrowser = browserList.size();
        for (int i = 0; i < totalBrowser; i++) {

            iPassCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Passed");

            iFailCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Failed");

            iSkippedCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Skipped");

            String browserName = browserList.get(i).substring(0, browserList.get(i).length() - 1);
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            pieDataset.setValue("FAIL", new Integer(iFailCount));
            pieDataset.setValue("SKIP", new Integer(iSkippedCount));
            pieDataset.setValue("PASS", new Integer(iPassCount));

            JFreeChart piechart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, false);
            PiePlot plot = (PiePlot) piechart.getPlot();

            plot.setSectionPaint("FAIL", Color.RED);
            plot.setSectionPaint("SKIP", Color.ORANGE);
            plot.setSectionPaint("PASS", new Color(192 * 85 + 192 * 104 + 192 * 47));
            plot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));
            plot.setExplodePercent("FAIL", 0.05);
            plot.setSimpleLabels(true);
            plot.setSectionOutlinesVisible(true);

            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            plot.setLabelGenerator(gen);
            plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
            try {
                /*ChartUtilities.saveChartAsJPEG(
                        new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChart"+ browserName + "_" + timeStamp +".png"), piechart,
                        400, 400);*/
                ChartUtilities.saveChartAsJPEG(new File(System.getProperty(
                        "user.dir") + "\\Reports\\ImageReports\\" + timeStamp + "\\PieChart" + browserName + "_" + timeStamp + ".png"), piechart, 400,
                        400);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Get bar chart follow browser list
     * Author : TanPham 01/06/2017
     *
     * @param sTestNames : test name list
     * @param sStatus    : status test name list
     */
    public static void getBarChartFollowBrowser(ArrayList sTestNames, ArrayList sStatus, String timeStamp) {
        java.util.List<String> browserList = getBrowserList();
        int totalBrowser = browserList.size();
        for (int i = 0; i < totalBrowser; i++) {
            final String series1 = "First";
            final String series2 = "Second";
            final String series3 = "Third";
            final String category1 = "Status";

            iPassCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Passed");

            iFailCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Failed");

            iSkippedCount = countTotalTestNameStatusFollowBrowser(sTestNames, sBrowserTestNameList, browserList.get(i), sStatus, "Skipped");

            String browserName = browserList.get(i).substring(0, browserList.get(i).length() - 1);

            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
            dataSet.addValue(iPassCount, series1, "Status");
            dataSet.addValue(iFailCount, series2, "Status");
            dataSet.addValue(iSkippedCount, series3, "Status");

            JFreeChart chart =
                    ChartFactory.createBarChart("Bar Graph", "Execution Status", "Testcases", dataSet, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot barplot = chart.getCategoryPlot();
            // barplot.setBackgroundPaint(paint);
            barplot.setBackgroundPaint(Color.white);
            barplot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));

            barplot.setDomainGridlinePaint(Color.white);

            NumberAxis rangeAxis = (NumberAxis) barplot.getRangeAxis();
            rangeAxis.setRange(0.0, 70.0);
            rangeAxis.setTickUnit(new NumberTickUnit(10));
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            rangeAxis.setAutoRangeIncludesZero(true);

            final BarRenderer renderer = (BarRenderer) barplot.getRenderer();
            renderer.setDrawBarOutline(false);
            renderer.setMaximumBarWidth(0.20);

            // set up gradient paints for series...
            final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(192 * 85 + 192 * 104 + 192 * 47), 0.0f, 0.0f, Color.lightGray);
            final GradientPaint gp1 = new GradientPaint(

                    0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);

            final GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.orange, 0.0f, 0.0f, Color.lightGray);
            renderer.setSeriesPaint(0, gp0);
            renderer.setSeriesPaint(1, gp1);
            renderer.setSeriesPaint(2, gp2);

            try {
                /*ChartUtilities.saveChartAsJPEG(
                        new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\BarChart"+ browserName + "_" + timeStamp +".png"), chart,
                        400, 400);*/
                ChartUtilities.saveChartAsJPEG(new File(System.getProperty(
                        "user.dir") + "\\Reports\\ImageReports\\" + timeStamp + "\\BarChart" + browserName + "_" + timeStamp + ".png"), chart, 400,
                        400);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * huyhuynh 01/06/2017
     * get all data on given sheet into 2-dimension array
     *
     * @param sheetName sheet which we want to get data
     */
    public static String[][] readExcelSheetData(String sheetName) {
        String data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(Generic.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            //System.out.println("sheetName = " + sheetName);
            int rowCount = sheet.getLastRowNum();
            data = new String[rowCount][sheet.getRow(0).getLastCellNum()];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    data[i - 1][j] = row.getCell(j).getStringCellValue();
                    //System.out.print(row.getCell(j).getStringCellValue() + "/");
                }
                //System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /* ===================================================================
     * @author: LAKSHMI BS Description: To read tests data from excel sheet
     * Edited by Doai.Tran
     =================================================================== */
    public static String[] toReadExcelData(String sTestCaseID, String SheetName) {
        String sData[] = null;
        try {
            FileInputStream fis = new FileInputStream(Generic.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);

            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    System.out.println("Row: " + i);
                    System.out.println("The number of Columns:" + iCellNum);
                    for (int j = 1; j <= iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(sData[j]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }

    public static String getTestDataFromExcelNoBrowserPrefix(String SheetName, String rowName, String columnName) {
        String userData = null;
        try {
            String userDataExcel = null;
            FileInputStream fis = new FileInputStream(Generic.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);
            //            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0) != null) {
                    if (sht.getRow(i).getCell(0).toString().equals(rowName)) {
                        int iCellNum = sht.getRow(i).getLastCellNum();
                        /*System.out.println("Row: " + i);
                        System.out.println("The number of Columns:" + iCellNum);
                        System.out.println(columnName);*/
                        for (int j = 1; j <= iCellNum; j++) {
                            if (sht.getRow(0).getCell(j) != null) {
                                if ((sht.getRow(0).getCell(j).toString()).equals(columnName)) {
                                    DataFormatter formatter = new DataFormatter();
                                    userDataExcel = formatter.formatCellValue(sht.getRow(i).getCell(j));
                                    //System.out.println("Data login: "+userDataExcel);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            userData = userDataExcel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    public static  boolean isEmptyString(String input){
        if((null != input) && (!"".equals(input))){
            return false;
        }
        return true;
    }

    public static String getPrefixFromBrowser(){
        String prefix = "";
        if(sBrowser.equalsIgnoreCase("firefox")){
            prefix = "ff.";
        }else if(sBrowser.equalsIgnoreCase("internet explorer")){
            prefix = "ie.";
        }else if(sBrowser.equalsIgnoreCase("edge")){
            prefix = "edge.";
        }else{
            prefix = "chr.";
        }

        return prefix;
    }
}
