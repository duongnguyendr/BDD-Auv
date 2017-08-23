package com.auvenir.utilities.htmlreport.com.nxgreport.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class Utils {
    public Utils() {
    }

    public static String getCurrentTime() {
        SimpleDateFormat var0 = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        Date var1 = new Date();
        return var0.format(var1);
    }
}
