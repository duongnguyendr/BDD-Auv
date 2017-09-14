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
    private static Logger logger = Logger.getLogger(TodoPage.class.getSimpleName());
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
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr//input[@type='checkbox']")
    protected List<WebElement> eleToDoCheckboxRow;
    @FindBy(id = "todo-bulk-dropdown")
    protected WebElement bulkActionsDropdownEle;
    @FindBy(xpath = "//div[@id='todo-bulk-dropdown']/div[@class='menu']")
    protected WebElement bulkActionsDropdownMenuEle;
    @FindBy(xpath = "//div[starts-with(@id,'Mark As Complete') and contains(@class,'au-modal')]")
    protected WebElement popUpMarkCompleteWindows;
    @FindBy(xpath = "//label[contains(@id,'m-Mark As Complete')]")
    protected WebElement markAsCompleteTitle;
    @FindBy(xpath = ".//label[contains(@id, 'm-Delete Todo Modal')]")
    protected WebElement deleteTodoTitle;
    @FindBy(xpath = "//div[contains(@id, 'Mark As Complete')]//div[@class='ce-footer']//button[@class='auvbtn primary']")
    protected WebElement archiveMarkPopupBtn;
    @FindBy(xpath = "//table[@id='todo-table']//td/div[@class='auvicon-circle-checkmark completeBtn priColor']/../../td/span")
    protected List<WebElement> listTodoCompleted;
    @FindBy(xpath = "//button[contains(text(),'Delete')][@class='item']")
    protected WebElement optionDelete;
    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]/div/div[starts-with(@id,'m-Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDoAnimate;
    @FindBy(xpath = "//div[contains(@id,'m-Delete Todo Modal')]/following-sibling::div//button[@class='auvbtn warning']")
    protected WebElement buttonConfirmDeleteToDo;
    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDo;
    @FindBy(className = "newTodoInput")
    protected List<WebElement> eleToDoNameRow;
    @FindBy(xpath = "//div[contains(text(),'Assign to')]")
    protected WebElement optionAssignTo;
    @FindBy(xpath = "//div[contains(text(),'Assign to')]/div[contains(@class,'menu')]/button")
    protected List<WebElement> childItemAssigneeBulkDrpEle;
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
        logger.info("Find Position of To Do Task Name");
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
                            logger.info("Element is found at " + i);
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
        logger.info("== select Client Assignee By Name ==");
            int index = findToDoTaskName(toDoName);
            clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
            waitSomeSeconds(2);
            WebElement clientAssigneeSelected =
                    listClientAssigneeDdl.get(index).findElement(By.xpath(String.format(assineeClientEle, clientAssignee)));
            clickElement(clientAssigneeSelected, "clientAssigneeSelected");

        }

    /**
     * Duong Nguyen
     */
    public int selectToDoCheckboxByName(String todoName) {//need
        logger.info("Select To Do Task Check Box by Name");
        try{
            int index = findToDoTaskName(todoName);
            System.out.println("Index: " + index);
            if (index != -1) {
                if (!eleToDoCheckboxRow.get(index).isSelected())
                    clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
            }
            return index;
        }catch (Exception e) {
            return -1;
        }
    }

    /**
     * Duong Nguyen
     */
    public void clickBulkActionsDropdown() {
        clickElement(bulkActionsDropdownEle, "Bulk Actions Dropdown List");
    }

    /**
     * Duong Nguyen
     */
    public void clickToBulkCompleteButton() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle.findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(1), "Bulk complete button");
        waitForCssValueChanged(popUpMarkCompleteWindows, "PopUp Mark Complete", "display", "block");
    }

    /**
     * Duong Nguyen
     */
    public void verifyPopUpMarkCompletedDisplay(){
        boolean result = validateElementText(markAsCompleteTitle, "Mark As Complete?");
        Assert.assertTrue(result, "Complete Mark Popup should be displayed.");
    }

    /**
     * Duong Nguyen
     */
    public void clickOnArchiveButtonInMarkAsCompletePopup() {
        waitForClickableOfElement(archiveMarkPopupBtn, "Wait for click on archive button");
        clickElement(archiveMarkPopupBtn, "Click on archive button");
    }

    public void verifyTodoMarkCompleted(String todoName) {
        boolean result = false;
        waitSomeSeconds(2);
        for (WebElement todo : listTodoCompleted) {
            System.out.println("Todo Copleted text: " + todo.getText());
            if (todoName.equals(todo.getText())) {
                result = true;
            }
        }
        Assert.assertEquals(result, true);
    }

    public void clickOptionDeleteOnBulkActionsDropDown() {
            logger.info("Choose option: Delete.");
            clickElement(optionDelete, "Option Delete");
    }

    public void verifyPopUpDeleteTodoDisplay(){
        boolean result = validateElementText(deleteTodoTitle, "Delete To-Do?");
        Assert.assertTrue(result, "Delete todo popup should be displayed.");
    }

    /**
     * Click 'Delete' on Delete To-do popup
     * TODO: need to find appropriate method to wait before click
     */
    public void clickConfirmDeleteButton() {
        waitForAnimation(divConfirmDeleteToDoAnimate, "Div Confirm Delete ToDo Animation");
        clickElement(buttonConfirmDeleteToDo, "Button Confirm Delete ToDo");
        waitForCssValueChanged(divConfirmDeleteToDo, "Div Confirm Delete ToDo", "display", "none");
    }

    /**
     * Verify to-do not existed on list To-dos
     *
     * @param todoName : name of to-to to verify
     */
    public void verifyToDoNotExist(String todoName) {
        try {
            logger.info("Verify deleted todo: " + todoName);
            boolean isExisted = false;
            for (int i = 0; i < eleToDoNameRow.size(); i++) {
                if (todoName.equals(getTextByAttributeValue(eleToDoNameRow.get(i), "Todo expected not Exist"))) {
                    Assert.fail("Fail: Todo still existed: " + todoName);
                    isExisted = true;
                }
            }
            if (!isExisted) {
                logger.info("Todo deleted success");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * choose an assignee on list Assign to
     * TODO hardcoding, rewrite later, list assignee not stable now
     */
    public void chooseBulkActionAssignee(String assigneeName) {
        logger.info(String.format("Choose Assignee '%s' in Bulk Dropdown list", assigneeName));
            String listUser = "";
            boolean result = false;
            clickElement(optionAssignTo, "Assign To Option");
            waitSomeSeconds(2);
            for (int i = 0; i < childItemAssigneeBulkDrpEle.size(); i++) {
                listUser = childItemAssigneeBulkDrpEle.get(i).getAttribute("textContent");
                System.out.println("list User: " + listUser);
                if (listUser.contains(assigneeName)) {
                    clickElement(childItemAssigneeBulkDrpEle.get(i), "Child Item Assignee");
                    break;
                }
            }
    }
}
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


