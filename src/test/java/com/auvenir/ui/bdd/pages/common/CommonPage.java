package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class CommonPage extends KeyWord {
    public CommonPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    /**
     * Waiting for The Progressing Overlay is closed.
     */
    @FindBy(xpath = "//*[@class='progress-overlay']")
    private WebElement progressingDiv;

    @FindBy(xpath = "//div[@class = 'fl-a-container fl-a-container-show'] //div[@class='send-message-success-alert']/span")
    private WebElement successToastMesDescriptionEle;

    public void waitForProgressOverlayIsClosed() {
        getLogger().info("Try to waiting the ProgressOverlayIsClosed.");
        waitForCssValueChanged(progressingDiv, "Progress Overlay", "display", "none");
    }

    public boolean verifyContentOfSuccessToastMessage(String expectedContent) {
        getLogger().info("Try to Verify Content Of Warning Toast Message ");
        return verifyContentOfToastMessage(successToastMesDescriptionEle, "Success Toast Message Content", expectedContent);
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to verify the content of Toast Message.
     */
    public boolean verifyContentOfToastMessage(WebElement element, String elementName, String expectedContent) {
        getLogger().info("Try to Verify Content Of Toast Message: " + elementName);
        try {
            boolean result;
            //            Thread.sleep(3000);
            waitForVisibleElement(element, elementName);
            //            Thread.sleep(smallTimeOut);
            result = validateElementText(element, expectedContent);
            Assert.assertTrue(result, "The content of toast message is displayed successfully.");
            return true;
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
            return false;
        }
    }
}
