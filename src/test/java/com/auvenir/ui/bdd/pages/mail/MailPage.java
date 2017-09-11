package com.auvenir.ui.bdd.pages.mail;

import com.auvenir.ui.bdd.common.KeyWord;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by thuan.duong on 9/11/2017.
 */
public class MailPage extends KeyWord{

    public MailPage(Logger logger, WebDriver driver) {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }


}
