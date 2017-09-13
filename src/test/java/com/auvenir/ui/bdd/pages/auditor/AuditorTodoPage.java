package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.TodoPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuditorTodoPage extends TodoPage {
    public AuditorTodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }


    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr")
    protected List<WebElement> toDoTaskRowEle;
    @FindBy(xpath = "//div[contains(@class,'ui dropdown auditor todo-bulkDdl ')]")
    private List<WebElement> listAuditorAssigneeDdl;







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
    public void selectAuditorAssigneeByName(String toDoName, String auditorAssignee){

        String assineeAuditorEle = ".//button[text()='%s']";
        int index = findToDoTaskName(toDoName);
        clickElement(listAuditorAssigneeDdl.get(index), "listAuditorAssigneeDdl");
        WebElement auditorAssigneeSelected =
                listAuditorAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeAuditorEle, auditorAssignee)));
        waitSomeSeconds(2);
        clickElement(auditorAssigneeSelected, "auditorAssigneeSelected");

    }

}
