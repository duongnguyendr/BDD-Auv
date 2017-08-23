package com.auvenir.utilities.htmlreport.com.nxgreport.utils;

import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class Steps {
    private String description;
    private String inputValue;
    private String expectedValue;
    private String actualValue;
    private String time;
    private String lineNum;
    private String screenShot;
    private LogAs logAs;
    private String stepException;

    public Steps() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public void setScreenShot(String screenShot) {
        this.screenShot = screenShot;
    }

    public String getInputValue() {
        return this.inputValue;
    }

    public String getExpectedValue() {
        return this.expectedValue;
    }

    public String getActualValue() {
        return this.actualValue;
    }

    public String getTime() {
        return this.time;
    }

    public String getLineNum() {
        return this.lineNum;
    }

    public LogAs getLogAs() {
        return this.logAs;
    }

    public String getScreenShot() {
        return this.screenShot;
    }

    public void setLogAs(LogAs logas2) {
        this.logAs = logas2;
    }

    public String  getStepException() {return this.stepException;}

    public void setStepException(String stepException){ this.stepException = stepException;}
}
