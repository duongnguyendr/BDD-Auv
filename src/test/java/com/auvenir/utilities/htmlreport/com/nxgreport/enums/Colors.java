//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.auvenir.utilities.htmlreport.com.nxgreport.enums;

public enum Colors {
    PASS("#7BB661"),
    FAIL("#E03C31"),
    SKIP("#21ABCD");

    private String color;

    private Colors(String var3) {
        this.setColor(var3);
    }

    public String getColor() {
        return this.color;
    }

    private void setColor(String var1) {
        this.color = var1;
    }
}
