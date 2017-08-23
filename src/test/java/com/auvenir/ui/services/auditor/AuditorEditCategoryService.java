package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.engagement.AuditorEditCategoriesPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 5/10/2017.
 */
public class AuditorEditCategoryService extends AbstractService {

    AuditorEditCategoriesPage auditorEditCategoryPage;

    /*
 * contructor
 */
    public AuditorEditCategoryService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorEditCategoryPage = new AuditorEditCategoriesPage(getLogger(), getDriver());
    }

    public void navigateToEditAtCreateTodoPage() throws Exception {

        auditorEditCategoryPage.navigateToEditCategory();

    }

//    public void navigateToEditAtTodoListPage() throws Exception {
//
//        auditorEditCategoryPage.selectEditCategoriesAtTodoPage();
//    }

    public void returnToCreateNewTodoPage() {
        auditorEditCategoryPage.returnToCreateNewTodoPage();
    }

    public void verifyEditCategoriesTitle() {

        auditorEditCategoryPage.verifyEditCategoriesPopupTitle();
    }

    public void verifyEditCategoriesGuide() {

        auditorEditCategoryPage.verifyEditCategoriesPopupGuide();
    }

    public void hoverOnCategoryItem() {
        auditorEditCategoryPage.verifyHoverOnCategoryItem();
    }

    public void hoverOnCategoryItem_TodoListPage() {
        auditorEditCategoryPage.verifyHoverOnCategoryItem_TodoListPage();
    }


    public void verifyDefaultCancelButton() throws Exception {

        auditorEditCategoryPage.verifyCancelBtn();
    }


    public void verifyDefaultSaveButton() throws Exception {
        auditorEditCategoryPage.verifyDefaultSaveBtn();
    }

    public void editValidValue(String newValue) throws Exception {

        auditorEditCategoryPage.editValidCategory(newValue);

    }

    public void verifyValidValue(String comparedValue) {
        auditorEditCategoryPage.verifyCategoriesSaved(comparedValue);
    }


    public void editOnlyNumber(int number) throws Exception {
        auditorEditCategoryPage.editOnlyNumber(number);

    }

    public void verifyNumber(int comparedNumber) {
        auditorEditCategoryPage.verifyCategoriesSaved(Integer.toString(comparedNumber));
    }


    public void editNullChars(String nullChars) throws Exception {
        auditorEditCategoryPage.editNullChar(nullChars);

    }

    public void verifyNullChars(String nullChars) throws Exception {
        auditorEditCategoryPage.verifyCategoriesNotSaved(nullChars);
    }

    public void editSpecialChars(String specialChar) throws Exception {
        auditorEditCategoryPage.editSpecialChars(specialChar);
    }

    public void verifySpecialChars(String specialChar) throws Exception {

        auditorEditCategoryPage.verifyCategoriesNotSaved(specialChar);
    }


    public void removeItem(int numberOfRemovedItem) throws Exception {
        auditorEditCategoryPage.removeItem(numberOfRemovedItem);


    }

}










