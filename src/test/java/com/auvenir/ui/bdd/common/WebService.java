package com.auvenir.ui.bdd.common;


import com.auvenir.ui.bdd.common.Generic;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WebService {
    private Logger logger;
    private final String USER_AGENT = "Mozilla/5.0";
    String sKey = null;
    String splitArray[] = null;
    String sResult[] = null;
    String sValue = null;
    String sRegisterUrl = Generic.getConfigValue(Generic.sConfigFile, "REGISTER_URL");
    String sLoginUrl = Generic.getConfigValue(Generic.sConfigFile, "LOGIN_URL");
    String sUserAuthID = null;

    /*	String sDevAuthID = null;
        String sApiKey = null;*/
    public WebService(Logger logger) {
        this.logger = logger;
    }

    public void gettingUserID(String sEmailID, String sKey, String sDevAuthID, String sApiKey) throws Exception {
        URL url = new URL(sRegisterUrl);
        logger.info("*****************************");
        //System.out.println("*****************************");
        logger.info(sEmailID + "*********" + sKey);
        //System.out.println(sEmailID + "*********" + sKey);
        HttpsURLConnection httpsUrlCon = (HttpsURLConnection) url.openConnection();
        httpsUrlCon.setRequestMethod("POST");
        httpsUrlCon.setRequestProperty("User-Agent", USER_AGENT);
        httpsUrlCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    /*	sDevAuthID = Generic.getCongigValue(Generic.sConfigFile, "DEVAUTHID");
		sApiKey = Generic.getCongigValue(Generic.sConfigFile, "APIKEY");*/
        String urlParameters = "email=" + sEmailID + "&devAuthID=" + sDevAuthID + "&apiKey=" + sApiKey;
        httpsUrlCon.setDoOutput(true);
        DataOutputStream dataOpStream = new DataOutputStream(httpsUrlCon.getOutputStream());
        dataOpStream.writeBytes(urlParameters);
        dataOpStream.flush();
        dataOpStream.close();
        int responseCode = httpsUrlCon.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        //System.out.println(in);
        logger.info(in);
        in.close();
        splitArray = response.toString().split("authID");
        sResult = splitArray[1].split("\"");
        sValue = sResult[2];
        logger.info("--------------------------");
        //System.out.println("--------------------------");
        logger.info(sKey);
        //System.out.println(sKey);
        logger.info("Value of  sValue: " + sValue);
        //System.out.println(sValue);

        /*Generic.setConfigValue(Generic.sConfigFile, sKey, sValue);*/
    }

    public void gettingURL(String sEmailID, String sKey, String sDevAuthID, String sApiKey) throws Exception {
        String sUrl = "https://ariel.auvenir.com/api/v1/login-link";
        //String sUrl = Generic.getCongigValue(Generic.sConfigFile,"AUDITOR_URL") + "/api/v1/login-link";
        URL url = new URL(sUrl);
        HttpsURLConnection httpsUrlCon = (HttpsURLConnection) url.openConnection();
        httpsUrlCon.setRequestMethod("POST");
        httpsUrlCon.setRequestProperty("User-Agent", USER_AGENT);
        httpsUrlCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        sUserAuthID = Generic.getConfigValue(Generic.sConfigFile, "USERAUTHID");
        sDevAuthID = Generic.getConfigValue(Generic.sConfigFile, "DEVAUTHID");
        sApiKey = Generic.getConfigValue(Generic.sConfigFile, "APIKEY");
        String urlParameters = "email=" + sEmailID + "&userAuthID=" + sUserAuthID + "&devAuthID=" + sDevAuthID
                + "&apiKey=" + sApiKey;
        httpsUrlCon.setDoOutput(true);
        DataOutputStream dataOpStream = new DataOutputStream(httpsUrlCon.getOutputStream());
        dataOpStream.writeBytes(urlParameters);
        dataOpStream.flush();
        dataOpStream.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        splitArray = response.toString().split("link");
        sResult = splitArray[1].split("\"");
        sValue = sResult[2];
        logger.info("--------------------------");
        //System.out.println("--------------------------");
        logger.info("Skey value is: " + sKey);
        //System.out.println(sKey);
        /*Generic.setConfigValue(Generic.sConfigFile, sKey, sValue);*/
    }
}
