package com.auvenir.ui.bdd.stepDefinitions;

import com.auvenir.ui.bdd.base.BaseInit;
import com.auvenir.ui.bdd.pages.common.TodoDetailsPage;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

/**
 * Created by huy.huynh on 18/09/2017.
 */
public class TodoDetailsStepDefinition extends BaseInit {
    private static Logger logger = Logger.getLogger(TodoDetailsStepDefinition.class.getSimpleName());
    private BaseInit baseInit;
    private TodoDetailsPage todoDetailsPage;

    public TodoDetailsStepDefinition(BaseInit baseInit) {
        this.baseInit = baseInit;
        todoDetailsPage = new TodoDetailsPage(logger, driver);
    }

    @Then("^I input comment content: \"([^\"]*)\"$")
    public void inputCommentContent(String commentContent) throws Throwable {
        logger.info("===== I input comment content =====");
        todoDetailsPage.inputCommentWithContent(commentContent);
    }

    @Then("^I click on post comment button$")
    public void clickOnPostCommentButton() throws Throwable {
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
}
