package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class CommonPage extends KeyWord {
    private static Logger logger = Logger.getLogger(CommonPage.class.getSimpleName());
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
        logger.info("Try to waiting the ProgressOverlayIsClosed.");
        waitForCssValueChanged(progressingDiv, "Progress Overlay", "display", "none");
    }

    public boolean verifyContentOfSuccessToastMessage(String expectedContent) {
        logger.info("Try to Verify Content Of Warning Toast Message ");
        return verifyContentOfToastMessage(successToastMesDescriptionEle, "Success Toast Message Content", expectedContent);
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to verify the content of Toast Message.
     */
    public boolean verifyContentOfToastMessage(WebElement element, String elementName, String expectedContent) {
        logger.info("Try to Verify Content Of Toast Message: " + elementName);
        try {
            boolean result;
            //            Thread.sleep(3000);
            waitForVisibleElement(element, elementName);
            //            Thread.sleep(smallTimeOut);
            result = validateElementText(element, expectedContent);
            Assert.assertTrue(result, "The content of toast message is displayed successfully.");
            return true;
        } catch (AssertionError e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    /**
     * wait until animation for element finish
     *
     * @param webElement  xpath to get element
     * @param elementName vararg for formating
     */
    public void waitForAnimation(WebElement webElement, String elementName) {
        // This function is waiting to Popup Delete To Do task is displayed after running animation.
        // We can move this function to Abstract Page or Common Page.
        try {
            logger.info("Waiting For Animation: " + elementName);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until((WebDriver driver) -> {
                boolean result = false;
                result = (boolean) ((JavascriptExecutor) driver).executeScript(
                        "var elm = arguments[0];" + "var doc1 = elm.ownerDocument || document;" + "var rect = elm.getBoundingClientRect();" + "return elm === doc1.elementFromPoint(rect.left, rect.top);",
                        webElement);
                logger.info("result: " + result);
                return result;
            });
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * @param webElement  Element defined in page class
     * @param elementName The text name of element
     * @return The text of web element
     */
    public String getTextByAttributeValue(WebElement webElement, String elementName) {
        logger.info("Get text by attribute 'value' " + elementName);
        try {
            return webElement.getAttribute("value");
        } catch (NoSuchElementException e) {
            logger.info(e.getMessage());
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;
    }
}
