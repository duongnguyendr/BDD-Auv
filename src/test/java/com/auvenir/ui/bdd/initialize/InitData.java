package com.auvenir.ui.bdd.initialize;

import com.auvenir.ui.bdd.common.mongoBD.MongoDBProperties;
import com.auvenir.ui.bdd.common.Generic;
import com.auvenir.ui.bdd.common.mongoBD.MongoDBService;
import com.auvenir.ui.bdd.stepDefinitions.AbstractStep;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
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
            dropAllCollections(db);
            initUser("User1");
            initUserRoleMapping("User1");
            initUser("User2");
            initUserRoleMapping("User2");
//            initUser("User3");
//            initUser("User4");
//            initUser("User5");
//            initUser("User6");

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
        return Generic.getTestDataFromExcelNoBrowserPrefix("usersRegression", user, columnName);
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


}
