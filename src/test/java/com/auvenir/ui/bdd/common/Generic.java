package com.auvenir.ui.bdd.common;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
import org.codehaus.groovy.runtime.powerassert.SourceText;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by doai.tran on 8/31/2017.
 */
public class Generic {
    static public String sDirPath = System.getProperty("user.dir");
    static public String sUserPath = System.getProperty("user.home");
    static public String sBrowser = null;

    /*public static void sendReportMail(File pdfReports, ArrayList sTestName, ArrayList sStatus, String timeStamp) {
        System.out.println("REPORT");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        sExecutionDate = simpleDateFormat.format(date);
        Properties properties = new Properties();
        List<String> sTestNameList = PdfGenerater.getTestNameList(sTestName);
        ArrayList<Integer> listTestCasePassed = new ArrayList<>();
        ArrayList<Integer> listTestCaseFailed = new ArrayList<>();
        ArrayList<Integer> listTestCaseSkipped = new ArrayList<>();
        String passedRow = "";
        String failedRow = "";
        String skippedRow = "";
        for (int i = 0; i < browserAutomationTest.length; i++) {
            if (PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i], sBrowserTestNameList)) {
                listTestCasePassed.add(0);
            } else {
                listTestCasePassed.add(PdfGenerater
                        .countTotalTestNameStatusFollowBrowser(sTestName, sBrowserTestNameList, browserAutomationTest[i], sStatus, "Passed"));
            }
        }
        for (int i = 0; i < browserAutomationTest.length; i++) {
            if (PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i], sBrowserTestNameList)) {
                listTestCaseFailed.add(0);
            } else {
                listTestCaseFailed.add(PdfGenerater
                        .countTotalTestNameStatusFollowBrowser(sTestName, sBrowserTestNameList, browserAutomationTest[i], sStatus, "Failed"));
            }
        }
        for (int i = 0; i < browserAutomationTest.length; i++) {
            int totalTestCase = sTestNameList.size();
            int totalPassedCount = 0;
            int totalFailedCount = 0;
            int totalSkippedCase = 0;
            if (!PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i], sBrowserTestNameList)) {
                totalPassedCount = PdfGenerater
                        .countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList, browserAutomationTest[i], sStatus,
                                "Passed");
                totalFailedCount = PdfGenerater
                        .countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList, browserAutomationTest[i], sStatus,
                                "Failed");
                totalSkippedCase = PdfGenerater
                        .countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList, browserAutomationTest[i], sStatus,
                                "Skipped");
            }
            listTestCaseSkipped.add(totalTestCase - (totalSkippedCase + totalPassedCount + totalFailedCount));
        }
        for (int i = 0; i < listTestCasePassed.size(); i++) {
            passedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCasePassed
                    .get(i) + "</td>";
        }
        for (int i = 0; i < listTestCaseFailed.size(); i++) {
            failedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCaseFailed
                    .get(i) + "</td>";
        }
        for (int i = 0; i < listTestCaseSkipped.size(); i++) {
            skippedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCaseSkipped
                    .get(i) + "</td>";
        }

        // create browser summary header
        StringBuilder sbSummaryBrowserHeaderRow = new StringBuilder();
        sbSummaryBrowserHeaderRow
                .append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left;\">Test Summary</th>");
        for (int i = 0; i < browserAutomationTest.length; i++) {
            sbSummaryBrowserHeaderRow
                    .append("<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left;\">" + browserAutomationTest[i] + "</th>");
        }

        // create total test case row
        StringBuilder sbTotalTestCaseRow = new StringBuilder();
        sbTotalTestCaseRow
                .append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Total Test case</td>");
        for (int i = 0; i < browserAutomationTest.length; i++) {
            sbTotalTestCaseRow
                    .append("<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + sTestNameList
                            .size() + "</td>");
        }

        // create browser follow pie chat row
        List<String> browserList = getBrowserList();
        StringBuilder sbBrowserImageRow = new StringBuilder();
        int totalBrowser = browserList.size();
        for (int i = 0; i < totalBrowser; i++) {
            String browserName = browserList.get(i).substring(0, browserList.get(i).length() - 1);
            sbBrowserImageRow.append("<tr><td>" + browserName + "&nbsp;&nbsp;&nbsp;</td>");
            sbBrowserImageRow.append("&nbsp;&nbsp;&nbsp;");
            sbBrowserImageRow
                    .append("<td><img src=\"cid:" + browserName + "_" + timeStamp + "\" style=\"height:200px; width: 200px; outline: thin solid;\"></td>");
            sbBrowserImageRow.append("</tr>");
        }
        String message =
                "<p>Team,</p><div style=\"font-family:Verdana;\">Find the tests automation execution status as below. For detail information, find the attached pdf file.</div><p></p><p></p><p></p><p></p>" + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY : </b></div></p>" + "<table bgcolor=\"#BDE4F6\" style=\"border-radius: 20px; padding: 25px;\">"
                *//*+ "<tr><td>&nbsp;&nbsp;&nbsp;</td>"
                + "&nbsp;&nbsp;&nbsp;"
                + "<td><img src=\"cid:image\" style=\"height:200px; width: 200px; outline: thin solid;\"></td>"
                + "</tr>"*//* + sbBrowserImageRow
                        .toString() + "</table><p></p><p></p><p></p><p></p>" + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY FOR BROWSER: </b></div></p>" + "<table style=\"border: 1px solid black;border-collapse: collapse;\"><col width=\"130\"><col width=\"80\"><col width=\"80\"><col width=\"80\"><col width=\"80\">" + "<tr style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">" + sbSummaryBrowserHeaderRow
                        .toString() + "</tr>" + "<tr>" + sbTotalTestCaseRow
                        .toString() + "</tr>" + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Passed</td>" + passedRow + "</tr>" + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Failed</td>" + failedRow + "</tr>" + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Skiped</td>" + skippedRow + "</tr></table>"
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
                return new PasswordAuthentication(GenericService.getConfigValue(GenericService.sConfigFile, "FROM_EMAILID"),
                        GenericService.getConfigValue(GenericService.sConfigFile, "FROM_PWD"));
            }
        });
        try {
            System.out.println("-------------------");
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(GenericService.getConfigValue(GenericService.sConfigFile, "FROM_EMAILID")));
            msg.setRecipients(Message.RecipientType.TO, GenericService.sToEmail);
            msg.setRecipients(Message.RecipientType.CC, GenericService.sCcEmail);
            String baseUrlRun = System.getProperty("serverDomainName");
            msg.setSubject("Auvenir Execution Report on " + baseUrlRun + " " + sExecutionDate);
            msg.setSentDate(new Date());
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(message, "text/html");

            for (int i = 0; i < totalBrowser; i++) {
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                String browserName = browserList.get(i).substring(0, browserList.get(i).length() - 1);
                DataSource fds = new FileDataSource(System.getProperty(
                        "user.dir") + "\\Reports\\ImageReports\\" + timeStamp + "\\PieChart" + browserName + "_" + timeStamp + ".png");
                messageBodyPart.setDataHandler(new DataHandler(fds));
                messageBodyPart.setHeader("Content-ID", "<" + browserName + "_" + timeStamp + ">");
                multipart.addBodyPart(messageBodyPart);
            }


            multipart.addBodyPart(textPart);
            MimeBodyPart attachementPart = new MimeBodyPart();
            // attachementPart.attachFile(new File(pdfReports));
            attachementPart.attachFile(pdfReports);
            multipart.addBodyPart(attachementPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Mail Sent Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
}
