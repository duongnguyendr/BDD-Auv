package com.auvenir.ui.bdd.common.mongoBD;

/**
 * Created by tan.pham on 9/12/2017.
 */
public class MongoDBProperties {

    private String serverIp;
    private String databaseName;
    private String userName;
    private String userPassword;
    private int port;
    private String ssl;

    public MongoDBProperties(){

    }

    public MongoDBProperties(String runServer){
        getMongoDBProperties(runServer);
    }


    private void getMongoDBProperties(String runServer){
        this.setServerIp("192.168.1.222");
        this.setDatabaseName("auvenir");
        this.setUserName("");
        this.setUserPassword("");
        this.setPort(27017);
        this.setSsl("No");

        if(runServer.equalsIgnoreCase("greed.auvenir.com")){
            this.setServerIp("golem.auvenir.com");
            this.setDatabaseName("auvenir");
            this.setUserName("auvqadb");
            this.setUserPassword("rE7IrgSfjnSjP9Pr08MQNhcXpezZp3d7SzfWreRVhW1zpU6f4gHnca0CNOLH9wvKewslvb5mfXDd3vsds76UhQ==");
            this.setPort(27017);
            this.setSsl("");
        }else{

        }
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }
}
