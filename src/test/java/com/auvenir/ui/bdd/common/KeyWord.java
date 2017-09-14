package com.auvenir.ui.bdd.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by doai.tran on 8/21/2017.
 */
public class KeyWord {
    private Logger logger = null;
    private WebDriver driver = null;

    public KeyWord(Logger logger, WebDriver driver) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }

    public static final int waitTime = 15;
    public static final int smallTimeOut = 1000;


    /*************** Waiting Element function ( Ex: Wait for clickable, wait for visible,... ******************/

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public void waitForVisibleElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Visible Element: " + elementName);
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * @Description In order to wait element to be present by locator.
     */
    public void waitForPresentOfLocator(By by) {
        getLogger().info("+++ Wait For Present Of Locator");
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * @Description In order to wait element to be visible by locator.
     */
    public void waitForVisibleOfLocator(By by) {
        getLogger().info("+++ Wait For Visible Of Locator");
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
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
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public void waitForClickableOfElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Clickable Of Element: " + elementName);
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public void waitForInvisibleElement(WebElement element, String elementName) {
        getLogger().info("+++ Wait For Invisible Element: " + elementName);
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    /**
     * @param webElement
     * @param timeOut
     * @param text
     */
    public void waitUtilTextPresent(WebElement webElement, long timeOut, String text) {
        getLogger().info("+++ Wait util Element: " + webElement + " present.");
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /*
Method to wait Ajax function on Site be loaded successfully.
*/
    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public void waitSomeSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex) {
            ex.printStackTrace();
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
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Author: Thuan Duong.
     *
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to change Attribute value.
     */
    public boolean waitForAtrributeValueChanged(WebElement element, String elementName, String attributeName,
                                                String attributeValue) {
        getLogger().info("Try to waitForAtrributeValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualAttributeValue = null;
                    if (element.getAttribute(attributeName) != null) {
                        actualAttributeValue = element.getAttribute(attributeName);
                        System.out.println("Actual Displayed Value: " + actualAttributeValue);
                    } else {
                        getLogger().info(String.format("Attribute %s is null", attributeName));
                        return false;
                    }
                    if (actualAttributeValue.equals(attributeValue))
                        return true;
                    else
                        return false;
                }
            });
            return true;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            return false;
        }
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to verify
     * @Description In order to wait element to be visible.
     */
    public boolean waitForCssValueChanged(WebElement element, String elementName, String cssName, String cssValue) {
        getLogger().info("Try to waitForCssValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualcssValue = element.getCssValue(cssName);
                    System.out.println("Actual Displayed Value: " + actualcssValue);
                    if (actualcssValue.equals(cssValue))
                        return true;
                    else
                        return false;
                }
            });
            return true;
        } catch (Exception e) {
            getLogger().info("CSS Value is not changed");
            return false;
        }
    }

    public boolean waitForTextValueChanged(WebElement element, String elementName, String textValue) {
        getLogger().info("Try to waitForTextValueChanged: " + elementName);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    String actualTextValue = element.getText().trim();
                    System.out.println("Actual Displayed Value: " + actualTextValue);
                    System.out.println("Expected Displayed Value: " + textValue);
                    if (actualTextValue.equals(textValue))
                        return true;
                    else
                        return false;
                }
            });
            getLogger().info("Text Value of element '%s' is changed to '%s' "+elementName +" " +textValue);
            return true;
        } catch (Exception e) {
            getLogger().info("CSS Value is not changed");
            getLogger().info("Text Value of element '%s' is NOT changed "+ elementName);
            return false;
        }
    }


    /************ Validate Element function ( Ex: validateElementText, validateDisPlayedElement,... ***************/

    /**
     * @param webElement  WebElement
     * @param elementText Text of Element be presented.
     */
    public boolean validateElementText(WebElement webElement, String elementText) {
        getLogger().info("+++ Check rendered of text: " + elementText.trim());
        try {
            getLogger().info("+++ Check rendered of text: " + elementText.trim());
            getLogger().info("+++++ Actual Text is displayed: " + getText(webElement).trim());
            Assert.assertEquals(getText(webElement).trim(), elementText.trim());
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
            getLogger().info("+++++ Text of Element is not: " + elementText);
            return false;
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Text of Element is not: " + elementText);
            return false;
        }
    }

    /**
     * @param element
     * @throws InvalidElementStateException
     * @elementName Name of element that we want to verify
     */
    public boolean validateDisPlayedElement(WebElement element,
                                            String elementName) throws InvalidElementStateException {
        getLogger().info("+++ Verify Displayed of: " + elementName);
        element.isDisplayed();
        getLogger().info("+++++ Element : " + elementName + " is presented");
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
    public boolean validateNotSelectedElement(WebElement element,
                                              String elementName) throws InvalidElementStateException {
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
            Assert.assertEquals(actualTextInput, inputTextWithMaxLength,
                    String.format("%s cannot input %d characters", webElementName, maxLength));
            return true;
        } catch (AssertionError error) {
            getLogger().info(error);
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
                throw new Exception(String.format("Expected ['%s'] but found ['%s']", expectedAttributeValue,
                        actualAttributeValue));
            }
        } catch (Exception e) {
            getLogger().info(e);
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Error: " + element
                    .getTagName() + " has attribute not as expected with actual: " + actualAttributeValue);
            return false;
        }
    }

    /**
     * @param element        element defined on page class
     * @param attributeName  AttributeCSSS that we want to validate
     * @param attributeValue Expected value that we want to validate
     */
    public boolean validateCssValueElement(WebElement element, String attributeName,
                                           String attributeValue) throws InvalidElementStateException {
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
     * Check properties of element
     *
     * @param webElement
     * @param expected
     * @param type
     */
    public void validateElememt(WebElement webElement, String expected, Element_Type type) {
        getLogger().info("+++++ Validate Element with: " + type);
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
     * validate if attribute contain given value
     *
     * @param webElement  element need to validate
     * @param attribute   attribute name
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public boolean validateAttributeContain(WebElement webElement, String attribute, String value, String elementName) {
        try {
            getLogger().info("Validate Style Attribute Exist " + elementName);
            if (webElement.getAttribute(attribute).contains(value)) {
                getLogger().info(value + " exist on " + attribute + " on element: " + elementName);
                return true;
            } else {
                Assert.fail(value + " still exist on " + attribute + " on element: " + elementName);
                return false;
            }
        } catch (NoSuchElementException e) {
            getLogger().info(e.getMessage());
            Assert.fail("Error: " + elementName + " is not exist.");
            return false;
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            Assert.fail("Error: Validate attribute contain " + elementName);
            return false;
        }
    }

    /**
     * validate text contain given value
     *
     * @param webElement  element need to validate
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateElementTextContain(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate Element Text Contain " + elementName);
            System.out.println("expected = " + value);
            System.out.println("actualll = " + webElement.getText());
            if (webElement.getText().contains(value)) {
                getLogger().info(elementName + "'s text contain: " + value);
            } else {
                Assert.fail(elementName + "'s text contain: " + value);
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            Assert.fail("Error: Validate text contain " + elementName);
        }
    }

    public boolean validateNotExistedElement(WebElement element, String elementName) {
        try {
            getLogger().info("Try to validate Element is not existed.");
            getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            element.click();
            element.getText();
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        } catch (NoSuchElementException e) {
            getLogger().info("Element is not existed.");
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        } catch (ElementNotVisibleException e) {
            getLogger().info("Element is visible.");
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        } catch (IndexOutOfBoundsException outEx) {
            getLogger().info("List element is empty.");
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            getLogger().info("Element is still displayed.");
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }

    /**
     * validate element list size equal
     *
     * @param elements    list element
     * @param quantity    Expected quantity
     * @param elementName Element name
     */
    public void validateElementsQuantity(List<WebElement> elements, int quantity, String elementName) {
        try {
            getLogger().info("Validate elements quantity" + elementName);
            if (elements.size() == quantity) {
                getLogger().info(elementName + " quantity equal: " + quantity);
            } else {
                Assert.fail(elementName + " quantity not equal: [Expected]= " + quantity + " /[Actual]= " + elements
                        .size());
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * validate placeholder text
     *
     * @param webElement  element need to validate
     * @param value       Expected placeholder text
     * @param elementName Element name
     */
    public void validatePlaceholder(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate placeholder " + elementName);
            if (webElement.getAttribute("placeholder").equals(value)) {
                getLogger().info(elementName + " placeholder equal: " + value);
            } else {
                Assert.fail(elementName + " placeholder not equal: [Expected]= " + value + " /[Actual]= " + webElement
                        .getAttribute("placeholder"));
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * validate if attribute not contain given value
     *
     * @param webElement  element need to validate
     * @param attribute   attribute name
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateAttributeNotContain(WebElement webElement, String attribute, String value, String elementName) {
        try {
            getLogger().info("Validate Style Attribute Not Exist " + elementName);
            if (!webElement.getAttribute(attribute).contains(value)) {
                getLogger().info(value + " not exist on " + attribute + " on element: " + elementName);
            } else {
                Assert.fail(value + " not exist on " + attribute + " on element: " + elementName);
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    /**
     * validate text get by JS contain given value
     *
     * @param webElement  element need to validate
     * @param value       Expected attribute value
     * @param elementName Element name
     */
    public void validateElementJavaScriptTextContain(WebElement webElement, String value, String elementName) {
        try {
            getLogger().info("Validate Element JavaScript Text Contain " + elementName);
            if (getTextByJavaScripts(webElement, elementName).contains(value)) {
                getLogger().info(elementName + "'s JavaScript text contain: " + value);
            } else {
                Assert.fail(elementName + "'s JavaScript text contain: " + value);
            }
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
    }

    public boolean validateExistedElement(WebElement element, String elementName) {
        try {
            getLogger().info("Validating " + elementName + " is existed.");
            element.getText();
            return true;
        } catch (NoSuchElementException e) {
            getLogger().info(elementName + " is not existed.");
            return false;
        } catch (ElementNotVisibleException e) {
            getLogger().info(elementName + " is visible.");
            return false;
        } catch (IndexOutOfBoundsException outEx) {
            getLogger().info("List " + elementName + " is empty.");
            return false;
        } catch (Exception e) {
            getLogger().info("Error: Finding " + elementName + " error.");
            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }

    public static void toValidate(WebElement element, String sExpectedText,
                                  String checkType) throws InvalidElementStateException {
        System.out.println("verify present of: " + sExpectedText);
        switch (checkType) {
            case "Displayed":
                try {
                    element.isDisplayed();
                } catch (Exception e) {
                }

                break;
            case "Enabled":
                try {
                    element.isEnabled();
                } catch (Exception e) {
                }

                break;
            case "Selected":
                try {
                    element.isSelected();
                } catch (Exception e) {
                }

            case "ElementText":
                try {
                    element.getText().equals(sExpectedText);
                } catch (Exception e) {
                }
                break;
        }
    }


    /************ Select an option in Select Dropdown Element  ***************/

    /**
     * @param element     element defined on page class
     * @param selText     Visible text that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectOptionByText(WebElement element, String selText, String elementName) {
        getLogger().info("+++ Select By VisibleText on element: " + elementName);
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(selText);
    }

    /**
     * @param element     element defined on page class
     * @param selValue    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectOptionByValue(WebElement element, String selValue, String elementName) {
        getLogger().info("+++ Select By Value on element: " + elementName);
        Select dropDown = new Select(element);
        dropDown.selectByValue(selValue);
    }

    /**
     * @param element     element defined on page class
     * @param selIndex    Value that you want to select on dropdown
     * @param elementName checkbox name
     * @Description: select a value on dropdown via visible text
     * @Description: select a value on dropdown via visible text
     */
    public void selectOptionByIndex(WebElement element, int selIndex, String elementName) {
        getLogger().info("+++ Select By Index on element: " + elementName);
        Select dropDown = new Select(element);
        dropDown.selectByIndex(selIndex);
    }




    /**
     * @param xpathElement
     * @return Web element by xpath
     */
    public WebElement findWebElementByXpath(String xpathElement) {
        WebElement resultWebElement = null;
        getLogger().info("The xpath of web element = " + xpathElement);
        resultWebElement = getDriver().findElement(By.xpath(xpathElement));
        return resultWebElement;
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
     * @param elementName Name of element that we want to click
     * @Description: Click on element
     */
    public void clickElement(WebElement element, String elementName) {
        getLogger().info("+++ Click on Element: " + elementName);
        waitForClickableOfElement(element, elementName);
        element.click();

    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to click and hold
     * @Description: Click and Hold on element
     */
    public void clickAndHold(WebElement element, String elementName) {
        getLogger().info("+++ Click And Hold: " + elementName);
        if (Generic.sBrowserData.equals("chr.")) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click(element);
            actions.perform();
        } else {
            element.click();
        }

    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to hover to
     * @Description: Hover on element
     */
    public void hoverElement(WebElement element, String elementName) {
        getLogger().info("+++ Hover on Element: " + elementName);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.build().perform();

    }

    /**
     * @param element     element defined on page class
     * @param text        The content of text that we want to input.
     * @param elementName Name of element that we want to input value.
     * @Description: Send a String to textBox.
     * @Description: Send a String to textBox.
     */
    public void sendKeyTextBox(WebElement element, String text, String elementName) {
        getLogger().info("+++ SendKey on : " + elementName);
        waitForClickableOfElement(element, "wait for click to " + elementName);
        element.clear();
        waitForClickableOfElement(element, "wait for click to " + elementName);
        element.sendKeys(text);
    }

    /**
     * @param element     element defined on page class
     * @param elementName Name of element that we want to input value.
     * @Description: Clear all Strings to textBox.
     * @Description: Clear all Strings to textBox.
     */
    public void clearTextBox(WebElement element, String elementName) {
        getLogger().info("+++ Clear text on : " + elementName);
        element.clear();
    }



    /**
     * @param element     element defined on page class
     * @param elementName Name of element: CheckBox that we want to Send TabKey
     * @Description: Send TabKey
     * @Description: Send TabKey
     */
    public void sendTabKey(WebElement element, String elementName) {
        getLogger().info("+++ Send TabKey on Element " + elementName);
        element.sendKeys(Keys.TAB);
    }

    public void sendEnterKey(WebElement element, String elementName) {
        getLogger().info("+++ Send Enter Key: " + elementName);
        element.sendKeys(Keys.ENTER);
        try {
            element.sendKeys(Keys.ENTER);
            getLogger().info("+++++ Sent Enter Key: " + elementName);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to sendEnterkey on: " + elementName);
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
            textOfElement = (String) ((JavascriptExecutor) getDriver())
                    .executeScript("return arguments[0].value;", eleGetText);
            getLogger().info("+++++ Text of element: " + elementName + textOfElement);
        } catch (Exception e) {
            getLogger().info(e.getMessage());
            getLogger().info(e.getMessage());
            getLogger().info("+++++ Unable to get text of element: " + elementName + textOfElement);
        }
        return textOfElement;
    }

    public void verifySortDataGrid(java.util.List<WebElement> elementRowValue, WebElement elementSortIcon) {
        getLogger().info("+++ Verify Sort Data Grid: " + elementSortIcon);
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
        getLogger().info("++++ Verified Sort Data Grid: " + elementSortIcon);
    }

    public enum Element_Type {
        DISPLAYED, ISENABLE, ISSELECTED, HIDDEN, TEXT_VALUE, NOT_EXIST
    }


    /**
     * Method togo to URL
     *
     * @param url
     */
    public void getUrl(String url) {
        getLogger().info("+++ Navigate to URL: " + url);
        driver.get(url);
    }

    /**
     * Switch to other tab
     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
     *
     * @param tabIndex
     */
    public void switchToOtherTab(int tabIndex) {
        getLogger().info("+++ Switch to tab: " + tabIndex);
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
     * Switch to other frame
     *
     * @param IframeName
     */
    public void switchToFrame(String IframeName) {
        getLogger().info("+++ Switch to iFrame: " + IframeName);
        driver.switchTo().frame(IframeName);

    }

    /**
     * Switch to other frame
     *
     * @param iFrameId
     */
    public void switchToFrame(int iFrameId) {
        getLogger().info("+++ Switch to iFrame with id: " + iFrameId);
        driver.switchTo().frame(iFrameId);

    }

    /**
     * Switch to other frame
     *
     * @param eleFrame
     */
    public void switchToFrame(WebElement eleFrame) {
        getLogger().info("+++ Switch to iFrame with WebElement: " + eleFrame);
        driver.switchTo().frame(eleFrame);

    }

    /**
     * get element which cant use @FindBy to find
     *
     * @param xpath xpath to get element
     * @param arg   vararg for formating
     */
    public WebElement getElementByXpath(String xpath, String... arg) {
        WebElement webElement = null;
        xpath = String.format(xpath, arg);
        try {
            webElement = getDriver().findElement(By.xpath(xpath));
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
        }
        return webElement;
    }


    public int findElementByText(java.util.List<WebElement> listElement, String textValue) {
        try {
            String actualTextValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualTextValue = listElement.get(i).getText().trim();
                if (actualTextValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    return i;
                }
            }
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;

        } catch (Exception e) {
            getLogger().info(String.format("Cannot find the text name: %s", textValue));
            return -1;
        }
    }

    /**
     * Scroll to footer of current page
     * TODO: duplicating with scrollToFooter on AbstractService, find solution later
     */
    public void scrollToFooter() {
        getLogger().info("Scroll down to see page footer.");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Find the index(position) of Web Element in the list Web Element by attribute value
     *
     * @param listElement   List WebElement
     * @param textValue     String text which is compared with each WebElements.
     * @param attributeName String attributeName which attribute will be found with get Attribute method.
     * @return i if the WebElement is matched, otherwise return -1.
     */
    public int findElementByAttribute(List<WebElement> listElement, String textValue, String attributeName) {
        try {
            String actualAttributeValue;
            for (int i = 0; i < listElement.size(); i++) {
                actualAttributeValue = listElement.get(i).getAttribute(attributeName).trim();
                if (actualAttributeValue.equals(textValue)) {
                    getLogger().info("Element is found at " + i);
                    getLogger().info(String.format("The position of the text name '%s' at %d", textValue, i));
                    return i;
                }
            }
            Assert.fail(String.format("Cannot find the text name: %s", textValue));
            return -1;

        } catch (Exception e) {
            Assert.fail(String.format("Cannot find the text name: %s", textValue));
            return -1;
        }
    }

    public String getDate(int day) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d/yyyy");
        return simpleDateFormat.format(date.getTime());
    }

    public static boolean checkFileExists(String pathLocation, boolean deleteExisted) {
        Path path = Paths.get(pathLocation);
        System.out.println("file: " + path);
        boolean result = false;
        try {
            if (Files.exists(path)) {
                result = true;
                if (deleteExisted) {
                    Files.delete(path);
                    if (Files.exists(path)) {
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void chooseFirstOptionOfInputSelect(List<WebElement> list, String elementName) {
        // Change the first Item to Third Item
        clickElement(list.get(0), elementName);
    }

    /**
     * Added by huy.huynh on 12/06/2017.
     * check element on dev-branch
     */
    /**
     * @param webElement  Element defined in page class
     * @param elementName The text name of element
     */
    public void clickByJavaScripts(WebElement webElement, String elementName) throws Exception {
        getLogger().info("Click by javascript of element " + elementName);
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", webElement);
    }

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
            logger.info(e.getMessage());
        }
    }
}
