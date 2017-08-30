package com.auvenir.ui.bdd.common;

/**
 * Created by doai.tran on 8/29/2017.
 */
import com.auvenir.ui.bdd.common.GenerateReport;
import org.testng.IExecutionListener;

public class TestNGExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("TestNG is staring the execution");
    }
    @Override
    public void onExecutionFinish() {
        System.out.println("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished, the execution");
    }
}
