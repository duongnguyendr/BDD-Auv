package com.auvenir.ui.bdd.stepDefinitions.monogo;

import com.auvenir.ui.bdd.common.mongoBD.MongoDBService;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by tan.pham on 9/13/2017.
 */
public class MongoStepDefinition {
    @And("^Clear on database$")
    public void clearOnDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeAllActivitiesCollectionOfAUser("chr.vienpham.admin.auditor@gmail.com");
        MongoDBService.removeAllFirmByName("Firm Vien");
        MongoDBService.removeEngagementCreatedByLeadAuditor("chr.vienpham.admin.auditor@gmail.com");
    }

    @And("^Delete all activity of user : \"([^\"]*)\"$")
    public void deleteAllActivityOfUser(String userEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeAllActivitiesCollectionOfAUser(userEmail);
    }

    @And("^Delete all engagement of user : \"([^\"]*)\"$")
    public void deleteAllEngagementOfUser(String userEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeEngagementCreatedByLeadAuditor(userEmail);
    }

    @And("^Delete all firm by name : \"([^\"]*)\"$")
    public void deleteAllFirmByName(String firmName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeAllFirmByName(firmName);
    }

    @And("^Delete all engagement by name : \"([^\"]*)\"$")
    public void deleteAllEngagementByName(String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeEngagementObjectByName(engagementName);
    }

    @And("^Delete all client of user : \"([^\"]*)\"$")
    public void deleteAllClientOfUser(List<String> listEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (String email: listEmail){
            MongoDBService.removeClientAndIndicatedValueByEmail(email);
        }
    }

    @And("^Delete all client of user$")
    public void deleteAllBusinessNameBy(String businessName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeAllBusinessByName(businessName);;
    }

    @And("^Delete all activity of engagement by user  : \"([^\"]*)\"$")
    public void deleteAllActivityOfEngagementByUser(String userEmail) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeAllActivitiesCollectionOfAEngagement(userEmail);
    }

    @And("^Delete engagement name by user  : \"([^\"]*)\", \"([^\"]*)\"$")
    public void deleteEngagementNameByUser(String userEmail, String engagementName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeEngagementCreatedByLeadAuditor(userEmail,engagementName);
    }

    @And("^Delete user by email: \"([^\"]*)\"$")
    public void deleteUserByEmail(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        MongoDBService.removeUserbyEmail( email);
    }
}
