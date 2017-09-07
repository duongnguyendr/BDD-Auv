package com.auvenir.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfGenerater {
    private static final BaseColor GrayColor = null;
    public static String sdate;
    public static String path = "D:/dvf.pdf";
    private static String FILE = path;
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
    private static Font failFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.RED);
    private static Font passFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, new BaseColor(0, 153, 76));
    private static Font skipFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, new BaseColor(204, 102, 0));
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font tableHeaderbold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
    private static Font tableCellText = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
    private static Font tableCellValue = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.BLACK);
    private static String browserAutomationTest[] = new String[] {"CHROME","FIREFOX","IE","SAFARI","EDGE"};

    public static void toExecute(ArrayList sTestName, ArrayList sDescription, ArrayList sStatus, int iPassCount, int iFailCount, int iSkippedCount, File pdfReports, String timeStamp) {
        PdfWriter writer = null;
        // String FILE = sTestngReports;
        try {
            Document document = new Document();
            writer = PdfWriter.getInstance(document, new FileOutputStream(pdfReports));
            document.open();
            addMetaData(document);
            addTitlePage(document, sTestName, sDescription, sStatus, iPassCount, iFailCount, iSkippedCount, timeStamp);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
        document.addHeader("Test", "Selenium");
    }

    private static void addTitlePage(Document document, ArrayList sTestName, ArrayList sDescription, ArrayList sStatus, int iPassCount, int iFailCount, int iSkipCount, String timeStamp) throws DocumentException, IOException {

        //Header header = new Header("header", "D:\\Auvenir.png") ;
        //document.addHeader("tests", "D:\\Auvenir.png");
        PdfPTable tblheader = new PdfPTable(1);
        try {
            tblheader.setWidths(new int[]{24});
            tblheader.setTotalWidth(150);
            tblheader.setLockedWidth(true);
            tblheader.getDefaultCell().setFixedHeight(130);
            tblheader.getDefaultCell().setLeading(0, 1.1f);
            tblheader.getDefaultCell().setBorder(Rectangle.BOTTOM);
            tblheader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            tblheader.addCell("Image");
            //tblheader.writeSelectedRows(0, -1, 10, tblheader.getTotalHeight() + 590, writer.getDirectContent());
        } catch (Exception e) {

        }

        Paragraph preface = new Paragraph();
        Image AuvenirheaderImg = Image.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\Auvenir.png");
        AuvenirheaderImg.scaleAbsolute(50f, 20f);
        AuvenirheaderImg.setAlignment(Element.ALIGN_TOP);

        Image NxgheaderImg = Image.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\NXGlogo.png");
        NxgheaderImg.scaleAbsolute(70f, 40f);
        NxgheaderImg.setAlignment(Element.ALIGN_RIGHT);
         /*preface.add(header);
		 preface.add(header1);*/
		 /*
		 Image footer = Image.getInstance(System.getProperty("user.dir")+"\\src\\tests\\resources\\images\\NXGlogo.png");
		 footer.scaleAbsolute(100f, 20f);
		 footer.setAlignment(Element.ALIGN_RIGHT);
		 preface.add(footer);
		 */
	     /* preface.add(AuvenirheaderImg);
	     preface.add(NxgheaderImg);*/
        // addEmptyLine(preface, 1);
        preface.add(new Paragraph("                           Automation Test Report".toUpperCase(), catFont));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("   Report generated by: " + "Automation Team" + ", " + new Date(), smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("   This report demontrates the status of automation execution results in number, percentage of Passed," + "     Failed and Skipped Test Cases.", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        /*Image image2 = Image.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChart.png");
        image2.scaleAbsolute(120f, 120f);
         //image2.setAlignment(Element.ALIGN_LEFT);
        Image image3 = Image.getInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\BarChart.png");
        image3.scaleAbsolute(120f, 120f);*/

        addEmptyLine(preface, 8);

        List<String> browserList = getBrowserList();
        int totalBrowser = browserList.size();
        for (int i = 0; i < totalBrowser; i++) {
            Paragraph prefaceBrowser = new Paragraph();
            addEmptyLine(prefaceBrowser, 1);
            String browserName = browserList.get(i).substring(0,browserList.get(i).length()-1);
            prefaceBrowser.add(new Paragraph("        Browser name : " + browserName, smallBold));
            addEmptyLine(prefaceBrowser, 1);
            document.add(prefaceBrowser);

            PdfPTable table = new PdfPTable(2);

            table.setWidthPercentage(75);
            table.setWidths(new int[]{1, 1});
            table.setSpacingAfter(10);

            /*table.addCell(createImageCell(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChart" + browserName + "_" + timeStamp + ".png"));
            table.addCell(createImageCell(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\BarChart" + browserName + "_" + timeStamp + ".png"));*/

            table.addCell(createImageCell(System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp +"\\PieChart" + browserName + "_" + timeStamp + ".png"));
            table.addCell(createImageCell(System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp +"\\BarChart" + browserName + "_" + timeStamp + ".png"));
            document.add(table);
        }

        Paragraph prefaceThree = new Paragraph();
        prefaceThree.setSpacingBefore(2);
        createSummaryTable(prefaceThree, iPassCount, iFailCount, iSkipCount, sTestName, sStatus);
        addEmptyLine(prefaceThree, 2);
        document.add(prefaceThree);

        //preface.add(image2);
        //preface.add(image3);
        Paragraph prefaceTwo = new Paragraph();
        createTable(prefaceTwo, sTestName, sDescription, sStatus);
        document.add(prefaceTwo);
        document.newPage();
    }

    private static void createSummaryTable(Paragraph preface, int iPassCount, int iFailCount, int iSkipCount,
                                           ArrayList sTestNames, ArrayList sStatus) throws DocumentException {
        List<String> browserList = getBrowserList();
        int totalColumn = browserAutomationTest.length + 1;
        PdfPTable table = new PdfPTable(totalColumn );
        float[] columnWidths = new float[totalColumn];
        columnWidths[0] = (float) 1.5;
        for(int i=1; i <totalColumn; i++){
            columnWidths[i] = (float) 1;
        }
        table.setWidthPercentage(75);
        table.setWidths(columnWidths);

        // table.setWidths(new int[]{1, 1});
        table.addCell(new PdfPCell(new Phrase("Test Summary", tableHeaderbold)));
        for(int i=0; i<browserAutomationTest.length; i++){
            table.addCell(new PdfPCell(new Phrase(browserAutomationTest[i],
                                        tableHeaderbold)));
        }
        List<String> sTestNameList = getTestNameList(sTestNames);
        table.addCell(new PdfPCell(new Phrase("Total Test cases", tableCellText)));
        for(int i=0; i<browserAutomationTest.length; i++){
            table.addCell(new PdfPCell(new Phrase(String.valueOf(sTestNameList.size()),tableHeaderbold)));
        }

        table.addCell(new PdfPCell(new Phrase("Passed", tableCellText)));
        for(int i=0; i<browserAutomationTest.length; i++){
            if(checkBrowserIsSkip(browserAutomationTest[i],browserList)){
                table.addCell(new PdfPCell(new Phrase("0",tableHeaderbold)));
            }else{
                table.addCell(new PdfPCell(new Phrase(String.valueOf(countTotalTestNameStatusFollowBrowser(sTestNames,GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Passed")),tableHeaderbold)));
            }

        }

        table.addCell(new PdfPCell(new Phrase("Failed", tableCellText)));
        for(int i=0; i<browserAutomationTest.length; i++){
            if(checkBrowserIsSkip(browserAutomationTest[i],browserList)){
                table.addCell(new PdfPCell(new Phrase("0",tableHeaderbold)));
            }else {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(countTotalTestNameStatusFollowBrowser(sTestNames, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Failed")), tableHeaderbold)));
            }
        }

        table.addCell(new PdfPCell(new Phrase("Skipped", tableCellText)));
        for(int i=0; i<browserAutomationTest.length; i++){
            int totalTestCase = sTestNameList.size();
            int totalPassedCount = 0;
            int totalFailedCount = 0;
            int totalSkippedCase = 0;
            if(!checkBrowserIsSkip(browserAutomationTest[i],browserList)){

                totalPassedCount = countTotalTestNameStatusFollowBrowser(sTestNames, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Passed");

                totalFailedCount = countTotalTestNameStatusFollowBrowser(sTestNames, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Failed");

                totalSkippedCase = countTotalTestNameStatusFollowBrowser(sTestNames, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Skipped");

            }
            table.addCell(new PdfPCell(new Phrase(String.valueOf(totalTestCase - (totalSkippedCase + totalPassedCount + totalFailedCount)), tableHeaderbold)));
        }
        preface.add(table);
    }

    public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBorderWidth((float) 0.05);
        return cell;
    }

    public static PdfPCell createStatusImage(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        // cell.setBorder(Rectangle.BOTTOM);
        cell.setBorderWidth((float) 0.25);
        cell.setBorderColor(BaseColor.BLACK);
        return cell;
    }

    private static void createTable(Paragraph preface, ArrayList sTestName, ArrayList sDescription, ArrayList sStatus) throws DocumentException, IOException {
        Font statusFont = null;
        String image = null;
        List<String> browserList = getBrowserList();
        int totalBrowser = browserAutomationTest.length;
        int totalColumn =  totalBrowser + 3;
        PdfPTable table = new PdfPTable(totalColumn);
        table.setWidthPercentage(95);
        float[] columnWidths = new float[totalColumn];
        columnWidths[0] = (float) 0.16;
        columnWidths[1] = (float) 0.90;
        columnWidths[2] = (float) 1.2;
        for(int i=3; i <totalColumn; i++){
            columnWidths[i] = (float) 0.6;
        }
        table.setWidths(columnWidths);
        PdfPCell c1 = new PdfPCell(new Phrase("No.", tableHeaderbold));
        c1.setVerticalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(BaseColor.GRAY);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Testcase", tableHeaderbold));
        c1.setVerticalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(BaseColor.GRAY);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Description", tableHeaderbold));
        c1.setVerticalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(BaseColor.GRAY);
        table.addCell(c1);
        for(int i=0; i<totalBrowser; i++){
            c1 = new PdfPCell(new Phrase(browserAutomationTest[i], tableHeaderbold));
            c1.setVerticalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(BaseColor.GRAY);
            table.addCell(c1);
        }

        table.setHeaderRows(1);
        int cnt = 0;
        List<String> sTestNameList = getTestNameList(sTestName);
        for (int i = 0; i < sTestNameList.size(); i++) {

            String sDescriptionTestName = getDescriptionTestNameFollowBrowser(sTestName,sTestNameList.get(i),
                                                                      sDescription);
            cnt = cnt + 1;
            table.addCell(new PdfPCell(new Phrase(String.valueOf(cnt), tableCellValue)));
            table.addCell(new PdfPCell(new Phrase(sTestNameList.get(i).toString(), tableCellValue)));
            table.addCell(new PdfPCell(new Phrase(sDescriptionTestName, tableCellValue)));
            for(int j=0;  j< totalBrowser; j++){
                String statusTestName = "Skipped";
                if(!checkBrowserIsSkip(browserAutomationTest[j],browserList)){
                    String browserName = browserAutomationTest[j] + "_";
                    statusTestName = getStatusTestNameFollowBrowser(sTestName,
                                                                    sTestNameList.get(i).toString(),
                                                                    GenericService.sBrowserTestNameList, browserName,
                                                                    sStatus);
                }
                if (statusTestName.equals("Passed")) {
                    statusFont = passFont;
                } else if (statusTestName.equals("Failed")) {
                    statusFont = failFont;
                } else {
                    statusFont = skipFont;
                }
                table.addCell(new PdfPCell(new Phrase(statusTestName, statusFont)));
            }
/*
            if (sStatus.get(i).equals("Passed")) {
                statusFont = passFont;
                //image = System.getProperty("user.dir")+"\\src\\tests\\resources\\images\\pass.png";
            } else if (sStatus.get(i).equals("Failed")) {
                statusFont = failFont;
                //image = System.getProperty("user.dir")+"\\src\\tests\\resources\\images\\pass.png";

            } else {
                statusFont = skipFont;
                //image = System.getProperty("user.dir")+"\\src\\tests\\resources\\images\\skip.png";
            }
            cnt = cnt + 1;

            table.addCell(new PdfPCell(new Phrase(sTestName.get(i).toString(), tableCellValue)));
            table.addCell(new PdfPCell(new Phrase(sDescription.get(i).toString(), tableCellValue)));
            table.addCell(new PdfPCell(new Phrase(sStatus.get(i).toString(), statusFont)));
            table.addCell(new PdfPCell(new Phrase(sStatus.get(i).toString(), statusFont)));*/
            //table.addCell(new PdfPCell(new Phrase(String.valueOf(cnt),tableCellValue)));    table.addCell(new PdfPCell(new Phrase(sTestName.get(i).toString(),tableCellValue))); table.addCell(new PdfPCell(new Phrase(sDescription.get(i).toString(),tableCellValue)));  table.addCell(createStatusImage(image));

        }
        preface.add(table);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    /**
     * Get browser list not duplicate
     * Auditor : TanPham 01/06/2017
     * @return browser list
     */
    private static List<String> getBrowserList(){
        List<String> result = new ArrayList<String>();
        int totalRow = GenericService.sBrowserTestNameList.size();
        for(int i=0; i<totalRow; i++){
            if(!result.contains(GenericService.sBrowserTestNameList.get(i).toString())){
                result.add(GenericService.sBrowserTestNameList.get(i).toString());
            }
        }
        return result;
    }

    /**
     * Get test name list not duplicate
     * Auditor : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @return null | test name list
     */
    public static List<String> getTestNameList(ArrayList sTestNames)
    {
        List<String> result = new ArrayList<String>();
        int totalRow = sTestNames.size();
        for(int i=0; i<totalRow; i++){
            if(!result.contains(sTestNames.get(i).toString())){
                result.add(sTestNames.get(i).toString());
            }
        }
        return result;
    }

    /**
     * get status test name follow browser
     * Auditor : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sTestName : test name need check
     * @param sBrowserList : browser list
     * @param sBrowser : browser need check
     * @param sStatus : status test name list
     * @return "" | != ""
     */
    private static String getStatusTestNameFollowBrowser(ArrayList sTestNames, String sTestName,
                                                         List<String> sBrowserList, String sBrowser,
                                                         ArrayList sStatus){
        String result = "Skipped";
        for (int i = 0; i < sTestNames.size(); i++) {
            if (sTestNames.get(i).equals(sTestName) &&
                sBrowserList.get(i).equals(sBrowser)){
                return sStatus.get(i).toString();
            }
        }
        return  result;
    }

    /**
     * Get description test name follow browser
     * Auditor : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sTestName : test name check
     * @param sDescription : description test name list
     * @return "" | != ""
     */
    private static String getDescriptionTestNameFollowBrowser(ArrayList sTestNames, String sTestName,
                                                              ArrayList sDescription){
        String result = "";
        for (int i = 0; i < sTestNames.size(); i++) {
            if (sTestNames.get(i).equals(sTestName)){
                return sDescription.get(i).toString();
            }
        }
        return  result;
    }

    /**
     * Count total test name follow browser
     * Auditor : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sBrowserList : browser list
     * @param sBrowser : browser need check
     * @return 0 | >0
     */
    private static int countTotalTestNameFollowBrowser(ArrayList sTestNames,
                                                       ArrayList sBrowserList, String sBrowser){
        int count =0 ;
        for (int i = 0; i < sTestNames.size(); i++) {
            if (sBrowserList.get(i).equals(sBrowser + "_")){
                count++;
            }
        }
        return  count;
    }

    /**
     * Count total test name follow status
     * Auditor : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sBrowserList : browser list
     * @param sBrowser : browser need check
     * @param sStatus : status test name list
     * @param statusTest : status need check
     * @return 0 | >0
     */
    public static int countTotalTestNameStatusFollowBrowser(ArrayList sTestNames,
                                                             ArrayList sBrowserList, String sBrowser,
                                                             ArrayList sStatus, String statusTest){
        int count = 0 ;
        if((sBrowserList.size() != sTestNames.size()) ||(sStatus.size() != sTestNames.size())){
            return count;
        }

        for (int i = 0; i < sTestNames.size(); i++) {
            if (sBrowserList.get(i).equals(sBrowser + "_") &&
                sStatus.get(i).equals(statusTest)){
                count++;
            }
        }
        return  count;
    }

    
    /**
     * Check browser is skipped.
     * Auditor : TanPham 01/06/2017
     * @param browserName : browser need check
     * @param sBrowserList : browser list
     * @return true | false
     */
    public static boolean checkBrowserIsSkip(String browserName,List sBrowserList){
        for (int i = 0; i < sBrowserList.size(); i++) {
            if (sBrowserList.get(i).equals(browserName + "_")){
                    return false;
            }
        }
        return true;
    }

    //PDF for Cucumber Report
    public static void toExecuteCucumberReport(File pdfReports, String timeStamp) {
        PdfWriter writer = null;
        // String FILE = sTestngReports;
        try {
            Document document = new Document();
            writer = PdfWriter.getInstance(document, new FileOutputStream(pdfReports));
            document.open();
            addMetaData(document);
            addTitlePageCucumberPDF(document, timeStamp);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTitlePageCucumberPDF(Document document, String timeStamp) throws DocumentException, IOException {

        Paragraph preface = new Paragraph();

        preface.add(new Paragraph("                           Automation Test Report".toUpperCase(), catFont));
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("   Report generated by: " + "Automation Team" + ", " + new Date(), smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("   This report demontrates the status of automation execution results in number, percentage of Passed," + "     Failed and Skipped Test Cases.", smallBold));
        addEmptyLine(preface, 1);
        document.add(preface);

        addEmptyLine(preface, 8);

        PdfPTable table = new PdfPTable(2);

        table.setWidthPercentage(75);
        table.setWidths(new int[]{1, 1});
        table.setSpacingAfter(10);

        table.addCell(createImageCell(System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp +"\\PieChart" +  "_" + timeStamp + ".png"));
        table.addCell(createImageCell(System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp +"\\BarChart" +  "_" + timeStamp + ".png"));
        document.add(table);

        document.newPage();
    }
}
   
  

