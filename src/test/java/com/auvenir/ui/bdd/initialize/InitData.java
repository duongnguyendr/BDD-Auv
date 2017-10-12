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
            initAdminUser("Super Admin");
            initAdminUser("Admin User");
//            initUserRoleMapping("Admin User");

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

    public void initAdminUser(String userAdd) throws UnknownHostException, SyncFactoryException {
        MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
        com.mongodb.DB db = MongoClient.getDB(dataBase);
        DBCollection usersCollection = db.getCollection("users");
//        System.out.println("Json parse: " + (DBObject) JSON.parse(getDataColumn(userAdd,"User Json")));
        DBObject adminDBObject = (DBObject) JSON.parse(getDataColumn(userAdd,"User Json"));
        usersCollection.insert(adminDBObject);

        DBCollection firms = db.getCollection("firms");
        DBObject firmsDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm Json"));
        firms.insert(firmsDBObject);

        // Create new userRoleMapping Firm_Admin of Admin Auditor.
        DBCollection usersRoleMapping = db.getCollection("userRoleMapping");
        DBObject usersRoleMappingDBObject = (DBObject) JSON.parse(getDataColumn(userAdd, "Firm User role mapping Json"));
        usersRoleMapping.insert(usersRoleMappingDBObject);

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
            System.out.println("General Auditor cannot create successfully.");
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

        } catch (Exception e) {
            System.out.println("Lead Client cannot create successfully.");
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
            System.out.println("General Client cannot create successfully.");
            e.printStackTrace();
        }
    }

}
