package com.auvenir.ui.dataprovider.commonData;

import com.auvenir.utilities.GenericData;
import com.auvenir.utilities.GenericService;

/**
 * Created by thuan.duong on 7/13/2017.
 *
 * Some Common Data for Testing script will be define in this class. All Class Data Provider will be extends from this class.
 * All this data login of Auvenir User does not use for modified testing.
 */
public class CommonDataProvider {
    //Data login of Auditor User. Not use for modified testing user.
    protected static String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
    protected static String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");

    //Data login of Client User. Not use for modified testing user.
    protected static String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Client");
    protected static String clientPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Client");

    //Data login of Admin User. Not use for modified testing user.
    protected static String adminId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Admin");
    protected static String adminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Admin");

    //Data login of Super Admin User. Not use for modified testing user.
    protected static String superAdminUser = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Super Admin");
    protected static String superAdminPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Super Admin");

    //Data Provider of Auditor To Do Page.
    protected static String engagementType = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Type", "Valid Data");
    protected static String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Company Name", "Valid Data");
    protected static String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
    protected static String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
    protected static String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Category Name", "Valid Data");

    //Enum Status Value
    protected static String onboardingStatus = GenericData.UserStatus.ONBOARDING.value;
    protected static String waitListedStatus = GenericData.UserStatus.WAITLISTED.value;
    protected static String activeStatus = GenericData.UserStatus.ACTIVE.value;
    protected static String inactiveStatus = GenericData.UserStatus.INACTIVE.value;
    protected static String lockedStatus = GenericData.UserStatus.LOCKED.value;

    //Enum UserRole Value
    protected static String clientRole = GenericData.UserRole.Client.value;
    protected static String auditorRole = GenericData.UserRole.Auditor.value;
    protected static String adminRole = GenericData.UserRole.Admin.value;
    protected static String superAdminRole = GenericData.UserRole.SuperAdmin.value;


    //Emum RoleCompanyMember Value
    protected static String partnerRole = GenericData.RoleCompanyMember.PARTNER.value;


}
