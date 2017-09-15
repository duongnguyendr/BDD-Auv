package com.auvenir.ui.bdd.pages.common;

import java.util.List;

public class GetTable {
    String column0;
    String column1;


    public GetTable(String column0, String column1) {
        this.column0 = column0;
        this.column1 = column1;
    }

    public String getColumn0() {
        return column0;
    }

    public void setColumn0(String column0) {
        this.column0 = column0;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }
}
