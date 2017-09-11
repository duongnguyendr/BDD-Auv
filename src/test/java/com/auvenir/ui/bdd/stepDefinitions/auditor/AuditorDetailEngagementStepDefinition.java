package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorDetailsEngagementPage;
import cucumber.api.java.en.And;

/**
 * Created by duong.nguyen on 9/8/2017.
 */
public class AuditorDetailEngagementStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorDetailsEngagementPage auditorDetailsEngagementPage;
    public AuditorDetailEngagementStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorDetailsEngagementPage = new AuditorDetailsEngagementPage(logger, driver);
    }

    @And("^I click on team tab$")
    public void iClickOnTeamTab() throws Throwable{
        getLogger().info("I click on team tab");
        auditorDetailsEngagementPage.navigateToTeamTab();
    }

}
