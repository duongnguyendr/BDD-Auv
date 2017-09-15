package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class TodoPage extends CommonPage {
    public TodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    protected List<WebElement> toDoTaskRowEle;
    @FindBy(xpath = "//div[contains(@class,'ui dropdown auditor todo-bulkDdl ')]")
    private List<WebElement> listAuditorAssigneeDdl;
    @FindBy(xpath = "//div[@class='ui dropdown client todo-bulkDdl ']")
    private List<WebElement> listClientAssigneeDdl;
    protected String assineeClientEle = ".//button[text()='%s']";
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td[7]/img")
    private List<WebElement> listSlideOutMenu;
    @FindBy(xpath = "//div[@id='auv-todo-details']")
    private WebElement todoDetailPopup;


    public int findToDoTaskName(String toDoName) {
        getLogger().info("Find Position of To Do Task Name");
        try {
            String actualAttributeValue;
            String classAttribute;
            for (int i = 0; i < toDoTaskRowEle.size(); i++) {
                classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
                if (classAttribute.equals("newRow")) {
                    boolean elementExisted =
                            validateNotExistedElement(toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']")), "toDoTaskRowEle");
                    if (!elementExisted) {
                        WebElement toDoNameCell = toDoTaskRowEle.get(i).findElement(By.xpath("td/input[@type='text']"));
                        actualAttributeValue = toDoNameCell.getAttribute("value").trim();

                        if (actualAttributeValue.equals(toDoName)) {
                            getLogger().info("Element is found at " + i);
                            return i;
                        }
                    }
                }
            }
            return -1;
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

    public void selectClientAssigneeByName(String toDoName, String clientAssignee) {
        getLogger().info("== select Client Assignee By Name ==");
        int index = findToDoTaskName(toDoName);
        clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
        waitSomeSeconds(2);
        WebElement clientAssigneeSelected =
                listClientAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeClientEle, clientAssignee)));
        clickElement(clientAssigneeSelected, "clientAssigneeSelected");

    }

    public void clickSlideOutMenuOnTodo(String todoName) {
        int index = findToDoTaskName(todoName);
        clickElement(listSlideOutMenu.get(index), "Slide Out Menu icon");
    }

    public void verifyTodoDetailOpened() {
        boolean isOpened = waitForCssValueChanged(todoDetailPopup, "Todo detail popup", "display", "block");
        Assert.assertTrue(isOpened, "Todo detail is opened successfully");
    }
}