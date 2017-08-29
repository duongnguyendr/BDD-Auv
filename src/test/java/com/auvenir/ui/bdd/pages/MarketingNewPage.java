package com.auvenir.ui.bdd.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by doai.tran on 8/29/2017.
 */
public class MarketingNewPage {
    public MarketingNewPage(WebDriver driver) {
        //super(logger, driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='ui right aligned container']/button")
    private WebElement loginBTN;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = ".//*[@id='login-popup']//button")
    private WebElement submitBTN;



    public void clickOnLoginBTN() {
/*        getLogger().info("Click on login button.");
        clickElement(loginBTN, "loginBTN");*/
        loginBTN.click();
    }

    public void inputUserNamePassword(String username, String password) {
/*        sendKeyTextBox(emailTextBox, username, "emailTextBox");
        sendKeyTextBox(passwordTextBox, password, "passwordTextBox");*/
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
    }

    public void clickOnSubmitBTN() {
        //clickElement(submitBTN, "loginBTN");
        submitBTN.click();
    }

    @FindBy(id = "pageHeadBackText")
    private WebElement eleAdminHdrTxt;

    public void verifyHeaderAdminPage() {
        /*try {
            waitForVisibleElement(eleAdminHdrTxt, "eleAdminHdrTxt");
            validateElementText(eleAdminHdrTxt, "Admin");
            Assert.assertEquals(validateElementText(eleAdminHdrTxt, "Admin"),"true");
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        System.out.println("00000000: "+eleAdminHdrTxt.getText());
        Assert.assertEquals((eleAdminHdrTxt).getText(), "Admin");
    }
}
