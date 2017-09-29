package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.common.KeyWord;
import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MailPage extends CommonPage {
     GmailPage gmailPage;
     SquirrelMailPage squirrelMailPage;
    public MailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        gmailPage = new GmailPage(logger,driver);
        squirrelMailPage = new SquirrelMailPage(logger,driver);
    }


    public void signInEmail(String email, String password) {
        if(email.trim().toLowerCase().contains("@gmail.com")){
            gmailPage.signInGmail(email,password);
        }else
        squirrelMailPage.signInEmail(email,password);
    }
    public void deleteAllExisted (String eMail, String ePassword) throws Exception {
        if(eMail.trim().toLowerCase().contains("@gmail.com")){
            gmailPage.deleteAllExistedGMail(eMail,ePassword);
        }else
          squirrelMailPage.deleteAllExistedEMail(eMail,ePassword);
    }
    public void clickOnboardingInvitationLink () {
        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
        System.out.println();
        if (checkSideMail== true ){
            gmailPage.clickOnboardingInvitationLink();
        }else
            squirrelMailPage.clickOnboardingInvitationLink();
    }
    public void selectActiveEmail (){
        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
        System.out.println();
        if (checkSideMail== true ){
            gmailPage.selectActiveEmail();
        }else
            squirrelMailPage.selectActiveEmail();
    }
    public void clickGetStartedButton(){
        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
        System.out.println();
        if (checkSideMail== true ){
            gmailPage.clickGetStartedButton();
        }else
            squirrelMailPage.clickGetStartedButton();
    }
    public void goEMail (String url){
        if(url.trim().toLowerCase().contains("gmail")){
            gmailPage.goGMail();
        }else
            squirrelMailPage.goEMail();
    }

    public void emailLogout () throws Exception {
        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
        System.out.println();
        if (checkSideMail== true ){
            gmailPage.gmailLogout();
        }else
            squirrelMailPage.emailLogout();

    }
    public void reSignInEmail(String passwd) throws Exception {
        gmailPage.reSignInGmail(passwd);

    }

}
