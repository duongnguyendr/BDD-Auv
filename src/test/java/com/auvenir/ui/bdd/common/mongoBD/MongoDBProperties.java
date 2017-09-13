package com.auvenir.ui.bdd.common.mongoBD;

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


    private MongoDBProperties getMongoDBProperties(String runServer){
        MongoDBProperties item = new MongoDBProperties();
        item.setServerIp("192.168.1.222");
        item.setDatabaseName("auvenir");
        item.setUserName("");
        item.setUserPassword("");
        item.setPort("27017");
        item.setSsl("No");

        if(runServer.equalsIgnoreCase("greed.auvenir.com")){
            item.setServerIp("golem.auvenir.com");
            item.setDatabaseName("auvenir");
            item.setUserName("auvqadb");
            item.setUserPassword("rE7IrgSfjnSjP9Pr08MQNhcXpezZp3d7SzfWreRVhW1zpU6f4gHnca0CNOLH9wvKewslvb5mfXDd3vsds76UhQ==");
            item.setPort("27017");
            item.setSsl("");
        }else{

        }

        return item;
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
}
