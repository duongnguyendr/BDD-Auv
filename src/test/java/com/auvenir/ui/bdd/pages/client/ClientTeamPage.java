package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.common.TeamPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by vien.pham on 9/12/2017.
 */
public class ClientTeamPage extends TeamPage {
    public ClientTeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(id = "m-inm-jobTitle")
    private WebElement memberRoleTxtbox;

    public void inputMemberRole(String roleName) {
        sendKeyTextBox(memberRoleTxtbox, roleName, "Member role Textbox");
    }
}
