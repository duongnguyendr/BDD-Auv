package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by thuan.duong on 9/12/2017.
 */
public class ClientSignUpPage extends CommonPage {

    @FindBy(xpath = "//h3[@id='welcome-body']")
    private WebElement titleWelcome;

    public ClientSignUpPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyWelcomePageTitle() {
        getLogger().info("Welcome Page loaded.(Status change: Onboarding->Active)");
        switchToOtherTab(1);
        boolean result = validateElementText(titleWelcome, "Welcome to Auvenir!");
        Assert.assertTrue(result,"Should see the Welcome to Auvenir! title.");
    }
}