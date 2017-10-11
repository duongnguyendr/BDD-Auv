package com.auvenir.ui.bdd.initialize;

import com.auvenir.ui.bdd.common.mongoBD.MongoDBProperties;
import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.common.mongoBD.MongoDBService;
import com.auvenir.ui.bdd.stepDefinitions.AbstractStep;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.json.JSONArray;
import org.testng.annotations.BeforeSuite;

import javax.sql.rowset.spi.SyncFactoryException;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by tan.pham on 9/12/2017.
 */
public class InitData extends AbstractStep {
    /**
     * create some users for init Regresstion test with multiple roles
     */
    @BeforeSuite
    public void deleteAllOldRecord() throws UnknownHostException {
        try {
            getBaseUrl();
            MongoDBProperties mongoDBProperties = new MongoDBProperties(System.getProperty("serverDomainName"));
            setDataBaseSer(mongoDBProperties.getServerIp());
            setDataBase(mongoDBProperties.getDatabaseName());
            setPort(mongoDBProperties.getPort());
            setUserName(mongoDBProperties.getUserName());
            setPassword(mongoDBProperties.getUserPassword());
            setSSL(mongoDBProperties.getSsl());
            getRunMode();
            //getToEmail();
            //getCcEmail();
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            DB db = MongoClient.getDB(dataBase);



//            DBCollection usersCollection = db.getCollection("users");
            //code to drop all records of collections on DB. TODO: be careful
//            dropAllCollections(db);
//            initUser("User1");
//            initUserRoleMapping("User1");
//            initUser("User2");
//            initUserRoleMapping("User2");

            initAdminAuditor("Admin Auditor");
            initLeadAuditor("Lead Auditor");
            initGeneralAuditor("General Auditor");
            initAdminClient("Admin Client");
            initLeadClient("Lead Client");
            initGeneralClient("General Client");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void dropAllCollections(DB db) {
        Set<String> collectionsName = db.getCollectionNames();
        collectionsName.remove("system.indexes");

        for (String s : collectionsName) {
            //System.out.println("+++++++++++++++++db.getCollectionNames: " + s);
            DBCollection collection = db.getCollection(s);
            collection.drop();
        }
    }


    private String getDataColumn(String user, String columnName) {
        return Generic.getTestDataFromExcelNoBrowserPrefix("SetupUserRoles", user, columnName);
    }

    public void initUser(String userAdd) throws UnknownHostException, SyncFactoryException {
        MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
        com.mongodb.DB db = MongoClient.getDB(dataBase);
        DBCollection usersCollection = db.getCollection("users");
        DBObject adminDBObject = (DBObject) JSON.parse(getDataColumn(userAdd,"User Json"));
        adminDBObject.put("_id", new ObjectId(getDataColumn(userAdd,"ID")));
        ISO8601DateFormat df = new ISO8601DateFormat();
        adminDBObject.put("lastLogin", getDataColumn(userAdd,"Last Login"));
        adminDBObject.put("dateCreated", getDataColumn(userAdd,"Date Created"));

        BasicDBObject access = new BasicDBObject();
        access.put("expires",getDataColumn(userAdd,"Expires"));
        BasicDBObject auth = new BasicDBObject();
        auth.put("id", getDataColumn(userAdd,"Auth Id"));
        auth.put("access", access);
        adminDBObject.put("auth", auth);
        adminDBObject.put("password",getDataColumn(userAdd,"Password"));
        adminDBObject.put("password_salt",getDataColumn(userAdd,"PasswordSalt"));
        usersCollection.insert(adminDBObject);
    }

    public void initUserRoleMapping(String userAdd) throws UnknownHostException, SyncFactoryException {
        MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
        com.mongodb.DB db = MongoClient.getDB(dataBase);
        DBCollection usersCollection = db.getCollection("userRoleMapping");
        DBObject adminDBObject = (DBObject) JSON.parse(getDataColumn(userAdd,"User role mapping Json"));
        adminDBObject.put("_id", new ObjectId(getDataColumn(userAdd,"_id_userRoleMapping")));
        adminDBObject.put("userID", new ObjectId(getDataColumn(userAdd,"ID")));
        adminDBObject.put("firmID", new ObjectId(getDataColumn(userAdd,"firmID_userRoleMapping")));
        usersCollection.insert(adminDBObject);

    }

    public void initAdminAuditor(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init Admin Auditor.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new Firm of Admin Auditor.
            DBCollection firms = db.getCollection("firms");
            DBObject firmsDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm Json"));
            firms.insert(firmsDBObject);
//            System.out.println("Firm ID: " + getDataColumn(userAdd, "firmID"));
//            addFirmPermission(getDataColumn(userAdd, "ID"), getDataColumn(userAdd, "firmID"), firms, true);

            // Create new userRoleMapping Firm_Admin of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 Admin role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);


            // Create engagement
            DBCollection engagement = db.getCollection("engagements");
            DBObject engagementsDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 Json"));
            engagement.insert(engagementsDBObject);

            // Create business
            DBCollection business = db.getCollection("businesses");
            DBObject businessesDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Business Json"));
            business.insert(businessesDBObject);

//            System.out.println("Engagement1 ID: " + getDataColumn(userAdd, "Engagement1 Json"));

        } catch (Exception e) {
            System.out.println("Admin Auditor cannot create successfully.");
            e.printStackTrace();
        }
    }

    public void initLeadAuditor(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init Lead Auditor.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new userRoleMapping Firm_Admin of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);

            // Create engagement
            DBCollection engagement = db.getCollection("engagements");
            DBObject engagementsDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 Json"));
            engagement.insert(engagementsDBObject);


        } catch (Exception e) {
            System.out.println("Lead Auditor cannot create successfully.");
            e.printStackTrace();
        }
    }

    public void initGeneralAuditor(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init General Auditor.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new userRoleMapping Firm_Admin of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);


        } catch (Exception e) {
            System.out.println("Lead Auditor cannot create successfully.");
            e.printStackTrace();
        }
    }

    public void initAdminClient(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init Admin Client.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new userRoleMapping Business_Admin of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement1 Admin role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
//            System.out.println("Engagement1 ID: " + getDataColumn(userAdd, "Engagement1 Json"));

        } catch (Exception e) {
            System.out.println("Admin Client cannot create successfully.");
            e.printStackTrace();
        }
    }

    public void initLeadClient(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init Lead Client.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new userRoleMapping Business_User of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
//            System.out.println("Engagement1 ID: " + getDataColumn(userAdd, "Engagement1 Json"));

        } catch (Exception e) {
            System.out.println("Admin Client cannot create successfully.");
            e.printStackTrace();
        }
    }

    public void initGeneralClient(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init General Client.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");
            DBObject usersDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "User Json"));
            usersCollection.insert(usersDBObject);

            // Create new userRoleMapping Business_User of Admin Auditor.
            DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
            DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);
            usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Engagement2 role mapping Json"));
            usersRoleMapping.insert(usersRoleMappingDBObject);

        } catch (Exception e) {
            System.out.println("Admin Client cannot create successfully.");
            e.printStackTrace();
        }
    }


    public void addFirmPermission(String userID, String firmID, DBCollection firms, boolean isAdmin) {
        DBObject find = new BasicDBObject("_id", new ObjectId(firmID));
        String json = String.format("{$push:{acl:{id:{ \"$oid\" : \"%s\"}, admin:%b}}}", userID, isAdmin);
        DBObject push = (DBObject) JSON.parse(json);
        firms.update(find, push);
    }
}
