package com.auvenir.ui.pages.client.engagement;

import com.auvenir.ui.pages.common.DetailsEngagementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 21/06/2017.
 */
public class ClientDetailsEngagementPage extends DetailsEngagementPage {

    public ClientDetailsEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyDetailsEngagementPage(String engagementName) {
        verifyDetailsEngagementPage(engagementName, false);
    }
}
