package com.auvenir.ui.pages.auditor.engagement;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.htmlreport.com.nxgreport.NXGReports;
import com.auvenir.utilities.htmlreport.com.nxgreport.logging.LogAs;
import com.auvenir.utilities.htmlreport.com.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Random;


/**
 * Created by vien.pham on 5/13/2017.
 */
public class AuditorEditCategoriesPage extends AbstractPage {
    public static final String specialCharacters = "!@#$%^&*()";
    public static final String nullValue = "";
    public static final int oneItemBeRemoved = 1;
    public static final int twoItemsBeRemoved = 2;

    public AuditorEditCategoriesPage(Logger logger, WebDriver driver) {
        super(logger, driver);

    }


    @FindBy(xpath = "//div[contains(@class,\"ui dropdown category\")]/div[contains(@class,\"text\")]")
    private WebElement dropdownCategoryEle;

    @FindBy(xpath = "//div[contains(@class,\"category\")]//div[contains(@class,\"menu\")]/div[2]")
    WebElement eleEditCategory;

    @FindBy(xpath = "//div[starts-with(@id, 'categoryModel') and contains(@style,'display: block')]//h3 [@class='setup-header']")
    WebElement eleEditCategoryTitle;

    @FindBy(xpath = "//div[contains(@class,\"des-edit-modal\")]")
    WebElement eleEditCategoryGuide;


    @FindBy(xpath = "//div[@class='au-modal au-display']//button[@id=\"m-ce-cancelBtn\"]")
    WebElement eleEditCategoryCancelBtn;

    @FindBy(xpath = "//div[@class=\"ce-footerBtnHolder\"]/button[@id=\"category-updateBtn\"]")
    WebElement eleEditCategorySaveBtn;


    @FindBy(xpath = "//*[@id=\"todo-cancel-btn\"]")
    WebElement eleEditCategoryCloseBtn;

