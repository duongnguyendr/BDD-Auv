package com.auvenir.ui.bdd.stepDefinitions.auditor;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.auditor.AuditorTeamPage;
import cucumber.api.java.en.And;

/**
 * Created by duong.nguyen on 9/11/2017.
 */
public class AuditorTeamStepDefinition extends BaseInit {
    BaseInit baseInit;
    AuditorTeamPage auditorTeamPage;
    public AuditorTeamStepDefinition(BaseInit baseInit){
        this.baseInit = baseInit;
        auditorTeamPage = new AuditorTeamPage(logger, driver);
    }

    @And("^I delete existed member$")
    public void iDeleteExistedMember(){

    }
}
