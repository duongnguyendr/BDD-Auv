package com.auvenir.ui.bdd.common;

import net.masterthought.cucumber.ReportResult;
import net.masterthought.cucumber.json.Feature;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by tan.pham on 9/8/2017.
 */
public class SendReportMail {

    private static String sExecutionDate;
    private static String sToEmail = "tan.pham@titancorpvn.com";
    private static String sCcEmail = "";


    public static void sendMail(File pdfReports, String timeStamp, ReportResult reportResult) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        sExecutionDate = simpleDateFormat.format(date);
        Properties properties = new Properties();

        //Create detail table
        StringBuilder sbDetailTable = new StringBuilder();
        sbDetailTable.append("<table style=\"border: 1px solid black1;border-collapse: collapse; width : 100%\">");
        sbDetailTable.append("<tr style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\"></th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\" colspan=\"6\">Steps</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\" colspan=\"3\">Scenario</th>");
        sbDetailTable.append("</tr>");
        sbDetailTable.append("<tr style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Features</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Passed</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Failed</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Skipped</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Pending</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Undefined</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Total</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Passed</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Failed</th>");
        sbDetailTable.append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: center;\">Total</th>");
        sbDetailTable.append("</tr>");

        //Create detail row
        int totalFeatures = reportResult.getAllFeatures().size();
        for(int i=0; i<totalFeatures ;i++) {
            Feature featureItem = reportResult.getAllFeatures().get(i);
            sbDetailTable.append("<tr>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;  width: 200px;\">" + featureItem.getName() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getPassedSteps() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getFailedFeatures() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getSkippedSteps() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getPendingSteps() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getUndefinedSteps() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getSteps() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getPassedScenarios() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getFailedScenarios() + "</td>");
            sbDetailTable.append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + featureItem.getScenarios() + "</td>");
            sbDetailTable.append("</tr>");
        }

        sbDetailTable.append("</table>");

        String featureChartImage = System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp + "\\FeaturesChart" + "_" + timeStamp + ".png";
        String scenarioChartImage = System.getProperty("user.dir") + "\\Reports\\ImageReports\\" + timeStamp + "\\ScenariosChart" + "_" + timeStamp + ".png";
        // create browser follow pie chat row
        StringBuilder sbBrowserImageRow = new StringBuilder();
        sbBrowserImageRow.append("<tr><td>" + "Feature" + "&nbsp;&nbsp;&nbsp;</td>");
        sbBrowserImageRow.append("&nbsp;&nbsp;&nbsp;");
        sbBrowserImageRow
                .append("<td><img src=\""+ featureChartImage +"\" style=\"height:200px; width: 200px; outline: thin solid;\"></td>");
        sbBrowserImageRow
                .append("<td><img src=\""+ scenarioChartImage +"\" style=\"height:200px; width: 200px; outline: thin solid;\"></td>");
        sbBrowserImageRow.append("</tr>");

        String message =
                "<p>Team,</p><div style=\"font-family:Verdana;\">Find the tests automation execution status as below. For detail information, find the attached pdf file.</div><p></p><p></p><p></p><p></p>" + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY : </b></div></p>" + "<table bgcolor=\"#BDE4F6\" style=\"border-radius: 20px; padding: 25px;\">"
                /*+ "<tr><td>&nbsp;&nbsp;&nbsp;</td>"
                + "&nbsp;&nbsp;&nbsp;"
                + "<td><img src=\"cid:image\" style=\"height:200px; width: 200px; outline: thin solid;\"></td>"
                + "</tr>"*/ + sbBrowserImageRow
                        .toString() + "</table><p></p><p></p><p></p><p></p>" + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY FOR BROWSER: CHROME</b></div></p>"
                        + sbDetailTable.toString()
                        + "<p></p><div style=\"font-family:Verdana;\">We can review detailed HTML report: </div><p></p>"
                        +"<a href=\"http://jenkins-auvenir-automation.titancorpvn.com:8080/job/automation/ws/Reports/HTMLReports/index.html\">Automation HTML Report<br/></a>"
                        + "<p></p><div style=\"font-family:Verdana;\">Regards,</div><p></p>" + "<div style=\"font-family:Verdana;\">Automation " +
                        "Team</div>";
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.debug", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("chr.auditor01.auvenir@gmail.com","Changeit@123");
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("chr.auditor01.auvenir@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, sToEmail);
            msg.setRecipients(Message.RecipientType.CC, sCcEmail);
            String prefixProtocol = "";
            if (prefixProtocol == "") {
                prefixProtocol = "https://";
            }

            String baseUrlRun = prefixProtocol + "auvenir-qa-automation.com";

            msg.setSubject("Auvenir Execution Report on " + baseUrlRun + " " + sExecutionDate);
            msg.setSentDate(new Date());
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(message, "text/html");

            multipart.addBodyPart(textPart);
            MimeBodyPart attachementPart = new MimeBodyPart();

            attachementPart.attachFile(pdfReports);
            multipart.addBodyPart(attachementPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Mail Sent Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
