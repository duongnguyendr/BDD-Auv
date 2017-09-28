package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.pages.common.CommonPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstracEmail extends CommonPage {
    public AbstracEmail(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public abstract void signInEmail(String email, String password);

    public abstract void deleteAllExistedEmail(String email, String ePassword) throws Exception;
    //
    //    public void clickOnboardingInvitationLink() {
    //        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
    //        System.out.println();
    //        if (checkSideMail == true) {
    //            gmailPage.clickOnboardingInvitationLink();
    //        } else
    //            squirrelMailPage.clickOnboardingInvitationLink();
    //    }
    //
    //    public void selectActiveEmail() {
    //        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
    //        System.out.println();
    //        if (checkSideMail == true) {
    //            gmailPage.selectActiveEmail();
    //        } else
    //            squirrelMailPage.selectActiveEmail();
    //    }
    //
    //    public void clickGetStartedButton() {
    //        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
    //        System.out.println();
    //        if (checkSideMail == true) {
    //            gmailPage.clickGetStartedButton();
    //        } else
    //            squirrelMailPage.clickGetStartedButton();
    //    }
    //
    //    public void goEMail(String url) {
    //        if (url.trim().toLowerCase().contains("gmail")) {
    //            gmailPage.goGMail();
    //        } else
    //            squirrelMailPage.goEMail();
    //    }
    //
    //    public void emailLogout() throws Exception {
    //        boolean checkSideMail = getDriver().getCurrentUrl().contains("mail.google");
    //        System.out.println();
    //        if (checkSideMail == true) {
    //            gmailPage.gmailLogout();
    //        } else
    //            squirrelMailPage.emailLogout();
    //
    //    }
    //
    //    public void reSignInEmail(String passwd) throws Exception {
    //        gmailPage.reSignInGmail(passwd);
    //
    //    }

}
