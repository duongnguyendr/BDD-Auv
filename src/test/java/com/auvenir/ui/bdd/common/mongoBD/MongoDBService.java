package com.auvenir.ui.bdd.common.mongoBD;

//import com.auvenir.ui.tests.AbstractTest;

import com.auvenir.ui.bdd.common.GeneralUtilities;
import com.auvenir.ui.bdd.common.Generic;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.sql.rowset.spi.SyncFactoryException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static com.auvenir.ui.bdd.base.BaseInit.baseUrl;
import static com.auvenir.ui.bdd.common.Generic.sDirPath;
import static com.mongodb.MongoClientOptions.builder;
import static javax.sql.rowset.spi.SyncFactory.getLogger;

/*===================================================================
 * Created by doai.tran on 4/24/2017.
 * Description:
 *
 *=================================================================== */
public class MongoDBService {
    private static String dataBaseSer;
    private static int port;
    private static String DB;
    private static String username;
    private static String ssl;
    private static String password;
    public static String sTestDataFile = sDirPath + "\\testData.xlsx";
    private static String testCaseId;
    static String[] sData = null;

    private static void configurateDatabase() {
//        MongoDBProperties mongoDBProperties = new MongoDBProperties((baseUrl));
//        dataBaseSer = mongoDBProperties.getServerIp();
//        port = Integer.valueOf(mongoDBProperties.getPort());
//        DB = mongoDBProperties.getDatabaseName();
//        username = mongoDBProperties.getUserName();
//        password = mongoDBProperties.getUserPassword();
//        ssl = mongoDBProperties.getSsl();
        MongoDBProperties mongoDBProperties = new MongoDBProperties((baseUrl));
        dataBaseSer = "192.168.1.222";
        port = 27017;
        DB = "auvenir";
        username = "";
        password = "";
        ssl = "no";
    }

    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to create a connection to DB server.
    Improve: 5/18/2017
     =================================================================== */
    public static MongoClient connectDBServer(String ServerHost, int portNo, String DB, String username,
                                              String password,
                                              String SSL) throws UnknownHostException, SyncFactoryException {
        try {
            MongoClient mongoClient = null;
            if (SSL.equalsIgnoreCase("yes")) {
                char[] pwd = password.toCharArray();
                MongoCredential credential = MongoCredential
                        .createCredential(username, DB, pwd); // user "myadmin" on admin database
                List<MongoCredential> credentials = Collections.singletonList(credential);
                ServerAddress hosts = new ServerAddress(ServerHost + ":" + portNo);
                MongoClientOptions.Builder options = builder().sslEnabled(true).sslInvalidHostNameAllowed(true);
                mongoClient = new MongoClient(hosts, credentials, options.build());
            } else if (SSL.equalsIgnoreCase("no") && GeneralUtilities.isEmptyString(username) && GeneralUtilities
                    .isEmptyString(password)) {
                mongoClient = new MongoClient(ServerHost, portNo);
            }
            //getLogger().info("Connected successfully.");
            System.out.println("Connected successfully.");
            return mongoClient;
        } catch (Exception e) {
            //getLogger().info("Unable to connect to DB: "+ e.getMessage());
            System.out.println("Unable to connect to DB: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to insert a new owner to DB server.
     =================================================================== */
    public static void insertOwner(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "owners");

            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("owners");
            BasicDBObject document = new BasicDBObject("_id", new ObjectId(sData[1]));

            document.put("ownerUID", sData[2]);
            document.put("uid", sData[3]);
            document.put("status", sData[4]);
            document.put("dateCreated", sData[5]);

            List<DBObject> array = new ArrayList<DBObject>();
            BasicDBObject documentfin = new BasicDBObject();
            documentfin.put("consumerID", sData[6]);
            documentfin.put("institutionID", sData[7]);
            documentfin.put("status", sData[8]);
            array.add(documentfin);
            document.put("finCustomer", array);
            table.insert(document);
            getLogger().info("Insert owner successfully.");
        } catch (Exception e) {
            getLogger().info("Insert owner successfully." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to delete a new owner to DB server.
     =================================================================== */
    public static void deleteOwner(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "owners");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("owners");
            BasicDBObject document = new BasicDBObject();
            document.put("ownerUID", sData[2]);
            table.remove(document);
            getLogger().info("Delete owner successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete owner." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: DoaiTran    - 24-Apr-2017 -
    In order to insert a new Customer to DB server.
     =================================================================== */
    public static void insertConsumer(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "consumers");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("consumers");
            BasicDBObject document = new BasicDBObject("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("institutionID", new ObjectId(sData[3]));
            document.put("consumerUID", sData[4]);
            document.put("userID", sData[5]);
            document.put("callbackURL", sData[6]);
            document.put("status", sData[7]);
            document.put("integration", sData[8]);
            document.put("dateCreated", sData[9]);
            document.put("finLoginID", sData[10]);
            table.insert(document);
            getLogger().info("Insert consumer successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to insert consumer." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to delete a customer to DB server.
     =================================================================== */
    public static void deleteConsumer(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "consumers");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("consumers");
            BasicDBObject document = new BasicDBObject();
            document.put("consumerUID", sData[4]);
            table.remove(document);
            getLogger().info("Delete consumer successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete consumer." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new institution to DB server.
     =================================================================== */
    public static void insertInstitution(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "institutions");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", new ObjectId(sData[1]));
            document.put("integration", sData[2]);
            document.put("dateCreated", sData[3]);
            document.put("finID", sData[4]);
            document.put("name", sData[5]);
            document.put("typeDescription", sData[6]);
            document.put("urlHomeApp", sData[7]);
            document.put("urlLogonApp", sData[8]);
            document.put("urlProductApp", sData[9]);
            document.put("phone", sData[10]);
            document.put("currency", sData[11]);
            document.put("email", sData[12]);
            document.put("specialText", sData[13]);
            document.put("address", sData[14]);
            document.put("raw", sData[15]);
            table.insert(document);
            getLogger().info("Insert Institution successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to insert Institution." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a customer to DB server.
     =================================================================== */
    public static void deleteInstitution(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "institutions");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
            document.put("finID", sData[4]);
            table.remove(document);
            getLogger().info("Delete Institution successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete Institution." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new ConsumerAccount to DB server.
     =================================================================== */
    public static void insertConsumerAccount(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "consumerAccounts");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("consumerAccounts");
            BasicDBObject document = new BasicDBObject();

            document.put("_id", new ObjectId(sData[1]));
            document.put("consumerID", new ObjectId(sData[2]));
            document.put("status", sData[3]);
            document.put("dateCreated", sData[4]);
            document.put("selected", new Boolean(sData[5]));
            document.put("dateSelected", sData[6]);
            document.put("finAccountID", sData[7]);
            document.put("number", sData[8]);
            document.put("name", sData[9]);
            document.put("type", sData[10]);
            document.put("loaded", new Boolean(sData[11]));
            document.put("dateLoaded", sData[12]);
            document.put("loadFailCode", sData[13]);
            document.put("txnFromDate", sData[14]);
            document.put("txnToDate", sData[15]);
            table.insert(document);
            getLogger().info("Insert ConsumerAccount successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to insert ConsumerAccount." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a ConsumerAccount to DB server.
     =================================================================== */
    public static void deleteConsumerAccount(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "consumerAccounts");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("consumerAccounts");
            BasicDBObject document = new BasicDBObject();
            document.put("finAccountID", sData[7]);
            table.remove(document);
            getLogger().info("Delete ConsumerAccount successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete ConsumerAccount." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new Account to DB server.
     =================================================================== */
    public static void insertAccount(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "accounts");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("accounts");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("institutionID", sData[3]);
            document.put("integration", sData[4]);
            document.put("dateCreated", sData[5]);
            document.put("finID", sData[6]);
            document.put("finCustomerID", sData[7]);
            document.put("finInstitutionID", sData[8]);
            document.put("finLoginID", sData[9]);
            document.put("number", sData[10]);
            document.put("name", sData[11]);
            document.put("status", sData[12]);
            document.put("type", sData[13]);
            document.put("balance", sData[14]);
            document.put("balanceDate", sData[15]);
            document.put("currency", sData[16]);
            document.put("finDateCreated", sData[17]);
            document.put("lastTransactionDate", sData[18]);
            document.put("raw", sData[19]);
            table.insert(document);
            getLogger().info("Insert Account successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to Insert Account." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a Account to DB server.
     =================================================================== */
    public static void deleteAccount(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "accounts");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("accounts");
            BasicDBObject document = new BasicDBObject();
            document.put("institutionID", sData[3]);
            table.remove(document);
            getLogger().info("Delete Account successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete Account." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: DoaiTran    - 26-Apr-2017 -
    In order to insert a new AuthSession to DB server.
     =================================================================== */
    public static void insertAuthSession(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "authSessions");
            configurateDatabase();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("authSessions");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("consumerID", sData[3]);
            document.put("dateCreated", sData[4]);
            document.put("expires", sData[5]);
            document.put("state", sData[6]);
            document.put("previousState", sData[7]);
            document.put("socketID", sData[8]);
            document.put("provider", sData[9]);
            document.put("finCustomerID", sData[10]);
            document.put("finLoginID", sData[11]);
            document.put("uid", sData[12]);
            document.put("userID", sData[13]);
            document.put("callbackURL", sData[14]);
            document.put("ownerUID", sData[15]);
            document.put("consumerUID", sData[16]);
            // loginForm

            List<DBObject> arrayLoginForm = new ArrayList<DBObject>();
            BasicDBObject documentLoginForm = new BasicDBObject();
            documentLoginForm.put("dateCreated", sData[17]);
            documentLoginForm.put("formDetails", sData[18]);
            arrayLoginForm.add(documentLoginForm);
            document.put("loginForm", arrayLoginForm);

            // mfa
            List<DBObject> arrayMfa = new ArrayList<DBObject>();
            BasicDBObject documentMfa = new BasicDBObject();
            documentMfa.put("dateCreated", sData[19]);
            documentMfa.put("details", sData[20]);
            arrayMfa.add(documentMfa);
            document.put("mfa", arrayMfa);

            // institution

            List<DBObject> arrayInstitution = new ArrayList<DBObject>();
            BasicDBObject documentInstitution = new BasicDBObject();
            documentInstitution.put("dateCreated", sData[21]);
            documentInstitution.put("finID", sData[22]);
            documentInstitution.put("name", sData[23]);
            documentInstitution.put("authorized", sData[24]);
            documentInstitution.put("rawSource", sData[25]);
            arrayInstitution.add(documentInstitution);
            document.put("institution", arrayInstitution);

            document.put("accounts", sData[26]);
            table.insert(document);
            getLogger().info("Insert AuthSession successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to insert AuthSession." + e.getMessage());
            e.printStackTrace();
        }
    }

    /* ===================================================================
    Created by: Doai.Tran    - 26-Apr-2017 -
    In order to delete a AuthSession to DB server.
     =================================================================== */
    public static void deleteAuthSession(String valueId) throws UnknownHostException, SyncFactoryException {
        try {
            sData = Generic.toReadExcelData(valueId, "authSessions");
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("authSessions");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", sData[1]);
            table.remove(document);
            getLogger().info("Delete AuthSession successfully.");
        } catch (Exception e) {
            getLogger().info("Unable to delete AuthSession." + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Merged by huy.huynh on 22/05/2017.
     */

    /**
     * get DBCollection object of given DB name and collection
     *
     * @param collectionName engagement value chosen as value
     */
    public static DBCollection getCollection(String collectionName) throws Exception {
        configurateDatabase();
        MongoClient mongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
        com.mongodb.DB db = mongoClient.getDB(DB);
        return db.getCollection(collectionName);
    }

    /**
     * get To-Do object of given name
     *
     * @param dBCollection DBCollection object
     * @param field        of engagement want to query
     * @param value        of engagement want to query
     * @param name         of to-do
     */
    public static JSONObject getToDoObject(DBCollection dBCollection, String field, String value,
                                           String name) throws Exception {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(field, value);
        DBCursor cursor = dBCollection.find(searchQuery);
        DBObject dBbject = cursor.next();

        JSONObject output = new JSONObject(new JSON().serialize(dBbject));
        JSONArray jsonArray = output.getJSONArray("todos");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            if (object.get("name").toString().equals(name)) {
                return object;
            }
        }
        return null;
    }

    /**
     * get User object of given string first name and last name(ex: 'huy huynh')
     *
     * @param dBCollection DBCollection object
     * @param name         user name
     */
    public static String getUserObjectByFirstNameLastName(DBCollection dBCollection, String name) throws Exception {
        String[] assignee = name.split(" ");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("firstName", assignee[0]);
        searchQuery.put("lastName", assignee[1]);
        DBCursor cursor = dBCollection.find(searchQuery);
        DBObject dBbject = cursor.next();

        return dBbject.get("_id").toString();
    }

    /**
     * remove given email user on database
     *
     * @param dBCollection DBCollection object
     * @param email        of user want to query
     */
    public static void removeUserObjectByEmail(DBCollection dBCollection, String email) {
        try {
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("email", email);
            DBCursor cursor = dBCollection.find(searchQuery);
            DBObject dBbject = cursor.next();

            dBCollection.remove(dBbject);
            System.out.println("Removed user map with email: " + email);
        } catch (NoSuchElementException ex) {
            System.out.println("This email not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Update attribute of users.
     *
     * @param dBCollection DBCollection object
     * @param email        email want to query
     * @param field        field wanna change
     * @param value        new value for this field
     */
    public static void changeUserObjectField(DBCollection dBCollection, String email, String field, String value) {
        try {
            BasicDBObject changeQuery = new BasicDBObject();
            changeQuery.append("$set", new BasicDBObject().append(field, value));

            BasicDBObject searchQuery = new BasicDBObject().append("email", email);

            dBCollection.update(searchQuery, changeQuery);
        } catch (NoSuchElementException ex) {
            System.out.println("This email not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * verify that given email exist on DB with status ACTIVE and type AUDITOR
     *
     * @param dBCollection DBCollection object
     * @param email        email to find
     */
    public static boolean verifyUserEmailTypeStatusExist(DBCollection dBCollection, String email) throws Exception {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("email", email);
        searchQuery.put("status", "ACTIVE");
        searchQuery.put("type", "AUDITOR");
        DBCursor cursor = dBCollection.find(searchQuery);
        DBObject dBbject = cursor.next();

        return dBbject != null ? true : false;
    }

    /**
     * Re-create a user with info on 'usersRegression' sheet
     *
     * @param email email to re-create
     */
    public static void createUserByEmail(String email) {
        try {
            String[][] data = Generic.readExcelSheetData("usersRegression");

            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            System.out.println("MongoClient = " + MongoClient);
            DB db = MongoClient.getDB(DB);
            //            MongoClient mongoClient = new MongoClient("192.168.1.213", 27017);
            //            DB db = mongoClient.getDB("auvenir");

            DBCollection usersCollection = db.getCollection("users");
            DBCollection firmsCollection = db.getCollection("firms");
            DBCollection businessesCollection = db.getCollection("businesses");

            System.out.println("businessesCollection = " + businessesCollection);

            for (int i = 0; i < data.length; i++) {
                if (data[i][0].toString().equals(email)) {
                    DBObject usersDBObject = (DBObject) JSON.parse(data[i][9]);
                    DBObject mappingDBObject = (DBObject) JSON.parse(data[i][10]);

                    usersDBObject.put("_id", new ObjectId(data[i][4]));

                    ISO8601DateFormat df = new ISO8601DateFormat();
                    usersDBObject.put("lastLogin", df.parse(data[i][5]));
                    usersDBObject.put("dateCreated", df.parse(data[i][6]));

                    BasicDBObject access = new BasicDBObject();
                    access.put("expires", df.parse(data[i][8]));
                    BasicDBObject auth = new BasicDBObject();
                    auth.put("id", data[i][7]);
                    auth.put("access", access);
                    usersDBObject.put("auth", auth);
                    usersCollection.insert(usersDBObject);

                    BasicDBObject userInMapping = new BasicDBObject();
                    userInMapping.put("id", new ObjectId(data[i][4]));
                    userInMapping.put("admin", true);
                    List<BasicDBObject> usersInMapping = new ArrayList<>();
                    usersInMapping.add(userInMapping);
                    mappingDBObject.put("acl", usersInMapping);

                    if (data[i][1].toString().equals("AUDITOR")) {
                        firmsCollection.insert(mappingDBObject);
                    } else if (data[i][1].toString().equals("CLIENT")) {
                        businessesCollection.insert(mappingDBObject);
                    } else {
                        System.out.println("Admin created");
                    }
                }
            }
            System.out.println("Re-created user map with email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * remove given name engagement on database
     *
     * @param name of engagement want to query
     */
    public static void removeEngagementObjectByName(String name) {
        try {
            DBCollection dBCollection = getCollection("engagements");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", name);
            DBCursor cursor = dBCollection.find(searchQuery);
            DBObject dBbject = cursor.next();
            while (dBbject != null) {
                System.out.println("     cursor.next() = " + dBbject);
                dBCollection.remove(dBbject);
                dBbject = cursor.next();
            }
            System.out.println("Removed engagement named: " + name);
        } catch (NoSuchElementException ex) {
            System.out.println("This engagement not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get the Object ID of Email Users in 'users' collection.
     *
     * @param email String email which is a email value in 'users' collection.
     * @return String Object ID of Email Users.
     */
    public static String getObjectIdOfEmailUser(String email) {
        String objectId = null;
        try {
            DBCollection dBCollection = getCollection("users");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("email", email);
            DBCursor cursor = dBCollection.find(searchQuery);
            int count = 0;
            while (cursor.hasNext()) {
                DBObject dBbject = cursor.next();
                // shows the whole result document
                ObjectId aclObject = (ObjectId) dBbject.get("_id");
                System.out.println("ObjectID User: " + aclObject.toString());
                objectId = aclObject.toString();
                count++;
            }
            if (count == 0)
                System.out.println("This users not exist on database.");
        } catch (NoSuchElementException ex) {
            System.out.println("This users not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objectId;
    }

    /**
     * Remove all the email(Object ID) in 'acl' array object in 'engagements' collection.
     *
     * @param email the String email which has object ID displayed in 'acl' array object.
     */
    public static void removeInvitedClientInEngagementCollection(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("engagements");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    System.out.println("Engagement ObjectID: " + dBbject.get("_id"));
                    BasicDBObject aclObject = new BasicDBObject("acl", new BasicDBObject("id", new ObjectId(objectId)));
                    dBCollection.update(searchQuery, new BasicDBObject("$pull", aclObject));
                    BasicDBObject toDoObject = new BasicDBObject("todos",
                            new BasicDBObject("clientAssignee", new ObjectId(objectId)));
                    dBCollection.update(searchQuery, new BasicDBObject("$pull", toDoObject));
                    BasicDBObject businessObject = new BasicDBObject("business",
                            new BasicDBObject("keyContact", new ObjectId(objectId)));
                    dBCollection.update(searchQuery, new BasicDBObject("$pull", businessObject));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(
                        String.format("Engagement integrated with email '%s' is not exist on database", email));
            } else
                System.out.println("Deleted Engagement successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This engagement not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove all the email(Object ID) in 'acl' array object in 'businesses' collection.
     *
     * @param email the String email which has object ID displayed in 'acl' array object.
     */
    public static void removeInvitedClientInBusinessesCollection(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("businesses");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    System.out.println("Businesses ObjectID: " + dBbject.get("_id"));
                    BasicDBObject aclObject = new BasicDBObject("acl", new BasicDBObject("id", new ObjectId(objectId)));
                    dBCollection.update(searchQuery, new BasicDBObject("$pull", aclObject));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(
                        String.format("Businesses integrated with email '%s' is not exist on database", email));
            } else
                System.out.println("Deleted Businesses successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This Businesses not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove activities of the email(Object ID) in Activities collection.
     *
     * @param email the String email which has object ID displayed in userId object.
     */
    public static void removeAllActivitiesCollectionOfAUser(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("activities");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("userID", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    System.out.println("Activities ObjectID: " + dBbject.get("_id"));
                    dBCollection.remove(dBbject);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(
                        String.format("Activities integrated with email '%s' is not exist on database", email));
            } else
                System.out.println("Deleted Activities successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This Activities not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove Client User from database and all indicated value in 'acl' array object of Client User in Engagement,
     * Activities and Business Collection.
     *
     * @param email
     */
    public static void removeClientAndIndicatedValueByEmail(String email) {
        System.out.println("Deleted Client User and All Indicated Value.");
        removeInvitedClientInEngagementCollection(email);
        removeInvitedClientInBusinessesCollection(email);
        removeAllActivitiesCollectionOfAUser(email);
        try {
            removeUserObjectByEmail(getCollection("users"), email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param firmName
     */
    public static void removeAllFirmByName(String firmName) {
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("firms");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", firmName);
            DBCursor curs = dBCollection.find(searchQuery);
            while (curs.hasNext()) {
                DBObject dBbject = curs.next();
                // shows the whole result document
                System.out.println("Firm name: " + dBbject.get("name"));
                dBCollection.remove(dBbject);
                count++;
            }
            if (count == 0) {
                System.out.println(String.format("Firm name '%s' is not exist on database", firmName));
            } else
                System.out.println("Deleted Firm successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This Firm not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param businessName
     */
    public static void removeAllBusinessByName(String businessName) {
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("businesses");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", businessName);
            DBCursor curs = dBCollection.find(searchQuery);
            while (curs.hasNext()) {
                DBObject dBbject = curs.next();
                // shows the whole result document
                System.out.println("Businesses name: " + dBbject.get("name"));
                dBCollection.remove(dBbject);
                count++;
            }
            if (count == 0) {
                System.out.println(String.format("Businesses name '%s' is not exist on database", businessName));
            } else
                System.out.println("Deleted Businesses successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This Businesses not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove engagement with the name(engagementName) and created by Auditor(email)
     *
     * @param email the String email which has object ID displayed in 'acl' array object.
     */
    public static void removeEngagementCreatedByLeadAuditor(String email, String engagementName) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("engagements");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                BasicDBObject searchQuery1 = new BasicDBObject();
                searchQuery.put("name", engagementName);
                DBCursor curs = dBCollection.find(searchQuery, searchQuery1);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    BasicDBList aclObjectID = (BasicDBList) dBbject.get("acl");
                    BasicDBObject[] aclObjectArr = aclObjectID.toArray(new BasicDBObject[0]);
                    for (BasicDBObject dbObj : aclObjectArr) {
                        // shows each item from the lights array
                        if (dbObj.get("id").toString().equals(objectId) && dbObj.get("lead").equals(true)) {
                            System.out.println("Engagement ObjectID: " + dBbject.get("_id"));
                            System.out.println("Acl ObjectID: " + dBbject.get("acl"));
                            dBCollection.remove(dBbject);
                        }
                    }
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(
                        String.format("Engagement name '%s' is created by email '%s' is not exist on database",
                                engagementName, email));
            } else
                System.out.println("Deleted Engagement successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This engagement not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove all engagement that created by Auditor(email)
     *
     * @param email the String email which has object ID displayed in 'acl' array object.
     */
    public static void removeEngagementCreatedByLeadAuditor(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("engagements");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                //                BasicDBObject searchQuery1 = new BasicDBObject();
                //                searchQuery.put("name",engagementName);
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    BasicDBList aclObjectID = (BasicDBList) dBbject.get("acl");
                    BasicDBObject[] aclObjectArr = aclObjectID.toArray(new BasicDBObject[0]);
                    for (BasicDBObject dbObj : aclObjectArr) {
                        // shows each item from the lights array
                        if (dbObj.get("id").toString().equals(objectId) && dbObj.get("lead").equals(true)) {
                            System.out.println("Engagement ObjectID: " + dBbject.get("_id"));
                            System.out.println("Acl ObjectID: " + dBbject.get("acl"));
                            dBCollection.remove(dBbject);
                        }
                    }
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(String.format("User '%s' does not have any engagement on database", email));
            } else
                System.out.println("Deleted Engagement successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This engagement not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove activities of the engagement which created by email(Object ID) in Activities collection.
     *
     * @param email the String email which has object ID displayed in userId object.
     */
    public static void removeAllActivitiesCollectionOfAEngagement(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("engagements");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    BasicDBList aclObjectID = (BasicDBList) dBbject.get("acl");
                    BasicDBObject[] aclObjectArr = aclObjectID.toArray(new BasicDBObject[0]);
                    for (BasicDBObject dbObj : aclObjectArr) {
                        // shows each item from the lights array

                        System.out.println("Engagement ObjectID: " + dBbject.get("_id"));
                        System.out.println("Acl ObjectID: " + dBbject.get("acl"));
                        DBCollection dBCollectionActivities = getCollection("activities");
                        String objectIdActivites = dBbject.get("_id").toString();
                        System.out.println("objectIdActivites: " + objectIdActivites);
                        if (objectIdActivites != null) {
                            BasicDBObject searchQueryActivities = new BasicDBObject();
                            searchQueryActivities.put("engagementID", new ObjectId(objectIdActivites));
                            DBCursor cursActivites = dBCollectionActivities.find(searchQueryActivities);
                            while (cursActivites.hasNext()) {
                                DBObject dBbjectActivities = cursActivites.next();
                                // shows the whole result document
                                System.out.println("Activities ObjectID: " + dBbjectActivities.get("_id"));
                                dBCollectionActivities.remove(dBbjectActivities);
                                count++;
                            }
                        }
                    }
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(String.format(
                        "Activities integrated with engagement which created by email '%s' is not exist on database.",
                        email));
            } else
                System.out.println("Deleted Activities successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This Activities not exist on database: " + ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int countTotalRowDelete(String collectionName, String emailSeach, String engagementNameSearch,
                                           String roleName) {
        String objectId;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection(collectionName);
            objectId = getObjectIdOfEmailUser(emailSeach);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                if (!GeneralUtilities.isEmptyString(engagementNameSearch)) {
                    searchQuery.put("name", engagementNameSearch);
                }
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    BasicDBList aclObjectID = (BasicDBList) dBbject.get("acl");
                    BasicDBObject[] aclObjectArr = aclObjectID.toArray(new BasicDBObject[0]);
                    for (BasicDBObject dbObj : aclObjectArr) {
                        // shows each item from the lights array
                        if (dbObj.get("id").toString().equals(objectId) && dbObj.get(roleName).equals(true)) {
                            System.out.println("Engagement ObjectID: " + dBbject.get("_id"));
                            System.out.println("Acl ObjectID: " + dBbject.get("acl"));
                            dBCollection.remove(dBbject);
                        }
                    }
                    count++;
                }
            }
        } catch (NoSuchElementException ex1) {
            return -1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return count;
    }

    private static void removeAllDataOutOfCollection(String collectorName, String keySearch, String valueSearch,
                                                     String titleName) {
        int count = 0;
        try {
            DBCollection dBCollection = getCollection(collectorName);
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put(keySearch, valueSearch);
            DBCursor curs = dBCollection.find(searchQuery);
            while (curs.hasNext()) {
                DBObject dBbject = curs.next();
                // shows the whole result document
                System.out.println(titleName + " name: " + dBbject.get("name"));
                dBCollection.remove(dBbject);
                count++;
            }
            if (count == 0) {
                System.out.println(String.format(titleName + " name '%s' is not exist on database", valueSearch));
            } else
                System.out.println("Deleted " + titleName + " successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This " + titleName + " not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removeUserByEmail(String email) {
        try {
            removeUserObjectByEmail(getCollection("users"), email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeUserRoleMappingByEmail(String email) {
        String objectId;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("userRoleMapping");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("userID", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    dBCollection.remove(dBbject);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(String.format(
                        "User Role Mapping record integrated with User email '%s' is not exist on database.",
                        email));
            } else
                System.out.println("Deleted User Role Mapping record successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This User Role Mapping record not exist on database: " + ex.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Remove firm which is created by Admin Firm(email)
     *
     * @param email the String email which has object ID displayed in 'acl' array object.
     */
    public static void removeFirmCreatedByAdminFirm(String email) {
        String objectId = null;
        int count = 0;
        try {
            DBCollection dBCollection = getCollection("firms");
            objectId = getObjectIdOfEmailUser(email);
            if (objectId != null) {
                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("acl.id", new ObjectId(objectId));
                DBCursor curs = dBCollection.find(searchQuery);
                while (curs.hasNext()) {
                    DBObject dBbject = curs.next();
                    // shows the whole result document
                    BasicDBList aclObjectID = (BasicDBList) dBbject.get("acl");
                    BasicDBObject[] aclObjectArr = aclObjectID.toArray(new BasicDBObject[0]);
                    for (BasicDBObject dbObj : aclObjectArr) {
                        // shows each item from the lights array
                        if (dbObj.get("id").toString().equals(objectId) && dbObj.get("admin").equals(true)) {
                            System.out.println("Firm ObjectID: " + dBbject.get("_id"));
                            System.out.println("Acl ObjectID: " + dBbject.get("acl"));
                            dBCollection.remove(dBbject);
                        }
                    }
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(
                        String.format("Firm which is created by '%s' is not exist on database", email));
            } else
                System.out.println("Deleted Engagement successfully.");
        } catch (NoSuchElementException ex) {
            System.out.println("This engagement not exist on database.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getDataColumn(String user, String columnName) {
        return Generic.getTestDataFromExcelNoBrowserPrefix("SetupUserRoles", user, columnName);
    }

    public void initAdminAuditor(String userAdd) {
        try {
            // Create new Admin Auditor user.
            System.out.println("Init Admin Auditor.");
            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseSer, port, DB, username, password, ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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

}
