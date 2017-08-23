package com.auvenir.utilities.htmlreport.com.nxgreport.exceptions;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class KIRWAReportException extends Exception {
    private static final long serialVersionUID = 1L;
    private String message;

    public KIRWAReportException() {
    }

    public KIRWAReportException(String var1) {
        this.message = var1;
    }

    public String toString() {
        return "[KIRWA Custom Reporter Exception] " + this.message;
    }
}
