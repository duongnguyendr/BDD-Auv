package com.auvenir.ui.bdd.pages;

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
        //super(driver);
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
    
    public AbstractPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    public static final int waitTime = 15;
    public static final int smallTimeOut = 1000;

    /**
     * @param webElement
     * @param elementName
     * @param waitTime
     */
    public void visibilityOfElementWait(WebElement webElement, String elementName, int waitTime) {
        try {
            getLogger().info("+++ Verify Element is visibility.");
            WebDriverWait sWebDriverWait = new WebDriverWait(driver, waitTime);
            sWebDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++ Element: "+elementName+" is not visibility.");
        }
    }

    /**
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
    public boolean validateElementText(WebElement webElement, String elementText) {
        try {
            getLogger().info("+++ Check rendered of text: " + elementText.trim());
            getLogger().info("+++++ Actual Text is displayed: " + getText(webElement).trim());
            Assert.assertEquals(getText(webElement).trim(), elementText.trim());
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            getLogger().info("+++++ Text of Element is not: "+elementText);
            return false;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Text of Element is not: "+elementText);
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
            getLogger().info(e.getMessage());
        }
        return resultWebElement;
    }

    /**
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public boolean validateDisPlayedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("+++ Verify Displayed of: " + elementName);
        try {
            element.isDisplayed();
            getLogger().info("+++++ Element : " + elementName + " is presented");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element : " + element + "is not presented");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */

    public boolean validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("+++ Verify enabled of: " + elementName);
        try {
            element.isEnabled();
            getLogger().info("+++++ Element : " + elementName + "is enable");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element : " + elementName + "is not enable.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("+++ Verify selected of: " + elementName);
        try {
            element.isSelected();
            getLogger().info("+++++ Element : " + element.getText() + "is selected.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element : " + element.getText() + "is not selected.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @throws InvalidElementStateException
     */
    public boolean validateNotSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
        getLogger().info("+++ Verify not selected of: " + elementName);
        try {
            if (!element.isSelected()) {
                getLogger().info("+++++ Element : " + element.getText() + "is not selected.");
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element : " + element.getText() + "is selected.");
            return false;
        }
    }

    public boolean validateMaxLength(WebElement webElement, String webElementName, int maxLength) {
        getLogger().info("Verify input with max length with " + maxLength + " characters");
        try {
            String inputTextWithMaxLength = randomCharacters(maxLength);
            clickElement(webElement, webElementName);
            clearTextBox(webElement, webElementName);
            webElement.sendKeys(inputTextWithMaxLength);
            String actualTextInput = webElement.getAttribute("value");
            Assert.assertEquals(actualTextInput, inputTextWithMaxLength, String.format("%s cannot input %d characters", webElementName, maxLength));
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
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

    public void scrollPageUp() {
        getLogger().info("+++ Scroll Page up.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_UP);
            robot.keyRelease(KeyEvent.VK_PAGE_UP);
            getLogger().info("+++++ Scroll Page up successfully.");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Scroll Page up unsuccessfully.");
        }
    }

    /*
    Method to scrollPageDown
     */
    public void scrollPageDown() {
        getLogger().info("+++ Scroll Page down.");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            getLogger().info("+++++ Scroll Page down successfully.");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Scroll Page down unsuccessfully.");
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForVisibleElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Visible Element: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            getLogger().info("+++++ Element: "+elementName+" is visible.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element: "+elementName+" is not visible.");
            getLogger().info(e);
            return false;
        }
    }

    /**
     * @Description In order to wait element to be present by locator.
     */
    public boolean waitForPresentOfLocator(By by) {
        getLogger().info("+++ Wait For Present Of Locator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            getLogger().info("+++++ Element is present.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not present.");
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible by locator.
     */
    public boolean waitForVisibleOfLocator(By by) {
        getLogger().info("+++ Wait For Visible Of Locator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            getLogger().info("+++++ Element is visible.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not visible.");
            return false;
        }
    }

    /**
     *
     * @Description In order to wait element to be visible by locator with seconds input.
     */
    public boolean waitForVisibleOfLocator(By locator, int seconds) {
        getLogger().info("+++ Wait For Visible Of Locator by seconds");
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
                getLogger().info("+++++ Element is not visible.");
            }
            return isResult;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not visible.");
            return isResult;
        }
    }

    /**
     * @Description In order to wait element to be invisible by locator.
     */
    public boolean waitForInvisibleOfLocator(By by) {
        getLogger().info("+++ Wait For Invisible Of Locator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            getLogger().info("+++++ Element is invisible.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not invisible.");
            return false;
        }
    }

    /**
     * @Description In order to wait element to be clickable by locator.
     */
    public boolean waitForClickableOfLocator(By by) {
        getLogger().info("+++ Wait For Clickable Of Locator");
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            getLogger().info("+++++ Element is clickable.");
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not clickable.");
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForClickableOfElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Clickable Of Element: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            getLogger().info("+++++ Element is clickable on Element: " + element.getText());
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not clickable on Element: " + element.getText());
            return false;
        }
    }

    /**
     * @Description In order to wait element to be visible.
     */
    public void waitForClickableOfElement(WebElement element) {
        getLogger().info("+++ Wait For Clickable Of Element: " + element);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            getLogger().info("+++++ Element is clickable on Element: ");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not clickable on Element: " + e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForInvisibleElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Invisible Element: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.invisibilityOf(element));
            getLogger().info("+++++ Element is invisible on Element: " + elementName);
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not invisible on Element: " + elementName);
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
            getLogger().info(e.getMessage());
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
        getLogger().info("+++ Click on Element: " + elementName);
        try {
            waitForClickableOfElement(element, "click to " + elementName);
            element.click();
            getLogger().info("+++++ Clicked on Element: " + elementName);
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            System.out.println("exception: " + e.getMessage());
            getLogger().info("+++++ Unable to Click on: " + elementName);
            return false;
        }
    }

    /**
     * @Description: Click on element
     * @Author: minh.nguyen
     */
    public void clickElement(WebElement element) {
        getLogger().info("+++ Click on Element: " + element);
        try {
            waitForClickableOfElement(element);
            element.click();
            getLogger().info("+++++ Clicked on element");
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to Click on Element: " + e.getMessage());
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click and hold
     * @Description: Click and Hold on element
     */
    public void clickAndHold(WebElement element, String elementName) {
        getLogger().info("+++ Click And Hold: " + elementName);
        try {
            if (GenericService.sBrowserData.equals("chr.")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.click(element);
                actions.perform();
            } else {
                element.click();
            }
            getLogger().info("+++++ Click And Hold on: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to ClickAndHold on: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to hover to
     * @Description: Hover on element
     */
    public void hoverElement(WebElement element, String elementName) {
        getLogger().info("+++ Hover on Element: " + elementName);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.build().perform();
            getLogger().info("+++++ Hovered on Element: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to hoverElement on: " + elementName);
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
        getLogger().info("+++ SendKey on : " + elementName);
        try {
            waitForClickableOfElement(element, "wait for click to " + elementName);
            //element.click();
            element.clear();
            waitForClickableOfElement(element, "wait for click to " + elementName);
            element.sendKeys(text);
            getLogger().info("+++++ Sent KeyValue on: " + elementName);
            return true;
        } catch (Exception e) {
            getLogger().info(e);
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to sendKey on: " + elementName);
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
        getLogger().info("+++ Clear text on : " + elementName);
        try {
            element.clear();
            getLogger().info("+++++ Cleared on: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to clear on: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to click
     * @Description: Click on checkbox
     */
    public void clickOnCheckBox(WebElement element, String elementName) {
        getLogger().info("+++ Click on checkbox: " + elementName);
        try {
            element.click();
            getLogger().info("+++ Clicked on checkbox: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to click on checkbox element: " + elementName);
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
        getLogger().info("+++ Select By VisibleText on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selText);
            getLogger().info("+++++ Selected By VisibleText on element: " + elementName);
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to Select By VisibleText on element: " + elementName);
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
        getLogger().info("+++ Select By Value on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByValue(selValue);
            getLogger().info("+++++ Selected By Value on element: " + elementName);
        } catch (Exception e) {
            getLogger().info("+++++ Selected By Value on element: " + elementName);
            getLogger().info(e.getMessage());
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
        getLogger().info("+++ Select By Index on element: " + elementName);
        try {
            Select dropDown = new Select(element);
            dropDown.selectByIndex(selIndex);
            getLogger().info("+++++ Selected By Index on element: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ unable to select By Index on element: " + elementName);
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     * @Description: Send TabKey
     * @Description: Send TabKey
     */
    public void sendTabKey(WebElement element, String elementName) {
        getLogger().info("+++ Send TabKey on Element " + elementName);
        try {
            element.sendKeys(Keys.TAB);
            getLogger().info("+++++ Sent TabKey on Element " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to send Tab key on: " + elementName);
        }
    }

    public void sendEnterKey(WebElement element, String elementName) {
        getLogger().info("+++ Send Enter Key: " + elementName);
        try {
            element.sendKeys(Keys.ENTER);
            getLogger().info("+++++ Sent Enter Key: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to sendEnterkey on: " + elementName);
        }
    }

    /**
     * @param element                element defined on page class
     * @param attributeName          Attribute that we want to validate
     * @param expectedAttributeValue Expected value that we want to validate
     */
    public boolean validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue) {
        getLogger().info("+++ Verify Attribute " + attributeName + " of: " + element.toString());
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
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Error: " + element.getTagName() + " has attribute not as expected with actual: " + actualAttributeValue);
            return false;
        }
    }

    /**
     * @param element        element defined on page class
     * @param attributeName  AttributeCSSS that we want to validate
     * @param attributeValue Expected value that we want to validate
     */
    public boolean validateCssValueElement(WebElement element, String attributeName, String attributeValue) throws InvalidElementStateException {
        getLogger().info("+++ Verify style with " + attributeName);
        try {
            getLogger().info("CurrentL: " + element.getCssValue(attributeName).trim());
            Assert.assertEquals(element.getCssValue(attributeName).trim(), attributeValue);
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Validate CSS Value Element is not correct.");
            return false;
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ CSS Value Element is not correct.");
            return false;
        }

    }

    public boolean validateIsNotDisPlayedElement(WebElement element, String elementName) {
        getLogger().info("+++ Verify element is not displayed of: " + elementName);
        try {
            if (!element.isDisplayed()) {
                return true;
            } else {
                getLogger().info("+++++ Element is not displayed.");
                return false;
            }
        } catch (Exception e) {
            getLogger().info("+++++ Element is not displayed.");
            getLogger().info(e.getMessage());
            return false;
        }

    }

    /**
     * @param eleGetText  Element defined in page class
     * @param elementName The text name of element
     * @return The text of web element
     */
    public String getTextByJavaScripts(WebElement eleGetText, String elementName) {
        getLogger().info("+++ Get text by javascript of element " + elementName);
        String textOfElement = "";
        try {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            textOfElement = (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].value;", eleGetText);
            getLogger().info("+++++ Text of element: " + elementName + textOfElement);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to get text of element: " + elementName + textOfElement);
        }
        return textOfElement;
    }

    public void verifySortDataGrid(java.util.List<WebElement> elementRowValue, WebElement elementSortIcon) {
        try {
            getLogger().info("+++ Verify Sort Data Grid: "+elementSortIcon);
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
            getLogger().info("++++ Verified Sort Data Grid: "+elementSortIcon);
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to sort data on Data Grid View.");
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
        getLogger().info("+++++ Validate Element with: "+ type);
        switch (type) {
            case DISPLAYED:
                try {
                    Assert.assertTrue(webElement.isDisplayed(), expected + " is not displayed.");
                } catch (NoSuchElementException e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISENABLE:
                try {
                    Assert.assertTrue(webElement.isEnabled(), expected + " is not enabled.");
                } catch (NoSuchElementException e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case ISSELECTED:
                try {
                    Assert.assertTrue(webElement.isSelected(), expected + " is not selected  ");
                } catch (NoSuchElementException e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case HIDDEN:
                try {
                    Assert.assertFalse(webElement.isDisplayed(), expected + " is not hidden.");
                } catch (NoSuchElementException e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                }
                break;
            case TEXT_VALUE:
                try {
                    Assert.assertEquals(getText(webElement), expected);
                } catch (NoSuchElementException e) {
                    getLogger().info(e.getMessage());
                    throw new AssertionError(e.getMessage());
                } catch (AssertionError e) {
                    getLogger().info(e.getMessage());
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

    /**
     * Method togo to URL
     * @param url
     */
    public void getUrl(String url) {
        getLogger().info("+++ Navigate to URL: "+ url);
        try{
            driver.get(url);
            getLogger().info("+++++ Navigated to URL: "+url);
        }catch (Exception e){
            getLogger().info(e.getMessage());
            getLogger().info("++++ Unable to navigate to URL: "+url);
        }
    }

    /**
     * Select option in select element by text
     *
     * @param webElement
     * @param item
     */
    public void selectOptionByText(WebElement webElement, String item, String elementName) {
        getLogger().info("+++ Select option: "+elementName+ "by Text: "+ item);
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(item);
            getLogger().info("+++++ Selected option: "+elementName+" option: "+item);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to select option: "+elementName+" option: "+item);
        }
    }

    /**
     * Select option in select element by value
     *
     * @param ele
     * @param val
     */
    public void selectOptionByValue(WebElement ele, String val) {
        getLogger().info("+++ Select option: "+ele+ "by value: "+ val);
        try {
            Select select = new Select(ele);
            select.selectByValue(val);
            getLogger().info("+++++ Selected option: "+ele+ "by value: "+ val);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to Select option: "+ele+ "by value: "+ val);
        }
    }

    /**
     * Select option in select element by index
     *
     * @param ele
     * @param index
     */
    public void selectOptionByIndex(WebElement ele, int index) {
        getLogger().info("+++ Select option: "+ele+ "by index: "+ index);
        try {
            Select select = new Select(ele);
            select.selectByIndex(index);
            getLogger().info("+++++ Select option: "+ele+ "by index: "+ index);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Select option: "+ele+ "by index: "+ index);

        }
    }

    /**
     * Switch to other tab
     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
     *
     * @param tabIndex
     */
    public void switchToOtherTab(int tabIndex) {
        getLogger().info("+++ Switch to tab: "+ tabIndex);
        try {
            java.util.List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            getLogger().info("+++++ Switched to tab: "+ tabIndex);
        }catch (Exception e){
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to Switch to tab: "+ tabIndex);
        }
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
        getLogger().info("+++ Wait util Element: " +webElement+" clickable.");
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            getLogger().info("+++++ Element: " +webElement+" is clickable.");

        } catch (TimeoutException e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element: " +webElement+" is not clickable.");
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * @param webElement
     * @param timeOut
     * @param text
     */
    public void waitUtilTextPresent(WebElement webElement, long timeOut, String text) {
        getLogger().info("+++ Wait util Element: " +webElement+" present.");
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
            getLogger().info("+++++ Element: " +webElement+" is present.");
        } catch (TimeoutException e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element: " +webElement+" is not present.");
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
        getLogger().info("+++ Wait util Element is hidden.");
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            getLogger().info("+++++ Element is hidden.");

        } catch (TimeoutException e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Element is not hidden.");
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Switch to other frame
     *
     * @param IframeName
     */
    public void switchToFrame(String IframeName) {
        getLogger().info("+++ Switch to iFrame: " + IframeName);
        try {
            driver.switchTo().frame(IframeName);
            getLogger().info("+++++ Switched to iFrame: " + IframeName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to switch to iFrame: " + IframeName);
        }
    }

    /**
     * Switch to other frame
     *
     * @param iFrameId
     */
    public void switchToFrame(int iFrameId) {
        getLogger().info("+++ Switch to iFrame with id: " + iFrameId);
        try {
            driver.switchTo().frame(iFrameId);
            getLogger().info("+++++ Switch to iFrame with id: " + iFrameId);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Try to switch to iFrame with id: " + iFrameId);
        }
    }

    /**
     * Switch to other frame
     *
     * @param eleFrame
     */
    public void switchToFrame(WebElement eleFrame) {
        getLogger().info("+++ Switch to iFrame with WebElement: " + eleFrame);
        try {
            driver.switchTo().frame(eleFrame);
            getLogger().info("+++++ Switched to iFrame with WebElement: " + eleFrame);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to switch to iFrame with WebElement: " + eleFrame);
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
        getLogger().info("+++ Verify CSS value: "+ cssName+ " of Element: "+ webElement);
        try {
            String actualValue = webElement.getCssValue(cssName);
            System.out.println("Actual CSS Value: " + actualValue);
            if (cssName.contains("color")) {
                actualValue = GenericService.parseRgbTohex(actualValue);
            }
            Assert.assertEquals(actualValue, expected);
            getLogger().info("+++++ Verified CSS value: "+ cssName+ " of Element: "+ webElement);
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ CSS value: "+ cssName+ " of Element: "+ webElement+" is not equal to "+ expected);
            throw new AssertionError(e.getMessage());
        }catch (Exception e){
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to verify CSS Value"+ webElement);
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
        getLogger().info("+++ Get CSS value: "+ cssType+ " of Element: "+ element);
        try {
            WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
            String actual = ((JavascriptExecutor) driver)
                    .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('" + cssType + "');", parent).toString();
            Assert.assertEquals(actual, expectedResult);
            getLogger().info("+++++ Got CSS value: "+ cssType+ " of Element: "+ element);
        } catch (AssertionError e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to get CSS value.");
        }
    }

}
