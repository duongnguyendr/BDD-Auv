package com.auvenir.ui.pages.client.settings;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by cuong.nguyen on 4/26/2017.
 */
public class ClientDevicesSettingsPage extends AbstractPage {
    private static final int waitTime= 60;
    public ClientDevicesSettingsPage(Logger logger, WebDriver driver)
    {
        super(logger,driver);

    }
    @FindBy(xpath = "//div[contains(text(),'My Devices')]")
    private WebElement myDevicesTextEle;

    public void verifyDevicesSettingsPage() {
        waitForVisibleElement(myDevicesTextEle,"myDevicesTextEle");
    }
}
