package com.auvenir.ui.bdd.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void verifyClientAssigneeSelected(String toDoName, String clientAssignee) {
        getLogger().info("== select Client Assignee By Name ==");
        waitSomeSeconds(2);
        int index = findToDoTaskName(toDoName);
        WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
        waitForTextValueChanged(clientAssigneeSelected, "listClientAssigneeDdl", clientAssignee);
        getLogger().info("++ Assert With " + clientAssigneeSelected.getText() + "and " + clientAssignee);
        Assert.assertEquals(clientAssigneeSelected.getText(), clientAssignee);

    }
    public void selectCategory(String categoryName) {

            int categoryExist = checkCategoryExist(categoryName);
            if (categoryExist != -1) {
                clickElement(dropdownCategoryEle.get(0).findElements(By.xpath(".//div[@class='item']")).get(categoryExist)," Select category Exist "+categoryName +"  success" );
            } else {
                sendTabkey(dropdownCategoryEle.get(0), "dropdownCategoryEle");
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
            getLogger().info("Adding new category...");
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
            getLogger().info("== navigate To Add New Category ==");
           clickElement(dropdownCategoryEle.get(0), "categoryDropdownEle");
            waitForTextValueChanged(listOfAddNewCategory.get(0), "categoryCreateEle", "Add New Category");
            hoverElement(listOfAddNewCategory.get(0), "categoryCreateEle");
            clickElement(listOfAddNewCategory.get(0), "categoryCreateEle");


    }
    public void chooseCategoryColorInPopup()  {
        hoverElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColor));
        waitForClickableOfElement(categoryColorFieldOnFromEle, "categoryColorFieldOnFromEle");
        clickElement(categoryColorFieldOnFromEle, "click to categoryColorFieldOnFromEle");
        waitForClickableOfLocator(By.xpath(categoryColorContainer));
        waitForClickableOfElement(detailCateColorEle, "detailCateColorEle");
        clickElement(detailCateColorEle, "click to detailCateColorEle");
    }
    public void clickNewCategoryCreateButton()  {
        getLogger().info("== click New Category Create Button ==");
        waitForClickableOfElement(eleIdBtnAddCategory, "Add Category Button");
        waitForJSandJQueryToLoad();
        WebElement popUpDiv = getDriver().findElement(By.xpath(popUpDivCategoryModel));
        clickElement(eleIdBtnAddCategory, "Add Category Button");
        waitForCssValueChanged(popUpDiv, "PopUp Windows", "display", "none");
    }
    }


