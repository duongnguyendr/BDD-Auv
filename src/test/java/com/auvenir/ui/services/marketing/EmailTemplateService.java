package com.auvenir.ui.services.marketing;

import com.auvenir.ui.pages.marketing.MailAuditorJoinPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by duong.nguyen on 6/7/2017.
 */
public class EmailTemplateService extends AbstractService {

    MailAuditorJoinPage mailAuditorJoinPage;

    public EmailTemplateService(Logger logger, WebDriver driver) {
        super(logger, driver);
        mailAuditorJoinPage = new MailAuditorJoinPage(getLogger(), getDriver());
    }

    public void verifyWaitListPageContent() {
        mailAuditorJoinPage.verifyPageContent();
    }

    /*
    Vien.Pham added
     */
    public void verifyActiveEmailTemplateContent() {
        mailAuditorJoinPage.verifyActiveEmailContent();
    }
    public void verifyEmailToCustomerSuccessTeam(String autitorAccount, String fullName, String firmName){
        mailAuditorJoinPage.verifyEmailToCustomerSuccessTeam(autitorAccount,fullName,firmName);
    }

    public void verifyAuditorInviteClientEmail() {
        mailAuditorJoinPage.verifyAuditorInviteClientEmail();
    }

    public void clickGetStartedButton() {
        mailAuditorJoinPage.clickGetStartedButton();
    }

    public void navigateToConfirmationLink() throws Exception {
        mailAuditorJoinPage.navigateToConfirmationLink();
    }

    public void verifySubjectEmailAuditorInviteClient(String auditorFullName, String subjectContent) {
        mailAuditorJoinPage.verifySubjectEmailAuditorInviteClient(auditorFullName, subjectContent);
    }

    public void verifyGreetingContentEmailAuditorInviteClient(String clientFullName, String greetingContent) {
        mailAuditorJoinPage.verifyGreetingContentEmailAuditorInviteClient(clientFullName, greetingContent);
    }

    public void verifyAnnouncementEmailAuditorInviteClient(String auditorFullName, String announcementContent) {
        mailAuditorJoinPage.verifyAnnouncementEmailAuditorInviteClient(auditorFullName, announcementContent);
    }

    public void verifyAuvenirIntroducingContent(String introducingTitle) {
        mailAuditorJoinPage.verifyAuvenirIntroducingContent(introducingTitle);
    }

    public void verifyBenefitContentEmailAuditorInviteClient(String introducingBenefit, String firstBenefitContent, String secondBenefitContent, String thirdBenefitContent) {
        mailAuditorJoinPage.verifyBenefitContentEmailAuditorInviteClient(introducingBenefit, firstBenefitContent, secondBenefitContent, thirdBenefitContent);
    }

    public void verifyFeedbackContent(String feedbackContent) {
        mailAuditorJoinPage.verifyFeedbackContent(feedbackContent);
    }

    public void verifyGoodbyeContent(String goodbyeContent) {
        mailAuditorJoinPage.verifyGoodbyeContent(goodbyeContent);
    }
}
