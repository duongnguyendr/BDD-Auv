package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by huy.huynh on 20/07/2017.
 */
public class EngagementPage extends CommonPage {

    //@FindBy(xpath = "//div[@id='allClientEngagement']//span[@id='c-header-title']")
    @FindBy(xpath = "//div[@id='preview-header-left']/span[@id='c-header-title']")
    private WebElement titleAllEngagement;

    @FindBy(xpath = "//*[@id='auditPageNoEngagement']")
    WebElement noEngagementDivEle;

    // Old version
    //    @FindBy(xpath = "//div[@id='cpa-main']/div")
    @FindBy(xpath = "//tbody[@id='engagement-tbody']//td/a")
    protected List<WebElement> engagementListEle;

    @FindBy(id = "c-header-title")
    private WebElement myEngagementTextEle;

    @FindBy(id = "newAuditBtn")
    protected WebElement buttonNewEngagement;

    public EngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    public void verifyNavigatedToEngagementPage() {
        waitForVisibleElement(titleAllEngagement, "Title All Engagement");
        validateElementText(titleAllEngagement, "All Engagements");
    }

    /*
     * Find the index(position) of Engagement in the list Engagement by Engagement Name
     *
     * @param engagementName String Engagement Name
     * @return the number of the position if the WebElement is matched, otherwise return -1.
     */
    public int findEngagementName(String engagementName) {
        getLogger().info("Find Position of Engagement Name");
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
            getLogger().info("Verify user's Engagement page: Pass");
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
            getLogger().info("Verify " + role + " can see all engagements within firm");
        } else {
            Assert.fail("Fail: Verify " + role + " can see all engagements within firm");
        }
    }
    /*-----------end of huy.huynh on 17/07/2017.*/
}