    @FindBy(xpath = "//input[contains(@id,\"forge-Input\")]")
    List<WebElement> listOfCategoriesItemEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-trash-btn\")]")
    List<WebElement> listOfEditTrashEle;

    @FindBy(xpath = "//img[contains(@id,\"cat-edit-btn\")]")
    List<WebElement> listOfEditPenEle;

    @FindBy(xpath = "//div[@class=\"auv-cat-error\"]/p[@class=\"auv-inputError\"]")
    WebElement notAValidNameEle;
    @FindBy(id = "auv-todo-createToDo")
    WebElement createToDoBtnEle;

    @FindBy(xpath = "//div[contains(@class, 'ui dropdown category todo-bulkDdl ')]/div[2]/div/button")
    List<WebElement> listOfCategoriesDropdownTableEle;


    @FindBy(xpath = "//table[@id=\"todo-table\"]/tbody/tr[1]//div[@class=\"menu\"]/div[2]")
    WebElement editCategoryBtn;

    @FindBy(xpath = "//*[@id=\"todo-table\"]/tbody/tr[1]/td[3]/div[contains(@class,'ui dropdown category')]")
    WebElement categoryDropdownEle;


    public void navigateToEditCategory() throws InterruptedException {
        //        waitForNewTodoNameSaved();
        waitForClickableOfLocator(By.xpath("//*[@id=\"todo-table\"]/tbody/tr[1]/td[3]/div[contains(@class,'ui dropdown category')]"));
        clickElement(categoryDropdownEle, "categoryDropdown");
        Thread.sleep(smallerTimeOut);
        waitForClickableOfLocator(By.xpath("//table[@id=\"todo-table\"]/tbody/tr[1]//div[@class=\"menu\"]/div[2]"));
        clickElement(editCategoryBtn, "editCategory");
    }


    public void returnToCreateNewTodoPage() {
        getLogger().info("Return to Create new todo page");
        waitForVisibleElement(createToDoBtnEle, "Create Todo Button");
        createToDoBtnEle.click();

    }

    public void verifyEditCategoriesPopupTitle() {
        validateDisPlayedElement(eleEditCategoryTitle, "PopUp Title");

    }

    public void verifyEditCategoriesPopupGuide() {
        validateDisPlayedElement(eleEditCategoryGuide, "PopUp Guide");

    }


    public void verifyCancelBtn() throws Exception {
        getLogger().info("Verifying Cancel button..");
        try {
            validateCssValueElement(eleEditCategoryCancelBtn, "background-color", "rgba(151, 147, 147, 1)");
            validateCssValueElement(eleEditCategoryCancelBtn, "color", "rgba(255, 255, 255, 1)");
            validateEnabledElement(eleEditCategoryCancelBtn, "Cancel Button");

            NXGReports.addStep("Cancel displayed correctly", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Cancel displayed incorrectly", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectCancelBtn() throws Exception {
        getLogger().info("Trying to click Cancel button...");
        try {
            waitForVisibleElement(eleEditCategoryCancelBtn, "Cancel button");
            eleEditCategoryCancelBtn.click();
            NXGReports.addStep("Select Cancel button successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Select Cancel button unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void selectSaveBtn() throws Exception {
        getLogger().info("Trying to click Save button...");
        try {
            waitForVisibleElement(eleEditCategorySaveBtn, "Cancel button");
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Select Save button successfully", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Select Save button unsuccessfully", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public void verifyDefaultSaveBtn() throws Exception {
        try {
            getLogger().info("Verifying Default Save button...");
            validateDisPlayedElement(eleEditCategorySaveBtn, "Save");
            validateCssValueElement(eleEditCategorySaveBtn, "background-color", "rgba(89, 155, 161, 1)");
            validateCssValueElement(eleEditCategorySaveBtn, "color", "rgba(255, 255, 255, 1)");
            getLogger().info("Verifying Default Save button is disable...");
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Default Save button displayed correctly", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Default Save button displayed incorrectly", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyUnActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is disable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), "true");
            NXGReports.addStep("Save button is disable", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Save button is enable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));


        }

    }


    public void verifyActiveSaveBtn() throws Exception {
        Thread.sleep(smallTimeOut);
        getLogger().info("Verify Save button is enable...");
        try {
            Assert.assertEquals(eleEditCategorySaveBtn.getAttribute("disabled"), null);
            eleEditCategorySaveBtn.click();
            NXGReports.addStep("Save button is enable", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Save button is disable", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void verifyCategoriesSaved(String comparedValue) {
        try {
            Thread.sleep(smallTimeOut);
            navigateToEditCategory();
            getLogger().info("Verifying new valid value should be saved...");
            if (listOfCategoriesItemEle.get(0).getAttribute("data-dbdata").equals(comparedValue))
                NXGReports.addStep("Valid value was saved ", LogAs.PASSED, null);
            else {
                AbstractService.sStatusCnt++;
                NXGReports.addStep("Valid value was not saved ", LogAs.FAILED,
                        new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Valid value was not saved ", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }


    public void verifyCategoriesNotSaved(String newVlue) throws Exception {
        try {
            Thread.sleep(smallTimeOut);
            navigateToEditCategory();
            getLogger().info("verifying new invalid values should not be saved");
            for (WebElement tdElement : listOfCategoriesItemEle) {
                String isCheckCategory = "";
                Thread.sleep(smallerTimeOut);
                isCheckCategory = tdElement.getAttribute("data-dbdata");
                getLogger().info("SearchValue = " + isCheckCategory);
                if (isCheckCategory.equals(newVlue)) {
                    AbstractService.sStatusCnt++;
                    NXGReports.addStep("Invalid value still appear in list", LogAs.FAILED,
                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

                } else {
                    NXGReports.addStep("Invalid value do not appear in list", LogAs.PASSED, null);
                }
            }
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Invalid value still appear in list", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void editValidCategory(String validValue) throws Exception {
        try {
            getLogger().info("Trying to edit ...");
            scrollPageUp();
            editSameMultiItems(validValue, 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            closeSuccessToastMes();
            NXGReports.addStep("Ending edit valid value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Ending edit valid value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }



    public void editOnlyNumber(int number) throws Exception {
        try {
            getLogger().info("Trying to edit with new Only number...");
            scrollPageUp();
            Thread.sleep(smallTimeOut);
            editSameMultiItems(Integer.toString(number), 1);
            scrollPageDown();
            verifyActiveSaveBtn();
            closeSuccessToastMes();
            NXGReports.addStep("Ending edit only number", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Ending edit only numbe", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void editNullChar(String nullChar) throws Exception {
        try {
            getLogger().info("Trying to edit with null value...");
            scrollPageUp();
            Thread.sleep(smallTimeOut);
            editSameMultiItems(nullValue, 1);
            eleEditCategoryGuide.click();
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            NXGReports.addStep("Eding edit null value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("Eding edit null value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void editSpecialChars(String specialChar) throws Exception {
        try {
            getLogger().info("Trying to edit with special value...");
            scrollPageUp();
            Thread.sleep(smallTimeOut);
            editSameMultiItems(specialChar, 1);
            validateDisPlayedElement(notAValidNameEle, "Warning");
            scrollPageDown();
            verifyUnActiveSaveBtn();
            selectCancelBtn();
            NXGReports.addStep("User can not save special value", LogAs.PASSED, null);
        } catch (Exception e) {
            NXGReports.addStep("User still save special value", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }


    public void removeItem(int numberOfRemovedItem) throws Exception {
        try {
            int numberItemsBefore = verifyListOfCurrentCategories(listOfCategoriesItemEle);
            System.out.println("number of items before removed: " + numberItemsBefore);
            scrollPageUp();
            removeCategories(numberOfRemovedItem);
            scrollPageDown();
            verifyActiveSaveBtn();
            closeSuccessToastMes();
            getLogger().info("verifying item was removed or not...");
            navigateToEditCategory();
            verifyItemsRemovedOrNot(numberItemsBefore, numberOfRemovedItem, listOfCategoriesItemEle);
            NXGReports.addStep("Remove Items.", LogAs.PASSED, null);
        } catch (Exception e) {
            AbstractService.sStatusCnt++;
            NXGReports.addStep("Remove Items.", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }
    }

    public int randomNumberForCategoryItems() {
        Random randNum = new Random();
        int intRanNum = randNum.nextInt(3) + 1;
        return intRanNum;
    }

    public void verifyHoverOnCategoryItem() {

        try {
            getLogger().info("Verifying Trash and Pen appear after hovered on item..");
            waitForVisibleElement(listOfCategoriesItemEle.get(0), "Category item 1");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditPenEle.get(0), "Pen 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            getLogger().info("Verifying Item is removed temporary when select Trash icon..");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyActiveRemoveStatus();
            getLogger().info("Verifying item returned to previous status if user select Trash icon again..");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyUnActiveRemoveStatus();
            validateDisPlayedElement(eleEditCategoryCancelBtn, "Cancel btn");
            eleEditCategoryCancelBtn.click();
            Thread.sleep(1000);
            navigateToEditCategory();

            NXGReports.addStep("Hover works as expected", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Hover works as unexpected", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }


    public void verifyHoverOnCategoryItem_TodoListPage() {

        try {
            getLogger().info("Verifying Trash and Pen appear after hovered on item..");
            waitForVisibleElement(listOfCategoriesItemEle.get(0), "Category item 1");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditPenEle.get(0), "Pen 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            getLogger().info("Verifying Item is removed temporary when select Trash icon..");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyActiveRemoveStatus();
            getLogger().info("Verifying item returned to previous status if user select Trash icon again..");
            hoverElement(listOfCategoriesItemEle.get(0), "Category item 1");
            validateDisPlayedElement(listOfEditTrashEle.get(0), "Trash 1");
            listOfEditTrashEle.get(0).click();
            Thread.sleep(smallerTimeOut);
            verifyUnActiveRemoveStatus();
            validateDisPlayedElement(eleEditCategoryCancelBtn, "Cancel btn");
            eleEditCategoryCancelBtn.click();
            Thread.sleep(1000);
            navigateToEditCategory();

            NXGReports.addStep("Hover works as expected", LogAs.PASSED, null);

        } catch (Exception e) {
            NXGReports.addStep("Hover works as unexpected", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

        }
    }

    public void verifyActiveRemoveStatus() {

        if (listOfCategoriesItemEle.get(0).getAttribute("data-del").equals("1")) {

            NXGReports.addStep("Item is temporary removed", LogAs.PASSED, null);

        } else {
            NXGReports.addStep("Item is not temporary removed", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

    public void verifyUnActiveRemoveStatus() {
        if (listOfCategoriesItemEle.get(0).getAttribute("data-del").equals("0")) {
            NXGReports.addStep("Item returned to unActiveRemove", LogAs.PASSED, null);

        } else {
            NXGReports.addStep("Item did not return to unActiveRemoved", LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
        }

    }

}
