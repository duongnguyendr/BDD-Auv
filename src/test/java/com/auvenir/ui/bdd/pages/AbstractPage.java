package com.auvenir.ui.bdd.pages;

import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.GenericService;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by doai.tran on 8/21/2017.
 */
public class AbstractPage {
    private Logger logger = null;
    private WebDriver driver = null;
    public AbstractPage(Logger logger, WebDriver driver){
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }
    public WebDriver getDriver(){
        return driver;
    }
    public Logger getLogger(){
        return logger;
    }

    public static final int waitTime = 30;
    public static final int smallTimeOut = 1000;

    /**
     * @param webElement
     * @param elementName
     * @param waitTime
     */
    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            WebDriverWait sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
    public boolean validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("Check rendered of text: " + elementText.trim());
            getLogger().info("Actual Text is displayed: " + getText(webElement).trim());
            Assert.assertEquals(getText(webElement).trim(), elementText.trim());
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            return false;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            AbstractService.sStatusCnt++;
            return false;
        }
    }

    /**
     *
     * @param xpathElement
     * @return Web element by xpath
     */
    public WebElement findWebElementByXpath(String xpathElement) {
        WebElement resultWebElement = null;
        try {
            getLogger().info("The xpath of web element = " + xpathElement);
            resultWebElement = getDriver().findElement(By.xpath(xpathElement));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
        return resultWebElement;
    }

    /**
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public boolean validateDisPlayedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify Displayed of: " + elementName);
        try {
            element.isDisplayed();
            getLogger().info("Element : " + elementName + " is presented");
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element + "is not presented");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */

    public boolean validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify enabled of: " + elementName);
        try {
            element.isEnabled();
            getLogger().info("Element : " + elementName + "is enable");
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + elementName + "is not enable.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify selected of: " + elementName);
        try {
            element.isSelected();
            getLogger().info("Element : " + element.getText() + "is selected.");
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() + "is not selected.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateNotSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("verify not selected of: " + elementName);
        try {
            if (!element.isSelected()) {
                getLogger().info("Element : " + element.getText() + "is not selected.");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element : " + element.getText() + "is selected.");
            return false;
        }
    }

    public boolean validateMaxlenght(WebElement webElement, String webElementName, int maxLength) {
        try {
            String inputTextwithMaxLength = randomCharacters(maxLength);
            getLogger().info("Verify input with max length with " + maxLength + " characters");
            clickElement(webElement, webElementName);
            clearTextBox(webElement, webElementName);
            webElement.sendKeys(inputTextwithMaxLength);
            String actualTextInput = webElement.getAttribute("value");
            Assert.assertEquals(actualTextInput, inputTextwithMaxLength, String.format("%s cannot input %d characters", webElementName, maxLength));
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            AbstractService.sStatusCnt++;
            return false;
        }
    }
    public String randomCharacters(int maxLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String results = sb.toString();
        return results;
    }

    /*
            Improvement to detect value: true/ false after take actions
            Updated by: Doai.Tran 8/5/2017
             */
    public void scrollPageUp() {
        getLogger().info("Try to scroll Page up.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page up unsuccessfully.");
        }
    }

    /*
    Method to scrollPageDown
     */
    public void scrollPageDown() {
        getLogger().info("Try to scroll Page down.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("scroll Page down unsuccessfully.");
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForVisibleElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForVisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e);
            return false;
        }
    }

    /**
     * @Description In order to wait element to be present by locator.
     */
    public boolean waitForPresentOfLocator(By by) {
        getLogger().info("Try to waitForPresentOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not present.");
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible by locator.
     */
    public boolean waitForVisibleOfLocator(By by) {
        getLogger().info("Try to waitForVisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible.");
            return false;
        }
    }

    /**
     * created by: minh.nguyen
     *
     * @Description In order to wait element to be visible by locator with seconds input.
     */
    public boolean waitForVisibleOfLocator(By locator, int seconds) {
        getLogger().info("Try to waitForVisibleOfLocator by seconds");
        boolean isResult = false;
        try {
            int i = 0;
            while (i < seconds) {
                try {
                    getDriver().findElement(locator);
                    isResult = true;
                    break;
                } catch (Exception ex) {
                }
                try {
                    Thread.sleep(smallTimeOut);
                    i++;
                } catch (Exception e) {

                }
            }
            if (!isResult) {
                AbstractService.sStatusCnt++;
            }
            return isResult;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not visible, try to waitForVisibleOfLocator by seconds.");
            return isResult;
        }
    }

    /**
     * @Description In order to wait element to be invisible by locator.
     */
    public boolean waitForInvisibleOfLocator(By by) {
        getLogger().info("Try to waitForInvisibleOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible.");
            return false;
        }
    }

    /**
     * @Description In order to wait element to be clickable by locator.
     */
    public boolean waitForClickableOfLocator(By by) {
        getLogger().info("Try to waitForClickableOfLocator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForClickableOfElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForClickableOfElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + element.getText());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible.
     */
    public void waitForClickableOfElement(WebElement element) {
        getLogger().info("Try to waitForClickableOfElement: " + element);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not clickable on Element: " + e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForInvisibleElement(WebElement element, String elementName) {
        getLogger().info("Try to waitForInvisibleElement: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Element is not invisible on Element: " + elementName);
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean validateDisabledElement(WebElement element, String elementName) {
        getLogger().info("verify disable of: " + elementName);
        try {
            if (!(element.isEnabled())) {
                getLogger().info(element.getTagName() + " is disabled");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(elementName + " is  not disabled");
            return false;
        }
    }



    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click
     * @Description: Click on element
     */
    public boolean clickElement(WebElement element, String elementName) {
        getLogger().info("Try to ClickElement: " + elementName);
        try {
            waitForClickableOfElement(element, "click to " + elementName);
            element.click();
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            System.out.println("exception: " + e.getMessage());
            getLogger().info("Unable to Click on: " + elementName);
            return false;
        }
    }

    /**
     * @Description: Click on element
     * @Author: minh.nguyen
     */
    public void clickElement(WebElement element) {
        getLogger().info("Try to ClickElement: " + element);
        try {
            waitForClickableOfElement(element);
            element.click();
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to Click on: " + e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click and hold
     * @Description: Click and Hold on element
     */
    public void clickAndHold(WebElement element, String elementName) {
        getLogger().info("Try to ClickAndHold: " + elementName);
        try {
            if (GenericService.sBrowserData.equals("chr.")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.click(element);
                actions.perform();
            } else
                element.click();
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to ClickAndHold on: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to hover to
     * @Description: Hover on element
     */
    public void hoverElement(WebElement element, String elementName) {
        getLogger().info("Try to hoverElement: " + elementName);
        try {
            if ((GenericService.sBrowserData).equals("chr.")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.build().perform();
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to hoverElement on: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param text        The content of text that we want to input.
     * @param elementName Name of element that we want to input value.
     * @Description: Send a String to textBox.
     * @Description: Send a String to textBox.
     */
    public boolean sendKeyTextBox(WebElement element, String text, String elementName) {
        getLogger().info("Try to sendKey on : " + elementName);
        try {
            waitForClickableOfElement(element, "wait for click to " + elementName);
            //element.click();
            element.clear();
            waitForClickableOfElement(element, "wait for click to " + elementName);
            element.sendKeys(text);
            return true;
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendKey on: " + elementName);
            getLogger().info(e);
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to input value.
     * @Description: Clear all Strings to textBox.
     * @Description: Clear all Strings to textBox.
     */
    public void clearTextBox(WebElement element, String elementName) {
        getLogger().info("Try to clear text on : " + elementName);
        try {
            element.clear();
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to clear on: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to click
     * @Description: Click on checkbox
     */
    public void clickOnCheckBox(WebElement element, String elementName) {
        getLogger().info("Try to click on checkbox: " + elementName);
        try {
            element.click();
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to click on checkbox element: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param selText     Visible text that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public boolean selectByVisibleText(WebElement element, String selText, String elementName) {
        getLogger().info("Try to selectByVisibleText on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selText);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param selValue    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectByValue(WebElement element, String selValue, String elementName) {
        getLogger().info("Try to selectByValue on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByValue(selValue);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * @param element     element defined on page class
     * @param selIndex    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectByIndex(WebElement element, int selIndex, String elementName) {
        getLogger().info("Try to selectByIndex on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByIndex(selIndex);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     * @Description: Send TabKey
     * @Description: Send TabKey
     */
    public void sendTabkey(WebElement element, String elementName) {
        getLogger().info("Try to sendTabkey: " + elementName);
        try {
            element.sendKeys(Keys.TAB);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendTabkey on: " + elementName);
        }
    }

    public void sendEnterkey(WebElement element, String elementName) {
        getLogger().info("Try to sendEnterkey: " + elementName);
        try {
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to sendEnterkey on: " + elementName);
        }
    }

    /**
     * @param element                element defined on page class
     * @param attributeName          Attribute that we want to validate
     * @param expectedAttributeValue Expected value that we want to validate
     */
    public boolean validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue) {
        getLogger().info("verify Attribute " + attributeName + " of: " + element.toString());
        String actualAttributeValue = null;
        try {
            actualAttributeValue = element.getAttribute(attributeName).trim();
            getLogger().info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
            if (actualAttributeValue.equals(expectedAttributeValue)) {
                getLogger().info(element.getTagName() + " has attribute " + actualAttributeValue);
                return true;
            } else {
                throw new Exception(String.format("Expected ['%s'] but found ['%s']", expectedAttributeValue, actualAttributeValue));
            }
        } catch (Exception e) {
            getLogger().info(e);
            AbstractService.sStatusCnt++;
            getLogger().info("Error: " + element.getTagName() + " has attribute not as expected with actual: " + actualAttributeValue);
            return false;
        }
    }

    /**
     * @param element        element defined on page class
     * @param attributeName  AttributeCSSS that we want to validate
     * @param attributeValue Expected value that we want to validate
     */
    public boolean validateCssValueElement(WebElement element, String attributeName, String attributeValue) throws InvalidElementStateException {
        getLogger().info("verify style with " + attributeName);
        try {
            getLogger().info("CurrentL: " + element.getCssValue(attributeName).trim());
            Assert.assertEquals(element.getCssValue(attributeName).trim(), attributeValue);
            return true;
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            return false;
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            return false;
        }

    }

    public boolean validateIsNotDisPlayedElement(WebElement element, String elementName) {
        getLogger().info("Verify element is not displayed of: " + elementName);
        try {
            if (!element.isDisplayed()) {
                return true;
            } else {
                AbstractService.sStatusCnt++;
                return false;

            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            return false;
        }

    }

    /**
     * @param eleGetText  Element defined in page class
     * @param elementName The text name of element
     * @return The text of web element
     */
    public String getTextByJavaScripts(WebElement eleGetText, String elementName) {
        getLogger().info("Get text by javascript of element " + elementName);
        String textOfElement = "";
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            textOfElement = (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;", eleGetText);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info(e.getMessage());
        }
        return textOfElement;
    }

    public void verifySortDataGrid(java.util.List<WebElement> elementRowValue, WebElement elementSortIcon) {
        try {
            java.util.List<String> listToDoTaskName = new ArrayList<String>();
            java.util.List<String> listSortedToDoTaskName;
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            listSortedToDoTaskName = listToDoTaskName;
            Collections.sort(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Ascending sort is NOT as expected");
            Collections.reverse(listSortedToDoTaskName);
            elementSortIcon.click();
            listToDoTaskName.clear();
            for (int i = 0; i < elementRowValue.size(); i++) {
                listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
            }
            Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Descending sort is NOT as expected");
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Cannot sort data on Data Grid View.");
        }
    }
    public enum Element_Type {
        DISPLAYED, ISENABLE, ISSELECTED, HIDDEN, TEXT_VALUE, NOT_EXIST
    }

    /**
     * Check properties of element
     *
     * @param webElement
     * @param expected
     * @param type
     */
    public void validateElememt(WebElement webElement, String expected, Element_Type type) {
        switch (type) {
            case DISPLAYED:
                try {
                    Assert.assertTrue(webElement.isDisplayed(), expected + " is not displayed.");
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISENABLE:
                try {
                    Assert.assertTrue(webElement.isEnabled(), expected + " is not enabled.");
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISSELECTED:
                try {
                    Assert.assertTrue(webElement.isSelected(), expected + " is not selected  ");
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                }
                break;
            case HIDDEN:
                try {
                    Assert.assertFalse(webElement.isDisplayed(), expected + " is not hidden.");
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                }
                break;
            case TEXT_VALUE:
                try {
                    Assert.assertEquals(getText(webElement), expected);
                } catch (NoSuchElementException e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    AbstractService.sStatusCnt++;
                    throw new AssertionError(e.getMessage());
                }
                break;
            case NOT_EXIST:
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                try {
                    webElement.click();
                    throw new AssertionError(expected + " is still displayed.");
                } catch (NoSuchElementException e) {
                }

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            default:
                break;
        }
    }

    public AbstractPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * @param url
     */
    public void getUrl(String url) {
        driver.get(url);
    }

    /**
     * Select option in select element by text
     *
     * @param webElement
     * @param item
     */
    public void selectOptionByText(WebElement webElement, String item, String elementName) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(item);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Select option in select element by value
     *
     * @param ele
     * @param val
     */
    public void selectOptionByValue(WebElement ele, String val) {
        try {
            Select select = new Select(ele);
            select.selectByValue(val);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Select option in select element by index
     *
     * @param ele
     * @param index
     */
    public void selectOptionByIndex(WebElement ele, int index) {
        try {
            Select select = new Select(ele);
            select.selectByIndex(index);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
        }
    }

    /**
     * Switch to other tab
     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
     *
     * @param tabIndex
     */
    public void switchToOtherTab(int tabIndex) {
        java.util.List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    /**
     * Get text value of element
     *
     * @param webElement
     * @return
     */
    public String getText(WebElement webElement) {
        if (webElement.getTagName().equals("input") || webElement.getTagName().equals("textarea"))
            return webElement.getAttribute("value");
        return webElement.getText();
    }

    /**
     * TODO
     * Execute javascript
     *
     * @param script
     * @return
     */
    public String executeJavascript(String script) {
        return "";
    }

    /**
     * @param webElement
     * @param timeOut
     */
    public void waitUtilElementClickable(WebElement webElement, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * @param webElement
     * @param timeOut
     * @param text
     */
    public void waitUtilTextPresent(WebElement webElement, long timeOut, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait Web Element is util hidden
     *
     * @param by
     * @param timeOut
     */
    public void waitUtilElementHidden(By by, long timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            AbstractService.sStatusCnt++;
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param IframeName
     */
    public void switchToFrame(String IframeName) {
        try {
            getLogger().info("Try to switch to iFrame: " + IframeName);
            driver.switchTo().frame(IframeName);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Unable to switch to iFrame: " + IframeName + "with error: " + e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param iFrameId
     */
    public void switchToFrame(int iFrameId) {
        try {
            getLogger().info("Try to switch to iFrame with id: " + iFrameId);
            driver.switchTo().frame(iFrameId);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Try to switch to iFrame with id: " + iFrameId + "with error: " + e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param eleFrame
     */
    public void switchToFrame(WebElement eleFrame) {
        try {
            getLogger().info("Try to switch to iFrame with WebElement: " + eleFrame);
            driver.switchTo().frame(eleFrame);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            getLogger().info("Try to switch to iFrame with WebElement: " + eleFrame + "with error: " + e.getMessage());
        }
    }

    /**
     * Verify CSS value of element
     *
     * @param webElement
     * @param cssName
     * @param expected
     */
    public void verifyCssValue(WebElement webElement, String cssName, String expected) {

        try {

            String actualValue = webElement.getCssValue(cssName);
            System.out.println("Actual CSS Value: " + actualValue);
            if (cssName.contains("color")) {
                actualValue = GenericService.parseRgbTohex(actualValue);
            }

            Assert.assertEquals(actualValue, expected);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Get css value of element:before
     *
     * @param element
     * @param cssType
     * @return
     */
    public void getValueCssOfBeforeElement(WebElement element, String cssType, String expectedResult) {
        try {
            WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
            String actual = ((JavascriptExecutor) driver)
                    .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('" + cssType + "');", parent).toString();
            Assert.assertEquals(actual, expectedResult);
        } catch (AssertionError e) {
            AbstractService.sStatusCnt++;
        }
    }

}
