package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.TodoPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by viet.le on 9/13/2017.
 */

public class AuditorTodoPage extends TodoPage {
    private static Logger logger = Logger.getLogger(AuditorTodoPage.class.getSimpleName());
    public AuditorTodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//div[contains(@class,'ui dropdown auditor todo-bulkDdl ')]")
    private List<WebElement> listAuditorAssigneeDdl;
    @FindBy(id = "auv-todo-createToDo")
    protected WebElement createToDoBtnEle;
    @FindBy(id = "empty-todo")
    protected WebElement emptyTodo;
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr[@class='newRow']//input[contains(@class,'newTodoInput')]")
    protected List<WebElement> toDoNameTextColumnEle;
    @FindBy(id = "engOverview-status")
    protected WebElement engOveviewStatus;

    public void selectAuditorAssigneeByName(String toDoName, String auditorAssignee){

        String assineeAuditorEle = ".//button[text()='%s']";
        int index = findToDoTaskName(toDoName);
        clickElement(listAuditorAssigneeDdl.get(index), "listAuditorAssigneeDdl");
        WebElement auditorAssigneeSelected =
                listAuditorAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeAuditorEle, auditorAssignee)));
        waitSomeSeconds(2);
        clickElement(auditorAssigneeSelected, "auditorAssigneeSelected");

    }
    public void verifyAuditorAssigneeSelected(String toDoName, String auditorAssignee) {

        waitSomeSeconds(2);
        logger.info("Verify Auditor Assignee Selected in Dropdownlist.");
        int index = findToDoTaskName(toDoName);
        WebElement auditorAssigneeSelected = listAuditorAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
        waitForTextValueChanged(auditorAssigneeSelected, "auditorAssigneeSelected", auditorAssignee);
        getLogger().info("++ Assert With "+auditorAssigneeSelected.getText()+"and "+auditorAssignee);
        Assert.assertEquals(auditorAssigneeSelected.getText(),auditorAssignee);

    }
    public void createToDoTaskWithCategoryName(String toDoName, String categoryName) {
        getLogger().info("Create To Do Task with 'toDoName' and 'categoryName'");
        waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
        String rowString = toDoTaskRowEle.get(0).getAttribute("class");
        //Thuan Duong: Have a bug, need to start with size 2;
        int size = 1;
        int index = -1;
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (validateExistedElement(emptyTodo, "emptyTodo")) {
            size ++;
        }
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!rowString.equals("")) {
            size = toDoTaskRowEle.size() + 1;
            index = findToDoTaskName(toDoName);
        }

        if (index == -1) {
            getLogger().info("Create New To Do Task");
            waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
            clickElement(createToDoBtnEle, "Create To Do button");
            waitForSizeListElementChanged(toDoTaskRowEle, "To Do task row", size);
            sendKeyTextBox(toDoNameTextColumnEle.get(0), toDoName, "First To Do Name textbox");
            clickElement(engOveviewStatus,"click overview status");

            // Create new category
            selectCategory(categoryName);
            waitSomeSeconds(1);
        }
    }



}
