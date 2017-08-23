package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.engagement.ClientTeamPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 7/19/2017.
 */
public class ClientEngagementTeamService extends AbstractService {
    /**
     * Updated by Minh.Nguyen on June 19, 2017
     *
     * @param logger
     * @param driver
     */
    private ClientTeamPage clientEngagementTeamPage;

    public ClientEngagementTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientEngagementTeamPage = new ClientTeamPage(getLogger(), getDriver());
    }


    public void removeAdminClient(String adminFullName) {
        clientEngagementTeamPage.removeTeamMember(adminFullName);
    }

    public void verifyMessageFromRemovingAdminClient(String successMessage) {
        clientEngagementTeamPage.verifyMessageFromRemovingTeamMember(successMessage);
    }

    public void verifyRemoveAdminClient(String adminFullName) {
        clientEngagementTeamPage.verifyRemoveTeamMember(adminFullName);
    }
}
