package com.auvenir.ui.bdd.pages.common;

import com.auvenir.ui.bdd.common.GeneralUtilities;
import com.auvenir.ui.bdd.common.Generic;
import cucumber.api.DataTable;
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
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td/span[@class='todo-name-readonly']")
    protected List<WebElement> unEditableTodoName;
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
    @FindBy(xpath = "//div[contains(@id, 'download-zip') and contains(@style, 'display: block;')]//label[contains" +
            "(@id, 'm-download-zip')]")
    protected WebElement downloadAttachmentTitle;
    @FindBy(xpath = ".//label[contains(@id, 'm-Delete Todo Modal')]")
    protected WebElement deleteTodoTitle;
    @FindBy(xpath = "//div[contains(@id, 'Mark As Complete')]//div[@class='ce-footer']//button[@class='auvbtn " +
            "primary']")
    protected WebElement archiveMarkPopupBtn;
    @FindBy(xpath = "//table[@id='todo-table']//td/div[@class='auvicon-circle-checkmark completeBtn " +
            "priColor']/../../td/span")
    protected List<WebElement> listTodoCompleted;
    @FindBy(xpath = "//button[contains(text(),'Delete')][@class='item']")
    protected WebElement optionDelete;
    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]/div/div[starts-with(@id,'m-Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDoAnimate;
    @FindBy(xpath = "//div[contains(@id,'m-Delete Todo Modal')]/following-sibling::div//button[@class='auvbtn " +
            "warning']")
    protected WebElement buttonConfirmDeleteToDo;
    @FindBy(xpath = "//div[starts-with(@id,'Delete Todo Modal')]")
    protected WebElement divConfirmDeleteToDo;
    @FindBy(className = "newTodoInput")
    protected List<WebElement> eleToDoNameRow;
    @FindBy(xpath = "//div[contains(text(),'Assign to')]")
    protected WebElement optionAssignTo;
    @FindBy(xpath = "//div[contains(text(),'Assign to')]/div[contains(@class,'menu')]/button")
    protected List<WebElement> childItemAssigneeBulkDrpEle;
    @FindBy(id = "cb-select-all-todo")
    protected WebElement eleCheckAllCheckBox;
    @FindBy(xpath = "//div[starts-with(@id,'download-zip') and contains(@class,'au-modal')]")
    protected WebElement popUpDownloadAttachmentsWindows;
    @FindBy(id = "fm-downloadBtn")
    protected WebElement downloadAllTodo;
    @FindBy(xpath = "//*[@id='todo-table']/tbody/tr/td[7]/img")
    protected List<WebElement> listSlideOutMenu;
    @FindBy(xpath = "//div[@id='auv-todo-details']")
    protected WebElement todoDetailPopup;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div")
    protected List<WebElement> listNewRequest;
    @FindBy(xpath = "//*[@id='todoDetailsReqCont']")
    protected WebElement newRequestTable;
    @FindBy(xpath = "//div[@id='todoDetailsReqCont']/div[@class='detReqForFile']/span[@class='todo-req-name-label']")
    protected List<WebElement> listRequestNameLabel;
    @FindBy(xpath = "//label[@class='auvicon-line-circle-add todo-circle-add todo-icon-hover']")
    private List<WebElement> addFileIcon;


    public int findToDoTaskName(String toDoName) {
        logger.info(String.format("Find Position of To Do Task Name: '%s'", toDoName));
        try {
            String actualAttributeValue;
            String classAttribute;
            WebElement toDoTaskName;
            for (int i = 0; i < toDoTaskRowEle.size(); i++) {
                classAttribute = toDoTaskRowEle.get(i).getAttribute("class");
                if (classAttribute.equals("newRow")) {
                    System.out.println(String.format("td[2]/*[@value|text()='%s']",toDoName));
                    try {
                        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                        toDoTaskName = toDoTaskRowEle.get(i).findElement(By.xpath(String.format("td[2]/*[@value|text()='%s']", toDoName)));
                        if(toDoTaskName != null) {
                            logger.info("Element is found at " + i);
                            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                            return i;
                        }
                    } catch (NoSuchElementException e) {
                        logger.info("Find to next item.");
                    }
                }
            }
            logger.info("Element is not found");
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return -1;
        } catch (NoSuchElementException e) {
            logger.info("Element is not found");
            logger.info(e.toString());
            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return -1;
        }
    }

    /**
     * Vien Pham
     *
     * @param toDoName
     * @return
     */
//    public int findUnEditableToDoTaskName(String toDoName) {
//        logger.info("Find Position of To Do Task Name "+ toDoName);
//        int index = -1;
//        try {
//            for (int i = 0; i < unEditableTodoName.size(); i++) {
//                String actualTodoName = unEditableTodoName.get(i).getText();
//                if (actualTodoName.equals(toDoName)) {
//                    index = i;
//                    break;
//                }
//            }
//            return index;
//        } catch (NoSuchElementException e) {
//            logger.info("Element is not found");
//            return -1;
//        }
//    }

    public void selectClientAssigneeByName(String toDoName, String clientAssignee) {
        logger.info("== select Client Assignee By Name ==");
        int index = findToDoTaskName(toDoName);
        clickElement(listClientAssigneeDdl.get(index), "listClientAssigneeDdl");
        waitSomeSeconds(2);
        WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index)
                .findElement(By.xpath(String.format(assineeClientEle, clientAssignee)));
        clickElement(clientAssigneeSelected, "clientAssigneeSelected");

    }

    /**
     * Duong Nguyen
     */
    public int selectToDoCheckboxByName(String todoName) {//need
        logger.info("Select To Do Task Check Box by Name");
        try {
            int index = findToDoTaskName(todoName);
            System.out.println("Index: " + index);
            if (index != -1) {
                if (!eleToDoCheckboxRow.get(index).isSelected())
                    clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
            }
            return index;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Vien.Pham
     *
     * @param todoName
     * @return
     */
//    public int selectUnEditableToDoCheckboxByName(String todoName) {
//        logger.info("Select To Do Task Check Box by Name");
//        try {
//            int index = findUnEditableToDoTaskName(todoName);
//            System.out.println("Index: " + index);
//            if (index != -1) {
//                if (!eleToDoCheckboxRow.get(index).isSelected())
//                    clickElement(eleToDoCheckboxRow.get(index), String.format("Check box of Task Name: %s", todoName));
//            }
//            return index;
//        } catch (Exception e) {
//            return -1;
//        }
//    }

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
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle
                .findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(1), "Bulk complete button");
        waitForCssValueChanged(popUpMarkCompleteWindows, "PopUp Mark Complete", "display", "block");
    }

    /**
     * Duong Nguyen
     */
    public void verifyPopUpMarkCompletedDisplay() {
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

    public void verifyPopUpDownloadAttachmentsDisplay() {
        boolean result = validateElementText(downloadAttachmentTitle, "Ready To Download");
        Assert.assertTrue(result, "Download Attachments popup should be displayed.");
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

    public void verifyPopUpDeleteTodoDisplay() {
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

    public void verifyClientAssigneeSelected(String toDoName, String clientAssignee) {
        logger.info("== select Client Assignee By Name ==");
        waitSomeSeconds(2);
        int index = findToDoTaskName(toDoName);
        WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index)
                .findElement(By.xpath("./div[@class='text']"));
        waitForTextValueChanged(clientAssigneeSelected, "listClientAssigneeDdl", clientAssignee);
        logger.info("++ Assert With " + clientAssigneeSelected.getText() + "and " + clientAssignee);
        Assert.assertEquals(clientAssigneeSelected.getText(), clientAssignee);
    }

    /**
     * Check/Uncheck checkall check box
     *
     * @param isCheck
     */
    public void checkOrUnCheckCheckAllCheckBox(boolean isCheck) {
        waitForVisibleElement(eleCheckAllCheckBox, "'CheckAll' check box");
        hoverElement(eleCheckAllCheckBox, "Hover 'CheckAll' check box");
        if (isCheck) {
            if (!eleCheckAllCheckBox.isSelected()) {
                clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
            } else {
                clickElement(eleCheckAllCheckBox, "Un check on 'CheckAll' checkbox");
                clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
            }
        } else {
            if (eleCheckAllCheckBox.isSelected()) {
                clickElement(eleCheckAllCheckBox, "Un Check on 'CheckAll' checkbox");
            } else {
                clickElement(eleCheckAllCheckBox, "Un check on 'CheckAll' checkbox");
                clickElement(eleCheckAllCheckBox, "Check on 'CheckAll' checkbox");
            }
            logger.info("UnCheck on 'CheckAll' check box in ToDo page complete");
        }
    }

    public void clickSlideOutMenuOnTodo(String todoName) {
        String xpathImageSlideOutByName = "//*[@value|text()='%s']/ancestor::tr[@class='newRow']//img";
        WebElement imageSlideOut = getElementByXpath(xpathImageSlideOutByName, todoName);
        System.out.println("imageSlideOut = " + imageSlideOut);
        Assert.assertNotNull(imageSlideOut, "Todo named: " + todoName + " expected exist on list todo.");
        clickElement(imageSlideOut, "Image Slide Out of todo: " + todoName);
    }

    public void verifyTodoDetailOpened() {
        boolean isOpened = waitForCssValueChanged(todoDetailPopup, "Todo detail popup", "display", "block");
        Assert.assertTrue(isOpened, "Todo detail is opened successfully");
    }

    public void clickToBulkDownloadAttachmentButton() {
        List<WebElement> menuBulkActionsDropdown = bulkActionsDropdownMenuEle
                .findElements(By.xpath("button[contains(@class,'item')]"));
        clickElement(menuBulkActionsDropdown.get(0), "Bulk download attachments button");
        waitForAnimation(popUpDownloadAttachmentsWindows, "Download To Do Popup");
    }

    public void clickDownloadAllTodo() {
        logger.info("Click Download Button.");
        clickElement(downloadAllTodo, "click to downloadAllTodo");
        waitForCssValueChanged(popUpDownloadAttachmentsWindows, "Popup Download", "display", "none");
        waitSomeSeconds(3);
    }

    public void verifyFileDownloadSuccessful(String fileName) {
        boolean result = GeneralUtilities.checkFileExists(Generic.FOLDER_DOWNLOAD + fileName, false);
        Assert.assertTrue(result, "File : " + fileName + " should existed in local computer");
    }

    public void verifyClientAssigneeSelectedOnUneditablePage(String toDoName, String clientAssignee) {
        logger.info("== select Client Assignee By Name ==");
        waitSomeSeconds(2);
        int index = findToDoTaskName(toDoName);
        WebElement clientAssigneeSelected = listClientAssigneeDdl.get(index).findElement(By.xpath("./div[@class='text']"));
        waitForTextValueChanged(clientAssigneeSelected, "listClientAssigneeDdl", clientAssignee);
        logger.info("++ Assert With " + clientAssigneeSelected.getText() + "and " + clientAssignee);
        Assert.assertEquals(clientAssigneeSelected.getText(), clientAssignee);
    }

    public void verifyUserSeeToDo(List<String> toDoList) {
        boolean result = true;
        int totalToDo = toDoList.size();
        for (int i = 0; i < totalToDo; i++) {
            String toDoName = toDoList.get(i);
            int index = findToDoTaskName(toDoName);
            if(-1 == index){
                logger.info("Can not see : " + toDoName);
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }




    public static void verifyRequestFromTodo(DataTable dataTable) {

    }
}