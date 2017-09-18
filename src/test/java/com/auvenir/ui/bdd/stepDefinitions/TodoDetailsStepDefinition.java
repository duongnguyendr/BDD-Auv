package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.common.KeyWord;
import com.auvenir.ui.bdd.pages.common.TodoDetailsPage;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

/**
 * Created by huy.huynh on 9/18/2017.
 */
public class TodoDetailsStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoDetailsStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    //AuditorTodoPage auditorTodoPage;
    private TodoDetailsPage todoDetailsPage;
    private KeyWord keyWord;

    public TodoDetailsStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        //auditorTodoPage = new AuditorTodoPage(logger,driver);
        todoDetailsPage = new TodoDetailsPage(logger, driver);
    }

    @Then("^I input comment content: \"([^\"]*)\"$")
    public void verifyTodoDetailOpened(String commentContent) throws Throwable {
        logger.info("===== I input comment content =====");
        todoDetailsPage.inputCommentWithContent(commentContent);
    }

    @Then("^I click on post comment button$")
    public void clickOnConfirmDeleteButton() throws Throwable {
        logger.info("===== I click on post comment button =====");
        int numberOfListCommentlist = todoDetailsPage.getNumberOfListComment();
        todoDetailsPage.clickOnPostCommentButton();
        todoDetailsPage.waitForSizeListCommentChanged(numberOfListCommentlist);
    }

    @Then("^I should see this comment display on list: \"([^\"]*)\"$")
    public void verifyCommentDisplay(String commentContent) throws Throwable {
        logger.info("===== I should see this comment display on list =====");
        todoDetailsPage.verifyCommentContentIsDisplayed(commentContent);
    }

    //    @And("^I select todo: \"([^\"]*)\" check box on todo page$")
    //    public void iSelectTodoCheckBoxOnTodoPage(String todoName) throws Throwable {
    //        // Write code here that turns the phrase above into concrete actions
    //        todoPage.selectToDoCheckboxByName(todoName);
    //    }
}
