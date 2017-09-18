package com.auvenir.ui.bdd.pages.marketing;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by doai.tran on 8/29/2017.
 */
public class MarketingPage extends CommonPage {
   public MarketingPage(Logger logger,WebDriver driver) {
      super(logger, driver);
      PageFactory.initElements(driver, this);
   }
   private String xpathStatusCellOnUserTableAdminX = "//td[text()='%s']/ancestor::tr/td[5]/select";
   @FindBy(xpath = "//*[@class='ui right aligned container']/button")
   private WebElement loginBTN;

   @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='email']")
   private WebElement emailTextBox;

   @FindBy(xpath = ".//*[@id='login-popup']//div/input[@name='password']")
   private WebElement passwordTextBox;

   @FindBy(xpath = ".//*[@id='login-popup']//button")
   private WebElement submitBTN;

   @FindBy(xpath = "//*/a[@class='ui large basic inverted button']")
   private WebElement signUpBTN;
   @FindBy(id = "marketing-header")
   private WebElement marketingHeader;


   public void clickOnLoginBTN() {
      //getLogger().info("Click on login button.");
      clickElement(loginBTN, "loginBTN");
      //loginBTN.click();
   }

   public void clickOnSignupButton() {
      clickElement(signUpBTN, "signup button");
   }

   public void inputUserNamePassword(String username, String password) {
      sendKeyTextBox(emailTextBox, username, "emailTextBox");
      sendKeyTextBox(passwordTextBox, password, "passwordTextBox");
        /*emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);.*/
   }

   public void clickOnSubmitBTN() {
      clickElement(submitBTN, "loginBTN");
      //submitBTN.click();
   }

   @FindBy(id = "pageHeadBackText")
   private WebElement eleAdminHdrTxt;

   public void verifyHeaderAdminPage() {
      Assert.assertEquals((eleAdminHdrTxt).getText(), "Admin");
   }

   public void verifyMaketingHeaderPage(){
      boolean result = validateExistedElement(marketingHeader, "Marketing header");
      Assert.assertTrue(result, "Verify marketing header page.");
   }

}
