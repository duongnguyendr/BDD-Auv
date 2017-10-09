package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 28/09/2017.
 */
public class MailPage extends CommonPage {
    private AbstracEmail mail;

    public MailPage(Logger logger, WebDriver driver, String email) {
        super(logger, driver);
        if (email.trim().toLowerCase().contains("@gmail.com")) {
            this.mail = new Gmail(logger, driver);
        } else {
            this.mail = new SquirrelMail(logger, driver);
        }
    }

    public void signInEmail(String email, String password) {
        this.mail.signInEmail(email, password);
    }
    public void goEMail (){
        this.mail.goEMail();
    }
    public void clickOnboardingInvitationLink(){
        this.mail.clickOnboardingInvitationLink();
    }

    public void deleteAllExistedEmail(String email, String password) throws Exception {
        this.mail.deleteAllExistedEmail(email, password);
    }
    public void selectActiveEmail(){
        this.mail.selectActiveEmail();
    }
    public void clickGetStartedButton(){
        this.mail.clickGetStartedButton();
    }
    public void reSignInEmail(String email, String password)throws Exception{
        this.mail.reSignInEmail(email,password);
    }
    public void emailLogout()throws Exception{
        this.mail.emailLogout();
    }
    public void navigateToConfirmationLink()throws Exception{
        this.mail.navigateToConfirmationLink();
        waitSomeSeconds(15);

    }
}
