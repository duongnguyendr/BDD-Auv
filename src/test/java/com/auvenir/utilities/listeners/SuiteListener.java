package com.auvenir.utilities.listeners;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * Created by duong.nguyen on 6/5/2017.
 */
public class SuiteListener implements ISuiteListener{
    public void onStart(ISuite suite) {
    }

    public void onFinish(ISuite suite){
        // send report...
        String timeStamp = GeneralUtilities.getTimeStampForNameSuffix();
        File sDateReports = new File(GenericService.sDirPath+"//Reports//ImageReports//" + timeStamp);
        try{
            if(!sDateReports.exists()) {
                FileUtils.forceMkdir(sDateReports);
            }
            GenericService.getPieChartFollowBrowser(TestngListener.sTestName, TestngListener.sStatus, timeStamp);
            GenericService.getBarChartFollowBrowser(TestngListener.sTestName, TestngListener.sStatus, timeStamp);
            TestngListener.pdf.toExecute(TestngListener.sTestName, TestngListener.sDescription, TestngListener.sStatus, TestngListener.iPassCount, TestngListener.iFailCount, TestngListener.iSkippedCount, TestngListener.pdfReports, timeStamp);
            GenericService.sendMail(TestngListener.pdfReports, TestngListener.sTestName, TestngListener.sStatus, timeStamp);
        }catch(IOException ex){

        }

    }
}
