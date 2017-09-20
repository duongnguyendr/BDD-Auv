package com.auvenir.ui.bdd.pages.auditor;

import com.auvenir.ui.bdd.pages.common.TodoPage;
import com.google.common.util.concurrent.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.auvenir.ui.bdd.common.GeneralUtilities.randomNumber;

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
    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory todo-category todo-bulkDdl')]")
    private List<WebElement> dropdownCategoryEle;
    @FindBy(id = "category-name")
    private WebElement categoryNameFieldOnFormEle;
    @FindBy(xpath = "//*[contains(@class,'ui dropdown todoCategory')]//div[text()='Add New Category']")
    List<WebElement> listOfAddNewCategory;
    @FindBy(xpath = "//*[@id='category-color']")
    private WebElement categoryColorFieldOnFromEle;
    @FindBy(xpath = "//*[@id=\"category-color-container\"]/ul/li[4]")
    private WebElement detailCateColorEle;
    @FindBy(id = "category-addBtn")
    private WebElement eleIdBtnAddCategory;



    public static final String popUpDivCategoryModel = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]";
    public static final String categoryColor = "//*[@id='category-color']";
    public static final String categoryColorContainer = "//*[@id='category-color-container']/ul/li[4]";



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
        if (auditorAssigneeSelected.getText().equals(auditorAssignee)) {
            logger.info("verify auditor assignee selected with name: " + auditorAssignee);
        } else {
            logger.info("verify auditor assignee selected with name: " + auditorAssignee);
        }

    }
    public void createToDoTaskWithCategoryName(String toDoName, String categoryName) {
        logger.info("Create To Do Task with 'toDoName' and 'categoryName'");
        waitForVisibleElement(createToDoBtnEle, "Create To Do Button");
        String rowString = toDoTaskRowEle.get(0).getAttribute("class");
        //Thuan Duong: Have a bug, need to start with size 2;
        int size = 1;
        int index = -1;
//        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
////        if (validateExistedElement(emptyTodo, "emptyTodo")) {
////            size ++;
////        }
//        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (rowString.contains("newRow")) {
            size = toDoTaskRowEle.size() + 1;
            index = findToDoTaskName(toDoName);
        }

        if (index == -1) {
            logger.info("Create New To Do Task");
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
    public void selectCategory(String categoryName) {

        int categoryExist = checkCategoryExist(categoryName);
        if (categoryExist != -1) {
            clickElement(dropdownCategoryEle.get(0).findElements(By.xpath(".//div[@class='item']")).get(categoryExist)," Select category Exist "+categoryName +"  success" );
        } else {
            sendTabKey(dropdownCategoryEle.get(0), "dropdownCategoryEle");
            createNewCategory(categoryName);
        }

    }
    public int checkCategoryExist(String categoryName) {
        int index = -1;
        try {
            Thread.sleep(3000);
            clickElement(dropdownCategoryEle.get(0), "click to dropdownCategoryEle");
            List<WebElement> listCategory = dropdownCategoryEle.get(0).findElements(By.xpath(".//div[@class='item']"));
            for (int i = 0; i < listCategory.size(); i++) {
                if (listCategory.get(i).getAttribute("textContent").equals(categoryName)) {
                    index = i;
                    break;
                }
            }
            return index;
        } catch (Exception e) {
            return index;
        }}
    public void createNewCategory(String categoryNameInput)  {
        waitSomeSeconds(2);
        String categoryName = null;
        if (categoryNameInput == "") {
            categoryName = "Category " + randomNumber();
        } else {
            categoryName = categoryNameInput;
        }
        logger.info("Adding new category...");
        navigateToAddNewCategory();
        waitForClickableOfElement(categoryNameFieldOnFormEle, "categoryNameFieldOnFormEle");
        waitForJSandJQueryToLoad();
        clickElement(categoryNameFieldOnFormEle, "click to categoryNameFieldOnFormEle");
        sendKeyTextBox(categoryNameFieldOnFormEle, categoryName, "send key to categoryNameFieldOnFormEle");
        chooseCategoryColorInPopup();
        clickNewCategoryCreateButton();
        //        closeSuccessToastMes();
    }
    public void navigateToAddNewCategory()  {
        logger.info("== navigate To Add New Category ==");
        clickElement(dropdownCategoryEle.get(0), "categoryDropdownEle");
        waitForTextValueChanged(listOfAddNewCategory.get(0), "categoryCreateEle", "Add New Category");
        hoverElement(listOfAddNewCategory.get(0), "categoryCreateEle");
        clickElement(listOfAddNewCategory.get(0), "categoryCreateEle");


    }
    public void chooseCategoryColorInPopup()  {
        hoverElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
//        waitForClickableOfLocator(By.xpath(categoryColor));
        waitForClickableOfElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
        clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
//        waitForClickableOfLocator(By.xpath(categoryColorContainer));
        waitForClickableOfElement(detailCateColorEle, "detailCateColorEle");
        clickElement(detailCateColorEle, "click to detailCateColorEle");
    }
    public void clickNewCategoryCreateButton()  {
        logger.info("== click New Category Create Button ==");
        waitForClickableOfElement(eleIdBtnAddCategory, "Add Category Button");
        waitForJSandJQueryToLoad();
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpDivCategoryModel));
        clickElement(eleIdBtnAddCategory, "Add Category Button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }
//    public void closeAddNewRequestWindow() {
//        clickElement(requestCloseBtn,"close Add New Request Window ");
//        waitForCssValueChanged(addNewRequestWindow, "Add new Request Window", "display", "none");
//    }
    public void verifyRequestCreated(List<String> listRequest) {
        logger.info("== verify Request Created ==");
        List<String> lstRequestDisplayed = new ArrayList<>();
        for (WebElement requestEle : listRequestEle) {
            waitSomeSeconds(1);
            lstRequestDisplayed.add(requestEle.getText());
        }
        logger.info("test listRequest: " + listRequest.size());
        for (int i = 0; i < listRequest.size(); i++) {
            Assert.assertTrue(lstRequestDisplayed.contains(listRequest.get(i)));
        }
        closeAddNewRequestWindow();

    }


}
