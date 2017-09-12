package com.auvenir.ui.bdd.pages.client;

import com.auvenir.ui.bdd.pages.common.EngagementPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vien.pham on 9/12/2017.
 */
public class ClientEngagementPage extends EngagementPage {
    public ClientEngagementPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//*[@id='auditPageNoEngagement']")
    private WebElement noEngagementDivEle;

    @FindBy(xpath = "//tbody[@id='engagement-tbody']//p")
    private List<WebElement> clientEngagementListEle;

    public void viewEngagementDetailsPage(String engagementName) {
        int index = findEngagementName(engagementName);
        System.out.println("Position: " + index);
        waitForClickableOfElement(clientEngagementListEle.get(index), engagementName);
        if (index == clientEngagementListEle.size() - 1) {
            scrollToFooter();
        } else
            hoverElement(clientEngagementListEle.get(index + 1), engagementName);
        clickElement(clientEngagementListEle.get(index), engagementName);
    }

    public int findEngagementName(String engagementName) {
        getLogger().info("Find Position of Engagement Name");
        String displayValue = noEngagementDivEle.getCssValue("display");
        if (displayValue.equals("block"))
            return -1;
        return findElementByText(clientEngagementListEle, engagementName);
    }
}
