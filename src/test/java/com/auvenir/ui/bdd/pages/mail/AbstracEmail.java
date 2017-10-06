package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstracEmail extends CommonPage {
    public AbstracEmail(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public abstract void signInEmail(String email, String password);
    public abstract void goEMail();
    public abstract void selectActiveEmail();
    public abstract void clickOnboardingInvitationLink();
    public abstract void clickGetStartedButton();
    public abstract void emailLogout()throws Exception;
    public abstract void navigateToConfirmationLink()throws Exception;
    public abstract void reSignInEmail(String email,String password)throws Exception ;
    public abstract void deleteAllExistedEmail(String email, String ePassword) throws Exception;

}
