package com.auvenir.ui.pages.client.settings;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by cuong.nguyen on 4/26/2017.
 * refactored partly by huy.huynh 23/06/2017
 */
public class ClientAccountSettingsPage extends AbstractPage {
    private static final int waitTime = 60;

    public ClientAccountSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Account Settings')]")
    private WebElement accountSettingsHeaderEle;

    public void verifyAccountSettingsPage() {
        getLogger().info("verifyAccountSettingsPage.");
        waitForVisibleElement(accountSettingsHeaderEle, "Account Settings Header");
    }
}
