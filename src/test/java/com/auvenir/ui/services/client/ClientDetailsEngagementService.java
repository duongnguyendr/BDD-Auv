package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.engagement.ClientDetailsEngagementPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 21/06/2017.
 */
public class ClientDetailsEngagementService extends AbstractService {
    ClientDetailsEngagementPage clientDetailsEngagementPage;


    public ClientDetailsEngagementService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientDetailsEngagementPage = new ClientDetailsEngagementPage(logger, driver);
    }

    public void verifyDetailsEngagementPage(String engagementName) {
        clientDetailsEngagementPage.verifyDetailsEngagementPage(engagementName);
    }

    public void navigateToTeamTab() {
        clientDetailsEngagementPage.navigateToTeamTab();
    }
}
