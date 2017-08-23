package com.auvenir.ui.dataprovider.auditor.todo;

import com.auvenir.utilities.GenericService;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/21/2017.
 */
public class AuditorRequestDataProvider {
    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
    private static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
    private static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
    private static String pathOfUploadLocation = GenericService.sDirPath +GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Path of Upload Location");
    private static String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  02");
    private static String txtFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "TXTFile");
    private static String docxFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DOCXFile");
    private static String xlsxFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "XLSXFile");
    private static String pdfFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "PDFFile");
    private static String pngFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "PNGFile");
    private static String jpgFile = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "JPGFile");

    @DataProvider(name = "verifyUploadRequestFiles")
    public static Object[][] getVerifyAuditorEmptyTodoListPage() {

        Object[][] arrayData = new Object[][]{
                {auditorId, auditorPwd, engagementName, pathOfUploadLocation, toDoName, txtFile, docxFile, xlsxFile, pdfFile, pngFile, jpgFile}};
        if (GenericService.sLanguage.equalsIgnoreCase("French")) {
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, pathOfUploadLocation, toDoName, txtFile, docxFile, xlsxFile, pdfFile, pngFile, jpgFile}};
        }
        return arrayData;
    }
}
