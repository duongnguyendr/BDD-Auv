package com.auvenir.ui.bdd.common;

import java.io.*;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.commons.io.FileUtils;

import static com.auvenir.ui.bdd.common.Generic.sExecuteTime;

/**
 * Created by doai.tran on 9/6/2017.
 */
public class GeneratePDF {

    public static void toExecute(File sPdfReports, String timeStamp){
        try {
            System.out.println("START GENERATE PDF");
            //String k = "<html><body> This is my Project </body></html>";
            /*OutputStream file = new FileOutputStream(new File("Reports/PDFReports/Report_"+sExecuteTime+".pdf"));
            Document document = new Document();*/
            /*PdfWriter.getInstance(document, file);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(k));*/
            /*PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Reports/PDFReports/Report_"+sExecuteTime+".pdf"));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    new FileInputStream("Reports/HTMLReports/Report_"+sExecuteTime+"/cucumber-html-reports/overview-features.html"));

            document.close();*/
            PdfGenerater.toExecuteCucumberReport(sPdfReports, timeStamp);

            //file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
