//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.auvenir.utilities.htmlreport.com.nxgreport;

public enum ReportLabels {
    HEADER_TEXT("KIRWA Custom Reports for TestNG"),
    PASS("Passed"),
    FAIL("Failed"),
    SKIP("Skipped"),
    CAPTION(""),
    KIRWALOGO("NXGlogo.png"),
    PROJLOGO("C:/ideas.png"),
    TC_INFO_LABEL("");

    private String label;

    private ReportLabels(String label) {
        this.setLabel(label);
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
