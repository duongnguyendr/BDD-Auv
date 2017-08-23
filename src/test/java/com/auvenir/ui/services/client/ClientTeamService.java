package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.engagement.ClientTeamPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 04/08/2017.
 */
public class ClientTeamService extends AbstractService {

    private ClientTeamPage clientTeamPage;

    public ClientTeamService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientTeamPage = new ClientTeamPage(getLogger(), getDriver());
    }

    public void inviteNewMemberToTeam() {
        clientTeamPage.clickInviteNewMember();
    }

    public void chooseLeadClientWithTeamMemberName(String name) {
        clientTeamPage.chooseLeadWithTeamMemberName(name);
        clientTeamPage.confirmSetUserToLead();
    }

    public void verifyLeadSetByName(String name, String leadText) {
        clientTeamPage.verifyLeadSetByName(name, leadText);
    }
}
