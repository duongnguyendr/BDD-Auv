package com.auvenir.utilities.initialize;

import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.testng.annotations.BeforeSuite;

import javax.sql.rowset.spi.SyncFactoryException;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by huy.huynh on 24/05/2017.
 * Updated by Doai. Tran on 18/07/2017
 * Run one time before Regression Testing with config on properties file ./resources/properties/MongoDB.properties
 * Execute this main() to run
 */
public class InitData extends AbstractTest {

    /**
     * create some users for init Regresstion test with multiple roles
     */
    @BeforeSuite
    public void deleteAllOldRecord() throws UnknownHostException {
        try {

            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");

            //code to drop all records of collections on DB. TODO: be careful
            dropAllCollections(db);
            initUser("User1");
            initUser("User2");
            initUser("User3");
            initUser("User4");
            initUser("User5");
            initUser("User6");
            /*DBObject adminDBObject = (DBObject) JSON.parse(getDataColumn("User Json"));
            adminDBObject.put("_id", new ObjectId(getDataColumn("ID")));
            ISO8601DateFormat df = new ISO8601DateFormat();
            adminDBObject.put("lastLogin", getDataColumn("Last Login"));
            adminDBObject.put("dateCreated", getDataColumn("Date Created"));

            BasicDBObject access = new BasicDBObject();
            access.put("expires",getDataColumn("Expires"));
            BasicDBObject auth = new BasicDBObject();
            auth.put("id", getDataColumn("Auth Id"));
            auth.put("access", access);
            adminDBObject.put("auth", auth);
            adminDBObject.put("password",getDataColumn("Password"));
            adminDBObject.put("password_salt",getDataColumn("PasswordSalt"));
            usersCollection.insert(adminDBObject);*/

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
        return GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", user, columnName);
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

    /*private static String userJsonStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "User Json");
    private static String iDStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "ID");
    private static String lastLoginStr= GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Last Login");
    private static String dateCreatedStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Date Created");
    private static String expiresStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Expires");
    private static String authIDsStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Auth Id");
    private static String passwordStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Password");
    private static String passwordSaltStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "PasswordSalt");*/


    /*private static String userJsonStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "User Json");
    private static String iDStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "ID");
    private static String lastLoginStr2= GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Last Login");
    private static String dateCreatedStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Date Created");
    private static String expiresStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Expires");
    private static String authIDsStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Auth Id");
    private static String passwordStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Password");
    private static String passwordSaltStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "PasswordSalt");

    private static String userJsonStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "User Json");
    private static String iDStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "ID");
    private static String lastLoginStr3= GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "Last Login");
    private static String dateCreatedStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "Date Created");
    private static String expiresStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "Expires");
    private static String authIDsStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "Auth Id");
    private static String passwordStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "Password");
    private static String passwordSaltStr3 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User3", "PasswordSalt");

    @DataProvider(name ="initUserAndMapping")
    public static Object[][] getInitUserAndMapping() {
        return  new Object[][]{{userJsonStr,iDStr,lastLoginStr,dateCreatedStr,expiresStr,authIDsStr,passwordStr, passwordSaltStr},
                {userJsonStr2,iDStr2, lastLoginStr2,dateCreatedStr2,expiresStr2,authIDsStr2,passwordStr2,passwordSaltStr2},
                {userJsonStr3,iDStr3, lastLoginStr3,dateCreatedStr3,expiresStr3,authIDsStr3,passwordStr3,passwordSaltStr3}};
    }
    @Test(priority = 1, enabled = true, description = "Initialize data before testing.",dataProvider = "initUserAndMapping")
    public void initUser(String userJsonStr,String iDStr,String lastLoginStr,
            String dateCreatedStr,String expiresStr,String authIDsStr, String passwordStr, String passwordSaltStr) throws UnknownHostException {
        try {

            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");

            //code to drop all records of collections on DB. TODO: be careful
            //dropAllCollections(db);

            DBObject adminDBObject = (DBObject) JSON.parse(userJsonStr);
            adminDBObject.put("_id", new ObjectId(iDStr));
            ISO8601DateFormat df = new ISO8601DateFormat();
            adminDBObject.put("lastLogin", lastLoginStr);
            adminDBObject.put("dateCreated", dateCreatedStr);

            BasicDBObject access = new BasicDBObject();
            access.put("expires",expiresStr);
            BasicDBObject auth = new BasicDBObject();
            auth.put("id", authIDsStr);
            auth.put("access", access);
            adminDBObject.put("auth", auth);
            adminDBObject.put("password",passwordStr);
            adminDBObject.put("password_salt",passwordSaltStr);
            usersCollection.insert(adminDBObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
