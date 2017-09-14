package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.TodoPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by viet.le on 9/13/2017.
 */

public class AuditorTodoPage extends TodoPage {
    public AuditorTodoPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }



    @FindBy(xpath = "//div[contains(@class,'ui dropdown auditor todo-bulkDdl ')]")
    private List<WebElement> listAuditorAssigneeDdl;




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
        getLogger().info("Verify Auditor Assignee Selected in Dropdownlist.");
        int index = findToDoTaskName(toDoName);
        WebElement auditorAssigneeSelected = listAuditorAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
        waitForTextValueChanged(auditorAssigneeSelected, "auditorAssigneeSelected", auditorAssignee);
        if (auditorAssigneeSelected.getText().equals(auditorAssignee)) {
            getLogger().info("verify auditor assignee selected with name: " + auditorAssignee);
        } else {

            getLogger().info("verify auditor assignee selected with name: " + auditorAssignee);
        }

    }


}
