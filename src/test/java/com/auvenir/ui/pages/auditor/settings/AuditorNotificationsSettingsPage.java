package com.auvenir.ui.pages.auditor.settings;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import java.util.List;

/**
 * Created by cuong.nguyen on 4/27/2017.
 */
public class AuditorNotificationsSettingsPage extends AbstractPage {
    private final static int waitTime = 60;
    private final static String NOTIFICATION_CARD_NOTE = "We will alert you when important updates and changes have occurred to your engagement. You can customize your notifications below.";
    private final static String NOTIFICATION_SUB_NOTE = "Get notified when someone:";
    private final static String[] notificationList = {"Is invited to your engagement",
                                                      "Has joined your engagement",
                                                      "Comments on an engagement",
                                                      "Creates a new request within a To-Do",
                                                      "Creates a new To-Do",
                                                      "Uploads a document",
                                                      "Marks a To-Do as complete"};
    public AuditorNotificationsSettingsPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Notifications Settings')]")
    private WebElement auditorNotificationsSettingsHeaderTextEle;

    @FindBy(xpath = "//h3[contains(text(),'By Email')]")
    private WebElement eleNotificationsSubHeaderText;

    @FindBy(xpath = "//p[@id='pNotificationNote' and @class='c-notifications-cardNote']")
    private WebElement eleNotificationCardNote;

    @FindBy(xpath = "//p[@id='pNotificationNote' and @class='c-notifications-cardSubNote']")
    private WebElement eleNotificationSubNote;

    @FindBy(xpath = "//p[@class='notifications-type-text']")
    private List<WebElement> eleNotificationItemList;

    @FindBy(xpath = "//div[@class='checkboxSlider round']")
    private List<WebElement> eleNotificationCheckBoxSliderRoundList;

    public void verifyAuditorNotificationSettingsPage() {

        try {
            boolean result;
            waitForVisibleElement(auditorNotificationsSettingsHeaderTextEle, "auditorNotificationsSettingsHeaderTextEle");

            waitForVisibleElement(eleNotificationCardNote, "notification card note");
            result = validateElementText(eleNotificationCardNote, NOTIFICATION_CARD_NOTE);
            Assert.assertTrue(result, "Verify GUI auditor notification card note");

            waitForVisibleElement(eleNotificationsSubHeaderText, "notification sub header text");
            result = validateElementText(eleNotificationSubNote, NOTIFICATION_SUB_NOTE);
            Assert.assertTrue(result, "Verify GUI auditor notification sub note");
        }
        catch (AssertionError error){
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify GUI auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),error.getMessage());
        }
        catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify GUI auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
        }
    }

   public void verifyNotificationItemListNotificationSettingsPage() {
        try {

            int itemTotal = eleNotificationItemList.size();
            if(itemTotal == 0){
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify notification item list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),"Notification item list is empty");
            }else{
                if(itemTotal != notificationList.length){
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify notification item list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),"Notification item list is not enough item");
                }else{
                    boolean result = true;
                    for(int i=0;i<itemTotal;i++){
                        if(!eleNotificationItemList.get(i).getText().trim().equals(notificationList[i])){
                            result = false;
                            int position = i + 1;
                            NXGReports.addStep("Verify notification item at position " + position + " in notification list.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),"Notification item at position " + position + " is wrong");
                        }
                    }
                    if(!result){
                        AbstractService.sStatusCnt++;
                    }
                }
            }
        }
        catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify notification item list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
        }
   }

    public void verifyNotificationCheckBoxSliderRoundWorking() {
        try {
            waitSomeSeconds(6);
            int itemTotal = eleNotificationCheckBoxSliderRoundList.size();
            if(itemTotal == 0){
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Verify notification check box slider round list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),"Notification check bok slider round list is empty");
            }else{
                if(itemTotal != notificationList.length){
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Verify notification check box slider round list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),"Notification check box slider round list is not enough item");
                }else{
                    for(int i=0;i<itemTotal;i++){
                        waitForVisibleElement(eleNotificationCheckBoxSliderRoundList.get(i),"notification check box slider round");
                        int position = i + 1;
                        clickElement(eleNotificationCheckBoxSliderRoundList.get(i), "Notification check box slider round at position " + position);
                    }
                }
            }
        }
        catch (Exception ex) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Verify notification check box slider round list in auditor notification page.", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE),ex.getMessage());
        }
    }
}
