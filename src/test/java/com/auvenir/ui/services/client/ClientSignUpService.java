package com.auvenir.ui.services.client;

import com.auvenir.ui.pages.client.general.ClientSignUpPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 14/06/2017.
 */
public class ClientSignUpService extends AbstractService {
    private ClientSignUpPage clientSignUpPage;

    public ClientSignUpService(Logger logger, WebDriver driver) {
        super(logger, driver);
        clientSignUpPage = new ClientSignUpPage(getLogger(), getDriver());
    }

    public void navigateToSignUpForm() {
        clientSignUpPage.verifyWelcomePageTitle();
        clientSignUpPage.clickGetStartedButton();
    }

    public void fillUpPersonalForm(String phoneNumber) {
        clientSignUpPage.fillUpPersonalForm(phoneNumber);
    }

    public void fillUpPersonalFormOfAuditorPage(String phoneNumber){
        clientSignUpPage.fillUpPersonalFormOfAuditorPage(phoneNumber);
    }

    public void fillUpFirmPage(String affiliatedTxt){
        clientSignUpPage.fillUpFirmPage(affiliatedTxt);
    }

    public void fillUpBusinessForm(String parentStakeholders) {
        clientSignUpPage.fillUpBusinessForm(parentStakeholders);
    }

    public void fillUpBankForm() {
        clientSignUpPage.fillUpBankForm();
    }

    public void fillUpFileForm() {
        clientSignUpPage.fillUpFileForm();
    }

    public void fillUpSecurityForm(String password) {
        clientSignUpPage.fillUpSecurityForm(password);
    }
}
