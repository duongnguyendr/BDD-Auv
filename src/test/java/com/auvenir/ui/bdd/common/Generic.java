package com.auvenir.ui.bdd.common;

import com.auvenir.ui.bdd.base.BaseInit;
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
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


/**
 * Created by doai.tran on 8/31/2017.
 */
public class Generic extends BaseInit{
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
    public static String sExecuteTime = null;
    public static String sExecutionDate = null;

    /**
     * Description: Method to read the configuration from Config file.
     * @param sFile FILE Destination
     * @param sKey KeyWord to read value.
     * @return
     */
    public static String getConfigValue(String sFile, String sKey) {
        getLogger().info("**** Read Configuration file ****");
        Properties prop = new Properties();
        String sValue = null;
        try {
            InputStream input = new FileInputStream(sFile);
            prop.load(input);
            sValue = prop.getProperty(sKey);
            getLogger().info("**** Value from Properties file of Parameter: "+sKey+": "+sValue);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            getLogger().info("**** Can not find the properties file ****"+sValue);
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
        getLogger().info("**** Read Configuration file ****");
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(sFile));
            prop.load(fis);
            fis.close();
            FileOutputStream fos = new FileOutputStream(new File(sFile));
            prop.setProperty(sKey, sValue);
            prop.store(fos, "Updating folder path");
            fos.close();
            getLogger().info("**** Value from Properties file of Parameter: "+sKey+"be set: "+sValue);
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
}
