package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.codehaus.groovy.ast.tools.GenericsUtils;
import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Created by tan.pham on 7/10/2017.
 */
public class AuditorToDoListDataProvider extends CommonDataProvider{

    private static String subjectContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Subject Email Auditor Invite Client", "Valid Value");
    private static String greetingContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Greeting Content", "Valid Value");
    private static String announcementContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Announcement Content", "Valid Value");
    private static String introducingContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Introducing Content", "Valid Value");
    private static String introducingBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Introducing Benefit Content", "Valid Value");
    private static String firstBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "First Benefit Content", "Valid Value");
    private static String secondBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Second Benefit Content", "Valid Value");
    private static String thirdBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Third Benefit Content", "Valid Value");
    private static String feedBackContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "FeedBack Content", "Valid Value");
    private static String goodbyeContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Goodbye Content", "Valid Value");

    private static String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
    private static String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
    private static String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
    private static String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();
    private static String toDoName02 = "toDoName02" + GeneralUtilities.getTimeStampForNameSuffix();

    private static String categoryName01 = "cate04";
    private static String categoryName02 = "cate05";
    private static String categoryName03 = "cate06";

    private static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    private static String auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
    private static String todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");

    @DataProvider(name="verifyAuditorEmptyTodoListPage")
    public static Object[][] getVerifyAuditorEmptyTodoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name="verifyCreateToDoPageCategorySearchData")
    public static Object[][] getVerifyCreateToDoPageCategorySearchData(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }


    @DataProvider(name="verifyNewCategoryPopup")
    public static Object[][] getVerifyNewCategoryPopup(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name = "verifyButtonFilter")
    public static Object[][] getVerifyButtonFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchPlaceholder")
    public static Object[][] getVerifySearchPlaceholder(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchHover")
    public static Object[][] getVerifySearchHover(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchInputText")
    public static Object[][] getVerifySearchInputText(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDataGridToDoTaskPage")
    public static Object[][] getVerifyDataGridToDoTaskPage(){

        String toDoListNames[] = {"416 To Do Task02", "a To Do Task02", "z To Do Task02", "b To Do Task02", "c To Do Task02"};
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCategoryComboBoxOnCreateToDo")
    public static Object[][] getVerifyCategoryComboBoxOnCreateToDo(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyFilterButton")
    public static Object[][] getVerifyFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyDefaultValueFilterButton")
    public static Object[][] getVerifyDefaultValueFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyBorderOnFilterButton")
    public static Object[][] getVerifyBorderOnFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyChooseAnOptionFilterButton")
    public static Object[][] getVerifyChooseAnOptionFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyUnableAddMoreOptionFilter")
    public static Object[][] getVerifyUnableAddMoreOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "selectAnVaLueOnAssignOptionFilter")
    public static Object[][] getSelectAnVaLueOnAssignOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "clickAndDoNotSelectOptionFilter")
    public static Object[][] getClickAndDoNotSelectOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoTextBox")
    public static Object[][] getVerifyGUIToDoTextBox(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoAddBulkActions")
    public static Object[][] getVerifyGUIToDoAddBulkActions(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUISelectDateDropDownInNewToDoPage")
    public static Object[][] getVerifyGUISelectDateDropDownInNewToDoPage(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyMarkAsComplete")
    public static Object[][] getVerifyMarkAsComplete(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyButtonUndoExist")
    public static Object[][] getVerifyButtonUndoExist(){

        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyButtonUndoStatus")
    public static Object[][] getVerifyButtonUndoStatus(){

        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithCompleteCase")
    public static Object[][] getVerifyUndoActionWithCompleteCase(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithAssignToCase")
    public static Object[][] getVerifyUndoActionWithAssignToCase(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithDeleteCase")
    public static Object[][] getVerifyUndoActionWithDeleteCase(){

        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName02 = "toDoName02" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }



    @DataProvider(name ="verifyGUIDeleteIconInToDoListPage")
    public static Object[][] getVerifyGUIDeleteIconInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultStatusDeleteIconInToDoListPage")
    public static Object[][] getVerifyDefaultStatusDeleteIconInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyGUIDeleteConfirmPopupInToDoListPage")
    public static Object[][] getVerifyGUIDeleteConfirmPopupInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCheckAllCheckBoxInToDoListPage")
    public static Object[][] getVerifyCheckAllCheckBoxInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteButtonInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelButtonInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultEditCategoryGuiAtCreateNewTodoPage")
    public static Object[][] getVerifyDefaultEditCategoryGuiAtCreateNewTodoPage(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, categoryName01, categoryName02, categoryName03}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, categoryName01, categoryName02, categoryName03}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyEditFunctionAtCreateNewTodoPage")
    public static Object[][] getVerifyEditFunctionAtCreateNewTodoPage(){

        String categoryName = "Vien Pham 11111";
        String editCategoryName = "Vien Pham 1308";
        String numberCategoryName = "444";
        String nullCategoryName ="";
        String specialCategoryName ="@#$%^VienPham";


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName, editCategoryName, numberCategoryName, nullCategoryName, specialCategoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName, editCategoryName, numberCategoryName, nullCategoryName, specialCategoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyRemoveFunctionAtTodoListPage")
    public static Object[][] getVerifyRemoveFunctionAtTodoListPage(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName01, categoryName02, categoryName03}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName01, categoryName02, categoryName03}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteMultiToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteMultiToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteAllToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelMultiToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelMultiToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelAllToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    private static Random random = new Random();
    private static String toDoName = "Task-2305" + random.nextInt(1000);
    private static String categoryName = "Category1";

    @DataProvider(name ="verifyCompletedFieldUpdateSuccessful")
    public static Object[][] getVerifyCompletedFieldUpdateSuccessful(){


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCancelCompleteAction")
    public static Object[][] getVerifyCancelCompleteAction(){
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyNotificationAuditorInviteClient")
    public static Object[][] getVerifyNotificationAuditorInviteClient(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor", "Valid Value");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Engagement Name", "Valid Value");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client", "Valid Value");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Email Password", "Valid Value");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Full Name", "Valid Value");
        String auditorFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor Full Name", "Valid Value");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, clientId, clientEmailPassword,
                clientFullName, auditorFullName, subjectContent, greetingContent, announcementContent,
                introducingContent, introducingBenefitContent, firstBenefitContent, secondBenefitContent, thirdBenefitContent, feedBackContent, goodbyeContent}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, clientId, clientEmailPassword,
                                        clientFullName, auditorFullName, subjectContent, greetingContent, announcementContent,
                                        introducingContent, introducingBenefitContent, firstBenefitContent, secondBenefitContent, thirdBenefitContent, feedBackContent, goodbyeContent}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyTodosTextBox")
    public static Object[][] getVerifyTodosTextBox(){
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String number = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Todo Name  01");
        String specialChars = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Todo Name  01");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName,validTodo, number,specialChars, deadlineDate, endDate, startDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName,validTodo, number,specialChars, deadlineDate, endDate, startDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyCategoryComboBox")
    public static Object[][] getVerifyCategoryComboBox(){
        String auditorId = GenericService.getTestDataFromExcel("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  01");
        String categoryName1 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 01");
        String categoryName2 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 02");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName,validTodo, categoryName1,categoryName2, deadlineDate, endDate, startDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName,validTodo, categoryName1,categoryName2, deadlineDate, endDate, startDate}};
        }
        return  arrayData;
    }


    @DataProvider(name = "verifyAuditorInvitingTheClient")
    public static Object[][] getVerifyAuditorInvitingTheClient(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Admin");
        String adminPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Admin Auvenir Password");
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String engagementMessage = "Your engagement invitation has been sent.";
        String clientStatus = "Onboarding";
        Object[][] arrayData = new Object[][]{{clientId, clientEmailPassword, clientFullName, adminId, adminPassword,auditorId, auditorPwd,
                engagementName,deadlineDate, endDate, startDate, engagementMessage, clientStatus}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{clientId, clientEmailPassword, clientFullName, adminId, adminPassword,auditorId, auditorPwd, engagementName,deadlineDate, endDate, startDate, engagementMessage, clientStatus}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyClientLogsInAndActive")
    public static Object[][] getVerifyClientLogsInAndActive(){
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Email Password");
        String clientAuvenirPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String phoneNumber = "0123456789";
        String parentStackHolder = "Titancorpvn";

        Object[][] arrayData = new Object[][]{{clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{clientId, clientEmailPassword, clientAuvenirPassword, engagementName, phoneNumber, parentStackHolder}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyClientAssigneeComboBox")
    public static Object[][] getVerifyClientAssigneeComboBox(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, clientFullName, engagementName, deadlineDate, endDate, startDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, clientFullName, engagementName, deadlineDate, endDate, startDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateTimebox")
    public static Object[][] getVerifyDueDateTimebox(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String sMonth = "07";
        String sDate = "16";
        String sYear = "2017";
        String sCorrectDate = "07/16/2017";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate,
                                              sMonth, sDate, sYear, sCorrectDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate,
                                            sMonth, sDate, sYear, sCorrectDate}};
        }
        return  arrayData;
    }


    @DataProvider(name = "verifyAuditAssigneeBox")
    public static Object[][] getVerifyAuditAssigneeBox(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate,
                auditAssigneeDefault}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate,
                    auditAssigneeDefault}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyTodoPage_Buttons")
    public static Object[][] getVerifyTodoPage_Buttons(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchBox")
    public static Object[][] getVerifySearchBox(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String searchText = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Search Input");
        String searchNumber = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Number Value", "Search Input");
        String searchSpecialCharacter = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Special Chars", "Search Input");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate, searchText, searchNumber,
                searchSpecialCharacter}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate, searchText, searchNumber,
                    searchSpecialCharacter}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyRealTimeSearch")
    public static Object[][] getVerifyRealTimeSearch(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        String validTodo = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Todo Name  02");
        String categoryName3 = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Category Name 03");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Client Assignee");
        String auditAssigneeDefault = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorSignUpTest", "First and Last Name", "Valid Value");
        String sMonth = "07";
        String sDate = "18";
        String sYear = "2017";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate, validTodo, categoryName3,
                clientFullName, auditAssigneeDefault, sMonth, sDate, sYear}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
                arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate, validTodo, categoryName3,
                    clientFullName, auditAssigneeDefault, sMonth, sDate, sYear}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDataGrid")
    public static Object[][] getVerifyDataGrid(){

        auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor");
        auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Engagement Name");
        String deadlineDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "DeadLine Date");
        String endDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "End Date");
        String startDate = GenericService.getTestDataFromExcelNoBrowserPrefix("TodoTestPage", "Valid Value", "Start Date");
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, deadlineDate, endDate, startDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsUI")
    public static Object[][] getVerifyDueDateOnToDoDetailsUI(){

        auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Engagement Name");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsDefaultValue")
    public static Object[][] getVerifyDueDateOnToDoDetailsDefaultValue(){
        auditorPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor Auvenir Password");
        todoName = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "ToDo Name");
        String dueDate = "";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, dueDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, dueDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsDateFormat")
    public static Object[][] getVerifyDueDateOnToDoDetailsDateFormat(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }


    @DataProvider(name = "verifyDueDateOnToDoDetailsHoverOnField")
    public static Object[][] getVerifyDueDateOnToDoDetailsHoverOnField(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsFocusingCurrentDueDate")
    public static Object[][] getVerifyDueDateOnToDoDetailsFocusingCurrentDueDate(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDatePickerOnToDoDetailsDisableDateAfterDueDate")
    public static Object[][] getVerifyDatePickerOnToDoDetailsDisableDateAfterDueDate(){
        String engagementDueDate = "";
        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, engagementDueDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, engagementDueDate}};
        }
        return  arrayData;
    }


    @DataProvider(name = "verifyDueDateOnToDoDetailsChooseAnotherDate")
    public static Object[][] getVerifyDueDateOnToDoDetailsChooseAnotherDate(){
        int selectDate = 0;
        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, selectDate}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName, selectDate}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsDatePickerPreviousMonthIcon")
    public static Object[][] getVerifyDueDateOnToDoDetailsDatePickerPreviousMonthIcon(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsDatePickerNextMonthIcon")
    public static Object[][] getVerifyDueDateOnToDoDetailsDatePickerNextMonthIcon(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsInputDateTime")
    public static Object[][] getVerifyDueDateOnToDoDetailsInputDateTime(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsInputText")
    public static Object[][] getVerifyDueDateOnToDoDetailsInputText(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsInputSpecialCharacter")
    public static Object[][] getVerifyDueDateOnToDoDetailsInputSpecialCharacter(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsChangeDueDateOnTodoDetail")
    public static Object[][] getVerifyDueDateOnToDoDetailsChangeDueDateOnTodoDetail(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsChangeDueDateOnTodoRow")
    public static Object[][] getVerifyDueDateOnToDoDetailsChangeDueDateOnTodoRow(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDueDateOnToDoDetailsMatchWithOnToDoRow")
    public static Object[][] getVerifyDueDateOnToDoDetailsMatchWithOnToDoRow(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPassword, engagementName, todoName}};
        }
        return  arrayData;
    }


}


