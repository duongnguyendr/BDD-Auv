package com.auvenir.ui.bdd.common;

import com.auvenir.ui.bdd.base.BaseInit;
import org.apache.log4j.Logger;

/**"
 * Created by tan.pham on 9/14/2017.
 */
public class PrintLog {
    private static Logger logger = Logger.getLogger("LOG");

    public static void printLogStepDefinitions(String stepDefinitions){
        logger.info("===== " + stepDefinitions + " =====");
    }

    public static void printLogActionInPage(String pageDescription){
        logger.info("  ----- " + pageDescription + " -----");
    }

    public static void printLogActionOfElement(String elementAction, String elementValue ){
        logger.info("    +++++ " + elementAction + ": " + elementValue + " +++++");
    }

    public static void printLogParameterInput(String parameterDescription, String parameterValue){
        logger.info("      ***** " + parameterDescription + ":" + parameterValue + " *****");
    }

    public static void printLogParameterGetProperties(String parameterDescription, String parameterValue){
        logger.info("      ##### " + parameterDescription + ":" + parameterValue + " #####");
    }

    public static void printLogParameterGetExcelFile(String parameterDescription, String parameterValue){
        logger.info("      $$$$$ " + parameterDescription + ":" + parameterValue + " $$$$$");
    }

    public static void printLogParameterGetTestNGFile(String parameterDescription, String parameterValue){
        logger.info("      ^^^^^ " + parameterDescription + ":" + parameterValue + " ^^^^^");
    }
}
