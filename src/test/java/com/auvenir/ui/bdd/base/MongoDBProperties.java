package com.auvenir.ui.bdd.base;

import com.auvenir.ui.bdd.common.Generic;

/**
 * Created by tan.pham on 9/12/2017.
 */
public class MongoDBProperties {

    private String serverIp;
    private String databaseName;
    private String userName;
    private String userPassword;
    private String port;
    private String ssl;

    public MongoDBProperties(){

    }

    public MongoDBProperties(String runServer){
        this.getMongoDBProperties(runServer);
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    private MongoDBProperties getMongoDBProperties(String runServer){
        MongoDBProperties item = new MongoDBProperties();
        item.setServerIp("192.168.1.222");
        item.setDatabaseName("auvenir");
        item.setUserName("");
        item.setUserPassword("");
        item.setPort("27017");
        item.setSsl("No");

        if(!Generic.isEmptyString(runServer)){

        }

        return item;
    }
}
