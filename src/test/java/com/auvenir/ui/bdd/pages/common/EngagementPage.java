package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public class EngagementPage extends CommonPage {
    private static Logger logger = Logger.getLogger(EngagementPage.class.getSimpleName());
    //@FindBy(xpath = "//div[@id='allClientEngagement']//span[@id='c-header-title']")
    @FindBy(xpath = "//div[@id='preview-header-left']/span[@id='c-header-title']")
    private WebElement titleAllEngagement;

    @FindBy(xpath = "//*[@id='auditPageNoEngagement']")
    WebElement noEngagementDivEle;

    // Old version
    //    @FindBy(xpath = "//div[@id='cpa-main']/div")
    @FindBy(xpath = "//tbody[@id='engagement-tbody']//td/p")
    protected List<WebElement> engagementListEle;

    @FindBy(id = "c-header-title")
    private WebElement myEngagementTextEle;

    @FindBy(id = "newAuditBtn")
    protected WebElement buttonNewEngagement;

    @FindBy(xpath = "//table[@id='engagement-table']/tbody/tr/td[@class='engagement-name']/p")
    private List<WebElement> eleEngagementNameList;

    public EngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyNavigatedToEngagementPage() {
        waitForVisibleElement(titleAllEngagement, "Title All Engagement");
        validateElementText(titleAllEngagement, "All Engagements");
    }

    @FindBy(id = "h-engagementsLink")
    private WebElement tabHeaderEngagements;

    /*
     * Find the index(position) of Engagement in the list Engagement by Engagement Name
     *
     * @param engagementName String Engagement Name
     * @return the number of the position if the WebElement is matched, otherwise return -1.
     */
    public int findEngagementName(String engagementName) {
        logger.info("Find Position of Engagement Name");
        String displayValue = noEngagementDivEle.getCssValue("display");
        if (displayValue.equals("block"))
            return -1;
        return findElementByText(engagementListEle, engagementName);
    }

    /**
     * Click on the Engagement with the engagement Name.
     *
     * @param engagementName The Engagement Name which be found on Engagement page.
     */
    public void viewEngagementDetailsPage(String engagementName) {
        int index = findEngagementName(engagementName);
        System.out.println("Position: " + index);
        //        hoverElement(engagementListEle.get(index), engagementName);
        waitForClickableOfElement(engagementListEle.get(index), engagementName);
        if (index == engagementListEle.size() - 1) {
            scrollToFooter();
        } else
            hoverElement(engagementListEle.get(index + 1), engagementName);
        clickElement(engagementListEle.get(index), engagementName);
    }

    public void verifyEngagementPage() {
        waitForVisibleElement(myEngagementTextEle, "myEngagementTextEle");
        boolean isCompareText = validateElementText(myEngagementTextEle, "All Engagements");
        if (isCompareText) {
            logger.info("Verify user's Engagement page: Pass");
        } else {
            Assert.fail("Verify user's Engagement page: Fail");
        }
    }

    /**
     * Added by huy.huynh on 17/07/2017.
     * R2.1 Group Permissions
     */
    public void verifyCanCreateAnEngagement(boolean exist) {
        if (exist) {
            clickElement(buttonNewEngagement, "Button New Engagement");
        } else {
            validateNotExistedElement(buttonNewEngagement, "Button New Engagement");
        }
    }

    public void verifyCanSeeAllEngagementsWithinFirm(List<String> engagementListNames, String role) {
        String xpathEngagementName = "//td[@class='engagement-name']/a[text()='%s']";
        boolean exist = true;
        for (String name : engagementListNames) {
            if (getElementByXpath(xpathEngagementName, name) == null) {
                System.out.println("name = " + name);
                exist = false;
            }
        }
        if (exist) {
            logger.info("Verify " + role + " can see all engagements within firm");
        } else {
            Assert.fail("Fail: Verify " + role + " can see all engagements within firm");
        }
    }
    /*-----------end of huy.huynh on 17/07/2017.*/

    public boolean checkEngagementListExists(List<String > engagementNames){
        if(eleEngagementNameList.size() != engagementNames.size())
            return false;

        int totalEngagement = engagementNames.size();
        for(int i=0; i<totalEngagement; i++){
            if(!engagementNames.contains(eleEngagementNameList.get(i).getText().trim())){
                logger.info("Can not see all engagement list : " + engagementNames.toString());
                return false;
            }
        }
        logger.info("See all engagement list : " + engagementNames.toString());
        return true;
    }

    public void verifySeeEngagementList(List<String> engagementNames){
        logger.info("-----------See All Engagement--------------");
        boolean result = checkEngagementListExists(engagementNames);
        Assert.assertTrue(result);
    }
    public void clickOnTabHeaderEngagements(){
        logger.info("----------- Click On Tab Header Engagement --------------");
        clickElement(tabHeaderEngagements,"tab Header Engagements");

    }
}
